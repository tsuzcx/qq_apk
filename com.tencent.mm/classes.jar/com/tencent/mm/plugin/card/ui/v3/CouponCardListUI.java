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
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.RecyclerView.a;
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
import com.tencent.mm.ac.d;
import com.tencent.mm.ak.c.a;
import com.tencent.mm.plugin.card.model.a.a.a;
import com.tencent.mm.plugin.card.model.a.a.a.b;
import com.tencent.mm.plugin.card.model.a.a.a.d;
import com.tencent.mm.plugin.card.ui.v2.CardNewBaseUI;
import com.tencent.mm.plugin.card.widget.CardTagTextView;
import com.tencent.mm.plugin.card.widget.MemberCardTopCropImageView;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.bma;
import com.tencent.mm.protocal.protobuf.dqi;
import com.tencent.mm.protocal.protobuf.tz;
import com.tencent.mm.protocal.protobuf.ua;
import com.tencent.mm.protocal.protobuf.ud;
import com.tencent.mm.protocal.protobuf.uh;
import com.tencent.mm.protocal.protobuf.un;
import com.tencent.mm.protocal.protobuf.uv;
import com.tencent.mm.protocal.protobuf.uw;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.base.o.f;
import com.tencent.mm.ui.base.o.g;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.RefreshLoadMoreLayout.a;
import com.tencent.mm.view.RefreshLoadMoreLayout.c;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.mm.view.recyclerview.WxRecyclerView;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.g.b.z.f;
import kotlin.t;
import kotlin.x;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/card/ui/v3/CouponCardListUI;", "Lcom/tencent/mm/plugin/card/ui/v2/CardNewBaseUI;", "()V", "TAG", "", "loadCount", "", "mCouponCardList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/card/ui/v3/CouponCardListUI$CouponCardConvertData;", "Lkotlin/collections/ArrayList;", "mCouponCardListAdapter", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "mCouponCardListRv", "Lcom/tencent/mm/view/recyclerview/WxRecyclerView;", "mCurrentSortInfo", "mCurrentSortWording", "mEmptyView", "Landroid/view/ViewGroup;", "mFirstLoad", "", "mHasLoadedSuccess", "mHeaderView", "mHistoryEntranceWording", "mHistoryMiniAppInfo", "Lcom/tencent/mm/protocal/protobuf/CardMiniAppInfo;", "mIsAll", "mIsLoading", "mNeedRefreshMch", "mOffset", "mPreviousSortInfo", "mRefreshLayout", "Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "mReqNum", "mScene", "mSortInfoList", "Lcom/tencent/mm/protocal/protobuf/CardSortInfoList;", "mSortTv", "Landroid/widget/TextView;", "mViewHeight", "mVisitMchId", "mVisitMchTime", "", "doDeleteVipCard", "", "merchantId", "cardId", "doGetMchInfo", "doLoadCouponCardList", "refresh", "getLayoutId", "gotoCardDetailUI", "initView", "loadSnapshot", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onFinishLocationThings", "ret", "isLocationOk", "onResume", "saveSnapshot", "showSortDialog", "updateIconMenu", "updateSortView", "updateViewByResp", "resp", "Lcom/tencent/mm/protocal/protobuf/GetCouponHomePageResponse;", "CardSpan", "Companion", "CouponCardConvertData", "CouponCardConverter", "plugin-card_release"})
public final class CouponCardListUI
  extends CardNewBaseUI
{
  public static final CouponCardListUI.b qhM;
  private final String TAG;
  private int aYO;
  private int fs;
  private boolean mGR;
  private int mScene;
  private boolean mwr;
  private ViewGroup qgI;
  private RefreshLoadMoreLayout qgY;
  private ViewGroup qgZ;
  private WxRecyclerAdapter<c> qhA;
  private final ArrayList<c> qhB;
  private int qhC;
  private boolean qhD;
  private String qhE;
  private long qhF;
  private un qhG;
  private String qhH;
  private uw qhI;
  private String qhJ;
  private int qhK;
  private int qhL;
  private boolean qhf;
  private boolean qhg;
  private int qhk;
  private WxRecyclerView qhy;
  private TextView qhz;
  
  static
  {
    AppMethodBeat.i(201535);
    qhM = new CouponCardListUI.b((byte)0);
    AppMethodBeat.o(201535);
  }
  
  public CouponCardListUI()
  {
    AppMethodBeat.i(201534);
    this.TAG = "MicroMsg.CouponCardListUI";
    this.qhB = new ArrayList();
    this.qhC = 10;
    this.qhE = "";
    this.qhJ = "";
    this.mGR = true;
    AppMethodBeat.o(201534);
  }
  
  private final void a(bma parambma)
  {
    AppMethodBeat.i(201533);
    if ((parambma.LUP == null) || (parambma.LUP.LdI.isEmpty()))
    {
      AppMethodBeat.o(201533);
      return;
    }
    parambma = parambma.LUP.LdI.iterator();
    while (parambma.hasNext())
    {
      ud localud = (ud)parambma.next();
      c localc = new c();
      p.g(localud, "cardInfo");
      localc.a(localud);
      this.qhB.add(localc);
    }
    if (this.qhB.isEmpty())
    {
      parambma = this.qgI;
      if (parambma == null) {
        p.btv("mEmptyView");
      }
      parambma.setVisibility(0);
    }
    for (;;)
    {
      parambma = this.qhA;
      if (parambma == null) {
        p.btv("mCouponCardListAdapter");
      }
      parambma.notifyDataSetChanged();
      AppMethodBeat.o(201533);
      return;
      parambma = this.qgI;
      if (parambma == null) {
        p.btv("mEmptyView");
      }
      parambma.setVisibility(8);
    }
  }
  
  private final void cxp()
  {
    AppMethodBeat.i(201530);
    un localun = this.qhG;
    if (localun != null)
    {
      removeAllOptionMenu();
      addIconOptionMenu(0, 0, 2131690843, (MenuItem.OnMenuItemClickListener)new m(localun, this));
      AppMethodBeat.o(201530);
      return;
    }
    AppMethodBeat.o(201530);
  }
  
  private final void cxq()
  {
    AppMethodBeat.i(201531);
    int i;
    Object localObject;
    ViewGroup localViewGroup;
    if (this.qhK > 0) {
      if (!((Collection)this.qhB).isEmpty())
      {
        i = 1;
        if (i == 0) {
          break label132;
        }
        localObject = this.qhz;
        if (localObject == null) {
          p.btv("mSortTv");
        }
        ((TextView)localObject).setText((CharSequence)this.qhJ);
        localObject = this.qhA;
        if (localObject == null) {
          p.btv("mCouponCardListAdapter");
        }
        localViewGroup = this.qgZ;
        if (localViewGroup == null) {
          p.btv("mHeaderView");
        }
        ((WxRecyclerAdapter)localObject).f((View)localViewGroup, 2, false);
      }
    }
    for (;;)
    {
      localObject = this.qhA;
      if (localObject == null) {
        p.btv("mCouponCardListAdapter");
      }
      ((WxRecyclerAdapter)localObject).notifyDataSetChanged();
      AppMethodBeat.o(201531);
      return;
      i = 0;
      break;
      label132:
      localObject = this.qhA;
      if (localObject == null) {
        p.btv("mCouponCardListAdapter");
      }
      localViewGroup = this.qgZ;
      if (localViewGroup == null) {
        p.btv("mHeaderView");
      }
      ((WxRecyclerAdapter)localObject).T(localViewGroup.hashCode(), false);
    }
  }
  
  private final void kA(final boolean paramBoolean)
  {
    int i = 0;
    AppMethodBeat.i(201532);
    Log.i(this.TAG, "do load vip card list: " + this.mwr + ", " + this.fs + ", " + this.qhK);
    Object localObject;
    if ((this.qhf) && (!paramBoolean))
    {
      Log.w(this.TAG, "already load complete");
      localObject = this.qgY;
      if (localObject == null) {
        p.btv("mRefreshLayout");
      }
      ((RefreshLoadMoreLayout)localObject).apT(0);
      AppMethodBeat.o(201532);
      return;
    }
    if (this.mwr)
    {
      Log.w(this.TAG, "is loading");
      AppMethodBeat.o(201532);
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
      localObject = new com.tencent.mm.plugin.card.model.b.a(i, this.qhC, this.latitude, this.dTj, this.qhK).aYH().aYI();
      p.g(localObject, "CgiGetCouponHomePage(off…ntCancelAfterDead().run()");
      d.b((com.tencent.mm.vending.g.c)localObject, (kotlin.g.a.b)new f(this, paramBoolean)).b((com.tencent.mm.vending.e.b)this);
      AppMethodBeat.o(201532);
      return;
      i = j;
    }
  }
  
  public final void ad(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(201529);
    if ((this.mGR) && (this.qhK == 1))
    {
      kA(true);
      AppMethodBeat.o(201529);
      return;
    }
    if (!paramBoolean) {
      cxi();
    }
    AppMethodBeat.o(201529);
  }
  
  public final int getLayoutId()
  {
    return 2131493390;
  }
  
  public final void initView()
  {
    AppMethodBeat.i(201526);
    Object localObject1 = findViewById(2131298715);
    p.g(localObject1, "findViewById(R.id.chpvv3_rv)");
    this.qhy = ((WxRecyclerView)localObject1);
    localObject1 = findViewById(2131298713);
    p.g(localObject1, "findViewById(R.id.chpvv3_refresh_layout)");
    this.qgY = ((RefreshLoadMoreLayout)localObject1);
    localObject1 = findViewById(2131298711);
    p.g(localObject1, "findViewById(R.id.chpvv3_empty_layout)");
    this.qgI = ((ViewGroup)localObject1);
    localObject1 = this.qhy;
    if (localObject1 == null) {
      p.btv("mCouponCardListRv");
    }
    getContext();
    ((WxRecyclerView)localObject1).setLayoutManager((RecyclerView.LayoutManager)new LinearLayoutManager(1, false));
    this.qhA = new WxRecyclerAdapter((com.tencent.mm.view.recyclerview.f)new g(this), this.qhB);
    localObject1 = this.qhy;
    if (localObject1 == null) {
      p.btv("mCouponCardListRv");
    }
    Object localObject2 = this.qhA;
    if (localObject2 == null) {
      p.btv("mCouponCardListAdapter");
    }
    ((WxRecyclerView)localObject1).setAdapter((RecyclerView.a)localObject2);
    localObject1 = getLayoutInflater();
    localObject2 = this.qhy;
    if (localObject2 == null) {
      p.btv("mCouponCardListRv");
    }
    localObject1 = ((LayoutInflater)localObject1).inflate(2131493395, (ViewGroup)localObject2, false);
    if (localObject1 == null)
    {
      localObject1 = new t("null cannot be cast to non-null type android.view.ViewGroup");
      AppMethodBeat.o(201526);
      throw ((Throwable)localObject1);
    }
    this.qgZ = ((ViewGroup)localObject1);
    localObject1 = this.qgZ;
    if (localObject1 == null) {
      p.btv("mHeaderView");
    }
    localObject2 = this.qgZ;
    if (localObject2 == null) {
      p.btv("mHeaderView");
    }
    ((ViewGroup)localObject1).setPadding(0, ((ViewGroup)localObject2).getPaddingTop(), 0, com.tencent.mm.cb.a.fromDPToPix((Context)getContext(), 12));
    localObject1 = this.qgZ;
    if (localObject1 == null) {
      p.btv("mHeaderView");
    }
    localObject1 = ((ViewGroup)localObject1).findViewById(2131298717);
    p.g(localObject1, "mHeaderView.findViewById(R.id.chpvv3_sort_tv)");
    this.qhz = ((TextView)localObject1);
    localObject1 = this.qgZ;
    if (localObject1 == null) {
      p.btv("mHeaderView");
    }
    ((ViewGroup)localObject1).setOnClickListener((View.OnClickListener)new h(this));
    localObject1 = this.qhA;
    if (localObject1 == null) {
      p.btv("mCouponCardListAdapter");
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
    ((RefreshLoadMoreLayout)localObject1).setActionCallback((RefreshLoadMoreLayout.a)new i(this));
    AppMethodBeat.o(201526);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(201525);
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
      setBackBtn((MenuItem.OnMenuItemClickListener)new j(this));
      this.mScene = getIntent().getIntExtra("scene", 0);
      paramBundle = com.tencent.mm.plugin.card.model.a.a.pVg;
      paramBundle = a.a.cuk();
      if (paramBundle != null)
      {
        this.fs = paramBundle.qGg;
        this.qhI = paramBundle.LUU;
        this.qhG = paramBundle.LUQ;
        this.qhH = paramBundle.LUR;
        cxp();
        a(paramBundle);
      }
      paramBundle = com.tencent.mm.plugin.card.model.a.a.pVg;
      paramBundle = a.a.cuo();
      if (paramBundle != null)
      {
        this.qhK = paramBundle.Leq;
        localObject = paramBundle.Les;
        p.g(localObject, "cardSortInfo.sort_wording");
        this.qhJ = ((String)localObject);
        this.qhC = paramBundle.Ler;
        this.qhL = this.qhK;
      }
      if ((this.qhI == null) || (this.mScene != 1)) {
        break label311;
      }
      paramBundle = this.qhI;
      if (paramBundle == null) {
        p.hyc();
      }
      paramBundle = paramBundle.Let.iterator();
      while (paramBundle.hasNext())
      {
        localObject = (uv)paramBundle.next();
        if (((uv)localObject).Leq == 2)
        {
          this.qhK = 2;
          localObject = ((uv)localObject).Les;
          p.g(localObject, "sortInfo.sort_wording");
          this.qhJ = ((String)localObject);
        }
      }
      i = 0;
      break;
      label301:
      setMMTitle(2131756989);
    }
    label311:
    cxq();
    cxq();
    if (this.qhK != 1) {
      kA(true);
    }
    AppMethodBeat.o(201525);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(201528);
    super.onDestroy();
    if (!this.qhg)
    {
      Log.i(this.TAG, "no data to save snapshot");
      AppMethodBeat.o(201528);
      return;
    }
    Object localObject1 = new bma();
    ((bma)localObject1).BaseResponse = new BaseResponse();
    ((bma)localObject1).BaseResponse.ErrMsg = new dqi();
    ((bma)localObject1).LUP = new uh();
    Object localObject2 = this.qhB.iterator();
    while (((Iterator)localObject2).hasNext())
    {
      ud localud = ((c)((Iterator)localObject2).next()).cxr();
      if (localud != null) {
        ((bma)localObject1).LUP.LdI.add(localud);
      }
    }
    ((bma)localObject1).LUU = this.qhI;
    ((bma)localObject1).qGg = this.fs;
    ((bma)localObject1).LUR = this.qhH;
    ((bma)localObject1).LUQ = this.qhG;
    localObject2 = com.tencent.mm.plugin.card.model.a.a.pVg;
    p.h(localObject1, "response");
    Log.d(com.tencent.mm.plugin.card.model.a.a.access$getTAG$cp(), "save vip card list snapshot");
    d.i((kotlin.g.a.a)new a.a.b((bma)localObject1));
    localObject1 = new uv();
    ((uv)localObject1).Leq = this.qhK;
    ((uv)localObject1).Les = this.qhJ;
    ((uv)localObject1).Ler = this.qhC;
    localObject2 = com.tencent.mm.plugin.card.model.a.a.pVg;
    p.h(localObject1, "sortInfo");
    Log.d(com.tencent.mm.plugin.card.model.a.a.access$getTAG$cp(), "save vip card list snapshot");
    d.i((kotlin.g.a.a)new a.a.d((uv)localObject1));
    AppMethodBeat.o(201528);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(201527);
    super.onResume();
    Log.i(this.TAG, "do get mch infoset: %s", new Object[] { Boolean.valueOf(this.qhD) });
    if (this.qhD) {
      new com.tencent.mm.plugin.card.model.a.f(this.qhE, this.qhF, this.latitude, this.dTj, this.qhK, 1).aYH().aYI().b((com.tencent.mm.vending.c.a)new e(this)).a((com.tencent.mm.vending.e.b)this);
    }
    AppMethodBeat.o(201527);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/card/ui/v3/CouponCardListUI$CouponCardConvertData;", "Lcom/tencent/mm/view/recyclerview/ConvertData;", "(Lcom/tencent/mm/plugin/card/ui/v3/CouponCardListUI;)V", "couponCardInfo", "Lcom/tencent/mm/protocal/protobuf/CardHomePageElement;", "getCouponCardInfo", "()Lcom/tencent/mm/protocal/protobuf/CardHomePageElement;", "setCouponCardInfo", "(Lcom/tencent/mm/protocal/protobuf/CardHomePageElement;)V", "expandState", "", "getExpandState", "()Z", "setExpandState", "(Z)V", "hasRender", "getHasRender", "setHasRender", "getItemId", "", "getItemType", "", "plugin-card_release"})
  public final class c
    implements com.tencent.mm.view.recyclerview.a
  {
    boolean qfr;
    boolean qfs;
    public ud qhO;
    
    public final void a(ud paramud)
    {
      AppMethodBeat.i(201489);
      p.h(paramud, "<set-?>");
      this.qhO = paramud;
      AppMethodBeat.o(201489);
    }
    
    public final int cxn()
    {
      return 1;
    }
    
    public final ud cxr()
    {
      AppMethodBeat.i(201488);
      ud localud = this.qhO;
      if (localud == null) {
        p.btv("couponCardInfo");
      }
      AppMethodBeat.o(201488);
      return localud;
    }
    
    public final long lT()
    {
      AppMethodBeat.i(201490);
      ud localud = this.qhO;
      if (localud == null) {
        p.btv("couponCardInfo");
      }
      long l = localud.Ldn.hashCode();
      AppMethodBeat.o(201490);
      return l;
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/card/ui/v3/CouponCardListUI$CouponCardConverter;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "Lcom/tencent/mm/plugin/card/ui/v3/CouponCardListUI$CouponCardConvertData;", "Lcom/tencent/mm/plugin/card/ui/v3/CouponCardListUI;", "(Lcom/tencent/mm/plugin/card/ui/v3/CouponCardListUI;)V", "headerClickListener", "Landroid/view/View$OnClickListener;", "addCouponView", "", "view", "Landroid/view/View;", "parentView", "Landroid/view/ViewGroup;", "appendCouponView", "offset", "", "len", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "position", "collapseCouponLayout", "expandCouponLayout", "getLayoutId", "onBindViewHolder", "type", "isHotPatch", "", "payloads", "", "", "onCreateViewHolder", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "showCollapseLayout", "showExpandLayout", "showMiniAppLayout", "updateCardLabelLayout", "couponLabelList", "", "Lcom/tencent/mm/protocal/protobuf/CardElementCouponLabel;", "labelLayout", "Landroid/widget/LinearLayout;", "updateExpandLayout", "isExpended", "plugin-card_release"})
  public final class d
    extends com.tencent.mm.view.recyclerview.e<CouponCardListUI.c>
  {
    private static void a(com.tencent.mm.view.recyclerview.h paramh, CouponCardListUI.c paramc)
    {
      AppMethodBeat.i(201502);
      paramc = paramc.cxr();
      TextView localTextView = (TextView)paramh.Mn(2131298687);
      ImageView localImageView = (ImageView)paramh.Mn(2131298685);
      paramh = (ViewGroup)paramh.Mn(2131298686);
      if (!Util.isNullOrNil(paramc.Ldt))
      {
        if (!Util.isNullOrNil(paramc.Ldu)) {
          localTextView.setTextColor(Color.parseColor(paramc.Ldu));
        }
        p.g(localTextView, "chpiExpandTv");
        localTextView.setText((CharSequence)paramc.Ldt);
        localImageView.setImageResource(2131231500);
        paramh.setOnClickListener((View.OnClickListener)new i(paramc));
      }
      AppMethodBeat.o(201502);
    }
    
    private final void a(final com.tencent.mm.view.recyclerview.h paramh, final CouponCardListUI.c paramc, final int paramInt)
    {
      AppMethodBeat.i(201503);
      ud localud = paramc.cxr();
      TextView localTextView = (TextView)paramh.Mn(2131298687);
      ImageView localImageView = (ImageView)paramh.Mn(2131298685);
      ViewGroup localViewGroup = (ViewGroup)paramh.Mn(2131298686);
      p.g(localTextView, "chpiExpandTv");
      Resources localResources = MMApplicationContext.getResources();
      if (localud == null) {
        p.hyc();
      }
      localTextView.setText((CharSequence)localResources.getString(2131757041, new Object[] { Integer.valueOf(localud.Ldy - localud.Ldz) }));
      localViewGroup.setOnClickListener((View.OnClickListener)new h(this, paramh, paramc, paramInt));
      localImageView.setImageResource(2131231561);
      p.g(localImageView, "chpiExpandIv");
      localImageView.setVisibility(0);
      AppMethodBeat.o(201503);
    }
    
    private final void a(List<? extends tz> paramList, LinearLayout paramLinearLayout)
    {
      AppMethodBeat.i(201507);
      paramList = paramList.iterator();
      if (paramList.hasNext())
      {
        tz localtz = (tz)paramList.next();
        CardTagTextView localCardTagTextView = new CardTagTextView((Context)this.qhN.getContext());
        AppCompatActivity localAppCompatActivity = this.qhN.getContext();
        localCardTagTextView.setMinHeight(com.tencent.mm.cb.a.fromDPToPix((Context)localAppCompatActivity, 18));
        localCardTagTextView.setMinWidth(com.tencent.mm.cb.a.fromDPToPix((Context)localAppCompatActivity, 56));
        int i = com.tencent.mm.cb.a.fromDPToPix((Context)localAppCompatActivity, 8);
        int j = com.tencent.mm.cb.a.fromDPToPix((Context)localAppCompatActivity, 4);
        localCardTagTextView.setPadding(i, j, i, j);
        localCardTagTextView.setText((CharSequence)localtz.LcI);
        localCardTagTextView.setTextSize(1, 10.0F);
        if (!Util.isNullOrNil(localtz.LcJ))
        {
          localCardTagTextView.setTextColor(Color.parseColor(localtz.LcJ));
          label169:
          if (Util.isNullOrNil(localtz.LcK)) {
            break label219;
          }
          localCardTagTextView.setFillColor(com.tencent.mm.plugin.card.d.l.cT(localtz.LcK, localtz.LcN));
        }
        for (;;)
        {
          paramLinearLayout.addView((View)localCardTagTextView);
          break;
          localCardTagTextView.setTextColor(-1);
          break label169;
          label219:
          localCardTagTextView.setFillColor(com.tencent.mm.plugin.card.d.l.fj(-16777216, 26));
        }
      }
      AppMethodBeat.o(201507);
    }
    
    private static void b(View paramView, ViewGroup paramViewGroup)
    {
      AppMethodBeat.i(201508);
      if (paramViewGroup.getChildCount() == 0)
      {
        paramViewGroup.addView(paramView);
        AppMethodBeat.o(201508);
        return;
      }
      ViewGroup.MarginLayoutParams localMarginLayoutParams = new ViewGroup.MarginLayoutParams(-1, com.tencent.mm.cb.a.fromDPToPix(paramViewGroup.getContext(), 84));
      localMarginLayoutParams.topMargin = com.tencent.mm.cb.a.fromDPToPix(paramViewGroup.getContext(), 8);
      paramViewGroup.addView(paramView, (ViewGroup.LayoutParams)new LinearLayout.LayoutParams(localMarginLayoutParams));
      AppMethodBeat.o(201508);
    }
    
    private final void b(final com.tencent.mm.view.recyclerview.h paramh, final CouponCardListUI.c paramc, final int paramInt)
    {
      AppMethodBeat.i(201504);
      paramc.cxr();
      TextView localTextView = (TextView)paramh.Mn(2131298687);
      ImageView localImageView = (ImageView)paramh.Mn(2131298685);
      ViewGroup localViewGroup = (ViewGroup)paramh.Mn(2131298686);
      p.g(localTextView, "chpiExpandTv");
      localTextView.setText((CharSequence)MMApplicationContext.getResources().getString(2131757039));
      localViewGroup.setOnClickListener((View.OnClickListener)new g(this, paramh, paramc, paramInt));
      localImageView.setImageResource(2131231562);
      p.g(localImageView, "chpiExpandIv");
      localImageView.setVisibility(0);
      AppMethodBeat.o(201504);
    }
    
    final void a(int paramInt1, int paramInt2, com.tencent.mm.view.recyclerview.h paramh, final CouponCardListUI.c paramc, final int paramInt3)
    {
      AppMethodBeat.i(201506);
      paramc = paramc.cxr();
      ViewGroup localViewGroup = (ViewGroup)paramh.Mn(2131298683);
      final int k = 0;
      Object localObject1 = paramc.Lds;
      p.g(localObject1, "el.card_element_coupon_list");
      localObject1 = ((Iterable)localObject1).iterator();
      int i = 0;
      if (((Iterator)localObject1).hasNext())
      {
        final ua localua = (ua)((Iterator)localObject1).next();
        int j = i;
        final z.f localf;
        if (k >= paramInt1)
        {
          localf = new z.f();
          if (localua.LcU != 1) {
            break label494;
          }
          p.g(localViewGroup, "chpiCouponLayout");
          localObject2 = LayoutInflater.from(localViewGroup.getContext()).inflate(2131493379, localViewGroup, false);
          if (localObject2 == null)
          {
            paramh = new t("null cannot be cast to non-null type android.view.ViewGroup");
            AppMethodBeat.o(201506);
            throw paramh;
          }
          localf.SYG = ((ViewGroup)localObject2);
          localObject3 = (TextView)((ViewGroup)localf.SYG).findViewById(2131298669);
          localObject4 = (CdnImageView)((ViewGroup)localf.SYG).findViewById(2131298666);
          localTextView = (TextView)((ViewGroup)localf.SYG).findViewById(2131298667);
          localObject2 = (LinearLayout)((ViewGroup)localf.SYG).findViewById(2131298668);
          if (!Util.isNullOrNil(localua.LcX)) {
            ((TextView)localObject3).setTextColor(com.tencent.mm.plugin.card.d.l.cT(localua.LcX, localua.LcY));
          }
          p.g(localObject3, "titleTv");
          ((TextView)localObject3).setText((CharSequence)localua.LcO);
          ((CdnImageView)localObject4).setUrl(localua.LcV);
          if (!Util.isNullOrNil(localua.LcZ)) {
            localTextView.setTextColor(com.tencent.mm.plugin.card.d.l.cT(localua.LcZ, localua.Lda));
          }
          p.g(localTextView, "descTv");
          localTextView.setText((CharSequence)localua.LcP);
          localObject3 = localua.LcT;
          p.g(localObject3, "coupon.coupon_label");
          localObject3 = (List)localObject3;
          p.g(localObject2, "labelLayout");
          a((List)localObject3, (LinearLayout)localObject2);
          localViewGroup.getChildCount();
          ((ViewGroup)localf.SYG).setOnClickListener((View.OnClickListener)new a(this, paramc, localua, k, paramInt3));
          ((ViewGroup)localf.SYG).setTag(localua.KDM);
          b((View)localf.SYG, localViewGroup);
        }
        label494:
        while (localua.LcU != 2)
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
        Object localObject2 = LayoutInflater.from(localViewGroup.getContext()).inflate(2131493378, localViewGroup, false);
        if (localObject2 == null)
        {
          paramh = new t("null cannot be cast to non-null type android.view.ViewGroup");
          AppMethodBeat.o(201506);
          throw paramh;
        }
        localf.SYG = ((ViewGroup)localObject2);
        Object localObject4 = (TextView)((ViewGroup)localf.SYG).findViewById(2131298669);
        TextView localTextView = (TextView)((ViewGroup)localf.SYG).findViewById(2131298667);
        localObject2 = (LinearLayout)((ViewGroup)localf.SYG).findViewById(2131298668);
        MemberCardTopCropImageView localMemberCardTopCropImageView = (MemberCardTopCropImageView)((ViewGroup)localf.SYG).findViewById(2131298664);
        Object localObject3 = (ImageView)((ViewGroup)localf.SYG).findViewById(2131298665);
        if (!Util.isNullOrNil(localua.LcX)) {
          ((TextView)localObject4).setTextColor(com.tencent.mm.plugin.card.d.l.cT(localua.LcX, localua.LcY));
        }
        p.g(localObject4, "titleTv");
        ((TextView)localObject4).setText((CharSequence)localua.LcO);
        p.g(localTextView, "descTv");
        localTextView.setText((CharSequence)localua.LcP);
        p.g(localMemberCardTopCropImageView, "bgIv");
        localMemberCardTopCropImageView.setRadius(com.tencent.mm.cb.a.fromDPToPix(localMemberCardTopCropImageView.getContext(), 2));
        if (!Util.isNullOrNil(localua.LcS))
        {
          localObject4 = ((ViewGroup)localf.SYG).findViewById(2131298664);
          p.g(localObject4, "view.findViewById(R.id.chpc_bg_iv)");
          localObject4 = (kotlin.g.a.a)new d(this, (MemberCardTopCropImageView)localObject4, localua);
          if (CouponCardListUI.b(this.qhN) <= 0)
          {
            CouponCardListUI.a(this.qhN, ((ViewGroup)localf.SYG).getHeight());
            if (CouponCardListUI.b(this.qhN) <= 0)
            {
              paramh.aus.post((Runnable)new b(this, localf, (kotlin.g.a.a)localObject4));
              label869:
              p.g(localObject3, "shadowBgIv");
              ((ImageView)localObject3).setVisibility(0);
            }
          }
        }
        for (;;)
        {
          localObject3 = localua.LcT;
          p.g(localObject3, "coupon.coupon_label");
          localObject3 = (List)localObject3;
          p.g(localObject2, "labelLayout");
          a((List)localObject3, (LinearLayout)localObject2);
          localViewGroup.getChildCount();
          ((ViewGroup)localf.SYG).setOnClickListener((View.OnClickListener)new c(this, paramc, localua));
          ((ViewGroup)localf.SYG).setTag(localua.KDM);
          b((View)localf.SYG, localViewGroup);
          break;
          ((kotlin.g.a.a)localObject4).invoke();
          break label869;
          ((kotlin.g.a.a)localObject4).invoke();
          break label869;
          if (!Util.isNullOrNil(localua.LcR))
          {
            localMemberCardTopCropImageView.setImageDrawable((Drawable)new ColorDrawable(Color.parseColor(localua.LcR)));
            p.g(localObject3, "shadowBgIv");
            ((ImageView)localObject3).setVisibility(0);
          }
        }
      }
      label1061:
      AppMethodBeat.o(201506);
    }
    
    public final void a(RecyclerView paramRecyclerView, com.tencent.mm.view.recyclerview.h paramh, int paramInt)
    {
      AppMethodBeat.i(201500);
      p.h(paramRecyclerView, "recyclerView");
      p.h(paramh, "holder");
      AppMethodBeat.o(201500);
    }
    
    final void a(boolean paramBoolean, com.tencent.mm.view.recyclerview.h paramh, CouponCardListUI.c paramc, int paramInt)
    {
      AppMethodBeat.i(201505);
      ud localud = paramc.cxr();
      if (paramBoolean)
      {
        if (!Util.isNullOrNil(localud.Ldt))
        {
          a(paramh, paramc);
          AppMethodBeat.o(201505);
          return;
        }
        b(paramh, paramc, paramInt);
        AppMethodBeat.o(201505);
        return;
      }
      a(paramh, paramc, paramInt);
      AppMethodBeat.o(201505);
    }
    
    public final int getLayoutId()
    {
      return 2131493389;
    }
    
    @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class a
      implements View.OnClickListener
    {
      a(CouponCardListUI.d paramd, ud paramud, ua paramua, int paramInt1, int paramInt2) {}
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(201491);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/card/ui/v3/CouponCardListUI$CouponCardConverter$appendCouponView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
        CouponCardListUI.a(this.qhP.qhN, true);
        paramView = this.qhP.qhN;
        localObject = paramc.Ldn;
        p.g(localObject, "el.card_pack_merchant_id");
        CouponCardListUI.a(paramView, (String)localObject);
        CouponCardListUI.a(this.qhP.qhN, paramc.LdA);
        paramView = this.qhP.qhN;
        localObject = localua.KDM;
        p.g(localObject, "coupon.user_card_id");
        CouponCardListUI.b(paramView, (String)localObject);
        com.tencent.mm.plugin.report.service.h.CyF.a(19748, new Object[] { Integer.valueOf(1), Long.valueOf(System.currentTimeMillis() / 1000L), localua.KDM, Integer.valueOf(k), Integer.valueOf(paramInt3) });
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/card/ui/v3/CouponCardListUI$CouponCardConverter$appendCouponView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(201491);
      }
    }
    
    @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
    static final class b
      implements Runnable
    {
      b(CouponCardListUI.d paramd, z.f paramf, kotlin.g.a.a parama) {}
      
      public final void run()
      {
        AppMethodBeat.i(201492);
        CouponCardListUI.a(this.qhP.qhN, ((ViewGroup)localf.SYG).getHeight());
        this.qgW.invoke();
        AppMethodBeat.o(201492);
      }
    }
    
    @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class c
      implements View.OnClickListener
    {
      c(CouponCardListUI.d paramd, ud paramud, ua paramua) {}
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(201493);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/card/ui/v3/CouponCardListUI$CouponCardConverter$appendCouponView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
        CouponCardListUI.a(this.qhP.qhN, true);
        paramView = this.qhP.qhN;
        localObject = paramc.Ldn;
        p.g(localObject, "el.card_pack_merchant_id");
        CouponCardListUI.a(paramView, (String)localObject);
        CouponCardListUI.a(this.qhP.qhN, paramc.LdA);
        paramView = this.qhP.qhN;
        localObject = localua.KDM;
        p.g(localObject, "coupon.user_card_id");
        CouponCardListUI.b(paramView, (String)localObject);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/card/ui/v3/CouponCardListUI$CouponCardConverter$appendCouponView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(201493);
      }
    }
    
    @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke", "()Lkotlin/Unit;"})
    static final class d
      extends q
      implements kotlin.g.a.a<x>
    {
      d(CouponCardListUI.d paramd, MemberCardTopCropImageView paramMemberCardTopCropImageView, ua paramua)
      {
        super();
      }
    }
    
    @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class e
      implements View.OnClickListener
    {
      e(CouponCardListUI.d paramd, com.tencent.mm.view.recyclerview.h paramh) {}
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(201495);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/card/ui/v3/CouponCardListUI$CouponCardConverter$onBindViewHolder$headerClickListener$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
        Log.i(CouponCardListUI.a(this.qhP.qhN), "click header view: " + this.qhp.lR());
        paramView = ((CouponCardListUI.c)this.qhp.hgv()).cxr();
        if (paramView != null) {
          switch (paramView.Ldc)
          {
          }
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/card/ui/v3/CouponCardListUI$CouponCardConverter$onBindViewHolder$headerClickListener$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(201495);
          return;
          CouponCardListUI.a(this.qhP.qhN, true);
          localObject = this.qhP.qhN;
          String str = paramView.Ldn;
          p.g(str, "card_pack_merchant_id");
          CouponCardListUI.a((CouponCardListUI)localObject, str);
          CouponCardListUI.a(this.qhP.qhN, paramView.LdA);
          localObject = this.qhP.qhN.getContext();
          if (localObject == null)
          {
            paramView = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
            AppMethodBeat.o(201495);
            throw paramView;
          }
          com.tencent.mm.plugin.card.d.b.a((MMActivity)localObject, paramView.Ldd);
          continue;
          CouponCardListUI.a(this.qhP.qhN, true);
          localObject = this.qhP.qhN;
          str = paramView.Ldn;
          p.g(str, "card_pack_merchant_id");
          CouponCardListUI.a((CouponCardListUI)localObject, str);
          CouponCardListUI.a(this.qhP.qhN, paramView.LdA);
          paramView = paramView.Lde;
          com.tencent.mm.plugin.card.d.b.H(paramView.Hwr, paramView.Hws, paramView.IhZ);
        }
      }
    }
    
    @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class g
      implements View.OnClickListener
    {
      g(CouponCardListUI.d paramd, com.tencent.mm.view.recyclerview.h paramh, CouponCardListUI.c paramc, int paramInt) {}
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(201497);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/card/ui/v3/CouponCardListUI$CouponCardConverter$showCollapseLayout$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
        Log.d("MicroMsg.CardHomePageNewUI", "do collapse coupon layout");
        paramView = this.qhP;
        localObject = paramh;
        CouponCardListUI.c localc = paramc;
        int j = paramInt;
        ud localud = localc.cxr();
        ViewGroup localViewGroup = (ViewGroup)((com.tencent.mm.view.recyclerview.h)localObject).Mn(2131298683);
        p.g(localViewGroup, "chpiCouponLayout");
        if (localViewGroup.getChildCount() > localud.Ldz)
        {
          String str = CouponCardListUI.a(paramView.qhN);
          int i = localViewGroup.getChildCount();
          if (localud == null) {
            p.hyc();
          }
          Log.d(str, "collapse count: %s, limit: %s", new Object[] { Integer.valueOf(i), Integer.valueOf(localud.Ldz) });
          i = localViewGroup.getChildCount() - 1;
          int k = localud.Ldz;
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
        paramView.a(false, (com.tencent.mm.view.recyclerview.h)localObject, localc, j);
        paramc.qfs = false;
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/card/ui/v3/CouponCardListUI$CouponCardConverter$showCollapseLayout$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(201497);
      }
    }
    
    @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class h
      implements View.OnClickListener
    {
      h(CouponCardListUI.d paramd, com.tencent.mm.view.recyclerview.h paramh, CouponCardListUI.c paramc, int paramInt) {}
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(201498);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/card/ui/v3/CouponCardListUI$CouponCardConverter$showExpandLayout$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
        Log.d(CouponCardListUI.a(this.qhP.qhN), "do expand coupon layout");
        paramView = this.qhP;
        localObject = paramh;
        CouponCardListUI.c localc = paramc;
        int i = paramInt;
        ud localud = localc.cxr();
        ((com.tencent.mm.view.recyclerview.h)localObject).Mn(2131298687);
        ((com.tencent.mm.view.recyclerview.h)localObject).Mn(2131298685);
        ViewGroup localViewGroup1 = (ViewGroup)((com.tencent.mm.view.recyclerview.h)localObject).Mn(2131298686);
        ViewGroup localViewGroup2 = (ViewGroup)((com.tencent.mm.view.recyclerview.h)localObject).Mn(2131298683);
        p.g(localViewGroup2, "chpiCouponLayout");
        int j = localViewGroup2.getChildCount();
        if (localud == null) {
          p.hyc();
        }
        if (j < localud.Ldy)
        {
          paramView.a(localud.Ldz, -1, (com.tencent.mm.view.recyclerview.h)localObject, localc, i);
          if (localud.Ldz < localud.Ldy) {
            break label219;
          }
          p.g(localViewGroup1, "chpiExpandLayout");
          localViewGroup1.setVisibility(8);
        }
        for (;;)
        {
          paramc.qfs = true;
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/card/ui/v3/CouponCardListUI$CouponCardConverter$showExpandLayout$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(201498);
          return;
          label219:
          paramView.a(true, (com.tencent.mm.view.recyclerview.h)localObject, localc, i);
        }
      }
    }
    
    @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class i
      implements View.OnClickListener
    {
      i(ud paramud) {}
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(201499);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/card/ui/v3/CouponCardListUI$CouponCardConverter$showMiniAppLayout$1$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        if (this.qfS.Ldv != null) {
          if (this.qfS.Ldv == null) {
            break label125;
          }
        }
        label125:
        for (boolean bool = true;; bool = false)
        {
          Log.i("MicroMsg.CardHomePageNewUI", "detail goto mini app %s", new Object[] { Boolean.valueOf(bool) });
          com.tencent.mm.plugin.card.d.b.H(this.qfS.Ldv.Hwr, this.qfS.Ldv.Hws, this.qfS.Ldv.IhZ);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/card/ui/v3/CouponCardListUI$CouponCardConverter$showMiniAppLayout$1$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(201499);
          return;
        }
      }
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/GetCardPkgMchInfoResponse;", "kotlin.jvm.PlatformType", "call"})
  static final class e<_Ret, _Var>
    implements com.tencent.mm.vending.c.a<_Ret, _Var>
  {
    e(CouponCardListUI paramCouponCardListUI) {}
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/GetCouponHomePageResponse;", "kotlin.jvm.PlatformType", "invoke"})
  static final class f
    extends q
    implements kotlin.g.a.b<c.a<bma>, x>
  {
    f(CouponCardListUI paramCouponCardListUI, boolean paramBoolean)
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/card/ui/v3/CouponCardListUI$initView$1", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "getItemConvert", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "type", "", "plugin-card_release"})
  public static final class g
    implements com.tencent.mm.view.recyclerview.f
  {
    public final com.tencent.mm.view.recyclerview.e<?> EC(int paramInt)
    {
      AppMethodBeat.i(201511);
      com.tencent.mm.view.recyclerview.e locale = (com.tencent.mm.view.recyclerview.e)new CouponCardListUI.d(this.qhN);
      AppMethodBeat.o(201511);
      return locale;
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class h
    implements View.OnClickListener
  {
    h(CouponCardListUI paramCouponCardListUI) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(201512);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/card/ui/v3/CouponCardListUI$initView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
      Log.d(CouponCardListUI.a(this.qhN), "click header view");
      CouponCardListUI.c(this.qhN);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/card/ui/v3/CouponCardListUI$initView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(201512);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/card/ui/v3/CouponCardListUI$initView$3", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback;", "onLoadMoreBegin", "", "onLoadMoreEnd", "reason", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;", "", "plugin-card_release"})
  public static final class i
    extends RefreshLoadMoreLayout.a
  {
    public final void ED(int paramInt)
    {
      AppMethodBeat.i(201516);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.pH(paramInt);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/card/ui/v3/CouponCardListUI$initView$3", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshBegin", "(I)V", this, localb.axR());
      super.ED(paramInt);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/card/ui/v3/CouponCardListUI$initView$3", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshBegin", "(I)V");
      AppMethodBeat.o(201516);
    }
    
    public final void a(RefreshLoadMoreLayout.c<Object> paramc)
    {
      AppMethodBeat.i(201515);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bm(paramc);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/card/ui/v3/CouponCardListUI$initView$3", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V", this, localb.axR());
      p.h(paramc, "reason");
      Log.d(CouponCardListUI.a(this.qhN), "on load more end: " + CouponCardListUI.d(this.qhN));
      if (CouponCardListUI.e(this.qhN)) {
        CouponCardListUI.f(this.qhN).h(null);
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/card/ui/v3/CouponCardListUI$initView$3", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V");
      AppMethodBeat.o(201515);
    }
    
    public final void cxo()
    {
      AppMethodBeat.i(201514);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/card/ui/v3/CouponCardListUI$initView$3", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreBegin", "()V", this);
      Log.d(CouponCardListUI.a(this.qhN), "on load more");
      d.h((kotlin.g.a.a)new a(this));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/card/ui/v3/CouponCardListUI$initView$3", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreBegin", "()V");
      AppMethodBeat.o(201514);
    }
    
    public final void onRefreshEnd(RefreshLoadMoreLayout.c paramc)
    {
      AppMethodBeat.i(201517);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bm(paramc);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/card/ui/v3/CouponCardListUI$initView$3", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V", this, localb.axR());
      super.onRefreshEnd(paramc);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/card/ui/v3/CouponCardListUI$initView$3", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V");
      AppMethodBeat.o(201517);
    }
    
    @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
    static final class a
      extends q
      implements kotlin.g.a.a<x>
    {
      a(CouponCardListUI.i parami)
      {
        super();
      }
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class j
    implements MenuItem.OnMenuItemClickListener
  {
    j(CouponCardListUI paramCouponCardListUI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(201518);
      this.qhN.finish();
      AppMethodBeat.o(201518);
      return false;
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Lcom/tencent/mm/ui/base/MMMenu;", "kotlin.jvm.PlatformType", "onCreateMMMenu"})
  static final class k
    implements o.f
  {
    k(CouponCardListUI paramCouponCardListUI) {}
    
    public final void onCreateMMMenu(m paramm)
    {
      AppMethodBeat.i(201519);
      Object localObject = CouponCardListUI.h(this.qhN);
      if (localObject == null) {
        p.hyc();
      }
      localObject = ((uw)localObject).Let.iterator();
      while (((Iterator)localObject).hasNext())
      {
        uv localuv = (uv)((Iterator)localObject).next();
        paramm.add(0, localuv.Leq, 1, (CharSequence)localuv.Les);
      }
      AppMethodBeat.o(201519);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "menuItem", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "index", "", "onMMMenuItemSelected"})
  static final class l
    implements o.g
  {
    l(CouponCardListUI paramCouponCardListUI) {}
    
    public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
    {
      AppMethodBeat.i(201521);
      p.g(paramMenuItem, "menuItem");
      paramInt = paramMenuItem.getItemId();
      Log.i(CouponCardListUI.a(this.qhN), "click item: %s", new Object[] { Integer.valueOf(paramInt) });
      if (paramInt == 1)
      {
        if (!CouponCardListUI.i(this.qhN))
        {
          com.tencent.mm.ui.base.h.a((Context)this.qhN.getContext(), this.qhN.getString(2131757063), this.qhN.getString(2131763890), this.qhN.getString(2131762043), this.qhN.getString(2131757785), false, (DialogInterface.OnClickListener)new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(201520);
              this.qhT.qhN.startActivityForResult(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"), 564);
              AppMethodBeat.o(201520);
            }
          }, null);
          AppMethodBeat.o(201521);
          return;
        }
        CouponCardListUI.b(this.qhN, CouponCardListUI.k(this.qhN));
        CouponCardListUI.c(this.qhN, 1);
        CouponCardListUI.d(this.qhN, paramMenuItem.getTitle().toString());
        CouponCardListUI.l(this.qhN);
        CouponCardListUI.b(this.qhN, true);
        com.tencent.mm.plugin.report.service.h.CyF.a(19747, new Object[] { Integer.valueOf(2), Integer.valueOf(5) });
        AppMethodBeat.o(201521);
        return;
      }
      CouponCardListUI.b(this.qhN, CouponCardListUI.k(this.qhN));
      CouponCardListUI.c(this.qhN, paramInt);
      CouponCardListUI.d(this.qhN, paramMenuItem.getTitle().toString());
      CouponCardListUI.l(this.qhN);
      CouponCardListUI.b(this.qhN, true);
      com.tencent.mm.plugin.report.service.h.CyF.a(19747, new Object[] { Integer.valueOf(2), Integer.valueOf(6) });
      AppMethodBeat.o(201521);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick", "com/tencent/mm/plugin/card/ui/v3/CouponCardListUI$updateIconMenu$1$1"})
  static final class m
    implements MenuItem.OnMenuItemClickListener
  {
    m(un paramun, CouponCardListUI paramCouponCardListUI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(201524);
      paramMenuItem = new com.tencent.mm.ui.widget.a.e((Context)jdField_this.getContext(), 1, false);
      paramMenuItem.a((o.f)new o.f()
      {
        public final void onCreateMMMenu(m paramAnonymousm)
        {
          AppMethodBeat.i(201522);
          paramAnonymousm.add(0, 0, 1, (CharSequence)CouponCardListUI.g(this.qhV.qhN));
          AppMethodBeat.o(201522);
        }
      });
      paramMenuItem.a((o.g)new o.g()
      {
        public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
        {
          AppMethodBeat.i(201523);
          p.g(paramAnonymousMenuItem, "menuItem");
          if (paramAnonymousMenuItem.getItemId() == 0)
          {
            com.tencent.mm.plugin.card.d.b.H(this.qhV.qhU.Hwr, this.qhV.qhU.Hws, this.qhV.qhU.IhZ);
            com.tencent.mm.plugin.report.service.h.CyF.a(19747, new Object[] { Integer.valueOf(2), Integer.valueOf(2) });
          }
          AppMethodBeat.o(201523);
        }
      });
      paramMenuItem.dGm();
      com.tencent.mm.plugin.report.service.h.CyF.a(19747, new Object[] { Integer.valueOf(2), Integer.valueOf(1) });
      AppMethodBeat.o(201524);
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.v3.CouponCardListUI
 * JD-Core Version:    0.7.0.1
 */