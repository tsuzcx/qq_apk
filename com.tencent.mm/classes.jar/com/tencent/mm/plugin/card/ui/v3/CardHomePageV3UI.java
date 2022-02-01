package com.tencent.mm.plugin.card.ui.v3;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Point;
import android.os.Bundle;
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
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.c.a;
import com.tencent.mm.kernel.k;
import com.tencent.mm.plugin.appbrand.service.z;
import com.tencent.mm.plugin.card.a.b;
import com.tencent.mm.plugin.card.a.c;
import com.tencent.mm.plugin.card.a.d;
import com.tencent.mm.plugin.card.a.e;
import com.tencent.mm.plugin.card.a.f;
import com.tencent.mm.plugin.card.a.g;
import com.tencent.mm.plugin.card.d.m;
import com.tencent.mm.plugin.card.model.a.a.a.e;
import com.tencent.mm.plugin.card.widget.MemberCardTopCropImageView;
import com.tencent.mm.protocal.protobuf.byk;
import com.tencent.mm.protocal.protobuf.dwk;
import com.tencent.mm.protocal.protobuf.eaf;
import com.tencent.mm.protocal.protobuf.jh;
import com.tencent.mm.protocal.protobuf.ug;
import com.tencent.mm.protocal.protobuf.uh;
import com.tencent.mm.protocal.protobuf.ui;
import com.tencent.mm.protocal.protobuf.uk;
import com.tencent.mm.protocal.protobuf.ul;
import com.tencent.mm.protocal.protobuf.um;
import com.tencent.mm.protocal.protobuf.up;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.base.q.f;
import com.tencent.mm.ui.base.q.g;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.RefreshLoadMoreLayout.a;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.mm.view.recyclerview.WxRecyclerView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@k
@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/card/ui/v3/CardHomePageV3UI;", "Lcom/tencent/mm/ui/MMActivity;", "()V", "TAG", "", "loadCount", "", "loadingDialog", "Landroid/app/Dialog;", "mCardDataList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/card/ui/v3/CardHomePageV3UI$CardConvertData;", "Lkotlin/collections/ArrayList;", "mCardHomePageTopCellGroup", "Lcom/tencent/mm/protocal/protobuf/CardHomePageTopCellGroup;", "mFAQItem", "Lcom/tencent/mm/protocal/protobuf/CardHomePageFAQItem;", "mHasLoadedSuccess", "", "mHeaderContainerLayout", "Landroid/view/ViewGroup;", "mHeaderView", "mHomePageEmptyView", "Landroid/view/View;", "mHomePageRecentlyUsedCardTitleTv", "Landroid/widget/TextView;", "mIsAll", "mIsLoading", "mNeedRefreshPage", "mOffset", "mPageAdapter", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "mPageRv", "Lcom/tencent/mm/view/recyclerview/WxRecyclerView;", "mRefreshLayout", "Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "mViewHeight", "mViewWidth", "doLoadHomePage", "", "refresh", "doRemoveRecentlyCard", "cardId", "userCardId", "getLayoutId", "gotoCardDetailUI", "gotoCertListUI", "gotoCouponCardListUI", "title", "gotoCouponGiftCardListUI", "gotoVipCardListUI", "hideLoading", "initView", "loadSnapshot", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onResume", "preloadMiniApp", "removeCardByCardId", "saveSnapshot", "showLoading", "updateCardList", "cardList", "Lcom/tencent/mm/protocal/protobuf/CardHomePageRecentlyUsedList;", "updateFAQ", "faqItem", "updateHeader", "topCellGroup", "updateRecentlyUsedCardTitleLayout", "updateRecentlyUsedTitle", "CardConvertData", "CardConverter", "Companion", "plugin-card_release"})
public final class CardHomePageV3UI
  extends MMActivity
{
  public static final CardHomePageV3UI.c tDh;
  String TAG;
  private int aIj;
  private int aIk;
  private boolean puR;
  private WxRecyclerView tCT;
  private RefreshLoadMoreLayout tCU;
  private ViewGroup tCV;
  private ViewGroup tCW;
  private TextView tCX;
  private View tCY;
  private WxRecyclerAdapter<a> tCZ;
  private ArrayList<a> tDa;
  private boolean tDb;
  private boolean tDc;
  private boolean tDd;
  private ul tDe;
  private ug tDf;
  private int tDg;
  private int zP;
  
  static
  {
    AppMethodBeat.i(245275);
    tDh = new CardHomePageV3UI.c((byte)0);
    AppMethodBeat.o(245275);
  }
  
  public CardHomePageV3UI()
  {
    AppMethodBeat.i(245273);
    this.TAG = "MicroMsg.CardHomePageV3UI";
    this.tDa = new ArrayList();
    AppMethodBeat.o(245273);
  }
  
  private final void a(ug paramug)
  {
    AppMethodBeat.i(245262);
    if (paramug != null)
    {
      this.tDf = paramug;
      if (!Util.isNullOrNil(paramug.SeO))
      {
        removeAllOptionMenu();
        addIconOptionMenu(0, 0, a.f.icons_outlined_more, (MenuItem.OnMenuItemClickListener)new i(paramug, this));
      }
      AppMethodBeat.o(245262);
      return;
    }
    AppMethodBeat.o(245262);
  }
  
  private final void a(ui paramui)
  {
    AppMethodBeat.i(245264);
    if (paramui != null)
    {
      paramui = paramui.SeU.iterator();
      while (paramui.hasNext())
      {
        uh localuh = (uh)paramui.next();
        a locala = new a();
        p.j(localuh, "cell");
        locala.a(localuh);
        this.tDa.add(locala);
      }
      paramui = this.tCZ;
      if (paramui == null) {
        p.bGy("mPageAdapter");
      }
      paramui.notifyDataSetChanged();
    }
    cKN();
    AppMethodBeat.o(245264);
  }
  
  private final void a(ul paramul)
  {
    AppMethodBeat.i(245271);
    Log.i(this.TAG, "do update header");
    if (paramul == null)
    {
      AppMethodBeat.o(245271);
      return;
    }
    this.tDe = paramul;
    Object localObject1 = this.tCW;
    if (localObject1 == null) {
      p.bGy("mHeaderContainerLayout");
    }
    ((ViewGroup)localObject1).removeAllViews();
    int k = getResources().getDimensionPixelSize(a.b.Edge_A);
    paramul = paramul.Sff;
    p.j(paramul, "topCellGroup.card_home_page_top_cell_list");
    paramul = ((Iterable)paramul).iterator();
    while (paramul.hasNext())
    {
      Object localObject2 = (um)paramul.next();
      localObject1 = new LinearLayout((Context)getContext());
      ((LinearLayout)localObject1).setOrientation(1);
      ((LinearLayout)localObject1).setPadding(0, 0, 0, k);
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, -2);
      Object localObject3 = ((um)localObject2).Sfg;
      p.j(localObject3, "group.card_home_page_top_cell");
      localObject3 = ((Iterable)localObject3).iterator();
      int i = 0;
      if (((Iterator)localObject3).hasNext())
      {
        final uk localuk = (uk)((Iterator)localObject3).next();
        View localView = getLayoutInflater().inflate(a.e.tiz, (ViewGroup)localObject1, false);
        Object localObject4 = (ImageView)localView.findViewById(a.d.tdX);
        TextView localTextView1 = (TextView)localView.findViewById(a.d.tdY);
        Object localObject5 = (TextView)localView.findViewById(a.d.tdV);
        TextView localTextView2 = (TextView)localView.findViewById(a.d.tec);
        ImageView localImageView1 = (ImageView)localView.findViewById(a.d.ted);
        ImageView localImageView2 = (ImageView)localView.findViewById(a.d.tee);
        CharSequence localCharSequence = (CharSequence)localuk.SeY;
        int j;
        if ((localCharSequence == null) || (localCharSequence.length() == 0))
        {
          j = 1;
          label326:
          if ((j != 0) || (localuk.Sfd != 1)) {
            break label562;
          }
          p.j(localObject5, "descTv");
          ((TextView)localObject5).setText((CharSequence)localuk.SeY);
          p.j(localImageView2, "reddot2Iv");
          localImageView2.setVisibility(0);
          p.j(localImageView1, "reddot1Iv");
          localImageView1.setVisibility(8);
          p.j(localTextView2, "newIv");
          localTextView2.setVisibility(8);
        }
        for (;;)
        {
          localObject5 = localuk.SeW;
          if (localObject5 != null)
          {
            j = getResources().getDimensionPixelSize(a.b.Edge_3A);
            Log.i(this.TAG, "cell icon top height and width ".concat(String.valueOf(j)));
            p.j(localObject4, "iconIv");
            m.a((ImageView)localObject4, (String)localObject5, false, 0, j, j, 28);
          }
          p.j(localTextView1, "titleTv");
          localTextView1.setText((CharSequence)localuk.SeX);
          if (i == ((um)localObject2).Sfg.size() - 1)
          {
            localObject4 = localView.findViewById(a.d.tdW);
            p.j(localObject4, "cellView.findViewById<Vi…header_cell_divider_view)");
            ((View)localObject4).setVisibility(8);
          }
          localView.setOnClickListener((View.OnClickListener)new j(this, localuk));
          ((LinearLayout)localObject1).addView(localView);
          i += 1;
          break;
          j = 0;
          break label326;
          label562:
          if (localuk.Sfe == 1)
          {
            p.j(localTextView2, "newIv");
            localTextView2.setVisibility(0);
            p.j(localObject5, "descTv");
            ((TextView)localObject5).setText((CharSequence)"");
            p.j(localImageView2, "reddot2Iv");
            localImageView2.setVisibility(8);
            p.j(localImageView1, "reddot1Iv");
            localImageView1.setVisibility(8);
          }
          else if (localuk.Sfd == 1)
          {
            p.j(localObject5, "descTv");
            ((TextView)localObject5).setText((CharSequence)"");
            p.j(localImageView1, "reddot1Iv");
            localImageView1.setVisibility(0);
            p.j(localTextView2, "newIv");
            localTextView2.setVisibility(8);
            p.j(localImageView2, "reddot2Iv");
            localImageView2.setVisibility(8);
          }
          else
          {
            p.j(localObject5, "descTv");
            ((TextView)localObject5).setText((CharSequence)"");
            p.j(localImageView1, "reddot1Iv");
            localImageView1.setVisibility(8);
            p.j(localTextView2, "newIv");
            localTextView2.setVisibility(8);
            p.j(localImageView2, "reddot2Iv");
            localImageView2.setVisibility(8);
          }
        }
      }
      localObject2 = this.tCW;
      if (localObject2 == null) {
        p.bGy("mHeaderContainerLayout");
      }
      ((ViewGroup)localObject2).addView((View)localObject1, (ViewGroup.LayoutParams)localLayoutParams);
    }
    AppMethodBeat.o(245271);
  }
  
  private final void arF(String paramString)
  {
    AppMethodBeat.i(245268);
    Object localObject = (CharSequence)paramString;
    if ((localObject == null) || (((CharSequence)localObject).length() == 0)) {}
    for (int i = 1;; i = 0)
    {
      if (i == 0)
      {
        localObject = this.tCX;
        if (localObject == null) {
          p.bGy("mHomePageRecentlyUsedCardTitleTv");
        }
        ((TextView)localObject).setText((CharSequence)paramString);
      }
      AppMethodBeat.o(245268);
      return;
    }
  }
  
  private final void cKN()
  {
    AppMethodBeat.i(245266);
    if (this.tDa.isEmpty())
    {
      localObject = this.tCY;
      if (localObject == null) {
        p.bGy("mHomePageEmptyView");
      }
      ((View)localObject).setVisibility(0);
      localObject = this.tCX;
      if (localObject == null) {
        p.bGy("mHomePageRecentlyUsedCardTitleTv");
      }
      ((TextView)localObject).setVisibility(8);
      AppMethodBeat.o(245266);
      return;
    }
    Object localObject = this.tCY;
    if (localObject == null) {
      p.bGy("mHomePageEmptyView");
    }
    ((View)localObject).setVisibility(8);
    localObject = this.tCX;
    if (localObject == null) {
      p.bGy("mHomePageRecentlyUsedCardTitleTv");
    }
    ((TextView)localObject).setVisibility(0);
    AppMethodBeat.o(245266);
  }
  
  private final void lL(final boolean paramBoolean)
  {
    int i = 0;
    AppMethodBeat.i(245261);
    Log.i(this.TAG, "do load home page");
    Object localObject;
    if ((this.tDb) && (!paramBoolean))
    {
      Log.w(this.TAG, "already load complete");
      localObject = this.tCU;
      if (localObject == null) {
        p.bGy("mRefreshLayout");
      }
      ((RefreshLoadMoreLayout)localObject).azs(0);
      AppMethodBeat.o(245261);
      return;
    }
    if (this.puR)
    {
      Log.w(this.TAG, "is loading");
      AppMethodBeat.o(245261);
      return;
    }
    this.puR = true;
    int j = this.zP;
    if (paramBoolean)
    {
      localObject = this.tCU;
      if (localObject == null) {
        p.bGy("mRefreshLayout");
      }
      ((RefreshLoadMoreLayout)localObject).setHasBottomMore(true);
    }
    for (;;)
    {
      localObject = new com.tencent.mm.plugin.card.model.b.c(i).bhW();
      p.j(localObject, "CgiGetMktCardHomePageV3(offset, 10).run()");
      com.tencent.mm.ae.d.b((com.tencent.mm.vending.g.c)localObject, (kotlin.g.a.b)new d(this, paramBoolean));
      AppMethodBeat.o(245261);
      return;
      i = j;
    }
  }
  
  public final int getLayoutId()
  {
    return a.e.tiC;
  }
  
  public final void initView()
  {
    AppMethodBeat.i(245252);
    Object localObject1 = findViewById(a.d.teC);
    p.j(localObject1, "findViewById(R.id.chpuv3_rv)");
    this.tCT = ((WxRecyclerView)localObject1);
    localObject1 = findViewById(a.d.teB);
    p.j(localObject1, "findViewById(R.id.chpuv3_refresh_layout)");
    this.tCU = ((RefreshLoadMoreLayout)localObject1);
    localObject1 = this.tCT;
    if (localObject1 == null) {
      p.bGy("mPageRv");
    }
    getContext();
    ((WxRecyclerView)localObject1).setLayoutManager((RecyclerView.LayoutManager)new LinearLayoutManager(1, false));
    this.tCZ = new WxRecyclerAdapter((com.tencent.mm.view.recyclerview.f)new CardHomePageV3UI.f(this), this.tDa);
    localObject1 = this.tCZ;
    if (localObject1 == null) {
      p.bGy("mPageAdapter");
    }
    ((WxRecyclerAdapter)localObject1).aw(true);
    localObject1 = this.tCT;
    if (localObject1 == null) {
      p.bGy("mPageRv");
    }
    Object localObject2 = this.tCZ;
    if (localObject2 == null) {
      p.bGy("mPageAdapter");
    }
    ((WxRecyclerView)localObject1).setAdapter((RecyclerView.a)localObject2);
    localObject1 = new androidx.recyclerview.widget.i((Context)getContext(), 1);
    ((androidx.recyclerview.widget.i)localObject1).t(getResources().getDrawable(a.c.taj));
    localObject2 = this.tCT;
    if (localObject2 == null) {
      p.bGy("mPageRv");
    }
    ((WxRecyclerView)localObject2).b((RecyclerView.h)localObject1);
    localObject1 = getLayoutInflater();
    int i = a.e.tiA;
    localObject2 = this.tCT;
    if (localObject2 == null) {
      p.bGy("mPageRv");
    }
    localObject1 = ((LayoutInflater)localObject1).inflate(i, (ViewGroup)localObject2, false);
    if (localObject1 == null)
    {
      localObject1 = new t("null cannot be cast to non-null type android.view.ViewGroup");
      AppMethodBeat.o(245252);
      throw ((Throwable)localObject1);
    }
    this.tCV = ((ViewGroup)localObject1);
    localObject1 = this.tCV;
    if (localObject1 == null) {
      p.bGy("mHeaderView");
    }
    localObject1 = ((ViewGroup)localObject1).findViewById(a.d.tdZ);
    p.j(localObject1, "mHeaderView.findViewById…_header_container_layout)");
    this.tCW = ((ViewGroup)localObject1);
    localObject1 = this.tCV;
    if (localObject1 == null) {
      p.bGy("mHeaderView");
    }
    localObject1 = ((ViewGroup)localObject1).findViewById(a.d.teb);
    p.j(localObject1, "mHeaderView.findViewById…hphv3_home_page_title_tv)");
    this.tCX = ((TextView)localObject1);
    localObject1 = this.tCV;
    if (localObject1 == null) {
      p.bGy("mHeaderView");
    }
    localObject1 = ((ViewGroup)localObject1).findViewById(a.d.tea);
    p.j(localObject1, "mHeaderView.findViewById…3_home_page_empty_layout)");
    this.tCY = ((View)localObject1);
    localObject1 = this.tCZ;
    if (localObject1 == null) {
      p.bGy("mPageAdapter");
    }
    localObject2 = this.tCV;
    if (localObject2 == null) {
      p.bGy("mHeaderView");
    }
    ((WxRecyclerAdapter)localObject1).g((View)localObject2, 2, false);
    localObject1 = this.tCU;
    if (localObject1 == null) {
      p.bGy("mRefreshLayout");
    }
    ((RefreshLoadMoreLayout)localObject1).setEnableRefresh(false);
    localObject1 = this.tCU;
    if (localObject1 == null) {
      p.bGy("mRefreshLayout");
    }
    i = com.tencent.mm.ci.a.fromDPToPix((Context)getContext(), 1200);
    localObject2 = MMApplicationContext.getContext();
    p.j(localObject2, "MMApplicationContext.getContext()");
    ((RefreshLoadMoreLayout)localObject1).setLimitTopRequest(i - (int)((Context)localObject2).getResources().getDimension(a.b.Edge_12A));
    localObject1 = this.tCU;
    if (localObject1 == null) {
      p.bGy("mRefreshLayout");
    }
    localObject2 = MMApplicationContext.getContext();
    p.j(localObject2, "MMApplicationContext.getContext()");
    ((RefreshLoadMoreLayout)localObject1).setRefreshTargetY((int)((Context)localObject2).getResources().getDimension(a.b.Edge_7A) - com.tencent.mm.ci.a.fromDPToPix((Context)getContext(), 1200));
    localObject1 = this.tCU;
    if (localObject1 == null) {
      p.bGy("mRefreshLayout");
    }
    ((RefreshLoadMoreLayout)localObject1).setDamping(1.85F);
    localObject1 = this.tCU;
    if (localObject1 == null) {
      p.bGy("mRefreshLayout");
    }
    ((RefreshLoadMoreLayout)localObject1).setActionCallback((RefreshLoadMoreLayout.a)new CardHomePageV3UI.g(this));
    AppMethodBeat.o(245252);
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(245258);
    switch (paramInt1)
    {
    }
    for (;;)
    {
      super.onActivityResult(paramInt1, paramInt2, paramIntent);
      AppMethodBeat.o(245258);
      return;
      lL(true);
      continue;
      lL(true);
      continue;
      lL(true);
      continue;
      lL(true);
    }
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(245248);
    super.onCreate(paramBundle);
    initView();
    setMMTitle(a.g.tkz);
    setActionbarColor(getResources().getColor(com.tencent.mm.plugin.card.a.a.BG_0));
    hideActionbarLine();
    setBackBtn((MenuItem.OnMenuItemClickListener)new CardHomePageV3UI.h(this));
    paramBundle = com.tencent.mm.plugin.card.model.a.a.trh;
    paramBundle = com.tencent.mm.plugin.card.model.a.a.a.cHJ();
    if (paramBundle != null)
    {
      this.zP = paramBundle.ufi;
      arF(paramBundle.ThD);
      a(paramBundle.ThB);
      a(paramBundle.ThC);
      a(paramBundle.Thy);
    }
    lL(true);
    ((com.tencent.mm.plugin.appbrand.service.f)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.appbrand.service.f.class)).b(z.qPm);
    AppMethodBeat.o(245248);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(245256);
    super.onDestroy();
    if (!this.tDc)
    {
      Log.i(this.TAG, "no data to save snapshot");
      AppMethodBeat.o(245256);
      return;
    }
    byk localbyk = new byk();
    localbyk.BaseResponse = new jh();
    localbyk.BaseResponse.Tef = new eaf();
    localbyk.ThB = this.tDe;
    Object localObject = this.tCX;
    if (localObject == null) {
      p.bGy("mHomePageRecentlyUsedCardTitleTv");
    }
    localbyk.ThD = ((TextView)localObject).getText().toString();
    localbyk.ThC = new ui();
    localbyk.ufi = this.zP;
    localbyk.Thy = this.tDf;
    localObject = this.tDa.iterator();
    while (((Iterator)localObject).hasNext())
    {
      uh localuh = ((a)((Iterator)localObject).next()).cKP();
      if (localuh != null) {
        localbyk.ThC.SeU.add(localuh);
      }
    }
    localObject = com.tencent.mm.plugin.card.model.a.a.trh;
    p.k(localbyk, "response");
    Log.d(com.tencent.mm.plugin.card.model.a.a.access$getTAG$cp(), "save home page v3 snapshot");
    com.tencent.mm.ae.d.h((kotlin.g.a.a)new a.a.e(localbyk));
    AppMethodBeat.o(245256);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(245254);
    super.onResume();
    if (this.tDd)
    {
      lL(true);
      this.tDd = false;
    }
    AppMethodBeat.o(245254);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/card/ui/v3/CardHomePageV3UI$CardConvertData;", "Lcom/tencent/mm/view/recyclerview/ConvertData;", "()V", "recentlyUsedCell", "Lcom/tencent/mm/protocal/protobuf/CardHomePageRecentlyUsedCell;", "getRecentlyUsedCell", "()Lcom/tencent/mm/protocal/protobuf/CardHomePageRecentlyUsedCell;", "setRecentlyUsedCell", "(Lcom/tencent/mm/protocal/protobuf/CardHomePageRecentlyUsedCell;)V", "getItemId", "", "getItemType", "", "plugin-card_release"})
  public static final class a
    implements com.tencent.mm.view.recyclerview.a
  {
    public uh tDi;
    
    public final void a(uh paramuh)
    {
      AppMethodBeat.i(245348);
      p.k(paramuh, "<set-?>");
      this.tDi = paramuh;
      AppMethodBeat.o(245348);
    }
    
    public final int bAQ()
    {
      return 1;
    }
    
    public final uh cKP()
    {
      AppMethodBeat.i(245345);
      uh localuh = this.tDi;
      if (localuh == null) {
        p.bGy("recentlyUsedCell");
      }
      AppMethodBeat.o(245345);
      return localuh;
    }
    
    public final long mf()
    {
      AppMethodBeat.i(245351);
      uh localuh = this.tDi;
      if (localuh == null) {
        p.bGy("recentlyUsedCell");
      }
      long l = localuh.fUL.hashCode();
      AppMethodBeat.o(245351);
      return l;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/card/ui/v3/CardHomePageV3UI$CardConverter;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "Lcom/tencent/mm/plugin/card/ui/v3/CardHomePageV3UI$CardConvertData;", "(Lcom/tencent/mm/plugin/card/ui/v3/CardHomePageV3UI;)V", "clearShadowLayer", "", "textview", "Landroid/widget/TextView;", "getLayoutId", "", "onBindViewHolder", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "position", "type", "isHotPatch", "", "payloads", "", "", "onCreateViewHolder", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "setShadowLayer", "showDeleteConfirmDialog", "cardId", "", "userCardId", "plugin-card_release"})
  public final class b
    extends com.tencent.mm.view.recyclerview.e<CardHomePageV3UI.a>
  {
    private static void m(TextView paramTextView)
    {
      AppMethodBeat.i(252386);
      paramTextView.setShadowLayer(0.0F, 0.0F, 0.0F, 0);
      AppMethodBeat.o(252386);
    }
    
    private final void n(TextView paramTextView)
    {
      AppMethodBeat.i(252388);
      paramTextView.setShadowLayer(com.tencent.mm.ci.a.fromDPToPix(paramTextView.getContext(), 4), 0.0F, 0.0F, this.tDj.getResources().getColor(com.tencent.mm.plugin.card.a.a.UN_BW_0_Alpha_0_2));
      AppMethodBeat.o(252388);
    }
    
    public final void a(RecyclerView paramRecyclerView, final com.tencent.mm.view.recyclerview.i parami, int paramInt)
    {
      AppMethodBeat.i(252382);
      p.k(paramRecyclerView, "recyclerView");
      p.k(parami, "holder");
      paramRecyclerView = (ViewGroup)parami.RD(a.d.tex);
      paramRecyclerView.setOnClickListener((View.OnClickListener)new c(this, parami));
      paramRecyclerView.setOnLongClickListener((View.OnLongClickListener)new d(this, parami));
      AppMethodBeat.o(252382);
    }
    
    public final int getLayoutId()
    {
      return a.e.tiB;
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
    static final class a
      implements Runnable
    {
      a(CardHomePageV3UI.b paramb, com.tencent.mm.view.recyclerview.i parami, kotlin.g.a.a parama) {}
      
      public final void run()
      {
        AppMethodBeat.i(247793);
        CardHomePageV3UI localCardHomePageV3UI = this.tDk.tDj;
        View localView = this.tDl.amk;
        p.j(localView, "holder.itemView");
        CardHomePageV3UI.a(localCardHomePageV3UI, localView.getHeight());
        localCardHomePageV3UI = this.tDk.tDj;
        localView = this.tDl.amk;
        p.j(localView, "holder.itemView");
        CardHomePageV3UI.b(localCardHomePageV3UI, localView.getWidth());
        this.tCS.invoke();
        AppMethodBeat.o(247793);
      }
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
    static final class b
      extends q
      implements kotlin.g.a.a<x>
    {
      b(CardHomePageV3UI.b paramb, com.tencent.mm.view.recyclerview.i parami, MemberCardTopCropImageView paramMemberCardTopCropImageView, CardHomePageV3UI.a parama)
      {
        super();
      }
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class c
      implements View.OnClickListener
    {
      c(CardHomePageV3UI.b paramb, com.tencent.mm.view.recyclerview.i parami) {}
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(247799);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/card/ui/v3/CardHomePageV3UI$CardConverter$onCreateViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
        paramView = (CardHomePageV3UI.a)parami.ihX();
        String str;
        switch (paramView.cKP().Sep)
        {
        default: 
          Log.w(CardHomePageV3UI.a(this.tDk.tDj), "unknown type " + paramView.cKP().Sep);
          localObject = this.tDk.tDj;
          str = paramView.cKP().RFf;
          p.j(str, "cardConvertData.recentlyUsedCell.user_card_id");
          CardHomePageV3UI.a((CardHomePageV3UI)localObject, str);
        }
        for (;;)
        {
          com.tencent.mm.plugin.report.service.h.IzE.a(19674, new Object[] { Integer.valueOf(1), Integer.valueOf(paramView.cKP().qJt), paramView.cKP().RFf, Long.valueOf(System.currentTimeMillis() / 1000L) });
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/card/ui/v3/CardHomePageV3UI$CardConverter$onCreateViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(247799);
          return;
          com.tencent.mm.plugin.card.d.b.a((MMActivity)this.tDk.tDj.getContext(), paramView.cKP().Seq);
          continue;
          localObject = paramView.cKP().Ser;
          if (localObject != null)
          {
            com.tencent.mm.plugin.card.d.b.L(((up)localObject).Ooe, ((up)localObject).Oof, ((up)localObject).Paq);
            continue;
            localObject = this.tDk.tDj;
            str = paramView.cKP().RFf;
            p.j(str, "cardConvertData.recentlyUsedCell.user_card_id");
            CardHomePageV3UI.a((CardHomePageV3UI)localObject, str);
          }
        }
      }
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onLongClick"})
    static final class d
      implements View.OnLongClickListener
    {
      d(CardHomePageV3UI.b paramb, com.tencent.mm.view.recyclerview.i parami) {}
      
      public final boolean onLongClick(View paramView)
      {
        AppMethodBeat.i(245670);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/card/ui/v3/CardHomePageV3UI$CardConverter$onCreateViewHolder$2", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
        final CardHomePageV3UI.a locala = (CardHomePageV3UI.a)parami.ihX();
        localObject = new com.tencent.mm.ui.widget.b.a((Context)this.tDk.tDj.getContext(), paramView);
        ((com.tencent.mm.ui.widget.b.a)localObject).a((View.OnCreateContextMenuListener)new View.OnCreateContextMenuListener()
        {
          public final void onCreateContextMenu(ContextMenu paramAnonymousContextMenu, View paramAnonymousView, ContextMenu.ContextMenuInfo paramAnonymousContextMenuInfo)
          {
            AppMethodBeat.i(244529);
            paramAnonymousContextMenu.add(0, 1, 0, (CharSequence)this.tDo.tDk.tDj.getString(a.g.tky));
            AppMethodBeat.o(244529);
          }
        });
        ((com.tencent.mm.ui.widget.b.a)localObject).a((q.g)new q.g()
        {
          public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
          {
            AppMethodBeat.i(245973);
            paramAnonymousMenuItem = this.tDo.tDk;
            String str1 = locala.cKP().fUL;
            p.j(str1, "cardConvertData.recentlyUsedCell.card_id");
            String str2 = locala.cKP().RFf;
            p.j(str2, "cardConvertData.recentlyUsedCell.user_card_id");
            com.tencent.mm.ui.widget.a.e locale = new com.tencent.mm.ui.widget.a.e((Context)paramAnonymousMenuItem.tDj.getContext(), 1, true);
            TextView localTextView = new TextView((Context)paramAnonymousMenuItem.tDj.getContext());
            localTextView.setText((CharSequence)paramAnonymousMenuItem.tDj.getString(a.g.tkx));
            localTextView.setTextSize(1, 14.0F);
            localTextView.setTextColor(paramAnonymousMenuItem.tDj.getResources().getColor(com.tencent.mm.plugin.card.a.a.half_alpha_black));
            localTextView.setGravity(17);
            paramAnonymousInt = paramAnonymousMenuItem.tDj.getResources().getDimensionPixelSize(a.b.Edge_A);
            int i = paramAnonymousMenuItem.tDj.getResources().getDimensionPixelSize(a.b.Edge_2A);
            localTextView.setPadding(paramAnonymousInt, i, paramAnonymousInt, i);
            locale.Z((View)localTextView, false);
            locale.a((q.f)new CardHomePageV3UI.b.e(paramAnonymousMenuItem));
            locale.a((q.g)new CardHomePageV3UI.b.f(paramAnonymousMenuItem, str1, str2));
            locale.eik();
            com.tencent.mm.plugin.report.service.h.IzE.a(19674, new Object[] { Integer.valueOf(2), Integer.valueOf(locala.cKP().qJt), locala.cKP().RFf, Long.valueOf(System.currentTimeMillis() / 1000L) });
            AppMethodBeat.o(245973);
          }
        });
        p.j(paramView, "it");
        paramView = m.dZ(paramView);
        ((com.tencent.mm.ui.widget.b.a)localObject).eY(paramView.x, paramView.y);
        com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/card/ui/v3/CardHomePageV3UI$CardConverter$onCreateViewHolder$2", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
        AppMethodBeat.o(245670);
        return false;
      }
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Lcom/tencent/mm/ui/base/MMMenu;", "kotlin.jvm.PlatformType", "onCreateMMMenu"})
    static final class e
      implements q.f
    {
      e(CardHomePageV3UI.b paramb) {}
      
      public final void onCreateMMMenu(o paramo)
      {
        AppMethodBeat.i(251493);
        paramo.a(1, this.tDk.tDj.getResources().getColor(com.tencent.mm.plugin.card.a.a.red_text_color), (CharSequence)this.tDk.tDj.getString(a.g.app_ok));
        AppMethodBeat.o(251493);
      }
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "menuItem", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "", "onMMMenuItemSelected"})
    static final class f
      implements q.g
    {
      f(CardHomePageV3UI.b paramb, String paramString1, String paramString2) {}
      
      public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
      {
        AppMethodBeat.i(253076);
        p.j(paramMenuItem, "menuItem");
        switch (paramMenuItem.getItemId())
        {
        }
        for (;;)
        {
          AppMethodBeat.o(253076);
          return;
          paramMenuItem = this.tDk.tDj;
          Object localObject = this.tCi;
          String str = this.tDq;
          p.k(localObject, "cardId");
          p.k(str, "userCardId");
          Log.i(paramMenuItem.TAG, "do remove recently: " + (String)localObject + ", " + str);
          localObject = new com.tencent.mm.plugin.card.model.b.d((String)localObject, str).bhV().bhW();
          p.j(localObject, "CgiRemoveCardInRecentlyU…ntCancelAfterDead().run()");
          com.tencent.mm.ae.d.b((com.tencent.mm.vending.g.c)localObject, (kotlin.g.a.b)new CardHomePageV3UI.e(paramMenuItem, str)).b((com.tencent.mm.vending.e.b)paramMenuItem);
        }
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/GetMktCardHomePageV2Response;", "kotlin.jvm.PlatformType", "invoke"})
  static final class d
    extends q
    implements kotlin.g.a.b<c.a<byk>, x>
  {
    d(CardHomePageV3UI paramCardHomePageV3UI, boolean paramBoolean)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/RemoveCardInRecentlyUsedListResponse;", "kotlin.jvm.PlatformType", "invoke", "(Lcom/tencent/mm/modelbase/Cgi$CgiBack;)Lkotlin/Unit;"})
  static final class e
    extends q
    implements kotlin.g.a.b<c.a<dwk>, x>
  {
    e(CardHomePageV3UI paramCardHomePageV3UI, String paramString)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick", "com/tencent/mm/plugin/card/ui/v3/CardHomePageV3UI$updateFAQ$1$1"})
  static final class i
    implements MenuItem.OnMenuItemClickListener
  {
    i(ug paramug, CardHomePageV3UI paramCardHomePageV3UI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(250587);
      paramMenuItem = new com.tencent.mm.ui.widget.a.e((Context)jdField_this.getContext(), 1, false);
      paramMenuItem.a((q.f)new q.f()
      {
        public final void onCreateMMMenu(o paramAnonymouso)
        {
          AppMethodBeat.i(246659);
          paramAnonymouso.add(0, 0, 1, (CharSequence)this.tDs.tBZ.SeO);
          AppMethodBeat.o(246659);
        }
      });
      paramMenuItem.a((q.g)new q.g()
      {
        public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
        {
          AppMethodBeat.i(246452);
          p.j(paramAnonymousMenuItem, "menuItem");
          if (paramAnonymousMenuItem.getItemId() == 0) {
            switch (this.tDs.tBZ.SeP)
            {
            }
          }
          for (;;)
          {
            AppMethodBeat.o(246452);
            return;
            com.tencent.mm.plugin.card.d.b.a((MMActivity)this.tDs.tDj.getContext(), this.tDs.tBZ.SeQ);
            AppMethodBeat.o(246452);
            return;
            paramAnonymousMenuItem = this.tDs.tBZ.SeR;
            com.tencent.mm.plugin.card.d.b.L(paramAnonymousMenuItem.Ooe, paramAnonymousMenuItem.Oof, paramAnonymousMenuItem.Paq);
          }
        }
      });
      paramMenuItem.eik();
      AppMethodBeat.o(250587);
      return false;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class j
    implements View.OnClickListener
  {
    j(CardHomePageV3UI paramCardHomePageV3UI, uk paramuk) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(256131);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/card/ui/v3/CardHomePageV3UI$updateHeader$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      switch (localuk.SeZ)
      {
      default: 
        Log.w(CardHomePageV3UI.a(this.tDj), "unknown type " + localuk.SeZ);
      }
      for (;;)
      {
        com.tencent.mm.plugin.report.service.h.IzE.a(19673, new Object[] { localuk.SeX, Long.valueOf(System.currentTimeMillis() / 1000L) });
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/card/ui/v3/CardHomePageV3UI$updateHeader$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(256131);
        return;
        com.tencent.mm.plugin.card.d.b.a((MMActivity)this.tDj.getContext(), localuk.Sfa);
        continue;
        paramView = localuk.Sfb;
        if (paramView != null)
        {
          com.tencent.mm.plugin.card.d.b.L(paramView.Ooe, paramView.Oof, paramView.Paq);
          CardHomePageV3UI.l(this.tDj);
          continue;
          if ("weixin://mktcard/cert".equals(localuk.Sfc)) {
            CardHomePageV3UI.m(this.tDj);
          } else if ("weixin://mktcard/membercard".equals(localuk.Sfc)) {
            CardHomePageV3UI.n(this.tDj);
          } else if ("weixin://mktcard/coupon".equals(localuk.Sfc)) {
            CardHomePageV3UI.d(this.tDj, localuk.SeX);
          } else if ("weixin://mktcard/couponv2".equals(localuk.Sfc)) {
            CardHomePageV3UI.e(this.tDj, localuk.SeX);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.v3.CardHomePageV3UI
 * JD-Core Version:    0.7.0.1
 */