package com.tencent.mm.plugin.card.ui.v3;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
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
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.card.d.m;
import com.tencent.mm.plugin.card.model.a.a.a.d;
import com.tencent.mm.plugin.card.model.a.a.a.e;
import com.tencent.mm.plugin.card.ui.v2.CardNewBaseUI;
import com.tencent.mm.plugin.card.widget.MemberCardTopCropImageView;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.beq;
import com.tencent.mm.protocal.protobuf.cxn;
import com.tencent.mm.protocal.protobuf.sv;
import com.tencent.mm.protocal.protobuf.ti;
import com.tencent.mm.protocal.protobuf.tq;
import com.tencent.mm.protocal.protobuf.tr;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.n.e;
import com.tencent.mm.ui.widget.RoundCornerImageView;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.RefreshLoadMoreLayout.a;
import com.tencent.mm.view.RefreshLoadMoreLayout.c;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.mm.view.recyclerview.WxRecyclerView;
import d.g.b.p;
import d.g.b.q;
import d.g.b.y.a;
import d.v;
import d.z;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;

@d.l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/card/ui/v3/VipCardListUI;", "Lcom/tencent/mm/plugin/card/ui/v2/CardNewBaseUI;", "()V", "TAG", "", "loadCount", "", "mCurrentSortInfo", "mCurrentSortWording", "mEmptyView", "Landroid/view/ViewGroup;", "mFirstLoad", "", "mHasLoadedSuccess", "mHeaderView", "mHistoryEntranceWording", "mHistoryMiniAppInfo", "Lcom/tencent/mm/protocal/protobuf/CardMiniAppInfo;", "mIsAll", "mIsLoading", "mNeedRefreshList", "mOffset", "mPhoneMemberEntranceWording", "mPhoneMemberMenuEntranceWording", "mPhoneMemberMiniAppInfo", "mPreviousSortInfo", "mRefreshLayout", "Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "mReqNum", "mSortInfoList", "Lcom/tencent/mm/protocal/protobuf/CardSortInfoList;", "mSortLayout", "mSortTv", "Landroid/widget/TextView;", "mTopPhoneVipCardLayout", "mTopPhoneVipCardTv", "mViewHeight", "mVipCardList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/card/ui/v3/VipCardListUI$VipCardConvertData;", "Lkotlin/collections/ArrayList;", "mVipCardListAdapter", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "mVipCardListRv", "Lcom/tencent/mm/view/recyclerview/WxRecyclerView;", "doDeleteVipCard", "", "cardId", "doLoadVipCardList", "refresh", "getLayoutId", "getPositionByUserCardId", "gotoCardDetailUI", "initView", "loadSnapshot", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onFinishLocationThings", "ret", "isLocationOk", "onResume", "saveSnapshot", "showSortDialog", "updateIconMenu", "updateTopHeaderLayout", "updateViewByResp", "resp", "Lcom/tencent/mm/protocal/protobuf/GetMemberCardHomePageResponse;", "Companion", "VipCardConvertData", "VipCardConverter", "plugin-card_release"})
public final class VipCardListUI
  extends CardNewBaseUI
{
  public static final VipCardListUI.a oUy;
  private final String TAG;
  private int aYT;
  private int fq;
  private boolean lpM;
  private boolean lzD;
  private ViewGroup oST;
  private TextView oTR;
  private int oTU;
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
  private WxRecyclerView oUo;
  private ViewGroup oUp;
  private ViewGroup oUq;
  private TextView oUr;
  private WxRecyclerAdapter<b> oUs;
  private final ArrayList<b> oUt;
  private boolean oUu;
  private ti oUv;
  private String oUw;
  private String oUx;
  
  static
  {
    AppMethodBeat.i(218577);
    oUy = new VipCardListUI.a((byte)0);
    AppMethodBeat.o(218577);
  }
  
  public VipCardListUI()
  {
    AppMethodBeat.i(218576);
    this.TAG = "MicroMsg.VipCardListUI";
    this.oUt = new ArrayList();
    this.oTU = 10;
    this.oUb = "";
    this.lzD = true;
    AppMethodBeat.o(218576);
  }
  
  private final void a(beq parambeq)
  {
    AppMethodBeat.i(218575);
    this.oUa = parambeq.GQE;
    parambeq = parambeq.GiO.iterator();
    while (parambeq.hasNext())
    {
      sv localsv = (sv)parambeq.next();
      b localb = new b();
      p.g(localsv, "cardInfo");
      localb.a(localsv);
      this.oUt.add(localb);
    }
    if (this.oUt.isEmpty())
    {
      parambeq = this.oST;
      if (parambeq == null) {
        p.bdF("mEmptyView");
      }
      parambeq.setVisibility(0);
    }
    for (;;)
    {
      parambeq = this.oUs;
      if (parambeq == null) {
        p.bdF("mVipCardListAdapter");
      }
      parambeq.notifyDataSetChanged();
      AppMethodBeat.o(218575);
      return;
      parambeq = this.oST;
      if (parambeq == null) {
        p.bdF("mEmptyView");
      }
      parambeq.setVisibility(8);
    }
  }
  
  private final void bZB()
  {
    AppMethodBeat.i(218574);
    final y.a locala1 = new y.a();
    locala1.NiT = false;
    final y.a locala2 = new y.a();
    locala2.NiT = false;
    if (this.oUv != null)
    {
      CharSequence localCharSequence = (CharSequence)this.oUx;
      if ((localCharSequence != null) && (localCharSequence.length() != 0)) {
        break label133;
      }
    }
    label133:
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        locala1.NiT = true;
      }
      if (this.oTY != null) {
        locala2.NiT = true;
      }
      if ((locala1.NiT) || (locala2.NiT))
      {
        removeAllOptionMenu();
        addIconOptionMenu(0, 0, 2131690603, (MenuItem.OnMenuItemClickListener)new k(this, locala1, locala2));
      }
      AppMethodBeat.o(218574);
      return;
    }
  }
  
  private final void bZE()
  {
    int k = 1;
    AppMethodBeat.i(218572);
    int i;
    label123:
    int j;
    if (this.oUc > 0) {
      if (!((Collection)this.oUt).isEmpty())
      {
        i = 1;
        if (i == 0) {
          break label310;
        }
        localObject = this.oTR;
        if (localObject == null) {
          p.bdF("mSortTv");
        }
        ((TextView)localObject).setText((CharSequence)this.oUb);
        localObject = this.oUp;
        if (localObject == null) {
          p.bdF("mSortLayout");
        }
        ((ViewGroup)localObject).setVisibility(0);
        localObject = this.oUp;
        if (localObject == null) {
          p.bdF("mSortLayout");
        }
        ((ViewGroup)localObject).setOnClickListener((View.OnClickListener)new l(this));
        i = 1;
        localObject = (CharSequence)this.oUw;
        if ((localObject != null) && (((CharSequence)localObject).length() != 0)) {
          break label339;
        }
        j = 1;
        label149:
        if ((j != 0) || (this.oUv == null)) {
          break label344;
        }
        localObject = this.oUq;
        if (localObject == null) {
          p.bdF("mTopPhoneVipCardLayout");
        }
        ((ViewGroup)localObject).setVisibility(0);
        localObject = this.oUr;
        if (localObject == null) {
          p.bdF("mTopPhoneVipCardTv");
        }
        ((TextView)localObject).setText((CharSequence)this.oUw);
        localObject = this.oUq;
        if (localObject == null) {
          p.bdF("mTopPhoneVipCardLayout");
        }
        ((ViewGroup)localObject).setOnClickListener((View.OnClickListener)new m(this));
        i = k;
      }
    }
    for (;;)
    {
      if (i == 0) {
        break label371;
      }
      localObject = this.oUs;
      if (localObject == null) {
        p.bdF("mVipCardListAdapter");
      }
      localViewGroup = this.oTj;
      if (localViewGroup == null) {
        p.bdF("mHeaderView");
      }
      ((WxRecyclerAdapter)localObject).f((View)localViewGroup, 2, false);
      AppMethodBeat.o(218572);
      return;
      i = 0;
      break;
      label310:
      localObject = this.oUp;
      if (localObject == null) {
        p.bdF("mSortLayout");
      }
      ((ViewGroup)localObject).setVisibility(8);
      i = 0;
      break label123;
      label339:
      j = 0;
      break label149;
      label344:
      localObject = this.oUq;
      if (localObject == null) {
        p.bdF("mTopPhoneVipCardLayout");
      }
      ((ViewGroup)localObject).setVisibility(8);
    }
    label371:
    Object localObject = this.oUs;
    if (localObject == null) {
      p.bdF("mVipCardListAdapter");
    }
    ViewGroup localViewGroup = this.oTj;
    if (localViewGroup == null) {
      p.bdF("mHeaderView");
    }
    ((WxRecyclerAdapter)localObject).O(localViewGroup.hashCode(), false);
    AppMethodBeat.o(218572);
  }
  
  private final void jy(final boolean paramBoolean)
  {
    int i = 0;
    AppMethodBeat.i(218573);
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
      AppMethodBeat.o(218573);
      return;
    }
    if (this.lpM)
    {
      ae.w(this.TAG, "is loading");
      AppMethodBeat.o(218573);
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
      localObject = new com.tencent.mm.plugin.card.model.b.b(i, this.oTU, this.dzE, this.dBu, this.oUc).aES().aET();
      p.g(localObject, "CgiGetMemberCardHomePage…ntCancelAfterDead().run()");
      com.tencent.mm.ac.c.b((com.tencent.mm.vending.g.c)localObject, (d.g.a.b)new e(this, paramBoolean)).b((com.tencent.mm.vending.e.b)this);
      AppMethodBeat.o(218573);
      return;
      i = j;
    }
  }
  
  public final void X(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(218571);
    if ((this.lzD) && (this.oUc == 1))
    {
      jy(true);
      AppMethodBeat.o(218571);
      return;
    }
    if (!paramBoolean) {
      bZs();
    }
    AppMethodBeat.o(218571);
  }
  
  public final int getLayoutId()
  {
    return 2131493307;
  }
  
  public final void initView()
  {
    AppMethodBeat.i(218568);
    Object localObject1 = findViewById(2131298323);
    p.g(localObject1, "findViewById(R.id.chpvv3_rv)");
    this.oUo = ((WxRecyclerView)localObject1);
    localObject1 = findViewById(2131298321);
    p.g(localObject1, "findViewById(R.id.chpvv3_refresh_layout)");
    this.oTi = ((RefreshLoadMoreLayout)localObject1);
    localObject1 = findViewById(2131298319);
    p.g(localObject1, "findViewById(R.id.chpvv3_empty_layout)");
    this.oST = ((ViewGroup)localObject1);
    localObject1 = this.oUo;
    if (localObject1 == null) {
      p.bdF("mVipCardListRv");
    }
    getContext();
    ((WxRecyclerView)localObject1).setLayoutManager((RecyclerView.i)new LinearLayoutManager(1));
    this.oUs = new WxRecyclerAdapter((com.tencent.mm.view.recyclerview.c)new f(this), this.oUt);
    localObject1 = this.oUo;
    if (localObject1 == null) {
      p.bdF("mVipCardListRv");
    }
    Object localObject2 = this.oUs;
    if (localObject2 == null) {
      p.bdF("mVipCardListAdapter");
    }
    ((WxRecyclerView)localObject1).setAdapter((RecyclerView.a)localObject2);
    localObject1 = new w((Context)getContext());
    ((w)localObject1).setDrawable(getResources().getDrawable(2131231470));
    localObject2 = this.oUo;
    if (localObject2 == null) {
      p.bdF("mVipCardListRv");
    }
    ((WxRecyclerView)localObject2).b((RecyclerView.h)localObject1);
    localObject1 = getLayoutInflater();
    localObject2 = this.oUo;
    if (localObject2 == null) {
      p.bdF("mVipCardListRv");
    }
    localObject1 = ((LayoutInflater)localObject1).inflate(2131493305, (ViewGroup)localObject2, false);
    if (localObject1 == null)
    {
      localObject1 = new v("null cannot be cast to non-null type android.view.ViewGroup");
      AppMethodBeat.o(218568);
      throw ((Throwable)localObject1);
    }
    this.oTj = ((ViewGroup)localObject1);
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
    localObject1 = ((ViewGroup)localObject1).findViewById(2131298324);
    p.g(localObject1, "mHeaderView.findViewById(R.id.chpvv3_sort_layout)");
    this.oUp = ((ViewGroup)localObject1);
    localObject1 = this.oTj;
    if (localObject1 == null) {
      p.bdF("mHeaderView");
    }
    localObject1 = ((ViewGroup)localObject1).findViewById(2131298327);
    p.g(localObject1, "mHeaderView.findViewById…top_phone_vipcard_layout)");
    this.oUq = ((ViewGroup)localObject1);
    localObject1 = this.oTj;
    if (localObject1 == null) {
      p.bdF("mHeaderView");
    }
    localObject1 = ((ViewGroup)localObject1).findViewById(2131298328);
    p.g(localObject1, "mHeaderView.findViewById…vv3_top_phone_vipcard_tv)");
    this.oUr = ((TextView)localObject1);
    localObject1 = this.oUs;
    if (localObject1 == null) {
      p.bdF("mVipCardListAdapter");
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
    ((RefreshLoadMoreLayout)localObject1).setActionCallback((RefreshLoadMoreLayout.a)new g(this));
    AppMethodBeat.o(218568);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(218567);
    super.onCreate(paramBundle);
    initView();
    setMMTitle(2131756930);
    setActionbarColor(getResources().getColor(2131099648));
    hideActionbarLine();
    setBackBtn((MenuItem.OnMenuItemClickListener)new h(this));
    paramBundle = com.tencent.mm.plugin.card.model.a.a.oHA;
    paramBundle = com.tencent.mm.plugin.card.model.a.a.a.bWu();
    if (paramBundle != null)
    {
      this.fq = paramBundle.pqB;
      this.oUa = paramBundle.GQE;
      this.oTY = paramBundle.GQA;
      this.oTZ = paramBundle.GQB;
      this.oUv = paramBundle.GTL;
      this.oUw = paramBundle.GTN;
      this.oUx = paramBundle.GTM;
      bZB();
      a(paramBundle);
    }
    paramBundle = com.tencent.mm.plugin.card.model.a.a.oHA;
    paramBundle = com.tencent.mm.plugin.card.model.a.a.a.bWv();
    if (paramBundle != null)
    {
      this.oUc = paramBundle.GjL;
      String str = paramBundle.GjN;
      p.g(str, "cardSortInfo.sort_wording");
      this.oUb = str;
      this.oTU = paramBundle.GjM;
      this.oUd = this.oUc;
    }
    bZE();
    if (this.oUc != 1) {
      jy(true);
    }
    AppMethodBeat.o(218567);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(218570);
    super.onDestroy();
    if (!this.oTq)
    {
      ae.i(this.TAG, "no data to save snapshot");
      AppMethodBeat.o(218570);
      return;
    }
    Object localObject1 = new beq();
    ((beq)localObject1).BaseResponse = new BaseResponse();
    ((beq)localObject1).BaseResponse.ErrMsg = new cxn();
    Object localObject2 = this.oUt.iterator();
    while (((Iterator)localObject2).hasNext())
    {
      b localb = (b)((Iterator)localObject2).next();
      if (localb.bZF() != null) {
        ((beq)localObject1).GiO.add(localb.bZF());
      }
    }
    ((beq)localObject1).GQE = this.oUa;
    ((beq)localObject1).pqB = this.fq;
    ((beq)localObject1).GQB = this.oTZ;
    ((beq)localObject1).GQA = this.oTY;
    ((beq)localObject1).GTL = this.oUv;
    ((beq)localObject1).GTM = this.oUx;
    ((beq)localObject1).GTN = this.oUw;
    localObject2 = com.tencent.mm.plugin.card.model.a.a.oHA;
    p.h(localObject1, "response");
    ae.d(com.tencent.mm.plugin.card.model.a.a.access$getTAG$cp(), "save vip card list snapshot");
    com.tencent.mm.ac.c.b(null, (d.g.a.a)new a.a.d((beq)localObject1));
    localObject1 = new tq();
    ((tq)localObject1).GjL = this.oUc;
    ((tq)localObject1).GjN = this.oUb;
    ((tq)localObject1).GjM = this.oTU;
    localObject2 = com.tencent.mm.plugin.card.model.a.a.oHA;
    p.h(localObject1, "sortInfo");
    ae.d(com.tencent.mm.plugin.card.model.a.a.access$getTAG$cp(), "save vip card list snapshot");
    com.tencent.mm.ac.c.b(null, (d.g.a.a)new a.a.e((tq)localObject1));
    AppMethodBeat.o(218570);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(218569);
    if (this.oUu)
    {
      jy(true);
      this.oUu = false;
    }
    super.onResume();
    AppMethodBeat.o(218569);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/card/ui/v3/VipCardListUI$VipCardConvertData;", "Lcom/tencent/mm/view/recyclerview/ConvertData;", "()V", "vipCardInfo", "Lcom/tencent/mm/protocal/protobuf/CardElementCouponList;", "getVipCardInfo", "()Lcom/tencent/mm/protocal/protobuf/CardElementCouponList;", "setVipCardInfo", "(Lcom/tencent/mm/protocal/protobuf/CardElementCouponList;)V", "getItemId", "", "getItemType", "", "plugin-card_release"})
  public static final class b
    implements com.tencent.mm.view.recyclerview.a
  {
    public sv oUz;
    
    public final void a(sv paramsv)
    {
      AppMethodBeat.i(218538);
      p.h(paramsv, "<set-?>");
      this.oUz = paramsv;
      AppMethodBeat.o(218538);
    }
    
    public final sv bZF()
    {
      AppMethodBeat.i(218537);
      sv localsv = this.oUz;
      if (localsv == null) {
        p.bdF("vipCardInfo");
      }
      AppMethodBeat.o(218537);
      return localsv;
    }
    
    public final int bZz()
    {
      return 1;
    }
    
    public final long lP()
    {
      AppMethodBeat.i(218539);
      sv localsv = this.oUz;
      if (localsv == null) {
        p.bdF("vipCardInfo");
      }
      long l = localsv.FKu.hashCode();
      AppMethodBeat.o(218539);
      return l;
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/card/ui/v3/VipCardListUI$VipCardConverter;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "Lcom/tencent/mm/plugin/card/ui/v3/VipCardListUI$VipCardConvertData;", "(Lcom/tencent/mm/plugin/card/ui/v3/VipCardListUI;)V", "getLayoutId", "", "onBindViewHolder", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "position", "type", "isHotPatch", "", "payloads", "", "", "onCreateViewHolder", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "showDeleteConfirmDialog", "cardId", "", "updateCardLabelLayout", "couponLabelList", "", "Lcom/tencent/mm/protocal/protobuf/CardElementCouponLabel;", "labelLayout", "Landroid/widget/LinearLayout;", "plugin-card_release"})
  public final class c
    extends com.tencent.mm.view.recyclerview.b<VipCardListUI.b>
  {
    public final void a(RecyclerView paramRecyclerView, final com.tencent.mm.view.recyclerview.e parame, int paramInt)
    {
      AppMethodBeat.i(218548);
      p.h(paramRecyclerView, "recyclerView");
      p.h(parame, "holder");
      ((RoundCornerImageView)parame.GD(2131298320)).kl(com.tencent.mm.cb.a.fromDPToPix((Context)this.oUA.getContext(), 1), this.oUA.getResources().getColor(2131099828));
      parame.auu.setOnClickListener((View.OnClickListener)new c(this, parame));
      parame.auu.setOnLongClickListener((View.OnLongClickListener)new d(this, parame));
      AppMethodBeat.o(218548);
    }
    
    public final int getLayoutId()
    {
      return 2131493306;
    }
    
    @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run"})
    static final class a
      implements Runnable
    {
      a(VipCardListUI.c paramc, com.tencent.mm.view.recyclerview.e parame, d.g.a.a parama) {}
      
      public final void run()
      {
        AppMethodBeat.i(218540);
        VipCardListUI localVipCardListUI = this.oUB.oUA;
        View localView = this.oTF.auu;
        p.g(localView, "holder.itemView");
        VipCardListUI.a(localVipCardListUI, localView.getHeight());
        this.oTG.invoke();
        AppMethodBeat.o(218540);
      }
    }
    
    @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
    static final class b
      extends q
      implements d.g.a.a<z>
    {
      b(VipCardListUI.c paramc, MemberCardTopCropImageView paramMemberCardTopCropImageView, VipCardListUI.b paramb, com.tencent.mm.view.recyclerview.e parame)
      {
        super();
      }
    }
    
    @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class c
      implements View.OnClickListener
    {
      c(VipCardListUI.c paramc, com.tencent.mm.view.recyclerview.e parame) {}
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(218542);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/card/ui/v3/VipCardListUI$VipCardConverter$onCreateViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
        paramView = (VipCardListUI.b)parame.fUY();
        localObject = paramView.bZF();
        if (((sv)localObject).Giz == 1) {
          com.tencent.mm.plugin.card.d.b.a((MMActivity)this.oUB.oUA.getContext(), ((sv)localObject).GiA);
        }
        for (;;)
        {
          localObject = g.yxI;
          long l = System.currentTimeMillis() / 1000L;
          String str = paramView.bZF().FKu;
          VipCardListUI localVipCardListUI = this.oUB.oUA;
          paramView = paramView.bZF().FKu;
          p.g(paramView, "vipCardConvertData.vipCardInfo.user_card_id");
          ((g)localObject).f(19748, new Object[] { Integer.valueOf(1), Long.valueOf(l), str, Integer.valueOf(VipCardListUI.b(localVipCardListUI, paramView)), Integer.valueOf(0) });
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/card/ui/v3/VipCardListUI$VipCardConverter$onCreateViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(218542);
          return;
          if (((sv)localObject).Giz == 2)
          {
            com.tencent.mm.plugin.card.d.b.I(((sv)localObject).GiB.CRv, ((sv)localObject).GiB.CRw, ((sv)localObject).GiB.DyO);
          }
          else
          {
            localObject = this.oUB.oUA;
            str = paramView.bZF().FKu;
            p.g(str, "vipCardConvertData.vipCardInfo.user_card_id");
            VipCardListUI.a((VipCardListUI)localObject, str);
          }
        }
      }
    }
    
    @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onLongClick"})
    static final class d
      implements View.OnLongClickListener
    {
      d(VipCardListUI.c paramc, com.tencent.mm.view.recyclerview.e parame) {}
      
      public final boolean onLongClick(View paramView)
      {
        AppMethodBeat.i(218545);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/card/ui/v3/VipCardListUI$VipCardConverter$onCreateViewHolder$2", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
        final VipCardListUI.b localb = (VipCardListUI.b)parame.fUY();
        localObject = new com.tencent.mm.ui.widget.b.a((Context)this.oUB.oUA.getContext(), paramView);
        ((com.tencent.mm.ui.widget.b.a)localObject).a((View.OnCreateContextMenuListener)new View.OnCreateContextMenuListener()
        {
          public final void onCreateContextMenu(ContextMenu paramAnonymousContextMenu, View paramAnonymousView, ContextMenu.ContextMenuInfo paramAnonymousContextMenuInfo)
          {
            AppMethodBeat.i(218543);
            paramAnonymousContextMenu.add(0, 1, 0, (CharSequence)this.oUD.oUB.oUA.getString(2131755707));
            AppMethodBeat.o(218543);
          }
        });
        ((com.tencent.mm.ui.widget.b.a)localObject).a((n.e)new n.e()
        {
          public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
          {
            AppMethodBeat.i(218544);
            paramAnonymousMenuItem = this.oUD.oUB;
            String str = localb.bZF().FKu;
            p.g(str, "vipCardConvertData.vipCardInfo.user_card_id");
            com.tencent.mm.ui.widget.a.e locale = new com.tencent.mm.ui.widget.a.e((Context)paramAnonymousMenuItem.oUA.getContext(), 1, true);
            TextView localTextView = new TextView((Context)paramAnonymousMenuItem.oUA.getContext());
            localTextView.setText((CharSequence)paramAnonymousMenuItem.oUA.getString(2131756885));
            localTextView.setTextSize(1, 14.0F);
            localTextView.setTextColor(paramAnonymousMenuItem.oUA.getResources().getColor(2131100482));
            localTextView.setGravity(17);
            paramAnonymousInt = paramAnonymousMenuItem.oUA.getResources().getDimensionPixelSize(2131165303);
            int i = paramAnonymousMenuItem.oUA.getResources().getDimensionPixelSize(2131165289);
            localTextView.setPadding(paramAnonymousInt, i, paramAnonymousInt, i);
            locale.P((View)localTextView, false);
            locale.a((n.d)new VipCardListUI.c.e(paramAnonymousMenuItem));
            locale.a((n.e)new VipCardListUI.c.f(paramAnonymousMenuItem, str));
            locale.cPF();
            AppMethodBeat.o(218544);
          }
        });
        p.g(paramView, "it");
        paramView = m.dJ(paramView);
        ((com.tencent.mm.ui.widget.b.a)localObject).el(paramView.x, paramView.y);
        g.yxI.f(19747, new Object[] { Integer.valueOf(1), Integer.valueOf(3) });
        com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/card/ui/v3/VipCardListUI$VipCardConverter$onCreateViewHolder$2", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
        AppMethodBeat.o(218545);
        return false;
      }
    }
    
    @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Lcom/tencent/mm/ui/base/MMMenu;", "kotlin.jvm.PlatformType", "onCreateMMMenu"})
    static final class e
      implements n.d
    {
      e(VipCardListUI.c paramc) {}
      
      public final void onCreateMMMenu(com.tencent.mm.ui.base.l paraml)
      {
        AppMethodBeat.i(218546);
        paraml.a(1, this.oUB.oUA.getResources().getColor(2131100800), (CharSequence)this.oUB.oUA.getString(2131755707));
        AppMethodBeat.o(218546);
      }
    }
    
    @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "menuItem", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "", "onMMMenuItemSelected"})
    static final class f
      implements n.e
    {
      f(VipCardListUI.c paramc, String paramString) {}
      
      public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
      {
        AppMethodBeat.i(218547);
        p.g(paramMenuItem, "menuItem");
        switch (paramMenuItem.getItemId())
        {
        }
        for (;;)
        {
          AppMethodBeat.o(218547);
          return;
          VipCardListUI.c(this.oUB.oUA, this.oSx);
          g.yxI.f(19747, new Object[] { Integer.valueOf(1), Integer.valueOf(4) });
        }
      }
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "kotlin.jvm.PlatformType", "it", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/DeleteCardInTicketListResponse;", "call"})
  static final class d<_Ret, _Var>
    implements com.tencent.mm.vending.c.a<_Ret, _Var>
  {
    d(VipCardListUI paramVipCardListUI, String paramString) {}
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/GetMemberCardHomePageResponse;", "kotlin.jvm.PlatformType", "invoke"})
  static final class e
    extends q
    implements d.g.a.b<com.tencent.mm.ak.a.a<beq>, z>
  {
    e(VipCardListUI paramVipCardListUI, boolean paramBoolean)
    {
      super();
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/card/ui/v3/VipCardListUI$initView$1", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "getItemConvert", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "type", "", "plugin-card_release"})
  public static final class f
    implements com.tencent.mm.view.recyclerview.c
  {
    public final com.tencent.mm.view.recyclerview.b<?> AX(int paramInt)
    {
      AppMethodBeat.i(218552);
      com.tencent.mm.view.recyclerview.b localb = (com.tencent.mm.view.recyclerview.b)new VipCardListUI.c(this.oUA);
      AppMethodBeat.o(218552);
      return localb;
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/card/ui/v3/VipCardListUI$initView$2", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback;", "onLoadMoreBegin", "", "onLoadMoreEnd", "reason", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;", "", "plugin-card_release"})
  public static final class g
    extends RefreshLoadMoreLayout.a
  {
    public final void AY(int paramInt)
    {
      AppMethodBeat.i(218556);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.mu(paramInt);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/card/ui/v3/VipCardListUI$initView$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshBegin", "(I)V", this, localb.ahF());
      super.AY(paramInt);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/card/ui/v3/VipCardListUI$initView$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshBegin", "(I)V");
      AppMethodBeat.o(218556);
    }
    
    public final void a(RefreshLoadMoreLayout.c<Object> paramc)
    {
      AppMethodBeat.i(218555);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bd(paramc);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/card/ui/v3/VipCardListUI$initView$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V", this, localb.ahF());
      p.h(paramc, "reason");
      ae.d(VipCardListUI.a(this.oUA), "on load more end: " + VipCardListUI.c(this.oUA));
      if (VipCardListUI.d(this.oUA)) {
        VipCardListUI.e(this.oUA).k(null);
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/card/ui/v3/VipCardListUI$initView$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V");
      AppMethodBeat.o(218555);
    }
    
    public final void b(RefreshLoadMoreLayout.c paramc)
    {
      AppMethodBeat.i(218557);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bd(paramc);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/card/ui/v3/VipCardListUI$initView$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V", this, localb.ahF());
      super.b(paramc);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/card/ui/v3/VipCardListUI$initView$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V");
      AppMethodBeat.o(218557);
    }
    
    public final void bZA()
    {
      AppMethodBeat.i(218554);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/card/ui/v3/VipCardListUI$initView$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreBegin", "()V", this);
      ae.d(VipCardListUI.a(this.oUA), "on load more");
      com.tencent.mm.ac.c.h((d.g.a.a)new a(this));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/card/ui/v3/VipCardListUI$initView$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreBegin", "()V");
      AppMethodBeat.o(218554);
    }
    
    @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
    static final class a
      extends q
      implements d.g.a.a<z>
    {
      a(VipCardListUI.g paramg)
      {
        super();
      }
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class h
    implements MenuItem.OnMenuItemClickListener
  {
    h(VipCardListUI paramVipCardListUI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(218558);
      this.oUA.finish();
      AppMethodBeat.o(218558);
      return false;
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Lcom/tencent/mm/ui/base/MMMenu;", "kotlin.jvm.PlatformType", "onCreateMMMenu"})
  static final class i
    implements n.d
  {
    i(VipCardListUI paramVipCardListUI) {}
    
    public final void onCreateMMMenu(com.tencent.mm.ui.base.l paraml)
    {
      AppMethodBeat.i(218559);
      Object localObject = VipCardListUI.f(this.oUA);
      if (localObject == null) {
        p.gkB();
      }
      localObject = ((tr)localObject).GjO.iterator();
      while (((Iterator)localObject).hasNext())
      {
        tq localtq = (tq)((Iterator)localObject).next();
        paraml.add(0, localtq.GjL, 1, (CharSequence)localtq.GjN);
      }
      AppMethodBeat.o(218559);
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "menuItem", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "index", "", "onMMMenuItemSelected"})
  static final class j
    implements n.e
  {
    j(VipCardListUI paramVipCardListUI) {}
    
    public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
    {
      AppMethodBeat.i(218561);
      p.g(paramMenuItem, "menuItem");
      paramInt = paramMenuItem.getItemId();
      ae.i(VipCardListUI.a(this.oUA), "click item: %s", new Object[] { Integer.valueOf(paramInt) });
      if (paramInt == 1)
      {
        if (!VipCardListUI.g(this.oUA))
        {
          h.a((Context)this.oUA.getContext(), this.oUA.getString(2131756893), this.oUA.getString(2131761885), this.oUA.getString(2131760598), this.oUA.getString(2131757558), false, (DialogInterface.OnClickListener)new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(218560);
              this.oUG.oUA.startActivityForResult(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"), 564);
              AppMethodBeat.o(218560);
            }
          }, null);
          AppMethodBeat.o(218561);
          return;
        }
        VipCardListUI.b(this.oUA, VipCardListUI.i(this.oUA));
        VipCardListUI.c(this.oUA, 1);
        VipCardListUI.d(this.oUA, paramMenuItem.getTitle().toString());
        VipCardListUI.j(this.oUA);
        VipCardListUI.a(this.oUA, true);
        g.yxI.f(19747, new Object[] { Integer.valueOf(1), Integer.valueOf(5) });
        AppMethodBeat.o(218561);
        return;
      }
      VipCardListUI.b(this.oUA, VipCardListUI.i(this.oUA));
      VipCardListUI.c(this.oUA, paramInt);
      VipCardListUI.d(this.oUA, paramMenuItem.getTitle().toString());
      VipCardListUI.j(this.oUA);
      VipCardListUI.a(this.oUA, true);
      g.yxI.f(19747, new Object[] { Integer.valueOf(1), Integer.valueOf(6) });
      AppMethodBeat.o(218561);
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class k
    implements MenuItem.OnMenuItemClickListener
  {
    k(VipCardListUI paramVipCardListUI, y.a parama1, y.a parama2) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(218564);
      paramMenuItem = new com.tencent.mm.ui.widget.a.e((Context)this.oUA.getContext(), 1, false);
      paramMenuItem.a((n.d)new n.d()
      {
        public final void onCreateMMMenu(com.tencent.mm.ui.base.l paramAnonymousl)
        {
          AppMethodBeat.i(218562);
          if (this.oUJ.oUH.NiT) {
            paramAnonymousl.add(0, 1, 0, (CharSequence)VipCardListUI.q(this.oUJ.oUA));
          }
          if (this.oUJ.oUI.NiT) {
            paramAnonymousl.add(0, 2, 1, (CharSequence)VipCardListUI.p(this.oUJ.oUA));
          }
          AppMethodBeat.o(218562);
        }
      });
      paramMenuItem.a((n.e)new n.e()
      {
        public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
        {
          AppMethodBeat.i(218563);
          p.g(paramAnonymousMenuItem, "menuItem");
          Object localObject;
          ti localti;
          if (paramAnonymousMenuItem.getItemId() == 1)
          {
            VipCardListUI.l(this.oUJ.oUA);
            paramAnonymousMenuItem = VipCardListUI.m(this.oUJ.oUA);
            if (paramAnonymousMenuItem == null) {
              p.gkB();
            }
            paramAnonymousMenuItem = paramAnonymousMenuItem.CRv;
            localObject = VipCardListUI.m(this.oUJ.oUA);
            if (localObject == null) {
              p.gkB();
            }
            localObject = ((ti)localObject).CRw;
            localti = VipCardListUI.m(this.oUJ.oUA);
            if (localti == null) {
              p.gkB();
            }
            com.tencent.mm.plugin.card.d.b.I(paramAnonymousMenuItem, (String)localObject, localti.DyO);
            g.yxI.f(19747, new Object[] { Integer.valueOf(1), Integer.valueOf(7) });
            AppMethodBeat.o(218563);
            return;
          }
          if (paramAnonymousMenuItem.getItemId() == 2)
          {
            paramAnonymousMenuItem = VipCardListUI.o(this.oUJ.oUA);
            if (paramAnonymousMenuItem == null) {
              p.gkB();
            }
            paramAnonymousMenuItem = paramAnonymousMenuItem.CRv;
            localObject = VipCardListUI.o(this.oUJ.oUA);
            if (localObject == null) {
              p.gkB();
            }
            localObject = ((ti)localObject).CRw;
            localti = VipCardListUI.o(this.oUJ.oUA);
            if (localti == null) {
              p.gkB();
            }
            com.tencent.mm.plugin.card.d.b.I(paramAnonymousMenuItem, (String)localObject, localti.DyO);
            g.yxI.f(19747, new Object[] { Integer.valueOf(1), Integer.valueOf(2) });
          }
          AppMethodBeat.o(218563);
        }
      });
      paramMenuItem.cPF();
      g.yxI.f(19747, new Object[] { Integer.valueOf(1), Integer.valueOf(1) });
      AppMethodBeat.o(218564);
      return false;
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class l
    implements View.OnClickListener
  {
    l(VipCardListUI paramVipCardListUI) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(218565);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/card/ui/v3/VipCardListUI$updateTopHeaderLayout$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
      ae.d(VipCardListUI.a(this.oUA), "click header view");
      VipCardListUI.k(this.oUA);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/card/ui/v3/VipCardListUI$updateTopHeaderLayout$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(218565);
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class m
    implements View.OnClickListener
  {
    m(VipCardListUI paramVipCardListUI) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(218566);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/card/ui/v3/VipCardListUI$updateTopHeaderLayout$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
      VipCardListUI.l(this.oUA);
      paramView = VipCardListUI.m(this.oUA);
      if (paramView == null) {
        p.gkB();
      }
      paramView = paramView.CRv;
      localObject = VipCardListUI.m(this.oUA);
      if (localObject == null) {
        p.gkB();
      }
      localObject = ((ti)localObject).CRw;
      ti localti = VipCardListUI.m(this.oUA);
      if (localti == null) {
        p.gkB();
      }
      com.tencent.mm.plugin.card.d.b.I(paramView, (String)localObject, localti.DyO);
      g.yxI.f(19747, new Object[] { Integer.valueOf(1), Integer.valueOf(8) });
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/card/ui/v3/VipCardListUI$updateTopHeaderLayout$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(218566);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.v3.VipCardListUI
 * JD-Core Version:    0.7.0.1
 */