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
import com.tencent.mm.al.c.a;
import com.tencent.mm.plugin.card.d.m;
import com.tencent.mm.plugin.card.model.a.a.a;
import com.tencent.mm.plugin.card.model.a.a.a.d;
import com.tencent.mm.plugin.card.model.a.a.a.e;
import com.tencent.mm.plugin.card.ui.v2.CardNewBaseUI;
import com.tencent.mm.plugin.card.widget.MemberCardTopCropImageView;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.awe;
import com.tencent.mm.protocal.protobuf.cmf;
import com.tencent.mm.protocal.protobuf.qq;
import com.tencent.mm.protocal.protobuf.rc;
import com.tencent.mm.protocal.protobuf.rk;
import com.tencent.mm.protocal.protobuf.rl;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.widget.RoundCornerImageView;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.RefreshLoadMoreLayout.a;
import com.tencent.mm.view.RefreshLoadMoreLayout.c;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.mm.view.recyclerview.WxRecyclerView;
import d.g.b.k;
import d.g.b.v.a;
import d.v;
import d.y;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/card/ui/v3/VipCardListUI;", "Lcom/tencent/mm/plugin/card/ui/v2/CardNewBaseUI;", "()V", "TAG", "", "loadCount", "", "mCurrentSortInfo", "mCurrentSortWording", "mEmptyView", "Landroid/view/ViewGroup;", "mFirstLoad", "", "mHasLoadedSuccess", "mHeaderView", "mHistoryEntranceWording", "mHistoryMiniAppInfo", "Lcom/tencent/mm/protocal/protobuf/CardMiniAppInfo;", "mIsAll", "mIsLoading", "mNeedRefreshList", "mOffset", "mPhoneMemberEntranceWording", "mPhoneMemberMenuEntranceWording", "mPhoneMemberMiniAppInfo", "mPreviousSortInfo", "mRefreshLayout", "Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "mReqNum", "mSortInfoList", "Lcom/tencent/mm/protocal/protobuf/CardSortInfoList;", "mSortLayout", "mSortTv", "Landroid/widget/TextView;", "mTopPhoneVipCardLayout", "mTopPhoneVipCardTv", "mViewHeight", "mVipCardList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/card/ui/v3/VipCardListUI$VipCardConvertData;", "Lkotlin/collections/ArrayList;", "mVipCardListAdapter", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "mVipCardListRv", "Lcom/tencent/mm/view/recyclerview/WxRecyclerView;", "doDeleteVipCard", "", "cardId", "doLoadVipCardList", "refresh", "getLayoutId", "getPositionByUserCardId", "gotoCardDetailUI", "initView", "loadSnapshot", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onFinishLocationThings", "ret", "isLocationOk", "onResume", "saveSnapshot", "showSortDialog", "updateIconMenu", "updateTopHeaderLayout", "updateViewByResp", "resp", "Lcom/tencent/mm/protocal/protobuf/GetMemberCardHomePageResponse;", "Companion", "VipCardConvertData", "VipCardConverter", "plugin-card_release"})
public final class VipCardListUI
  extends CardNewBaseUI
{
  public static final VipCardListUI.a nHB;
  private int LZ;
  private final String TAG;
  private int aNJ;
  private boolean knt;
  private boolean kwQ;
  private ViewGroup nFU;
  private TextView nGS;
  private int nGV;
  private rc nGZ;
  private RefreshLoadMoreLayout nGj;
  private ViewGroup nGk;
  private boolean nGq;
  private boolean nGr;
  private int nGv;
  private String nHA;
  private String nHa;
  private rl nHb;
  private String nHc;
  private int nHd;
  private int nHe;
  private WxRecyclerView nHr;
  private ViewGroup nHs;
  private ViewGroup nHt;
  private TextView nHu;
  private WxRecyclerAdapter<b> nHv;
  private final ArrayList<b> nHw;
  private boolean nHx;
  private rc nHy;
  private String nHz;
  
  static
  {
    AppMethodBeat.i(192840);
    nHB = new VipCardListUI.a((byte)0);
    AppMethodBeat.o(192840);
  }
  
  public VipCardListUI()
  {
    AppMethodBeat.i(192839);
    this.TAG = "MicroMsg.VipCardListUI";
    this.nHw = new ArrayList();
    this.nGV = 10;
    this.nHc = "";
    this.kwQ = true;
    AppMethodBeat.o(192839);
  }
  
  private final void a(awe paramawe)
  {
    AppMethodBeat.i(192838);
    this.nHb = paramawe.DsW;
    paramawe = paramawe.CQu.iterator();
    while (paramawe.hasNext())
    {
      qq localqq = (qq)paramawe.next();
      b localb = new b();
      k.g(localqq, "cardInfo");
      localb.a(localqq);
      this.nHw.add(localb);
    }
    if (this.nHw.isEmpty())
    {
      paramawe = this.nFU;
      if (paramawe == null) {
        k.aPZ("mEmptyView");
      }
      paramawe.setVisibility(0);
    }
    for (;;)
    {
      paramawe = this.nHv;
      if (paramawe == null) {
        k.aPZ("mVipCardListAdapter");
      }
      paramawe.notifyDataSetChanged();
      AppMethodBeat.o(192838);
      return;
      paramawe = this.nFU;
      if (paramawe == null) {
        k.aPZ("mEmptyView");
      }
      paramawe.setVisibility(8);
    }
  }
  
  private final void bMw()
  {
    AppMethodBeat.i(192837);
    final v.a locala1 = new v.a();
    locala1.Jhs = false;
    final v.a locala2 = new v.a();
    locala2.Jhs = false;
    if (this.nHy != null)
    {
      CharSequence localCharSequence = (CharSequence)this.nHA;
      if ((localCharSequence != null) && (localCharSequence.length() != 0)) {
        break label133;
      }
    }
    label133:
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        locala1.Jhs = true;
      }
      if (this.nGZ != null) {
        locala2.Jhs = true;
      }
      if ((locala1.Jhs) || (locala2.Jhs))
      {
        removeAllOptionMenu();
        addIconOptionMenu(0, 0, 2131690603, (MenuItem.OnMenuItemClickListener)new k(this, locala1, locala2));
      }
      AppMethodBeat.o(192837);
      return;
    }
  }
  
  private final void bMz()
  {
    int k = 1;
    AppMethodBeat.i(192835);
    int i;
    label123:
    int j;
    if (this.nHd > 0) {
      if (!((Collection)this.nHw).isEmpty())
      {
        i = 1;
        if (i == 0) {
          break label310;
        }
        localObject = this.nGS;
        if (localObject == null) {
          k.aPZ("mSortTv");
        }
        ((TextView)localObject).setText((CharSequence)this.nHc);
        localObject = this.nHs;
        if (localObject == null) {
          k.aPZ("mSortLayout");
        }
        ((ViewGroup)localObject).setVisibility(0);
        localObject = this.nHs;
        if (localObject == null) {
          k.aPZ("mSortLayout");
        }
        ((ViewGroup)localObject).setOnClickListener((View.OnClickListener)new l(this));
        i = 1;
        localObject = (CharSequence)this.nHz;
        if ((localObject != null) && (((CharSequence)localObject).length() != 0)) {
          break label339;
        }
        j = 1;
        label149:
        if ((j != 0) || (this.nHy == null)) {
          break label344;
        }
        localObject = this.nHt;
        if (localObject == null) {
          k.aPZ("mTopPhoneVipCardLayout");
        }
        ((ViewGroup)localObject).setVisibility(0);
        localObject = this.nHu;
        if (localObject == null) {
          k.aPZ("mTopPhoneVipCardTv");
        }
        ((TextView)localObject).setText((CharSequence)this.nHz);
        localObject = this.nHt;
        if (localObject == null) {
          k.aPZ("mTopPhoneVipCardLayout");
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
      localObject = this.nHv;
      if (localObject == null) {
        k.aPZ("mVipCardListAdapter");
      }
      localViewGroup = this.nGk;
      if (localViewGroup == null) {
        k.aPZ("mHeaderView");
      }
      ((WxRecyclerAdapter)localObject).f((View)localViewGroup, 2, false);
      AppMethodBeat.o(192835);
      return;
      i = 0;
      break;
      label310:
      localObject = this.nHs;
      if (localObject == null) {
        k.aPZ("mSortLayout");
      }
      ((ViewGroup)localObject).setVisibility(8);
      i = 0;
      break label123;
      label339:
      j = 0;
      break label149;
      label344:
      localObject = this.nHt;
      if (localObject == null) {
        k.aPZ("mTopPhoneVipCardLayout");
      }
      ((ViewGroup)localObject).setVisibility(8);
    }
    label371:
    Object localObject = this.nHv;
    if (localObject == null) {
      k.aPZ("mVipCardListAdapter");
    }
    ViewGroup localViewGroup = this.nGk;
    if (localViewGroup == null) {
      k.aPZ("mHeaderView");
    }
    ((WxRecyclerAdapter)localObject).i(localViewGroup.hashCode(), false);
    AppMethodBeat.o(192835);
  }
  
  private final void iL(final boolean paramBoolean)
  {
    int i = 0;
    AppMethodBeat.i(192836);
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
      AppMethodBeat.o(192836);
      return;
    }
    if (this.knt)
    {
      ad.w(this.TAG, "is loading");
      AppMethodBeat.o(192836);
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
      localObject = new com.tencent.mm.plugin.card.model.b.b(i, this.nGV, this.dpb, this.dqQ, this.nHd).auK();
      k.g(localObject, "CgiGetMemberCardHomePage…, mCurrentSortInfo).run()");
      com.tencent.mm.ad.c.b((com.tencent.mm.vending.g.c)localObject, (d.g.a.b)new e(this, paramBoolean)).b((com.tencent.mm.vending.e.b)this);
      AppMethodBeat.o(192836);
      return;
      i = j;
    }
  }
  
  public final void V(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(192834);
    if ((this.kwQ) && (this.nHd == 1))
    {
      iL(true);
      AppMethodBeat.o(192834);
      return;
    }
    if (!paramBoolean) {
      bMl();
    }
    AppMethodBeat.o(192834);
  }
  
  public final int getLayoutId()
  {
    return 2131493307;
  }
  
  public final void initView()
  {
    AppMethodBeat.i(192831);
    Object localObject1 = findViewById(2131298323);
    k.g(localObject1, "findViewById(R.id.chpvv3_rv)");
    this.nHr = ((WxRecyclerView)localObject1);
    localObject1 = findViewById(2131298321);
    k.g(localObject1, "findViewById(R.id.chpvv3_refresh_layout)");
    this.nGj = ((RefreshLoadMoreLayout)localObject1);
    localObject1 = findViewById(2131298319);
    k.g(localObject1, "findViewById(R.id.chpvv3_empty_layout)");
    this.nFU = ((ViewGroup)localObject1);
    localObject1 = this.nHr;
    if (localObject1 == null) {
      k.aPZ("mVipCardListRv");
    }
    getContext();
    ((WxRecyclerView)localObject1).setLayoutManager((RecyclerView.i)new LinearLayoutManager(1));
    this.nHv = new WxRecyclerAdapter((com.tencent.mm.view.recyclerview.c)new f(this), this.nHw);
    localObject1 = this.nHr;
    if (localObject1 == null) {
      k.aPZ("mVipCardListRv");
    }
    Object localObject2 = this.nHv;
    if (localObject2 == null) {
      k.aPZ("mVipCardListAdapter");
    }
    ((WxRecyclerView)localObject1).setAdapter((RecyclerView.a)localObject2);
    localObject1 = new w((Context)getContext());
    ((w)localObject1).setDrawable(getResources().getDrawable(2131231470));
    localObject2 = this.nHr;
    if (localObject2 == null) {
      k.aPZ("mVipCardListRv");
    }
    ((WxRecyclerView)localObject2).b((RecyclerView.h)localObject1);
    localObject1 = getLayoutInflater();
    localObject2 = this.nHr;
    if (localObject2 == null) {
      k.aPZ("mVipCardListRv");
    }
    localObject1 = ((LayoutInflater)localObject1).inflate(2131493305, (ViewGroup)localObject2, false);
    if (localObject1 == null)
    {
      localObject1 = new v("null cannot be cast to non-null type android.view.ViewGroup");
      AppMethodBeat.o(192831);
      throw ((Throwable)localObject1);
    }
    this.nGk = ((ViewGroup)localObject1);
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
    localObject1 = ((ViewGroup)localObject1).findViewById(2131298324);
    k.g(localObject1, "mHeaderView.findViewById(R.id.chpvv3_sort_layout)");
    this.nHs = ((ViewGroup)localObject1);
    localObject1 = this.nGk;
    if (localObject1 == null) {
      k.aPZ("mHeaderView");
    }
    localObject1 = ((ViewGroup)localObject1).findViewById(2131298327);
    k.g(localObject1, "mHeaderView.findViewById…top_phone_vipcard_layout)");
    this.nHt = ((ViewGroup)localObject1);
    localObject1 = this.nGk;
    if (localObject1 == null) {
      k.aPZ("mHeaderView");
    }
    localObject1 = ((ViewGroup)localObject1).findViewById(2131298328);
    k.g(localObject1, "mHeaderView.findViewById…vv3_top_phone_vipcard_tv)");
    this.nHu = ((TextView)localObject1);
    localObject1 = this.nHv;
    if (localObject1 == null) {
      k.aPZ("mVipCardListAdapter");
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
    ((RefreshLoadMoreLayout)localObject1).setActionCallback((RefreshLoadMoreLayout.a)new g(this));
    AppMethodBeat.o(192831);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(192830);
    super.onCreate(paramBundle);
    initView();
    setMMTitle(2131756930);
    setActionbarColor(getResources().getColor(2131099648));
    hideActionbarLine();
    setBackBtn((MenuItem.OnMenuItemClickListener)new VipCardListUI.h(this));
    paramBundle = com.tencent.mm.plugin.card.model.a.a.nuE;
    paramBundle = a.a.bJn();
    if (paramBundle != null)
    {
      this.LZ = paramBundle.ocT;
      this.nHb = paramBundle.DsW;
      this.nGZ = paramBundle.DsS;
      this.nHa = paramBundle.DsT;
      this.nHy = paramBundle.Dvz;
      this.nHz = paramBundle.DvB;
      this.nHA = paramBundle.DvA;
      bMw();
      a(paramBundle);
    }
    paramBundle = com.tencent.mm.plugin.card.model.a.a.nuE;
    paramBundle = a.a.bJo();
    if (paramBundle != null)
    {
      this.nHd = paramBundle.CRs;
      String str = paramBundle.CRu;
      k.g(str, "cardSortInfo.sort_wording");
      this.nHc = str;
      this.nGV = paramBundle.CRt;
      this.nHe = this.nHd;
    }
    bMz();
    if (this.nHd != 1) {
      iL(true);
    }
    AppMethodBeat.o(192830);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(192833);
    super.onDestroy();
    if (!this.nGr)
    {
      ad.i(this.TAG, "no data to save snapshot");
      AppMethodBeat.o(192833);
      return;
    }
    Object localObject1 = new awe();
    ((awe)localObject1).BaseResponse = new BaseResponse();
    ((awe)localObject1).BaseResponse.ErrMsg = new cmf();
    Object localObject2 = this.nHw.iterator();
    while (((Iterator)localObject2).hasNext())
    {
      b localb = (b)((Iterator)localObject2).next();
      if (localb.bMA() != null) {
        ((awe)localObject1).CQu.add(localb.bMA());
      }
    }
    ((awe)localObject1).DsW = this.nHb;
    ((awe)localObject1).ocT = this.LZ;
    ((awe)localObject1).DsT = this.nHa;
    ((awe)localObject1).DsS = this.nGZ;
    ((awe)localObject1).Dvz = this.nHy;
    ((awe)localObject1).DvA = this.nHA;
    ((awe)localObject1).DvB = this.nHz;
    localObject2 = com.tencent.mm.plugin.card.model.a.a.nuE;
    k.h(localObject1, "response");
    ad.d(com.tencent.mm.plugin.card.model.a.a.access$getTAG$cp(), "save vip card list snapshot");
    com.tencent.mm.ad.c.b(null, (d.g.a.a)new a.a.d((awe)localObject1));
    localObject1 = new rk();
    ((rk)localObject1).CRs = this.nHd;
    ((rk)localObject1).CRu = this.nHc;
    ((rk)localObject1).CRt = this.nGV;
    localObject2 = com.tencent.mm.plugin.card.model.a.a.nuE;
    k.h(localObject1, "sortInfo");
    ad.d(com.tencent.mm.plugin.card.model.a.a.access$getTAG$cp(), "save vip card list snapshot");
    com.tencent.mm.ad.c.b(null, (d.g.a.a)new a.a.e((rk)localObject1));
    AppMethodBeat.o(192833);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(192832);
    if (this.nHx)
    {
      iL(true);
      this.nHx = false;
    }
    super.onResume();
    AppMethodBeat.o(192832);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/card/ui/v3/VipCardListUI$VipCardConvertData;", "Lcom/tencent/mm/view/recyclerview/ConvertData;", "()V", "vipCardInfo", "Lcom/tencent/mm/protocal/protobuf/CardElementCouponList;", "getVipCardInfo", "()Lcom/tencent/mm/protocal/protobuf/CardElementCouponList;", "setVipCardInfo", "(Lcom/tencent/mm/protocal/protobuf/CardElementCouponList;)V", "getItemId", "", "getItemType", "", "plugin-card_release"})
  public static final class b
    implements com.tencent.mm.view.recyclerview.a
  {
    public qq nHC;
    
    public final void a(qq paramqq)
    {
      AppMethodBeat.i(192803);
      k.h(paramqq, "<set-?>");
      this.nHC = paramqq;
      AppMethodBeat.o(192803);
    }
    
    public final qq bMA()
    {
      AppMethodBeat.i(192802);
      qq localqq = this.nHC;
      if (localqq == null) {
        k.aPZ("vipCardInfo");
      }
      AppMethodBeat.o(192802);
      return localqq;
    }
    
    public final long bMs()
    {
      AppMethodBeat.i(192804);
      qq localqq = this.nHC;
      if (localqq == null) {
        k.aPZ("vipCardInfo");
      }
      long l = localqq.CuA.hashCode();
      AppMethodBeat.o(192804);
      return l;
    }
    
    public final int bMt()
    {
      return 1;
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/card/ui/v3/VipCardListUI$VipCardConverter;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "Lcom/tencent/mm/plugin/card/ui/v3/VipCardListUI$VipCardConvertData;", "(Lcom/tencent/mm/plugin/card/ui/v3/VipCardListUI;)V", "getLayoutId", "", "onBindViewHolder", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "position", "type", "isHotPatch", "", "payloads", "", "", "onCreateViewHolder", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "showDeleteConfirmDialog", "cardId", "", "updateCardLabelLayout", "couponLabelList", "", "Lcom/tencent/mm/protocal/protobuf/CardElementCouponLabel;", "labelLayout", "Landroid/widget/LinearLayout;", "plugin-card_release"})
  public final class c
    extends com.tencent.mm.view.recyclerview.b<VipCardListUI.b>
  {
    public final void a(RecyclerView paramRecyclerView, final com.tencent.mm.view.recyclerview.e parame, int paramInt)
    {
      AppMethodBeat.i(192813);
      k.h(paramRecyclerView, "recyclerView");
      k.h(parame, "holder");
      ((RoundCornerImageView)parame.abq(2131298320)).jG(com.tencent.mm.cd.a.fromDPToPix((Context)this.nHD.getContext(), 1), this.nHD.getResources().getColor(2131099828));
      parame.arI.setOnClickListener((View.OnClickListener)new c(this, parame));
      parame.arI.setOnLongClickListener((View.OnLongClickListener)new d(this, parame));
      AppMethodBeat.o(192813);
    }
    
    public final int getLayoutId()
    {
      return 2131493306;
    }
    
    @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run"})
    static final class a
      implements Runnable
    {
      a(VipCardListUI.c paramc, com.tencent.mm.view.recyclerview.e parame, d.g.a.a parama) {}
      
      public final void run()
      {
        AppMethodBeat.i(192805);
        VipCardListUI localVipCardListUI = this.nHE.nHD;
        View localView = this.nGG.arI;
        k.g(localView, "holder.itemView");
        VipCardListUI.a(localVipCardListUI, localView.getHeight());
        this.nGH.invoke();
        AppMethodBeat.o(192805);
      }
    }
    
    @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
    static final class b
      extends d.g.b.l
      implements d.g.a.a<y>
    {
      b(VipCardListUI.c paramc, MemberCardTopCropImageView paramMemberCardTopCropImageView, VipCardListUI.b paramb, com.tencent.mm.view.recyclerview.e parame)
      {
        super();
      }
    }
    
    @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class c
      implements View.OnClickListener
    {
      c(VipCardListUI.c paramc, com.tencent.mm.view.recyclerview.e parame) {}
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(192807);
        paramView = (VipCardListUI.b)parame.fjf();
        Object localObject = paramView.bMA();
        if (((qq)localObject).CQf == 1) {
          com.tencent.mm.plugin.card.d.b.a((MMActivity)this.nHE.nHD.getContext(), ((qq)localObject).CQg);
        }
        for (;;)
        {
          localObject = com.tencent.mm.plugin.report.service.h.vKh;
          long l = System.currentTimeMillis() / 1000L;
          String str = paramView.bMA().CuA;
          VipCardListUI localVipCardListUI = this.nHE.nHD;
          paramView = paramView.bMA().CuA;
          k.g(paramView, "vipCardConvertData.vipCardInfo.user_card_id");
          ((com.tencent.mm.plugin.report.service.h)localObject).f(19748, new Object[] { Integer.valueOf(1), Long.valueOf(l), str, Integer.valueOf(VipCardListUI.b(localVipCardListUI, paramView)), Integer.valueOf(0) });
          AppMethodBeat.o(192807);
          return;
          if (((qq)localObject).CQf == 2)
          {
            com.tencent.mm.plugin.card.d.b.G(((qq)localObject).CQh.zHs, ((qq)localObject).CQh.zHt, ((qq)localObject).CQh.Aoy);
          }
          else
          {
            localObject = this.nHE.nHD;
            str = paramView.bMA().CuA;
            k.g(str, "vipCardConvertData.vipCardInfo.user_card_id");
            VipCardListUI.a((VipCardListUI)localObject, str);
          }
        }
      }
    }
    
    @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onLongClick"})
    static final class d
      implements View.OnLongClickListener
    {
      d(VipCardListUI.c paramc, com.tencent.mm.view.recyclerview.e parame) {}
      
      public final boolean onLongClick(View paramView)
      {
        AppMethodBeat.i(192810);
        final VipCardListUI.b localb = (VipCardListUI.b)parame.fjf();
        com.tencent.mm.ui.widget.b.a locala = new com.tencent.mm.ui.widget.b.a((Context)this.nHE.nHD.getContext(), paramView);
        locala.a((View.OnCreateContextMenuListener)new View.OnCreateContextMenuListener()
        {
          public final void onCreateContextMenu(ContextMenu paramAnonymousContextMenu, View paramAnonymousView, ContextMenu.ContextMenuInfo paramAnonymousContextMenuInfo)
          {
            AppMethodBeat.i(192808);
            paramAnonymousContextMenu.add(0, 1, 0, (CharSequence)this.nHG.nHE.nHD.getString(2131755707));
            AppMethodBeat.o(192808);
          }
        });
        locala.a((n.d)new n.d()
        {
          public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
          {
            AppMethodBeat.i(192809);
            paramAnonymousMenuItem = this.nHG.nHE;
            String str = localb.bMA().CuA;
            k.g(str, "vipCardConvertData.vipCardInfo.user_card_id");
            com.tencent.mm.ui.widget.a.e locale = new com.tencent.mm.ui.widget.a.e((Context)paramAnonymousMenuItem.nHD.getContext(), 1, true);
            TextView localTextView = new TextView((Context)paramAnonymousMenuItem.nHD.getContext());
            localTextView.setText((CharSequence)paramAnonymousMenuItem.nHD.getString(2131756885));
            localTextView.setTextSize(1, 14.0F);
            localTextView.setTextColor(paramAnonymousMenuItem.nHD.getResources().getColor(2131100482));
            localTextView.setGravity(17);
            paramAnonymousInt = paramAnonymousMenuItem.nHD.getResources().getDimensionPixelSize(2131165303);
            int i = paramAnonymousMenuItem.nHD.getResources().getDimensionPixelSize(2131165289);
            localTextView.setPadding(paramAnonymousInt, i, paramAnonymousInt, i);
            locale.J((View)localTextView, false);
            locale.a((n.c)new VipCardListUI.c.e(paramAnonymousMenuItem));
            locale.a((n.d)new VipCardListUI.c.f(paramAnonymousMenuItem, str));
            locale.csG();
            AppMethodBeat.o(192809);
          }
        });
        k.g(paramView, "it");
        paramView = m.dE(paramView);
        locala.eh(paramView.x, paramView.y);
        com.tencent.mm.plugin.report.service.h.vKh.f(19747, new Object[] { Integer.valueOf(1), Integer.valueOf(3) });
        AppMethodBeat.o(192810);
        return false;
      }
    }
    
    @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Lcom/tencent/mm/ui/base/MMMenu;", "kotlin.jvm.PlatformType", "onCreateMMMenu"})
    static final class e
      implements n.c
    {
      e(VipCardListUI.c paramc) {}
      
      public final void onCreateMMMenu(com.tencent.mm.ui.base.l paraml)
      {
        AppMethodBeat.i(192811);
        paraml.a(1, this.nHE.nHD.getResources().getColor(2131100800), (CharSequence)this.nHE.nHD.getString(2131755707));
        AppMethodBeat.o(192811);
      }
    }
    
    @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "menuItem", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "", "onMMMenuItemSelected"})
    static final class f
      implements n.d
    {
      f(VipCardListUI.c paramc, String paramString) {}
      
      public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
      {
        AppMethodBeat.i(192812);
        k.g(paramMenuItem, "menuItem");
        switch (paramMenuItem.getItemId())
        {
        }
        for (;;)
        {
          AppMethodBeat.o(192812);
          return;
          VipCardListUI.c(this.nHE.nHD, this.nFA);
          com.tencent.mm.plugin.report.service.h.vKh.f(19747, new Object[] { Integer.valueOf(1), Integer.valueOf(4) });
        }
      }
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "kotlin.jvm.PlatformType", "it", "Lcom/tencent/mm/modelbase/DeprecatedCgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/DeleteCardInTicketListResponse;", "call"})
  static final class d<_Ret, _Var>
    implements com.tencent.mm.vending.c.a<_Ret, _Var>
  {
    d(VipCardListUI paramVipCardListUI, String paramString) {}
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Lcom/tencent/mm/modelbase/DeprecatedCgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/GetMemberCardHomePageResponse;", "kotlin.jvm.PlatformType", "invoke"})
  static final class e
    extends d.g.b.l
    implements d.g.a.b<c.a<awe>, y>
  {
    e(VipCardListUI paramVipCardListUI, boolean paramBoolean)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/card/ui/v3/VipCardListUI$initView$1", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "getItemConvert", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "type", "", "plugin-card_release"})
  public static final class f
    implements com.tencent.mm.view.recyclerview.c
  {
    public final com.tencent.mm.view.recyclerview.b<?> zm(int paramInt)
    {
      AppMethodBeat.i(192817);
      com.tencent.mm.view.recyclerview.b localb = (com.tencent.mm.view.recyclerview.b)new VipCardListUI.c(this.nHD);
      AppMethodBeat.o(192817);
      return localb;
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/card/ui/v3/VipCardListUI$initView$2", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback;", "onLoadMoreBegin", "", "onLoadMoreEnd", "reason", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;", "", "plugin-card_release"})
  public static final class g
    extends RefreshLoadMoreLayout.a
  {
    public final void a(RefreshLoadMoreLayout.c<Object> paramc)
    {
      AppMethodBeat.i(192820);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.be(paramc);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/card/ui/v3/VipCardListUI$initView$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V", this, localb.ado());
      k.h(paramc, "reason");
      ad.d(VipCardListUI.a(this.nHD), "on load more end: " + VipCardListUI.c(this.nHD));
      if (VipCardListUI.d(this.nHD)) {
        VipCardListUI.e(this.nHD).g(null);
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/card/ui/v3/VipCardListUI$initView$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V");
      AppMethodBeat.o(192820);
    }
    
    public final void agP(int paramInt)
    {
      AppMethodBeat.i(205464);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.lT(paramInt);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/card/ui/v3/VipCardListUI$initView$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshBegin", "(I)V", this, localb.ado());
      super.agP(paramInt);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/card/ui/v3/VipCardListUI$initView$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshBegin", "(I)V");
      AppMethodBeat.o(205464);
    }
    
    public final void b(RefreshLoadMoreLayout.c paramc)
    {
      AppMethodBeat.i(205465);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.be(paramc);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/card/ui/v3/VipCardListUI$initView$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V", this, localb.ado());
      super.b(paramc);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/card/ui/v3/VipCardListUI$initView$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V");
      AppMethodBeat.o(205465);
    }
    
    public final void bMu()
    {
      AppMethodBeat.i(192819);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/card/ui/v3/VipCardListUI$initView$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreBegin", "()V", this);
      ad.d(VipCardListUI.a(this.nHD), "on load more");
      com.tencent.mm.ad.c.g((d.g.a.a)new a(this));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/card/ui/v3/VipCardListUI$initView$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreBegin", "()V");
      AppMethodBeat.o(192819);
    }
    
    @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
    static final class a
      extends d.g.b.l
      implements d.g.a.a<y>
    {
      a(VipCardListUI.g paramg)
      {
        super();
      }
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Lcom/tencent/mm/ui/base/MMMenu;", "kotlin.jvm.PlatformType", "onCreateMMMenu"})
  static final class i
    implements n.c
  {
    i(VipCardListUI paramVipCardListUI) {}
    
    public final void onCreateMMMenu(com.tencent.mm.ui.base.l paraml)
    {
      AppMethodBeat.i(192822);
      Object localObject = VipCardListUI.f(this.nHD);
      if (localObject == null) {
        k.fvU();
      }
      localObject = ((rl)localObject).CRv.iterator();
      while (((Iterator)localObject).hasNext())
      {
        rk localrk = (rk)((Iterator)localObject).next();
        paraml.add(0, localrk.CRs, 1, (CharSequence)localrk.CRu);
      }
      AppMethodBeat.o(192822);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "menuItem", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "index", "", "onMMMenuItemSelected"})
  static final class j
    implements n.d
  {
    j(VipCardListUI paramVipCardListUI) {}
    
    public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
    {
      AppMethodBeat.i(192824);
      k.g(paramMenuItem, "menuItem");
      paramInt = paramMenuItem.getItemId();
      ad.i(VipCardListUI.a(this.nHD), "click item: %s", new Object[] { Integer.valueOf(paramInt) });
      if (paramInt == 1)
      {
        if (!VipCardListUI.g(this.nHD))
        {
          com.tencent.mm.ui.base.h.a((Context)this.nHD.getContext(), this.nHD.getString(2131756893), this.nHD.getString(2131761885), this.nHD.getString(2131760598), this.nHD.getString(2131757558), false, (DialogInterface.OnClickListener)new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(192823);
              this.nHJ.nHD.startActivityForResult(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"), 564);
              AppMethodBeat.o(192823);
            }
          }, null);
          AppMethodBeat.o(192824);
          return;
        }
        VipCardListUI.b(this.nHD, VipCardListUI.i(this.nHD));
        VipCardListUI.c(this.nHD, 1);
        VipCardListUI.d(this.nHD, paramMenuItem.getTitle().toString());
        VipCardListUI.j(this.nHD);
        VipCardListUI.a(this.nHD, true);
        com.tencent.mm.plugin.report.service.h.vKh.f(19747, new Object[] { Integer.valueOf(1), Integer.valueOf(5) });
        AppMethodBeat.o(192824);
        return;
      }
      VipCardListUI.b(this.nHD, VipCardListUI.i(this.nHD));
      VipCardListUI.c(this.nHD, paramInt);
      VipCardListUI.d(this.nHD, paramMenuItem.getTitle().toString());
      VipCardListUI.j(this.nHD);
      VipCardListUI.a(this.nHD, true);
      com.tencent.mm.plugin.report.service.h.vKh.f(19747, new Object[] { Integer.valueOf(1), Integer.valueOf(6) });
      AppMethodBeat.o(192824);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class k
    implements MenuItem.OnMenuItemClickListener
  {
    k(VipCardListUI paramVipCardListUI, v.a parama1, v.a parama2) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(192827);
      paramMenuItem = new com.tencent.mm.ui.widget.a.e((Context)this.nHD.getContext(), 1, false);
      paramMenuItem.a((n.c)new n.c()
      {
        public final void onCreateMMMenu(com.tencent.mm.ui.base.l paramAnonymousl)
        {
          AppMethodBeat.i(192825);
          if (this.nHM.nHK.Jhs) {
            paramAnonymousl.add(0, 1, 0, (CharSequence)VipCardListUI.q(this.nHM.nHD));
          }
          if (this.nHM.nHL.Jhs) {
            paramAnonymousl.add(0, 2, 1, (CharSequence)VipCardListUI.p(this.nHM.nHD));
          }
          AppMethodBeat.o(192825);
        }
      });
      paramMenuItem.a((n.d)new n.d()
      {
        public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
        {
          AppMethodBeat.i(192826);
          k.g(paramAnonymousMenuItem, "menuItem");
          Object localObject;
          rc localrc;
          if (paramAnonymousMenuItem.getItemId() == 1)
          {
            VipCardListUI.l(this.nHM.nHD);
            paramAnonymousMenuItem = VipCardListUI.m(this.nHM.nHD);
            if (paramAnonymousMenuItem == null) {
              k.fvU();
            }
            paramAnonymousMenuItem = paramAnonymousMenuItem.zHs;
            localObject = VipCardListUI.m(this.nHM.nHD);
            if (localObject == null) {
              k.fvU();
            }
            localObject = ((rc)localObject).zHt;
            localrc = VipCardListUI.m(this.nHM.nHD);
            if (localrc == null) {
              k.fvU();
            }
            com.tencent.mm.plugin.card.d.b.G(paramAnonymousMenuItem, (String)localObject, localrc.Aoy);
            com.tencent.mm.plugin.report.service.h.vKh.f(19747, new Object[] { Integer.valueOf(1), Integer.valueOf(7) });
            AppMethodBeat.o(192826);
            return;
          }
          if (paramAnonymousMenuItem.getItemId() == 2)
          {
            paramAnonymousMenuItem = VipCardListUI.o(this.nHM.nHD);
            if (paramAnonymousMenuItem == null) {
              k.fvU();
            }
            paramAnonymousMenuItem = paramAnonymousMenuItem.zHs;
            localObject = VipCardListUI.o(this.nHM.nHD);
            if (localObject == null) {
              k.fvU();
            }
            localObject = ((rc)localObject).zHt;
            localrc = VipCardListUI.o(this.nHM.nHD);
            if (localrc == null) {
              k.fvU();
            }
            com.tencent.mm.plugin.card.d.b.G(paramAnonymousMenuItem, (String)localObject, localrc.Aoy);
            com.tencent.mm.plugin.report.service.h.vKh.f(19747, new Object[] { Integer.valueOf(1), Integer.valueOf(2) });
          }
          AppMethodBeat.o(192826);
        }
      });
      paramMenuItem.csG();
      com.tencent.mm.plugin.report.service.h.vKh.f(19747, new Object[] { Integer.valueOf(1), Integer.valueOf(1) });
      AppMethodBeat.o(192827);
      return false;
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class l
    implements View.OnClickListener
  {
    l(VipCardListUI paramVipCardListUI) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(192828);
      ad.d(VipCardListUI.a(this.nHD), "click header view");
      VipCardListUI.k(this.nHD);
      AppMethodBeat.o(192828);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class m
    implements View.OnClickListener
  {
    m(VipCardListUI paramVipCardListUI) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(192829);
      VipCardListUI.l(this.nHD);
      paramView = VipCardListUI.m(this.nHD);
      if (paramView == null) {
        k.fvU();
      }
      paramView = paramView.zHs;
      Object localObject = VipCardListUI.m(this.nHD);
      if (localObject == null) {
        k.fvU();
      }
      localObject = ((rc)localObject).zHt;
      rc localrc = VipCardListUI.m(this.nHD);
      if (localrc == null) {
        k.fvU();
      }
      com.tencent.mm.plugin.card.d.b.G(paramView, (String)localObject, localrc.Aoy);
      com.tencent.mm.plugin.report.service.h.vKh.f(19747, new Object[] { Integer.valueOf(1), Integer.valueOf(8) });
      AppMethodBeat.o(192829);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.v3.VipCardListUI
 * JD-Core Version:    0.7.0.1
 */