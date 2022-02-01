package com.tencent.mm.plugin.finder.live.plugin;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
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
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewPropertyAnimator;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout.LayoutParams;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.b;
import androidx.recyclerview.widget.RecyclerView.k;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.live.b.b.c;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.appbrand.api.g;
import com.tencent.mm.plugin.finder.live.l;
import com.tencent.mm.plugin.finder.live.model.aj;
import com.tencent.mm.plugin.finder.live.model.ap;
import com.tencent.mm.plugin.finder.live.model.ap.a;
import com.tencent.mm.plugin.finder.live.p.b;
import com.tencent.mm.plugin.finder.live.p.c;
import com.tencent.mm.plugin.finder.live.p.d;
import com.tencent.mm.plugin.finder.live.p.e;
import com.tencent.mm.plugin.finder.live.p.f;
import com.tencent.mm.plugin.finder.live.p.g;
import com.tencent.mm.plugin.finder.live.p.h;
import com.tencent.mm.plugin.finder.live.report.q.a;
import com.tencent.mm.plugin.finder.live.report.q.as;
import com.tencent.mm.plugin.finder.live.report.q.bx;
import com.tencent.mm.plugin.finder.live.report.q.c;
import com.tencent.mm.plugin.finder.live.view.FinderLiveShoppingPriceView.b;
import com.tencent.mm.plugin.finder.live.view.FinderLiveVisitorPluginLayout;
import com.tencent.mm.plugin.finder.live.view.adapter.ac;
import com.tencent.mm.plugin.finder.live.view.adapter.ae;
import com.tencent.mm.plugin.finder.live.view.adapter.af;
import com.tencent.mm.plugin.finder.live.view.adapter.ag;
import com.tencent.mm.plugin.finder.live.view.adapter.holder.b.a;
import com.tencent.mm.plugin.finder.live.view.convert.i;
import com.tencent.mm.plugin.finder.live.viewmodel.data.business.e;
import com.tencent.mm.plugin.finder.live.widget.FinderLiveShoppingCouponView;
import com.tencent.mm.plugin.finder.live.widget.FinderLiveShoppingCouponView.a;
import com.tencent.mm.plugin.finder.live.widget.FinderLiveShoppingPanel;
import com.tencent.mm.plugin.finder.model.cc;
import com.tencent.mm.plugin.findersdk.a.e;
import com.tencent.mm.protocal.protobuf.aka;
import com.tencent.mm.protocal.protobuf.auw;
import com.tencent.mm.protocal.protobuf.bih;
import com.tencent.mm.protocal.protobuf.bip;
import com.tencent.mm.protocal.protobuf.bir;
import com.tencent.mm.protocal.protobuf.bjz;
import com.tencent.mm.protocal.protobuf.bkd;
import com.tencent.mm.protocal.protobuf.blp;
import com.tencent.mm.protocal.protobuf.bms;
import com.tencent.mm.protocal.protobuf.buh;
import com.tencent.mm.protocal.protobuf.bui;
import com.tencent.mm.protocal.protobuf.bvg;
import com.tencent.mm.protocal.protobuf.bvo;
import com.tencent.mm.protocal.protobuf.bzd;
import com.tencent.mm.protocal.protobuf.dzi;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.bf;
import com.tencent.mm.ui.widget.MMSwitchBtn;
import com.tencent.mm.ui.widget.MMSwitchBtn.a;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.m;
import kotlin.g.b.ah.f;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlinx.coroutines.bg;
import kotlinx.coroutines.bu;
import kotlinx.coroutines.cb;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveShoppingListPlugin;", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;", "Landroid/view/View$OnClickListener;", "root", "Landroid/view/ViewGroup;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "MAX_PREHOT_SIZE", "", "blankArea", "Landroid/view/View;", "bundles", "Ljava/util/HashMap;", "", "Lcom/tencent/mm/plugin/appbrand/api/WeAppOpenBundle;", "Lkotlin/collections/HashMap;", "getBundles", "()Ljava/util/HashMap;", "close", "closeIv", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "contentGroup", "Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveShoppingPanel;", "couponList", "Landroidx/recyclerview/widget/RecyclerView;", "couponListAdapter", "Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveShoppingCouponListAdapter;", "emptyAction", "Landroid/widget/TextView;", "emptyGroup", "emptyTips", "hasNotifyVisitorShopping", "", "hasScrolledToPromotingProduct", "loadingBar", "Landroid/widget/ProgressBar;", "maskHideAnim", "Landroid/animation/ObjectAnimator;", "maskShowAnim", "maskView", "notifyVisitorShoppingTimes", "onItemTouchListener", "Landroidx/recyclerview/widget/RecyclerView$OnItemTouchListener;", "optionView", "orderGroup", "orderIv", "orderTv", "productsTitle", "retryTip", "secondaryGoodsList", "secondaryPageContainer", "Landroid/widget/FrameLayout;", "serviceGoodsListAdapter", "Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveShoppingSecondaryServiceGoodsListAdapter;", "serviceGroup", "serviceIv", "serviceTv", "shoppingList", "getShoppingList$plugin_finder_live_release", "()Landroidx/recyclerview/widget/RecyclerView;", "setShoppingList$plugin_finder_live_release", "(Landroidx/recyclerview/widget/RecyclerView;)V", "shoppingListAdapter", "Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveShoppingListAdapter;", "titleGroup", "touchLoc", "", "addProduct", "", "animateShowCouponList", "checkShoppingAvailableAnchorStatus", "checkShowServiceButton", "enterShoppingService", "showListDirectly", "getShoppingListData", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "getShoppingPriceViewConfig", "Lcom/tencent/mm/plugin/finder/live/view/FinderLiveShoppingPriceView$Config;", "gotoShoppingOrder", "hideMaskView", "hideSecondaryPage", "animate", "hideShoppingContent", "initLandscapeShoppingList", "initListener", "initLogic", "initPortraitShoppingList", "initShoppingListAdapter", "initView", "isAnchorAddProduct", "checkProductFirst", "isAnchorOrAssistant", "isAssistant", "managerProduct", "modProductReplaySetting", "switch", "type", "callback", "Lkotlin/Function3;", "modifyShoppingContent", "allList", "", "", "delete", "mount", "notifyVisitorShopping", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onBackPress", "onClick", "v", "onClickReplayOptionView", "onClickShoppingService", "onGetShoppingListFail", "onGetShoppingListSuccess", "info", "Landroid/os/Bundle;", "refresh", "onNewIntent", "intent", "onPortraitDelayAction", "extraMsg", "extraData", "", "delayMs", "openFullScreenMiniprogram", "bundle", "openFullScreenMiniprogramImpl", "openHalfScreenMiniprogram", "openHalfScreenMiniprogramImpl", "prehotMiniprogram", "products", "reportAnchor", "it", "Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;", "reportAnchorAddProduct", "reportExposed", "rv", "reportWhenAddProduct", "setMainListTopButton", "isHidingSecondaryPage", "setTitle", "title", "showCanUseCouponProductList", "showEmptyShoppingPanel", "showGoodsEmptyContent", "showMaskView", "showProductList", "productList", "showSecondaryPage", "directly", "showServiceGoodsList", "showShoppingContent", "pullScene", "showShoppingLoading", "statusChange", "status", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "param", "unMount", "uninitListener", "uninitShoppingListAdapter", "updateEmptyTipsPosition", "updatePromotingCouponItem", "Companion", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class bz
  extends b
  implements View.OnClickListener
{
  public static final bz.a Djh;
  private static final String TAG;
  private int[] Cxl;
  private View DeW;
  private ag DjA;
  private ObjectAnimator DjB;
  private ObjectAnimator DjC;
  private int DjD;
  private boolean DjE;
  private boolean DjF;
  private RecyclerView.k DjG;
  private final int DjH;
  private final HashMap<String, g> DjI;
  private FinderLiveShoppingPanel Dji;
  private WeImageView Djj;
  private View Djk;
  private TextView Djl;
  private WeImageView Djm;
  private View Djn;
  private TextView Djo;
  private WeImageView Djp;
  public RecyclerView Djq;
  private TextView Djr;
  private TextView Djs;
  private TextView Djt;
  private FrameLayout Dju;
  private RecyclerView Djv;
  private RecyclerView Djw;
  private View Djx;
  private ae Djy;
  private ac Djz;
  private View maskView;
  private final com.tencent.mm.live.b.b nfT;
  private View niW;
  private TextView njg;
  private ProgressBar njj;
  private View njm;
  private View yls;
  
  static
  {
    AppMethodBeat.i(355312);
    Djh = new bz.a((byte)0);
    TAG = "Finder.LiveShoppingListPlugin";
    AppMethodBeat.o(355312);
  }
  
  public bz(ViewGroup paramViewGroup, com.tencent.mm.live.b.b paramb)
  {
    super(paramViewGroup, paramb);
    AppMethodBeat.i(354310);
    this.nfT = paramb;
    paramb = paramViewGroup.getContext();
    s.s(paramb, "root.context");
    boolean bool;
    if (this.nfT.getLiveRole() == 1) {
      bool = true;
    }
    RecyclerView localRecyclerView;
    int i;
    for (;;)
    {
      this.Djy = new ae(paramb, bool, getBuContext());
      paramb = paramViewGroup.getContext();
      s.s(paramb, "root.context");
      if (this.nfT.getLiveRole() == 1)
      {
        bool = true;
        this.Djz = new ac(paramb, bool, getBuContext());
        paramViewGroup = paramViewGroup.getContext();
        s.s(paramViewGroup, "root.context");
        this.DjA = new ag(paramViewGroup, this.nfT, this, getBuContext());
        this.Cxl = new int[2];
        paramViewGroup = this.mJe.findViewById(p.e.BSF);
        s.s(paramViewGroup, "root.findViewById(R.id.finder_live_shopping_mask)");
        this.maskView = paramViewGroup;
        paramViewGroup = this.mJe.findViewById(p.e.BUG);
        s.s(paramViewGroup, "root.findViewById(R.id.f…shopping_list_blank_area)");
        this.niW = paramViewGroup;
        paramViewGroup = this.mJe.findViewById(p.e.BUH);
        s.s(paramViewGroup, "root.findViewById(R.id.f…opping_list_content_area)");
        this.Dji = ((FinderLiveShoppingPanel)paramViewGroup);
        paramViewGroup = this.mJe.findViewById(p.e.BSE);
        s.s(paramViewGroup, "root.findViewById(R.id.f…hopping_list_title_group)");
        this.njm = paramViewGroup;
        paramViewGroup = this.mJe.findViewById(p.e.BSm);
        s.s(paramViewGroup, "root.findViewById(R.id.f…live_shopping_list_close)");
        this.yls = paramViewGroup;
        paramViewGroup = this.mJe.findViewById(p.e.BSn);
        s.s(paramViewGroup, "root.findViewById(R.id.f…e_shopping_list_close_iv)");
        this.Djj = ((WeImageView)paramViewGroup);
        paramViewGroup = this.mJe.findViewById(p.e.BSv);
        s.s(paramViewGroup, "root.findViewById(R.id.f…hopping_list_order_group)");
        this.Djk = paramViewGroup;
        paramViewGroup = this.mJe.findViewById(p.e.BSx);
        s.s(paramViewGroup, "root.findViewById(R.id.f…e_shopping_list_order_tv)");
        this.Djl = ((TextView)paramViewGroup);
        paramViewGroup = this.mJe.findViewById(p.e.BSw);
        s.s(paramViewGroup, "root.findViewById(R.id.f…e_shopping_list_order_iv)");
        this.Djm = ((WeImageView)paramViewGroup);
        paramViewGroup = this.mJe.findViewById(p.e.BSA);
        s.s(paramViewGroup, "root.findViewById(R.id.f…pping_list_service_group)");
        this.Djn = paramViewGroup;
        paramViewGroup = this.mJe.findViewById(p.e.BSC);
        s.s(paramViewGroup, "root.findViewById(R.id.f…shopping_list_service_tv)");
        this.Djo = ((TextView)paramViewGroup);
        paramViewGroup = this.mJe.findViewById(p.e.BSB);
        s.s(paramViewGroup, "root.findViewById(R.id.f…shopping_list_service_iv)");
        this.Djp = ((WeImageView)paramViewGroup);
        paramViewGroup = this.mJe.findViewById(p.e.BSo);
        s.s(paramViewGroup, "root.findViewById(R.id.f…ve_shopping_list_content)");
        paramViewGroup = (RecyclerView)paramViewGroup;
        s.u(paramViewGroup, "<set-?>");
        this.Djq = paramViewGroup;
      }
      try
      {
        com.tencent.mm.view.f.a(erY(), (com.tencent.mm.view.e.a)new w(this));
        paramViewGroup = this.mJe.findViewById(p.e.BSt);
        s.s(paramViewGroup, "root.findViewById(R.id.f…ve_shopping_list_loading)");
        this.njj = ((ProgressBar)paramViewGroup);
        paramViewGroup = this.mJe.findViewById(p.e.BSy);
        s.s(paramViewGroup, "root.findViewById(R.id.f…_shopping_list_retry_tip)");
        this.njg = ((TextView)paramViewGroup);
        paramViewGroup = this.mJe.findViewById(p.e.BSq);
        s.s(paramViewGroup, "root.findViewById(R.id.f…hopping_list_empty_group)");
        this.DeW = paramViewGroup;
        paramViewGroup = this.mJe.findViewById(p.e.BSr);
        s.s(paramViewGroup, "root.findViewById(R.id.f…_shopping_list_empty_tip)");
        this.Djr = ((TextView)paramViewGroup);
        paramViewGroup = this.mJe.findViewById(p.e.BSp);
        s.s(paramViewGroup, "root.findViewById(R.id.f…opping_list_empty_action)");
        this.Djs = ((TextView)paramViewGroup);
        paramViewGroup = this.mJe.findViewById(p.e.BSD);
        s.s(paramViewGroup, "root.findViewById(R.id.f…live_shopping_list_title)");
        this.Djt = ((TextView)paramViewGroup);
        paramViewGroup = this.mJe.findViewById(p.e.BSH);
        s.s(paramViewGroup, "root.findViewById(R.id.f…secondary_page_container)");
        this.Dju = ((FrameLayout)paramViewGroup);
        paramViewGroup = this.mJe.findViewById(p.e.BSk);
        s.s(paramViewGroup, "root.findViewById(R.id.f…ping_coupon_list_content)");
        this.Djv = ((RecyclerView)paramViewGroup);
        paramViewGroup = this.mJe.findViewById(p.e.BSG);
        s.s(paramViewGroup, "root.findViewById(R.id.f…ndary_goods_list_content)");
        this.Djw = ((RecyclerView)paramViewGroup);
        this.Djx = this.mJe.findViewById(p.e.BSu);
        erZ();
        if (!isLandscape()) {
          break label1323;
        }
        localRecyclerView = erY();
        this.mJe.getContext();
        localRecyclerView.setLayoutManager((RecyclerView.LayoutManager)new LinearLayoutManager(1, false));
        localRecyclerView.setAdapter((RecyclerView.a)this.Djy);
        paramb = this.njm;
        paramViewGroup = paramb;
        if (paramb == null)
        {
          s.bIx("titleGroup");
          paramViewGroup = null;
        }
        paramViewGroup = paramViewGroup.getLayoutParams();
        if (paramViewGroup != null)
        {
          paramViewGroup = Integer.valueOf(paramViewGroup.height);
          if (((Number)paramViewGroup).intValue() > 0)
          {
            i = 1;
            if (i == 0) {
              break label1229;
            }
            if (paramViewGroup != null) {
              break label1234;
            }
            i = MMApplicationContext.getContext().getResources().getDimensionPixelOffset(p.c.Edge_8A);
            localRecyclerView.getLayoutParams().height = (bf.bf(this.mJe.getContext()).y - i);
            Log.i(TAG, "initLandscapeShoppingList,titleGroupHeight:" + i + ", shoppingList height:" + localRecyclerView.getLayoutParams().height);
            paramb = this.Dju;
            paramViewGroup = paramb;
            if (paramb == null)
            {
              s.bIx("secondaryPageContainer");
              paramViewGroup = null;
            }
            paramViewGroup.getLayoutParams().height = erY().getLayoutParams().height;
            paramViewGroup = this.Djv;
            if (paramViewGroup != null) {
              break label1243;
            }
            s.bIx("couponList");
            paramViewGroup = null;
            this.mJe.getContext();
            paramViewGroup.setLayoutManager((RecyclerView.LayoutManager)new LinearLayoutManager(1, false));
            paramViewGroup.setAdapter((RecyclerView.a)this.Djz);
            paramViewGroup.getLayoutParams().height = erY().getLayoutParams().height;
            paramViewGroup = this.Djw;
            if (paramViewGroup != null) {
              break label1246;
            }
            s.bIx("secondaryGoodsList");
            paramViewGroup = null;
            this.mJe.getContext();
            paramViewGroup.setLayoutManager((RecyclerView.LayoutManager)new LinearLayoutManager(1, false));
            paramViewGroup.getLayoutParams().height = erY().getLayoutParams().height;
            paramb = this.Dji;
            paramViewGroup = paramb;
            if (paramb == null)
            {
              s.bIx("contentGroup");
              paramViewGroup = null;
            }
            paramViewGroup.setTranslationX(bf.bf(this.mJe.getContext()).y);
            paramb = this.Dji;
            paramViewGroup = paramb;
            if (paramb == null)
            {
              s.bIx("contentGroup");
              paramViewGroup = null;
            }
            paramViewGroup = paramViewGroup.getLayoutParams();
            if (paramViewGroup != null) {
              break label1249;
            }
            paramViewGroup = new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
            AppMethodBeat.o(354310);
            throw paramViewGroup;
            bool = false;
            continue;
            bool = false;
          }
        }
      }
      catch (Exception paramViewGroup)
      {
        label1229:
        label1234:
        label1243:
        label1246:
        for (;;)
        {
          paramb = com.tencent.mm.plugin.finder.utils.aw.Gjk;
          com.tencent.mm.plugin.finder.utils.aw.a(paramViewGroup, TAG);
          continue;
          i = 0;
          continue;
          paramViewGroup = null;
          continue;
          i = paramViewGroup.intValue();
          continue;
        }
        label1249:
        ((ConstraintLayout.LayoutParams)paramViewGroup).width = bf.bf(this.mJe.getContext()).y;
      }
    }
    paramViewGroup = this.Djt;
    if (paramViewGroup == null)
    {
      s.bIx("productsTitle");
      paramViewGroup = localObject;
    }
    for (;;)
    {
      com.tencent.mm.ui.aw.a((Paint)paramViewGroup.getPaint(), 0.8F);
      this.DjH = 3;
      this.DjI = new HashMap();
      AppMethodBeat.o(354310);
      return;
      label1323:
      float f = bf.bf(MMApplicationContext.getContext()).y;
      paramViewGroup = com.tencent.d.a.a.a.a.a.ahiX;
      int j = (int)(f * (com.tencent.d.a.a.a.a.a.jTt() / 100.0F));
      localRecyclerView = erY();
      this.mJe.getContext();
      localRecyclerView.setLayoutManager((RecyclerView.LayoutManager)new LinearLayoutManager(1, false));
      localRecyclerView.setAdapter((RecyclerView.a)this.Djy);
      paramb = this.njm;
      paramViewGroup = paramb;
      if (paramb == null)
      {
        s.bIx("titleGroup");
        paramViewGroup = null;
      }
      paramViewGroup = paramViewGroup.getLayoutParams();
      if (paramViewGroup != null)
      {
        paramViewGroup = Integer.valueOf(paramViewGroup.height);
        if (((Number)paramViewGroup).intValue() > 0)
        {
          i = 1;
          label1443:
          if (i == 0) {
            break label1798;
          }
          label1448:
          if (paramViewGroup != null) {
            break label1803;
          }
          i = MMApplicationContext.getContext().getResources().getDimensionPixelOffset(p.c.Edge_8A);
          label1466:
          int k = bf.bk(this.mJe.getContext());
          localRecyclerView.getLayoutParams().height = (j - i - k);
          Log.i(TAG, "initPortraitShoppingList,panelHeight:" + j + ", titleGroupHeight:" + i + ",navigationBarHeight:" + k + ",shoppingList height:" + localRecyclerView.getLayoutParams().height);
          paramb = this.Dju;
          paramViewGroup = paramb;
          if (paramb == null)
          {
            s.bIx("secondaryPageContainer");
            paramViewGroup = null;
          }
          paramViewGroup.getLayoutParams().height = erY().getLayoutParams().height;
          paramViewGroup = this.Djv;
          if (paramViewGroup != null) {
            break label1812;
          }
          s.bIx("couponList");
          paramViewGroup = null;
          label1610:
          this.mJe.getContext();
          paramViewGroup.setLayoutManager((RecyclerView.LayoutManager)new LinearLayoutManager(1, false));
          paramViewGroup.setAdapter((RecyclerView.a)this.Djz);
          paramViewGroup.getLayoutParams().height = erY().getLayoutParams().height;
          paramViewGroup = this.Djw;
          if (paramViewGroup != null) {
            break label1815;
          }
          s.bIx("secondaryGoodsList");
          paramViewGroup = null;
        }
      }
      label1798:
      label1803:
      label1812:
      label1815:
      for (;;)
      {
        this.mJe.getContext();
        paramViewGroup.setLayoutManager((RecyclerView.LayoutManager)new LinearLayoutManager(1, false));
        paramViewGroup.getLayoutParams().height = erY().getLayoutParams().height;
        paramb = this.Dji;
        paramViewGroup = paramb;
        if (paramb == null)
        {
          s.bIx("contentGroup");
          paramViewGroup = null;
        }
        paramViewGroup.setTranslationY(bf.bf(this.mJe.getContext()).y);
        paramViewGroup.getLayoutParams().height = j;
        Log.i(paramViewGroup.getTAG(), s.X("initPortraitShoppingList,contentGroup height:", Integer.valueOf(paramViewGroup.getLayoutParams().height)));
        break;
        i = 0;
        break label1443;
        paramViewGroup = null;
        break label1448;
        i = paramViewGroup.intValue();
        break label1466;
        break label1610;
      }
    }
  }
  
  private final void a(int paramInt1, int paramInt2, kotlin.g.a.q<? super Boolean, ? super Integer, ? super Integer, ah> paramq)
  {
    AppMethodBeat.i(354685);
    ah.f localf = new ah.f();
    cb localcb = kotlinx.coroutines.j.a((kotlinx.coroutines.aq)bu.ajwo, (kotlin.d.f)bg.kCh(), null, (m)new bz.q(localf, this, null), 2);
    Object localObject1 = aj.CGT;
    localObject1 = aj.getFinderLiveAssistant();
    if (localObject1 != null)
    {
      Object localObject2 = this.mJe.getContext();
      if (localObject2 == null)
      {
        paramq = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
        AppMethodBeat.o(354685);
        throw paramq;
      }
      localObject2 = (MMActivity)localObject2;
      long l1 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).liveInfo.liveId;
      long l2 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).hKN;
      String str = ((e)business(e.class)).mIC;
      auw localauw = new auw();
      Object localObject3 = com.tencent.mm.plugin.finder.utils.aw.Gjk;
      localObject3 = new bjz();
      ((bjz)localObject3).ZTl = paramInt1;
      ((bjz)localObject3).ZTm = paramInt2;
      ah localah = ah.aiuX;
      localauw.ZFn = com.tencent.mm.plugin.finder.utils.aw.j((com.tencent.mm.bx.a)localObject3);
      localauw.cmdId = 104;
      localObject3 = ah.aiuX;
      ((ap)localObject1).a((MMActivity)localObject2, l1, l2, str, localauw, (kotlin.g.a.q)new bz.p(localcb, localf, paramq, paramInt1, paramInt2));
    }
    AppMethodBeat.o(354685);
  }
  
  private final void a(final Bundle paramBundle, int paramInt, final boolean paramBoolean)
  {
    AppMethodBeat.i(354408);
    if ((paramBundle != null) && (paramBundle.getBoolean("PARAM_FINDER_LIVE_SHOPPING_SOURCE_CLICK", false) == true)) {}
    ap localap;
    for (final boolean bool = true;; bool = false)
    {
      Log.i(TAG, "showShoppingContent is refresh:" + paramBoolean + "，checkProductFirst:" + bool + ",pullScene:" + paramInt);
      rB(false);
      localObject = aj.CGT;
      localap = aj.getFinderLiveAssistant();
      if (localap == null) {
        break label254;
      }
      localObject = this.mJe.getContext();
      if (localObject != null) {
        break;
      }
      paramBundle = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
      AppMethodBeat.o(354408);
      throw paramBundle;
    }
    MMActivity localMMActivity = (MMActivity)localObject;
    long l1 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).liveInfo.liveId;
    long l2 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).hKN;
    String str = ((e)business(e.class)).mIC;
    byte[] arrayOfByte = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).mZp;
    Object localObject = (e)business(e.class);
    if (localObject == null)
    {
      localObject = null;
      localap.a(localMMActivity, l1, l2, str, arrayOfByte, null, paramInt, (String)localObject, (kotlin.g.a.b)new y(this, bool, paramBundle, paramBoolean));
      label254:
      this.DjF = false;
      if (rz(bool)) {
        break label360;
      }
      tO(0);
      localObject = (Collection)((com.tencent.mm.plugin.finder.live.viewmodel.data.business.q)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.q.class)).Eib;
      if ((localObject != null) && (!((Collection)localObject).isEmpty())) {
        break label333;
      }
    }
    label333:
    for (paramInt = 1;; paramInt = 0)
    {
      if (paramInt == 0) {
        break label338;
      }
      esc();
      AppMethodBeat.o(354408);
      return;
      localObject = ((e)localObject).EeF;
      break;
    }
    label338:
    esd();
    a(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.q)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.q.class)).Eib, paramBundle);
    label360:
    AppMethodBeat.o(354408);
  }
  
  private static final void a(bz parambz)
  {
    AppMethodBeat.i(354803);
    s.u(parambz, "this$0");
    FinderLiveShoppingPanel localFinderLiveShoppingPanel = parambz.Dji;
    parambz = localFinderLiveShoppingPanel;
    if (localFinderLiveShoppingPanel == null)
    {
      s.bIx("contentGroup");
      parambz = null;
    }
    parambz.hide();
    AppMethodBeat.o(354803);
  }
  
  private static final void a(bz parambz, View paramView1, final View paramView2, final View paramView3)
  {
    AppMethodBeat.i(354855);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(parambz);
    localb.cH(paramView1);
    localb.cH(paramView2);
    localb.cH(paramView3);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/plugin/FinderLiveShoppingListPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(parambz, "this$0");
    com.tencent.mm.plugin.finder.live.report.j.a(com.tencent.mm.plugin.finder.live.report.j.Dob, 1, 0);
    parambz.a(1, 0, (kotlin.g.a.q)new u(paramView1, paramView2, paramView3));
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/live/plugin/FinderLiveShoppingListPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(354855);
  }
  
  private static final void a(bz parambz, Object paramObject, long paramLong)
  {
    AppMethodBeat.i(354915);
    s.u(parambz, "this$0");
    if (!parambz.isFinished())
    {
      if ((paramObject instanceof g)) {}
      for (g localg = (g)paramObject; localg != null; localg = null)
      {
        parambz.g((g)paramObject);
        AppMethodBeat.o(354915);
        return;
      }
    }
    Log.i(TAG, "openFullScreenMiniprogramImpl delayMs:" + paramLong + ",isFinished!");
    AppMethodBeat.o(354915);
  }
  
  private static final void a(com.tencent.mm.ui.widget.a.h paramh, bz parambz, View paramView)
  {
    AppMethodBeat.i(354892);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramh);
    localb.cH(parambz);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/plugin/FinderLiveShoppingListPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramh, "$this_apply");
    s.u(parambz, "this$0");
    paramh.cyW();
    if (parambz.eqc()) {}
    for (int i = 0;; i = 3)
    {
      parambz.a(null, i, false);
      parambz.rD(true);
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/live/plugin/FinderLiveShoppingListPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(354892);
      return;
    }
  }
  
  private final void a(LinkedList<cc> paramLinkedList, Bundle paramBundle)
  {
    AppMethodBeat.i(354626);
    Object localObject1;
    final int i;
    label102:
    long l2;
    label321:
    int j;
    if (paramLinkedList != null)
    {
      Object localObject2 = (Iterable)paramLinkedList;
      localObject1 = (Collection)new ArrayList();
      localObject2 = ((Iterable)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        Object localObject3 = ((Iterator)localObject2).next();
        if ((localObject3 instanceof com.tencent.mm.plugin.finder.live.view.convert.k)) {
          ((Collection)localObject1).add(localObject3);
        }
      }
      if (!((Collection)localObject1).isEmpty())
      {
        i = 1;
        if (i != 1) {
          break label431;
        }
        i = 1;
        if (i != 0)
        {
          localObject2 = this.DeW;
          localObject1 = localObject2;
          if (localObject2 == null)
          {
            s.bIx("emptyGroup");
            localObject1 = null;
          }
          ((View)localObject1).setVisibility(8);
        }
        localObject2 = this.njj;
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          s.bIx("loadingBar");
          localObject1 = null;
        }
        ((ProgressBar)localObject1).setVisibility(8);
        localObject2 = this.njm;
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          s.bIx("titleGroup");
          localObject1 = null;
        }
        ((View)localObject1).setVisibility(0);
        erY().setVisibility(0);
        localObject2 = this.njg;
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          s.bIx("retryTip");
          localObject1 = null;
        }
        ((TextView)localObject1).setVisibility(8);
        rC(false);
        this.Djy.ax(paramLinkedList);
        if ((paramBundle != null) && ((paramBundle.containsKey("PARAM_FINDER_LIVE_BUBBLE_PRODUCTID")) || (paramBundle.containsKey("PARAM_FINDER_LIVE_BUBBLE_ADID"))))
        {
          long l1 = paramBundle.getLong("PARAM_FINDER_LIVE_BUBBLE_PRODUCTID", 0L);
          l2 = paramBundle.getLong("PARAM_FINDER_LIVE_BUBBLE_ADID", 0L);
          if (l1 == 0L) {
            break label454;
          }
          paramBundle = (List)this.Djy.DTh;
          i = 0;
          paramBundle = paramBundle.iterator();
          if (!paramBundle.hasNext()) {
            break label449;
          }
          localObject1 = (cc)paramBundle.next();
          if ((!(localObject1 instanceof com.tencent.mm.plugin.finder.live.view.convert.k)) || (((com.tencent.mm.plugin.finder.live.view.convert.k)localObject1).DVk != l1)) {
            break label436;
          }
          j = 1;
          label366:
          if (j == 0) {
            break label442;
          }
        }
      }
    }
    label551:
    label558:
    for (;;)
    {
      if ((i >= 0) && (i < this.Djy.DTh.size())) {
        erY().getViewTreeObserver().addOnGlobalLayoutListener((ViewTreeObserver.OnGlobalLayoutListener)new x(this, i));
      }
      gE((List)paramLinkedList);
      AppMethodBeat.o(354626);
      return;
      i = 0;
      break;
      label431:
      i = 0;
      break label102;
      label436:
      j = 0;
      break label366;
      label442:
      i += 1;
      break label321;
      label449:
      i = -1;
      continue;
      label454:
      if (l2 != 0L)
      {
        paramBundle = ((List)this.Djy.DTh).iterator();
        i = 0;
        for (;;)
        {
          if (!paramBundle.hasNext()) {
            break label558;
          }
          localObject1 = (cc)paramBundle.next();
          if (((localObject1 instanceof i)) && (((i)localObject1).DUP != 0L) && (((i)localObject1).DUP == l2)) {}
          for (j = 1;; j = 0)
          {
            if (j == 0) {
              break label551;
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
  
  private static final void b(bz parambz)
  {
    AppMethodBeat.i(354817);
    s.u(parambz, "this$0");
    FinderLiveShoppingPanel localFinderLiveShoppingPanel = parambz.Dji;
    parambz = localFinderLiveShoppingPanel;
    if (localFinderLiveShoppingPanel == null)
    {
      s.bIx("contentGroup");
      parambz = null;
    }
    parambz.show();
    AppMethodBeat.o(354817);
  }
  
  private static final void b(bz parambz, View paramView1, final View paramView2, final View paramView3)
  {
    AppMethodBeat.i(354865);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(parambz);
    localb.cH(paramView1);
    localb.cH(paramView2);
    localb.cH(paramView3);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/plugin/FinderLiveShoppingListPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(parambz, "this$0");
    com.tencent.mm.plugin.finder.live.report.j.a(com.tencent.mm.plugin.finder.live.report.j.Dob, 1, 1);
    parambz.a(1, 1, (kotlin.g.a.q)new v(paramView1, paramView2, paramView3));
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/live/plugin/FinderLiveShoppingListPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(354865);
  }
  
  private static final void b(bz parambz, Object paramObject, long paramLong)
  {
    AppMethodBeat.i(354929);
    s.u(parambz, "this$0");
    if (!parambz.isFinished())
    {
      if ((paramObject instanceof g)) {}
      for (g localg = (g)paramObject; localg != null; localg = null)
      {
        parambz.h((g)paramObject);
        AppMethodBeat.o(354929);
        return;
      }
    }
    Log.i(TAG, "openHalfScreenMiniprogramImpl delayMs:" + paramLong + ",isFinished!");
    AppMethodBeat.o(354929);
  }
  
  private static final void b(com.tencent.mm.ui.widget.a.h paramh, View paramView)
  {
    AppMethodBeat.i(354874);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramh);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/plugin/FinderLiveShoppingListPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramh, "$this_apply");
    paramh.cyW();
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/live/plugin/FinderLiveShoppingListPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(354874);
  }
  
  private static final void b(com.tencent.mm.ui.widget.a.h paramh, bz parambz, View paramView)
  {
    AppMethodBeat.i(354903);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramh);
    localb.cH(parambz);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/plugin/FinderLiveShoppingListPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramh, "$this_apply");
    s.u(parambz, "this$0");
    paramh.cyW();
    if (parambz.eqc()) {}
    for (int i = 0;; i = 3)
    {
      parambz.a(null, i, false);
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/live/plugin/FinderLiveShoppingListPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(354903);
      return;
    }
  }
  
  private static final void c(bz parambz)
  {
    AppMethodBeat.i(354830);
    s.u(parambz, "this$0");
    FinderLiveShoppingPanel localFinderLiveShoppingPanel = parambz.Dji;
    parambz = localFinderLiveShoppingPanel;
    if (localFinderLiveShoppingPanel == null)
    {
      s.bIx("contentGroup");
      parambz = null;
    }
    parambz.show();
    AppMethodBeat.o(354830);
  }
  
  private static final void d(bz parambz)
  {
    AppMethodBeat.i(354843);
    s.u(parambz, "this$0");
    FinderLiveShoppingPanel localFinderLiveShoppingPanel = parambz.Dji;
    parambz = localFinderLiveShoppingPanel;
    if (localFinderLiveShoppingPanel == null)
    {
      s.bIx("contentGroup");
      parambz = null;
    }
    parambz.show();
    AppMethodBeat.o(354843);
  }
  
  private static final void e(bz parambz)
  {
    AppMethodBeat.i(354881);
    s.u(parambz, "this$0");
    parambz.a(null, 0, true);
    AppMethodBeat.o(354881);
  }
  
  private final boolean eqc()
  {
    AppMethodBeat.i(354770);
    com.tencent.mm.plugin.finder.live.utils.a locala = com.tencent.mm.plugin.finder.live.utils.a.DJT;
    if ((com.tencent.mm.plugin.finder.live.utils.a.bUx()) || (((e)business(e.class)).DUe))
    {
      AppMethodBeat.o(354770);
      return true;
    }
    AppMethodBeat.o(354770);
    return false;
  }
  
  private final void erZ()
  {
    AppMethodBeat.i(354328);
    m localm = (m)new o(this);
    FinderLiveShoppingCouponView.a locala = (FinderLiveShoppingCouponView.a)new n(this);
    final ae localae = this.Djy;
    localae.DTk = localm;
    localae.DTl = ((kotlin.g.a.b)new i(this));
    localae.DTm = ((kotlin.g.a.b)new j(this));
    localae.DTn = ((kotlin.g.a.q)new k(this, localae));
    localae.DTo = ((kotlin.g.a.b)new l(this));
    localae.DTp = ((com.tencent.mm.plugin.finder.live.view.adapter.holder.b.b)new m(this));
    localae.DSK = locala;
    this.DjA.DTk = localm;
    this.Djz.DSK = locala;
    AppMethodBeat.o(354328);
  }
  
  private final boolean erp()
  {
    AppMethodBeat.i(354790);
    boolean bool = ((e)business(e.class)).DUe;
    AppMethodBeat.o(354790);
    return bool;
  }
  
  private final void esa()
  {
    Object localObject2 = null;
    AppMethodBeat.i(354344);
    if (this.DjB == null)
    {
      View localView = this.maskView;
      localObject1 = localView;
      if (localView == null)
      {
        s.bIx("maskView");
        localObject1 = null;
      }
      this.DjB = ObjectAnimator.ofFloat(localObject1, "alpha", new float[] { 0.0F, 1.0F });
    }
    Object localObject1 = this.maskView;
    if (localObject1 == null)
    {
      s.bIx("maskView");
      localObject1 = localObject2;
      if (((View)localObject1).getAlpha() != 1.0F) {
        break label101;
      }
    }
    label101:
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        break label106;
      }
      AppMethodBeat.o(354344);
      return;
      break;
    }
    label106:
    localObject1 = this.DjB;
    if (localObject1 != null) {
      ((ObjectAnimator)localObject1).cancel();
    }
    localObject1 = this.DjB;
    if (localObject1 != null) {
      ((ObjectAnimator)localObject1).start();
    }
    AppMethodBeat.o(354344);
  }
  
  private final void esb()
  {
    com.tencent.mm.plugin.finder.live.utils.a locala = null;
    AppMethodBeat.i(354373);
    Log.i(TAG, s.X("hideShoppingContent:", Util.getStack()));
    ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.q)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.q.class)).Eic.clear();
    ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.q)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.q.class)).Eim = null;
    Object localObject2 = this.Dji;
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      s.bIx("contentGroup");
      localObject1 = null;
    }
    ((FinderLiveShoppingPanel)localObject1).post(new bz..ExternalSyntheticLambda8(this));
    localObject2 = (com.tencent.mm.plugin.h)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.h.class);
    localObject1 = eoH();
    if ((localObject1 instanceof FinderLiveVisitorPluginLayout))
    {
      localObject1 = (FinderLiveVisitorPluginLayout)localObject1;
      if (localObject1 != null) {
        break label150;
      }
    }
    label150:
    for (localObject1 = locala;; localObject1 = ((FinderLiveVisitorPluginLayout)localObject1).getReportObj())
    {
      locala = com.tencent.mm.plugin.finder.live.utils.a.DJT;
      ((com.tencent.mm.plugin.h)localObject2).a((bui)localObject1, com.tencent.mm.plugin.finder.live.utils.a.b(getBuContext(), 30));
      AppMethodBeat.o(354373);
      return;
      localObject1 = null;
      break;
    }
  }
  
  private final void esc()
  {
    Object localObject2 = null;
    AppMethodBeat.i(354426);
    Log.i(TAG, "showShoppingLoading");
    Object localObject3 = this.njj;
    Object localObject1 = localObject3;
    if (localObject3 == null)
    {
      s.bIx("loadingBar");
      localObject1 = null;
    }
    ((ProgressBar)localObject1).setVisibility(0);
    localObject3 = this.njg;
    localObject1 = localObject3;
    if (localObject3 == null)
    {
      s.bIx("retryTip");
      localObject1 = null;
    }
    ((TextView)localObject1).setVisibility(8);
    localObject3 = this.DeW;
    localObject1 = localObject3;
    if (localObject3 == null)
    {
      s.bIx("emptyGroup");
      localObject1 = null;
    }
    ((View)localObject1).setVisibility(8);
    localObject3 = this.njm;
    localObject1 = localObject3;
    if (localObject3 == null)
    {
      s.bIx("titleGroup");
      localObject1 = null;
    }
    ((View)localObject1).setVisibility(8);
    erY().setVisibility(8);
    localObject1 = this.Dji;
    if (localObject1 == null)
    {
      s.bIx("contentGroup");
      localObject1 = localObject2;
    }
    for (;;)
    {
      ((FinderLiveShoppingPanel)localObject1).post(new bz..ExternalSyntheticLambda7(this));
      esa();
      AppMethodBeat.o(354426);
      return;
    }
  }
  
  private final void esd()
  {
    Object localObject2 = null;
    AppMethodBeat.i(354444);
    Log.i(TAG, "showEmptyShoppingPanel");
    Object localObject3 = this.njj;
    Object localObject1 = localObject3;
    if (localObject3 == null)
    {
      s.bIx("loadingBar");
      localObject1 = null;
    }
    ((ProgressBar)localObject1).setVisibility(8);
    localObject3 = this.njg;
    localObject1 = localObject3;
    if (localObject3 == null)
    {
      s.bIx("retryTip");
      localObject1 = null;
    }
    ((TextView)localObject1).setVisibility(8);
    localObject3 = this.DeW;
    localObject1 = localObject3;
    if (localObject3 == null)
    {
      s.bIx("emptyGroup");
      localObject1 = null;
    }
    ((View)localObject1).setVisibility(8);
    localObject3 = this.njm;
    localObject1 = localObject3;
    if (localObject3 == null)
    {
      s.bIx("titleGroup");
      localObject1 = null;
    }
    ((View)localObject1).setVisibility(8);
    erY().setVisibility(8);
    localObject1 = this.Dji;
    if (localObject1 == null)
    {
      s.bIx("contentGroup");
      localObject1 = localObject2;
    }
    for (;;)
    {
      ((FinderLiveShoppingPanel)localObject1).post(new bz..ExternalSyntheticLambda9(this));
      esa();
      tO(0);
      AppMethodBeat.o(354444);
      return;
    }
  }
  
  private final void ese()
  {
    AppMethodBeat.i(354525);
    cc localcc1 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.q)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.q.class)).Eie;
    com.tencent.mm.live.b.b localb;
    b.c localc;
    Bundle localBundle;
    Object localObject;
    int i;
    if ((localcc1 instanceof com.tencent.mm.plugin.finder.live.view.convert.j))
    {
      localb = this.nfT;
      localc = b.c.ndP;
      localBundle = new Bundle();
      Iterator localIterator = ((Iterable)((com.tencent.mm.plugin.finder.live.viewmodel.data.business.q)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.q.class)).ezk()).iterator();
      if (!localIterator.hasNext()) {
        break label184;
      }
      localObject = localIterator.next();
      cc localcc2 = (cc)localObject;
      if ((!(localcc2 instanceof com.tencent.mm.plugin.finder.live.view.convert.j)) || (!s.p(((com.tencent.mm.plugin.finder.live.view.convert.j)localcc2).mdN, ((com.tencent.mm.plugin.finder.live.view.convert.j)localcc1).mdN))) {
        break label179;
      }
      i = 1;
      label127:
      if (i == 0) {
        break label182;
      }
    }
    for (;;)
    {
      localObject = (cc)localObject;
      if (localObject != null) {
        localBundle.putByteArray("PARAM_FINDER_LIVE_PROMOTE_DATA", ((com.tencent.mm.plugin.finder.live.view.convert.j)localObject).DUV.toByteArray());
      }
      localObject = ah.aiuX;
      localb.statusChange(localc, localBundle);
      AppMethodBeat.o(354525);
      return;
      label179:
      i = 0;
      break label127;
      label182:
      break;
      label184:
      localObject = null;
    }
  }
  
  private final void esf()
  {
    AppMethodBeat.i(354533);
    if ((!eqc()) && (this.Djy.ewa()) && (((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(com.tencent.mm.plugin.expt.b.c.a.yHw, 0) == 1))
    {
      View localView2 = this.Djn;
      View localView1 = localView2;
      if (localView2 == null)
      {
        s.bIx("serviceGroup");
        localView1 = null;
      }
      localView1.setVisibility(0);
    }
    AppMethodBeat.o(354533);
  }
  
  private final void esg()
  {
    Object localObject2 = null;
    AppMethodBeat.i(354552);
    Log.i(TAG, "showEmptyContent");
    Object localObject3 = this.Djn;
    Object localObject1 = localObject3;
    if (localObject3 == null)
    {
      s.bIx("serviceGroup");
      localObject1 = null;
    }
    ((View)localObject1).setVisibility(8);
    localObject3 = this.DeW;
    localObject1 = localObject3;
    if (localObject3 == null)
    {
      s.bIx("emptyGroup");
      localObject1 = null;
    }
    ((View)localObject1).setVisibility(0);
    if (eqc())
    {
      localObject3 = this.Djs;
      localObject1 = localObject3;
      if (localObject3 == null)
      {
        s.bIx("emptyAction");
        localObject1 = null;
      }
      ((TextView)localObject1).setVisibility(0);
      localObject3 = this.njj;
      localObject1 = localObject3;
      if (localObject3 == null)
      {
        s.bIx("loadingBar");
        localObject1 = null;
      }
      ((ProgressBar)localObject1).setVisibility(8);
      localObject3 = this.njm;
      localObject1 = localObject3;
      if (localObject3 == null)
      {
        s.bIx("titleGroup");
        localObject1 = null;
      }
      ((View)localObject1).setVisibility(0);
      setTitle(null);
      rC(false);
      localObject1 = this.njg;
      if (localObject1 != null) {
        break label214;
      }
      s.bIx("retryTip");
      localObject1 = localObject2;
    }
    label214:
    for (;;)
    {
      ((TextView)localObject1).setVisibility(8);
      AppMethodBeat.o(354552);
      return;
      localObject3 = this.Djs;
      localObject1 = localObject3;
      if (localObject3 == null)
      {
        s.bIx("emptyAction");
        localObject1 = null;
      }
      ((TextView)localObject1).setVisibility(8);
      break;
    }
  }
  
  private final void esh()
  {
    AppMethodBeat.i(354565);
    View localView2 = this.DeW;
    View localView1 = localView2;
    if (localView2 == null)
    {
      s.bIx("emptyGroup");
      localView1 = null;
    }
    if (localView1.getVisibility() != 0)
    {
      AppMethodBeat.o(354565);
      return;
    }
    erY().getViewTreeObserver().addOnGlobalLayoutListener((ViewTreeObserver.OnGlobalLayoutListener)new z(this));
    AppMethodBeat.o(354565);
  }
  
  private final void esk()
  {
    Object localObject2 = null;
    AppMethodBeat.i(354663);
    Object localObject3 = TAG;
    Object localObject4 = new StringBuilder("add product appId:");
    Object localObject1 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.q)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.q.class)).Eia;
    if (localObject1 == null)
    {
      localObject1 = null;
      localObject4 = ((StringBuilder)localObject4).append(localObject1).append(",path:");
      localObject1 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.q)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.q.class)).Eia;
      if (localObject1 != null) {
        break label294;
      }
      localObject1 = null;
      label87:
      Log.i((String)localObject3, localObject1);
      localObject1 = com.tencent.mm.plugin.finder.live.k.Bxu;
      com.tencent.mm.plugin.finder.live.k.b(getBuContext(), (m)new c(this));
      if (this.nfT.getLiveRole() != 1) {
        break label527;
      }
      localObject3 = new JSONObject();
      ((JSONObject)localObject3).put("type", q.as.Dzn.action);
      localObject1 = com.tencent.mm.plugin.finder.live.report.j.Dob;
      ((JSONObject)localObject3).put("sessionid", com.tencent.mm.plugin.finder.live.report.j.Doc.DpP);
      ((JSONObject)localObject3).put("shopwindowid", "");
      localObject1 = com.tencent.mm.plugin.finder.live.model.context.a.CMm;
      localObject1 = com.tencent.mm.plugin.finder.live.model.context.a.emY();
      if (localObject1 == null) {
        break label322;
      }
      localObject1 = (e)((com.tencent.mm.plugin.finder.live.model.context.a)localObject1).business(e.class);
      if ((localObject1 == null) || (((e)localObject1).eyz() != true)) {
        break label322;
      }
    }
    label294:
    label322:
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        break label327;
      }
      com.tencent.mm.plugin.finder.live.report.j.Dob.C(q.a.DqI.mwI, ((JSONObject)localObject3).toString());
      AppMethodBeat.o(354663);
      return;
      localObject1 = ((bih)localObject1).ZRp;
      if (localObject1 == null)
      {
        localObject1 = null;
        break;
      }
      localObject1 = ((bzd)localObject1).appId;
      break;
      localObject1 = ((bih)localObject1).ZRp;
      if (localObject1 == null)
      {
        localObject1 = null;
        break label87;
      }
      localObject1 = ((bzd)localObject1).aail;
      break label87;
    }
    label327:
    localObject1 = com.tencent.mm.plugin.finder.live.model.context.a.CMm;
    localObject1 = com.tencent.mm.plugin.finder.live.model.context.a.emY();
    label406:
    long l;
    if (localObject1 != null)
    {
      localObject1 = (e)((com.tencent.mm.plugin.finder.live.model.context.a)localObject1).business(e.class);
      if ((localObject1 != null) && (((e)localObject1).isLiveStarted() == true))
      {
        i = 1;
        if (i != 0)
        {
          localObject1 = com.tencent.mm.plugin.finder.live.report.j.Dob;
          com.tencent.mm.plugin.finder.live.report.j.Doc.Dqv = true;
          localObject1 = com.tencent.mm.plugin.finder.live.model.context.a.CMm;
          localObject1 = com.tencent.mm.plugin.finder.live.model.context.a.emY();
          if (localObject1 != null) {
            break label539;
          }
          localObject1 = localObject2;
          ((JSONObject)localObject3).put("appid", localObject1);
          localObject1 = com.tencent.mm.plugin.finder.live.model.context.a.CMm;
          localObject1 = com.tencent.mm.plugin.finder.live.model.context.a.emY();
          if (localObject1 != null) {
            break label571;
          }
          l = -1L;
          label436:
          if (l >= 0L) {
            break label624;
          }
          ((JSONObject)localObject3).put("liveid", "");
          label454:
          localObject1 = com.tencent.mm.plugin.expt.hellhound.ext.b.b.c.zGj;
          ((JSONObject)localObject3).put("clickid", com.tencent.mm.plugin.expt.hellhound.ext.b.b.c.dKp());
          localObject1 = com.tencent.mm.plugin.expt.hellhound.ext.b.b.c.zGj;
          com.tencent.mm.plugin.expt.hellhound.ext.b.b.c.a.arH("");
          localObject1 = com.tencent.mm.plugin.finder.live.model.context.a.CMm;
          localObject1 = com.tencent.mm.plugin.finder.live.model.context.a.emY();
          if (localObject1 != null) {
            break label640;
          }
          localObject1 = "";
        }
      }
    }
    for (;;)
    {
      ((JSONObject)localObject3).put("productid", localObject1);
      com.tencent.mm.plugin.finder.live.report.j.Dob.a(q.c.Drn, ((JSONObject)localObject3).toString());
      label527:
      AppMethodBeat.o(354663);
      return;
      i = 0;
      break;
      label539:
      localObject4 = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.q)((com.tencent.mm.plugin.finder.live.model.context.a)localObject1).business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.q.class);
      localObject1 = localObject2;
      if (localObject4 == null) {
        break label406;
      }
      localObject1 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.q)localObject4).Eii;
      break label406;
      label571:
      localObject1 = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)((com.tencent.mm.plugin.finder.live.model.context.a)localObject1).business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class);
      if (localObject1 == null)
      {
        l = -1L;
        break label436;
      }
      localObject1 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)localObject1).liveInfo;
      if (localObject1 == null)
      {
        l = -1L;
        break label436;
      }
      l = ((bip)localObject1).liveId;
      break label436;
      label624:
      ((JSONObject)localObject3).put("liveid", com.tencent.mm.plugin.expt.hellhound.core.b.hF(l));
      break label454;
      label640:
      localObject1 = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.q)((com.tencent.mm.plugin.finder.live.model.context.a)localObject1).business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.q.class);
      if (localObject1 == null)
      {
        localObject1 = "";
      }
      else
      {
        localObject1 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.q)localObject1).Eie;
        if (localObject1 == null) {
          localObject1 = "";
        } else {
          localObject1 = Long.valueOf(((cc)localObject1).bZA());
        }
      }
    }
  }
  
  private final void g(g paramg)
  {
    AppMethodBeat.i(354740);
    Object localObject = aj.CGT;
    ap localap = aj.getFinderLiveAssistant();
    if (localap != null)
    {
      localObject = this.mJe;
      if (localObject != null) {
        break label55;
      }
    }
    label55:
    for (localObject = null;; localObject = ((ViewGroup)localObject).getContext())
    {
      s.s(localObject, "root?.context");
      localap.a((Context)localObject, paramg, ehM());
      AppMethodBeat.o(354740);
      return;
    }
  }
  
  private final void gE(List<? extends cc> paramList)
  {
    AppMethodBeat.i(354595);
    this.DjI.clear();
    if (paramList != null)
    {
      localObject1 = (Iterable)paramList;
      paramList = (Collection)new ArrayList();
      localObject1 = ((Iterable)localObject1).iterator();
      Object localObject2;
      Object localObject4;
      label112:
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = ((Iterator)localObject1).next();
        localObject3 = (cc)localObject2;
        if ((localObject3 instanceof com.tencent.mm.plugin.finder.live.view.convert.k))
        {
          localObject4 = com.tencent.mm.plugin.finder.live.utils.a.DJT;
          if (!com.tencent.mm.plugin.finder.live.utils.a.Pr(((com.tencent.mm.plugin.finder.live.view.convert.k)localObject3).DVs)) {}
        }
        for (i = 1;; i = 0)
        {
          if (i == 0) {
            break label112;
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
        localObject1 = (com.tencent.mm.plugin.finder.live.view.convert.k)((Iterator)localObject3).next();
        if (((com.tencent.mm.plugin.finder.live.view.convert.k)localObject1).DVr == 1)
        {
          localObject1 = ((com.tencent.mm.plugin.finder.live.view.convert.k)localObject1).DVq;
          if (localObject1 != null)
          {
            paramList = com.tencent.mm.plugin.finder.live.utils.a.DJT;
            paramList = com.tencent.mm.plugin.finder.live.utils.a.a((aka)localObject1);
          }
        }
        else
        {
          localObject4 = ((com.tencent.mm.plugin.finder.live.view.convert.k)localObject1).DVq;
          if (localObject4 != null)
          {
            HashMap localHashMap = this.DjI;
            localObject2 = ((aka)localObject4).appid;
            localObject1 = localObject2;
            if (localObject2 == null) {
              localObject1 = "";
            }
            localObject2 = com.tencent.mm.plugin.finder.live.utils.a.DJT;
            localHashMap.put(localObject1, com.tencent.mm.plugin.finder.live.utils.a.a((aka)localObject4));
          }
        }
      }
    }
    Object localObject1 = null;
    Log.i(TAG, "prehotMiniprogram promotingBundle:" + localObject1 + ",bundle size:" + this.DjI.size() + ",MAX_PREHOT_SIZE:" + this.DjH);
    if (localObject1 != null)
    {
      l.a(l.Bxv, getBuContext(), (g)localObject1);
      this.DjI.remove(((g)localObject1).appId);
    }
    paramList = ((Map)this.DjI).entrySet().iterator();
    int i = 0;
    while (paramList.hasNext())
    {
      localObject1 = (Map.Entry)paramList.next();
      if (i < this.DjH)
      {
        localObject1 = (g)((Map.Entry)localObject1).getValue();
        if (localObject1 != null) {
          l.a(l.Bxv, getBuContext(), (g)localObject1);
        }
      }
      i += 1;
    }
    AppMethodBeat.o(354595);
  }
  
  private final void h(g paramg)
  {
    AppMethodBeat.i(354757);
    Object localObject = aj.CGT;
    ap localap = aj.getFinderLiveAssistant();
    if (localap != null)
    {
      localObject = this.mJe;
      if (localObject != null) {
        break label55;
      }
    }
    label55:
    for (localObject = null;; localObject = ((ViewGroup)localObject).getContext())
    {
      s.s(localObject, "root?.context");
      localap.b((Context)localObject, paramg, ehM());
      AppMethodBeat.o(354757);
      return;
    }
  }
  
  private final void rA(boolean paramBoolean)
  {
    FrameLayout localFrameLayout = null;
    AppMethodBeat.i(354464);
    Log.i(TAG, s.X("showSecondaryPage ", Boolean.valueOf(paramBoolean)));
    Object localObject2 = this.njm;
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      s.bIx("titleGroup");
      localObject1 = null;
    }
    ((View)localObject1).setVisibility(0);
    localObject2 = this.Djl;
    localObject1 = localObject2;
    if (localObject2 == null)
    {
      s.bIx("orderTv");
      localObject1 = null;
    }
    ((TextView)localObject1).setVisibility(8);
    localObject2 = this.Djm;
    localObject1 = localObject2;
    if (localObject2 == null)
    {
      s.bIx("orderIv");
      localObject1 = null;
    }
    ((WeImageView)localObject1).setVisibility(8);
    localObject2 = this.Djn;
    localObject1 = localObject2;
    if (localObject2 == null)
    {
      s.bIx("serviceGroup");
      localObject1 = null;
    }
    ((View)localObject1).setVisibility(8);
    localObject2 = this.Djj;
    localObject1 = localObject2;
    if (localObject2 == null)
    {
      s.bIx("closeIv");
      localObject1 = null;
    }
    ((WeImageView)localObject1).setImageResource(p.g.icons_filled_back);
    localObject2 = this.Djj;
    localObject1 = localObject2;
    if (localObject2 == null)
    {
      s.bIx("closeIv");
      localObject1 = null;
    }
    ((WeImageView)localObject1).setRotation(0.0F);
    localObject2 = this.yls;
    localObject1 = localObject2;
    if (localObject2 == null)
    {
      s.bIx("close");
      localObject1 = null;
    }
    ((View)localObject1).setBackground(null);
    localObject2 = this.Dju;
    localObject1 = localObject2;
    if (localObject2 == null)
    {
      s.bIx("secondaryPageContainer");
      localObject1 = null;
    }
    ((FrameLayout)localObject1).setVisibility(0);
    if (paramBoolean)
    {
      localObject1 = this.Dju;
      if (localObject1 == null)
      {
        s.bIx("secondaryPageContainer");
        localObject1 = localFrameLayout;
      }
      for (;;)
      {
        ((FrameLayout)localObject1).setTranslationX(0.0F);
        AppMethodBeat.o(354464);
        return;
      }
    }
    localFrameLayout = this.Dju;
    localObject1 = localFrameLayout;
    if (localFrameLayout == null)
    {
      s.bIx("secondaryPageContainer");
      localObject1 = null;
    }
    ((FrameLayout)localObject1).setTranslationX(erY().getWidth());
    localFrameLayout = this.Dju;
    localObject1 = localFrameLayout;
    if (localFrameLayout == null)
    {
      s.bIx("secondaryPageContainer");
      localObject1 = null;
    }
    ((FrameLayout)localObject1).animate().setDuration(300L).setInterpolator((TimeInterpolator)new AccelerateDecelerateInterpolator()).translationX(0.0F).setListener(null).start();
    AppMethodBeat.o(354464);
  }
  
  private final void rB(boolean paramBoolean)
  {
    Object localObject3 = null;
    Object localObject2 = null;
    AppMethodBeat.i(354477);
    Log.i(TAG, s.X("hideSecondaryPage ", Boolean.valueOf(paramBoolean)));
    Object localObject4 = this.Djl;
    Object localObject1 = localObject4;
    if (localObject4 == null)
    {
      s.bIx("orderTv");
      localObject1 = null;
    }
    ((TextView)localObject1).setVisibility(0);
    rC(true);
    esf();
    setTitle(null);
    localObject4 = this.Djj;
    localObject1 = localObject4;
    if (localObject4 == null)
    {
      s.bIx("closeIv");
      localObject1 = null;
    }
    ((WeImageView)localObject1).setImageResource(p.g.icons_filled_arrow);
    localObject4 = this.Djj;
    localObject1 = localObject4;
    if (localObject4 == null)
    {
      s.bIx("closeIv");
      localObject1 = null;
    }
    ((WeImageView)localObject1).setRotation(90.0F);
    localObject4 = this.yls;
    localObject1 = localObject4;
    if (localObject4 == null)
    {
      s.bIx("close");
      localObject1 = null;
    }
    ((View)localObject1).setBackgroundResource(p.d.BAL);
    if (paramBoolean)
    {
      localObject1 = this.Dju;
      if (localObject1 == null)
      {
        s.bIx("secondaryPageContainer");
        localObject1 = localObject2;
      }
      for (;;)
      {
        ((FrameLayout)localObject1).animate().setDuration(300L).setInterpolator((TimeInterpolator)new AccelerateDecelerateInterpolator()).translationX(erY().getWidth()).setListener((Animator.AnimatorListener)new f(this)).start();
        AppMethodBeat.o(354477);
        return;
      }
    }
    localObject1 = this.Dju;
    if (localObject1 == null)
    {
      s.bIx("secondaryPageContainer");
      localObject1 = localObject3;
    }
    for (;;)
    {
      ((FrameLayout)localObject1).setVisibility(8);
      AppMethodBeat.o(354477);
      return;
    }
  }
  
  private final void rC(boolean paramBoolean)
  {
    WeImageView localWeImageView = null;
    Object localObject2 = null;
    AppMethodBeat.i(354505);
    FrameLayout localFrameLayout = this.Dju;
    Object localObject1 = localFrameLayout;
    if (localFrameLayout == null)
    {
      s.bIx("secondaryPageContainer");
      localObject1 = null;
    }
    if ((((FrameLayout)localObject1).getVisibility() == 0) && (!paramBoolean))
    {
      AppMethodBeat.o(354505);
      return;
    }
    setTitle(null);
    localObject1 = this.Djl;
    if (localObject1 == null)
    {
      s.bIx("orderTv");
      localObject1 = null;
      if (!eqc()) {
        break label131;
      }
      localWeImageView = this.Djm;
      if (localWeImageView != null) {
        break label125;
      }
      s.bIx("orderIv");
    }
    for (;;)
    {
      ((WeImageView)localObject2).setVisibility(8);
      localObject2 = (CharSequence)"";
      ((TextView)localObject1).setText((CharSequence)localObject2);
      AppMethodBeat.o(354505);
      return;
      break;
      label125:
      localObject2 = localWeImageView;
    }
    label131:
    localObject2 = this.Djm;
    if (localObject2 == null)
    {
      s.bIx("orderIv");
      localObject2 = localWeImageView;
    }
    for (;;)
    {
      ((WeImageView)localObject2).setVisibility(0);
      localObject2 = (CharSequence)this.mJe.getContext().getString(p.h.finder_live_shopping_order);
      break;
    }
  }
  
  private final void rD(boolean paramBoolean)
  {
    Object localObject2 = null;
    AppMethodBeat.i(354726);
    Object localObject1 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.q)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.q.class)).Eia;
    Object localObject3;
    label88:
    int i;
    if (localObject1 == null)
    {
      localObject1 = null;
      if ((localObject1 == null) || (((bms)localObject1).xlL == 0)) {
        break label246;
      }
      Log.i(TAG, s.X("enter direct cs info: ", com.tencent.mm.ae.f.dg(localObject1)));
      if (((bms)localObject1).xlL != 1) {
        break label209;
      }
      localObject3 = ((Iterable)this.Djy.DTh).iterator();
      if (!((Iterator)localObject3).hasNext()) {
        break label203;
      }
      localObject2 = ((Iterator)localObject3).next();
      localObject4 = (cc)localObject2;
      if ((!(localObject4 instanceof com.tencent.mm.plugin.finder.live.view.convert.k)) || (((com.tencent.mm.plugin.finder.live.view.convert.k)localObject4).DVr != 1)) {
        break label198;
      }
      i = 1;
      label136:
      if (i == 0) {
        break label201;
      }
    }
    for (;;)
    {
      localObject2 = (cc)localObject2;
      localObject3 = com.tencent.mm.plugin.finder.live.utils.a.DJT;
      localObject3 = this.mJe.getContext();
      s.s(localObject3, "root.context");
      com.tencent.mm.plugin.finder.live.utils.a.a((Context)localObject3, (bms)localObject1, (com.tencent.mm.plugin.finder.live.view.convert.k)localObject2);
      AppMethodBeat.o(354726);
      return;
      localObject1 = ((bih)localObject1).ZRu;
      break;
      label198:
      i = 0;
      break label136;
      label201:
      break label88;
      label203:
      localObject2 = null;
    }
    label209:
    localObject2 = com.tencent.mm.plugin.finder.live.utils.a.DJT;
    localObject2 = this.mJe.getContext();
    s.s(localObject2, "root.context");
    com.tencent.mm.plugin.finder.live.utils.a.a((Context)localObject2, (bms)localObject1);
    AppMethodBeat.o(354726);
    return;
    label246:
    setTitle(this.mJe.getContext().getString(p.h.CsL));
    localObject1 = this.Djw;
    if (localObject1 == null)
    {
      s.bIx("secondaryGoodsList");
      localObject1 = null;
    }
    for (;;)
    {
      ((RecyclerView)localObject1).setAdapter((RecyclerView.a)this.DjA);
      localObject1 = this.DjA;
      localObject3 = this.Djy;
      localObject5 = (Iterable)((ae)localObject3).DTh;
      localObject4 = (Collection)new ArrayList();
      localObject5 = ((Iterable)localObject5).iterator();
      while (((Iterator)localObject5).hasNext())
      {
        localObject6 = ((Iterator)localObject5).next();
        if ((localObject6 instanceof com.tencent.mm.plugin.finder.live.view.convert.k)) {
          ((Collection)localObject4).add(localObject6);
        }
      }
    }
    Object localObject4 = (List)localObject4;
    Object localObject6 = (Iterable)localObject4;
    Object localObject5 = (Collection)new ArrayList();
    localObject6 = ((Iterable)localObject6).iterator();
    label469:
    while (((Iterator)localObject6).hasNext())
    {
      Object localObject7 = ((Iterator)localObject6).next();
      if (((com.tencent.mm.plugin.finder.live.view.convert.k)localObject7).DVr == 1) {}
      for (i = 1;; i = 0)
      {
        if (i == 0) {
          break label469;
        }
        ((Collection)localObject5).add(localObject7);
        break;
      }
    }
    localObject5 = kotlin.a.p.J((Collection)localObject5);
    localObject6 = ((ae)localObject3).DSJ;
    int j;
    if (localObject6 != null)
    {
      localObject6 = ((bz)localObject6).erY().getLayoutManager();
      if (localObject6 == null)
      {
        localObject1 = new NullPointerException("null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
        AppMethodBeat.o(354726);
        throw ((Throwable)localObject1);
      }
      localObject6 = (LinearLayoutManager)localObject6;
      i = ((LinearLayoutManager)localObject6).Ju();
      j = ((LinearLayoutManager)localObject6).Jw();
      if (i > j) {}
    }
    for (;;)
    {
      localObject6 = (Integer)((ae)localObject3).DSF.get(i);
      if (localObject6 == null) {}
      while (i == j)
      {
        localObject3 = ((List)localObject4).iterator();
        for (;;)
        {
          if (((Iterator)localObject3).hasNext())
          {
            localObject4 = (com.tencent.mm.plugin.finder.live.view.convert.k)((Iterator)localObject3).next();
            if (!((List)localObject5).contains(localObject4))
            {
              ((List)localObject5).add(localObject4);
              continue;
              if (((Integer)localObject6).intValue() != 2) {
                break;
              }
              localObject6 = ((ae)localObject3).DTh.get(((ae)localObject3).hN(i, 2));
              s.s(localObject6, "goodsAndAdList[realPosCo… ITEM_TYPE_GOODS_OR_ADS)]");
              localObject6 = (cc)localObject6;
              if ((!(localObject6 instanceof com.tencent.mm.plugin.finder.live.view.convert.k)) || (((com.tencent.mm.plugin.finder.live.view.convert.k)localObject6).DVr == 1)) {
                break;
              }
              ((List)localObject5).add(localObject6);
              break;
            }
          }
        }
        Log.i("Finder.LiveShoppingListAdapter", s.X("getSortedGoodsDataForService ", Integer.valueOf(((List)localObject5).size())));
        localObject3 = this.Djy.DSR;
        s.u(localObject5, "productList");
        s.u(localObject3, "priceViewConfig");
        ((af)localObject1).DSI.clear();
        ((af)localObject1).DSI.addAll((Collection)localObject5);
        ((af)localObject1).DSR = ((FinderLiveShoppingPriceView.b)localObject3);
        ((RecyclerView.a)localObject1).bZE.notifyChanged();
        localObject3 = this.Djv;
        localObject1 = localObject3;
        if (localObject3 == null)
        {
          s.bIx("couponList");
          localObject1 = null;
        }
        ((RecyclerView)localObject1).setVisibility(8);
        localObject1 = this.Djw;
        if (localObject1 == null)
        {
          s.bIx("secondaryGoodsList");
          localObject1 = localObject2;
        }
        for (;;)
        {
          ((RecyclerView)localObject1).setVisibility(0);
          rA(paramBoolean);
          AppMethodBeat.o(354726);
          return;
        }
      }
      i += 1;
    }
  }
  
  private final boolean rz(boolean paramBoolean)
  {
    AppMethodBeat.i(354386);
    if ((eqc()) && (paramBoolean))
    {
      AppMethodBeat.o(354386);
      return true;
    }
    AppMethodBeat.o(354386);
    return false;
  }
  
  private final void setTitle(String paramString)
  {
    AppMethodBeat.i(354488);
    TextView localTextView2 = this.Djt;
    TextView localTextView1 = localTextView2;
    if (localTextView2 == null)
    {
      s.bIx("productsTitle");
      localTextView1 = null;
    }
    localTextView1.setText((CharSequence)paramString);
    AppMethodBeat.o(354488);
  }
  
  public final void a(Bundle paramBundle, Object paramObject, long paramLong)
  {
    AppMethodBeat.i(355644);
    if (paramBundle == null) {
      paramBundle = "";
    }
    while (s.p(paramBundle, "PORTRAIT_ACTION_FULL_SCREEN_MINIPRO"))
    {
      com.tencent.mm.ae.d.a(paramLong, new bz..ExternalSyntheticLambda10(this, paramObject, paramLong));
      AppMethodBeat.o(355644);
      return;
      String str = paramBundle.getString("ACTION_POST_PORTRAIT", "");
      paramBundle = str;
      if (str == null) {
        paramBundle = "";
      }
    }
    if (s.p(paramBundle, "PORTRAIT_ACTION_HALF_SCREEN_MINIPRO")) {
      com.tencent.mm.ae.d.a(paramLong, new bz..ExternalSyntheticLambda11(this, paramObject, paramLong));
    }
    AppMethodBeat.o(355644);
  }
  
  public final RecyclerView erY()
  {
    AppMethodBeat.i(355491);
    RecyclerView localRecyclerView = this.Djq;
    if (localRecyclerView != null)
    {
      AppMethodBeat.o(355491);
      return localRecyclerView;
    }
    s.bIx("shoppingList");
    AppMethodBeat.o(355491);
    return null;
  }
  
  public final void esi()
  {
    AppMethodBeat.i(355572);
    if ((!((com.tencent.mm.plugin.finder.live.viewmodel.data.business.q)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.q.class)).CEZ) || (com.tencent.mm.ae.d.ee(((e)business(e.class)).Ecp, 16)) || (!((e)business(e.class)).isLiveStarted()))
    {
      AppMethodBeat.o(355572);
      return;
    }
    if (com.tencent.mm.ae.d.ee((int)((e)business(e.class)).Ecq, 1))
    {
      Log.i(TAG, s.X("checkShoppingAvailableAnchorStatus backEndAnchorStatusFlag:", Long.valueOf(((e)business(e.class)).Ecq)));
      int i = ((e)business(e.class)).Ecp;
      Object localObject = aj.CGT;
      localObject = aj.getFinderLiveAssistant();
      if (localObject != null) {
        ap.a.a((ap)localObject, ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).liveInfo.liveId, ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).hKN, i | 0x10, 16L, 2, null, 32);
      }
    }
    AppMethodBeat.o(355572);
  }
  
  public final void esj()
  {
    AppMethodBeat.i(355588);
    if ((!eqc()) || (this.DjE))
    {
      AppMethodBeat.o(355588);
      return;
    }
    if (((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).liveInfo.liveId == 0L)
    {
      AppMethodBeat.o(355588);
      return;
    }
    Log.i(TAG, s.X("has notify visitor shopping:", Boolean.valueOf(this.DjE)));
    this.DjD += 1;
    if (this.DjD >= 3)
    {
      this.DjD = 0;
      AppMethodBeat.o(355588);
      return;
    }
    int i = ((e)business(e.class)).Ecp;
    Object localObject = aj.CGT;
    localObject = aj.getFinderLiveAssistant();
    if (localObject != null) {
      ((ap)localObject).a(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).liveInfo.liveId, ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).hKN, i | 0x10, 16L, 2, (com.tencent.mm.plugin.finder.live.cgi.e.a)new s(this));
    }
    AppMethodBeat.o(355588);
  }
  
  public final void mount()
  {
    Object localObject2 = null;
    AppMethodBeat.i(355680);
    super.mount();
    erZ();
    Object localObject1 = this.niW;
    if (localObject1 == null)
    {
      s.bIx("blankArea");
      localObject1 = null;
      ((View)localObject1).setOnClickListener((View.OnClickListener)this);
      localObject1 = this.yls;
      if (localObject1 != null) {
        break label273;
      }
      s.bIx("close");
      localObject1 = null;
      label58:
      ((View)localObject1).setOnClickListener((View.OnClickListener)this);
      localObject1 = this.Djk;
      if (localObject1 != null) {
        break label276;
      }
      s.bIx("orderGroup");
      localObject1 = null;
      label83:
      ((View)localObject1).setOnClickListener((View.OnClickListener)this);
      localObject1 = this.njg;
      if (localObject1 != null) {
        break label279;
      }
      s.bIx("retryTip");
      localObject1 = null;
      label108:
      ((TextView)localObject1).setOnClickListener((View.OnClickListener)this);
      localObject1 = this.Djs;
      if (localObject1 != null) {
        break label282;
      }
      s.bIx("emptyAction");
      localObject1 = null;
      label133:
      ((TextView)localObject1).setOnClickListener((View.OnClickListener)this);
      localObject1 = this.Djn;
      if (localObject1 != null) {
        break label285;
      }
      s.bIx("serviceGroup");
      localObject1 = null;
      label158:
      ((View)localObject1).setOnClickListener((View.OnClickListener)this);
      localObject1 = this.Djx;
      if (localObject1 != null) {
        ((View)localObject1).setOnClickListener((View.OnClickListener)this);
      }
      localObject1 = new g(this);
      erY().a((RecyclerView.k)localObject1);
      ah localah = ah.aiuX;
      this.DjG = ((RecyclerView.k)localObject1);
      localObject1 = this.Dji;
      if (localObject1 != null) {
        break label288;
      }
      s.bIx("contentGroup");
      localObject1 = localObject2;
    }
    label273:
    label276:
    label279:
    label282:
    label285:
    label288:
    for (;;)
    {
      ((FinderLiveShoppingPanel)localObject1).setOnVisibilityListener((kotlin.g.a.b)new h(this));
      this.Djy.DSJ = this;
      this.Djz.DSJ = this;
      AppMethodBeat.o(355680);
      return;
      break;
      break label58;
      break label83;
      break label108;
      break label133;
      break label158;
    }
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(355661);
    if (paramInt1 == 1013)
    {
      if (paramInt2 == -1)
      {
        Object localObject1;
        boolean bool;
        if (paramIntent == null)
        {
          localObject1 = null;
          if (paramIntent != null) {
            break label192;
          }
          bool = false;
        }
        Object localObject2;
        label192:
        long l1;
        long l2;
        String str;
        for (;;)
        {
          if (localObject1 != null)
          {
            s.u(localObject1, "allList");
            paramIntent = aj.CGT;
            paramIntent = aj.getFinderLiveAssistant();
            if (paramIntent != null)
            {
              localObject2 = this.mJe.getContext();
              if (localObject2 == null)
              {
                paramIntent = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
                AppMethodBeat.o(355661);
                throw paramIntent;
                localObject1 = paramIntent.getStringArrayListExtra("KEY_PRODUCTLIST");
                if (localObject1 == null)
                {
                  localObject1 = null;
                  break;
                }
                localObject2 = (Iterable)localObject1;
                localObject1 = (Collection)new ArrayList(kotlin.a.p.a((Iterable)localObject2, 10));
                localObject2 = ((Iterable)localObject2).iterator();
                while (((Iterator)localObject2).hasNext()) {
                  ((Collection)localObject1).add(Long.valueOf(Util.safeParseLong((String)((Iterator)localObject2).next())));
                }
                localObject1 = (List)localObject1;
                break;
                bool = paramIntent.getBooleanExtra("KEY_DELETE", false);
                continue;
              }
              localObject2 = (MMActivity)localObject2;
              l1 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).liveInfo.liveId;
              l2 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).hKN;
              str = ((e)business(e.class)).mIC;
              com.tencent.mm.plugin.finder.live.utils.a locala = com.tencent.mm.plugin.finder.live.utils.a.DJT;
              if (!bool) {
                break label356;
              }
            }
          }
        }
        label356:
        for (paramInt1 = 102;; paramInt1 = 101)
        {
          paramIntent.a((MMActivity)localObject2, l1, l2, str, com.tencent.mm.plugin.finder.live.utils.a.b(paramInt1, new LinkedList((Collection)localObject1)), (kotlin.g.a.q)new r(this));
          Log.i(TAG, "list:" + localObject1 + ",delete:" + bool);
          AppMethodBeat.o(355661);
          return;
        }
      }
      Log.i(TAG, s.X("onActivityResult:REQUEST_MANAGER_PRODUCT,resultCode:", Integer.valueOf(paramInt2)));
    }
    AppMethodBeat.o(355661);
  }
  
  public final boolean onBackPress()
  {
    AppMethodBeat.i(355503);
    if (this.mJe.getVisibility() == 0)
    {
      esb();
      AppMethodBeat.o(355503);
      return true;
    }
    boolean bool = super.onBackPress();
    AppMethodBeat.o(355503);
    return bool;
  }
  
  public final void onClick(View paramView)
  {
    int i = 4;
    Object localObject1 = null;
    Object localObject2 = null;
    AppMethodBeat.i(355634);
    Object localObject3 = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject3).cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/plugin/FinderLiveShoppingListPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject3).aYj());
    int j;
    if (paramView == null)
    {
      paramView = null;
      j = p.e.BSm;
      if (paramView != null) {
        break label146;
      }
      label64:
      j = p.e.BUG;
      if (paramView != null) {
        break label197;
      }
      label72:
      j = p.e.BSv;
      if (paramView != null) {
        break label212;
      }
      label80:
      j = p.e.BSy;
      if (paramView != null) {
        break label626;
      }
      label88:
      j = p.e.BSp;
      if (paramView != null) {
        break label658;
      }
      label96:
      j = p.e.BSA;
      if (paramView != null) {
        break label673;
      }
      label104:
      j = p.e.BSu;
      if (paramView != null) {
        break label1019;
      }
    }
    label146:
    label190:
    label197:
    label212:
    label379:
    while (paramView.intValue() != j) {
      for (;;)
      {
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/plugin/FinderLiveShoppingListPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(355634);
        return;
        paramView = Integer.valueOf(paramView.getId());
        break;
        if (paramView.intValue() != j) {
          break label64;
        }
        paramView = this.Dju;
        if (paramView == null)
        {
          s.bIx("secondaryPageContainer");
          paramView = (View)localObject2;
        }
        for (;;)
        {
          if (paramView.getVisibility() != 0) {
            break label190;
          }
          rB(true);
          break;
        }
        esb();
        continue;
        if (paramView.intValue() != j) {
          break label72;
        }
        esb();
        continue;
        if (paramView.intValue() != j) {
          break label80;
        }
        if (!eqc())
        {
          localObject2 = TAG;
          localObject3 = new StringBuilder("gotoShoppingOrder appId:");
          paramView = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.q)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.q.class)).Eia;
          if (paramView == null)
          {
            paramView = null;
            localObject3 = ((StringBuilder)localObject3).append(paramView).append(",path:");
            paramView = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.q)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.q.class)).Eia;
            if (paramView != null) {
              break label379;
            }
            paramView = (View)localObject1;
          }
          for (;;)
          {
            Log.i((String)localObject2, paramView);
            paramView = com.tencent.mm.plugin.finder.storage.d.FAy;
            if (((Number)com.tencent.mm.plugin.finder.storage.d.eRT().bmg()).intValue() != 0) {
              break label402;
            }
            paramView = com.tencent.mm.plugin.finder.live.k.Bxu;
            com.tencent.mm.plugin.finder.live.k.a(getBuContext(), (m)new d(this));
            break;
            paramView = paramView.ZRs;
            if (paramView == null)
            {
              paramView = null;
              break label264;
            }
            paramView = paramView.appId;
            break label264;
            localObject4 = paramView.ZRs;
            paramView = (View)localObject1;
            if (localObject4 != null) {
              paramView = ((bzd)localObject4).aail;
            }
          }
          localObject2 = new Intent();
          localObject3 = new dzi();
          paramView = com.tencent.mm.plugin.finder.live.report.k.Doi;
          s.u(localObject3, "struct");
          ((dzi)localObject3).abed = com.tencent.mm.plugin.expt.hellhound.core.b.hF(com.tencent.mm.plugin.finder.live.report.k.liveId);
          ((dzi)localObject3).feedID = com.tencent.mm.plugin.expt.hellhound.core.b.hF(com.tencent.mm.plugin.finder.live.report.k.feedId);
          ((dzi)localObject3).userName = com.tencent.mm.plugin.finder.live.report.k.zDJ;
          localObject1 = com.tencent.mm.plugin.expt.hellhound.ext.session.a.c.dLD().dHN();
          paramView = (View)localObject1;
          if (localObject1 == null) {
            paramView = "";
          }
          ((dzi)localObject3).FUP = paramView;
          ((dzi)localObject3).Dol = com.tencent.mm.plugin.finder.live.report.k.Dol;
          localObject1 = com.tencent.mm.plugin.expt.hellhound.core.b.bys();
          paramView = (View)localObject1;
          if (localObject1 == null) {
            paramView = "";
          }
          ((dzi)localObject3).zIO = paramView;
          ((dzi)localObject3).sessionBuffer = String.valueOf(com.tencent.mm.plugin.finder.live.report.k.E(com.tencent.mm.plugin.finder.live.report.k.feedId, com.tencent.mm.plugin.finder.live.report.k.Dol));
          paramView = com.tencent.mm.plugin.finder.live.report.j.Dob;
          ((dzi)localObject3).CRV = ((int)com.tencent.mm.plugin.finder.live.report.q.aB(((dzi)localObject3).Dol, com.tencent.mm.plugin.finder.live.report.k.ACR));
          ((dzi)localObject3).abee = com.tencent.mm.plugin.finder.live.report.k.DnT;
          paramView = a.e.HbQ;
          ((Intent)localObject2).putExtra(a.e.fro(), ((dzi)localObject3).toByteArray());
          paramView = a.e.HbQ;
          ((Intent)localObject2).putExtra(a.e.frp(), 2);
          paramView = com.tencent.mm.plugin.finder.order.a.ESd;
          paramView = this.mJe.getContext();
          s.s(paramView, "root.context");
          com.tencent.mm.plugin.finder.order.a.Q(paramView, (Intent)localObject2);
          continue;
          if (paramView.intValue() != j) {
            break label88;
          }
          if (eqc()) {}
          for (i = 0;; i = 4)
          {
            a(null, i, true);
            break;
          }
          if (paramView.intValue() != j) {
            break label96;
          }
          esk();
          continue;
          if (paramView.intValue() != j) {
            break label104;
          }
          i = com.tencent.mm.kernel.h.baE().ban().getInt(at.a.adaO, 4);
          long l = com.tencent.mm.kernel.h.baE().ban().a(at.a.adfr, 0L);
          Log.i(TAG, s.X("lastShowNoteTime ", Long.valueOf(l)));
          if ((i != 1) && (System.currentTimeMillis() - l > 86400000L))
          {
            com.tencent.mm.kernel.h.baE().ban().set(at.a.adfr, Long.valueOf(System.currentTimeMillis()));
            esb();
            paramView = new com.tencent.mm.ui.widget.a.h(this.mJe.getContext());
            paramView.jHQ();
            paramView.aFa(p.f.CfK);
            com.tencent.mm.ui.aw.a((Paint)((TextView)paramView.rootView.findViewById(p.e.finder_mm_bottom_sheet_title)).getPaint(), 0.8F);
            localObject4 = paramView.rootView.findViewById(p.e.finder_mm_bottom_sheet_item1);
            localObject1 = (ImageView)((View)localObject4).findViewById(p.e.icon);
            localObject2 = (TextView)((View)localObject4).findViewById(p.e.title);
            localObject3 = (TextView)((View)localObject4).findViewById(p.e.desc);
            ((ImageView)((View)localObject4).findViewById(p.e.right_icon)).setVisibility(8);
            localObject4 = this.mJe.getContext();
            localObject5 = com.tencent.mm.plugin.finder.utils.aw.Gjk;
            ((TextView)localObject2).setText((CharSequence)com.tencent.mm.pluginsdk.ui.span.p.b((Context)localObject4, (CharSequence)com.tencent.mm.plugin.finder.utils.aw.Ud(2)));
            ((TextView)localObject2).setTextColor(com.tencent.mm.cd.a.w(this.mJe.getContext(), p.b.BW_100_Alpha_0_8));
            ((TextView)localObject3).setVisibility(8);
            com.tencent.mm.ui.i.a.a.g((ImageView)localObject1, z.bAM());
            ((Button)paramView.rootView.findViewById(p.e.ok_btn)).setOnClickListener(new bz..ExternalSyntheticLambda3(paramView, this));
            ((Button)paramView.rootView.findViewById(p.e.cancel_btn)).setOnClickListener(new bz..ExternalSyntheticLambda4(paramView, this));
            paramView.dDn();
          }
          else
          {
            rD(false);
          }
        }
      }
    }
    label264:
    label402:
    label626:
    label1019:
    Log.i(TAG, "[onClickOptionView]");
    label658:
    label673:
    esb();
    paramView = new com.tencent.mm.ui.widget.a.h(this.mJe.getContext());
    paramView.jHQ();
    paramView.aFa(p.f.Cfj);
    com.tencent.mm.ui.aw.a((Paint)((TextView)paramView.rootView.findViewById(p.e.BRl)).getPaint(), 0.8F);
    localObject1 = (MMSwitchBtn)paramView.rootView.findViewById(p.e.BRm);
    localObject2 = paramView.rootView.findViewById(p.e.BSn);
    localObject3 = paramView.rootView.findViewById(p.e.BRk);
    Object localObject4 = paramView.rootView.findViewById(p.e.BQZ);
    Object localObject5 = paramView.rootView.findViewById(p.e.BRa);
    View localView1 = paramView.rootView.findViewById(p.e.BRi);
    View localView2 = paramView.rootView.findViewById(p.e.BRj);
    buh localbuh = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.q)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.q.class)).Ein;
    boolean bool;
    if (localbuh != null)
    {
      if (localbuh.ZTl != 1) {
        break label1356;
      }
      bool = true;
      label1212:
      ((MMSwitchBtn)localObject1).setCheck(bool);
      if (localbuh.ZTl == 1) {
        i = 0;
      }
      ((View)localObject3).setVisibility(i);
      switch (localbuh.ZTm)
      {
      }
    }
    for (;;)
    {
      ((MMSwitchBtn)localObject1).setSwitchListener((MMSwitchBtn.a)new t(localbuh, this, (MMSwitchBtn)localObject1, (View)localObject3, (View)localObject4, (View)localObject5));
      localView1.setOnClickListener(new bz..ExternalSyntheticLambda0(this, (View)localObject4, (View)localObject5));
      localView2.setOnClickListener(new bz..ExternalSyntheticLambda1(this, (View)localObject4, (View)localObject5));
      ((View)localObject2).setOnClickListener(new bz..ExternalSyntheticLambda2(paramView));
      paramView.dDn();
      paramView.agfD = new bz..ExternalSyntheticLambda5(this);
      break;
      label1356:
      bool = false;
      break label1212;
      ((View)localObject4).setVisibility(0);
      continue;
      ((View)localObject5).setVisibility(0);
    }
  }
  
  public final void onNewIntent(Intent paramIntent)
  {
    boolean bool = false;
    AppMethodBeat.i(355518);
    if (paramIntent == null) {}
    for (;;)
    {
      Log.i(TAG, s.X("clickEmptyAreaClose = ", Boolean.valueOf(bool)));
      if (bool) {
        esb();
      }
      AppMethodBeat.o(355518);
      return;
      bool = paramIntent.getBooleanExtra("extra_start_by_half_screen_empty_area_click_scene", false);
    }
  }
  
  public final void statusChange(b.c paramc, Bundle paramBundle)
  {
    int i = 0;
    int j = 0;
    Object localObject1 = null;
    Object localObject2 = null;
    AppMethodBeat.i(355555);
    s.u(paramc, "status");
    switch (b.$EnumSwitchMapping$0[paramc.ordinal()])
    {
    default: 
    case 1: 
    case 2: 
      do
      {
        do
        {
          AppMethodBeat.o(355555);
          return;
          localObject1 = this.Dju;
          paramc = (b.c)localObject1;
          if (localObject1 == null)
          {
            s.bIx("secondaryPageContainer");
            paramc = null;
          }
          paramc.setVisibility(8);
          if ((((e)business(e.class)).isLiveStarted()) || ((eqc()) && (((e)business(e.class)).eyz())))
          {
            if (!eqc()) {
              break;
            }
            i = 0;
            a(paramBundle, i, false);
          }
          if (!eqc()) {
            break label650;
          }
          if (!erp()) {
            break label245;
          }
          com.tencent.mm.plugin.finder.live.report.k.Doi.aA(3, 0, 0);
          paramc = this.Djx;
        } while (paramc == null);
        paramBundle = com.tencent.mm.plugin.finder.live.utils.a.DJT;
        if ((com.tencent.mm.plugin.finder.live.utils.a.bUx()) && (com.tencent.mm.ae.d.ee((int)((com.tencent.mm.plugin.finder.live.viewmodel.data.business.q)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.q.class)).Eio, 1))) {}
        for (i = j;; i = 8)
        {
          paramc.setVisibility(i);
          AppMethodBeat.o(355555);
          return;
          i = 2;
          break;
          paramc = getBuContext();
          paramBundle = new JSONObject();
          paramBundle.put("type", q.as.Dzm.action);
          localObject1 = com.tencent.mm.plugin.finder.live.report.j.Dob;
          paramBundle.put("sessionid", com.tencent.mm.plugin.finder.live.report.j.Doc.DpP);
          paramBundle.put("shopwindowid", "");
          if (((e)paramc.business(e.class)).eyz())
          {
            com.tencent.mm.plugin.finder.live.report.j.Dob.C(q.a.DqI.mwI, paramBundle.toString());
            break label185;
          }
          if (!((e)paramc.business(e.class)).isLiveStarted()) {
            break label185;
          }
          paramc = com.tencent.mm.plugin.finder.live.report.j.Dob;
          if (com.tencent.mm.plugin.finder.live.report.j.Doc.Dqu) {
            paramBundle.put("type", q.as.Dzt.action);
          }
          paramc = com.tencent.mm.plugin.finder.live.model.context.a.CMm;
          paramc = com.tencent.mm.plugin.finder.live.model.context.a.emY();
          long l;
          if (paramc == null)
          {
            paramc = localObject2;
            paramBundle.put("appid", paramc);
            paramc = com.tencent.mm.plugin.finder.live.model.context.a.CMm;
            paramc = com.tencent.mm.plugin.finder.live.model.context.a.emY();
            if (paramc != null) {
              break label534;
            }
            l = -1L;
            if (l >= 0L) {
              break label583;
            }
            paramBundle.put("liveid", "");
            paramc = com.tencent.mm.plugin.expt.hellhound.ext.b.b.c.zGj;
            paramBundle.put("clickid", com.tencent.mm.plugin.expt.hellhound.ext.b.b.c.dKp());
            paramc = com.tencent.mm.plugin.expt.hellhound.ext.b.b.c.zGj;
            com.tencent.mm.plugin.expt.hellhound.ext.b.b.c.a.arH("");
            paramc = com.tencent.mm.plugin.finder.live.model.context.a.CMm;
            paramc = com.tencent.mm.plugin.finder.live.model.context.a.emY();
            if (paramc != null) {
              break label599;
            }
            paramc = "";
          }
          for (;;)
          {
            paramBundle.put("productid", paramc);
            com.tencent.mm.plugin.finder.live.report.j.Dob.a(q.c.Drn, paramBundle.toString());
            break;
            localObject1 = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.q)paramc.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.q.class);
            paramc = localObject2;
            if (localObject1 == null) {
              break label395;
            }
            paramc = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.q)localObject1).Eii;
            break label395;
            paramc = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)paramc.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class);
            if (paramc == null)
            {
              l = -1L;
              break label421;
            }
            paramc = paramc.liveInfo;
            if (paramc == null)
            {
              l = -1L;
              break label421;
            }
            l = paramc.liveId;
            break label421;
            paramBundle.put("liveid", com.tencent.mm.plugin.expt.hellhound.core.b.hF(l));
            break label439;
            paramc = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.q)paramc.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.q.class);
            if (paramc == null)
            {
              paramc = "";
            }
            else
            {
              paramc = paramc.Eie;
              if (paramc == null) {
                paramc = "";
              } else {
                paramc = Long.valueOf(paramc.bZA());
              }
            }
          }
          com.tencent.mm.plugin.finder.live.report.k.a(com.tencent.mm.plugin.finder.live.report.k.Doi, q.bx.DDH, null, null);
          break label185;
        }
        tO(8);
      } while (eqc());
      com.tencent.mm.plugin.finder.live.report.k.a(com.tencent.mm.plugin.finder.live.report.k.Doi, q.bx.DDO, null, null);
      AppMethodBeat.o(355555);
      return;
    case 3: 
      ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.q)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.q.class)).aNm();
      tO(8);
      AppMethodBeat.o(355555);
      return;
    case 4: 
      Log.i(TAG, s.X("refresh shop page,view visibility:", Integer.valueOf(this.mJe.getVisibility())));
      if (eqc()) {}
      for (;;)
      {
        a(paramBundle, i, true);
        AppMethodBeat.o(355555);
        return;
        i = 3;
      }
    case 5: 
      label185:
      label245:
      paramc = (Collection)((com.tencent.mm.plugin.finder.live.viewmodel.data.business.q)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.q.class)).Eic;
      label395:
      label421:
      label439:
      label583:
      label599:
      if ((paramc == null) || (paramc.isEmpty()))
      {
        i = 1;
        if (i == 0)
        {
          rB(false);
          paramBundle = this.DeW;
          paramc = paramBundle;
          if (paramBundle == null)
          {
            s.bIx("emptyGroup");
            paramc = null;
          }
          paramc.setVisibility(8);
          paramBundle = this.njj;
          paramc = paramBundle;
          if (paramBundle == null)
          {
            s.bIx("loadingBar");
            paramc = null;
          }
          paramc.setVisibility(8);
          paramBundle = this.njm;
          paramc = paramBundle;
          if (paramBundle == null)
          {
            s.bIx("titleGroup");
            paramc = null;
          }
          paramc.setVisibility(0);
          erY().setVisibility(0);
          paramBundle = this.njg;
          paramc = paramBundle;
          if (paramBundle == null)
          {
            s.bIx("retryTip");
            paramc = null;
          }
          paramc.setVisibility(8);
          rC(false);
          paramc = this.Djy;
          paramBundle = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.q)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.q.class)).Eic;
          s.u(paramBundle, "productList");
          paramc.DTg.clear();
          paramc.DTg.addAll((Collection)paramBundle);
          paramc.bZE.notifyChanged();
          paramc = this.Dji;
          if (paramc != null) {
            break label1032;
          }
          s.bIx("contentGroup");
          paramc = (b.c)localObject1;
        }
      }
      label1032:
      for (;;)
      {
        label534:
        paramc.post(new bz..ExternalSyntheticLambda6(this));
        label650:
        esa();
        tO(0);
        AppMethodBeat.o(355555);
        return;
        i = 0;
        break;
      }
    }
    paramc = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.q)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.q.class);
    if (paramc == null) {}
    for (paramc = null;; paramc = paramc.Eib)
    {
      a(paramc, null);
      break;
    }
  }
  
  public final void unMount()
  {
    AppMethodBeat.i(355695);
    super.unMount();
    Object localObject1 = this.Djy;
    ((ae)localObject1).DTk = null;
    ((ae)localObject1).DTl = null;
    ((ae)localObject1).DTm = null;
    ((ae)localObject1).DTn = null;
    ((ae)localObject1).DTo = null;
    ((ae)localObject1).DTp = null;
    ((ae)localObject1).DSK = null;
    this.DjA.DTk = null;
    this.Djz.DSK = null;
    Object localObject2 = this.niW;
    localObject1 = localObject2;
    if (localObject2 == null)
    {
      s.bIx("blankArea");
      localObject1 = null;
    }
    ((View)localObject1).setOnClickListener(null);
    localObject2 = this.yls;
    localObject1 = localObject2;
    if (localObject2 == null)
    {
      s.bIx("close");
      localObject1 = null;
    }
    ((View)localObject1).setOnClickListener(null);
    localObject2 = this.Djk;
    localObject1 = localObject2;
    if (localObject2 == null)
    {
      s.bIx("orderGroup");
      localObject1 = null;
    }
    ((View)localObject1).setOnClickListener(null);
    localObject2 = this.njg;
    localObject1 = localObject2;
    if (localObject2 == null)
    {
      s.bIx("retryTip");
      localObject1 = null;
    }
    ((TextView)localObject1).setOnClickListener(null);
    localObject2 = this.Djs;
    localObject1 = localObject2;
    if (localObject2 == null)
    {
      s.bIx("emptyAction");
      localObject1 = null;
    }
    ((TextView)localObject1).setOnClickListener(null);
    localObject2 = this.Djn;
    localObject1 = localObject2;
    if (localObject2 == null)
    {
      s.bIx("serviceGroup");
      localObject1 = null;
    }
    ((View)localObject1).setOnClickListener(null);
    localObject1 = this.DjG;
    if (localObject1 != null) {
      erY().b((RecyclerView.k)localObject1);
    }
    this.DjG = null;
    localObject2 = this.Dji;
    localObject1 = localObject2;
    if (localObject2 == null)
    {
      s.bIx("contentGroup");
      localObject1 = null;
    }
    ((FinderLiveShoppingPanel)localObject1).setOnVisibilityListener(null);
    this.Djy.DSJ = null;
    this.Djz.DSJ = null;
    AppMethodBeat.o(355695);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "<anonymous parameter 0>", "", "bundle", "Lcom/tencent/mm/plugin/appbrand/api/WeAppOpenBundle;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements m<Boolean, g, ah>
  {
    c(bz parambz)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "<anonymous parameter 0>", "", "bundle", "Lcom/tencent/mm/plugin/appbrand/api/WeAppOpenBundle;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements m<Boolean, g, ah>
  {
    d(bz parambz)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/live/plugin/FinderLiveShoppingListPlugin$hideMaskView$1", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class e
    implements Animator.AnimatorListener
  {
    e(bz parambz) {}
    
    public final void onAnimationCancel(Animator paramAnimator) {}
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(354158);
      com.tencent.mm.live.b.b.b.a(bz.m(this.DjJ), b.c.ndC);
      AppMethodBeat.o(354158);
    }
    
    public final void onAnimationRepeat(Animator paramAnimator) {}
    
    public final void onAnimationStart(Animator paramAnimator) {}
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/live/plugin/FinderLiveShoppingListPlugin$hideSecondaryPage$1", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class f
    implements Animator.AnimatorListener
  {
    f(bz parambz) {}
    
    public final void onAnimationCancel(Animator paramAnimator) {}
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(354306);
      FrameLayout localFrameLayout = bz.o(this.DjJ);
      paramAnimator = localFrameLayout;
      if (localFrameLayout == null)
      {
        s.bIx("secondaryPageContainer");
        paramAnimator = null;
      }
      paramAnimator.setVisibility(8);
      AppMethodBeat.o(354306);
    }
    
    public final void onAnimationRepeat(Animator paramAnimator) {}
    
    public final void onAnimationStart(Animator paramAnimator) {}
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/live/plugin/FinderLiveShoppingListPlugin$initListener$1", "Landroidx/recyclerview/widget/RecyclerView$OnItemTouchListener;", "onInterceptTouchEvent", "", "rv", "Landroidx/recyclerview/widget/RecyclerView;", "motionEvent", "Landroid/view/MotionEvent;", "onRequestDisallowInterceptTouchEvent", "", "p0", "onTouchEvent", "p1", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class g
    implements RecyclerView.k
  {
    g(bz parambz) {}
    
    public final boolean a(RecyclerView paramRecyclerView, MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(354291);
      s.u(paramRecyclerView, "rv");
      s.u(paramMotionEvent, "motionEvent");
      bz.k(this.DjJ)[0] = ((int)paramMotionEvent.getRawX());
      bz.k(this.DjJ)[1] = ((int)paramMotionEvent.getRawY());
      AppMethodBeat.o(354291);
      return false;
    }
    
    public final void aX(boolean paramBoolean) {}
    
    public final void b(RecyclerView paramRecyclerView, MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(354280);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.cH(paramRecyclerView);
      localb.cH(paramMotionEvent);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/plugin/FinderLiveShoppingListPlugin$initListener$1", "androidx/recyclerview/widget/RecyclerView$OnItemTouchListener", "onTouchEvent", "(Landroidx/recyclerview/widget/RecyclerView;Landroid/view/MotionEvent;)V", this, localb.aYj());
      s.u(paramRecyclerView, "p0");
      s.u(paramMotionEvent, "p1");
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/plugin/FinderLiveShoppingListPlugin$initListener$1", "androidx/recyclerview/widget/RecyclerView$OnItemTouchListener", "onTouchEvent", "(Landroidx/recyclerview/widget/RecyclerView;Landroid/view/MotionEvent;)V");
      AppMethodBeat.o(354280);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "isShow", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class h
    extends u
    implements kotlin.g.a.b<Boolean, ah>
  {
    h(bz parambz)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "empty", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class i
    extends u
    implements kotlin.g.a.b<Boolean, ah>
  {
    i(bz parambz)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "promting", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class j
    extends u
    implements kotlin.g.a.b<Boolean, ah>
  {
    j(bz parambz)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "holder", "Lcom/tencent/mm/plugin/finder/live/view/adapter/holder/FinderLiveShoppingViewHolder;", "itemView", "Landroid/view/View;", "pos", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class k
    extends u
    implements kotlin.g.a.q<com.tencent.mm.plugin.finder.live.view.adapter.holder.d, View, Integer, ah>
  {
    k(bz parambz, ae paramae)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "productId", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class l
    extends u
    implements kotlin.g.a.b<Long, ah>
  {
    l(bz parambz)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/live/plugin/FinderLiveShoppingListPlugin$initShoppingListAdapter$1$5", "Lcom/tencent/mm/plugin/finder/live/view/adapter/holder/FinderLiveShoppingHeaderViewHolder$ShoppingHeaderViewCallback;", "onClickAdd", "", "onClickManage", "onClickMore", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class m
    implements com.tencent.mm.plugin.finder.live.view.adapter.holder.b.b
  {
    m(bz parambz) {}
    
    public final void esl()
    {
      AppMethodBeat.i(354276);
      bz.y(this.DjJ);
      AppMethodBeat.o(354276);
    }
    
    public final void esm()
    {
      AppMethodBeat.i(354284);
      bz.z(this.DjJ);
      if (bz.g(this.DjJ)) {
        com.tencent.mm.plugin.finder.live.report.k.Doi.aA(2, 5, 0);
      }
      AppMethodBeat.o(354284);
    }
    
    public final void esn()
    {
      AppMethodBeat.i(354293);
      bz.A(this.DjJ);
      if (bz.g(this.DjJ)) {
        com.tencent.mm.plugin.finder.live.report.k.Doi.aA(2, 6, 0);
      }
      AppMethodBeat.o(354293);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/live/plugin/FinderLiveShoppingListPlugin$initShoppingListAdapter$couponActionButtonClickCallback$1", "Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveShoppingCouponView$Callback;", "onActionButtonClicked", "", "item", "Lcom/tencent/mm/plugin/finder/live/view/convert/ShopWindowCouponItem;", "view", "Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveShoppingCouponView;", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class n
    implements FinderLiveShoppingCouponView.a
  {
    n(bz parambz) {}
    
    public final void a(final com.tencent.mm.plugin.finder.live.view.convert.j paramj, final FinderLiveShoppingCouponView paramFinderLiveShoppingCouponView)
    {
      int i = 1;
      AppMethodBeat.i(354264);
      s.u(paramj, "item");
      s.u(paramFinderLiveShoppingCouponView, "view");
      Object localObject1;
      label106:
      label118:
      Object localObject2;
      if (bz.f(this.DjJ))
      {
        boolean bool;
        if (!paramj.DVc)
        {
          bool = true;
          if (!bz.g(this.DjJ)) {
            break label106;
          }
          com.tencent.mm.plugin.finder.live.report.k.Doi.aA(1, 4, 0);
        }
        for (;;)
        {
          localObject1 = bz.getFinderLiveAssistant();
          if (localObject1 == null) {
            break label303;
          }
          paramFinderLiveShoppingCouponView = this.DjJ.mJe.getContext();
          if (paramFinderLiveShoppingCouponView != null) {
            break label118;
          }
          paramj = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
          AppMethodBeat.o(354264);
          throw paramj;
          bool = false;
          break;
          paramFinderLiveShoppingCouponView = bz.Djh;
          bz.a.rE(bool);
        }
        localObject2 = (MMActivity)paramFinderLiveShoppingCouponView;
        paramFinderLiveShoppingCouponView = paramj.mdN;
        if (paramFinderLiveShoppingCouponView == null)
        {
          paramFinderLiveShoppingCouponView = "";
          if (!bool) {
            break label178;
          }
        }
        for (;;)
        {
          ((ap)localObject1).a((MMActivity)localObject2, paramFinderLiveShoppingCouponView, i, (m)new a(bool, paramj, this.DjJ));
          AppMethodBeat.o(354264);
          return;
          break;
          label178:
          i = 2;
        }
      }
      ap localap = bz.getFinderLiveAssistant();
      if (localap != null)
      {
        localObject1 = this.DjJ.mJe.getContext();
        if (localObject1 == null)
        {
          paramj = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
          AppMethodBeat.o(354264);
          throw paramj;
        }
        MMActivity localMMActivity = (MMActivity)localObject1;
        LinkedList localLinkedList = new LinkedList();
        localObject2 = paramj.mdN;
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = "";
        }
        localLinkedList.add(localObject1);
        localObject1 = ah.aiuX;
        localap.a(localMMActivity, localLinkedList, true, (m)new b(paramj, paramFinderLiveShoppingCouponView, this.DjJ));
      }
      label303:
      AppMethodBeat.o(354264);
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", "", "success", "", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderLiveIssueCouponResponse;"}, k=3, mv={1, 5, 1}, xi=48)
    static final class a
      extends u
      implements m<Boolean, bir, ah>
    {
      a(boolean paramBoolean, com.tencent.mm.plugin.finder.live.view.convert.j paramj, bz parambz)
      {
        super();
      }
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", "", "success", "", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderLiveReceiveCouponResponse;"}, k=3, mv={1, 5, 1}, xi=48)
    static final class b
      extends u
      implements m<Boolean, blp, ah>
    {
      b(com.tencent.mm.plugin.finder.live.view.convert.j paramj, FinderLiveShoppingCouponView paramFinderLiveShoppingCouponView, bz parambz)
      {
        super();
      }
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "sourceType", "", "bundle", "Lcom/tencent/mm/plugin/appbrand/api/WeAppOpenBundle;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class o
    extends u
    implements m<Integer, g, ah>
  {
    o(bz parambz)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "success", "", "errmsg", "", "<anonymous parameter 2>", "Lcom/tencent/mm/protocal/protobuf/FinderLiveModShopShelfResponse;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class r
    extends u
    implements kotlin.g.a.q<Boolean, String, bkd, ah>
  {
    r(bz parambz)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/live/plugin/FinderLiveShoppingListPlugin$notifyVisitorShopping$1", "Lcom/tencent/mm/plugin/finder/live/cgi/CgiFinderLiveAnchorStatus$CallBack;", "onFail", "", "errType", "", "errCode", "errMsg", "", "anchorStatus", "onSuccess", "micSettingFlag", "", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class s
    implements com.tencent.mm.plugin.finder.live.cgi.e.a
  {
    s(bz parambz) {}
    
    public final void a(bvg parambvg)
    {
      AppMethodBeat.i(354492);
      s.u(this, "this");
      AppMethodBeat.o(354492);
    }
    
    public final void am(int paramInt, long paramLong)
    {
      AppMethodBeat.i(354478);
      bz.t(this.DjJ);
      bz.a locala = bz.Djh;
      Log.i(bz.access$getTAG$cp(), s.X("notify visitor shopping success times:", Integer.valueOf(bz.u(this.DjJ))));
      AppMethodBeat.o(354478);
    }
    
    public final void b(int paramInt1, int paramInt2, String paramString, int paramInt3)
    {
      AppMethodBeat.i(354484);
      paramString = bz.Djh;
      Log.i(bz.access$getTAG$cp(), s.X("notify visitor shopping fail times:", Integer.valueOf(bz.u(this.DjJ))));
      this.DjJ.esj();
      AppMethodBeat.o(354484);
    }
    
    public final void eho()
    {
      AppMethodBeat.i(354501);
      s.u(this, "this");
      AppMethodBeat.o(354501);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/live/plugin/FinderLiveShoppingListPlugin$onClickReplayOptionView$1$1$1", "Lcom/tencent/mm/ui/widget/MMSwitchBtn$ISwitch;", "onStatusChange", "", "check", "", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class t
    implements MMSwitchBtn.a
  {
    t(buh parambuh, bz parambz, MMSwitchBtn paramMMSwitchBtn, View paramView1, View paramView2, View paramView3) {}
    
    public final void onStatusChange(boolean paramBoolean)
    {
      AppMethodBeat.i(354457);
      if (!paramBoolean) {
        com.tencent.mm.plugin.finder.live.report.j.a(com.tencent.mm.plugin.finder.live.report.j.Dob, 2, this.DjQ.ZTm);
      }
      for (int i = 2;; i = 1)
      {
        bz.a(jdField_this, i, this.DjQ.ZTm, (kotlin.g.a.q)new a(this.DjR, this.DjS, this.DjT, this.DjU, this.DjQ, jdField_this, this));
        AppMethodBeat.o(354457);
        return;
        com.tencent.mm.plugin.finder.live.report.j.a(com.tencent.mm.plugin.finder.live.report.j.Dob, 1, this.DjQ.ZTm);
      }
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", "", "succuss", "", "switch", "", "type"}, k=3, mv={1, 5, 1}, xi=48)
    static final class a
      extends u
      implements kotlin.g.a.q<Boolean, Integer, Integer, ah>
    {
      a(MMSwitchBtn paramMMSwitchBtn, View paramView1, View paramView2, View paramView3, buh parambuh, bz parambz, bz.t paramt)
      {
        super();
      }
      
      private static final void a(MMSwitchBtn paramMMSwitchBtn, bz.t paramt)
      {
        AppMethodBeat.i(353715);
        s.u(paramt, "this$0");
        paramMMSwitchBtn.setSwitchListener((MMSwitchBtn.a)paramt);
        AppMethodBeat.o(353715);
      }
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "succuss", "", "switch", "", "type"}, k=3, mv={1, 5, 1}, xi=48)
  static final class u
    extends u
    implements kotlin.g.a.q<Boolean, Integer, Integer, ah>
  {
    u(View paramView1, View paramView2, View paramView3)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "succuss", "", "switch", "", "type"}, k=3, mv={1, 5, 1}, xi=48)
  static final class v
    extends u
    implements kotlin.g.a.q<Boolean, Integer, Integer, ah>
  {
    v(View paramView1, View paramView2, View paramView3)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/live/plugin/FinderLiveShoppingListPlugin$reportExposed$1$1", "Lcom/tencent/mm/view/ExposeElves$OnRecyclerViewChildExposedListener;", "exposedSet", "Ljava/util/HashSet;", "", "getExposedSet", "()Ljava/util/HashSet;", "ignoreFlingExposed", "", "onChildExposeChanged", "", "parent", "Landroid/view/View;", "exposedHolders", "", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class w
    extends com.tencent.mm.view.e.a
  {
    private final HashSet<Long> AKl;
    
    w(bz parambz)
    {
      AppMethodBeat.i(354838);
      this.AKl = new HashSet();
      AppMethodBeat.o(354838);
    }
    
    public final void b(View paramView, List<? extends RecyclerView.v> paramList)
    {
      AppMethodBeat.i(354848);
      s.u(paramView, "parent");
      s.u(paramList, "exposedHolders");
      paramView = new ah.f();
      Object localObject1 = (Iterable)paramList;
      paramList = this.DjJ;
      localObject1 = ((Iterable)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = (RecyclerView.v)((Iterator)localObject1).next();
        localObject2 = bz.i(paramList).PC(bz.i(paramList).hN(((RecyclerView.v)localObject2).KJ(), 2));
        if (((localObject2 instanceof com.tencent.mm.plugin.finder.live.view.convert.k)) && (!this.AKl.contains(Long.valueOf(((com.tencent.mm.plugin.finder.live.view.convert.k)localObject2).DVk))))
        {
          this.AKl.add(Long.valueOf(((com.tencent.mm.plugin.finder.live.view.convert.k)localObject2).DVk));
          if (paramView.aqH == null) {
            paramView.aqH = new LinkedList();
          }
          LinkedList localLinkedList = (LinkedList)paramView.aqH;
          if (localLinkedList != null) {
            localLinkedList.add(Long.valueOf(((com.tencent.mm.plugin.finder.live.view.convert.k)localObject2).DVk));
          }
        }
      }
      paramList = bz.Djh;
      Log.i(bz.access$getTAG$cp(), s.X("[onChildExposeChanged] exposed=", paramView.aqH));
      paramList = (LinkedList)paramView.aqH;
      if (paramList != null) {
        if (!((Collection)paramList).isEmpty())
        {
          i = 1;
          if (i != 1) {
            break label277;
          }
        }
      }
      label277:
      for (int i = 1;; i = 0)
      {
        if (i != 0) {
          com.tencent.mm.ae.d.e("FinderLiveShoppingListExpose", (kotlin.g.a.a)new a(paramView, this, this.DjJ));
        }
        AppMethodBeat.o(354848);
        return;
        i = 0;
        break;
      }
    }
    
    public final boolean dXG()
    {
      return true;
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
    static final class a
      extends u
      implements kotlin.g.a.a<ah>
    {
      a(ah.f<LinkedList<Long>> paramf, bz.w paramw, bz parambz)
      {
        super();
      }
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/live/plugin/FinderLiveShoppingListPlugin$showProductList$1", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "onGlobalLayout", "", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class x
    implements ViewTreeObserver.OnGlobalLayoutListener
  {
    x(bz parambz, int paramInt) {}
    
    public final void onGlobalLayout()
    {
      AppMethodBeat.i(354812);
      this.DjJ.erY().getViewTreeObserver().removeOnGlobalLayoutListener((ViewTreeObserver.OnGlobalLayoutListener)this);
      int i;
      if (!bz.r(this.DjJ))
      {
        i = bz.i(this.DjJ).PA(i);
        localObject = this.DjJ.erY().getLayoutManager();
        if (!(localObject instanceof LinearLayoutManager)) {
          break label152;
        }
      }
      label152:
      for (Object localObject = (LinearLayoutManager)localObject;; localObject = null)
      {
        if (localObject != null) {
          ((LinearLayoutManager)localObject).bo(i, 0);
        }
        localObject = bz.Djh;
        Log.i(bz.access$getTAG$cp(), "showProductList size:" + bz.i(this.DjJ).DTh.size() + ",scrollToPosition:" + i + ", realPos: " + i);
        bz.s(this.DjJ);
        AppMethodBeat.o(354812);
        return;
      }
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "success", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class y
    extends u
    implements kotlin.g.a.b<Boolean, ah>
  {
    y(bz parambz, boolean paramBoolean1, Bundle paramBundle, boolean paramBoolean2)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/live/plugin/FinderLiveShoppingListPlugin$updateEmptyTipsPosition$1", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "onGlobalLayout", "", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class z
    implements ViewTreeObserver.OnGlobalLayoutListener
  {
    z(bz parambz) {}
    
    public final void onGlobalLayout()
    {
      Object localObject2 = null;
      AppMethodBeat.i(354884);
      this.DjJ.erY().getViewTreeObserver().removeOnGlobalLayoutListener((ViewTreeObserver.OnGlobalLayoutListener)this);
      Object localObject3 = bz.p(this.DjJ);
      Object localObject1 = localObject3;
      if (localObject3 == null)
      {
        s.bIx("emptyGroup");
        localObject1 = null;
      }
      localObject1 = ((View)localObject1).getParent();
      if (localObject1 == null)
      {
        localObject1 = new NullPointerException("null cannot be cast to non-null type android.view.View");
        AppMethodBeat.o(354884);
        throw ((Throwable)localObject1);
      }
      int k = ((View)localObject1).getHeight();
      localObject1 = bz.p(this.DjJ);
      int m;
      if (localObject1 == null)
      {
        s.bIx("emptyGroup");
        localObject1 = null;
        ((View)localObject1).setLayoutParams((ViewGroup.LayoutParams)new RelativeLayout.LayoutParams(-1, k));
        m = this.DjJ.erY().getChildCount();
        if (m <= 0) {
          break label342;
        }
      }
      int j;
      label207:
      label342:
      label347:
      label353:
      label360:
      for (int i = 0;; i = j)
      {
        j = i + 1;
        localObject1 = this.DjJ.erY().bj(this.DjJ.erY().getChildAt(i));
        if (((localObject1 instanceof com.tencent.mm.plugin.finder.live.view.adapter.holder.b)) && (((com.tencent.mm.plugin.finder.live.view.adapter.holder.b)localObject1).DUk == b.a.DUm))
        {
          i = ((RecyclerView.v)localObject1).caK.getBottom();
          j = com.tencent.mm.cd.a.bs(this.DjJ.mJe.getContext(), p.c.Edge_17A);
          localObject3 = bz.q(this.DjJ);
          localObject1 = localObject3;
          if (localObject3 == null)
          {
            s.bIx("emptyTips");
            localObject1 = null;
          }
          localObject1 = ((TextView)localObject1).getLayoutParams();
          if (!(localObject1 instanceof ViewGroup.MarginLayoutParams)) {
            break label347;
          }
          localObject1 = (ViewGroup.MarginLayoutParams)localObject1;
          if (localObject1 != null)
          {
            localObject3 = this.DjJ;
            ((ViewGroup.MarginLayoutParams)localObject1).setMargins(0, i + (k - i - j) / 3, 0, 0);
            localObject3 = bz.q((bz)localObject3);
            if (localObject3 != null) {
              break label353;
            }
            s.bIx("emptyTips");
          }
        }
        for (;;)
        {
          localObject2.setLayoutParams((ViewGroup.LayoutParams)localObject1);
          AppMethodBeat.o(354884);
          return;
          break;
          if (j < m) {
            break label360;
          }
          i = 0;
          break label207;
          localObject1 = null;
          break label272;
          localObject2 = localObject3;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.plugin.bz
 * JD-Core Version:    0.7.0.1
 */