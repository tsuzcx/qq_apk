package com.tencent.mm.plugin.card.ui.v2;

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
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.b.a;
import com.tencent.mm.plugin.appbrand.api.g;
import com.tencent.mm.plugin.appbrand.service.t;
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
import com.tencent.mm.plugin.card.model.a.c;
import com.tencent.mm.plugin.card.ui.CardDetailUI;
import com.tencent.mm.protocal.protobuf.ajl;
import com.tencent.mm.protocal.protobuf.cnr;
import com.tencent.mm.protocal.protobuf.dnd;
import com.tencent.mm.protocal.protobuf.eal;
import com.tencent.mm.protocal.protobuf.eam;
import com.tencent.mm.protocal.protobuf.ean;
import com.tencent.mm.protocal.protobuf.eao;
import com.tencent.mm.protocal.protobuf.eap;
import com.tencent.mm.protocal.protobuf.esc;
import com.tencent.mm.protocal.protobuf.wg;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.w;
import com.tencent.mm.ui.component.UIComponent;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.n.d;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/card/ui/v2/CardTicketListUI;", "Lcom/tencent/mm/plugin/card/ui/v2/CardNewBaseUI;", "()V", "firstLoad", "", "getMktTicketHomePage", "Lcom/tencent/mm/plugin/card/model/v2/CgiGetMktTicketHomePage;", "isAll", "isLoading", "jumpList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/card/ui/v2/CardTicketListModel;", "licenseList", "mEmptyView", "Landroid/view/ViewGroup;", "mProgressDialog", "Lcom/tencent/mm/ui/base/MMProgressDialog;", "mTicketAdapter", "Lcom/tencent/mm/plugin/card/ui/v2/CardTicketAdapter;", "mTicketRv", "Lcom/tencent/mm/plugin/appbrand/widget/recyclerview/LoadMoreRecyclerView;", "medicareCard", "needRefreshList", "offset", "", "reqNum", "ticketList", "weAppOpenUICallback", "com/tencent/mm/plugin/card/ui/v2/CardTicketListUI$weAppOpenUICallback$1", "Lcom/tencent/mm/plugin/card/ui/v2/CardTicketListUI$weAppOpenUICallback$1;", "adjustFooterView", "", "doDeleteTicket", "cardId", "", "doGetTicketHomePage", "refresh", "getLayoutId", "gotoCardDetailUI", "initView", "loadSnapshot", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onFinishLocationThings", "ret", "isLocationOk", "onResume", "saveSnapshot", "showDeleteCardAlert", "ticketElement", "Lcom/tencent/mm/protocal/protobuf/PageTicketElement;", "item", "Landroid/view/View;", "showDeleteConfirmDialog", "showProgressDialog", "isShow", "(Ljava/lang/Boolean;)V", "superImportUIComponents", "set", "Ljava/util/HashSet;", "Ljava/lang/Class;", "Lcom/tencent/mm/ui/component/UIComponent;", "updateModelList", "Lcom/tencent/mm/protocal/protobuf/PageTicketJumpList;", "Lcom/tencent/mm/protocal/protobuf/PageTicketList;", "underList", "Lcom/tencent/mm/protocal/protobuf/PageUnderList;", "updateTextMenu", "CardTicketListUIAccessibilityConfig", "Companion", "plugin-card_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class CardTicketListUI
  extends CardNewBaseUI
{
  public static final CardTicketListUI.b wGG;
  private boolean isLoading;
  private w lKp;
  private boolean mgS;
  private int offset;
  private int wFo;
  private boolean wFp;
  private b wGB;
  private ViewGroup wGH;
  private boolean wGI;
  private final c wGJ;
  private com.tencent.mm.plugin.card.model.a.i wGK;
  private LoadMoreRecyclerView wGn;
  private a wGo;
  private final ArrayList<b> wGw;
  private final ArrayList<b> wGx;
  private final ArrayList<b> wGy;
  
  static
  {
    AppMethodBeat.i(112545);
    wGG = new CardTicketListUI.b((byte)0);
    AppMethodBeat.o(112545);
  }
  
  public CardTicketListUI()
  {
    AppMethodBeat.i(112544);
    this.wFo = 10;
    this.mgS = true;
    this.wGw = new ArrayList();
    this.wGx = new ArrayList();
    this.wGy = new ArrayList();
    this.wGJ = new c(this);
    AppMethodBeat.o(112544);
  }
  
  private static final Object a(CardTicketListUI paramCardTicketListUI, boolean paramBoolean, b.a parama)
  {
    AppMethodBeat.i(294143);
    kotlin.g.b.s.u(paramCardTicketListUI, "this$0");
    Log.i("MicroMsg.CardTicketListUI", "errtype: %s, errcode: %s", new Object[] { Integer.valueOf(parama.errType), Integer.valueOf(parama.errCode) });
    paramCardTicketListUI.isLoading = false;
    if ((parama.errType == 0) && (parama.errCode == 0))
    {
      esc localesc = parama.ott;
      cnr localcnr = (cnr)localesc;
      Log.i("MicroMsg.CardTicketListUI", "retCode: %s", new Object[] { Integer.valueOf(localcnr.wuz) });
      boolean bool;
      LoadMoreRecyclerView localLoadMoreRecyclerView;
      if (localcnr.wuz == 0)
      {
        paramCardTicketListUI.offset = localcnr.xlj;
        if (localcnr.aaqL == 1)
        {
          bool = true;
          paramCardTicketListUI.wFp = bool;
          if (!paramCardTicketListUI.wFp) {
            break label263;
          }
          localLoadMoreRecyclerView = paramCardTicketListUI.wGn;
          parama = localLoadMoreRecyclerView;
          if (localLoadMoreRecyclerView == null)
          {
            kotlin.g.b.s.bIx("mTicketRv");
            parama = null;
          }
          parama.showLoading(false);
          label164:
          if ((paramCardTicketListUI.mgS) || (paramBoolean))
          {
            paramCardTicketListUI.wGy.clear();
            paramCardTicketListUI.wGw.clear();
            paramCardTicketListUI.wGx.clear();
            paramCardTicketListUI.wGB = null;
            paramCardTicketListUI.mgS = false;
          }
          Log.d("MicroMsg.CardTicketListUI", "page_under_list: %s", new Object[] { localcnr.aauZ });
          paramCardTicketListUI.a(localcnr.aauW, localcnr.aauX, localcnr.aauY, localcnr.aauZ);
        }
      }
      for (;;)
      {
        AppMethodBeat.o(294143);
        return localesc;
        bool = false;
        break;
        label263:
        localLoadMoreRecyclerView = paramCardTicketListUI.wGn;
        parama = localLoadMoreRecyclerView;
        if (localLoadMoreRecyclerView == null)
        {
          kotlin.g.b.s.bIx("mTicketRv");
          parama = null;
        }
        parama.showLoading(true);
        break label164;
        l.ar((Context)paramCardTicketListUI, localcnr.wuA);
        if (paramCardTicketListUI.mgS) {
          paramCardTicketListUI.mgS = false;
        }
      }
    }
    if (paramCardTicketListUI.mgS) {
      paramCardTicketListUI.mgS = false;
    }
    l.as((Context)paramCardTicketListUI, "");
    paramCardTicketListUI = ah.aiuX;
    AppMethodBeat.o(294143);
    return paramCardTicketListUI;
  }
  
  private static final ah a(CardTicketListUI paramCardTicketListUI, String paramString, b.a parama)
  {
    AppMethodBeat.i(294115);
    kotlin.g.b.s.u(paramCardTicketListUI, "this$0");
    kotlin.g.b.s.u(paramString, "$cardId");
    Log.i("MicroMsg.CardTicketListUI", "errtype: %s, errcode: %s", new Object[] { Integer.valueOf(parama.errType), Integer.valueOf(parama.errCode) });
    if ((parama.errType == 0) && (parama.errCode == 0))
    {
      parama = (ajl)parama.ott;
      Log.i("MicroMsg.CardTicketListUI", "retCode: %s", new Object[] { Integer.valueOf(parama.wuz) });
      if (parama.wuz == 0)
      {
        a locala = paramCardTicketListUI.wGo;
        parama = locala;
        if (locala == null)
        {
          kotlin.g.b.s.bIx("mTicketAdapter");
          parama = null;
        }
        parama.alf(paramString);
      }
    }
    for (;;)
    {
      paramCardTicketListUI.p(Boolean.FALSE);
      paramCardTicketListUI = ah.aiuX;
      AppMethodBeat.o(294115);
      return paramCardTicketListUI;
      l.ar((Context)paramCardTicketListUI, parama.wuA);
      continue;
      l.as((Context)paramCardTicketListUI, "");
    }
  }
  
  private static final void a(CardTicketListUI paramCardTicketListUI, ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
  {
    AppMethodBeat.i(294079);
    kotlin.g.b.s.u(paramCardTicketListUI, "this$0");
    paramContextMenu.add(0, 1, 0, (CharSequence)paramCardTicketListUI.getString(a.g.app_delete));
    AppMethodBeat.o(294079);
  }
  
  private static final void a(CardTicketListUI paramCardTicketListUI, MenuItem paramMenuItem, int paramInt)
  {
    AppMethodBeat.i(294126);
    kotlin.g.b.s.u(paramCardTicketListUI, "this$0");
    if (paramMenuItem.getItemId() == 0)
    {
      Log.i("MicroMsg.CardTicketListUI", "click history wording");
      paramMenuItem = new Intent((Context)paramCardTicketListUI, CardInvalidTicketListUI.class);
      paramMenuItem = new com.tencent.mm.hellhoundlib.b.a().cG(paramMenuItem);
      com.tencent.mm.hellhoundlib.a.a.b(paramCardTicketListUI, paramMenuItem.aYi(), "com/tencent/mm/plugin/card/ui/v2/CardTicketListUI", "updateTextMenu$lambda-29$lambda-28", "(Lcom/tencent/mm/plugin/card/ui/v2/CardTicketListUI;Landroid/view/MenuItem;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramCardTicketListUI.startActivity((Intent)paramMenuItem.sb(0));
      com.tencent.mm.hellhoundlib.a.a.c(paramCardTicketListUI, "com/tencent/mm/plugin/card/ui/v2/CardTicketListUI", "updateTextMenu$lambda-29$lambda-28", "(Lcom/tencent/mm/plugin/card/ui/v2/CardTicketListUI;Landroid/view/MenuItem;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      com.tencent.mm.plugin.report.service.h.OAn.b(16322, new Object[] { Integer.valueOf(8) });
    }
    AppMethodBeat.o(294126);
  }
  
  private static final void a(CardTicketListUI paramCardTicketListUI, RecyclerView paramRecyclerView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(294067);
    kotlin.g.b.s.u(paramCardTicketListUI, "this$0");
    Log.i("MicroMsg.CardTicketListUI", "click item");
    paramView = paramCardTicketListUI.wGo;
    paramRecyclerView = paramView;
    if (paramView == null)
    {
      kotlin.g.b.s.bIx("mTicketAdapter");
      paramRecyclerView = null;
    }
    paramRecyclerView = paramRecyclerView.IG(paramInt);
    if (paramRecyclerView != null) {
      switch (paramRecyclerView.type)
      {
      }
    }
    for (;;)
    {
      AppMethodBeat.o(294067);
      return;
      paramRecyclerView = paramRecyclerView.wGD;
      if (paramRecyclerView != null) {
        switch (paramRecyclerView.aaUp)
        {
        }
      }
      for (;;)
      {
        com.tencent.mm.plugin.report.service.h.OAn.b(16322, new Object[] { Integer.valueOf(7) });
        AppMethodBeat.o(294067);
        return;
        com.tencent.mm.plugin.card.c.b.a((MMActivity)paramCardTicketListUI, paramRecyclerView.abfM, 0);
        continue;
        paramCardTicketListUI = paramRecyclerView.abfN;
        if (paramCardTicketListUI != null) {
          com.tencent.mm.plugin.card.c.b.S(paramCardTicketListUI.VcU, paramCardTicketListUI.VcV, paramCardTicketListUI.VQU);
        }
      }
      paramView = paramRecyclerView.wGE;
      if (paramView != null)
      {
        paramRecyclerView = paramView.YBH;
        kotlin.g.b.s.s(paramRecyclerView, "user_card_id");
        Log.i("MicroMsg.CardTicketListUI", "go to card detail: %s", new Object[] { paramRecyclerView });
        Object localObject1 = new Intent((Context)paramCardTicketListUI.getContext(), CardDetailUI.class);
        ((Intent)localObject1).putExtra("key_card_id", paramRecyclerView);
        ((Intent)localObject1).addFlags(131072);
        ((Intent)localObject1).putExtra("key_from_scene", 3);
        paramCardTicketListUI.startActivityForResult((Intent)localObject1, 256);
        com.tencent.mm.plugin.report.service.h.OAn.b(16322, new Object[] { Integer.valueOf(10) });
        localObject1 = com.tencent.mm.plugin.report.service.h.OAn;
        paramInt = paramView.abfF;
        Object localObject2 = paramView.YBH;
        paramRecyclerView = paramCardTicketListUI.wGo;
        paramCardTicketListUI = paramRecyclerView;
        if (paramRecyclerView == null)
        {
          kotlin.g.b.s.bIx("mTicketAdapter");
          paramCardTicketListUI = null;
        }
        paramRecyclerView = paramView.YBH;
        kotlin.g.b.s.s(paramRecyclerView, "user_card_id");
        ((com.tencent.mm.plugin.report.service.h)localObject1).b(16326, new Object[] { Integer.valueOf(paramInt), localObject2, Integer.valueOf(paramCardTicketListUI.dL(paramRecyclerView, paramView.abfF)), Integer.valueOf(1) });
        AppMethodBeat.o(294067);
        return;
        paramRecyclerView = paramRecyclerView.wGF;
        if (paramRecyclerView != null) {
          switch (paramRecyclerView.aaUp)
          {
          default: 
            break;
          case 1: 
            com.tencent.mm.plugin.card.c.b.a((MMActivity)paramCardTicketListUI, paramRecyclerView.aaUq, 0);
            paramCardTicketListUI.wGI = true;
            AppMethodBeat.o(294067);
            return;
          case 2: 
            localObject2 = paramRecyclerView.aaUr;
            if (localObject2 != null)
            {
              paramRecyclerView = (t)com.tencent.mm.kernel.h.ax(t.class);
              paramView = (Context)paramCardTicketListUI;
              localObject1 = new g();
              ((g)localObject1).username = ((wg)localObject2).VcU;
              ((g)localObject1).qAF = ((wg)localObject2).VcV;
              ((g)localObject1).version = ((wg)localObject2).VQU;
              ((g)localObject1).scene = 1028;
              ((g)localObject1).qAU = ((com.tencent.mm.plugin.appbrand.api.i)paramCardTicketListUI.wGJ);
              paramCardTicketListUI = ah.aiuX;
              paramRecyclerView.a(paramView, (g)localObject1);
            }
            break;
          }
        }
      }
    }
  }
  
  private static final void a(CardTicketListUI paramCardTicketListUI, LoadMoreRecyclerView paramLoadMoreRecyclerView, RecyclerView.a parama)
  {
    AppMethodBeat.i(294058);
    kotlin.g.b.s.u(paramCardTicketListUI, "this$0");
    paramCardTicketListUI.nf(false);
    AppMethodBeat.o(294058);
  }
  
  private static final void a(CardTicketListUI paramCardTicketListUI, eal parameal, MenuItem paramMenuItem, int paramInt)
  {
    AppMethodBeat.i(294091);
    kotlin.g.b.s.u(paramCardTicketListUI, "this$0");
    if (parameal != null)
    {
      com.tencent.mm.ui.widget.a.f localf = new com.tencent.mm.ui.widget.a.f((Context)paramCardTicketListUI.getContext(), 1, true);
      paramMenuItem = new TextView((Context)paramCardTicketListUI.getContext());
      paramMenuItem.setText((CharSequence)paramCardTicketListUI.getString(a.g.woS));
      paramMenuItem.setTextSize(1, 14.0F);
      paramMenuItem.setTextColor(paramCardTicketListUI.getResources().getColor(a.a.half_alpha_black));
      paramMenuItem.setGravity(17);
      paramInt = paramCardTicketListUI.getResources().getDimensionPixelSize(a.b.Edge_A);
      int i = paramCardTicketListUI.getResources().getDimensionPixelSize(a.b.Edge_2A);
      paramMenuItem.setPadding(paramInt, i, paramInt, i);
      localf.af((View)paramMenuItem, false);
      localf.Vtg = new CardTicketListUI..ExternalSyntheticLambda7(paramCardTicketListUI);
      localf.GAC = new CardTicketListUI..ExternalSyntheticLambda9(paramCardTicketListUI, parameal);
      com.tencent.mm.plugin.report.service.h localh = com.tencent.mm.plugin.report.service.h.OAn;
      paramInt = parameal.abfF;
      String str = parameal.YBH;
      paramMenuItem = paramCardTicketListUI.wGo;
      paramCardTicketListUI = paramMenuItem;
      if (paramMenuItem == null)
      {
        kotlin.g.b.s.bIx("mTicketAdapter");
        paramCardTicketListUI = null;
      }
      paramMenuItem = parameal.YBH;
      kotlin.g.b.s.s(paramMenuItem, "ticketElement!!.user_card_id");
      localh.b(16326, new Object[] { Integer.valueOf(paramInt), str, Integer.valueOf(paramCardTicketListUI.dL(paramMenuItem, parameal.abfF)), Integer.valueOf(3) });
      localf.dDn();
    }
    AppMethodBeat.o(294091);
  }
  
  private static final void a(CardTicketListUI paramCardTicketListUI, com.tencent.mm.ui.base.s params)
  {
    AppMethodBeat.i(294096);
    kotlin.g.b.s.u(paramCardTicketListUI, "this$0");
    params.a(1, paramCardTicketListUI.getResources().getColor(a.a.red_text_color), (CharSequence)paramCardTicketListUI.getString(a.g.app_delete));
    AppMethodBeat.o(294096);
  }
  
  private final void a(ean paramean, eao parameao1, eao parameao2, eap parameap)
  {
    Object localObject1 = null;
    AppMethodBeat.i(294043);
    Object localObject2;
    int i;
    if (paramean != null)
    {
      this.wGy.clear();
      localObject2 = paramean.abfP;
      kotlin.g.b.s.s(localObject2, "page_ticket_jump_element");
      if (!((Collection)localObject2).isEmpty()) {}
      for (i = 1; i != 0; i = 0)
      {
        paramean = paramean.abfP.iterator();
        while (paramean.hasNext())
        {
          localObject2 = (eam)paramean.next();
          b localb = new b();
          localb.wGD = ((eam)localObject2);
          localb.type = 1;
          this.wGy.add(localb);
        }
      }
    }
    if (parameao1 != null)
    {
      paramean = parameao1.abfQ;
      kotlin.g.b.s.s(paramean, "page_ticket_element");
      if (!((Collection)paramean).isEmpty()) {}
      for (i = 1; i != 0; i = 0)
      {
        paramean = parameao1.abfQ.iterator();
        while (paramean.hasNext())
        {
          parameao1 = (eal)paramean.next();
          localObject2 = new b();
          ((b)localObject2).wGE = parameao1;
          ((b)localObject2).type = 2;
          this.wGw.add(localObject2);
        }
      }
    }
    if (parameao2 != null)
    {
      paramean = parameao2.abfQ;
      kotlin.g.b.s.s(paramean, "page_ticket_element");
      if (!((Collection)paramean).isEmpty()) {}
      for (i = 1; i != 0; i = 0)
      {
        paramean = parameao2.abfQ.iterator();
        while (paramean.hasNext())
        {
          parameao1 = (eal)paramean.next();
          parameao2 = new b();
          parameao2.wGE = parameao1;
          parameao2.type = 2;
          this.wGx.add(parameao2);
        }
      }
    }
    if (parameap != null)
    {
      paramean = parameap.abfR;
      if (paramean != null)
      {
        this.wGB = new b();
        parameao1 = this.wGB;
        kotlin.g.b.s.checkNotNull(parameao1);
        parameao1.type = 3;
        parameao1 = this.wGB;
        kotlin.g.b.s.checkNotNull(parameao1);
        parameao1.wGF = paramean;
      }
    }
    if (!((Collection)this.wGy).isEmpty())
    {
      i = 1;
      if (i == 0)
      {
        if (((Collection)this.wGw).isEmpty()) {
          break label585;
        }
        i = 1;
        label421:
        if (i == 0) {
          break label597;
        }
      }
      if (((Collection)this.wGx).isEmpty()) {
        break label591;
      }
      i = 1;
      label444:
      if ((i == 0) && (this.wGB == null)) {
        break label597;
      }
      parameao1 = this.wGo;
      paramean = parameao1;
      if (parameao1 == null)
      {
        kotlin.g.b.s.bIx("mTicketAdapter");
        paramean = null;
      }
      parameao1 = getString(a.g.wqD);
      kotlin.g.b.s.s(parameao1, "getString(R.string.card_ticket_section_title)");
      paramean.alg(parameao1);
      parameao1 = this.wGo;
      paramean = parameao1;
      if (parameao1 == null)
      {
        kotlin.g.b.s.bIx("mTicketAdapter");
        paramean = null;
      }
      parameao1 = getString(a.g.wpi);
      kotlin.g.b.s.s(parameao1, "getString(R.string.card_license_section_title)");
      paramean.alh(parameao1);
      label534:
      paramean = this.wGo;
      if (paramean != null) {
        break label652;
      }
      kotlin.g.b.s.bIx("mTicketAdapter");
      paramean = localObject1;
    }
    label652:
    for (;;)
    {
      paramean.a(this.wGy, this.wGw, this.wGx, this.wGB);
      AppMethodBeat.o(294043);
      return;
      i = 0;
      break;
      label585:
      i = 0;
      break label421;
      label591:
      i = 0;
      break label444;
      label597:
      parameao1 = this.wGo;
      paramean = parameao1;
      if (parameao1 == null)
      {
        kotlin.g.b.s.bIx("mTicketAdapter");
        paramean = null;
      }
      paramean.alg("");
      parameao1 = this.wGo;
      paramean = parameao1;
      if (parameao1 == null)
      {
        kotlin.g.b.s.bIx("mTicketAdapter");
        paramean = null;
      }
      paramean.alh("");
      break label534;
    }
  }
  
  private static final boolean a(CardTicketListUI paramCardTicketListUI, MenuItem paramMenuItem)
  {
    AppMethodBeat.i(294055);
    kotlin.g.b.s.u(paramCardTicketListUI, "this$0");
    paramCardTicketListUI.finish();
    AppMethodBeat.o(294055);
    return false;
  }
  
  private final void ali(String paramString)
  {
    AppMethodBeat.i(112542);
    Log.i("MicroMsg.CardTicketListUI", "do delete ticket: %s", new Object[] { paramString });
    p(Boolean.TRUE);
    new c(paramString).bFJ().b(new CardTicketListUI..ExternalSyntheticLambda11(this, paramString));
    AppMethodBeat.o(112542);
  }
  
  private static final void b(CardTicketListUI paramCardTicketListUI, eal parameal, MenuItem paramMenuItem, int paramInt)
  {
    AppMethodBeat.i(294103);
    kotlin.g.b.s.u(paramCardTicketListUI, "this$0");
    if (paramMenuItem.getItemId() == 1)
    {
      kotlin.g.b.s.checkNotNull(parameal);
      paramMenuItem = parameal.YBH;
      kotlin.g.b.s.s(paramMenuItem, "ticketElement!!.user_card_id");
      paramCardTicketListUI.ali(paramMenuItem);
      com.tencent.mm.plugin.report.service.h localh = com.tencent.mm.plugin.report.service.h.OAn;
      paramInt = parameal.abfF;
      String str = parameal.YBH;
      paramMenuItem = paramCardTicketListUI.wGo;
      paramCardTicketListUI = paramMenuItem;
      if (paramMenuItem == null)
      {
        kotlin.g.b.s.bIx("mTicketAdapter");
        paramCardTicketListUI = null;
      }
      paramMenuItem = parameal.YBH;
      kotlin.g.b.s.s(paramMenuItem, "ticketElement!!.user_card_id");
      localh.b(16326, new Object[] { Integer.valueOf(paramInt), str, Integer.valueOf(paramCardTicketListUI.dL(paramMenuItem, parameal.abfF)), Integer.valueOf(4) });
    }
    AppMethodBeat.o(294103);
  }
  
  private static final void b(CardTicketListUI paramCardTicketListUI, com.tencent.mm.ui.base.s params)
  {
    AppMethodBeat.i(294118);
    kotlin.g.b.s.u(paramCardTicketListUI, "this$0");
    params.add(0, 0, 1, (CharSequence)paramCardTicketListUI.getString(a.g.wqN));
    AppMethodBeat.o(294118);
  }
  
  private static final boolean b(CardTicketListUI paramCardTicketListUI, MenuItem paramMenuItem)
  {
    AppMethodBeat.i(294134);
    kotlin.g.b.s.u(paramCardTicketListUI, "this$0");
    paramMenuItem = new com.tencent.mm.ui.widget.a.f((Context)paramCardTicketListUI.getContext(), 1, false);
    paramMenuItem.Vtg = new CardTicketListUI..ExternalSyntheticLambda6(paramCardTicketListUI);
    paramMenuItem.GAC = new CardTicketListUI..ExternalSyntheticLambda8(paramCardTicketListUI);
    paramMenuItem.dDn();
    AppMethodBeat.o(294134);
    return false;
  }
  
  private static final boolean b(CardTicketListUI paramCardTicketListUI, RecyclerView paramRecyclerView, View paramView, int paramInt, long paramLong)
  {
    String str = null;
    AppMethodBeat.i(294074);
    kotlin.g.b.s.u(paramCardTicketListUI, "this$0");
    Log.i("MicroMsg.CardTicketListUI", "long click item");
    Object localObject = paramCardTicketListUI.wGo;
    paramRecyclerView = (RecyclerView)localObject;
    if (localObject == null)
    {
      kotlin.g.b.s.bIx("mTicketAdapter");
      paramRecyclerView = null;
    }
    localObject = paramRecyclerView.IG(paramInt);
    if (localObject != null)
    {
      paramRecyclerView = ((b)localObject).wGE;
      if (((b)localObject).type == 2)
      {
        kotlin.g.b.s.s(paramView, "view");
        if (paramRecyclerView != null)
        {
          localObject = new com.tencent.mm.ui.widget.b.a((Context)paramCardTicketListUI.getContext(), paramView);
          ((com.tencent.mm.ui.widget.b.a)localObject).agjt = new CardTicketListUI..ExternalSyntheticLambda2(paramCardTicketListUI);
          ((com.tencent.mm.ui.widget.b.a)localObject).GAC = new CardTicketListUI..ExternalSyntheticLambda10(paramCardTicketListUI, paramRecyclerView);
          paramView = m.eN(paramView);
          ((com.tencent.mm.ui.widget.b.a)localObject).fQ(paramView.x, paramView.y);
          paramView = com.tencent.mm.plugin.report.service.h.OAn;
          paramInt = paramRecyclerView.abfF;
          localObject = paramRecyclerView.YBH;
          paramCardTicketListUI = paramCardTicketListUI.wGo;
          if (paramCardTicketListUI != null) {
            break label247;
          }
          kotlin.g.b.s.bIx("mTicketAdapter");
          paramCardTicketListUI = str;
        }
      }
    }
    label247:
    for (;;)
    {
      str = paramRecyclerView.YBH;
      kotlin.g.b.s.s(str, "user_card_id");
      paramView.b(16326, new Object[] { Integer.valueOf(paramInt), localObject, Integer.valueOf(paramCardTicketListUI.dL(str, paramRecyclerView.abfF)), Integer.valueOf(2) });
      AppMethodBeat.o(294074);
      return false;
    }
  }
  
  private final void nf(boolean paramBoolean)
  {
    AppMethodBeat.i(294051);
    Log.i("MicroMsg.CardTicketListUI", "do get ticket: %s, %s, %s, %s", new Object[] { Integer.valueOf(this.offset), Integer.valueOf(this.wFo), Boolean.valueOf(this.wFp), Boolean.valueOf(this.isLoading) });
    if ((paramBoolean) || ((!this.wFp) && (!this.isLoading)))
    {
      this.isLoading = true;
      i = this.wFo;
      if (paramBoolean) {
        if (this.offset * 2 >= this.wFo) {
          break label172;
        }
      }
    }
    label172:
    for (int i = this.wFo;; i = this.offset * 2)
    {
      this.offset = 0;
      this.wGK = new com.tencent.mm.plugin.card.model.a.i(this.offset, i, getLatitude(), getLongitude());
      com.tencent.mm.plugin.card.model.a.i locali = this.wGK;
      kotlin.g.b.s.checkNotNull(locali);
      locali.bFJ().b(new CardTicketListUI..ExternalSyntheticLambda12(this, paramBoolean));
      AppMethodBeat.o(294051);
      return;
    }
  }
  
  private final void p(Boolean paramBoolean)
  {
    AppMethodBeat.i(294028);
    if (paramBoolean == null)
    {
      AppMethodBeat.o(294028);
      return;
    }
    if (paramBoolean.booleanValue()) {}
    for (paramBoolean = w.a((Context)getContext(), (CharSequence)getString(a.g.app_waiting), true, 3, null);; paramBoolean = null)
    {
      this.lKp = paramBoolean;
      AppMethodBeat.o(294028);
      return;
      paramBoolean = this.lKp;
      if (paramBoolean != null) {
        paramBoolean.dismiss();
      }
    }
  }
  
  public final void at(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(112540);
    Log.i("MicroMsg.CardTicketListUI", "location finish: [%s, %s], ret: %s, isOk: %s", new Object[] { Float.valueOf(getLatitude()), Float.valueOf(getLongitude()), Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean) });
    AppMethodBeat.o(112540);
  }
  
  public final int getLayoutId()
  {
    return a.e.wnO;
  }
  
  public final void initView()
  {
    Object localObject3 = null;
    AppMethodBeat.i(112537);
    Object localObject1 = findViewById(a.d.wjS);
    kotlin.g.b.s.s(localObject1, "findViewById(R.id.ctlu_rv)");
    this.wGn = ((LoadMoreRecyclerView)localObject1);
    this.wGo = new a();
    Object localObject2 = this.wGo;
    localObject1 = localObject2;
    if (localObject2 == null)
    {
      kotlin.g.b.s.bIx("mTicketAdapter");
      localObject1 = null;
    }
    ((a)localObject1).bf(true);
    localObject1 = this.wGn;
    if (localObject1 == null)
    {
      kotlin.g.b.s.bIx("mTicketRv");
      localObject1 = null;
      Object localObject4 = this.wGo;
      localObject2 = localObject4;
      if (localObject4 == null)
      {
        kotlin.g.b.s.bIx("mTicketAdapter");
        localObject2 = null;
      }
      ((LoadMoreRecyclerView)localObject1).setAdapter((RecyclerView.a)localObject2);
      localObject1 = this.wGn;
      if (localObject1 != null) {
        break label398;
      }
      kotlin.g.b.s.bIx("mTicketRv");
      localObject1 = null;
      label130:
      getContext();
      ((LoadMoreRecyclerView)localObject1).setLayoutManager((RecyclerView.LayoutManager)new LinearLayoutManager());
      localObject2 = new androidx.recyclerview.widget.h((Context)this, 1);
      ((androidx.recyclerview.widget.h)localObject2).w(getResources().getDrawable(a.c.weo));
      localObject1 = this.wGn;
      if (localObject1 != null) {
        break label401;
      }
      kotlin.g.b.s.bIx("mTicketRv");
      localObject1 = null;
      label193:
      ((RecyclerView)localObject1).a((RecyclerView.h)localObject2);
      localObject2 = this.wGn;
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        kotlin.g.b.s.bIx("mTicketRv");
        localObject1 = null;
      }
      ((LoadMoreRecyclerView)localObject1).setLoadingView(a.e.wmP);
      localObject1 = findViewById(a.d.wih);
      kotlin.g.b.s.s(localObject1, "findViewById(R.id.chpe_root_layout)");
      this.wGH = ((ViewGroup)localObject1);
      localObject1 = this.wGn;
      if (localObject1 != null) {
        break label404;
      }
      kotlin.g.b.s.bIx("mTicketRv");
      localObject1 = null;
      label267:
      localObject4 = this.wGH;
      localObject2 = localObject4;
      if (localObject4 == null)
      {
        kotlin.g.b.s.bIx("mEmptyView");
        localObject2 = null;
      }
      ((LoadMoreRecyclerView)localObject1).setEmptyView((View)localObject2);
      localObject2 = this.wGn;
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        kotlin.g.b.s.bIx("mTicketRv");
        localObject1 = null;
      }
      ((LoadMoreRecyclerView)localObject1).setOnLoadingStateChangedListener(new CardTicketListUI..ExternalSyntheticLambda3(this));
      localObject2 = this.wGn;
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        kotlin.g.b.s.bIx("mTicketRv");
        localObject1 = null;
      }
      ((LoadMoreRecyclerView)localObject1).setOnItemClickListener(new CardTicketListUI..ExternalSyntheticLambda4(this));
      localObject1 = this.wGn;
      if (localObject1 != null) {
        break label407;
      }
      kotlin.g.b.s.bIx("mTicketRv");
      localObject1 = localObject3;
    }
    label398:
    label401:
    label404:
    label407:
    for (;;)
    {
      ((LoadMoreRecyclerView)localObject1).setOnItemLongClickListener(new CardTicketListUI..ExternalSyntheticLambda5(this));
      AppMethodBeat.o(112537);
      return;
      break;
      break label130;
      break label193;
      break label267;
    }
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    Object localObject2 = null;
    AppMethodBeat.i(112539);
    if ((paramInt1 == 256) && (paramInt2 == -1))
    {
      if (paramIntent != null) {
        break label52;
      }
      localObject1 = null;
      if (localObject1 != null) {
        break label68;
      }
    }
    for (;;)
    {
      if (localObject1 == null)
      {
        super.onActivityResult(paramInt1, paramInt2, paramIntent);
        AppMethodBeat.o(112539);
        return;
        label52:
        localObject1 = Integer.valueOf(paramIntent.getIntExtra("key_finish_action", -1));
        break;
        label68:
        if (((Integer)localObject1).intValue() == 1) {
          label77:
          if (paramIntent != null) {
            break label111;
          }
        }
      }
    }
    label111:
    for (Object localObject1 = localObject2;; localObject1 = paramIntent.getStringExtra("key_card_id"))
    {
      kotlin.g.b.s.checkNotNull(localObject1);
      ali((String)localObject1);
      break;
      if (((Integer)localObject1).intValue() != 2) {
        break;
      }
      break label77;
    }
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(112536);
    fixStatusbar(true);
    super.onCreate(paramBundle);
    hideActionbarLine();
    initView();
    if (this.mgS)
    {
      Log.i("MicroMsg.CardTicketListUI", "firstLoad doGetTicketHomePage");
      nf(false);
    }
    doo();
    paramBundle = new ean();
    eao localeao1 = new eao();
    eao localeao2 = new eao();
    eap localeap = new eap();
    Object localObject = com.tencent.mm.plugin.card.model.a.a.wvG;
    kotlin.g.b.s.u(paramBundle, "jumpList");
    kotlin.g.b.s.u(localeao1, "ticketList");
    kotlin.g.b.s.u(localeao2, "licenseList");
    kotlin.g.b.s.u(localeap, "underList");
    Log.d(com.tencent.mm.plugin.card.model.a.a.access$getTAG$cp(), "load ticket page snapshot");
    localObject = (String)com.tencent.mm.kernel.h.baE().ban().get(at.a.acXH, null);
    if (localObject != null)
    {
      localObject = ((String)localObject).getBytes(d.ISO_8859_1);
      kotlin.g.b.s.s(localObject, "(this as java.lang.String).getBytes(charset)");
      paramBundle.parseFrom((byte[])localObject);
    }
    localObject = (String)com.tencent.mm.kernel.h.baE().ban().get(at.a.acXI, null);
    if (localObject != null)
    {
      localObject = ((String)localObject).getBytes(d.ISO_8859_1);
      kotlin.g.b.s.s(localObject, "(this as java.lang.String).getBytes(charset)");
      localeao1.parseFrom((byte[])localObject);
    }
    localObject = (String)com.tencent.mm.kernel.h.baE().ban().get(at.a.acXJ, null);
    if (localObject != null)
    {
      localObject = ((String)localObject).getBytes(d.ISO_8859_1);
      kotlin.g.b.s.s(localObject, "(this as java.lang.String).getBytes(charset)");
      localeao2.parseFrom((byte[])localObject);
    }
    localObject = (String)com.tencent.mm.kernel.h.baE().ban().get(at.a.acXK, null);
    if (localObject != null)
    {
      localObject = ((String)localObject).getBytes(d.ISO_8859_1);
      kotlin.g.b.s.s(localObject, "(this as java.lang.String).getBytes(charset)");
      localeap.parseFrom((byte[])localObject);
    }
    a(paramBundle, localeao1, localeao2, localeap);
    setMMTitle(a.g.wqO);
    setBackBtn(new CardTicketListUI..ExternalSyntheticLambda0(this));
    addIconOptionMenu(0, a.f.icons_outlined_more, new CardTicketListUI..ExternalSyntheticLambda1(this));
    com.tencent.mm.plugin.report.service.h.OAn.b(16322, new Object[] { Integer.valueOf(6) });
    AppMethodBeat.o(112536);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(112538);
    super.onDestroy();
    Object localObject1 = this.wGK;
    if (localObject1 != null) {
      ((com.tencent.mm.plugin.card.model.a.i)localObject1).cancel();
    }
    ((t)com.tencent.mm.kernel.h.ax(t.class)).a((com.tencent.mm.plugin.appbrand.api.i)this.wGJ);
    Log.i("MicroMsg.CardTicketListUI", "do save snapshot");
    localObject1 = new ean();
    ((ean)localObject1).abfP = new LinkedList();
    Object localObject2 = this.wGy.iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = ((b)((Iterator)localObject2).next()).wGD;
      if (localObject3 != null) {
        ((ean)localObject1).abfP.add(localObject3);
      }
    }
    localObject2 = new eao();
    ((eao)localObject2).abfQ = new LinkedList();
    Object localObject3 = this.wGw.iterator();
    while (((Iterator)localObject3).hasNext())
    {
      localObject4 = ((b)((Iterator)localObject3).next()).wGE;
      if (localObject4 != null) {
        ((eao)localObject2).abfQ.add(localObject4);
      }
    }
    localObject3 = new eao();
    ((eao)localObject3).abfQ = new LinkedList();
    Object localObject4 = this.wGx.iterator();
    while (((Iterator)localObject4).hasNext())
    {
      localObject5 = ((b)((Iterator)localObject4).next()).wGE;
      if (localObject5 != null) {
        ((eao)localObject3).abfQ.add(localObject5);
      }
    }
    localObject4 = new eap();
    Object localObject5 = this.wGB;
    if (localObject5 != null) {
      ((eap)localObject4).abfR = ((b)localObject5).wGF;
    }
    localObject5 = com.tencent.mm.plugin.card.model.a.a.wvG;
    kotlin.g.b.s.u(localObject1, "jumpList");
    kotlin.g.b.s.u(localObject2, "ticketList");
    kotlin.g.b.s.u(localObject3, "licenseList");
    kotlin.g.b.s.u(localObject4, "underList");
    Log.d(com.tencent.mm.plugin.card.model.a.a.access$getTAG$cp(), "save ticket page snapshot");
    localObject1 = ((ean)localObject1).toByteArray();
    kotlin.g.b.s.s(localObject1, "jumpList.toByteArray()");
    localObject1 = new String((byte[])localObject1, d.ISO_8859_1);
    com.tencent.mm.kernel.h.baE().ban().set(at.a.acXH, localObject1);
    localObject1 = ((eao)localObject2).toByteArray();
    kotlin.g.b.s.s(localObject1, "ticketList.toByteArray()");
    localObject1 = new String((byte[])localObject1, d.ISO_8859_1);
    com.tencent.mm.kernel.h.baE().ban().set(at.a.acXI, localObject1);
    localObject1 = ((eao)localObject3).toByteArray();
    kotlin.g.b.s.s(localObject1, "licenseList.toByteArray()");
    localObject1 = new String((byte[])localObject1, d.ISO_8859_1);
    com.tencent.mm.kernel.h.baE().ban().set(at.a.acXJ, localObject1);
    localObject1 = ((eap)localObject4).toByteArray();
    kotlin.g.b.s.s(localObject1, "underList.toByteArray()");
    localObject1 = new String((byte[])localObject1, d.ISO_8859_1);
    com.tencent.mm.kernel.h.baE().ban().set(at.a.acXK, localObject1);
    AppMethodBeat.o(112538);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(294240);
    if (this.wGI)
    {
      nf(true);
      this.wGI = false;
    }
    super.onResume();
    AppMethodBeat.o(294240);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public final void superImportUIComponents(HashSet<Class<? extends UIComponent>> paramHashSet)
  {
    AppMethodBeat.i(294269);
    kotlin.g.b.s.u(paramHashSet, "set");
    super.superImportUIComponents(paramHashSet);
    paramHashSet.add(CardTicketListUI.a.class);
    AppMethodBeat.o(294269);
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/card/ui/v2/CardTicketListUI$weAppOpenUICallback$1", "Lcom/tencent/mm/plugin/appbrand/api/WeAppOpenUICallback;", "onAppBrandPreconditionError", "", "onAppBrandProcessDied", "onAppBrandUIEnter", "onAppBrandUIExit", "isFinish", "", "onTriggerHalfScreenShare", "token", "", "plugin-card_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
    implements com.tencent.mm.plugin.appbrand.api.i
  {
    c(CardTicketListUI paramCardTicketListUI) {}
    
    public final void UP(String paramString)
    {
      AppMethodBeat.i(294032);
      Log.i("MicroMsg.CardTicketListUI", "onTriggerHalfScreenShare");
      AppMethodBeat.o(294032);
    }
    
    public final void ceq()
    {
      AppMethodBeat.i(294008);
      Log.i("MicroMsg.CardTicketListUI", "onAppBrandPreconditionError");
      AppMethodBeat.o(294008);
    }
    
    public final void cer()
    {
      AppMethodBeat.i(294011);
      Log.i("MicroMsg.CardTicketListUI", "onAppBrandUIEnter");
      AppMethodBeat.o(294011);
    }
    
    public final void ces()
    {
      AppMethodBeat.i(294027);
      Log.i("MicroMsg.CardTicketListUI", "onAppBrandProcessDied");
      CardTicketListUI.a(this.wGO);
      AppMethodBeat.o(294027);
    }
    
    public final void ie(boolean paramBoolean)
    {
      AppMethodBeat.i(294018);
      Log.i("MicroMsg.CardTicketListUI", "onAppBrandUIExit(isFinish=" + paramBoolean + ')');
      CardTicketListUI.a(this.wGO);
      AppMethodBeat.o(294018);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.v2.CardTicketListUI
 * JD-Core Version:    0.7.0.1
 */