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
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.an.c.a;
import com.tencent.mm.plugin.card.a.c;
import com.tencent.mm.plugin.card.a.d;
import com.tencent.mm.plugin.card.a.e;
import com.tencent.mm.plugin.card.a.f;
import com.tencent.mm.plugin.card.a.g;
import com.tencent.mm.plugin.card.model.a.a.a.b;
import com.tencent.mm.plugin.card.model.a.a.a.d;
import com.tencent.mm.plugin.card.ui.v2.CardNewBaseUI;
import com.tencent.mm.plugin.card.widget.CardTagTextView;
import com.tencent.mm.plugin.card.widget.MemberCardTopCropImageView;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.pluginsdk.ui.span.j;
import com.tencent.mm.protocal.protobuf.btj;
import com.tencent.mm.protocal.protobuf.eaf;
import com.tencent.mm.protocal.protobuf.jh;
import com.tencent.mm.protocal.protobuf.ub;
import com.tencent.mm.protocal.protobuf.uc;
import com.tencent.mm.protocal.protobuf.uf;
import com.tencent.mm.protocal.protobuf.uj;
import com.tencent.mm.protocal.protobuf.up;
import com.tencent.mm.protocal.protobuf.ux;
import com.tencent.mm.protocal.protobuf.uy;
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
import com.tencent.mm.view.recyclerview.i;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.g.b.aa.f;
import kotlin.g.b.q;
import kotlin.t;
import kotlin.x;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/card/ui/v3/CouponCardListUI;", "Lcom/tencent/mm/plugin/card/ui/v2/CardNewBaseUI;", "()V", "TAG", "", "loadCount", "", "mCouponCardList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/card/ui/v3/CouponCardListUI$CouponCardConvertData;", "Lkotlin/collections/ArrayList;", "mCouponCardListAdapter", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "mCouponCardListRv", "Lcom/tencent/mm/view/recyclerview/WxRecyclerView;", "mCurrentSortInfo", "mCurrentSortWording", "mEmptyView", "Landroid/view/ViewGroup;", "mFirstLoad", "", "mHasLoadedSuccess", "mHeaderView", "mHistoryEntranceWording", "mHistoryMiniAppInfo", "Lcom/tencent/mm/protocal/protobuf/CardMiniAppInfo;", "mIsAll", "mIsLoading", "mNeedRefreshMch", "mOffset", "mPreviousSortInfo", "mRefreshLayout", "Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "mReqNum", "mScene", "mSortInfoList", "Lcom/tencent/mm/protocal/protobuf/CardSortInfoList;", "mSortTv", "Landroid/widget/TextView;", "mViewHeight", "mViewWidth", "mVisitMchId", "mVisitMchTime", "", "doDeleteVipCard", "", "merchantId", "cardId", "doGetMchInfo", "doLoadCouponCardList", "refresh", "getLayoutId", "gotoCardDetailUI", "initView", "loadSnapshot", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onFinishLocationThings", "ret", "isLocationOk", "onResume", "saveSnapshot", "showSortDialog", "updateIconMenu", "updateSortView", "updateViewByResp", "resp", "Lcom/tencent/mm/protocal/protobuf/GetCouponHomePageResponse;", "CardSpan", "Companion", "CouponCardConvertData", "CouponCardConverter", "plugin-card_release"})
public final class CouponCardListUI
  extends CardNewBaseUI
{
  public static final CouponCardListUI.b tDI;
  private final String TAG;
  private int aIj;
  private int aIk;
  private int mScene;
  private boolean pFW;
  private boolean puR;
  private ViewGroup tCE;
  private RefreshLoadMoreLayout tCU;
  private ViewGroup tCV;
  private String tDA;
  private long tDB;
  private up tDC;
  private String tDD;
  private uy tDE;
  private String tDF;
  private int tDG;
  private int tDH;
  private boolean tDb;
  private boolean tDc;
  private int tDg;
  private WxRecyclerView tDu;
  private TextView tDv;
  private WxRecyclerAdapter<c> tDw;
  private final ArrayList<c> tDx;
  private int tDy;
  private boolean tDz;
  private int zP;
  
  static
  {
    AppMethodBeat.i(252803);
    tDI = new CouponCardListUI.b((byte)0);
    AppMethodBeat.o(252803);
  }
  
  public CouponCardListUI()
  {
    AppMethodBeat.i(252802);
    this.TAG = "MicroMsg.CouponCardListUI";
    this.tDx = new ArrayList();
    this.tDy = 10;
    this.tDA = "";
    this.tDF = "";
    this.pFW = true;
    AppMethodBeat.o(252802);
  }
  
  private final void a(btj parambtj)
  {
    AppMethodBeat.i(252801);
    if ((parambtj.Tdx == null) || (parambtj.Tdx.SeV.isEmpty()))
    {
      AppMethodBeat.o(252801);
      return;
    }
    parambtj = parambtj.Tdx.SeV.iterator();
    while (parambtj.hasNext())
    {
      uf localuf = (uf)parambtj.next();
      c localc = new c();
      kotlin.g.b.p.j(localuf, "cardInfo");
      localc.a(localuf);
      this.tDx.add(localc);
    }
    if (this.tDx.isEmpty())
    {
      parambtj = this.tCE;
      if (parambtj == null) {
        kotlin.g.b.p.bGy("mEmptyView");
      }
      parambtj.setVisibility(0);
    }
    for (;;)
    {
      parambtj = this.tDw;
      if (parambtj == null) {
        kotlin.g.b.p.bGy("mCouponCardListAdapter");
      }
      parambtj.notifyDataSetChanged();
      AppMethodBeat.o(252801);
      return;
      parambtj = this.tCE;
      if (parambtj == null) {
        kotlin.g.b.p.bGy("mEmptyView");
      }
      parambtj.setVisibility(8);
    }
  }
  
  private final void cKR()
  {
    AppMethodBeat.i(252790);
    up localup = this.tDC;
    if (localup != null)
    {
      removeAllOptionMenu();
      addIconOptionMenu(0, 0, a.f.icons_outlined_more, (MenuItem.OnMenuItemClickListener)new m(localup, this));
      AppMethodBeat.o(252790);
      return;
    }
    AppMethodBeat.o(252790);
  }
  
  private final void cKS()
  {
    AppMethodBeat.i(252795);
    int i;
    Object localObject;
    ViewGroup localViewGroup;
    if (this.tDG > 0) {
      if (!((Collection)this.tDx).isEmpty())
      {
        i = 1;
        if (i == 0) {
          break label132;
        }
        localObject = this.tDv;
        if (localObject == null) {
          kotlin.g.b.p.bGy("mSortTv");
        }
        ((TextView)localObject).setText((CharSequence)this.tDF);
        localObject = this.tDw;
        if (localObject == null) {
          kotlin.g.b.p.bGy("mCouponCardListAdapter");
        }
        localViewGroup = this.tCV;
        if (localViewGroup == null) {
          kotlin.g.b.p.bGy("mHeaderView");
        }
        ((WxRecyclerAdapter)localObject).g((View)localViewGroup, 2, false);
      }
    }
    for (;;)
    {
      localObject = this.tDw;
      if (localObject == null) {
        kotlin.g.b.p.bGy("mCouponCardListAdapter");
      }
      ((WxRecyclerAdapter)localObject).notifyDataSetChanged();
      AppMethodBeat.o(252795);
      return;
      i = 0;
      break;
      label132:
      localObject = this.tDw;
      if (localObject == null) {
        kotlin.g.b.p.bGy("mCouponCardListAdapter");
      }
      localViewGroup = this.tCV;
      if (localViewGroup == null) {
        kotlin.g.b.p.bGy("mHeaderView");
      }
      ((WxRecyclerAdapter)localObject).T(localViewGroup.hashCode(), false);
    }
  }
  
  private final void lM(final boolean paramBoolean)
  {
    int i = 0;
    AppMethodBeat.i(252799);
    Log.i(this.TAG, "do load vip card list: " + this.puR + ", " + this.zP + ", " + this.tDG);
    Object localObject;
    if ((this.tDb) && (!paramBoolean))
    {
      Log.w(this.TAG, "already load complete");
      localObject = this.tCU;
      if (localObject == null) {
        kotlin.g.b.p.bGy("mRefreshLayout");
      }
      ((RefreshLoadMoreLayout)localObject).azs(0);
      AppMethodBeat.o(252799);
      return;
    }
    if (this.puR)
    {
      Log.w(this.TAG, "is loading");
      AppMethodBeat.o(252799);
      return;
    }
    this.puR = true;
    int j = this.zP;
    if (paramBoolean)
    {
      localObject = this.tCU;
      if (localObject == null) {
        kotlin.g.b.p.bGy("mRefreshLayout");
      }
      ((RefreshLoadMoreLayout)localObject).setHasBottomMore(true);
    }
    for (;;)
    {
      localObject = new com.tencent.mm.plugin.card.model.b.a(i, this.tDy, this.latitude, this.longitude, this.tDG).bhV().bhW();
      kotlin.g.b.p.j(localObject, "CgiGetCouponHomePage(off…ntCancelAfterDead().run()");
      d.b((com.tencent.mm.vending.g.c)localObject, (kotlin.g.a.b)new f(this, paramBoolean)).b((com.tencent.mm.vending.e.b)this);
      AppMethodBeat.o(252799);
      return;
      i = j;
    }
  }
  
  public final void ac(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(252789);
    if ((this.pFW) && (this.tDG == 1))
    {
      lM(true);
      AppMethodBeat.o(252789);
      return;
    }
    if (!paramBoolean) {
      cKL();
    }
    AppMethodBeat.o(252789);
  }
  
  public final int getLayoutId()
  {
    return a.e.tiy;
  }
  
  public final void initView()
  {
    AppMethodBeat.i(252783);
    Object localObject1 = findViewById(a.d.teJ);
    kotlin.g.b.p.j(localObject1, "findViewById(R.id.chpvv3_rv)");
    this.tDu = ((WxRecyclerView)localObject1);
    localObject1 = findViewById(a.d.teH);
    kotlin.g.b.p.j(localObject1, "findViewById(R.id.chpvv3_refresh_layout)");
    this.tCU = ((RefreshLoadMoreLayout)localObject1);
    localObject1 = findViewById(a.d.teF);
    kotlin.g.b.p.j(localObject1, "findViewById(R.id.chpvv3_empty_layout)");
    this.tCE = ((ViewGroup)localObject1);
    localObject1 = this.tDu;
    if (localObject1 == null) {
      kotlin.g.b.p.bGy("mCouponCardListRv");
    }
    getContext();
    ((WxRecyclerView)localObject1).setLayoutManager((RecyclerView.LayoutManager)new LinearLayoutManager(1, false));
    this.tDw = new WxRecyclerAdapter((com.tencent.mm.view.recyclerview.f)new CouponCardListUI.g(this), this.tDx);
    localObject1 = this.tDu;
    if (localObject1 == null) {
      kotlin.g.b.p.bGy("mCouponCardListRv");
    }
    Object localObject2 = this.tDw;
    if (localObject2 == null) {
      kotlin.g.b.p.bGy("mCouponCardListAdapter");
    }
    ((WxRecyclerView)localObject1).setAdapter((RecyclerView.a)localObject2);
    localObject1 = getLayoutInflater();
    int i = a.e.tiD;
    localObject2 = this.tDu;
    if (localObject2 == null) {
      kotlin.g.b.p.bGy("mCouponCardListRv");
    }
    localObject1 = ((LayoutInflater)localObject1).inflate(i, (ViewGroup)localObject2, false);
    if (localObject1 == null)
    {
      localObject1 = new t("null cannot be cast to non-null type android.view.ViewGroup");
      AppMethodBeat.o(252783);
      throw ((Throwable)localObject1);
    }
    this.tCV = ((ViewGroup)localObject1);
    localObject1 = this.tCV;
    if (localObject1 == null) {
      kotlin.g.b.p.bGy("mHeaderView");
    }
    localObject2 = this.tCV;
    if (localObject2 == null) {
      kotlin.g.b.p.bGy("mHeaderView");
    }
    ((ViewGroup)localObject1).setPadding(0, ((ViewGroup)localObject2).getPaddingTop(), 0, com.tencent.mm.ci.a.fromDPToPix((Context)getContext(), 12));
    localObject1 = this.tCV;
    if (localObject1 == null) {
      kotlin.g.b.p.bGy("mHeaderView");
    }
    localObject1 = ((ViewGroup)localObject1).findViewById(a.d.teL);
    kotlin.g.b.p.j(localObject1, "mHeaderView.findViewById(R.id.chpvv3_sort_tv)");
    this.tDv = ((TextView)localObject1);
    localObject1 = this.tCV;
    if (localObject1 == null) {
      kotlin.g.b.p.bGy("mHeaderView");
    }
    ((ViewGroup)localObject1).setOnClickListener((View.OnClickListener)new CouponCardListUI.h(this));
    localObject1 = this.tDw;
    if (localObject1 == null) {
      kotlin.g.b.p.bGy("mCouponCardListAdapter");
    }
    localObject2 = this.tCV;
    if (localObject2 == null) {
      kotlin.g.b.p.bGy("mHeaderView");
    }
    ((WxRecyclerAdapter)localObject1).g((View)localObject2, 2, false);
    localObject1 = this.tCU;
    if (localObject1 == null) {
      kotlin.g.b.p.bGy("mRefreshLayout");
    }
    ((RefreshLoadMoreLayout)localObject1).setEnableRefresh(false);
    localObject1 = this.tCU;
    if (localObject1 == null) {
      kotlin.g.b.p.bGy("mRefreshLayout");
    }
    ((RefreshLoadMoreLayout)localObject1).setActionCallback((RefreshLoadMoreLayout.a)new CouponCardListUI.i(this));
    AppMethodBeat.o(252783);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(252779);
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
      setActionbarColor(getResources().getColor(com.tencent.mm.plugin.card.a.a.BG_0));
      hideActionbarLine();
      setBackBtn((MenuItem.OnMenuItemClickListener)new CouponCardListUI.j(this));
      this.mScene = getIntent().getIntExtra("scene", 0);
      paramBundle = com.tencent.mm.plugin.card.model.a.a.trh;
      paramBundle = com.tencent.mm.plugin.card.model.a.a.a.cHM();
      if (paramBundle != null)
      {
        this.zP = paramBundle.ufi;
        this.tDE = paramBundle.TdC;
        this.tDC = paramBundle.Tdy;
        this.tDD = paramBundle.Tdz;
        cKR();
        a(paramBundle);
      }
      paramBundle = com.tencent.mm.plugin.card.model.a.a.trh;
      paramBundle = com.tencent.mm.plugin.card.model.a.a.a.cHQ();
      if (paramBundle != null)
      {
        this.tDG = paramBundle.SfD;
        localObject = paramBundle.SfF;
        kotlin.g.b.p.j(localObject, "cardSortInfo.sort_wording");
        this.tDF = ((String)localObject);
        this.tDy = paramBundle.SfE;
        this.tDH = this.tDG;
      }
      if ((this.tDE == null) || (this.mScene != 1)) {
        break label311;
      }
      paramBundle = this.tDE;
      if (paramBundle == null) {
        kotlin.g.b.p.iCn();
      }
      paramBundle = paramBundle.SfG.iterator();
      while (paramBundle.hasNext())
      {
        localObject = (ux)paramBundle.next();
        if (((ux)localObject).SfD == 2)
        {
          this.tDG = 2;
          localObject = ((ux)localObject).SfF;
          kotlin.g.b.p.j(localObject, "sortInfo.sort_wording");
          this.tDF = ((String)localObject);
        }
      }
      i = 0;
      break;
      label301:
      setMMTitle(a.g.thV);
    }
    label311:
    cKS();
    cKS();
    if (this.tDG != 1) {
      lM(true);
    }
    AppMethodBeat.o(252779);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(252787);
    super.onDestroy();
    if (!this.tDc)
    {
      Log.i(this.TAG, "no data to save snapshot");
      AppMethodBeat.o(252787);
      return;
    }
    Object localObject1 = new btj();
    ((btj)localObject1).BaseResponse = new jh();
    ((btj)localObject1).BaseResponse.Tef = new eaf();
    ((btj)localObject1).Tdx = new uj();
    Object localObject2 = this.tDx.iterator();
    while (((Iterator)localObject2).hasNext())
    {
      uf localuf = ((c)((Iterator)localObject2).next()).cKT();
      if (localuf != null) {
        ((btj)localObject1).Tdx.SeV.add(localuf);
      }
    }
    ((btj)localObject1).TdC = this.tDE;
    ((btj)localObject1).ufi = this.zP;
    ((btj)localObject1).Tdz = this.tDD;
    ((btj)localObject1).Tdy = this.tDC;
    localObject2 = com.tencent.mm.plugin.card.model.a.a.trh;
    kotlin.g.b.p.k(localObject1, "response");
    Log.d(com.tencent.mm.plugin.card.model.a.a.access$getTAG$cp(), "save vip card list snapshot");
    d.h((kotlin.g.a.a)new a.a.b((btj)localObject1));
    localObject1 = new ux();
    ((ux)localObject1).SfD = this.tDG;
    ((ux)localObject1).SfF = this.tDF;
    ((ux)localObject1).SfE = this.tDy;
    localObject2 = com.tencent.mm.plugin.card.model.a.a.trh;
    kotlin.g.b.p.k(localObject1, "sortInfo");
    Log.d(com.tencent.mm.plugin.card.model.a.a.access$getTAG$cp(), "save vip card list snapshot");
    d.h((kotlin.g.a.a)new a.a.d((ux)localObject1));
    AppMethodBeat.o(252787);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(252785);
    super.onResume();
    Log.i(this.TAG, "do get mch infoset: %s", new Object[] { Boolean.valueOf(this.tDz) });
    if (this.tDz) {
      new com.tencent.mm.plugin.card.model.a.f(this.tDA, this.tDB, this.latitude, this.longitude, this.tDG, 1).bhV().bhW().b((com.tencent.mm.vending.c.a)new e(this)).a((com.tencent.mm.vending.e.b)this);
    }
    AppMethodBeat.o(252785);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/card/ui/v3/CouponCardListUI$CardSpan;", "Lcom/tencent/mm/pluginsdk/ui/span/PressableClickSpan;", "linkColor", "", "bgColor", "listener", "Lcom/tencent/mm/pluginsdk/ui/span/MMSpanClickListener;", "(Lcom/tencent/mm/plugin/card/ui/v3/CouponCardListUI;IILcom/tencent/mm/pluginsdk/ui/span/MMSpanClickListener;)V", "onClick", "", "widget", "Landroid/view/View;", "plugin-card_release"})
  public final class a
    extends com.tencent.mm.pluginsdk.ui.span.p
  {
    public a(int paramInt, j paramj)
    {
      super(paramj);
      AppMethodBeat.i(251726);
      this.mClickListener = localObject;
      AppMethodBeat.o(251726);
    }
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(251722);
      kotlin.g.b.p.k(paramView, "widget");
      if (this.mClickListener != null) {
        this.mClickListener.a(paramView, null);
      }
      AppMethodBeat.o(251722);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/card/ui/v3/CouponCardListUI$CouponCardConvertData;", "Lcom/tencent/mm/view/recyclerview/ConvertData;", "(Lcom/tencent/mm/plugin/card/ui/v3/CouponCardListUI;)V", "couponCardInfo", "Lcom/tencent/mm/protocal/protobuf/CardHomePageElement;", "getCouponCardInfo", "()Lcom/tencent/mm/protocal/protobuf/CardHomePageElement;", "setCouponCardInfo", "(Lcom/tencent/mm/protocal/protobuf/CardHomePageElement;)V", "expandState", "", "getExpandState", "()Z", "setExpandState", "(Z)V", "hasRender", "getHasRender", "setHasRender", "getItemId", "", "getItemType", "", "plugin-card_release"})
  public final class c
    implements com.tencent.mm.view.recyclerview.a
  {
    boolean tBo;
    boolean tBp;
    public uf tDK;
    
    public final void a(uf paramuf)
    {
      AppMethodBeat.i(249336);
      kotlin.g.b.p.k(paramuf, "<set-?>");
      this.tDK = paramuf;
      AppMethodBeat.o(249336);
    }
    
    public final int bAQ()
    {
      return 1;
    }
    
    public final uf cKT()
    {
      AppMethodBeat.i(249335);
      uf localuf = this.tDK;
      if (localuf == null) {
        kotlin.g.b.p.bGy("couponCardInfo");
      }
      AppMethodBeat.o(249335);
      return localuf;
    }
    
    public final long mf()
    {
      AppMethodBeat.i(249337);
      uf localuf = this.tDK;
      if (localuf == null) {
        kotlin.g.b.p.bGy("couponCardInfo");
      }
      long l = localuf.SeA.hashCode();
      AppMethodBeat.o(249337);
      return l;
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/card/ui/v3/CouponCardListUI$CouponCardConverter;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "Lcom/tencent/mm/plugin/card/ui/v3/CouponCardListUI$CouponCardConvertData;", "Lcom/tencent/mm/plugin/card/ui/v3/CouponCardListUI;", "(Lcom/tencent/mm/plugin/card/ui/v3/CouponCardListUI;)V", "headerClickListener", "Landroid/view/View$OnClickListener;", "addCouponView", "", "view", "Landroid/view/View;", "parentView", "Landroid/view/ViewGroup;", "appendCouponView", "offset", "", "len", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "position", "collapseCouponLayout", "expandCouponLayout", "getLayoutId", "onBindViewHolder", "type", "isHotPatch", "", "payloads", "", "", "onCreateViewHolder", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "showCollapseLayout", "showExpandLayout", "showMiniAppLayout", "updateCardLabelLayout", "couponLabelList", "", "Lcom/tencent/mm/protocal/protobuf/CardElementCouponLabel;", "labelLayout", "Landroid/widget/LinearLayout;", "updateExpandLayout", "isExpended", "plugin-card_release"})
  public final class d
    extends com.tencent.mm.view.recyclerview.e<CouponCardListUI.c>
  {
    private static void a(i parami, CouponCardListUI.c paramc)
    {
      AppMethodBeat.i(244753);
      paramc = paramc.cKT();
      TextView localTextView = (TextView)parami.RD(a.d.tej);
      ImageView localImageView = (ImageView)parami.RD(a.d.teh);
      parami = (ViewGroup)parami.RD(a.d.tei);
      if (!Util.isNullOrNil(paramc.SeG))
      {
        if (!Util.isNullOrNil(paramc.SeH)) {
          localTextView.setTextColor(Color.parseColor(paramc.SeH));
        }
        kotlin.g.b.p.j(localTextView, "chpiExpandTv");
        localTextView.setText((CharSequence)paramc.SeG);
        localImageView.setImageResource(a.c.tad);
        parami.setOnClickListener((View.OnClickListener)new i(paramc));
      }
      AppMethodBeat.o(244753);
    }
    
    private final void a(final i parami, final CouponCardListUI.c paramc, final int paramInt)
    {
      AppMethodBeat.i(244755);
      uf localuf = paramc.cKT();
      TextView localTextView = (TextView)parami.RD(a.d.tej);
      ImageView localImageView = (ImageView)parami.RD(a.d.teh);
      ViewGroup localViewGroup = (ViewGroup)parami.RD(a.d.tei);
      kotlin.g.b.p.j(localTextView, "chpiExpandTv");
      Resources localResources = MMApplicationContext.getResources();
      int i = a.g.tks;
      if (localuf == null) {
        kotlin.g.b.p.iCn();
      }
      localTextView.setText((CharSequence)localResources.getString(i, new Object[] { Integer.valueOf(localuf.SeL - localuf.SeM) }));
      localViewGroup.setOnClickListener((View.OnClickListener)new h(this, parami, paramc, paramInt));
      localImageView.setImageResource(a.c.tal);
      kotlin.g.b.p.j(localImageView, "chpiExpandIv");
      localImageView.setVisibility(0);
      AppMethodBeat.o(244755);
    }
    
    private final void a(List<? extends ub> paramList, LinearLayout paramLinearLayout)
    {
      AppMethodBeat.i(244766);
      paramList = paramList.iterator();
      if (paramList.hasNext())
      {
        ub localub = (ub)paramList.next();
        CardTagTextView localCardTagTextView = new CardTagTextView((Context)this.tDJ.getContext());
        AppCompatActivity localAppCompatActivity = this.tDJ.getContext();
        localCardTagTextView.setMinHeight(com.tencent.mm.ci.a.fromDPToPix((Context)localAppCompatActivity, 18));
        localCardTagTextView.setMinWidth(com.tencent.mm.ci.a.fromDPToPix((Context)localAppCompatActivity, 56));
        int i = com.tencent.mm.ci.a.fromDPToPix((Context)localAppCompatActivity, 8);
        int j = com.tencent.mm.ci.a.fromDPToPix((Context)localAppCompatActivity, 4);
        localCardTagTextView.setPadding(i, j, i, j);
        localCardTagTextView.setText((CharSequence)localub.SdV);
        localCardTagTextView.setTextSize(1, 10.0F);
        if (!Util.isNullOrNil(localub.SdW))
        {
          localCardTagTextView.setTextColor(Color.parseColor(localub.SdW));
          label169:
          if (Util.isNullOrNil(localub.SdX)) {
            break label219;
          }
          localCardTagTextView.setFillColor(com.tencent.mm.plugin.card.d.l.dn(localub.SdX, localub.Sea));
        }
        for (;;)
        {
          paramLinearLayout.addView((View)localCardTagTextView);
          break;
          localCardTagTextView.setTextColor(-1);
          break label169;
          label219:
          localCardTagTextView.setFillColor(com.tencent.mm.plugin.card.d.l.fG(-16777216, 26));
        }
      }
      AppMethodBeat.o(244766);
    }
    
    private static void b(View paramView, ViewGroup paramViewGroup)
    {
      AppMethodBeat.i(244768);
      if (paramViewGroup.getChildCount() == 0)
      {
        paramViewGroup.addView(paramView);
        AppMethodBeat.o(244768);
        return;
      }
      ViewGroup.MarginLayoutParams localMarginLayoutParams = new ViewGroup.MarginLayoutParams(-1, com.tencent.mm.ci.a.fromDPToPix(paramViewGroup.getContext(), 84));
      localMarginLayoutParams.topMargin = com.tencent.mm.ci.a.fromDPToPix(paramViewGroup.getContext(), 8);
      paramViewGroup.addView(paramView, (ViewGroup.LayoutParams)new LinearLayout.LayoutParams(localMarginLayoutParams));
      AppMethodBeat.o(244768);
    }
    
    private final void b(final i parami, final CouponCardListUI.c paramc, final int paramInt)
    {
      AppMethodBeat.i(244757);
      paramc.cKT();
      TextView localTextView = (TextView)parami.RD(a.d.tej);
      ImageView localImageView = (ImageView)parami.RD(a.d.teh);
      ViewGroup localViewGroup = (ViewGroup)parami.RD(a.d.tei);
      kotlin.g.b.p.j(localTextView, "chpiExpandTv");
      localTextView.setText((CharSequence)MMApplicationContext.getResources().getString(a.g.tkq));
      localViewGroup.setOnClickListener((View.OnClickListener)new g(this, parami, paramc, paramInt));
      localImageView.setImageResource(a.c.tam);
      kotlin.g.b.p.j(localImageView, "chpiExpandIv");
      localImageView.setVisibility(0);
      AppMethodBeat.o(244757);
    }
    
    final void a(int paramInt1, int paramInt2, i parami, final CouponCardListUI.c paramc, final int paramInt3)
    {
      AppMethodBeat.i(244764);
      paramc = paramc.cKT();
      ViewGroup localViewGroup = (ViewGroup)parami.RD(a.d.tef);
      final int k = 0;
      Object localObject1 = paramc.SeF;
      kotlin.g.b.p.j(localObject1, "el.card_element_coupon_list");
      localObject1 = ((Iterable)localObject1).iterator();
      int i = 0;
      if (((Iterator)localObject1).hasNext())
      {
        final uc localuc = (uc)((Iterator)localObject1).next();
        int j = i;
        final aa.f localf;
        if (k >= paramInt1)
        {
          localf = new aa.f();
          if (localuc.Seh != 1) {
            break label494;
          }
          kotlin.g.b.p.j(localViewGroup, "chpiCouponLayout");
          localObject2 = LayoutInflater.from(localViewGroup.getContext()).inflate(a.e.tio, localViewGroup, false);
          if (localObject2 == null)
          {
            parami = new t("null cannot be cast to non-null type android.view.ViewGroup");
            AppMethodBeat.o(244764);
            throw parami;
          }
          localf.aaBC = ((ViewGroup)localObject2);
          localObject3 = (TextView)((ViewGroup)localf.aaBC).findViewById(a.d.tdR);
          localObject4 = (CdnImageView)((ViewGroup)localf.aaBC).findViewById(a.d.tdO);
          localTextView = (TextView)((ViewGroup)localf.aaBC).findViewById(a.d.tdP);
          localObject2 = (LinearLayout)((ViewGroup)localf.aaBC).findViewById(a.d.tdQ);
          if (!Util.isNullOrNil(localuc.Sek)) {
            ((TextView)localObject3).setTextColor(com.tencent.mm.plugin.card.d.l.dn(localuc.Sek, localuc.Sel));
          }
          kotlin.g.b.p.j(localObject3, "titleTv");
          ((TextView)localObject3).setText((CharSequence)localuc.Seb);
          ((CdnImageView)localObject4).setUrl(localuc.Sei);
          if (!Util.isNullOrNil(localuc.Sem)) {
            localTextView.setTextColor(com.tencent.mm.plugin.card.d.l.dn(localuc.Sem, localuc.Sen));
          }
          kotlin.g.b.p.j(localTextView, "descTv");
          localTextView.setText((CharSequence)localuc.Sec);
          localObject3 = localuc.Seg;
          kotlin.g.b.p.j(localObject3, "coupon.coupon_label");
          localObject3 = (List)localObject3;
          kotlin.g.b.p.j(localObject2, "labelLayout");
          a((List)localObject3, (LinearLayout)localObject2);
          localViewGroup.getChildCount();
          ((ViewGroup)localf.aaBC).setOnClickListener((View.OnClickListener)new a(this, paramc, localuc, k, paramInt3));
          ((ViewGroup)localf.aaBC).setTag(localuc.RFf);
          b((View)localf.aaBC, localViewGroup);
        }
        label494:
        while (localuc.Seh != 2)
        {
          j = i;
          if (paramInt2 > 0)
          {
            j = i + 1;
            if (j >= paramInt2) {
              break label1099;
            }
          }
          k += 1;
          i = j;
          break;
        }
        kotlin.g.b.p.j(localViewGroup, "chpiCouponLayout");
        Object localObject2 = LayoutInflater.from(localViewGroup.getContext()).inflate(a.e.tin, localViewGroup, false);
        if (localObject2 == null)
        {
          parami = new t("null cannot be cast to non-null type android.view.ViewGroup");
          AppMethodBeat.o(244764);
          throw parami;
        }
        localf.aaBC = ((ViewGroup)localObject2);
        Object localObject4 = (TextView)((ViewGroup)localf.aaBC).findViewById(a.d.tdR);
        TextView localTextView = (TextView)((ViewGroup)localf.aaBC).findViewById(a.d.tdP);
        localObject2 = (LinearLayout)((ViewGroup)localf.aaBC).findViewById(a.d.tdQ);
        MemberCardTopCropImageView localMemberCardTopCropImageView = (MemberCardTopCropImageView)((ViewGroup)localf.aaBC).findViewById(a.d.tdM);
        Object localObject3 = (ImageView)((ViewGroup)localf.aaBC).findViewById(a.d.tdN);
        if (!Util.isNullOrNil(localuc.Sek)) {
          ((TextView)localObject4).setTextColor(com.tencent.mm.plugin.card.d.l.dn(localuc.Sek, localuc.Sel));
        }
        kotlin.g.b.p.j(localObject4, "titleTv");
        ((TextView)localObject4).setText((CharSequence)localuc.Seb);
        kotlin.g.b.p.j(localTextView, "descTv");
        localTextView.setText((CharSequence)localuc.Sec);
        kotlin.g.b.p.j(localMemberCardTopCropImageView, "bgIv");
        localMemberCardTopCropImageView.setRadius(com.tencent.mm.ci.a.fromDPToPix(localMemberCardTopCropImageView.getContext(), 2));
        if (!Util.isNullOrNil(localuc.Sef))
        {
          localObject4 = ((ViewGroup)localf.aaBC).findViewById(a.d.tdM);
          kotlin.g.b.p.j(localObject4, "view.findViewById(R.id.chpc_bg_iv)");
          localObject4 = (kotlin.g.a.a)new d(this, (MemberCardTopCropImageView)localObject4, localuc);
          if ((CouponCardListUI.b(this.tDJ) <= 0) || (CouponCardListUI.c(this.tDJ) <= 0))
          {
            CouponCardListUI.a(this.tDJ, ((ViewGroup)localf.aaBC).getHeight());
            CouponCardListUI.b(this.tDJ, ((ViewGroup)localf.aaBC).getWidth());
            if ((CouponCardListUI.b(this.tDJ) <= 0) || (CouponCardListUI.c(this.tDJ) <= 0))
            {
              parami.amk.post((Runnable)new b(this, localf, (kotlin.g.a.a)localObject4));
              label907:
              kotlin.g.b.p.j(localObject3, "shadowBgIv");
              ((ImageView)localObject3).setVisibility(0);
            }
          }
        }
        for (;;)
        {
          localObject3 = localuc.Seg;
          kotlin.g.b.p.j(localObject3, "coupon.coupon_label");
          localObject3 = (List)localObject3;
          kotlin.g.b.p.j(localObject2, "labelLayout");
          a((List)localObject3, (LinearLayout)localObject2);
          localViewGroup.getChildCount();
          ((ViewGroup)localf.aaBC).setOnClickListener((View.OnClickListener)new c(this, paramc, localuc));
          ((ViewGroup)localf.aaBC).setTag(localuc.RFf);
          b((View)localf.aaBC, localViewGroup);
          break;
          ((kotlin.g.a.a)localObject4).invoke();
          break label907;
          ((kotlin.g.a.a)localObject4).invoke();
          break label907;
          if (!Util.isNullOrNil(localuc.See))
          {
            localMemberCardTopCropImageView.setImageDrawable((Drawable)new ColorDrawable(Color.parseColor(localuc.See)));
            kotlin.g.b.p.j(localObject3, "shadowBgIv");
            ((ImageView)localObject3).setVisibility(0);
          }
        }
      }
      label1099:
      AppMethodBeat.o(244764);
    }
    
    public final void a(RecyclerView paramRecyclerView, i parami, int paramInt)
    {
      AppMethodBeat.i(244747);
      kotlin.g.b.p.k(paramRecyclerView, "recyclerView");
      kotlin.g.b.p.k(parami, "holder");
      AppMethodBeat.o(244747);
    }
    
    final void a(boolean paramBoolean, i parami, CouponCardListUI.c paramc, int paramInt)
    {
      AppMethodBeat.i(244759);
      uf localuf = paramc.cKT();
      if (paramBoolean)
      {
        if (!Util.isNullOrNil(localuf.SeG))
        {
          a(parami, paramc);
          AppMethodBeat.o(244759);
          return;
        }
        b(parami, paramc, paramInt);
        AppMethodBeat.o(244759);
        return;
      }
      a(parami, paramc, paramInt);
      AppMethodBeat.o(244759);
    }
    
    public final int getLayoutId()
    {
      return a.e.tix;
    }
    
    @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class a
      implements View.OnClickListener
    {
      a(CouponCardListUI.d paramd, uf paramuf, uc paramuc, int paramInt1, int paramInt2) {}
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(246701);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/card/ui/v3/CouponCardListUI$CouponCardConverter$appendCouponView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
        CouponCardListUI.a(this.tDL.tDJ, true);
        paramView = this.tDL.tDJ;
        localObject = paramc.SeA;
        kotlin.g.b.p.j(localObject, "el.card_pack_merchant_id");
        CouponCardListUI.a(paramView, (String)localObject);
        CouponCardListUI.a(this.tDL.tDJ, paramc.SeN);
        paramView = this.tDL.tDJ;
        localObject = localuc.RFf;
        kotlin.g.b.p.j(localObject, "coupon.user_card_id");
        CouponCardListUI.b(paramView, (String)localObject);
        com.tencent.mm.plugin.report.service.h.IzE.a(19748, new Object[] { Integer.valueOf(1), Long.valueOf(System.currentTimeMillis() / 1000L), localuc.RFf, Integer.valueOf(k), Integer.valueOf(paramInt3) });
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/card/ui/v3/CouponCardListUI$CouponCardConverter$appendCouponView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(246701);
      }
    }
    
    @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
    static final class b
      implements Runnable
    {
      b(CouponCardListUI.d paramd, aa.f paramf, kotlin.g.a.a parama) {}
      
      public final void run()
      {
        AppMethodBeat.i(246819);
        CouponCardListUI.a(this.tDL.tDJ, ((ViewGroup)localf.aaBC).getHeight());
        CouponCardListUI.b(this.tDL.tDJ, ((ViewGroup)localf.aaBC).getWidth());
        this.tCS.invoke();
        AppMethodBeat.o(246819);
      }
    }
    
    @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class c
      implements View.OnClickListener
    {
      c(CouponCardListUI.d paramd, uf paramuf, uc paramuc) {}
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(246564);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/card/ui/v3/CouponCardListUI$CouponCardConverter$appendCouponView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
        CouponCardListUI.a(this.tDL.tDJ, true);
        paramView = this.tDL.tDJ;
        localObject = paramc.SeA;
        kotlin.g.b.p.j(localObject, "el.card_pack_merchant_id");
        CouponCardListUI.a(paramView, (String)localObject);
        CouponCardListUI.a(this.tDL.tDJ, paramc.SeN);
        paramView = this.tDL.tDJ;
        localObject = localuc.RFf;
        kotlin.g.b.p.j(localObject, "coupon.user_card_id");
        CouponCardListUI.b(paramView, (String)localObject);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/card/ui/v3/CouponCardListUI$CouponCardConverter$appendCouponView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(246564);
      }
    }
    
    @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke", "()Lkotlin/Unit;"})
    static final class d
      extends q
      implements kotlin.g.a.a<x>
    {
      d(CouponCardListUI.d paramd, MemberCardTopCropImageView paramMemberCardTopCropImageView, uc paramuc)
      {
        super();
      }
    }
    
    @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class e
      implements View.OnClickListener
    {
      e(CouponCardListUI.d paramd, i parami) {}
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(249179);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/card/ui/v3/CouponCardListUI$CouponCardConverter$onBindViewHolder$headerClickListener$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
        Log.i(CouponCardListUI.a(this.tDL.tDJ), "click header view: " + this.tDl.md());
        paramView = ((CouponCardListUI.c)this.tDl.ihX()).cKT();
        if (paramView != null) {
          switch (paramView.Sep)
          {
          }
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/card/ui/v3/CouponCardListUI$CouponCardConverter$onBindViewHolder$headerClickListener$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(249179);
          return;
          CouponCardListUI.a(this.tDL.tDJ, true);
          localObject = this.tDL.tDJ;
          String str = paramView.SeA;
          kotlin.g.b.p.j(str, "card_pack_merchant_id");
          CouponCardListUI.a((CouponCardListUI)localObject, str);
          CouponCardListUI.a(this.tDL.tDJ, paramView.SeN);
          localObject = this.tDL.tDJ.getContext();
          if (localObject == null)
          {
            paramView = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
            AppMethodBeat.o(249179);
            throw paramView;
          }
          com.tencent.mm.plugin.card.d.b.a((MMActivity)localObject, paramView.Seq);
          continue;
          CouponCardListUI.a(this.tDL.tDJ, true);
          localObject = this.tDL.tDJ;
          str = paramView.SeA;
          kotlin.g.b.p.j(str, "card_pack_merchant_id");
          CouponCardListUI.a((CouponCardListUI)localObject, str);
          CouponCardListUI.a(this.tDL.tDJ, paramView.SeN);
          paramView = paramView.Ser;
          com.tencent.mm.plugin.card.d.b.L(paramView.Ooe, paramView.Oof, paramView.Paq);
        }
      }
    }
    
    @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class g
      implements View.OnClickListener
    {
      g(CouponCardListUI.d paramd, i parami, CouponCardListUI.c paramc, int paramInt) {}
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(253605);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/card/ui/v3/CouponCardListUI$CouponCardConverter$showCollapseLayout$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
        Log.d("MicroMsg.CardHomePageNewUI", "do collapse coupon layout");
        paramView = this.tDL;
        localObject = parami;
        CouponCardListUI.c localc = paramc;
        int j = paramInt;
        uf localuf = localc.cKT();
        ViewGroup localViewGroup = (ViewGroup)((i)localObject).RD(a.d.tef);
        kotlin.g.b.p.j(localViewGroup, "chpiCouponLayout");
        if (localViewGroup.getChildCount() > localuf.SeM)
        {
          String str = CouponCardListUI.a(paramView.tDJ);
          int i = localViewGroup.getChildCount();
          if (localuf == null) {
            kotlin.g.b.p.iCn();
          }
          Log.d(str, "collapse count: %s, limit: %s", new Object[] { Integer.valueOf(i), Integer.valueOf(localuf.SeM) });
          i = localViewGroup.getChildCount() - 1;
          int k = localuf.SeM;
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
        paramView.a(false, (i)localObject, localc, j);
        paramc.tBp = false;
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/card/ui/v3/CouponCardListUI$CouponCardConverter$showCollapseLayout$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(253605);
      }
    }
    
    @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class h
      implements View.OnClickListener
    {
      h(CouponCardListUI.d paramd, i parami, CouponCardListUI.c paramc, int paramInt) {}
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(245445);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/card/ui/v3/CouponCardListUI$CouponCardConverter$showExpandLayout$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
        Log.d(CouponCardListUI.a(this.tDL.tDJ), "do expand coupon layout");
        paramView = this.tDL;
        localObject = parami;
        CouponCardListUI.c localc = paramc;
        int i = paramInt;
        uf localuf = localc.cKT();
        ((i)localObject).RD(a.d.tej);
        ((i)localObject).RD(a.d.teh);
        ViewGroup localViewGroup1 = (ViewGroup)((i)localObject).RD(a.d.tei);
        ViewGroup localViewGroup2 = (ViewGroup)((i)localObject).RD(a.d.tef);
        kotlin.g.b.p.j(localViewGroup2, "chpiCouponLayout");
        int j = localViewGroup2.getChildCount();
        if (localuf == null) {
          kotlin.g.b.p.iCn();
        }
        if (j < localuf.SeL)
        {
          paramView.a(localuf.SeM, -1, (i)localObject, localc, i);
          if (localuf.SeM < localuf.SeL) {
            break label223;
          }
          kotlin.g.b.p.j(localViewGroup1, "chpiExpandLayout");
          localViewGroup1.setVisibility(8);
        }
        for (;;)
        {
          paramc.tBp = true;
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/card/ui/v3/CouponCardListUI$CouponCardConverter$showExpandLayout$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(245445);
          return;
          label223:
          paramView.a(true, (i)localObject, localc, i);
        }
      }
    }
    
    @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class i
      implements View.OnClickListener
    {
      i(uf paramuf) {}
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(247621);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/card/ui/v3/CouponCardListUI$CouponCardConverter$showMiniAppLayout$1$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        if (this.tBP.SeI != null) {
          if (this.tBP.SeI == null) {
            break label125;
          }
        }
        label125:
        for (boolean bool = true;; bool = false)
        {
          Log.i("MicroMsg.CardHomePageNewUI", "detail goto mini app %s", new Object[] { Boolean.valueOf(bool) });
          com.tencent.mm.plugin.card.d.b.L(this.tBP.SeI.Ooe, this.tBP.SeI.Oof, this.tBP.SeI.Paq);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/card/ui/v3/CouponCardListUI$CouponCardConverter$showMiniAppLayout$1$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(247621);
          return;
        }
      }
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/GetCardPkgMchInfoResponse;", "kotlin.jvm.PlatformType", "call"})
  static final class e<_Ret, _Var>
    implements com.tencent.mm.vending.c.a<_Ret, _Var>
  {
    e(CouponCardListUI paramCouponCardListUI) {}
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/GetCouponHomePageResponse;", "kotlin.jvm.PlatformType", "invoke"})
  static final class f
    extends q
    implements kotlin.g.a.b<c.a<btj>, x>
  {
    f(CouponCardListUI paramCouponCardListUI, boolean paramBoolean)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Lcom/tencent/mm/ui/base/MMMenu;", "kotlin.jvm.PlatformType", "onCreateMMMenu"})
  static final class k
    implements q.f
  {
    k(CouponCardListUI paramCouponCardListUI) {}
    
    public final void onCreateMMMenu(o paramo)
    {
      AppMethodBeat.i(244794);
      Object localObject = CouponCardListUI.i(this.tDJ);
      if (localObject == null) {
        kotlin.g.b.p.iCn();
      }
      localObject = ((uy)localObject).SfG.iterator();
      while (((Iterator)localObject).hasNext())
      {
        ux localux = (ux)((Iterator)localObject).next();
        paramo.add(0, localux.SfD, 1, (CharSequence)localux.SfF);
      }
      AppMethodBeat.o(244794);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "menuItem", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "index", "", "onMMMenuItemSelected"})
  static final class l
    implements q.g
  {
    l(CouponCardListUI paramCouponCardListUI) {}
    
    public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
    {
      AppMethodBeat.i(248963);
      kotlin.g.b.p.j(paramMenuItem, "menuItem");
      paramInt = paramMenuItem.getItemId();
      Log.i(CouponCardListUI.a(this.tDJ), "click item: %s", new Object[] { Integer.valueOf(paramInt) });
      if (paramInt == 1)
      {
        if (!CouponCardListUI.j(this.tDJ))
        {
          com.tencent.mm.ui.base.h.a((Context)this.tDJ.getContext(), this.tDJ.getString(a.g.tkA), this.tDJ.getString(a.g.permission_tips_title), this.tDJ.getString(a.g.jump_to_settings), this.tDJ.getString(a.g.confirm_dialog_cancel), false, (DialogInterface.OnClickListener)new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(244171);
              this.tDP.tDJ.startActivityForResult(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"), 564);
              AppMethodBeat.o(244171);
            }
          }, null);
          AppMethodBeat.o(248963);
          return;
        }
        CouponCardListUI.c(this.tDJ, CouponCardListUI.l(this.tDJ));
        CouponCardListUI.d(this.tDJ, 1);
        CouponCardListUI.d(this.tDJ, paramMenuItem.getTitle().toString());
        CouponCardListUI.m(this.tDJ);
        CouponCardListUI.b(this.tDJ, true);
        com.tencent.mm.plugin.report.service.h.IzE.a(19747, new Object[] { Integer.valueOf(2), Integer.valueOf(5) });
        AppMethodBeat.o(248963);
        return;
      }
      CouponCardListUI.c(this.tDJ, CouponCardListUI.l(this.tDJ));
      CouponCardListUI.d(this.tDJ, paramInt);
      CouponCardListUI.d(this.tDJ, paramMenuItem.getTitle().toString());
      CouponCardListUI.m(this.tDJ);
      CouponCardListUI.b(this.tDJ, true);
      com.tencent.mm.plugin.report.service.h.IzE.a(19747, new Object[] { Integer.valueOf(2), Integer.valueOf(6) });
      AppMethodBeat.o(248963);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick", "com/tencent/mm/plugin/card/ui/v3/CouponCardListUI$updateIconMenu$1$1"})
  static final class m
    implements MenuItem.OnMenuItemClickListener
  {
    m(up paramup, CouponCardListUI paramCouponCardListUI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(253792);
      paramMenuItem = new com.tencent.mm.ui.widget.a.e((Context)jdField_this.getContext(), 1, false);
      paramMenuItem.a((q.f)new q.f()
      {
        public final void onCreateMMMenu(o paramAnonymouso)
        {
          AppMethodBeat.i(251588);
          paramAnonymouso.add(0, 0, 1, (CharSequence)CouponCardListUI.h(this.tDR.tDJ));
          AppMethodBeat.o(251588);
        }
      });
      paramMenuItem.a((q.g)new q.g()
      {
        public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
        {
          AppMethodBeat.i(247233);
          kotlin.g.b.p.j(paramAnonymousMenuItem, "menuItem");
          if (paramAnonymousMenuItem.getItemId() == 0)
          {
            com.tencent.mm.plugin.card.d.b.L(this.tDR.tDQ.Ooe, this.tDR.tDQ.Oof, this.tDR.tDQ.Paq);
            com.tencent.mm.plugin.report.service.h.IzE.a(19747, new Object[] { Integer.valueOf(2), Integer.valueOf(2) });
          }
          AppMethodBeat.o(247233);
        }
      });
      paramMenuItem.eik();
      com.tencent.mm.plugin.report.service.h.IzE.a(19747, new Object[] { Integer.valueOf(2), Integer.valueOf(1) });
      AppMethodBeat.o(253792);
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.v3.CouponCardListUI
 * JD-Core Version:    0.7.0.1
 */