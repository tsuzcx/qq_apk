package com.tencent.mm.plugin.card.ui.v3;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Point;
import android.os.Bundle;
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
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.an.c.a;
import com.tencent.mm.plugin.card.a.b;
import com.tencent.mm.plugin.card.a.c;
import com.tencent.mm.plugin.card.a.d;
import com.tencent.mm.plugin.card.a.e;
import com.tencent.mm.plugin.card.a.f;
import com.tencent.mm.plugin.card.a.g;
import com.tencent.mm.plugin.card.d.m;
import com.tencent.mm.plugin.card.model.a.a.a.g;
import com.tencent.mm.plugin.card.model.a.a.a.h;
import com.tencent.mm.plugin.card.ui.v2.CardNewBaseUI;
import com.tencent.mm.plugin.card.widget.MemberCardTopCropImageView;
import com.tencent.mm.protocal.protobuf.bye;
import com.tencent.mm.protocal.protobuf.eaf;
import com.tencent.mm.protocal.protobuf.jh;
import com.tencent.mm.protocal.protobuf.uc;
import com.tencent.mm.protocal.protobuf.ug;
import com.tencent.mm.protocal.protobuf.up;
import com.tencent.mm.protocal.protobuf.ux;
import com.tencent.mm.protocal.protobuf.uy;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.base.q.f;
import com.tencent.mm.ui.base.q.g;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.ui.widget.RoundCornerImageView;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.RefreshLoadMoreLayout.a;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.mm.view.recyclerview.WxRecyclerView;
import com.tencent.mm.view.recyclerview.f;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.a.j;
import kotlin.g.b.aa.a;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/card/ui/v3/VipCardListUI;", "Lcom/tencent/mm/plugin/card/ui/v2/CardNewBaseUI;", "()V", "TAG", "", "loadCount", "", "mCurrentSortInfo", "mCurrentSortWording", "mEmptyView", "Landroid/view/ViewGroup;", "mFirstLoad", "", "mHasLoadedSuccess", "mHeaderView", "mHistoryEntranceWording", "mHistoryMiniAppInfo", "Lcom/tencent/mm/protocal/protobuf/CardMiniAppInfo;", "mIconMoreList", "", "Lcom/tencent/mm/protocal/protobuf/CardHomePageFAQItem;", "mIsAll", "mIsLoading", "mNeedRefreshList", "mOffset", "mPhoneMemberEntranceWording", "mPhoneMemberMenuEntranceWording", "mPhoneMemberMiniAppInfo", "mPreviousSortInfo", "mProgressDialog", "Lcom/tencent/mm/ui/base/MMProgressDialog;", "mRefreshLayout", "Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "mReqNum", "mSortInfoList", "Lcom/tencent/mm/protocal/protobuf/CardSortInfoList;", "mSortLayout", "mSortTv", "Landroid/widget/TextView;", "mTopPhoneVipCardLayout", "mTopPhoneVipCardTv", "mViewHeight", "mViewWidth", "mVipCardList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/card/ui/v3/VipCardListUI$VipCardConvertData;", "Lkotlin/collections/ArrayList;", "mVipCardListAdapter", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "mVipCardListRv", "Lcom/tencent/mm/view/recyclerview/WxRecyclerView;", "doDeleteVipCard", "", "cardId", "doLoadVipCardList", "refresh", "getLayoutId", "getPositionByUserCardId", "gotoCardDetailUI", "gotoVipHistoryCardListUI", "title", "initView", "loadSnapshot", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onFinishLocationThings", "ret", "isLocationOk", "onResume", "performMenuItemClicked", "item", "saveSnapshot", "showProgressDialog", "isShow", "(Ljava/lang/Boolean;)V", "showSortDialog", "updateIconMenu", "updateIconMenuByV4Protocol", "iconMenuData", "updateTopHeaderLayout", "updateViewByResp", "resp", "Lcom/tencent/mm/protocal/protobuf/GetMemberCardHomePageResponse;", "Companion", "VipCardConvertData", "VipCardConverter", "plugin-card_release"})
public final class VipCardListUI
  extends CardNewBaseUI
{
  public static final VipCardListUI.a tEd;
  private final String TAG;
  private int aIj;
  private int aIk;
  private s jhZ;
  private boolean pFW;
  private boolean puR;
  private ViewGroup tCE;
  private RefreshLoadMoreLayout tCU;
  private ViewGroup tCV;
  private up tDC;
  private String tDD;
  private uy tDE;
  private String tDF;
  private int tDG;
  private int tDH;
  private WxRecyclerView tDS;
  private ViewGroup tDT;
  private ViewGroup tDU;
  private TextView tDV;
  private WxRecyclerAdapter<b> tDW;
  private final ArrayList<b> tDX;
  private boolean tDY;
  private up tDZ;
  private boolean tDb;
  private boolean tDc;
  private int tDg;
  private TextView tDv;
  private int tDy;
  private String tEa;
  private String tEb;
  private List<? extends ug> tEc;
  private int zP;
  
  static
  {
    AppMethodBeat.i(248259);
    tEd = new VipCardListUI.a((byte)0);
    AppMethodBeat.o(248259);
  }
  
  public VipCardListUI()
  {
    AppMethodBeat.i(248257);
    this.TAG = "MicroMsg.VipCardListUI";
    this.tDX = new ArrayList();
    this.tDy = 10;
    this.tDF = "";
    this.pFW = true;
    AppMethodBeat.o(248257);
  }
  
  private final void a(bye parambye)
  {
    AppMethodBeat.i(248251);
    this.tDE = parambye.TdC;
    parambye = parambye.SeF.iterator();
    while (parambye.hasNext())
    {
      uc localuc = (uc)parambye.next();
      b localb = new b();
      p.j(localuc, "cardInfo");
      localb.a(localuc);
      this.tDX.add(localb);
    }
    if (this.tDX.isEmpty())
    {
      parambye = this.tCE;
      if (parambye == null) {
        p.bGy("mEmptyView");
      }
      parambye.setVisibility(0);
    }
    for (;;)
    {
      parambye = this.tDW;
      if (parambye == null) {
        p.bGy("mVipCardListAdapter");
      }
      parambye.notifyDataSetChanged();
      AppMethodBeat.o(248251);
      return;
      parambye = this.tCE;
      if (parambye == null) {
        p.bGy("mEmptyView");
      }
      parambye.setVisibility(8);
    }
  }
  
  private final void cKR()
  {
    AppMethodBeat.i(248246);
    Object localObject = (Collection)this.tEc;
    if ((localObject == null) || (((Collection)localObject).isEmpty())) {}
    for (int i = 1; i == 0; i = 0)
    {
      cT(this.tEc);
      AppMethodBeat.o(248246);
      return;
    }
    localObject = new aa.a();
    ((aa.a)localObject).aaBx = false;
    final aa.a locala = new aa.a();
    locala.aaBx = false;
    if (this.tDZ != null)
    {
      CharSequence localCharSequence = (CharSequence)this.tEb;
      if ((localCharSequence != null) && (localCharSequence.length() != 0)) {
        break label180;
      }
    }
    label180:
    for (i = 1;; i = 0)
    {
      if (i == 0) {
        ((aa.a)localObject).aaBx = true;
      }
      if (this.tDC != null) {
        locala.aaBx = true;
      }
      if ((((aa.a)localObject).aaBx) || (locala.aaBx))
      {
        removeAllOptionMenu();
        addIconOptionMenu(0, 0, a.f.icons_outlined_more, (MenuItem.OnMenuItemClickListener)new k(this, (aa.a)localObject, locala));
      }
      AppMethodBeat.o(248246);
      return;
    }
  }
  
  private final void cKU()
  {
    int k = 1;
    AppMethodBeat.i(248240);
    int i;
    label130:
    int j;
    if (this.tDG > 0) {
      if (!((Collection)this.tDX).isEmpty())
      {
        i = 1;
        if ((i == 0) || (this.tDE == null)) {
          break label317;
        }
        localObject = this.tDv;
        if (localObject == null) {
          p.bGy("mSortTv");
        }
        ((TextView)localObject).setText((CharSequence)this.tDF);
        localObject = this.tDT;
        if (localObject == null) {
          p.bGy("mSortLayout");
        }
        ((ViewGroup)localObject).setVisibility(0);
        localObject = this.tDT;
        if (localObject == null) {
          p.bGy("mSortLayout");
        }
        ((ViewGroup)localObject).setOnClickListener((View.OnClickListener)new VipCardListUI.m(this));
        i = 1;
        localObject = (CharSequence)this.tEa;
        if ((localObject != null) && (((CharSequence)localObject).length() != 0)) {
          break label346;
        }
        j = 1;
        label156:
        if ((j != 0) || (this.tDZ == null)) {
          break label351;
        }
        localObject = this.tDU;
        if (localObject == null) {
          p.bGy("mTopPhoneVipCardLayout");
        }
        ((ViewGroup)localObject).setVisibility(0);
        localObject = this.tDV;
        if (localObject == null) {
          p.bGy("mTopPhoneVipCardTv");
        }
        ((TextView)localObject).setText((CharSequence)this.tEa);
        localObject = this.tDU;
        if (localObject == null) {
          p.bGy("mTopPhoneVipCardLayout");
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
      localObject = this.tDW;
      if (localObject == null) {
        p.bGy("mVipCardListAdapter");
      }
      localViewGroup = this.tCV;
      if (localViewGroup == null) {
        p.bGy("mHeaderView");
      }
      ((WxRecyclerAdapter)localObject).g((View)localViewGroup, 2, false);
      AppMethodBeat.o(248240);
      return;
      i = 0;
      break;
      label317:
      localObject = this.tDT;
      if (localObject == null) {
        p.bGy("mSortLayout");
      }
      ((ViewGroup)localObject).setVisibility(8);
      i = 0;
      break label130;
      label346:
      j = 0;
      break label156;
      label351:
      localObject = this.tDU;
      if (localObject == null) {
        p.bGy("mTopPhoneVipCardLayout");
      }
      ((ViewGroup)localObject).setVisibility(8);
    }
    label378:
    Object localObject = this.tDW;
    if (localObject == null) {
      p.bGy("mVipCardListAdapter");
    }
    ViewGroup localViewGroup = this.tCV;
    if (localViewGroup == null) {
      p.bGy("mHeaderView");
    }
    ((WxRecyclerAdapter)localObject).T(localViewGroup.hashCode(), false);
    AppMethodBeat.o(248240);
  }
  
  private final void cT(final List<? extends ug> paramList)
  {
    AppMethodBeat.i(248249);
    if (paramList != null)
    {
      removeAllOptionMenu();
      addIconOptionMenu(0, 0, a.f.icons_outlined_more, (MenuItem.OnMenuItemClickListener)new l(paramList, this, paramList));
      AppMethodBeat.o(248249);
      return;
    }
    AppMethodBeat.o(248249);
  }
  
  private final void lN(final boolean paramBoolean)
  {
    int i = 0;
    AppMethodBeat.i(248243);
    Log.i(this.TAG, "do load vip card list: " + this.puR + ", " + this.zP + ", " + this.tDG);
    Object localObject;
    if ((this.tDb) && (!paramBoolean))
    {
      Log.w(this.TAG, "already load complete");
      localObject = this.tCU;
      if (localObject == null) {
        p.bGy("mRefreshLayout");
      }
      ((RefreshLoadMoreLayout)localObject).azs(0);
      AppMethodBeat.o(248243);
      return;
    }
    if (this.puR)
    {
      Log.w(this.TAG, "is loading");
      AppMethodBeat.o(248243);
      return;
    }
    this.puR = true;
    int j = this.zP;
    if (paramBoolean)
    {
      localObject = this.tCU;
      if (localObject == null) {
        p.bGy("mRefreshLayout");
      }
      ((RefreshLoadMoreLayout)localObject).setHasBottomMore(true);
    }
    for (;;)
    {
      localObject = new com.tencent.mm.plugin.card.model.b.b(i, this.tDy, this.latitude, this.longitude, this.tDG).bhV().bhW();
      p.j(localObject, "CgiGetMemberCardHomePage…ntCancelAfterDead().run()");
      d.b((com.tencent.mm.vending.g.c)localObject, (kotlin.g.a.b)new e(this, paramBoolean)).b((com.tencent.mm.vending.e.b)this);
      AppMethodBeat.o(248243);
      return;
      i = j;
    }
  }
  
  private final void n(Boolean paramBoolean)
  {
    AppMethodBeat.i(248254);
    if (paramBoolean == null)
    {
      AppMethodBeat.o(248254);
      return;
    }
    if (paramBoolean.booleanValue()) {}
    for (paramBoolean = s.a((Context)getContext(), (CharSequence)getString(a.g.app_waiting), true, 3, null);; paramBoolean = null)
    {
      this.jhZ = paramBoolean;
      AppMethodBeat.o(248254);
      return;
      paramBoolean = this.jhZ;
      if (paramBoolean != null) {
        paramBoolean.dismiss();
      }
    }
  }
  
  public final void ac(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(248236);
    if ((this.pFW) && (this.tDG == 1))
    {
      lN(true);
      AppMethodBeat.o(248236);
      return;
    }
    if (!paramBoolean) {
      cKL();
    }
    AppMethodBeat.o(248236);
  }
  
  public final int getLayoutId()
  {
    return a.e.tiF;
  }
  
  public final void initView()
  {
    AppMethodBeat.i(248232);
    Object localObject1 = findViewById(a.d.teJ);
    p.j(localObject1, "findViewById(R.id.chpvv3_rv)");
    this.tDS = ((WxRecyclerView)localObject1);
    localObject1 = findViewById(a.d.teH);
    p.j(localObject1, "findViewById(R.id.chpvv3_refresh_layout)");
    this.tCU = ((RefreshLoadMoreLayout)localObject1);
    localObject1 = findViewById(a.d.teF);
    p.j(localObject1, "findViewById(R.id.chpvv3_empty_layout)");
    this.tCE = ((ViewGroup)localObject1);
    localObject1 = this.tDS;
    if (localObject1 == null) {
      p.bGy("mVipCardListRv");
    }
    getContext();
    ((WxRecyclerView)localObject1).setLayoutManager((RecyclerView.LayoutManager)new LinearLayoutManager(1, false));
    this.tDW = new WxRecyclerAdapter((f)new VipCardListUI.f(this), this.tDX);
    localObject1 = this.tDW;
    if (localObject1 == null) {
      p.bGy("mVipCardListAdapter");
    }
    ((WxRecyclerAdapter)localObject1).aw(true);
    localObject1 = this.tDS;
    if (localObject1 == null) {
      p.bGy("mVipCardListRv");
    }
    Object localObject2 = this.tDW;
    if (localObject2 == null) {
      p.bGy("mVipCardListAdapter");
    }
    ((WxRecyclerView)localObject1).setAdapter((RecyclerView.a)localObject2);
    localObject1 = new androidx.recyclerview.widget.i((Context)getContext(), 1);
    ((androidx.recyclerview.widget.i)localObject1).t(getResources().getDrawable(a.c.taj));
    localObject2 = this.tDS;
    if (localObject2 == null) {
      p.bGy("mVipCardListRv");
    }
    ((WxRecyclerView)localObject2).b((RecyclerView.h)localObject1);
    localObject1 = getLayoutInflater();
    int i = a.e.tiD;
    localObject2 = this.tDS;
    if (localObject2 == null) {
      p.bGy("mVipCardListRv");
    }
    localObject1 = ((LayoutInflater)localObject1).inflate(i, (ViewGroup)localObject2, false);
    if (localObject1 == null)
    {
      localObject1 = new t("null cannot be cast to non-null type android.view.ViewGroup");
      AppMethodBeat.o(248232);
      throw ((Throwable)localObject1);
    }
    this.tCV = ((ViewGroup)localObject1);
    localObject1 = this.tCV;
    if (localObject1 == null) {
      p.bGy("mHeaderView");
    }
    localObject1 = ((ViewGroup)localObject1).findViewById(a.d.teL);
    p.j(localObject1, "mHeaderView.findViewById(R.id.chpvv3_sort_tv)");
    this.tDv = ((TextView)localObject1);
    localObject1 = this.tCV;
    if (localObject1 == null) {
      p.bGy("mHeaderView");
    }
    localObject1 = ((ViewGroup)localObject1).findViewById(a.d.teK);
    p.j(localObject1, "mHeaderView.findViewById(R.id.chpvv3_sort_layout)");
    this.tDT = ((ViewGroup)localObject1);
    localObject1 = this.tCV;
    if (localObject1 == null) {
      p.bGy("mHeaderView");
    }
    localObject1 = ((ViewGroup)localObject1).findViewById(a.d.teN);
    p.j(localObject1, "mHeaderView.findViewById…top_phone_vipcard_layout)");
    this.tDU = ((ViewGroup)localObject1);
    localObject1 = this.tCV;
    if (localObject1 == null) {
      p.bGy("mHeaderView");
    }
    localObject1 = ((ViewGroup)localObject1).findViewById(a.d.teO);
    p.j(localObject1, "mHeaderView.findViewById…vv3_top_phone_vipcard_tv)");
    this.tDV = ((TextView)localObject1);
    localObject1 = this.tDW;
    if (localObject1 == null) {
      p.bGy("mVipCardListAdapter");
    }
    localObject2 = this.tCV;
    if (localObject2 == null) {
      p.bGy("mHeaderView");
    }
    ((WxRecyclerAdapter)localObject1).g((View)localObject2, 2, false);
    localObject1 = this.tCU;
    if (localObject1 == null) {
      p.bGy("mRefreshLayout");
    }
    ((RefreshLoadMoreLayout)localObject1).setEnableRefresh(false);
    localObject1 = this.tCU;
    if (localObject1 == null) {
      p.bGy("mRefreshLayout");
    }
    ((RefreshLoadMoreLayout)localObject1).setActionCallback((RefreshLoadMoreLayout.a)new VipCardListUI.g(this));
    AppMethodBeat.o(248232);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(248230);
    super.onCreate(paramBundle);
    initView();
    setMMTitle(a.g.tiT);
    setActionbarColor(getResources().getColor(com.tencent.mm.plugin.card.a.a.BG_0));
    hideActionbarLine();
    setBackBtn((MenuItem.OnMenuItemClickListener)new VipCardListUI.h(this));
    paramBundle = com.tencent.mm.plugin.card.model.a.a.trh;
    paramBundle = com.tencent.mm.plugin.card.model.a.a.a.cHK();
    if (paramBundle != null)
    {
      this.zP = paramBundle.ufi;
      this.tDE = paramBundle.TdC;
      this.tDC = paramBundle.Tdy;
      this.tEc = ((List)paramBundle.Tds);
      this.tDD = paramBundle.Tdz;
      this.tDZ = paramBundle.Tht;
      this.tEa = paramBundle.Thv;
      this.tEb = paramBundle.Thu;
      cKR();
      a(paramBundle);
    }
    paramBundle = com.tencent.mm.plugin.card.model.a.a.trh;
    paramBundle = com.tencent.mm.plugin.card.model.a.a.a.cHL();
    if (paramBundle != null)
    {
      this.tDG = paramBundle.SfD;
      String str = paramBundle.SfF;
      p.j(str, "cardSortInfo.sort_wording");
      this.tDF = str;
      this.tDy = paramBundle.SfE;
      this.tDH = this.tDG;
    }
    cKU();
    if (this.tDG != 1) {
      lN(true);
    }
    AppMethodBeat.o(248230);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(248235);
    super.onDestroy();
    if (!this.tDc)
    {
      Log.i(this.TAG, "no data to save snapshot");
      AppMethodBeat.o(248235);
      return;
    }
    Object localObject1 = new bye();
    ((bye)localObject1).BaseResponse = new jh();
    ((bye)localObject1).BaseResponse.Tef = new eaf();
    Object localObject2 = this.tDX.iterator();
    while (((Iterator)localObject2).hasNext())
    {
      b localb = (b)((Iterator)localObject2).next();
      if (localb.cKV() != null) {
        ((bye)localObject1).SeF.add(localb.cKV());
      }
    }
    ((bye)localObject1).TdC = this.tDE;
    ((bye)localObject1).ufi = this.zP;
    ((bye)localObject1).Tdz = this.tDD;
    ((bye)localObject1).Tdy = this.tDC;
    ((bye)localObject1).Tds = ((LinkedList)this.tEc);
    ((bye)localObject1).Tht = this.tDZ;
    ((bye)localObject1).Thu = this.tEb;
    ((bye)localObject1).Thv = this.tEa;
    localObject2 = com.tencent.mm.plugin.card.model.a.a.trh;
    p.k(localObject1, "response");
    Log.d(com.tencent.mm.plugin.card.model.a.a.access$getTAG$cp(), "save vip card list snapshot");
    d.h((kotlin.g.a.a)new a.a.g((bye)localObject1));
    localObject1 = new ux();
    ((ux)localObject1).SfD = this.tDG;
    ((ux)localObject1).SfF = this.tDF;
    ((ux)localObject1).SfE = this.tDy;
    localObject2 = com.tencent.mm.plugin.card.model.a.a.trh;
    p.k(localObject1, "sortInfo");
    Log.d(com.tencent.mm.plugin.card.model.a.a.access$getTAG$cp(), "save vip card list snapshot");
    d.h((kotlin.g.a.a)new a.a.h((ux)localObject1));
    AppMethodBeat.o(248235);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(248233);
    if (this.tDY)
    {
      lN(true);
      this.tDY = false;
    }
    super.onResume();
    AppMethodBeat.o(248233);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/card/ui/v3/VipCardListUI$VipCardConvertData;", "Lcom/tencent/mm/view/recyclerview/ConvertData;", "()V", "vipCardInfo", "Lcom/tencent/mm/protocal/protobuf/CardElementCouponList;", "getVipCardInfo", "()Lcom/tencent/mm/protocal/protobuf/CardElementCouponList;", "setVipCardInfo", "(Lcom/tencent/mm/protocal/protobuf/CardElementCouponList;)V", "getItemId", "", "getItemType", "", "plugin-card_release"})
  public static final class b
    implements com.tencent.mm.view.recyclerview.a
  {
    public uc tEe;
    
    public final void a(uc paramuc)
    {
      AppMethodBeat.i(251782);
      p.k(paramuc, "<set-?>");
      this.tEe = paramuc;
      AppMethodBeat.o(251782);
    }
    
    public final int bAQ()
    {
      return 1;
    }
    
    public final uc cKV()
    {
      AppMethodBeat.i(251779);
      uc localuc = this.tEe;
      if (localuc == null) {
        p.bGy("vipCardInfo");
      }
      AppMethodBeat.o(251779);
      return localuc;
    }
    
    public final long mf()
    {
      AppMethodBeat.i(251784);
      uc localuc = this.tEe;
      if (localuc == null) {
        p.bGy("vipCardInfo");
      }
      long l = localuc.RFf.hashCode();
      AppMethodBeat.o(251784);
      return l;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/card/ui/v3/VipCardListUI$VipCardConverter;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "Lcom/tencent/mm/plugin/card/ui/v3/VipCardListUI$VipCardConvertData;", "(Lcom/tencent/mm/plugin/card/ui/v3/VipCardListUI;)V", "getLayoutId", "", "onBindViewHolder", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "position", "type", "isHotPatch", "", "payloads", "", "", "onCreateViewHolder", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "showDeleteConfirmDialog", "cardId", "", "updateCardLabelLayout", "couponLabelList", "", "Lcom/tencent/mm/protocal/protobuf/CardElementCouponLabel;", "labelLayout", "Landroid/widget/LinearLayout;", "plugin-card_release"})
  public final class c
    extends com.tencent.mm.view.recyclerview.e<VipCardListUI.b>
  {
    public final void a(RecyclerView paramRecyclerView, final com.tencent.mm.view.recyclerview.i parami, int paramInt)
    {
      AppMethodBeat.i(249838);
      p.k(paramRecyclerView, "recyclerView");
      p.k(parami, "holder");
      ((RoundCornerImageView)parami.RD(a.d.teG)).mP(com.tencent.mm.ci.a.fromDPToPix((Context)this.tEf.getContext(), 1), this.tEf.getResources().getColor(com.tencent.mm.plugin.card.a.a.White));
      parami.amk.setOnClickListener((View.OnClickListener)new c(this, parami));
      parami.amk.setOnLongClickListener((View.OnLongClickListener)new d(this, parami));
      AppMethodBeat.o(249838);
    }
    
    public final int getLayoutId()
    {
      return a.e.tiE;
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
    static final class a
      implements Runnable
    {
      a(VipCardListUI.c paramc, com.tencent.mm.view.recyclerview.i parami, kotlin.g.a.a parama) {}
      
      public final void run()
      {
        AppMethodBeat.i(246656);
        VipCardListUI localVipCardListUI = this.tEg.tEf;
        View localView = this.tDl.amk;
        p.j(localView, "holder.itemView");
        VipCardListUI.a(localVipCardListUI, localView.getHeight());
        localVipCardListUI = this.tEg.tEf;
        localView = this.tDl.amk;
        p.j(localView, "holder.itemView");
        VipCardListUI.b(localVipCardListUI, localView.getWidth());
        this.tCS.invoke();
        AppMethodBeat.o(246656);
      }
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
    static final class b
      extends q
      implements kotlin.g.a.a<x>
    {
      b(VipCardListUI.c paramc, MemberCardTopCropImageView paramMemberCardTopCropImageView, VipCardListUI.b paramb)
      {
        super();
      }
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class c
      implements View.OnClickListener
    {
      c(VipCardListUI.c paramc, com.tencent.mm.view.recyclerview.i parami) {}
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(244324);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/card/ui/v3/VipCardListUI$VipCardConverter$onCreateViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
        paramView = (VipCardListUI.b)parami.ihX();
        localObject = paramView.cKV();
        if (((uc)localObject).Sep == 1) {
          com.tencent.mm.plugin.card.d.b.a((MMActivity)this.tEg.tEf.getContext(), ((uc)localObject).Seq);
        }
        for (;;)
        {
          localObject = com.tencent.mm.plugin.report.service.h.IzE;
          long l = System.currentTimeMillis() / 1000L;
          String str = paramView.cKV().RFf;
          VipCardListUI localVipCardListUI = this.tEg.tEf;
          paramView = paramView.cKV().RFf;
          p.j(paramView, "vipCardConvertData.vipCardInfo.user_card_id");
          ((com.tencent.mm.plugin.report.service.h)localObject).a(19748, new Object[] { Integer.valueOf(1), Long.valueOf(l), str, Integer.valueOf(VipCardListUI.b(localVipCardListUI, paramView)), Integer.valueOf(0) });
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/card/ui/v3/VipCardListUI$VipCardConverter$onCreateViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(244324);
          return;
          if (((uc)localObject).Sep == 2)
          {
            com.tencent.mm.plugin.card.d.b.L(((uc)localObject).Ser.Ooe, ((uc)localObject).Ser.Oof, ((uc)localObject).Ser.Paq);
          }
          else
          {
            localObject = this.tEg.tEf;
            str = paramView.cKV().RFf;
            p.j(str, "vipCardConvertData.vipCardInfo.user_card_id");
            VipCardListUI.a((VipCardListUI)localObject, str);
          }
        }
      }
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onLongClick"})
    static final class d
      implements View.OnLongClickListener
    {
      d(VipCardListUI.c paramc, com.tencent.mm.view.recyclerview.i parami) {}
      
      public final boolean onLongClick(View paramView)
      {
        AppMethodBeat.i(245662);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/card/ui/v3/VipCardListUI$VipCardConverter$onCreateViewHolder$2", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
        final VipCardListUI.b localb = (VipCardListUI.b)parami.ihX();
        localObject = new com.tencent.mm.ui.widget.b.a((Context)this.tEg.tEf.getContext(), paramView);
        ((com.tencent.mm.ui.widget.b.a)localObject).a((View.OnCreateContextMenuListener)new View.OnCreateContextMenuListener()
        {
          public final void onCreateContextMenu(ContextMenu paramAnonymousContextMenu, View paramAnonymousView, ContextMenu.ContextMenuInfo paramAnonymousContextMenuInfo)
          {
            AppMethodBeat.i(251125);
            paramAnonymousContextMenu.add(0, 1, 0, (CharSequence)this.tEi.tEg.tEf.getString(a.g.app_delete));
            AppMethodBeat.o(251125);
          }
        });
        ((com.tencent.mm.ui.widget.b.a)localObject).a((q.g)new q.g()
        {
          public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
          {
            AppMethodBeat.i(247355);
            paramAnonymousMenuItem = this.tEi.tEg;
            String str = localb.cKV().RFf;
            p.j(str, "vipCardConvertData.vipCardInfo.user_card_id");
            com.tencent.mm.ui.widget.a.e locale = new com.tencent.mm.ui.widget.a.e((Context)paramAnonymousMenuItem.tEf.getContext(), 1, true);
            TextView localTextView = new TextView((Context)paramAnonymousMenuItem.tEf.getContext());
            localTextView.setText((CharSequence)paramAnonymousMenuItem.tEf.getString(a.g.tkv));
            localTextView.setTextSize(1, 14.0F);
            localTextView.setTextColor(paramAnonymousMenuItem.tEf.getResources().getColor(com.tencent.mm.plugin.card.a.a.half_alpha_black));
            localTextView.setGravity(17);
            paramAnonymousInt = paramAnonymousMenuItem.tEf.getResources().getDimensionPixelSize(a.b.Edge_A);
            int i = paramAnonymousMenuItem.tEf.getResources().getDimensionPixelSize(a.b.Edge_2A);
            localTextView.setPadding(paramAnonymousInt, i, paramAnonymousInt, i);
            locale.Z((View)localTextView, false);
            locale.a((q.f)new VipCardListUI.c.e(paramAnonymousMenuItem));
            locale.a((q.g)new VipCardListUI.c.f(paramAnonymousMenuItem, str));
            locale.eik();
            AppMethodBeat.o(247355);
          }
        });
        p.j(paramView, "it");
        paramView = m.dZ(paramView);
        ((com.tencent.mm.ui.widget.b.a)localObject).eY(paramView.x, paramView.y);
        com.tencent.mm.plugin.report.service.h.IzE.a(19747, new Object[] { Integer.valueOf(1), Integer.valueOf(3) });
        com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/card/ui/v3/VipCardListUI$VipCardConverter$onCreateViewHolder$2", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
        AppMethodBeat.o(245662);
        return false;
      }
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Lcom/tencent/mm/ui/base/MMMenu;", "kotlin.jvm.PlatformType", "onCreateMMMenu"})
    static final class e
      implements q.f
    {
      e(VipCardListUI.c paramc) {}
      
      public final void onCreateMMMenu(o paramo)
      {
        AppMethodBeat.i(245592);
        paramo.a(1, this.tEg.tEf.getResources().getColor(com.tencent.mm.plugin.card.a.a.red_text_color), (CharSequence)this.tEg.tEf.getString(a.g.app_delete));
        AppMethodBeat.o(245592);
      }
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "menuItem", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "", "onMMMenuItemSelected"})
    static final class f
      implements q.g
    {
      f(VipCardListUI.c paramc, String paramString) {}
      
      public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
      {
        AppMethodBeat.i(246727);
        p.j(paramMenuItem, "menuItem");
        switch (paramMenuItem.getItemId())
        {
        }
        for (;;)
        {
          AppMethodBeat.o(246727);
          return;
          VipCardListUI.c(this.tEg.tEf, this.tCi);
          com.tencent.mm.plugin.report.service.h.IzE.a(19747, new Object[] { Integer.valueOf(1), Integer.valueOf(4) });
        }
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/DeleteCardInTicketListResponse;", "kotlin.jvm.PlatformType", "call"})
  static final class d<_Ret, _Var>
    implements com.tencent.mm.vending.c.a<_Ret, _Var>
  {
    d(VipCardListUI paramVipCardListUI, String paramString) {}
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/GetMemberCardHomePageResponse;", "kotlin.jvm.PlatformType", "invoke"})
  static final class e
    extends q
    implements kotlin.g.a.b<c.a<bye>, x>
  {
    e(VipCardListUI paramVipCardListUI, boolean paramBoolean)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Lcom/tencent/mm/ui/base/MMMenu;", "kotlin.jvm.PlatformType", "onCreateMMMenu"})
  static final class i
    implements q.f
  {
    i(VipCardListUI paramVipCardListUI) {}
    
    public final void onCreateMMMenu(o paramo)
    {
      AppMethodBeat.i(253836);
      Object localObject = VipCardListUI.g(this.tEf);
      if (localObject == null) {
        p.iCn();
      }
      localObject = ((uy)localObject).SfG.iterator();
      while (((Iterator)localObject).hasNext())
      {
        ux localux = (ux)((Iterator)localObject).next();
        paramo.add(0, localux.SfD, 1, (CharSequence)localux.SfF);
      }
      AppMethodBeat.o(253836);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "menuItem", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "index", "", "onMMMenuItemSelected"})
  static final class j
    implements q.g
  {
    j(VipCardListUI paramVipCardListUI) {}
    
    public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
    {
      AppMethodBeat.i(253170);
      p.j(paramMenuItem, "menuItem");
      paramInt = paramMenuItem.getItemId();
      Log.i(VipCardListUI.a(this.tEf), "click item: %s", new Object[] { Integer.valueOf(paramInt) });
      if (paramInt == 1)
      {
        if (!VipCardListUI.h(this.tEf))
        {
          com.tencent.mm.ui.base.h.a((Context)this.tEf.getContext(), this.tEf.getString(a.g.tkA), this.tEf.getString(a.g.permission_tips_title), this.tEf.getString(a.g.jump_to_settings), this.tEf.getString(a.g.confirm_dialog_cancel), false, (DialogInterface.OnClickListener)new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(250076);
              this.tEl.tEf.startActivityForResult(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"), 564);
              AppMethodBeat.o(250076);
            }
          }, null);
          AppMethodBeat.o(253170);
          return;
        }
        VipCardListUI.c(this.tEf, VipCardListUI.j(this.tEf));
        VipCardListUI.d(this.tEf, 1);
        VipCardListUI.d(this.tEf, paramMenuItem.getTitle().toString());
        VipCardListUI.k(this.tEf);
        VipCardListUI.a(this.tEf, true);
        com.tencent.mm.plugin.report.service.h.IzE.a(19747, new Object[] { Integer.valueOf(1), Integer.valueOf(5) });
        AppMethodBeat.o(253170);
        return;
      }
      VipCardListUI.c(this.tEf, VipCardListUI.j(this.tEf));
      VipCardListUI.d(this.tEf, paramInt);
      VipCardListUI.d(this.tEf, paramMenuItem.getTitle().toString());
      VipCardListUI.k(this.tEf);
      VipCardListUI.a(this.tEf, true);
      com.tencent.mm.plugin.report.service.h.IzE.a(19747, new Object[] { Integer.valueOf(1), Integer.valueOf(6) });
      AppMethodBeat.o(253170);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class k
    implements MenuItem.OnMenuItemClickListener
  {
    k(VipCardListUI paramVipCardListUI, aa.a parama1, aa.a parama2) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(248004);
      paramMenuItem = new com.tencent.mm.ui.widget.a.e((Context)this.tEf.getContext(), 1, false);
      paramMenuItem.a((q.f)new q.f()
      {
        public final void onCreateMMMenu(o paramAnonymouso)
        {
          AppMethodBeat.i(244343);
          if (this.tEo.tEm.aaBx) {
            paramAnonymouso.add(0, 1, 0, (CharSequence)VipCardListUI.r(this.tEo.tEf));
          }
          if (this.tEo.tEn.aaBx) {
            paramAnonymouso.add(0, 2, 1, (CharSequence)VipCardListUI.q(this.tEo.tEf));
          }
          AppMethodBeat.o(244343);
        }
      });
      paramMenuItem.a((q.g)new q.g()
      {
        public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
        {
          AppMethodBeat.i(246328);
          p.j(paramAnonymousMenuItem, "menuItem");
          Object localObject;
          up localup;
          if (paramAnonymousMenuItem.getItemId() == 1)
          {
            VipCardListUI.m(this.tEo.tEf);
            paramAnonymousMenuItem = VipCardListUI.n(this.tEo.tEf);
            if (paramAnonymousMenuItem == null) {
              p.iCn();
            }
            paramAnonymousMenuItem = paramAnonymousMenuItem.Ooe;
            localObject = VipCardListUI.n(this.tEo.tEf);
            if (localObject == null) {
              p.iCn();
            }
            localObject = ((up)localObject).Oof;
            localup = VipCardListUI.n(this.tEo.tEf);
            if (localup == null) {
              p.iCn();
            }
            com.tencent.mm.plugin.card.d.b.L(paramAnonymousMenuItem, (String)localObject, localup.Paq);
            com.tencent.mm.plugin.report.service.h.IzE.a(19747, new Object[] { Integer.valueOf(1), Integer.valueOf(7) });
            AppMethodBeat.o(246328);
            return;
          }
          if (paramAnonymousMenuItem.getItemId() == 2)
          {
            paramAnonymousMenuItem = VipCardListUI.p(this.tEo.tEf);
            if (paramAnonymousMenuItem == null) {
              p.iCn();
            }
            paramAnonymousMenuItem = paramAnonymousMenuItem.Ooe;
            localObject = VipCardListUI.p(this.tEo.tEf);
            if (localObject == null) {
              p.iCn();
            }
            localObject = ((up)localObject).Oof;
            localup = VipCardListUI.p(this.tEo.tEf);
            if (localup == null) {
              p.iCn();
            }
            com.tencent.mm.plugin.card.d.b.L(paramAnonymousMenuItem, (String)localObject, localup.Paq);
            com.tencent.mm.plugin.report.service.h.IzE.a(19747, new Object[] { Integer.valueOf(1), Integer.valueOf(2) });
          }
          AppMethodBeat.o(246328);
        }
      });
      paramMenuItem.eik();
      com.tencent.mm.plugin.report.service.h.IzE.a(19747, new Object[] { Integer.valueOf(1), Integer.valueOf(1) });
      AppMethodBeat.o(248004);
      return false;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick", "com/tencent/mm/plugin/card/ui/v3/VipCardListUI$updateIconMenuByV4Protocol$1$1"})
  static final class l
    implements MenuItem.OnMenuItemClickListener
  {
    l(List paramList1, VipCardListUI paramVipCardListUI, List paramList2) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(247761);
      paramMenuItem = new com.tencent.mm.ui.widget.a.e((Context)jdField_this.getContext(), 1, false);
      paramMenuItem.a((q.f)new q.f()
      {
        public final void onCreateMMMenu(o paramAnonymouso)
        {
          AppMethodBeat.i(245433);
          Iterator localIterator = ((Iterable)this.tEr.tEp).iterator();
          int i = 0;
          while (localIterator.hasNext())
          {
            Object localObject = localIterator.next();
            if (i < 0) {
              j.iBO();
            }
            localObject = (ug)localObject;
            paramAnonymouso.add(0, i, 1, (CharSequence)((ug)localObject).SeO);
            Log.i(VipCardListUI.a(this.tEr.tEf), "Icon menu content, index: " + i + ", wording: " + ((ug)localObject).SeO + ", jumpType:" + ((ug)localObject).SeP + ' ');
            i += 1;
          }
          AppMethodBeat.o(245433);
        }
      });
      paramMenuItem.a((q.g)new q.g()
      {
        public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
        {
          AppMethodBeat.i(245698);
          VipCardListUI.a(this.tEr.tEf, (ug)this.tEr.tEq.get(paramAnonymousInt));
          AppMethodBeat.o(245698);
        }
      });
      paramMenuItem.eik();
      com.tencent.mm.plugin.report.service.h.IzE.a(19747, new Object[] { Integer.valueOf(1), Integer.valueOf(1) });
      AppMethodBeat.o(247761);
      return false;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class n
    implements View.OnClickListener
  {
    n(VipCardListUI paramVipCardListUI) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(250176);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/card/ui/v3/VipCardListUI$updateTopHeaderLayout$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
      VipCardListUI.m(this.tEf);
      paramView = VipCardListUI.n(this.tEf);
      if (paramView == null) {
        p.iCn();
      }
      paramView = paramView.Ooe;
      localObject = VipCardListUI.n(this.tEf);
      if (localObject == null) {
        p.iCn();
      }
      localObject = ((up)localObject).Oof;
      up localup = VipCardListUI.n(this.tEf);
      if (localup == null) {
        p.iCn();
      }
      com.tencent.mm.plugin.card.d.b.L(paramView, (String)localObject, localup.Paq);
      com.tencent.mm.plugin.report.service.h.IzE.a(19747, new Object[] { Integer.valueOf(1), Integer.valueOf(8) });
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/card/ui/v3/VipCardListUI$updateTopHeaderLayout$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(250176);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.v3.VipCardListUI
 * JD-Core Version:    0.7.0.1
 */