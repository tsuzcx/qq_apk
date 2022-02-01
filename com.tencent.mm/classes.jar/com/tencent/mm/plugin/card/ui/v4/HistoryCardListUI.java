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
import com.tencent.mm.ui.widget.imageview.WeImageView;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.p;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/card/ui/v4/HistoryCardListUI;", "Lcom/tencent/mm/plugin/card/ui/v2/CardNewBaseUI;", "()V", "mCardType", "", "mEmptyView", "Landroid/view/ViewGroup;", "mHistoryCardListAdapter", "Lcom/tencent/mm/plugin/card/ui/v4/CardsAndOffersAdapter;", "mHistoryCardListRv", "Lcom/tencent/mm/plugin/appbrand/widget/recyclerview/LoadMoreRecyclerView;", "mProgressDialog", "Lcom/tencent/mm/ui/base/MMProgressDialog;", "mViewModel", "Lcom/tencent/mm/plugin/card/ui/v4/CardsViewModel;", "bindData", "", "doItemClick", "getLayoutId", "gotoCardDetailUI", "position", "initDeleteDialog", "model", "Lcom/tencent/mm/plugin/card/ui/v4/CardDataModel;", "initView", "jumpToNextPage", "item", "Lcom/tencent/mm/protocal/protobuf/CardHomePageFAQItem;", "loadSnapshot", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onFinishLocationThings", "ret", "isLocationOk", "", "saveSnapshot", "showDeleteCardMenu", "Landroid/view/View;", "showFetchCardListTips", "fetchState", "Lcom/tencent/mm/plugin/card/ui/v4/FetchCardListState;", "showProgressDialog", "isShow", "(Ljava/lang/Boolean;)V", "superImportUIComponents", "set", "Ljava/util/HashSet;", "Ljava/lang/Class;", "Lcom/tencent/mm/ui/component/UIComponent;", "updateCardListView", "data", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "updateIconMenu", "iconMenuData", "", "Companion", "HistoryCardListUIAccessibilityConfig", "plugin-card_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class HistoryCardListUI
  extends CardNewBaseUI
{
  public static final HistoryCardListUI.a wIP;
  private w lKp;
  private ViewGroup wGH;
  private LoadMoreRecyclerView wIQ;
  private d wIR;
  private c wIS;
  private int wIT = 1;
  
  static
  {
    AppMethodBeat.i(294409);
    wIP = new HistoryCardListUI.a((byte)0);
    AppMethodBeat.o(294409);
  }
  
  private static final void a(HistoryCardListUI paramHistoryCardListUI, ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
  {
    AppMethodBeat.i(294395);
    kotlin.g.b.s.u(paramHistoryCardListUI, "this$0");
    paramContextMenu.add(0, 1, 0, (CharSequence)paramHistoryCardListUI.getString(a.g.app_delete));
    AppMethodBeat.o(294395);
  }
  
  private static final void a(HistoryCardListUI paramHistoryCardListUI, MenuItem paramMenuItem, int paramInt)
  {
    AppMethodBeat.i(294367);
    kotlin.g.b.s.u(paramHistoryCardListUI, "this$0");
    paramMenuItem = paramHistoryCardListUI.wIR;
    paramHistoryCardListUI = paramMenuItem;
    if (paramMenuItem == null)
    {
      kotlin.g.b.s.bIx("mViewModel");
      paramHistoryCardListUI = null;
    }
    paramHistoryCardListUI.IK(paramInt);
    AppMethodBeat.o(294367);
  }
  
  private static final void a(HistoryCardListUI paramHistoryCardListUI, RecyclerView paramRecyclerView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(294346);
    kotlin.g.b.s.u(paramHistoryCardListUI, "this$0");
    paramView = paramHistoryCardListUI.wIS;
    paramRecyclerView = paramView;
    if (paramView == null)
    {
      kotlin.g.b.s.bIx("mHistoryCardListAdapter");
      paramRecyclerView = null;
    }
    paramRecyclerView = paramRecyclerView.IJ(paramInt);
    int i;
    if (paramRecyclerView != null)
    {
      paramRecyclerView = paramRecyclerView.wIa;
      if (paramRecyclerView != null) {
        switch (paramRecyclerView.Zcl)
        {
        default: 
          Object localObject = new Intent((Context)paramHistoryCardListUI.getContext(), CardDetailUI.class);
          ((Intent)localObject).putExtra("key_card_id", paramRecyclerView.YBH);
          ((Intent)localObject).addFlags(131072);
          ((Intent)localObject).putExtra("key_from_scene", 3);
          paramView = paramHistoryCardListUI.getContext();
          localObject = new com.tencent.mm.hellhoundlib.b.a().cG(localObject);
          com.tencent.mm.hellhoundlib.a.a.b(paramView, ((com.tencent.mm.hellhoundlib.b.a)localObject).aYi(), "com/tencent/mm/plugin/card/ui/v4/HistoryCardListUI", "gotoCardDetailUI", "(I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sb(0));
          com.tencent.mm.hellhoundlib.a.a.c(paramView, "com/tencent/mm/plugin/card/ui/v4/HistoryCardListUI", "gotoCardDetailUI", "(I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          switch (paramHistoryCardListUI.wIT)
          {
          default: 
            i = 2;
          }
          break;
        }
      }
    }
    for (;;)
    {
      Log.i("MicroMsg.HistoryCardListUI", "go to card detail ui, cardIndex: " + paramInt + ", cardID: " + paramRecyclerView.YBH + ", pageScene: " + i + ", cardType: " + paramRecyclerView.Zcl);
      com.tencent.mm.plugin.report.service.h.OAn.b(21329, new Object[] { Integer.valueOf(i), Integer.valueOf(1), paramRecyclerView.YBH, Integer.valueOf(paramInt) });
      AppMethodBeat.o(294346);
      return;
      com.tencent.mm.plugin.card.c.b.a((MMActivity)paramHistoryCardListUI.getContext(), paramRecyclerView.Zcm, 0);
      break;
      paramView = paramRecyclerView.Zcn;
      if (paramView == null) {
        break;
      }
      com.tencent.mm.plugin.card.c.b.S(paramView.VcU, paramView.VcV, paramView.VQU);
      break;
      i = 2;
      continue;
      i = 1;
    }
  }
  
  private static final void a(HistoryCardListUI paramHistoryCardListUI, LoadMoreRecyclerView paramLoadMoreRecyclerView, RecyclerView.a parama)
  {
    AppMethodBeat.i(294336);
    kotlin.g.b.s.u(paramHistoryCardListUI, "this$0");
    parama = paramHistoryCardListUI.wIR;
    paramLoadMoreRecyclerView = parama;
    if (parama == null)
    {
      kotlin.g.b.s.bIx("mViewModel");
      paramLoadMoreRecyclerView = null;
    }
    paramLoadMoreRecyclerView.c((com.tencent.mm.vending.e.b)paramHistoryCardListUI);
    AppMethodBeat.o(294336);
  }
  
  private static final void a(HistoryCardListUI paramHistoryCardListUI, a parama, int paramInt1, MenuItem paramMenuItem, int paramInt2)
  {
    AppMethodBeat.i(294388);
    kotlin.g.b.s.u(paramHistoryCardListUI, "this$0");
    kotlin.g.b.s.u(parama, "$model");
    if (paramMenuItem.getItemId() == 1) {
      switch (paramHistoryCardListUI.wIT)
      {
      default: 
        paramInt2 = 2;
        paramMenuItem = parama.wIa;
        if (paramMenuItem == null) {
          paramMenuItem = "";
        }
        break;
      }
    }
    for (;;)
    {
      Log.i("MicroMsg.HistoryCardListUI", "delete card, cardIndex: " + paramInt1 + ", cardID: " + paramMenuItem + ", pageScene: " + paramInt2);
      com.tencent.mm.plugin.report.service.h.OAn.b(21329, new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(1), paramMenuItem, Integer.valueOf(paramInt1) });
      paramMenuItem = paramHistoryCardListUI.wIR;
      paramHistoryCardListUI = paramMenuItem;
      if (paramMenuItem == null)
      {
        kotlin.g.b.s.bIx("mViewModel");
        paramHistoryCardListUI = null;
      }
      paramHistoryCardListUI.a(parama);
      AppMethodBeat.o(294388);
      return;
      paramInt2 = 2;
      break;
      paramInt2 = 1;
      break;
      String str = paramMenuItem.YBH;
      paramMenuItem = str;
      if (str == null) {
        paramMenuItem = "";
      }
    }
  }
  
  private static final void a(HistoryCardListUI paramHistoryCardListUI, g paramg)
  {
    Object localObject = null;
    CharSequence localCharSequence = null;
    AppMethodBeat.i(294319);
    kotlin.g.b.s.u(paramHistoryCardListUI, "this$0");
    if (paramg != null) {}
    switch (c.$EnumSwitchMapping$0[paramg.ordinal()])
    {
    default: 
      AppMethodBeat.o(294319);
      return;
    case 1: 
      localCharSequence = (CharSequence)paramg.msg;
      if ((localCharSequence == null) || (localCharSequence.length() == 0)) {}
      for (int i = 1; i != 0; i = 0)
      {
        l.as((Context)paramHistoryCardListUI.getContext(), "");
        AppMethodBeat.o(294319);
        return;
      }
      l.ar((Context)paramHistoryCardListUI.getContext(), paramg.msg);
      AppMethodBeat.o(294319);
      return;
    case 2: 
      paramHistoryCardListUI = paramHistoryCardListUI.wIQ;
      if (paramHistoryCardListUI == null)
      {
        kotlin.g.b.s.bIx("mHistoryCardListRv");
        paramHistoryCardListUI = localCharSequence;
      }
      for (;;)
      {
        paramHistoryCardListUI.showLoading(false);
        AppMethodBeat.o(294319);
        return;
      }
    }
    paramHistoryCardListUI = paramHistoryCardListUI.wIQ;
    if (paramHistoryCardListUI == null)
    {
      kotlin.g.b.s.bIx("mHistoryCardListRv");
      paramHistoryCardListUI = localObject;
    }
    for (;;)
    {
      paramHistoryCardListUI.showLoading(true);
      break;
    }
  }
  
  private static final void a(HistoryCardListUI paramHistoryCardListUI, vx paramvx)
  {
    AppMethodBeat.i(294303);
    kotlin.g.b.s.u(paramHistoryCardListUI, "this$0");
    if (paramvx != null) {
      switch (paramvx.ZcL)
      {
      }
    }
    for (;;)
    {
      AppMethodBeat.o(294303);
      return;
      paramvx = paramvx.ZcM;
      if (paramvx != null)
      {
        com.tencent.mm.plugin.card.c.b.a((MMActivity)paramHistoryCardListUI, paramvx, 0);
        AppMethodBeat.o(294303);
        return;
        paramHistoryCardListUI = paramvx.ZcN;
        if (paramHistoryCardListUI != null) {
          com.tencent.mm.plugin.card.c.b.S(paramHistoryCardListUI.VcU, paramHistoryCardListUI.VcV, paramHistoryCardListUI.VQU);
        }
      }
    }
  }
  
  private static final void a(HistoryCardListUI paramHistoryCardListUI, com.tencent.mm.ui.base.s params)
  {
    AppMethodBeat.i(294381);
    kotlin.g.b.s.u(paramHistoryCardListUI, "this$0");
    params.a(1, paramHistoryCardListUI.getResources().getColor(a.a.red_text_color), (CharSequence)paramHistoryCardListUI.getString(a.g.app_delete));
    AppMethodBeat.o(294381);
  }
  
  private static final void a(HistoryCardListUI paramHistoryCardListUI, Boolean paramBoolean)
  {
    AppMethodBeat.i(294328);
    kotlin.g.b.s.u(paramHistoryCardListUI, "this$0");
    if (paramBoolean != null) {
      if (!paramBoolean.booleanValue()) {
        break label59;
      }
    }
    for (paramBoolean = w.a((Context)paramHistoryCardListUI.getContext(), (CharSequence)paramHistoryCardListUI.getString(a.g.app_waiting), true, 3, null);; paramBoolean = null)
    {
      paramHistoryCardListUI.lKp = paramBoolean;
      AppMethodBeat.o(294328);
      return;
      label59:
      paramBoolean = paramHistoryCardListUI.lKp;
      if (paramBoolean != null) {
        paramBoolean.dismiss();
      }
    }
  }
  
  private static final void a(HistoryCardListUI paramHistoryCardListUI, ArrayList paramArrayList)
  {
    ViewGroup localViewGroup = null;
    Object localObject1 = null;
    AppMethodBeat.i(294313);
    kotlin.g.b.s.u(paramHistoryCardListUI, "this$0");
    Object localObject2 = (Collection)paramArrayList;
    int i;
    if ((localObject2 == null) || (((Collection)localObject2).isEmpty()))
    {
      i = 1;
      if (i == 0) {
        break label109;
      }
      localViewGroup = paramHistoryCardListUI.wGH;
      paramArrayList = localViewGroup;
      if (localViewGroup == null)
      {
        kotlin.g.b.s.bIx("mEmptyView");
        paramArrayList = null;
      }
      paramArrayList.setVisibility(0);
      paramHistoryCardListUI = paramHistoryCardListUI.wIS;
      if (paramHistoryCardListUI != null) {
        break label106;
      }
      kotlin.g.b.s.bIx("mHistoryCardListAdapter");
      paramHistoryCardListUI = localObject1;
    }
    label106:
    for (;;)
    {
      paramHistoryCardListUI.bZE.notifyChanged();
      AppMethodBeat.o(294313);
      return;
      i = 0;
      break;
    }
    label109:
    localObject2 = paramHistoryCardListUI.wGH;
    localObject1 = localObject2;
    if (localObject2 == null)
    {
      kotlin.g.b.s.bIx("mEmptyView");
      localObject1 = null;
    }
    localObject1.setVisibility(8);
    paramHistoryCardListUI = paramHistoryCardListUI.wIS;
    if (paramHistoryCardListUI == null)
    {
      kotlin.g.b.s.bIx("mHistoryCardListAdapter");
      paramHistoryCardListUI = localViewGroup;
    }
    for (;;)
    {
      paramHistoryCardListUI.U(paramArrayList);
      AppMethodBeat.o(294313);
      return;
    }
  }
  
  private static final void a(HistoryCardListUI paramHistoryCardListUI, List paramList)
  {
    AppMethodBeat.i(294297);
    kotlin.g.b.s.u(paramHistoryCardListUI, "this$0");
    Collection localCollection = (Collection)paramList;
    if ((localCollection == null) || (localCollection.isEmpty())) {}
    for (int i = 1;; i = 0)
    {
      if (i == 0)
      {
        paramHistoryCardListUI.removeAllOptionMenu();
        paramHistoryCardListUI.addIconOptionMenu(0, 0, a.f.icons_outlined_more, new HistoryCardListUI..ExternalSyntheticLambda1(paramHistoryCardListUI, paramList));
      }
      AppMethodBeat.o(294297);
      return;
    }
  }
  
  private static final boolean a(HistoryCardListUI paramHistoryCardListUI, MenuItem paramMenuItem)
  {
    AppMethodBeat.i(294290);
    kotlin.g.b.s.u(paramHistoryCardListUI, "this$0");
    paramHistoryCardListUI.finish();
    AppMethodBeat.o(294290);
    return false;
  }
  
  private static final boolean a(HistoryCardListUI paramHistoryCardListUI, List paramList, MenuItem paramMenuItem)
  {
    AppMethodBeat.i(294375);
    kotlin.g.b.s.u(paramHistoryCardListUI, "this$0");
    kotlin.g.b.s.u(paramList, "$this_apply");
    paramMenuItem = new com.tencent.mm.ui.widget.a.f((Context)paramHistoryCardListUI.getContext(), 1, false);
    paramMenuItem.Vtg = new HistoryCardListUI..ExternalSyntheticLambda12(paramList);
    paramMenuItem.GAC = new HistoryCardListUI..ExternalSyntheticLambda13(paramHistoryCardListUI);
    paramMenuItem.dDn();
    AppMethodBeat.o(294375);
    return false;
  }
  
  private static final void b(HistoryCardListUI paramHistoryCardListUI, a parama, int paramInt1, MenuItem paramMenuItem, int paramInt2)
  {
    AppMethodBeat.i(294405);
    kotlin.g.b.s.u(paramHistoryCardListUI, "this$0");
    paramMenuItem = new com.tencent.mm.ui.widget.a.f((Context)paramHistoryCardListUI.getContext(), 1, true);
    TextView localTextView = new TextView((Context)paramHistoryCardListUI.getContext());
    localTextView.setText((CharSequence)paramHistoryCardListUI.getString(a.g.woS));
    localTextView.setTextSize(1, 14.0F);
    localTextView.setTextColor(paramHistoryCardListUI.getResources().getColor(a.a.half_alpha_black));
    localTextView.setGravity(17);
    paramInt2 = paramHistoryCardListUI.getResources().getDimensionPixelSize(a.b.Edge_A);
    int i = paramHistoryCardListUI.getResources().getDimensionPixelSize(a.b.Edge_2A);
    localTextView.setPadding(paramInt2, i, paramInt2, i);
    paramMenuItem.af((View)localTextView, false);
    paramMenuItem.Vtg = new HistoryCardListUI..ExternalSyntheticLambda11(paramHistoryCardListUI);
    paramMenuItem.GAC = new HistoryCardListUI..ExternalSyntheticLambda15(paramHistoryCardListUI, parama, paramInt1);
    paramMenuItem.dDn();
    AppMethodBeat.o(294405);
  }
  
  private static final boolean b(HistoryCardListUI paramHistoryCardListUI, RecyclerView paramRecyclerView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(294352);
    kotlin.g.b.s.u(paramHistoryCardListUI, "this$0");
    kotlin.g.b.s.s(paramView, "view");
    Object localObject = paramHistoryCardListUI.wIS;
    paramRecyclerView = (RecyclerView)localObject;
    if (localObject == null)
    {
      kotlin.g.b.s.bIx("mHistoryCardListAdapter");
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
      AppMethodBeat.o(294352);
      return false;
      paramRecyclerView = new com.tencent.mm.ui.widget.b.a((Context)paramHistoryCardListUI.getContext(), paramView);
      paramRecyclerView.agjt = new HistoryCardListUI..ExternalSyntheticLambda2(paramHistoryCardListUI);
      paramRecyclerView.GAC = new HistoryCardListUI..ExternalSyntheticLambda14(paramHistoryCardListUI, (a)localObject, paramInt);
      paramHistoryCardListUI = m.eN(paramView);
      paramRecyclerView.fQ(paramHistoryCardListUI.x, paramHistoryCardListUI.y);
    }
  }
  
  private static final void c(List paramList, com.tencent.mm.ui.base.s params)
  {
    AppMethodBeat.i(294359);
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
    AppMethodBeat.o(294359);
  }
  
  public final void at(int paramInt, boolean paramBoolean) {}
  
  public final int getLayoutId()
  {
    return a.e.wnP;
  }
  
  public final void initView()
  {
    AppMethodBeat.i(294496);
    Object localObject1 = findViewById(a.d.wjS);
    kotlin.g.b.s.s(localObject1, "findViewById(R.id.ctlu_rv)");
    this.wIQ = ((LoadMoreRecyclerView)localObject1);
    localObject1 = findViewById(a.d.wih);
    kotlin.g.b.s.s(localObject1, "findViewById(R.id.chpe_root_layout)");
    this.wGH = ((ViewGroup)localObject1);
    TextView localTextView = (TextView)findViewById(a.d.wii);
    localObject1 = (WeImageView)findViewById(a.d.wig);
    ((WeImageView)localObject1).setImageResource(a.f.icon_history_card_empty);
    ((WeImageView)localObject1).setIconColor(getResources().getColor(a.a.FG_2));
    localObject1 = this.wIQ;
    label186:
    int i;
    if (localObject1 == null)
    {
      kotlin.g.b.s.bIx("mHistoryCardListRv");
      localObject1 = null;
      getContext();
      ((LoadMoreRecyclerView)localObject1).setLayoutManager((RecyclerView.LayoutManager)new LinearLayoutManager(1, false));
      this.wIS = new c(true);
      Object localObject2 = this.wIS;
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        kotlin.g.b.s.bIx("mHistoryCardListAdapter");
        localObject1 = null;
      }
      ((c)localObject1).bf(true);
      localObject1 = this.wIQ;
      if (localObject1 != null) {
        break label446;
      }
      kotlin.g.b.s.bIx("mHistoryCardListRv");
      localObject1 = null;
      Object localObject3 = this.wIS;
      localObject2 = localObject3;
      if (localObject3 == null)
      {
        kotlin.g.b.s.bIx("mHistoryCardListAdapter");
        localObject2 = null;
      }
      ((LoadMoreRecyclerView)localObject1).setAdapter((RecyclerView.a)localObject2);
      localObject2 = new androidx.recyclerview.widget.h((Context)getContext(), 1);
      ((androidx.recyclerview.widget.h)localObject2).w(getResources().getDrawable(a.c.weq));
      localObject1 = this.wIQ;
      if (localObject1 != null) {
        break label449;
      }
      kotlin.g.b.s.bIx("mHistoryCardListRv");
      localObject1 = null;
      label262:
      ((RecyclerView)localObject1).a((RecyclerView.h)localObject2);
      localObject2 = this.wIQ;
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        kotlin.g.b.s.bIx("mHistoryCardListRv");
        localObject1 = null;
      }
      ((LoadMoreRecyclerView)localObject1).setLoadingView(a.e.wmP);
      localObject1 = this.wIQ;
      if (localObject1 != null) {
        break label452;
      }
      kotlin.g.b.s.bIx("mHistoryCardListRv");
      localObject1 = null;
      label313:
      localObject3 = this.wGH;
      localObject2 = localObject3;
      if (localObject3 == null)
      {
        kotlin.g.b.s.bIx("mEmptyView");
        localObject2 = null;
      }
      ((LoadMoreRecyclerView)localObject1).setEmptyView((View)localObject2);
      localTextView.setText(a.g.woU);
      localObject1 = getIntent().getStringExtra("title");
      this.wIT = getIntent().getIntExtra("card_type", 2);
      localObject2 = (CharSequence)localObject1;
      if ((localObject2 != null) && (((CharSequence)localObject2).length() != 0)) {
        break label455;
      }
      i = 1;
      label397:
      if (i != 0) {
        break label460;
      }
      setMMTitle((String)localObject1);
    }
    for (;;)
    {
      setActionbarColor(getResources().getColor(a.a.BG_0));
      hideActionbarLine();
      setBackBtn(new HistoryCardListUI..ExternalSyntheticLambda0(this));
      AppMethodBeat.o(294496);
      return;
      break;
      label446:
      break label186;
      label449:
      break label262;
      label452:
      break label313;
      label455:
      i = 0;
      break label397;
      label460:
      setMMTitle(a.g.wqN);
    }
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    Object localObject1 = null;
    AppMethodBeat.i(294493);
    super.onCreate(paramBundle);
    initView();
    Object localObject2 = this.wIQ;
    paramBundle = (Bundle)localObject2;
    if (localObject2 == null)
    {
      kotlin.g.b.s.bIx("mHistoryCardListRv");
      paramBundle = null;
    }
    paramBundle.setOnLoadingStateChangedListener(new HistoryCardListUI..ExternalSyntheticLambda8(this));
    localObject2 = this.wIQ;
    paramBundle = (Bundle)localObject2;
    if (localObject2 == null)
    {
      kotlin.g.b.s.bIx("mHistoryCardListRv");
      paramBundle = null;
    }
    paramBundle.setOnItemClickListener(new HistoryCardListUI..ExternalSyntheticLambda9(this));
    localObject2 = this.wIQ;
    paramBundle = (Bundle)localObject2;
    if (localObject2 == null)
    {
      kotlin.g.b.s.bIx("mHistoryCardListRv");
      paramBundle = null;
    }
    paramBundle.setOnItemLongClickListener(new HistoryCardListUI..ExternalSyntheticLambda10(this));
    switch (this.wIT)
    {
    default: 
      paramBundle = ai.a((FragmentActivity)this, null).q(f.class);
      kotlin.g.b.s.s(paramBundle, "{\n                ViewMo…class.java)\n            }");
      paramBundle = (d)paramBundle;
      this.wIR = paramBundle;
      localObject2 = this.wIR;
      paramBundle = (Bundle)localObject2;
      if (localObject2 == null)
      {
        kotlin.g.b.s.bIx("mViewModel");
        paramBundle = null;
      }
      ((LiveData)paramBundle.wIm).a((q)this, new HistoryCardListUI..ExternalSyntheticLambda7(this));
      localObject2 = this.wIR;
      paramBundle = (Bundle)localObject2;
      if (localObject2 == null)
      {
        kotlin.g.b.s.bIx("mViewModel");
        paramBundle = null;
      }
      ((LiveData)paramBundle.wIn).a((q)this, new HistoryCardListUI..ExternalSyntheticLambda4(this));
      localObject2 = this.wIR;
      paramBundle = (Bundle)localObject2;
      if (localObject2 == null)
      {
        kotlin.g.b.s.bIx("mViewModel");
        paramBundle = null;
      }
      ((LiveData)paramBundle.wIo).a((q)this, new HistoryCardListUI..ExternalSyntheticLambda6(this));
      localObject2 = this.wIR;
      paramBundle = (Bundle)localObject2;
      if (localObject2 == null)
      {
        kotlin.g.b.s.bIx("mViewModel");
        paramBundle = null;
      }
      ((LiveData)paramBundle.wIp).a((q)this, new HistoryCardListUI..ExternalSyntheticLambda3(this));
      localObject2 = this.wIR;
      paramBundle = (Bundle)localObject2;
      if (localObject2 == null)
      {
        kotlin.g.b.s.bIx("mViewModel");
        paramBundle = null;
      }
      ((LiveData)paramBundle.wIq).a((q)this, new HistoryCardListUI..ExternalSyntheticLambda5(this));
      localObject2 = this.wIR;
      paramBundle = (Bundle)localObject2;
      if (localObject2 == null)
      {
        kotlin.g.b.s.bIx("mViewModel");
        paramBundle = null;
      }
      paramBundle.doC();
      paramBundle = this.wIR;
      if (paramBundle == null)
      {
        kotlin.g.b.s.bIx("mViewModel");
        paramBundle = localObject1;
      }
      break;
    }
    for (;;)
    {
      paramBundle.d((com.tencent.mm.vending.e.b)this);
      AppMethodBeat.o(294493);
      return;
      paramBundle = ai.a((FragmentActivity)this, null).q(f.class);
      kotlin.g.b.s.s(paramBundle, "{\n                ViewMo…class.java)\n            }");
      paramBundle = (d)paramBundle;
      break;
      paramBundle = ai.a((FragmentActivity)this, null).q(i.class);
      kotlin.g.b.s.s(paramBundle, "{\n                ViewMo…class.java)\n            }");
      paramBundle = (d)paramBundle;
      break;
    }
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(294498);
    super.onDestroy();
    d locald2 = this.wIR;
    d locald1 = locald2;
    if (locald2 == null)
    {
      kotlin.g.b.s.bIx("mViewModel");
      locald1 = null;
    }
    locald1.doD();
    AppMethodBeat.o(294498);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public final void superImportUIComponents(HashSet<Class<? extends UIComponent>> paramHashSet)
  {
    AppMethodBeat.i(294501);
    kotlin.g.b.s.u(paramHashSet, "set");
    super.superImportUIComponents(paramHashSet);
    paramHashSet.add(HistoryCardListUI.b.class);
    AppMethodBeat.o(294501);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.v4.HistoryCardListUI
 * JD-Core Version:    0.7.0.1
 */