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
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.h;
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
import com.tencent.mm.ac.d;
import com.tencent.mm.ak.c.a;
import com.tencent.mm.plugin.card.model.a.a.a;
import com.tencent.mm.plugin.card.model.a.a.a.g;
import com.tencent.mm.plugin.card.model.a.a.a.h;
import com.tencent.mm.plugin.card.ui.v2.CardNewBaseUI;
import com.tencent.mm.plugin.card.widget.MemberCardTopCropImageView;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.bqk;
import com.tencent.mm.protocal.protobuf.dqi;
import com.tencent.mm.protocal.protobuf.ua;
import com.tencent.mm.protocal.protobuf.ue;
import com.tencent.mm.protocal.protobuf.un;
import com.tencent.mm.protocal.protobuf.uv;
import com.tencent.mm.protocal.protobuf.uw;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.o.f;
import com.tencent.mm.ui.base.o.g;
import com.tencent.mm.ui.widget.RoundCornerImageView;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.RefreshLoadMoreLayout.a;
import com.tencent.mm.view.RefreshLoadMoreLayout.c;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.mm.view.recyclerview.WxRecyclerView;
import com.tencent.mm.view.recyclerview.f;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.g.b.z.a;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/card/ui/v3/VipCardListUI;", "Lcom/tencent/mm/plugin/card/ui/v2/CardNewBaseUI;", "()V", "TAG", "", "loadCount", "", "mCurrentSortInfo", "mCurrentSortWording", "mEmptyView", "Landroid/view/ViewGroup;", "mFirstLoad", "", "mHasLoadedSuccess", "mHeaderView", "mHistoryEntranceWording", "mHistoryMiniAppInfo", "Lcom/tencent/mm/protocal/protobuf/CardMiniAppInfo;", "mIconMoreList", "", "Lcom/tencent/mm/protocal/protobuf/CardHomePageFAQItem;", "mIsAll", "mIsLoading", "mNeedRefreshList", "mOffset", "mPhoneMemberEntranceWording", "mPhoneMemberMenuEntranceWording", "mPhoneMemberMiniAppInfo", "mPreviousSortInfo", "mProgressDialog", "Lcom/tencent/mm/ui/base/MMProgressDialog;", "mRefreshLayout", "Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "mReqNum", "mSortInfoList", "Lcom/tencent/mm/protocal/protobuf/CardSortInfoList;", "mSortLayout", "mSortTv", "Landroid/widget/TextView;", "mTopPhoneVipCardLayout", "mTopPhoneVipCardTv", "mViewHeight", "mViewWidth", "mVipCardList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/card/ui/v3/VipCardListUI$VipCardConvertData;", "Lkotlin/collections/ArrayList;", "mVipCardListAdapter", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "mVipCardListRv", "Lcom/tencent/mm/view/recyclerview/WxRecyclerView;", "doDeleteVipCard", "", "cardId", "doLoadVipCardList", "refresh", "getLayoutId", "getPositionByUserCardId", "gotoCardDetailUI", "gotoVipHistoryCardListUI", "title", "initView", "loadSnapshot", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onFinishLocationThings", "ret", "isLocationOk", "onResume", "performMenuItemClicked", "item", "saveSnapshot", "showProgressDialog", "isShow", "(Ljava/lang/Boolean;)V", "showSortDialog", "updateIconMenu", "updateIconMenuByV4Protocol", "iconMenuData", "updateTopHeaderLayout", "updateViewByResp", "resp", "Lcom/tencent/mm/protocal/protobuf/GetMemberCardHomePageResponse;", "Companion", "VipCardConvertData", "VipCardConverter", "plugin-card_release"})
public final class VipCardListUI
  extends CardNewBaseUI
{
  public static final VipCardListUI.a qih;
  private final String TAG;
  private int aYN;
  private int aYO;
  private int fs;
  private com.tencent.mm.ui.base.q gxX;
  private boolean mGR;
  private boolean mwr;
  private ViewGroup qgI;
  private RefreshLoadMoreLayout qgY;
  private ViewGroup qgZ;
  private int qhC;
  private un qhG;
  private String qhH;
  private uw qhI;
  private String qhJ;
  private int qhK;
  private int qhL;
  private WxRecyclerView qhW;
  private ViewGroup qhX;
  private ViewGroup qhY;
  private TextView qhZ;
  private boolean qhf;
  private boolean qhg;
  private int qhk;
  private TextView qhz;
  private WxRecyclerAdapter<b> qia;
  private final ArrayList<b> qib;
  private boolean qic;
  private un qid;
  private String qie;
  private String qif;
  private List<? extends ue> qig;
  
  static
  {
    AppMethodBeat.i(201589);
    qih = new VipCardListUI.a((byte)0);
    AppMethodBeat.o(201589);
  }
  
  public VipCardListUI()
  {
    AppMethodBeat.i(201588);
    this.TAG = "MicroMsg.VipCardListUI";
    this.qib = new ArrayList();
    this.qhC = 10;
    this.qhJ = "";
    this.mGR = true;
    AppMethodBeat.o(201588);
  }
  
  private final void a(bqk parambqk)
  {
    AppMethodBeat.i(201586);
    this.qhI = parambqk.LUU;
    parambqk = parambqk.Lds.iterator();
    while (parambqk.hasNext())
    {
      ua localua = (ua)parambqk.next();
      b localb = new b();
      p.g(localua, "cardInfo");
      localb.a(localua);
      this.qib.add(localb);
    }
    if (this.qib.isEmpty())
    {
      parambqk = this.qgI;
      if (parambqk == null) {
        p.btv("mEmptyView");
      }
      parambqk.setVisibility(0);
    }
    for (;;)
    {
      parambqk = this.qia;
      if (parambqk == null) {
        p.btv("mVipCardListAdapter");
      }
      parambqk.notifyDataSetChanged();
      AppMethodBeat.o(201586);
      return;
      parambqk = this.qgI;
      if (parambqk == null) {
        p.btv("mEmptyView");
      }
      parambqk.setVisibility(8);
    }
  }
  
  private final void cW(final List<? extends ue> paramList)
  {
    AppMethodBeat.i(201585);
    if (paramList != null)
    {
      removeAllOptionMenu();
      addIconOptionMenu(0, 0, 2131690843, (MenuItem.OnMenuItemClickListener)new l(paramList, this, paramList));
      AppMethodBeat.o(201585);
      return;
    }
    AppMethodBeat.o(201585);
  }
  
  private final void cxp()
  {
    AppMethodBeat.i(201584);
    Object localObject = (Collection)this.qig;
    if ((localObject == null) || (((Collection)localObject).isEmpty())) {}
    for (int i = 1; i == 0; i = 0)
    {
      cW(this.qig);
      AppMethodBeat.o(201584);
      return;
    }
    localObject = new z.a();
    ((z.a)localObject).SYB = false;
    final z.a locala = new z.a();
    locala.SYB = false;
    if (this.qid != null)
    {
      CharSequence localCharSequence = (CharSequence)this.qif;
      if ((localCharSequence != null) && (localCharSequence.length() != 0)) {
        break label180;
      }
    }
    label180:
    for (i = 1;; i = 0)
    {
      if (i == 0) {
        ((z.a)localObject).SYB = true;
      }
      if (this.qhG != null) {
        locala.SYB = true;
      }
      if ((((z.a)localObject).SYB) || (locala.SYB))
      {
        removeAllOptionMenu();
        addIconOptionMenu(0, 0, 2131690843, (MenuItem.OnMenuItemClickListener)new k(this, (z.a)localObject, locala));
      }
      AppMethodBeat.o(201584);
      return;
    }
  }
  
  private final void cxs()
  {
    int k = 1;
    AppMethodBeat.i(201582);
    int i;
    label130:
    int j;
    if (this.qhK > 0) {
      if (!((Collection)this.qib).isEmpty())
      {
        i = 1;
        if ((i == 0) || (this.qhI == null)) {
          break label317;
        }
        localObject = this.qhz;
        if (localObject == null) {
          p.btv("mSortTv");
        }
        ((TextView)localObject).setText((CharSequence)this.qhJ);
        localObject = this.qhX;
        if (localObject == null) {
          p.btv("mSortLayout");
        }
        ((ViewGroup)localObject).setVisibility(0);
        localObject = this.qhX;
        if (localObject == null) {
          p.btv("mSortLayout");
        }
        ((ViewGroup)localObject).setOnClickListener((View.OnClickListener)new m(this));
        i = 1;
        localObject = (CharSequence)this.qie;
        if ((localObject != null) && (((CharSequence)localObject).length() != 0)) {
          break label346;
        }
        j = 1;
        label156:
        if ((j != 0) || (this.qid == null)) {
          break label351;
        }
        localObject = this.qhY;
        if (localObject == null) {
          p.btv("mTopPhoneVipCardLayout");
        }
        ((ViewGroup)localObject).setVisibility(0);
        localObject = this.qhZ;
        if (localObject == null) {
          p.btv("mTopPhoneVipCardTv");
        }
        ((TextView)localObject).setText((CharSequence)this.qie);
        localObject = this.qhY;
        if (localObject == null) {
          p.btv("mTopPhoneVipCardLayout");
        }
        ((ViewGroup)localObject).setOnClickListener((View.OnClickListener)new n(this));
        i = k;
      }
    }
    for (;;)
    {
      if (i == 0) {
        break label378;
      }
      localObject = this.qia;
      if (localObject == null) {
        p.btv("mVipCardListAdapter");
      }
      localViewGroup = this.qgZ;
      if (localViewGroup == null) {
        p.btv("mHeaderView");
      }
      ((WxRecyclerAdapter)localObject).f((View)localViewGroup, 2, false);
      AppMethodBeat.o(201582);
      return;
      i = 0;
      break;
      label317:
      localObject = this.qhX;
      if (localObject == null) {
        p.btv("mSortLayout");
      }
      ((ViewGroup)localObject).setVisibility(8);
      i = 0;
      break label130;
      label346:
      j = 0;
      break label156;
      label351:
      localObject = this.qhY;
      if (localObject == null) {
        p.btv("mTopPhoneVipCardLayout");
      }
      ((ViewGroup)localObject).setVisibility(8);
    }
    label378:
    Object localObject = this.qia;
    if (localObject == null) {
      p.btv("mVipCardListAdapter");
    }
    ViewGroup localViewGroup = this.qgZ;
    if (localViewGroup == null) {
      p.btv("mHeaderView");
    }
    ((WxRecyclerAdapter)localObject).T(localViewGroup.hashCode(), false);
    AppMethodBeat.o(201582);
  }
  
  private final void j(Boolean paramBoolean)
  {
    AppMethodBeat.i(201587);
    if (paramBoolean == null)
    {
      AppMethodBeat.o(201587);
      return;
    }
    if (paramBoolean.booleanValue()) {}
    for (paramBoolean = com.tencent.mm.ui.base.q.a((Context)getContext(), (CharSequence)getString(2131756029), true, 3, null);; paramBoolean = null)
    {
      this.gxX = paramBoolean;
      AppMethodBeat.o(201587);
      return;
      paramBoolean = this.gxX;
      if (paramBoolean != null) {
        paramBoolean.dismiss();
      }
    }
  }
  
  private final void kB(final boolean paramBoolean)
  {
    int i = 0;
    AppMethodBeat.i(201583);
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
      AppMethodBeat.o(201583);
      return;
    }
    if (this.mwr)
    {
      Log.w(this.TAG, "is loading");
      AppMethodBeat.o(201583);
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
      localObject = new com.tencent.mm.plugin.card.model.b.b(i, this.qhC, this.latitude, this.dTj, this.qhK).aYH().aYI();
      p.g(localObject, "CgiGetMemberCardHomePage…ntCancelAfterDead().run()");
      d.b((com.tencent.mm.vending.g.c)localObject, (kotlin.g.a.b)new e(this, paramBoolean)).b((com.tencent.mm.vending.e.b)this);
      AppMethodBeat.o(201583);
      return;
      i = j;
    }
  }
  
  public final void ad(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(201581);
    if ((this.mGR) && (this.qhK == 1))
    {
      kB(true);
      AppMethodBeat.o(201581);
      return;
    }
    if (!paramBoolean) {
      cxi();
    }
    AppMethodBeat.o(201581);
  }
  
  public final int getLayoutId()
  {
    return 2131493397;
  }
  
  public final void initView()
  {
    AppMethodBeat.i(201578);
    Object localObject1 = findViewById(2131298715);
    p.g(localObject1, "findViewById(R.id.chpvv3_rv)");
    this.qhW = ((WxRecyclerView)localObject1);
    localObject1 = findViewById(2131298713);
    p.g(localObject1, "findViewById(R.id.chpvv3_refresh_layout)");
    this.qgY = ((RefreshLoadMoreLayout)localObject1);
    localObject1 = findViewById(2131298711);
    p.g(localObject1, "findViewById(R.id.chpvv3_empty_layout)");
    this.qgI = ((ViewGroup)localObject1);
    localObject1 = this.qhW;
    if (localObject1 == null) {
      p.btv("mVipCardListRv");
    }
    getContext();
    ((WxRecyclerView)localObject1).setLayoutManager((RecyclerView.LayoutManager)new LinearLayoutManager(1, false));
    this.qia = new WxRecyclerAdapter((f)new f(this), this.qib);
    localObject1 = this.qia;
    if (localObject1 == null) {
      p.btv("mVipCardListAdapter");
    }
    ((WxRecyclerAdapter)localObject1).au(true);
    localObject1 = this.qhW;
    if (localObject1 == null) {
      p.btv("mVipCardListRv");
    }
    Object localObject2 = this.qia;
    if (localObject2 == null) {
      p.btv("mVipCardListAdapter");
    }
    ((WxRecyclerView)localObject1).setAdapter((RecyclerView.a)localObject2);
    localObject1 = new w((Context)getContext(), 1);
    ((w)localObject1).setDrawable(getResources().getDrawable(2131231535));
    localObject2 = this.qhW;
    if (localObject2 == null) {
      p.btv("mVipCardListRv");
    }
    ((WxRecyclerView)localObject2).b((RecyclerView.h)localObject1);
    localObject1 = getLayoutInflater();
    localObject2 = this.qhW;
    if (localObject2 == null) {
      p.btv("mVipCardListRv");
    }
    localObject1 = ((LayoutInflater)localObject1).inflate(2131493395, (ViewGroup)localObject2, false);
    if (localObject1 == null)
    {
      localObject1 = new t("null cannot be cast to non-null type android.view.ViewGroup");
      AppMethodBeat.o(201578);
      throw ((Throwable)localObject1);
    }
    this.qgZ = ((ViewGroup)localObject1);
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
    localObject1 = ((ViewGroup)localObject1).findViewById(2131298716);
    p.g(localObject1, "mHeaderView.findViewById(R.id.chpvv3_sort_layout)");
    this.qhX = ((ViewGroup)localObject1);
    localObject1 = this.qgZ;
    if (localObject1 == null) {
      p.btv("mHeaderView");
    }
    localObject1 = ((ViewGroup)localObject1).findViewById(2131298719);
    p.g(localObject1, "mHeaderView.findViewById…top_phone_vipcard_layout)");
    this.qhY = ((ViewGroup)localObject1);
    localObject1 = this.qgZ;
    if (localObject1 == null) {
      p.btv("mHeaderView");
    }
    localObject1 = ((ViewGroup)localObject1).findViewById(2131298720);
    p.g(localObject1, "mHeaderView.findViewById…vv3_top_phone_vipcard_tv)");
    this.qhZ = ((TextView)localObject1);
    localObject1 = this.qia;
    if (localObject1 == null) {
      p.btv("mVipCardListAdapter");
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
    ((RefreshLoadMoreLayout)localObject1).setActionCallback((RefreshLoadMoreLayout.a)new g(this));
    AppMethodBeat.o(201578);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(201577);
    super.onCreate(paramBundle);
    initView();
    setMMTitle(2131757100);
    setActionbarColor(getResources().getColor(2131099648));
    hideActionbarLine();
    setBackBtn((MenuItem.OnMenuItemClickListener)new h(this));
    paramBundle = com.tencent.mm.plugin.card.model.a.a.pVg;
    paramBundle = a.a.cui();
    if (paramBundle != null)
    {
      this.fs = paramBundle.qGg;
      this.qhI = paramBundle.LUU;
      this.qhG = paramBundle.LUQ;
      this.qig = ((List)paramBundle.LUK);
      this.qhH = paramBundle.LUR;
      this.qid = paramBundle.LYc;
      this.qie = paramBundle.LYe;
      this.qif = paramBundle.LYd;
      cxp();
      a(paramBundle);
    }
    paramBundle = com.tencent.mm.plugin.card.model.a.a.pVg;
    paramBundle = a.a.cuj();
    if (paramBundle != null)
    {
      this.qhK = paramBundle.Leq;
      String str = paramBundle.Les;
      p.g(str, "cardSortInfo.sort_wording");
      this.qhJ = str;
      this.qhC = paramBundle.Ler;
      this.qhL = this.qhK;
    }
    cxs();
    if (this.qhK != 1) {
      kB(true);
    }
    AppMethodBeat.o(201577);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(201580);
    super.onDestroy();
    if (!this.qhg)
    {
      Log.i(this.TAG, "no data to save snapshot");
      AppMethodBeat.o(201580);
      return;
    }
    Object localObject1 = new bqk();
    ((bqk)localObject1).BaseResponse = new BaseResponse();
    ((bqk)localObject1).BaseResponse.ErrMsg = new dqi();
    Object localObject2 = this.qib.iterator();
    while (((Iterator)localObject2).hasNext())
    {
      b localb = (b)((Iterator)localObject2).next();
      if (localb.cxt() != null) {
        ((bqk)localObject1).Lds.add(localb.cxt());
      }
    }
    ((bqk)localObject1).LUU = this.qhI;
    ((bqk)localObject1).qGg = this.fs;
    ((bqk)localObject1).LUR = this.qhH;
    ((bqk)localObject1).LUQ = this.qhG;
    ((bqk)localObject1).LUK = ((LinkedList)this.qig);
    ((bqk)localObject1).LYc = this.qid;
    ((bqk)localObject1).LYd = this.qif;
    ((bqk)localObject1).LYe = this.qie;
    localObject2 = com.tencent.mm.plugin.card.model.a.a.pVg;
    p.h(localObject1, "response");
    Log.d(com.tencent.mm.plugin.card.model.a.a.access$getTAG$cp(), "save vip card list snapshot");
    d.i((kotlin.g.a.a)new a.a.g((bqk)localObject1));
    localObject1 = new uv();
    ((uv)localObject1).Leq = this.qhK;
    ((uv)localObject1).Les = this.qhJ;
    ((uv)localObject1).Ler = this.qhC;
    localObject2 = com.tencent.mm.plugin.card.model.a.a.pVg;
    p.h(localObject1, "sortInfo");
    Log.d(com.tencent.mm.plugin.card.model.a.a.access$getTAG$cp(), "save vip card list snapshot");
    d.i((kotlin.g.a.a)new a.a.h((uv)localObject1));
    AppMethodBeat.o(201580);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(201579);
    if (this.qic)
    {
      kB(true);
      this.qic = false;
    }
    super.onResume();
    AppMethodBeat.o(201579);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/card/ui/v3/VipCardListUI$VipCardConvertData;", "Lcom/tencent/mm/view/recyclerview/ConvertData;", "()V", "vipCardInfo", "Lcom/tencent/mm/protocal/protobuf/CardElementCouponList;", "getVipCardInfo", "()Lcom/tencent/mm/protocal/protobuf/CardElementCouponList;", "setVipCardInfo", "(Lcom/tencent/mm/protocal/protobuf/CardElementCouponList;)V", "getItemId", "", "getItemType", "", "plugin-card_release"})
  public static final class b
    implements com.tencent.mm.view.recyclerview.a
  {
    public ua qii;
    
    public final void a(ua paramua)
    {
      AppMethodBeat.i(201545);
      p.h(paramua, "<set-?>");
      this.qii = paramua;
      AppMethodBeat.o(201545);
    }
    
    public final int cxn()
    {
      return 1;
    }
    
    public final ua cxt()
    {
      AppMethodBeat.i(201544);
      ua localua = this.qii;
      if (localua == null) {
        p.btv("vipCardInfo");
      }
      AppMethodBeat.o(201544);
      return localua;
    }
    
    public final long lT()
    {
      AppMethodBeat.i(201546);
      ua localua = this.qii;
      if (localua == null) {
        p.btv("vipCardInfo");
      }
      long l = localua.KDM.hashCode();
      AppMethodBeat.o(201546);
      return l;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/card/ui/v3/VipCardListUI$VipCardConverter;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "Lcom/tencent/mm/plugin/card/ui/v3/VipCardListUI$VipCardConvertData;", "(Lcom/tencent/mm/plugin/card/ui/v3/VipCardListUI;)V", "getLayoutId", "", "onBindViewHolder", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "position", "type", "isHotPatch", "", "payloads", "", "", "onCreateViewHolder", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "showDeleteConfirmDialog", "cardId", "", "updateCardLabelLayout", "couponLabelList", "", "Lcom/tencent/mm/protocal/protobuf/CardElementCouponLabel;", "labelLayout", "Landroid/widget/LinearLayout;", "plugin-card_release"})
  public final class c
    extends com.tencent.mm.view.recyclerview.e<VipCardListUI.b>
  {
    public final void a(RecyclerView paramRecyclerView, final com.tencent.mm.view.recyclerview.h paramh, int paramInt)
    {
      AppMethodBeat.i(201555);
      p.h(paramRecyclerView, "recyclerView");
      p.h(paramh, "holder");
      ((RoundCornerImageView)paramh.Mn(2131298712)).lx(com.tencent.mm.cb.a.fromDPToPix((Context)this.qij.getContext(), 1), this.qij.getResources().getColor(2131099844));
      paramh.aus.setOnClickListener((View.OnClickListener)new c(this, paramh));
      paramh.aus.setOnLongClickListener((View.OnLongClickListener)new d(this, paramh));
      AppMethodBeat.o(201555);
    }
    
    public final int getLayoutId()
    {
      return 2131493396;
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
    static final class a
      implements Runnable
    {
      a(VipCardListUI.c paramc, com.tencent.mm.view.recyclerview.h paramh, kotlin.g.a.a parama) {}
      
      public final void run()
      {
        AppMethodBeat.i(201547);
        VipCardListUI localVipCardListUI = this.qik.qij;
        View localView = this.qhp.aus;
        p.g(localView, "holder.itemView");
        VipCardListUI.a(localVipCardListUI, localView.getHeight());
        localVipCardListUI = this.qik.qij;
        localView = this.qhp.aus;
        p.g(localView, "holder.itemView");
        VipCardListUI.b(localVipCardListUI, localView.getWidth());
        this.qgW.invoke();
        AppMethodBeat.o(201547);
      }
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
    static final class b
      extends kotlin.g.b.q
      implements kotlin.g.a.a<x>
    {
      b(VipCardListUI.c paramc, MemberCardTopCropImageView paramMemberCardTopCropImageView, VipCardListUI.b paramb)
      {
        super();
      }
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class c
      implements View.OnClickListener
    {
      c(VipCardListUI.c paramc, com.tencent.mm.view.recyclerview.h paramh) {}
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(201549);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/card/ui/v3/VipCardListUI$VipCardConverter$onCreateViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
        paramView = (VipCardListUI.b)paramh.hgv();
        localObject = paramView.cxt();
        if (((ua)localObject).Ldc == 1) {
          com.tencent.mm.plugin.card.d.b.a((MMActivity)this.qik.qij.getContext(), ((ua)localObject).Ldd);
        }
        for (;;)
        {
          localObject = com.tencent.mm.plugin.report.service.h.CyF;
          long l = System.currentTimeMillis() / 1000L;
          String str = paramView.cxt().KDM;
          VipCardListUI localVipCardListUI = this.qik.qij;
          paramView = paramView.cxt().KDM;
          p.g(paramView, "vipCardConvertData.vipCardInfo.user_card_id");
          ((com.tencent.mm.plugin.report.service.h)localObject).a(19748, new Object[] { Integer.valueOf(1), Long.valueOf(l), str, Integer.valueOf(VipCardListUI.b(localVipCardListUI, paramView)), Integer.valueOf(0) });
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/card/ui/v3/VipCardListUI$VipCardConverter$onCreateViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(201549);
          return;
          if (((ua)localObject).Ldc == 2)
          {
            com.tencent.mm.plugin.card.d.b.H(((ua)localObject).Lde.Hwr, ((ua)localObject).Lde.Hws, ((ua)localObject).Lde.IhZ);
          }
          else
          {
            localObject = this.qik.qij;
            str = paramView.cxt().KDM;
            p.g(str, "vipCardConvertData.vipCardInfo.user_card_id");
            VipCardListUI.a((VipCardListUI)localObject, str);
          }
        }
      }
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onLongClick"})
    static final class d
      implements View.OnLongClickListener
    {
      d(VipCardListUI.c paramc, com.tencent.mm.view.recyclerview.h paramh) {}
      
      public final boolean onLongClick(View paramView)
      {
        AppMethodBeat.i(201552);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/card/ui/v3/VipCardListUI$VipCardConverter$onCreateViewHolder$2", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
        final VipCardListUI.b localb = (VipCardListUI.b)paramh.hgv();
        localObject = new com.tencent.mm.ui.widget.b.a((Context)this.qik.qij.getContext(), paramView);
        ((com.tencent.mm.ui.widget.b.a)localObject).a((View.OnCreateContextMenuListener)new View.OnCreateContextMenuListener()
        {
          public final void onCreateContextMenu(ContextMenu paramAnonymousContextMenu, View paramAnonymousView, ContextMenu.ContextMenuInfo paramAnonymousContextMenuInfo)
          {
            AppMethodBeat.i(201550);
            paramAnonymousContextMenu.add(0, 1, 0, (CharSequence)this.qim.qik.qij.getString(2131755778));
            AppMethodBeat.o(201550);
          }
        });
        ((com.tencent.mm.ui.widget.b.a)localObject).a((o.g)new o.g()
        {
          public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
          {
            AppMethodBeat.i(201551);
            paramAnonymousMenuItem = this.qim.qik;
            String str = localb.cxt().KDM;
            p.g(str, "vipCardConvertData.vipCardInfo.user_card_id");
            com.tencent.mm.ui.widget.a.e locale = new com.tencent.mm.ui.widget.a.e((Context)paramAnonymousMenuItem.qij.getContext(), 1, true);
            TextView localTextView = new TextView((Context)paramAnonymousMenuItem.qij.getContext());
            localTextView.setText((CharSequence)paramAnonymousMenuItem.qij.getString(2131757051));
            localTextView.setTextSize(1, 14.0F);
            localTextView.setTextColor(paramAnonymousMenuItem.qij.getResources().getColor(2131100584));
            localTextView.setGravity(17);
            paramAnonymousInt = paramAnonymousMenuItem.qij.getResources().getDimensionPixelSize(2131165314);
            int i = paramAnonymousMenuItem.qij.getResources().getDimensionPixelSize(2131165296);
            localTextView.setPadding(paramAnonymousInt, i, paramAnonymousInt, i);
            locale.V((View)localTextView, false);
            locale.a((o.f)new VipCardListUI.c.e(paramAnonymousMenuItem));
            locale.a((o.g)new VipCardListUI.c.f(paramAnonymousMenuItem, str));
            locale.dGm();
            AppMethodBeat.o(201551);
          }
        });
        p.g(paramView, "it");
        paramView = com.tencent.mm.plugin.card.d.m.dB(paramView);
        ((com.tencent.mm.ui.widget.b.a)localObject).ez(paramView.x, paramView.y);
        com.tencent.mm.plugin.report.service.h.CyF.a(19747, new Object[] { Integer.valueOf(1), Integer.valueOf(3) });
        com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/card/ui/v3/VipCardListUI$VipCardConverter$onCreateViewHolder$2", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
        AppMethodBeat.o(201552);
        return false;
      }
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Lcom/tencent/mm/ui/base/MMMenu;", "kotlin.jvm.PlatformType", "onCreateMMMenu"})
    static final class e
      implements o.f
    {
      e(VipCardListUI.c paramc) {}
      
      public final void onCreateMMMenu(com.tencent.mm.ui.base.m paramm)
      {
        AppMethodBeat.i(201553);
        paramm.a(1, this.qik.qij.getResources().getColor(2131100996), (CharSequence)this.qik.qij.getString(2131755778));
        AppMethodBeat.o(201553);
      }
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "menuItem", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "", "onMMMenuItemSelected"})
    static final class f
      implements o.g
    {
      f(VipCardListUI.c paramc, String paramString) {}
      
      public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
      {
        AppMethodBeat.i(201554);
        p.g(paramMenuItem, "menuItem");
        switch (paramMenuItem.getItemId())
        {
        }
        for (;;)
        {
          AppMethodBeat.o(201554);
          return;
          VipCardListUI.c(this.qik.qij, this.qgl);
          com.tencent.mm.plugin.report.service.h.CyF.a(19747, new Object[] { Integer.valueOf(1), Integer.valueOf(4) });
        }
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/DeleteCardInTicketListResponse;", "kotlin.jvm.PlatformType", "call"})
  static final class d<_Ret, _Var>
    implements com.tencent.mm.vending.c.a<_Ret, _Var>
  {
    d(VipCardListUI paramVipCardListUI, String paramString) {}
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/GetMemberCardHomePageResponse;", "kotlin.jvm.PlatformType", "invoke"})
  static final class e
    extends kotlin.g.b.q
    implements kotlin.g.a.b<c.a<bqk>, x>
  {
    e(VipCardListUI paramVipCardListUI, boolean paramBoolean)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/card/ui/v3/VipCardListUI$initView$1", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "getItemConvert", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "type", "", "plugin-card_release"})
  public static final class f
    implements f
  {
    public final com.tencent.mm.view.recyclerview.e<?> EC(int paramInt)
    {
      AppMethodBeat.i(201559);
      com.tencent.mm.view.recyclerview.e locale = (com.tencent.mm.view.recyclerview.e)new VipCardListUI.c(this.qij);
      AppMethodBeat.o(201559);
      return locale;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/card/ui/v3/VipCardListUI$initView$2", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback;", "onLoadMoreBegin", "", "onLoadMoreEnd", "reason", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;", "", "plugin-card_release"})
  public static final class g
    extends RefreshLoadMoreLayout.a
  {
    public final void ED(int paramInt)
    {
      AppMethodBeat.i(201563);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.pH(paramInt);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/card/ui/v3/VipCardListUI$initView$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshBegin", "(I)V", this, localb.axR());
      super.ED(paramInt);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/card/ui/v3/VipCardListUI$initView$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshBegin", "(I)V");
      AppMethodBeat.o(201563);
    }
    
    public final void a(RefreshLoadMoreLayout.c<Object> paramc)
    {
      AppMethodBeat.i(201562);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bm(paramc);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/card/ui/v3/VipCardListUI$initView$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V", this, localb.axR());
      p.h(paramc, "reason");
      Log.d(VipCardListUI.a(this.qij), "on load more end: " + VipCardListUI.d(this.qij));
      if (VipCardListUI.e(this.qij)) {
        VipCardListUI.f(this.qij).h(null);
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/card/ui/v3/VipCardListUI$initView$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V");
      AppMethodBeat.o(201562);
    }
    
    public final void cxo()
    {
      AppMethodBeat.i(201561);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/card/ui/v3/VipCardListUI$initView$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreBegin", "()V", this);
      Log.d(VipCardListUI.a(this.qij), "on load more");
      d.h((kotlin.g.a.a)new a(this));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/card/ui/v3/VipCardListUI$initView$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreBegin", "()V");
      AppMethodBeat.o(201561);
    }
    
    public final void onRefreshEnd(RefreshLoadMoreLayout.c paramc)
    {
      AppMethodBeat.i(201564);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bm(paramc);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/card/ui/v3/VipCardListUI$initView$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V", this, localb.axR());
      super.onRefreshEnd(paramc);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/card/ui/v3/VipCardListUI$initView$2", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V");
      AppMethodBeat.o(201564);
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
    static final class a
      extends kotlin.g.b.q
      implements kotlin.g.a.a<x>
    {
      a(VipCardListUI.g paramg)
      {
        super();
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class h
    implements MenuItem.OnMenuItemClickListener
  {
    h(VipCardListUI paramVipCardListUI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(201565);
      this.qij.finish();
      AppMethodBeat.o(201565);
      return false;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Lcom/tencent/mm/ui/base/MMMenu;", "kotlin.jvm.PlatformType", "onCreateMMMenu"})
  static final class i
    implements o.f
  {
    i(VipCardListUI paramVipCardListUI) {}
    
    public final void onCreateMMMenu(com.tencent.mm.ui.base.m paramm)
    {
      AppMethodBeat.i(201566);
      Object localObject = VipCardListUI.g(this.qij);
      if (localObject == null) {
        p.hyc();
      }
      localObject = ((uw)localObject).Let.iterator();
      while (((Iterator)localObject).hasNext())
      {
        uv localuv = (uv)((Iterator)localObject).next();
        paramm.add(0, localuv.Leq, 1, (CharSequence)localuv.Les);
      }
      AppMethodBeat.o(201566);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "menuItem", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "index", "", "onMMMenuItemSelected"})
  static final class j
    implements o.g
  {
    j(VipCardListUI paramVipCardListUI) {}
    
    public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
    {
      AppMethodBeat.i(201568);
      p.g(paramMenuItem, "menuItem");
      paramInt = paramMenuItem.getItemId();
      Log.i(VipCardListUI.a(this.qij), "click item: %s", new Object[] { Integer.valueOf(paramInt) });
      if (paramInt == 1)
      {
        if (!VipCardListUI.h(this.qij))
        {
          com.tencent.mm.ui.base.h.a((Context)this.qij.getContext(), this.qij.getString(2131757063), this.qij.getString(2131763890), this.qij.getString(2131762043), this.qij.getString(2131757785), false, (DialogInterface.OnClickListener)new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(201567);
              this.qip.qij.startActivityForResult(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"), 564);
              AppMethodBeat.o(201567);
            }
          }, null);
          AppMethodBeat.o(201568);
          return;
        }
        VipCardListUI.c(this.qij, VipCardListUI.j(this.qij));
        VipCardListUI.d(this.qij, 1);
        VipCardListUI.d(this.qij, paramMenuItem.getTitle().toString());
        VipCardListUI.k(this.qij);
        VipCardListUI.a(this.qij, true);
        com.tencent.mm.plugin.report.service.h.CyF.a(19747, new Object[] { Integer.valueOf(1), Integer.valueOf(5) });
        AppMethodBeat.o(201568);
        return;
      }
      VipCardListUI.c(this.qij, VipCardListUI.j(this.qij));
      VipCardListUI.d(this.qij, paramInt);
      VipCardListUI.d(this.qij, paramMenuItem.getTitle().toString());
      VipCardListUI.k(this.qij);
      VipCardListUI.a(this.qij, true);
      com.tencent.mm.plugin.report.service.h.CyF.a(19747, new Object[] { Integer.valueOf(1), Integer.valueOf(6) });
      AppMethodBeat.o(201568);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class k
    implements MenuItem.OnMenuItemClickListener
  {
    k(VipCardListUI paramVipCardListUI, z.a parama1, z.a parama2) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(201571);
      paramMenuItem = new com.tencent.mm.ui.widget.a.e((Context)this.qij.getContext(), 1, false);
      paramMenuItem.a((o.f)new o.f()
      {
        public final void onCreateMMMenu(com.tencent.mm.ui.base.m paramAnonymousm)
        {
          AppMethodBeat.i(201569);
          if (this.qis.qiq.SYB) {
            paramAnonymousm.add(0, 1, 0, (CharSequence)VipCardListUI.r(this.qis.qij));
          }
          if (this.qis.qir.SYB) {
            paramAnonymousm.add(0, 2, 1, (CharSequence)VipCardListUI.q(this.qis.qij));
          }
          AppMethodBeat.o(201569);
        }
      });
      paramMenuItem.a((o.g)new o.g()
      {
        public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
        {
          AppMethodBeat.i(201570);
          p.g(paramAnonymousMenuItem, "menuItem");
          Object localObject;
          un localun;
          if (paramAnonymousMenuItem.getItemId() == 1)
          {
            VipCardListUI.m(this.qis.qij);
            paramAnonymousMenuItem = VipCardListUI.n(this.qis.qij);
            if (paramAnonymousMenuItem == null) {
              p.hyc();
            }
            paramAnonymousMenuItem = paramAnonymousMenuItem.Hwr;
            localObject = VipCardListUI.n(this.qis.qij);
            if (localObject == null) {
              p.hyc();
            }
            localObject = ((un)localObject).Hws;
            localun = VipCardListUI.n(this.qis.qij);
            if (localun == null) {
              p.hyc();
            }
            com.tencent.mm.plugin.card.d.b.H(paramAnonymousMenuItem, (String)localObject, localun.IhZ);
            com.tencent.mm.plugin.report.service.h.CyF.a(19747, new Object[] { Integer.valueOf(1), Integer.valueOf(7) });
            AppMethodBeat.o(201570);
            return;
          }
          if (paramAnonymousMenuItem.getItemId() == 2)
          {
            paramAnonymousMenuItem = VipCardListUI.p(this.qis.qij);
            if (paramAnonymousMenuItem == null) {
              p.hyc();
            }
            paramAnonymousMenuItem = paramAnonymousMenuItem.Hwr;
            localObject = VipCardListUI.p(this.qis.qij);
            if (localObject == null) {
              p.hyc();
            }
            localObject = ((un)localObject).Hws;
            localun = VipCardListUI.p(this.qis.qij);
            if (localun == null) {
              p.hyc();
            }
            com.tencent.mm.plugin.card.d.b.H(paramAnonymousMenuItem, (String)localObject, localun.IhZ);
            com.tencent.mm.plugin.report.service.h.CyF.a(19747, new Object[] { Integer.valueOf(1), Integer.valueOf(2) });
          }
          AppMethodBeat.o(201570);
        }
      });
      paramMenuItem.dGm();
      com.tencent.mm.plugin.report.service.h.CyF.a(19747, new Object[] { Integer.valueOf(1), Integer.valueOf(1) });
      AppMethodBeat.o(201571);
      return false;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick", "com/tencent/mm/plugin/card/ui/v3/VipCardListUI$updateIconMenuByV4Protocol$1$1"})
  static final class l
    implements MenuItem.OnMenuItemClickListener
  {
    l(List paramList1, VipCardListUI paramVipCardListUI, List paramList2) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(201574);
      paramMenuItem = new com.tencent.mm.ui.widget.a.e((Context)jdField_this.getContext(), 1, false);
      paramMenuItem.a((o.f)new o.f()
      {
        public final void onCreateMMMenu(com.tencent.mm.ui.base.m paramAnonymousm)
        {
          AppMethodBeat.i(201572);
          Iterator localIterator = ((Iterable)this.qiv.qit).iterator();
          int i = 0;
          while (localIterator.hasNext())
          {
            Object localObject = localIterator.next();
            if (i < 0) {
              j.hxH();
            }
            localObject = (ue)localObject;
            paramAnonymousm.add(0, i, 1, (CharSequence)((ue)localObject).LdB);
            Log.i(VipCardListUI.a(this.qiv.qij), "Icon menu content, index: " + i + ", wording: " + ((ue)localObject).LdB + ", jumpType:" + ((ue)localObject).LdC + ' ');
            i += 1;
          }
          AppMethodBeat.o(201572);
        }
      });
      paramMenuItem.a((o.g)new o.g()
      {
        public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
        {
          AppMethodBeat.i(201573);
          VipCardListUI.a(this.qiv.qij, (ue)this.qiv.qiu.get(paramAnonymousInt));
          AppMethodBeat.o(201573);
        }
      });
      paramMenuItem.dGm();
      com.tencent.mm.plugin.report.service.h.CyF.a(19747, new Object[] { Integer.valueOf(1), Integer.valueOf(1) });
      AppMethodBeat.o(201574);
      return false;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class m
    implements View.OnClickListener
  {
    m(VipCardListUI paramVipCardListUI) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(201575);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/card/ui/v3/VipCardListUI$updateTopHeaderLayout$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
      Log.d(VipCardListUI.a(this.qij), "click header view");
      VipCardListUI.l(this.qij);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/card/ui/v3/VipCardListUI$updateTopHeaderLayout$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(201575);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class n
    implements View.OnClickListener
  {
    n(VipCardListUI paramVipCardListUI) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(201576);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/card/ui/v3/VipCardListUI$updateTopHeaderLayout$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
      VipCardListUI.m(this.qij);
      paramView = VipCardListUI.n(this.qij);
      if (paramView == null) {
        p.hyc();
      }
      paramView = paramView.Hwr;
      localObject = VipCardListUI.n(this.qij);
      if (localObject == null) {
        p.hyc();
      }
      localObject = ((un)localObject).Hws;
      un localun = VipCardListUI.n(this.qij);
      if (localun == null) {
        p.hyc();
      }
      com.tencent.mm.plugin.card.d.b.H(paramView, (String)localObject, localun.IhZ);
      com.tencent.mm.plugin.report.service.h.CyF.a(19747, new Object[] { Integer.valueOf(1), Integer.valueOf(8) });
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/card/ui/v3/VipCardListUI$updateTopHeaderLayout$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(201576);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.v3.VipCardListUI
 * JD-Core Version:    0.7.0.1
 */