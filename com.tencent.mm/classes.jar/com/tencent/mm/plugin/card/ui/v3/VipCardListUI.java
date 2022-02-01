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
import com.tencent.mm.protocal.protobuf.bea;
import com.tencent.mm.protocal.protobuf.cwt;
import com.tencent.mm.protocal.protobuf.st;
import com.tencent.mm.protocal.protobuf.tg;
import com.tencent.mm.protocal.protobuf.to;
import com.tencent.mm.protocal.protobuf.tp;
import com.tencent.mm.sdk.platformtools.ad;
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

@d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/card/ui/v3/VipCardListUI;", "Lcom/tencent/mm/plugin/card/ui/v2/CardNewBaseUI;", "()V", "TAG", "", "loadCount", "", "mCurrentSortInfo", "mCurrentSortWording", "mEmptyView", "Landroid/view/ViewGroup;", "mFirstLoad", "", "mHasLoadedSuccess", "mHeaderView", "mHistoryEntranceWording", "mHistoryMiniAppInfo", "Lcom/tencent/mm/protocal/protobuf/CardMiniAppInfo;", "mIsAll", "mIsLoading", "mNeedRefreshList", "mOffset", "mPhoneMemberEntranceWording", "mPhoneMemberMenuEntranceWording", "mPhoneMemberMiniAppInfo", "mPreviousSortInfo", "mRefreshLayout", "Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "mReqNum", "mSortInfoList", "Lcom/tencent/mm/protocal/protobuf/CardSortInfoList;", "mSortLayout", "mSortTv", "Landroid/widget/TextView;", "mTopPhoneVipCardLayout", "mTopPhoneVipCardTv", "mViewHeight", "mVipCardList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/card/ui/v3/VipCardListUI$VipCardConvertData;", "Lkotlin/collections/ArrayList;", "mVipCardListAdapter", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "mVipCardListRv", "Lcom/tencent/mm/view/recyclerview/WxRecyclerView;", "doDeleteVipCard", "", "cardId", "doLoadVipCardList", "refresh", "getLayoutId", "getPositionByUserCardId", "gotoCardDetailUI", "initView", "loadSnapshot", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onFinishLocationThings", "ret", "isLocationOk", "onResume", "saveSnapshot", "showSortDialog", "updateIconMenu", "updateTopHeaderLayout", "updateViewByResp", "resp", "Lcom/tencent/mm/protocal/protobuf/GetMemberCardHomePageResponse;", "Companion", "VipCardConvertData", "VipCardConverter", "plugin-card_release"})
public final class VipCardListUI
  extends CardNewBaseUI
{
  public static final VipCardListUI.a oNW;
  private final String TAG;
  private int aYT;
  private int fq;
  private boolean llo;
  private boolean lvf;
  private RefreshLoadMoreLayout oMG;
  private ViewGroup oMH;
  private boolean oMN;
  private boolean oMO;
  private int oMS;
  private ViewGroup oMr;
  private int oNA;
  private int oNB;
  private WxRecyclerView oNM;
  private ViewGroup oNN;
  private ViewGroup oNO;
  private TextView oNP;
  private WxRecyclerAdapter<b> oNQ;
  private final ArrayList<b> oNR;
  private boolean oNS;
  private tg oNT;
  private String oNU;
  private String oNV;
  private TextView oNp;
  private int oNs;
  private tg oNw;
  private String oNx;
  private tp oNy;
  private String oNz;
  
  static
  {
    AppMethodBeat.i(215616);
    oNW = new VipCardListUI.a((byte)0);
    AppMethodBeat.o(215616);
  }
  
  public VipCardListUI()
  {
    AppMethodBeat.i(215615);
    this.TAG = "MicroMsg.VipCardListUI";
    this.oNR = new ArrayList();
    this.oNs = 10;
    this.oNz = "";
    this.lvf = true;
    AppMethodBeat.o(215615);
  }
  
  private final void a(bea parambea)
  {
    AppMethodBeat.i(215614);
    this.oNy = parambea.Gxe;
    parambea = parambea.FQp.iterator();
    while (parambea.hasNext())
    {
      st localst = (st)parambea.next();
      b localb = new b();
      p.g(localst, "cardInfo");
      localb.a(localst);
      this.oNR.add(localb);
    }
    if (this.oNR.isEmpty())
    {
      parambea = this.oMr;
      if (parambea == null) {
        p.bcb("mEmptyView");
      }
      parambea.setVisibility(0);
    }
    for (;;)
    {
      parambea = this.oNQ;
      if (parambea == null) {
        p.bcb("mVipCardListAdapter");
      }
      parambea.notifyDataSetChanged();
      AppMethodBeat.o(215614);
      return;
      parambea = this.oMr;
      if (parambea == null) {
        p.bcb("mEmptyView");
      }
      parambea.setVisibility(8);
    }
  }
  
  private final void bYm()
  {
    AppMethodBeat.i(215613);
    final y.a locala1 = new y.a();
    locala1.MLQ = false;
    final y.a locala2 = new y.a();
    locala2.MLQ = false;
    if (this.oNT != null)
    {
      CharSequence localCharSequence = (CharSequence)this.oNV;
      if ((localCharSequence != null) && (localCharSequence.length() != 0)) {
        break label133;
      }
    }
    label133:
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        locala1.MLQ = true;
      }
      if (this.oNw != null) {
        locala2.MLQ = true;
      }
      if ((locala1.MLQ) || (locala2.MLQ))
      {
        removeAllOptionMenu();
        addIconOptionMenu(0, 0, 2131690603, (MenuItem.OnMenuItemClickListener)new k(this, locala1, locala2));
      }
      AppMethodBeat.o(215613);
      return;
    }
  }
  
  private final void bYp()
  {
    int k = 1;
    AppMethodBeat.i(215611);
    int i;
    label123:
    int j;
    if (this.oNA > 0) {
      if (!((Collection)this.oNR).isEmpty())
      {
        i = 1;
        if (i == 0) {
          break label310;
        }
        localObject = this.oNp;
        if (localObject == null) {
          p.bcb("mSortTv");
        }
        ((TextView)localObject).setText((CharSequence)this.oNz);
        localObject = this.oNN;
        if (localObject == null) {
          p.bcb("mSortLayout");
        }
        ((ViewGroup)localObject).setVisibility(0);
        localObject = this.oNN;
        if (localObject == null) {
          p.bcb("mSortLayout");
        }
        ((ViewGroup)localObject).setOnClickListener((View.OnClickListener)new l(this));
        i = 1;
        localObject = (CharSequence)this.oNU;
        if ((localObject != null) && (((CharSequence)localObject).length() != 0)) {
          break label339;
        }
        j = 1;
        label149:
        if ((j != 0) || (this.oNT == null)) {
          break label344;
        }
        localObject = this.oNO;
        if (localObject == null) {
          p.bcb("mTopPhoneVipCardLayout");
        }
        ((ViewGroup)localObject).setVisibility(0);
        localObject = this.oNP;
        if (localObject == null) {
          p.bcb("mTopPhoneVipCardTv");
        }
        ((TextView)localObject).setText((CharSequence)this.oNU);
        localObject = this.oNO;
        if (localObject == null) {
          p.bcb("mTopPhoneVipCardLayout");
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
      localObject = this.oNQ;
      if (localObject == null) {
        p.bcb("mVipCardListAdapter");
      }
      localViewGroup = this.oMH;
      if (localViewGroup == null) {
        p.bcb("mHeaderView");
      }
      ((WxRecyclerAdapter)localObject).f((View)localViewGroup, 2, false);
      AppMethodBeat.o(215611);
      return;
      i = 0;
      break;
      label310:
      localObject = this.oNN;
      if (localObject == null) {
        p.bcb("mSortLayout");
      }
      ((ViewGroup)localObject).setVisibility(8);
      i = 0;
      break label123;
      label339:
      j = 0;
      break label149;
      label344:
      localObject = this.oNO;
      if (localObject == null) {
        p.bcb("mTopPhoneVipCardLayout");
      }
      ((ViewGroup)localObject).setVisibility(8);
    }
    label371:
    Object localObject = this.oNQ;
    if (localObject == null) {
      p.bcb("mVipCardListAdapter");
    }
    ViewGroup localViewGroup = this.oMH;
    if (localViewGroup == null) {
      p.bcb("mHeaderView");
    }
    ((WxRecyclerAdapter)localObject).M(localViewGroup.hashCode(), false);
    AppMethodBeat.o(215611);
  }
  
  private final void jz(final boolean paramBoolean)
  {
    int i = 0;
    AppMethodBeat.i(215612);
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
      AppMethodBeat.o(215612);
      return;
    }
    if (this.llo)
    {
      ad.w(this.TAG, "is loading");
      AppMethodBeat.o(215612);
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
      localObject = new com.tencent.mm.plugin.card.model.b.b(i, this.oNs, this.dyz, this.dAp, this.oNA).aEC().aED();
      p.g(localObject, "CgiGetMemberCardHomePage…ntCancelAfterDead().run()");
      com.tencent.mm.ad.c.b((com.tencent.mm.vending.g.c)localObject, (d.g.a.b)new e(this, paramBoolean)).b((com.tencent.mm.vending.e.b)this);
      AppMethodBeat.o(215612);
      return;
      i = j;
    }
  }
  
  public final void V(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(215610);
    if ((this.lvf) && (this.oNA == 1))
    {
      jz(true);
      AppMethodBeat.o(215610);
      return;
    }
    if (!paramBoolean) {
      bYd();
    }
    AppMethodBeat.o(215610);
  }
  
  public final int getLayoutId()
  {
    return 2131493307;
  }
  
  public final void initView()
  {
    AppMethodBeat.i(215607);
    Object localObject1 = findViewById(2131298323);
    p.g(localObject1, "findViewById(R.id.chpvv3_rv)");
    this.oNM = ((WxRecyclerView)localObject1);
    localObject1 = findViewById(2131298321);
    p.g(localObject1, "findViewById(R.id.chpvv3_refresh_layout)");
    this.oMG = ((RefreshLoadMoreLayout)localObject1);
    localObject1 = findViewById(2131298319);
    p.g(localObject1, "findViewById(R.id.chpvv3_empty_layout)");
    this.oMr = ((ViewGroup)localObject1);
    localObject1 = this.oNM;
    if (localObject1 == null) {
      p.bcb("mVipCardListRv");
    }
    getContext();
    ((WxRecyclerView)localObject1).setLayoutManager((RecyclerView.i)new LinearLayoutManager(1));
    this.oNQ = new WxRecyclerAdapter((com.tencent.mm.view.recyclerview.c)new f(this), this.oNR);
    localObject1 = this.oNM;
    if (localObject1 == null) {
      p.bcb("mVipCardListRv");
    }
    Object localObject2 = this.oNQ;
    if (localObject2 == null) {
      p.bcb("mVipCardListAdapter");
    }
    ((WxRecyclerView)localObject1).setAdapter((RecyclerView.a)localObject2);
    localObject1 = new w((Context)getContext());
    ((w)localObject1).setDrawable(getResources().getDrawable(2131231470));
    localObject2 = this.oNM;
    if (localObject2 == null) {
      p.bcb("mVipCardListRv");
    }
    ((WxRecyclerView)localObject2).b((RecyclerView.h)localObject1);
    localObject1 = getLayoutInflater();
    localObject2 = this.oNM;
    if (localObject2 == null) {
      p.bcb("mVipCardListRv");
    }
    localObject1 = ((LayoutInflater)localObject1).inflate(2131493305, (ViewGroup)localObject2, false);
    if (localObject1 == null)
    {
      localObject1 = new v("null cannot be cast to non-null type android.view.ViewGroup");
      AppMethodBeat.o(215607);
      throw ((Throwable)localObject1);
    }
    this.oMH = ((ViewGroup)localObject1);
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
    localObject1 = ((ViewGroup)localObject1).findViewById(2131298324);
    p.g(localObject1, "mHeaderView.findViewById(R.id.chpvv3_sort_layout)");
    this.oNN = ((ViewGroup)localObject1);
    localObject1 = this.oMH;
    if (localObject1 == null) {
      p.bcb("mHeaderView");
    }
    localObject1 = ((ViewGroup)localObject1).findViewById(2131298327);
    p.g(localObject1, "mHeaderView.findViewById…top_phone_vipcard_layout)");
    this.oNO = ((ViewGroup)localObject1);
    localObject1 = this.oMH;
    if (localObject1 == null) {
      p.bcb("mHeaderView");
    }
    localObject1 = ((ViewGroup)localObject1).findViewById(2131298328);
    p.g(localObject1, "mHeaderView.findViewById…vv3_top_phone_vipcard_tv)");
    this.oNP = ((TextView)localObject1);
    localObject1 = this.oNQ;
    if (localObject1 == null) {
      p.bcb("mVipCardListAdapter");
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
    ((RefreshLoadMoreLayout)localObject1).setActionCallback((RefreshLoadMoreLayout.a)new g(this));
    AppMethodBeat.o(215607);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(215606);
    super.onCreate(paramBundle);
    initView();
    setMMTitle(2131756930);
    setActionbarColor(getResources().getColor(2131099648));
    hideActionbarLine();
    setBackBtn((MenuItem.OnMenuItemClickListener)new VipCardListUI.h(this));
    paramBundle = com.tencent.mm.plugin.card.model.a.a.oAY;
    paramBundle = com.tencent.mm.plugin.card.model.a.a.a.bVf();
    if (paramBundle != null)
    {
      this.fq = paramBundle.pjW;
      this.oNy = paramBundle.Gxe;
      this.oNw = paramBundle.Gxa;
      this.oNx = paramBundle.Gxb;
      this.oNT = paramBundle.GAl;
      this.oNU = paramBundle.GAn;
      this.oNV = paramBundle.GAm;
      bYm();
      a(paramBundle);
    }
    paramBundle = com.tencent.mm.plugin.card.model.a.a.oAY;
    paramBundle = com.tencent.mm.plugin.card.model.a.a.a.bVg();
    if (paramBundle != null)
    {
      this.oNA = paramBundle.FRm;
      String str = paramBundle.FRo;
      p.g(str, "cardSortInfo.sort_wording");
      this.oNz = str;
      this.oNs = paramBundle.FRn;
      this.oNB = this.oNA;
    }
    bYp();
    if (this.oNA != 1) {
      jz(true);
    }
    AppMethodBeat.o(215606);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(215609);
    super.onDestroy();
    if (!this.oMO)
    {
      ad.i(this.TAG, "no data to save snapshot");
      AppMethodBeat.o(215609);
      return;
    }
    Object localObject1 = new bea();
    ((bea)localObject1).BaseResponse = new BaseResponse();
    ((bea)localObject1).BaseResponse.ErrMsg = new cwt();
    Object localObject2 = this.oNR.iterator();
    while (((Iterator)localObject2).hasNext())
    {
      b localb = (b)((Iterator)localObject2).next();
      if (localb.bYq() != null) {
        ((bea)localObject1).FQp.add(localb.bYq());
      }
    }
    ((bea)localObject1).Gxe = this.oNy;
    ((bea)localObject1).pjW = this.fq;
    ((bea)localObject1).Gxb = this.oNx;
    ((bea)localObject1).Gxa = this.oNw;
    ((bea)localObject1).GAl = this.oNT;
    ((bea)localObject1).GAm = this.oNV;
    ((bea)localObject1).GAn = this.oNU;
    localObject2 = com.tencent.mm.plugin.card.model.a.a.oAY;
    p.h(localObject1, "response");
    ad.d(com.tencent.mm.plugin.card.model.a.a.access$getTAG$cp(), "save vip card list snapshot");
    com.tencent.mm.ad.c.b(null, (d.g.a.a)new a.a.d((bea)localObject1));
    localObject1 = new to();
    ((to)localObject1).FRm = this.oNA;
    ((to)localObject1).FRo = this.oNz;
    ((to)localObject1).FRn = this.oNs;
    localObject2 = com.tencent.mm.plugin.card.model.a.a.oAY;
    p.h(localObject1, "sortInfo");
    ad.d(com.tencent.mm.plugin.card.model.a.a.access$getTAG$cp(), "save vip card list snapshot");
    com.tencent.mm.ad.c.b(null, (d.g.a.a)new a.a.e((to)localObject1));
    AppMethodBeat.o(215609);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(215608);
    if (this.oNS)
    {
      jz(true);
      this.oNS = false;
    }
    super.onResume();
    AppMethodBeat.o(215608);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/card/ui/v3/VipCardListUI$VipCardConvertData;", "Lcom/tencent/mm/view/recyclerview/ConvertData;", "()V", "vipCardInfo", "Lcom/tencent/mm/protocal/protobuf/CardElementCouponList;", "getVipCardInfo", "()Lcom/tencent/mm/protocal/protobuf/CardElementCouponList;", "setVipCardInfo", "(Lcom/tencent/mm/protocal/protobuf/CardElementCouponList;)V", "getItemId", "", "getItemType", "", "plugin-card_release"})
  public static final class b
    implements com.tencent.mm.view.recyclerview.a
  {
    public st oNX;
    
    public final void a(st paramst)
    {
      AppMethodBeat.i(215577);
      p.h(paramst, "<set-?>");
      this.oNX = paramst;
      AppMethodBeat.o(215577);
    }
    
    public final int bYk()
    {
      return 1;
    }
    
    public final st bYq()
    {
      AppMethodBeat.i(215576);
      st localst = this.oNX;
      if (localst == null) {
        p.bcb("vipCardInfo");
      }
      AppMethodBeat.o(215576);
      return localst;
    }
    
    public final long lP()
    {
      AppMethodBeat.i(215578);
      st localst = this.oNX;
      if (localst == null) {
        p.bcb("vipCardInfo");
      }
      long l = localst.FrW.hashCode();
      AppMethodBeat.o(215578);
      return l;
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/card/ui/v3/VipCardListUI$VipCardConverter;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "Lcom/tencent/mm/plugin/card/ui/v3/VipCardListUI$VipCardConvertData;", "(Lcom/tencent/mm/plugin/card/ui/v3/VipCardListUI;)V", "getLayoutId", "", "onBindViewHolder", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "position", "type", "isHotPatch", "", "payloads", "", "", "onCreateViewHolder", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "showDeleteConfirmDialog", "cardId", "", "updateCardLabelLayout", "couponLabelList", "", "Lcom/tencent/mm/protocal/protobuf/CardElementCouponLabel;", "labelLayout", "Landroid/widget/LinearLayout;", "plugin-card_release"})
  public final class c
    extends com.tencent.mm.view.recyclerview.b<VipCardListUI.b>
  {
    public final void a(RecyclerView paramRecyclerView, final com.tencent.mm.view.recyclerview.e parame, int paramInt)
    {
      AppMethodBeat.i(215587);
      p.h(paramRecyclerView, "recyclerView");
      p.h(parame, "holder");
      ((RoundCornerImageView)parame.Gd(2131298320)).ke(com.tencent.mm.cc.a.fromDPToPix((Context)this.oNY.getContext(), 1), this.oNY.getResources().getColor(2131099828));
      parame.auu.setOnClickListener((View.OnClickListener)new c(this, parame));
      parame.auu.setOnLongClickListener((View.OnLongClickListener)new d(this, parame));
      AppMethodBeat.o(215587);
    }
    
    public final int getLayoutId()
    {
      return 2131493306;
    }
    
    @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run"})
    static final class a
      implements Runnable
    {
      a(VipCardListUI.c paramc, com.tencent.mm.view.recyclerview.e parame, d.g.a.a parama) {}
      
      public final void run()
      {
        AppMethodBeat.i(215579);
        VipCardListUI localVipCardListUI = this.oNZ.oNY;
        View localView = this.oNd.auu;
        p.g(localView, "holder.itemView");
        VipCardListUI.a(localVipCardListUI, localView.getHeight());
        this.oNe.invoke();
        AppMethodBeat.o(215579);
      }
    }
    
    @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
    static final class b
      extends q
      implements d.g.a.a<z>
    {
      b(VipCardListUI.c paramc, MemberCardTopCropImageView paramMemberCardTopCropImageView, VipCardListUI.b paramb, com.tencent.mm.view.recyclerview.e parame)
      {
        super();
      }
    }
    
    @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class c
      implements View.OnClickListener
    {
      c(VipCardListUI.c paramc, com.tencent.mm.view.recyclerview.e parame) {}
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(215581);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/card/ui/v3/VipCardListUI$VipCardConverter$onCreateViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
        paramView = (VipCardListUI.b)parame.fQC();
        localObject = paramView.bYq();
        if (((st)localObject).FQa == 1) {
          com.tencent.mm.plugin.card.d.b.a((MMActivity)this.oNZ.oNY.getContext(), ((st)localObject).FQb);
        }
        for (;;)
        {
          localObject = g.yhR;
          long l = System.currentTimeMillis() / 1000L;
          String str = paramView.bYq().FrW;
          VipCardListUI localVipCardListUI = this.oNZ.oNY;
          paramView = paramView.bYq().FrW;
          p.g(paramView, "vipCardConvertData.vipCardInfo.user_card_id");
          ((g)localObject).f(19748, new Object[] { Integer.valueOf(1), Long.valueOf(l), str, Integer.valueOf(VipCardListUI.b(localVipCardListUI, paramView)), Integer.valueOf(0) });
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/card/ui/v3/VipCardListUI$VipCardConverter$onCreateViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(215581);
          return;
          if (((st)localObject).FQa == 2)
          {
            com.tencent.mm.plugin.card.d.b.I(((st)localObject).FQc.CzQ, ((st)localObject).FQc.CzR, ((st)localObject).FQc.Dhk);
          }
          else
          {
            localObject = this.oNZ.oNY;
            str = paramView.bYq().FrW;
            p.g(str, "vipCardConvertData.vipCardInfo.user_card_id");
            VipCardListUI.a((VipCardListUI)localObject, str);
          }
        }
      }
    }
    
    @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onLongClick"})
    static final class d
      implements View.OnLongClickListener
    {
      d(VipCardListUI.c paramc, com.tencent.mm.view.recyclerview.e parame) {}
      
      public final boolean onLongClick(View paramView)
      {
        AppMethodBeat.i(215584);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/card/ui/v3/VipCardListUI$VipCardConverter$onCreateViewHolder$2", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
        final VipCardListUI.b localb = (VipCardListUI.b)parame.fQC();
        localObject = new com.tencent.mm.ui.widget.b.a((Context)this.oNZ.oNY.getContext(), paramView);
        ((com.tencent.mm.ui.widget.b.a)localObject).a((View.OnCreateContextMenuListener)new View.OnCreateContextMenuListener()
        {
          public final void onCreateContextMenu(ContextMenu paramAnonymousContextMenu, View paramAnonymousView, ContextMenu.ContextMenuInfo paramAnonymousContextMenuInfo)
          {
            AppMethodBeat.i(215582);
            paramAnonymousContextMenu.add(0, 1, 0, (CharSequence)this.oOb.oNZ.oNY.getString(2131755707));
            AppMethodBeat.o(215582);
          }
        });
        ((com.tencent.mm.ui.widget.b.a)localObject).a((n.e)new n.e()
        {
          public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
          {
            AppMethodBeat.i(215583);
            paramAnonymousMenuItem = this.oOb.oNZ;
            String str = localb.bYq().FrW;
            p.g(str, "vipCardConvertData.vipCardInfo.user_card_id");
            com.tencent.mm.ui.widget.a.e locale = new com.tencent.mm.ui.widget.a.e((Context)paramAnonymousMenuItem.oNY.getContext(), 1, true);
            TextView localTextView = new TextView((Context)paramAnonymousMenuItem.oNY.getContext());
            localTextView.setText((CharSequence)paramAnonymousMenuItem.oNY.getString(2131756885));
            localTextView.setTextSize(1, 14.0F);
            localTextView.setTextColor(paramAnonymousMenuItem.oNY.getResources().getColor(2131100482));
            localTextView.setGravity(17);
            paramAnonymousInt = paramAnonymousMenuItem.oNY.getResources().getDimensionPixelSize(2131165303);
            int i = paramAnonymousMenuItem.oNY.getResources().getDimensionPixelSize(2131165289);
            localTextView.setPadding(paramAnonymousInt, i, paramAnonymousInt, i);
            locale.K((View)localTextView, false);
            locale.a((n.d)new VipCardListUI.c.e(paramAnonymousMenuItem));
            locale.a((n.e)new VipCardListUI.c.f(paramAnonymousMenuItem, str));
            locale.cMW();
            AppMethodBeat.o(215583);
          }
        });
        p.g(paramView, "it");
        paramView = m.dJ(paramView);
        ((com.tencent.mm.ui.widget.b.a)localObject).el(paramView.x, paramView.y);
        g.yhR.f(19747, new Object[] { Integer.valueOf(1), Integer.valueOf(3) });
        com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/card/ui/v3/VipCardListUI$VipCardConverter$onCreateViewHolder$2", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
        AppMethodBeat.o(215584);
        return false;
      }
    }
    
    @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Lcom/tencent/mm/ui/base/MMMenu;", "kotlin.jvm.PlatformType", "onCreateMMMenu"})
    static final class e
      implements n.d
    {
      e(VipCardListUI.c paramc) {}
      
      public final void onCreateMMMenu(com.tencent.mm.ui.base.l paraml)
      {
        AppMethodBeat.i(215585);
        paraml.a(1, this.oNZ.oNY.getResources().getColor(2131100800), (CharSequence)this.oNZ.oNY.getString(2131755707));
        AppMethodBeat.o(215585);
      }
    }
    
    @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "menuItem", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "", "onMMMenuItemSelected"})
    static final class f
      implements n.e
    {
      f(VipCardListUI.c paramc, String paramString) {}
      
      public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
      {
        AppMethodBeat.i(215586);
        p.g(paramMenuItem, "menuItem");
        switch (paramMenuItem.getItemId())
        {
        }
        for (;;)
        {
          AppMethodBeat.o(215586);
          return;
          VipCardListUI.c(this.oNZ.oNY, this.oLV);
          g.yhR.f(19747, new Object[] { Integer.valueOf(1), Integer.valueOf(4) });
        }
      }
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "kotlin.jvm.PlatformType", "it", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/DeleteCardInTicketListResponse;", "call"})
  static final class d<_Ret, _Var>
    implements com.tencent.mm.vending.c.a<_Ret, _Var>
  {
    d(VipCardListUI paramVipCardListUI, String paramString) {}
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/GetMemberCardHomePageResponse;", "kotlin.jvm.PlatformType", "invoke"})
  static final class e
    extends q
    implements d.g.a.b<com.tencent.mm.al.a.a<bea>, z>
  {
    e(VipCardListUI paramVipCardListUI, boolean paramBoolean)
    {
      super();
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/card/ui/v3/VipCardListUI$initView$1", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "getItemConvert", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "type", "", "plugin-card_release"})
  public static final class f
    implements com.tencent.mm.view.recyclerview.c
  {
    public final com.tencent.mm.view.recyclerview.b<?> AL(int paramInt)
    {
      AppMethodBeat.i(215591);
      com.tencent.mm.view.recyclerview.b localb = (com.tencent.mm.view.recyclerview.b)new VipCardListUI.c(this.oNY);
      AppMethodBeat.o(215591);
      return localb;
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/card/ui/v3/VipCardListUI$initView$2", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback;", "onLoadMoreBegin", "", "onLoadMoreEnd", "reason", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;", "", "plugin-card_release"})
  public static final class g
    extends RefreshLoadMoreLayout.a
  {
    public final void AM(int paramInt)
    {
      AppMethodBeat.i(215595);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.mr(paramInt);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/card/ui/v3/VipCardListUI$initView$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshBegin", "(I)V", this, localb.ahq());
      super.AM(paramInt);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/card/ui/v3/VipCardListUI$initView$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshBegin", "(I)V");
      AppMethodBeat.o(215595);
    }
    
    public final void a(RefreshLoadMoreLayout.c<Object> paramc)
    {
      AppMethodBeat.i(215594);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bd(paramc);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/card/ui/v3/VipCardListUI$initView$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V", this, localb.ahq());
      p.h(paramc, "reason");
      ad.d(VipCardListUI.a(this.oNY), "on load more end: " + VipCardListUI.c(this.oNY));
      if (VipCardListUI.d(this.oNY)) {
        VipCardListUI.e(this.oNY).k(null);
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/card/ui/v3/VipCardListUI$initView$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V");
      AppMethodBeat.o(215594);
    }
    
    public final void b(RefreshLoadMoreLayout.c paramc)
    {
      AppMethodBeat.i(215596);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bd(paramc);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/card/ui/v3/VipCardListUI$initView$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V", this, localb.ahq());
      super.b(paramc);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/card/ui/v3/VipCardListUI$initView$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V");
      AppMethodBeat.o(215596);
    }
    
    public final void bYl()
    {
      AppMethodBeat.i(215593);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/card/ui/v3/VipCardListUI$initView$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreBegin", "()V", this);
      ad.d(VipCardListUI.a(this.oNY), "on load more");
      com.tencent.mm.ad.c.g((d.g.a.a)new a(this));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/card/ui/v3/VipCardListUI$initView$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreBegin", "()V");
      AppMethodBeat.o(215593);
    }
    
    @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
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
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "menuItem", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "index", "", "onMMMenuItemSelected"})
  static final class j
    implements n.e
  {
    j(VipCardListUI paramVipCardListUI) {}
    
    public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
    {
      AppMethodBeat.i(215600);
      p.g(paramMenuItem, "menuItem");
      paramInt = paramMenuItem.getItemId();
      ad.i(VipCardListUI.a(this.oNY), "click item: %s", new Object[] { Integer.valueOf(paramInt) });
      if (paramInt == 1)
      {
        if (!VipCardListUI.g(this.oNY))
        {
          h.a((Context)this.oNY.getContext(), this.oNY.getString(2131756893), this.oNY.getString(2131761885), this.oNY.getString(2131760598), this.oNY.getString(2131757558), false, (DialogInterface.OnClickListener)new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(215599);
              this.oOe.oNY.startActivityForResult(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"), 564);
              AppMethodBeat.o(215599);
            }
          }, null);
          AppMethodBeat.o(215600);
          return;
        }
        VipCardListUI.b(this.oNY, VipCardListUI.i(this.oNY));
        VipCardListUI.c(this.oNY, 1);
        VipCardListUI.d(this.oNY, paramMenuItem.getTitle().toString());
        VipCardListUI.j(this.oNY);
        VipCardListUI.a(this.oNY, true);
        g.yhR.f(19747, new Object[] { Integer.valueOf(1), Integer.valueOf(5) });
        AppMethodBeat.o(215600);
        return;
      }
      VipCardListUI.b(this.oNY, VipCardListUI.i(this.oNY));
      VipCardListUI.c(this.oNY, paramInt);
      VipCardListUI.d(this.oNY, paramMenuItem.getTitle().toString());
      VipCardListUI.j(this.oNY);
      VipCardListUI.a(this.oNY, true);
      g.yhR.f(19747, new Object[] { Integer.valueOf(1), Integer.valueOf(6) });
      AppMethodBeat.o(215600);
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class k
    implements MenuItem.OnMenuItemClickListener
  {
    k(VipCardListUI paramVipCardListUI, y.a parama1, y.a parama2) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(215603);
      paramMenuItem = new com.tencent.mm.ui.widget.a.e((Context)this.oNY.getContext(), 1, false);
      paramMenuItem.a((n.d)new n.d()
      {
        public final void onCreateMMMenu(com.tencent.mm.ui.base.l paramAnonymousl)
        {
          AppMethodBeat.i(215601);
          if (this.oOh.oOf.MLQ) {
            paramAnonymousl.add(0, 1, 0, (CharSequence)VipCardListUI.q(this.oOh.oNY));
          }
          if (this.oOh.oOg.MLQ) {
            paramAnonymousl.add(0, 2, 1, (CharSequence)VipCardListUI.p(this.oOh.oNY));
          }
          AppMethodBeat.o(215601);
        }
      });
      paramMenuItem.a((n.e)new n.e()
      {
        public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
        {
          AppMethodBeat.i(215602);
          p.g(paramAnonymousMenuItem, "menuItem");
          Object localObject;
          tg localtg;
          if (paramAnonymousMenuItem.getItemId() == 1)
          {
            VipCardListUI.l(this.oOh.oNY);
            paramAnonymousMenuItem = VipCardListUI.m(this.oOh.oNY);
            if (paramAnonymousMenuItem == null) {
              p.gfZ();
            }
            paramAnonymousMenuItem = paramAnonymousMenuItem.CzQ;
            localObject = VipCardListUI.m(this.oOh.oNY);
            if (localObject == null) {
              p.gfZ();
            }
            localObject = ((tg)localObject).CzR;
            localtg = VipCardListUI.m(this.oOh.oNY);
            if (localtg == null) {
              p.gfZ();
            }
            com.tencent.mm.plugin.card.d.b.I(paramAnonymousMenuItem, (String)localObject, localtg.Dhk);
            g.yhR.f(19747, new Object[] { Integer.valueOf(1), Integer.valueOf(7) });
            AppMethodBeat.o(215602);
            return;
          }
          if (paramAnonymousMenuItem.getItemId() == 2)
          {
            paramAnonymousMenuItem = VipCardListUI.o(this.oOh.oNY);
            if (paramAnonymousMenuItem == null) {
              p.gfZ();
            }
            paramAnonymousMenuItem = paramAnonymousMenuItem.CzQ;
            localObject = VipCardListUI.o(this.oOh.oNY);
            if (localObject == null) {
              p.gfZ();
            }
            localObject = ((tg)localObject).CzR;
            localtg = VipCardListUI.o(this.oOh.oNY);
            if (localtg == null) {
              p.gfZ();
            }
            com.tencent.mm.plugin.card.d.b.I(paramAnonymousMenuItem, (String)localObject, localtg.Dhk);
            g.yhR.f(19747, new Object[] { Integer.valueOf(1), Integer.valueOf(2) });
          }
          AppMethodBeat.o(215602);
        }
      });
      paramMenuItem.cMW();
      g.yhR.f(19747, new Object[] { Integer.valueOf(1), Integer.valueOf(1) });
      AppMethodBeat.o(215603);
      return false;
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class l
    implements View.OnClickListener
  {
    l(VipCardListUI paramVipCardListUI) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(215604);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/card/ui/v3/VipCardListUI$updateTopHeaderLayout$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
      ad.d(VipCardListUI.a(this.oNY), "click header view");
      VipCardListUI.k(this.oNY);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/card/ui/v3/VipCardListUI$updateTopHeaderLayout$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(215604);
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class m
    implements View.OnClickListener
  {
    m(VipCardListUI paramVipCardListUI) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(215605);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/card/ui/v3/VipCardListUI$updateTopHeaderLayout$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
      VipCardListUI.l(this.oNY);
      paramView = VipCardListUI.m(this.oNY);
      if (paramView == null) {
        p.gfZ();
      }
      paramView = paramView.CzQ;
      localObject = VipCardListUI.m(this.oNY);
      if (localObject == null) {
        p.gfZ();
      }
      localObject = ((tg)localObject).CzR;
      tg localtg = VipCardListUI.m(this.oNY);
      if (localtg == null) {
        p.gfZ();
      }
      com.tencent.mm.plugin.card.d.b.I(paramView, (String)localObject, localtg.Dhk);
      g.yhR.f(19747, new Object[] { Integer.valueOf(1), Integer.valueOf(8) });
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/card/ui/v3/VipCardListUI$updateTopHeaderLayout$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(215605);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.v3.VipCardListUI
 * JD-Core Version:    0.7.0.1
 */