package com.tencent.mm.plugin.finder.live.plugin;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Paint;
import android.graphics.Point;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout.LayoutParams;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.k;
import android.support.v7.widget.RecyclerView.l;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.live.c.b.b;
import com.tencent.mm.live.c.b.c;
import com.tencent.mm.live.core.core.d.b.a;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.expt.hellhound.a.b.b.c.a;
import com.tencent.mm.plugin.finder.live.model.o;
import com.tencent.mm.plugin.finder.live.view.adapter.h.b;
import com.tencent.mm.plugin.finder.live.widget.FinderLiveShoppingPanel;
import com.tencent.mm.plugin.finder.report.live.k;
import com.tencent.mm.plugin.finder.report.live.s.aa;
import com.tencent.mm.plugin.finder.report.live.s.c;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.protocal.protobuf.awc;
import com.tencent.mm.protocal.protobuf.awe;
import com.tencent.mm.protocal.protobuf.axg;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.au;
import java.util.HashMap;
import java.util.LinkedList;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;
import kotlin.x;
import org.json.JSONObject;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveShoppingListPlugin;", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;", "Landroid/view/View$OnClickListener;", "root", "Landroid/view/ViewGroup;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "TITLE_GROUP_HEIGHT", "", "getTITLE_GROUP_HEIGHT", "()I", "setTITLE_GROUP_HEIGHT", "(I)V", "blankArea", "Landroid/view/View;", "close", "Landroid/widget/ImageView;", "contentGroup", "Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveShoppingPanel;", "emptyAction", "Landroid/widget/TextView;", "emptyGroup", "footer", "footerTv", "hasNotifyVisitorShopping", "", "loadingBar", "Landroid/widget/ProgressBar;", "loadingMore", "maskHideAnim", "Landroid/animation/ObjectAnimator;", "maskShowAnim", "maskView", "notifyVisitorShoppingTimes", "order", "productsTitle", "retryTip", "shoppingList", "Landroid/support/v7/widget/RecyclerView;", "shoppingListAdapter", "Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveShoppingListAdapter;", "titleGroup", "touchLoc", "", "addProduct", "", "checkLoadMore", "lastVisiblePosition", "gotoShoppingOrder", "hideMaskView", "hideShoppingContent", "initLandscapeLogic", "initPortraitLogic", "initTitleGroupHeight", "initView", "notifyVisitorShopping", "onBackPress", "onClick", "v", "onGetShoppingListFail", "onGetShoppingListSuccess", "info", "Landroid/os/Bundle;", "onLoadMoreFinish", "success", "onNewIntent", "intent", "Landroid/content/Intent;", "onPortraitDelayAction", "extraMsg", "delayMs", "", "openFullScreenMiniprogram", "bundle", "Lcom/tencent/mm/plugin/appbrand/api/WeAppOpenBundle;", "openFullScreenMiniprogramImpl", "openHalfScreenMiniprogram", "openHalfScreenMiniprogramImpl", "reportWhenAddProduct", "setFooterTvVisibility", "visibility", "showEmptyContent", "data", "Lcom/tencent/mm/protocal/protobuf/FinderLiveGetShopWindowProductResponse;", "showMaskView", "showProductList", "showShoppingContent", "refresh", "showShoppingLoading", "statusChange", "status", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "param", "Companion", "plugin-finder_release"})
public final class bf
  extends d
  implements View.OnClickListener
{
  private static final String TAG = "Finder.LiveShoppingListPlugin";
  private static final String utU = "PORTRAIT_ACTION_FULL_SCREEN_MINIPRO";
  private static final String utV = "PORTRAIT_ACTION_HALF_SCREEN_MINIPRO";
  public static final g utW;
  private final com.tencent.mm.live.c.b hOp;
  private TextView hRL;
  private ProgressBar hRO;
  private View hRR;
  private View hRx;
  private View maskView;
  private View qdl;
  private TextView unG;
  private boolean unJ;
  private View ush;
  private int utH;
  private FinderLiveShoppingPanel utI;
  private ImageView utJ;
  private TextView utK;
  private RecyclerView utL;
  private TextView utM;
  private TextView utN;
  private com.tencent.mm.plugin.finder.live.view.adapter.h utO;
  private ObjectAnimator utP;
  private ObjectAnimator utQ;
  private int utR;
  private boolean utS;
  private int[] utT;
  
  static
  {
    AppMethodBeat.i(247032);
    utW = new g((byte)0);
    TAG = "Finder.LiveShoppingListPlugin";
    utU = "PORTRAIT_ACTION_FULL_SCREEN_MINIPRO";
    utV = "PORTRAIT_ACTION_HALF_SCREEN_MINIPRO";
    AppMethodBeat.o(247032);
  }
  
  public bf(ViewGroup paramViewGroup, com.tencent.mm.live.c.b paramb)
  {
    super(paramViewGroup, paramb);
    AppMethodBeat.i(247031);
    this.hOp = paramb;
    paramViewGroup = paramViewGroup.getContext();
    p.g(paramViewGroup, "root.context");
    this.utO = new com.tencent.mm.plugin.finder.live.view.adapter.h(paramViewGroup, this.hOp, getLiveData());
    this.utT = new int[2];
    paramViewGroup = this.utO;
    paramViewGroup.uBB = ((kotlin.g.a.b)new a(this));
    paramViewGroup.uBC = ((kotlin.g.a.b)new b(this));
    paramViewGroup.uBD = ((kotlin.g.a.b)new c(this));
    paramViewGroup.uBE = ((kotlin.g.a.b)new d(this));
    paramViewGroup.uBF = ((kotlin.g.a.q)new e(paramViewGroup, this));
    paramViewGroup.uBG = ((kotlin.g.a.b)new f(this));
    paramViewGroup = this.hwr.findViewById(2131301270);
    p.g(paramViewGroup, "root.findViewById(R.id.finder_live_shopping_mask)");
    this.maskView = paramViewGroup;
    paramViewGroup = this.hwr.findViewById(2131301488);
    p.g(paramViewGroup, "root.findViewById(R.id.f…shopping_list_blank_area)");
    this.hRx = paramViewGroup;
    paramViewGroup = this.hwr.findViewById(2131301489);
    p.g(paramViewGroup, "root.findViewById(R.id.f…opping_list_content_area)");
    this.utI = ((FinderLiveShoppingPanel)paramViewGroup);
    paramViewGroup = this.hwr.findViewById(2131301269);
    p.g(paramViewGroup, "root.findViewById(R.id.f…hopping_list_title_group)");
    this.hRR = paramViewGroup;
    paramViewGroup = this.hRR;
    if (paramViewGroup == null) {
      p.btv("titleGroup");
    }
    paramViewGroup = paramViewGroup.getLayoutParams();
    if (paramViewGroup != null) {}
    for (final int i = paramViewGroup.height;; i = 0)
    {
      this.utH = i;
      if (this.utH <= 0)
      {
        paramViewGroup = MMApplicationContext.getContext();
        p.g(paramViewGroup, "MMApplicationContext.getContext()");
        this.utH = paramViewGroup.getResources().getDimensionPixelOffset(2131165312);
      }
      Log.i(TAG, "initTitleGroupHeight:" + this.utH);
      paramViewGroup = this.hwr.findViewById(2131301259);
      p.g(paramViewGroup, "root.findViewById(R.id.f…live_shopping_list_close)");
      this.utJ = ((ImageView)paramViewGroup);
      paramViewGroup = this.hwr.findViewById(2131301265);
      p.g(paramViewGroup, "root.findViewById(R.id.f…live_shopping_list_order)");
      this.utK = ((TextView)paramViewGroup);
      paramViewGroup = this.hwr.findViewById(2131301260);
      p.g(paramViewGroup, "root.findViewById(R.id.f…ve_shopping_list_content)");
      this.utL = ((RecyclerView)paramViewGroup);
      paramViewGroup = this.hwr.findViewById(2131301264);
      p.g(paramViewGroup, "root.findViewById(R.id.f…ve_shopping_list_loading)");
      this.hRO = ((ProgressBar)paramViewGroup);
      paramViewGroup = this.hwr.findViewById(2131301266);
      p.g(paramViewGroup, "root.findViewById(R.id.f…_shopping_list_retry_tip)");
      this.hRL = ((TextView)paramViewGroup);
      paramViewGroup = this.hwr.findViewById(2131301262);
      p.g(paramViewGroup, "root.findViewById(R.id.f…hopping_list_empty_group)");
      this.ush = paramViewGroup;
      paramViewGroup = this.hwr.findViewById(2131301261);
      p.g(paramViewGroup, "root.findViewById(R.id.f…opping_list_empty_action)");
      this.utM = ((TextView)paramViewGroup);
      paramViewGroup = this.hwr.findViewById(2131301258);
      p.g(paramViewGroup, "root.findViewById(R.id.f…der_live_shopping_footer)");
      this.qdl = paramViewGroup;
      paramViewGroup = this.qdl;
      if (paramViewGroup == null) {
        p.btv("footer");
      }
      paramViewGroup = paramViewGroup.findViewById(2131303685);
      p.g(paramViewGroup, "footer.findViewById(R.id.load_more_footer_tip_tv)");
      this.unG = ((TextView)paramViewGroup);
      paramViewGroup = this.hwr.findViewById(2131301268);
      p.g(paramViewGroup, "root.findViewById(R.id.f…live_shopping_list_title)");
      this.utN = ((TextView)paramViewGroup);
      if (!isLandscape()) {
        break label1023;
      }
      paramViewGroup = this.utL;
      if (paramViewGroup == null) {
        p.btv("shoppingList");
      }
      this.hwr.getContext();
      paramViewGroup.setLayoutManager((RecyclerView.LayoutManager)new LinearLayoutManager(1, false));
      paramViewGroup.setAdapter((RecyclerView.a)this.utO);
      paramViewGroup.a((RecyclerView.l)new m(this));
      paramViewGroup.a((RecyclerView.k)new n(this));
      paramViewGroup.getLayoutParams().height = (au.az(this.hwr.getContext()).y - this.utH);
      Log.i(TAG, "shoppingList height:" + paramViewGroup.getLayoutParams().height);
      paramViewGroup = this.utI;
      if (paramViewGroup == null) {
        p.btv("contentGroup");
      }
      paramViewGroup.setTranslationX(au.az(this.hwr.getContext()).y);
      paramViewGroup.setOnVisibilityListener((kotlin.g.a.b)new o(this));
      paramViewGroup = this.utI;
      if (paramViewGroup == null) {
        p.btv("contentGroup");
      }
      paramViewGroup = paramViewGroup.getLayoutParams();
      if (paramViewGroup != null) {
        break;
      }
      paramViewGroup = new t("null cannot be cast to non-null type android.support.constraint.ConstraintLayout.LayoutParams");
      AppMethodBeat.o(247031);
      throw paramViewGroup;
    }
    ((ConstraintLayout.LayoutParams)paramViewGroup).width = au.az(this.hwr.getContext()).y;
    paramViewGroup = this.utN;
    if (paramViewGroup == null) {
      p.btv("productsTitle");
    }
    ao.a((Paint)paramViewGroup.getPaint(), 0.8F);
    paramViewGroup = this.hRx;
    if (paramViewGroup == null) {
      p.btv("blankArea");
    }
    paramViewGroup.setOnClickListener((View.OnClickListener)this);
    paramViewGroup = this.utJ;
    if (paramViewGroup == null) {
      p.btv("close");
    }
    paramViewGroup.setOnClickListener((View.OnClickListener)this);
    paramViewGroup = this.utK;
    if (paramViewGroup == null) {
      p.btv("order");
    }
    paramViewGroup.setOnClickListener((View.OnClickListener)this);
    paramViewGroup = this.hRL;
    if (paramViewGroup == null) {
      p.btv("retryTip");
    }
    paramViewGroup.setOnClickListener((View.OnClickListener)this);
    paramViewGroup = this.utM;
    if (paramViewGroup == null) {
      p.btv("emptyAction");
    }
    paramViewGroup.setOnClickListener((View.OnClickListener)this);
    AppMethodBeat.o(247031);
    return;
    label1023:
    float f = au.az(MMApplicationContext.getContext()).y;
    paramViewGroup = com.tencent.mm.plugin.finder.storage.c.vCb;
    i = (int)(f * (com.tencent.mm.plugin.finder.storage.c.duX() / 100.0F));
    paramViewGroup = this.utL;
    if (paramViewGroup == null) {
      p.btv("shoppingList");
    }
    this.hwr.getContext();
    paramViewGroup.setLayoutManager((RecyclerView.LayoutManager)new LinearLayoutManager(1, false));
    paramViewGroup.setAdapter((RecyclerView.a)this.utO);
    paramViewGroup.a((RecyclerView.l)new p(this, i));
    paramViewGroup.a((RecyclerView.k)new q(this, i));
    paramViewGroup.getLayoutParams().height = (i - this.utH);
    Log.i(TAG, "shoppingList height:" + paramViewGroup.getLayoutParams().height);
    paramViewGroup = this.utI;
    if (paramViewGroup == null) {
      p.btv("contentGroup");
    }
    paramViewGroup.setTranslationY(au.az(this.hwr.getContext()).y);
    paramViewGroup.setOnVisibilityListener((kotlin.g.a.b)new r(this, i));
    paramViewGroup.getLayoutParams().height = i;
    Log.i(paramViewGroup.getTAG(), "contentGroup height:" + paramViewGroup.getLayoutParams().height);
    paramViewGroup = this.utN;
    if (paramViewGroup == null) {
      p.btv("productsTitle");
    }
    ao.a((Paint)paramViewGroup.getPaint(), 0.8F);
    paramViewGroup = this.hRx;
    if (paramViewGroup == null) {
      p.btv("blankArea");
    }
    paramViewGroup.setOnClickListener((View.OnClickListener)this);
    paramViewGroup = this.utJ;
    if (paramViewGroup == null) {
      p.btv("close");
    }
    paramViewGroup.setOnClickListener((View.OnClickListener)this);
    paramViewGroup = this.utK;
    if (paramViewGroup == null) {
      p.btv("order");
    }
    paramViewGroup.setOnClickListener((View.OnClickListener)this);
    paramViewGroup = this.hRL;
    if (paramViewGroup == null) {
      p.btv("retryTip");
    }
    paramViewGroup.setOnClickListener((View.OnClickListener)this);
    paramViewGroup = this.utM;
    if (paramViewGroup == null) {
      p.btv("emptyAction");
    }
    paramViewGroup.setOnClickListener((View.OnClickListener)this);
    AppMethodBeat.o(247031);
  }
  
  private final void Jk(final int paramInt)
  {
    AppMethodBeat.i(247016);
    com.tencent.mm.ac.d.h((kotlin.g.a.a)new y(this, paramInt));
    AppMethodBeat.o(247016);
  }
  
  private void c(final Bundle paramBundle, boolean paramBoolean)
  {
    AppMethodBeat.i(247022);
    Log.i(TAG, "showShoppingContent is refresh:".concat(String.valueOf(paramBoolean)));
    com.tencent.mm.plugin.finder.live.h.ufY.a(getLiveData());
    rg(0);
    dhO();
    getLiveData().djd();
    Object localObject = o.ujN;
    localObject = o.getFinderLiveAssistant();
    if (localObject != null)
    {
      com.tencent.mm.plugin.finder.live.model.s.a.a((com.tencent.mm.plugin.finder.live.model.s)localObject, getLiveData().liveInfo.liveId, getLiveData().hFK, (kotlin.g.a.b)new aa(this, paramBundle));
      AppMethodBeat.o(247022);
      return;
    }
    AppMethodBeat.o(247022);
  }
  
  private final void dhM()
  {
    AppMethodBeat.i(247017);
    if (this.utP == null)
    {
      localObject = this.maskView;
      if (localObject == null) {
        p.btv("maskView");
      }
      this.utP = ObjectAnimator.ofFloat(localObject, "alpha", new float[] { 0.0F, 1.0F });
    }
    Object localObject = this.utP;
    if (localObject != null) {
      ((ObjectAnimator)localObject).cancel();
    }
    localObject = this.utP;
    if (localObject != null)
    {
      ((ObjectAnimator)localObject).start();
      AppMethodBeat.o(247017);
      return;
    }
    AppMethodBeat.o(247017);
  }
  
  private final void dhN()
  {
    AppMethodBeat.i(247021);
    Log.i(TAG, "hideShoppingContent:" + Util.getStack());
    FinderLiveShoppingPanel localFinderLiveShoppingPanel = this.utI;
    if (localFinderLiveShoppingPanel == null) {
      p.btv("contentGroup");
    }
    localFinderLiveShoppingPanel.post((Runnable)new l(this));
    AppMethodBeat.o(247021);
  }
  
  private final void dhO()
  {
    AppMethodBeat.i(247024);
    Object localObject = this.hRO;
    if (localObject == null) {
      p.btv("loadingBar");
    }
    ((ProgressBar)localObject).setVisibility(0);
    localObject = this.hRL;
    if (localObject == null) {
      p.btv("retryTip");
    }
    ((TextView)localObject).setVisibility(8);
    localObject = this.ush;
    if (localObject == null) {
      p.btv("emptyGroup");
    }
    ((View)localObject).setVisibility(8);
    localObject = this.hRR;
    if (localObject == null) {
      p.btv("titleGroup");
    }
    ((View)localObject).setVisibility(8);
    localObject = this.utL;
    if (localObject == null) {
      p.btv("shoppingList");
    }
    ((RecyclerView)localObject).setVisibility(8);
    Jk(8);
    localObject = this.utI;
    if (localObject == null) {
      p.btv("contentGroup");
    }
    ((FinderLiveShoppingPanel)localObject).post((Runnable)new ab(this));
    dhM();
    AppMethodBeat.o(247024);
  }
  
  private final void dhQ()
  {
    Object localObject2 = null;
    AppMethodBeat.i(247026);
    Object localObject3 = TAG;
    Object localObject4 = new StringBuilder("add product appId:");
    Object localObject1 = getLiveData().uEl;
    if (localObject1 != null)
    {
      localObject1 = ((awc)localObject1).LGD;
      localObject4 = ((StringBuilder)localObject4).append((String)localObject1).append(",path:");
      localObject1 = getLiveData().uEl;
      if (localObject1 == null) {
        break label265;
      }
    }
    label265:
    for (localObject1 = ((awc)localObject1).LGB;; localObject1 = null)
    {
      Log.i((String)localObject3, (String)localObject1);
      localObject1 = com.tencent.mm.plugin.finder.live.g.ufT;
      com.tencent.mm.plugin.finder.live.g.b(getLiveData(), (kotlin.g.a.m)new h(this));
      if (this.hOp.getLiveRole() != 1) {
        break label458;
      }
      localObject4 = new JSONObject();
      ((JSONObject)localObject4).put("type", s.aa.vpK.action);
      localObject1 = k.vkd;
      ((JSONObject)localObject4).put("sessionid", k.dpl().vlJ);
      localObject1 = o.ujN;
      localObject1 = o.dfZ();
      if (localObject1 != null)
      {
        localObject1 = ((com.tencent.mm.plugin.finder.live.viewmodel.g)localObject1).uEl;
        if (localObject1 != null)
        {
          localObject3 = ((awc)localObject1).vtD;
          localObject1 = localObject3;
          if (localObject3 != null) {
            break label205;
          }
        }
      }
      localObject1 = "";
      label205:
      ((JSONObject)localObject4).put("shopwindowid", localObject1);
      localObject1 = o.ujN;
      localObject1 = o.dfZ();
      if ((localObject1 == null) || (((com.tencent.mm.plugin.finder.live.viewmodel.g)localObject1).djk() != true)) {
        break label270;
      }
      localObject1 = k.vkd;
      k.q(com.tencent.mm.plugin.finder.report.live.s.a.vmz.hlf, ((JSONObject)localObject4).toString());
      AppMethodBeat.o(247026);
      return;
      localObject1 = null;
      break;
    }
    label270:
    localObject1 = o.ujN;
    localObject1 = o.dfZ();
    long l;
    if (localObject1 != null) {
      if (((com.tencent.mm.plugin.finder.live.viewmodel.g)localObject1).isLiveStarted() == true)
      {
        localObject1 = k.vkd;
        k.dpl().vmo = true;
        localObject1 = o.ujN;
        localObject3 = o.dfZ();
        localObject1 = localObject2;
        if (localObject3 != null) {
          localObject1 = ((com.tencent.mm.plugin.finder.live.viewmodel.g)localObject3).uEq;
        }
        ((JSONObject)localObject4).put("appid", localObject1);
        localObject1 = o.ujN;
        localObject1 = o.dfZ();
        if (localObject1 == null) {
          break label472;
        }
        localObject1 = ((com.tencent.mm.plugin.finder.live.viewmodel.g)localObject1).liveInfo;
        if (localObject1 == null) {
          break label472;
        }
        l = ((awe)localObject1).liveId;
        if (l >= 0L) {
          break label479;
        }
        ((JSONObject)localObject4).put("liveid", "");
        label378:
        localObject1 = com.tencent.mm.plugin.expt.hellhound.a.b.b.c.sFa;
        ((JSONObject)localObject4).put("clickid", com.tencent.mm.plugin.expt.hellhound.a.b.b.c.cOM());
        localObject1 = com.tencent.mm.plugin.expt.hellhound.a.b.b.c.sFa;
        c.a.apD("");
        localObject1 = o.ujN;
        localObject1 = o.dfZ();
        if (localObject1 == null) {
          break label495;
        }
        localObject1 = ((com.tencent.mm.plugin.finder.live.viewmodel.g)localObject1).uEm;
        if (localObject1 == null) {
          break label495;
        }
      }
    }
    label458:
    label472:
    label479:
    label495:
    for (localObject1 = Long.valueOf(((axg)localObject1).uko);; localObject1 = "")
    {
      ((JSONObject)localObject4).put("productid", localObject1);
      localObject1 = k.vkd;
      k.a(s.c.vmV, ((JSONObject)localObject4).toString());
      AppMethodBeat.o(247026);
      return;
      AppMethodBeat.o(247026);
      return;
      l = -1L;
      break;
      ((JSONObject)localObject4).put("liveid", com.tencent.mm.plugin.expt.hellhound.core.b.zs(l));
      break label378;
    }
  }
  
  private final void e(com.tencent.mm.plugin.appbrand.api.g paramg)
  {
    AppMethodBeat.i(247028);
    Object localObject = o.ujN;
    com.tencent.mm.plugin.finder.live.model.s locals = o.getFinderLiveAssistant();
    if (locals != null)
    {
      localObject = this.hwr;
      if (localObject != null) {}
      for (localObject = ((ViewGroup)localObject).getContext();; localObject = null)
      {
        p.g(localObject, "root?.context");
        com.tencent.mm.plugin.finder.live.model.s.a.a(locals, (Context)localObject, paramg);
        AppMethodBeat.o(247028);
        return;
      }
    }
    AppMethodBeat.o(247028);
  }
  
  private final void f(com.tencent.mm.plugin.appbrand.api.g paramg)
  {
    AppMethodBeat.i(247029);
    Object localObject = o.ujN;
    com.tencent.mm.plugin.finder.live.model.s locals = o.getFinderLiveAssistant();
    if (locals != null)
    {
      localObject = this.hwr;
      if (localObject != null) {}
      for (localObject = ((ViewGroup)localObject).getContext();; localObject = null)
      {
        p.g(localObject, "root?.context");
        locals.c((Context)localObject, paramg);
        AppMethodBeat.o(247029);
        return;
      }
    }
    AppMethodBeat.o(247029);
  }
  
  public final void a(final Bundle paramBundle, final long paramLong)
  {
    AppMethodBeat.i(247030);
    String str1;
    if (paramBundle != null)
    {
      String str2 = paramBundle.getString("POST_PORTRAIT_ACTION", "");
      str1 = str2;
      if (str2 != null) {}
    }
    else
    {
      str1 = "";
    }
    if (p.j(str1, utU))
    {
      com.tencent.mm.ac.d.a(paramLong, (Runnable)new w(this, paramBundle, paramLong));
      AppMethodBeat.o(247030);
      return;
    }
    if (p.j(str1, utV)) {
      com.tencent.mm.ac.d.a(paramLong, (Runnable)new x(this, paramBundle, paramLong));
    }
    AppMethodBeat.o(247030);
  }
  
  public final void dhP()
  {
    AppMethodBeat.i(247025);
    Object localObject = com.tencent.mm.plugin.finder.utils.m.vVH;
    if ((!com.tencent.mm.plugin.finder.utils.m.dBP()) || (this.utS))
    {
      AppMethodBeat.o(247025);
      return;
    }
    if (getLiveData().liveInfo.liveId == 0L)
    {
      AppMethodBeat.o(247025);
      return;
    }
    Log.i(TAG, "has notify visitor shopping:" + this.utS);
    this.utR += 1;
    if (this.utR >= 3)
    {
      this.utR = 0;
      AppMethodBeat.o(247025);
      return;
    }
    int i = getLiveData().uDA;
    long l1 = getLiveData().liveInfo.liveId;
    long l2 = getLiveData().hFK;
    localObject = z.aUg();
    p.g(localObject, "ConfigStorageLogic.getMyFinderUsername()");
    new com.tencent.mm.plugin.finder.cgi.s(l1, l2, i | 0x10, (String)localObject, 2, (com.tencent.mm.plugin.finder.cgi.s.a)new s(this)).aYI();
    AppMethodBeat.o(247025);
  }
  
  public final boolean onBackPress()
  {
    AppMethodBeat.i(247018);
    if (this.hwr.getVisibility() == 0)
    {
      dhN();
      AppMethodBeat.o(247018);
      return true;
    }
    boolean bool = super.onBackPress();
    AppMethodBeat.o(247018);
    return bool;
  }
  
  public final void onClick(View paramView)
  {
    Object localObject1 = null;
    AppMethodBeat.i(247027);
    Object localObject2 = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).bm(paramView);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/live/plugin/FinderLiveShoppingListPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject2).axR());
    if (paramView != null)
    {
      paramView = Integer.valueOf(paramView.getId());
      if (paramView != null) {
        break label101;
      }
      label57:
      if (paramView != null) {
        break label118;
      }
      if (paramView != null) {
        break label131;
      }
      label65:
      if (paramView != null) {
        break label270;
      }
      label69:
      if (paramView != null) {
        break label289;
      }
    }
    for (;;)
    {
      label73:
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/plugin/FinderLiveShoppingListPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(247027);
      return;
      paramView = null;
      break;
      label101:
      if (paramView.intValue() != 2131301259) {
        break label57;
      }
      for (;;)
      {
        dhN();
        break label73;
        label118:
        if (paramView.intValue() != 2131301488) {
          break;
        }
      }
      label131:
      if (paramView.intValue() != 2131301265) {
        break label65;
      }
      paramView = com.tencent.mm.live.core.core.d.b.hCo;
      if (b.a.aDp())
      {
        localObject2 = TAG;
        StringBuilder localStringBuilder = new StringBuilder("gotoShoppingOrder appId:");
        paramView = getLiveData().uEl;
        if (paramView != null) {}
        for (paramView = paramView.LGE;; paramView = null)
        {
          localStringBuilder = localStringBuilder.append(paramView).append(",path:");
          awc localawc = getLiveData().uEl;
          paramView = localObject1;
          if (localawc != null) {
            paramView = localawc.LGA;
          }
          Log.i((String)localObject2, paramView);
          paramView = com.tencent.mm.plugin.finder.live.g.ufT;
          com.tencent.mm.plugin.finder.live.g.a(getLiveData(), (kotlin.g.a.m)new j(this));
          break;
        }
      }
      dhQ();
      continue;
      label270:
      if (paramView.intValue() != 2131301266) {
        break label69;
      }
      c(null, true);
      continue;
      label289:
      if (paramView.intValue() == 2131301261) {
        dhQ();
      }
    }
  }
  
  public final void onNewIntent(Intent paramIntent)
  {
    boolean bool = false;
    AppMethodBeat.i(247019);
    if (paramIntent != null) {
      bool = paramIntent.getBooleanExtra("extra_start_by_half_screen_empty_area_click_scene", false);
    }
    Log.i(TAG, "clickEmptyAreaClose = ".concat(String.valueOf(bool)));
    if (bool) {
      dhN();
    }
    AppMethodBeat.o(247019);
  }
  
  public final void statusChange(b.c paramc, Bundle paramBundle)
  {
    AppMethodBeat.i(247020);
    p.h(paramc, "status");
    switch (bg.$EnumSwitchMapping$0[paramc.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(247020);
      return;
      getLiveData().djd();
      rg(8);
      AppMethodBeat.o(247020);
      return;
      com.tencent.mm.ac.d.h((kotlin.g.a.a)new ac(this));
      AppMethodBeat.o(247020);
      return;
      Log.i(TAG, "refresh shop page,view visibility:" + this.hwr.getVisibility());
      if (this.hwr.getVisibility() == 0) {
        c(null, true);
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "bundle", "Lcom/tencent/mm/plugin/appbrand/api/WeAppOpenBundle;", "invoke", "com/tencent/mm/plugin/finder/live/plugin/FinderLiveShoppingListPlugin$1$1"})
  static final class a
    extends kotlin.g.b.q
    implements kotlin.g.a.b<com.tencent.mm.plugin.appbrand.api.g, x>
  {
    a(bf parambf)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "success", "", "invoke"})
  static final class aa
    extends kotlin.g.b.q
    implements kotlin.g.a.b<Boolean, x>
  {
    aa(bf parambf, Bundle paramBundle)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class ab
    implements Runnable
  {
    ab(bf parambf) {}
    
    public final void run()
    {
      AppMethodBeat.i(247014);
      bf.i(this.utX).show();
      AppMethodBeat.o(247014);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class ac
    extends kotlin.g.b.q
    implements kotlin.g.a.a<x>
  {
    ac(bf parambf)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "bundle", "Lcom/tencent/mm/plugin/appbrand/api/WeAppOpenBundle;", "invoke", "com/tencent/mm/plugin/finder/live/plugin/FinderLiveShoppingListPlugin$1$2"})
  static final class b
    extends kotlin.g.b.q
    implements kotlin.g.a.b<com.tencent.mm.plugin.appbrand.api.g, x>
  {
    b(bf parambf)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "empty", "", "invoke", "com/tencent/mm/plugin/finder/live/plugin/FinderLiveShoppingListPlugin$1$3"})
  static final class c
    extends kotlin.g.b.q
    implements kotlin.g.a.b<Boolean, x>
  {
    c(bf parambf)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "promting", "", "invoke", "com/tencent/mm/plugin/finder/live/plugin/FinderLiveShoppingListPlugin$1$4"})
  static final class d
    extends kotlin.g.b.q
    implements kotlin.g.a.b<Boolean, x>
  {
    d(bf parambf)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "holder", "Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveShoppingListAdapter$ShoppingViewHolder;", "Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveShoppingListAdapter;", "itemView", "Landroid/view/View;", "pos", "", "invoke", "com/tencent/mm/plugin/finder/live/plugin/FinderLiveShoppingListPlugin$1$5"})
  static final class e
    extends kotlin.g.b.q
    implements kotlin.g.a.q<h.b, View, Integer, x>
  {
    e(com.tencent.mm.plugin.finder.live.view.adapter.h paramh, bf parambf)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "productId", "", "invoke", "com/tencent/mm/plugin/finder/live/plugin/FinderLiveShoppingListPlugin$1$6"})
  static final class f
    extends kotlin.g.b.q
    implements kotlin.g.a.b<Long, x>
  {
    f(bf parambf)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveShoppingListPlugin$Companion;", "", "()V", "LOAD_MORE_THRESHOLD", "", "NOTIFY_VISITOR_SHOPPING_THRESHOLD", "PORTRAIT_ACTION_FULL_SCREEN_MINIPRO", "", "getPORTRAIT_ACTION_FULL_SCREEN_MINIPRO", "()Ljava/lang/String;", "PORTRAIT_ACTION_HALF_SCREEN_MINIPRO", "getPORTRAIT_ACTION_HALF_SCREEN_MINIPRO", "TAG", "getTAG", "plugin-finder_release"})
  public static final class g {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "gotoHalfScreen", "", "bundle", "Lcom/tencent/mm/plugin/appbrand/api/WeAppOpenBundle;", "invoke"})
  static final class h
    extends kotlin.g.b.q
    implements kotlin.g.a.m<Boolean, com.tencent.mm.plugin.appbrand.api.g, x>
  {
    h(bf parambf)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "success", "", "invoke"})
  static final class i
    extends kotlin.g.b.q
    implements kotlin.g.a.b<Boolean, x>
  {
    i(bf parambf)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "gotoHalfScreen", "", "bundle", "Lcom/tencent/mm/plugin/appbrand/api/WeAppOpenBundle;", "invoke"})
  static final class j
    extends kotlin.g.b.q
    implements kotlin.g.a.m<Boolean, com.tencent.mm.plugin.appbrand.api.g, x>
  {
    j(bf parambf)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/live/plugin/FinderLiveShoppingListPlugin$hideMaskView$1", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-finder_release"})
  public static final class k
    implements Animator.AnimatorListener
  {
    public final void onAnimationCancel(Animator paramAnimator) {}
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(246992);
      b.b.a(bf.e(this.utX), b.c.hNa);
      AppMethodBeat.o(246992);
    }
    
    public final void onAnimationRepeat(Animator paramAnimator) {}
    
    public final void onAnimationStart(Animator paramAnimator) {}
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class l
    implements Runnable
  {
    l(bf parambf) {}
    
    public final void run()
    {
      AppMethodBeat.i(246993);
      bf.i(this.utX).hide();
      AppMethodBeat.o(246993);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/live/plugin/FinderLiveShoppingListPlugin$initLandscapeLogic$1$1", "Landroid/support/v7/widget/RecyclerView$OnScrollListener;", "onScrollStateChanged", "", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "newState", "", "plugin-finder_release"})
  public static final class m
    extends RecyclerView.l
  {
    m(bf parambf) {}
    
    public final void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
    {
      AppMethodBeat.i(246994);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bm(paramRecyclerView);
      localb.pH(paramInt);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/live/plugin/FinderLiveShoppingListPlugin$initLandscapeLogic$$inlined$apply$lambda$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V", this, localb.axR());
      p.h(paramRecyclerView, "recyclerView");
      paramRecyclerView = paramRecyclerView.getLayoutManager();
      if (paramRecyclerView == null)
      {
        paramRecyclerView = new t("null cannot be cast to non-null type android.support.v7.widget.LinearLayoutManager");
        AppMethodBeat.o(246994);
        throw paramRecyclerView;
      }
      paramInt = ((LinearLayoutManager)paramRecyclerView).kv();
      bf.a(this.utX, paramInt);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/plugin/FinderLiveShoppingListPlugin$initLandscapeLogic$$inlined$apply$lambda$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V");
      AppMethodBeat.o(246994);
    }
    
    public final void onScrolled(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(246995);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bm(paramRecyclerView);
      localb.pH(paramInt1);
      localb.pH(paramInt2);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/live/plugin/FinderLiveShoppingListPlugin$initLandscapeLogic$$inlined$apply$lambda$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V", this, localb.axR());
      super.onScrolled(paramRecyclerView, paramInt1, paramInt2);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/plugin/FinderLiveShoppingListPlugin$initLandscapeLogic$$inlined$apply$lambda$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
      AppMethodBeat.o(246995);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/live/plugin/FinderLiveShoppingListPlugin$initLandscapeLogic$1$2", "Landroid/support/v7/widget/RecyclerView$OnItemTouchListener;", "onInterceptTouchEvent", "", "rv", "Landroid/support/v7/widget/RecyclerView;", "motionEvent", "Landroid/view/MotionEvent;", "onRequestDisallowInterceptTouchEvent", "", "p0", "onTouchEvent", "p1", "plugin-finder_release"})
  public static final class n
    implements RecyclerView.k
  {
    n(bf parambf) {}
    
    public final boolean a(RecyclerView paramRecyclerView, MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(246997);
      p.h(paramRecyclerView, "rv");
      p.h(paramMotionEvent, "motionEvent");
      bf.a(this.utX)[0] = ((int)paramMotionEvent.getRawX());
      bf.a(this.utX)[1] = ((int)paramMotionEvent.getRawY());
      paramRecyclerView = y.vXH;
      if (y.dCM())
      {
        paramRecyclerView = bf.utW;
        Log.i(bf.access$getTAG$cp(), "recyclerView, onTouchEvent() (%s, %s)", new Object[] { Integer.valueOf(bf.a(this.utX)[0]), Integer.valueOf(bf.a(this.utX)[1]) });
      }
      AppMethodBeat.o(246997);
      return false;
    }
    
    public final void ah(boolean paramBoolean) {}
    
    public final void b(RecyclerView paramRecyclerView, MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(246996);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bm(paramRecyclerView);
      localb.bm(paramMotionEvent);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/live/plugin/FinderLiveShoppingListPlugin$initLandscapeLogic$$inlined$apply$lambda$2", "android/support/v7/widget/RecyclerView$OnItemTouchListener", "onTouchEvent", "(Landroid/support/v7/widget/RecyclerView;Landroid/view/MotionEvent;)V", this, localb.axR());
      p.h(paramRecyclerView, "p0");
      p.h(paramMotionEvent, "p1");
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/plugin/FinderLiveShoppingListPlugin$initLandscapeLogic$$inlined$apply$lambda$2", "android/support/v7/widget/RecyclerView$OnItemTouchListener", "onTouchEvent", "(Landroid/support/v7/widget/RecyclerView;Landroid/view/MotionEvent;)V");
      AppMethodBeat.o(246996);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "isShow", "", "invoke", "com/tencent/mm/plugin/finder/live/plugin/FinderLiveShoppingListPlugin$initLandscapeLogic$2$1"})
  static final class o
    extends kotlin.g.b.q
    implements kotlin.g.a.b<Boolean, x>
  {
    o(bf parambf)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/live/plugin/FinderLiveShoppingListPlugin$initPortraitLogic$1$1", "Landroid/support/v7/widget/RecyclerView$OnScrollListener;", "onScrollStateChanged", "", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "newState", "", "plugin-finder_release"})
  public static final class p
    extends RecyclerView.l
  {
    p(bf parambf, int paramInt) {}
    
    public final void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
    {
      AppMethodBeat.i(246999);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bm(paramRecyclerView);
      localb.pH(paramInt);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/live/plugin/FinderLiveShoppingListPlugin$initPortraitLogic$$inlined$apply$lambda$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V", this, localb.axR());
      p.h(paramRecyclerView, "recyclerView");
      paramRecyclerView = paramRecyclerView.getLayoutManager();
      if (paramRecyclerView == null)
      {
        paramRecyclerView = new t("null cannot be cast to non-null type android.support.v7.widget.LinearLayoutManager");
        AppMethodBeat.o(246999);
        throw paramRecyclerView;
      }
      paramInt = ((LinearLayoutManager)paramRecyclerView).kv();
      bf.a(this.utX, paramInt);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/plugin/FinderLiveShoppingListPlugin$initPortraitLogic$$inlined$apply$lambda$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V");
      AppMethodBeat.o(246999);
    }
    
    public final void onScrolled(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(247000);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bm(paramRecyclerView);
      localb.pH(paramInt1);
      localb.pH(paramInt2);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/live/plugin/FinderLiveShoppingListPlugin$initPortraitLogic$$inlined$apply$lambda$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V", this, localb.axR());
      super.onScrolled(paramRecyclerView, paramInt1, paramInt2);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/plugin/FinderLiveShoppingListPlugin$initPortraitLogic$$inlined$apply$lambda$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
      AppMethodBeat.o(247000);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/live/plugin/FinderLiveShoppingListPlugin$initPortraitLogic$1$2", "Landroid/support/v7/widget/RecyclerView$OnItemTouchListener;", "onInterceptTouchEvent", "", "rv", "Landroid/support/v7/widget/RecyclerView;", "motionEvent", "Landroid/view/MotionEvent;", "onRequestDisallowInterceptTouchEvent", "", "p0", "onTouchEvent", "p1", "plugin-finder_release"})
  public static final class q
    implements RecyclerView.k
  {
    q(bf parambf, int paramInt) {}
    
    public final boolean a(RecyclerView paramRecyclerView, MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(247002);
      p.h(paramRecyclerView, "rv");
      p.h(paramMotionEvent, "motionEvent");
      bf.a(this.utX)[0] = ((int)paramMotionEvent.getRawX());
      bf.a(this.utX)[1] = ((int)paramMotionEvent.getRawY());
      paramRecyclerView = y.vXH;
      if (y.dCM())
      {
        paramRecyclerView = bf.utW;
        Log.i(bf.access$getTAG$cp(), "recyclerView, onTouchEvent() (%s, %s)", new Object[] { Integer.valueOf(bf.a(this.utX)[0]), Integer.valueOf(bf.a(this.utX)[1]) });
      }
      AppMethodBeat.o(247002);
      return false;
    }
    
    public final void ah(boolean paramBoolean) {}
    
    public final void b(RecyclerView paramRecyclerView, MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(247001);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bm(paramRecyclerView);
      localb.bm(paramMotionEvent);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/live/plugin/FinderLiveShoppingListPlugin$initPortraitLogic$$inlined$apply$lambda$2", "android/support/v7/widget/RecyclerView$OnItemTouchListener", "onTouchEvent", "(Landroid/support/v7/widget/RecyclerView;Landroid/view/MotionEvent;)V", this, localb.axR());
      p.h(paramRecyclerView, "p0");
      p.h(paramMotionEvent, "p1");
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/plugin/FinderLiveShoppingListPlugin$initPortraitLogic$$inlined$apply$lambda$2", "android/support/v7/widget/RecyclerView$OnItemTouchListener", "onTouchEvent", "(Landroid/support/v7/widget/RecyclerView;Landroid/view/MotionEvent;)V");
      AppMethodBeat.o(247001);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "isShow", "", "invoke", "com/tencent/mm/plugin/finder/live/plugin/FinderLiveShoppingListPlugin$initPortraitLogic$2$1"})
  static final class r
    extends kotlin.g.b.q
    implements kotlin.g.a.b<Boolean, x>
  {
    r(bf parambf, int paramInt)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/live/plugin/FinderLiveShoppingListPlugin$notifyVisitorShopping$1", "Lcom/tencent/mm/plugin/finder/cgi/CgiFinderLiveAnchorStatus$CallBack;", "onFail", "", "errType", "", "errCode", "errMsg", "", "anchorStatus", "onSuccess", "plugin-finder_release"})
  public static final class s
    implements com.tencent.mm.plugin.finder.cgi.s.a
  {
    public final void b(int paramInt1, int paramInt2, String paramString, int paramInt3)
    {
      AppMethodBeat.i(247005);
      paramString = bf.utW;
      Log.i(bf.access$getTAG$cp(), "notify visitor shopping fail times:" + bf.r(this.utX));
      this.utX.dhP();
      AppMethodBeat.o(247005);
    }
    
    public final void onSuccess(int paramInt)
    {
      AppMethodBeat.i(247004);
      bf.q(this.utX);
      bf.g localg = bf.utW;
      Log.i(bf.access$getTAG$cp(), "notify visitor shopping success times:" + bf.r(this.utX));
      AppMethodBeat.o(247004);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class t
    extends kotlin.g.b.q
    implements kotlin.g.a.a<x>
  {
    t(bf parambf)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class u
    extends kotlin.g.b.q
    implements kotlin.g.a.a<x>
  {
    u(bf parambf, Bundle paramBundle)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class v
    extends kotlin.g.b.q
    implements kotlin.g.a.a<x>
  {
    v(bf parambf, boolean paramBoolean)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class w
    implements Runnable
  {
    w(bf parambf, Bundle paramBundle, long paramLong) {}
    
    public final void run()
    {
      AppMethodBeat.i(247009);
      Object localObject1;
      if (!this.utX.isFinished())
      {
        localObject1 = paramBundle;
        if (localObject1 != null)
        {
          localObject1 = Integer.valueOf(((Bundle)localObject1).getInt("ACTION_DATA_KEY"));
          if (localObject1 == null) {
            break label99;
          }
          ((Number)localObject1).intValue();
          localObject1 = this.utX.getLiveData().uEi.remove(localObject1);
          label61:
          if ((localObject1 instanceof com.tencent.mm.plugin.appbrand.api.g)) {
            break label150;
          }
        }
      }
      label150:
      for (Object localObject2 = null;; localObject2 = localObject1)
      {
        if ((com.tencent.mm.plugin.appbrand.api.g)localObject2 != null)
        {
          bf.c(this.utX, (com.tencent.mm.plugin.appbrand.api.g)localObject1);
          AppMethodBeat.o(247009);
          return;
          localObject1 = null;
          break;
          label99:
          localObject1 = null;
          break label61;
        }
        AppMethodBeat.o(247009);
        return;
        localObject1 = bf.utW;
        Log.i(bf.access$getTAG$cp(), "openFullScreenMiniprogramImpl delayMs:" + paramLong + ",isFinished!");
        AppMethodBeat.o(247009);
        return;
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class x
    implements Runnable
  {
    x(bf parambf, Bundle paramBundle, long paramLong) {}
    
    public final void run()
    {
      AppMethodBeat.i(247010);
      Object localObject1;
      if (!this.utX.isFinished())
      {
        localObject1 = paramBundle;
        if (localObject1 != null)
        {
          localObject1 = Integer.valueOf(((Bundle)localObject1).getInt("ACTION_DATA_KEY"));
          if (localObject1 == null) {
            break label99;
          }
          ((Number)localObject1).intValue();
          localObject1 = this.utX.getLiveData().uEi.remove(localObject1);
          label61:
          if ((localObject1 instanceof com.tencent.mm.plugin.appbrand.api.g)) {
            break label150;
          }
        }
      }
      label150:
      for (Object localObject2 = null;; localObject2 = localObject1)
      {
        if ((com.tencent.mm.plugin.appbrand.api.g)localObject2 != null)
        {
          bf.d(this.utX, (com.tencent.mm.plugin.appbrand.api.g)localObject1);
          AppMethodBeat.o(247010);
          return;
          localObject1 = null;
          break;
          label99:
          localObject1 = null;
          break label61;
        }
        AppMethodBeat.o(247010);
        return;
        localObject1 = bf.utW;
        Log.i(bf.access$getTAG$cp(), "openHalfScreenMiniprogramImpl delayMs:" + paramLong + ",isFinished!");
        AppMethodBeat.o(247010);
        return;
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class y
    extends kotlin.g.b.q
    implements kotlin.g.a.a<x>
  {
    y(bf parambf, int paramInt)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/live/plugin/FinderLiveShoppingListPlugin$showProductList$1", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "onGlobalLayout", "", "plugin-finder_release"})
  public static final class z
    implements ViewTreeObserver.OnGlobalLayoutListener
  {
    z(int paramInt) {}
    
    public final void onGlobalLayout()
    {
      AppMethodBeat.i(247012);
      bf.o(this.utX).getViewTreeObserver().removeOnGlobalLayoutListener((ViewTreeObserver.OnGlobalLayoutListener)this);
      RecyclerView.LayoutManager localLayoutManager = bf.o(this.utX).getLayoutManager();
      Object localObject = localLayoutManager;
      if (!(localLayoutManager instanceof LinearLayoutManager)) {
        localObject = null;
      }
      localObject = (LinearLayoutManager)localObject;
      if (localObject != null) {
        ((LinearLayoutManager)localObject).ah(this.gUj, 0);
      }
      localObject = bf.utW;
      Log.i(bf.access$getTAG$cp(), "showProductList size:" + bf.h(this.utX).ppH.size() + ",scrollToPosition:" + this.gUj);
      AppMethodBeat.o(247012);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.plugin.bf
 * JD-Core Version:    0.7.0.1
 */