package com.tencent.mm.plugin.card.ui.v3;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Point;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.h;
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
import com.tencent.mm.plugin.card.model.a.a.a;
import com.tencent.mm.plugin.card.model.a.a.a.e;
import com.tencent.mm.plugin.card.widget.MemberCardTopCropImageView;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.bqq;
import com.tencent.mm.protocal.protobuf.dmt;
import com.tencent.mm.protocal.protobuf.dqi;
import com.tencent.mm.protocal.protobuf.ue;
import com.tencent.mm.protocal.protobuf.uf;
import com.tencent.mm.protocal.protobuf.ug;
import com.tencent.mm.protocal.protobuf.ui;
import com.tencent.mm.protocal.protobuf.uj;
import com.tencent.mm.protocal.protobuf.uk;
import com.tencent.mm.protocal.protobuf.un;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.o.f;
import com.tencent.mm.ui.base.o.g;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.RefreshLoadMoreLayout.a;
import com.tencent.mm.view.RefreshLoadMoreLayout.c;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.mm.view.recyclerview.WxRecyclerView;
import com.tencent.mm.view.recyclerview.f;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@i
@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/card/ui/v3/CardHomePageV3UI;", "Lcom/tencent/mm/ui/MMActivity;", "()V", "TAG", "", "loadCount", "", "loadingDialog", "Landroid/app/Dialog;", "mCardDataList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/card/ui/v3/CardHomePageV3UI$CardConvertData;", "Lkotlin/collections/ArrayList;", "mCardHomePageTopCellGroup", "Lcom/tencent/mm/protocal/protobuf/CardHomePageTopCellGroup;", "mFAQItem", "Lcom/tencent/mm/protocal/protobuf/CardHomePageFAQItem;", "mHasLoadedSuccess", "", "mHeaderContainerLayout", "Landroid/view/ViewGroup;", "mHeaderView", "mHomePageEmptyView", "Landroid/view/View;", "mHomePageRecentlyUsedCardTitleTv", "Landroid/widget/TextView;", "mIsAll", "mIsLoading", "mNeedRefreshPage", "mOffset", "mPageAdapter", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "mPageRv", "Lcom/tencent/mm/view/recyclerview/WxRecyclerView;", "mRefreshLayout", "Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "mViewHeight", "mViewWidth", "doLoadHomePage", "", "refresh", "doRemoveRecentlyCard", "cardId", "userCardId", "getLayoutId", "gotoCardDetailUI", "gotoCertListUI", "gotoCouponCardListUI", "title", "gotoCouponGiftCardListUI", "gotoVipCardListUI", "hideLoading", "initView", "loadSnapshot", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onResume", "removeCardByCardId", "saveSnapshot", "showLoading", "updateCardList", "cardList", "Lcom/tencent/mm/protocal/protobuf/CardHomePageRecentlyUsedList;", "updateFAQ", "faqItem", "updateHeader", "topCellGroup", "updateRecentlyUsedCardTitleLayout", "updateRecentlyUsedTitle", "CardConvertData", "CardConverter", "Companion", "plugin-card_release"})
public final class CardHomePageV3UI
  extends MMActivity
{
  public static final CardHomePageV3UI.c qhl;
  String TAG;
  private int aYN;
  private int aYO;
  private int fs;
  private boolean mwr;
  private WxRecyclerView qgX;
  private RefreshLoadMoreLayout qgY;
  private ViewGroup qgZ;
  private ViewGroup qha;
  private TextView qhb;
  private View qhc;
  private WxRecyclerAdapter<a> qhd;
  private ArrayList<a> qhe;
  private boolean qhf;
  private boolean qhg;
  private boolean qhh;
  private uj qhi;
  private ue qhj;
  private int qhk;
  
  static
  {
    AppMethodBeat.i(201468);
    qhl = new CardHomePageV3UI.c((byte)0);
    AppMethodBeat.o(201468);
  }
  
  public CardHomePageV3UI()
  {
    AppMethodBeat.i(201467);
    this.TAG = "MicroMsg.CardHomePageV3UI";
    this.qhe = new ArrayList();
    AppMethodBeat.o(201467);
  }
  
  private final void a(ue paramue)
  {
    AppMethodBeat.i(201462);
    if (paramue != null)
    {
      this.qhj = paramue;
      if (!Util.isNullOrNil(paramue.LdB))
      {
        removeAllOptionMenu();
        addIconOptionMenu(0, 0, 2131690843, (MenuItem.OnMenuItemClickListener)new i(paramue, this));
      }
      AppMethodBeat.o(201462);
      return;
    }
    AppMethodBeat.o(201462);
  }
  
  private final void a(ug paramug)
  {
    AppMethodBeat.i(201463);
    if (paramug != null)
    {
      paramug = paramug.LdH.iterator();
      while (paramug.hasNext())
      {
        uf localuf = (uf)paramug.next();
        a locala = new a();
        p.g(localuf, "cell");
        locala.a(localuf);
        this.qhe.add(locala);
      }
      paramug = this.qhd;
      if (paramug == null) {
        p.btv("mPageAdapter");
      }
      paramug.notifyDataSetChanged();
    }
    cxk();
    AppMethodBeat.o(201463);
  }
  
  private final void a(uj paramuj)
  {
    AppMethodBeat.i(201466);
    Log.i(this.TAG, "do update header");
    if (paramuj == null)
    {
      AppMethodBeat.o(201466);
      return;
    }
    this.qhi = paramuj;
    Object localObject1 = this.qha;
    if (localObject1 == null) {
      p.btv("mHeaderContainerLayout");
    }
    ((ViewGroup)localObject1).removeAllViews();
    int k = getResources().getDimensionPixelSize(2131165314);
    paramuj = paramuj.LdS;
    p.g(paramuj, "topCellGroup.card_home_page_top_cell_list");
    paramuj = ((Iterable)paramuj).iterator();
    while (paramuj.hasNext())
    {
      Object localObject2 = (uk)paramuj.next();
      localObject1 = new LinearLayout((Context)getContext());
      ((LinearLayout)localObject1).setOrientation(1);
      ((LinearLayout)localObject1).setPadding(0, 0, 0, k);
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, -2);
      Object localObject3 = ((uk)localObject2).LdT;
      p.g(localObject3, "group.card_home_page_top_cell");
      localObject3 = ((Iterable)localObject3).iterator();
      int i = 0;
      if (((Iterator)localObject3).hasNext())
      {
        final ui localui = (ui)((Iterator)localObject3).next();
        View localView = getLayoutInflater().inflate(2131493391, (ViewGroup)localObject1, false);
        Object localObject4 = (ImageView)localView.findViewById(2131298675);
        TextView localTextView1 = (TextView)localView.findViewById(2131298676);
        Object localObject5 = (TextView)localView.findViewById(2131298673);
        TextView localTextView2 = (TextView)localView.findViewById(2131298680);
        ImageView localImageView1 = (ImageView)localView.findViewById(2131298681);
        ImageView localImageView2 = (ImageView)localView.findViewById(2131298682);
        CharSequence localCharSequence = (CharSequence)localui.LdL;
        int j;
        if ((localCharSequence == null) || (localCharSequence.length() == 0))
        {
          j = 1;
          label326:
          if ((j != 0) || (localui.LdQ != 1)) {
            break label534;
          }
          p.g(localObject5, "descTv");
          ((TextView)localObject5).setText((CharSequence)localui.LdL);
          p.g(localImageView2, "reddot2Iv");
          localImageView2.setVisibility(0);
          p.g(localImageView1, "reddot1Iv");
          localImageView1.setVisibility(8);
          p.g(localTextView2, "newIv");
          localTextView2.setVisibility(8);
        }
        for (;;)
        {
          localObject5 = localui.LdJ;
          if (localObject5 != null)
          {
            p.g(localObject4, "iconIv");
            com.tencent.mm.plugin.card.d.m.a((ImageView)localObject4, (String)localObject5, false, 0, 0, 0, 124);
          }
          p.g(localTextView1, "titleTv");
          localTextView1.setText((CharSequence)localui.LdK);
          if (i == ((uk)localObject2).LdT.size() - 1)
          {
            localObject4 = localView.findViewById(2131298674);
            p.g(localObject4, "cellView.findViewById<Vi…header_cell_divider_view)");
            ((View)localObject4).setVisibility(8);
          }
          localView.setOnClickListener((View.OnClickListener)new j(this, localui));
          ((LinearLayout)localObject1).addView(localView);
          i += 1;
          break;
          j = 0;
          break label326;
          label534:
          if (localui.LdR == 1)
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
          else if (localui.LdQ == 1)
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
      localObject2 = this.qha;
      if (localObject2 == null) {
        p.btv("mHeaderContainerLayout");
      }
      ((ViewGroup)localObject2).addView((View)localObject1, (ViewGroup.LayoutParams)localLayoutParams);
    }
    AppMethodBeat.o(201466);
  }
  
  private final void ajS(String paramString)
  {
    AppMethodBeat.i(201465);
    Object localObject = (CharSequence)paramString;
    if ((localObject == null) || (((CharSequence)localObject).length() == 0)) {}
    for (int i = 1;; i = 0)
    {
      if (i == 0)
      {
        localObject = this.qhb;
        if (localObject == null) {
          p.btv("mHomePageRecentlyUsedCardTitleTv");
        }
        ((TextView)localObject).setText((CharSequence)paramString);
      }
      AppMethodBeat.o(201465);
      return;
    }
  }
  
  private final void cxk()
  {
    AppMethodBeat.i(201464);
    if (this.qhe.isEmpty())
    {
      localObject = this.qhc;
      if (localObject == null) {
        p.btv("mHomePageEmptyView");
      }
      ((View)localObject).setVisibility(0);
      localObject = this.qhb;
      if (localObject == null) {
        p.btv("mHomePageRecentlyUsedCardTitleTv");
      }
      ((TextView)localObject).setVisibility(8);
      AppMethodBeat.o(201464);
      return;
    }
    Object localObject = this.qhc;
    if (localObject == null) {
      p.btv("mHomePageEmptyView");
    }
    ((View)localObject).setVisibility(8);
    localObject = this.qhb;
    if (localObject == null) {
      p.btv("mHomePageRecentlyUsedCardTitleTv");
    }
    ((TextView)localObject).setVisibility(0);
    AppMethodBeat.o(201464);
  }
  
  private final void kz(final boolean paramBoolean)
  {
    int i = 0;
    AppMethodBeat.i(201461);
    Log.i(this.TAG, "do load home page");
    Object localObject;
    if ((this.qhf) && (!paramBoolean))
    {
      Log.w(this.TAG, "already load complete");
      localObject = this.qgY;
      if (localObject == null) {
        p.btv("mRefreshLayout");
      }
      ((RefreshLoadMoreLayout)localObject).apT(0);
      AppMethodBeat.o(201461);
      return;
    }
    if (this.mwr)
    {
      Log.w(this.TAG, "is loading");
      AppMethodBeat.o(201461);
      return;
    }
    this.mwr = true;
    int j = this.fs;
    if (paramBoolean)
    {
      localObject = this.qgY;
      if (localObject == null) {
        p.btv("mRefreshLayout");
      }
      ((RefreshLoadMoreLayout)localObject).setHasBottomMore(true);
    }
    for (;;)
    {
      localObject = new com.tencent.mm.plugin.card.model.b.c(i).aYI();
      p.g(localObject, "CgiGetMktCardHomePageV3(offset, 10).run()");
      com.tencent.mm.ac.d.b((com.tencent.mm.vending.g.c)localObject, (kotlin.g.a.b)new d(this, paramBoolean));
      AppMethodBeat.o(201461);
      return;
      i = j;
    }
  }
  
  public final int getLayoutId()
  {
    return 2131493394;
  }
  
  public final void initView()
  {
    AppMethodBeat.i(201457);
    Object localObject1 = findViewById(2131298707);
    p.g(localObject1, "findViewById(R.id.chpuv3_rv)");
    this.qgX = ((WxRecyclerView)localObject1);
    localObject1 = findViewById(2131298706);
    p.g(localObject1, "findViewById(R.id.chpuv3_refresh_layout)");
    this.qgY = ((RefreshLoadMoreLayout)localObject1);
    localObject1 = this.qgX;
    if (localObject1 == null) {
      p.btv("mPageRv");
    }
    getContext();
    ((WxRecyclerView)localObject1).setLayoutManager((RecyclerView.LayoutManager)new LinearLayoutManager(1, false));
    this.qhd = new WxRecyclerAdapter((f)new f(this), this.qhe);
    localObject1 = this.qhd;
    if (localObject1 == null) {
      p.btv("mPageAdapter");
    }
    ((WxRecyclerAdapter)localObject1).au(true);
    localObject1 = this.qgX;
    if (localObject1 == null) {
      p.btv("mPageRv");
    }
    Object localObject2 = this.qhd;
    if (localObject2 == null) {
      p.btv("mPageAdapter");
    }
    ((WxRecyclerView)localObject1).setAdapter((RecyclerView.a)localObject2);
    localObject1 = new w((Context)getContext(), 1);
    ((w)localObject1).setDrawable(getResources().getDrawable(2131231535));
    localObject2 = this.qgX;
    if (localObject2 == null) {
      p.btv("mPageRv");
    }
    ((WxRecyclerView)localObject2).b((RecyclerView.h)localObject1);
    localObject1 = getLayoutInflater();
    localObject2 = this.qgX;
    if (localObject2 == null) {
      p.btv("mPageRv");
    }
    localObject1 = ((LayoutInflater)localObject1).inflate(2131493392, (ViewGroup)localObject2, false);
    if (localObject1 == null)
    {
      localObject1 = new t("null cannot be cast to non-null type android.view.ViewGroup");
      AppMethodBeat.o(201457);
      throw ((Throwable)localObject1);
    }
    this.qgZ = ((ViewGroup)localObject1);
    localObject1 = this.qgZ;
    if (localObject1 == null) {
      p.btv("mHeaderView");
    }
    localObject1 = ((ViewGroup)localObject1).findViewById(2131298677);
    p.g(localObject1, "mHeaderView.findViewById…_header_container_layout)");
    this.qha = ((ViewGroup)localObject1);
    localObject1 = this.qgZ;
    if (localObject1 == null) {
      p.btv("mHeaderView");
    }
    localObject1 = ((ViewGroup)localObject1).findViewById(2131298679);
    p.g(localObject1, "mHeaderView.findViewById…hphv3_home_page_title_tv)");
    this.qhb = ((TextView)localObject1);
    localObject1 = this.qgZ;
    if (localObject1 == null) {
      p.btv("mHeaderView");
    }
    localObject1 = ((ViewGroup)localObject1).findViewById(2131298678);
    p.g(localObject1, "mHeaderView.findViewById…3_home_page_empty_layout)");
    this.qhc = ((View)localObject1);
    localObject1 = this.qhd;
    if (localObject1 == null) {
      p.btv("mPageAdapter");
    }
    localObject2 = this.qgZ;
    if (localObject2 == null) {
      p.btv("mHeaderView");
    }
    ((WxRecyclerAdapter)localObject1).f((View)localObject2, 2, false);
    localObject1 = this.qgY;
    if (localObject1 == null) {
      p.btv("mRefreshLayout");
    }
    ((RefreshLoadMoreLayout)localObject1).setEnableRefresh(false);
    localObject1 = this.qgY;
    if (localObject1 == null) {
      p.btv("mRefreshLayout");
    }
    int i = com.tencent.mm.cb.a.fromDPToPix((Context)getContext(), 1200);
    localObject2 = MMApplicationContext.getContext();
    p.g(localObject2, "MMApplicationContext.getContext()");
    ((RefreshLoadMoreLayout)localObject1).setLimitTopRequest(i - (int)((Context)localObject2).getResources().getDimension(2131165281));
    localObject1 = this.qgY;
    if (localObject1 == null) {
      p.btv("mRefreshLayout");
    }
    localObject2 = MMApplicationContext.getContext();
    p.g(localObject2, "MMApplicationContext.getContext()");
    ((RefreshLoadMoreLayout)localObject1).setRefreshTargetY((int)((Context)localObject2).getResources().getDimension(2131165310) - com.tencent.mm.cb.a.fromDPToPix((Context)getContext(), 1200));
    localObject1 = this.qgY;
    if (localObject1 == null) {
      p.btv("mRefreshLayout");
    }
    ((RefreshLoadMoreLayout)localObject1).setDamping(1.85F);
    localObject1 = this.qgY;
    if (localObject1 == null) {
      p.btv("mRefreshLayout");
    }
    ((RefreshLoadMoreLayout)localObject1).setActionCallback((RefreshLoadMoreLayout.a)new g(this));
    AppMethodBeat.o(201457);
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(201460);
    switch (paramInt1)
    {
    }
    for (;;)
    {
      super.onActivityResult(paramInt1, paramInt2, paramIntent);
      AppMethodBeat.o(201460);
      return;
      kz(true);
      continue;
      kz(true);
      continue;
      kz(true);
      continue;
      kz(true);
    }
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(201456);
    super.onCreate(paramBundle);
    initView();
    setMMTitle(2131757061);
    setActionbarColor(getResources().getColor(2131099648));
    hideActionbarLine();
    setBackBtn((MenuItem.OnMenuItemClickListener)new h(this));
    paramBundle = com.tencent.mm.plugin.card.model.a.a.pVg;
    paramBundle = a.a.cuh();
    if (paramBundle != null)
    {
      this.fs = paramBundle.qGg;
      ajS(paramBundle.LYm);
      a(paramBundle.LYk);
      a(paramBundle.LYl);
      a(paramBundle.LYh);
    }
    kz(true);
    AppMethodBeat.o(201456);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(201459);
    super.onDestroy();
    if (!this.qhg)
    {
      Log.i(this.TAG, "no data to save snapshot");
      AppMethodBeat.o(201459);
      return;
    }
    bqq localbqq = new bqq();
    localbqq.BaseResponse = new BaseResponse();
    localbqq.BaseResponse.ErrMsg = new dqi();
    localbqq.LYk = this.qhi;
    Object localObject = this.qhb;
    if (localObject == null) {
      p.btv("mHomePageRecentlyUsedCardTitleTv");
    }
    localbqq.LYm = ((TextView)localObject).getText().toString();
    localbqq.LYl = new ug();
    localbqq.qGg = this.fs;
    localbqq.LYh = this.qhj;
    localObject = this.qhe.iterator();
    while (((Iterator)localObject).hasNext())
    {
      uf localuf = ((a)((Iterator)localObject).next()).cxm();
      if (localuf != null) {
        localbqq.LYl.LdH.add(localuf);
      }
    }
    localObject = com.tencent.mm.plugin.card.model.a.a.pVg;
    p.h(localbqq, "response");
    Log.d(com.tencent.mm.plugin.card.model.a.a.access$getTAG$cp(), "save home page v3 snapshot");
    com.tencent.mm.ac.d.i((kotlin.g.a.a)new a.a.e(localbqq));
    AppMethodBeat.o(201459);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(201458);
    super.onResume();
    if (this.qhh)
    {
      kz(true);
      this.qhh = false;
    }
    AppMethodBeat.o(201458);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/card/ui/v3/CardHomePageV3UI$CardConvertData;", "Lcom/tencent/mm/view/recyclerview/ConvertData;", "()V", "recentlyUsedCell", "Lcom/tencent/mm/protocal/protobuf/CardHomePageRecentlyUsedCell;", "getRecentlyUsedCell", "()Lcom/tencent/mm/protocal/protobuf/CardHomePageRecentlyUsedCell;", "setRecentlyUsedCell", "(Lcom/tencent/mm/protocal/protobuf/CardHomePageRecentlyUsedCell;)V", "getItemId", "", "getItemType", "", "plugin-card_release"})
  public static final class a
    implements com.tencent.mm.view.recyclerview.a
  {
    public uf qhm;
    
    public final void a(uf paramuf)
    {
      AppMethodBeat.i(201429);
      p.h(paramuf, "<set-?>");
      this.qhm = paramuf;
      AppMethodBeat.o(201429);
    }
    
    public final uf cxm()
    {
      AppMethodBeat.i(201428);
      uf localuf = this.qhm;
      if (localuf == null) {
        p.btv("recentlyUsedCell");
      }
      AppMethodBeat.o(201428);
      return localuf;
    }
    
    public final int cxn()
    {
      return 1;
    }
    
    public final long lT()
    {
      AppMethodBeat.i(201430);
      uf localuf = this.qhm;
      if (localuf == null) {
        p.btv("recentlyUsedCell");
      }
      long l = localuf.eaO.hashCode();
      AppMethodBeat.o(201430);
      return l;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/card/ui/v3/CardHomePageV3UI$CardConverter;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "Lcom/tencent/mm/plugin/card/ui/v3/CardHomePageV3UI$CardConvertData;", "(Lcom/tencent/mm/plugin/card/ui/v3/CardHomePageV3UI;)V", "clearShadowLayer", "", "textview", "Landroid/widget/TextView;", "getLayoutId", "", "onBindViewHolder", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "position", "type", "isHotPatch", "", "payloads", "", "", "onCreateViewHolder", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "setShadowLayer", "showDeleteConfirmDialog", "cardId", "", "userCardId", "plugin-card_release"})
  public final class b
    extends com.tencent.mm.view.recyclerview.e<CardHomePageV3UI.a>
  {
    private static void j(TextView paramTextView)
    {
      AppMethodBeat.i(201441);
      paramTextView.setShadowLayer(0.0F, 0.0F, 0.0F, 0);
      AppMethodBeat.o(201441);
    }
    
    private final void k(TextView paramTextView)
    {
      AppMethodBeat.i(201442);
      paramTextView.setShadowLayer(com.tencent.mm.cb.a.fromDPToPix(paramTextView.getContext(), 4), 0.0F, 0.0F, this.qhn.getResources().getColor(2131099833));
      AppMethodBeat.o(201442);
    }
    
    public final void a(RecyclerView paramRecyclerView, final com.tencent.mm.view.recyclerview.h paramh, int paramInt)
    {
      AppMethodBeat.i(201439);
      p.h(paramRecyclerView, "recyclerView");
      p.h(paramh, "holder");
      paramRecyclerView = (ViewGroup)paramh.Mn(2131298701);
      paramRecyclerView.setOnClickListener((View.OnClickListener)new c(this, paramh));
      paramRecyclerView.setOnLongClickListener((View.OnLongClickListener)new d(this, paramh));
      AppMethodBeat.o(201439);
    }
    
    public final int getLayoutId()
    {
      return 2131493393;
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
    static final class a
      implements Runnable
    {
      a(CardHomePageV3UI.b paramb, com.tencent.mm.view.recyclerview.h paramh, kotlin.g.a.a parama) {}
      
      public final void run()
      {
        AppMethodBeat.i(201431);
        CardHomePageV3UI localCardHomePageV3UI = this.qho.qhn;
        View localView = this.qhp.aus;
        p.g(localView, "holder.itemView");
        CardHomePageV3UI.a(localCardHomePageV3UI, localView.getHeight());
        localCardHomePageV3UI = this.qho.qhn;
        localView = this.qhp.aus;
        p.g(localView, "holder.itemView");
        CardHomePageV3UI.b(localCardHomePageV3UI, localView.getWidth());
        this.qgW.invoke();
        AppMethodBeat.o(201431);
      }
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
    static final class b
      extends q
      implements kotlin.g.a.a<x>
    {
      b(CardHomePageV3UI.b paramb, com.tencent.mm.view.recyclerview.h paramh, MemberCardTopCropImageView paramMemberCardTopCropImageView, CardHomePageV3UI.a parama)
      {
        super();
      }
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class c
      implements View.OnClickListener
    {
      c(CardHomePageV3UI.b paramb, com.tencent.mm.view.recyclerview.h paramh) {}
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(201433);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/card/ui/v3/CardHomePageV3UI$CardConverter$onCreateViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
        paramView = (CardHomePageV3UI.a)paramh.hgv();
        String str;
        switch (paramView.cxm().Ldc)
        {
        default: 
          Log.w(CardHomePageV3UI.a(this.qho.qhn), "unknown type " + paramView.cxm().Ldc);
          localObject = this.qho.qhn;
          str = paramView.cxm().KDM;
          p.g(str, "cardConvertData.recentlyUsedCell.user_card_id");
          CardHomePageV3UI.a((CardHomePageV3UI)localObject, str);
        }
        for (;;)
        {
          com.tencent.mm.plugin.report.service.h.CyF.a(19674, new Object[] { Integer.valueOf(1), Integer.valueOf(paramView.cxm().nHh), paramView.cxm().KDM, Long.valueOf(System.currentTimeMillis() / 1000L) });
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/card/ui/v3/CardHomePageV3UI$CardConverter$onCreateViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(201433);
          return;
          com.tencent.mm.plugin.card.d.b.a((MMActivity)this.qho.qhn.getContext(), paramView.cxm().Ldd);
          continue;
          localObject = paramView.cxm().Lde;
          if (localObject != null)
          {
            com.tencent.mm.plugin.card.d.b.H(((un)localObject).Hwr, ((un)localObject).Hws, ((un)localObject).IhZ);
            continue;
            localObject = this.qho.qhn;
            str = paramView.cxm().KDM;
            p.g(str, "cardConvertData.recentlyUsedCell.user_card_id");
            CardHomePageV3UI.a((CardHomePageV3UI)localObject, str);
          }
        }
      }
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onLongClick"})
    static final class d
      implements View.OnLongClickListener
    {
      d(CardHomePageV3UI.b paramb, com.tencent.mm.view.recyclerview.h paramh) {}
      
      public final boolean onLongClick(View paramView)
      {
        AppMethodBeat.i(201436);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/card/ui/v3/CardHomePageV3UI$CardConverter$onCreateViewHolder$2", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
        final CardHomePageV3UI.a locala = (CardHomePageV3UI.a)paramh.hgv();
        localObject = new com.tencent.mm.ui.widget.b.a((Context)this.qho.qhn.getContext(), paramView);
        ((com.tencent.mm.ui.widget.b.a)localObject).a((View.OnCreateContextMenuListener)new View.OnCreateContextMenuListener()
        {
          public final void onCreateContextMenu(ContextMenu paramAnonymousContextMenu, View paramAnonymousView, ContextMenu.ContextMenuInfo paramAnonymousContextMenuInfo)
          {
            AppMethodBeat.i(201434);
            paramAnonymousContextMenu.add(0, 1, 0, (CharSequence)this.qhs.qho.qhn.getString(2131757060));
            AppMethodBeat.o(201434);
          }
        });
        ((com.tencent.mm.ui.widget.b.a)localObject).a((o.g)new o.g()
        {
          public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
          {
            AppMethodBeat.i(201435);
            paramAnonymousMenuItem = this.qhs.qho;
            String str1 = locala.cxm().eaO;
            p.g(str1, "cardConvertData.recentlyUsedCell.card_id");
            String str2 = locala.cxm().KDM;
            p.g(str2, "cardConvertData.recentlyUsedCell.user_card_id");
            com.tencent.mm.ui.widget.a.e locale = new com.tencent.mm.ui.widget.a.e((Context)paramAnonymousMenuItem.qhn.getContext(), 1, true);
            TextView localTextView = new TextView((Context)paramAnonymousMenuItem.qhn.getContext());
            localTextView.setText((CharSequence)paramAnonymousMenuItem.qhn.getString(2131757059));
            localTextView.setTextSize(1, 14.0F);
            localTextView.setTextColor(paramAnonymousMenuItem.qhn.getResources().getColor(2131100584));
            localTextView.setGravity(17);
            paramAnonymousInt = paramAnonymousMenuItem.qhn.getResources().getDimensionPixelSize(2131165314);
            int i = paramAnonymousMenuItem.qhn.getResources().getDimensionPixelSize(2131165296);
            localTextView.setPadding(paramAnonymousInt, i, paramAnonymousInt, i);
            locale.V((View)localTextView, false);
            locale.a((o.f)new CardHomePageV3UI.b.e(paramAnonymousMenuItem));
            locale.a((o.g)new CardHomePageV3UI.b.f(paramAnonymousMenuItem, str1, str2));
            locale.dGm();
            com.tencent.mm.plugin.report.service.h.CyF.a(19674, new Object[] { Integer.valueOf(2), Integer.valueOf(locala.cxm().nHh), locala.cxm().KDM, Long.valueOf(System.currentTimeMillis() / 1000L) });
            AppMethodBeat.o(201435);
          }
        });
        p.g(paramView, "it");
        paramView = com.tencent.mm.plugin.card.d.m.dB(paramView);
        ((com.tencent.mm.ui.widget.b.a)localObject).ez(paramView.x, paramView.y);
        com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/card/ui/v3/CardHomePageV3UI$CardConverter$onCreateViewHolder$2", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
        AppMethodBeat.o(201436);
        return false;
      }
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Lcom/tencent/mm/ui/base/MMMenu;", "kotlin.jvm.PlatformType", "onCreateMMMenu"})
    static final class e
      implements o.f
    {
      e(CardHomePageV3UI.b paramb) {}
      
      public final void onCreateMMMenu(com.tencent.mm.ui.base.m paramm)
      {
        AppMethodBeat.i(201437);
        paramm.a(1, this.qho.qhn.getResources().getColor(2131100996), (CharSequence)this.qho.qhn.getString(2131755921));
        AppMethodBeat.o(201437);
      }
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "menuItem", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "", "onMMMenuItemSelected"})
    static final class f
      implements o.g
    {
      f(CardHomePageV3UI.b paramb, String paramString1, String paramString2) {}
      
      public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
      {
        AppMethodBeat.i(201438);
        p.g(paramMenuItem, "menuItem");
        switch (paramMenuItem.getItemId())
        {
        }
        for (;;)
        {
          AppMethodBeat.o(201438);
          return;
          paramMenuItem = this.qho.qhn;
          Object localObject = this.qgl;
          String str = this.qhu;
          p.h(localObject, "cardId");
          p.h(str, "userCardId");
          Log.i(paramMenuItem.TAG, "do remove recently: " + (String)localObject + ", " + str);
          localObject = new com.tencent.mm.plugin.card.model.b.d((String)localObject, str).aYH().aYI();
          p.g(localObject, "CgiRemoveCardInRecentlyU…ntCancelAfterDead().run()");
          com.tencent.mm.ac.d.b((com.tencent.mm.vending.g.c)localObject, (kotlin.g.a.b)new CardHomePageV3UI.e(paramMenuItem, str)).b((com.tencent.mm.vending.e.b)paramMenuItem);
        }
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/GetMktCardHomePageV2Response;", "kotlin.jvm.PlatformType", "invoke"})
  static final class d
    extends q
    implements kotlin.g.a.b<c.a<bqq>, x>
  {
    d(CardHomePageV3UI paramCardHomePageV3UI, boolean paramBoolean)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/RemoveCardInRecentlyUsedListResponse;", "kotlin.jvm.PlatformType", "invoke", "(Lcom/tencent/mm/modelbase/Cgi$CgiBack;)Lkotlin/Unit;"})
  static final class e
    extends q
    implements kotlin.g.a.b<c.a<dmt>, x>
  {
    e(CardHomePageV3UI paramCardHomePageV3UI, String paramString)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/card/ui/v3/CardHomePageV3UI$initView$1", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "getItemConvert", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "type", "", "plugin-card_release"})
  public static final class f
    implements f
  {
    public final com.tencent.mm.view.recyclerview.e<?> EC(int paramInt)
    {
      AppMethodBeat.i(201445);
      com.tencent.mm.view.recyclerview.e locale = (com.tencent.mm.view.recyclerview.e)new CardHomePageV3UI.b(this.qhn);
      AppMethodBeat.o(201445);
      return locale;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/card/ui/v3/CardHomePageV3UI$initView$2", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback;", "onLoadMoreBegin", "", "onLoadMoreEnd", "reason", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;", "", "onRefreshBegin", "refreshType", "", "onRefreshEnd", "plugin-card_release"})
  public static final class g
    extends RefreshLoadMoreLayout.a
  {
    public final void ED(int paramInt)
    {
      AppMethodBeat.i(201449);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.pH(paramInt);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/card/ui/v3/CardHomePageV3UI$initView$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshBegin", "(I)V", this, localb.axR());
      Log.d(CardHomePageV3UI.a(this.qhn), "on begin refresh");
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/card/ui/v3/CardHomePageV3UI$initView$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshBegin", "(I)V");
      AppMethodBeat.o(201449);
    }
    
    public final void a(RefreshLoadMoreLayout.c<Object> paramc)
    {
      AppMethodBeat.i(201448);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bm(paramc);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/card/ui/v3/CardHomePageV3UI$initView$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V", this, localb.axR());
      p.h(paramc, "reason");
      Log.d(CardHomePageV3UI.a(this.qhn), "on load more end: " + CardHomePageV3UI.e(this.qhn));
      if (CardHomePageV3UI.f(this.qhn)) {
        CardHomePageV3UI.g(this.qhn).h(null);
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/card/ui/v3/CardHomePageV3UI$initView$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V");
      AppMethodBeat.o(201448);
    }
    
    public final void cxo()
    {
      AppMethodBeat.i(201447);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/card/ui/v3/CardHomePageV3UI$initView$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreBegin", "()V", this);
      Log.d(CardHomePageV3UI.a(this.qhn), "on load more");
      com.tencent.mm.ac.d.h((kotlin.g.a.a)new a(this));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/card/ui/v3/CardHomePageV3UI$initView$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreBegin", "()V");
      AppMethodBeat.o(201447);
    }
    
    public final void onRefreshEnd(RefreshLoadMoreLayout.c<Object> paramc)
    {
      AppMethodBeat.i(201450);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bm(paramc);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/card/ui/v3/CardHomePageV3UI$initView$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V", this, localb.axR());
      p.h(paramc, "reason");
      Log.d(CardHomePageV3UI.a(this.qhn), "on refresh end");
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/card/ui/v3/CardHomePageV3UI$initView$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V");
      AppMethodBeat.o(201450);
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
    static final class a
      extends q
      implements kotlin.g.a.a<x>
    {
      a(CardHomePageV3UI.g paramg)
      {
        super();
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class h
    implements MenuItem.OnMenuItemClickListener
  {
    h(CardHomePageV3UI paramCardHomePageV3UI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(201451);
      this.qhn.finish();
      AppMethodBeat.o(201451);
      return false;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick", "com/tencent/mm/plugin/card/ui/v3/CardHomePageV3UI$updateFAQ$1$1"})
  static final class i
    implements MenuItem.OnMenuItemClickListener
  {
    i(ue paramue, CardHomePageV3UI paramCardHomePageV3UI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(201454);
      paramMenuItem = new com.tencent.mm.ui.widget.a.e((Context)jdField_this.getContext(), 1, false);
      paramMenuItem.a((o.f)new o.f()
      {
        public final void onCreateMMMenu(com.tencent.mm.ui.base.m paramAnonymousm)
        {
          AppMethodBeat.i(201452);
          paramAnonymousm.add(0, 0, 1, (CharSequence)this.qhw.qgc.LdB);
          AppMethodBeat.o(201452);
        }
      });
      paramMenuItem.a((o.g)new o.g()
      {
        public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
        {
          AppMethodBeat.i(201453);
          p.g(paramAnonymousMenuItem, "menuItem");
          if (paramAnonymousMenuItem.getItemId() == 0) {
            switch (this.qhw.qgc.LdC)
            {
            }
          }
          for (;;)
          {
            AppMethodBeat.o(201453);
            return;
            com.tencent.mm.plugin.card.d.b.a((MMActivity)this.qhw.qhn.getContext(), this.qhw.qgc.LdD);
            AppMethodBeat.o(201453);
            return;
            paramAnonymousMenuItem = this.qhw.qgc.LdE;
            com.tencent.mm.plugin.card.d.b.H(paramAnonymousMenuItem.Hwr, paramAnonymousMenuItem.Hws, paramAnonymousMenuItem.IhZ);
          }
        }
      });
      paramMenuItem.dGm();
      AppMethodBeat.o(201454);
      return false;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class j
    implements View.OnClickListener
  {
    j(CardHomePageV3UI paramCardHomePageV3UI, ui paramui) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(201455);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/card/ui/v3/CardHomePageV3UI$updateHeader$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
      switch (localui.LdM)
      {
      default: 
        Log.w(CardHomePageV3UI.a(this.qhn), "unknown type " + localui.LdM);
      }
      for (;;)
      {
        com.tencent.mm.plugin.report.service.h.CyF.a(19673, new Object[] { localui.LdK, Long.valueOf(System.currentTimeMillis() / 1000L) });
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/card/ui/v3/CardHomePageV3UI$updateHeader$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(201455);
        return;
        com.tencent.mm.plugin.card.d.b.a((MMActivity)this.qhn.getContext(), localui.LdN);
        continue;
        paramView = localui.LdO;
        if (paramView != null)
        {
          com.tencent.mm.plugin.card.d.b.H(paramView.Hwr, paramView.Hws, paramView.IhZ);
          CardHomePageV3UI.l(this.qhn);
          continue;
          if ("weixin://mktcard/cert".equals(localui.LdP)) {
            CardHomePageV3UI.m(this.qhn);
          } else if ("weixin://mktcard/membercard".equals(localui.LdP)) {
            CardHomePageV3UI.n(this.qhn);
          } else if ("weixin://mktcard/coupon".equals(localui.LdP)) {
            CardHomePageV3UI.d(this.qhn, localui.LdK);
          } else if ("weixin://mktcard/couponv2".equals(localui.LdP)) {
            CardHomePageV3UI.e(this.qhn, localui.LdK);
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