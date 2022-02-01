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
import com.tencent.mm.protocal.protobuf.bal;
import com.tencent.mm.protocal.protobuf.cxn;
import com.tencent.mm.protocal.protobuf.su;
import com.tencent.mm.protocal.protobuf.sv;
import com.tencent.mm.protocal.protobuf.sy;
import com.tencent.mm.protocal.protobuf.tc;
import com.tencent.mm.protocal.protobuf.ti;
import com.tencent.mm.protocal.protobuf.tq;
import com.tencent.mm.protocal.protobuf.tr;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
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

@d.l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/card/ui/v3/CouponCardListUI;", "Lcom/tencent/mm/plugin/card/ui/v2/CardNewBaseUI;", "()V", "TAG", "", "loadCount", "", "mCouponCardList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/card/ui/v3/CouponCardListUI$CouponCardConvertData;", "Lkotlin/collections/ArrayList;", "mCouponCardListAdapter", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "mCouponCardListRv", "Lcom/tencent/mm/view/recyclerview/WxRecyclerView;", "mCurrentSortInfo", "mCurrentSortWording", "mEmptyView", "Landroid/view/ViewGroup;", "mFirstLoad", "", "mHasLoadedSuccess", "mHeaderView", "mHistoryEntranceWording", "mHistoryMiniAppInfo", "Lcom/tencent/mm/protocal/protobuf/CardMiniAppInfo;", "mIsAll", "mIsLoading", "mNeedRefreshMch", "mOffset", "mPreviousSortInfo", "mRefreshLayout", "Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "mReqNum", "mScene", "mSortInfoList", "Lcom/tencent/mm/protocal/protobuf/CardSortInfoList;", "mSortTv", "Landroid/widget/TextView;", "mViewHeight", "mVisitMchId", "mVisitMchTime", "", "doDeleteVipCard", "", "merchantId", "cardId", "doGetMchInfo", "doLoadCouponCardList", "refresh", "getLayoutId", "gotoCardDetailUI", "initView", "loadSnapshot", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onFinishLocationThings", "ret", "isLocationOk", "onResume", "saveSnapshot", "showSortDialog", "updateIconMenu", "updateSortView", "updateViewByResp", "resp", "Lcom/tencent/mm/protocal/protobuf/GetCouponHomePageResponse;", "CardSpan", "Companion", "CouponCardConvertData", "CouponCardConverter", "plugin-card_release"})
public final class CouponCardListUI
  extends CardNewBaseUI
{
  public static final CouponCardListUI.b oUe;
  private final String TAG;
  private int aYT;
  private int fq;
  private boolean lpM;
  private boolean lzD;
  private int mScene;
  private ViewGroup oST;
  private WxRecyclerView oTQ;
  private TextView oTR;
  private WxRecyclerAdapter<c> oTS;
  private final ArrayList<c> oTT;
  private int oTU;
  private boolean oTV;
  private String oTW;
  private long oTX;
  private ti oTY;
  private String oTZ;
  private RefreshLoadMoreLayout oTi;
  private ViewGroup oTj;
  private boolean oTp;
  private boolean oTq;
  private int oTu;
  private tr oUa;
  private String oUb;
  private int oUc;
  private int oUd;
  
  static
  {
    AppMethodBeat.i(218528);
    oUe = new CouponCardListUI.b((byte)0);
    AppMethodBeat.o(218528);
  }
  
  public CouponCardListUI()
  {
    AppMethodBeat.i(218527);
    this.TAG = "MicroMsg.CouponCardListUI";
    this.oTT = new ArrayList();
    this.oTU = 10;
    this.oTW = "";
    this.oUb = "";
    this.lzD = true;
    AppMethodBeat.o(218527);
  }
  
  private final void a(bal parambal)
  {
    AppMethodBeat.i(218526);
    if ((parambal.GQz == null) || (parambal.GQz.Gjd.isEmpty()))
    {
      AppMethodBeat.o(218526);
      return;
    }
    parambal = parambal.GQz.Gjd.iterator();
    while (parambal.hasNext())
    {
      sy localsy = (sy)parambal.next();
      c localc = new c();
      p.g(localsy, "cardInfo");
      localc.a(localsy);
      this.oTT.add(localc);
    }
    if (this.oTT.isEmpty())
    {
      parambal = this.oST;
      if (parambal == null) {
        p.bdF("mEmptyView");
      }
      parambal.setVisibility(0);
    }
    for (;;)
    {
      parambal = this.oTS;
      if (parambal == null) {
        p.bdF("mCouponCardListAdapter");
      }
      parambal.notifyDataSetChanged();
      AppMethodBeat.o(218526);
      return;
      parambal = this.oST;
      if (parambal == null) {
        p.bdF("mEmptyView");
      }
      parambal.setVisibility(8);
    }
  }
  
  private final void bZB()
  {
    AppMethodBeat.i(218523);
    ti localti = this.oTY;
    if (localti != null)
    {
      removeAllOptionMenu();
      addIconOptionMenu(0, 0, 2131690603, (MenuItem.OnMenuItemClickListener)new m(localti, this));
      AppMethodBeat.o(218523);
      return;
    }
    AppMethodBeat.o(218523);
  }
  
  private final void bZC()
  {
    AppMethodBeat.i(218524);
    int i;
    Object localObject;
    ViewGroup localViewGroup;
    if (this.oUc > 0) {
      if (!((Collection)this.oTT).isEmpty())
      {
        i = 1;
        if (i == 0) {
          break label132;
        }
        localObject = this.oTR;
        if (localObject == null) {
          p.bdF("mSortTv");
        }
        ((TextView)localObject).setText((CharSequence)this.oUb);
        localObject = this.oTS;
        if (localObject == null) {
          p.bdF("mCouponCardListAdapter");
        }
        localViewGroup = this.oTj;
        if (localViewGroup == null) {
          p.bdF("mHeaderView");
        }
        ((WxRecyclerAdapter)localObject).f((View)localViewGroup, 2, false);
      }
    }
    for (;;)
    {
      localObject = this.oTS;
      if (localObject == null) {
        p.bdF("mCouponCardListAdapter");
      }
      ((WxRecyclerAdapter)localObject).notifyDataSetChanged();
      AppMethodBeat.o(218524);
      return;
      i = 0;
      break;
      label132:
      localObject = this.oTS;
      if (localObject == null) {
        p.bdF("mCouponCardListAdapter");
      }
      localViewGroup = this.oTj;
      if (localViewGroup == null) {
        p.bdF("mHeaderView");
      }
      ((WxRecyclerAdapter)localObject).O(localViewGroup.hashCode(), false);
    }
  }
  
  private final void jx(final boolean paramBoolean)
  {
    int i = 0;
    AppMethodBeat.i(218525);
    ae.i(this.TAG, "do load vip card list: " + this.lpM + ", " + this.fq + ", " + this.oUc);
    Object localObject;
    if ((this.oTp) && (!paramBoolean))
    {
      ae.w(this.TAG, "already load complete");
      localObject = this.oTi;
      if (localObject == null) {
        p.bdF("mRefreshLayout");
      }
      ((RefreshLoadMoreLayout)localObject).agI(0);
      AppMethodBeat.o(218525);
      return;
    }
    if (this.lpM)
    {
      ae.w(this.TAG, "is loading");
      AppMethodBeat.o(218525);
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
      localObject = new com.tencent.mm.plugin.card.model.b.a(i, this.oTU, this.dzE, this.dBu, this.oUc).aES().aET();
      p.g(localObject, "CgiGetCouponHomePage(off…ntCancelAfterDead().run()");
      com.tencent.mm.ac.c.b((com.tencent.mm.vending.g.c)localObject, (d.g.a.b)new f(this, paramBoolean)).b((com.tencent.mm.vending.e.b)this);
      AppMethodBeat.o(218525);
      return;
      i = j;
    }
  }
  
  public final void X(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(218522);
    if ((this.lzD) && (this.oUc == 1))
    {
      jx(true);
      AppMethodBeat.o(218522);
      return;
    }
    if (!paramBoolean) {
      bZs();
    }
    AppMethodBeat.o(218522);
  }
  
  public final int getLayoutId()
  {
    return 2131493300;
  }
  
  public final void initView()
  {
    AppMethodBeat.i(218519);
    Object localObject1 = findViewById(2131298323);
    p.g(localObject1, "findViewById(R.id.chpvv3_rv)");
    this.oTQ = ((WxRecyclerView)localObject1);
    localObject1 = findViewById(2131298321);
    p.g(localObject1, "findViewById(R.id.chpvv3_refresh_layout)");
    this.oTi = ((RefreshLoadMoreLayout)localObject1);
    localObject1 = findViewById(2131298319);
    p.g(localObject1, "findViewById(R.id.chpvv3_empty_layout)");
    this.oST = ((ViewGroup)localObject1);
    localObject1 = this.oTQ;
    if (localObject1 == null) {
      p.bdF("mCouponCardListRv");
    }
    getContext();
    ((WxRecyclerView)localObject1).setLayoutManager((RecyclerView.i)new LinearLayoutManager(1));
    this.oTS = new WxRecyclerAdapter((com.tencent.mm.view.recyclerview.c)new g(this), this.oTT);
    localObject1 = this.oTQ;
    if (localObject1 == null) {
      p.bdF("mCouponCardListRv");
    }
    Object localObject2 = this.oTS;
    if (localObject2 == null) {
      p.bdF("mCouponCardListAdapter");
    }
    ((WxRecyclerView)localObject1).setAdapter((RecyclerView.a)localObject2);
    localObject1 = getLayoutInflater();
    localObject2 = this.oTQ;
    if (localObject2 == null) {
      p.bdF("mCouponCardListRv");
    }
    localObject1 = ((LayoutInflater)localObject1).inflate(2131493305, (ViewGroup)localObject2, false);
    if (localObject1 == null)
    {
      localObject1 = new v("null cannot be cast to non-null type android.view.ViewGroup");
      AppMethodBeat.o(218519);
      throw ((Throwable)localObject1);
    }
    this.oTj = ((ViewGroup)localObject1);
    localObject1 = this.oTj;
    if (localObject1 == null) {
      p.bdF("mHeaderView");
    }
    localObject2 = this.oTj;
    if (localObject2 == null) {
      p.bdF("mHeaderView");
    }
    ((ViewGroup)localObject1).setPadding(0, ((ViewGroup)localObject2).getPaddingTop(), 0, com.tencent.mm.cb.a.fromDPToPix((Context)getContext(), 12));
    localObject1 = this.oTj;
    if (localObject1 == null) {
      p.bdF("mHeaderView");
    }
    localObject1 = ((ViewGroup)localObject1).findViewById(2131298325);
    p.g(localObject1, "mHeaderView.findViewById(R.id.chpvv3_sort_tv)");
    this.oTR = ((TextView)localObject1);
    localObject1 = this.oTj;
    if (localObject1 == null) {
      p.bdF("mHeaderView");
    }
    ((ViewGroup)localObject1).setOnClickListener((View.OnClickListener)new h(this));
    localObject1 = this.oTS;
    if (localObject1 == null) {
      p.bdF("mCouponCardListAdapter");
    }
    localObject2 = this.oTj;
    if (localObject2 == null) {
      p.bdF("mHeaderView");
    }
    ((WxRecyclerAdapter)localObject1).f((View)localObject2, 2, false);
    localObject1 = this.oTi;
    if (localObject1 == null) {
      p.bdF("mRefreshLayout");
    }
    ((RefreshLoadMoreLayout)localObject1).setEnableRefresh(false);
    localObject1 = this.oTi;
    if (localObject1 == null) {
      p.bdF("mRefreshLayout");
    }
    ((RefreshLoadMoreLayout)localObject1).setActionCallback((RefreshLoadMoreLayout.a)new i(this));
    AppMethodBeat.o(218519);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(218518);
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
      paramBundle = com.tencent.mm.plugin.card.model.a.a.oHA;
      paramBundle = com.tencent.mm.plugin.card.model.a.a.a.bWw();
      if (paramBundle != null)
      {
        this.fq = paramBundle.pqB;
        this.oUa = paramBundle.GQE;
        this.oTY = paramBundle.GQA;
        this.oTZ = paramBundle.GQB;
        bZB();
        a(paramBundle);
      }
      paramBundle = com.tencent.mm.plugin.card.model.a.a.oHA;
      paramBundle = com.tencent.mm.plugin.card.model.a.a.a.bWx();
      if (paramBundle != null)
      {
        this.oUc = paramBundle.GjL;
        localObject = paramBundle.GjN;
        p.g(localObject, "cardSortInfo.sort_wording");
        this.oUb = ((String)localObject);
        this.oTU = paramBundle.GjM;
        this.oUd = this.oUc;
      }
      if ((this.oUa == null) || (this.mScene != 1)) {
        break label311;
      }
      paramBundle = this.oUa;
      if (paramBundle == null) {
        p.gkB();
      }
      paramBundle = paramBundle.GjO.iterator();
      while (paramBundle.hasNext())
      {
        localObject = (tq)paramBundle.next();
        if (((tq)localObject).GjL == 2)
        {
          this.oUc = 2;
          localObject = ((tq)localObject).GjN;
          p.g(localObject, "sortInfo.sort_wording");
          this.oUb = ((String)localObject);
        }
      }
      i = 0;
      break;
      label301:
      setMMTitle(2131756824);
    }
    label311:
    bZC();
    bZC();
    if (this.oUc != 1) {
      jx(true);
    }
    AppMethodBeat.o(218518);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(218521);
    super.onDestroy();
    if (!this.oTq)
    {
      ae.i(this.TAG, "no data to save snapshot");
      AppMethodBeat.o(218521);
      return;
    }
    Object localObject1 = new bal();
    ((bal)localObject1).BaseResponse = new BaseResponse();
    ((bal)localObject1).BaseResponse.ErrMsg = new cxn();
    ((bal)localObject1).GQz = new tc();
    Object localObject2 = this.oTT.iterator();
    while (((Iterator)localObject2).hasNext())
    {
      sy localsy = ((c)((Iterator)localObject2).next()).bZD();
      if (localsy != null) {
        ((bal)localObject1).GQz.Gjd.add(localsy);
      }
    }
    ((bal)localObject1).GQE = this.oUa;
    ((bal)localObject1).pqB = this.fq;
    ((bal)localObject1).GQB = this.oTZ;
    ((bal)localObject1).GQA = this.oTY;
    localObject2 = com.tencent.mm.plugin.card.model.a.a.oHA;
    p.h(localObject1, "response");
    ae.d(com.tencent.mm.plugin.card.model.a.a.access$getTAG$cp(), "save vip card list snapshot");
    com.tencent.mm.ac.c.b(null, (d.g.a.a)new a.a.a((bal)localObject1));
    localObject1 = new tq();
    ((tq)localObject1).GjL = this.oUc;
    ((tq)localObject1).GjN = this.oUb;
    ((tq)localObject1).GjM = this.oTU;
    localObject2 = com.tencent.mm.plugin.card.model.a.a.oHA;
    p.h(localObject1, "sortInfo");
    ae.d(com.tencent.mm.plugin.card.model.a.a.access$getTAG$cp(), "save vip card list snapshot");
    com.tencent.mm.ac.c.b(null, (d.g.a.a)new a.a.b((tq)localObject1));
    AppMethodBeat.o(218521);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(218520);
    super.onResume();
    ae.i(this.TAG, "do get mch infoset: %s", new Object[] { Boolean.valueOf(this.oTV) });
    if (this.oTV) {
      new com.tencent.mm.plugin.card.model.a.f(this.oTW, this.oTX, this.dzE, this.dBu, this.oUc, 1).aES().aET().b((com.tencent.mm.vending.c.a)new e(this)).a((com.tencent.mm.vending.e.b)this);
    }
    AppMethodBeat.o(218520);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/card/ui/v3/CouponCardListUI$CouponCardConvertData;", "Lcom/tencent/mm/view/recyclerview/ConvertData;", "(Lcom/tencent/mm/plugin/card/ui/v3/CouponCardListUI;)V", "couponCardInfo", "Lcom/tencent/mm/protocal/protobuf/CardHomePageElement;", "getCouponCardInfo", "()Lcom/tencent/mm/protocal/protobuf/CardHomePageElement;", "setCouponCardInfo", "(Lcom/tencent/mm/protocal/protobuf/CardHomePageElement;)V", "expandState", "", "getExpandState", "()Z", "setExpandState", "(Z)V", "hasRender", "getHasRender", "setHasRender", "getItemId", "", "getItemType", "", "plugin-card_release"})
  public final class c
    implements com.tencent.mm.view.recyclerview.a
  {
    boolean oRD;
    boolean oRE;
    public sy oUg;
    
    public final void a(sy paramsy)
    {
      AppMethodBeat.i(218482);
      p.h(paramsy, "<set-?>");
      this.oUg = paramsy;
      AppMethodBeat.o(218482);
    }
    
    public final sy bZD()
    {
      AppMethodBeat.i(218481);
      sy localsy = this.oUg;
      if (localsy == null) {
        p.bdF("couponCardInfo");
      }
      AppMethodBeat.o(218481);
      return localsy;
    }
    
    public final int bZz()
    {
      return 1;
    }
    
    public final long lP()
    {
      AppMethodBeat.i(218483);
      sy localsy = this.oUg;
      if (localsy == null) {
        p.bdF("couponCardInfo");
      }
      long l = localsy.GiJ.hashCode();
      AppMethodBeat.o(218483);
      return l;
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/card/ui/v3/CouponCardListUI$CouponCardConverter;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "Lcom/tencent/mm/plugin/card/ui/v3/CouponCardListUI$CouponCardConvertData;", "Lcom/tencent/mm/plugin/card/ui/v3/CouponCardListUI;", "(Lcom/tencent/mm/plugin/card/ui/v3/CouponCardListUI;)V", "headerClickListener", "Landroid/view/View$OnClickListener;", "addCouponView", "", "view", "Landroid/view/View;", "parentView", "Landroid/view/ViewGroup;", "appendCouponView", "offset", "", "len", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "position", "collapseCouponLayout", "expandCouponLayout", "getLayoutId", "onBindViewHolder", "type", "isHotPatch", "", "payloads", "", "", "onCreateViewHolder", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "showCollapseLayout", "showExpandLayout", "showMiniAppLayout", "updateCardLabelLayout", "couponLabelList", "", "Lcom/tencent/mm/protocal/protobuf/CardElementCouponLabel;", "labelLayout", "Landroid/widget/LinearLayout;", "updateExpandLayout", "isExpended", "plugin-card_release"})
  public final class d
    extends com.tencent.mm.view.recyclerview.b<CouponCardListUI.c>
  {
    private static void a(com.tencent.mm.view.recyclerview.e parame, CouponCardListUI.c paramc)
    {
      AppMethodBeat.i(218495);
      paramc = paramc.bZD();
      TextView localTextView = (TextView)parame.GD(2131298296);
      ImageView localImageView = (ImageView)parame.GD(2131298294);
      parame = (ViewGroup)parame.GD(2131298295);
      if (!bu.isNullOrNil(paramc.GiP))
      {
        if (!bu.isNullOrNil(paramc.GiQ)) {
          localTextView.setTextColor(Color.parseColor(paramc.GiQ));
        }
        p.g(localTextView, "chpiExpandTv");
        localTextView.setText((CharSequence)paramc.GiP);
        localImageView.setImageResource(2131231436);
        parame.setOnClickListener((View.OnClickListener)new i(paramc));
      }
      AppMethodBeat.o(218495);
    }
    
    private final void a(final com.tencent.mm.view.recyclerview.e parame, final CouponCardListUI.c paramc, final int paramInt)
    {
      AppMethodBeat.i(218496);
      sy localsy = paramc.bZD();
      TextView localTextView = (TextView)parame.GD(2131298296);
      ImageView localImageView = (ImageView)parame.GD(2131298294);
      ViewGroup localViewGroup = (ViewGroup)parame.GD(2131298295);
      p.g(localTextView, "chpiExpandTv");
      Resources localResources = ak.getResources();
      if (localsy == null) {
        p.gkB();
      }
      localTextView.setText((CharSequence)localResources.getString(2131756876, new Object[] { Integer.valueOf(localsy.GiU - localsy.GiV) }));
      localViewGroup.setOnClickListener((View.OnClickListener)new h(this, parame, paramc, paramInt));
      localImageView.setImageResource(2131231497);
      p.g(localImageView, "chpiExpandIv");
      localImageView.setVisibility(0);
      AppMethodBeat.o(218496);
    }
    
    private final void a(List<? extends su> paramList, LinearLayout paramLinearLayout)
    {
      AppMethodBeat.i(218500);
      paramList = paramList.iterator();
      if (paramList.hasNext())
      {
        su localsu = (su)paramList.next();
        CardTagTextView localCardTagTextView = new CardTagTextView((Context)this.oUf.getContext());
        AppCompatActivity localAppCompatActivity = this.oUf.getContext();
        localCardTagTextView.setMinHeight(com.tencent.mm.cb.a.fromDPToPix((Context)localAppCompatActivity, 18));
        localCardTagTextView.setMinWidth(com.tencent.mm.cb.a.fromDPToPix((Context)localAppCompatActivity, 56));
        int i = com.tencent.mm.cb.a.fromDPToPix((Context)localAppCompatActivity, 8);
        int j = com.tencent.mm.cb.a.fromDPToPix((Context)localAppCompatActivity, 4);
        localCardTagTextView.setPadding(i, j, i, j);
        localCardTagTextView.setText((CharSequence)localsu.Gif);
        localCardTagTextView.setTextSize(1, 10.0F);
        if (!bu.isNullOrNil(localsu.Gig))
        {
          localCardTagTextView.setTextColor(Color.parseColor(localsu.Gig));
          label169:
          if (bu.isNullOrNil(localsu.Gih)) {
            break label219;
          }
          localCardTagTextView.setFillColor(com.tencent.mm.plugin.card.d.l.cO(localsu.Gih, localsu.Gik));
        }
        for (;;)
        {
          paramLinearLayout.addView((View)localCardTagTextView);
          break;
          localCardTagTextView.setTextColor(-1);
          break label169;
          label219:
          localCardTagTextView.setFillColor(com.tencent.mm.plugin.card.d.l.eW(-16777216, 26));
        }
      }
      AppMethodBeat.o(218500);
    }
    
    private static void b(View paramView, ViewGroup paramViewGroup)
    {
      AppMethodBeat.i(218501);
      if (paramViewGroup.getChildCount() == 0)
      {
        paramViewGroup.addView(paramView);
        AppMethodBeat.o(218501);
        return;
      }
      ViewGroup.MarginLayoutParams localMarginLayoutParams = new ViewGroup.MarginLayoutParams(-1, com.tencent.mm.cb.a.fromDPToPix(paramViewGroup.getContext(), 84));
      localMarginLayoutParams.topMargin = com.tencent.mm.cb.a.fromDPToPix(paramViewGroup.getContext(), 8);
      paramViewGroup.addView(paramView, (ViewGroup.LayoutParams)new LinearLayout.LayoutParams(localMarginLayoutParams));
      AppMethodBeat.o(218501);
    }
    
    private final void b(final com.tencent.mm.view.recyclerview.e parame, final CouponCardListUI.c paramc, final int paramInt)
    {
      AppMethodBeat.i(218497);
      paramc.bZD();
      TextView localTextView = (TextView)parame.GD(2131298296);
      ImageView localImageView = (ImageView)parame.GD(2131298294);
      ViewGroup localViewGroup = (ViewGroup)parame.GD(2131298295);
      p.g(localTextView, "chpiExpandTv");
      localTextView.setText((CharSequence)ak.getResources().getString(2131756874));
      localViewGroup.setOnClickListener((View.OnClickListener)new g(this, parame, paramc, paramInt));
      localImageView.setImageResource(2131231498);
      p.g(localImageView, "chpiExpandIv");
      localImageView.setVisibility(0);
      AppMethodBeat.o(218497);
    }
    
    final void a(int paramInt1, int paramInt2, com.tencent.mm.view.recyclerview.e parame, final CouponCardListUI.c paramc, final int paramInt3)
    {
      AppMethodBeat.i(218499);
      paramc = paramc.bZD();
      ViewGroup localViewGroup = (ViewGroup)parame.GD(2131298292);
      final int k = 0;
      Object localObject1 = paramc.GiO;
      p.g(localObject1, "el.card_element_coupon_list");
      localObject1 = ((Iterable)localObject1).iterator();
      int i = 0;
      if (((Iterator)localObject1).hasNext())
      {
        final sv localsv = (sv)((Iterator)localObject1).next();
        int j = i;
        final y.f localf;
        if (k >= paramInt1)
        {
          localf = new y.f();
          if (localsv.Gir != 1) {
            break label494;
          }
          p.g(localViewGroup, "chpiCouponLayout");
          localObject2 = LayoutInflater.from(localViewGroup.getContext()).inflate(2131493289, localViewGroup, false);
          if (localObject2 == null)
          {
            parame = new v("null cannot be cast to non-null type android.view.ViewGroup");
            AppMethodBeat.o(218499);
            throw parame;
          }
          localf.NiY = ((ViewGroup)localObject2);
          localObject3 = (TextView)((ViewGroup)localf.NiY).findViewById(2131298279);
          localObject4 = (CdnImageView)((ViewGroup)localf.NiY).findViewById(2131298276);
          localTextView = (TextView)((ViewGroup)localf.NiY).findViewById(2131298277);
          localObject2 = (LinearLayout)((ViewGroup)localf.NiY).findViewById(2131298278);
          if (!bu.isNullOrNil(localsv.Giu)) {
            ((TextView)localObject3).setTextColor(com.tencent.mm.plugin.card.d.l.cO(localsv.Giu, localsv.Giv));
          }
          p.g(localObject3, "titleTv");
          ((TextView)localObject3).setText((CharSequence)localsv.Gil);
          ((CdnImageView)localObject4).setUrl(localsv.Gis);
          if (!bu.isNullOrNil(localsv.Giw)) {
            localTextView.setTextColor(com.tencent.mm.plugin.card.d.l.cO(localsv.Giw, localsv.Gix));
          }
          p.g(localTextView, "descTv");
          localTextView.setText((CharSequence)localsv.Gim);
          localObject3 = localsv.Giq;
          p.g(localObject3, "coupon.coupon_label");
          localObject3 = (List)localObject3;
          p.g(localObject2, "labelLayout");
          a((List)localObject3, (LinearLayout)localObject2);
          localViewGroup.getChildCount();
          ((ViewGroup)localf.NiY).setOnClickListener((View.OnClickListener)new a(this, paramc, localsv, k, paramInt3));
          ((ViewGroup)localf.NiY).setTag(localsv.FKu);
          b((View)localf.NiY, localViewGroup);
        }
        label494:
        while (localsv.Gir != 2)
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
          AppMethodBeat.o(218499);
          throw parame;
        }
        localf.NiY = ((ViewGroup)localObject2);
        Object localObject4 = (TextView)((ViewGroup)localf.NiY).findViewById(2131298279);
        TextView localTextView = (TextView)((ViewGroup)localf.NiY).findViewById(2131298277);
        localObject2 = (LinearLayout)((ViewGroup)localf.NiY).findViewById(2131298278);
        MemberCardTopCropImageView localMemberCardTopCropImageView = (MemberCardTopCropImageView)((ViewGroup)localf.NiY).findViewById(2131298274);
        Object localObject3 = (ImageView)((ViewGroup)localf.NiY).findViewById(2131298275);
        if (!bu.isNullOrNil(localsv.Giu)) {
          ((TextView)localObject4).setTextColor(com.tencent.mm.plugin.card.d.l.cO(localsv.Giu, localsv.Giv));
        }
        p.g(localObject4, "titleTv");
        ((TextView)localObject4).setText((CharSequence)localsv.Gil);
        p.g(localTextView, "descTv");
        localTextView.setText((CharSequence)localsv.Gim);
        p.g(localMemberCardTopCropImageView, "bgIv");
        localMemberCardTopCropImageView.setRadius(com.tencent.mm.cb.a.fromDPToPix(localMemberCardTopCropImageView.getContext(), 2));
        if (!bu.isNullOrNil(localsv.Gip))
        {
          localObject4 = ((ViewGroup)localf.NiY).findViewById(2131298274);
          p.g(localObject4, "view.findViewById(R.id.chpc_bg_iv)");
          localObject4 = (d.g.a.a)new d(this, (MemberCardTopCropImageView)localObject4, localsv);
          if (CouponCardListUI.b(this.oUf) <= 0)
          {
            CouponCardListUI.a(this.oUf, ((ViewGroup)localf.NiY).getHeight());
            if (CouponCardListUI.b(this.oUf) <= 0)
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
          localObject3 = localsv.Giq;
          p.g(localObject3, "coupon.coupon_label");
          localObject3 = (List)localObject3;
          p.g(localObject2, "labelLayout");
          a((List)localObject3, (LinearLayout)localObject2);
          localViewGroup.getChildCount();
          ((ViewGroup)localf.NiY).setOnClickListener((View.OnClickListener)new c(this, paramc, localsv));
          ((ViewGroup)localf.NiY).setTag(localsv.FKu);
          b((View)localf.NiY, localViewGroup);
          break;
          ((d.g.a.a)localObject4).invoke();
          break label869;
          ((d.g.a.a)localObject4).invoke();
          break label869;
          if (!bu.isNullOrNil(localsv.Gio))
          {
            localMemberCardTopCropImageView.setImageDrawable((Drawable)new ColorDrawable(Color.parseColor(localsv.Gio)));
            p.g(localObject3, "shadowBgIv");
            ((ImageView)localObject3).setVisibility(0);
          }
        }
      }
      label1061:
      AppMethodBeat.o(218499);
    }
    
    public final void a(RecyclerView paramRecyclerView, com.tencent.mm.view.recyclerview.e parame, int paramInt)
    {
      AppMethodBeat.i(218493);
      p.h(paramRecyclerView, "recyclerView");
      p.h(parame, "holder");
      AppMethodBeat.o(218493);
    }
    
    final void a(boolean paramBoolean, com.tencent.mm.view.recyclerview.e parame, CouponCardListUI.c paramc, int paramInt)
    {
      AppMethodBeat.i(218498);
      sy localsy = paramc.bZD();
      if (paramBoolean)
      {
        if (!bu.isNullOrNil(localsy.GiP))
        {
          a(parame, paramc);
          AppMethodBeat.o(218498);
          return;
        }
        b(parame, paramc, paramInt);
        AppMethodBeat.o(218498);
        return;
      }
      a(parame, paramc, paramInt);
      AppMethodBeat.o(218498);
    }
    
    public final int getLayoutId()
    {
      return 2131493299;
    }
    
    @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class a
      implements View.OnClickListener
    {
      a(CouponCardListUI.d paramd, sy paramsy, sv paramsv, int paramInt1, int paramInt2) {}
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(218484);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/card/ui/v3/CouponCardListUI$CouponCardConverter$appendCouponView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
        CouponCardListUI.a(this.oUh.oUf, true);
        paramView = this.oUh.oUf;
        localObject = paramc.GiJ;
        p.g(localObject, "el.card_pack_merchant_id");
        CouponCardListUI.a(paramView, (String)localObject);
        CouponCardListUI.a(this.oUh.oUf, paramc.GiW);
        paramView = this.oUh.oUf;
        localObject = localsv.FKu;
        p.g(localObject, "coupon.user_card_id");
        CouponCardListUI.b(paramView, (String)localObject);
        g.yxI.f(19748, new Object[] { Integer.valueOf(1), Long.valueOf(System.currentTimeMillis() / 1000L), localsv.FKu, Integer.valueOf(k), Integer.valueOf(paramInt3) });
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/card/ui/v3/CouponCardListUI$CouponCardConverter$appendCouponView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(218484);
      }
    }
    
    @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run"})
    static final class b
      implements Runnable
    {
      b(CouponCardListUI.d paramd, y.f paramf, d.g.a.a parama) {}
      
      public final void run()
      {
        AppMethodBeat.i(218485);
        CouponCardListUI.a(this.oUh.oUf, ((ViewGroup)localf.NiY).getHeight());
        this.oTG.invoke();
        AppMethodBeat.o(218485);
      }
    }
    
    @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class c
      implements View.OnClickListener
    {
      c(CouponCardListUI.d paramd, sy paramsy, sv paramsv) {}
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(218486);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/card/ui/v3/CouponCardListUI$CouponCardConverter$appendCouponView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
        CouponCardListUI.a(this.oUh.oUf, true);
        paramView = this.oUh.oUf;
        localObject = paramc.GiJ;
        p.g(localObject, "el.card_pack_merchant_id");
        CouponCardListUI.a(paramView, (String)localObject);
        CouponCardListUI.a(this.oUh.oUf, paramc.GiW);
        paramView = this.oUh.oUf;
        localObject = localsv.FKu;
        p.g(localObject, "coupon.user_card_id");
        CouponCardListUI.b(paramView, (String)localObject);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/card/ui/v3/CouponCardListUI$CouponCardConverter$appendCouponView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(218486);
      }
    }
    
    @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke", "()Lkotlin/Unit;"})
    static final class d
      extends q
      implements d.g.a.a<z>
    {
      d(CouponCardListUI.d paramd, MemberCardTopCropImageView paramMemberCardTopCropImageView, sv paramsv)
      {
        super();
      }
    }
    
    @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class e
      implements View.OnClickListener
    {
      e(CouponCardListUI.d paramd, com.tencent.mm.view.recyclerview.e parame) {}
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(218488);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/card/ui/v3/CouponCardListUI$CouponCardConverter$onBindViewHolder$headerClickListener$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
        ae.i(CouponCardListUI.a(this.oUh.oUf), "click header view: " + this.oTF.lN());
        paramView = ((CouponCardListUI.c)this.oTF.fUY()).bZD();
        if (paramView != null) {
          switch (paramView.Giz)
          {
          }
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/card/ui/v3/CouponCardListUI$CouponCardConverter$onBindViewHolder$headerClickListener$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(218488);
          return;
          CouponCardListUI.a(this.oUh.oUf, true);
          localObject = this.oUh.oUf;
          String str = paramView.GiJ;
          p.g(str, "card_pack_merchant_id");
          CouponCardListUI.a((CouponCardListUI)localObject, str);
          CouponCardListUI.a(this.oUh.oUf, paramView.GiW);
          localObject = this.oUh.oUf.getContext();
          if (localObject == null)
          {
            paramView = new v("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
            AppMethodBeat.o(218488);
            throw paramView;
          }
          com.tencent.mm.plugin.card.d.b.a((MMActivity)localObject, paramView.GiA);
          continue;
          CouponCardListUI.a(this.oUh.oUf, true);
          localObject = this.oUh.oUf;
          str = paramView.GiJ;
          p.g(str, "card_pack_merchant_id");
          CouponCardListUI.a((CouponCardListUI)localObject, str);
          CouponCardListUI.a(this.oUh.oUf, paramView.GiW);
          paramView = paramView.GiB;
          com.tencent.mm.plugin.card.d.b.I(paramView.CRv, paramView.CRw, paramView.DyO);
        }
      }
    }
    
    @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class g
      implements View.OnClickListener
    {
      g(CouponCardListUI.d paramd, com.tencent.mm.view.recyclerview.e parame, CouponCardListUI.c paramc, int paramInt) {}
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(218490);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/card/ui/v3/CouponCardListUI$CouponCardConverter$showCollapseLayout$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
        ae.d("MicroMsg.CardHomePageNewUI", "do collapse coupon layout");
        paramView = this.oUh;
        localObject = parame;
        CouponCardListUI.c localc = paramc;
        int j = paramInt;
        sy localsy = localc.bZD();
        ViewGroup localViewGroup = (ViewGroup)((com.tencent.mm.view.recyclerview.e)localObject).GD(2131298292);
        p.g(localViewGroup, "chpiCouponLayout");
        if (localViewGroup.getChildCount() > localsy.GiV)
        {
          String str = CouponCardListUI.a(paramView.oUf);
          int i = localViewGroup.getChildCount();
          if (localsy == null) {
            p.gkB();
          }
          ae.d(str, "collapse count: %s, limit: %s", new Object[] { Integer.valueOf(i), Integer.valueOf(localsy.GiV) });
          i = localViewGroup.getChildCount() - 1;
          int k = localsy.GiV;
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
        paramc.oRE = false;
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/card/ui/v3/CouponCardListUI$CouponCardConverter$showCollapseLayout$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(218490);
      }
    }
    
    @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class h
      implements View.OnClickListener
    {
      h(CouponCardListUI.d paramd, com.tencent.mm.view.recyclerview.e parame, CouponCardListUI.c paramc, int paramInt) {}
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(218491);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/card/ui/v3/CouponCardListUI$CouponCardConverter$showExpandLayout$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
        ae.d(CouponCardListUI.a(this.oUh.oUf), "do expand coupon layout");
        paramView = this.oUh;
        localObject = parame;
        CouponCardListUI.c localc = paramc;
        int i = paramInt;
        sy localsy = localc.bZD();
        ((com.tencent.mm.view.recyclerview.e)localObject).GD(2131298296);
        ((com.tencent.mm.view.recyclerview.e)localObject).GD(2131298294);
        ViewGroup localViewGroup1 = (ViewGroup)((com.tencent.mm.view.recyclerview.e)localObject).GD(2131298295);
        ViewGroup localViewGroup2 = (ViewGroup)((com.tencent.mm.view.recyclerview.e)localObject).GD(2131298292);
        p.g(localViewGroup2, "chpiCouponLayout");
        int j = localViewGroup2.getChildCount();
        if (localsy == null) {
          p.gkB();
        }
        if (j < localsy.GiU)
        {
          paramView.a(localsy.GiV, -1, (com.tencent.mm.view.recyclerview.e)localObject, localc, i);
          if (localsy.GiV < localsy.GiU) {
            break label219;
          }
          p.g(localViewGroup1, "chpiExpandLayout");
          localViewGroup1.setVisibility(8);
        }
        for (;;)
        {
          paramc.oRE = true;
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/card/ui/v3/CouponCardListUI$CouponCardConverter$showExpandLayout$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(218491);
          return;
          label219:
          paramView.a(true, (com.tencent.mm.view.recyclerview.e)localObject, localc, i);
        }
      }
    }
    
    @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class i
      implements View.OnClickListener
    {
      i(sy paramsy) {}
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(218492);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/card/ui/v3/CouponCardListUI$CouponCardConverter$showMiniAppLayout$1$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        if (this.oSe.GiR != null) {
          if (this.oSe.GiR == null) {
            break label125;
          }
        }
        label125:
        for (boolean bool = true;; bool = false)
        {
          ae.i("MicroMsg.CardHomePageNewUI", "detail goto mini app %s", new Object[] { Boolean.valueOf(bool) });
          com.tencent.mm.plugin.card.d.b.I(this.oSe.GiR.CRv, this.oSe.GiR.CRw, this.oSe.GiR.DyO);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/card/ui/v3/CouponCardListUI$CouponCardConverter$showMiniAppLayout$1$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(218492);
          return;
        }
      }
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/GetCardPkgMchInfoResponse;", "kotlin.jvm.PlatformType", "call"})
  static final class e<_Ret, _Var>
    implements com.tencent.mm.vending.c.a<_Ret, _Var>
  {
    e(CouponCardListUI paramCouponCardListUI) {}
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/GetCouponHomePageResponse;", "kotlin.jvm.PlatformType", "invoke"})
  static final class f
    extends q
    implements d.g.a.b<com.tencent.mm.ak.a.a<bal>, z>
  {
    f(CouponCardListUI paramCouponCardListUI, boolean paramBoolean)
    {
      super();
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/card/ui/v3/CouponCardListUI$initView$1", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "getItemConvert", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "type", "", "plugin-card_release"})
  public static final class g
    implements com.tencent.mm.view.recyclerview.c
  {
    public final com.tencent.mm.view.recyclerview.b<?> AX(int paramInt)
    {
      AppMethodBeat.i(218504);
      com.tencent.mm.view.recyclerview.b localb = (com.tencent.mm.view.recyclerview.b)new CouponCardListUI.d(this.oUf);
      AppMethodBeat.o(218504);
      return localb;
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class h
    implements View.OnClickListener
  {
    h(CouponCardListUI paramCouponCardListUI) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(218505);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/card/ui/v3/CouponCardListUI$initView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
      ae.d(CouponCardListUI.a(this.oUf), "click header view");
      CouponCardListUI.c(this.oUf);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/card/ui/v3/CouponCardListUI$initView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(218505);
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/card/ui/v3/CouponCardListUI$initView$3", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback;", "onLoadMoreBegin", "", "onLoadMoreEnd", "reason", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;", "", "plugin-card_release"})
  public static final class i
    extends RefreshLoadMoreLayout.a
  {
    public final void AY(int paramInt)
    {
      AppMethodBeat.i(218509);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.mu(paramInt);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/card/ui/v3/CouponCardListUI$initView$3", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshBegin", "(I)V", this, localb.ahF());
      super.AY(paramInt);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/card/ui/v3/CouponCardListUI$initView$3", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshBegin", "(I)V");
      AppMethodBeat.o(218509);
    }
    
    public final void a(RefreshLoadMoreLayout.c<Object> paramc)
    {
      AppMethodBeat.i(218508);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bd(paramc);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/card/ui/v3/CouponCardListUI$initView$3", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V", this, localb.ahF());
      p.h(paramc, "reason");
      ae.d(CouponCardListUI.a(this.oUf), "on load more end: " + CouponCardListUI.d(this.oUf));
      if (CouponCardListUI.e(this.oUf)) {
        CouponCardListUI.f(this.oUf).k(null);
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/card/ui/v3/CouponCardListUI$initView$3", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V");
      AppMethodBeat.o(218508);
    }
    
    public final void b(RefreshLoadMoreLayout.c paramc)
    {
      AppMethodBeat.i(218510);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bd(paramc);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/card/ui/v3/CouponCardListUI$initView$3", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V", this, localb.ahF());
      super.b(paramc);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/card/ui/v3/CouponCardListUI$initView$3", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V");
      AppMethodBeat.o(218510);
    }
    
    public final void bZA()
    {
      AppMethodBeat.i(218507);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/card/ui/v3/CouponCardListUI$initView$3", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreBegin", "()V", this);
      ae.d(CouponCardListUI.a(this.oUf), "on load more");
      com.tencent.mm.ac.c.h((d.g.a.a)new a(this));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/card/ui/v3/CouponCardListUI$initView$3", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreBegin", "()V");
      AppMethodBeat.o(218507);
    }
    
    @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
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
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class j
    implements MenuItem.OnMenuItemClickListener
  {
    j(CouponCardListUI paramCouponCardListUI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(218511);
      this.oUf.finish();
      AppMethodBeat.o(218511);
      return false;
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Lcom/tencent/mm/ui/base/MMMenu;", "kotlin.jvm.PlatformType", "onCreateMMMenu"})
  static final class k
    implements n.d
  {
    k(CouponCardListUI paramCouponCardListUI) {}
    
    public final void onCreateMMMenu(com.tencent.mm.ui.base.l paraml)
    {
      AppMethodBeat.i(218512);
      Object localObject = CouponCardListUI.h(this.oUf);
      if (localObject == null) {
        p.gkB();
      }
      localObject = ((tr)localObject).GjO.iterator();
      while (((Iterator)localObject).hasNext())
      {
        tq localtq = (tq)((Iterator)localObject).next();
        paraml.add(0, localtq.GjL, 1, (CharSequence)localtq.GjN);
      }
      AppMethodBeat.o(218512);
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "menuItem", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "index", "", "onMMMenuItemSelected"})
  static final class l
    implements n.e
  {
    l(CouponCardListUI paramCouponCardListUI) {}
    
    public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
    {
      AppMethodBeat.i(218514);
      p.g(paramMenuItem, "menuItem");
      paramInt = paramMenuItem.getItemId();
      ae.i(CouponCardListUI.a(this.oUf), "click item: %s", new Object[] { Integer.valueOf(paramInt) });
      if (paramInt == 1)
      {
        if (!CouponCardListUI.i(this.oUf))
        {
          h.a((Context)this.oUf.getContext(), this.oUf.getString(2131756893), this.oUf.getString(2131761885), this.oUf.getString(2131760598), this.oUf.getString(2131757558), false, (DialogInterface.OnClickListener)new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(218513);
              this.oUl.oUf.startActivityForResult(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"), 564);
              AppMethodBeat.o(218513);
            }
          }, null);
          AppMethodBeat.o(218514);
          return;
        }
        CouponCardListUI.b(this.oUf, CouponCardListUI.k(this.oUf));
        CouponCardListUI.c(this.oUf, 1);
        CouponCardListUI.d(this.oUf, paramMenuItem.getTitle().toString());
        CouponCardListUI.l(this.oUf);
        CouponCardListUI.b(this.oUf, true);
        g.yxI.f(19747, new Object[] { Integer.valueOf(2), Integer.valueOf(5) });
        AppMethodBeat.o(218514);
        return;
      }
      CouponCardListUI.b(this.oUf, CouponCardListUI.k(this.oUf));
      CouponCardListUI.c(this.oUf, paramInt);
      CouponCardListUI.d(this.oUf, paramMenuItem.getTitle().toString());
      CouponCardListUI.l(this.oUf);
      CouponCardListUI.b(this.oUf, true);
      g.yxI.f(19747, new Object[] { Integer.valueOf(2), Integer.valueOf(6) });
      AppMethodBeat.o(218514);
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick", "com/tencent/mm/plugin/card/ui/v3/CouponCardListUI$updateIconMenu$1$1"})
  static final class m
    implements MenuItem.OnMenuItemClickListener
  {
    m(ti paramti, CouponCardListUI paramCouponCardListUI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(218517);
      paramMenuItem = new com.tencent.mm.ui.widget.a.e((Context)jdField_this.getContext(), 1, false);
      paramMenuItem.a((n.d)new n.d()
      {
        public final void onCreateMMMenu(com.tencent.mm.ui.base.l paramAnonymousl)
        {
          AppMethodBeat.i(218515);
          paramAnonymousl.add(0, 0, 1, (CharSequence)CouponCardListUI.g(this.oUn.oUf));
          AppMethodBeat.o(218515);
        }
      });
      paramMenuItem.a((n.e)new n.e()
      {
        public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
        {
          AppMethodBeat.i(218516);
          p.g(paramAnonymousMenuItem, "menuItem");
          if (paramAnonymousMenuItem.getItemId() == 0)
          {
            com.tencent.mm.plugin.card.d.b.I(this.oUn.oUm.CRv, this.oUn.oUm.CRw, this.oUn.oUm.DyO);
            g.yxI.f(19747, new Object[] { Integer.valueOf(2), Integer.valueOf(2) });
          }
          AppMethodBeat.o(218516);
        }
      });
      paramMenuItem.cPF();
      g.yxI.f(19747, new Object[] { Integer.valueOf(2), Integer.valueOf(1) });
      AppMethodBeat.o(218517);
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.v3.CouponCardListUI
 * JD-Core Version:    0.7.0.1
 */