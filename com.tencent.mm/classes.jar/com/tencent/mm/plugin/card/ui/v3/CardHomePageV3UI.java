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
import com.tencent.mm.kernel.i;
import com.tencent.mm.plugin.card.d.m;
import com.tencent.mm.plugin.card.model.a.a.a.c;
import com.tencent.mm.plugin.card.model.b.d;
import com.tencent.mm.plugin.card.widget.MemberCardTopCropImageView;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.beu;
import com.tencent.mm.protocal.protobuf.cuc;
import com.tencent.mm.protocal.protobuf.cxn;
import com.tencent.mm.protocal.protobuf.sz;
import com.tencent.mm.protocal.protobuf.ta;
import com.tencent.mm.protocal.protobuf.tb;
import com.tencent.mm.protocal.protobuf.td;
import com.tencent.mm.protocal.protobuf.te;
import com.tencent.mm.protocal.protobuf.tf;
import com.tencent.mm.protocal.protobuf.ti;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.n.e;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.RefreshLoadMoreLayout.a;
import com.tencent.mm.view.RefreshLoadMoreLayout.c;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.mm.view.recyclerview.WxRecyclerView;
import d.g.b.p;
import d.g.b.q;
import d.v;
import d.z;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

@i
@d.l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/card/ui/v3/CardHomePageV3UI;", "Lcom/tencent/mm/ui/MMActivity;", "()V", "TAG", "", "loadCount", "", "loadingDialog", "Landroid/app/Dialog;", "mCardDataList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/card/ui/v3/CardHomePageV3UI$CardConvertData;", "Lkotlin/collections/ArrayList;", "mCardHomePageTopCellGroup", "Lcom/tencent/mm/protocal/protobuf/CardHomePageTopCellGroup;", "mFAQItem", "Lcom/tencent/mm/protocal/protobuf/CardHomePageFAQItem;", "mHasLoadedSuccess", "", "mHeaderContainerLayout", "Landroid/view/ViewGroup;", "mHeaderView", "mHomePageEmptyView", "Landroid/view/View;", "mHomePageRecentlyUsedCardTitleTv", "Landroid/widget/TextView;", "mIsAll", "mIsLoading", "mNeedRefreshPage", "mOffset", "mPageAdapter", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "mPageRv", "Lcom/tencent/mm/view/recyclerview/WxRecyclerView;", "mRefreshLayout", "Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "mViewHeight", "doLoadHomePage", "", "refresh", "doRemoveRecentlyCard", "cardId", "userCardId", "getLayoutId", "gotoCardDetailUI", "gotoCertListUI", "gotoCouponCardListUI", "title", "gotoVipCardListUI", "hideLoading", "initView", "loadSnapshot", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onResume", "removeCardByCardId", "saveSnapshot", "showLoading", "updateCardList", "cardList", "Lcom/tencent/mm/protocal/protobuf/CardHomePageRecentlyUsedList;", "updateFAQ", "faqItem", "updateHeader", "topCellGroup", "updateRecentlyUsedCardTitleLayout", "updateRecentlyUsedTitle", "CardConvertData", "CardConverter", "Companion", "plugin-card_release"})
public final class CardHomePageV3UI
  extends MMActivity
{
  private static final int oTA = 4;
  public static final CardHomePageV3UI.c oTB;
  private static final int oTv = 1;
  private static final int oTw = 2;
  private static final int oTx = 1;
  private static final int oTy = 2;
  private static final int oTz = 3;
  String TAG;
  private int aYT;
  private int fq;
  private boolean lpM;
  private WxRecyclerView oTh;
  private RefreshLoadMoreLayout oTi;
  private ViewGroup oTj;
  private ViewGroup oTk;
  private TextView oTl;
  private View oTm;
  private WxRecyclerAdapter<a> oTn;
  private ArrayList<a> oTo;
  private boolean oTp;
  private boolean oTq;
  private boolean oTr;
  private te oTs;
  private sz oTt;
  private int oTu;
  
  static
  {
    AppMethodBeat.i(218462);
    oTB = new CardHomePageV3UI.c((byte)0);
    oTv = 1;
    oTw = 2;
    oTx = 1;
    oTy = 2;
    oTz = 3;
    oTA = 4;
    AppMethodBeat.o(218462);
  }
  
  public CardHomePageV3UI()
  {
    AppMethodBeat.i(218461);
    this.TAG = "MicroMsg.CardHomePageV3UI";
    this.oTo = new ArrayList();
    AppMethodBeat.o(218461);
  }
  
  private final void ZN(String paramString)
  {
    AppMethodBeat.i(218459);
    Object localObject = (CharSequence)paramString;
    if ((localObject == null) || (((CharSequence)localObject).length() == 0)) {}
    for (int i = 1;; i = 0)
    {
      if (i == 0)
      {
        localObject = this.oTl;
        if (localObject == null) {
          p.bdF("mHomePageRecentlyUsedCardTitleTv");
        }
        ((TextView)localObject).setText((CharSequence)paramString);
      }
      AppMethodBeat.o(218459);
      return;
    }
  }
  
  private final void a(sz paramsz)
  {
    AppMethodBeat.i(218456);
    if (paramsz != null)
    {
      this.oTt = paramsz;
      if (!bu.isNullOrNil(paramsz.GiX))
      {
        removeAllOptionMenu();
        addIconOptionMenu(0, 0, 2131690603, (MenuItem.OnMenuItemClickListener)new i(paramsz, this));
      }
      AppMethodBeat.o(218456);
      return;
    }
    AppMethodBeat.o(218456);
  }
  
  private final void a(tb paramtb)
  {
    AppMethodBeat.i(218457);
    if (paramtb != null)
    {
      paramtb = paramtb.Gjc.iterator();
      while (paramtb.hasNext())
      {
        ta localta = (ta)paramtb.next();
        a locala = new a();
        p.g(localta, "cell");
        locala.a(localta);
        this.oTo.add(locala);
      }
      paramtb = this.oTn;
      if (paramtb == null) {
        p.bdF("mPageAdapter");
      }
      paramtb.notifyDataSetChanged();
    }
    bZv();
    AppMethodBeat.o(218457);
  }
  
  private final void a(te paramte)
  {
    AppMethodBeat.i(218460);
    ae.i(this.TAG, "do update header");
    if (paramte == null)
    {
      AppMethodBeat.o(218460);
      return;
    }
    this.oTs = paramte;
    Object localObject1 = this.oTk;
    if (localObject1 == null) {
      p.bdF("mHeaderContainerLayout");
    }
    ((ViewGroup)localObject1).removeAllViews();
    int k = getResources().getDimensionPixelSize(2131165303);
    paramte = paramte.Gjn;
    p.g(paramte, "topCellGroup.card_home_page_top_cell_list");
    paramte = ((Iterable)paramte).iterator();
    while (paramte.hasNext())
    {
      Object localObject2 = (tf)paramte.next();
      localObject1 = new LinearLayout((Context)getContext());
      ((LinearLayout)localObject1).setOrientation(1);
      ((LinearLayout)localObject1).setPadding(0, 0, 0, k);
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, -2);
      Object localObject3 = ((tf)localObject2).Gjo;
      p.g(localObject3, "group.card_home_page_top_cell");
      localObject3 = ((Iterable)localObject3).iterator();
      int i = 0;
      if (((Iterator)localObject3).hasNext())
      {
        final td localtd = (td)((Iterator)localObject3).next();
        View localView = getLayoutInflater().inflate(2131493301, (ViewGroup)localObject1, false);
        Object localObject4 = (ImageView)localView.findViewById(2131298284);
        TextView localTextView1 = (TextView)localView.findViewById(2131298285);
        Object localObject5 = (TextView)localView.findViewById(2131298282);
        TextView localTextView2 = (TextView)localView.findViewById(2131298289);
        ImageView localImageView1 = (ImageView)localView.findViewById(2131298290);
        ImageView localImageView2 = (ImageView)localView.findViewById(2131298291);
        CharSequence localCharSequence = (CharSequence)localtd.Gjg;
        int j;
        if ((localCharSequence == null) || (localCharSequence.length() == 0))
        {
          j = 1;
          label326:
          if ((j != 0) || (localtd.Gjl != 1)) {
            break label534;
          }
          p.g(localObject5, "descTv");
          ((TextView)localObject5).setText((CharSequence)localtd.Gjg);
          p.g(localImageView2, "reddot2Iv");
          localImageView2.setVisibility(0);
          p.g(localImageView1, "reddot1Iv");
          localImageView1.setVisibility(8);
          p.g(localTextView2, "newIv");
          localTextView2.setVisibility(8);
        }
        for (;;)
        {
          localObject5 = localtd.Gje;
          if (localObject5 != null)
          {
            p.g(localObject4, "iconIv");
            m.a((ImageView)localObject4, (String)localObject5, false, 0, 0, 0, 124);
          }
          p.g(localTextView1, "titleTv");
          localTextView1.setText((CharSequence)localtd.Gjf);
          if (i == ((tf)localObject2).Gjo.size() - 1)
          {
            localObject4 = localView.findViewById(2131298283);
            p.g(localObject4, "cellView.findViewById<Vi…header_cell_divider_view)");
            ((View)localObject4).setVisibility(8);
          }
          localView.setOnClickListener((View.OnClickListener)new j(this, localtd));
          ((LinearLayout)localObject1).addView(localView);
          i += 1;
          break;
          j = 0;
          break label326;
          label534:
          if (localtd.Gjm == 1)
          {
            p.g(localTextView2, "newIv");
            localTextView2.setVisibility(0);
            p.g(localObject5, "descTv");
            ((TextView)localObject5).setText((CharSequence)"");
            p.g(localImageView2, "reddot2Iv");
            localImageView2.setVisibility(8);
            p.g(localImageView1, "reddot1Iv");
            localImageView1.setVisibility(8);
          }
          else if (localtd.Gjl == 1)
          {
            p.g(localObject5, "descTv");
            ((TextView)localObject5).setText((CharSequence)"");
            p.g(localImageView1, "reddot1Iv");
            localImageView1.setVisibility(0);
            p.g(localTextView2, "newIv");
            localTextView2.setVisibility(8);
            p.g(localImageView2, "reddot2Iv");
            localImageView2.setVisibility(8);
          }
          else
          {
            p.g(localObject5, "descTv");
            ((TextView)localObject5).setText((CharSequence)"");
            p.g(localImageView1, "reddot1Iv");
            localImageView1.setVisibility(8);
            p.g(localTextView2, "newIv");
            localTextView2.setVisibility(8);
            p.g(localImageView2, "reddot2Iv");
            localImageView2.setVisibility(8);
          }
        }
      }
      localObject2 = this.oTk;
      if (localObject2 == null) {
        p.bdF("mHeaderContainerLayout");
      }
      ((ViewGroup)localObject2).addView((View)localObject1, (ViewGroup.LayoutParams)localLayoutParams);
    }
    AppMethodBeat.o(218460);
  }
  
  private final void bZv()
  {
    AppMethodBeat.i(218458);
    if (this.oTo.isEmpty())
    {
      localObject = this.oTm;
      if (localObject == null) {
        p.bdF("mHomePageEmptyView");
      }
      ((View)localObject).setVisibility(0);
      localObject = this.oTl;
      if (localObject == null) {
        p.bdF("mHomePageRecentlyUsedCardTitleTv");
      }
      ((TextView)localObject).setVisibility(8);
      AppMethodBeat.o(218458);
      return;
    }
    Object localObject = this.oTm;
    if (localObject == null) {
      p.bdF("mHomePageEmptyView");
    }
    ((View)localObject).setVisibility(8);
    localObject = this.oTl;
    if (localObject == null) {
      p.bdF("mHomePageRecentlyUsedCardTitleTv");
    }
    ((TextView)localObject).setVisibility(0);
    AppMethodBeat.o(218458);
  }
  
  private final void jw(final boolean paramBoolean)
  {
    int i = 0;
    AppMethodBeat.i(218455);
    ae.i(this.TAG, "do load home page");
    Object localObject;
    if ((this.oTp) && (!paramBoolean))
    {
      ae.w(this.TAG, "already load complete");
      localObject = this.oTi;
      if (localObject == null) {
        p.bdF("mRefreshLayout");
      }
      ((RefreshLoadMoreLayout)localObject).agI(0);
      AppMethodBeat.o(218455);
      return;
    }
    if (this.lpM)
    {
      ae.w(this.TAG, "is loading");
      AppMethodBeat.o(218455);
      return;
    }
    this.lpM = true;
    int j = this.fq;
    if (paramBoolean)
    {
      localObject = this.oTi;
      if (localObject == null) {
        p.bdF("mRefreshLayout");
      }
      ((RefreshLoadMoreLayout)localObject).setHasBottomMore(true);
    }
    for (;;)
    {
      localObject = new com.tencent.mm.plugin.card.model.b.c(i).aET();
      p.g(localObject, "CgiGetMktCardHomePageV3(offset, 10).run()");
      com.tencent.mm.ac.c.b((com.tencent.mm.vending.g.c)localObject, (d.g.a.b)new d(this, paramBoolean));
      AppMethodBeat.o(218455);
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
    AppMethodBeat.i(218451);
    Object localObject1 = findViewById(2131298315);
    p.g(localObject1, "findViewById(R.id.chpuv3_rv)");
    this.oTh = ((WxRecyclerView)localObject1);
    localObject1 = findViewById(2131298314);
    p.g(localObject1, "findViewById(R.id.chpuv3_refresh_layout)");
    this.oTi = ((RefreshLoadMoreLayout)localObject1);
    localObject1 = this.oTh;
    if (localObject1 == null) {
      p.bdF("mPageRv");
    }
    getContext();
    ((WxRecyclerView)localObject1).setLayoutManager((RecyclerView.i)new LinearLayoutManager(1));
    this.oTn = new WxRecyclerAdapter((com.tencent.mm.view.recyclerview.c)new f(this), this.oTo);
    localObject1 = this.oTh;
    if (localObject1 == null) {
      p.bdF("mPageRv");
    }
    Object localObject2 = this.oTn;
    if (localObject2 == null) {
      p.bdF("mPageAdapter");
    }
    ((WxRecyclerView)localObject1).setAdapter((RecyclerView.a)localObject2);
    localObject1 = new w((Context)getContext());
    ((w)localObject1).setDrawable(getResources().getDrawable(2131231470));
    localObject2 = this.oTh;
    if (localObject2 == null) {
      p.bdF("mPageRv");
    }
    ((WxRecyclerView)localObject2).b((RecyclerView.h)localObject1);
    localObject1 = getLayoutInflater();
    localObject2 = this.oTh;
    if (localObject2 == null) {
      p.bdF("mPageRv");
    }
    localObject1 = ((LayoutInflater)localObject1).inflate(2131493302, (ViewGroup)localObject2, false);
    if (localObject1 == null)
    {
      localObject1 = new v("null cannot be cast to non-null type android.view.ViewGroup");
      AppMethodBeat.o(218451);
      throw ((Throwable)localObject1);
    }
    this.oTj = ((ViewGroup)localObject1);
    localObject1 = this.oTj;
    if (localObject1 == null) {
      p.bdF("mHeaderView");
    }
    localObject1 = ((ViewGroup)localObject1).findViewById(2131298286);
    p.g(localObject1, "mHeaderView.findViewById…_header_container_layout)");
    this.oTk = ((ViewGroup)localObject1);
    localObject1 = this.oTj;
    if (localObject1 == null) {
      p.bdF("mHeaderView");
    }
    localObject1 = ((ViewGroup)localObject1).findViewById(2131298288);
    p.g(localObject1, "mHeaderView.findViewById…hphv3_home_page_title_tv)");
    this.oTl = ((TextView)localObject1);
    localObject1 = this.oTj;
    if (localObject1 == null) {
      p.bdF("mHeaderView");
    }
    localObject1 = ((ViewGroup)localObject1).findViewById(2131298287);
    p.g(localObject1, "mHeaderView.findViewById…3_home_page_empty_layout)");
    this.oTm = ((View)localObject1);
    localObject1 = this.oTn;
    if (localObject1 == null) {
      p.bdF("mPageAdapter");
    }
    localObject2 = this.oTj;
    if (localObject2 == null) {
      p.bdF("mHeaderView");
    }
    ((WxRecyclerAdapter)localObject1).f((View)localObject2, oTw, false);
    localObject1 = this.oTi;
    if (localObject1 == null) {
      p.bdF("mRefreshLayout");
    }
    ((RefreshLoadMoreLayout)localObject1).setEnableRefresh(false);
    localObject1 = this.oTi;
    if (localObject1 == null) {
      p.bdF("mRefreshLayout");
    }
    int i = com.tencent.mm.cb.a.fromDPToPix((Context)getContext(), 1200);
    localObject2 = ak.getContext();
    p.g(localObject2, "MMApplicationContext.getContext()");
    ((RefreshLoadMoreLayout)localObject1).setLimitTopRequest(i - (int)((Context)localObject2).getResources().getDimension(2131165277));
    localObject1 = this.oTi;
    if (localObject1 == null) {
      p.bdF("mRefreshLayout");
    }
    localObject2 = ak.getContext();
    p.g(localObject2, "MMApplicationContext.getContext()");
    ((RefreshLoadMoreLayout)localObject1).setRefreshTargetY((int)((Context)localObject2).getResources().getDimension(2131165299) - com.tencent.mm.cb.a.fromDPToPix((Context)getContext(), 1200));
    localObject1 = this.oTi;
    if (localObject1 == null) {
      p.bdF("mRefreshLayout");
    }
    ((RefreshLoadMoreLayout)localObject1).setDamping(1.85F);
    localObject1 = this.oTi;
    if (localObject1 == null) {
      p.bdF("mRefreshLayout");
    }
    ((RefreshLoadMoreLayout)localObject1).setActionCallback((RefreshLoadMoreLayout.a)new g(this));
    AppMethodBeat.o(218451);
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(218454);
    if (paramInt1 == oTx) {
      jw(true);
    }
    for (;;)
    {
      super.onActivityResult(paramInt1, paramInt2, paramIntent);
      AppMethodBeat.o(218454);
      return;
      if (paramInt1 == oTz) {
        jw(true);
      } else if (paramInt1 == oTy) {
        jw(true);
      } else if (paramInt1 == oTA) {
        jw(true);
      }
    }
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(218450);
    super.onCreate(paramBundle);
    initView();
    setMMTitle(2131756891);
    setActionbarColor(getResources().getColor(2131099648));
    hideActionbarLine();
    setBackBtn((MenuItem.OnMenuItemClickListener)new h(this));
    paramBundle = com.tencent.mm.plugin.card.model.a.a.oHA;
    paramBundle = com.tencent.mm.plugin.card.model.a.a.a.bWt();
    if (paramBundle != null)
    {
      this.fq = paramBundle.pqB;
      ZN(paramBundle.GTU);
      a(paramBundle.GTS);
      a(paramBundle.GTT);
      a(paramBundle.GTP);
    }
    jw(true);
    AppMethodBeat.o(218450);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(218453);
    super.onDestroy();
    if (!this.oTq)
    {
      ae.i(this.TAG, "no data to save snapshot");
      AppMethodBeat.o(218453);
      return;
    }
    beu localbeu = new beu();
    localbeu.BaseResponse = new BaseResponse();
    localbeu.BaseResponse.ErrMsg = new cxn();
    localbeu.GTS = this.oTs;
    Object localObject = this.oTl;
    if (localObject == null) {
      p.bdF("mHomePageRecentlyUsedCardTitleTv");
    }
    localbeu.GTU = ((TextView)localObject).getText().toString();
    localbeu.GTT = new tb();
    localbeu.pqB = this.fq;
    localbeu.GTP = this.oTt;
    localObject = this.oTo.iterator();
    while (((Iterator)localObject).hasNext())
    {
      ta localta = ((a)((Iterator)localObject).next()).bZy();
      if (localta != null) {
        localbeu.GTT.Gjc.add(localta);
      }
    }
    localObject = com.tencent.mm.plugin.card.model.a.a.oHA;
    p.h(localbeu, "response");
    ae.d(com.tencent.mm.plugin.card.model.a.a.access$getTAG$cp(), "save home page v3 snapshot");
    com.tencent.mm.ac.c.b(null, (d.g.a.a)new a.a.c(localbeu));
    AppMethodBeat.o(218453);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(218452);
    super.onResume();
    if (this.oTr)
    {
      jw(true);
      this.oTr = false;
    }
    AppMethodBeat.o(218452);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/card/ui/v3/CardHomePageV3UI$CardConvertData;", "Lcom/tencent/mm/view/recyclerview/ConvertData;", "()V", "recentlyUsedCell", "Lcom/tencent/mm/protocal/protobuf/CardHomePageRecentlyUsedCell;", "getRecentlyUsedCell", "()Lcom/tencent/mm/protocal/protobuf/CardHomePageRecentlyUsedCell;", "setRecentlyUsedCell", "(Lcom/tencent/mm/protocal/protobuf/CardHomePageRecentlyUsedCell;)V", "getItemId", "", "getItemType", "", "plugin-card_release"})
  public static final class a
    implements com.tencent.mm.view.recyclerview.a
  {
    public ta oTC;
    
    public final void a(ta paramta)
    {
      AppMethodBeat.i(218422);
      p.h(paramta, "<set-?>");
      this.oTC = paramta;
      AppMethodBeat.o(218422);
    }
    
    public final ta bZy()
    {
      AppMethodBeat.i(218421);
      ta localta = this.oTC;
      if (localta == null) {
        p.bdF("recentlyUsedCell");
      }
      AppMethodBeat.o(218421);
      return localta;
    }
    
    public final int bZz()
    {
      AppMethodBeat.i(218424);
      CardHomePageV3UI.c localc = CardHomePageV3UI.oTB;
      int i = CardHomePageV3UI.bZx();
      AppMethodBeat.o(218424);
      return i;
    }
    
    public final long lP()
    {
      AppMethodBeat.i(218423);
      ta localta = this.oTC;
      if (localta == null) {
        p.bdF("recentlyUsedCell");
      }
      long l = localta.dJb.hashCode();
      AppMethodBeat.o(218423);
      return l;
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/card/ui/v3/CardHomePageV3UI$CardConverter;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "Lcom/tencent/mm/plugin/card/ui/v3/CardHomePageV3UI$CardConvertData;", "(Lcom/tencent/mm/plugin/card/ui/v3/CardHomePageV3UI;)V", "clearShadowLayer", "", "textview", "Landroid/widget/TextView;", "getLayoutId", "", "onBindViewHolder", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "position", "type", "isHotPatch", "", "payloads", "", "", "onCreateViewHolder", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "setShadowLayer", "showDeleteConfirmDialog", "cardId", "", "userCardId", "plugin-card_release"})
  public final class b
    extends com.tencent.mm.view.recyclerview.b<CardHomePageV3UI.a>
  {
    private static void i(TextView paramTextView)
    {
      AppMethodBeat.i(218435);
      paramTextView.setShadowLayer(0.0F, 0.0F, 0.0F, 0);
      AppMethodBeat.o(218435);
    }
    
    private final void j(TextView paramTextView)
    {
      AppMethodBeat.i(218436);
      paramTextView.setShadowLayer(com.tencent.mm.cb.a.fromDPToPix(paramTextView.getContext(), 4), 0.0F, 0.0F, this.oTD.getResources().getColor(2131099817));
      AppMethodBeat.o(218436);
    }
    
    public final void a(RecyclerView paramRecyclerView, final com.tencent.mm.view.recyclerview.e parame, int paramInt)
    {
      AppMethodBeat.i(218433);
      p.h(paramRecyclerView, "recyclerView");
      p.h(parame, "holder");
      paramRecyclerView = (ViewGroup)parame.GD(2131298309);
      paramRecyclerView.setOnClickListener((View.OnClickListener)new c(this, parame));
      paramRecyclerView.setOnLongClickListener((View.OnLongClickListener)new d(this, parame));
      AppMethodBeat.o(218433);
    }
    
    public final int getLayoutId()
    {
      return 2131493303;
    }
    
    @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run"})
    static final class a
      implements Runnable
    {
      a(CardHomePageV3UI.b paramb, com.tencent.mm.view.recyclerview.e parame, d.g.a.a parama) {}
      
      public final void run()
      {
        AppMethodBeat.i(218425);
        CardHomePageV3UI localCardHomePageV3UI = this.oTE.oTD;
        View localView = this.oTF.auu;
        p.g(localView, "holder.itemView");
        CardHomePageV3UI.a(localCardHomePageV3UI, localView.getHeight());
        this.oTG.invoke();
        AppMethodBeat.o(218425);
      }
    }
    
    @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
    static final class b
      extends q
      implements d.g.a.a<z>
    {
      b(CardHomePageV3UI.b paramb, MemberCardTopCropImageView paramMemberCardTopCropImageView, CardHomePageV3UI.a parama, com.tencent.mm.view.recyclerview.e parame)
      {
        super();
      }
    }
    
    @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class c
      implements View.OnClickListener
    {
      c(CardHomePageV3UI.b paramb, com.tencent.mm.view.recyclerview.e parame) {}
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(218427);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/card/ui/v3/CardHomePageV3UI$CardConverter$onCreateViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
        paramView = (CardHomePageV3UI.a)parame.fUY();
        String str;
        switch (paramView.bZy().Giz)
        {
        default: 
          ae.w(CardHomePageV3UI.a(this.oTE.oTD), "unknown type " + paramView.bZy().Giz);
          localObject = this.oTE.oTD;
          str = paramView.bZy().FKu;
          p.g(str, "cardConvertData.recentlyUsedCell.user_card_id");
          CardHomePageV3UI.a((CardHomePageV3UI)localObject, str);
        }
        for (;;)
        {
          g.yxI.f(19674, new Object[] { Integer.valueOf(1), Integer.valueOf(paramView.bZy().mwj), paramView.bZy().FKu, Long.valueOf(System.currentTimeMillis() / 1000L) });
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/card/ui/v3/CardHomePageV3UI$CardConverter$onCreateViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(218427);
          return;
          com.tencent.mm.plugin.card.d.b.a((MMActivity)this.oTE.oTD.getContext(), paramView.bZy().GiA);
          continue;
          localObject = paramView.bZy().GiB;
          if (localObject != null)
          {
            com.tencent.mm.plugin.card.d.b.I(((ti)localObject).CRv, ((ti)localObject).CRw, ((ti)localObject).DyO);
            continue;
            localObject = this.oTE.oTD;
            str = paramView.bZy().FKu;
            p.g(str, "cardConvertData.recentlyUsedCell.user_card_id");
            CardHomePageV3UI.a((CardHomePageV3UI)localObject, str);
          }
        }
      }
    }
    
    @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onLongClick"})
    static final class d
      implements View.OnLongClickListener
    {
      d(CardHomePageV3UI.b paramb, com.tencent.mm.view.recyclerview.e parame) {}
      
      public final boolean onLongClick(View paramView)
      {
        AppMethodBeat.i(218430);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/card/ui/v3/CardHomePageV3UI$CardConverter$onCreateViewHolder$2", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
        final CardHomePageV3UI.a locala = (CardHomePageV3UI.a)parame.fUY();
        localObject = new com.tencent.mm.ui.widget.b.a((Context)this.oTE.oTD.getContext(), paramView);
        ((com.tencent.mm.ui.widget.b.a)localObject).a((View.OnCreateContextMenuListener)new View.OnCreateContextMenuListener()
        {
          public final void onCreateContextMenu(ContextMenu paramAnonymousContextMenu, View paramAnonymousView, ContextMenu.ContextMenuInfo paramAnonymousContextMenuInfo)
          {
            AppMethodBeat.i(218428);
            paramAnonymousContextMenu.add(0, 1, 0, (CharSequence)this.oTJ.oTE.oTD.getString(2131760291));
            AppMethodBeat.o(218428);
          }
        });
        ((com.tencent.mm.ui.widget.b.a)localObject).a((n.e)new n.e()
        {
          public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
          {
            AppMethodBeat.i(218429);
            paramAnonymousMenuItem = this.oTJ.oTE;
            String str1 = locala.bZy().dJb;
            p.g(str1, "cardConvertData.recentlyUsedCell.card_id");
            String str2 = locala.bZy().FKu;
            p.g(str2, "cardConvertData.recentlyUsedCell.user_card_id");
            com.tencent.mm.ui.widget.a.e locale = new com.tencent.mm.ui.widget.a.e((Context)paramAnonymousMenuItem.oTD.getContext(), 1, true);
            TextView localTextView = new TextView((Context)paramAnonymousMenuItem.oTD.getContext());
            localTextView.setText((CharSequence)paramAnonymousMenuItem.oTD.getString(2131756890));
            localTextView.setTextSize(1, 14.0F);
            localTextView.setTextColor(paramAnonymousMenuItem.oTD.getResources().getColor(2131100482));
            localTextView.setGravity(17);
            paramAnonymousInt = paramAnonymousMenuItem.oTD.getResources().getDimensionPixelSize(2131165303);
            int i = paramAnonymousMenuItem.oTD.getResources().getDimensionPixelSize(2131165289);
            localTextView.setPadding(paramAnonymousInt, i, paramAnonymousInt, i);
            locale.P((View)localTextView, false);
            locale.a((n.d)new CardHomePageV3UI.b.e(paramAnonymousMenuItem));
            locale.a((n.e)new CardHomePageV3UI.b.f(paramAnonymousMenuItem, str1, str2));
            locale.cPF();
            g.yxI.f(19674, new Object[] { Integer.valueOf(2), Integer.valueOf(locala.bZy().mwj), locala.bZy().FKu, Long.valueOf(System.currentTimeMillis() / 1000L) });
            AppMethodBeat.o(218429);
          }
        });
        p.g(paramView, "it");
        paramView = m.dJ(paramView);
        ((com.tencent.mm.ui.widget.b.a)localObject).el(paramView.x, paramView.y);
        com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/card/ui/v3/CardHomePageV3UI$CardConverter$onCreateViewHolder$2", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
        AppMethodBeat.o(218430);
        return false;
      }
    }
    
    @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Lcom/tencent/mm/ui/base/MMMenu;", "kotlin.jvm.PlatformType", "onCreateMMMenu"})
    static final class e
      implements n.d
    {
      e(CardHomePageV3UI.b paramb) {}
      
      public final void onCreateMMMenu(com.tencent.mm.ui.base.l paraml)
      {
        AppMethodBeat.i(218431);
        paraml.a(1, this.oTE.oTD.getResources().getColor(2131100800), (CharSequence)this.oTE.oTD.getString(2131755835));
        AppMethodBeat.o(218431);
      }
    }
    
    @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "menuItem", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "", "onMMMenuItemSelected"})
    static final class f
      implements n.e
    {
      f(CardHomePageV3UI.b paramb, String paramString1, String paramString2) {}
      
      public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
      {
        AppMethodBeat.i(218432);
        p.g(paramMenuItem, "menuItem");
        switch (paramMenuItem.getItemId())
        {
        }
        for (;;)
        {
          AppMethodBeat.o(218432);
          return;
          paramMenuItem = this.oTE.oTD;
          Object localObject = this.oSx;
          String str = this.oTL;
          p.h(localObject, "cardId");
          p.h(str, "userCardId");
          ae.i(paramMenuItem.TAG, "do remove recently: " + (String)localObject + ", " + str);
          localObject = new d((String)localObject, str).aES().aET();
          p.g(localObject, "CgiRemoveCardInRecentlyU…ntCancelAfterDead().run()");
          com.tencent.mm.ac.c.b((com.tencent.mm.vending.g.c)localObject, (d.g.a.b)new CardHomePageV3UI.e(paramMenuItem, str)).b((com.tencent.mm.vending.e.b)paramMenuItem);
        }
      }
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/GetMktCardHomePageV2Response;", "kotlin.jvm.PlatformType", "invoke"})
  static final class d
    extends q
    implements d.g.a.b<com.tencent.mm.ak.a.a<beu>, z>
  {
    d(CardHomePageV3UI paramCardHomePageV3UI, boolean paramBoolean)
    {
      super();
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/RemoveCardInRecentlyUsedListResponse;", "kotlin.jvm.PlatformType", "invoke", "(Lcom/tencent/mm/modelbase/Cgi$CgiBack;)Lkotlin/Unit;"})
  static final class e
    extends q
    implements d.g.a.b<com.tencent.mm.ak.a.a<cuc>, z>
  {
    e(CardHomePageV3UI paramCardHomePageV3UI, String paramString)
    {
      super();
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/card/ui/v3/CardHomePageV3UI$initView$1", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "getItemConvert", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "type", "", "plugin-card_release"})
  public static final class f
    implements com.tencent.mm.view.recyclerview.c
  {
    public final com.tencent.mm.view.recyclerview.b<?> AX(int paramInt)
    {
      AppMethodBeat.i(218439);
      com.tencent.mm.view.recyclerview.b localb = (com.tencent.mm.view.recyclerview.b)new CardHomePageV3UI.b(this.oTD);
      AppMethodBeat.o(218439);
      return localb;
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/card/ui/v3/CardHomePageV3UI$initView$2", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback;", "onLoadMoreBegin", "", "onLoadMoreEnd", "reason", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;", "", "onRefreshBegin", "refreshType", "", "onRefreshEnd", "plugin-card_release"})
  public static final class g
    extends RefreshLoadMoreLayout.a
  {
    public final void AY(int paramInt)
    {
      AppMethodBeat.i(218443);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.mu(paramInt);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/card/ui/v3/CardHomePageV3UI$initView$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshBegin", "(I)V", this, localb.ahF());
      ae.d(CardHomePageV3UI.a(this.oTD), "on begin refresh");
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/card/ui/v3/CardHomePageV3UI$initView$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshBegin", "(I)V");
      AppMethodBeat.o(218443);
    }
    
    public final void a(RefreshLoadMoreLayout.c<Object> paramc)
    {
      AppMethodBeat.i(218442);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bd(paramc);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/card/ui/v3/CardHomePageV3UI$initView$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V", this, localb.ahF());
      p.h(paramc, "reason");
      ae.d(CardHomePageV3UI.a(this.oTD), "on load more end: " + CardHomePageV3UI.d(this.oTD));
      if (CardHomePageV3UI.e(this.oTD)) {
        CardHomePageV3UI.f(this.oTD).k(null);
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/card/ui/v3/CardHomePageV3UI$initView$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V");
      AppMethodBeat.o(218442);
    }
    
    public final void b(RefreshLoadMoreLayout.c<Object> paramc)
    {
      AppMethodBeat.i(218444);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bd(paramc);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/card/ui/v3/CardHomePageV3UI$initView$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V", this, localb.ahF());
      p.h(paramc, "reason");
      ae.d(CardHomePageV3UI.a(this.oTD), "on refresh end");
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/card/ui/v3/CardHomePageV3UI$initView$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V");
      AppMethodBeat.o(218444);
    }
    
    public final void bZA()
    {
      AppMethodBeat.i(218441);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/card/ui/v3/CardHomePageV3UI$initView$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreBegin", "()V", this);
      ae.d(CardHomePageV3UI.a(this.oTD), "on load more");
      com.tencent.mm.ac.c.h((d.g.a.a)new a(this));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/card/ui/v3/CardHomePageV3UI$initView$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreBegin", "()V");
      AppMethodBeat.o(218441);
    }
    
    @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
    static final class a
      extends q
      implements d.g.a.a<z>
    {
      a(CardHomePageV3UI.g paramg)
      {
        super();
      }
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class h
    implements MenuItem.OnMenuItemClickListener
  {
    h(CardHomePageV3UI paramCardHomePageV3UI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(218445);
      this.oTD.finish();
      AppMethodBeat.o(218445);
      return false;
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick", "com/tencent/mm/plugin/card/ui/v3/CardHomePageV3UI$updateFAQ$1$1"})
  static final class i
    implements MenuItem.OnMenuItemClickListener
  {
    i(sz paramsz, CardHomePageV3UI paramCardHomePageV3UI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(218448);
      paramMenuItem = new com.tencent.mm.ui.widget.a.e((Context)jdField_this.getContext(), 1, false);
      paramMenuItem.a((n.d)new n.d()
      {
        public final void onCreateMMMenu(com.tencent.mm.ui.base.l paramAnonymousl)
        {
          AppMethodBeat.i(218446);
          paramAnonymousl.add(0, 0, 1, (CharSequence)this.oTO.oSo.GiX);
          AppMethodBeat.o(218446);
        }
      });
      paramMenuItem.a((n.e)new n.e()
      {
        public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
        {
          AppMethodBeat.i(218447);
          p.g(paramAnonymousMenuItem, "menuItem");
          if (paramAnonymousMenuItem.getItemId() == 0) {
            switch (this.oTO.oSo.GiY)
            {
            }
          }
          for (;;)
          {
            AppMethodBeat.o(218447);
            return;
            com.tencent.mm.plugin.card.d.b.a((MMActivity)this.oTO.oTD.getContext(), this.oTO.oSo.GiZ);
            AppMethodBeat.o(218447);
            return;
            paramAnonymousMenuItem = this.oTO.oSo.Gja;
            com.tencent.mm.plugin.card.d.b.I(paramAnonymousMenuItem.CRv, paramAnonymousMenuItem.CRw, paramAnonymousMenuItem.DyO);
          }
        }
      });
      paramMenuItem.cPF();
      AppMethodBeat.o(218448);
      return false;
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class j
    implements View.OnClickListener
  {
    j(CardHomePageV3UI paramCardHomePageV3UI, td paramtd) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(218449);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/card/ui/v3/CardHomePageV3UI$updateHeader$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
      switch (localtd.Gjh)
      {
      default: 
        ae.w(CardHomePageV3UI.a(this.oTD), "unknown type " + localtd.Gjh);
      }
      for (;;)
      {
        g.yxI.f(19673, new Object[] { localtd.Gjf, Long.valueOf(System.currentTimeMillis() / 1000L) });
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/card/ui/v3/CardHomePageV3UI$updateHeader$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(218449);
        return;
        com.tencent.mm.plugin.card.d.b.a((MMActivity)this.oTD.getContext(), localtd.Gji);
        continue;
        paramView = localtd.Gjj;
        if (paramView != null)
        {
          com.tencent.mm.plugin.card.d.b.I(paramView.CRv, paramView.CRw, paramView.DyO);
          CardHomePageV3UI.k(this.oTD);
          continue;
          if ("weixin://mktcard/cert".equals(localtd.Gjk)) {
            CardHomePageV3UI.l(this.oTD);
          } else if ("weixin://mktcard/membercard".equals(localtd.Gjk)) {
            CardHomePageV3UI.m(this.oTD);
          } else if ("weixin://mktcard/coupon".equals(localtd.Gjk)) {
            CardHomePageV3UI.d(this.oTD, localtd.Gjf);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.v3.CardHomePageV3UI
 * JD-Core Version:    0.7.0.1
 */