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
import com.tencent.mm.ak.c.a;
import com.tencent.mm.plugin.card.model.a.a.a;
import com.tencent.mm.plugin.card.model.a.a.a.a;
import com.tencent.mm.plugin.card.model.a.a.a.b;
import com.tencent.mm.plugin.card.ui.v2.CardNewBaseUI;
import com.tencent.mm.plugin.card.widget.CardTagTextView;
import com.tencent.mm.plugin.card.widget.MemberCardTopCropImageView;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.avx;
import com.tencent.mm.protocal.protobuf.crm;
import com.tencent.mm.protocal.protobuf.qz;
import com.tencent.mm.protocal.protobuf.ra;
import com.tencent.mm.protocal.protobuf.rc;
import com.tencent.mm.protocal.protobuf.rg;
import com.tencent.mm.protocal.protobuf.rm;
import com.tencent.mm.protocal.protobuf.ru;
import com.tencent.mm.protocal.protobuf.rv;
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
import d.g.b.v.f;
import d.v;
import d.y;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/card/ui/v3/CouponCardListUI;", "Lcom/tencent/mm/plugin/card/ui/v2/CardNewBaseUI;", "()V", "TAG", "", "loadCount", "", "mCouponCardList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/card/ui/v3/CouponCardListUI$CouponCardConvertData;", "Lkotlin/collections/ArrayList;", "mCouponCardListAdapter", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "mCouponCardListRv", "Lcom/tencent/mm/view/recyclerview/WxRecyclerView;", "mCurrentSortInfo", "mCurrentSortWording", "mEmptyView", "Landroid/view/ViewGroup;", "mFirstLoad", "", "mHasLoadedSuccess", "mHeaderView", "mHistoryEntranceWording", "mHistoryMiniAppInfo", "Lcom/tencent/mm/protocal/protobuf/CardMiniAppInfo;", "mIsAll", "mIsLoading", "mNeedRefreshMch", "mOffset", "mPreviousSortInfo", "mRefreshLayout", "Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "mReqNum", "mScene", "mSortInfoList", "Lcom/tencent/mm/protocal/protobuf/CardSortInfoList;", "mSortTv", "Landroid/widget/TextView;", "mViewHeight", "mVisitMchId", "mVisitMchTime", "", "doDeleteVipCard", "", "merchantId", "cardId", "doGetMchInfo", "doLoadCouponCardList", "refresh", "getLayoutId", "gotoCardDetailUI", "initView", "loadSnapshot", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onFinishLocationThings", "ret", "isLocationOk", "onResume", "saveSnapshot", "showSortDialog", "updateIconMenu", "updateSortView", "updateViewByResp", "resp", "Lcom/tencent/mm/protocal/protobuf/GetCouponHomePageResponse;", "CardSpan", "Companion", "CouponCardConvertData", "CouponCardConverter", "plugin-card_release"})
public final class CouponCardListUI
  extends CardNewBaseUI
{
  public static final CouponCardListUI.b okg;
  private int MW;
  private final String TAG;
  private int aOz;
  private boolean kOL;
  private boolean kYe;
  private int mScene;
  private ViewGroup oiV;
  private WxRecyclerView ojS;
  private TextView ojT;
  private WxRecyclerAdapter<c> ojU;
  private final ArrayList<c> ojV;
  private int ojW;
  private boolean ojX;
  private String ojY;
  private long ojZ;
  private RefreshLoadMoreLayout ojk;
  private ViewGroup ojl;
  private boolean ojr;
  private boolean ojs;
  private int ojw;
  private rm oka;
  private String okb;
  private rv okc;
  private String okd;
  private int oke;
  private int okf;
  
  static
  {
    AppMethodBeat.i(206369);
    okg = new CouponCardListUI.b((byte)0);
    AppMethodBeat.o(206369);
  }
  
  public CouponCardListUI()
  {
    AppMethodBeat.i(206368);
    this.TAG = "MicroMsg.CouponCardListUI";
    this.ojV = new ArrayList();
    this.ojW = 10;
    this.ojY = "";
    this.okd = "";
    this.kYe = true;
    AppMethodBeat.o(206368);
  }
  
  private final void a(avx paramavx)
  {
    AppMethodBeat.i(206367);
    if ((paramavx.ENV == null) || (paramavx.ENV.Eju.isEmpty()))
    {
      AppMethodBeat.o(206367);
      return;
    }
    paramavx = paramavx.ENV.Eju.iterator();
    while (paramavx.hasNext())
    {
      rc localrc = (rc)paramavx.next();
      c localc = new c();
      k.g(localrc, "cardInfo");
      localc.a(localrc);
      this.ojV.add(localc);
    }
    if (this.ojV.isEmpty())
    {
      paramavx = this.oiV;
      if (paramavx == null) {
        k.aVY("mEmptyView");
      }
      paramavx.setVisibility(0);
    }
    for (;;)
    {
      paramavx = this.ojU;
      if (paramavx == null) {
        k.aVY("mCouponCardListAdapter");
      }
      paramavx.notifyDataSetChanged();
      AppMethodBeat.o(206367);
      return;
      paramavx = this.oiV;
      if (paramavx == null) {
        k.aVY("mEmptyView");
      }
      paramavx.setVisibility(8);
    }
  }
  
  private final void bTH()
  {
    AppMethodBeat.i(206364);
    rm localrm = this.oka;
    if (localrm != null)
    {
      removeAllOptionMenu();
      addIconOptionMenu(0, 0, 2131690603, (MenuItem.OnMenuItemClickListener)new m(localrm, this));
      AppMethodBeat.o(206364);
      return;
    }
    AppMethodBeat.o(206364);
  }
  
  private final void bTI()
  {
    AppMethodBeat.i(206365);
    int i;
    Object localObject;
    ViewGroup localViewGroup;
    if (this.oke > 0) {
      if (!((Collection)this.ojV).isEmpty())
      {
        i = 1;
        if (i == 0) {
          break label132;
        }
        localObject = this.ojT;
        if (localObject == null) {
          k.aVY("mSortTv");
        }
        ((TextView)localObject).setText((CharSequence)this.okd);
        localObject = this.ojU;
        if (localObject == null) {
          k.aVY("mCouponCardListAdapter");
        }
        localViewGroup = this.ojl;
        if (localViewGroup == null) {
          k.aVY("mHeaderView");
        }
        ((WxRecyclerAdapter)localObject).f((View)localViewGroup, 2, false);
      }
    }
    for (;;)
    {
      localObject = this.ojU;
      if (localObject == null) {
        k.aVY("mCouponCardListAdapter");
      }
      ((WxRecyclerAdapter)localObject).notifyDataSetChanged();
      AppMethodBeat.o(206365);
      return;
      i = 0;
      break;
      label132:
      localObject = this.ojU;
      if (localObject == null) {
        k.aVY("mCouponCardListAdapter");
      }
      localViewGroup = this.ojl;
      if (localViewGroup == null) {
        k.aVY("mHeaderView");
      }
      ((WxRecyclerAdapter)localObject).L(localViewGroup.hashCode(), false);
    }
  }
  
  private final void jn(final boolean paramBoolean)
  {
    int i = 0;
    AppMethodBeat.i(206366);
    ac.i(this.TAG, "do load vip card list: " + this.kOL + ", " + this.MW + ", " + this.oke);
    Object localObject;
    if ((this.ojr) && (!paramBoolean))
    {
      ac.w(this.TAG, "already load complete");
      localObject = this.ojk;
      if (localObject == null) {
        k.aVY("mRefreshLayout");
      }
      ((RefreshLoadMoreLayout)localObject).adz(0);
      AppMethodBeat.o(206366);
      return;
    }
    if (this.kOL)
    {
      ac.w(this.TAG, "is loading");
      AppMethodBeat.o(206366);
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
      localObject = new com.tencent.mm.plugin.card.model.b.a(i, this.ojW, this.dmL, this.doB, this.oke).aBB();
      k.g(localObject, "CgiGetCouponHomePage(off…, mCurrentSortInfo).run()");
      com.tencent.mm.ac.c.b((com.tencent.mm.vending.g.c)localObject, (d.g.a.b)new f(this, paramBoolean)).b((com.tencent.mm.vending.e.b)this);
      AppMethodBeat.o(206366);
      return;
      i = j;
    }
  }
  
  public final void V(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(206363);
    if ((this.kYe) && (this.oke == 1))
    {
      jn(true);
      AppMethodBeat.o(206363);
      return;
    }
    if (!paramBoolean) {
      bTy();
    }
    AppMethodBeat.o(206363);
  }
  
  public final int getLayoutId()
  {
    return 2131493300;
  }
  
  public final void initView()
  {
    AppMethodBeat.i(206360);
    Object localObject1 = findViewById(2131298323);
    k.g(localObject1, "findViewById(R.id.chpvv3_rv)");
    this.ojS = ((WxRecyclerView)localObject1);
    localObject1 = findViewById(2131298321);
    k.g(localObject1, "findViewById(R.id.chpvv3_refresh_layout)");
    this.ojk = ((RefreshLoadMoreLayout)localObject1);
    localObject1 = findViewById(2131298319);
    k.g(localObject1, "findViewById(R.id.chpvv3_empty_layout)");
    this.oiV = ((ViewGroup)localObject1);
    localObject1 = this.ojS;
    if (localObject1 == null) {
      k.aVY("mCouponCardListRv");
    }
    getContext();
    ((WxRecyclerView)localObject1).setLayoutManager((RecyclerView.i)new LinearLayoutManager(1));
    this.ojU = new WxRecyclerAdapter((com.tencent.mm.view.recyclerview.c)new g(this), this.ojV);
    localObject1 = this.ojS;
    if (localObject1 == null) {
      k.aVY("mCouponCardListRv");
    }
    Object localObject2 = this.ojU;
    if (localObject2 == null) {
      k.aVY("mCouponCardListAdapter");
    }
    ((WxRecyclerView)localObject1).setAdapter((RecyclerView.a)localObject2);
    localObject1 = getLayoutInflater();
    localObject2 = this.ojS;
    if (localObject2 == null) {
      k.aVY("mCouponCardListRv");
    }
    localObject1 = ((LayoutInflater)localObject1).inflate(2131493305, (ViewGroup)localObject2, false);
    if (localObject1 == null)
    {
      localObject1 = new v("null cannot be cast to non-null type android.view.ViewGroup");
      AppMethodBeat.o(206360);
      throw ((Throwable)localObject1);
    }
    this.ojl = ((ViewGroup)localObject1);
    localObject1 = this.ojl;
    if (localObject1 == null) {
      k.aVY("mHeaderView");
    }
    localObject2 = this.ojl;
    if (localObject2 == null) {
      k.aVY("mHeaderView");
    }
    ((ViewGroup)localObject1).setPadding(0, ((ViewGroup)localObject2).getPaddingTop(), 0, com.tencent.mm.cc.a.fromDPToPix((Context)getContext(), 12));
    localObject1 = this.ojl;
    if (localObject1 == null) {
      k.aVY("mHeaderView");
    }
    localObject1 = ((ViewGroup)localObject1).findViewById(2131298325);
    k.g(localObject1, "mHeaderView.findViewById(R.id.chpvv3_sort_tv)");
    this.ojT = ((TextView)localObject1);
    localObject1 = this.ojl;
    if (localObject1 == null) {
      k.aVY("mHeaderView");
    }
    ((ViewGroup)localObject1).setOnClickListener((View.OnClickListener)new h(this));
    localObject1 = this.ojU;
    if (localObject1 == null) {
      k.aVY("mCouponCardListAdapter");
    }
    localObject2 = this.ojl;
    if (localObject2 == null) {
      k.aVY("mHeaderView");
    }
    ((WxRecyclerAdapter)localObject1).f((View)localObject2, 2, false);
    localObject1 = this.ojk;
    if (localObject1 == null) {
      k.aVY("mRefreshLayout");
    }
    ((RefreshLoadMoreLayout)localObject1).setEnableRefresh(false);
    localObject1 = this.ojk;
    if (localObject1 == null) {
      k.aVY("mRefreshLayout");
    }
    ((RefreshLoadMoreLayout)localObject1).setActionCallback((RefreshLoadMoreLayout.a)new i(this));
    AppMethodBeat.o(206360);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(206359);
    super.onCreate(paramBundle);
    initView();
    setMMTitle(2131756824);
    setActionbarColor(getResources().getColor(2131099648));
    hideActionbarLine();
    setBackBtn((MenuItem.OnMenuItemClickListener)new j(this));
    this.mScene = getIntent().getIntExtra("scene", 0);
    paramBundle = com.tencent.mm.plugin.card.model.a.a.nXE;
    paramBundle = a.a.bQC();
    if (paramBundle != null)
    {
      this.MW = paramBundle.oGs;
      this.okc = paramBundle.EOa;
      this.oka = paramBundle.ENW;
      this.okb = paramBundle.ENX;
      bTH();
      a(paramBundle);
    }
    paramBundle = com.tencent.mm.plugin.card.model.a.a.nXE;
    paramBundle = a.a.bQD();
    Object localObject;
    if (paramBundle != null)
    {
      this.oke = paramBundle.Ekd;
      localObject = paramBundle.Ekf;
      k.g(localObject, "cardSortInfo.sort_wording");
      this.okd = ((String)localObject);
      this.ojW = paramBundle.Eke;
      this.okf = this.oke;
    }
    if ((this.okc != null) && (this.mScene == 1))
    {
      paramBundle = this.okc;
      if (paramBundle == null) {
        k.fOy();
      }
      paramBundle = paramBundle.Ekg.iterator();
      while (paramBundle.hasNext())
      {
        localObject = (ru)paramBundle.next();
        if (((ru)localObject).Ekd == 2)
        {
          this.oke = 2;
          localObject = ((ru)localObject).Ekf;
          k.g(localObject, "sortInfo.sort_wording");
          this.okd = ((String)localObject);
        }
      }
    }
    bTI();
    bTI();
    if (this.oke != 1) {
      jn(true);
    }
    AppMethodBeat.o(206359);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(206362);
    super.onDestroy();
    if (!this.ojs)
    {
      ac.i(this.TAG, "no data to save snapshot");
      AppMethodBeat.o(206362);
      return;
    }
    Object localObject1 = new avx();
    ((avx)localObject1).BaseResponse = new BaseResponse();
    ((avx)localObject1).BaseResponse.ErrMsg = new crm();
    ((avx)localObject1).ENV = new rg();
    Object localObject2 = this.ojV.iterator();
    while (((Iterator)localObject2).hasNext())
    {
      rc localrc = ((c)((Iterator)localObject2).next()).bTJ();
      if (localrc != null) {
        ((avx)localObject1).ENV.Eju.add(localrc);
      }
    }
    ((avx)localObject1).EOa = this.okc;
    ((avx)localObject1).oGs = this.MW;
    ((avx)localObject1).ENX = this.okb;
    ((avx)localObject1).ENW = this.oka;
    localObject2 = com.tencent.mm.plugin.card.model.a.a.nXE;
    k.h(localObject1, "response");
    ac.d(com.tencent.mm.plugin.card.model.a.a.access$getTAG$cp(), "save vip card list snapshot");
    com.tencent.mm.ac.c.b(null, (d.g.a.a)new a.a.a((avx)localObject1));
    localObject1 = new ru();
    ((ru)localObject1).Ekd = this.oke;
    ((ru)localObject1).Ekf = this.okd;
    ((ru)localObject1).Eke = this.ojW;
    localObject2 = com.tencent.mm.plugin.card.model.a.a.nXE;
    k.h(localObject1, "sortInfo");
    ac.d(com.tencent.mm.plugin.card.model.a.a.access$getTAG$cp(), "save vip card list snapshot");
    com.tencent.mm.ac.c.b(null, (d.g.a.a)new a.a.b((ru)localObject1));
    AppMethodBeat.o(206362);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(206361);
    super.onResume();
    ac.i(this.TAG, "do get mch infoset: %s", new Object[] { Boolean.valueOf(this.ojX) });
    if (this.ojX) {
      new com.tencent.mm.plugin.card.model.a.f(this.ojY, this.ojZ, this.dmL, this.doB, this.oke, 1).aBB().b((com.tencent.mm.vending.c.a)new e(this)).a((com.tencent.mm.vending.e.b)this);
    }
    AppMethodBeat.o(206361);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/card/ui/v3/CouponCardListUI$CouponCardConvertData;", "Lcom/tencent/mm/view/recyclerview/ConvertData;", "(Lcom/tencent/mm/plugin/card/ui/v3/CouponCardListUI;)V", "couponCardInfo", "Lcom/tencent/mm/protocal/protobuf/CardHomePageElement;", "getCouponCardInfo", "()Lcom/tencent/mm/protocal/protobuf/CardHomePageElement;", "setCouponCardInfo", "(Lcom/tencent/mm/protocal/protobuf/CardHomePageElement;)V", "expandState", "", "getExpandState", "()Z", "setExpandState", "(Z)V", "hasRender", "getHasRender", "setHasRender", "getItemId", "", "getItemType", "", "plugin-card_release"})
  public final class c
    implements com.tencent.mm.view.recyclerview.a
  {
    boolean ohH;
    boolean ohI;
    public rc oki;
    
    public final void a(rc paramrc)
    {
      AppMethodBeat.i(206323);
      k.h(paramrc, "<set-?>");
      this.oki = paramrc;
      AppMethodBeat.o(206323);
    }
    
    public final int bTF()
    {
      return 1;
    }
    
    public final rc bTJ()
    {
      AppMethodBeat.i(206322);
      rc localrc = this.oki;
      if (localrc == null) {
        k.aVY("couponCardInfo");
      }
      AppMethodBeat.o(206322);
      return localrc;
    }
    
    public final long lx()
    {
      AppMethodBeat.i(206324);
      rc localrc = this.oki;
      if (localrc == null) {
        k.aVY("couponCardInfo");
      }
      long l = localrc.Eja.hashCode();
      AppMethodBeat.o(206324);
      return l;
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/card/ui/v3/CouponCardListUI$CouponCardConverter;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "Lcom/tencent/mm/plugin/card/ui/v3/CouponCardListUI$CouponCardConvertData;", "Lcom/tencent/mm/plugin/card/ui/v3/CouponCardListUI;", "(Lcom/tencent/mm/plugin/card/ui/v3/CouponCardListUI;)V", "headerClickListener", "Landroid/view/View$OnClickListener;", "addCouponView", "", "view", "Landroid/view/View;", "parentView", "Landroid/view/ViewGroup;", "appendCouponView", "offset", "", "len", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "position", "collapseCouponLayout", "expandCouponLayout", "getLayoutId", "onBindViewHolder", "type", "isHotPatch", "", "payloads", "", "", "onCreateViewHolder", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "showCollapseLayout", "showExpandLayout", "showMiniAppLayout", "updateCardLabelLayout", "couponLabelList", "", "Lcom/tencent/mm/protocal/protobuf/CardElementCouponLabel;", "labelLayout", "Landroid/widget/LinearLayout;", "updateExpandLayout", "isExpended", "plugin-card_release"})
  public final class d
    extends com.tencent.mm.view.recyclerview.b<CouponCardListUI.c>
  {
    View.OnClickListener okj;
    
    private static void a(com.tencent.mm.view.recyclerview.e parame, CouponCardListUI.c paramc)
    {
      AppMethodBeat.i(206336);
      paramc = paramc.bTJ();
      TextView localTextView = (TextView)parame.adJ(2131298296);
      ImageView localImageView = (ImageView)parame.adJ(2131298294);
      parame = (ViewGroup)parame.adJ(2131298295);
      if (!bs.isNullOrNil(paramc.Ejg))
      {
        if (!bs.isNullOrNil(paramc.Ejh)) {
          localTextView.setTextColor(Color.parseColor(paramc.Ejh));
        }
        k.g(localTextView, "chpiExpandTv");
        localTextView.setText((CharSequence)paramc.Ejg);
        localImageView.setImageResource(2131231436);
        parame.setOnClickListener((View.OnClickListener)new i(paramc));
      }
      AppMethodBeat.o(206336);
    }
    
    private final void a(final com.tencent.mm.view.recyclerview.e parame, final CouponCardListUI.c paramc, final int paramInt)
    {
      AppMethodBeat.i(206337);
      rc localrc = paramc.bTJ();
      TextView localTextView = (TextView)parame.adJ(2131298296);
      ImageView localImageView = (ImageView)parame.adJ(2131298294);
      ViewGroup localViewGroup = (ViewGroup)parame.adJ(2131298295);
      k.g(localTextView, "chpiExpandTv");
      Resources localResources = ai.getResources();
      if (localrc == null) {
        k.fOy();
      }
      localTextView.setText((CharSequence)localResources.getString(2131756876, new Object[] { Integer.valueOf(localrc.Ejl - localrc.Ejm) }));
      localViewGroup.setOnClickListener((View.OnClickListener)new h(this, parame, paramc, paramInt));
      localImageView.setImageResource(2131231497);
      k.g(localImageView, "chpiExpandIv");
      localImageView.setVisibility(0);
      AppMethodBeat.o(206337);
    }
    
    private final void a(List<? extends qz> paramList, LinearLayout paramLinearLayout)
    {
      AppMethodBeat.i(206341);
      paramList = paramList.iterator();
      if (paramList.hasNext())
      {
        qz localqz = (qz)paramList.next();
        CardTagTextView localCardTagTextView = new CardTagTextView((Context)this.okh.getContext());
        AppCompatActivity localAppCompatActivity = this.okh.getContext();
        localCardTagTextView.setMinHeight(com.tencent.mm.cc.a.fromDPToPix((Context)localAppCompatActivity, 18));
        localCardTagTextView.setMinWidth(com.tencent.mm.cc.a.fromDPToPix((Context)localAppCompatActivity, 56));
        int i = com.tencent.mm.cc.a.fromDPToPix((Context)localAppCompatActivity, 8);
        int j = com.tencent.mm.cc.a.fromDPToPix((Context)localAppCompatActivity, 4);
        localCardTagTextView.setPadding(i, j, i, j);
        localCardTagTextView.setText((CharSequence)localqz.Eiw);
        localCardTagTextView.setTextSize(1, 10.0F);
        if (!bs.isNullOrNil(localqz.Eix))
        {
          localCardTagTextView.setTextColor(Color.parseColor(localqz.Eix));
          label169:
          if (bs.isNullOrNil(localqz.Eiy)) {
            break label219;
          }
          localCardTagTextView.setFillColor(com.tencent.mm.plugin.card.d.l.cH(localqz.Eiy, localqz.EiB));
        }
        for (;;)
        {
          paramLinearLayout.addView((View)localCardTagTextView);
          break;
          localCardTagTextView.setTextColor(-1);
          break label169;
          label219:
          localCardTagTextView.setFillColor(com.tencent.mm.plugin.card.d.l.eR(-16777216, 26));
        }
      }
      AppMethodBeat.o(206341);
    }
    
    private static void b(View paramView, ViewGroup paramViewGroup)
    {
      AppMethodBeat.i(206342);
      if (paramViewGroup.getChildCount() == 0)
      {
        paramViewGroup.addView(paramView);
        AppMethodBeat.o(206342);
        return;
      }
      ViewGroup.MarginLayoutParams localMarginLayoutParams = new ViewGroup.MarginLayoutParams(-1, com.tencent.mm.cc.a.fromDPToPix(paramViewGroup.getContext(), 84));
      localMarginLayoutParams.topMargin = com.tencent.mm.cc.a.fromDPToPix(paramViewGroup.getContext(), 8);
      paramViewGroup.addView(paramView, (ViewGroup.LayoutParams)new LinearLayout.LayoutParams(localMarginLayoutParams));
      AppMethodBeat.o(206342);
    }
    
    private final void b(final com.tencent.mm.view.recyclerview.e parame, final CouponCardListUI.c paramc, final int paramInt)
    {
      AppMethodBeat.i(206338);
      paramc.bTJ();
      TextView localTextView = (TextView)parame.adJ(2131298296);
      ImageView localImageView = (ImageView)parame.adJ(2131298294);
      ViewGroup localViewGroup = (ViewGroup)parame.adJ(2131298295);
      k.g(localTextView, "chpiExpandTv");
      localTextView.setText((CharSequence)ai.getResources().getString(2131756874));
      localViewGroup.setOnClickListener((View.OnClickListener)new g(this, parame, paramc, paramInt));
      localImageView.setImageResource(2131231498);
      k.g(localImageView, "chpiExpandIv");
      localImageView.setVisibility(0);
      AppMethodBeat.o(206338);
    }
    
    final void a(int paramInt1, int paramInt2, com.tencent.mm.view.recyclerview.e parame, final CouponCardListUI.c paramc, final int paramInt3)
    {
      AppMethodBeat.i(206340);
      paramc = paramc.bTJ();
      ViewGroup localViewGroup = (ViewGroup)parame.adJ(2131298292);
      final int k = 0;
      Object localObject1 = paramc.Ejf;
      k.g(localObject1, "el.card_element_coupon_list");
      localObject1 = ((Iterable)localObject1).iterator();
      int i = 0;
      if (((Iterator)localObject1).hasNext())
      {
        final ra localra = (ra)((Iterator)localObject1).next();
        int j = i;
        final v.f localf;
        if (k >= paramInt1)
        {
          localf = new v.f();
          if (localra.EiI != 1) {
            break label494;
          }
          k.g(localViewGroup, "chpiCouponLayout");
          localObject2 = LayoutInflater.from(localViewGroup.getContext()).inflate(2131493289, localViewGroup, false);
          if (localObject2 == null)
          {
            parame = new v("null cannot be cast to non-null type android.view.ViewGroup");
            AppMethodBeat.o(206340);
            throw parame;
          }
          localf.KUQ = ((ViewGroup)localObject2);
          localObject3 = (TextView)((ViewGroup)localf.KUQ).findViewById(2131298279);
          localObject4 = (CdnImageView)((ViewGroup)localf.KUQ).findViewById(2131298276);
          localTextView = (TextView)((ViewGroup)localf.KUQ).findViewById(2131298277);
          localObject2 = (LinearLayout)((ViewGroup)localf.KUQ).findViewById(2131298278);
          if (!bs.isNullOrNil(localra.EiL)) {
            ((TextView)localObject3).setTextColor(com.tencent.mm.plugin.card.d.l.cH(localra.EiL, localra.EiM));
          }
          k.g(localObject3, "titleTv");
          ((TextView)localObject3).setText((CharSequence)localra.EiC);
          ((CdnImageView)localObject4).setUrl(localra.EiJ);
          if (!bs.isNullOrNil(localra.EiN)) {
            localTextView.setTextColor(com.tencent.mm.plugin.card.d.l.cH(localra.EiN, localra.EiO));
          }
          k.g(localTextView, "descTv");
          localTextView.setText((CharSequence)localra.EiD);
          localObject3 = localra.EiH;
          k.g(localObject3, "coupon.coupon_label");
          localObject3 = (List)localObject3;
          k.g(localObject2, "labelLayout");
          a((List)localObject3, (LinearLayout)localObject2);
          localViewGroup.getChildCount();
          ((ViewGroup)localf.KUQ).setOnClickListener((View.OnClickListener)new a(this, paramc, localra, k, paramInt3));
          ((ViewGroup)localf.KUQ).setTag(localra.DMR);
          b((View)localf.KUQ, localViewGroup);
        }
        label494:
        while (localra.EiI != 2)
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
          AppMethodBeat.o(206340);
          throw parame;
        }
        localf.KUQ = ((ViewGroup)localObject2);
        Object localObject4 = (TextView)((ViewGroup)localf.KUQ).findViewById(2131298279);
        TextView localTextView = (TextView)((ViewGroup)localf.KUQ).findViewById(2131298277);
        localObject2 = (LinearLayout)((ViewGroup)localf.KUQ).findViewById(2131298278);
        MemberCardTopCropImageView localMemberCardTopCropImageView = (MemberCardTopCropImageView)((ViewGroup)localf.KUQ).findViewById(2131298274);
        Object localObject3 = (ImageView)((ViewGroup)localf.KUQ).findViewById(2131298275);
        if (!bs.isNullOrNil(localra.EiL)) {
          ((TextView)localObject4).setTextColor(com.tencent.mm.plugin.card.d.l.cH(localra.EiL, localra.EiM));
        }
        k.g(localObject4, "titleTv");
        ((TextView)localObject4).setText((CharSequence)localra.EiC);
        k.g(localTextView, "descTv");
        localTextView.setText((CharSequence)localra.EiD);
        k.g(localMemberCardTopCropImageView, "bgIv");
        localMemberCardTopCropImageView.setRadius(com.tencent.mm.cc.a.fromDPToPix(localMemberCardTopCropImageView.getContext(), 2));
        if (!bs.isNullOrNil(localra.EiG))
        {
          localObject4 = ((ViewGroup)localf.KUQ).findViewById(2131298274);
          k.g(localObject4, "view.findViewById(R.id.chpc_bg_iv)");
          localObject4 = (d.g.a.a)new d(this, (MemberCardTopCropImageView)localObject4, localra);
          if (CouponCardListUI.b(this.okh) <= 0)
          {
            CouponCardListUI.a(this.okh, ((ViewGroup)localf.KUQ).getHeight());
            if (CouponCardListUI.b(this.okh) <= 0)
            {
              parame.asD.post((Runnable)new b(this, localf, (d.g.a.a)localObject4));
              label869:
              k.g(localObject3, "shadowBgIv");
              ((ImageView)localObject3).setVisibility(0);
            }
          }
        }
        for (;;)
        {
          localObject3 = localra.EiH;
          k.g(localObject3, "coupon.coupon_label");
          localObject3 = (List)localObject3;
          k.g(localObject2, "labelLayout");
          a((List)localObject3, (LinearLayout)localObject2);
          localViewGroup.getChildCount();
          ((ViewGroup)localf.KUQ).setOnClickListener((View.OnClickListener)new c(this, paramc, localra));
          ((ViewGroup)localf.KUQ).setTag(localra.DMR);
          b((View)localf.KUQ, localViewGroup);
          break;
          ((d.g.a.a)localObject4).invoke();
          break label869;
          ((d.g.a.a)localObject4).invoke();
          break label869;
          if (!bs.isNullOrNil(localra.EiF))
          {
            localMemberCardTopCropImageView.setImageDrawable((Drawable)new ColorDrawable(Color.parseColor(localra.EiF)));
            k.g(localObject3, "shadowBgIv");
            ((ImageView)localObject3).setVisibility(0);
          }
        }
      }
      label1061:
      AppMethodBeat.o(206340);
    }
    
    public final void a(RecyclerView paramRecyclerView, final com.tencent.mm.view.recyclerview.e parame, int paramInt)
    {
      AppMethodBeat.i(206334);
      k.h(paramRecyclerView, "recyclerView");
      k.h(parame, "holder");
      paramRecyclerView = (ImageView)parame.adJ(2131298299);
      parame.adJ(2131298303);
      this.okj = ((View.OnClickListener)new f(this, parame));
      parame = this.okj;
      if (parame == null) {
        k.aVY("headerClickListener");
      }
      paramRecyclerView.setOnClickListener(parame);
      AppMethodBeat.o(206334);
    }
    
    final void a(boolean paramBoolean, com.tencent.mm.view.recyclerview.e parame, CouponCardListUI.c paramc, int paramInt)
    {
      AppMethodBeat.i(206339);
      rc localrc = paramc.bTJ();
      if (paramBoolean)
      {
        if (!bs.isNullOrNil(localrc.Ejg))
        {
          a(parame, paramc);
          AppMethodBeat.o(206339);
          return;
        }
        b(parame, paramc, paramInt);
        AppMethodBeat.o(206339);
        return;
      }
      a(parame, paramc, paramInt);
      AppMethodBeat.o(206339);
    }
    
    public final int getLayoutId()
    {
      return 2131493299;
    }
    
    @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class a
      implements View.OnClickListener
    {
      a(CouponCardListUI.d paramd, rc paramrc, ra paramra, int paramInt1, int paramInt2) {}
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(206325);
        CouponCardListUI.a(this.okk.okh, true);
        paramView = this.okk.okh;
        String str = paramc.Eja;
        k.g(str, "el.card_pack_merchant_id");
        CouponCardListUI.a(paramView, str);
        CouponCardListUI.a(this.okk.okh, paramc.Ejn);
        paramView = this.okk.okh;
        str = localra.DMR;
        k.g(str, "coupon.user_card_id");
        CouponCardListUI.b(paramView, str);
        com.tencent.mm.plugin.report.service.h.wUl.f(19748, new Object[] { Integer.valueOf(1), Long.valueOf(System.currentTimeMillis() / 1000L), localra.DMR, Integer.valueOf(k), Integer.valueOf(paramInt3) });
        AppMethodBeat.o(206325);
      }
    }
    
    @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run"})
    static final class b
      implements Runnable
    {
      b(CouponCardListUI.d paramd, v.f paramf, d.g.a.a parama) {}
      
      public final void run()
      {
        AppMethodBeat.i(206326);
        CouponCardListUI.a(this.okk.okh, ((ViewGroup)localf.KUQ).getHeight());
        this.ojI.invoke();
        AppMethodBeat.o(206326);
      }
    }
    
    @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class c
      implements View.OnClickListener
    {
      c(CouponCardListUI.d paramd, rc paramrc, ra paramra) {}
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(206327);
        CouponCardListUI.a(this.okk.okh, true);
        paramView = this.okk.okh;
        String str = paramc.Eja;
        k.g(str, "el.card_pack_merchant_id");
        CouponCardListUI.a(paramView, str);
        CouponCardListUI.a(this.okk.okh, paramc.Ejn);
        paramView = this.okk.okh;
        str = localra.DMR;
        k.g(str, "coupon.user_card_id");
        CouponCardListUI.b(paramView, str);
        AppMethodBeat.o(206327);
      }
    }
    
    @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke", "()Lkotlin/Unit;"})
    static final class d
      extends d.g.b.l
      implements d.g.a.a<y>
    {
      d(CouponCardListUI.d paramd, MemberCardTopCropImageView paramMemberCardTopCropImageView, ra paramra)
      {
        super();
      }
    }
    
    @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class f
      implements View.OnClickListener
    {
      f(CouponCardListUI.d paramd, com.tencent.mm.view.recyclerview.e parame) {}
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(206330);
        ac.i(CouponCardListUI.a(this.okk.okh), "click header view: " + parame.lv());
        paramView = ((CouponCardListUI.c)parame.fzs()).bTJ();
        if (paramView != null)
        {
          switch (paramView.EiQ)
          {
          }
          for (;;)
          {
            AppMethodBeat.o(206330);
            return;
            CouponCardListUI.a(this.okk.okh, true);
            Object localObject = this.okk.okh;
            String str = paramView.Eja;
            k.g(str, "card_pack_merchant_id");
            CouponCardListUI.a((CouponCardListUI)localObject, str);
            CouponCardListUI.a(this.okk.okh, paramView.Ejn);
            localObject = this.okk.okh.getContext();
            if (localObject == null)
            {
              paramView = new v("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
              AppMethodBeat.o(206330);
              throw paramView;
            }
            com.tencent.mm.plugin.card.d.b.a((MMActivity)localObject, paramView.EiR);
            AppMethodBeat.o(206330);
            return;
            CouponCardListUI.a(this.okk.okh, true);
            localObject = this.okk.okh;
            str = paramView.Eja;
            k.g(str, "card_pack_merchant_id");
            CouponCardListUI.a((CouponCardListUI)localObject, str);
            CouponCardListUI.a(this.okk.okh, paramView.Ejn);
            paramView = paramView.EiS;
            com.tencent.mm.plugin.card.d.b.H(paramView.AZE, paramView.AZF, paramView.BGS);
          }
        }
        AppMethodBeat.o(206330);
      }
    }
    
    @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class g
      implements View.OnClickListener
    {
      g(CouponCardListUI.d paramd, com.tencent.mm.view.recyclerview.e parame, CouponCardListUI.c paramc, int paramInt) {}
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(206331);
        ac.d("MicroMsg.CardHomePageNewUI", "do collapse coupon layout");
        paramView = this.okk;
        com.tencent.mm.view.recyclerview.e locale = parame;
        CouponCardListUI.c localc = paramc;
        int j = paramInt;
        rc localrc = localc.bTJ();
        ViewGroup localViewGroup = (ViewGroup)locale.adJ(2131298292);
        k.g(localViewGroup, "chpiCouponLayout");
        if (localViewGroup.getChildCount() > localrc.Ejm)
        {
          String str = CouponCardListUI.a(paramView.okh);
          int i = localViewGroup.getChildCount();
          if (localrc == null) {
            k.fOy();
          }
          ac.d(str, "collapse count: %s, limit: %s", new Object[] { Integer.valueOf(i), Integer.valueOf(localrc.Ejm) });
          i = localViewGroup.getChildCount() - 1;
          int k = localrc.Ejm;
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
        paramc.ohI = false;
        AppMethodBeat.o(206331);
      }
    }
    
    @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class h
      implements View.OnClickListener
    {
      h(CouponCardListUI.d paramd, com.tencent.mm.view.recyclerview.e parame, CouponCardListUI.c paramc, int paramInt) {}
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(206332);
        ac.d(CouponCardListUI.a(this.okk.okh), "do expand coupon layout");
        paramView = this.okk;
        com.tencent.mm.view.recyclerview.e locale = parame;
        CouponCardListUI.c localc = paramc;
        int i = paramInt;
        rc localrc = localc.bTJ();
        locale.adJ(2131298296);
        locale.adJ(2131298294);
        ViewGroup localViewGroup1 = (ViewGroup)locale.adJ(2131298295);
        ViewGroup localViewGroup2 = (ViewGroup)locale.adJ(2131298292);
        k.g(localViewGroup2, "chpiCouponLayout");
        int j = localViewGroup2.getChildCount();
        if (localrc == null) {
          k.fOy();
        }
        if (j < localrc.Ejl)
        {
          paramView.a(localrc.Ejm, -1, locale, localc, i);
          if (localrc.Ejm < localrc.Ejl) {
            break label175;
          }
          k.g(localViewGroup1, "chpiExpandLayout");
          localViewGroup1.setVisibility(8);
        }
        for (;;)
        {
          paramc.ohI = true;
          AppMethodBeat.o(206332);
          return;
          label175:
          paramView.a(true, locale, localc, i);
        }
      }
    }
    
    @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class i
      implements View.OnClickListener
    {
      i(rc paramrc) {}
      
      public final void onClick(View paramView)
      {
        boolean bool = true;
        AppMethodBeat.i(206333);
        if (this.oii.Eji != null) {
          if (this.oii.Eji == null) {
            break label84;
          }
        }
        for (;;)
        {
          ac.i("MicroMsg.CardHomePageNewUI", "detail goto mini app %s", new Object[] { Boolean.valueOf(bool) });
          com.tencent.mm.plugin.card.d.b.H(this.oii.Eji.AZE, this.oii.Eji.AZF, this.oii.Eji.BGS);
          AppMethodBeat.o(206333);
          return;
          label84:
          bool = false;
        }
      }
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Lcom/tencent/mm/modelbase/DeprecatedCgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/GetCardPkgMchInfoResponse;", "kotlin.jvm.PlatformType", "call"})
  static final class e<_Ret, _Var>
    implements com.tencent.mm.vending.c.a<_Ret, _Var>
  {
    e(CouponCardListUI paramCouponCardListUI) {}
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Lcom/tencent/mm/modelbase/DeprecatedCgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/GetCouponHomePageResponse;", "kotlin.jvm.PlatformType", "invoke"})
  static final class f
    extends d.g.b.l
    implements d.g.a.b<c.a<avx>, y>
  {
    f(CouponCardListUI paramCouponCardListUI, boolean paramBoolean)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/card/ui/v3/CouponCardListUI$initView$1", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "getItemConvert", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "type", "", "plugin-card_release"})
  public static final class g
    implements com.tencent.mm.view.recyclerview.c
  {
    public final com.tencent.mm.view.recyclerview.b<?> Ac(int paramInt)
    {
      AppMethodBeat.i(206345);
      com.tencent.mm.view.recyclerview.b localb = (com.tencent.mm.view.recyclerview.b)new CouponCardListUI.d(this.okh);
      AppMethodBeat.o(206345);
      return localb;
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class h
    implements View.OnClickListener
  {
    h(CouponCardListUI paramCouponCardListUI) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(206346);
      ac.d(CouponCardListUI.a(this.okh), "click header view");
      CouponCardListUI.c(this.okh);
      AppMethodBeat.o(206346);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/card/ui/v3/CouponCardListUI$initView$3", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback;", "onLoadMoreBegin", "", "onLoadMoreEnd", "reason", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;", "", "plugin-card_release"})
  public static final class i
    extends RefreshLoadMoreLayout.a
  {
    public final void Ad(int paramInt)
    {
      AppMethodBeat.i(206350);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.lS(paramInt);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/card/ui/v3/CouponCardListUI$initView$3", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshBegin", "(I)V", this, localb.aeE());
      super.Ad(paramInt);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/card/ui/v3/CouponCardListUI$initView$3", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshBegin", "(I)V");
      AppMethodBeat.o(206350);
    }
    
    public final void a(RefreshLoadMoreLayout.c<Object> paramc)
    {
      AppMethodBeat.i(206349);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bb(paramc);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/card/ui/v3/CouponCardListUI$initView$3", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V", this, localb.aeE());
      k.h(paramc, "reason");
      ac.d(CouponCardListUI.a(this.okh), "on load more end: " + CouponCardListUI.d(this.okh));
      if (CouponCardListUI.e(this.okh)) {
        CouponCardListUI.f(this.okh).i(null);
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/card/ui/v3/CouponCardListUI$initView$3", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V");
      AppMethodBeat.o(206349);
    }
    
    public final void b(RefreshLoadMoreLayout.c paramc)
    {
      AppMethodBeat.i(206351);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bb(paramc);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/card/ui/v3/CouponCardListUI$initView$3", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V", this, localb.aeE());
      super.b(paramc);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/card/ui/v3/CouponCardListUI$initView$3", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V");
      AppMethodBeat.o(206351);
    }
    
    public final void bTG()
    {
      AppMethodBeat.i(206348);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/card/ui/v3/CouponCardListUI$initView$3", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreBegin", "()V", this);
      ac.d(CouponCardListUI.a(this.okh), "on load more");
      com.tencent.mm.ac.c.g((d.g.a.a)new a(this));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/card/ui/v3/CouponCardListUI$initView$3", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreBegin", "()V");
      AppMethodBeat.o(206348);
    }
    
    @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
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
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class j
    implements MenuItem.OnMenuItemClickListener
  {
    j(CouponCardListUI paramCouponCardListUI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(206352);
      this.okh.finish();
      AppMethodBeat.o(206352);
      return false;
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Lcom/tencent/mm/ui/base/MMMenu;", "kotlin.jvm.PlatformType", "onCreateMMMenu"})
  static final class k
    implements n.c
  {
    k(CouponCardListUI paramCouponCardListUI) {}
    
    public final void onCreateMMMenu(com.tencent.mm.ui.base.l paraml)
    {
      AppMethodBeat.i(206353);
      Object localObject = CouponCardListUI.h(this.okh);
      if (localObject == null) {
        k.fOy();
      }
      localObject = ((rv)localObject).Ekg.iterator();
      while (((Iterator)localObject).hasNext())
      {
        ru localru = (ru)((Iterator)localObject).next();
        paraml.add(0, localru.Ekd, 1, (CharSequence)localru.Ekf);
      }
      AppMethodBeat.o(206353);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "menuItem", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "index", "", "onMMMenuItemSelected"})
  static final class l
    implements n.d
  {
    l(CouponCardListUI paramCouponCardListUI) {}
    
    public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
    {
      AppMethodBeat.i(206355);
      k.g(paramMenuItem, "menuItem");
      paramInt = paramMenuItem.getItemId();
      ac.i(CouponCardListUI.a(this.okh), "click item: %s", new Object[] { Integer.valueOf(paramInt) });
      if (paramInt == 1)
      {
        if (!CouponCardListUI.i(this.okh))
        {
          com.tencent.mm.ui.base.h.a((Context)this.okh.getContext(), this.okh.getString(2131756893), this.okh.getString(2131761885), this.okh.getString(2131760598), this.okh.getString(2131757558), false, (DialogInterface.OnClickListener)new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(206354);
              this.oko.okh.startActivityForResult(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"), 564);
              AppMethodBeat.o(206354);
            }
          }, null);
          AppMethodBeat.o(206355);
          return;
        }
        CouponCardListUI.b(this.okh, CouponCardListUI.k(this.okh));
        CouponCardListUI.c(this.okh, 1);
        CouponCardListUI.d(this.okh, paramMenuItem.getTitle().toString());
        CouponCardListUI.l(this.okh);
        CouponCardListUI.b(this.okh, true);
        com.tencent.mm.plugin.report.service.h.wUl.f(19747, new Object[] { Integer.valueOf(2), Integer.valueOf(5) });
        AppMethodBeat.o(206355);
        return;
      }
      CouponCardListUI.b(this.okh, CouponCardListUI.k(this.okh));
      CouponCardListUI.c(this.okh, paramInt);
      CouponCardListUI.d(this.okh, paramMenuItem.getTitle().toString());
      CouponCardListUI.l(this.okh);
      CouponCardListUI.b(this.okh, true);
      com.tencent.mm.plugin.report.service.h.wUl.f(19747, new Object[] { Integer.valueOf(2), Integer.valueOf(6) });
      AppMethodBeat.o(206355);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick", "com/tencent/mm/plugin/card/ui/v3/CouponCardListUI$updateIconMenu$1$1"})
  static final class m
    implements MenuItem.OnMenuItemClickListener
  {
    m(rm paramrm, CouponCardListUI paramCouponCardListUI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(206358);
      paramMenuItem = new com.tencent.mm.ui.widget.a.e((Context)jdField_this.getContext(), 1, false);
      paramMenuItem.a((n.c)new n.c()
      {
        public final void onCreateMMMenu(com.tencent.mm.ui.base.l paramAnonymousl)
        {
          AppMethodBeat.i(206356);
          paramAnonymousl.add(0, 0, 1, (CharSequence)CouponCardListUI.g(this.okq.okh));
          AppMethodBeat.o(206356);
        }
      });
      paramMenuItem.a((n.d)new n.d()
      {
        public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
        {
          AppMethodBeat.i(206357);
          k.g(paramAnonymousMenuItem, "menuItem");
          if (paramAnonymousMenuItem.getItemId() == 0)
          {
            com.tencent.mm.plugin.card.d.b.H(this.okq.okp.AZE, this.okq.okp.AZF, this.okq.okp.BGS);
            com.tencent.mm.plugin.report.service.h.wUl.f(19747, new Object[] { Integer.valueOf(2), Integer.valueOf(2) });
          }
          AppMethodBeat.o(206357);
        }
      });
      paramMenuItem.cED();
      com.tencent.mm.plugin.report.service.h.wUl.f(19747, new Object[] { Integer.valueOf(2), Integer.valueOf(1) });
      AppMethodBeat.o(206358);
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.v3.CouponCardListUI
 * JD-Core Version:    0.7.0.1
 */