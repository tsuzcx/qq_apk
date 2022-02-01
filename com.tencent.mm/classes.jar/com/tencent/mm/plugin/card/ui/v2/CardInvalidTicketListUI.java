package com.tencent.mm.plugin.card.ui.v2;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Point;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.b.a;
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
import com.tencent.mm.protocal.protobuf.ajj;
import com.tencent.mm.protocal.protobuf.cnp;
import com.tencent.mm.protocal.protobuf.eal;
import com.tencent.mm.protocal.protobuf.eao;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.base.w;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.n.d;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/card/ui/v2/CardInvalidTicketListUI;", "Lcom/tencent/mm/plugin/card/ui/v2/CardNewBaseUI;", "()V", "firstLoad", "", "isAll", "isLoading", "isShowClearBtn", "mInvalidTicketList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/card/ui/v2/CardTicketListModel;", "mProgressDialog", "Lcom/tencent/mm/ui/base/MMProgressDialog;", "mTicketAdapter", "Lcom/tencent/mm/plugin/card/ui/v2/CardTicketAdapter;", "getMTicketAdapter", "()Lcom/tencent/mm/plugin/card/ui/v2/CardTicketAdapter;", "setMTicketAdapter", "(Lcom/tencent/mm/plugin/card/ui/v2/CardTicketAdapter;)V", "mTicketRv", "Lcom/tencent/mm/plugin/appbrand/widget/recyclerview/LoadMoreRecyclerView;", "getMTicketRv", "()Lcom/tencent/mm/plugin/appbrand/widget/recyclerview/LoadMoreRecyclerView;", "setMTicketRv", "(Lcom/tencent/mm/plugin/appbrand/widget/recyclerview/LoadMoreRecyclerView;)V", "offset", "", "reqNum", "doClearInvalidTicketList", "", "doDeleteInvalidTicket", "cardId", "", "doGetInvalidTicketHomePage", "getLayoutId", "gotoCardDetailUI", "initView", "invalidTicketIds", "loadSnapshot", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onFinishLocationThings", "ret", "isLocationOk", "saveSnapshot", "showDeleteCardAlert", "ticketElement", "Lcom/tencent/mm/protocal/protobuf/PageTicketElement;", "item", "Landroid/view/View;", "showDeleteConfirmDialog", "showProgressDialog", "isShow", "(Ljava/lang/Boolean;)V", "updateModelList", "ticketList", "Lcom/tencent/mm/protocal/protobuf/PageTicketList;", "updateOptionMenu", "Companion", "plugin-card_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class CardInvalidTicketListUI
  extends CardNewBaseUI
{
  public static final CardInvalidTicketListUI.a wGm;
  private boolean isLoading;
  private w lKp;
  private boolean mgS;
  private int offset;
  private int wFo;
  private boolean wFp;
  public LoadMoreRecyclerView wGn;
  public a wGo;
  private ArrayList<b> wGp;
  private boolean wGq;
  
  static
  {
    AppMethodBeat.i(112498);
    wGm = new CardInvalidTicketListUI.a((byte)0);
    AppMethodBeat.o(112498);
  }
  
  public CardInvalidTicketListUI()
  {
    AppMethodBeat.i(112497);
    this.wGp = new ArrayList();
    this.wFo = 10;
    this.mgS = true;
    AppMethodBeat.o(112497);
  }
  
  private static final Object a(CardInvalidTicketListUI paramCardInvalidTicketListUI, b.a parama)
  {
    AppMethodBeat.i(294306);
    kotlin.g.b.s.u(paramCardInvalidTicketListUI, "this$0");
    Log.i("MicroMsg.CardInvalidTicketListUI", "errtype: %s, errcode: %s", new Object[] { Integer.valueOf(parama.errType), Integer.valueOf(parama.errCode) });
    paramCardInvalidTicketListUI.isLoading = false;
    if ((parama.errType == 0) && (parama.errCode == 0))
    {
      parama = parama.ott;
      cnp localcnp = (cnp)parama;
      Log.i("MicroMsg.CardInvalidTicketListUI", "retCode: %s", new Object[] { Integer.valueOf(localcnp.wuz) });
      boolean bool;
      if (localcnp.wuz == 0)
      {
        paramCardInvalidTicketListUI.offset = localcnp.xlj;
        if (localcnp.aaqL == 1)
        {
          bool = true;
          paramCardInvalidTicketListUI.wFp = bool;
          if (localcnp.aauV != 1) {
            break label255;
          }
          bool = true;
          label132:
          paramCardInvalidTicketListUI.wGq = bool;
          Log.i("MicroMsg.CardInvalidTicketListUI", "update clear btn: %s", new Object[] { Boolean.valueOf(paramCardInvalidTicketListUI.wGq) });
          if (!paramCardInvalidTicketListUI.wGq) {
            break label269;
          }
          paramCardInvalidTicketListUI.addTextOptionMenu(0, paramCardInvalidTicketListUI.getString(a.g.card_clear), new CardInvalidTicketListUI..ExternalSyntheticLambda2(paramCardInvalidTicketListUI));
          if (!paramCardInvalidTicketListUI.wGp.isEmpty()) {
            break label260;
          }
          paramCardInvalidTicketListUI.enableOptionMenu(0, false);
          label201:
          if (!paramCardInvalidTicketListUI.wFp) {
            break label278;
          }
          paramCardInvalidTicketListUI.doj().showLoading(false);
          label216:
          if (paramCardInvalidTicketListUI.mgS)
          {
            paramCardInvalidTicketListUI.wGp.clear();
            paramCardInvalidTicketListUI.mgS = false;
          }
          paramCardInvalidTicketListUI.a(localcnp.aauU);
        }
      }
      for (;;)
      {
        AppMethodBeat.o(294306);
        return parama;
        bool = false;
        break;
        label255:
        bool = false;
        break label132;
        label260:
        paramCardInvalidTicketListUI.enableOptionMenu(0, true);
        break label201;
        label269:
        paramCardInvalidTicketListUI.removeOptionMenu(0);
        break label201;
        label278:
        paramCardInvalidTicketListUI.doj().showLoading(true);
        break label216;
        if (paramCardInvalidTicketListUI.mgS) {
          paramCardInvalidTicketListUI.mgS = false;
        }
        l.ar((Context)paramCardInvalidTicketListUI, localcnp.wuA);
      }
    }
    if (paramCardInvalidTicketListUI.mgS) {
      paramCardInvalidTicketListUI.mgS = false;
    }
    l.as((Context)paramCardInvalidTicketListUI, "");
    paramCardInvalidTicketListUI = ah.aiuX;
    AppMethodBeat.o(294306);
    return paramCardInvalidTicketListUI;
  }
  
  private static final ah a(CardInvalidTicketListUI paramCardInvalidTicketListUI, String paramString, b.a parama)
  {
    AppMethodBeat.i(294349);
    kotlin.g.b.s.u(paramCardInvalidTicketListUI, "this$0");
    kotlin.g.b.s.u(paramString, "$cardId");
    Log.i("MicroMsg.CardInvalidTicketListUI", "errtype: %s, errcode: %s", new Object[] { Integer.valueOf(parama.errType), Integer.valueOf(parama.errCode) });
    if ((parama.errType == 0) && (parama.errCode == 0))
    {
      parama = (ajj)parama.ott;
      Log.i("MicroMsg.CardInvalidTicketListUI", "retCode: %s", new Object[] { Integer.valueOf(parama.wuz) });
      if (parama.wuz == 0) {
        paramCardInvalidTicketListUI.dok().alf(paramString);
      }
    }
    for (;;)
    {
      paramCardInvalidTicketListUI.p(Boolean.FALSE);
      paramCardInvalidTicketListUI = ah.aiuX;
      AppMethodBeat.o(294349);
      return paramCardInvalidTicketListUI;
      l.ar((Context)paramCardInvalidTicketListUI, parama.wuA);
      continue;
      l.as((Context)paramCardInvalidTicketListUI, "");
    }
  }
  
  private static final void a(CardInvalidTicketListUI paramCardInvalidTicketListUI, DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(294317);
    kotlin.g.b.s.u(paramCardInvalidTicketListUI, "this$0");
    Log.i("MicroMsg.CardInvalidTicketListUI", "do clear invalid ticket list");
    com.tencent.mm.plugin.report.service.h.OAn.b(16322, new Object[] { Integer.valueOf(11) });
    AppMethodBeat.o(294317);
  }
  
  private static final void a(CardInvalidTicketListUI paramCardInvalidTicketListUI, ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
  {
    AppMethodBeat.i(294249);
    kotlin.g.b.s.u(paramCardInvalidTicketListUI, "this$0");
    paramContextMenu.add(0, 1, 0, (CharSequence)paramCardInvalidTicketListUI.getString(a.g.app_delete));
    AppMethodBeat.o(294249);
  }
  
  private static final void a(CardInvalidTicketListUI paramCardInvalidTicketListUI, RecyclerView paramRecyclerView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(294234);
    kotlin.g.b.s.u(paramCardInvalidTicketListUI, "this$0");
    Log.i("MicroMsg.CardInvalidTicketListUI", "click item");
    paramRecyclerView = paramCardInvalidTicketListUI.dok().IG(paramInt);
    if ((paramRecyclerView != null) && (paramRecyclerView.type == 2))
    {
      paramRecyclerView = paramRecyclerView.wGE;
      if (paramRecyclerView != null)
      {
        paramRecyclerView = paramRecyclerView.YBH;
        kotlin.g.b.s.s(paramRecyclerView, "user_card_id");
        Log.i("MicroMsg.CardTicketListUI", "go to card detail: %s", new Object[] { paramRecyclerView });
        paramView = new Intent((Context)paramCardInvalidTicketListUI.getContext(), CardDetailUI.class);
        paramView.putExtra("key_card_id", paramRecyclerView);
        paramView.addFlags(131072);
        paramView.putExtra("key_from_scene", 3);
        paramCardInvalidTicketListUI.getContext().startActivityForResult(paramView, 256);
      }
    }
    AppMethodBeat.o(294234);
  }
  
  private static final void a(CardInvalidTicketListUI paramCardInvalidTicketListUI, LoadMoreRecyclerView paramLoadMoreRecyclerView, RecyclerView.a parama)
  {
    AppMethodBeat.i(294230);
    kotlin.g.b.s.u(paramCardInvalidTicketListUI, "this$0");
    paramCardInvalidTicketListUI.dol();
    AppMethodBeat.o(294230);
  }
  
  private static final void a(CardInvalidTicketListUI paramCardInvalidTicketListUI, eal parameal, MenuItem paramMenuItem, int paramInt)
  {
    AppMethodBeat.i(294260);
    kotlin.g.b.s.u(paramCardInvalidTicketListUI, "this$0");
    if (parameal != null)
    {
      paramMenuItem = new com.tencent.mm.ui.widget.a.f((Context)paramCardInvalidTicketListUI.getContext(), 1, true);
      TextView localTextView = new TextView((Context)paramCardInvalidTicketListUI.getContext());
      localTextView.setText((CharSequence)paramCardInvalidTicketListUI.getString(a.g.woS));
      localTextView.setTextSize(1, 14.0F);
      localTextView.setTextColor(paramCardInvalidTicketListUI.getResources().getColor(a.a.half_alpha_black));
      localTextView.setGravity(17);
      paramInt = paramCardInvalidTicketListUI.getResources().getDimensionPixelSize(a.b.Edge_A);
      int i = paramCardInvalidTicketListUI.getResources().getDimensionPixelSize(a.b.Edge_2A);
      localTextView.setPadding(paramInt, i, paramInt, i);
      paramMenuItem.af((View)localTextView, false);
      paramMenuItem.Vtg = new CardInvalidTicketListUI..ExternalSyntheticLambda8(paramCardInvalidTicketListUI);
      paramMenuItem.GAC = new CardInvalidTicketListUI..ExternalSyntheticLambda10(paramCardInvalidTicketListUI, parameal);
      paramMenuItem.dDn();
    }
    AppMethodBeat.o(294260);
  }
  
  private static final void a(CardInvalidTicketListUI paramCardInvalidTicketListUI, com.tencent.mm.ui.base.s params)
  {
    AppMethodBeat.i(294272);
    kotlin.g.b.s.u(paramCardInvalidTicketListUI, "this$0");
    params.a(1, paramCardInvalidTicketListUI.getResources().getColor(a.a.red_text_color), (CharSequence)paramCardInvalidTicketListUI.getString(a.g.app_delete));
    AppMethodBeat.o(294272);
  }
  
  private final void a(eao parameao)
  {
    AppMethodBeat.i(112495);
    if (parameao != null)
    {
      Object localObject = parameao.abfQ;
      kotlin.g.b.s.s(localObject, "page_ticket_element");
      if (!((Collection)localObject).isEmpty()) {}
      for (int i = 1; i != 0; i = 0)
      {
        parameao = parameao.abfQ.iterator();
        while (parameao.hasNext())
        {
          localObject = (eal)parameao.next();
          b localb = new b();
          localb.wGE = ((eal)localObject);
          localb.type = 2;
          this.wGp.add(localb);
        }
      }
    }
    dok().a(null, this.wGp, null, null);
    AppMethodBeat.o(112495);
  }
  
  private static final boolean a(CardInvalidTicketListUI paramCardInvalidTicketListUI, MenuItem paramMenuItem)
  {
    AppMethodBeat.i(294221);
    kotlin.g.b.s.u(paramCardInvalidTicketListUI, "this$0");
    paramCardInvalidTicketListUI.finish();
    AppMethodBeat.o(294221);
    return false;
  }
  
  private static final void b(CardInvalidTicketListUI paramCardInvalidTicketListUI, eal parameal, MenuItem paramMenuItem, int paramInt)
  {
    AppMethodBeat.i(294286);
    kotlin.g.b.s.u(paramCardInvalidTicketListUI, "this$0");
    if (paramMenuItem.getItemId() == 1)
    {
      kotlin.g.b.s.checkNotNull(parameal);
      parameal = parameal.YBH;
      kotlin.g.b.s.s(parameal, "ticketElement!!.user_card_id");
      Log.i("MicroMsg.CardInvalidTicketListUI", "do delete ticket: %s", new Object[] { parameal });
      paramCardInvalidTicketListUI.p(Boolean.TRUE);
      new com.tencent.mm.plugin.card.model.a.b(parameal).bFJ().b(new CardInvalidTicketListUI..ExternalSyntheticLambda12(paramCardInvalidTicketListUI, parameal));
    }
    AppMethodBeat.o(294286);
  }
  
  private static final boolean b(CardInvalidTicketListUI paramCardInvalidTicketListUI, MenuItem paramMenuItem)
  {
    AppMethodBeat.i(294338);
    kotlin.g.b.s.u(paramCardInvalidTicketListUI, "this$0");
    k.a((Context)paramCardInvalidTicketListUI.getContext(), false, paramCardInvalidTicketListUI.getString(a.g.wpc), "", paramCardInvalidTicketListUI.getString(a.g.confirm_dialog_ok), paramCardInvalidTicketListUI.getString(a.g.confirm_dialog_cancel), new CardInvalidTicketListUI..ExternalSyntheticLambda0(paramCardInvalidTicketListUI), CardInvalidTicketListUI..ExternalSyntheticLambda1.INSTANCE);
    com.tencent.mm.plugin.report.service.h.OAn.b(16322, new Object[] { Integer.valueOf(10) });
    AppMethodBeat.o(294338);
    return false;
  }
  
  private static final boolean b(CardInvalidTicketListUI paramCardInvalidTicketListUI, RecyclerView paramRecyclerView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(294241);
    kotlin.g.b.s.u(paramCardInvalidTicketListUI, "this$0");
    Log.i("MicroMsg.CardInvalidTicketListUI", "long click item");
    paramRecyclerView = paramCardInvalidTicketListUI.dok().IG(paramInt);
    if ((paramRecyclerView != null) && (paramRecyclerView.type == 2))
    {
      eal localeal = paramRecyclerView.wGE;
      kotlin.g.b.s.s(paramView, "view");
      if (localeal != null)
      {
        paramRecyclerView = new com.tencent.mm.ui.widget.b.a((Context)paramCardInvalidTicketListUI.getContext(), paramView);
        paramRecyclerView.agjt = new CardInvalidTicketListUI..ExternalSyntheticLambda4(paramCardInvalidTicketListUI);
        paramRecyclerView.GAC = new CardInvalidTicketListUI..ExternalSyntheticLambda9(paramCardInvalidTicketListUI, localeal);
        paramCardInvalidTicketListUI = m.eN(paramView);
        paramRecyclerView.fQ(paramCardInvalidTicketListUI.x, paramCardInvalidTicketListUI.y);
      }
    }
    AppMethodBeat.o(294241);
    return false;
  }
  
  private LoadMoreRecyclerView doj()
  {
    AppMethodBeat.i(112489);
    LoadMoreRecyclerView localLoadMoreRecyclerView = this.wGn;
    if (localLoadMoreRecyclerView != null)
    {
      AppMethodBeat.o(112489);
      return localLoadMoreRecyclerView;
    }
    kotlin.g.b.s.bIx("mTicketRv");
    AppMethodBeat.o(112489);
    return null;
  }
  
  private a dok()
  {
    AppMethodBeat.i(112490);
    a locala = this.wGo;
    if (locala != null)
    {
      AppMethodBeat.o(112490);
      return locala;
    }
    kotlin.g.b.s.bIx("mTicketAdapter");
    AppMethodBeat.o(112490);
    return null;
  }
  
  private final void dol()
  {
    AppMethodBeat.i(112496);
    Log.i("MicroMsg.CardInvalidTicketListUI", "do get invalid ticket: %s, %s, %s, %s", new Object[] { Integer.valueOf(this.offset), Integer.valueOf(this.wFo), Boolean.valueOf(this.wFp), Boolean.valueOf(this.isLoading) });
    if ((!this.wFp) && (!this.isLoading))
    {
      this.isLoading = true;
      new com.tencent.mm.plugin.card.model.a.h(this.offset, this.wFo, getLatitude(), getLongitude()).bFJ().b(new CardInvalidTicketListUI..ExternalSyntheticLambda11(this));
    }
    AppMethodBeat.o(112496);
  }
  
  private static final void k(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(294327);
    paramDialogInterface.dismiss();
    com.tencent.mm.plugin.report.service.h.OAn.b(16322, new Object[] { Integer.valueOf(12) });
    AppMethodBeat.o(294327);
  }
  
  private final void p(Boolean paramBoolean)
  {
    AppMethodBeat.i(294183);
    if (paramBoolean == null)
    {
      AppMethodBeat.o(294183);
      return;
    }
    if (paramBoolean.booleanValue()) {}
    for (paramBoolean = w.a((Context)getContext(), (CharSequence)getString(a.g.app_waiting), true, 3, null);; paramBoolean = null)
    {
      this.lKp = paramBoolean;
      AppMethodBeat.o(294183);
      return;
      paramBoolean = this.lKp;
      if (paramBoolean != null) {
        paramBoolean.dismiss();
      }
    }
  }
  
  public final void at(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(112494);
    Log.i("MicroMsg.CardInvalidTicketListUI", "location finish: [%s, %s], ret: %s, isOk: %s", new Object[] { Float.valueOf(getLatitude()), Float.valueOf(getLongitude()), Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean) });
    if (this.mgS)
    {
      dol();
      AppMethodBeat.o(112494);
      return;
    }
    if (!paramBoolean) {
      doo();
    }
    AppMethodBeat.o(112494);
  }
  
  public final int getLayoutId()
  {
    return a.e.wnO;
  }
  
  public final void initView()
  {
    AppMethodBeat.i(112492);
    Object localObject = findViewById(a.d.wjS);
    kotlin.g.b.s.s(localObject, "findViewById(R.id.ctlu_rv)");
    localObject = (LoadMoreRecyclerView)localObject;
    kotlin.g.b.s.u(localObject, "<set-?>");
    this.wGn = ((LoadMoreRecyclerView)localObject);
    localObject = new a(true);
    kotlin.g.b.s.u(localObject, "<set-?>");
    this.wGo = ((a)localObject);
    dok().bf(true);
    doj().setAdapter((RecyclerView.a)dok());
    localObject = doj();
    getContext();
    ((LoadMoreRecyclerView)localObject).setLayoutManager((RecyclerView.LayoutManager)new LinearLayoutManager());
    doj().setEmptyView(findViewById(a.d.wih));
    ((TextView)doj().getEmptyView().findViewById(a.d.wii)).setText((CharSequence)getString(a.g.woU));
    localObject = (WeImageView)doj().getEmptyView().findViewById(a.d.wig);
    ((WeImageView)localObject).setImageResource(a.f.icon_history_card_empty);
    ((WeImageView)localObject).setIconColor(getResources().getColor(a.a.FG_2));
    localObject = new androidx.recyclerview.widget.h((Context)this, 1);
    ((androidx.recyclerview.widget.h)localObject).w(getResources().getDrawable(a.c.weo));
    doj().a((RecyclerView.h)localObject);
    doj().setLoadingView(a.e.wmP);
    doj().setOnLoadingStateChangedListener(new CardInvalidTicketListUI..ExternalSyntheticLambda5(this));
    doj().setOnItemClickListener(new CardInvalidTicketListUI..ExternalSyntheticLambda6(this));
    doj().setOnItemLongClickListener(new CardInvalidTicketListUI..ExternalSyntheticLambda7(this));
    AppMethodBeat.o(112492);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(112491);
    fixStatusbar(true);
    super.onCreate(paramBundle);
    hideActionbarLine();
    initView();
    paramBundle = new eao();
    Object localObject = com.tencent.mm.plugin.card.model.a.a.wvG;
    kotlin.g.b.s.u(paramBundle, "invalidTicketList");
    Log.d(com.tencent.mm.plugin.card.model.a.a.access$getTAG$cp(), "load invalid ticket page snapshot");
    localObject = (String)com.tencent.mm.kernel.h.baE().ban().get(at.a.acXL, null);
    if (localObject != null)
    {
      localObject = ((String)localObject).getBytes(d.ISO_8859_1);
      kotlin.g.b.s.s(localObject, "(this as java.lang.String).getBytes(charset)");
      paramBundle.parseFrom((byte[])localObject);
    }
    a(paramBundle);
    setMMTitle(a.g.wqN);
    setBackBtn(new CardInvalidTicketListUI..ExternalSyntheticLambda3(this));
    com.tencent.mm.plugin.report.service.h.OAn.b(16322, new Object[] { Integer.valueOf(9) });
    AppMethodBeat.o(112491);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(112493);
    super.onDestroy();
    Object localObject1 = new eao();
    ((eao)localObject1).abfQ = new LinkedList();
    Object localObject2 = this.wGp.iterator();
    while (((Iterator)localObject2).hasNext())
    {
      eal localeal = ((b)((Iterator)localObject2).next()).wGE;
      if (localeal != null) {
        ((eao)localObject1).abfQ.add(localeal);
      }
    }
    localObject2 = com.tencent.mm.plugin.card.model.a.a.wvG;
    kotlin.g.b.s.u(localObject1, "invalidTicketList");
    Log.d(com.tencent.mm.plugin.card.model.a.a.access$getTAG$cp(), "save invalid ticket snapshot");
    localObject1 = ((eao)localObject1).toByteArray();
    kotlin.g.b.s.s(localObject1, "invalidTicketList.toByteArray()");
    localObject1 = new String((byte[])localObject1, d.ISO_8859_1);
    com.tencent.mm.kernel.h.baE().ban().set(at.a.acXL, localObject1);
    AppMethodBeat.o(112493);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.v2.CardInvalidTicketListUI
 * JD-Core Version:    0.7.0.1
 */