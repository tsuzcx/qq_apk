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
import com.tencent.mm.ak.c.a;
import com.tencent.mm.plugin.card.d.m;
import com.tencent.mm.plugin.card.model.a.a.a;
import com.tencent.mm.plugin.card.model.a.a.a.d;
import com.tencent.mm.plugin.card.model.a.a.a.e;
import com.tencent.mm.plugin.card.ui.v2.CardNewBaseUI;
import com.tencent.mm.plugin.card.widget.MemberCardTopCropImageView;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.azw;
import com.tencent.mm.protocal.protobuf.crm;
import com.tencent.mm.protocal.protobuf.ra;
import com.tencent.mm.protocal.protobuf.rm;
import com.tencent.mm.protocal.protobuf.ru;
import com.tencent.mm.protocal.protobuf.rv;
import com.tencent.mm.sdk.platformtools.ac;
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

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/card/ui/v3/VipCardListUI;", "Lcom/tencent/mm/plugin/card/ui/v2/CardNewBaseUI;", "()V", "TAG", "", "loadCount", "", "mCurrentSortInfo", "mCurrentSortWording", "mEmptyView", "Landroid/view/ViewGroup;", "mFirstLoad", "", "mHasLoadedSuccess", "mHeaderView", "mHistoryEntranceWording", "mHistoryMiniAppInfo", "Lcom/tencent/mm/protocal/protobuf/CardMiniAppInfo;", "mIsAll", "mIsLoading", "mNeedRefreshList", "mOffset", "mPhoneMemberEntranceWording", "mPhoneMemberMenuEntranceWording", "mPhoneMemberMiniAppInfo", "mPreviousSortInfo", "mRefreshLayout", "Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "mReqNum", "mSortInfoList", "Lcom/tencent/mm/protocal/protobuf/CardSortInfoList;", "mSortLayout", "mSortTv", "Landroid/widget/TextView;", "mTopPhoneVipCardLayout", "mTopPhoneVipCardTv", "mViewHeight", "mVipCardList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/card/ui/v3/VipCardListUI$VipCardConvertData;", "Lkotlin/collections/ArrayList;", "mVipCardListAdapter", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "mVipCardListRv", "Lcom/tencent/mm/view/recyclerview/WxRecyclerView;", "doDeleteVipCard", "", "cardId", "doLoadVipCardList", "refresh", "getLayoutId", "getPositionByUserCardId", "gotoCardDetailUI", "initView", "loadSnapshot", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onFinishLocationThings", "ret", "isLocationOk", "onResume", "saveSnapshot", "showSortDialog", "updateIconMenu", "updateTopHeaderLayout", "updateViewByResp", "resp", "Lcom/tencent/mm/protocal/protobuf/GetMemberCardHomePageResponse;", "Companion", "VipCardConvertData", "VipCardConverter", "plugin-card_release"})
public final class VipCardListUI
  extends CardNewBaseUI
{
  public static final VipCardListUI.a okB;
  private int MW;
  private final String TAG;
  private int aOz;
  private boolean kOL;
  private boolean kYe;
  private ViewGroup oiV;
  private TextView ojT;
  private int ojW;
  private RefreshLoadMoreLayout ojk;
  private ViewGroup ojl;
  private boolean ojr;
  private boolean ojs;
  private int ojw;
  private String okA;
  private rm oka;
  private String okb;
  private rv okc;
  private String okd;
  private int oke;
  private int okf;
  private WxRecyclerView okr;
  private ViewGroup oks;
  private ViewGroup okt;
  private TextView oku;
  private WxRecyclerAdapter<b> okv;
  private final ArrayList<b> okw;
  private boolean okx;
  private rm oky;
  private String okz;
  
  static
  {
    AppMethodBeat.i(206418);
    okB = new VipCardListUI.a((byte)0);
    AppMethodBeat.o(206418);
  }
  
  public VipCardListUI()
  {
    AppMethodBeat.i(206417);
    this.TAG = "MicroMsg.VipCardListUI";
    this.okw = new ArrayList();
    this.ojW = 10;
    this.okd = "";
    this.kYe = true;
    AppMethodBeat.o(206417);
  }
  
  private final void a(azw paramazw)
  {
    AppMethodBeat.i(206416);
    this.okc = paramazw.EOa;
    paramazw = paramazw.Ejf.iterator();
    while (paramazw.hasNext())
    {
      ra localra = (ra)paramazw.next();
      b localb = new b();
      k.g(localra, "cardInfo");
      localb.a(localra);
      this.okw.add(localb);
    }
    if (this.okw.isEmpty())
    {
      paramazw = this.oiV;
      if (paramazw == null) {
        k.aVY("mEmptyView");
      }
      paramazw.setVisibility(0);
    }
    for (;;)
    {
      paramazw = this.okv;
      if (paramazw == null) {
        k.aVY("mVipCardListAdapter");
      }
      paramazw.notifyDataSetChanged();
      AppMethodBeat.o(206416);
      return;
      paramazw = this.oiV;
      if (paramazw == null) {
        k.aVY("mEmptyView");
      }
      paramazw.setVisibility(8);
    }
  }
  
  private final void bTH()
  {
    AppMethodBeat.i(206415);
    final v.a locala1 = new v.a();
    locala1.KUL = false;
    final v.a locala2 = new v.a();
    locala2.KUL = false;
    if (this.oky != null)
    {
      CharSequence localCharSequence = (CharSequence)this.okA;
      if ((localCharSequence != null) && (localCharSequence.length() != 0)) {
        break label133;
      }
    }
    label133:
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        locala1.KUL = true;
      }
      if (this.oka != null) {
        locala2.KUL = true;
      }
      if ((locala1.KUL) || (locala2.KUL))
      {
        removeAllOptionMenu();
        addIconOptionMenu(0, 0, 2131690603, (MenuItem.OnMenuItemClickListener)new k(this, locala1, locala2));
      }
      AppMethodBeat.o(206415);
      return;
    }
  }
  
  private final void bTK()
  {
    int k = 1;
    AppMethodBeat.i(206413);
    int i;
    label123:
    int j;
    if (this.oke > 0) {
      if (!((Collection)this.okw).isEmpty())
      {
        i = 1;
        if (i == 0) {
          break label310;
        }
        localObject = this.ojT;
        if (localObject == null) {
          k.aVY("mSortTv");
        }
        ((TextView)localObject).setText((CharSequence)this.okd);
        localObject = this.oks;
        if (localObject == null) {
          k.aVY("mSortLayout");
        }
        ((ViewGroup)localObject).setVisibility(0);
        localObject = this.oks;
        if (localObject == null) {
          k.aVY("mSortLayout");
        }
        ((ViewGroup)localObject).setOnClickListener((View.OnClickListener)new l(this));
        i = 1;
        localObject = (CharSequence)this.okz;
        if ((localObject != null) && (((CharSequence)localObject).length() != 0)) {
          break label339;
        }
        j = 1;
        label149:
        if ((j != 0) || (this.oky == null)) {
          break label344;
        }
        localObject = this.okt;
        if (localObject == null) {
          k.aVY("mTopPhoneVipCardLayout");
        }
        ((ViewGroup)localObject).setVisibility(0);
        localObject = this.oku;
        if (localObject == null) {
          k.aVY("mTopPhoneVipCardTv");
        }
        ((TextView)localObject).setText((CharSequence)this.okz);
        localObject = this.okt;
        if (localObject == null) {
          k.aVY("mTopPhoneVipCardLayout");
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
      localObject = this.okv;
      if (localObject == null) {
        k.aVY("mVipCardListAdapter");
      }
      localViewGroup = this.ojl;
      if (localViewGroup == null) {
        k.aVY("mHeaderView");
      }
      ((WxRecyclerAdapter)localObject).f((View)localViewGroup, 2, false);
      AppMethodBeat.o(206413);
      return;
      i = 0;
      break;
      label310:
      localObject = this.oks;
      if (localObject == null) {
        k.aVY("mSortLayout");
      }
      ((ViewGroup)localObject).setVisibility(8);
      i = 0;
      break label123;
      label339:
      j = 0;
      break label149;
      label344:
      localObject = this.okt;
      if (localObject == null) {
        k.aVY("mTopPhoneVipCardLayout");
      }
      ((ViewGroup)localObject).setVisibility(8);
    }
    label371:
    Object localObject = this.okv;
    if (localObject == null) {
      k.aVY("mVipCardListAdapter");
    }
    ViewGroup localViewGroup = this.ojl;
    if (localViewGroup == null) {
      k.aVY("mHeaderView");
    }
    ((WxRecyclerAdapter)localObject).L(localViewGroup.hashCode(), false);
    AppMethodBeat.o(206413);
  }
  
  private final void jo(final boolean paramBoolean)
  {
    int i = 0;
    AppMethodBeat.i(206414);
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
      AppMethodBeat.o(206414);
      return;
    }
    if (this.kOL)
    {
      ac.w(this.TAG, "is loading");
      AppMethodBeat.o(206414);
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
      localObject = new com.tencent.mm.plugin.card.model.b.b(i, this.ojW, this.dmL, this.doB, this.oke).aBB();
      k.g(localObject, "CgiGetMemberCardHomePage…, mCurrentSortInfo).run()");
      com.tencent.mm.ac.c.b((com.tencent.mm.vending.g.c)localObject, (d.g.a.b)new e(this, paramBoolean)).b((com.tencent.mm.vending.e.b)this);
      AppMethodBeat.o(206414);
      return;
      i = j;
    }
  }
  
  public final void V(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(206412);
    if ((this.kYe) && (this.oke == 1))
    {
      jo(true);
      AppMethodBeat.o(206412);
      return;
    }
    if (!paramBoolean) {
      bTy();
    }
    AppMethodBeat.o(206412);
  }
  
  public final int getLayoutId()
  {
    return 2131493307;
  }
  
  public final void initView()
  {
    AppMethodBeat.i(206409);
    Object localObject1 = findViewById(2131298323);
    k.g(localObject1, "findViewById(R.id.chpvv3_rv)");
    this.okr = ((WxRecyclerView)localObject1);
    localObject1 = findViewById(2131298321);
    k.g(localObject1, "findViewById(R.id.chpvv3_refresh_layout)");
    this.ojk = ((RefreshLoadMoreLayout)localObject1);
    localObject1 = findViewById(2131298319);
    k.g(localObject1, "findViewById(R.id.chpvv3_empty_layout)");
    this.oiV = ((ViewGroup)localObject1);
    localObject1 = this.okr;
    if (localObject1 == null) {
      k.aVY("mVipCardListRv");
    }
    getContext();
    ((WxRecyclerView)localObject1).setLayoutManager((RecyclerView.i)new LinearLayoutManager(1));
    this.okv = new WxRecyclerAdapter((com.tencent.mm.view.recyclerview.c)new f(this), this.okw);
    localObject1 = this.okr;
    if (localObject1 == null) {
      k.aVY("mVipCardListRv");
    }
    Object localObject2 = this.okv;
    if (localObject2 == null) {
      k.aVY("mVipCardListAdapter");
    }
    ((WxRecyclerView)localObject1).setAdapter((RecyclerView.a)localObject2);
    localObject1 = new w((Context)getContext());
    ((w)localObject1).setDrawable(getResources().getDrawable(2131231470));
    localObject2 = this.okr;
    if (localObject2 == null) {
      k.aVY("mVipCardListRv");
    }
    ((WxRecyclerView)localObject2).b((RecyclerView.h)localObject1);
    localObject1 = getLayoutInflater();
    localObject2 = this.okr;
    if (localObject2 == null) {
      k.aVY("mVipCardListRv");
    }
    localObject1 = ((LayoutInflater)localObject1).inflate(2131493305, (ViewGroup)localObject2, false);
    if (localObject1 == null)
    {
      localObject1 = new v("null cannot be cast to non-null type android.view.ViewGroup");
      AppMethodBeat.o(206409);
      throw ((Throwable)localObject1);
    }
    this.ojl = ((ViewGroup)localObject1);
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
    localObject1 = ((ViewGroup)localObject1).findViewById(2131298324);
    k.g(localObject1, "mHeaderView.findViewById(R.id.chpvv3_sort_layout)");
    this.oks = ((ViewGroup)localObject1);
    localObject1 = this.ojl;
    if (localObject1 == null) {
      k.aVY("mHeaderView");
    }
    localObject1 = ((ViewGroup)localObject1).findViewById(2131298327);
    k.g(localObject1, "mHeaderView.findViewById…top_phone_vipcard_layout)");
    this.okt = ((ViewGroup)localObject1);
    localObject1 = this.ojl;
    if (localObject1 == null) {
      k.aVY("mHeaderView");
    }
    localObject1 = ((ViewGroup)localObject1).findViewById(2131298328);
    k.g(localObject1, "mHeaderView.findViewById…vv3_top_phone_vipcard_tv)");
    this.oku = ((TextView)localObject1);
    localObject1 = this.okv;
    if (localObject1 == null) {
      k.aVY("mVipCardListAdapter");
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
    ((RefreshLoadMoreLayout)localObject1).setActionCallback((RefreshLoadMoreLayout.a)new g(this));
    AppMethodBeat.o(206409);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(206408);
    super.onCreate(paramBundle);
    initView();
    setMMTitle(2131756930);
    setActionbarColor(getResources().getColor(2131099648));
    hideActionbarLine();
    setBackBtn((MenuItem.OnMenuItemClickListener)new h(this));
    paramBundle = com.tencent.mm.plugin.card.model.a.a.nXE;
    paramBundle = a.a.bQA();
    if (paramBundle != null)
    {
      this.MW = paramBundle.oGs;
      this.okc = paramBundle.EOa;
      this.oka = paramBundle.ENW;
      this.okb = paramBundle.ENX;
      this.oky = paramBundle.EQU;
      this.okz = paramBundle.EQW;
      this.okA = paramBundle.EQV;
      bTH();
      a(paramBundle);
    }
    paramBundle = com.tencent.mm.plugin.card.model.a.a.nXE;
    paramBundle = a.a.bQB();
    if (paramBundle != null)
    {
      this.oke = paramBundle.Ekd;
      String str = paramBundle.Ekf;
      k.g(str, "cardSortInfo.sort_wording");
      this.okd = str;
      this.ojW = paramBundle.Eke;
      this.okf = this.oke;
    }
    bTK();
    if (this.oke != 1) {
      jo(true);
    }
    AppMethodBeat.o(206408);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(206411);
    super.onDestroy();
    if (!this.ojs)
    {
      ac.i(this.TAG, "no data to save snapshot");
      AppMethodBeat.o(206411);
      return;
    }
    Object localObject1 = new azw();
    ((azw)localObject1).BaseResponse = new BaseResponse();
    ((azw)localObject1).BaseResponse.ErrMsg = new crm();
    Object localObject2 = this.okw.iterator();
    while (((Iterator)localObject2).hasNext())
    {
      b localb = (b)((Iterator)localObject2).next();
      if (localb.bTL() != null) {
        ((azw)localObject1).Ejf.add(localb.bTL());
      }
    }
    ((azw)localObject1).EOa = this.okc;
    ((azw)localObject1).oGs = this.MW;
    ((azw)localObject1).ENX = this.okb;
    ((azw)localObject1).ENW = this.oka;
    ((azw)localObject1).EQU = this.oky;
    ((azw)localObject1).EQV = this.okA;
    ((azw)localObject1).EQW = this.okz;
    localObject2 = com.tencent.mm.plugin.card.model.a.a.nXE;
    k.h(localObject1, "response");
    ac.d(com.tencent.mm.plugin.card.model.a.a.access$getTAG$cp(), "save vip card list snapshot");
    com.tencent.mm.ac.c.b(null, (d.g.a.a)new a.a.d((azw)localObject1));
    localObject1 = new ru();
    ((ru)localObject1).Ekd = this.oke;
    ((ru)localObject1).Ekf = this.okd;
    ((ru)localObject1).Eke = this.ojW;
    localObject2 = com.tencent.mm.plugin.card.model.a.a.nXE;
    k.h(localObject1, "sortInfo");
    ac.d(com.tencent.mm.plugin.card.model.a.a.access$getTAG$cp(), "save vip card list snapshot");
    com.tencent.mm.ac.c.b(null, (d.g.a.a)new a.a.e((ru)localObject1));
    AppMethodBeat.o(206411);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(206410);
    if (this.okx)
    {
      jo(true);
      this.okx = false;
    }
    super.onResume();
    AppMethodBeat.o(206410);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/card/ui/v3/VipCardListUI$VipCardConvertData;", "Lcom/tencent/mm/view/recyclerview/ConvertData;", "()V", "vipCardInfo", "Lcom/tencent/mm/protocal/protobuf/CardElementCouponList;", "getVipCardInfo", "()Lcom/tencent/mm/protocal/protobuf/CardElementCouponList;", "setVipCardInfo", "(Lcom/tencent/mm/protocal/protobuf/CardElementCouponList;)V", "getItemId", "", "getItemType", "", "plugin-card_release"})
  public static final class b
    implements com.tencent.mm.view.recyclerview.a
  {
    public ra okC;
    
    public final void a(ra paramra)
    {
      AppMethodBeat.i(206379);
      k.h(paramra, "<set-?>");
      this.okC = paramra;
      AppMethodBeat.o(206379);
    }
    
    public final int bTF()
    {
      return 1;
    }
    
    public final ra bTL()
    {
      AppMethodBeat.i(206378);
      ra localra = this.okC;
      if (localra == null) {
        k.aVY("vipCardInfo");
      }
      AppMethodBeat.o(206378);
      return localra;
    }
    
    public final long lx()
    {
      AppMethodBeat.i(206380);
      ra localra = this.okC;
      if (localra == null) {
        k.aVY("vipCardInfo");
      }
      long l = localra.DMR.hashCode();
      AppMethodBeat.o(206380);
      return l;
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/card/ui/v3/VipCardListUI$VipCardConverter;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "Lcom/tencent/mm/plugin/card/ui/v3/VipCardListUI$VipCardConvertData;", "(Lcom/tencent/mm/plugin/card/ui/v3/VipCardListUI;)V", "getLayoutId", "", "onBindViewHolder", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "position", "type", "isHotPatch", "", "payloads", "", "", "onCreateViewHolder", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "showDeleteConfirmDialog", "cardId", "", "updateCardLabelLayout", "couponLabelList", "", "Lcom/tencent/mm/protocal/protobuf/CardElementCouponLabel;", "labelLayout", "Landroid/widget/LinearLayout;", "plugin-card_release"})
  public final class c
    extends com.tencent.mm.view.recyclerview.b<VipCardListUI.b>
  {
    public final void a(RecyclerView paramRecyclerView, final com.tencent.mm.view.recyclerview.e parame, int paramInt)
    {
      AppMethodBeat.i(206389);
      k.h(paramRecyclerView, "recyclerView");
      k.h(parame, "holder");
      ((RoundCornerImageView)parame.adJ(2131298320)).jS(com.tencent.mm.cc.a.fromDPToPix((Context)this.okD.getContext(), 1), this.okD.getResources().getColor(2131099828));
      parame.asD.setOnClickListener((View.OnClickListener)new c(this, parame));
      parame.asD.setOnLongClickListener((View.OnLongClickListener)new d(this, parame));
      AppMethodBeat.o(206389);
    }
    
    public final int getLayoutId()
    {
      return 2131493306;
    }
    
    @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run"})
    static final class a
      implements Runnable
    {
      a(VipCardListUI.c paramc, com.tencent.mm.view.recyclerview.e parame, d.g.a.a parama) {}
      
      public final void run()
      {
        AppMethodBeat.i(206381);
        VipCardListUI localVipCardListUI = this.okE.okD;
        View localView = this.ojH.asD;
        k.g(localView, "holder.itemView");
        VipCardListUI.a(localVipCardListUI, localView.getHeight());
        this.ojI.invoke();
        AppMethodBeat.o(206381);
      }
    }
    
    @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
    static final class b
      extends d.g.b.l
      implements d.g.a.a<y>
    {
      b(VipCardListUI.c paramc, MemberCardTopCropImageView paramMemberCardTopCropImageView, VipCardListUI.b paramb, com.tencent.mm.view.recyclerview.e parame)
      {
        super();
      }
    }
    
    @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class c
      implements View.OnClickListener
    {
      c(VipCardListUI.c paramc, com.tencent.mm.view.recyclerview.e parame) {}
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(206383);
        paramView = (VipCardListUI.b)parame.fzs();
        Object localObject = paramView.bTL();
        if (((ra)localObject).EiQ == 1) {
          com.tencent.mm.plugin.card.d.b.a((MMActivity)this.okE.okD.getContext(), ((ra)localObject).EiR);
        }
        for (;;)
        {
          localObject = com.tencent.mm.plugin.report.service.h.wUl;
          long l = System.currentTimeMillis() / 1000L;
          String str = paramView.bTL().DMR;
          VipCardListUI localVipCardListUI = this.okE.okD;
          paramView = paramView.bTL().DMR;
          k.g(paramView, "vipCardConvertData.vipCardInfo.user_card_id");
          ((com.tencent.mm.plugin.report.service.h)localObject).f(19748, new Object[] { Integer.valueOf(1), Long.valueOf(l), str, Integer.valueOf(VipCardListUI.b(localVipCardListUI, paramView)), Integer.valueOf(0) });
          AppMethodBeat.o(206383);
          return;
          if (((ra)localObject).EiQ == 2)
          {
            com.tencent.mm.plugin.card.d.b.H(((ra)localObject).EiS.AZE, ((ra)localObject).EiS.AZF, ((ra)localObject).EiS.BGS);
          }
          else
          {
            localObject = this.okE.okD;
            str = paramView.bTL().DMR;
            k.g(str, "vipCardConvertData.vipCardInfo.user_card_id");
            VipCardListUI.a((VipCardListUI)localObject, str);
          }
        }
      }
    }
    
    @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onLongClick"})
    static final class d
      implements View.OnLongClickListener
    {
      d(VipCardListUI.c paramc, com.tencent.mm.view.recyclerview.e parame) {}
      
      public final boolean onLongClick(View paramView)
      {
        AppMethodBeat.i(206386);
        final VipCardListUI.b localb = (VipCardListUI.b)parame.fzs();
        com.tencent.mm.ui.widget.b.a locala = new com.tencent.mm.ui.widget.b.a((Context)this.okE.okD.getContext(), paramView);
        locala.a((View.OnCreateContextMenuListener)new View.OnCreateContextMenuListener()
        {
          public final void onCreateContextMenu(ContextMenu paramAnonymousContextMenu, View paramAnonymousView, ContextMenu.ContextMenuInfo paramAnonymousContextMenuInfo)
          {
            AppMethodBeat.i(206384);
            paramAnonymousContextMenu.add(0, 1, 0, (CharSequence)this.okG.okE.okD.getString(2131755707));
            AppMethodBeat.o(206384);
          }
        });
        locala.a((n.d)new n.d()
        {
          public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
          {
            AppMethodBeat.i(206385);
            paramAnonymousMenuItem = this.okG.okE;
            String str = localb.bTL().DMR;
            k.g(str, "vipCardConvertData.vipCardInfo.user_card_id");
            com.tencent.mm.ui.widget.a.e locale = new com.tencent.mm.ui.widget.a.e((Context)paramAnonymousMenuItem.okD.getContext(), 1, true);
            TextView localTextView = new TextView((Context)paramAnonymousMenuItem.okD.getContext());
            localTextView.setText((CharSequence)paramAnonymousMenuItem.okD.getString(2131756885));
            localTextView.setTextSize(1, 14.0F);
            localTextView.setTextColor(paramAnonymousMenuItem.okD.getResources().getColor(2131100482));
            localTextView.setGravity(17);
            paramAnonymousInt = paramAnonymousMenuItem.okD.getResources().getDimensionPixelSize(2131165303);
            int i = paramAnonymousMenuItem.okD.getResources().getDimensionPixelSize(2131165289);
            localTextView.setPadding(paramAnonymousInt, i, paramAnonymousInt, i);
            locale.J((View)localTextView, false);
            locale.a((n.c)new VipCardListUI.c.e(paramAnonymousMenuItem));
            locale.a((n.d)new VipCardListUI.c.f(paramAnonymousMenuItem, str));
            locale.cED();
            AppMethodBeat.o(206385);
          }
        });
        k.g(paramView, "it");
        paramView = m.dG(paramView);
        locala.ej(paramView.x, paramView.y);
        com.tencent.mm.plugin.report.service.h.wUl.f(19747, new Object[] { Integer.valueOf(1), Integer.valueOf(3) });
        AppMethodBeat.o(206386);
        return false;
      }
    }
    
    @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Lcom/tencent/mm/ui/base/MMMenu;", "kotlin.jvm.PlatformType", "onCreateMMMenu"})
    static final class e
      implements n.c
    {
      e(VipCardListUI.c paramc) {}
      
      public final void onCreateMMMenu(com.tencent.mm.ui.base.l paraml)
      {
        AppMethodBeat.i(206387);
        paraml.a(1, this.okE.okD.getResources().getColor(2131100800), (CharSequence)this.okE.okD.getString(2131755707));
        AppMethodBeat.o(206387);
      }
    }
    
    @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "menuItem", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "", "onMMMenuItemSelected"})
    static final class f
      implements n.d
    {
      f(VipCardListUI.c paramc, String paramString) {}
      
      public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
      {
        AppMethodBeat.i(206388);
        k.g(paramMenuItem, "menuItem");
        switch (paramMenuItem.getItemId())
        {
        }
        for (;;)
        {
          AppMethodBeat.o(206388);
          return;
          VipCardListUI.c(this.okE.okD, this.oiB);
          com.tencent.mm.plugin.report.service.h.wUl.f(19747, new Object[] { Integer.valueOf(1), Integer.valueOf(4) });
        }
      }
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "kotlin.jvm.PlatformType", "it", "Lcom/tencent/mm/modelbase/DeprecatedCgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/DeleteCardInTicketListResponse;", "call"})
  static final class d<_Ret, _Var>
    implements com.tencent.mm.vending.c.a<_Ret, _Var>
  {
    d(VipCardListUI paramVipCardListUI, String paramString) {}
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Lcom/tencent/mm/modelbase/DeprecatedCgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/GetMemberCardHomePageResponse;", "kotlin.jvm.PlatformType", "invoke"})
  static final class e
    extends d.g.b.l
    implements d.g.a.b<c.a<azw>, y>
  {
    e(VipCardListUI paramVipCardListUI, boolean paramBoolean)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/card/ui/v3/VipCardListUI$initView$1", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "getItemConvert", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "type", "", "plugin-card_release"})
  public static final class f
    implements com.tencent.mm.view.recyclerview.c
  {
    public final com.tencent.mm.view.recyclerview.b<?> Ac(int paramInt)
    {
      AppMethodBeat.i(206393);
      com.tencent.mm.view.recyclerview.b localb = (com.tencent.mm.view.recyclerview.b)new VipCardListUI.c(this.okD);
      AppMethodBeat.o(206393);
      return localb;
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/card/ui/v3/VipCardListUI$initView$2", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback;", "onLoadMoreBegin", "", "onLoadMoreEnd", "reason", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;", "", "plugin-card_release"})
  public static final class g
    extends RefreshLoadMoreLayout.a
  {
    public final void Ad(int paramInt)
    {
      AppMethodBeat.i(206397);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.lS(paramInt);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/card/ui/v3/VipCardListUI$initView$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshBegin", "(I)V", this, localb.aeE());
      super.Ad(paramInt);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/card/ui/v3/VipCardListUI$initView$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshBegin", "(I)V");
      AppMethodBeat.o(206397);
    }
    
    public final void a(RefreshLoadMoreLayout.c<Object> paramc)
    {
      AppMethodBeat.i(206396);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bb(paramc);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/card/ui/v3/VipCardListUI$initView$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V", this, localb.aeE());
      k.h(paramc, "reason");
      ac.d(VipCardListUI.a(this.okD), "on load more end: " + VipCardListUI.c(this.okD));
      if (VipCardListUI.d(this.okD)) {
        VipCardListUI.e(this.okD).i(null);
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/card/ui/v3/VipCardListUI$initView$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V");
      AppMethodBeat.o(206396);
    }
    
    public final void b(RefreshLoadMoreLayout.c paramc)
    {
      AppMethodBeat.i(206398);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bb(paramc);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/card/ui/v3/VipCardListUI$initView$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V", this, localb.aeE());
      super.b(paramc);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/card/ui/v3/VipCardListUI$initView$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V");
      AppMethodBeat.o(206398);
    }
    
    public final void bTG()
    {
      AppMethodBeat.i(206395);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/card/ui/v3/VipCardListUI$initView$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreBegin", "()V", this);
      ac.d(VipCardListUI.a(this.okD), "on load more");
      com.tencent.mm.ac.c.g((d.g.a.a)new a(this));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/card/ui/v3/VipCardListUI$initView$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreBegin", "()V");
      AppMethodBeat.o(206395);
    }
    
    @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
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
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class h
    implements MenuItem.OnMenuItemClickListener
  {
    h(VipCardListUI paramVipCardListUI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(206399);
      this.okD.finish();
      AppMethodBeat.o(206399);
      return false;
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Lcom/tencent/mm/ui/base/MMMenu;", "kotlin.jvm.PlatformType", "onCreateMMMenu"})
  static final class i
    implements n.c
  {
    i(VipCardListUI paramVipCardListUI) {}
    
    public final void onCreateMMMenu(com.tencent.mm.ui.base.l paraml)
    {
      AppMethodBeat.i(206400);
      Object localObject = VipCardListUI.f(this.okD);
      if (localObject == null) {
        k.fOy();
      }
      localObject = ((rv)localObject).Ekg.iterator();
      while (((Iterator)localObject).hasNext())
      {
        ru localru = (ru)((Iterator)localObject).next();
        paraml.add(0, localru.Ekd, 1, (CharSequence)localru.Ekf);
      }
      AppMethodBeat.o(206400);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "menuItem", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "index", "", "onMMMenuItemSelected"})
  static final class j
    implements n.d
  {
    j(VipCardListUI paramVipCardListUI) {}
    
    public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
    {
      AppMethodBeat.i(206402);
      k.g(paramMenuItem, "menuItem");
      paramInt = paramMenuItem.getItemId();
      ac.i(VipCardListUI.a(this.okD), "click item: %s", new Object[] { Integer.valueOf(paramInt) });
      if (paramInt == 1)
      {
        if (!VipCardListUI.g(this.okD))
        {
          com.tencent.mm.ui.base.h.a((Context)this.okD.getContext(), this.okD.getString(2131756893), this.okD.getString(2131761885), this.okD.getString(2131760598), this.okD.getString(2131757558), false, (DialogInterface.OnClickListener)new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(206401);
              this.okJ.okD.startActivityForResult(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"), 564);
              AppMethodBeat.o(206401);
            }
          }, null);
          AppMethodBeat.o(206402);
          return;
        }
        VipCardListUI.b(this.okD, VipCardListUI.i(this.okD));
        VipCardListUI.c(this.okD, 1);
        VipCardListUI.d(this.okD, paramMenuItem.getTitle().toString());
        VipCardListUI.j(this.okD);
        VipCardListUI.a(this.okD, true);
        com.tencent.mm.plugin.report.service.h.wUl.f(19747, new Object[] { Integer.valueOf(1), Integer.valueOf(5) });
        AppMethodBeat.o(206402);
        return;
      }
      VipCardListUI.b(this.okD, VipCardListUI.i(this.okD));
      VipCardListUI.c(this.okD, paramInt);
      VipCardListUI.d(this.okD, paramMenuItem.getTitle().toString());
      VipCardListUI.j(this.okD);
      VipCardListUI.a(this.okD, true);
      com.tencent.mm.plugin.report.service.h.wUl.f(19747, new Object[] { Integer.valueOf(1), Integer.valueOf(6) });
      AppMethodBeat.o(206402);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class k
    implements MenuItem.OnMenuItemClickListener
  {
    k(VipCardListUI paramVipCardListUI, v.a parama1, v.a parama2) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(206405);
      paramMenuItem = new com.tencent.mm.ui.widget.a.e((Context)this.okD.getContext(), 1, false);
      paramMenuItem.a((n.c)new n.c()
      {
        public final void onCreateMMMenu(com.tencent.mm.ui.base.l paramAnonymousl)
        {
          AppMethodBeat.i(206403);
          if (this.okM.okK.KUL) {
            paramAnonymousl.add(0, 1, 0, (CharSequence)VipCardListUI.q(this.okM.okD));
          }
          if (this.okM.okL.KUL) {
            paramAnonymousl.add(0, 2, 1, (CharSequence)VipCardListUI.p(this.okM.okD));
          }
          AppMethodBeat.o(206403);
        }
      });
      paramMenuItem.a((n.d)new n.d()
      {
        public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
        {
          AppMethodBeat.i(206404);
          k.g(paramAnonymousMenuItem, "menuItem");
          Object localObject;
          rm localrm;
          if (paramAnonymousMenuItem.getItemId() == 1)
          {
            VipCardListUI.l(this.okM.okD);
            paramAnonymousMenuItem = VipCardListUI.m(this.okM.okD);
            if (paramAnonymousMenuItem == null) {
              k.fOy();
            }
            paramAnonymousMenuItem = paramAnonymousMenuItem.AZE;
            localObject = VipCardListUI.m(this.okM.okD);
            if (localObject == null) {
              k.fOy();
            }
            localObject = ((rm)localObject).AZF;
            localrm = VipCardListUI.m(this.okM.okD);
            if (localrm == null) {
              k.fOy();
            }
            com.tencent.mm.plugin.card.d.b.H(paramAnonymousMenuItem, (String)localObject, localrm.BGS);
            com.tencent.mm.plugin.report.service.h.wUl.f(19747, new Object[] { Integer.valueOf(1), Integer.valueOf(7) });
            AppMethodBeat.o(206404);
            return;
          }
          if (paramAnonymousMenuItem.getItemId() == 2)
          {
            paramAnonymousMenuItem = VipCardListUI.o(this.okM.okD);
            if (paramAnonymousMenuItem == null) {
              k.fOy();
            }
            paramAnonymousMenuItem = paramAnonymousMenuItem.AZE;
            localObject = VipCardListUI.o(this.okM.okD);
            if (localObject == null) {
              k.fOy();
            }
            localObject = ((rm)localObject).AZF;
            localrm = VipCardListUI.o(this.okM.okD);
            if (localrm == null) {
              k.fOy();
            }
            com.tencent.mm.plugin.card.d.b.H(paramAnonymousMenuItem, (String)localObject, localrm.BGS);
            com.tencent.mm.plugin.report.service.h.wUl.f(19747, new Object[] { Integer.valueOf(1), Integer.valueOf(2) });
          }
          AppMethodBeat.o(206404);
        }
      });
      paramMenuItem.cED();
      com.tencent.mm.plugin.report.service.h.wUl.f(19747, new Object[] { Integer.valueOf(1), Integer.valueOf(1) });
      AppMethodBeat.o(206405);
      return false;
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class l
    implements View.OnClickListener
  {
    l(VipCardListUI paramVipCardListUI) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(206406);
      ac.d(VipCardListUI.a(this.okD), "click header view");
      VipCardListUI.k(this.okD);
      AppMethodBeat.o(206406);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class m
    implements View.OnClickListener
  {
    m(VipCardListUI paramVipCardListUI) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(206407);
      VipCardListUI.l(this.okD);
      paramView = VipCardListUI.m(this.okD);
      if (paramView == null) {
        k.fOy();
      }
      paramView = paramView.AZE;
      Object localObject = VipCardListUI.m(this.okD);
      if (localObject == null) {
        k.fOy();
      }
      localObject = ((rm)localObject).AZF;
      rm localrm = VipCardListUI.m(this.okD);
      if (localrm == null) {
        k.fOy();
      }
      com.tencent.mm.plugin.card.d.b.H(paramView, (String)localObject, localrm.BGS);
      com.tencent.mm.plugin.report.service.h.wUl.f(19747, new Object[] { Integer.valueOf(1), Integer.valueOf(8) });
      AppMethodBeat.o(206407);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.v3.VipCardListUI
 * JD-Core Version:    0.7.0.1
 */