package com.tencent.mm.plugin.card.ui.v3;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Point;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.b;
import androidx.recyclerview.widget.RecyclerView.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.b.a;
import com.tencent.mm.kernel.k;
import com.tencent.mm.plugin.appbrand.service.ab;
import com.tencent.mm.plugin.card.a.b;
import com.tencent.mm.plugin.card.a.c;
import com.tencent.mm.plugin.card.a.d;
import com.tencent.mm.plugin.card.a.e;
import com.tencent.mm.plugin.card.a.f;
import com.tencent.mm.plugin.card.a.g;
import com.tencent.mm.plugin.card.c.m;
import com.tencent.mm.plugin.card.model.a.a.a.e;
import com.tencent.mm.plugin.card.ui.v2.CardTicketListUI;
import com.tencent.mm.plugin.card.ui.v4.CouponAndGiftCardListV4UI;
import com.tencent.mm.plugin.card.widget.MemberCardTopCropImageView;
import com.tencent.mm.protocal.protobuf.cnn;
import com.tencent.mm.protocal.protobuf.epo;
import com.tencent.mm.protocal.protobuf.etl;
import com.tencent.mm.protocal.protobuf.kd;
import com.tencent.mm.protocal.protobuf.vx;
import com.tencent.mm.protocal.protobuf.vy;
import com.tencent.mm.protocal.protobuf.vz;
import com.tencent.mm.protocal.protobuf.wb;
import com.tencent.mm.protocal.protobuf.wc;
import com.tencent.mm.protocal.protobuf.wd;
import com.tencent.mm.protocal.protobuf.wg;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.RefreshLoadMoreLayout.b;
import com.tencent.mm.view.RefreshLoadMoreLayout.d;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.mm.view.recyclerview.WxRecyclerView;
import com.tencent.mm.view.recyclerview.j;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.u;

@k
@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/card/ui/v3/CardHomePageV3UI;", "Lcom/tencent/mm/ui/MMActivity;", "()V", "TAG", "", "loadCount", "", "loadingDialog", "Landroid/app/Dialog;", "mCardDataList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/card/ui/v3/CardHomePageV3UI$CardConvertData;", "Lkotlin/collections/ArrayList;", "mCardHomePageTopCellGroup", "Lcom/tencent/mm/protocal/protobuf/CardHomePageTopCellGroup;", "mFAQItem", "Lcom/tencent/mm/protocal/protobuf/CardHomePageFAQItem;", "mHasLoadedSuccess", "", "mHeaderContainerLayout", "Landroid/view/ViewGroup;", "mHeaderView", "mHomePageEmptyView", "Landroid/view/View;", "mHomePageRecentlyUsedCardTitleTv", "Landroid/widget/TextView;", "mIsAll", "mIsLoading", "mNeedRefreshPage", "mOffset", "mPageAdapter", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "mPageRv", "Lcom/tencent/mm/view/recyclerview/WxRecyclerView;", "mRefreshLayout", "Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "mViewHeight", "mViewWidth", "doLoadHomePage", "", "refresh", "doRemoveRecentlyCard", "cardId", "userCardId", "getLayoutId", "gotoCardDetailUI", "gotoCertListUI", "gotoCouponCardListUI", "title", "gotoCouponGiftCardListUI", "gotoVipCardListUI", "hideLoading", "initView", "loadSnapshot", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onResume", "preloadMiniApp", "removeCardByCardId", "saveSnapshot", "showLoading", "superImportUIComponents", "set", "Ljava/util/HashSet;", "Ljava/lang/Class;", "Lcom/tencent/mm/ui/component/UIComponent;", "updateCardList", "cardList", "Lcom/tencent/mm/protocal/protobuf/CardHomePageRecentlyUsedList;", "updateFAQ", "faqItem", "updateHeader", "topCellGroup", "updateRecentlyUsedCardTitleLayout", "updateRecentlyUsedTitle", "CardConvertData", "CardConverter", "CardHomePageV3UIAccessibility", "Companion", "plugin-card_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class CardHomePageV3UI
  extends MMActivity
{
  public static final CardHomePageV3UI.d wGV;
  private int Sc;
  String TAG;
  private int mViewHeight;
  private int mViewWidth;
  private boolean szX;
  private WxRecyclerView wGW;
  private RefreshLoadMoreLayout wGX;
  private ViewGroup wGY;
  private ViewGroup wGZ;
  private TextView wHa;
  private View wHb;
  private WxRecyclerAdapter<a> wHc;
  private ArrayList<a> wHd;
  private boolean wHe;
  private boolean wHf;
  private boolean wHg;
  private wc wHh;
  private vx wHi;
  private int wHj;
  
  static
  {
    AppMethodBeat.i(294070);
    wGV = new CardHomePageV3UI.d((byte)0);
    AppMethodBeat.o(294070);
  }
  
  public CardHomePageV3UI()
  {
    AppMethodBeat.i(293885);
    this.TAG = "MicroMsg.CardHomePageV3UI";
    this.wHd = new ArrayList();
    AppMethodBeat.o(293885);
  }
  
  private final void a(vx paramvx)
  {
    AppMethodBeat.i(293896);
    if (paramvx != null)
    {
      this.wHi = paramvx;
      if (!Util.isNullOrNil(paramvx.ZcK))
      {
        removeAllOptionMenu();
        addIconOptionMenu(0, 0, a.f.icons_outlined_more, new CardHomePageV3UI..ExternalSyntheticLambda1(this, paramvx));
      }
    }
    AppMethodBeat.o(293896);
  }
  
  private static final void a(vx paramvx, CardHomePageV3UI paramCardHomePageV3UI, MenuItem paramMenuItem, int paramInt)
  {
    AppMethodBeat.i(293952);
    kotlin.g.b.s.u(paramvx, "$this_apply");
    kotlin.g.b.s.u(paramCardHomePageV3UI, "this$0");
    if (paramMenuItem.getItemId() == 0) {
      switch (paramvx.ZcL)
      {
      }
    }
    for (;;)
    {
      AppMethodBeat.o(293952);
      return;
      com.tencent.mm.plugin.card.c.b.a((MMActivity)paramCardHomePageV3UI.getContext(), paramvx.ZcM, 0);
      AppMethodBeat.o(293952);
      return;
      paramvx = paramvx.ZcN;
      com.tencent.mm.plugin.card.c.b.S(paramvx.VcU, paramvx.VcV, paramvx.VQU);
    }
  }
  
  private final void a(vz paramvz)
  {
    AppMethodBeat.i(293903);
    if (paramvz != null)
    {
      paramvz = paramvz.ZcP.iterator();
      while (paramvz.hasNext())
      {
        localObject = (vy)paramvz.next();
        a locala = new a();
        kotlin.g.b.s.s(localObject, "cell");
        locala.a((vy)localObject);
        this.wHd.add(locala);
      }
      Object localObject = this.wHc;
      paramvz = (vz)localObject;
      if (localObject == null)
      {
        kotlin.g.b.s.bIx("mPageAdapter");
        paramvz = null;
      }
      paramvz.bZE.notifyChanged();
    }
    dot();
    AppMethodBeat.o(293903);
  }
  
  private static final void a(wb paramwb, CardHomePageV3UI paramCardHomePageV3UI, View paramView)
  {
    AppMethodBeat.i(293975);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramwb);
    localb.cH(paramCardHomePageV3UI);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/card/ui/v3/CardHomePageV3UI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(paramCardHomePageV3UI, "this$0");
    switch (paramwb.ZcU)
    {
    default: 
      Log.w(paramCardHomePageV3UI.TAG, kotlin.g.b.s.X("unknown type ", Integer.valueOf(paramwb.ZcU)));
    }
    for (;;)
    {
      com.tencent.mm.plugin.report.service.h.OAn.b(19673, new Object[] { paramwb.ZcS, Long.valueOf(System.currentTimeMillis() / 1000L) });
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/card/ui/v3/CardHomePageV3UI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(293975);
      return;
      com.tencent.mm.plugin.card.c.b.a((MMActivity)paramCardHomePageV3UI.getContext(), paramwb.ZcV, 0);
      continue;
      paramView = paramwb.ZcW;
      if (paramView != null)
      {
        com.tencent.mm.plugin.card.c.b.S(paramView.VcU, paramView.VcV, paramView.VQU);
        paramCardHomePageV3UI.wHg = true;
        continue;
        if ("weixin://mktcard/cert".equals(paramwb.ZcX))
        {
          Log.i(paramCardHomePageV3UI.TAG, "go to cert list");
          paramCardHomePageV3UI.startActivityForResult(new Intent((Context)paramCardHomePageV3UI.getContext(), CardTicketListUI.class), 2);
        }
        else if ("weixin://mktcard/membercard".equals(paramwb.ZcX))
        {
          Log.i(paramCardHomePageV3UI.TAG, "go to vip card list");
          paramCardHomePageV3UI.startActivityForResult(new Intent((Context)paramCardHomePageV3UI.getContext(), VipCardListUI.class), 1);
        }
        else if ("weixin://mktcard/coupon".equals(paramwb.ZcX))
        {
          paramView = paramwb.ZcS;
          Log.i(paramCardHomePageV3UI.TAG, "go to vip card list");
          localObject = new Intent((Context)paramCardHomePageV3UI.getContext(), CouponCardListUI.class);
          ((Intent)localObject).putExtra("title", paramView);
          paramCardHomePageV3UI.startActivityForResult((Intent)localObject, 3);
        }
        else if ("weixin://mktcard/couponv2".equals(paramwb.ZcX))
        {
          paramView = paramwb.ZcS;
          Log.i(paramCardHomePageV3UI.TAG, "go to coupon gift card list");
          localObject = new Intent((Context)paramCardHomePageV3UI.getContext(), CouponAndGiftCardListV4UI.class);
          ((Intent)localObject).putExtra("title", paramView);
          paramCardHomePageV3UI.startActivityForResult((Intent)localObject, 5);
        }
      }
    }
  }
  
  private final void a(wc paramwc)
  {
    AppMethodBeat.i(293929);
    Log.i(this.TAG, "do update header");
    if (paramwc == null)
    {
      AppMethodBeat.o(293929);
      return;
    }
    this.wHh = paramwc;
    Object localObject2 = this.wGZ;
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      kotlin.g.b.s.bIx("mHeaderContainerLayout");
      localObject1 = null;
    }
    ((ViewGroup)localObject1).removeAllViews();
    int k = getResources().getDimensionPixelSize(a.b.Edge_A);
    localObject1 = paramwc.Zda.iterator();
    if (((Iterator)localObject1).hasNext())
    {
      paramwc = (wd)((Iterator)localObject1).next();
      localObject2 = new LinearLayout((Context)getContext());
      ((LinearLayout)localObject2).setOrientation(1);
      ((LinearLayout)localObject2).setPadding(0, 0, 0, k);
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, -2);
      Iterator localIterator = paramwc.Zdb.iterator();
      int i = 0;
      if (localIterator.hasNext())
      {
        wb localwb = (wb)localIterator.next();
        View localView = getLayoutInflater().inflate(a.e.wmW, (ViewGroup)localObject2, false);
        ImageView localImageView1 = (ImageView)localView.findViewById(a.d.wil);
        TextView localTextView1 = (TextView)localView.findViewById(a.d.wim);
        Object localObject3 = (TextView)localView.findViewById(a.d.wij);
        TextView localTextView2 = (TextView)localView.findViewById(a.d.wir);
        ImageView localImageView2 = (ImageView)localView.findViewById(a.d.wis);
        ImageView localImageView3 = (ImageView)localView.findViewById(a.d.wit);
        CharSequence localCharSequence = (CharSequence)localwb.ZcT;
        int j;
        if ((localCharSequence == null) || (localCharSequence.length() == 0))
        {
          j = 1;
          label303:
          if ((j != 0) || (localwb.ZcY != 1)) {
            break label483;
          }
          ((TextView)localObject3).setText((CharSequence)localwb.ZcT);
          localImageView3.setVisibility(0);
          localImageView2.setVisibility(8);
          localTextView2.setVisibility(8);
        }
        for (;;)
        {
          localObject3 = localwb.ZcR;
          if (localObject3 != null)
          {
            j = getResources().getDimensionPixelSize(a.b.Edge_3A);
            Log.i(this.TAG, kotlin.g.b.s.X("cell icon top height and width ", Integer.valueOf(j)));
            kotlin.g.b.s.s(localImageView1, "iconIv");
            m.a(localImageView1, (String)localObject3, false, 0, j, j, 28);
          }
          localTextView1.setText((CharSequence)localwb.ZcS);
          if (i == paramwc.Zdb.size() - 1) {
            localView.findViewById(a.d.wik).setVisibility(8);
          }
          localView.setOnClickListener(new CardHomePageV3UI..ExternalSyntheticLambda2(localwb, this));
          ((LinearLayout)localObject2).addView(localView);
          i += 1;
          break;
          j = 0;
          break label303;
          label483:
          if (localwb.ZcZ == 1)
          {
            localTextView2.setVisibility(0);
            ((TextView)localObject3).setText((CharSequence)"");
            localImageView3.setVisibility(8);
            localImageView2.setVisibility(8);
          }
          else if (localwb.ZcY == 1)
          {
            ((TextView)localObject3).setText((CharSequence)"");
            localImageView2.setVisibility(0);
            localTextView2.setVisibility(8);
            localImageView3.setVisibility(8);
          }
          else
          {
            ((TextView)localObject3).setText((CharSequence)"");
            localImageView2.setVisibility(8);
            localTextView2.setVisibility(8);
            localImageView3.setVisibility(8);
          }
        }
      }
      paramwc = this.wGZ;
      if (paramwc == null)
      {
        kotlin.g.b.s.bIx("mHeaderContainerLayout");
        paramwc = null;
      }
      for (;;)
      {
        paramwc.addView((View)localObject2, (ViewGroup.LayoutParams)localLayoutParams);
        break;
      }
    }
    AppMethodBeat.o(293929);
  }
  
  private static final boolean a(CardHomePageV3UI paramCardHomePageV3UI, MenuItem paramMenuItem)
  {
    AppMethodBeat.i(293937);
    kotlin.g.b.s.u(paramCardHomePageV3UI, "this$0");
    paramCardHomePageV3UI.finish();
    AppMethodBeat.o(293937);
    return false;
  }
  
  private static final boolean a(CardHomePageV3UI paramCardHomePageV3UI, vx paramvx, MenuItem paramMenuItem)
  {
    AppMethodBeat.i(293961);
    kotlin.g.b.s.u(paramCardHomePageV3UI, "this$0");
    kotlin.g.b.s.u(paramvx, "$this_apply");
    paramMenuItem = new com.tencent.mm.ui.widget.a.f((Context)paramCardHomePageV3UI.getContext(), 1, false);
    paramMenuItem.Vtg = new CardHomePageV3UI..ExternalSyntheticLambda3(paramvx);
    paramMenuItem.GAC = new CardHomePageV3UI..ExternalSyntheticLambda4(paramvx, paramCardHomePageV3UI);
    paramMenuItem.dDn();
    AppMethodBeat.o(293961);
    return false;
  }
  
  private final void alj(String paramString)
  {
    AppMethodBeat.i(293915);
    Object localObject = (CharSequence)paramString;
    if ((localObject == null) || (((CharSequence)localObject).length() == 0)) {}
    for (int i = 1;; i = 0)
    {
      if (i == 0)
      {
        TextView localTextView = this.wHa;
        localObject = localTextView;
        if (localTextView == null)
        {
          kotlin.g.b.s.bIx("mHomePageRecentlyUsedCardTitleTv");
          localObject = null;
        }
        ((TextView)localObject).setText((CharSequence)paramString);
      }
      AppMethodBeat.o(293915);
      return;
    }
  }
  
  private static final void b(vx paramvx, com.tencent.mm.ui.base.s params)
  {
    AppMethodBeat.i(293942);
    kotlin.g.b.s.u(paramvx, "$this_apply");
    params.add(0, 0, 1, (CharSequence)paramvx.ZcK);
    AppMethodBeat.o(293942);
  }
  
  private final void dot()
  {
    View localView2 = null;
    View localView1 = null;
    AppMethodBeat.i(293909);
    if (this.wHd.isEmpty())
    {
      localView2 = this.wHb;
      localObject = localView2;
      if (localView2 == null)
      {
        kotlin.g.b.s.bIx("mHomePageEmptyView");
        localObject = null;
      }
      ((View)localObject).setVisibility(0);
      localObject = this.wHa;
      if (localObject == null)
      {
        kotlin.g.b.s.bIx("mHomePageRecentlyUsedCardTitleTv");
        localObject = localView1;
      }
      for (;;)
      {
        ((TextView)localObject).setVisibility(8);
        AppMethodBeat.o(293909);
        return;
      }
    }
    localView1 = this.wHb;
    Object localObject = localView1;
    if (localView1 == null)
    {
      kotlin.g.b.s.bIx("mHomePageEmptyView");
      localObject = null;
    }
    ((View)localObject).setVisibility(8);
    localObject = this.wHa;
    if (localObject == null)
    {
      kotlin.g.b.s.bIx("mHomePageRecentlyUsedCardTitleTv");
      localObject = localView2;
    }
    for (;;)
    {
      ((TextView)localObject).setVisibility(0);
      AppMethodBeat.o(293909);
      return;
    }
  }
  
  private final void ng(final boolean paramBoolean)
  {
    RefreshLoadMoreLayout localRefreshLoadMoreLayout = null;
    Object localObject = null;
    AppMethodBeat.i(293890);
    Log.i(this.TAG, "do load home page");
    if ((this.wHe) && (!paramBoolean))
    {
      Log.w(this.TAG, "already load complete");
      localRefreshLoadMoreLayout = this.wGX;
      if (localRefreshLoadMoreLayout == null) {
        kotlin.g.b.s.bIx("mRefreshLayout");
      }
      for (;;)
      {
        ((RefreshLoadMoreLayout)localObject).aFW(0);
        AppMethodBeat.o(293890);
        return;
        localObject = localRefreshLoadMoreLayout;
      }
    }
    if (this.szX)
    {
      Log.w(this.TAG, "is loading");
      AppMethodBeat.o(293890);
      return;
    }
    this.szX = true;
    int i = this.Sc;
    if (paramBoolean)
    {
      localObject = this.wGX;
      if (localObject == null)
      {
        kotlin.g.b.s.bIx("mRefreshLayout");
        localObject = localRefreshLoadMoreLayout;
        ((RefreshLoadMoreLayout)localObject).setHasBottomMore(true);
        i = 0;
      }
    }
    for (;;)
    {
      localObject = new com.tencent.mm.plugin.card.model.b.c(i).bFJ();
      kotlin.g.b.s.s(localObject, "CgiGetMktCardHomePageV3(offset, 10).run()");
      com.tencent.mm.ae.d.b((com.tencent.mm.vending.g.c)localObject, (kotlin.g.a.b)new e(this, paramBoolean));
      AppMethodBeat.o(293890);
      return;
      break;
    }
  }
  
  public final int getLayoutId()
  {
    return a.e.wmZ;
  }
  
  public final void initView()
  {
    Object localObject3 = null;
    AppMethodBeat.i(294122);
    Object localObject1 = findViewById(a.d.wiR);
    kotlin.g.b.s.s(localObject1, "findViewById(R.id.chpuv3_rv)");
    this.wGW = ((WxRecyclerView)localObject1);
    localObject1 = findViewById(a.d.wiQ);
    kotlin.g.b.s.s(localObject1, "findViewById(R.id.chpuv3_refresh_layout)");
    this.wGX = ((RefreshLoadMoreLayout)localObject1);
    localObject1 = this.wGW;
    label160:
    Object localObject4;
    if (localObject1 == null)
    {
      kotlin.g.b.s.bIx("mPageRv");
      localObject1 = null;
      getContext();
      ((WxRecyclerView)localObject1).setLayoutManager((RecyclerView.LayoutManager)new LinearLayoutManager(1, false));
      this.wHc = new WxRecyclerAdapter((com.tencent.mm.view.recyclerview.g)new g(this), this.wHd);
      localObject2 = this.wHc;
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        kotlin.g.b.s.bIx("mPageAdapter");
        localObject1 = null;
      }
      ((WxRecyclerAdapter)localObject1).bf(true);
      localObject1 = this.wGW;
      if (localObject1 != null) {
        break label312;
      }
      kotlin.g.b.s.bIx("mPageRv");
      localObject1 = null;
      localObject4 = this.wHc;
      localObject2 = localObject4;
      if (localObject4 == null)
      {
        kotlin.g.b.s.bIx("mPageAdapter");
        localObject2 = null;
      }
      ((WxRecyclerView)localObject1).setAdapter((RecyclerView.a)localObject2);
      localObject2 = new androidx.recyclerview.widget.h((Context)getContext(), 1);
      ((androidx.recyclerview.widget.h)localObject2).w(getResources().getDrawable(a.c.weq));
      localObject1 = this.wGW;
      if (localObject1 != null) {
        break label315;
      }
      kotlin.g.b.s.bIx("mPageRv");
      localObject1 = null;
    }
    label312:
    label315:
    for (;;)
    {
      ((RecyclerView)localObject1).a((RecyclerView.h)localObject2);
      localObject4 = getLayoutInflater();
      int i = a.e.wmX;
      localObject2 = this.wGW;
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        kotlin.g.b.s.bIx("mPageRv");
        localObject1 = null;
      }
      localObject1 = ((LayoutInflater)localObject4).inflate(i, (ViewGroup)localObject1, false);
      if (localObject1 != null) {
        break label318;
      }
      localObject1 = new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
      AppMethodBeat.o(294122);
      throw ((Throwable)localObject1);
      break;
      break label160;
    }
    label318:
    this.wGY = ((ViewGroup)localObject1);
    Object localObject2 = this.wGY;
    localObject1 = localObject2;
    if (localObject2 == null)
    {
      kotlin.g.b.s.bIx("mHeaderView");
      localObject1 = null;
    }
    localObject1 = ((ViewGroup)localObject1).findViewById(a.d.win);
    kotlin.g.b.s.s(localObject1, "mHeaderView.findViewById…_header_container_layout)");
    this.wGZ = ((ViewGroup)localObject1);
    localObject2 = this.wGY;
    localObject1 = localObject2;
    if (localObject2 == null)
    {
      kotlin.g.b.s.bIx("mHeaderView");
      localObject1 = null;
    }
    localObject1 = ((ViewGroup)localObject1).findViewById(a.d.wiq);
    kotlin.g.b.s.s(localObject1, "mHeaderView.findViewById…hphv3_home_page_title_tv)");
    this.wHa = ((TextView)localObject1);
    localObject2 = this.wGY;
    localObject1 = localObject2;
    if (localObject2 == null)
    {
      kotlin.g.b.s.bIx("mHeaderView");
      localObject1 = null;
    }
    localObject1 = ((ViewGroup)localObject1).findViewById(a.d.wip);
    kotlin.g.b.s.s(localObject1, "mHeaderView.findViewById…3_home_page_empty_layout)");
    this.wHb = ((View)localObject1);
    localObject1 = this.wHc;
    if (localObject1 == null)
    {
      kotlin.g.b.s.bIx("mPageAdapter");
      localObject1 = null;
      localObject4 = this.wGY;
      localObject2 = localObject4;
      if (localObject4 == null)
      {
        kotlin.g.b.s.bIx("mHeaderView");
        localObject2 = null;
      }
      ((WxRecyclerAdapter)localObject1).i((View)localObject2, 2, false);
      localObject2 = this.wGX;
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        kotlin.g.b.s.bIx("mRefreshLayout");
        localObject1 = null;
      }
      ((RefreshLoadMoreLayout)localObject1).setEnableRefresh(false);
      localObject1 = this.wGX;
      if (localObject1 != null) {
        break label688;
      }
      kotlin.g.b.s.bIx("mRefreshLayout");
      localObject1 = null;
      label540:
      ((RefreshLoadMoreLayout)localObject1).setLimitTopRequest(com.tencent.mm.cd.a.fromDPToPix((Context)getContext(), 1200) - (int)MMApplicationContext.getContext().getResources().getDimension(a.b.Edge_12A));
      localObject1 = this.wGX;
      if (localObject1 != null) {
        break label691;
      }
      kotlin.g.b.s.bIx("mRefreshLayout");
      localObject1 = null;
      label588:
      ((RefreshLoadMoreLayout)localObject1).setRefreshTargetY((int)MMApplicationContext.getContext().getResources().getDimension(a.b.Edge_7A) - com.tencent.mm.cd.a.fromDPToPix((Context)getContext(), 1200));
      localObject2 = this.wGX;
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        kotlin.g.b.s.bIx("mRefreshLayout");
        localObject1 = null;
      }
      ((RefreshLoadMoreLayout)localObject1).setDamping(1.85F);
      localObject1 = this.wGX;
      if (localObject1 != null) {
        break label694;
      }
      kotlin.g.b.s.bIx("mRefreshLayout");
      localObject1 = localObject3;
    }
    label688:
    label691:
    label694:
    for (;;)
    {
      ((RefreshLoadMoreLayout)localObject1).setActionCallback((RefreshLoadMoreLayout.b)new h(this));
      AppMethodBeat.o(294122);
      return;
      break;
      break label540;
      break label588;
    }
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(294148);
    switch (paramInt1)
    {
    }
    for (;;)
    {
      super.onActivityResult(paramInt1, paramInt2, paramIntent);
      AppMethodBeat.o(294148);
      return;
      ng(true);
      continue;
      ng(true);
      continue;
      ng(true);
      continue;
      ng(true);
    }
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(294108);
    super.onCreate(paramBundle);
    initView();
    setMMTitle(a.g.woX);
    setActionbarColor(getResources().getColor(com.tencent.mm.plugin.card.a.a.BG_0));
    hideActionbarLine();
    setBackBtn(new CardHomePageV3UI..ExternalSyntheticLambda0(this));
    paramBundle = com.tencent.mm.plugin.card.model.a.a.wvG;
    paramBundle = com.tencent.mm.plugin.card.model.a.a.a.dla();
    if (paramBundle != null)
    {
      this.Sc = paramBundle.xlj;
      alj(paramBundle.aauT);
      a(paramBundle.aauR);
      a(paramBundle.aauS);
      a(paramBundle.aauO);
    }
    ng(true);
    ((com.tencent.mm.plugin.appbrand.service.g)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.appbrand.service.g.class)).b(ab.tUd);
    AppMethodBeat.o(294108);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(294136);
    super.onDestroy();
    if (!this.wHf)
    {
      Log.i(this.TAG, "no data to save snapshot");
      AppMethodBeat.o(294136);
      return;
    }
    cnn localcnn = new cnn();
    localcnn.BaseResponse = new kd();
    localcnn.BaseResponse.akjO = new etl();
    localcnn.aauR = this.wHh;
    Object localObject2 = this.wHa;
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      kotlin.g.b.s.bIx("mHomePageRecentlyUsedCardTitleTv");
      localObject1 = null;
    }
    localcnn.aauT = ((TextView)localObject1).getText().toString();
    localcnn.aauS = new vz();
    localcnn.xlj = this.Sc;
    localcnn.aauO = this.wHi;
    localObject1 = this.wHd.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = ((a)((Iterator)localObject1).next()).dov();
      if (localObject2 != null) {
        localcnn.aauS.ZcP.add(localObject2);
      }
    }
    localObject1 = com.tencent.mm.plugin.card.model.a.a.wvG;
    kotlin.g.b.s.u(localcnn, "response");
    Log.d(com.tencent.mm.plugin.card.model.a.a.access$getTAG$cp(), "save home page v3 snapshot");
    com.tencent.mm.ae.d.B((kotlin.g.a.a)new a.a.e(localcnn));
    AppMethodBeat.o(294136);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(294128);
    super.onResume();
    if (this.wHg)
    {
      ng(true);
      this.wHg = false;
    }
    AppMethodBeat.o(294128);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public final void superImportUIComponents(HashSet<Class<? extends UIComponent>> paramHashSet)
  {
    AppMethodBeat.i(294154);
    kotlin.g.b.s.u(paramHashSet, "set");
    super.superImportUIComponents(paramHashSet);
    paramHashSet.add(CardHomePageV3UI.c.class);
    AppMethodBeat.o(294154);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/card/ui/v3/CardHomePageV3UI$CardConvertData;", "Lcom/tencent/mm/view/recyclerview/ConvertData;", "()V", "recentlyUsedCell", "Lcom/tencent/mm/protocal/protobuf/CardHomePageRecentlyUsedCell;", "getRecentlyUsedCell", "()Lcom/tencent/mm/protocal/protobuf/CardHomePageRecentlyUsedCell;", "setRecentlyUsedCell", "(Lcom/tencent/mm/protocal/protobuf/CardHomePageRecentlyUsedCell;)V", "getItemId", "", "getItemType", "", "plugin-card_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    implements com.tencent.mm.view.recyclerview.a
  {
    public vy wHk;
    
    public final void a(vy paramvy)
    {
      AppMethodBeat.i(293959);
      kotlin.g.b.s.u(paramvy, "<set-?>");
      this.wHk = paramvy;
      AppMethodBeat.o(293959);
    }
    
    public final long bZA()
    {
      AppMethodBeat.i(293971);
      long l = dov().iaI.hashCode();
      AppMethodBeat.o(293971);
      return l;
    }
    
    public final int bZB()
    {
      return 1;
    }
    
    public final vy dov()
    {
      AppMethodBeat.i(293951);
      vy localvy = this.wHk;
      if (localvy != null)
      {
        AppMethodBeat.o(293951);
        return localvy;
      }
      kotlin.g.b.s.bIx("recentlyUsedCell");
      AppMethodBeat.o(293951);
      return null;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/card/ui/v3/CardHomePageV3UI$CardConverter;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "Lcom/tencent/mm/plugin/card/ui/v3/CardHomePageV3UI$CardConvertData;", "(Lcom/tencent/mm/plugin/card/ui/v3/CardHomePageV3UI;)V", "clearShadowLayer", "", "textview", "Landroid/widget/TextView;", "getLayoutId", "", "onBindViewHolder", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "position", "type", "isHotPatch", "", "payloads", "", "", "onCreateViewHolder", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "setShadowLayer", "showDeleteConfirmDialog", "cardId", "", "userCardId", "plugin-card_release"}, k=1, mv={1, 5, 1}, xi=48)
  public final class b
    extends com.tencent.mm.view.recyclerview.f<CardHomePageV3UI.a>
  {
    public b()
    {
      AppMethodBeat.i(293935);
      AppMethodBeat.o(293935);
    }
    
    private static final void a(b paramb, CardHomePageV3UI.a parama, MenuItem paramMenuItem, int paramInt)
    {
      AppMethodBeat.i(293978);
      kotlin.g.b.s.u(paramb, "this$0");
      paramMenuItem = parama.dov().iaI;
      kotlin.g.b.s.s(paramMenuItem, "cardConvertData.recentlyUsedCell.card_id");
      String str = parama.dov().YBH;
      kotlin.g.b.s.s(str, "cardConvertData.recentlyUsedCell.user_card_id");
      com.tencent.mm.ui.widget.a.f localf = new com.tencent.mm.ui.widget.a.f((Context)paramb.wHl.getContext(), 1, true);
      TextView localTextView = new TextView((Context)paramb.wHl.getContext());
      localTextView.setText((CharSequence)paramb.wHl.getString(a.g.woV));
      localTextView.setTextSize(1, 14.0F);
      localTextView.setTextColor(paramb.wHl.getResources().getColor(com.tencent.mm.plugin.card.a.a.half_alpha_black));
      localTextView.setGravity(17);
      paramInt = paramb.wHl.getResources().getDimensionPixelSize(a.b.Edge_A);
      int i = paramb.wHl.getResources().getDimensionPixelSize(a.b.Edge_2A);
      localTextView.setPadding(paramInt, i, paramInt, i);
      localf.af((View)localTextView, false);
      localf.Vtg = new CardHomePageV3UI.b..ExternalSyntheticLambda3(paramb.wHl);
      localf.GAC = new CardHomePageV3UI.b..ExternalSyntheticLambda5(paramb.wHl, paramMenuItem, str);
      localf.dDn();
      com.tencent.mm.plugin.report.service.h.OAn.b(19674, new Object[] { Integer.valueOf(2), Integer.valueOf(parama.dov().tNW), parama.dov().YBH, Long.valueOf(System.currentTimeMillis() / 1000L) });
      AppMethodBeat.o(293978);
    }
    
    private static final void a(CardHomePageV3UI paramCardHomePageV3UI, ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
    {
      AppMethodBeat.i(293970);
      kotlin.g.b.s.u(paramCardHomePageV3UI, "this$0");
      paramContextMenu.add(0, 1, 0, (CharSequence)paramCardHomePageV3UI.getString(a.g.woW));
      AppMethodBeat.o(293970);
    }
    
    private static final void a(CardHomePageV3UI paramCardHomePageV3UI, com.tencent.mm.ui.base.s params)
    {
      AppMethodBeat.i(293990);
      kotlin.g.b.s.u(paramCardHomePageV3UI, "this$0");
      params.a(1, paramCardHomePageV3UI.getResources().getColor(com.tencent.mm.plugin.card.a.a.red_text_color), (CharSequence)paramCardHomePageV3UI.getString(a.g.app_ok));
      AppMethodBeat.o(293990);
    }
    
    private static final void a(CardHomePageV3UI paramCardHomePageV3UI, j paramj, kotlin.g.a.a parama)
    {
      AppMethodBeat.i(294003);
      kotlin.g.b.s.u(paramCardHomePageV3UI, "this$0");
      kotlin.g.b.s.u(paramj, "$holder");
      kotlin.g.b.s.u(parama, "$func");
      CardHomePageV3UI.b(paramCardHomePageV3UI, paramj.caK.getHeight());
      CardHomePageV3UI.c(paramCardHomePageV3UI, paramj.caK.getWidth());
      parama.invoke();
      AppMethodBeat.o(294003);
    }
    
    private static final void a(CardHomePageV3UI paramCardHomePageV3UI, String paramString1, String paramString2, MenuItem paramMenuItem, int paramInt)
    {
      AppMethodBeat.i(293997);
      kotlin.g.b.s.u(paramCardHomePageV3UI, "this$0");
      kotlin.g.b.s.u(paramString1, "$cardId");
      kotlin.g.b.s.u(paramString2, "$userCardId");
      if (paramMenuItem.getItemId() == 1)
      {
        kotlin.g.b.s.u(paramString1, "cardId");
        kotlin.g.b.s.u(paramString2, "userCardId");
        Log.i(paramCardHomePageV3UI.TAG, "do remove recently: " + paramString1 + ", " + paramString2);
        paramString1 = new com.tencent.mm.plugin.card.model.b.d(paramString1, paramString2);
        paramString1.otr = true;
        paramString1 = paramString1.bFJ();
        kotlin.g.b.s.s(paramString1, "CgiRemoveCardInRecentlyU…ntCancelAfterDead().run()");
        com.tencent.mm.ae.d.b((com.tencent.mm.vending.g.c)paramString1, (kotlin.g.a.b)new CardHomePageV3UI.f(paramCardHomePageV3UI, paramString2)).b((com.tencent.mm.vending.e.b)paramCardHomePageV3UI);
      }
      AppMethodBeat.o(293997);
    }
    
    private static final void a(j paramj, CardHomePageV3UI paramCardHomePageV3UI, View paramView)
    {
      AppMethodBeat.i(293966);
      Object localObject = new Object();
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.cH(paramj);
      localb.cH(paramCardHomePageV3UI);
      localb.cH(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/card/ui/v3/CardHomePageV3UI$CardConverter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
      kotlin.g.b.s.u(paramj, "$holder");
      kotlin.g.b.s.u(paramCardHomePageV3UI, "this$0");
      paramj = (CardHomePageV3UI.a)paramj.CSA;
      switch (paramj.dov().Zcl)
      {
      default: 
        Log.w(CardHomePageV3UI.a(paramCardHomePageV3UI), kotlin.g.b.s.X("unknown type ", Integer.valueOf(paramj.dov().Zcl)));
        paramView = paramj.dov().YBH;
        kotlin.g.b.s.s(paramView, "cardConvertData.recentlyUsedCell.user_card_id");
        CardHomePageV3UI.c(paramCardHomePageV3UI, paramView);
      }
      for (;;)
      {
        com.tencent.mm.plugin.report.service.h.OAn.b(19674, new Object[] { Integer.valueOf(1), Integer.valueOf(paramj.dov().tNW), paramj.dov().YBH, Long.valueOf(System.currentTimeMillis() / 1000L) });
        com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/card/ui/v3/CardHomePageV3UI$CardConverter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(293966);
        return;
        com.tencent.mm.plugin.card.c.b.a((MMActivity)paramCardHomePageV3UI.getContext(), paramj.dov().Zcm, 0);
        continue;
        paramCardHomePageV3UI = paramj.dov().Zcn;
        if (paramCardHomePageV3UI != null)
        {
          com.tencent.mm.plugin.card.c.b.S(paramCardHomePageV3UI.VcU, paramCardHomePageV3UI.VcV, paramCardHomePageV3UI.VQU);
          continue;
          paramView = paramj.dov().YBH;
          kotlin.g.b.s.s(paramView, "cardConvertData.recentlyUsedCell.user_card_id");
          CardHomePageV3UI.c(paramCardHomePageV3UI, paramView);
        }
      }
    }
    
    private static final boolean a(j paramj, CardHomePageV3UI paramCardHomePageV3UI, b paramb, View paramView)
    {
      AppMethodBeat.i(293986);
      Object localObject = new Object();
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.cH(paramj);
      localb.cH(paramCardHomePageV3UI);
      localb.cH(paramb);
      localb.cH(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/card/ui/v3/CardHomePageV3UI$CardConverter", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", localObject, localb.aYj());
      kotlin.g.b.s.u(paramj, "$holder");
      kotlin.g.b.s.u(paramCardHomePageV3UI, "this$0");
      kotlin.g.b.s.u(paramb, "this$1");
      localObject = (CardHomePageV3UI.a)paramj.CSA;
      paramj = new com.tencent.mm.ui.widget.b.a((Context)paramCardHomePageV3UI.getContext(), paramView);
      paramj.agjt = new CardHomePageV3UI.b..ExternalSyntheticLambda1(paramCardHomePageV3UI);
      paramj.GAC = new CardHomePageV3UI.b..ExternalSyntheticLambda4(paramb, (CardHomePageV3UI.a)localObject);
      kotlin.g.b.s.s(paramView, "it");
      paramCardHomePageV3UI = m.eN(paramView);
      paramj.fQ(paramCardHomePageV3UI.x, paramCardHomePageV3UI.y);
      com.tencent.mm.hellhoundlib.a.a.a(false, new Object(), "com/tencent/mm/plugin/card/ui/v3/CardHomePageV3UI$CardConverter", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
      AppMethodBeat.o(293986);
      return false;
    }
    
    private static void q(TextView paramTextView)
    {
      AppMethodBeat.i(293941);
      paramTextView.setShadowLayer(0.0F, 0.0F, 0.0F, 0);
      AppMethodBeat.o(293941);
    }
    
    private final void r(TextView paramTextView)
    {
      AppMethodBeat.i(293949);
      paramTextView.setShadowLayer(com.tencent.mm.cd.a.fromDPToPix(paramTextView.getContext(), 4), 0.0F, 0.0F, this.wHl.getResources().getColor(com.tencent.mm.plugin.card.a.a.UN_BW_0_Alpha_0_2));
      AppMethodBeat.o(293949);
    }
    
    public final void a(RecyclerView paramRecyclerView, j paramj, int paramInt)
    {
      AppMethodBeat.i(294047);
      kotlin.g.b.s.u(paramRecyclerView, "recyclerView");
      kotlin.g.b.s.u(paramj, "holder");
      paramRecyclerView = (ViewGroup)paramj.UH(a.d.wiM);
      paramRecyclerView.setOnClickListener(new CardHomePageV3UI.b..ExternalSyntheticLambda0(paramj, this.wHl));
      paramRecyclerView.setOnLongClickListener(new CardHomePageV3UI.b..ExternalSyntheticLambda2(paramj, this.wHl, this));
      AppMethodBeat.o(294047);
    }
    
    public final int getLayoutId()
    {
      return a.e.wmY;
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
    static final class a
      extends u
      implements kotlin.g.a.a<ah>
    {
      a(CardHomePageV3UI paramCardHomePageV3UI, j paramj, MemberCardTopCropImageView paramMemberCardTopCropImageView, CardHomePageV3UI.a parama)
      {
        super();
      }
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/GetMktCardHomePageV2Response;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends u
    implements kotlin.g.a.b<b.a<cnn>, ah>
  {
    e(CardHomePageV3UI paramCardHomePageV3UI, boolean paramBoolean)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/RemoveCardInRecentlyUsedListResponse;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class f
    extends u
    implements kotlin.g.a.b<b.a<epo>, ah>
  {
    f(CardHomePageV3UI paramCardHomePageV3UI, String paramString)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/card/ui/v3/CardHomePageV3UI$initView$1", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "getItemConvert", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "type", "", "plugin-card_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class g
    implements com.tencent.mm.view.recyclerview.g
  {
    g(CardHomePageV3UI paramCardHomePageV3UI) {}
    
    public final com.tencent.mm.view.recyclerview.f<?> yF(int paramInt)
    {
      AppMethodBeat.i(293922);
      com.tencent.mm.view.recyclerview.f localf = (com.tencent.mm.view.recyclerview.f)new CardHomePageV3UI.b(this.wHl);
      AppMethodBeat.o(293922);
      return localf;
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/card/ui/v3/CardHomePageV3UI$initView$2", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback2;", "onLoadMoreBegin", "", "loadMoreType", "", "onLoadMoreEnd", "reason", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;", "", "onRefreshBegin", "refreshType", "onRefreshEnd", "plugin-card_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class h
    extends RefreshLoadMoreLayout.b
  {
    h(CardHomePageV3UI paramCardHomePageV3UI) {}
    
    public final void IH(int paramInt)
    {
      AppMethodBeat.i(293940);
      Log.d(CardHomePageV3UI.a(this.wHl), "on begin refresh");
      AppMethodBeat.o(293940);
    }
    
    public final void a(RefreshLoadMoreLayout.d<Object> paramd)
    {
      AppMethodBeat.i(293932);
      kotlin.g.b.s.u(paramd, "reason");
      Log.d(CardHomePageV3UI.a(this.wHl), kotlin.g.b.s.X("on load more end: ", Integer.valueOf(CardHomePageV3UI.c(this.wHl))));
      if (CardHomePageV3UI.d(this.wHl))
      {
        RefreshLoadMoreLayout localRefreshLoadMoreLayout = CardHomePageV3UI.e(this.wHl);
        paramd = localRefreshLoadMoreLayout;
        if (localRefreshLoadMoreLayout == null)
        {
          kotlin.g.b.s.bIx("mRefreshLayout");
          paramd = null;
        }
        paramd.m(null);
      }
      AppMethodBeat.o(293932);
    }
    
    public final void onRefreshEnd(RefreshLoadMoreLayout.d<Object> paramd)
    {
      AppMethodBeat.i(293947);
      kotlin.g.b.s.u(paramd, "reason");
      Log.d(CardHomePageV3UI.a(this.wHl), "on refresh end");
      AppMethodBeat.o(293947);
    }
    
    public final void qI(int paramInt)
    {
      AppMethodBeat.i(293925);
      Log.d(CardHomePageV3UI.a(this.wHl), "on load more");
      com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new a(this.wHl));
      AppMethodBeat.o(293925);
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
    static final class a
      extends u
      implements kotlin.g.a.a<ah>
    {
      a(CardHomePageV3UI paramCardHomePageV3UI)
      {
        super();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.v3.CardHomePageV3UI
 * JD-Core Version:    0.7.0.1
 */