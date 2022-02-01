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
import com.tencent.mm.protocal.protobuf.bee;
import com.tencent.mm.protocal.protobuf.cti;
import com.tencent.mm.protocal.protobuf.cwt;
import com.tencent.mm.protocal.protobuf.sx;
import com.tencent.mm.protocal.protobuf.sy;
import com.tencent.mm.protocal.protobuf.sz;
import com.tencent.mm.protocal.protobuf.tb;
import com.tencent.mm.protocal.protobuf.tc;
import com.tencent.mm.protocal.protobuf.td;
import com.tencent.mm.protocal.protobuf.tg;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
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
@d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/card/ui/v3/CardHomePageV3UI;", "Lcom/tencent/mm/ui/MMActivity;", "()V", "TAG", "", "loadCount", "", "loadingDialog", "Landroid/app/Dialog;", "mCardDataList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/card/ui/v3/CardHomePageV3UI$CardConvertData;", "Lkotlin/collections/ArrayList;", "mCardHomePageTopCellGroup", "Lcom/tencent/mm/protocal/protobuf/CardHomePageTopCellGroup;", "mFAQItem", "Lcom/tencent/mm/protocal/protobuf/CardHomePageFAQItem;", "mHasLoadedSuccess", "", "mHeaderContainerLayout", "Landroid/view/ViewGroup;", "mHeaderView", "mHomePageEmptyView", "Landroid/view/View;", "mHomePageRecentlyUsedCardTitleTv", "Landroid/widget/TextView;", "mIsAll", "mIsLoading", "mNeedRefreshPage", "mOffset", "mPageAdapter", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "mPageRv", "Lcom/tencent/mm/view/recyclerview/WxRecyclerView;", "mRefreshLayout", "Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "mViewHeight", "doLoadHomePage", "", "refresh", "doRemoveRecentlyCard", "cardId", "userCardId", "getLayoutId", "gotoCardDetailUI", "gotoCertListUI", "gotoCouponCardListUI", "title", "gotoVipCardListUI", "hideLoading", "initView", "loadSnapshot", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onResume", "removeCardByCardId", "saveSnapshot", "showLoading", "updateCardList", "cardList", "Lcom/tencent/mm/protocal/protobuf/CardHomePageRecentlyUsedList;", "updateFAQ", "faqItem", "updateHeader", "topCellGroup", "updateRecentlyUsedCardTitleLayout", "updateRecentlyUsedTitle", "CardConvertData", "CardConverter", "Companion", "plugin-card_release"})
public final class CardHomePageV3UI
  extends MMActivity
{
  private static final int oMT = 1;
  private static final int oMU = 2;
  private static final int oMV = 1;
  private static final int oMW = 2;
  private static final int oMX = 3;
  private static final int oMY = 4;
  public static final CardHomePageV3UI.c oMZ;
  String TAG;
  private int aYT;
  private int fq;
  private boolean llo;
  private WxRecyclerView oMF;
  private RefreshLoadMoreLayout oMG;
  private ViewGroup oMH;
  private ViewGroup oMI;
  private TextView oMJ;
  private View oMK;
  private WxRecyclerAdapter<a> oML;
  private ArrayList<a> oMM;
  private boolean oMN;
  private boolean oMO;
  private boolean oMP;
  private tc oMQ;
  private sx oMR;
  private int oMS;
  
  static
  {
    AppMethodBeat.i(215501);
    oMZ = new CardHomePageV3UI.c((byte)0);
    oMT = 1;
    oMU = 2;
    oMV = 1;
    oMW = 2;
    oMX = 3;
    oMY = 4;
    AppMethodBeat.o(215501);
  }
  
  public CardHomePageV3UI()
  {
    AppMethodBeat.i(215500);
    this.TAG = "MicroMsg.CardHomePageV3UI";
    this.oMM = new ArrayList();
    AppMethodBeat.o(215500);
  }
  
  private final void YW(String paramString)
  {
    AppMethodBeat.i(215498);
    Object localObject = (CharSequence)paramString;
    if ((localObject == null) || (((CharSequence)localObject).length() == 0)) {}
    for (int i = 1;; i = 0)
    {
      if (i == 0)
      {
        localObject = this.oMJ;
        if (localObject == null) {
          p.bcb("mHomePageRecentlyUsedCardTitleTv");
        }
        ((TextView)localObject).setText((CharSequence)paramString);
      }
      AppMethodBeat.o(215498);
      return;
    }
  }
  
  private final void a(sx paramsx)
  {
    AppMethodBeat.i(215495);
    if (paramsx != null)
    {
      this.oMR = paramsx;
      if (!bt.isNullOrNil(paramsx.FQy))
      {
        removeAllOptionMenu();
        addIconOptionMenu(0, 0, 2131690603, (MenuItem.OnMenuItemClickListener)new i(paramsx, this));
      }
      AppMethodBeat.o(215495);
      return;
    }
    AppMethodBeat.o(215495);
  }
  
  private final void a(sz paramsz)
  {
    AppMethodBeat.i(215496);
    if (paramsz != null)
    {
      paramsz = paramsz.FQD.iterator();
      while (paramsz.hasNext())
      {
        sy localsy = (sy)paramsz.next();
        a locala = new a();
        p.g(localsy, "cell");
        locala.a(localsy);
        this.oMM.add(locala);
      }
      paramsz = this.oML;
      if (paramsz == null) {
        p.bcb("mPageAdapter");
      }
      paramsz.notifyDataSetChanged();
    }
    bYg();
    AppMethodBeat.o(215496);
  }
  
  private final void a(tc paramtc)
  {
    AppMethodBeat.i(215499);
    ad.i(this.TAG, "do update header");
    if (paramtc == null)
    {
      AppMethodBeat.o(215499);
      return;
    }
    this.oMQ = paramtc;
    Object localObject1 = this.oMI;
    if (localObject1 == null) {
      p.bcb("mHeaderContainerLayout");
    }
    ((ViewGroup)localObject1).removeAllViews();
    int k = getResources().getDimensionPixelSize(2131165303);
    paramtc = paramtc.FQO;
    p.g(paramtc, "topCellGroup.card_home_page_top_cell_list");
    paramtc = ((Iterable)paramtc).iterator();
    while (paramtc.hasNext())
    {
      Object localObject2 = (td)paramtc.next();
      localObject1 = new LinearLayout((Context)getContext());
      ((LinearLayout)localObject1).setOrientation(1);
      ((LinearLayout)localObject1).setPadding(0, 0, 0, k);
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, -2);
      Object localObject3 = ((td)localObject2).FQP;
      p.g(localObject3, "group.card_home_page_top_cell");
      localObject3 = ((Iterable)localObject3).iterator();
      int i = 0;
      if (((Iterator)localObject3).hasNext())
      {
        final tb localtb = (tb)((Iterator)localObject3).next();
        View localView = getLayoutInflater().inflate(2131493301, (ViewGroup)localObject1, false);
        Object localObject4 = (ImageView)localView.findViewById(2131298284);
        TextView localTextView1 = (TextView)localView.findViewById(2131298285);
        Object localObject5 = (TextView)localView.findViewById(2131298282);
        TextView localTextView2 = (TextView)localView.findViewById(2131298289);
        ImageView localImageView1 = (ImageView)localView.findViewById(2131298290);
        ImageView localImageView2 = (ImageView)localView.findViewById(2131298291);
        CharSequence localCharSequence = (CharSequence)localtb.FQH;
        int j;
        if ((localCharSequence == null) || (localCharSequence.length() == 0))
        {
          j = 1;
          label326:
          if ((j != 0) || (localtb.FQM != 1)) {
            break label534;
          }
          p.g(localObject5, "descTv");
          ((TextView)localObject5).setText((CharSequence)localtb.FQH);
          p.g(localImageView2, "reddot2Iv");
          localImageView2.setVisibility(0);
          p.g(localImageView1, "reddot1Iv");
          localImageView1.setVisibility(8);
          p.g(localTextView2, "newIv");
          localTextView2.setVisibility(8);
        }
        for (;;)
        {
          localObject5 = localtb.FQF;
          if (localObject5 != null)
          {
            p.g(localObject4, "iconIv");
            m.a((ImageView)localObject4, (String)localObject5, false, 0, 0, 0, 124);
          }
          p.g(localTextView1, "titleTv");
          localTextView1.setText((CharSequence)localtb.FQG);
          if (i == ((td)localObject2).FQP.size() - 1)
          {
            localObject4 = localView.findViewById(2131298283);
            p.g(localObject4, "cellView.findViewById<Vi…header_cell_divider_view)");
            ((View)localObject4).setVisibility(8);
          }
          localView.setOnClickListener((View.OnClickListener)new j(this, localtb));
          ((LinearLayout)localObject1).addView(localView);
          i += 1;
          break;
          j = 0;
          break label326;
          label534:
          if (localtb.FQN == 1)
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
          else if (localtb.FQM == 1)
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
      localObject2 = this.oMI;
      if (localObject2 == null) {
        p.bcb("mHeaderContainerLayout");
      }
      ((ViewGroup)localObject2).addView((View)localObject1, (ViewGroup.LayoutParams)localLayoutParams);
    }
    AppMethodBeat.o(215499);
  }
  
  private final void bYg()
  {
    AppMethodBeat.i(215497);
    if (this.oMM.isEmpty())
    {
      localObject = this.oMK;
      if (localObject == null) {
        p.bcb("mHomePageEmptyView");
      }
      ((View)localObject).setVisibility(0);
      localObject = this.oMJ;
      if (localObject == null) {
        p.bcb("mHomePageRecentlyUsedCardTitleTv");
      }
      ((TextView)localObject).setVisibility(8);
      AppMethodBeat.o(215497);
      return;
    }
    Object localObject = this.oMK;
    if (localObject == null) {
      p.bcb("mHomePageEmptyView");
    }
    ((View)localObject).setVisibility(8);
    localObject = this.oMJ;
    if (localObject == null) {
      p.bcb("mHomePageRecentlyUsedCardTitleTv");
    }
    ((TextView)localObject).setVisibility(0);
    AppMethodBeat.o(215497);
  }
  
  private final void jx(final boolean paramBoolean)
  {
    int i = 0;
    AppMethodBeat.i(215494);
    ad.i(this.TAG, "do load home page");
    Object localObject;
    if ((this.oMN) && (!paramBoolean))
    {
      ad.w(this.TAG, "already load complete");
      localObject = this.oMG;
      if (localObject == null) {
        p.bcb("mRefreshLayout");
      }
      ((RefreshLoadMoreLayout)localObject).afZ(0);
      AppMethodBeat.o(215494);
      return;
    }
    if (this.llo)
    {
      ad.w(this.TAG, "is loading");
      AppMethodBeat.o(215494);
      return;
    }
    this.llo = true;
    int j = this.fq;
    if (paramBoolean)
    {
      localObject = this.oMG;
      if (localObject == null) {
        p.bcb("mRefreshLayout");
      }
      ((RefreshLoadMoreLayout)localObject).setHasBottomMore(true);
    }
    for (;;)
    {
      localObject = new com.tencent.mm.plugin.card.model.b.c(i).aED();
      p.g(localObject, "CgiGetMktCardHomePageV3(offset, 10).run()");
      com.tencent.mm.ad.c.b((com.tencent.mm.vending.g.c)localObject, (d.g.a.b)new d(this, paramBoolean));
      AppMethodBeat.o(215494);
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
    AppMethodBeat.i(215490);
    Object localObject1 = findViewById(2131298315);
    p.g(localObject1, "findViewById(R.id.chpuv3_rv)");
    this.oMF = ((WxRecyclerView)localObject1);
    localObject1 = findViewById(2131298314);
    p.g(localObject1, "findViewById(R.id.chpuv3_refresh_layout)");
    this.oMG = ((RefreshLoadMoreLayout)localObject1);
    localObject1 = this.oMF;
    if (localObject1 == null) {
      p.bcb("mPageRv");
    }
    getContext();
    ((WxRecyclerView)localObject1).setLayoutManager((RecyclerView.i)new LinearLayoutManager(1));
    this.oML = new WxRecyclerAdapter((com.tencent.mm.view.recyclerview.c)new f(this), this.oMM);
    localObject1 = this.oMF;
    if (localObject1 == null) {
      p.bcb("mPageRv");
    }
    Object localObject2 = this.oML;
    if (localObject2 == null) {
      p.bcb("mPageAdapter");
    }
    ((WxRecyclerView)localObject1).setAdapter((RecyclerView.a)localObject2);
    localObject1 = new w((Context)getContext());
    ((w)localObject1).setDrawable(getResources().getDrawable(2131231470));
    localObject2 = this.oMF;
    if (localObject2 == null) {
      p.bcb("mPageRv");
    }
    ((WxRecyclerView)localObject2).b((RecyclerView.h)localObject1);
    localObject1 = getLayoutInflater();
    localObject2 = this.oMF;
    if (localObject2 == null) {
      p.bcb("mPageRv");
    }
    localObject1 = ((LayoutInflater)localObject1).inflate(2131493302, (ViewGroup)localObject2, false);
    if (localObject1 == null)
    {
      localObject1 = new v("null cannot be cast to non-null type android.view.ViewGroup");
      AppMethodBeat.o(215490);
      throw ((Throwable)localObject1);
    }
    this.oMH = ((ViewGroup)localObject1);
    localObject1 = this.oMH;
    if (localObject1 == null) {
      p.bcb("mHeaderView");
    }
    localObject1 = ((ViewGroup)localObject1).findViewById(2131298286);
    p.g(localObject1, "mHeaderView.findViewById…_header_container_layout)");
    this.oMI = ((ViewGroup)localObject1);
    localObject1 = this.oMH;
    if (localObject1 == null) {
      p.bcb("mHeaderView");
    }
    localObject1 = ((ViewGroup)localObject1).findViewById(2131298288);
    p.g(localObject1, "mHeaderView.findViewById…hphv3_home_page_title_tv)");
    this.oMJ = ((TextView)localObject1);
    localObject1 = this.oMH;
    if (localObject1 == null) {
      p.bcb("mHeaderView");
    }
    localObject1 = ((ViewGroup)localObject1).findViewById(2131298287);
    p.g(localObject1, "mHeaderView.findViewById…3_home_page_empty_layout)");
    this.oMK = ((View)localObject1);
    localObject1 = this.oML;
    if (localObject1 == null) {
      p.bcb("mPageAdapter");
    }
    localObject2 = this.oMH;
    if (localObject2 == null) {
      p.bcb("mHeaderView");
    }
    ((WxRecyclerAdapter)localObject1).f((View)localObject2, oMU, false);
    localObject1 = this.oMG;
    if (localObject1 == null) {
      p.bcb("mRefreshLayout");
    }
    ((RefreshLoadMoreLayout)localObject1).setEnableRefresh(false);
    localObject1 = this.oMG;
    if (localObject1 == null) {
      p.bcb("mRefreshLayout");
    }
    int i = com.tencent.mm.cc.a.fromDPToPix((Context)getContext(), 1200);
    localObject2 = aj.getContext();
    p.g(localObject2, "MMApplicationContext.getContext()");
    ((RefreshLoadMoreLayout)localObject1).setLimitTopRequest(i - (int)((Context)localObject2).getResources().getDimension(2131165277));
    localObject1 = this.oMG;
    if (localObject1 == null) {
      p.bcb("mRefreshLayout");
    }
    localObject2 = aj.getContext();
    p.g(localObject2, "MMApplicationContext.getContext()");
    ((RefreshLoadMoreLayout)localObject1).setRefreshTargetY((int)((Context)localObject2).getResources().getDimension(2131165299) - com.tencent.mm.cc.a.fromDPToPix((Context)getContext(), 1200));
    localObject1 = this.oMG;
    if (localObject1 == null) {
      p.bcb("mRefreshLayout");
    }
    ((RefreshLoadMoreLayout)localObject1).setDamping(1.85F);
    localObject1 = this.oMG;
    if (localObject1 == null) {
      p.bcb("mRefreshLayout");
    }
    ((RefreshLoadMoreLayout)localObject1).setActionCallback((RefreshLoadMoreLayout.a)new g(this));
    AppMethodBeat.o(215490);
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(215493);
    if (paramInt1 == oMV) {
      jx(true);
    }
    for (;;)
    {
      super.onActivityResult(paramInt1, paramInt2, paramIntent);
      AppMethodBeat.o(215493);
      return;
      if (paramInt1 == oMX) {
        jx(true);
      } else if (paramInt1 == oMW) {
        jx(true);
      } else if (paramInt1 == oMY) {
        jx(true);
      }
    }
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(215489);
    super.onCreate(paramBundle);
    initView();
    setMMTitle(2131756891);
    setActionbarColor(getResources().getColor(2131099648));
    hideActionbarLine();
    setBackBtn((MenuItem.OnMenuItemClickListener)new h(this));
    paramBundle = com.tencent.mm.plugin.card.model.a.a.oAY;
    paramBundle = com.tencent.mm.plugin.card.model.a.a.a.bVe();
    if (paramBundle != null)
    {
      this.fq = paramBundle.pjW;
      YW(paramBundle.GAu);
      a(paramBundle.GAs);
      a(paramBundle.GAt);
      a(paramBundle.GAp);
    }
    jx(true);
    AppMethodBeat.o(215489);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(215492);
    super.onDestroy();
    if (!this.oMO)
    {
      ad.i(this.TAG, "no data to save snapshot");
      AppMethodBeat.o(215492);
      return;
    }
    bee localbee = new bee();
    localbee.BaseResponse = new BaseResponse();
    localbee.BaseResponse.ErrMsg = new cwt();
    localbee.GAs = this.oMQ;
    Object localObject = this.oMJ;
    if (localObject == null) {
      p.bcb("mHomePageRecentlyUsedCardTitleTv");
    }
    localbee.GAu = ((TextView)localObject).getText().toString();
    localbee.GAt = new sz();
    localbee.pjW = this.fq;
    localbee.GAp = this.oMR;
    localObject = this.oMM.iterator();
    while (((Iterator)localObject).hasNext())
    {
      sy localsy = ((a)((Iterator)localObject).next()).bYj();
      if (localsy != null) {
        localbee.GAt.FQD.add(localsy);
      }
    }
    localObject = com.tencent.mm.plugin.card.model.a.a.oAY;
    p.h(localbee, "response");
    ad.d(com.tencent.mm.plugin.card.model.a.a.access$getTAG$cp(), "save home page v3 snapshot");
    com.tencent.mm.ad.c.b(null, (d.g.a.a)new a.a.c(localbee));
    AppMethodBeat.o(215492);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(215491);
    super.onResume();
    if (this.oMP)
    {
      jx(true);
      this.oMP = false;
    }
    AppMethodBeat.o(215491);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/card/ui/v3/CardHomePageV3UI$CardConvertData;", "Lcom/tencent/mm/view/recyclerview/ConvertData;", "()V", "recentlyUsedCell", "Lcom/tencent/mm/protocal/protobuf/CardHomePageRecentlyUsedCell;", "getRecentlyUsedCell", "()Lcom/tencent/mm/protocal/protobuf/CardHomePageRecentlyUsedCell;", "setRecentlyUsedCell", "(Lcom/tencent/mm/protocal/protobuf/CardHomePageRecentlyUsedCell;)V", "getItemId", "", "getItemType", "", "plugin-card_release"})
  public static final class a
    implements com.tencent.mm.view.recyclerview.a
  {
    public sy oNa;
    
    public final void a(sy paramsy)
    {
      AppMethodBeat.i(215461);
      p.h(paramsy, "<set-?>");
      this.oNa = paramsy;
      AppMethodBeat.o(215461);
    }
    
    public final sy bYj()
    {
      AppMethodBeat.i(215460);
      sy localsy = this.oNa;
      if (localsy == null) {
        p.bcb("recentlyUsedCell");
      }
      AppMethodBeat.o(215460);
      return localsy;
    }
    
    public final int bYk()
    {
      AppMethodBeat.i(215463);
      CardHomePageV3UI.c localc = CardHomePageV3UI.oMZ;
      int i = CardHomePageV3UI.bYi();
      AppMethodBeat.o(215463);
      return i;
    }
    
    public final long lP()
    {
      AppMethodBeat.i(215462);
      sy localsy = this.oNa;
      if (localsy == null) {
        p.bcb("recentlyUsedCell");
      }
      long l = localsy.dHX.hashCode();
      AppMethodBeat.o(215462);
      return l;
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/card/ui/v3/CardHomePageV3UI$CardConverter;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "Lcom/tencent/mm/plugin/card/ui/v3/CardHomePageV3UI$CardConvertData;", "(Lcom/tencent/mm/plugin/card/ui/v3/CardHomePageV3UI;)V", "clearShadowLayer", "", "textview", "Landroid/widget/TextView;", "getLayoutId", "", "onBindViewHolder", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "position", "type", "isHotPatch", "", "payloads", "", "", "onCreateViewHolder", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "setShadowLayer", "showDeleteConfirmDialog", "cardId", "", "userCardId", "plugin-card_release"})
  public final class b
    extends com.tencent.mm.view.recyclerview.b<CardHomePageV3UI.a>
  {
    private static void j(TextView paramTextView)
    {
      AppMethodBeat.i(215474);
      paramTextView.setShadowLayer(0.0F, 0.0F, 0.0F, 0);
      AppMethodBeat.o(215474);
    }
    
    private final void k(TextView paramTextView)
    {
      AppMethodBeat.i(215475);
      paramTextView.setShadowLayer(com.tencent.mm.cc.a.fromDPToPix(paramTextView.getContext(), 4), 0.0F, 0.0F, this.oNb.getResources().getColor(2131099817));
      AppMethodBeat.o(215475);
    }
    
    public final void a(RecyclerView paramRecyclerView, final com.tencent.mm.view.recyclerview.e parame, int paramInt)
    {
      AppMethodBeat.i(215472);
      p.h(paramRecyclerView, "recyclerView");
      p.h(parame, "holder");
      paramRecyclerView = (ViewGroup)parame.Gd(2131298309);
      paramRecyclerView.setOnClickListener((View.OnClickListener)new c(this, parame));
      paramRecyclerView.setOnLongClickListener((View.OnLongClickListener)new d(this, parame));
      AppMethodBeat.o(215472);
    }
    
    public final int getLayoutId()
    {
      return 2131493303;
    }
    
    @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run"})
    static final class a
      implements Runnable
    {
      a(CardHomePageV3UI.b paramb, com.tencent.mm.view.recyclerview.e parame, d.g.a.a parama) {}
      
      public final void run()
      {
        AppMethodBeat.i(215464);
        CardHomePageV3UI localCardHomePageV3UI = this.oNc.oNb;
        View localView = this.oNd.auu;
        p.g(localView, "holder.itemView");
        CardHomePageV3UI.a(localCardHomePageV3UI, localView.getHeight());
        this.oNe.invoke();
        AppMethodBeat.o(215464);
      }
    }
    
    @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
    static final class b
      extends q
      implements d.g.a.a<z>
    {
      b(CardHomePageV3UI.b paramb, MemberCardTopCropImageView paramMemberCardTopCropImageView, CardHomePageV3UI.a parama, com.tencent.mm.view.recyclerview.e parame)
      {
        super();
      }
    }
    
    @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class c
      implements View.OnClickListener
    {
      c(CardHomePageV3UI.b paramb, com.tencent.mm.view.recyclerview.e parame) {}
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(215466);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/card/ui/v3/CardHomePageV3UI$CardConverter$onCreateViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
        paramView = (CardHomePageV3UI.a)parame.fQC();
        String str;
        switch (paramView.bYj().FQa)
        {
        default: 
          ad.w(CardHomePageV3UI.a(this.oNc.oNb), "unknown type " + paramView.bYj().FQa);
          localObject = this.oNc.oNb;
          str = paramView.bYj().FrW;
          p.g(str, "cardConvertData.recentlyUsedCell.user_card_id");
          CardHomePageV3UI.a((CardHomePageV3UI)localObject, str);
        }
        for (;;)
        {
          g.yhR.f(19674, new Object[] { Integer.valueOf(1), Integer.valueOf(paramView.bYj().mrl), paramView.bYj().FrW, Long.valueOf(System.currentTimeMillis() / 1000L) });
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/card/ui/v3/CardHomePageV3UI$CardConverter$onCreateViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(215466);
          return;
          com.tencent.mm.plugin.card.d.b.a((MMActivity)this.oNc.oNb.getContext(), paramView.bYj().FQb);
          continue;
          localObject = paramView.bYj().FQc;
          if (localObject != null)
          {
            com.tencent.mm.plugin.card.d.b.I(((tg)localObject).CzQ, ((tg)localObject).CzR, ((tg)localObject).Dhk);
            continue;
            localObject = this.oNc.oNb;
            str = paramView.bYj().FrW;
            p.g(str, "cardConvertData.recentlyUsedCell.user_card_id");
            CardHomePageV3UI.a((CardHomePageV3UI)localObject, str);
          }
        }
      }
    }
    
    @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onLongClick"})
    static final class d
      implements View.OnLongClickListener
    {
      d(CardHomePageV3UI.b paramb, com.tencent.mm.view.recyclerview.e parame) {}
      
      public final boolean onLongClick(View paramView)
      {
        AppMethodBeat.i(215469);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/card/ui/v3/CardHomePageV3UI$CardConverter$onCreateViewHolder$2", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
        final CardHomePageV3UI.a locala = (CardHomePageV3UI.a)parame.fQC();
        localObject = new com.tencent.mm.ui.widget.b.a((Context)this.oNc.oNb.getContext(), paramView);
        ((com.tencent.mm.ui.widget.b.a)localObject).a((View.OnCreateContextMenuListener)new View.OnCreateContextMenuListener()
        {
          public final void onCreateContextMenu(ContextMenu paramAnonymousContextMenu, View paramAnonymousView, ContextMenu.ContextMenuInfo paramAnonymousContextMenuInfo)
          {
            AppMethodBeat.i(215467);
            paramAnonymousContextMenu.add(0, 1, 0, (CharSequence)this.oNh.oNc.oNb.getString(2131760291));
            AppMethodBeat.o(215467);
          }
        });
        ((com.tencent.mm.ui.widget.b.a)localObject).a((n.e)new n.e()
        {
          public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
          {
            AppMethodBeat.i(215468);
            paramAnonymousMenuItem = this.oNh.oNc;
            String str1 = locala.bYj().dHX;
            p.g(str1, "cardConvertData.recentlyUsedCell.card_id");
            String str2 = locala.bYj().FrW;
            p.g(str2, "cardConvertData.recentlyUsedCell.user_card_id");
            com.tencent.mm.ui.widget.a.e locale = new com.tencent.mm.ui.widget.a.e((Context)paramAnonymousMenuItem.oNb.getContext(), 1, true);
            TextView localTextView = new TextView((Context)paramAnonymousMenuItem.oNb.getContext());
            localTextView.setText((CharSequence)paramAnonymousMenuItem.oNb.getString(2131756890));
            localTextView.setTextSize(1, 14.0F);
            localTextView.setTextColor(paramAnonymousMenuItem.oNb.getResources().getColor(2131100482));
            localTextView.setGravity(17);
            paramAnonymousInt = paramAnonymousMenuItem.oNb.getResources().getDimensionPixelSize(2131165303);
            int i = paramAnonymousMenuItem.oNb.getResources().getDimensionPixelSize(2131165289);
            localTextView.setPadding(paramAnonymousInt, i, paramAnonymousInt, i);
            locale.K((View)localTextView, false);
            locale.a((n.d)new CardHomePageV3UI.b.e(paramAnonymousMenuItem));
            locale.a((n.e)new CardHomePageV3UI.b.f(paramAnonymousMenuItem, str1, str2));
            locale.cMW();
            g.yhR.f(19674, new Object[] { Integer.valueOf(2), Integer.valueOf(locala.bYj().mrl), locala.bYj().FrW, Long.valueOf(System.currentTimeMillis() / 1000L) });
            AppMethodBeat.o(215468);
          }
        });
        p.g(paramView, "it");
        paramView = m.dJ(paramView);
        ((com.tencent.mm.ui.widget.b.a)localObject).el(paramView.x, paramView.y);
        com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/card/ui/v3/CardHomePageV3UI$CardConverter$onCreateViewHolder$2", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
        AppMethodBeat.o(215469);
        return false;
      }
    }
    
    @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Lcom/tencent/mm/ui/base/MMMenu;", "kotlin.jvm.PlatformType", "onCreateMMMenu"})
    static final class e
      implements n.d
    {
      e(CardHomePageV3UI.b paramb) {}
      
      public final void onCreateMMMenu(com.tencent.mm.ui.base.l paraml)
      {
        AppMethodBeat.i(215470);
        paraml.a(1, this.oNc.oNb.getResources().getColor(2131100800), (CharSequence)this.oNc.oNb.getString(2131755835));
        AppMethodBeat.o(215470);
      }
    }
    
    @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "menuItem", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "", "onMMMenuItemSelected"})
    static final class f
      implements n.e
    {
      f(CardHomePageV3UI.b paramb, String paramString1, String paramString2) {}
      
      public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
      {
        AppMethodBeat.i(215471);
        p.g(paramMenuItem, "menuItem");
        switch (paramMenuItem.getItemId())
        {
        }
        for (;;)
        {
          AppMethodBeat.o(215471);
          return;
          paramMenuItem = this.oNc.oNb;
          Object localObject = this.oLV;
          String str = this.oNj;
          p.h(localObject, "cardId");
          p.h(str, "userCardId");
          ad.i(paramMenuItem.TAG, "do remove recently: " + (String)localObject + ", " + str);
          localObject = new d((String)localObject, str).aEC().aED();
          p.g(localObject, "CgiRemoveCardInRecentlyU…ntCancelAfterDead().run()");
          com.tencent.mm.ad.c.b((com.tencent.mm.vending.g.c)localObject, (d.g.a.b)new CardHomePageV3UI.e(paramMenuItem, str)).b((com.tencent.mm.vending.e.b)paramMenuItem);
        }
      }
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/GetMktCardHomePageV2Response;", "kotlin.jvm.PlatformType", "invoke"})
  static final class d
    extends q
    implements d.g.a.b<com.tencent.mm.al.a.a<bee>, z>
  {
    d(CardHomePageV3UI paramCardHomePageV3UI, boolean paramBoolean)
    {
      super();
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/RemoveCardInRecentlyUsedListResponse;", "kotlin.jvm.PlatformType", "invoke", "(Lcom/tencent/mm/modelbase/Cgi$CgiBack;)Lkotlin/Unit;"})
  static final class e
    extends q
    implements d.g.a.b<com.tencent.mm.al.a.a<cti>, z>
  {
    e(CardHomePageV3UI paramCardHomePageV3UI, String paramString)
    {
      super();
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/card/ui/v3/CardHomePageV3UI$initView$1", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "getItemConvert", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "type", "", "plugin-card_release"})
  public static final class f
    implements com.tencent.mm.view.recyclerview.c
  {
    public final com.tencent.mm.view.recyclerview.b<?> AL(int paramInt)
    {
      AppMethodBeat.i(215478);
      com.tencent.mm.view.recyclerview.b localb = (com.tencent.mm.view.recyclerview.b)new CardHomePageV3UI.b(this.oNb);
      AppMethodBeat.o(215478);
      return localb;
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/card/ui/v3/CardHomePageV3UI$initView$2", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback;", "onLoadMoreBegin", "", "onLoadMoreEnd", "reason", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;", "", "onRefreshBegin", "refreshType", "", "onRefreshEnd", "plugin-card_release"})
  public static final class g
    extends RefreshLoadMoreLayout.a
  {
    public final void AM(int paramInt)
    {
      AppMethodBeat.i(215482);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.mr(paramInt);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/card/ui/v3/CardHomePageV3UI$initView$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshBegin", "(I)V", this, localb.ahq());
      ad.d(CardHomePageV3UI.a(this.oNb), "on begin refresh");
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/card/ui/v3/CardHomePageV3UI$initView$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshBegin", "(I)V");
      AppMethodBeat.o(215482);
    }
    
    public final void a(RefreshLoadMoreLayout.c<Object> paramc)
    {
      AppMethodBeat.i(215481);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bd(paramc);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/card/ui/v3/CardHomePageV3UI$initView$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V", this, localb.ahq());
      p.h(paramc, "reason");
      ad.d(CardHomePageV3UI.a(this.oNb), "on load more end: " + CardHomePageV3UI.d(this.oNb));
      if (CardHomePageV3UI.e(this.oNb)) {
        CardHomePageV3UI.f(this.oNb).k(null);
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/card/ui/v3/CardHomePageV3UI$initView$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V");
      AppMethodBeat.o(215481);
    }
    
    public final void b(RefreshLoadMoreLayout.c<Object> paramc)
    {
      AppMethodBeat.i(215483);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bd(paramc);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/card/ui/v3/CardHomePageV3UI$initView$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V", this, localb.ahq());
      p.h(paramc, "reason");
      ad.d(CardHomePageV3UI.a(this.oNb), "on refresh end");
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/card/ui/v3/CardHomePageV3UI$initView$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V");
      AppMethodBeat.o(215483);
    }
    
    public final void bYl()
    {
      AppMethodBeat.i(215480);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/card/ui/v3/CardHomePageV3UI$initView$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreBegin", "()V", this);
      ad.d(CardHomePageV3UI.a(this.oNb), "on load more");
      com.tencent.mm.ad.c.g((d.g.a.a)new a(this));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/card/ui/v3/CardHomePageV3UI$initView$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreBegin", "()V");
      AppMethodBeat.o(215480);
    }
    
    @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
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
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class h
    implements MenuItem.OnMenuItemClickListener
  {
    h(CardHomePageV3UI paramCardHomePageV3UI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(215484);
      this.oNb.finish();
      AppMethodBeat.o(215484);
      return false;
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick", "com/tencent/mm/plugin/card/ui/v3/CardHomePageV3UI$updateFAQ$1$1"})
  static final class i
    implements MenuItem.OnMenuItemClickListener
  {
    i(sx paramsx, CardHomePageV3UI paramCardHomePageV3UI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(215487);
      paramMenuItem = new com.tencent.mm.ui.widget.a.e((Context)jdField_this.getContext(), 1, false);
      paramMenuItem.a((n.d)new n.d()
      {
        public final void onCreateMMMenu(com.tencent.mm.ui.base.l paramAnonymousl)
        {
          AppMethodBeat.i(215485);
          paramAnonymousl.add(0, 0, 1, (CharSequence)this.oNm.oLM.FQy);
          AppMethodBeat.o(215485);
        }
      });
      paramMenuItem.a((n.e)new n.e()
      {
        public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
        {
          AppMethodBeat.i(215486);
          p.g(paramAnonymousMenuItem, "menuItem");
          if (paramAnonymousMenuItem.getItemId() == 0) {
            switch (this.oNm.oLM.FQz)
            {
            }
          }
          for (;;)
          {
            AppMethodBeat.o(215486);
            return;
            com.tencent.mm.plugin.card.d.b.a((MMActivity)this.oNm.oNb.getContext(), this.oNm.oLM.FQA);
            AppMethodBeat.o(215486);
            return;
            paramAnonymousMenuItem = this.oNm.oLM.FQB;
            com.tencent.mm.plugin.card.d.b.I(paramAnonymousMenuItem.CzQ, paramAnonymousMenuItem.CzR, paramAnonymousMenuItem.Dhk);
          }
        }
      });
      paramMenuItem.cMW();
      AppMethodBeat.o(215487);
      return false;
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class j
    implements View.OnClickListener
  {
    j(CardHomePageV3UI paramCardHomePageV3UI, tb paramtb) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(215488);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/card/ui/v3/CardHomePageV3UI$updateHeader$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
      switch (localtb.FQI)
      {
      default: 
        ad.w(CardHomePageV3UI.a(this.oNb), "unknown type " + localtb.FQI);
      }
      for (;;)
      {
        g.yhR.f(19673, new Object[] { localtb.FQG, Long.valueOf(System.currentTimeMillis() / 1000L) });
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/card/ui/v3/CardHomePageV3UI$updateHeader$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(215488);
        return;
        com.tencent.mm.plugin.card.d.b.a((MMActivity)this.oNb.getContext(), localtb.FQJ);
        continue;
        paramView = localtb.FQK;
        if (paramView != null)
        {
          com.tencent.mm.plugin.card.d.b.I(paramView.CzQ, paramView.CzR, paramView.Dhk);
          CardHomePageV3UI.k(this.oNb);
          continue;
          if ("weixin://mktcard/cert".equals(localtb.FQL)) {
            CardHomePageV3UI.l(this.oNb);
          } else if ("weixin://mktcard/membercard".equals(localtb.FQL)) {
            CardHomePageV3UI.m(this.oNb);
          } else if ("weixin://mktcard/coupon".equals(localtb.FQL)) {
            CardHomePageV3UI.d(this.oNb, localtb.FQG);
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