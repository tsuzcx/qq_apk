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
import com.tencent.mm.al.c.a;
import com.tencent.mm.plugin.card.model.a.a.a;
import com.tencent.mm.plugin.card.model.a.a.a.a;
import com.tencent.mm.plugin.card.model.a.a.a.b;
import com.tencent.mm.plugin.card.ui.v2.CardNewBaseUI;
import com.tencent.mm.plugin.card.widget.CardTagTextView;
import com.tencent.mm.plugin.card.widget.MemberCardTopCropImageView;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.ast;
import com.tencent.mm.protocal.protobuf.cmf;
import com.tencent.mm.protocal.protobuf.qp;
import com.tencent.mm.protocal.protobuf.qq;
import com.tencent.mm.protocal.protobuf.qs;
import com.tencent.mm.protocal.protobuf.qw;
import com.tencent.mm.protocal.protobuf.rc;
import com.tencent.mm.protocal.protobuf.rk;
import com.tencent.mm.protocal.protobuf.rl;
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
import d.g.b.v.e;
import d.v;
import d.y;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/card/ui/v3/CouponCardListUI;", "Lcom/tencent/mm/plugin/card/ui/v2/CardNewBaseUI;", "()V", "TAG", "", "loadCount", "", "mCouponCardList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/card/ui/v3/CouponCardListUI$CouponCardConvertData;", "Lkotlin/collections/ArrayList;", "mCouponCardListAdapter", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "mCouponCardListRv", "Lcom/tencent/mm/view/recyclerview/WxRecyclerView;", "mCurrentSortInfo", "mCurrentSortWording", "mEmptyView", "Landroid/view/ViewGroup;", "mFirstLoad", "", "mHasLoadedSuccess", "mHeaderView", "mHistoryEntranceWording", "mHistoryMiniAppInfo", "Lcom/tencent/mm/protocal/protobuf/CardMiniAppInfo;", "mIsAll", "mIsLoading", "mNeedRefreshMch", "mOffset", "mPreviousSortInfo", "mRefreshLayout", "Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "mReqNum", "mScene", "mSortInfoList", "Lcom/tencent/mm/protocal/protobuf/CardSortInfoList;", "mSortTv", "Landroid/widget/TextView;", "mViewHeight", "mVisitMchId", "mVisitMchTime", "", "doDeleteVipCard", "", "merchantId", "cardId", "doGetMchInfo", "doLoadCouponCardList", "refresh", "getLayoutId", "gotoCardDetailUI", "initView", "loadSnapshot", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onFinishLocationThings", "ret", "isLocationOk", "onResume", "saveSnapshot", "showSortDialog", "updateIconMenu", "updateSortView", "updateViewByResp", "resp", "Lcom/tencent/mm/protocal/protobuf/GetCouponHomePageResponse;", "CardSpan", "Companion", "CouponCardConvertData", "CouponCardConverter", "plugin-card_release"})
public final class CouponCardListUI
  extends CardNewBaseUI
{
  public static final CouponCardListUI.b nHf;
  private int LZ;
  private final String TAG;
  private int aNJ;
  private boolean knt;
  private boolean kwQ;
  private int mScene;
  private ViewGroup nFU;
  private WxRecyclerView nGR;
  private TextView nGS;
  private WxRecyclerAdapter<c> nGT;
  private final ArrayList<c> nGU;
  private int nGV;
  private boolean nGW;
  private String nGX;
  private long nGY;
  private rc nGZ;
  private RefreshLoadMoreLayout nGj;
  private ViewGroup nGk;
  private boolean nGq;
  private boolean nGr;
  private int nGv;
  private String nHa;
  private rl nHb;
  private String nHc;
  private int nHd;
  private int nHe;
  
  static
  {
    AppMethodBeat.i(192793);
    nHf = new CouponCardListUI.b((byte)0);
    AppMethodBeat.o(192793);
  }
  
  public CouponCardListUI()
  {
    AppMethodBeat.i(192792);
    this.TAG = "MicroMsg.CouponCardListUI";
    this.nGU = new ArrayList();
    this.nGV = 10;
    this.nGX = "";
    this.nHc = "";
    this.kwQ = true;
    AppMethodBeat.o(192792);
  }
  
  private final void a(ast paramast)
  {
    AppMethodBeat.i(192791);
    if ((paramast.DsR == null) || (paramast.DsR.CQJ.isEmpty()))
    {
      AppMethodBeat.o(192791);
      return;
    }
    paramast = paramast.DsR.CQJ.iterator();
    while (paramast.hasNext())
    {
      qs localqs = (qs)paramast.next();
      c localc = new c();
      k.g(localqs, "cardInfo");
      localc.a(localqs);
      this.nGU.add(localc);
    }
    if (this.nGU.isEmpty())
    {
      paramast = this.nFU;
      if (paramast == null) {
        k.aPZ("mEmptyView");
      }
      paramast.setVisibility(0);
    }
    for (;;)
    {
      paramast = this.nGT;
      if (paramast == null) {
        k.aPZ("mCouponCardListAdapter");
      }
      paramast.notifyDataSetChanged();
      AppMethodBeat.o(192791);
      return;
      paramast = this.nFU;
      if (paramast == null) {
        k.aPZ("mEmptyView");
      }
      paramast.setVisibility(8);
    }
  }
  
  private final void bMw()
  {
    AppMethodBeat.i(192788);
    rc localrc = this.nGZ;
    if (localrc != null)
    {
      removeAllOptionMenu();
      addIconOptionMenu(0, 0, 2131690603, (MenuItem.OnMenuItemClickListener)new m(localrc, this));
      AppMethodBeat.o(192788);
      return;
    }
    AppMethodBeat.o(192788);
  }
  
  private final void bMx()
  {
    AppMethodBeat.i(192789);
    int i;
    Object localObject;
    ViewGroup localViewGroup;
    if (this.nHd > 0) {
      if (!((Collection)this.nGU).isEmpty())
      {
        i = 1;
        if (i == 0) {
          break label132;
        }
        localObject = this.nGS;
        if (localObject == null) {
          k.aPZ("mSortTv");
        }
        ((TextView)localObject).setText((CharSequence)this.nHc);
        localObject = this.nGT;
        if (localObject == null) {
          k.aPZ("mCouponCardListAdapter");
        }
        localViewGroup = this.nGk;
        if (localViewGroup == null) {
          k.aPZ("mHeaderView");
        }
        ((WxRecyclerAdapter)localObject).f((View)localViewGroup, 2, false);
      }
    }
    for (;;)
    {
      localObject = this.nGT;
      if (localObject == null) {
        k.aPZ("mCouponCardListAdapter");
      }
      ((WxRecyclerAdapter)localObject).notifyDataSetChanged();
      AppMethodBeat.o(192789);
      return;
      i = 0;
      break;
      label132:
      localObject = this.nGT;
      if (localObject == null) {
        k.aPZ("mCouponCardListAdapter");
      }
      localViewGroup = this.nGk;
      if (localViewGroup == null) {
        k.aPZ("mHeaderView");
      }
      ((WxRecyclerAdapter)localObject).i(localViewGroup.hashCode(), false);
    }
  }
  
  private final void iK(final boolean paramBoolean)
  {
    int i = 0;
    AppMethodBeat.i(192790);
    ad.i(this.TAG, "do load vip card list: " + this.knt + ", " + this.LZ + ", " + this.nHd);
    Object localObject;
    if ((this.nGq) && (!paramBoolean))
    {
      ad.w(this.TAG, "already load complete");
      localObject = this.nGj;
      if (localObject == null) {
        k.aPZ("mRefreshLayout");
      }
      ((RefreshLoadMoreLayout)localObject).abh(0);
      AppMethodBeat.o(192790);
      return;
    }
    if (this.knt)
    {
      ad.w(this.TAG, "is loading");
      AppMethodBeat.o(192790);
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
      localObject = new com.tencent.mm.plugin.card.model.b.a(i, this.nGV, this.dpb, this.dqQ, this.nHd).auK();
      k.g(localObject, "CgiGetCouponHomePage(off…, mCurrentSortInfo).run()");
      com.tencent.mm.ad.c.b((com.tencent.mm.vending.g.c)localObject, (d.g.a.b)new f(this, paramBoolean)).b((com.tencent.mm.vending.e.b)this);
      AppMethodBeat.o(192790);
      return;
      i = j;
    }
  }
  
  public final void V(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(192787);
    if ((this.kwQ) && (this.nHd == 1))
    {
      iK(true);
      AppMethodBeat.o(192787);
      return;
    }
    if (!paramBoolean) {
      bMl();
    }
    AppMethodBeat.o(192787);
  }
  
  public final int getLayoutId()
  {
    return 2131493300;
  }
  
  public final void initView()
  {
    AppMethodBeat.i(192784);
    Object localObject1 = findViewById(2131298323);
    k.g(localObject1, "findViewById(R.id.chpvv3_rv)");
    this.nGR = ((WxRecyclerView)localObject1);
    localObject1 = findViewById(2131298321);
    k.g(localObject1, "findViewById(R.id.chpvv3_refresh_layout)");
    this.nGj = ((RefreshLoadMoreLayout)localObject1);
    localObject1 = findViewById(2131298319);
    k.g(localObject1, "findViewById(R.id.chpvv3_empty_layout)");
    this.nFU = ((ViewGroup)localObject1);
    localObject1 = this.nGR;
    if (localObject1 == null) {
      k.aPZ("mCouponCardListRv");
    }
    getContext();
    ((WxRecyclerView)localObject1).setLayoutManager((RecyclerView.i)new LinearLayoutManager(1));
    this.nGT = new WxRecyclerAdapter((com.tencent.mm.view.recyclerview.c)new g(this), this.nGU);
    localObject1 = this.nGR;
    if (localObject1 == null) {
      k.aPZ("mCouponCardListRv");
    }
    Object localObject2 = this.nGT;
    if (localObject2 == null) {
      k.aPZ("mCouponCardListAdapter");
    }
    ((WxRecyclerView)localObject1).setAdapter((RecyclerView.a)localObject2);
    localObject1 = getLayoutInflater();
    localObject2 = this.nGR;
    if (localObject2 == null) {
      k.aPZ("mCouponCardListRv");
    }
    localObject1 = ((LayoutInflater)localObject1).inflate(2131493305, (ViewGroup)localObject2, false);
    if (localObject1 == null)
    {
      localObject1 = new v("null cannot be cast to non-null type android.view.ViewGroup");
      AppMethodBeat.o(192784);
      throw ((Throwable)localObject1);
    }
    this.nGk = ((ViewGroup)localObject1);
    localObject1 = this.nGk;
    if (localObject1 == null) {
      k.aPZ("mHeaderView");
    }
    localObject2 = this.nGk;
    if (localObject2 == null) {
      k.aPZ("mHeaderView");
    }
    ((ViewGroup)localObject1).setPadding(0, ((ViewGroup)localObject2).getPaddingTop(), 0, com.tencent.mm.cd.a.fromDPToPix((Context)getContext(), 12));
    localObject1 = this.nGk;
    if (localObject1 == null) {
      k.aPZ("mHeaderView");
    }
    localObject1 = ((ViewGroup)localObject1).findViewById(2131298325);
    k.g(localObject1, "mHeaderView.findViewById(R.id.chpvv3_sort_tv)");
    this.nGS = ((TextView)localObject1);
    localObject1 = this.nGk;
    if (localObject1 == null) {
      k.aPZ("mHeaderView");
    }
    ((ViewGroup)localObject1).setOnClickListener((View.OnClickListener)new h(this));
    localObject1 = this.nGT;
    if (localObject1 == null) {
      k.aPZ("mCouponCardListAdapter");
    }
    localObject2 = this.nGk;
    if (localObject2 == null) {
      k.aPZ("mHeaderView");
    }
    ((WxRecyclerAdapter)localObject1).f((View)localObject2, 2, false);
    localObject1 = this.nGj;
    if (localObject1 == null) {
      k.aPZ("mRefreshLayout");
    }
    ((RefreshLoadMoreLayout)localObject1).setEnableRefresh(false);
    localObject1 = this.nGj;
    if (localObject1 == null) {
      k.aPZ("mRefreshLayout");
    }
    ((RefreshLoadMoreLayout)localObject1).setActionCallback((RefreshLoadMoreLayout.a)new i(this));
    AppMethodBeat.o(192784);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(192783);
    super.onCreate(paramBundle);
    initView();
    setMMTitle(2131756824);
    setActionbarColor(getResources().getColor(2131099648));
    hideActionbarLine();
    setBackBtn((MenuItem.OnMenuItemClickListener)new CouponCardListUI.j(this));
    this.mScene = getIntent().getIntExtra("scene", 0);
    paramBundle = com.tencent.mm.plugin.card.model.a.a.nuE;
    paramBundle = a.a.bJp();
    if (paramBundle != null)
    {
      this.LZ = paramBundle.ocT;
      this.nHb = paramBundle.DsW;
      this.nGZ = paramBundle.DsS;
      this.nHa = paramBundle.DsT;
      bMw();
      a(paramBundle);
    }
    paramBundle = com.tencent.mm.plugin.card.model.a.a.nuE;
    paramBundle = a.a.bJq();
    Object localObject;
    if (paramBundle != null)
    {
      this.nHd = paramBundle.CRs;
      localObject = paramBundle.CRu;
      k.g(localObject, "cardSortInfo.sort_wording");
      this.nHc = ((String)localObject);
      this.nGV = paramBundle.CRt;
      this.nHe = this.nHd;
    }
    if ((this.nHb != null) && (this.mScene == 1))
    {
      paramBundle = this.nHb;
      if (paramBundle == null) {
        k.fvU();
      }
      paramBundle = paramBundle.CRv.iterator();
      while (paramBundle.hasNext())
      {
        localObject = (rk)paramBundle.next();
        if (((rk)localObject).CRs == 2)
        {
          this.nHd = 2;
          localObject = ((rk)localObject).CRu;
          k.g(localObject, "sortInfo.sort_wording");
          this.nHc = ((String)localObject);
        }
      }
    }
    bMx();
    bMx();
    if (this.nHd != 1) {
      iK(true);
    }
    AppMethodBeat.o(192783);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(192786);
    super.onDestroy();
    if (!this.nGr)
    {
      ad.i(this.TAG, "no data to save snapshot");
      AppMethodBeat.o(192786);
      return;
    }
    Object localObject1 = new ast();
    ((ast)localObject1).BaseResponse = new BaseResponse();
    ((ast)localObject1).BaseResponse.ErrMsg = new cmf();
    ((ast)localObject1).DsR = new qw();
    Object localObject2 = this.nGU.iterator();
    while (((Iterator)localObject2).hasNext())
    {
      qs localqs = ((c)((Iterator)localObject2).next()).bMy();
      if (localqs != null) {
        ((ast)localObject1).DsR.CQJ.add(localqs);
      }
    }
    ((ast)localObject1).DsW = this.nHb;
    ((ast)localObject1).ocT = this.LZ;
    ((ast)localObject1).DsT = this.nHa;
    ((ast)localObject1).DsS = this.nGZ;
    localObject2 = com.tencent.mm.plugin.card.model.a.a.nuE;
    k.h(localObject1, "response");
    ad.d(com.tencent.mm.plugin.card.model.a.a.access$getTAG$cp(), "save vip card list snapshot");
    com.tencent.mm.ad.c.b(null, (d.g.a.a)new a.a.a((ast)localObject1));
    localObject1 = new rk();
    ((rk)localObject1).CRs = this.nHd;
    ((rk)localObject1).CRu = this.nHc;
    ((rk)localObject1).CRt = this.nGV;
    localObject2 = com.tencent.mm.plugin.card.model.a.a.nuE;
    k.h(localObject1, "sortInfo");
    ad.d(com.tencent.mm.plugin.card.model.a.a.access$getTAG$cp(), "save vip card list snapshot");
    com.tencent.mm.ad.c.b(null, (d.g.a.a)new a.a.b((rk)localObject1));
    AppMethodBeat.o(192786);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(192785);
    super.onResume();
    ad.i(this.TAG, "do get mch infoset: %s", new Object[] { Boolean.valueOf(this.nGW) });
    if (this.nGW) {
      new com.tencent.mm.plugin.card.model.a.f(this.nGX, this.nGY, this.dpb, this.dqQ, this.nHd, 1).auK().b((com.tencent.mm.vending.c.a)new e(this)).a((com.tencent.mm.vending.e.b)this);
    }
    AppMethodBeat.o(192785);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/card/ui/v3/CouponCardListUI$CouponCardConvertData;", "Lcom/tencent/mm/view/recyclerview/ConvertData;", "(Lcom/tencent/mm/plugin/card/ui/v3/CouponCardListUI;)V", "couponCardInfo", "Lcom/tencent/mm/protocal/protobuf/CardHomePageElement;", "getCouponCardInfo", "()Lcom/tencent/mm/protocal/protobuf/CardHomePageElement;", "setCouponCardInfo", "(Lcom/tencent/mm/protocal/protobuf/CardHomePageElement;)V", "expandState", "", "getExpandState", "()Z", "setExpandState", "(Z)V", "hasRender", "getHasRender", "setHasRender", "getItemId", "", "getItemType", "", "plugin-card_release"})
  public final class c
    implements com.tencent.mm.view.recyclerview.a
  {
    boolean nEG;
    boolean nEH;
    public qs nHh;
    
    public final void a(qs paramqs)
    {
      AppMethodBeat.i(192749);
      k.h(paramqs, "<set-?>");
      this.nHh = paramqs;
      AppMethodBeat.o(192749);
    }
    
    public final long bMs()
    {
      AppMethodBeat.i(192750);
      qs localqs = this.nHh;
      if (localqs == null) {
        k.aPZ("couponCardInfo");
      }
      long l = localqs.CQp.hashCode();
      AppMethodBeat.o(192750);
      return l;
    }
    
    public final int bMt()
    {
      return 1;
    }
    
    public final qs bMy()
    {
      AppMethodBeat.i(192748);
      qs localqs = this.nHh;
      if (localqs == null) {
        k.aPZ("couponCardInfo");
      }
      AppMethodBeat.o(192748);
      return localqs;
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/card/ui/v3/CouponCardListUI$CouponCardConverter;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "Lcom/tencent/mm/plugin/card/ui/v3/CouponCardListUI$CouponCardConvertData;", "Lcom/tencent/mm/plugin/card/ui/v3/CouponCardListUI;", "(Lcom/tencent/mm/plugin/card/ui/v3/CouponCardListUI;)V", "headerClickListener", "Landroid/view/View$OnClickListener;", "addCouponView", "", "view", "Landroid/view/View;", "parentView", "Landroid/view/ViewGroup;", "appendCouponView", "offset", "", "len", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "position", "collapseCouponLayout", "expandCouponLayout", "getLayoutId", "onBindViewHolder", "type", "isHotPatch", "", "payloads", "", "", "onCreateViewHolder", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "showCollapseLayout", "showExpandLayout", "showMiniAppLayout", "updateCardLabelLayout", "couponLabelList", "", "Lcom/tencent/mm/protocal/protobuf/CardElementCouponLabel;", "labelLayout", "Landroid/widget/LinearLayout;", "updateExpandLayout", "isExpended", "plugin-card_release"})
  public final class d
    extends com.tencent.mm.view.recyclerview.b<CouponCardListUI.c>
  {
    View.OnClickListener nHi;
    
    private static void a(com.tencent.mm.view.recyclerview.e parame, CouponCardListUI.c paramc)
    {
      AppMethodBeat.i(192762);
      paramc = paramc.bMy();
      TextView localTextView = (TextView)parame.abq(2131298296);
      ImageView localImageView = (ImageView)parame.abq(2131298294);
      parame = (ViewGroup)parame.abq(2131298295);
      if (!bt.isNullOrNil(paramc.CQv))
      {
        if (!bt.isNullOrNil(paramc.CQw)) {
          localTextView.setTextColor(Color.parseColor(paramc.CQw));
        }
        k.g(localTextView, "chpiExpandTv");
        localTextView.setText((CharSequence)paramc.CQv);
        localImageView.setImageResource(2131231436);
        parame.setOnClickListener((View.OnClickListener)new i(paramc));
      }
      AppMethodBeat.o(192762);
    }
    
    private final void a(final com.tencent.mm.view.recyclerview.e parame, final CouponCardListUI.c paramc, final int paramInt)
    {
      AppMethodBeat.i(192763);
      qs localqs = paramc.bMy();
      TextView localTextView = (TextView)parame.abq(2131298296);
      ImageView localImageView = (ImageView)parame.abq(2131298294);
      ViewGroup localViewGroup = (ViewGroup)parame.abq(2131298295);
      k.g(localTextView, "chpiExpandTv");
      Resources localResources = aj.getResources();
      if (localqs == null) {
        k.fvU();
      }
      localTextView.setText((CharSequence)localResources.getString(2131756876, new Object[] { Integer.valueOf(localqs.CQA - localqs.CQB) }));
      localViewGroup.setOnClickListener((View.OnClickListener)new h(this, parame, paramc, paramInt));
      localImageView.setImageResource(2131231497);
      k.g(localImageView, "chpiExpandIv");
      localImageView.setVisibility(0);
      AppMethodBeat.o(192763);
    }
    
    private final void a(List<? extends qp> paramList, LinearLayout paramLinearLayout)
    {
      AppMethodBeat.i(192767);
      paramList = paramList.iterator();
      if (paramList.hasNext())
      {
        qp localqp = (qp)paramList.next();
        CardTagTextView localCardTagTextView = new CardTagTextView((Context)this.nHg.getContext());
        AppCompatActivity localAppCompatActivity = this.nHg.getContext();
        localCardTagTextView.setMinHeight(com.tencent.mm.cd.a.fromDPToPix((Context)localAppCompatActivity, 18));
        localCardTagTextView.setMinWidth(com.tencent.mm.cd.a.fromDPToPix((Context)localAppCompatActivity, 56));
        int i = com.tencent.mm.cd.a.fromDPToPix((Context)localAppCompatActivity, 8);
        int j = com.tencent.mm.cd.a.fromDPToPix((Context)localAppCompatActivity, 4);
        localCardTagTextView.setPadding(i, j, i, j);
        localCardTagTextView.setText((CharSequence)localqp.CPL);
        localCardTagTextView.setTextSize(1, 10.0F);
        if (!bt.isNullOrNil(localqp.CPM))
        {
          localCardTagTextView.setTextColor(Color.parseColor(localqp.CPM));
          label169:
          if (bt.isNullOrNil(localqp.CPN)) {
            break label219;
          }
          localCardTagTextView.setFillColor(com.tencent.mm.plugin.card.d.l.cC(localqp.CPN, localqp.CPQ));
        }
        for (;;)
        {
          paramLinearLayout.addView((View)localCardTagTextView);
          break;
          localCardTagTextView.setTextColor(-1);
          break label169;
          label219:
          localCardTagTextView.setFillColor(com.tencent.mm.plugin.card.d.l.eO(-16777216, 26));
        }
      }
      AppMethodBeat.o(192767);
    }
    
    private static void b(View paramView, ViewGroup paramViewGroup)
    {
      AppMethodBeat.i(192768);
      if (paramViewGroup.getChildCount() == 0)
      {
        paramViewGroup.addView(paramView);
        AppMethodBeat.o(192768);
        return;
      }
      ViewGroup.MarginLayoutParams localMarginLayoutParams = new ViewGroup.MarginLayoutParams(-1, com.tencent.mm.cd.a.fromDPToPix(paramViewGroup.getContext(), 84));
      localMarginLayoutParams.topMargin = com.tencent.mm.cd.a.fromDPToPix(paramViewGroup.getContext(), 8);
      paramViewGroup.addView(paramView, (ViewGroup.LayoutParams)new LinearLayout.LayoutParams(localMarginLayoutParams));
      AppMethodBeat.o(192768);
    }
    
    private final void b(final com.tencent.mm.view.recyclerview.e parame, final CouponCardListUI.c paramc, final int paramInt)
    {
      AppMethodBeat.i(192764);
      paramc.bMy();
      TextView localTextView = (TextView)parame.abq(2131298296);
      ImageView localImageView = (ImageView)parame.abq(2131298294);
      ViewGroup localViewGroup = (ViewGroup)parame.abq(2131298295);
      k.g(localTextView, "chpiExpandTv");
      localTextView.setText((CharSequence)aj.getResources().getString(2131756874));
      localViewGroup.setOnClickListener((View.OnClickListener)new g(this, parame, paramc, paramInt));
      localImageView.setImageResource(2131231498);
      k.g(localImageView, "chpiExpandIv");
      localImageView.setVisibility(0);
      AppMethodBeat.o(192764);
    }
    
    final void a(int paramInt1, int paramInt2, com.tencent.mm.view.recyclerview.e parame, final CouponCardListUI.c paramc, final int paramInt3)
    {
      AppMethodBeat.i(192766);
      paramc = paramc.bMy();
      ViewGroup localViewGroup = (ViewGroup)parame.abq(2131298292);
      final int k = 0;
      Object localObject1 = paramc.CQu;
      k.g(localObject1, "el.card_element_coupon_list");
      localObject1 = ((Iterable)localObject1).iterator();
      int i = 0;
      if (((Iterator)localObject1).hasNext())
      {
        final qq localqq = (qq)((Iterator)localObject1).next();
        int j = i;
        final v.e locale;
        if (k >= paramInt1)
        {
          locale = new v.e();
          if (localqq.CPX != 1) {
            break label494;
          }
          k.g(localViewGroup, "chpiCouponLayout");
          localObject2 = LayoutInflater.from(localViewGroup.getContext()).inflate(2131493289, localViewGroup, false);
          if (localObject2 == null)
          {
            parame = new v("null cannot be cast to non-null type android.view.ViewGroup");
            AppMethodBeat.o(192766);
            throw parame;
          }
          locale.Jhw = ((ViewGroup)localObject2);
          localObject3 = (TextView)((ViewGroup)locale.Jhw).findViewById(2131298279);
          localObject4 = (CdnImageView)((ViewGroup)locale.Jhw).findViewById(2131298276);
          localTextView = (TextView)((ViewGroup)locale.Jhw).findViewById(2131298277);
          localObject2 = (LinearLayout)((ViewGroup)locale.Jhw).findViewById(2131298278);
          if (!bt.isNullOrNil(localqq.CQa)) {
            ((TextView)localObject3).setTextColor(com.tencent.mm.plugin.card.d.l.cC(localqq.CQa, localqq.CQb));
          }
          k.g(localObject3, "titleTv");
          ((TextView)localObject3).setText((CharSequence)localqq.CPR);
          ((CdnImageView)localObject4).setUrl(localqq.CPY);
          if (!bt.isNullOrNil(localqq.CQc)) {
            localTextView.setTextColor(com.tencent.mm.plugin.card.d.l.cC(localqq.CQc, localqq.CQd));
          }
          k.g(localTextView, "descTv");
          localTextView.setText((CharSequence)localqq.CPS);
          localObject3 = localqq.CPW;
          k.g(localObject3, "coupon.coupon_label");
          localObject3 = (List)localObject3;
          k.g(localObject2, "labelLayout");
          a((List)localObject3, (LinearLayout)localObject2);
          localViewGroup.getChildCount();
          ((ViewGroup)locale.Jhw).setOnClickListener((View.OnClickListener)new a(this, paramc, localqq, k, paramInt3));
          ((ViewGroup)locale.Jhw).setTag(localqq.CuA);
          b((View)locale.Jhw, localViewGroup);
        }
        label494:
        while (localqq.CPX != 2)
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
        k.g(localViewGroup, "chpiCouponLayout");
        Object localObject2 = LayoutInflater.from(localViewGroup.getContext()).inflate(2131493288, localViewGroup, false);
        if (localObject2 == null)
        {
          parame = new v("null cannot be cast to non-null type android.view.ViewGroup");
          AppMethodBeat.o(192766);
          throw parame;
        }
        locale.Jhw = ((ViewGroup)localObject2);
        Object localObject4 = (TextView)((ViewGroup)locale.Jhw).findViewById(2131298279);
        TextView localTextView = (TextView)((ViewGroup)locale.Jhw).findViewById(2131298277);
        localObject2 = (LinearLayout)((ViewGroup)locale.Jhw).findViewById(2131298278);
        MemberCardTopCropImageView localMemberCardTopCropImageView = (MemberCardTopCropImageView)((ViewGroup)locale.Jhw).findViewById(2131298274);
        Object localObject3 = (ImageView)((ViewGroup)locale.Jhw).findViewById(2131298275);
        if (!bt.isNullOrNil(localqq.CQa)) {
          ((TextView)localObject4).setTextColor(com.tencent.mm.plugin.card.d.l.cC(localqq.CQa, localqq.CQb));
        }
        k.g(localObject4, "titleTv");
        ((TextView)localObject4).setText((CharSequence)localqq.CPR);
        k.g(localTextView, "descTv");
        localTextView.setText((CharSequence)localqq.CPS);
        k.g(localMemberCardTopCropImageView, "bgIv");
        localMemberCardTopCropImageView.setRadius(com.tencent.mm.cd.a.fromDPToPix(localMemberCardTopCropImageView.getContext(), 2));
        if (!bt.isNullOrNil(localqq.CPV))
        {
          localObject4 = ((ViewGroup)locale.Jhw).findViewById(2131298274);
          k.g(localObject4, "view.findViewById(R.id.chpc_bg_iv)");
          localObject4 = (d.g.a.a)new d(this, (MemberCardTopCropImageView)localObject4, localqq);
          if (CouponCardListUI.b(this.nHg) <= 0)
          {
            CouponCardListUI.a(this.nHg, ((ViewGroup)locale.Jhw).getHeight());
            if (CouponCardListUI.b(this.nHg) <= 0)
            {
              parame.arI.post((Runnable)new b(this, locale, (d.g.a.a)localObject4));
              label869:
              k.g(localObject3, "shadowBgIv");
              ((ImageView)localObject3).setVisibility(0);
            }
          }
        }
        for (;;)
        {
          localObject3 = localqq.CPW;
          k.g(localObject3, "coupon.coupon_label");
          localObject3 = (List)localObject3;
          k.g(localObject2, "labelLayout");
          a((List)localObject3, (LinearLayout)localObject2);
          localViewGroup.getChildCount();
          ((ViewGroup)locale.Jhw).setOnClickListener((View.OnClickListener)new c(this, paramc, localqq));
          ((ViewGroup)locale.Jhw).setTag(localqq.CuA);
          b((View)locale.Jhw, localViewGroup);
          break;
          ((d.g.a.a)localObject4).invoke();
          break label869;
          ((d.g.a.a)localObject4).invoke();
          break label869;
          if (!bt.isNullOrNil(localqq.CPU))
          {
            localMemberCardTopCropImageView.setImageDrawable((Drawable)new ColorDrawable(Color.parseColor(localqq.CPU)));
            k.g(localObject3, "shadowBgIv");
            ((ImageView)localObject3).setVisibility(0);
          }
        }
      }
      label1061:
      AppMethodBeat.o(192766);
    }
    
    public final void a(RecyclerView paramRecyclerView, final com.tencent.mm.view.recyclerview.e parame, int paramInt)
    {
      AppMethodBeat.i(192760);
      k.h(paramRecyclerView, "recyclerView");
      k.h(parame, "holder");
      paramRecyclerView = (ImageView)parame.abq(2131298299);
      parame.abq(2131298303);
      this.nHi = ((View.OnClickListener)new f(this, parame));
      parame = this.nHi;
      if (parame == null) {
        k.aPZ("headerClickListener");
      }
      paramRecyclerView.setOnClickListener(parame);
      AppMethodBeat.o(192760);
    }
    
    final void a(boolean paramBoolean, com.tencent.mm.view.recyclerview.e parame, CouponCardListUI.c paramc, int paramInt)
    {
      AppMethodBeat.i(192765);
      qs localqs = paramc.bMy();
      if (paramBoolean)
      {
        if (!bt.isNullOrNil(localqs.CQv))
        {
          a(parame, paramc);
          AppMethodBeat.o(192765);
          return;
        }
        b(parame, paramc, paramInt);
        AppMethodBeat.o(192765);
        return;
      }
      a(parame, paramc, paramInt);
      AppMethodBeat.o(192765);
    }
    
    public final int getLayoutId()
    {
      return 2131493299;
    }
    
    @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class a
      implements View.OnClickListener
    {
      a(CouponCardListUI.d paramd, qs paramqs, qq paramqq, int paramInt1, int paramInt2) {}
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(192751);
        CouponCardListUI.a(this.nHj.nHg, true);
        paramView = this.nHj.nHg;
        String str = paramc.CQp;
        k.g(str, "el.card_pack_merchant_id");
        CouponCardListUI.a(paramView, str);
        CouponCardListUI.a(this.nHj.nHg, paramc.CQC);
        paramView = this.nHj.nHg;
        str = localqq.CuA;
        k.g(str, "coupon.user_card_id");
        CouponCardListUI.b(paramView, str);
        com.tencent.mm.plugin.report.service.h.vKh.f(19748, new Object[] { Integer.valueOf(1), Long.valueOf(System.currentTimeMillis() / 1000L), localqq.CuA, Integer.valueOf(k), Integer.valueOf(paramInt3) });
        AppMethodBeat.o(192751);
      }
    }
    
    @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run"})
    static final class b
      implements Runnable
    {
      b(CouponCardListUI.d paramd, v.e parame, d.g.a.a parama) {}
      
      public final void run()
      {
        AppMethodBeat.i(192752);
        CouponCardListUI.a(this.nHj.nHg, ((ViewGroup)locale.Jhw).getHeight());
        this.nGH.invoke();
        AppMethodBeat.o(192752);
      }
    }
    
    @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class c
      implements View.OnClickListener
    {
      c(CouponCardListUI.d paramd, qs paramqs, qq paramqq) {}
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(192753);
        CouponCardListUI.a(this.nHj.nHg, true);
        paramView = this.nHj.nHg;
        String str = paramc.CQp;
        k.g(str, "el.card_pack_merchant_id");
        CouponCardListUI.a(paramView, str);
        CouponCardListUI.a(this.nHj.nHg, paramc.CQC);
        paramView = this.nHj.nHg;
        str = localqq.CuA;
        k.g(str, "coupon.user_card_id");
        CouponCardListUI.b(paramView, str);
        AppMethodBeat.o(192753);
      }
    }
    
    @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke", "()Lkotlin/Unit;"})
    static final class d
      extends d.g.b.l
      implements d.g.a.a<y>
    {
      d(CouponCardListUI.d paramd, MemberCardTopCropImageView paramMemberCardTopCropImageView, qq paramqq)
      {
        super();
      }
    }
    
    @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class f
      implements View.OnClickListener
    {
      f(CouponCardListUI.d paramd, com.tencent.mm.view.recyclerview.e parame) {}
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(192756);
        ad.i(CouponCardListUI.a(this.nHj.nHg), "click header view: " + parame.ln());
        paramView = ((CouponCardListUI.c)parame.fjf()).bMy();
        if (paramView != null)
        {
          switch (paramView.CQf)
          {
          }
          for (;;)
          {
            AppMethodBeat.o(192756);
            return;
            CouponCardListUI.a(this.nHj.nHg, true);
            Object localObject = this.nHj.nHg;
            String str = paramView.CQp;
            k.g(str, "card_pack_merchant_id");
            CouponCardListUI.a((CouponCardListUI)localObject, str);
            CouponCardListUI.a(this.nHj.nHg, paramView.CQC);
            localObject = this.nHj.nHg.getContext();
            if (localObject == null)
            {
              paramView = new v("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
              AppMethodBeat.o(192756);
              throw paramView;
            }
            com.tencent.mm.plugin.card.d.b.a((MMActivity)localObject, paramView.CQg);
            AppMethodBeat.o(192756);
            return;
            CouponCardListUI.a(this.nHj.nHg, true);
            localObject = this.nHj.nHg;
            str = paramView.CQp;
            k.g(str, "card_pack_merchant_id");
            CouponCardListUI.a((CouponCardListUI)localObject, str);
            CouponCardListUI.a(this.nHj.nHg, paramView.CQC);
            paramView = paramView.CQh;
            com.tencent.mm.plugin.card.d.b.G(paramView.zHs, paramView.zHt, paramView.Aoy);
          }
        }
        AppMethodBeat.o(192756);
      }
    }
    
    @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class g
      implements View.OnClickListener
    {
      g(CouponCardListUI.d paramd, com.tencent.mm.view.recyclerview.e parame, CouponCardListUI.c paramc, int paramInt) {}
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(192757);
        ad.d("MicroMsg.CardHomePageNewUI", "do collapse coupon layout");
        paramView = this.nHj;
        com.tencent.mm.view.recyclerview.e locale = parame;
        CouponCardListUI.c localc = paramc;
        int j = paramInt;
        qs localqs = localc.bMy();
        ViewGroup localViewGroup = (ViewGroup)locale.abq(2131298292);
        k.g(localViewGroup, "chpiCouponLayout");
        if (localViewGroup.getChildCount() > localqs.CQB)
        {
          String str = CouponCardListUI.a(paramView.nHg);
          int i = localViewGroup.getChildCount();
          if (localqs == null) {
            k.fvU();
          }
          ad.d(str, "collapse count: %s, limit: %s", new Object[] { Integer.valueOf(i), Integer.valueOf(localqs.CQB) });
          i = localViewGroup.getChildCount() - 1;
          int k = localqs.CQB;
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
        paramView.a(false, locale, localc, j);
        paramc.nEH = false;
        AppMethodBeat.o(192757);
      }
    }
    
    @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class h
      implements View.OnClickListener
    {
      h(CouponCardListUI.d paramd, com.tencent.mm.view.recyclerview.e parame, CouponCardListUI.c paramc, int paramInt) {}
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(192758);
        ad.d(CouponCardListUI.a(this.nHj.nHg), "do expand coupon layout");
        paramView = this.nHj;
        com.tencent.mm.view.recyclerview.e locale = parame;
        CouponCardListUI.c localc = paramc;
        int i = paramInt;
        qs localqs = localc.bMy();
        locale.abq(2131298296);
        locale.abq(2131298294);
        ViewGroup localViewGroup1 = (ViewGroup)locale.abq(2131298295);
        ViewGroup localViewGroup2 = (ViewGroup)locale.abq(2131298292);
        k.g(localViewGroup2, "chpiCouponLayout");
        int j = localViewGroup2.getChildCount();
        if (localqs == null) {
          k.fvU();
        }
        if (j < localqs.CQA)
        {
          paramView.a(localqs.CQB, -1, locale, localc, i);
          if (localqs.CQB < localqs.CQA) {
            break label175;
          }
          k.g(localViewGroup1, "chpiExpandLayout");
          localViewGroup1.setVisibility(8);
        }
        for (;;)
        {
          paramc.nEH = true;
          AppMethodBeat.o(192758);
          return;
          label175:
          paramView.a(true, locale, localc, i);
        }
      }
    }
    
    @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class i
      implements View.OnClickListener
    {
      i(qs paramqs) {}
      
      public final void onClick(View paramView)
      {
        boolean bool = true;
        AppMethodBeat.i(192759);
        if (this.nFh.CQx != null) {
          if (this.nFh.CQx == null) {
            break label84;
          }
        }
        for (;;)
        {
          ad.i("MicroMsg.CardHomePageNewUI", "detail goto mini app %s", new Object[] { Boolean.valueOf(bool) });
          com.tencent.mm.plugin.card.d.b.G(this.nFh.CQx.zHs, this.nFh.CQx.zHt, this.nFh.CQx.Aoy);
          AppMethodBeat.o(192759);
          return;
          label84:
          bool = false;
        }
      }
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Lcom/tencent/mm/modelbase/DeprecatedCgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/GetCardPkgMchInfoResponse;", "kotlin.jvm.PlatformType", "call"})
  static final class e<_Ret, _Var>
    implements com.tencent.mm.vending.c.a<_Ret, _Var>
  {
    e(CouponCardListUI paramCouponCardListUI) {}
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Lcom/tencent/mm/modelbase/DeprecatedCgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/GetCouponHomePageResponse;", "kotlin.jvm.PlatformType", "invoke"})
  static final class f
    extends d.g.b.l
    implements d.g.a.b<c.a<ast>, y>
  {
    f(CouponCardListUI paramCouponCardListUI, boolean paramBoolean)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/card/ui/v3/CouponCardListUI$initView$1", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "getItemConvert", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "type", "", "plugin-card_release"})
  public static final class g
    implements com.tencent.mm.view.recyclerview.c
  {
    public final com.tencent.mm.view.recyclerview.b<?> zm(int paramInt)
    {
      AppMethodBeat.i(192771);
      com.tencent.mm.view.recyclerview.b localb = (com.tencent.mm.view.recyclerview.b)new CouponCardListUI.d(this.nHg);
      AppMethodBeat.o(192771);
      return localb;
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class h
    implements View.OnClickListener
  {
    h(CouponCardListUI paramCouponCardListUI) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(192772);
      ad.d(CouponCardListUI.a(this.nHg), "click header view");
      CouponCardListUI.c(this.nHg);
      AppMethodBeat.o(192772);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/card/ui/v3/CouponCardListUI$initView$3", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback;", "onLoadMoreBegin", "", "onLoadMoreEnd", "reason", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;", "", "plugin-card_release"})
  public static final class i
    extends RefreshLoadMoreLayout.a
  {
    public final void a(RefreshLoadMoreLayout.c<Object> paramc)
    {
      AppMethodBeat.i(192775);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.be(paramc);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/card/ui/v3/CouponCardListUI$initView$3", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V", this, localb.ado());
      k.h(paramc, "reason");
      ad.d(CouponCardListUI.a(this.nHg), "on load more end: " + CouponCardListUI.d(this.nHg));
      if (CouponCardListUI.e(this.nHg)) {
        CouponCardListUI.f(this.nHg).g(null);
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/card/ui/v3/CouponCardListUI$initView$3", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V");
      AppMethodBeat.o(192775);
    }
    
    public final void agP(int paramInt)
    {
      AppMethodBeat.i(205462);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.lT(paramInt);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/card/ui/v3/CouponCardListUI$initView$3", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshBegin", "(I)V", this, localb.ado());
      super.agP(paramInt);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/card/ui/v3/CouponCardListUI$initView$3", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshBegin", "(I)V");
      AppMethodBeat.o(205462);
    }
    
    public final void b(RefreshLoadMoreLayout.c paramc)
    {
      AppMethodBeat.i(205463);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.be(paramc);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/card/ui/v3/CouponCardListUI$initView$3", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V", this, localb.ado());
      super.b(paramc);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/card/ui/v3/CouponCardListUI$initView$3", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V");
      AppMethodBeat.o(205463);
    }
    
    public final void bMu()
    {
      AppMethodBeat.i(192774);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/card/ui/v3/CouponCardListUI$initView$3", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreBegin", "()V", this);
      ad.d(CouponCardListUI.a(this.nHg), "on load more");
      com.tencent.mm.ad.c.g((d.g.a.a)new a(this));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/card/ui/v3/CouponCardListUI$initView$3", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreBegin", "()V");
      AppMethodBeat.o(192774);
    }
    
    @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
    static final class a
      extends d.g.b.l
      implements d.g.a.a<y>
    {
      a(CouponCardListUI.i parami)
      {
        super();
      }
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Lcom/tencent/mm/ui/base/MMMenu;", "kotlin.jvm.PlatformType", "onCreateMMMenu"})
  static final class k
    implements n.c
  {
    k(CouponCardListUI paramCouponCardListUI) {}
    
    public final void onCreateMMMenu(com.tencent.mm.ui.base.l paraml)
    {
      AppMethodBeat.i(192777);
      Object localObject = CouponCardListUI.h(this.nHg);
      if (localObject == null) {
        k.fvU();
      }
      localObject = ((rl)localObject).CRv.iterator();
      while (((Iterator)localObject).hasNext())
      {
        rk localrk = (rk)((Iterator)localObject).next();
        paraml.add(0, localrk.CRs, 1, (CharSequence)localrk.CRu);
      }
      AppMethodBeat.o(192777);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "menuItem", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "index", "", "onMMMenuItemSelected"})
  static final class l
    implements n.d
  {
    l(CouponCardListUI paramCouponCardListUI) {}
    
    public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
    {
      AppMethodBeat.i(192779);
      k.g(paramMenuItem, "menuItem");
      paramInt = paramMenuItem.getItemId();
      ad.i(CouponCardListUI.a(this.nHg), "click item: %s", new Object[] { Integer.valueOf(paramInt) });
      if (paramInt == 1)
      {
        if (!CouponCardListUI.i(this.nHg))
        {
          com.tencent.mm.ui.base.h.a((Context)this.nHg.getContext(), this.nHg.getString(2131756893), this.nHg.getString(2131761885), this.nHg.getString(2131760598), this.nHg.getString(2131757558), false, (DialogInterface.OnClickListener)new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(192778);
              this.nHo.nHg.startActivityForResult(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"), 564);
              AppMethodBeat.o(192778);
            }
          }, null);
          AppMethodBeat.o(192779);
          return;
        }
        CouponCardListUI.b(this.nHg, CouponCardListUI.k(this.nHg));
        CouponCardListUI.c(this.nHg, 1);
        CouponCardListUI.d(this.nHg, paramMenuItem.getTitle().toString());
        CouponCardListUI.l(this.nHg);
        CouponCardListUI.b(this.nHg, true);
        com.tencent.mm.plugin.report.service.h.vKh.f(19747, new Object[] { Integer.valueOf(2), Integer.valueOf(5) });
        AppMethodBeat.o(192779);
        return;
      }
      CouponCardListUI.b(this.nHg, CouponCardListUI.k(this.nHg));
      CouponCardListUI.c(this.nHg, paramInt);
      CouponCardListUI.d(this.nHg, paramMenuItem.getTitle().toString());
      CouponCardListUI.l(this.nHg);
      CouponCardListUI.b(this.nHg, true);
      com.tencent.mm.plugin.report.service.h.vKh.f(19747, new Object[] { Integer.valueOf(2), Integer.valueOf(6) });
      AppMethodBeat.o(192779);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick", "com/tencent/mm/plugin/card/ui/v3/CouponCardListUI$updateIconMenu$1$1"})
  static final class m
    implements MenuItem.OnMenuItemClickListener
  {
    m(rc paramrc, CouponCardListUI paramCouponCardListUI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(192782);
      paramMenuItem = new com.tencent.mm.ui.widget.a.e((Context)jdField_this.getContext(), 1, false);
      paramMenuItem.a((n.c)new n.c()
      {
        public final void onCreateMMMenu(com.tencent.mm.ui.base.l paramAnonymousl)
        {
          AppMethodBeat.i(192780);
          paramAnonymousl.add(0, 0, 1, (CharSequence)CouponCardListUI.g(this.nHq.nHg));
          AppMethodBeat.o(192780);
        }
      });
      paramMenuItem.a((n.d)new n.d()
      {
        public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
        {
          AppMethodBeat.i(192781);
          k.g(paramAnonymousMenuItem, "menuItem");
          if (paramAnonymousMenuItem.getItemId() == 0)
          {
            com.tencent.mm.plugin.card.d.b.G(this.nHq.nHp.zHs, this.nHq.nHp.zHt, this.nHq.nHp.Aoy);
            com.tencent.mm.plugin.report.service.h.vKh.f(19747, new Object[] { Integer.valueOf(2), Integer.valueOf(2) });
          }
          AppMethodBeat.o(192781);
        }
      });
      paramMenuItem.csG();
      com.tencent.mm.plugin.report.service.h.vKh.f(19747, new Object[] { Integer.valueOf(2), Integer.valueOf(1) });
      AppMethodBeat.o(192782);
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.v3.CouponCardListUI
 * JD-Core Version:    0.7.0.1
 */