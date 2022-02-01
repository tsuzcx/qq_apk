package com.tencent.mm.plugin.card.ui.v3;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.i;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.card.model.a.a.a.a;
import com.tencent.mm.plugin.card.model.a.a.a.b;
import com.tencent.mm.plugin.card.ui.v2.CardNewBaseUI;
import com.tencent.mm.plugin.card.widget.CardTagTextView;
import com.tencent.mm.plugin.card.widget.MemberCardTopCropImageView;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.azv;
import com.tencent.mm.protocal.protobuf.cwt;
import com.tencent.mm.protocal.protobuf.ss;
import com.tencent.mm.protocal.protobuf.st;
import com.tencent.mm.protocal.protobuf.sw;
import com.tencent.mm.protocal.protobuf.ta;
import com.tencent.mm.protocal.protobuf.tg;
import com.tencent.mm.protocal.protobuf.to;
import com.tencent.mm.protocal.protobuf.tp;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.n.e;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.RefreshLoadMoreLayout.a;
import com.tencent.mm.view.RefreshLoadMoreLayout.c;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.mm.view.recyclerview.WxRecyclerView;
import d.g.b.p;
import d.g.b.q;
import d.g.b.y.f;
import d.v;
import d.z;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/card/ui/v3/CouponCardListUI;", "Lcom/tencent/mm/plugin/card/ui/v2/CardNewBaseUI;", "()V", "TAG", "", "loadCount", "", "mCouponCardList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/card/ui/v3/CouponCardListUI$CouponCardConvertData;", "Lkotlin/collections/ArrayList;", "mCouponCardListAdapter", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "mCouponCardListRv", "Lcom/tencent/mm/view/recyclerview/WxRecyclerView;", "mCurrentSortInfo", "mCurrentSortWording", "mEmptyView", "Landroid/view/ViewGroup;", "mFirstLoad", "", "mHasLoadedSuccess", "mHeaderView", "mHistoryEntranceWording", "mHistoryMiniAppInfo", "Lcom/tencent/mm/protocal/protobuf/CardMiniAppInfo;", "mIsAll", "mIsLoading", "mNeedRefreshMch", "mOffset", "mPreviousSortInfo", "mRefreshLayout", "Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "mReqNum", "mScene", "mSortInfoList", "Lcom/tencent/mm/protocal/protobuf/CardSortInfoList;", "mSortTv", "Landroid/widget/TextView;", "mViewHeight", "mVisitMchId", "mVisitMchTime", "", "doDeleteVipCard", "", "merchantId", "cardId", "doGetMchInfo", "doLoadCouponCardList", "refresh", "getLayoutId", "gotoCardDetailUI", "initView", "loadSnapshot", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onFinishLocationThings", "ret", "isLocationOk", "onResume", "saveSnapshot", "showSortDialog", "updateIconMenu", "updateSortView", "updateViewByResp", "resp", "Lcom/tencent/mm/protocal/protobuf/GetCouponHomePageResponse;", "CardSpan", "Companion", "CouponCardConvertData", "CouponCardConverter", "plugin-card_release"})
public final class CouponCardListUI
  extends CardNewBaseUI
{
  public static final CouponCardListUI.b oNC;
  private final String TAG;
  private int aYT;
  private int fq;
  private boolean llo;
  private boolean lvf;
  private int mScene;
  private RefreshLoadMoreLayout oMG;
  private ViewGroup oMH;
  private boolean oMN;
  private boolean oMO;
  private int oMS;
  private ViewGroup oMr;
  private int oNA;
  private int oNB;
  private WxRecyclerView oNo;
  private TextView oNp;
  private WxRecyclerAdapter<c> oNq;
  private final ArrayList<c> oNr;
  private int oNs;
  private boolean oNt;
  private String oNu;
  private long oNv;
  private tg oNw;
  private String oNx;
  private tp oNy;
  private String oNz;
  
  static
  {
    AppMethodBeat.i(215567);
    oNC = new CouponCardListUI.b((byte)0);
    AppMethodBeat.o(215567);
  }
  
  public CouponCardListUI()
  {
    AppMethodBeat.i(215566);
    this.TAG = "MicroMsg.CouponCardListUI";
    this.oNr = new ArrayList();
    this.oNs = 10;
    this.oNu = "";
    this.oNz = "";
    this.lvf = true;
    AppMethodBeat.o(215566);
  }
  
  private final void a(azv paramazv)
  {
    AppMethodBeat.i(215565);
    if ((paramazv.GwZ == null) || (paramazv.GwZ.FQE.isEmpty()))
    {
      AppMethodBeat.o(215565);
      return;
    }
    paramazv = paramazv.GwZ.FQE.iterator();
    while (paramazv.hasNext())
    {
      sw localsw = (sw)paramazv.next();
      c localc = new c();
      p.g(localsw, "cardInfo");
      localc.a(localsw);
      this.oNr.add(localc);
    }
    if (this.oNr.isEmpty())
    {
      paramazv = this.oMr;
      if (paramazv == null) {
        p.bcb("mEmptyView");
      }
      paramazv.setVisibility(0);
    }
    for (;;)
    {
      paramazv = this.oNq;
      if (paramazv == null) {
        p.bcb("mCouponCardListAdapter");
      }
      paramazv.notifyDataSetChanged();
      AppMethodBeat.o(215565);
      return;
      paramazv = this.oMr;
      if (paramazv == null) {
        p.bcb("mEmptyView");
      }
      paramazv.setVisibility(8);
    }
  }
  
  private final void bYm()
  {
    AppMethodBeat.i(215562);
    tg localtg = this.oNw;
    if (localtg != null)
    {
      removeAllOptionMenu();
      addIconOptionMenu(0, 0, 2131690603, (MenuItem.OnMenuItemClickListener)new m(localtg, this));
      AppMethodBeat.o(215562);
      return;
    }
    AppMethodBeat.o(215562);
  }
  
  private final void bYn()
  {
    AppMethodBeat.i(215563);
    int i;
    Object localObject;
    ViewGroup localViewGroup;
    if (this.oNA > 0) {
      if (!((Collection)this.oNr).isEmpty())
      {
        i = 1;
        if (i == 0) {
          break label132;
        }
        localObject = this.oNp;
        if (localObject == null) {
          p.bcb("mSortTv");
        }
        ((TextView)localObject).setText((CharSequence)this.oNz);
        localObject = this.oNq;
        if (localObject == null) {
          p.bcb("mCouponCardListAdapter");
        }
        localViewGroup = this.oMH;
        if (localViewGroup == null) {
          p.bcb("mHeaderView");
        }
        ((WxRecyclerAdapter)localObject).f((View)localViewGroup, 2, false);
      }
    }
    for (;;)
    {
      localObject = this.oNq;
      if (localObject == null) {
        p.bcb("mCouponCardListAdapter");
      }
      ((WxRecyclerAdapter)localObject).notifyDataSetChanged();
      AppMethodBeat.o(215563);
      return;
      i = 0;
      break;
      label132:
      localObject = this.oNq;
      if (localObject == null) {
        p.bcb("mCouponCardListAdapter");
      }
      localViewGroup = this.oMH;
      if (localViewGroup == null) {
        p.bcb("mHeaderView");
      }
      ((WxRecyclerAdapter)localObject).M(localViewGroup.hashCode(), false);
    }
  }
  
  private final void jy(final boolean paramBoolean)
  {
    int i = 0;
    AppMethodBeat.i(215564);
    ad.i(this.TAG, "do load vip card list: " + this.llo + ", " + this.fq + ", " + this.oNA);
    Object localObject;
    if ((this.oMN) && (!paramBoolean))
    {
      ad.w(this.TAG, "already load complete");
      localObject = this.oMG;
      if (localObject == null) {
        p.bcb("mRefreshLayout");
      }
      ((RefreshLoadMoreLayout)localObject).afZ(0);
      AppMethodBeat.o(215564);
      return;
    }
    if (this.llo)
    {
      ad.w(this.TAG, "is loading");
      AppMethodBeat.o(215564);
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
      localObject = new com.tencent.mm.plugin.card.model.b.a(i, this.oNs, this.dyz, this.dAp, this.oNA).aEC().aED();
      p.g(localObject, "CgiGetCouponHomePage(off…ntCancelAfterDead().run()");
      com.tencent.mm.ad.c.b((com.tencent.mm.vending.g.c)localObject, (d.g.a.b)new f(this, paramBoolean)).b((com.tencent.mm.vending.e.b)this);
      AppMethodBeat.o(215564);
      return;
      i = j;
    }
  }
  
  public final void V(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(215561);
    if ((this.lvf) && (this.oNA == 1))
    {
      jy(true);
      AppMethodBeat.o(215561);
      return;
    }
    if (!paramBoolean) {
      bYd();
    }
    AppMethodBeat.o(215561);
  }
  
  public final int getLayoutId()
  {
    return 2131493300;
  }
  
  public final void initView()
  {
    AppMethodBeat.i(215558);
    Object localObject1 = findViewById(2131298323);
    p.g(localObject1, "findViewById(R.id.chpvv3_rv)");
    this.oNo = ((WxRecyclerView)localObject1);
    localObject1 = findViewById(2131298321);
    p.g(localObject1, "findViewById(R.id.chpvv3_refresh_layout)");
    this.oMG = ((RefreshLoadMoreLayout)localObject1);
    localObject1 = findViewById(2131298319);
    p.g(localObject1, "findViewById(R.id.chpvv3_empty_layout)");
    this.oMr = ((ViewGroup)localObject1);
    localObject1 = this.oNo;
    if (localObject1 == null) {
      p.bcb("mCouponCardListRv");
    }
    getContext();
    ((WxRecyclerView)localObject1).setLayoutManager((RecyclerView.i)new LinearLayoutManager(1));
    this.oNq = new WxRecyclerAdapter((com.tencent.mm.view.recyclerview.c)new g(this), this.oNr);
    localObject1 = this.oNo;
    if (localObject1 == null) {
      p.bcb("mCouponCardListRv");
    }
    Object localObject2 = this.oNq;
    if (localObject2 == null) {
      p.bcb("mCouponCardListAdapter");
    }
    ((WxRecyclerView)localObject1).setAdapter((RecyclerView.a)localObject2);
    localObject1 = getLayoutInflater();
    localObject2 = this.oNo;
    if (localObject2 == null) {
      p.bcb("mCouponCardListRv");
    }
    localObject1 = ((LayoutInflater)localObject1).inflate(2131493305, (ViewGroup)localObject2, false);
    if (localObject1 == null)
    {
      localObject1 = new v("null cannot be cast to non-null type android.view.ViewGroup");
      AppMethodBeat.o(215558);
      throw ((Throwable)localObject1);
    }
    this.oMH = ((ViewGroup)localObject1);
    localObject1 = this.oMH;
    if (localObject1 == null) {
      p.bcb("mHeaderView");
    }
    localObject2 = this.oMH;
    if (localObject2 == null) {
      p.bcb("mHeaderView");
    }
    ((ViewGroup)localObject1).setPadding(0, ((ViewGroup)localObject2).getPaddingTop(), 0, com.tencent.mm.cc.a.fromDPToPix((Context)getContext(), 12));
    localObject1 = this.oMH;
    if (localObject1 == null) {
      p.bcb("mHeaderView");
    }
    localObject1 = ((ViewGroup)localObject1).findViewById(2131298325);
    p.g(localObject1, "mHeaderView.findViewById(R.id.chpvv3_sort_tv)");
    this.oNp = ((TextView)localObject1);
    localObject1 = this.oMH;
    if (localObject1 == null) {
      p.bcb("mHeaderView");
    }
    ((ViewGroup)localObject1).setOnClickListener((View.OnClickListener)new h(this));
    localObject1 = this.oNq;
    if (localObject1 == null) {
      p.bcb("mCouponCardListAdapter");
    }
    localObject2 = this.oMH;
    if (localObject2 == null) {
      p.bcb("mHeaderView");
    }
    ((WxRecyclerAdapter)localObject1).f((View)localObject2, 2, false);
    localObject1 = this.oMG;
    if (localObject1 == null) {
      p.bcb("mRefreshLayout");
    }
    ((RefreshLoadMoreLayout)localObject1).setEnableRefresh(false);
    localObject1 = this.oMG;
    if (localObject1 == null) {
      p.bcb("mRefreshLayout");
    }
    ((RefreshLoadMoreLayout)localObject1).setActionCallback((RefreshLoadMoreLayout.a)new i(this));
    AppMethodBeat.o(215558);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(215557);
    super.onCreate(paramBundle);
    initView();
    paramBundle = getIntent().getStringExtra("title");
    Object localObject = (CharSequence)paramBundle;
    int i;
    if ((localObject == null) || (((CharSequence)localObject).length() == 0))
    {
      i = 1;
      if (i != 0) {
        break label301;
      }
      setMMTitle(paramBundle);
    }
    for (;;)
    {
      setActionbarColor(getResources().getColor(2131099648));
      hideActionbarLine();
      setBackBtn((MenuItem.OnMenuItemClickListener)new CouponCardListUI.j(this));
      this.mScene = getIntent().getIntExtra("scene", 0);
      paramBundle = com.tencent.mm.plugin.card.model.a.a.oAY;
      paramBundle = com.tencent.mm.plugin.card.model.a.a.a.bVh();
      if (paramBundle != null)
      {
        this.fq = paramBundle.pjW;
        this.oNy = paramBundle.Gxe;
        this.oNw = paramBundle.Gxa;
        this.oNx = paramBundle.Gxb;
        bYm();
        a(paramBundle);
      }
      paramBundle = com.tencent.mm.plugin.card.model.a.a.oAY;
      paramBundle = com.tencent.mm.plugin.card.model.a.a.a.bVi();
      if (paramBundle != null)
      {
        this.oNA = paramBundle.FRm;
        localObject = paramBundle.FRo;
        p.g(localObject, "cardSortInfo.sort_wording");
        this.oNz = ((String)localObject);
        this.oNs = paramBundle.FRn;
        this.oNB = this.oNA;
      }
      if ((this.oNy == null) || (this.mScene != 1)) {
        break label311;
      }
      paramBundle = this.oNy;
      if (paramBundle == null) {
        p.gfZ();
      }
      paramBundle = paramBundle.FRp.iterator();
      while (paramBundle.hasNext())
      {
        localObject = (to)paramBundle.next();
        if (((to)localObject).FRm == 2)
        {
          this.oNA = 2;
          localObject = ((to)localObject).FRo;
          p.g(localObject, "sortInfo.sort_wording");
          this.oNz = ((String)localObject);
        }
      }
      i = 0;
      break;
      label301:
      setMMTitle(2131756824);
    }
    label311:
    bYn();
    bYn();
    if (this.oNA != 1) {
      jy(true);
    }
    AppMethodBeat.o(215557);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(215560);
    super.onDestroy();
    if (!this.oMO)
    {
      ad.i(this.TAG, "no data to save snapshot");
      AppMethodBeat.o(215560);
      return;
    }
    Object localObject1 = new azv();
    ((azv)localObject1).BaseResponse = new BaseResponse();
    ((azv)localObject1).BaseResponse.ErrMsg = new cwt();
    ((azv)localObject1).GwZ = new ta();
    Object localObject2 = this.oNr.iterator();
    while (((Iterator)localObject2).hasNext())
    {
      sw localsw = ((c)((Iterator)localObject2).next()).bYo();
      if (localsw != null) {
        ((azv)localObject1).GwZ.FQE.add(localsw);
      }
    }
    ((azv)localObject1).Gxe = this.oNy;
    ((azv)localObject1).pjW = this.fq;
    ((azv)localObject1).Gxb = this.oNx;
    ((azv)localObject1).Gxa = this.oNw;
    localObject2 = com.tencent.mm.plugin.card.model.a.a.oAY;
    p.h(localObject1, "response");
    ad.d(com.tencent.mm.plugin.card.model.a.a.access$getTAG$cp(), "save vip card list snapshot");
    com.tencent.mm.ad.c.b(null, (d.g.a.a)new a.a.a((azv)localObject1));
    localObject1 = new to();
    ((to)localObject1).FRm = this.oNA;
    ((to)localObject1).FRo = this.oNz;
    ((to)localObject1).FRn = this.oNs;
    localObject2 = com.tencent.mm.plugin.card.model.a.a.oAY;
    p.h(localObject1, "sortInfo");
    ad.d(com.tencent.mm.plugin.card.model.a.a.access$getTAG$cp(), "save vip card list snapshot");
    com.tencent.mm.ad.c.b(null, (d.g.a.a)new a.a.b((to)localObject1));
    AppMethodBeat.o(215560);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(215559);
    super.onResume();
    ad.i(this.TAG, "do get mch infoset: %s", new Object[] { Boolean.valueOf(this.oNt) });
    if (this.oNt) {
      new com.tencent.mm.plugin.card.model.a.f(this.oNu, this.oNv, this.dyz, this.dAp, this.oNA, 1).aEC().aED().b((com.tencent.mm.vending.c.a)new e(this)).a((com.tencent.mm.vending.e.b)this);
    }
    AppMethodBeat.o(215559);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/card/ui/v3/CouponCardListUI$CouponCardConvertData;", "Lcom/tencent/mm/view/recyclerview/ConvertData;", "(Lcom/tencent/mm/plugin/card/ui/v3/CouponCardListUI;)V", "couponCardInfo", "Lcom/tencent/mm/protocal/protobuf/CardHomePageElement;", "getCouponCardInfo", "()Lcom/tencent/mm/protocal/protobuf/CardHomePageElement;", "setCouponCardInfo", "(Lcom/tencent/mm/protocal/protobuf/CardHomePageElement;)V", "expandState", "", "getExpandState", "()Z", "setExpandState", "(Z)V", "hasRender", "getHasRender", "setHasRender", "getItemId", "", "getItemType", "", "plugin-card_release"})
  public final class c
    implements com.tencent.mm.view.recyclerview.a
  {
    boolean oLb;
    boolean oLc;
    public sw oNE;
    
    public final void a(sw paramsw)
    {
      AppMethodBeat.i(215521);
      p.h(paramsw, "<set-?>");
      this.oNE = paramsw;
      AppMethodBeat.o(215521);
    }
    
    public final int bYk()
    {
      return 1;
    }
    
    public final sw bYo()
    {
      AppMethodBeat.i(215520);
      sw localsw = this.oNE;
      if (localsw == null) {
        p.bcb("couponCardInfo");
      }
      AppMethodBeat.o(215520);
      return localsw;
    }
    
    public final long lP()
    {
      AppMethodBeat.i(215522);
      sw localsw = this.oNE;
      if (localsw == null) {
        p.bcb("couponCardInfo");
      }
      long l = localsw.FQk.hashCode();
      AppMethodBeat.o(215522);
      return l;
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/card/ui/v3/CouponCardListUI$CouponCardConverter;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "Lcom/tencent/mm/plugin/card/ui/v3/CouponCardListUI$CouponCardConvertData;", "Lcom/tencent/mm/plugin/card/ui/v3/CouponCardListUI;", "(Lcom/tencent/mm/plugin/card/ui/v3/CouponCardListUI;)V", "headerClickListener", "Landroid/view/View$OnClickListener;", "addCouponView", "", "view", "Landroid/view/View;", "parentView", "Landroid/view/ViewGroup;", "appendCouponView", "offset", "", "len", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "position", "collapseCouponLayout", "expandCouponLayout", "getLayoutId", "onBindViewHolder", "type", "isHotPatch", "", "payloads", "", "", "onCreateViewHolder", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "showCollapseLayout", "showExpandLayout", "showMiniAppLayout", "updateCardLabelLayout", "couponLabelList", "", "Lcom/tencent/mm/protocal/protobuf/CardElementCouponLabel;", "labelLayout", "Landroid/widget/LinearLayout;", "updateExpandLayout", "isExpended", "plugin-card_release"})
  public final class d
    extends com.tencent.mm.view.recyclerview.b<CouponCardListUI.c>
  {
    private static void a(com.tencent.mm.view.recyclerview.e parame, CouponCardListUI.c paramc)
    {
      AppMethodBeat.i(215534);
      paramc = paramc.bYo();
      TextView localTextView = (TextView)parame.Gd(2131298296);
      ImageView localImageView = (ImageView)parame.Gd(2131298294);
      parame = (ViewGroup)parame.Gd(2131298295);
      if (!bt.isNullOrNil(paramc.FQq))
      {
        if (!bt.isNullOrNil(paramc.FQr)) {
          localTextView.setTextColor(Color.parseColor(paramc.FQr));
        }
        p.g(localTextView, "chpiExpandTv");
        localTextView.setText((CharSequence)paramc.FQq);
        localImageView.setImageResource(2131231436);
        parame.setOnClickListener((View.OnClickListener)new i(paramc));
      }
      AppMethodBeat.o(215534);
    }
    
    private final void a(final com.tencent.mm.view.recyclerview.e parame, final CouponCardListUI.c paramc, final int paramInt)
    {
      AppMethodBeat.i(215535);
      sw localsw = paramc.bYo();
      TextView localTextView = (TextView)parame.Gd(2131298296);
      ImageView localImageView = (ImageView)parame.Gd(2131298294);
      ViewGroup localViewGroup = (ViewGroup)parame.Gd(2131298295);
      p.g(localTextView, "chpiExpandTv");
      Resources localResources = aj.getResources();
      if (localsw == null) {
        p.gfZ();
      }
      localTextView.setText((CharSequence)localResources.getString(2131756876, new Object[] { Integer.valueOf(localsw.FQv - localsw.FQw) }));
      localViewGroup.setOnClickListener((View.OnClickListener)new h(this, parame, paramc, paramInt));
      localImageView.setImageResource(2131231497);
      p.g(localImageView, "chpiExpandIv");
      localImageView.setVisibility(0);
      AppMethodBeat.o(215535);
    }
    
    private final void a(List<? extends ss> paramList, LinearLayout paramLinearLayout)
    {
      AppMethodBeat.i(215539);
      paramList = paramList.iterator();
      if (paramList.hasNext())
      {
        ss localss = (ss)paramList.next();
        CardTagTextView localCardTagTextView = new CardTagTextView((Context)this.oND.getContext());
        AppCompatActivity localAppCompatActivity = this.oND.getContext();
        localCardTagTextView.setMinHeight(com.tencent.mm.cc.a.fromDPToPix((Context)localAppCompatActivity, 18));
        localCardTagTextView.setMinWidth(com.tencent.mm.cc.a.fromDPToPix((Context)localAppCompatActivity, 56));
        int i = com.tencent.mm.cc.a.fromDPToPix((Context)localAppCompatActivity, 8);
        int j = com.tencent.mm.cc.a.fromDPToPix((Context)localAppCompatActivity, 4);
        localCardTagTextView.setPadding(i, j, i, j);
        localCardTagTextView.setText((CharSequence)localss.FPG);
        localCardTagTextView.setTextSize(1, 10.0F);
        if (!bt.isNullOrNil(localss.FPH))
        {
          localCardTagTextView.setTextColor(Color.parseColor(localss.FPH));
          label169:
          if (bt.isNullOrNil(localss.FPI)) {
            break label219;
          }
          localCardTagTextView.setFillColor(com.tencent.mm.plugin.card.d.l.cK(localss.FPI, localss.FPL));
        }
        for (;;)
        {
          paramLinearLayout.addView((View)localCardTagTextView);
          break;
          localCardTagTextView.setTextColor(-1);
          break label169;
          label219:
          localCardTagTextView.setFillColor(com.tencent.mm.plugin.card.d.l.eV(-16777216, 26));
        }
      }
      AppMethodBeat.o(215539);
    }
    
    private static void b(View paramView, ViewGroup paramViewGroup)
    {
      AppMethodBeat.i(215540);
      if (paramViewGroup.getChildCount() == 0)
      {
        paramViewGroup.addView(paramView);
        AppMethodBeat.o(215540);
        return;
      }
      ViewGroup.MarginLayoutParams localMarginLayoutParams = new ViewGroup.MarginLayoutParams(-1, com.tencent.mm.cc.a.fromDPToPix(paramViewGroup.getContext(), 84));
      localMarginLayoutParams.topMargin = com.tencent.mm.cc.a.fromDPToPix(paramViewGroup.getContext(), 8);
      paramViewGroup.addView(paramView, (ViewGroup.LayoutParams)new LinearLayout.LayoutParams(localMarginLayoutParams));
      AppMethodBeat.o(215540);
    }
    
    private final void b(final com.tencent.mm.view.recyclerview.e parame, final CouponCardListUI.c paramc, final int paramInt)
    {
      AppMethodBeat.i(215536);
      paramc.bYo();
      TextView localTextView = (TextView)parame.Gd(2131298296);
      ImageView localImageView = (ImageView)parame.Gd(2131298294);
      ViewGroup localViewGroup = (ViewGroup)parame.Gd(2131298295);
      p.g(localTextView, "chpiExpandTv");
      localTextView.setText((CharSequence)aj.getResources().getString(2131756874));
      localViewGroup.setOnClickListener((View.OnClickListener)new g(this, parame, paramc, paramInt));
      localImageView.setImageResource(2131231498);
      p.g(localImageView, "chpiExpandIv");
      localImageView.setVisibility(0);
      AppMethodBeat.o(215536);
    }
    
    final void a(int paramInt1, int paramInt2, com.tencent.mm.view.recyclerview.e parame, final CouponCardListUI.c paramc, final int paramInt3)
    {
      AppMethodBeat.i(215538);
      paramc = paramc.bYo();
      ViewGroup localViewGroup = (ViewGroup)parame.Gd(2131298292);
      final int k = 0;
      Object localObject1 = paramc.FQp;
      p.g(localObject1, "el.card_element_coupon_list");
      localObject1 = ((Iterable)localObject1).iterator();
      int i = 0;
      if (((Iterator)localObject1).hasNext())
      {
        final st localst = (st)((Iterator)localObject1).next();
        int j = i;
        final y.f localf;
        if (k >= paramInt1)
        {
          localf = new y.f();
          if (localst.FPS != 1) {
            break label494;
          }
          p.g(localViewGroup, "chpiCouponLayout");
          localObject2 = LayoutInflater.from(localViewGroup.getContext()).inflate(2131493289, localViewGroup, false);
          if (localObject2 == null)
          {
            parame = new v("null cannot be cast to non-null type android.view.ViewGroup");
            AppMethodBeat.o(215538);
            throw parame;
          }
          localf.MLV = ((ViewGroup)localObject2);
          localObject3 = (TextView)((ViewGroup)localf.MLV).findViewById(2131298279);
          localObject4 = (CdnImageView)((ViewGroup)localf.MLV).findViewById(2131298276);
          localTextView = (TextView)((ViewGroup)localf.MLV).findViewById(2131298277);
          localObject2 = (LinearLayout)((ViewGroup)localf.MLV).findViewById(2131298278);
          if (!bt.isNullOrNil(localst.FPV)) {
            ((TextView)localObject3).setTextColor(com.tencent.mm.plugin.card.d.l.cK(localst.FPV, localst.FPW));
          }
          p.g(localObject3, "titleTv");
          ((TextView)localObject3).setText((CharSequence)localst.FPM);
          ((CdnImageView)localObject4).setUrl(localst.FPT);
          if (!bt.isNullOrNil(localst.FPX)) {
            localTextView.setTextColor(com.tencent.mm.plugin.card.d.l.cK(localst.FPX, localst.FPY));
          }
          p.g(localTextView, "descTv");
          localTextView.setText((CharSequence)localst.FPN);
          localObject3 = localst.FPR;
          p.g(localObject3, "coupon.coupon_label");
          localObject3 = (List)localObject3;
          p.g(localObject2, "labelLayout");
          a((List)localObject3, (LinearLayout)localObject2);
          localViewGroup.getChildCount();
          ((ViewGroup)localf.MLV).setOnClickListener((View.OnClickListener)new a(this, paramc, localst, k, paramInt3));
          ((ViewGroup)localf.MLV).setTag(localst.FrW);
          b((View)localf.MLV, localViewGroup);
        }
        label494:
        while (localst.FPS != 2)
        {
          j = i;
          if (paramInt2 > 0)
          {
            j = i + 1;
            if (j >= paramInt2) {
              break label1061;
            }
          }
          k += 1;
          i = j;
          break;
        }
        p.g(localViewGroup, "chpiCouponLayout");
        Object localObject2 = LayoutInflater.from(localViewGroup.getContext()).inflate(2131493288, localViewGroup, false);
        if (localObject2 == null)
        {
          parame = new v("null cannot be cast to non-null type android.view.ViewGroup");
          AppMethodBeat.o(215538);
          throw parame;
        }
        localf.MLV = ((ViewGroup)localObject2);
        Object localObject4 = (TextView)((ViewGroup)localf.MLV).findViewById(2131298279);
        TextView localTextView = (TextView)((ViewGroup)localf.MLV).findViewById(2131298277);
        localObject2 = (LinearLayout)((ViewGroup)localf.MLV).findViewById(2131298278);
        MemberCardTopCropImageView localMemberCardTopCropImageView = (MemberCardTopCropImageView)((ViewGroup)localf.MLV).findViewById(2131298274);
        Object localObject3 = (ImageView)((ViewGroup)localf.MLV).findViewById(2131298275);
        if (!bt.isNullOrNil(localst.FPV)) {
          ((TextView)localObject4).setTextColor(com.tencent.mm.plugin.card.d.l.cK(localst.FPV, localst.FPW));
        }
        p.g(localObject4, "titleTv");
        ((TextView)localObject4).setText((CharSequence)localst.FPM);
        p.g(localTextView, "descTv");
        localTextView.setText((CharSequence)localst.FPN);
        p.g(localMemberCardTopCropImageView, "bgIv");
        localMemberCardTopCropImageView.setRadius(com.tencent.mm.cc.a.fromDPToPix(localMemberCardTopCropImageView.getContext(), 2));
        if (!bt.isNullOrNil(localst.FPQ))
        {
          localObject4 = ((ViewGroup)localf.MLV).findViewById(2131298274);
          p.g(localObject4, "view.findViewById(R.id.chpc_bg_iv)");
          localObject4 = (d.g.a.a)new d(this, (MemberCardTopCropImageView)localObject4, localst);
          if (CouponCardListUI.b(this.oND) <= 0)
          {
            CouponCardListUI.a(this.oND, ((ViewGroup)localf.MLV).getHeight());
            if (CouponCardListUI.b(this.oND) <= 0)
            {
              parame.auu.post((Runnable)new b(this, localf, (d.g.a.a)localObject4));
              label869:
              p.g(localObject3, "shadowBgIv");
              ((ImageView)localObject3).setVisibility(0);
            }
          }
        }
        for (;;)
        {
          localObject3 = localst.FPR;
          p.g(localObject3, "coupon.coupon_label");
          localObject3 = (List)localObject3;
          p.g(localObject2, "labelLayout");
          a((List)localObject3, (LinearLayout)localObject2);
          localViewGroup.getChildCount();
          ((ViewGroup)localf.MLV).setOnClickListener((View.OnClickListener)new c(this, paramc, localst));
          ((ViewGroup)localf.MLV).setTag(localst.FrW);
          b((View)localf.MLV, localViewGroup);
          break;
          ((d.g.a.a)localObject4).invoke();
          break label869;
          ((d.g.a.a)localObject4).invoke();
          break label869;
          if (!bt.isNullOrNil(localst.FPP))
          {
            localMemberCardTopCropImageView.setImageDrawable((Drawable)new ColorDrawable(Color.parseColor(localst.FPP)));
            p.g(localObject3, "shadowBgIv");
            ((ImageView)localObject3).setVisibility(0);
          }
        }
      }
      label1061:
      AppMethodBeat.o(215538);
    }
    
    public final void a(RecyclerView paramRecyclerView, com.tencent.mm.view.recyclerview.e parame, int paramInt)
    {
      AppMethodBeat.i(215532);
      p.h(paramRecyclerView, "recyclerView");
      p.h(parame, "holder");
      AppMethodBeat.o(215532);
    }
    
    final void a(boolean paramBoolean, com.tencent.mm.view.recyclerview.e parame, CouponCardListUI.c paramc, int paramInt)
    {
      AppMethodBeat.i(215537);
      sw localsw = paramc.bYo();
      if (paramBoolean)
      {
        if (!bt.isNullOrNil(localsw.FQq))
        {
          a(parame, paramc);
          AppMethodBeat.o(215537);
          return;
        }
        b(parame, paramc, paramInt);
        AppMethodBeat.o(215537);
        return;
      }
      a(parame, paramc, paramInt);
      AppMethodBeat.o(215537);
    }
    
    public final int getLayoutId()
    {
      return 2131493299;
    }
    
    @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class a
      implements View.OnClickListener
    {
      a(CouponCardListUI.d paramd, sw paramsw, st paramst, int paramInt1, int paramInt2) {}
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(215523);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/card/ui/v3/CouponCardListUI$CouponCardConverter$appendCouponView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
        CouponCardListUI.a(this.oNF.oND, true);
        paramView = this.oNF.oND;
        localObject = paramc.FQk;
        p.g(localObject, "el.card_pack_merchant_id");
        CouponCardListUI.a(paramView, (String)localObject);
        CouponCardListUI.a(this.oNF.oND, paramc.FQx);
        paramView = this.oNF.oND;
        localObject = localst.FrW;
        p.g(localObject, "coupon.user_card_id");
        CouponCardListUI.b(paramView, (String)localObject);
        g.yhR.f(19748, new Object[] { Integer.valueOf(1), Long.valueOf(System.currentTimeMillis() / 1000L), localst.FrW, Integer.valueOf(k), Integer.valueOf(paramInt3) });
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/card/ui/v3/CouponCardListUI$CouponCardConverter$appendCouponView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(215523);
      }
    }
    
    @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run"})
    static final class b
      implements Runnable
    {
      b(CouponCardListUI.d paramd, y.f paramf, d.g.a.a parama) {}
      
      public final void run()
      {
        AppMethodBeat.i(215524);
        CouponCardListUI.a(this.oNF.oND, ((ViewGroup)localf.MLV).getHeight());
        this.oNe.invoke();
        AppMethodBeat.o(215524);
      }
    }
    
    @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class c
      implements View.OnClickListener
    {
      c(CouponCardListUI.d paramd, sw paramsw, st paramst) {}
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(215525);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/card/ui/v3/CouponCardListUI$CouponCardConverter$appendCouponView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
        CouponCardListUI.a(this.oNF.oND, true);
        paramView = this.oNF.oND;
        localObject = paramc.FQk;
        p.g(localObject, "el.card_pack_merchant_id");
        CouponCardListUI.a(paramView, (String)localObject);
        CouponCardListUI.a(this.oNF.oND, paramc.FQx);
        paramView = this.oNF.oND;
        localObject = localst.FrW;
        p.g(localObject, "coupon.user_card_id");
        CouponCardListUI.b(paramView, (String)localObject);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/card/ui/v3/CouponCardListUI$CouponCardConverter$appendCouponView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(215525);
      }
    }
    
    @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke", "()Lkotlin/Unit;"})
    static final class d
      extends q
      implements d.g.a.a<z>
    {
      d(CouponCardListUI.d paramd, MemberCardTopCropImageView paramMemberCardTopCropImageView, st paramst)
      {
        super();
      }
    }
    
    @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class e
      implements View.OnClickListener
    {
      e(CouponCardListUI.d paramd, com.tencent.mm.view.recyclerview.e parame) {}
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(215527);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/card/ui/v3/CouponCardListUI$CouponCardConverter$onBindViewHolder$headerClickListener$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
        ad.i(CouponCardListUI.a(this.oNF.oND), "click header view: " + this.oNd.lN());
        paramView = ((CouponCardListUI.c)this.oNd.fQC()).bYo();
        if (paramView != null) {
          switch (paramView.FQa)
          {
          }
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/card/ui/v3/CouponCardListUI$CouponCardConverter$onBindViewHolder$headerClickListener$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(215527);
          return;
          CouponCardListUI.a(this.oNF.oND, true);
          localObject = this.oNF.oND;
          String str = paramView.FQk;
          p.g(str, "card_pack_merchant_id");
          CouponCardListUI.a((CouponCardListUI)localObject, str);
          CouponCardListUI.a(this.oNF.oND, paramView.FQx);
          localObject = this.oNF.oND.getContext();
          if (localObject == null)
          {
            paramView = new v("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
            AppMethodBeat.o(215527);
            throw paramView;
          }
          com.tencent.mm.plugin.card.d.b.a((MMActivity)localObject, paramView.FQb);
          continue;
          CouponCardListUI.a(this.oNF.oND, true);
          localObject = this.oNF.oND;
          str = paramView.FQk;
          p.g(str, "card_pack_merchant_id");
          CouponCardListUI.a((CouponCardListUI)localObject, str);
          CouponCardListUI.a(this.oNF.oND, paramView.FQx);
          paramView = paramView.FQc;
          com.tencent.mm.plugin.card.d.b.I(paramView.CzQ, paramView.CzR, paramView.Dhk);
        }
      }
    }
    
    @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class g
      implements View.OnClickListener
    {
      g(CouponCardListUI.d paramd, com.tencent.mm.view.recyclerview.e parame, CouponCardListUI.c paramc, int paramInt) {}
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(215529);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/card/ui/v3/CouponCardListUI$CouponCardConverter$showCollapseLayout$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
        ad.d("MicroMsg.CardHomePageNewUI", "do collapse coupon layout");
        paramView = this.oNF;
        localObject = parame;
        CouponCardListUI.c localc = paramc;
        int j = paramInt;
        sw localsw = localc.bYo();
        ViewGroup localViewGroup = (ViewGroup)((com.tencent.mm.view.recyclerview.e)localObject).Gd(2131298292);
        p.g(localViewGroup, "chpiCouponLayout");
        if (localViewGroup.getChildCount() > localsw.FQw)
        {
          String str = CouponCardListUI.a(paramView.oND);
          int i = localViewGroup.getChildCount();
          if (localsw == null) {
            p.gfZ();
          }
          ad.d(str, "collapse count: %s, limit: %s", new Object[] { Integer.valueOf(i), Integer.valueOf(localsw.FQw) });
          i = localViewGroup.getChildCount() - 1;
          int k = localsw.FQw;
          if (i >= k) {
            for (;;)
            {
              localViewGroup.removeViewAt(i);
              if (i == k) {
                break;
              }
              i -= 1;
            }
          }
        }
        paramView.a(false, (com.tencent.mm.view.recyclerview.e)localObject, localc, j);
        paramc.oLc = false;
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/card/ui/v3/CouponCardListUI$CouponCardConverter$showCollapseLayout$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(215529);
      }
    }
    
    @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class h
      implements View.OnClickListener
    {
      h(CouponCardListUI.d paramd, com.tencent.mm.view.recyclerview.e parame, CouponCardListUI.c paramc, int paramInt) {}
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(215530);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/card/ui/v3/CouponCardListUI$CouponCardConverter$showExpandLayout$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
        ad.d(CouponCardListUI.a(this.oNF.oND), "do expand coupon layout");
        paramView = this.oNF;
        localObject = parame;
        CouponCardListUI.c localc = paramc;
        int i = paramInt;
        sw localsw = localc.bYo();
        ((com.tencent.mm.view.recyclerview.e)localObject).Gd(2131298296);
        ((com.tencent.mm.view.recyclerview.e)localObject).Gd(2131298294);
        ViewGroup localViewGroup1 = (ViewGroup)((com.tencent.mm.view.recyclerview.e)localObject).Gd(2131298295);
        ViewGroup localViewGroup2 = (ViewGroup)((com.tencent.mm.view.recyclerview.e)localObject).Gd(2131298292);
        p.g(localViewGroup2, "chpiCouponLayout");
        int j = localViewGroup2.getChildCount();
        if (localsw == null) {
          p.gfZ();
        }
        if (j < localsw.FQv)
        {
          paramView.a(localsw.FQw, -1, (com.tencent.mm.view.recyclerview.e)localObject, localc, i);
          if (localsw.FQw < localsw.FQv) {
            break label219;
          }
          p.g(localViewGroup1, "chpiExpandLayout");
          localViewGroup1.setVisibility(8);
        }
        for (;;)
        {
          paramc.oLc = true;
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/card/ui/v3/CouponCardListUI$CouponCardConverter$showExpandLayout$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(215530);
          return;
          label219:
          paramView.a(true, (com.tencent.mm.view.recyclerview.e)localObject, localc, i);
        }
      }
    }
    
    @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class i
      implements View.OnClickListener
    {
      i(sw paramsw) {}
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(215531);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/card/ui/v3/CouponCardListUI$CouponCardConverter$showMiniAppLayout$1$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        if (this.oLC.FQs != null) {
          if (this.oLC.FQs == null) {
            break label125;
          }
        }
        label125:
        for (boolean bool = true;; bool = false)
        {
          ad.i("MicroMsg.CardHomePageNewUI", "detail goto mini app %s", new Object[] { Boolean.valueOf(bool) });
          com.tencent.mm.plugin.card.d.b.I(this.oLC.FQs.CzQ, this.oLC.FQs.CzR, this.oLC.FQs.Dhk);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/card/ui/v3/CouponCardListUI$CouponCardConverter$showMiniAppLayout$1$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(215531);
          return;
        }
      }
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/GetCardPkgMchInfoResponse;", "kotlin.jvm.PlatformType", "call"})
  static final class e<_Ret, _Var>
    implements com.tencent.mm.vending.c.a<_Ret, _Var>
  {
    e(CouponCardListUI paramCouponCardListUI) {}
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/GetCouponHomePageResponse;", "kotlin.jvm.PlatformType", "invoke"})
  static final class f
    extends q
    implements d.g.a.b<com.tencent.mm.al.a.a<azv>, z>
  {
    f(CouponCardListUI paramCouponCardListUI, boolean paramBoolean)
    {
      super();
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/card/ui/v3/CouponCardListUI$initView$1", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "getItemConvert", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "type", "", "plugin-card_release"})
  public static final class g
    implements com.tencent.mm.view.recyclerview.c
  {
    public final com.tencent.mm.view.recyclerview.b<?> AL(int paramInt)
    {
      AppMethodBeat.i(215543);
      com.tencent.mm.view.recyclerview.b localb = (com.tencent.mm.view.recyclerview.b)new CouponCardListUI.d(this.oND);
      AppMethodBeat.o(215543);
      return localb;
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class h
    implements View.OnClickListener
  {
    h(CouponCardListUI paramCouponCardListUI) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(215544);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/card/ui/v3/CouponCardListUI$initView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
      ad.d(CouponCardListUI.a(this.oND), "click header view");
      CouponCardListUI.c(this.oND);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/card/ui/v3/CouponCardListUI$initView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(215544);
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/card/ui/v3/CouponCardListUI$initView$3", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback;", "onLoadMoreBegin", "", "onLoadMoreEnd", "reason", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;", "", "plugin-card_release"})
  public static final class i
    extends RefreshLoadMoreLayout.a
  {
    public final void AM(int paramInt)
    {
      AppMethodBeat.i(215548);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.mr(paramInt);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/card/ui/v3/CouponCardListUI$initView$3", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshBegin", "(I)V", this, localb.ahq());
      super.AM(paramInt);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/card/ui/v3/CouponCardListUI$initView$3", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshBegin", "(I)V");
      AppMethodBeat.o(215548);
    }
    
    public final void a(RefreshLoadMoreLayout.c<Object> paramc)
    {
      AppMethodBeat.i(215547);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bd(paramc);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/card/ui/v3/CouponCardListUI$initView$3", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V", this, localb.ahq());
      p.h(paramc, "reason");
      ad.d(CouponCardListUI.a(this.oND), "on load more end: " + CouponCardListUI.d(this.oND));
      if (CouponCardListUI.e(this.oND)) {
        CouponCardListUI.f(this.oND).k(null);
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/card/ui/v3/CouponCardListUI$initView$3", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V");
      AppMethodBeat.o(215547);
    }
    
    public final void b(RefreshLoadMoreLayout.c paramc)
    {
      AppMethodBeat.i(215549);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bd(paramc);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/card/ui/v3/CouponCardListUI$initView$3", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V", this, localb.ahq());
      super.b(paramc);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/card/ui/v3/CouponCardListUI$initView$3", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V");
      AppMethodBeat.o(215549);
    }
    
    public final void bYl()
    {
      AppMethodBeat.i(215546);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/card/ui/v3/CouponCardListUI$initView$3", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreBegin", "()V", this);
      ad.d(CouponCardListUI.a(this.oND), "on load more");
      com.tencent.mm.ad.c.g((d.g.a.a)new a(this));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/card/ui/v3/CouponCardListUI$initView$3", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreBegin", "()V");
      AppMethodBeat.o(215546);
    }
    
    @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
    static final class a
      extends q
      implements d.g.a.a<z>
    {
      a(CouponCardListUI.i parami)
      {
        super();
      }
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "menuItem", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "index", "", "onMMMenuItemSelected"})
  static final class l
    implements n.e
  {
    l(CouponCardListUI paramCouponCardListUI) {}
    
    public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
    {
      AppMethodBeat.i(215553);
      p.g(paramMenuItem, "menuItem");
      paramInt = paramMenuItem.getItemId();
      ad.i(CouponCardListUI.a(this.oND), "click item: %s", new Object[] { Integer.valueOf(paramInt) });
      if (paramInt == 1)
      {
        if (!CouponCardListUI.i(this.oND))
        {
          h.a((Context)this.oND.getContext(), this.oND.getString(2131756893), this.oND.getString(2131761885), this.oND.getString(2131760598), this.oND.getString(2131757558), false, (DialogInterface.OnClickListener)new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(215552);
              this.oNJ.oND.startActivityForResult(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"), 564);
              AppMethodBeat.o(215552);
            }
          }, null);
          AppMethodBeat.o(215553);
          return;
        }
        CouponCardListUI.b(this.oND, CouponCardListUI.k(this.oND));
        CouponCardListUI.c(this.oND, 1);
        CouponCardListUI.d(this.oND, paramMenuItem.getTitle().toString());
        CouponCardListUI.l(this.oND);
        CouponCardListUI.b(this.oND, true);
        g.yhR.f(19747, new Object[] { Integer.valueOf(2), Integer.valueOf(5) });
        AppMethodBeat.o(215553);
        return;
      }
      CouponCardListUI.b(this.oND, CouponCardListUI.k(this.oND));
      CouponCardListUI.c(this.oND, paramInt);
      CouponCardListUI.d(this.oND, paramMenuItem.getTitle().toString());
      CouponCardListUI.l(this.oND);
      CouponCardListUI.b(this.oND, true);
      g.yhR.f(19747, new Object[] { Integer.valueOf(2), Integer.valueOf(6) });
      AppMethodBeat.o(215553);
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick", "com/tencent/mm/plugin/card/ui/v3/CouponCardListUI$updateIconMenu$1$1"})
  static final class m
    implements MenuItem.OnMenuItemClickListener
  {
    m(tg paramtg, CouponCardListUI paramCouponCardListUI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(215556);
      paramMenuItem = new com.tencent.mm.ui.widget.a.e((Context)jdField_this.getContext(), 1, false);
      paramMenuItem.a((n.d)new n.d()
      {
        public final void onCreateMMMenu(com.tencent.mm.ui.base.l paramAnonymousl)
        {
          AppMethodBeat.i(215554);
          paramAnonymousl.add(0, 0, 1, (CharSequence)CouponCardListUI.g(this.oNL.oND));
          AppMethodBeat.o(215554);
        }
      });
      paramMenuItem.a((n.e)new n.e()
      {
        public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
        {
          AppMethodBeat.i(215555);
          p.g(paramAnonymousMenuItem, "menuItem");
          if (paramAnonymousMenuItem.getItemId() == 0)
          {
            com.tencent.mm.plugin.card.d.b.I(this.oNL.oNK.CzQ, this.oNL.oNK.CzR, this.oNL.oNK.Dhk);
            g.yhR.f(19747, new Object[] { Integer.valueOf(2), Integer.valueOf(2) });
          }
          AppMethodBeat.o(215555);
        }
      });
      paramMenuItem.cMW();
      g.yhR.f(19747, new Object[] { Integer.valueOf(2), Integer.valueOf(1) });
      AppMethodBeat.o(215556);
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.v3.CouponCardListUI
 * JD-Core Version:    0.7.0.1
 */