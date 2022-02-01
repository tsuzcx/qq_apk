package com.tencent.mm.plugin.card.ui.v4;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Point;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ah;
import androidx.lifecycle.ai;
import androidx.lifecycle.q;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.b;
import androidx.recyclerview.widget.RecyclerView.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.widget.recyclerview.LoadMoreRecyclerView;
import com.tencent.mm.plugin.card.a.a;
import com.tencent.mm.plugin.card.a.b;
import com.tencent.mm.plugin.card.a.c;
import com.tencent.mm.plugin.card.a.d;
import com.tencent.mm.plugin.card.a.e;
import com.tencent.mm.plugin.card.a.f;
import com.tencent.mm.plugin.card.a.g;
import com.tencent.mm.plugin.card.c.l;
import com.tencent.mm.plugin.card.c.m;
import com.tencent.mm.plugin.card.ui.CardDetailUI;
import com.tencent.mm.plugin.card.ui.v2.CardNewBaseUI;
import com.tencent.mm.protocal.protobuf.vt;
import com.tencent.mm.protocal.protobuf.vx;
import com.tencent.mm.protocal.protobuf.wg;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.w;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.widget.a.f;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.p;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/card/ui/v4/CouponAndGiftCardListV4UI;", "Lcom/tencent/mm/plugin/card/ui/v2/CardNewBaseUI;", "()V", "TAG", "", "mCardsCardListAdapter", "Lcom/tencent/mm/plugin/card/ui/v4/CardsAndOffersAdapter;", "mCouponCardListRv", "Lcom/tencent/mm/plugin/appbrand/widget/recyclerview/LoadMoreRecyclerView;", "mEmptyView", "Landroid/view/ViewGroup;", "mProgressDialog", "Lcom/tencent/mm/ui/base/MMProgressDialog;", "mViewModel", "Lcom/tencent/mm/plugin/card/ui/v4/CouponAndGiftCardListViewModel;", "needForceRefresh", "", "bindData", "", "doItemClick", "getLayoutId", "", "gotoCardDetailUI", "position", "gotoCouponHistoryCardListUI", "title", "initView", "jumpToNextPage", "item", "Lcom/tencent/mm/protocal/protobuf/CardHomePageFAQItem;", "loadSnapshot", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onFinishLocationThings", "ret", "isLocationOk", "onResume", "saveSnapshot", "showDeleteCardAlert", "Landroid/view/View;", "showDeleteConfirmDialog", "model", "Lcom/tencent/mm/plugin/card/ui/v4/CardDataModel;", "showFetchCardListTips", "fetchState", "Lcom/tencent/mm/plugin/card/ui/v4/FetchCardListState;", "showProgressDialog", "isShow", "(Ljava/lang/Boolean;)V", "superImportUIComponents", "set", "Ljava/util/HashSet;", "Ljava/lang/Class;", "Lcom/tencent/mm/ui/component/UIComponent;", "updateCardListView", "data", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "updateIconMenu", "iconMenuData", "", "CouponAndGiftCardListV4UIAccessibilityConfig", "plugin-card_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class CouponAndGiftCardListV4UI
  extends CardNewBaseUI
{
  private final String TAG = "MicroMsg.CouponAndGiftCardListV4UI";
  private w lKp;
  private ViewGroup wGH;
  private LoadMoreRecyclerView wIr;
  private e wIs;
  private c wIt;
  private boolean wIu;
  
  private static final void a(CouponAndGiftCardListV4UI paramCouponAndGiftCardListV4UI, ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
  {
    AppMethodBeat.i(294431);
    kotlin.g.b.s.u(paramCouponAndGiftCardListV4UI, "this$0");
    paramContextMenu.add(0, 1, 0, (CharSequence)paramCouponAndGiftCardListV4UI.getString(a.g.app_delete));
    AppMethodBeat.o(294431);
  }
  
  private static final void a(CouponAndGiftCardListV4UI paramCouponAndGiftCardListV4UI, MenuItem paramMenuItem, int paramInt)
  {
    AppMethodBeat.i(294406);
    kotlin.g.b.s.u(paramCouponAndGiftCardListV4UI, "this$0");
    paramMenuItem = paramCouponAndGiftCardListV4UI.wIs;
    paramCouponAndGiftCardListV4UI = paramMenuItem;
    if (paramMenuItem == null)
    {
      kotlin.g.b.s.bIx("mViewModel");
      paramCouponAndGiftCardListV4UI = null;
    }
    paramCouponAndGiftCardListV4UI.IK(paramInt);
    AppMethodBeat.o(294406);
  }
  
  private static final void a(CouponAndGiftCardListV4UI paramCouponAndGiftCardListV4UI, RecyclerView paramRecyclerView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(294315);
    kotlin.g.b.s.u(paramCouponAndGiftCardListV4UI, "this$0");
    paramView = paramCouponAndGiftCardListV4UI.wIt;
    paramRecyclerView = paramView;
    if (paramView == null)
    {
      kotlin.g.b.s.bIx("mCardsCardListAdapter");
      paramRecyclerView = null;
    }
    paramRecyclerView = paramRecyclerView.IJ(paramInt);
    if (paramRecyclerView != null) {
      switch (paramRecyclerView.type)
      {
      default: 
        paramInt = -1;
        paramView = paramRecyclerView.wIa;
        if (paramView != null)
        {
          Log.i(paramCouponAndGiftCardListV4UI.TAG, "go to card detail ui, cardIndex: " + paramInt + ", cardID: " + paramView.YBH + ", cardType: " + paramView.Zcl);
          com.tencent.mm.plugin.report.service.h.OAn.b(19748, new Object[] { Integer.valueOf(3), Long.valueOf(System.currentTimeMillis() / 1000L), paramView.YBH, Integer.valueOf(paramInt), Integer.valueOf(0) });
          switch (paramView.Zcl)
          {
          default: 
            paramRecyclerView = new Intent((Context)paramCouponAndGiftCardListV4UI.getContext(), CardDetailUI.class);
            paramRecyclerView.putExtra("key_card_id", paramView.YBH);
            paramRecyclerView.addFlags(131072);
            paramRecyclerView.putExtra("key_from_scene", 3);
            paramView = paramCouponAndGiftCardListV4UI.getContext();
            paramRecyclerView = new com.tencent.mm.hellhoundlib.b.a().cG(paramRecyclerView);
            com.tencent.mm.hellhoundlib.a.a.b(paramView, paramRecyclerView.aYi(), "com/tencent/mm/plugin/card/ui/v4/CouponAndGiftCardListV4UI", "gotoCardDetailUI", "(I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            paramView.startActivity((Intent)paramRecyclerView.sb(0));
            com.tencent.mm.hellhoundlib.a.a.c(paramView, "com/tencent/mm/plugin/card/ui/v4/CouponAndGiftCardListV4UI", "gotoCardDetailUI", "(I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          }
        }
        break;
      }
    }
    for (;;)
    {
      paramCouponAndGiftCardListV4UI.wIu = true;
      AppMethodBeat.o(294315);
      return;
      paramInt -= 2;
      break;
      paramInt -= 1;
      break;
      com.tencent.mm.plugin.card.c.b.a((MMActivity)paramCouponAndGiftCardListV4UI.getContext(), paramView.Zcm, 0);
      continue;
      paramRecyclerView = paramView.Zcn;
      if (paramRecyclerView != null) {
        com.tencent.mm.plugin.card.c.b.S(paramRecyclerView.VcU, paramRecyclerView.VcV, paramRecyclerView.VQU);
      }
    }
  }
  
  private static final void a(CouponAndGiftCardListV4UI paramCouponAndGiftCardListV4UI, LoadMoreRecyclerView paramLoadMoreRecyclerView, RecyclerView.a parama)
  {
    AppMethodBeat.i(294294);
    kotlin.g.b.s.u(paramCouponAndGiftCardListV4UI, "this$0");
    parama = paramCouponAndGiftCardListV4UI.wIs;
    paramLoadMoreRecyclerView = parama;
    if (parama == null)
    {
      kotlin.g.b.s.bIx("mViewModel");
      paramLoadMoreRecyclerView = null;
    }
    paramLoadMoreRecyclerView.c((com.tencent.mm.vending.e.b)paramCouponAndGiftCardListV4UI);
    AppMethodBeat.o(294294);
  }
  
  private static final void a(CouponAndGiftCardListV4UI paramCouponAndGiftCardListV4UI, a parama, MenuItem paramMenuItem, int paramInt)
  {
    AppMethodBeat.i(294448);
    kotlin.g.b.s.u(paramCouponAndGiftCardListV4UI, "this$0");
    paramMenuItem = new f((Context)paramCouponAndGiftCardListV4UI.getContext(), 1, true);
    TextView localTextView = new TextView((Context)paramCouponAndGiftCardListV4UI.getContext());
    localTextView.setText((CharSequence)paramCouponAndGiftCardListV4UI.getString(a.g.woS));
    localTextView.setTextSize(1, 14.0F);
    localTextView.setTextColor(paramCouponAndGiftCardListV4UI.getResources().getColor(a.a.half_alpha_black));
    localTextView.setGravity(17);
    paramInt = paramCouponAndGiftCardListV4UI.getResources().getDimensionPixelSize(a.b.Edge_A);
    int i = paramCouponAndGiftCardListV4UI.getResources().getDimensionPixelSize(a.b.Edge_2A);
    localTextView.setPadding(paramInt, i, paramInt, i);
    paramMenuItem.af((View)localTextView, false);
    paramMenuItem.Vtg = new CouponAndGiftCardListV4UI..ExternalSyntheticLambda11(paramCouponAndGiftCardListV4UI);
    paramMenuItem.GAC = new CouponAndGiftCardListV4UI..ExternalSyntheticLambda15(paramCouponAndGiftCardListV4UI, parama);
    paramMenuItem.dDn();
    AppMethodBeat.o(294448);
  }
  
  private static final void a(CouponAndGiftCardListV4UI paramCouponAndGiftCardListV4UI, g paramg)
  {
    Object localObject = null;
    CharSequence localCharSequence = null;
    AppMethodBeat.i(294378);
    kotlin.g.b.s.u(paramCouponAndGiftCardListV4UI, "this$0");
    if (paramg != null) {}
    switch (b.$EnumSwitchMapping$0[paramg.ordinal()])
    {
    default: 
      AppMethodBeat.o(294378);
      return;
    case 1: 
      localCharSequence = (CharSequence)paramg.msg;
      if ((localCharSequence == null) || (localCharSequence.length() == 0)) {}
      for (int i = 1; i != 0; i = 0)
      {
        l.as((Context)paramCouponAndGiftCardListV4UI.getContext(), "");
        AppMethodBeat.o(294378);
        return;
      }
      l.ar((Context)paramCouponAndGiftCardListV4UI.getContext(), paramg.msg);
      AppMethodBeat.o(294378);
      return;
    case 2: 
      paramCouponAndGiftCardListV4UI = paramCouponAndGiftCardListV4UI.wIr;
      if (paramCouponAndGiftCardListV4UI == null)
      {
        kotlin.g.b.s.bIx("mCouponCardListRv");
        paramCouponAndGiftCardListV4UI = localCharSequence;
      }
      for (;;)
      {
        paramCouponAndGiftCardListV4UI.showLoading(false);
        AppMethodBeat.o(294378);
        return;
      }
    }
    paramCouponAndGiftCardListV4UI = paramCouponAndGiftCardListV4UI.wIr;
    if (paramCouponAndGiftCardListV4UI == null)
    {
      kotlin.g.b.s.bIx("mCouponCardListRv");
      paramCouponAndGiftCardListV4UI = localObject;
    }
    for (;;)
    {
      paramCouponAndGiftCardListV4UI.showLoading(true);
      break;
    }
  }
  
  private static final void a(CouponAndGiftCardListV4UI paramCouponAndGiftCardListV4UI, vx paramvx)
  {
    AppMethodBeat.i(294351);
    kotlin.g.b.s.u(paramCouponAndGiftCardListV4UI, "this$0");
    if (paramvx != null) {
      switch (paramvx.ZcL)
      {
      }
    }
    for (;;)
    {
      AppMethodBeat.o(294351);
      return;
      paramvx = paramvx.ZcM;
      if (paramvx != null)
      {
        com.tencent.mm.plugin.card.c.b.a((MMActivity)paramCouponAndGiftCardListV4UI, paramvx, 0);
        AppMethodBeat.o(294351);
        return;
        paramCouponAndGiftCardListV4UI = paramvx.ZcN;
        if (paramCouponAndGiftCardListV4UI != null)
        {
          com.tencent.mm.plugin.card.c.b.S(paramCouponAndGiftCardListV4UI.VcU, paramCouponAndGiftCardListV4UI.VcV, paramCouponAndGiftCardListV4UI.VQU);
          AppMethodBeat.o(294351);
          return;
          String str = paramvx.ZcO;
          if ((str != null) && (kotlin.g.b.s.p(str, "weixin://mktcard/couponv2history")))
          {
            str = paramvx.ZcK;
            Log.i(paramCouponAndGiftCardListV4UI.TAG, kotlin.g.b.s.X("go to coupon history card list: title ", str));
            paramvx = new Intent((Context)paramCouponAndGiftCardListV4UI.getContext(), HistoryCardListUI.class);
            paramvx.putExtra("title", str);
            paramvx.putExtra("card_type", 2);
            paramCouponAndGiftCardListV4UI = paramCouponAndGiftCardListV4UI.getContext();
            paramvx = new com.tencent.mm.hellhoundlib.b.a().cG(paramvx);
            com.tencent.mm.hellhoundlib.a.a.b(paramCouponAndGiftCardListV4UI, paramvx.aYi(), "com/tencent/mm/plugin/card/ui/v4/CouponAndGiftCardListV4UI", "gotoCouponHistoryCardListUI", "(Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            paramCouponAndGiftCardListV4UI.startActivity((Intent)paramvx.sb(0));
            com.tencent.mm.hellhoundlib.a.a.c(paramCouponAndGiftCardListV4UI, "com/tencent/mm/plugin/card/ui/v4/CouponAndGiftCardListV4UI", "gotoCouponHistoryCardListUI", "(Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            com.tencent.mm.plugin.report.service.h.OAn.b(19747, new Object[] { Integer.valueOf(3), Integer.valueOf(2) });
          }
        }
      }
    }
  }
  
  private static final void a(CouponAndGiftCardListV4UI paramCouponAndGiftCardListV4UI, com.tencent.mm.ui.base.s params)
  {
    AppMethodBeat.i(294462);
    kotlin.g.b.s.u(paramCouponAndGiftCardListV4UI, "this$0");
    params.a(1, paramCouponAndGiftCardListV4UI.getResources().getColor(a.a.red_text_color), (CharSequence)paramCouponAndGiftCardListV4UI.getString(a.g.app_delete));
    AppMethodBeat.o(294462);
  }
  
  private static final void a(CouponAndGiftCardListV4UI paramCouponAndGiftCardListV4UI, Boolean paramBoolean)
  {
    AppMethodBeat.i(294387);
    kotlin.g.b.s.u(paramCouponAndGiftCardListV4UI, "this$0");
    if (paramBoolean != null) {
      if (!paramBoolean.booleanValue()) {
        break label59;
      }
    }
    for (paramBoolean = w.a((Context)paramCouponAndGiftCardListV4UI.getContext(), (CharSequence)paramCouponAndGiftCardListV4UI.getString(a.g.app_waiting), true, 3, null);; paramBoolean = null)
    {
      paramCouponAndGiftCardListV4UI.lKp = paramBoolean;
      AppMethodBeat.o(294387);
      return;
      label59:
      paramBoolean = paramCouponAndGiftCardListV4UI.lKp;
      if (paramBoolean != null) {
        paramBoolean.dismiss();
      }
    }
  }
  
  private static final void a(CouponAndGiftCardListV4UI paramCouponAndGiftCardListV4UI, ArrayList paramArrayList)
  {
    ViewGroup localViewGroup = null;
    Object localObject1 = null;
    AppMethodBeat.i(294362);
    kotlin.g.b.s.u(paramCouponAndGiftCardListV4UI, "this$0");
    Object localObject2 = (Collection)paramArrayList;
    int i;
    if ((localObject2 == null) || (((Collection)localObject2).isEmpty()))
    {
      i = 1;
      if (i == 0) {
        break label109;
      }
      localViewGroup = paramCouponAndGiftCardListV4UI.wGH;
      paramArrayList = localViewGroup;
      if (localViewGroup == null)
      {
        kotlin.g.b.s.bIx("mEmptyView");
        paramArrayList = null;
      }
      paramArrayList.setVisibility(0);
      paramCouponAndGiftCardListV4UI = paramCouponAndGiftCardListV4UI.wIt;
      if (paramCouponAndGiftCardListV4UI != null) {
        break label106;
      }
      kotlin.g.b.s.bIx("mCardsCardListAdapter");
      paramCouponAndGiftCardListV4UI = localObject1;
    }
    label106:
    for (;;)
    {
      paramCouponAndGiftCardListV4UI.bZE.notifyChanged();
      AppMethodBeat.o(294362);
      return;
      i = 0;
      break;
    }
    label109:
    localObject2 = paramCouponAndGiftCardListV4UI.wGH;
    localObject1 = localObject2;
    if (localObject2 == null)
    {
      kotlin.g.b.s.bIx("mEmptyView");
      localObject1 = null;
    }
    localObject1.setVisibility(8);
    paramCouponAndGiftCardListV4UI = paramCouponAndGiftCardListV4UI.wIt;
    if (paramCouponAndGiftCardListV4UI == null)
    {
      kotlin.g.b.s.bIx("mCardsCardListAdapter");
      paramCouponAndGiftCardListV4UI = localViewGroup;
    }
    for (;;)
    {
      paramCouponAndGiftCardListV4UI.U(paramArrayList);
      AppMethodBeat.o(294362);
      return;
    }
  }
  
  private static final void a(CouponAndGiftCardListV4UI paramCouponAndGiftCardListV4UI, List paramList)
  {
    AppMethodBeat.i(294339);
    kotlin.g.b.s.u(paramCouponAndGiftCardListV4UI, "this$0");
    Collection localCollection = (Collection)paramList;
    if ((localCollection == null) || (localCollection.isEmpty())) {}
    for (int i = 1;; i = 0)
    {
      if (i == 0)
      {
        paramCouponAndGiftCardListV4UI.removeAllOptionMenu();
        paramCouponAndGiftCardListV4UI.addIconOptionMenu(0, 0, a.f.icons_outlined_more, new CouponAndGiftCardListV4UI..ExternalSyntheticLambda1(paramCouponAndGiftCardListV4UI, paramList));
      }
      AppMethodBeat.o(294339);
      return;
    }
  }
  
  private static final boolean a(CouponAndGiftCardListV4UI paramCouponAndGiftCardListV4UI, MenuItem paramMenuItem)
  {
    AppMethodBeat.i(294283);
    kotlin.g.b.s.u(paramCouponAndGiftCardListV4UI, "this$0");
    paramCouponAndGiftCardListV4UI.finish();
    AppMethodBeat.o(294283);
    return false;
  }
  
  private static final boolean a(CouponAndGiftCardListV4UI paramCouponAndGiftCardListV4UI, List paramList, MenuItem paramMenuItem)
  {
    AppMethodBeat.i(294419);
    kotlin.g.b.s.u(paramCouponAndGiftCardListV4UI, "this$0");
    kotlin.g.b.s.u(paramList, "$this_apply");
    paramMenuItem = new f((Context)paramCouponAndGiftCardListV4UI.getContext(), 1, false);
    paramMenuItem.Vtg = new CouponAndGiftCardListV4UI..ExternalSyntheticLambda12(paramList);
    paramMenuItem.GAC = new CouponAndGiftCardListV4UI..ExternalSyntheticLambda13(paramCouponAndGiftCardListV4UI);
    paramMenuItem.dDn();
    com.tencent.mm.plugin.report.service.h.OAn.b(19747, new Object[] { Integer.valueOf(3), Integer.valueOf(1) });
    AppMethodBeat.o(294419);
    return false;
  }
  
  private static final void b(CouponAndGiftCardListV4UI paramCouponAndGiftCardListV4UI, a parama, MenuItem paramMenuItem, int paramInt)
  {
    AppMethodBeat.i(294471);
    kotlin.g.b.s.u(paramCouponAndGiftCardListV4UI, "this$0");
    kotlin.g.b.s.u(parama, "$model");
    if (paramMenuItem.getItemId() == 1)
    {
      paramMenuItem = paramCouponAndGiftCardListV4UI.wIs;
      paramCouponAndGiftCardListV4UI = paramMenuItem;
      if (paramMenuItem == null)
      {
        kotlin.g.b.s.bIx("mViewModel");
        paramCouponAndGiftCardListV4UI = null;
      }
      paramCouponAndGiftCardListV4UI.a(parama);
    }
    AppMethodBeat.o(294471);
  }
  
  private static final void b(List paramList, com.tencent.mm.ui.base.s params)
  {
    AppMethodBeat.i(294398);
    kotlin.g.b.s.u(paramList, "$this_apply");
    paramList = ((Iterable)paramList).iterator();
    int i = 0;
    while (paramList.hasNext())
    {
      Object localObject = paramList.next();
      if (i < 0) {
        p.kkW();
      }
      params.add(0, i, 1, (CharSequence)((vx)localObject).ZcK);
      i += 1;
    }
    AppMethodBeat.o(294398);
  }
  
  private static final boolean b(CouponAndGiftCardListV4UI paramCouponAndGiftCardListV4UI, RecyclerView paramRecyclerView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(294331);
    kotlin.g.b.s.u(paramCouponAndGiftCardListV4UI, "this$0");
    kotlin.g.b.s.s(paramView, "view");
    Object localObject = paramCouponAndGiftCardListV4UI.wIt;
    paramRecyclerView = (RecyclerView)localObject;
    if (localObject == null)
    {
      kotlin.g.b.s.bIx("mCardsCardListAdapter");
      paramRecyclerView = null;
    }
    localObject = paramRecyclerView.IJ(paramInt);
    if (localObject != null) {
      switch (((a)localObject).type)
      {
      }
    }
    for (;;)
    {
      AppMethodBeat.o(294331);
      return false;
      paramRecyclerView = new com.tencent.mm.ui.widget.b.a((Context)paramCouponAndGiftCardListV4UI.getContext(), paramView);
      paramRecyclerView.agjt = new CouponAndGiftCardListV4UI..ExternalSyntheticLambda2(paramCouponAndGiftCardListV4UI);
      paramRecyclerView.GAC = new CouponAndGiftCardListV4UI..ExternalSyntheticLambda14(paramCouponAndGiftCardListV4UI, (a)localObject);
      paramCouponAndGiftCardListV4UI = m.eN(paramView);
      paramRecyclerView.fQ(paramCouponAndGiftCardListV4UI.x, paramCouponAndGiftCardListV4UI.y);
      com.tencent.mm.plugin.report.service.h.OAn.b(19747, new Object[] { Integer.valueOf(3), Integer.valueOf(3) });
    }
  }
  
  public final void at(int paramInt, boolean paramBoolean) {}
  
  public final int getLayoutId()
  {
    return a.e.wnP;
  }
  
  public final void initView()
  {
    AppMethodBeat.i(294512);
    Object localObject1 = findViewById(a.d.wjS);
    kotlin.g.b.s.s(localObject1, "findViewById(R.id.ctlu_rv)");
    this.wIr = ((LoadMoreRecyclerView)localObject1);
    localObject1 = findViewById(a.d.wih);
    kotlin.g.b.s.s(localObject1, "findViewById(R.id.chpe_root_layout)");
    this.wGH = ((ViewGroup)localObject1);
    localObject1 = this.wIr;
    label141:
    label217:
    int i;
    if (localObject1 == null)
    {
      kotlin.g.b.s.bIx("mCouponCardListRv");
      localObject1 = null;
      getContext();
      ((LoadMoreRecyclerView)localObject1).setLayoutManager((RecyclerView.LayoutManager)new LinearLayoutManager(1, false));
      this.wIt = new c();
      Object localObject2 = this.wIt;
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        kotlin.g.b.s.bIx("mCardsCardListAdapter");
        localObject1 = null;
      }
      ((c)localObject1).bf(true);
      localObject1 = this.wIr;
      if (localObject1 != null) {
        break label378;
      }
      kotlin.g.b.s.bIx("mCouponCardListRv");
      localObject1 = null;
      Object localObject3 = this.wIt;
      localObject2 = localObject3;
      if (localObject3 == null)
      {
        kotlin.g.b.s.bIx("mCardsCardListAdapter");
        localObject2 = null;
      }
      ((LoadMoreRecyclerView)localObject1).setAdapter((RecyclerView.a)localObject2);
      localObject2 = new androidx.recyclerview.widget.h((Context)getContext(), 1);
      ((androidx.recyclerview.widget.h)localObject2).w(getResources().getDrawable(a.c.weq));
      localObject1 = this.wIr;
      if (localObject1 != null) {
        break label381;
      }
      kotlin.g.b.s.bIx("mCouponCardListRv");
      localObject1 = null;
      ((RecyclerView)localObject1).a((RecyclerView.h)localObject2);
      localObject2 = this.wIr;
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        kotlin.g.b.s.bIx("mCouponCardListRv");
        localObject1 = null;
      }
      ((LoadMoreRecyclerView)localObject1).setLoadingView(a.e.wmP);
      localObject1 = this.wIr;
      if (localObject1 != null) {
        break label384;
      }
      kotlin.g.b.s.bIx("mCouponCardListRv");
      localObject1 = null;
      label268:
      localObject3 = this.wGH;
      localObject2 = localObject3;
      if (localObject3 == null)
      {
        kotlin.g.b.s.bIx("mEmptyView");
        localObject2 = null;
      }
      ((LoadMoreRecyclerView)localObject1).setEmptyView((View)localObject2);
      localObject1 = getIntent().getStringExtra("title");
      localObject2 = (CharSequence)localObject1;
      if ((localObject2 != null) && (((CharSequence)localObject2).length() != 0)) {
        break label387;
      }
      i = 1;
      label329:
      if (i != 0) {
        break label392;
      }
      setMMTitle((String)localObject1);
    }
    for (;;)
    {
      setActionbarColor(getResources().getColor(a.a.BG_0));
      hideActionbarLine();
      setBackBtn(new CouponAndGiftCardListV4UI..ExternalSyntheticLambda0(this));
      AppMethodBeat.o(294512);
      return;
      break;
      label378:
      break label141;
      label381:
      break label217;
      label384:
      break label268;
      label387:
      i = 0;
      break label329;
      label392:
      setMMTitle(a.g.wou);
    }
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    Object localObject1 = null;
    AppMethodBeat.i(294511);
    super.onCreate(paramBundle);
    initView();
    Object localObject2 = this.wIr;
    paramBundle = (Bundle)localObject2;
    if (localObject2 == null)
    {
      kotlin.g.b.s.bIx("mCouponCardListRv");
      paramBundle = null;
    }
    paramBundle.setOnLoadingStateChangedListener(new CouponAndGiftCardListV4UI..ExternalSyntheticLambda8(this));
    localObject2 = this.wIr;
    paramBundle = (Bundle)localObject2;
    if (localObject2 == null)
    {
      kotlin.g.b.s.bIx("mCouponCardListRv");
      paramBundle = null;
    }
    paramBundle.setOnItemClickListener(new CouponAndGiftCardListV4UI..ExternalSyntheticLambda9(this));
    localObject2 = this.wIr;
    paramBundle = (Bundle)localObject2;
    if (localObject2 == null)
    {
      kotlin.g.b.s.bIx("mCouponCardListRv");
      paramBundle = null;
    }
    paramBundle.setOnItemLongClickListener(new CouponAndGiftCardListV4UI..ExternalSyntheticLambda10(this));
    paramBundle = ai.a((FragmentActivity)this, null).q(e.class);
    kotlin.g.b.s.s(paramBundle, "of(this).get(CouponAndGi…istViewModel::class.java)");
    this.wIs = ((e)paramBundle);
    localObject2 = this.wIs;
    paramBundle = (Bundle)localObject2;
    if (localObject2 == null)
    {
      kotlin.g.b.s.bIx("mViewModel");
      paramBundle = null;
    }
    ((LiveData)paramBundle.wIm).a((q)this, new CouponAndGiftCardListV4UI..ExternalSyntheticLambda7(this));
    localObject2 = this.wIs;
    paramBundle = (Bundle)localObject2;
    if (localObject2 == null)
    {
      kotlin.g.b.s.bIx("mViewModel");
      paramBundle = null;
    }
    ((LiveData)paramBundle.wIn).a((q)this, new CouponAndGiftCardListV4UI..ExternalSyntheticLambda4(this));
    localObject2 = this.wIs;
    paramBundle = (Bundle)localObject2;
    if (localObject2 == null)
    {
      kotlin.g.b.s.bIx("mViewModel");
      paramBundle = null;
    }
    ((LiveData)paramBundle.wIo).a((q)this, new CouponAndGiftCardListV4UI..ExternalSyntheticLambda6(this));
    localObject2 = this.wIs;
    paramBundle = (Bundle)localObject2;
    if (localObject2 == null)
    {
      kotlin.g.b.s.bIx("mViewModel");
      paramBundle = null;
    }
    ((LiveData)paramBundle.wIp).a((q)this, new CouponAndGiftCardListV4UI..ExternalSyntheticLambda3(this));
    localObject2 = this.wIs;
    paramBundle = (Bundle)localObject2;
    if (localObject2 == null)
    {
      kotlin.g.b.s.bIx("mViewModel");
      paramBundle = null;
    }
    ((LiveData)paramBundle.wIq).a((q)this, new CouponAndGiftCardListV4UI..ExternalSyntheticLambda5(this));
    localObject2 = this.wIs;
    paramBundle = (Bundle)localObject2;
    if (localObject2 == null)
    {
      kotlin.g.b.s.bIx("mViewModel");
      paramBundle = null;
    }
    paramBundle.doC();
    paramBundle = this.wIs;
    if (paramBundle == null)
    {
      kotlin.g.b.s.bIx("mViewModel");
      paramBundle = localObject1;
    }
    for (;;)
    {
      paramBundle.d((com.tencent.mm.vending.e.b)this);
      AppMethodBeat.o(294511);
      return;
    }
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(294520);
    super.onDestroy();
    e locale2 = this.wIs;
    e locale1 = locale2;
    if (locale2 == null)
    {
      kotlin.g.b.s.bIx("mViewModel");
      locale1 = null;
    }
    locale1.doD();
    AppMethodBeat.o(294520);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(294515);
    e locale;
    if (this.wIu)
    {
      locale = this.wIs;
      if (locale != null) {
        break label53;
      }
      kotlin.g.b.s.bIx("mViewModel");
      locale = null;
    }
    label53:
    for (;;)
    {
      locale.d((com.tencent.mm.vending.e.b)this);
      this.wIu = false;
      super.onResume();
      AppMethodBeat.o(294515);
      return;
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public final void superImportUIComponents(HashSet<Class<? extends UIComponent>> paramHashSet)
  {
    AppMethodBeat.i(294530);
    kotlin.g.b.s.u(paramHashSet, "set");
    super.superImportUIComponents(paramHashSet);
    paramHashSet.add(CouponAndGiftCardListV4UI.a.class);
    AppMethodBeat.o(294530);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.v4.CouponAndGiftCardListV4UI
 * JD-Core Version:    0.7.0.1
 */