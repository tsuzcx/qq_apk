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
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout.LayoutParams;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.k;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.f.a;
import com.tencent.mm.live.c.b.b;
import com.tencent.mm.live.c.b.c;
import com.tencent.mm.plugin.appbrand.api.g;
import com.tencent.mm.plugin.expt.hellhound.a.b.b.c.a;
import com.tencent.mm.plugin.finder.b.d;
import com.tencent.mm.plugin.finder.b.f;
import com.tencent.mm.plugin.finder.b.j;
import com.tencent.mm.plugin.finder.live.cgi.d.a;
import com.tencent.mm.plugin.finder.live.model.ah;
import com.tencent.mm.plugin.finder.live.model.an;
import com.tencent.mm.plugin.finder.live.r;
import com.tencent.mm.plugin.finder.live.report.k;
import com.tencent.mm.plugin.finder.live.report.s.a;
import com.tencent.mm.plugin.finder.live.report.s.ah;
import com.tencent.mm.plugin.finder.live.report.s.bi;
import com.tencent.mm.plugin.finder.live.report.s.c;
import com.tencent.mm.plugin.finder.live.view.adapter.x.b;
import com.tencent.mm.plugin.finder.live.view.convert.e;
import com.tencent.mm.plugin.finder.live.view.convert.f;
import com.tencent.mm.plugin.finder.live.widget.FinderLiveShoppingPanel;
import com.tencent.mm.plugin.finder.live.widget.al;
import com.tencent.mm.plugin.finder.model.bu;
import com.tencent.mm.plugin.finder.utils.aj;
import com.tencent.mm.protocal.protobuf.ahj;
import com.tencent.mm.protocal.protobuf.azy;
import com.tencent.mm.protocal.protobuf.bac;
import com.tencent.mm.protocal.protobuf.bbc;
import com.tencent.mm.protocal.protobuf.bln;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.ax;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;
import org.json.JSONObject;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveShoppingListPlugin;", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;", "Landroid/view/View$OnClickListener;", "root", "Landroid/view/ViewGroup;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "MAX_PREHOT_SIZE", "", "TITLE_GROUP_HEIGHT", "getTITLE_GROUP_HEIGHT", "()I", "setTITLE_GROUP_HEIGHT", "(I)V", "blankArea", "Landroid/view/View;", "bundles", "Ljava/util/HashMap;", "", "Lcom/tencent/mm/plugin/appbrand/api/WeAppOpenBundle;", "Lkotlin/collections/HashMap;", "getBundles", "()Ljava/util/HashMap;", "checkAnchorShoppingAvailableTs", "", "close", "contentGroup", "Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveShoppingPanel;", "edit", "Landroid/widget/TextView;", "editWidget", "Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveShoppingEditWidget;", "emptyAction", "emptyGroup", "hasNotifyVisitorShopping", "", "loadingBar", "Landroid/widget/ProgressBar;", "maskHideAnim", "Landroid/animation/ObjectAnimator;", "maskShowAnim", "maskView", "notifyVisitorShoppingTimes", "orderGroup", "orderIv", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "orderTv", "productsTitle", "retryTip", "shoppingAvailableFirstErrorStatus", "shoppingList", "Landroidx/recyclerview/widget/RecyclerView;", "shoppingListAdapter", "Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveShoppingListAdapter;", "titleGroup", "touchLoc", "", "addProduct", "", "anchorAddProduct", "checkProductFirst", "checkEditState", "checkShoppingAvailableAnchorStatus", "getShoppingListData", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "gotoShoppingOrder", "hideMaskView", "hideShoppingContent", "initLandscapeLogic", "initPortraitLogic", "initTitleGroupHeight", "initView", "modifyShoppingContent", "allList", "", "notifyVisitorShopping", "onBackPress", "onClick", "v", "onGetShoppingListFail", "onGetShoppingListSuccess", "info", "Landroid/os/Bundle;", "refresh", "onNewIntent", "intent", "Landroid/content/Intent;", "onPortraitDelayAction", "extraMsg", "extraData", "", "delayMs", "openFullScreenMiniprogram", "bundle", "openFullScreenMiniprogramImpl", "openHalfScreenMiniprogram", "openHalfScreenMiniprogramImpl", "prehotMiniprogram", "products", "reportAnchor", "it", "Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;", "reportAnchorAddProduct", "reportWhenAddProduct", "setOrderGroup", "empty", "setTitle", "num", "showEmptyContent", "showEmptyShoppingPanel", "showMaskView", "showProductList", "productList", "showShoppingContent", "showShoppingLoading", "statusChange", "status", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "param", "Companion", "plugin-finder_release"})
public final class cl
  extends d
  implements View.OnClickListener
{
  private static final String TAG = "Finder.LiveShoppingListPlugin";
  private static final String yxv = "PORTRAIT_ACTION_FULL_SCREEN_MINIPRO";
  private static final String yxw = "PORTRAIT_ACTION_HALF_SCREEN_MINIPRO";
  public static final f yxx;
  private final com.tencent.mm.live.c.b kCL;
  private View kFU;
  private TextView kGi;
  private ProgressBar kGl;
  private View kGo;
  private View maskView;
  private View uZo;
  private int[] xYT;
  private View yuz;
  private int yxc;
  private FinderLiveShoppingPanel yxd;
  private View yxe;
  private TextView yxf;
  private WeImageView yxg;
  private TextView yxh;
  private RecyclerView yxi;
  private TextView yxj;
  private TextView yxk;
  public com.tencent.mm.plugin.finder.live.view.adapter.x yxl;
  private ObjectAnimator yxm;
  private ObjectAnimator yxn;
  private int yxo;
  private boolean yxp;
  private long yxq;
  private boolean yxr;
  private al yxs;
  private final int yxt;
  private final HashMap<String, g> yxu;
  
  static
  {
    AppMethodBeat.i(287492);
    yxx = new f((byte)0);
    TAG = "Finder.LiveShoppingListPlugin";
    yxv = "PORTRAIT_ACTION_FULL_SCREEN_MINIPRO";
    yxw = "PORTRAIT_ACTION_HALF_SCREEN_MINIPRO";
    AppMethodBeat.o(287492);
  }
  
  public cl(ViewGroup paramViewGroup, com.tencent.mm.live.c.b paramb)
  {
    super(paramViewGroup, paramb);
    AppMethodBeat.i(287491);
    this.kCL = paramb;
    paramViewGroup = paramViewGroup.getContext();
    p.j(paramViewGroup, "root.context");
    this.yxl = new com.tencent.mm.plugin.finder.live.view.adapter.x(paramViewGroup, this.kCL, this, getBuContext());
    this.yxr = true;
    this.xYT = new int[2];
    paramViewGroup = this.yxl;
    paramViewGroup.yZx = ((kotlin.g.a.b)new a(this));
    paramViewGroup.yZy = ((kotlin.g.a.b)new b(this));
    paramViewGroup.yZz = ((kotlin.g.a.b)new c(this));
    paramViewGroup.yZA = ((kotlin.g.a.q)new d(paramViewGroup, this));
    paramViewGroup.yZB = ((kotlin.g.a.b)new e(this));
    paramViewGroup = this.kiF.findViewById(b.f.finder_live_shopping_mask);
    p.j(paramViewGroup, "root.findViewById(R.id.finder_live_shopping_mask)");
    this.maskView = paramViewGroup;
    paramViewGroup = this.kiF.findViewById(b.f.finder_shopping_list_blank_area);
    p.j(paramViewGroup, "root.findViewById(R.id.f…shopping_list_blank_area)");
    this.kFU = paramViewGroup;
    paramViewGroup = this.kiF.findViewById(b.f.finder_shopping_list_content_area);
    p.j(paramViewGroup, "root.findViewById(R.id.f…opping_list_content_area)");
    this.yxd = ((FinderLiveShoppingPanel)paramViewGroup);
    paramViewGroup = this.kiF.findViewById(b.f.finder_live_shopping_list_title_group);
    p.j(paramViewGroup, "root.findViewById(R.id.f…hopping_list_title_group)");
    this.kGo = paramViewGroup;
    paramViewGroup = this.kGo;
    if (paramViewGroup == null) {
      p.bGy("titleGroup");
    }
    paramViewGroup = paramViewGroup.getLayoutParams();
    if (paramViewGroup != null) {}
    for (final int i = paramViewGroup.height;; i = 0)
    {
      this.yxc = i;
      if (this.yxc <= 0)
      {
        paramViewGroup = MMApplicationContext.getContext();
        p.j(paramViewGroup, "MMApplicationContext.getContext()");
        this.yxc = paramViewGroup.getResources().getDimensionPixelOffset(b.d.Edge_8A);
      }
      Log.i(TAG, "initTitleGroupHeight:" + this.yxc);
      paramViewGroup = this.kiF.findViewById(b.f.finder_live_shopping_list_close);
      p.j(paramViewGroup, "root.findViewById(R.id.f…live_shopping_list_close)");
      this.uZo = paramViewGroup;
      paramViewGroup = this.kiF.findViewById(b.f.finder_live_shopping_list_order_group);
      p.j(paramViewGroup, "root.findViewById(R.id.f…hopping_list_order_group)");
      this.yxe = paramViewGroup;
      paramViewGroup = this.kiF.findViewById(b.f.finder_live_shopping_list_order_tv);
      p.j(paramViewGroup, "root.findViewById(R.id.f…e_shopping_list_order_tv)");
      this.yxf = ((TextView)paramViewGroup);
      paramViewGroup = this.kiF.findViewById(b.f.finder_live_shopping_list_order_iv);
      p.j(paramViewGroup, "root.findViewById(R.id.f…e_shopping_list_order_iv)");
      this.yxg = ((WeImageView)paramViewGroup);
      paramViewGroup = this.kiF.findViewById(b.f.finder_live_shopping_list_edit);
      p.j(paramViewGroup, "root.findViewById(R.id.f…_live_shopping_list_edit)");
      this.yxh = ((TextView)paramViewGroup);
      paramViewGroup = this.kiF.findViewById(b.f.finder_live_shopping_list_content);
      p.j(paramViewGroup, "root.findViewById(R.id.f…ve_shopping_list_content)");
      this.yxi = ((RecyclerView)paramViewGroup);
      paramViewGroup = this.kiF.findViewById(b.f.finder_live_shopping_list_loading);
      p.j(paramViewGroup, "root.findViewById(R.id.f…ve_shopping_list_loading)");
      this.kGl = ((ProgressBar)paramViewGroup);
      paramViewGroup = this.kiF.findViewById(b.f.finder_live_shopping_list_retry_tip);
      p.j(paramViewGroup, "root.findViewById(R.id.f…_shopping_list_retry_tip)");
      this.kGi = ((TextView)paramViewGroup);
      paramViewGroup = this.kiF.findViewById(b.f.finder_live_shopping_list_empty_group);
      p.j(paramViewGroup, "root.findViewById(R.id.f…hopping_list_empty_group)");
      this.yuz = paramViewGroup;
      paramViewGroup = this.kiF.findViewById(b.f.finder_live_shopping_list_empty_action);
      p.j(paramViewGroup, "root.findViewById(R.id.f…opping_list_empty_action)");
      this.yxj = ((TextView)paramViewGroup);
      paramViewGroup = this.kiF.findViewById(b.f.finder_live_shopping_list_title);
      p.j(paramViewGroup, "root.findViewById(R.id.f…live_shopping_list_title)");
      this.yxk = ((TextView)paramViewGroup);
      if (!isLandscape()) {
        break label1054;
      }
      paramViewGroup = this.yxi;
      if (paramViewGroup == null) {
        p.bGy("shoppingList");
      }
      this.kiF.getContext();
      paramViewGroup.setLayoutManager((RecyclerView.LayoutManager)new LinearLayoutManager(1, false));
      paramViewGroup.setAdapter((RecyclerView.a)this.yxl);
      paramViewGroup.a((RecyclerView.k)new l(this));
      paramViewGroup.getLayoutParams().height = (ax.au(this.kiF.getContext()).y - this.yxc);
      Log.i(TAG, "shoppingList height:" + paramViewGroup.getLayoutParams().height);
      paramViewGroup = this.yxd;
      if (paramViewGroup == null) {
        p.bGy("contentGroup");
      }
      paramViewGroup.setTranslationX(ax.au(this.kiF.getContext()).y);
      paramViewGroup.setOnVisibilityListener((kotlin.g.a.b)new m(this));
      paramViewGroup = this.yxd;
      if (paramViewGroup == null) {
        p.bGy("contentGroup");
      }
      paramViewGroup = paramViewGroup.getLayoutParams();
      if (paramViewGroup != null) {
        break;
      }
      paramViewGroup = new t("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
      AppMethodBeat.o(287491);
      throw paramViewGroup;
    }
    ((ConstraintLayout.LayoutParams)paramViewGroup).width = ax.au(this.kiF.getContext()).y;
    paramViewGroup = this.yxk;
    if (paramViewGroup == null) {
      p.bGy("productsTitle");
    }
    ar.a((Paint)paramViewGroup.getPaint(), 0.8F);
    paramViewGroup = this.kFU;
    if (paramViewGroup == null) {
      p.bGy("blankArea");
    }
    paramViewGroup.setOnClickListener((View.OnClickListener)this);
    paramViewGroup = this.uZo;
    if (paramViewGroup == null) {
      p.bGy("close");
    }
    paramViewGroup.setOnClickListener((View.OnClickListener)this);
    paramViewGroup = this.yxe;
    if (paramViewGroup == null) {
      p.bGy("orderGroup");
    }
    paramViewGroup.setOnClickListener((View.OnClickListener)this);
    paramViewGroup = this.yxh;
    if (paramViewGroup == null) {
      p.bGy("edit");
    }
    paramViewGroup.setOnClickListener((View.OnClickListener)this);
    paramViewGroup = this.kGi;
    if (paramViewGroup == null) {
      p.bGy("retryTip");
    }
    paramViewGroup.setOnClickListener((View.OnClickListener)this);
    paramViewGroup = this.yxj;
    if (paramViewGroup == null) {
      p.bGy("emptyAction");
    }
    paramViewGroup.setOnClickListener((View.OnClickListener)this);
    for (;;)
    {
      this.yxt = 3;
      this.yxu = new HashMap();
      AppMethodBeat.o(287491);
      return;
      label1054:
      float f = ax.au(MMApplicationContext.getContext()).y;
      paramViewGroup = com.tencent.c.a.a.a.a.a.Zlt;
      i = (int)(f * (com.tencent.c.a.a.a.a.a.imN() / 100.0F));
      paramViewGroup = this.yxi;
      if (paramViewGroup == null) {
        p.bGy("shoppingList");
      }
      this.kiF.getContext();
      paramViewGroup.setLayoutManager((RecyclerView.LayoutManager)new LinearLayoutManager(1, false));
      paramViewGroup.setAdapter((RecyclerView.a)this.yxl);
      paramViewGroup.a((RecyclerView.k)new n(this, i));
      paramViewGroup.getLayoutParams().height = (i - this.yxc);
      Log.i(TAG, "shoppingList height:" + paramViewGroup.getLayoutParams().height);
      paramViewGroup = this.yxd;
      if (paramViewGroup == null) {
        p.bGy("contentGroup");
      }
      paramViewGroup.setTranslationY(ax.au(this.kiF.getContext()).y);
      paramViewGroup.setOnVisibilityListener((kotlin.g.a.b)new o(this, i));
      paramViewGroup.getLayoutParams().height = i;
      Log.i(paramViewGroup.getTAG(), "contentGroup height:" + paramViewGroup.getLayoutParams().height);
      paramViewGroup = this.yxk;
      if (paramViewGroup == null) {
        p.bGy("productsTitle");
      }
      ar.a((Paint)paramViewGroup.getPaint(), 0.8F);
      paramViewGroup = this.kFU;
      if (paramViewGroup == null) {
        p.bGy("blankArea");
      }
      paramViewGroup.setOnClickListener((View.OnClickListener)this);
      paramViewGroup = this.uZo;
      if (paramViewGroup == null) {
        p.bGy("close");
      }
      paramViewGroup.setOnClickListener((View.OnClickListener)this);
      paramViewGroup = this.yxe;
      if (paramViewGroup == null) {
        p.bGy("orderGroup");
      }
      paramViewGroup.setOnClickListener((View.OnClickListener)this);
      paramViewGroup = this.yxh;
      if (paramViewGroup == null) {
        p.bGy("edit");
      }
      paramViewGroup.setOnClickListener((View.OnClickListener)this);
      paramViewGroup = this.kGi;
      if (paramViewGroup == null) {
        p.bGy("retryTip");
      }
      paramViewGroup.setOnClickListener((View.OnClickListener)this);
      paramViewGroup = this.yxj;
      if (paramViewGroup == null) {
        p.bGy("emptyAction");
      }
      paramViewGroup.setOnClickListener((View.OnClickListener)this);
    }
  }
  
  private final void N(boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(287479);
    if ((!paramBoolean) && (paramInt > 0))
    {
      localTextView = this.yxk;
      if (localTextView == null) {
        p.bGy("productsTitle");
      }
      localContext = this.kiF.getContext();
      p.j(localContext, "root.context");
      localTextView.setText((CharSequence)localContext.getResources().getString(b.j.finder_live_shopping_title_with_num, new Object[] { Integer.valueOf(paramInt) }));
      AppMethodBeat.o(287479);
      return;
    }
    TextView localTextView = this.yxk;
    if (localTextView == null) {
      p.bGy("productsTitle");
    }
    Context localContext = this.kiF.getContext();
    p.j(localContext, "root.context");
    localTextView.setText((CharSequence)localContext.getResources().getString(b.j.finder_live_shopping_title));
    AppMethodBeat.o(287479);
  }
  
  private final void a(LinkedList<bu> paramLinkedList, Bundle paramBundle)
  {
    AppMethodBeat.i(287483);
    Object localObject1 = this.yuz;
    if (localObject1 == null) {
      p.bGy("emptyGroup");
    }
    ((View)localObject1).setVisibility(8);
    localObject1 = this.kGl;
    if (localObject1 == null) {
      p.bGy("loadingBar");
    }
    ((ProgressBar)localObject1).setVisibility(8);
    localObject1 = this.kGo;
    if (localObject1 == null) {
      p.bGy("titleGroup");
    }
    ((View)localObject1).setVisibility(0);
    localObject1 = this.yxi;
    if (localObject1 == null) {
      p.bGy("shoppingList");
    }
    ((RecyclerView)localObject1).setVisibility(0);
    localObject1 = this.kGi;
    if (localObject1 == null) {
      p.bGy("retryTip");
    }
    ((TextView)localObject1).setVisibility(8);
    pm(false);
    com.tencent.mm.plugin.finder.live.view.adapter.x localx = this.yxl;
    Object localObject2 = new StringBuilder("before updateShoppingList,ori size:").append(localx.yZv.size()).append(",new size:");
    Object localObject3;
    final int i;
    if (paramLinkedList != null)
    {
      localObject1 = Integer.valueOf(paramLinkedList.size());
      Log.i("Finder.LiveShoppingListAdapter", localObject1);
      if (paramLinkedList == null) {
        break label535;
      }
      localx.yZv.clear();
      localx.yZv.addAll((Collection)paramLinkedList);
      localx.yZw.clear();
      localObject2 = localx.yZw;
      localObject1 = (Iterable)paramLinkedList;
      localObject3 = (Collection)new ArrayList(kotlin.a.j.a((Iterable)localObject1, 10));
      i = 0;
      Iterator localIterator = ((Iterable)localObject1).iterator();
      label269:
      if (!localIterator.hasNext()) {
        break label341;
      }
      localObject1 = localIterator.next();
      if (i < 0) {
        kotlin.a.j.iBO();
      }
      if (!((bu)localObject1 instanceof e)) {
        break label335;
      }
    }
    label335:
    for (localObject1 = Integer.valueOf(i);; localObject1 = null)
    {
      ((Collection)localObject3).add(localObject1);
      i += 1;
      break label269;
      localObject1 = null;
      break;
    }
    label341:
    ((ArrayList)localObject2).addAll((Collection)kotlin.a.j.l((Iterable)localObject3));
    int j;
    if (localx.kCL.getLiveRole() == 1)
    {
      i = 1;
      if (i != 0)
      {
        localObject1 = k.yBj;
        k.dDm().yDC.clear();
        localObject1 = (Iterable)paramLinkedList;
        i = 0;
        localObject1 = ((Iterable)localObject1).iterator();
      }
    }
    else
    {
      for (;;)
      {
        if (!((Iterator)localObject1).hasNext()) {
          break label535;
        }
        localObject2 = ((Iterator)localObject1).next();
        j = i + 1;
        if (i < 0) {
          kotlin.a.j.iBO();
        }
        localObject2 = (bu)localObject2;
        if ((localObject2 instanceof f))
        {
          localObject3 = k.yBj;
          k.dDm().yDC.add(Long.valueOf(((f)localObject2).zaO));
          i = j;
          continue;
          i = 0;
          break;
        }
        if ((localObject2 instanceof e))
        {
          localObject3 = k.yBj;
          k.dDm().yDC.add(Long.valueOf(((e)localObject2).zaI));
        }
        i = j;
      }
    }
    label535:
    Log.i("Finder.LiveShoppingListAdapter", "after updateShoppingList,data size:" + localx.yZv.size() + ",ad list:" + localx.yZw);
    N(false, this.yxl.dFK());
    this.yxl.notifyDataSetChanged();
    long l2;
    if ((paramBundle != null) && ((paramBundle.containsKey("PARAM_FINDER_LIVE_BUBBLE_PRODUCTID")) || (paramBundle.containsKey("PARAM_FINDER_LIVE_BUBBLE_ADID"))))
    {
      long l1 = paramBundle.getLong("PARAM_FINDER_LIVE_BUBBLE_PRODUCTID", 0L);
      l2 = paramBundle.getLong("PARAM_FINDER_LIVE_BUBBLE_ADID", 0L);
      if (l1 == 0L) {
        break label804;
      }
      paramBundle = (List)this.yxl.yZv;
      i = 0;
      paramBundle = paramBundle.iterator();
      if (!paramBundle.hasNext()) {
        break label799;
      }
      localObject1 = (bu)paramBundle.next();
      if ((!(localObject1 instanceof f)) || (((f)localObject1).zaO != l1)) {
        break label786;
      }
      j = 1;
      label714:
      if (j == 0) {
        break label792;
      }
    }
    label901:
    label908:
    for (;;)
    {
      if ((i >= 0) && (i < this.yxl.yZv.size()))
      {
        paramBundle = this.yxi;
        if (paramBundle == null) {
          p.bGy("shoppingList");
        }
        paramBundle.getViewTreeObserver().addOnGlobalLayoutListener((ViewTreeObserver.OnGlobalLayoutListener)new u(this, i));
      }
      et((List)paramLinkedList);
      AppMethodBeat.o(287483);
      return;
      label786:
      j = 0;
      break label714;
      label792:
      i += 1;
      break;
      label799:
      i = -1;
      continue;
      label804:
      if (l2 != 0L)
      {
        paramBundle = ((List)this.yxl.yZv).iterator();
        i = 0;
        for (;;)
        {
          if (!paramBundle.hasNext()) {
            break label908;
          }
          localObject1 = (bu)paramBundle.next();
          if (((localObject1 instanceof e)) && (((e)localObject1).zaI != 0L) && (((e)localObject1).zaI == l2)) {}
          for (j = 1;; j = 0)
          {
            if (j == 0) {
              break label901;
            }
            break;
          }
          i += 1;
        }
        i = -1;
      }
      else
      {
        i = -1;
      }
    }
  }
  
  private final void b(final Bundle paramBundle, final boolean paramBoolean)
  {
    AppMethodBeat.i(287475);
    if ((paramBundle != null) && (paramBundle.getBoolean("PARAM_FINDER_LIVE_SHOPPING_SOURCE_CLICK", false) == true)) {}
    Object localObject;
    Context localContext;
    for (final boolean bool = true;; bool = false)
    {
      Log.i(TAG, "showShoppingContent is refresh:" + paramBoolean + "，checkProductFirst:" + bool);
      localObject = ah.yhC;
      localObject = ah.getFinderLiveAssistant();
      if (localObject == null) {
        break label191;
      }
      localContext = this.kiF.getContext();
      if (localContext != null) {
        break;
      }
      paramBundle = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
      AppMethodBeat.o(287475);
      throw paramBundle;
    }
    ((an)localObject).a((MMActivity)localContext, ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.c)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.c.class)).liveInfo.liveId, ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.c)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.c.class)).xbk, ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).kig, ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.c)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.c.class)).kvN, (kotlin.g.a.b)new v(this, bool, paramBundle, paramBoolean));
    label191:
    if (!pl(bool))
    {
      tU(0);
      dCC();
    }
    AppMethodBeat.o(287475);
  }
  
  private final void dCA()
  {
    AppMethodBeat.i(287469);
    if (this.yxm == null)
    {
      localObject = this.maskView;
      if (localObject == null) {
        p.bGy("maskView");
      }
      this.yxm = ObjectAnimator.ofFloat(localObject, "alpha", new float[] { 0.0F, 1.0F });
    }
    Object localObject = this.maskView;
    if (localObject == null) {
      p.bGy("maskView");
    }
    if (((View)localObject).getAlpha() == 1.0F)
    {
      AppMethodBeat.o(287469);
      return;
    }
    localObject = this.yxm;
    if (localObject != null) {
      ((ObjectAnimator)localObject).cancel();
    }
    localObject = this.yxm;
    if (localObject != null)
    {
      ((ObjectAnimator)localObject).start();
      AppMethodBeat.o(287469);
      return;
    }
    AppMethodBeat.o(287469);
  }
  
  private final void dCB()
  {
    AppMethodBeat.i(287473);
    Log.i(TAG, "hideShoppingContent:" + Util.getStack());
    FinderLiveShoppingPanel localFinderLiveShoppingPanel = this.yxd;
    if (localFinderLiveShoppingPanel == null) {
      p.bGy("contentGroup");
    }
    localFinderLiveShoppingPanel.post((Runnable)new k(this));
    AppMethodBeat.o(287473);
  }
  
  private final void dCC()
  {
    AppMethodBeat.i(287476);
    Object localObject = this.kGl;
    if (localObject == null) {
      p.bGy("loadingBar");
    }
    ((ProgressBar)localObject).setVisibility(0);
    localObject = this.kGi;
    if (localObject == null) {
      p.bGy("retryTip");
    }
    ((TextView)localObject).setVisibility(8);
    localObject = this.yuz;
    if (localObject == null) {
      p.bGy("emptyGroup");
    }
    ((View)localObject).setVisibility(8);
    localObject = this.kGo;
    if (localObject == null) {
      p.bGy("titleGroup");
    }
    ((View)localObject).setVisibility(8);
    localObject = this.yxi;
    if (localObject == null) {
      p.bGy("shoppingList");
    }
    ((RecyclerView)localObject).setVisibility(8);
    localObject = this.yxd;
    if (localObject == null) {
      p.bGy("contentGroup");
    }
    ((FinderLiveShoppingPanel)localObject).post((Runnable)new w(this));
    dCA();
    AppMethodBeat.o(287476);
  }
  
  private final void dCD()
  {
    AppMethodBeat.i(287477);
    Object localObject = this.kGl;
    if (localObject == null) {
      p.bGy("loadingBar");
    }
    ((ProgressBar)localObject).setVisibility(8);
    localObject = this.kGi;
    if (localObject == null) {
      p.bGy("retryTip");
    }
    ((TextView)localObject).setVisibility(8);
    localObject = this.yuz;
    if (localObject == null) {
      p.bGy("emptyGroup");
    }
    ((View)localObject).setVisibility(8);
    localObject = this.kGo;
    if (localObject == null) {
      p.bGy("titleGroup");
    }
    ((View)localObject).setVisibility(8);
    localObject = this.yxi;
    if (localObject == null) {
      p.bGy("shoppingList");
    }
    ((RecyclerView)localObject).setVisibility(8);
    localObject = this.yxd;
    if (localObject == null) {
      p.bGy("contentGroup");
    }
    ((FinderLiveShoppingPanel)localObject).post((Runnable)new t(this));
    dCA();
    tU(0);
    AppMethodBeat.o(287477);
  }
  
  private final void dCE()
  {
    AppMethodBeat.i(287478);
    Object localObject1 = com.tencent.mm.plugin.finder.live.utils.a.yRm;
    if (com.tencent.mm.plugin.finder.live.utils.a.dEy())
    {
      Object localObject2 = (Iterable)this.yxl.yZv;
      localObject1 = (Collection)new ArrayList();
      localObject2 = ((Iterable)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        Object localObject3 = ((Iterator)localObject2).next();
        if ((localObject3 instanceof f)) {
          ((Collection)localObject1).add(localObject3);
        }
      }
      if (!((Collection)localObject1).isEmpty()) {}
      for (int i = 1; i != 0; i = 0)
      {
        localObject1 = this.yxh;
        if (localObject1 == null) {
          p.bGy("edit");
        }
        ((TextView)localObject1).setVisibility(0);
        AppMethodBeat.o(287478);
        return;
      }
    }
    localObject1 = this.yxh;
    if (localObject1 == null) {
      p.bGy("edit");
    }
    ((TextView)localObject1).setVisibility(4);
    AppMethodBeat.o(287478);
  }
  
  private final void dCF()
  {
    AppMethodBeat.i(287481);
    Object localObject = this.yuz;
    if (localObject == null) {
      p.bGy("emptyGroup");
    }
    ((View)localObject).setVisibility(0);
    localObject = com.tencent.mm.plugin.finder.live.utils.a.yRm;
    if (com.tencent.mm.plugin.finder.live.utils.a.dEy())
    {
      localObject = this.yxj;
      if (localObject == null) {
        p.bGy("emptyAction");
      }
      ((TextView)localObject).setVisibility(0);
    }
    for (;;)
    {
      localObject = this.kGl;
      if (localObject == null) {
        p.bGy("loadingBar");
      }
      ((ProgressBar)localObject).setVisibility(8);
      localObject = this.kGo;
      if (localObject == null) {
        p.bGy("titleGroup");
      }
      ((View)localObject).setVisibility(0);
      N(true, 0);
      localObject = this.yxi;
      if (localObject == null) {
        p.bGy("shoppingList");
      }
      ((RecyclerView)localObject).setVisibility(8);
      pm(true);
      localObject = this.kGi;
      if (localObject == null) {
        p.bGy("retryTip");
      }
      ((TextView)localObject).setVisibility(8);
      dCE();
      AppMethodBeat.o(287481);
      return;
      localObject = this.yxj;
      if (localObject == null) {
        p.bGy("emptyAction");
      }
      ((TextView)localObject).setVisibility(8);
    }
  }
  
  private final void dCI()
  {
    Object localObject2 = null;
    AppMethodBeat.i(287486);
    Object localObject3 = TAG;
    Object localObject4 = new StringBuilder("add product appId:");
    Object localObject1 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.j.class)).ziI;
    if (localObject1 != null)
    {
      localObject1 = ((azy)localObject1).SLw;
      if (localObject1 != null)
      {
        localObject1 = ((bln)localObject1).appId;
        localObject4 = ((StringBuilder)localObject4).append((String)localObject1).append(",path:");
        localObject1 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.j.class)).ziI;
        if (localObject1 == null) {
          break label273;
        }
        localObject1 = ((azy)localObject1).SLw;
        if (localObject1 == null) {
          break label273;
        }
      }
    }
    label273:
    for (localObject1 = ((bln)localObject1).SWz;; localObject1 = null)
    {
      Log.i((String)localObject3, (String)localObject1);
      localObject1 = r.xWC;
      r.b(getBuContext(), (kotlin.g.a.m)new g(this));
      if (this.kCL.getLiveRole() != 1) {
        break label534;
      }
      localObject3 = new JSONObject();
      ((JSONObject)localObject3).put("type", s.ah.yIx.action);
      localObject1 = k.yBj;
      ((JSONObject)localObject3).put("sessionid", k.dDm().yCW);
      ((JSONObject)localObject3).put("shopwindowid", "");
      localObject1 = com.tencent.mm.plugin.finder.live.model.context.a.ykr;
      localObject1 = com.tencent.mm.plugin.finder.live.model.context.a.dAc();
      if (localObject1 == null) {
        break label278;
      }
      localObject1 = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)((com.tencent.mm.plugin.finder.live.model.context.a)localObject1).business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class);
      if ((localObject1 == null) || (((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)localObject1).dGM() != true)) {
        break label278;
      }
      localObject1 = k.yBj;
      k.t(s.a.yDO.jWO, ((JSONObject)localObject3).toString());
      AppMethodBeat.o(287486);
      return;
      localObject1 = null;
      break;
    }
    label278:
    localObject1 = com.tencent.mm.plugin.finder.live.model.context.a.ykr;
    localObject1 = com.tencent.mm.plugin.finder.live.model.context.a.dAc();
    long l;
    if (localObject1 != null)
    {
      localObject1 = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)((com.tencent.mm.plugin.finder.live.model.context.a)localObject1).business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class);
      if (localObject1 != null) {
        if (((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)localObject1).isLiveStarted() == true)
        {
          localObject1 = k.yBj;
          k.dDm().yDB = true;
          localObject1 = com.tencent.mm.plugin.finder.live.model.context.a.ykr;
          localObject4 = com.tencent.mm.plugin.finder.live.model.context.a.dAc();
          localObject1 = localObject2;
          if (localObject4 != null)
          {
            localObject4 = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)((com.tencent.mm.plugin.finder.live.model.context.a)localObject4).business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.j.class);
            localObject1 = localObject2;
            if (localObject4 != null) {
              localObject1 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)localObject4).ziN;
            }
          }
          ((JSONObject)localObject3).put("appid", localObject1);
          localObject1 = com.tencent.mm.plugin.finder.live.model.context.a.ykr;
          localObject1 = com.tencent.mm.plugin.finder.live.model.context.a.dAc();
          if (localObject1 == null) {
            break label548;
          }
          localObject1 = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.c)((com.tencent.mm.plugin.finder.live.model.context.a)localObject1).business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.c.class);
          if (localObject1 == null) {
            break label548;
          }
          localObject1 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.c)localObject1).liveInfo;
          if (localObject1 == null) {
            break label548;
          }
          l = ((bac)localObject1).liveId;
          if (l >= 0L) {
            break label555;
          }
          ((JSONObject)localObject3).put("liveid", "");
          label437:
          localObject1 = com.tencent.mm.plugin.expt.hellhound.a.b.b.c.wkV;
          ((JSONObject)localObject3).put("clickid", com.tencent.mm.plugin.expt.hellhound.a.b.b.c.ddF());
          localObject1 = com.tencent.mm.plugin.expt.hellhound.a.b.b.c.wkV;
          c.a.axD("");
          localObject1 = com.tencent.mm.plugin.finder.live.model.context.a.ykr;
          localObject1 = com.tencent.mm.plugin.finder.live.model.context.a.dAc();
          if (localObject1 == null) {
            break label571;
          }
          localObject1 = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)((com.tencent.mm.plugin.finder.live.model.context.a)localObject1).business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.j.class);
          if (localObject1 == null) {
            break label571;
          }
          localObject1 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)localObject1).ziK;
          if (localObject1 == null) {
            break label571;
          }
        }
      }
    }
    label534:
    label548:
    label555:
    label571:
    for (localObject1 = Long.valueOf(((bu)localObject1).mf());; localObject1 = "")
    {
      ((JSONObject)localObject3).put("productid", localObject1);
      localObject1 = k.yBj;
      k.a(s.c.yEp, ((JSONObject)localObject3).toString());
      AppMethodBeat.o(287486);
      return;
      AppMethodBeat.o(287486);
      return;
      l = -1L;
      break;
      ((JSONObject)localObject3).put("liveid", com.tencent.mm.plugin.expt.hellhound.core.b.Fw(l));
      break label437;
    }
  }
  
  private final void et(List<? extends bu> paramList)
  {
    AppMethodBeat.i(287482);
    Object localObject1 = com.tencent.mm.plugin.finder.live.utils.a.yRm;
    if (!com.tencent.mm.plugin.finder.live.utils.a.dEC())
    {
      Log.i(TAG, "disable preload others weapp!");
      AppMethodBeat.o(287482);
      return;
    }
    this.yxu.clear();
    if (paramList != null)
    {
      localObject1 = (Iterable)paramList;
      paramList = (Collection)new ArrayList();
      localObject1 = ((Iterable)localObject1).iterator();
      Object localObject2;
      Object localObject4;
      label144:
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = ((Iterator)localObject1).next();
        localObject3 = (bu)localObject2;
        if ((localObject3 instanceof f))
        {
          localObject4 = com.tencent.mm.plugin.finder.live.utils.a.yRm;
          if (!com.tencent.mm.plugin.finder.live.utils.a.NJ(((f)localObject3).yiH)) {}
        }
        for (i = 1;; i = 0)
        {
          if (i == 0) {
            break label144;
          }
          paramList.add(localObject2);
          break;
        }
      }
      Object localObject3 = ((Iterable)paramList).iterator();
      paramList = null;
      for (;;)
      {
        localObject1 = paramList;
        if (!((Iterator)localObject3).hasNext()) {
          break;
        }
        localObject1 = (bu)((Iterator)localObject3).next();
        if (localObject1 == null)
        {
          paramList = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.live.view.convert.ShopWindowShelfProductItem");
          AppMethodBeat.o(287482);
          throw paramList;
        }
        localObject1 = (f)localObject1;
        if (((f)localObject1).zaV == 1)
        {
          localObject1 = ((f)localObject1).zaU;
          if (localObject1 != null)
          {
            paramList = com.tencent.mm.plugin.finder.live.utils.a.yRm;
            paramList = com.tencent.mm.plugin.finder.live.utils.a.a((ahj)localObject1);
          }
        }
        else
        {
          localObject4 = ((f)localObject1).zaU;
          if (localObject4 != null)
          {
            HashMap localHashMap = this.yxu;
            localObject2 = ((ahj)localObject4).appid;
            localObject1 = localObject2;
            if (localObject2 == null) {
              localObject1 = "";
            }
            localObject2 = com.tencent.mm.plugin.finder.live.utils.a.yRm;
            localHashMap.put(localObject1, com.tencent.mm.plugin.finder.live.utils.a.a((ahj)localObject4));
          }
        }
      }
    }
    localObject1 = null;
    Log.i(TAG, "prehotMiniprogram promotingBundle:" + localObject1 + ",bundle size:" + this.yxu.size() + ",MAX_PREHOT_SIZE:" + this.yxt);
    if (localObject1 != null)
    {
      com.tencent.mm.plugin.finder.live.s.a(com.tencent.mm.plugin.finder.live.s.xWG, getBuContext(), (g)localObject1);
      this.yxu.remove(((g)localObject1).appId);
    }
    paramList = ((Map)this.yxu).entrySet().iterator();
    int i = 0;
    while (paramList.hasNext())
    {
      localObject1 = (Map.Entry)paramList.next();
      int j = i + 1;
      if (i < this.yxt)
      {
        localObject1 = (g)((Map.Entry)localObject1).getValue();
        if (localObject1 != null)
        {
          com.tencent.mm.plugin.finder.live.s.a(com.tencent.mm.plugin.finder.live.s.xWG, getBuContext(), (g)localObject1);
          i = j;
          continue;
        }
      }
      i = j;
    }
    AppMethodBeat.o(287482);
  }
  
  private final void f(g paramg)
  {
    AppMethodBeat.i(287488);
    Object localObject = ah.yhC;
    an localan = ah.getFinderLiveAssistant();
    if (localan != null)
    {
      localObject = this.kiF;
      if (localObject != null) {}
      for (localObject = ((ViewGroup)localObject).getContext();; localObject = null)
      {
        p.j(localObject, "root?.context");
        localan.a((Context)localObject, paramg, dxf());
        AppMethodBeat.o(287488);
        return;
      }
    }
    AppMethodBeat.o(287488);
  }
  
  private final void g(g paramg)
  {
    AppMethodBeat.i(287489);
    Object localObject = ah.yhC;
    an localan = ah.getFinderLiveAssistant();
    if (localan != null)
    {
      localObject = this.kiF;
      if (localObject != null) {}
      for (localObject = ((ViewGroup)localObject).getContext();; localObject = null)
      {
        p.j(localObject, "root?.context");
        localan.b((Context)localObject, paramg, dxf());
        AppMethodBeat.o(287489);
        return;
      }
    }
    AppMethodBeat.o(287489);
  }
  
  private static boolean pl(boolean paramBoolean)
  {
    AppMethodBeat.i(287474);
    com.tencent.mm.plugin.finder.live.utils.a locala = com.tencent.mm.plugin.finder.live.utils.a.yRm;
    if ((com.tencent.mm.plugin.finder.live.utils.a.dEy()) && (paramBoolean))
    {
      AppMethodBeat.o(287474);
      return true;
    }
    AppMethodBeat.o(287474);
    return false;
  }
  
  private final void pm(boolean paramBoolean)
  {
    AppMethodBeat.i(287480);
    TextView localTextView = this.yxf;
    if (localTextView == null) {
      p.bGy("orderTv");
    }
    Object localObject = com.tencent.mm.plugin.finder.live.utils.a.yRm;
    if (com.tencent.mm.plugin.finder.live.utils.a.dEy())
    {
      localObject = this.yxg;
      if (localObject == null) {
        p.bGy("orderIv");
      }
      ((WeImageView)localObject).setVisibility(8);
      if (paramBoolean) {
        localObject = "";
      }
    }
    for (localObject = (CharSequence)localObject;; localObject = (CharSequence)this.kiF.getContext().getString(b.j.finder_live_shopping_order))
    {
      localTextView.setText((CharSequence)localObject);
      AppMethodBeat.o(287480);
      return;
      localObject = this.kiF.getContext().getString(b.j.finder_live_shopping_add_goods);
      p.j(localObject, "root.context.getString(R…_live_shopping_add_goods)");
      break;
      localObject = this.yxg;
      if (localObject == null) {
        p.bGy("orderIv");
      }
      ((WeImageView)localObject).setVisibility(0);
    }
  }
  
  public final void a(Bundle paramBundle, final Object paramObject, final long paramLong)
  {
    AppMethodBeat.i(287490);
    if (paramBundle != null)
    {
      String str = paramBundle.getString("ACTION_POST_PORTRAIT", "");
      paramBundle = str;
      if (str != null) {}
    }
    else
    {
      paramBundle = "";
    }
    if (p.h(paramBundle, yxv))
    {
      com.tencent.mm.ae.d.a(paramLong, (Runnable)new r(this, paramObject, paramLong));
      AppMethodBeat.o(287490);
      return;
    }
    if (p.h(paramBundle, yxw)) {
      com.tencent.mm.ae.d.a(paramLong, (Runnable)new s(this, paramObject, paramLong));
    }
    AppMethodBeat.o(287490);
  }
  
  public final void dCG()
  {
    AppMethodBeat.i(287484);
    if ((!((com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.j.class)).yeB) || (com.tencent.mm.ae.d.dr(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).zfa, 16)) || (!((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).isLiveStarted()))
    {
      AppMethodBeat.o(287484);
      return;
    }
    long l = System.currentTimeMillis();
    if (l - this.yxq > 6000L)
    {
      this.yxq = l;
      if (!((com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.j.class)).ziG) {
        break label181;
      }
      this.yxp = false;
      dCH();
      if (this.yxr)
      {
        f.a.a(com.tencent.mm.plugin.findersdk.b.BuZ, "correctShoppingAvailableStatus", false, false, null, 28);
        this.yxr = false;
      }
    }
    for (;;)
    {
      Log.i(TAG, "checkShoppingAvailableAnchorStatus anchorProductsOnSale:" + ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.j.class)).ziG);
      AppMethodBeat.o(287484);
      return;
      label181:
      Object localObject = ah.yhC;
      localObject = ah.getFinderLiveAssistant();
      if (localObject != null)
      {
        Context localContext = this.kiF.getContext();
        if (localContext == null)
        {
          localObject = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
          AppMethodBeat.o(287484);
          throw ((Throwable)localObject);
        }
        ((an)localObject).a((MMActivity)localContext, ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.c)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.c.class)).liveInfo.liveId, ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.c)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.c.class)).xbk, ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).kig, ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.c)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.c.class)).kvN, (kotlin.g.a.b)cl.h.yxA);
      }
    }
  }
  
  public final void dCH()
  {
    AppMethodBeat.i(287485);
    Object localObject = com.tencent.mm.plugin.finder.live.utils.a.yRm;
    if ((!com.tencent.mm.plugin.finder.live.utils.a.dEy()) || (this.yxp))
    {
      AppMethodBeat.o(287485);
      return;
    }
    if (((com.tencent.mm.plugin.finder.live.viewmodel.data.business.c)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.c.class)).liveInfo.liveId == 0L)
    {
      AppMethodBeat.o(287485);
      return;
    }
    Log.i(TAG, "has notify visitor shopping:" + this.yxp);
    this.yxo += 1;
    if (this.yxo >= 3)
    {
      this.yxo = 0;
      AppMethodBeat.o(287485);
      return;
    }
    int i = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).zfa;
    localObject = ah.yhC;
    localObject = ah.getFinderLiveAssistant();
    if (localObject != null)
    {
      ((an)localObject).a(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.c)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.c.class)).liveInfo.liveId, ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.c)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.c.class)).xbk, i | 0x10, 2, (d.a)new q(this));
      AppMethodBeat.o(287485);
      return;
    }
    AppMethodBeat.o(287485);
  }
  
  public final boolean onBackPress()
  {
    AppMethodBeat.i(287470);
    if (this.kiF.getVisibility() == 0)
    {
      dCB();
      AppMethodBeat.o(287470);
      return true;
    }
    boolean bool = super.onBackPress();
    AppMethodBeat.o(287470);
    return bool;
  }
  
  public final void onClick(View paramView)
  {
    al localal = null;
    AppMethodBeat.i(287487);
    Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject1).bn(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/plugin/FinderLiveShoppingListPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).aFi());
    int i;
    if (paramView != null)
    {
      paramView = Integer.valueOf(paramView.getId());
      i = b.f.finder_live_shopping_list_close;
      if (paramView != null) {
        break label132;
      }
      label64:
      i = b.f.finder_shopping_list_blank_area;
      if (paramView != null) {
        break label147;
      }
      i = b.f.finder_live_shopping_list_order_group;
      if (paramView != null) {
        break label158;
      }
      label80:
      i = b.f.finder_live_shopping_list_retry_tip;
      if (paramView != null) {
        break label332;
      }
      label88:
      i = b.f.finder_live_shopping_list_empty_action;
      if (paramView != null) {
        break label349;
      }
      label96:
      i = b.f.finder_live_shopping_list_edit;
      if (paramView != null) {
        break label364;
      }
    }
    for (;;)
    {
      label104:
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/plugin/FinderLiveShoppingListPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(287487);
      return;
      paramView = null;
      break;
      label132:
      if (paramView.intValue() != i) {
        break label64;
      }
      for (;;)
      {
        dCB();
        break label104;
        label147:
        if (paramView.intValue() != i) {
          break;
        }
      }
      label158:
      if (paramView.intValue() != i) {
        break label80;
      }
      paramView = com.tencent.mm.plugin.finder.live.utils.a.yRm;
      if (com.tencent.mm.plugin.finder.live.utils.a.dEy())
      {
        dCI();
      }
      else
      {
        localObject1 = TAG;
        StringBuilder localStringBuilder = new StringBuilder("gotoShoppingOrder appId:");
        paramView = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.j.class)).ziI;
        if (paramView != null)
        {
          paramView = paramView.SLz;
          if (paramView == null) {}
        }
        for (paramView = paramView.appId;; paramView = null)
        {
          localStringBuilder = localStringBuilder.append(paramView).append(",path:");
          Object localObject2 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.j.class)).ziI;
          paramView = localal;
          if (localObject2 != null)
          {
            localObject2 = ((azy)localObject2).SLz;
            paramView = localal;
            if (localObject2 != null) {
              paramView = ((bln)localObject2).SWz;
            }
          }
          Log.i((String)localObject1, paramView);
          paramView = r.xWC;
          r.a(getBuContext(), (kotlin.g.a.m)new i(this));
          break;
        }
        label332:
        if (paramView.intValue() != i) {
          break label88;
        }
        b(null, true);
        continue;
        label349:
        if (paramView.intValue() != i) {
          break label96;
        }
        dCI();
        continue;
        label364:
        if (paramView.intValue() == i)
        {
          localal = this.yxs;
          paramView = localal;
          if (localal == null)
          {
            paramView = this.kiF.findViewById(b.f.finder_shopping_edit_area);
            p.j(paramView, "root.findViewById(R.id.finder_shopping_edit_area)");
            paramView = new al((ViewGroup)paramView, getBuContext(), this);
          }
          this.yxs = paramView;
          paramView = this.yxs;
          if (paramView != null) {
            al.a(paramView, true);
          }
        }
      }
    }
  }
  
  public final void onNewIntent(Intent paramIntent)
  {
    boolean bool = false;
    AppMethodBeat.i(287471);
    if (paramIntent != null) {
      bool = paramIntent.getBooleanExtra("extra_start_by_half_screen_empty_area_click_scene", false);
    }
    Log.i(TAG, "clickEmptyAreaClose = ".concat(String.valueOf(bool)));
    if (bool) {
      dCB();
    }
    AppMethodBeat.o(287471);
  }
  
  public final void statusChange(b.c paramc, Bundle paramBundle)
  {
    AppMethodBeat.i(287472);
    p.k(paramc, "status");
    switch (cm.$EnumSwitchMapping$0[paramc.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(287472);
      return;
      if (!((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).isLiveStarted())
      {
        paramc = com.tencent.mm.plugin.finder.live.utils.a.yRm;
        if ((!com.tencent.mm.plugin.finder.live.utils.a.dEy()) || (!((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).dGM())) {}
      }
      else
      {
        b(paramBundle, false);
      }
      paramc = com.tencent.mm.plugin.finder.live.utils.a.yRm;
      if (com.tencent.mm.plugin.finder.live.utils.a.dEy())
      {
        paramc = getBuContext();
        paramBundle = new JSONObject();
        paramBundle.put("type", s.ah.yIw.action);
        k localk = k.yBj;
        paramBundle.put("sessionid", k.dDm().yCW);
        paramBundle.put("shopwindowid", "");
        if (((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)paramc.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).dGM())
        {
          paramc = k.yBj;
          k.t(s.a.yDO.jWO, paramBundle.toString());
          AppMethodBeat.o(287472);
          return;
        }
        long l;
        if (((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)paramc.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).isLiveStarted())
        {
          paramc = k.yBj;
          if (k.dDm().yDA) {
            paramBundle.put("type", s.ah.yID.action);
          }
          paramc = com.tencent.mm.plugin.finder.live.model.context.a.ykr;
          paramc = com.tencent.mm.plugin.finder.live.model.context.a.dAc();
          if (paramc == null) {
            break label461;
          }
          paramc = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)paramc.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.j.class);
          if (paramc == null) {
            break label461;
          }
          paramc = paramc.ziN;
          paramBundle.put("appid", paramc);
          paramc = com.tencent.mm.plugin.finder.live.model.context.a.ykr;
          paramc = com.tencent.mm.plugin.finder.live.model.context.a.dAc();
          if (paramc == null) {
            break label466;
          }
          paramc = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.c)paramc.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.c.class);
          if (paramc == null) {
            break label466;
          }
          paramc = paramc.liveInfo;
          if (paramc == null) {
            break label466;
          }
          l = paramc.liveId;
          label343:
          if (l >= 0L) {
            break label473;
          }
          paramBundle.put("liveid", "");
          label360:
          paramc = com.tencent.mm.plugin.expt.hellhound.a.b.b.c.wkV;
          paramBundle.put("clickid", com.tencent.mm.plugin.expt.hellhound.a.b.b.c.ddF());
          paramc = com.tencent.mm.plugin.expt.hellhound.a.b.b.c.wkV;
          c.a.axD("");
          paramc = com.tencent.mm.plugin.finder.live.model.context.a.ykr;
          paramc = com.tencent.mm.plugin.finder.live.model.context.a.dAc();
          if (paramc == null) {
            break label488;
          }
          paramc = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)paramc.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.j.class);
          if (paramc == null) {
            break label488;
          }
          paramc = paramc.ziK;
          if (paramc == null) {
            break label488;
          }
        }
        label461:
        label466:
        label473:
        label488:
        for (paramc = Long.valueOf(paramc.mf());; paramc = "")
        {
          paramBundle.put("productid", paramc);
          paramc = k.yBj;
          k.a(s.c.yEp, paramBundle.toString());
          AppMethodBeat.o(287472);
          return;
          paramc = null;
          break;
          l = -1L;
          break label343;
          paramBundle.put("liveid", com.tencent.mm.plugin.expt.hellhound.core.b.Fw(l));
          break label360;
        }
      }
      com.tencent.mm.plugin.finder.live.report.m.a(com.tencent.mm.plugin.finder.live.report.m.yCt, s.bi.yLQ, null, null);
      AppMethodBeat.o(287472);
      return;
      tU(8);
      paramc = com.tencent.mm.plugin.finder.live.utils.a.yRm;
      if (!com.tencent.mm.plugin.finder.live.utils.a.dEy())
      {
        com.tencent.mm.plugin.finder.live.report.m.a(com.tencent.mm.plugin.finder.live.report.m.yCt, s.bi.yLX, null, null);
        AppMethodBeat.o(287472);
        return;
        ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.j.class)).dHk();
        tU(8);
        AppMethodBeat.o(287472);
        return;
        this.yxl.c(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.j.class)).ziK);
        AppMethodBeat.o(287472);
        return;
        Log.i(TAG, "refresh shop page,view visibility:" + this.kiF.getVisibility());
        b(paramBundle, true);
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "bundle", "Lcom/tencent/mm/plugin/appbrand/api/WeAppOpenBundle;", "invoke", "com/tencent/mm/plugin/finder/live/plugin/FinderLiveShoppingListPlugin$1$1"})
  static final class a
    extends kotlin.g.b.q
    implements kotlin.g.a.b<g, kotlin.x>
  {
    a(cl paramcl)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "empty", "", "invoke", "com/tencent/mm/plugin/finder/live/plugin/FinderLiveShoppingListPlugin$1$2"})
  static final class b
    extends kotlin.g.b.q
    implements kotlin.g.a.b<Boolean, kotlin.x>
  {
    b(cl paramcl)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "promting", "", "invoke", "com/tencent/mm/plugin/finder/live/plugin/FinderLiveShoppingListPlugin$1$3"})
  static final class c
    extends kotlin.g.b.q
    implements kotlin.g.a.b<Boolean, kotlin.x>
  {
    c(cl paramcl)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "holder", "Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveShoppingListAdapter$ShoppingViewHolder;", "Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveShoppingListAdapter;", "itemView", "Landroid/view/View;", "pos", "", "invoke", "com/tencent/mm/plugin/finder/live/plugin/FinderLiveShoppingListPlugin$1$4"})
  static final class d
    extends kotlin.g.b.q
    implements kotlin.g.a.q<x.b, View, Integer, kotlin.x>
  {
    d(com.tencent.mm.plugin.finder.live.view.adapter.x paramx, cl paramcl)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "productId", "", "invoke", "com/tencent/mm/plugin/finder/live/plugin/FinderLiveShoppingListPlugin$1$5"})
  static final class e
    extends kotlin.g.b.q
    implements kotlin.g.a.b<Long, kotlin.x>
  {
    e(cl paramcl)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveShoppingListPlugin$Companion;", "", "()V", "CHECKING_INTERVAL", "", "NOTIFY_VISITOR_SHOPPING_THRESHOLD", "PORTRAIT_ACTION_FULL_SCREEN_MINIPRO", "", "getPORTRAIT_ACTION_FULL_SCREEN_MINIPRO", "()Ljava/lang/String;", "PORTRAIT_ACTION_HALF_SCREEN_MINIPRO", "getPORTRAIT_ACTION_HALF_SCREEN_MINIPRO", "TAG", "getTAG", "plugin-finder_release"})
  public static final class f {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "<anonymous parameter 0>", "", "bundle", "Lcom/tencent/mm/plugin/appbrand/api/WeAppOpenBundle;", "invoke"})
  static final class g
    extends kotlin.g.b.q
    implements kotlin.g.a.m<Boolean, g, kotlin.x>
  {
    g(cl paramcl)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "<anonymous parameter 0>", "", "bundle", "Lcom/tencent/mm/plugin/appbrand/api/WeAppOpenBundle;", "invoke"})
  static final class i
    extends kotlin.g.b.q
    implements kotlin.g.a.m<Boolean, g, kotlin.x>
  {
    i(cl paramcl)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/live/plugin/FinderLiveShoppingListPlugin$hideMaskView$1", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-finder_release"})
  public static final class j
    implements Animator.AnimatorListener
  {
    public final void onAnimationCancel(Animator paramAnimator) {}
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(291990);
      b.b.a(cl.c(this.yxy), b.c.kAm);
      AppMethodBeat.o(291990);
    }
    
    public final void onAnimationRepeat(Animator paramAnimator) {}
    
    public final void onAnimationStart(Animator paramAnimator) {}
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class k
    implements Runnable
  {
    k(cl paramcl) {}
    
    public final void run()
    {
      AppMethodBeat.i(266173);
      cl.d(this.yxy).hide();
      AppMethodBeat.o(266173);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/live/plugin/FinderLiveShoppingListPlugin$initLandscapeLogic$1$1", "Landroidx/recyclerview/widget/RecyclerView$OnItemTouchListener;", "onInterceptTouchEvent", "", "rv", "Landroidx/recyclerview/widget/RecyclerView;", "motionEvent", "Landroid/view/MotionEvent;", "onRequestDisallowInterceptTouchEvent", "", "p0", "onTouchEvent", "p1", "plugin-finder_release"})
  public static final class l
    implements RecyclerView.k
  {
    l(cl paramcl) {}
    
    public final boolean a(RecyclerView paramRecyclerView, MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(284022);
      p.k(paramRecyclerView, "rv");
      p.k(paramMotionEvent, "motionEvent");
      cl.a(this.yxy)[0] = ((int)paramMotionEvent.getRawX());
      cl.a(this.yxy)[1] = ((int)paramMotionEvent.getRawY());
      paramRecyclerView = aj.AGc;
      if (aj.eej())
      {
        paramRecyclerView = cl.yxx;
        Log.i(cl.access$getTAG$cp(), "recyclerView, onTouchEvent() (%s, %s)", new Object[] { Integer.valueOf(cl.a(this.yxy)[0]), Integer.valueOf(cl.a(this.yxy)[1]) });
      }
      AppMethodBeat.o(284022);
      return false;
    }
    
    public final void ao(boolean paramBoolean) {}
    
    public final void b(RecyclerView paramRecyclerView, MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(284021);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramRecyclerView);
      localb.bn(paramMotionEvent);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/plugin/FinderLiveShoppingListPlugin$initLandscapeLogic$$inlined$apply$lambda$1", "androidx/recyclerview/widget/RecyclerView$OnItemTouchListener", "onTouchEvent", "(Landroidx/recyclerview/widget/RecyclerView;Landroid/view/MotionEvent;)V", this, localb.aFi());
      p.k(paramRecyclerView, "p0");
      p.k(paramMotionEvent, "p1");
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/plugin/FinderLiveShoppingListPlugin$initLandscapeLogic$$inlined$apply$lambda$1", "androidx/recyclerview/widget/RecyclerView$OnItemTouchListener", "onTouchEvent", "(Landroidx/recyclerview/widget/RecyclerView;Landroid/view/MotionEvent;)V");
      AppMethodBeat.o(284021);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "isShow", "", "invoke", "com/tencent/mm/plugin/finder/live/plugin/FinderLiveShoppingListPlugin$initLandscapeLogic$2$1"})
  static final class m
    extends kotlin.g.b.q
    implements kotlin.g.a.b<Boolean, kotlin.x>
  {
    m(cl paramcl)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/live/plugin/FinderLiveShoppingListPlugin$initPortraitLogic$1$1", "Landroidx/recyclerview/widget/RecyclerView$OnItemTouchListener;", "onInterceptTouchEvent", "", "rv", "Landroidx/recyclerview/widget/RecyclerView;", "motionEvent", "Landroid/view/MotionEvent;", "onRequestDisallowInterceptTouchEvent", "", "p0", "onTouchEvent", "p1", "plugin-finder_release"})
  public static final class n
    implements RecyclerView.k
  {
    n(cl paramcl, int paramInt) {}
    
    public final boolean a(RecyclerView paramRecyclerView, MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(276896);
      p.k(paramRecyclerView, "rv");
      p.k(paramMotionEvent, "motionEvent");
      cl.a(this.yxy)[0] = ((int)paramMotionEvent.getRawX());
      cl.a(this.yxy)[1] = ((int)paramMotionEvent.getRawY());
      paramRecyclerView = aj.AGc;
      if (aj.eej())
      {
        paramRecyclerView = cl.yxx;
        Log.i(cl.access$getTAG$cp(), "recyclerView, onTouchEvent() (%s, %s)", new Object[] { Integer.valueOf(cl.a(this.yxy)[0]), Integer.valueOf(cl.a(this.yxy)[1]) });
      }
      AppMethodBeat.o(276896);
      return false;
    }
    
    public final void ao(boolean paramBoolean) {}
    
    public final void b(RecyclerView paramRecyclerView, MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(276895);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramRecyclerView);
      localb.bn(paramMotionEvent);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/plugin/FinderLiveShoppingListPlugin$initPortraitLogic$$inlined$apply$lambda$1", "androidx/recyclerview/widget/RecyclerView$OnItemTouchListener", "onTouchEvent", "(Landroidx/recyclerview/widget/RecyclerView;Landroid/view/MotionEvent;)V", this, localb.aFi());
      p.k(paramRecyclerView, "p0");
      p.k(paramMotionEvent, "p1");
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/plugin/FinderLiveShoppingListPlugin$initPortraitLogic$$inlined$apply$lambda$1", "androidx/recyclerview/widget/RecyclerView$OnItemTouchListener", "onTouchEvent", "(Landroidx/recyclerview/widget/RecyclerView;Landroid/view/MotionEvent;)V");
      AppMethodBeat.o(276895);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "isShow", "", "invoke", "com/tencent/mm/plugin/finder/live/plugin/FinderLiveShoppingListPlugin$initPortraitLogic$2$1"})
  static final class o
    extends kotlin.g.b.q
    implements kotlin.g.a.b<Boolean, kotlin.x>
  {
    o(cl paramcl, int paramInt)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "success", "", "<anonymous parameter 1>", "Lcom/tencent/mm/protocal/protobuf/FinderLiveModShopShelfResponse;", "invoke"})
  public static final class p
    extends kotlin.g.b.q
    implements kotlin.g.a.m<Boolean, bbc, kotlin.x>
  {
    public p(cl paramcl)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/live/plugin/FinderLiveShoppingListPlugin$notifyVisitorShopping$1", "Lcom/tencent/mm/plugin/finder/live/cgi/CgiFinderLiveAnchorStatus$CallBack;", "onFail", "", "errType", "", "errCode", "errMsg", "", "anchorStatus", "onSuccess", "micSettingFlag", "", "plugin-finder_release"})
  public static final class q
    implements d.a
  {
    public final void ai(int paramInt, long paramLong)
    {
      AppMethodBeat.i(273868);
      cl.i(this.yxy);
      cl.f localf = cl.yxx;
      Log.i(cl.access$getTAG$cp(), "notify visitor shopping success times:" + cl.j(this.yxy));
      AppMethodBeat.o(273868);
    }
    
    public final void b(int paramInt1, int paramInt2, String paramString, int paramInt3)
    {
      AppMethodBeat.i(273869);
      paramString = cl.yxx;
      Log.i(cl.access$getTAG$cp(), "notify visitor shopping fail times:" + cl.j(this.yxy));
      this.yxy.dCH();
      AppMethodBeat.o(273869);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class r
    implements Runnable
  {
    r(cl paramcl, Object paramObject, long paramLong) {}
    
    public final void run()
    {
      AppMethodBeat.i(229014);
      if (!this.yxy.isFinished())
      {
        Object localObject2 = paramObject;
        localObject1 = localObject2;
        if (!(localObject2 instanceof g)) {
          localObject1 = null;
        }
        if ((g)localObject1 != null)
        {
          cl.b(this.yxy, (g)paramObject);
          AppMethodBeat.o(229014);
          return;
        }
        AppMethodBeat.o(229014);
        return;
      }
      Object localObject1 = cl.yxx;
      Log.i(cl.access$getTAG$cp(), "openFullScreenMiniprogramImpl delayMs:" + paramLong + ",isFinished!");
      AppMethodBeat.o(229014);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class s
    implements Runnable
  {
    s(cl paramcl, Object paramObject, long paramLong) {}
    
    public final void run()
    {
      AppMethodBeat.i(228155);
      if (!this.yxy.isFinished())
      {
        Object localObject2 = paramObject;
        localObject1 = localObject2;
        if (!(localObject2 instanceof g)) {
          localObject1 = null;
        }
        if ((g)localObject1 != null)
        {
          cl.c(this.yxy, (g)paramObject);
          AppMethodBeat.o(228155);
          return;
        }
        AppMethodBeat.o(228155);
        return;
      }
      Object localObject1 = cl.yxx;
      Log.i(cl.access$getTAG$cp(), "openHalfScreenMiniprogramImpl delayMs:" + paramLong + ",isFinished!");
      AppMethodBeat.o(228155);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class t
    implements Runnable
  {
    t(cl paramcl) {}
    
    public final void run()
    {
      AppMethodBeat.i(287982);
      cl.d(this.yxy).show();
      AppMethodBeat.o(287982);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/live/plugin/FinderLiveShoppingListPlugin$showProductList$1", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "onGlobalLayout", "", "plugin-finder_release"})
  public static final class u
    implements ViewTreeObserver.OnGlobalLayoutListener
  {
    u(int paramInt) {}
    
    public final void onGlobalLayout()
    {
      AppMethodBeat.i(264962);
      cl.g(this.yxy).getViewTreeObserver().removeOnGlobalLayoutListener((ViewTreeObserver.OnGlobalLayoutListener)this);
      RecyclerView.LayoutManager localLayoutManager = cl.g(this.yxy).getLayoutManager();
      Object localObject = localLayoutManager;
      if (!(localLayoutManager instanceof LinearLayoutManager)) {
        localObject = null;
      }
      localObject = (LinearLayoutManager)localObject;
      if (localObject != null) {
        ((LinearLayoutManager)localObject).au(i, 0);
      }
      localObject = cl.yxx;
      Log.i(cl.access$getTAG$cp(), "showProductList size:" + cl.h(this.yxy).yZv.size() + ",scrollToPosition:" + i);
      AppMethodBeat.o(264962);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "success", "", "invoke"})
  static final class v
    extends kotlin.g.b.q
    implements kotlin.g.a.b<Boolean, kotlin.x>
  {
    v(cl paramcl, boolean paramBoolean1, Bundle paramBundle, boolean paramBoolean2)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class w
    implements Runnable
  {
    w(cl paramcl) {}
    
    public final void run()
    {
      AppMethodBeat.i(276928);
      cl.d(this.yxy).show();
      AppMethodBeat.o(276928);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.plugin.cl
 * JD-Core Version:    0.7.0.1
 */