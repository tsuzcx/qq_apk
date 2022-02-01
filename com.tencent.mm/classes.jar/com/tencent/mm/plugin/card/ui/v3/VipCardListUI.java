package com.tencent.mm.plugin.card.ui.v3;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Point;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.b;
import androidx.recyclerview.widget.RecyclerView.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.am.b.a;
import com.tencent.mm.plugin.card.a.b;
import com.tencent.mm.plugin.card.a.c;
import com.tencent.mm.plugin.card.a.d;
import com.tencent.mm.plugin.card.a.e;
import com.tencent.mm.plugin.card.a.f;
import com.tencent.mm.plugin.card.a.g;
import com.tencent.mm.plugin.card.c.l;
import com.tencent.mm.plugin.card.c.m;
import com.tencent.mm.plugin.card.model.a.a.a.g;
import com.tencent.mm.plugin.card.model.a.a.a.h;
import com.tencent.mm.plugin.card.ui.v2.CardNewBaseUI;
import com.tencent.mm.plugin.card.ui.v4.HistoryCardListUI;
import com.tencent.mm.plugin.card.widget.MemberCardTopCropImageView;
import com.tencent.mm.protocal.protobuf.ajl;
import com.tencent.mm.protocal.protobuf.cnh;
import com.tencent.mm.protocal.protobuf.etl;
import com.tencent.mm.protocal.protobuf.kd;
import com.tencent.mm.protocal.protobuf.vt;
import com.tencent.mm.protocal.protobuf.vx;
import com.tencent.mm.protocal.protobuf.wg;
import com.tencent.mm.protocal.protobuf.wo;
import com.tencent.mm.protocal.protobuf.wp;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.base.w;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.widget.RoundCornerImageView;
import com.tencent.mm.vending.g.c;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.RefreshLoadMoreLayout.b;
import com.tencent.mm.view.RefreshLoadMoreLayout.d;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.mm.view.recyclerview.WxRecyclerView;
import com.tencent.mm.view.recyclerview.g;
import com.tencent.mm.view.recyclerview.j;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.ah;
import kotlin.g.b.ah.a;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/card/ui/v3/VipCardListUI;", "Lcom/tencent/mm/plugin/card/ui/v2/CardNewBaseUI;", "()V", "TAG", "", "loadCount", "", "mCurrentSortInfo", "mCurrentSortWording", "mEmptyView", "Landroid/view/ViewGroup;", "mFirstLoad", "", "mHasLoadedSuccess", "mHeaderView", "mHistoryEntranceWording", "mHistoryMiniAppInfo", "Lcom/tencent/mm/protocal/protobuf/CardMiniAppInfo;", "mIconMoreList", "", "Lcom/tencent/mm/protocal/protobuf/CardHomePageFAQItem;", "mIsAll", "mIsLoading", "mNeedRefreshList", "mOffset", "mPhoneMemberEntranceWording", "mPhoneMemberMenuEntranceWording", "mPhoneMemberMiniAppInfo", "mPreviousSortInfo", "mProgressDialog", "Lcom/tencent/mm/ui/base/MMProgressDialog;", "mRefreshLayout", "Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "mReqNum", "mSortInfoList", "Lcom/tencent/mm/protocal/protobuf/CardSortInfoList;", "mSortLayout", "mSortTv", "Landroid/widget/TextView;", "mTopPhoneVipCardLayout", "mTopPhoneVipCardTv", "mViewHeight", "mViewWidth", "mVipCardList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/card/ui/v3/VipCardListUI$VipCardConvertData;", "Lkotlin/collections/ArrayList;", "mVipCardListAdapter", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "mVipCardListRv", "Lcom/tencent/mm/view/recyclerview/WxRecyclerView;", "doDeleteVipCard", "", "cardId", "doLoadVipCardList", "refresh", "getLayoutId", "getPositionByUserCardId", "gotoCardDetailUI", "gotoVipHistoryCardListUI", "title", "initView", "loadSnapshot", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onFinishLocationThings", "ret", "isLocationOk", "onResume", "performMenuItemClicked", "item", "saveSnapshot", "showProgressDialog", "isShow", "(Ljava/lang/Boolean;)V", "showSortDialog", "superImportUIComponents", "set", "Ljava/util/HashSet;", "Ljava/lang/Class;", "Lcom/tencent/mm/ui/component/UIComponent;", "updateIconMenu", "updateIconMenuByV4Protocol", "iconMenuData", "updateTopHeaderLayout", "updateViewByResp", "resp", "Lcom/tencent/mm/protocal/protobuf/GetMemberCardHomePageResponse;", "Companion", "VipCardConvertData", "VipCardConverter", "VipCardListUIAccessibility", "plugin-card_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class VipCardListUI
  extends CardNewBaseUI
{
  public static final VipCardListUI.a wHK;
  private int Sc;
  private final String TAG;
  private w lKp;
  private int mViewHeight;
  private int mViewWidth;
  private boolean sLf;
  private boolean szX;
  private ViewGroup wGH;
  private RefreshLoadMoreLayout wGX;
  private ViewGroup wGY;
  private wg wHB;
  private String wHC;
  private wp wHD;
  private String wHE;
  private int wHF;
  private int wHG;
  private WxRecyclerView wHL;
  private ViewGroup wHM;
  private ViewGroup wHN;
  private TextView wHO;
  private WxRecyclerAdapter<b> wHP;
  private final ArrayList<b> wHQ;
  private boolean wHR;
  private wg wHS;
  private String wHT;
  private String wHU;
  private List<? extends vx> wHV;
  private boolean wHe;
  private boolean wHf;
  private int wHj;
  private TextView wHu;
  private int wHx;
  
  static
  {
    AppMethodBeat.i(294210);
    wHK = new VipCardListUI.a((byte)0);
    AppMethodBeat.o(294210);
  }
  
  public VipCardListUI()
  {
    AppMethodBeat.i(293888);
    this.TAG = "MicroMsg.VipCardListUI";
    this.wHQ = new ArrayList();
    this.wHx = 10;
    this.wHE = "";
    this.sLf = true;
    AppMethodBeat.o(293888);
  }
  
  private static final ah a(VipCardListUI paramVipCardListUI, String paramString, b.a parama)
  {
    AppMethodBeat.i(294030);
    kotlin.g.b.s.u(paramVipCardListUI, "this$0");
    kotlin.g.b.s.u(paramString, "$cardId");
    Log.i("MicroMsg.CardHomePageNewUI", "errtype: %s, errcode: %s", new Object[] { Integer.valueOf(parama.errType), Integer.valueOf(parama.errCode) });
    if ((parama.errType == 0) && (parama.errCode == 0))
    {
      parama = (ajl)parama.ott;
      Log.i("MicroMsg.CardHomePageNewUI", "retCode: %s", new Object[] { Integer.valueOf(parama.wuz) });
      if (parama.wuz == 0)
      {
        parama = paramVipCardListUI.wHQ.iterator();
        while (parama.hasNext())
        {
          b localb = (b)parama.next();
          if (kotlin.g.b.s.p(localb.doB().YBH, paramString))
          {
            paramVipCardListUI.wHQ.remove(localb);
            parama = paramVipCardListUI.wHP;
            paramString = parama;
            if (parama == null)
            {
              kotlin.g.b.s.bIx("mVipCardListAdapter");
              paramString = null;
            }
            paramString.bZE.notifyChanged();
          }
        }
      }
    }
    for (;;)
    {
      paramVipCardListUI.p(Boolean.FALSE);
      paramVipCardListUI = ah.aiuX;
      AppMethodBeat.o(294030);
      return paramVipCardListUI;
      l.ar((Context)paramVipCardListUI, parama.wuA);
      continue;
      l.as((Context)paramVipCardListUI, "");
    }
  }
  
  private static final void a(VipCardListUI paramVipCardListUI, DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(293963);
    kotlin.g.b.s.u(paramVipCardListUI, "this$0");
    com.tencent.mm.pluginsdk.permission.b.bG((Activity)paramVipCardListUI.getContext());
    AppMethodBeat.o(293963);
  }
  
  private static final void a(VipCardListUI paramVipCardListUI, MenuItem paramMenuItem, int paramInt)
  {
    AppMethodBeat.i(293972);
    kotlin.g.b.s.u(paramVipCardListUI, "this$0");
    paramInt = paramMenuItem.getItemId();
    Log.i(paramVipCardListUI.TAG, "click item: %s", new Object[] { Integer.valueOf(paramInt) });
    if (paramInt == 1)
    {
      if (!paramVipCardListUI.dom())
      {
        k.a((Context)paramVipCardListUI.getContext(), paramVipCardListUI.getString(a.g.woY), paramVipCardListUI.getString(a.g.permission_tips_title), paramVipCardListUI.getString(a.g.jump_to_settings), paramVipCardListUI.getString(a.g.confirm_dialog_cancel), false, new VipCardListUI..ExternalSyntheticLambda0(paramVipCardListUI), null);
        AppMethodBeat.o(293972);
        return;
      }
      paramVipCardListUI.wHG = paramVipCardListUI.wHF;
      paramVipCardListUI.wHF = 1;
      paramVipCardListUI.wHE = paramMenuItem.getTitle().toString();
      paramVipCardListUI.doA();
      paramVipCardListUI.ni(true);
      com.tencent.mm.plugin.report.service.h.OAn.b(19747, new Object[] { Integer.valueOf(1), Integer.valueOf(5) });
      AppMethodBeat.o(293972);
      return;
    }
    paramVipCardListUI.wHG = paramVipCardListUI.wHF;
    paramVipCardListUI.wHF = paramInt;
    paramVipCardListUI.wHE = paramMenuItem.getTitle().toString();
    paramVipCardListUI.doA();
    paramVipCardListUI.ni(true);
    com.tencent.mm.plugin.report.service.h.OAn.b(19747, new Object[] { Integer.valueOf(1), Integer.valueOf(6) });
    AppMethodBeat.o(293972);
  }
  
  private static final void a(VipCardListUI paramVipCardListUI, View paramView)
  {
    AppMethodBeat.i(293977);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramVipCardListUI);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/card/ui/v3/VipCardListUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(paramVipCardListUI, "this$0");
    Log.d(paramVipCardListUI.TAG, "click header view");
    paramVipCardListUI.dox();
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/card/ui/v3/VipCardListUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(293977);
  }
  
  private static final void a(VipCardListUI paramVipCardListUI, com.tencent.mm.ui.base.s params)
  {
    AppMethodBeat.i(293955);
    kotlin.g.b.s.u(paramVipCardListUI, "this$0");
    paramVipCardListUI = paramVipCardListUI.wHD;
    kotlin.g.b.s.checkNotNull(paramVipCardListUI);
    paramVipCardListUI = paramVipCardListUI.ZdB.iterator();
    while (paramVipCardListUI.hasNext())
    {
      wo localwo = (wo)paramVipCardListUI.next();
      params.add(0, localwo.Zdy, 1, (CharSequence)localwo.ZdA);
    }
    AppMethodBeat.o(293955);
  }
  
  private static final void a(VipCardListUI paramVipCardListUI, List paramList, MenuItem paramMenuItem, int paramInt)
  {
    AppMethodBeat.i(294012);
    kotlin.g.b.s.u(paramVipCardListUI, "this$0");
    paramList = (vx)paramList.get(paramInt);
    if (paramList != null) {
      switch (paramList.ZcL)
      {
      }
    }
    for (;;)
    {
      AppMethodBeat.o(294012);
      return;
      paramList = paramList.ZcM;
      if (paramList != null)
      {
        com.tencent.mm.plugin.card.c.b.a((MMActivity)paramVipCardListUI, paramList, 0);
        AppMethodBeat.o(294012);
        return;
        paramVipCardListUI = paramList.ZcN;
        if (paramVipCardListUI != null)
        {
          com.tencent.mm.plugin.card.c.b.S(paramVipCardListUI.VcU, paramVipCardListUI.VcV, paramVipCardListUI.VQU);
          AppMethodBeat.o(294012);
          return;
          paramMenuItem = paramList.ZcO;
          if ((paramMenuItem != null) && (kotlin.g.b.s.p(paramMenuItem, "weixin://mktcard/membercardhistory")))
          {
            com.tencent.mm.plugin.report.service.h.OAn.b(19747, new Object[] { Integer.valueOf(1), Integer.valueOf(2) });
            paramMenuItem = paramList.ZcK;
            Log.i(paramVipCardListUI.TAG, "go to vip history card list");
            paramList = new Intent((Context)paramVipCardListUI.getContext(), HistoryCardListUI.class);
            paramList.putExtra("title", paramMenuItem);
            paramList.putExtra("card_type", 3);
            paramVipCardListUI = paramVipCardListUI.getContext();
            paramList = new com.tencent.mm.hellhoundlib.b.a().cG(paramList);
            com.tencent.mm.hellhoundlib.a.a.b(paramVipCardListUI, paramList.aYi(), "com/tencent/mm/plugin/card/ui/v3/VipCardListUI", "gotoVipHistoryCardListUI", "(Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            paramVipCardListUI.startActivity((Intent)paramList.sb(0));
            com.tencent.mm.hellhoundlib.a.a.c(paramVipCardListUI, "com/tencent/mm/plugin/card/ui/v3/VipCardListUI", "gotoVipHistoryCardListUI", "(Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          }
        }
      }
    }
  }
  
  private final void a(cnh paramcnh)
  {
    Object localObject1 = null;
    AppMethodBeat.i(293931);
    this.wHD = paramcnh.aaqR;
    paramcnh = paramcnh.ZcB.iterator();
    Object localObject2;
    while (paramcnh.hasNext())
    {
      localObject2 = (vt)paramcnh.next();
      b localb = new b();
      kotlin.g.b.s.s(localObject2, "cardInfo");
      localb.a((vt)localObject2);
      this.wHQ.add(localb);
    }
    if (this.wHQ.isEmpty())
    {
      localObject2 = this.wGH;
      paramcnh = (cnh)localObject2;
      if (localObject2 == null)
      {
        kotlin.g.b.s.bIx("mEmptyView");
        paramcnh = null;
      }
      paramcnh.setVisibility(0);
      paramcnh = this.wHP;
      if (paramcnh != null) {
        break label171;
      }
      kotlin.g.b.s.bIx("mVipCardListAdapter");
      paramcnh = localObject1;
    }
    label171:
    for (;;)
    {
      paramcnh.bZE.notifyChanged();
      AppMethodBeat.o(293931);
      return;
      localObject2 = this.wGH;
      paramcnh = (cnh)localObject2;
      if (localObject2 == null)
      {
        kotlin.g.b.s.bIx("mEmptyView");
        paramcnh = null;
      }
      paramcnh.setVisibility(8);
      break;
    }
  }
  
  private static final void a(List paramList, VipCardListUI paramVipCardListUI, com.tencent.mm.ui.base.s params)
  {
    AppMethodBeat.i(294004);
    kotlin.g.b.s.u(paramList, "$this_apply");
    kotlin.g.b.s.u(paramVipCardListUI, "this$0");
    paramList = ((Iterable)paramList).iterator();
    int i = 0;
    while (paramList.hasNext())
    {
      Object localObject = paramList.next();
      if (i < 0) {
        p.kkW();
      }
      localObject = (vx)localObject;
      params.add(0, i, 1, (CharSequence)((vx)localObject).ZcK);
      Log.i(paramVipCardListUI.TAG, "Icon menu content, index: " + i + ", wording: " + ((vx)localObject).ZcK + ", jumpType:" + ((vx)localObject).ZcL + ' ');
      i += 1;
    }
    AppMethodBeat.o(294004);
  }
  
  private static final void a(ah.a parama1, VipCardListUI paramVipCardListUI, ah.a parama2, com.tencent.mm.ui.base.s params)
  {
    AppMethodBeat.i(293987);
    kotlin.g.b.s.u(parama1, "$hasPhoneMemberEntrance");
    kotlin.g.b.s.u(paramVipCardListUI, "this$0");
    kotlin.g.b.s.u(parama2, "$hasHistory");
    if (parama1.aiwY) {
      params.add(0, 1, 0, (CharSequence)paramVipCardListUI.wHU);
    }
    if (parama2.aiwY) {
      params.add(0, 2, 1, (CharSequence)paramVipCardListUI.wHC);
    }
    AppMethodBeat.o(293987);
  }
  
  private static final boolean a(VipCardListUI paramVipCardListUI, MenuItem paramMenuItem)
  {
    AppMethodBeat.i(293946);
    kotlin.g.b.s.u(paramVipCardListUI, "this$0");
    paramVipCardListUI.finish();
    AppMethodBeat.o(293946);
    return false;
  }
  
  private static final boolean a(VipCardListUI paramVipCardListUI, List paramList1, List paramList2, MenuItem paramMenuItem)
  {
    AppMethodBeat.i(294020);
    kotlin.g.b.s.u(paramVipCardListUI, "this$0");
    kotlin.g.b.s.u(paramList1, "$this_apply");
    paramMenuItem = new com.tencent.mm.ui.widget.a.f((Context)paramVipCardListUI.getContext(), 1, false);
    paramMenuItem.Vtg = new VipCardListUI..ExternalSyntheticLambda7(paramList1, paramVipCardListUI);
    paramMenuItem.GAC = new VipCardListUI..ExternalSyntheticLambda11(paramVipCardListUI, paramList2);
    paramMenuItem.dDn();
    com.tencent.mm.plugin.report.service.h.OAn.b(19747, new Object[] { Integer.valueOf(1), Integer.valueOf(1) });
    AppMethodBeat.o(294020);
    return false;
  }
  
  private static final boolean a(VipCardListUI paramVipCardListUI, ah.a parama1, ah.a parama2, MenuItem paramMenuItem)
  {
    AppMethodBeat.i(293999);
    kotlin.g.b.s.u(paramVipCardListUI, "this$0");
    kotlin.g.b.s.u(parama1, "$hasPhoneMemberEntrance");
    kotlin.g.b.s.u(parama2, "$hasHistory");
    paramMenuItem = new com.tencent.mm.ui.widget.a.f((Context)paramVipCardListUI.getContext(), 1, false);
    paramMenuItem.Vtg = new VipCardListUI..ExternalSyntheticLambda8(parama1, paramVipCardListUI, parama2);
    paramMenuItem.GAC = new VipCardListUI..ExternalSyntheticLambda10(paramVipCardListUI);
    paramMenuItem.dDn();
    com.tencent.mm.plugin.report.service.h.OAn.b(19747, new Object[] { Integer.valueOf(1), Integer.valueOf(1) });
    AppMethodBeat.o(293999);
    return false;
  }
  
  private static final void b(VipCardListUI paramVipCardListUI, MenuItem paramMenuItem, int paramInt)
  {
    AppMethodBeat.i(293994);
    kotlin.g.b.s.u(paramVipCardListUI, "this$0");
    Object localObject;
    if (paramMenuItem.getItemId() == 1)
    {
      paramVipCardListUI.wHR = true;
      paramMenuItem = paramVipCardListUI.wHS;
      kotlin.g.b.s.checkNotNull(paramMenuItem);
      paramMenuItem = paramMenuItem.VcU;
      localObject = paramVipCardListUI.wHS;
      kotlin.g.b.s.checkNotNull(localObject);
      localObject = ((wg)localObject).VcV;
      paramVipCardListUI = paramVipCardListUI.wHS;
      kotlin.g.b.s.checkNotNull(paramVipCardListUI);
      com.tencent.mm.plugin.card.c.b.S(paramMenuItem, (String)localObject, paramVipCardListUI.VQU);
      com.tencent.mm.plugin.report.service.h.OAn.b(19747, new Object[] { Integer.valueOf(1), Integer.valueOf(7) });
      AppMethodBeat.o(293994);
      return;
    }
    if (paramMenuItem.getItemId() == 2)
    {
      paramMenuItem = paramVipCardListUI.wHB;
      kotlin.g.b.s.checkNotNull(paramMenuItem);
      paramMenuItem = paramMenuItem.VcU;
      localObject = paramVipCardListUI.wHB;
      kotlin.g.b.s.checkNotNull(localObject);
      localObject = ((wg)localObject).VcV;
      paramVipCardListUI = paramVipCardListUI.wHB;
      kotlin.g.b.s.checkNotNull(paramVipCardListUI);
      com.tencent.mm.plugin.card.c.b.S(paramMenuItem, (String)localObject, paramVipCardListUI.VQU);
      com.tencent.mm.plugin.report.service.h.OAn.b(19747, new Object[] { Integer.valueOf(1), Integer.valueOf(2) });
    }
    AppMethodBeat.o(293994);
  }
  
  private static final void b(VipCardListUI paramVipCardListUI, View paramView)
  {
    AppMethodBeat.i(293981);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramVipCardListUI);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/card/ui/v3/VipCardListUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(paramVipCardListUI, "this$0");
    paramVipCardListUI.wHR = true;
    paramView = paramVipCardListUI.wHS;
    kotlin.g.b.s.checkNotNull(paramView);
    paramView = paramView.VcU;
    localObject = paramVipCardListUI.wHS;
    kotlin.g.b.s.checkNotNull(localObject);
    localObject = ((wg)localObject).VcV;
    paramVipCardListUI = paramVipCardListUI.wHS;
    kotlin.g.b.s.checkNotNull(paramVipCardListUI);
    com.tencent.mm.plugin.card.c.b.S(paramView, (String)localObject, paramVipCardListUI.VQU);
    com.tencent.mm.plugin.report.service.h.OAn.b(19747, new Object[] { Integer.valueOf(1), Integer.valueOf(8) });
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/card/ui/v3/VipCardListUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(293981);
  }
  
  private final void doA()
  {
    int k = 1;
    Object localObject2 = null;
    AppMethodBeat.i(293901);
    int i;
    label66:
    int j;
    if (this.wHF > 0) {
      if (!((Collection)this.wHQ).isEmpty())
      {
        i = 1;
        if ((i == 0) || (this.wHD == null)) {
          break label361;
        }
        localObject1 = this.wHu;
        if (localObject1 != null) {
          break label358;
        }
        kotlin.g.b.s.bIx("mSortTv");
        localObject1 = null;
        ((TextView)localObject1).setText((CharSequence)this.wHE);
        localObject3 = this.wHM;
        localObject1 = localObject3;
        if (localObject3 == null)
        {
          kotlin.g.b.s.bIx("mSortLayout");
          localObject1 = null;
        }
        ((ViewGroup)localObject1).setVisibility(0);
        localObject3 = this.wHM;
        localObject1 = localObject3;
        if (localObject3 == null)
        {
          kotlin.g.b.s.bIx("mSortLayout");
          localObject1 = null;
        }
        ((ViewGroup)localObject1).setOnClickListener(new VipCardListUI..ExternalSyntheticLambda4(this));
        i = 1;
        label147:
        localObject1 = (CharSequence)this.wHT;
        if ((localObject1 != null) && (((CharSequence)localObject1).length() != 0)) {
          break label397;
        }
        j = 1;
        label173:
        if ((j != 0) || (this.wHS == null)) {
          break label405;
        }
        localObject3 = this.wHN;
        localObject1 = localObject3;
        if (localObject3 == null)
        {
          kotlin.g.b.s.bIx("mTopPhoneVipCardLayout");
          localObject1 = null;
        }
        ((ViewGroup)localObject1).setVisibility(0);
        localObject1 = this.wHO;
        if (localObject1 != null) {
          break label402;
        }
        kotlin.g.b.s.bIx("mTopPhoneVipCardTv");
        localObject1 = null;
        label234:
        ((TextView)localObject1).setText((CharSequence)this.wHT);
        localObject3 = this.wHN;
        localObject1 = localObject3;
        if (localObject3 == null)
        {
          kotlin.g.b.s.bIx("mTopPhoneVipCardLayout");
          localObject1 = null;
        }
        ((ViewGroup)localObject1).setOnClickListener(new VipCardListUI..ExternalSyntheticLambda5(this));
        i = k;
        label285:
        if (i == 0) {
          break label442;
        }
        localObject1 = this.wHP;
        if (localObject1 != null) {
          break label439;
        }
        kotlin.g.b.s.bIx("mVipCardListAdapter");
        localObject1 = null;
      }
    }
    label397:
    label402:
    label405:
    label439:
    for (;;)
    {
      localObject3 = this.wGY;
      localObject2 = localObject3;
      if (localObject3 == null)
      {
        kotlin.g.b.s.bIx("mHeaderView");
        localObject2 = null;
      }
      ((WxRecyclerAdapter)localObject1).i((View)localObject2, 2, false);
      AppMethodBeat.o(293901);
      return;
      i = 0;
      break;
      label358:
      break label66;
      label361:
      localObject3 = this.wHM;
      localObject1 = localObject3;
      if (localObject3 == null)
      {
        kotlin.g.b.s.bIx("mSortLayout");
        localObject1 = null;
      }
      ((ViewGroup)localObject1).setVisibility(8);
      i = 0;
      break label147;
      j = 0;
      break label173;
      break label234;
      localObject3 = this.wHN;
      localObject1 = localObject3;
      if (localObject3 == null)
      {
        kotlin.g.b.s.bIx("mTopPhoneVipCardLayout");
        localObject1 = null;
      }
      ((ViewGroup)localObject1).setVisibility(8);
      break label285;
    }
    label442:
    Object localObject3 = this.wHP;
    Object localObject1 = localObject3;
    if (localObject3 == null)
    {
      kotlin.g.b.s.bIx("mVipCardListAdapter");
      localObject1 = null;
    }
    localObject3 = this.wGY;
    if (localObject3 == null) {
      kotlin.g.b.s.bIx("mHeaderView");
    }
    for (;;)
    {
      ((WxRecyclerAdapter)localObject1).ae(localObject2.hashCode(), false);
      AppMethodBeat.o(293901);
      return;
      localObject2 = localObject3;
    }
  }
  
  private final void dow()
  {
    AppMethodBeat.i(293918);
    Object localObject = (Collection)this.wHV;
    if ((localObject == null) || (((Collection)localObject).isEmpty())) {}
    for (int i = 1; i == 0; i = 0)
    {
      eO(this.wHV);
      AppMethodBeat.o(293918);
      return;
    }
    localObject = new ah.a();
    ah.a locala = new ah.a();
    if (this.wHS != null)
    {
      CharSequence localCharSequence = (CharSequence)this.wHU;
      if ((localCharSequence != null) && (localCharSequence.length() != 0)) {
        break label167;
      }
    }
    label167:
    for (i = 1;; i = 0)
    {
      if (i == 0) {
        ((ah.a)localObject).aiwY = true;
      }
      if (this.wHB != null) {
        locala.aiwY = true;
      }
      if ((((ah.a)localObject).aiwY) || (locala.aiwY))
      {
        removeAllOptionMenu();
        addIconOptionMenu(0, 0, a.f.icons_outlined_more, new VipCardListUI..ExternalSyntheticLambda3(this, (ah.a)localObject, locala));
      }
      AppMethodBeat.o(293918);
      return;
    }
  }
  
  private final void dox()
  {
    AppMethodBeat.i(293893);
    Log.i(this.TAG, "show sort dialog");
    if (this.wHD == null)
    {
      AppMethodBeat.o(293893);
      return;
    }
    com.tencent.mm.ui.widget.a.f localf = new com.tencent.mm.ui.widget.a.f((Context)getContext(), 1, false);
    localf.Vtg = new VipCardListUI..ExternalSyntheticLambda6(this);
    localf.GAC = new VipCardListUI..ExternalSyntheticLambda9(this);
    localf.dDn();
    AppMethodBeat.o(293893);
  }
  
  private final void eO(List<? extends vx> paramList)
  {
    AppMethodBeat.i(293920);
    if (paramList != null)
    {
      removeAllOptionMenu();
      addIconOptionMenu(0, 0, a.f.icons_outlined_more, new VipCardListUI..ExternalSyntheticLambda2(this, paramList, paramList));
    }
    AppMethodBeat.o(293920);
  }
  
  private final void ni(final boolean paramBoolean)
  {
    RefreshLoadMoreLayout localRefreshLoadMoreLayout = null;
    Object localObject = null;
    int i = 0;
    AppMethodBeat.i(293910);
    Log.i(this.TAG, "do load vip card list: " + this.szX + ", " + this.Sc + ", " + this.wHF);
    if ((this.wHe) && (!paramBoolean))
    {
      Log.w(this.TAG, "already load complete");
      localRefreshLoadMoreLayout = this.wGX;
      if (localRefreshLoadMoreLayout == null) {
        kotlin.g.b.s.bIx("mRefreshLayout");
      }
      for (;;)
      {
        ((RefreshLoadMoreLayout)localObject).aFW(0);
        AppMethodBeat.o(293910);
        return;
        localObject = localRefreshLoadMoreLayout;
      }
    }
    if (this.szX)
    {
      Log.w(this.TAG, "is loading");
      AppMethodBeat.o(293910);
      return;
    }
    this.szX = true;
    int j = this.Sc;
    if (paramBoolean)
    {
      localObject = this.wGX;
      if (localObject == null)
      {
        kotlin.g.b.s.bIx("mRefreshLayout");
        localObject = localRefreshLoadMoreLayout;
        ((RefreshLoadMoreLayout)localObject).setHasBottomMore(true);
      }
    }
    for (;;)
    {
      localObject = new com.tencent.mm.plugin.card.model.b.b(i, this.wHx, getLatitude(), getLongitude(), this.wHF);
      ((com.tencent.mm.am.b)localObject).otr = true;
      localObject = ((com.tencent.mm.am.b)localObject).bFJ();
      kotlin.g.b.s.s(localObject, "CgiGetMemberCardHomePage…ntCancelAfterDead().run()");
      d.b((c)localObject, (kotlin.g.a.b)new e(this, paramBoolean)).b((com.tencent.mm.vending.e.b)this);
      AppMethodBeat.o(293910);
      return;
      break;
      i = j;
    }
  }
  
  private final void p(Boolean paramBoolean)
  {
    AppMethodBeat.i(293939);
    if (paramBoolean == null)
    {
      AppMethodBeat.o(293939);
      return;
    }
    if (paramBoolean.booleanValue()) {}
    for (paramBoolean = w.a((Context)getContext(), (CharSequence)getString(a.g.app_waiting), true, 3, null);; paramBoolean = null)
    {
      this.lKp = paramBoolean;
      AppMethodBeat.o(293939);
      return;
      paramBoolean = this.lKp;
      if (paramBoolean != null) {
        paramBoolean.dismiss();
      }
    }
  }
  
  public final void at(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(294300);
    if ((this.sLf) && (this.wHF == 1))
    {
      ni(true);
      AppMethodBeat.o(294300);
      return;
    }
    if (!paramBoolean) {
      doo();
    }
    AppMethodBeat.o(294300);
  }
  
  public final int getLayoutId()
  {
    return a.e.wnc;
  }
  
  public final void initView()
  {
    Object localObject3 = null;
    AppMethodBeat.i(294275);
    Object localObject1 = findViewById(a.d.wiZ);
    kotlin.g.b.s.s(localObject1, "findViewById(R.id.chpvv3_rv)");
    this.wHL = ((WxRecyclerView)localObject1);
    localObject1 = findViewById(a.d.wiX);
    kotlin.g.b.s.s(localObject1, "findViewById(R.id.chpvv3_refresh_layout)");
    this.wGX = ((RefreshLoadMoreLayout)localObject1);
    localObject1 = findViewById(a.d.wiV);
    kotlin.g.b.s.s(localObject1, "findViewById(R.id.chpvv3_empty_layout)");
    this.wGH = ((ViewGroup)localObject1);
    localObject1 = this.wHL;
    label183:
    Object localObject4;
    if (localObject1 == null)
    {
      kotlin.g.b.s.bIx("mVipCardListRv");
      localObject1 = null;
      getContext();
      ((WxRecyclerView)localObject1).setLayoutManager((RecyclerView.LayoutManager)new LinearLayoutManager(1, false));
      this.wHP = new WxRecyclerAdapter((g)new f(this), this.wHQ);
      localObject2 = this.wHP;
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        kotlin.g.b.s.bIx("mVipCardListAdapter");
        localObject1 = null;
      }
      ((WxRecyclerAdapter)localObject1).bf(true);
      localObject1 = this.wHL;
      if (localObject1 != null) {
        break label335;
      }
      kotlin.g.b.s.bIx("mVipCardListRv");
      localObject1 = null;
      localObject4 = this.wHP;
      localObject2 = localObject4;
      if (localObject4 == null)
      {
        kotlin.g.b.s.bIx("mVipCardListAdapter");
        localObject2 = null;
      }
      ((WxRecyclerView)localObject1).setAdapter((RecyclerView.a)localObject2);
      localObject2 = new androidx.recyclerview.widget.h((Context)getContext(), 1);
      ((androidx.recyclerview.widget.h)localObject2).w(getResources().getDrawable(a.c.weq));
      localObject1 = this.wHL;
      if (localObject1 != null) {
        break label338;
      }
      kotlin.g.b.s.bIx("mVipCardListRv");
      localObject1 = null;
    }
    label335:
    label338:
    for (;;)
    {
      ((RecyclerView)localObject1).a((RecyclerView.h)localObject2);
      localObject4 = getLayoutInflater();
      int i = a.e.wna;
      localObject2 = this.wHL;
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        kotlin.g.b.s.bIx("mVipCardListRv");
        localObject1 = null;
      }
      localObject1 = ((LayoutInflater)localObject4).inflate(i, (ViewGroup)localObject1, false);
      if (localObject1 != null) {
        break label341;
      }
      localObject1 = new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
      AppMethodBeat.o(294275);
      throw ((Throwable)localObject1);
      break;
      break label183;
    }
    label341:
    this.wGY = ((ViewGroup)localObject1);
    Object localObject2 = this.wGY;
    localObject1 = localObject2;
    if (localObject2 == null)
    {
      kotlin.g.b.s.bIx("mHeaderView");
      localObject1 = null;
    }
    localObject1 = ((ViewGroup)localObject1).findViewById(a.d.wjb);
    kotlin.g.b.s.s(localObject1, "mHeaderView.findViewById(R.id.chpvv3_sort_tv)");
    this.wHu = ((TextView)localObject1);
    localObject2 = this.wGY;
    localObject1 = localObject2;
    if (localObject2 == null)
    {
      kotlin.g.b.s.bIx("mHeaderView");
      localObject1 = null;
    }
    localObject1 = ((ViewGroup)localObject1).findViewById(a.d.wja);
    kotlin.g.b.s.s(localObject1, "mHeaderView.findViewById(R.id.chpvv3_sort_layout)");
    this.wHM = ((ViewGroup)localObject1);
    localObject2 = this.wGY;
    localObject1 = localObject2;
    if (localObject2 == null)
    {
      kotlin.g.b.s.bIx("mHeaderView");
      localObject1 = null;
    }
    localObject1 = ((ViewGroup)localObject1).findViewById(a.d.wjd);
    kotlin.g.b.s.s(localObject1, "mHeaderView.findViewById…top_phone_vipcard_layout)");
    this.wHN = ((ViewGroup)localObject1);
    localObject2 = this.wGY;
    localObject1 = localObject2;
    if (localObject2 == null)
    {
      kotlin.g.b.s.bIx("mHeaderView");
      localObject1 = null;
    }
    localObject1 = ((ViewGroup)localObject1).findViewById(a.d.wje);
    kotlin.g.b.s.s(localObject1, "mHeaderView.findViewById…vv3_top_phone_vipcard_tv)");
    this.wHO = ((TextView)localObject1);
    localObject1 = this.wHP;
    if (localObject1 == null)
    {
      kotlin.g.b.s.bIx("mVipCardListAdapter");
      localObject1 = null;
      localObject4 = this.wGY;
      localObject2 = localObject4;
      if (localObject4 == null)
      {
        kotlin.g.b.s.bIx("mHeaderView");
        localObject2 = null;
      }
      ((WxRecyclerAdapter)localObject1).i((View)localObject2, 2, false);
      localObject2 = this.wGX;
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        kotlin.g.b.s.bIx("mRefreshLayout");
        localObject1 = null;
      }
      ((RefreshLoadMoreLayout)localObject1).setEnableRefresh(false);
      localObject1 = this.wGX;
      if (localObject1 != null) {
        break label634;
      }
      kotlin.g.b.s.bIx("mRefreshLayout");
      localObject1 = localObject3;
    }
    label634:
    for (;;)
    {
      ((RefreshLoadMoreLayout)localObject1).setActionCallback((RefreshLoadMoreLayout.b)new g(this));
      AppMethodBeat.o(294275);
      return;
      break;
    }
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(294266);
    super.onCreate(paramBundle);
    initView();
    setMMTitle(a.g.wnq);
    setActionbarColor(getResources().getColor(com.tencent.mm.plugin.card.a.a.BG_0));
    hideActionbarLine();
    setBackBtn(new VipCardListUI..ExternalSyntheticLambda1(this));
    paramBundle = com.tencent.mm.plugin.card.model.a.a.wvG;
    paramBundle = com.tencent.mm.plugin.card.model.a.a.a.dlb();
    if (paramBundle != null)
    {
      this.Sc = paramBundle.xlj;
      this.wHD = paramBundle.aaqR;
      this.wHB = paramBundle.aaqN;
      this.wHV = ((List)paramBundle.aaqH);
      this.wHC = paramBundle.aaqO;
      this.wHS = paramBundle.aauJ;
      this.wHT = paramBundle.aauL;
      this.wHU = paramBundle.aauK;
      dow();
      a(paramBundle);
    }
    paramBundle = com.tencent.mm.plugin.card.model.a.a.wvG;
    paramBundle = com.tencent.mm.plugin.card.model.a.a.a.dlc();
    if (paramBundle != null)
    {
      this.wHF = paramBundle.Zdy;
      String str = paramBundle.ZdA;
      kotlin.g.b.s.s(str, "cardSortInfo.sort_wording");
      this.wHE = str;
      this.wHx = paramBundle.Zdz;
      this.wHG = this.wHF;
    }
    doA();
    if (this.wHF != 1) {
      ni(true);
    }
    AppMethodBeat.o(294266);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(294291);
    super.onDestroy();
    if (!this.wHf)
    {
      Log.i(this.TAG, "no data to save snapshot");
      AppMethodBeat.o(294291);
      return;
    }
    Object localObject1 = new cnh();
    ((cnh)localObject1).BaseResponse = new kd();
    ((cnh)localObject1).BaseResponse.akjO = new etl();
    Object localObject2 = this.wHQ.iterator();
    while (((Iterator)localObject2).hasNext())
    {
      b localb = (b)((Iterator)localObject2).next();
      if (localb.doB() != null) {
        ((cnh)localObject1).ZcB.add(localb.doB());
      }
    }
    ((cnh)localObject1).aaqR = this.wHD;
    ((cnh)localObject1).xlj = this.Sc;
    ((cnh)localObject1).aaqO = this.wHC;
    ((cnh)localObject1).aaqN = this.wHB;
    ((cnh)localObject1).aaqH = ((LinkedList)this.wHV);
    ((cnh)localObject1).aauJ = this.wHS;
    ((cnh)localObject1).aauK = this.wHU;
    ((cnh)localObject1).aauL = this.wHT;
    localObject2 = com.tencent.mm.plugin.card.model.a.a.wvG;
    kotlin.g.b.s.u(localObject1, "response");
    Log.d(com.tencent.mm.plugin.card.model.a.a.access$getTAG$cp(), "save vip card list snapshot");
    d.B((kotlin.g.a.a)new a.a.g((cnh)localObject1));
    localObject1 = new wo();
    ((wo)localObject1).Zdy = this.wHF;
    ((wo)localObject1).ZdA = this.wHE;
    ((wo)localObject1).Zdz = this.wHx;
    localObject2 = com.tencent.mm.plugin.card.model.a.a.wvG;
    kotlin.g.b.s.u(localObject1, "sortInfo");
    Log.d(com.tencent.mm.plugin.card.model.a.a.access$getTAG$cp(), "save vip card list snapshot");
    d.B((kotlin.g.a.a)new a.a.h((wo)localObject1));
    AppMethodBeat.o(294291);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(294282);
    if (this.wHR)
    {
      ni(true);
      this.wHR = false;
    }
    super.onResume();
    AppMethodBeat.o(294282);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public final void superImportUIComponents(HashSet<Class<? extends UIComponent>> paramHashSet)
  {
    AppMethodBeat.i(294310);
    kotlin.g.b.s.u(paramHashSet, "set");
    super.superImportUIComponents(paramHashSet);
    paramHashSet.add(VipCardListUI.d.class);
    AppMethodBeat.o(294310);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/card/ui/v3/VipCardListUI$VipCardConvertData;", "Lcom/tencent/mm/view/recyclerview/ConvertData;", "()V", "vipCardInfo", "Lcom/tencent/mm/protocal/protobuf/CardElementCouponList;", "getVipCardInfo", "()Lcom/tencent/mm/protocal/protobuf/CardElementCouponList;", "setVipCardInfo", "(Lcom/tencent/mm/protocal/protobuf/CardElementCouponList;)V", "getItemId", "", "getItemType", "", "plugin-card_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    implements com.tencent.mm.view.recyclerview.a
  {
    public vt wHW;
    
    public final void a(vt paramvt)
    {
      AppMethodBeat.i(293848);
      kotlin.g.b.s.u(paramvt, "<set-?>");
      this.wHW = paramvt;
      AppMethodBeat.o(293848);
    }
    
    public final long bZA()
    {
      AppMethodBeat.i(293853);
      long l = doB().YBH.hashCode();
      AppMethodBeat.o(293853);
      return l;
    }
    
    public final int bZB()
    {
      return 1;
    }
    
    public final vt doB()
    {
      AppMethodBeat.i(293844);
      vt localvt = this.wHW;
      if (localvt != null)
      {
        AppMethodBeat.o(293844);
        return localvt;
      }
      kotlin.g.b.s.bIx("vipCardInfo");
      AppMethodBeat.o(293844);
      return null;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/card/ui/v3/VipCardListUI$VipCardConverter;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "Lcom/tencent/mm/plugin/card/ui/v3/VipCardListUI$VipCardConvertData;", "(Lcom/tencent/mm/plugin/card/ui/v3/VipCardListUI;)V", "getLayoutId", "", "onBindViewHolder", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "position", "type", "isHotPatch", "", "payloads", "", "", "onCreateViewHolder", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "showDeleteConfirmDialog", "cardId", "", "updateCardLabelLayout", "couponLabelList", "", "Lcom/tencent/mm/protocal/protobuf/CardElementCouponLabel;", "labelLayout", "Landroid/widget/LinearLayout;", "plugin-card_release"}, k=1, mv={1, 5, 1}, xi=48)
  public final class c
    extends com.tencent.mm.view.recyclerview.f<VipCardListUI.b>
  {
    public c()
    {
      AppMethodBeat.i(293849);
      AppMethodBeat.o(293849);
    }
    
    private static final void a(c paramc, VipCardListUI.b paramb, MenuItem paramMenuItem, int paramInt)
    {
      AppMethodBeat.i(293869);
      kotlin.g.b.s.u(paramc, "this$0");
      paramb = paramb.doB().YBH;
      kotlin.g.b.s.s(paramb, "vipCardConvertData.vipCardInfo.user_card_id");
      paramMenuItem = new com.tencent.mm.ui.widget.a.f((Context)paramc.wHX.getContext(), 1, true);
      TextView localTextView = new TextView((Context)paramc.wHX.getContext());
      localTextView.setText((CharSequence)paramc.wHX.getString(a.g.woT));
      localTextView.setTextSize(1, 14.0F);
      localTextView.setTextColor(paramc.wHX.getResources().getColor(com.tencent.mm.plugin.card.a.a.half_alpha_black));
      localTextView.setGravity(17);
      paramInt = paramc.wHX.getResources().getDimensionPixelSize(a.b.Edge_A);
      int i = paramc.wHX.getResources().getDimensionPixelSize(a.b.Edge_2A);
      localTextView.setPadding(paramInt, i, paramInt, i);
      paramMenuItem.af((View)localTextView, false);
      paramMenuItem.Vtg = new VipCardListUI.c..ExternalSyntheticLambda3(paramc.wHX);
      paramMenuItem.GAC = new VipCardListUI.c..ExternalSyntheticLambda5(paramc.wHX, paramb);
      paramMenuItem.dDn();
      AppMethodBeat.o(293869);
    }
    
    private static final void a(VipCardListUI paramVipCardListUI, ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
    {
      AppMethodBeat.i(293864);
      kotlin.g.b.s.u(paramVipCardListUI, "this$0");
      paramContextMenu.add(0, 1, 0, (CharSequence)paramVipCardListUI.getString(a.g.app_delete));
      AppMethodBeat.o(293864);
    }
    
    private static final void a(VipCardListUI paramVipCardListUI, j paramj, kotlin.g.a.a parama)
    {
      AppMethodBeat.i(293894);
      kotlin.g.b.s.u(paramVipCardListUI, "this$0");
      kotlin.g.b.s.u(paramj, "$holder");
      kotlin.g.b.s.u(parama, "$func");
      VipCardListUI.d(paramVipCardListUI, paramj.caK.getHeight());
      VipCardListUI.e(paramVipCardListUI, paramj.caK.getWidth());
      parama.invoke();
      AppMethodBeat.o(293894);
    }
    
    private static final void a(VipCardListUI paramVipCardListUI, String paramString, MenuItem paramMenuItem, int paramInt)
    {
      AppMethodBeat.i(293886);
      kotlin.g.b.s.u(paramVipCardListUI, "this$0");
      kotlin.g.b.s.u(paramString, "$cardId");
      if (paramMenuItem.getItemId() == 1)
      {
        VipCardListUI.g(paramVipCardListUI, paramString);
        com.tencent.mm.plugin.report.service.h.OAn.b(19747, new Object[] { Integer.valueOf(1), Integer.valueOf(4) });
      }
      AppMethodBeat.o(293886);
    }
    
    private static final void a(j paramj, VipCardListUI paramVipCardListUI, View paramView)
    {
      AppMethodBeat.i(293859);
      Object localObject = new Object();
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.cH(paramj);
      localb.cH(paramVipCardListUI);
      localb.cH(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/card/ui/v3/VipCardListUI$VipCardConverter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
      kotlin.g.b.s.u(paramj, "$holder");
      kotlin.g.b.s.u(paramVipCardListUI, "this$0");
      paramj = (VipCardListUI.b)paramj.CSA;
      paramView = paramj.doB();
      if (paramView.Zcl == 1) {
        com.tencent.mm.plugin.card.c.b.a((MMActivity)paramVipCardListUI.getContext(), paramView.Zcm, 0);
      }
      for (;;)
      {
        paramView = com.tencent.mm.plugin.report.service.h.OAn;
        long l = System.currentTimeMillis() / 1000L;
        localObject = paramj.doB().YBH;
        paramj = paramj.doB().YBH;
        kotlin.g.b.s.s(paramj, "vipCardConvertData.vipCardInfo.user_card_id");
        paramView.b(19748, new Object[] { Integer.valueOf(1), Long.valueOf(l), localObject, Integer.valueOf(VipCardListUI.f(paramVipCardListUI, paramj)), Integer.valueOf(0) });
        com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/card/ui/v3/VipCardListUI$VipCardConverter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(293859);
        return;
        if (paramView.Zcl == 2)
        {
          com.tencent.mm.plugin.card.c.b.S(paramView.Zcn.VcU, paramView.Zcn.VcV, paramView.Zcn.VQU);
        }
        else
        {
          paramView = paramj.doB().YBH;
          kotlin.g.b.s.s(paramView, "vipCardConvertData.vipCardInfo.user_card_id");
          VipCardListUI.e(paramVipCardListUI, paramView);
        }
      }
    }
    
    private static final boolean a(j paramj, VipCardListUI paramVipCardListUI, c paramc, View paramView)
    {
      AppMethodBeat.i(293879);
      Object localObject = new Object();
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.cH(paramj);
      localb.cH(paramVipCardListUI);
      localb.cH(paramc);
      localb.cH(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/card/ui/v3/VipCardListUI$VipCardConverter", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", localObject, localb.aYj());
      kotlin.g.b.s.u(paramj, "$holder");
      kotlin.g.b.s.u(paramVipCardListUI, "this$0");
      kotlin.g.b.s.u(paramc, "this$1");
      localObject = (VipCardListUI.b)paramj.CSA;
      paramj = new com.tencent.mm.ui.widget.b.a((Context)paramVipCardListUI.getContext(), paramView);
      paramj.agjt = new VipCardListUI.c..ExternalSyntheticLambda1(paramVipCardListUI);
      paramj.GAC = new VipCardListUI.c..ExternalSyntheticLambda4(paramc, (VipCardListUI.b)localObject);
      kotlin.g.b.s.s(paramView, "it");
      paramVipCardListUI = m.eN(paramView);
      paramj.fQ(paramVipCardListUI.x, paramVipCardListUI.y);
      com.tencent.mm.plugin.report.service.h.OAn.b(19747, new Object[] { Integer.valueOf(1), Integer.valueOf(3) });
      com.tencent.mm.hellhoundlib.a.a.a(false, new Object(), "com/tencent/mm/plugin/card/ui/v3/VipCardListUI$VipCardConverter", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
      AppMethodBeat.o(293879);
      return false;
    }
    
    private static final void b(VipCardListUI paramVipCardListUI, com.tencent.mm.ui.base.s params)
    {
      AppMethodBeat.i(293882);
      kotlin.g.b.s.u(paramVipCardListUI, "this$0");
      params.a(1, paramVipCardListUI.getResources().getColor(com.tencent.mm.plugin.card.a.a.red_text_color), (CharSequence)paramVipCardListUI.getString(a.g.app_delete));
      AppMethodBeat.o(293882);
    }
    
    public final void a(RecyclerView paramRecyclerView, j paramj, int paramInt)
    {
      AppMethodBeat.i(293954);
      kotlin.g.b.s.u(paramRecyclerView, "recyclerView");
      kotlin.g.b.s.u(paramj, "holder");
      ((RoundCornerImageView)paramj.UH(a.d.wiW)).oI(com.tencent.mm.cd.a.fromDPToPix((Context)this.wHX.getContext(), 1), this.wHX.getResources().getColor(com.tencent.mm.plugin.card.a.a.White));
      paramj.caK.setOnClickListener(new VipCardListUI.c..ExternalSyntheticLambda0(paramj, this.wHX));
      paramj.caK.setOnLongClickListener(new VipCardListUI.c..ExternalSyntheticLambda2(paramj, this.wHX, this));
      AppMethodBeat.o(293954);
    }
    
    public final int getLayoutId()
    {
      return a.e.wnb;
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
    static final class a
      extends u
      implements kotlin.g.a.a<ah>
    {
      a(VipCardListUI paramVipCardListUI, MemberCardTopCropImageView paramMemberCardTopCropImageView, VipCardListUI.b paramb)
      {
        super();
      }
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/GetMemberCardHomePageResponse;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends u
    implements kotlin.g.a.b<b.a<cnh>, ah>
  {
    e(VipCardListUI paramVipCardListUI, boolean paramBoolean)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/card/ui/v3/VipCardListUI$initView$1", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "getItemConvert", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "type", "", "plugin-card_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class f
    implements g
  {
    f(VipCardListUI paramVipCardListUI) {}
    
    public final com.tencent.mm.view.recyclerview.f<?> yF(int paramInt)
    {
      AppMethodBeat.i(293850);
      com.tencent.mm.view.recyclerview.f localf = (com.tencent.mm.view.recyclerview.f)new VipCardListUI.c(this.wHX);
      AppMethodBeat.o(293850);
      return localf;
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/card/ui/v3/VipCardListUI$initView$2", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback2;", "onLoadMoreBegin", "", "loadMoreType", "", "onLoadMoreEnd", "reason", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;", "", "plugin-card_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class g
    extends RefreshLoadMoreLayout.b
  {
    g(VipCardListUI paramVipCardListUI) {}
    
    public final void a(RefreshLoadMoreLayout.d<Object> paramd)
    {
      AppMethodBeat.i(293841);
      kotlin.g.b.s.u(paramd, "reason");
      Log.d(VipCardListUI.a(this.wHX), kotlin.g.b.s.X("on load more end: ", Integer.valueOf(VipCardListUI.c(this.wHX))));
      if (VipCardListUI.d(this.wHX))
      {
        RefreshLoadMoreLayout localRefreshLoadMoreLayout = VipCardListUI.e(this.wHX);
        paramd = localRefreshLoadMoreLayout;
        if (localRefreshLoadMoreLayout == null)
        {
          kotlin.g.b.s.bIx("mRefreshLayout");
          paramd = null;
        }
        paramd.m(null);
      }
      AppMethodBeat.o(293841);
    }
    
    public final void qI(int paramInt)
    {
      AppMethodBeat.i(293838);
      Log.d(VipCardListUI.a(this.wHX), "on load more");
      d.uiThread((kotlin.g.a.a)new a(this.wHX));
      AppMethodBeat.o(293838);
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
    static final class a
      extends u
      implements kotlin.g.a.a<ah>
    {
      a(VipCardListUI paramVipCardListUI)
      {
        super();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.v3.VipCardListUI
 * JD-Core Version:    0.7.0.1
 */