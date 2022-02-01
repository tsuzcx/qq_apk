package com.tencent.mm.plugin.card.ui.v3;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Point;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.h;
import android.support.v7.widget.RecyclerView.i;
import android.support.v7.widget.w;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnCreateContextMenuListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.c.a;
import com.tencent.mm.kernel.i;
import com.tencent.mm.plugin.card.d.m;
import com.tencent.mm.plugin.card.model.a.a.a;
import com.tencent.mm.plugin.card.model.a.a.a.c;
import com.tencent.mm.plugin.card.model.b.d;
import com.tencent.mm.plugin.card.widget.MemberCardTopCropImageView;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.baa;
import com.tencent.mm.protocal.protobuf.cof;
import com.tencent.mm.protocal.protobuf.crm;
import com.tencent.mm.protocal.protobuf.rd;
import com.tencent.mm.protocal.protobuf.re;
import com.tencent.mm.protocal.protobuf.rf;
import com.tencent.mm.protocal.protobuf.rh;
import com.tencent.mm.protocal.protobuf.ri;
import com.tencent.mm.protocal.protobuf.rj;
import com.tencent.mm.protocal.protobuf.rm;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.RefreshLoadMoreLayout.a;
import com.tencent.mm.view.RefreshLoadMoreLayout.c;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.mm.view.recyclerview.WxRecyclerView;
import d.g.b.k;
import d.v;
import d.y;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

@i
@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/card/ui/v3/CardHomePageV3UI;", "Lcom/tencent/mm/ui/MMActivity;", "()V", "TAG", "", "loadCount", "", "loadingDialog", "Landroid/app/Dialog;", "mCardDataList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/card/ui/v3/CardHomePageV3UI$CardConvertData;", "Lkotlin/collections/ArrayList;", "mCardHomePageTopCellGroup", "Lcom/tencent/mm/protocal/protobuf/CardHomePageTopCellGroup;", "mFAQItem", "Lcom/tencent/mm/protocal/protobuf/CardHomePageFAQItem;", "mHasLoadedSuccess", "", "mHeaderContainerLayout", "Landroid/view/ViewGroup;", "mHeaderView", "mHomePageEmptyView", "Landroid/view/View;", "mHomePageRecentlyUsedCardTitleTv", "Landroid/widget/TextView;", "mIsAll", "mIsLoading", "mNeedRefreshPage", "mOffset", "mPageAdapter", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "mPageRv", "Lcom/tencent/mm/view/recyclerview/WxRecyclerView;", "mRefreshLayout", "Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "mViewHeight", "doLoadHomePage", "", "refresh", "doRemoveRecentlyCard", "cardId", "userCardId", "getLayoutId", "gotoCardDetailUI", "gotoCertListUI", "gotoCouponCardListUI", "gotoVipCardListUI", "hideLoading", "initView", "loadSnapshot", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onResume", "removeCardByCardId", "saveSnapshot", "showLoading", "updateCardList", "cardList", "Lcom/tencent/mm/protocal/protobuf/CardHomePageRecentlyUsedList;", "updateFAQ", "faqItem", "updateHeader", "topCellGroup", "updateRecentlyUsedCardTitleLayout", "updateRecentlyUsedTitle", "title", "CardConvertData", "CardConverter", "Companion", "plugin-card_release"})
public final class CardHomePageV3UI
  extends MMActivity
{
  private static final int ojA = 2;
  private static final int ojB = 3;
  private static final int ojC = 4;
  public static final CardHomePageV3UI.c ojD;
  private static final int ojx = 1;
  private static final int ojy = 2;
  private static final int ojz = 1;
  private int MW;
  String TAG;
  private int aOz;
  private boolean kOL;
  private WxRecyclerView ojj;
  private RefreshLoadMoreLayout ojk;
  private ViewGroup ojl;
  private ViewGroup ojm;
  private TextView ojn;
  private View ojo;
  private WxRecyclerAdapter<a> ojp;
  private ArrayList<a> ojq;
  private boolean ojr;
  private boolean ojs;
  private boolean ojt;
  private ri oju;
  private rd ojv;
  private int ojw;
  
  static
  {
    AppMethodBeat.i(206303);
    ojD = new CardHomePageV3UI.c((byte)0);
    ojx = 1;
    ojy = 2;
    ojz = 1;
    ojA = 2;
    ojB = 3;
    ojC = 4;
    AppMethodBeat.o(206303);
  }
  
  public CardHomePageV3UI()
  {
    AppMethodBeat.i(206302);
    this.TAG = "MicroMsg.CardHomePageV3UI";
    this.ojq = new ArrayList();
    AppMethodBeat.o(206302);
  }
  
  private final void Vn(String paramString)
  {
    AppMethodBeat.i(206300);
    Object localObject = (CharSequence)paramString;
    if ((localObject == null) || (((CharSequence)localObject).length() == 0)) {}
    for (int i = 1;; i = 0)
    {
      if (i == 0)
      {
        localObject = this.ojn;
        if (localObject == null) {
          k.aVY("mHomePageRecentlyUsedCardTitleTv");
        }
        ((TextView)localObject).setText((CharSequence)paramString);
      }
      AppMethodBeat.o(206300);
      return;
    }
  }
  
  private final void a(rd paramrd)
  {
    AppMethodBeat.i(206297);
    if (paramrd != null)
    {
      this.ojv = paramrd;
      if (!bs.isNullOrNil(paramrd.Ejo))
      {
        removeAllOptionMenu();
        addIconOptionMenu(0, 0, 2131690603, (MenuItem.OnMenuItemClickListener)new i(paramrd, this));
      }
      AppMethodBeat.o(206297);
      return;
    }
    AppMethodBeat.o(206297);
  }
  
  private final void a(rf paramrf)
  {
    AppMethodBeat.i(206298);
    if (paramrf != null)
    {
      paramrf = paramrf.Ejt.iterator();
      while (paramrf.hasNext())
      {
        re localre = (re)paramrf.next();
        a locala = new a();
        k.g(localre, "cell");
        locala.a(localre);
        this.ojq.add(locala);
      }
      paramrf = this.ojp;
      if (paramrf == null) {
        k.aVY("mPageAdapter");
      }
      paramrf.notifyDataSetChanged();
    }
    bTB();
    AppMethodBeat.o(206298);
  }
  
  private final void a(ri paramri)
  {
    AppMethodBeat.i(206301);
    ac.i(this.TAG, "do update header");
    if (paramri == null)
    {
      AppMethodBeat.o(206301);
      return;
    }
    this.oju = paramri;
    Object localObject1 = this.ojm;
    if (localObject1 == null) {
      k.aVY("mHeaderContainerLayout");
    }
    ((ViewGroup)localObject1).removeAllViews();
    int k = getResources().getDimensionPixelSize(2131165303);
    paramri = paramri.EjE;
    k.g(paramri, "topCellGroup.card_home_page_top_cell_list");
    paramri = ((Iterable)paramri).iterator();
    while (paramri.hasNext())
    {
      Object localObject2 = (rj)paramri.next();
      localObject1 = new LinearLayout((Context)getContext());
      ((LinearLayout)localObject1).setOrientation(1);
      ((LinearLayout)localObject1).setPadding(0, 0, 0, k);
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, -2);
      Object localObject3 = ((rj)localObject2).EjF;
      k.g(localObject3, "group.card_home_page_top_cell");
      localObject3 = ((Iterable)localObject3).iterator();
      int i = 0;
      if (((Iterator)localObject3).hasNext())
      {
        final rh localrh = (rh)((Iterator)localObject3).next();
        View localView = getLayoutInflater().inflate(2131493301, (ViewGroup)localObject1, false);
        Object localObject4 = (ImageView)localView.findViewById(2131298284);
        TextView localTextView1 = (TextView)localView.findViewById(2131298285);
        Object localObject5 = (TextView)localView.findViewById(2131298282);
        TextView localTextView2 = (TextView)localView.findViewById(2131298289);
        ImageView localImageView1 = (ImageView)localView.findViewById(2131298290);
        ImageView localImageView2 = (ImageView)localView.findViewById(2131298291);
        CharSequence localCharSequence = (CharSequence)localrh.Ejx;
        int j;
        if ((localCharSequence == null) || (localCharSequence.length() == 0))
        {
          j = 1;
          label326:
          if ((j != 0) || (localrh.EjC != 1)) {
            break label534;
          }
          k.g(localObject5, "descTv");
          ((TextView)localObject5).setText((CharSequence)localrh.Ejx);
          k.g(localImageView2, "reddot2Iv");
          localImageView2.setVisibility(0);
          k.g(localImageView1, "reddot1Iv");
          localImageView1.setVisibility(8);
          k.g(localTextView2, "newIv");
          localTextView2.setVisibility(8);
        }
        for (;;)
        {
          localObject5 = localrh.Ejv;
          if (localObject5 != null)
          {
            k.g(localObject4, "iconIv");
            m.a((ImageView)localObject4, (String)localObject5, false, 0, 0, 0, 124);
          }
          k.g(localTextView1, "titleTv");
          localTextView1.setText((CharSequence)localrh.Ejw);
          if (i == ((rj)localObject2).EjF.size() - 1)
          {
            localObject4 = localView.findViewById(2131298283);
            k.g(localObject4, "cellView.findViewById<Vi…header_cell_divider_view)");
            ((View)localObject4).setVisibility(8);
          }
          localView.setOnClickListener((View.OnClickListener)new j(this, localrh));
          ((LinearLayout)localObject1).addView(localView);
          i += 1;
          break;
          j = 0;
          break label326;
          label534:
          if (localrh.EjD == 1)
          {
            k.g(localTextView2, "newIv");
            localTextView2.setVisibility(0);
            k.g(localObject5, "descTv");
            ((TextView)localObject5).setText((CharSequence)"");
            k.g(localImageView2, "reddot2Iv");
            localImageView2.setVisibility(8);
            k.g(localImageView1, "reddot1Iv");
            localImageView1.setVisibility(8);
          }
          else if (localrh.EjC == 1)
          {
            k.g(localObject5, "descTv");
            ((TextView)localObject5).setText((CharSequence)"");
            k.g(localImageView1, "reddot1Iv");
            localImageView1.setVisibility(0);
            k.g(localTextView2, "newIv");
            localTextView2.setVisibility(8);
            k.g(localImageView2, "reddot2Iv");
            localImageView2.setVisibility(8);
          }
          else
          {
            k.g(localObject5, "descTv");
            ((TextView)localObject5).setText((CharSequence)"");
            k.g(localImageView1, "reddot1Iv");
            localImageView1.setVisibility(8);
            k.g(localTextView2, "newIv");
            localTextView2.setVisibility(8);
            k.g(localImageView2, "reddot2Iv");
            localImageView2.setVisibility(8);
          }
        }
      }
      localObject2 = this.ojm;
      if (localObject2 == null) {
        k.aVY("mHeaderContainerLayout");
      }
      ((ViewGroup)localObject2).addView((View)localObject1, (ViewGroup.LayoutParams)localLayoutParams);
    }
    AppMethodBeat.o(206301);
  }
  
  private final void bTB()
  {
    AppMethodBeat.i(206299);
    if (this.ojq.isEmpty())
    {
      localObject = this.ojo;
      if (localObject == null) {
        k.aVY("mHomePageEmptyView");
      }
      ((View)localObject).setVisibility(0);
      localObject = this.ojn;
      if (localObject == null) {
        k.aVY("mHomePageRecentlyUsedCardTitleTv");
      }
      ((TextView)localObject).setVisibility(8);
      AppMethodBeat.o(206299);
      return;
    }
    Object localObject = this.ojo;
    if (localObject == null) {
      k.aVY("mHomePageEmptyView");
    }
    ((View)localObject).setVisibility(8);
    localObject = this.ojn;
    if (localObject == null) {
      k.aVY("mHomePageRecentlyUsedCardTitleTv");
    }
    ((TextView)localObject).setVisibility(0);
    AppMethodBeat.o(206299);
  }
  
  private final void jm(final boolean paramBoolean)
  {
    int i = 0;
    AppMethodBeat.i(206296);
    ac.i(this.TAG, "do load home page");
    Object localObject;
    if ((this.ojr) && (!paramBoolean))
    {
      ac.w(this.TAG, "already load complete");
      localObject = this.ojk;
      if (localObject == null) {
        k.aVY("mRefreshLayout");
      }
      ((RefreshLoadMoreLayout)localObject).adz(0);
      AppMethodBeat.o(206296);
      return;
    }
    if (this.kOL)
    {
      ac.w(this.TAG, "is loading");
      AppMethodBeat.o(206296);
      return;
    }
    this.kOL = true;
    int j = this.MW;
    if (paramBoolean)
    {
      localObject = this.ojk;
      if (localObject == null) {
        k.aVY("mRefreshLayout");
      }
      ((RefreshLoadMoreLayout)localObject).setHasBottomMore(true);
    }
    for (;;)
    {
      localObject = new com.tencent.mm.plugin.card.model.b.c(i).aBB();
      k.g(localObject, "CgiGetMktCardHomePageV3(offset, 10).run()");
      com.tencent.mm.ac.c.b((com.tencent.mm.vending.g.c)localObject, (d.g.a.b)new d(this, paramBoolean));
      AppMethodBeat.o(206296);
      return;
      i = j;
    }
  }
  
  public final int getLayoutId()
  {
    return 2131493304;
  }
  
  public final void initView()
  {
    AppMethodBeat.i(206292);
    Object localObject1 = findViewById(2131298315);
    k.g(localObject1, "findViewById(R.id.chpuv3_rv)");
    this.ojj = ((WxRecyclerView)localObject1);
    localObject1 = findViewById(2131298314);
    k.g(localObject1, "findViewById(R.id.chpuv3_refresh_layout)");
    this.ojk = ((RefreshLoadMoreLayout)localObject1);
    localObject1 = this.ojj;
    if (localObject1 == null) {
      k.aVY("mPageRv");
    }
    getContext();
    ((WxRecyclerView)localObject1).setLayoutManager((RecyclerView.i)new LinearLayoutManager(1));
    this.ojp = new WxRecyclerAdapter((com.tencent.mm.view.recyclerview.c)new f(this), this.ojq);
    localObject1 = this.ojj;
    if (localObject1 == null) {
      k.aVY("mPageRv");
    }
    Object localObject2 = this.ojp;
    if (localObject2 == null) {
      k.aVY("mPageAdapter");
    }
    ((WxRecyclerView)localObject1).setAdapter((RecyclerView.a)localObject2);
    localObject1 = new w((Context)getContext());
    ((w)localObject1).setDrawable(getResources().getDrawable(2131231470));
    localObject2 = this.ojj;
    if (localObject2 == null) {
      k.aVY("mPageRv");
    }
    ((WxRecyclerView)localObject2).b((RecyclerView.h)localObject1);
    localObject1 = getLayoutInflater();
    localObject2 = this.ojj;
    if (localObject2 == null) {
      k.aVY("mPageRv");
    }
    localObject1 = ((LayoutInflater)localObject1).inflate(2131493302, (ViewGroup)localObject2, false);
    if (localObject1 == null)
    {
      localObject1 = new v("null cannot be cast to non-null type android.view.ViewGroup");
      AppMethodBeat.o(206292);
      throw ((Throwable)localObject1);
    }
    this.ojl = ((ViewGroup)localObject1);
    localObject1 = this.ojl;
    if (localObject1 == null) {
      k.aVY("mHeaderView");
    }
    localObject1 = ((ViewGroup)localObject1).findViewById(2131298286);
    k.g(localObject1, "mHeaderView.findViewById…_header_container_layout)");
    this.ojm = ((ViewGroup)localObject1);
    localObject1 = this.ojl;
    if (localObject1 == null) {
      k.aVY("mHeaderView");
    }
    localObject1 = ((ViewGroup)localObject1).findViewById(2131298288);
    k.g(localObject1, "mHeaderView.findViewById…hphv3_home_page_title_tv)");
    this.ojn = ((TextView)localObject1);
    localObject1 = this.ojl;
    if (localObject1 == null) {
      k.aVY("mHeaderView");
    }
    localObject1 = ((ViewGroup)localObject1).findViewById(2131298287);
    k.g(localObject1, "mHeaderView.findViewById…3_home_page_empty_layout)");
    this.ojo = ((View)localObject1);
    localObject1 = this.ojp;
    if (localObject1 == null) {
      k.aVY("mPageAdapter");
    }
    localObject2 = this.ojl;
    if (localObject2 == null) {
      k.aVY("mHeaderView");
    }
    ((WxRecyclerAdapter)localObject1).f((View)localObject2, ojy, false);
    localObject1 = this.ojk;
    if (localObject1 == null) {
      k.aVY("mRefreshLayout");
    }
    ((RefreshLoadMoreLayout)localObject1).setEnableRefresh(false);
    localObject1 = this.ojk;
    if (localObject1 == null) {
      k.aVY("mRefreshLayout");
    }
    int i = com.tencent.mm.cc.a.fromDPToPix((Context)getContext(), 1200);
    localObject2 = ai.getContext();
    k.g(localObject2, "MMApplicationContext.getContext()");
    ((RefreshLoadMoreLayout)localObject1).setLimitTopRequest(i - (int)((Context)localObject2).getResources().getDimension(2131165277));
    localObject1 = this.ojk;
    if (localObject1 == null) {
      k.aVY("mRefreshLayout");
    }
    localObject2 = ai.getContext();
    k.g(localObject2, "MMApplicationContext.getContext()");
    ((RefreshLoadMoreLayout)localObject1).setRefreshTargetY((int)((Context)localObject2).getResources().getDimension(2131165299) - com.tencent.mm.cc.a.fromDPToPix((Context)getContext(), 1200));
    localObject1 = this.ojk;
    if (localObject1 == null) {
      k.aVY("mRefreshLayout");
    }
    ((RefreshLoadMoreLayout)localObject1).setDamping(1.85F);
    localObject1 = this.ojk;
    if (localObject1 == null) {
      k.aVY("mRefreshLayout");
    }
    ((RefreshLoadMoreLayout)localObject1).setActionCallback((RefreshLoadMoreLayout.a)new g(this));
    AppMethodBeat.o(206292);
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(206295);
    if (paramInt1 == ojz) {
      jm(true);
    }
    for (;;)
    {
      super.onActivityResult(paramInt1, paramInt2, paramIntent);
      AppMethodBeat.o(206295);
      return;
      if (paramInt1 == ojB) {
        jm(true);
      } else if (paramInt1 == ojA) {
        jm(true);
      } else if (paramInt1 == ojC) {
        jm(true);
      }
    }
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(206291);
    super.onCreate(paramBundle);
    initView();
    setMMTitle(2131756891);
    setActionbarColor(getResources().getColor(2131099648));
    hideActionbarLine();
    setBackBtn((MenuItem.OnMenuItemClickListener)new h(this));
    paramBundle = com.tencent.mm.plugin.card.model.a.a.nXE;
    paramBundle = a.a.bQz();
    if (paramBundle != null)
    {
      this.MW = paramBundle.oGs;
      Vn(paramBundle.ERd);
      a(paramBundle.ERb);
      a(paramBundle.ERc);
      a(paramBundle.EQY);
    }
    jm(true);
    AppMethodBeat.o(206291);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(206294);
    super.onDestroy();
    if (!this.ojs)
    {
      ac.i(this.TAG, "no data to save snapshot");
      AppMethodBeat.o(206294);
      return;
    }
    baa localbaa = new baa();
    localbaa.BaseResponse = new BaseResponse();
    localbaa.BaseResponse.ErrMsg = new crm();
    localbaa.ERb = this.oju;
    Object localObject = this.ojn;
    if (localObject == null) {
      k.aVY("mHomePageRecentlyUsedCardTitleTv");
    }
    localbaa.ERd = ((TextView)localObject).getText().toString();
    localbaa.ERc = new rf();
    localbaa.oGs = this.MW;
    localbaa.EQY = this.ojv;
    localObject = this.ojq.iterator();
    while (((Iterator)localObject).hasNext())
    {
      re localre = ((a)((Iterator)localObject).next()).bTE();
      if (localre != null) {
        localbaa.ERc.Ejt.add(localre);
      }
    }
    localObject = com.tencent.mm.plugin.card.model.a.a.nXE;
    k.h(localbaa, "response");
    ac.d(com.tencent.mm.plugin.card.model.a.a.access$getTAG$cp(), "save home page v3 snapshot");
    com.tencent.mm.ac.c.b(null, (d.g.a.a)new a.a.c(localbaa));
    AppMethodBeat.o(206294);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(206293);
    super.onResume();
    if (this.ojt)
    {
      jm(true);
      this.ojt = false;
    }
    AppMethodBeat.o(206293);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/card/ui/v3/CardHomePageV3UI$CardConvertData;", "Lcom/tencent/mm/view/recyclerview/ConvertData;", "()V", "recentlyUsedCell", "Lcom/tencent/mm/protocal/protobuf/CardHomePageRecentlyUsedCell;", "getRecentlyUsedCell", "()Lcom/tencent/mm/protocal/protobuf/CardHomePageRecentlyUsedCell;", "setRecentlyUsedCell", "(Lcom/tencent/mm/protocal/protobuf/CardHomePageRecentlyUsedCell;)V", "getItemId", "", "getItemType", "", "plugin-card_release"})
  public static final class a
    implements com.tencent.mm.view.recyclerview.a
  {
    public re ojE;
    
    public final void a(re paramre)
    {
      AppMethodBeat.i(206263);
      k.h(paramre, "<set-?>");
      this.ojE = paramre;
      AppMethodBeat.o(206263);
    }
    
    public final re bTE()
    {
      AppMethodBeat.i(206262);
      re localre = this.ojE;
      if (localre == null) {
        k.aVY("recentlyUsedCell");
      }
      AppMethodBeat.o(206262);
      return localre;
    }
    
    public final int bTF()
    {
      AppMethodBeat.i(206265);
      CardHomePageV3UI.c localc = CardHomePageV3UI.ojD;
      int i = CardHomePageV3UI.bTD();
      AppMethodBeat.o(206265);
      return i;
    }
    
    public final long lx()
    {
      AppMethodBeat.i(206264);
      re localre = this.ojE;
      if (localre == null) {
        k.aVY("recentlyUsedCell");
      }
      long l = localre.dvO.hashCode();
      AppMethodBeat.o(206264);
      return l;
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/card/ui/v3/CardHomePageV3UI$CardConverter;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "Lcom/tencent/mm/plugin/card/ui/v3/CardHomePageV3UI$CardConvertData;", "(Lcom/tencent/mm/plugin/card/ui/v3/CardHomePageV3UI;)V", "clearShadowLayer", "", "textview", "Landroid/widget/TextView;", "getLayoutId", "", "onBindViewHolder", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "position", "type", "isHotPatch", "", "payloads", "", "", "onCreateViewHolder", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "setShadowLayer", "showDeleteConfirmDialog", "cardId", "", "userCardId", "plugin-card_release"})
  public final class b
    extends com.tencent.mm.view.recyclerview.b<CardHomePageV3UI.a>
  {
    private static void j(TextView paramTextView)
    {
      AppMethodBeat.i(206276);
      paramTextView.setShadowLayer(0.0F, 0.0F, 0.0F, 0);
      AppMethodBeat.o(206276);
    }
    
    private final void k(TextView paramTextView)
    {
      AppMethodBeat.i(206277);
      paramTextView.setShadowLayer(com.tencent.mm.cc.a.fromDPToPix(paramTextView.getContext(), 4), 0.0F, 0.0F, this.ojF.getResources().getColor(2131099817));
      AppMethodBeat.o(206277);
    }
    
    public final void a(RecyclerView paramRecyclerView, final com.tencent.mm.view.recyclerview.e parame, int paramInt)
    {
      AppMethodBeat.i(206274);
      k.h(paramRecyclerView, "recyclerView");
      k.h(parame, "holder");
      paramRecyclerView = (ViewGroup)parame.adJ(2131298309);
      paramRecyclerView.setOnClickListener((View.OnClickListener)new c(this, parame));
      paramRecyclerView.setOnLongClickListener((View.OnLongClickListener)new d(this, parame));
      AppMethodBeat.o(206274);
    }
    
    public final int getLayoutId()
    {
      return 2131493303;
    }
    
    @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run"})
    static final class a
      implements Runnable
    {
      a(CardHomePageV3UI.b paramb, com.tencent.mm.view.recyclerview.e parame, d.g.a.a parama) {}
      
      public final void run()
      {
        AppMethodBeat.i(206266);
        CardHomePageV3UI localCardHomePageV3UI = this.ojG.ojF;
        View localView = this.ojH.asD;
        k.g(localView, "holder.itemView");
        CardHomePageV3UI.a(localCardHomePageV3UI, localView.getHeight());
        this.ojI.invoke();
        AppMethodBeat.o(206266);
      }
    }
    
    @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
    static final class b
      extends d.g.b.l
      implements d.g.a.a<y>
    {
      b(CardHomePageV3UI.b paramb, MemberCardTopCropImageView paramMemberCardTopCropImageView, CardHomePageV3UI.a parama, com.tencent.mm.view.recyclerview.e parame)
      {
        super();
      }
    }
    
    @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class c
      implements View.OnClickListener
    {
      c(CardHomePageV3UI.b paramb, com.tencent.mm.view.recyclerview.e parame) {}
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(206268);
        paramView = (CardHomePageV3UI.a)parame.fzs();
        Object localObject;
        String str;
        switch (paramView.bTE().EiQ)
        {
        default: 
          ac.w(CardHomePageV3UI.a(this.ojG.ojF), "unknown type " + paramView.bTE().EiQ);
          localObject = this.ojG.ojF;
          str = paramView.bTE().DMR;
          k.g(str, "cardConvertData.recentlyUsedCell.user_card_id");
          CardHomePageV3UI.a((CardHomePageV3UI)localObject, str);
        }
        for (;;)
        {
          h.wUl.f(19674, new Object[] { Integer.valueOf(1), Integer.valueOf(paramView.bTE().lRv), paramView.bTE().DMR, Long.valueOf(System.currentTimeMillis() / 1000L) });
          AppMethodBeat.o(206268);
          return;
          com.tencent.mm.plugin.card.d.b.a((MMActivity)this.ojG.ojF.getContext(), paramView.bTE().EiR);
          continue;
          localObject = paramView.bTE().EiS;
          if (localObject != null)
          {
            com.tencent.mm.plugin.card.d.b.H(((rm)localObject).AZE, ((rm)localObject).AZF, ((rm)localObject).BGS);
            continue;
            localObject = this.ojG.ojF;
            str = paramView.bTE().DMR;
            k.g(str, "cardConvertData.recentlyUsedCell.user_card_id");
            CardHomePageV3UI.a((CardHomePageV3UI)localObject, str);
          }
        }
      }
    }
    
    @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onLongClick"})
    static final class d
      implements View.OnLongClickListener
    {
      d(CardHomePageV3UI.b paramb, com.tencent.mm.view.recyclerview.e parame) {}
      
      public final boolean onLongClick(View paramView)
      {
        AppMethodBeat.i(206271);
        final CardHomePageV3UI.a locala1 = (CardHomePageV3UI.a)parame.fzs();
        com.tencent.mm.ui.widget.b.a locala = new com.tencent.mm.ui.widget.b.a((Context)this.ojG.ojF.getContext(), paramView);
        locala.a((View.OnCreateContextMenuListener)new View.OnCreateContextMenuListener()
        {
          public final void onCreateContextMenu(ContextMenu paramAnonymousContextMenu, View paramAnonymousView, ContextMenu.ContextMenuInfo paramAnonymousContextMenuInfo)
          {
            AppMethodBeat.i(206269);
            paramAnonymousContextMenu.add(0, 1, 0, (CharSequence)this.ojL.ojG.ojF.getString(2131760291));
            AppMethodBeat.o(206269);
          }
        });
        locala.a((n.d)new n.d()
        {
          public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
          {
            AppMethodBeat.i(206270);
            paramAnonymousMenuItem = this.ojL.ojG;
            String str1 = locala1.bTE().dvO;
            k.g(str1, "cardConvertData.recentlyUsedCell.card_id");
            String str2 = locala1.bTE().DMR;
            k.g(str2, "cardConvertData.recentlyUsedCell.user_card_id");
            com.tencent.mm.ui.widget.a.e locale = new com.tencent.mm.ui.widget.a.e((Context)paramAnonymousMenuItem.ojF.getContext(), 1, true);
            TextView localTextView = new TextView((Context)paramAnonymousMenuItem.ojF.getContext());
            localTextView.setText((CharSequence)paramAnonymousMenuItem.ojF.getString(2131756890));
            localTextView.setTextSize(1, 14.0F);
            localTextView.setTextColor(paramAnonymousMenuItem.ojF.getResources().getColor(2131100482));
            localTextView.setGravity(17);
            paramAnonymousInt = paramAnonymousMenuItem.ojF.getResources().getDimensionPixelSize(2131165303);
            int i = paramAnonymousMenuItem.ojF.getResources().getDimensionPixelSize(2131165289);
            localTextView.setPadding(paramAnonymousInt, i, paramAnonymousInt, i);
            locale.J((View)localTextView, false);
            locale.a((n.c)new CardHomePageV3UI.b.e(paramAnonymousMenuItem));
            locale.a((n.d)new CardHomePageV3UI.b.f(paramAnonymousMenuItem, str1, str2));
            locale.cED();
            h.wUl.f(19674, new Object[] { Integer.valueOf(2), Integer.valueOf(locala1.bTE().lRv), locala1.bTE().DMR, Long.valueOf(System.currentTimeMillis() / 1000L) });
            AppMethodBeat.o(206270);
          }
        });
        k.g(paramView, "it");
        paramView = m.dG(paramView);
        locala.ej(paramView.x, paramView.y);
        AppMethodBeat.o(206271);
        return false;
      }
    }
    
    @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Lcom/tencent/mm/ui/base/MMMenu;", "kotlin.jvm.PlatformType", "onCreateMMMenu"})
    static final class e
      implements n.c
    {
      e(CardHomePageV3UI.b paramb) {}
      
      public final void onCreateMMMenu(com.tencent.mm.ui.base.l paraml)
      {
        AppMethodBeat.i(206272);
        paraml.a(1, this.ojG.ojF.getResources().getColor(2131100800), (CharSequence)this.ojG.ojF.getString(2131755835));
        AppMethodBeat.o(206272);
      }
    }
    
    @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "menuItem", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "", "onMMMenuItemSelected"})
    static final class f
      implements n.d
    {
      f(CardHomePageV3UI.b paramb, String paramString1, String paramString2) {}
      
      public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
      {
        AppMethodBeat.i(206273);
        k.g(paramMenuItem, "menuItem");
        switch (paramMenuItem.getItemId())
        {
        }
        for (;;)
        {
          AppMethodBeat.o(206273);
          return;
          paramMenuItem = this.ojG.ojF;
          Object localObject = this.oiB;
          String str = this.ojN;
          k.h(localObject, "cardId");
          k.h(str, "userCardId");
          ac.i(paramMenuItem.TAG, "do remove recently: " + (String)localObject + ", " + str);
          localObject = new d((String)localObject, str).aBB();
          k.g(localObject, "CgiRemoveCardInRecentlyU…cardId, userCardId).run()");
          com.tencent.mm.ac.c.b((com.tencent.mm.vending.g.c)localObject, (d.g.a.b)new CardHomePageV3UI.e(paramMenuItem, str)).b((com.tencent.mm.vending.e.b)paramMenuItem);
        }
      }
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Lcom/tencent/mm/modelbase/DeprecatedCgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/GetMktCardHomePageV2Response;", "kotlin.jvm.PlatformType", "invoke"})
  static final class d
    extends d.g.b.l
    implements d.g.a.b<c.a<baa>, y>
  {
    d(CardHomePageV3UI paramCardHomePageV3UI, boolean paramBoolean)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Lcom/tencent/mm/modelbase/DeprecatedCgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/RemoveCardInRecentlyUsedListResponse;", "kotlin.jvm.PlatformType", "invoke", "(Lcom/tencent/mm/modelbase/DeprecatedCgi$CgiBack;)Lkotlin/Unit;"})
  static final class e
    extends d.g.b.l
    implements d.g.a.b<c.a<cof>, y>
  {
    e(CardHomePageV3UI paramCardHomePageV3UI, String paramString)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/card/ui/v3/CardHomePageV3UI$initView$1", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "getItemConvert", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "type", "", "plugin-card_release"})
  public static final class f
    implements com.tencent.mm.view.recyclerview.c
  {
    public final com.tencent.mm.view.recyclerview.b<?> Ac(int paramInt)
    {
      AppMethodBeat.i(206280);
      com.tencent.mm.view.recyclerview.b localb = (com.tencent.mm.view.recyclerview.b)new CardHomePageV3UI.b(this.ojF);
      AppMethodBeat.o(206280);
      return localb;
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/card/ui/v3/CardHomePageV3UI$initView$2", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback;", "onLoadMoreBegin", "", "onLoadMoreEnd", "reason", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;", "", "onRefreshBegin", "refreshType", "", "onRefreshEnd", "plugin-card_release"})
  public static final class g
    extends RefreshLoadMoreLayout.a
  {
    public final void Ad(int paramInt)
    {
      AppMethodBeat.i(206284);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.lS(paramInt);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/card/ui/v3/CardHomePageV3UI$initView$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshBegin", "(I)V", this, localb.aeE());
      ac.d(CardHomePageV3UI.a(this.ojF), "on begin refresh");
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/card/ui/v3/CardHomePageV3UI$initView$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshBegin", "(I)V");
      AppMethodBeat.o(206284);
    }
    
    public final void a(RefreshLoadMoreLayout.c<Object> paramc)
    {
      AppMethodBeat.i(206283);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bb(paramc);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/card/ui/v3/CardHomePageV3UI$initView$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V", this, localb.aeE());
      k.h(paramc, "reason");
      ac.d(CardHomePageV3UI.a(this.ojF), "on load more end: " + CardHomePageV3UI.d(this.ojF));
      if (CardHomePageV3UI.e(this.ojF)) {
        CardHomePageV3UI.f(this.ojF).i(null);
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/card/ui/v3/CardHomePageV3UI$initView$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V");
      AppMethodBeat.o(206283);
    }
    
    public final void b(RefreshLoadMoreLayout.c<Object> paramc)
    {
      AppMethodBeat.i(206285);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bb(paramc);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/card/ui/v3/CardHomePageV3UI$initView$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V", this, localb.aeE());
      k.h(paramc, "reason");
      ac.d(CardHomePageV3UI.a(this.ojF), "on refresh end");
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/card/ui/v3/CardHomePageV3UI$initView$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V");
      AppMethodBeat.o(206285);
    }
    
    public final void bTG()
    {
      AppMethodBeat.i(206282);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/card/ui/v3/CardHomePageV3UI$initView$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreBegin", "()V", this);
      ac.d(CardHomePageV3UI.a(this.ojF), "on load more");
      com.tencent.mm.ac.c.g((d.g.a.a)new a(this));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/card/ui/v3/CardHomePageV3UI$initView$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreBegin", "()V");
      AppMethodBeat.o(206282);
    }
    
    @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
    static final class a
      extends d.g.b.l
      implements d.g.a.a<y>
    {
      a(CardHomePageV3UI.g paramg)
      {
        super();
      }
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class h
    implements MenuItem.OnMenuItemClickListener
  {
    h(CardHomePageV3UI paramCardHomePageV3UI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(206286);
      this.ojF.finish();
      AppMethodBeat.o(206286);
      return false;
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick", "com/tencent/mm/plugin/card/ui/v3/CardHomePageV3UI$updateFAQ$1$1"})
  static final class i
    implements MenuItem.OnMenuItemClickListener
  {
    i(rd paramrd, CardHomePageV3UI paramCardHomePageV3UI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(206289);
      paramMenuItem = new com.tencent.mm.ui.widget.a.e((Context)jdField_this.getContext(), 1, false);
      paramMenuItem.a((n.c)new n.c()
      {
        public final void onCreateMMMenu(com.tencent.mm.ui.base.l paramAnonymousl)
        {
          AppMethodBeat.i(206287);
          paramAnonymousl.add(0, 0, 1, (CharSequence)this.ojQ.ois.Ejo);
          AppMethodBeat.o(206287);
        }
      });
      paramMenuItem.a((n.d)new n.d()
      {
        public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
        {
          AppMethodBeat.i(206288);
          k.g(paramAnonymousMenuItem, "menuItem");
          if (paramAnonymousMenuItem.getItemId() == 0) {
            switch (this.ojQ.ois.Ejp)
            {
            }
          }
          for (;;)
          {
            AppMethodBeat.o(206288);
            return;
            com.tencent.mm.plugin.card.d.b.a((MMActivity)this.ojQ.ojF.getContext(), this.ojQ.ois.Ejq);
            AppMethodBeat.o(206288);
            return;
            paramAnonymousMenuItem = this.ojQ.ois.Ejr;
            com.tencent.mm.plugin.card.d.b.H(paramAnonymousMenuItem.AZE, paramAnonymousMenuItem.AZF, paramAnonymousMenuItem.BGS);
          }
        }
      });
      paramMenuItem.cED();
      AppMethodBeat.o(206289);
      return false;
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class j
    implements View.OnClickListener
  {
    j(CardHomePageV3UI paramCardHomePageV3UI, rh paramrh) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(206290);
      switch (localrh.Ejy)
      {
      default: 
        ac.w(CardHomePageV3UI.a(this.ojF), "unknown type " + localrh.Ejy);
      }
      for (;;)
      {
        h.wUl.f(19673, new Object[] { localrh.Ejw, Long.valueOf(System.currentTimeMillis() / 1000L) });
        AppMethodBeat.o(206290);
        return;
        com.tencent.mm.plugin.card.d.b.a((MMActivity)this.ojF.getContext(), localrh.Ejz);
        continue;
        paramView = localrh.EjA;
        if (paramView != null)
        {
          com.tencent.mm.plugin.card.d.b.H(paramView.AZE, paramView.AZF, paramView.BGS);
          CardHomePageV3UI.k(this.ojF);
          continue;
          if ("weixin://mktcard/cert".equals(localrh.EjB)) {
            CardHomePageV3UI.l(this.ojF);
          } else if ("weixin://mktcard/membercard".equals(localrh.EjB)) {
            CardHomePageV3UI.m(this.ojF);
          } else if ("weixin://mktcard/coupon".equals(localrh.EjB)) {
            CardHomePageV3UI.n(this.ojF);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.v3.CardHomePageV3UI
 * JD-Core Version:    0.7.0.1
 */