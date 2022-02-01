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
import com.tencent.mm.al.c.a;
import com.tencent.mm.kernel.i;
import com.tencent.mm.plugin.card.d.m;
import com.tencent.mm.plugin.card.model.a.a.a;
import com.tencent.mm.plugin.card.model.a.a.a.c;
import com.tencent.mm.plugin.card.model.b.d;
import com.tencent.mm.plugin.card.widget.MemberCardTopCropImageView;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.awi;
import com.tencent.mm.protocal.protobuf.ciy;
import com.tencent.mm.protocal.protobuf.cmf;
import com.tencent.mm.protocal.protobuf.qt;
import com.tencent.mm.protocal.protobuf.qu;
import com.tencent.mm.protocal.protobuf.qv;
import com.tencent.mm.protocal.protobuf.qx;
import com.tencent.mm.protocal.protobuf.qy;
import com.tencent.mm.protocal.protobuf.qz;
import com.tencent.mm.protocal.protobuf.rc;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
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
@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/card/ui/v3/CardHomePageV3UI;", "Lcom/tencent/mm/ui/MMActivity;", "()V", "TAG", "", "loadCount", "", "loadingDialog", "Landroid/app/Dialog;", "mCardDataList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/card/ui/v3/CardHomePageV3UI$CardConvertData;", "Lkotlin/collections/ArrayList;", "mCardHomePageTopCellGroup", "Lcom/tencent/mm/protocal/protobuf/CardHomePageTopCellGroup;", "mFAQItem", "Lcom/tencent/mm/protocal/protobuf/CardHomePageFAQItem;", "mHasLoadedSuccess", "", "mHeaderContainerLayout", "Landroid/view/ViewGroup;", "mHeaderView", "mHomePageEmptyView", "Landroid/view/View;", "mHomePageRecentlyUsedCardTitleTv", "Landroid/widget/TextView;", "mIsAll", "mIsLoading", "mNeedRefreshPage", "mOffset", "mPageAdapter", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "mPageRv", "Lcom/tencent/mm/view/recyclerview/WxRecyclerView;", "mRefreshLayout", "Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "mViewHeight", "doLoadHomePage", "", "refresh", "doRemoveRecentlyCard", "cardId", "userCardId", "getLayoutId", "gotoCardDetailUI", "gotoCertListUI", "gotoCouponCardListUI", "gotoVipCardListUI", "hideLoading", "initView", "loadSnapshot", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onResume", "removeCardByCardId", "saveSnapshot", "showLoading", "updateCardList", "cardList", "Lcom/tencent/mm/protocal/protobuf/CardHomePageRecentlyUsedList;", "updateFAQ", "faqItem", "updateHeader", "topCellGroup", "updateRecentlyUsedCardTitleLayout", "updateRecentlyUsedTitle", "title", "CardConvertData", "CardConverter", "Companion", "plugin-card_release"})
public final class CardHomePageV3UI
  extends MMActivity
{
  private static final int nGA = 3;
  private static final int nGB = 4;
  public static final CardHomePageV3UI.c nGC;
  private static final int nGw = 1;
  private static final int nGx = 2;
  private static final int nGy = 1;
  private static final int nGz = 2;
  private int LZ;
  String TAG;
  private int aNJ;
  private boolean knt;
  private WxRecyclerView nGi;
  private RefreshLoadMoreLayout nGj;
  private ViewGroup nGk;
  private ViewGroup nGl;
  private TextView nGm;
  private View nGn;
  private WxRecyclerAdapter<a> nGo;
  private ArrayList<a> nGp;
  private boolean nGq;
  private boolean nGr;
  private boolean nGs;
  private qy nGt;
  private qt nGu;
  private int nGv;
  
  static
  {
    AppMethodBeat.i(192729);
    nGC = new CardHomePageV3UI.c((byte)0);
    nGw = 1;
    nGx = 2;
    nGy = 1;
    nGz = 2;
    nGA = 3;
    nGB = 4;
    AppMethodBeat.o(192729);
  }
  
  public CardHomePageV3UI()
  {
    AppMethodBeat.i(192728);
    this.TAG = "MicroMsg.CardHomePageV3UI";
    this.nGp = new ArrayList();
    AppMethodBeat.o(192728);
  }
  
  private final void Rb(String paramString)
  {
    AppMethodBeat.i(192726);
    Object localObject = (CharSequence)paramString;
    if ((localObject == null) || (((CharSequence)localObject).length() == 0)) {}
    for (int i = 1;; i = 0)
    {
      if (i == 0)
      {
        localObject = this.nGm;
        if (localObject == null) {
          k.aPZ("mHomePageRecentlyUsedCardTitleTv");
        }
        ((TextView)localObject).setText((CharSequence)paramString);
      }
      AppMethodBeat.o(192726);
      return;
    }
  }
  
  private final void a(qt paramqt)
  {
    AppMethodBeat.i(192723);
    if (paramqt != null)
    {
      this.nGu = paramqt;
      if (!bt.isNullOrNil(paramqt.CQD))
      {
        removeAllOptionMenu();
        addIconOptionMenu(0, 0, 2131690603, (MenuItem.OnMenuItemClickListener)new i(paramqt, this));
      }
      AppMethodBeat.o(192723);
      return;
    }
    AppMethodBeat.o(192723);
  }
  
  private final void a(qv paramqv)
  {
    AppMethodBeat.i(192724);
    if (paramqv != null)
    {
      paramqv = paramqv.CQI.iterator();
      while (paramqv.hasNext())
      {
        qu localqu = (qu)paramqv.next();
        a locala = new a();
        k.g(localqu, "cell");
        locala.a(localqu);
        this.nGp.add(locala);
      }
      paramqv = this.nGo;
      if (paramqv == null) {
        k.aPZ("mPageAdapter");
      }
      paramqv.notifyDataSetChanged();
    }
    bMo();
    AppMethodBeat.o(192724);
  }
  
  private final void a(qy paramqy)
  {
    AppMethodBeat.i(192727);
    ad.i(this.TAG, "do update header");
    if (paramqy == null)
    {
      AppMethodBeat.o(192727);
      return;
    }
    this.nGt = paramqy;
    Object localObject1 = this.nGl;
    if (localObject1 == null) {
      k.aPZ("mHeaderContainerLayout");
    }
    ((ViewGroup)localObject1).removeAllViews();
    int k = getResources().getDimensionPixelSize(2131165303);
    paramqy = paramqy.CQT;
    k.g(paramqy, "topCellGroup.card_home_page_top_cell_list");
    paramqy = ((Iterable)paramqy).iterator();
    while (paramqy.hasNext())
    {
      Object localObject2 = (qz)paramqy.next();
      localObject1 = new LinearLayout((Context)getContext());
      ((LinearLayout)localObject1).setOrientation(1);
      ((LinearLayout)localObject1).setPadding(0, 0, 0, k);
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, -2);
      Object localObject3 = ((qz)localObject2).CQU;
      k.g(localObject3, "group.card_home_page_top_cell");
      localObject3 = ((Iterable)localObject3).iterator();
      int i = 0;
      if (((Iterator)localObject3).hasNext())
      {
        final qx localqx = (qx)((Iterator)localObject3).next();
        View localView = getLayoutInflater().inflate(2131493301, (ViewGroup)localObject1, false);
        Object localObject4 = (ImageView)localView.findViewById(2131298284);
        TextView localTextView1 = (TextView)localView.findViewById(2131298285);
        Object localObject5 = (TextView)localView.findViewById(2131298282);
        TextView localTextView2 = (TextView)localView.findViewById(2131298289);
        ImageView localImageView1 = (ImageView)localView.findViewById(2131298290);
        ImageView localImageView2 = (ImageView)localView.findViewById(2131298291);
        CharSequence localCharSequence = (CharSequence)localqx.CQM;
        int j;
        if ((localCharSequence == null) || (localCharSequence.length() == 0))
        {
          j = 1;
          label326:
          if ((j != 0) || (localqx.CQR != 1)) {
            break label534;
          }
          k.g(localObject5, "descTv");
          ((TextView)localObject5).setText((CharSequence)localqx.CQM);
          k.g(localImageView2, "reddot2Iv");
          localImageView2.setVisibility(0);
          k.g(localImageView1, "reddot1Iv");
          localImageView1.setVisibility(8);
          k.g(localTextView2, "newIv");
          localTextView2.setVisibility(8);
        }
        for (;;)
        {
          localObject5 = localqx.CQK;
          if (localObject5 != null)
          {
            k.g(localObject4, "iconIv");
            m.a((ImageView)localObject4, (String)localObject5, false, 0, 0, 0, 124);
          }
          k.g(localTextView1, "titleTv");
          localTextView1.setText((CharSequence)localqx.CQL);
          if (i == ((qz)localObject2).CQU.size() - 1)
          {
            localObject4 = localView.findViewById(2131298283);
            k.g(localObject4, "cellView.findViewById<Vi…header_cell_divider_view)");
            ((View)localObject4).setVisibility(8);
          }
          localView.setOnClickListener((View.OnClickListener)new j(this, localqx));
          ((LinearLayout)localObject1).addView(localView);
          i += 1;
          break;
          j = 0;
          break label326;
          label534:
          if (localqx.CQS == 1)
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
          else if (localqx.CQR == 1)
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
      localObject2 = this.nGl;
      if (localObject2 == null) {
        k.aPZ("mHeaderContainerLayout");
      }
      ((ViewGroup)localObject2).addView((View)localObject1, (ViewGroup.LayoutParams)localLayoutParams);
    }
    AppMethodBeat.o(192727);
  }
  
  private final void bMo()
  {
    AppMethodBeat.i(192725);
    if (this.nGp.isEmpty())
    {
      localObject = this.nGn;
      if (localObject == null) {
        k.aPZ("mHomePageEmptyView");
      }
      ((View)localObject).setVisibility(0);
      localObject = this.nGm;
      if (localObject == null) {
        k.aPZ("mHomePageRecentlyUsedCardTitleTv");
      }
      ((TextView)localObject).setVisibility(8);
      AppMethodBeat.o(192725);
      return;
    }
    Object localObject = this.nGn;
    if (localObject == null) {
      k.aPZ("mHomePageEmptyView");
    }
    ((View)localObject).setVisibility(8);
    localObject = this.nGm;
    if (localObject == null) {
      k.aPZ("mHomePageRecentlyUsedCardTitleTv");
    }
    ((TextView)localObject).setVisibility(0);
    AppMethodBeat.o(192725);
  }
  
  private final void iJ(final boolean paramBoolean)
  {
    int i = 0;
    AppMethodBeat.i(192722);
    ad.i(this.TAG, "do load home page");
    Object localObject;
    if ((this.nGq) && (!paramBoolean))
    {
      ad.w(this.TAG, "already load complete");
      localObject = this.nGj;
      if (localObject == null) {
        k.aPZ("mRefreshLayout");
      }
      ((RefreshLoadMoreLayout)localObject).abh(0);
      AppMethodBeat.o(192722);
      return;
    }
    if (this.knt)
    {
      ad.w(this.TAG, "is loading");
      AppMethodBeat.o(192722);
      return;
    }
    this.knt = true;
    int j = this.LZ;
    if (paramBoolean)
    {
      localObject = this.nGj;
      if (localObject == null) {
        k.aPZ("mRefreshLayout");
      }
      ((RefreshLoadMoreLayout)localObject).setHasBottomMore(true);
    }
    for (;;)
    {
      localObject = new com.tencent.mm.plugin.card.model.b.c(i).auK();
      k.g(localObject, "CgiGetMktCardHomePageV3(offset, 10).run()");
      com.tencent.mm.ad.c.b((com.tencent.mm.vending.g.c)localObject, (d.g.a.b)new d(this, paramBoolean));
      AppMethodBeat.o(192722);
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
    AppMethodBeat.i(192718);
    Object localObject1 = findViewById(2131298315);
    k.g(localObject1, "findViewById(R.id.chpuv3_rv)");
    this.nGi = ((WxRecyclerView)localObject1);
    localObject1 = findViewById(2131298314);
    k.g(localObject1, "findViewById(R.id.chpuv3_refresh_layout)");
    this.nGj = ((RefreshLoadMoreLayout)localObject1);
    localObject1 = this.nGi;
    if (localObject1 == null) {
      k.aPZ("mPageRv");
    }
    getContext();
    ((WxRecyclerView)localObject1).setLayoutManager((RecyclerView.i)new LinearLayoutManager(1));
    this.nGo = new WxRecyclerAdapter((com.tencent.mm.view.recyclerview.c)new f(this), this.nGp);
    localObject1 = this.nGi;
    if (localObject1 == null) {
      k.aPZ("mPageRv");
    }
    Object localObject2 = this.nGo;
    if (localObject2 == null) {
      k.aPZ("mPageAdapter");
    }
    ((WxRecyclerView)localObject1).setAdapter((RecyclerView.a)localObject2);
    localObject1 = new w((Context)getContext());
    ((w)localObject1).setDrawable(getResources().getDrawable(2131231470));
    localObject2 = this.nGi;
    if (localObject2 == null) {
      k.aPZ("mPageRv");
    }
    ((WxRecyclerView)localObject2).b((RecyclerView.h)localObject1);
    localObject1 = getLayoutInflater();
    localObject2 = this.nGi;
    if (localObject2 == null) {
      k.aPZ("mPageRv");
    }
    localObject1 = ((LayoutInflater)localObject1).inflate(2131493302, (ViewGroup)localObject2, false);
    if (localObject1 == null)
    {
      localObject1 = new v("null cannot be cast to non-null type android.view.ViewGroup");
      AppMethodBeat.o(192718);
      throw ((Throwable)localObject1);
    }
    this.nGk = ((ViewGroup)localObject1);
    localObject1 = this.nGk;
    if (localObject1 == null) {
      k.aPZ("mHeaderView");
    }
    localObject1 = ((ViewGroup)localObject1).findViewById(2131298286);
    k.g(localObject1, "mHeaderView.findViewById…_header_container_layout)");
    this.nGl = ((ViewGroup)localObject1);
    localObject1 = this.nGk;
    if (localObject1 == null) {
      k.aPZ("mHeaderView");
    }
    localObject1 = ((ViewGroup)localObject1).findViewById(2131298288);
    k.g(localObject1, "mHeaderView.findViewById…hphv3_home_page_title_tv)");
    this.nGm = ((TextView)localObject1);
    localObject1 = this.nGk;
    if (localObject1 == null) {
      k.aPZ("mHeaderView");
    }
    localObject1 = ((ViewGroup)localObject1).findViewById(2131298287);
    k.g(localObject1, "mHeaderView.findViewById…3_home_page_empty_layout)");
    this.nGn = ((View)localObject1);
    localObject1 = this.nGo;
    if (localObject1 == null) {
      k.aPZ("mPageAdapter");
    }
    localObject2 = this.nGk;
    if (localObject2 == null) {
      k.aPZ("mHeaderView");
    }
    ((WxRecyclerAdapter)localObject1).f((View)localObject2, nGx, false);
    localObject1 = this.nGj;
    if (localObject1 == null) {
      k.aPZ("mRefreshLayout");
    }
    ((RefreshLoadMoreLayout)localObject1).setEnableRefresh(false);
    localObject1 = this.nGj;
    if (localObject1 == null) {
      k.aPZ("mRefreshLayout");
    }
    int i = com.tencent.mm.cd.a.fromDPToPix((Context)getContext(), 1200);
    localObject2 = aj.getContext();
    k.g(localObject2, "MMApplicationContext.getContext()");
    ((RefreshLoadMoreLayout)localObject1).setLimitTopRequest(i - (int)((Context)localObject2).getResources().getDimension(2131165277));
    localObject1 = this.nGj;
    if (localObject1 == null) {
      k.aPZ("mRefreshLayout");
    }
    localObject2 = aj.getContext();
    k.g(localObject2, "MMApplicationContext.getContext()");
    ((RefreshLoadMoreLayout)localObject1).setRefreshTargetY((int)((Context)localObject2).getResources().getDimension(2131165299) - com.tencent.mm.cd.a.fromDPToPix((Context)getContext(), 1200));
    localObject1 = this.nGj;
    if (localObject1 == null) {
      k.aPZ("mRefreshLayout");
    }
    ((RefreshLoadMoreLayout)localObject1).setDamping(1.85F);
    localObject1 = this.nGj;
    if (localObject1 == null) {
      k.aPZ("mRefreshLayout");
    }
    ((RefreshLoadMoreLayout)localObject1).setActionCallback((RefreshLoadMoreLayout.a)new g(this));
    AppMethodBeat.o(192718);
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(192721);
    if (paramInt1 == nGy) {
      iJ(true);
    }
    for (;;)
    {
      super.onActivityResult(paramInt1, paramInt2, paramIntent);
      AppMethodBeat.o(192721);
      return;
      if (paramInt1 == nGA) {
        iJ(true);
      } else if (paramInt1 == nGz) {
        iJ(true);
      } else if (paramInt1 == nGB) {
        iJ(true);
      }
    }
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(192717);
    super.onCreate(paramBundle);
    initView();
    setMMTitle(2131756891);
    setActionbarColor(getResources().getColor(2131099648));
    hideActionbarLine();
    setBackBtn((MenuItem.OnMenuItemClickListener)new CardHomePageV3UI.h(this));
    paramBundle = com.tencent.mm.plugin.card.model.a.a.nuE;
    paramBundle = a.a.bJm();
    if (paramBundle != null)
    {
      this.LZ = paramBundle.ocT;
      Rb(paramBundle.DvI);
      a(paramBundle.DvG);
      a(paramBundle.DvH);
      a(paramBundle.DvD);
    }
    iJ(true);
    AppMethodBeat.o(192717);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(192720);
    super.onDestroy();
    if (!this.nGr)
    {
      ad.i(this.TAG, "no data to save snapshot");
      AppMethodBeat.o(192720);
      return;
    }
    awi localawi = new awi();
    localawi.BaseResponse = new BaseResponse();
    localawi.BaseResponse.ErrMsg = new cmf();
    localawi.DvG = this.nGt;
    Object localObject = this.nGm;
    if (localObject == null) {
      k.aPZ("mHomePageRecentlyUsedCardTitleTv");
    }
    localawi.DvI = ((TextView)localObject).getText().toString();
    localawi.DvH = new qv();
    localawi.ocT = this.LZ;
    localawi.DvD = this.nGu;
    localObject = this.nGp.iterator();
    while (((Iterator)localObject).hasNext())
    {
      qu localqu = ((a)((Iterator)localObject).next()).bMr();
      if (localqu != null) {
        localawi.DvH.CQI.add(localqu);
      }
    }
    localObject = com.tencent.mm.plugin.card.model.a.a.nuE;
    k.h(localawi, "response");
    ad.d(com.tencent.mm.plugin.card.model.a.a.access$getTAG$cp(), "save home page v3 snapshot");
    com.tencent.mm.ad.c.b(null, (d.g.a.a)new a.a.c(localawi));
    AppMethodBeat.o(192720);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(192719);
    super.onResume();
    if (this.nGs)
    {
      iJ(true);
      this.nGs = false;
    }
    AppMethodBeat.o(192719);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/card/ui/v3/CardHomePageV3UI$CardConvertData;", "Lcom/tencent/mm/view/recyclerview/ConvertData;", "()V", "recentlyUsedCell", "Lcom/tencent/mm/protocal/protobuf/CardHomePageRecentlyUsedCell;", "getRecentlyUsedCell", "()Lcom/tencent/mm/protocal/protobuf/CardHomePageRecentlyUsedCell;", "setRecentlyUsedCell", "(Lcom/tencent/mm/protocal/protobuf/CardHomePageRecentlyUsedCell;)V", "getItemId", "", "getItemType", "", "plugin-card_release"})
  public static final class a
    implements com.tencent.mm.view.recyclerview.a
  {
    public qu nGD;
    
    public final void a(qu paramqu)
    {
      AppMethodBeat.i(192689);
      k.h(paramqu, "<set-?>");
      this.nGD = paramqu;
      AppMethodBeat.o(192689);
    }
    
    public final qu bMr()
    {
      AppMethodBeat.i(192688);
      qu localqu = this.nGD;
      if (localqu == null) {
        k.aPZ("recentlyUsedCell");
      }
      AppMethodBeat.o(192688);
      return localqu;
    }
    
    public final long bMs()
    {
      AppMethodBeat.i(192690);
      qu localqu = this.nGD;
      if (localqu == null) {
        k.aPZ("recentlyUsedCell");
      }
      long l = localqu.dyc.hashCode();
      AppMethodBeat.o(192690);
      return l;
    }
    
    public final int bMt()
    {
      AppMethodBeat.i(192691);
      CardHomePageV3UI.c localc = CardHomePageV3UI.nGC;
      int i = CardHomePageV3UI.bMq();
      AppMethodBeat.o(192691);
      return i;
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/card/ui/v3/CardHomePageV3UI$CardConverter;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "Lcom/tencent/mm/plugin/card/ui/v3/CardHomePageV3UI$CardConvertData;", "(Lcom/tencent/mm/plugin/card/ui/v3/CardHomePageV3UI;)V", "clearShadowLayer", "", "textview", "Landroid/widget/TextView;", "getLayoutId", "", "onBindViewHolder", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "position", "type", "isHotPatch", "", "payloads", "", "", "onCreateViewHolder", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "setShadowLayer", "showDeleteConfirmDialog", "cardId", "", "userCardId", "plugin-card_release"})
  public final class b
    extends com.tencent.mm.view.recyclerview.b<CardHomePageV3UI.a>
  {
    private static void j(TextView paramTextView)
    {
      AppMethodBeat.i(192702);
      paramTextView.setShadowLayer(0.0F, 0.0F, 0.0F, 0);
      AppMethodBeat.o(192702);
    }
    
    private final void k(TextView paramTextView)
    {
      AppMethodBeat.i(192703);
      paramTextView.setShadowLayer(com.tencent.mm.cd.a.fromDPToPix(paramTextView.getContext(), 4), 0.0F, 0.0F, this.nGE.getResources().getColor(2131099817));
      AppMethodBeat.o(192703);
    }
    
    public final void a(RecyclerView paramRecyclerView, final com.tencent.mm.view.recyclerview.e parame, int paramInt)
    {
      AppMethodBeat.i(192700);
      k.h(paramRecyclerView, "recyclerView");
      k.h(parame, "holder");
      paramRecyclerView = (ViewGroup)parame.abq(2131298309);
      paramRecyclerView.setOnClickListener((View.OnClickListener)new c(this, parame));
      paramRecyclerView.setOnLongClickListener((View.OnLongClickListener)new d(this, parame));
      AppMethodBeat.o(192700);
    }
    
    public final int getLayoutId()
    {
      return 2131493303;
    }
    
    @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run"})
    static final class a
      implements Runnable
    {
      a(CardHomePageV3UI.b paramb, com.tencent.mm.view.recyclerview.e parame, d.g.a.a parama) {}
      
      public final void run()
      {
        AppMethodBeat.i(192692);
        CardHomePageV3UI localCardHomePageV3UI = this.nGF.nGE;
        View localView = this.nGG.arI;
        k.g(localView, "holder.itemView");
        CardHomePageV3UI.a(localCardHomePageV3UI, localView.getHeight());
        this.nGH.invoke();
        AppMethodBeat.o(192692);
      }
    }
    
    @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
    static final class b
      extends d.g.b.l
      implements d.g.a.a<y>
    {
      b(CardHomePageV3UI.b paramb, MemberCardTopCropImageView paramMemberCardTopCropImageView, CardHomePageV3UI.a parama, com.tencent.mm.view.recyclerview.e parame)
      {
        super();
      }
    }
    
    @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class c
      implements View.OnClickListener
    {
      c(CardHomePageV3UI.b paramb, com.tencent.mm.view.recyclerview.e parame) {}
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(192694);
        paramView = (CardHomePageV3UI.a)parame.fjf();
        Object localObject;
        String str;
        switch (paramView.bMr().CQf)
        {
        default: 
          ad.w(CardHomePageV3UI.a(this.nGF.nGE), "unknown type " + paramView.bMr().CQf);
          localObject = this.nGF.nGE;
          str = paramView.bMr().CuA;
          k.g(str, "cardConvertData.recentlyUsedCell.user_card_id");
          CardHomePageV3UI.a((CardHomePageV3UI)localObject, str);
        }
        for (;;)
        {
          h.vKh.f(19674, new Object[] { Integer.valueOf(1), Integer.valueOf(paramView.bMr().lpz), paramView.bMr().CuA, Long.valueOf(System.currentTimeMillis() / 1000L) });
          AppMethodBeat.o(192694);
          return;
          com.tencent.mm.plugin.card.d.b.a((MMActivity)this.nGF.nGE.getContext(), paramView.bMr().CQg);
          continue;
          localObject = paramView.bMr().CQh;
          if (localObject != null)
          {
            com.tencent.mm.plugin.card.d.b.G(((rc)localObject).zHs, ((rc)localObject).zHt, ((rc)localObject).Aoy);
            continue;
            localObject = this.nGF.nGE;
            str = paramView.bMr().CuA;
            k.g(str, "cardConvertData.recentlyUsedCell.user_card_id");
            CardHomePageV3UI.a((CardHomePageV3UI)localObject, str);
          }
        }
      }
    }
    
    @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onLongClick"})
    static final class d
      implements View.OnLongClickListener
    {
      d(CardHomePageV3UI.b paramb, com.tencent.mm.view.recyclerview.e parame) {}
      
      public final boolean onLongClick(View paramView)
      {
        AppMethodBeat.i(192697);
        final CardHomePageV3UI.a locala1 = (CardHomePageV3UI.a)parame.fjf();
        com.tencent.mm.ui.widget.b.a locala = new com.tencent.mm.ui.widget.b.a((Context)this.nGF.nGE.getContext(), paramView);
        locala.a((View.OnCreateContextMenuListener)new View.OnCreateContextMenuListener()
        {
          public final void onCreateContextMenu(ContextMenu paramAnonymousContextMenu, View paramAnonymousView, ContextMenu.ContextMenuInfo paramAnonymousContextMenuInfo)
          {
            AppMethodBeat.i(192695);
            paramAnonymousContextMenu.add(0, 1, 0, (CharSequence)this.nGK.nGF.nGE.getString(2131760291));
            AppMethodBeat.o(192695);
          }
        });
        locala.a((n.d)new n.d()
        {
          public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
          {
            AppMethodBeat.i(192696);
            paramAnonymousMenuItem = this.nGK.nGF;
            String str1 = locala1.bMr().dyc;
            k.g(str1, "cardConvertData.recentlyUsedCell.card_id");
            String str2 = locala1.bMr().CuA;
            k.g(str2, "cardConvertData.recentlyUsedCell.user_card_id");
            com.tencent.mm.ui.widget.a.e locale = new com.tencent.mm.ui.widget.a.e((Context)paramAnonymousMenuItem.nGE.getContext(), 1, true);
            TextView localTextView = new TextView((Context)paramAnonymousMenuItem.nGE.getContext());
            localTextView.setText((CharSequence)paramAnonymousMenuItem.nGE.getString(2131756890));
            localTextView.setTextSize(1, 14.0F);
            localTextView.setTextColor(paramAnonymousMenuItem.nGE.getResources().getColor(2131100482));
            localTextView.setGravity(17);
            paramAnonymousInt = paramAnonymousMenuItem.nGE.getResources().getDimensionPixelSize(2131165303);
            int i = paramAnonymousMenuItem.nGE.getResources().getDimensionPixelSize(2131165289);
            localTextView.setPadding(paramAnonymousInt, i, paramAnonymousInt, i);
            locale.J((View)localTextView, false);
            locale.a((n.c)new CardHomePageV3UI.b.e(paramAnonymousMenuItem));
            locale.a((n.d)new CardHomePageV3UI.b.f(paramAnonymousMenuItem, str1, str2));
            locale.csG();
            h.vKh.f(19674, new Object[] { Integer.valueOf(2), Integer.valueOf(locala1.bMr().lpz), locala1.bMr().CuA, Long.valueOf(System.currentTimeMillis() / 1000L) });
            AppMethodBeat.o(192696);
          }
        });
        k.g(paramView, "it");
        paramView = m.dE(paramView);
        locala.eh(paramView.x, paramView.y);
        AppMethodBeat.o(192697);
        return false;
      }
    }
    
    @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Lcom/tencent/mm/ui/base/MMMenu;", "kotlin.jvm.PlatformType", "onCreateMMMenu"})
    static final class e
      implements n.c
    {
      e(CardHomePageV3UI.b paramb) {}
      
      public final void onCreateMMMenu(com.tencent.mm.ui.base.l paraml)
      {
        AppMethodBeat.i(192698);
        paraml.a(1, this.nGF.nGE.getResources().getColor(2131100800), (CharSequence)this.nGF.nGE.getString(2131755835));
        AppMethodBeat.o(192698);
      }
    }
    
    @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "menuItem", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "", "onMMMenuItemSelected"})
    static final class f
      implements n.d
    {
      f(CardHomePageV3UI.b paramb, String paramString1, String paramString2) {}
      
      public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
      {
        AppMethodBeat.i(192699);
        k.g(paramMenuItem, "menuItem");
        switch (paramMenuItem.getItemId())
        {
        }
        for (;;)
        {
          AppMethodBeat.o(192699);
          return;
          paramMenuItem = this.nGF.nGE;
          Object localObject = this.nFA;
          String str = this.nGM;
          k.h(localObject, "cardId");
          k.h(str, "userCardId");
          ad.i(paramMenuItem.TAG, "do remove recently: " + (String)localObject + ", " + str);
          localObject = new d((String)localObject, str).auK();
          k.g(localObject, "CgiRemoveCardInRecentlyU…cardId, userCardId).run()");
          com.tencent.mm.ad.c.b((com.tencent.mm.vending.g.c)localObject, (d.g.a.b)new CardHomePageV3UI.e(paramMenuItem, str)).b((com.tencent.mm.vending.e.b)paramMenuItem);
        }
      }
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Lcom/tencent/mm/modelbase/DeprecatedCgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/GetMktCardHomePageV2Response;", "kotlin.jvm.PlatformType", "invoke"})
  static final class d
    extends d.g.b.l
    implements d.g.a.b<c.a<awi>, y>
  {
    d(CardHomePageV3UI paramCardHomePageV3UI, boolean paramBoolean)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Lcom/tencent/mm/modelbase/DeprecatedCgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/RemoveCardInRecentlyUsedListResponse;", "kotlin.jvm.PlatformType", "invoke", "(Lcom/tencent/mm/modelbase/DeprecatedCgi$CgiBack;)Lkotlin/Unit;"})
  static final class e
    extends d.g.b.l
    implements d.g.a.b<c.a<ciy>, y>
  {
    e(CardHomePageV3UI paramCardHomePageV3UI, String paramString)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/card/ui/v3/CardHomePageV3UI$initView$1", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "getItemConvert", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "type", "", "plugin-card_release"})
  public static final class f
    implements com.tencent.mm.view.recyclerview.c
  {
    public final com.tencent.mm.view.recyclerview.b<?> zm(int paramInt)
    {
      AppMethodBeat.i(192706);
      com.tencent.mm.view.recyclerview.b localb = (com.tencent.mm.view.recyclerview.b)new CardHomePageV3UI.b(this.nGE);
      AppMethodBeat.o(192706);
      return localb;
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/card/ui/v3/CardHomePageV3UI$initView$2", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback;", "onLoadMoreBegin", "", "onLoadMoreEnd", "reason", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;", "", "onRefreshBegin", "refreshType", "", "onRefreshEnd", "plugin-card_release"})
  public static final class g
    extends RefreshLoadMoreLayout.a
  {
    public final void a(RefreshLoadMoreLayout.c<Object> paramc)
    {
      AppMethodBeat.i(192709);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.be(paramc);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/card/ui/v3/CardHomePageV3UI$initView$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V", this, localb.ado());
      k.h(paramc, "reason");
      ad.d(CardHomePageV3UI.a(this.nGE), "on load more end: " + CardHomePageV3UI.d(this.nGE));
      if (CardHomePageV3UI.e(this.nGE)) {
        CardHomePageV3UI.f(this.nGE).g(null);
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/card/ui/v3/CardHomePageV3UI$initView$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V");
      AppMethodBeat.o(192709);
    }
    
    public final void agP(int paramInt)
    {
      AppMethodBeat.i(205461);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.lT(paramInt);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/card/ui/v3/CardHomePageV3UI$initView$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshBegin", "(I)V", this, localb.ado());
      ad.d(CardHomePageV3UI.a(this.nGE), "on begin refresh");
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/card/ui/v3/CardHomePageV3UI$initView$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshBegin", "(I)V");
      AppMethodBeat.o(205461);
    }
    
    public final void b(RefreshLoadMoreLayout.c<Object> paramc)
    {
      AppMethodBeat.i(192711);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.be(paramc);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/card/ui/v3/CardHomePageV3UI$initView$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V", this, localb.ado());
      k.h(paramc, "reason");
      ad.d(CardHomePageV3UI.a(this.nGE), "on refresh end");
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/card/ui/v3/CardHomePageV3UI$initView$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V");
      AppMethodBeat.o(192711);
    }
    
    public final void bMu()
    {
      AppMethodBeat.i(192708);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/card/ui/v3/CardHomePageV3UI$initView$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreBegin", "()V", this);
      ad.d(CardHomePageV3UI.a(this.nGE), "on load more");
      com.tencent.mm.ad.c.g((d.g.a.a)new a(this));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/card/ui/v3/CardHomePageV3UI$initView$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreBegin", "()V");
      AppMethodBeat.o(192708);
    }
    
    @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
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
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick", "com/tencent/mm/plugin/card/ui/v3/CardHomePageV3UI$updateFAQ$1$1"})
  static final class i
    implements MenuItem.OnMenuItemClickListener
  {
    i(qt paramqt, CardHomePageV3UI paramCardHomePageV3UI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(192715);
      paramMenuItem = new com.tencent.mm.ui.widget.a.e((Context)jdField_this.getContext(), 1, false);
      paramMenuItem.a((n.c)new n.c()
      {
        public final void onCreateMMMenu(com.tencent.mm.ui.base.l paramAnonymousl)
        {
          AppMethodBeat.i(192713);
          paramAnonymousl.add(0, 0, 1, (CharSequence)this.nGP.nFr.CQD);
          AppMethodBeat.o(192713);
        }
      });
      paramMenuItem.a((n.d)new n.d()
      {
        public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
        {
          AppMethodBeat.i(192714);
          k.g(paramAnonymousMenuItem, "menuItem");
          if (paramAnonymousMenuItem.getItemId() == 0) {
            switch (this.nGP.nFr.CQE)
            {
            }
          }
          for (;;)
          {
            AppMethodBeat.o(192714);
            return;
            com.tencent.mm.plugin.card.d.b.a((MMActivity)this.nGP.nGE.getContext(), this.nGP.nFr.CQF);
            AppMethodBeat.o(192714);
            return;
            paramAnonymousMenuItem = this.nGP.nFr.CQG;
            com.tencent.mm.plugin.card.d.b.G(paramAnonymousMenuItem.zHs, paramAnonymousMenuItem.zHt, paramAnonymousMenuItem.Aoy);
          }
        }
      });
      paramMenuItem.csG();
      AppMethodBeat.o(192715);
      return false;
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class j
    implements View.OnClickListener
  {
    j(CardHomePageV3UI paramCardHomePageV3UI, qx paramqx) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(192716);
      switch (localqx.CQN)
      {
      default: 
        ad.w(CardHomePageV3UI.a(this.nGE), "unknown type " + localqx.CQN);
      }
      for (;;)
      {
        h.vKh.f(19673, new Object[] { localqx.CQL, Long.valueOf(System.currentTimeMillis() / 1000L) });
        AppMethodBeat.o(192716);
        return;
        com.tencent.mm.plugin.card.d.b.a((MMActivity)this.nGE.getContext(), localqx.CQO);
        continue;
        paramView = localqx.CQP;
        if (paramView != null)
        {
          com.tencent.mm.plugin.card.d.b.G(paramView.zHs, paramView.zHt, paramView.Aoy);
          CardHomePageV3UI.k(this.nGE);
          continue;
          if ("weixin://mktcard/cert".equals(localqx.CQQ)) {
            CardHomePageV3UI.l(this.nGE);
          } else if ("weixin://mktcard/membercard".equals(localqx.CQQ)) {
            CardHomePageV3UI.m(this.nGE);
          } else if ("weixin://mktcard/coupon".equals(localqx.CQQ)) {
            CardHomePageV3UI.n(this.nGE);
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