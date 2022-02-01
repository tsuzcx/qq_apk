package com.tencent.mm.plugin.card.ui.v2;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnCreateContextMenuListener;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.h;
import androidx.recyclerview.widget.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.widget.recyclerview.LoadMoreRecyclerView;
import com.tencent.mm.plugin.appbrand.widget.recyclerview.LoadMoreRecyclerView.a;
import com.tencent.mm.plugin.appbrand.widget.recyclerview.MRecyclerView.a;
import com.tencent.mm.plugin.appbrand.widget.recyclerview.MRecyclerView.b;
import com.tencent.mm.plugin.card.a.a;
import com.tencent.mm.plugin.card.a.c;
import com.tencent.mm.plugin.card.a.d;
import com.tencent.mm.plugin.card.a.e;
import com.tencent.mm.plugin.card.a.f;
import com.tencent.mm.plugin.card.a.g;
import com.tencent.mm.protocal.protobuf.dib;
import com.tencent.mm.protocal.protobuf.die;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.base.q.f;
import com.tencent.mm.ui.base.q.g;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.d;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/card/ui/v2/CardInvalidTicketListUI;", "Lcom/tencent/mm/plugin/card/ui/v2/CardNewBaseUI;", "()V", "firstLoad", "", "isAll", "isLoading", "isShowClearBtn", "mInvalidTicketList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/card/ui/v2/CardTicketListModel;", "mProgressDialog", "Lcom/tencent/mm/ui/base/MMProgressDialog;", "mTicketAdapter", "Lcom/tencent/mm/plugin/card/ui/v2/CardTicketAdapter;", "getMTicketAdapter", "()Lcom/tencent/mm/plugin/card/ui/v2/CardTicketAdapter;", "setMTicketAdapter", "(Lcom/tencent/mm/plugin/card/ui/v2/CardTicketAdapter;)V", "mTicketRv", "Lcom/tencent/mm/plugin/appbrand/widget/recyclerview/LoadMoreRecyclerView;", "getMTicketRv", "()Lcom/tencent/mm/plugin/appbrand/widget/recyclerview/LoadMoreRecyclerView;", "setMTicketRv", "(Lcom/tencent/mm/plugin/appbrand/widget/recyclerview/LoadMoreRecyclerView;)V", "offset", "", "reqNum", "doClearInvalidTicketList", "", "doDeleteInvalidTicket", "cardId", "", "doGetInvalidTicketHomePage", "getLayoutId", "gotoCardDetailUI", "initView", "invalidTicketIds", "loadSnapshot", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onFinishLocationThings", "ret", "isLocationOk", "saveSnapshot", "showDeleteCardAlert", "ticketElement", "Lcom/tencent/mm/protocal/protobuf/PageTicketElement;", "item", "Landroid/view/View;", "showDeleteConfirmDialog", "showProgressDialog", "isShow", "(Ljava/lang/Boolean;)V", "updateModelList", "ticketList", "Lcom/tencent/mm/protocal/protobuf/PageTicketList;", "updateOptionMenu", "Companion", "plugin-card_release"})
public final class CardInvalidTicketListUI
  extends CardNewBaseUI
{
  public static final CardInvalidTicketListUI.a tCg;
  private boolean isLoading;
  private boolean jHo;
  private s jhZ;
  private int offset;
  private int tAP;
  private boolean tAQ;
  public LoadMoreRecyclerView tCc;
  public a tCd;
  private ArrayList<b> tCe;
  private boolean tCf;
  
  static
  {
    AppMethodBeat.i(112498);
    tCg = new CardInvalidTicketListUI.a((byte)0);
    AppMethodBeat.o(112498);
  }
  
  public CardInvalidTicketListUI()
  {
    AppMethodBeat.i(112497);
    this.tCe = new ArrayList();
    this.tAP = 10;
    this.jHo = true;
    AppMethodBeat.o(112497);
  }
  
  private final void a(die paramdie)
  {
    AppMethodBeat.i(112495);
    if (paramdie != null)
    {
      Object localObject = paramdie.TPu;
      p.j(localObject, "page_ticket_element");
      if (!((Collection)localObject).isEmpty()) {}
      for (int i = 1; i != 0; i = 0)
      {
        paramdie = paramdie.TPu.iterator();
        while (paramdie.hasNext())
        {
          localObject = (dib)paramdie.next();
          b localb = new b();
          localb.tCC = ((dib)localObject);
          localb.type = 2;
          this.tCe.add(localb);
        }
      }
    }
    paramdie = this.tCd;
    if (paramdie == null) {
      p.bGy("mTicketAdapter");
    }
    paramdie.a(null, this.tCe, null, null);
    AppMethodBeat.o(112495);
  }
  
  private final void cKI()
  {
    AppMethodBeat.i(112496);
    Log.i("MicroMsg.CardInvalidTicketListUI", "do get invalid ticket: %s, %s, %s, %s", new Object[] { Integer.valueOf(this.offset), Integer.valueOf(this.tAP), Boolean.valueOf(this.tAQ), Boolean.valueOf(this.isLoading) });
    if ((!this.tAQ) && (!this.isLoading))
    {
      this.isLoading = true;
      new com.tencent.mm.plugin.card.model.a.h(this.offset, this.tAP, this.latitude, this.longitude).bhW().b((com.tencent.mm.vending.c.a)new c(this));
    }
    AppMethodBeat.o(112496);
  }
  
  private final void n(Boolean paramBoolean)
  {
    AppMethodBeat.i(245489);
    if (paramBoolean == null)
    {
      AppMethodBeat.o(245489);
      return;
    }
    if (paramBoolean.booleanValue()) {}
    for (paramBoolean = s.a((Context)getContext(), (CharSequence)getString(a.g.app_waiting), true, 3, null);; paramBoolean = null)
    {
      this.jhZ = paramBoolean;
      AppMethodBeat.o(245489);
      return;
      paramBoolean = this.jhZ;
      if (paramBoolean != null) {
        paramBoolean.dismiss();
      }
    }
  }
  
  public final void ac(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(112494);
    Log.i("MicroMsg.CardInvalidTicketListUI", "location finish: [%s, %s], ret: %s, isOk: %s", new Object[] { Float.valueOf(this.latitude), Float.valueOf(this.longitude), Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean) });
    if (this.jHo)
    {
      cKI();
      AppMethodBeat.o(112494);
      return;
    }
    if (!paramBoolean) {
      cKL();
    }
    AppMethodBeat.o(112494);
  }
  
  public final LoadMoreRecyclerView cKG()
  {
    AppMethodBeat.i(112489);
    LoadMoreRecyclerView localLoadMoreRecyclerView = this.tCc;
    if (localLoadMoreRecyclerView == null) {
      p.bGy("mTicketRv");
    }
    AppMethodBeat.o(112489);
    return localLoadMoreRecyclerView;
  }
  
  public final a cKH()
  {
    AppMethodBeat.i(112490);
    a locala = this.tCd;
    if (locala == null) {
      p.bGy("mTicketAdapter");
    }
    AppMethodBeat.o(112490);
    return locala;
  }
  
  public final int getLayoutId()
  {
    return a.e.tjr;
  }
  
  public final void initView()
  {
    AppMethodBeat.i(112492);
    Object localObject1 = findViewById(a.d.tfx);
    p.j(localObject1, "findViewById(R.id.ctlu_rv)");
    this.tCc = ((LoadMoreRecyclerView)localObject1);
    this.tCd = new a(true);
    localObject1 = this.tCd;
    if (localObject1 == null) {
      p.bGy("mTicketAdapter");
    }
    ((a)localObject1).aw(true);
    localObject1 = this.tCc;
    if (localObject1 == null) {
      p.bGy("mTicketRv");
    }
    Object localObject2 = this.tCd;
    if (localObject2 == null) {
      p.bGy("mTicketAdapter");
    }
    ((LoadMoreRecyclerView)localObject1).setAdapter((RecyclerView.a)localObject2);
    localObject1 = this.tCc;
    if (localObject1 == null) {
      p.bGy("mTicketRv");
    }
    getContext();
    ((LoadMoreRecyclerView)localObject1).setLayoutManager((RecyclerView.LayoutManager)new LinearLayoutManager());
    localObject1 = this.tCc;
    if (localObject1 == null) {
      p.bGy("mTicketRv");
    }
    ((LoadMoreRecyclerView)localObject1).setEmptyView(findViewById(a.d.tdT));
    localObject1 = this.tCc;
    if (localObject1 == null) {
      p.bGy("mTicketRv");
    }
    localObject1 = (TextView)((LoadMoreRecyclerView)localObject1).getEmptyView().findViewById(a.d.tdU);
    p.j(localObject1, "emptyTv");
    ((TextView)localObject1).setText((CharSequence)getString(a.g.tkw));
    localObject1 = this.tCc;
    if (localObject1 == null) {
      p.bGy("mTicketRv");
    }
    localObject1 = (WeImageView)((LoadMoreRecyclerView)localObject1).getEmptyView().findViewById(a.d.tdS);
    ((WeImageView)localObject1).setImageResource(a.f.icon_history_card_empty);
    ((WeImageView)localObject1).setIconColor(getResources().getColor(a.a.FG_2));
    localObject1 = new i((Context)this, 1);
    ((i)localObject1).t(getResources().getDrawable(a.c.tah));
    localObject2 = this.tCc;
    if (localObject2 == null) {
      p.bGy("mTicketRv");
    }
    ((LoadMoreRecyclerView)localObject2).b((RecyclerView.h)localObject1);
    localObject1 = this.tCc;
    if (localObject1 == null) {
      p.bGy("mTicketRv");
    }
    ((LoadMoreRecyclerView)localObject1).setLoadingView(a.e.tis);
    localObject1 = this.tCc;
    if (localObject1 == null) {
      p.bGy("mTicketRv");
    }
    ((LoadMoreRecyclerView)localObject1).setOnLoadingStateChangedListener((LoadMoreRecyclerView.a)new d(this));
    localObject1 = this.tCc;
    if (localObject1 == null) {
      p.bGy("mTicketRv");
    }
    ((LoadMoreRecyclerView)localObject1).setOnItemClickListener((MRecyclerView.a)new e(this));
    localObject1 = this.tCc;
    if (localObject1 == null) {
      p.bGy("mTicketRv");
    }
    ((LoadMoreRecyclerView)localObject1).setOnItemLongClickListener((MRecyclerView.b)new f(this));
    AppMethodBeat.o(112492);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(112491);
    fixStatusbar(true);
    super.onCreate(paramBundle);
    hideActionbarLine();
    initView();
    paramBundle = new die();
    Object localObject = com.tencent.mm.plugin.card.model.a.a.trh;
    p.k(paramBundle, "invalidTicketList");
    Log.d(com.tencent.mm.plugin.card.model.a.a.access$getTAG$cp(), "load invalid ticket page snapshot");
    localObject = com.tencent.mm.kernel.h.aHG();
    p.j(localObject, "MMKernel.storage()");
    localObject = (String)((com.tencent.mm.kernel.f)localObject).aHp().j(ar.a.Vwb);
    if (localObject != null)
    {
      Charset localCharset = d.ISO_8859_1;
      if (localObject == null)
      {
        paramBundle = new t("null cannot be cast to non-null type java.lang.String");
        AppMethodBeat.o(112491);
        throw paramBundle;
      }
      localObject = ((String)localObject).getBytes(localCharset);
      p.j(localObject, "(this as java.lang.String).getBytes(charset)");
      paramBundle.parseFrom((byte[])localObject);
    }
    a(paramBundle);
    setMMTitle(a.g.tmn);
    setBackBtn((MenuItem.OnMenuItemClickListener)new CardInvalidTicketListUI.g(this));
    com.tencent.mm.plugin.report.service.h.IzE.a(16322, new Object[] { Integer.valueOf(9) });
    AppMethodBeat.o(112491);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(112493);
    super.onDestroy();
    Object localObject1 = new die();
    ((die)localObject1).TPu = new LinkedList();
    Object localObject2 = this.tCe.iterator();
    while (((Iterator)localObject2).hasNext())
    {
      dib localdib = ((b)((Iterator)localObject2).next()).tCC;
      if (localdib != null) {
        ((die)localObject1).TPu.add(localdib);
      }
    }
    localObject2 = com.tencent.mm.plugin.card.model.a.a.trh;
    p.k(localObject1, "invalidTicketList");
    Log.d(com.tencent.mm.plugin.card.model.a.a.access$getTAG$cp(), "save invalid ticket snapshot");
    localObject1 = ((die)localObject1).toByteArray();
    p.j(localObject1, "invalidTicketList.toByteArray()");
    localObject1 = new String((byte[])localObject1, d.ISO_8859_1);
    localObject2 = com.tencent.mm.kernel.h.aHG();
    p.j(localObject2, "MMKernel.storage()");
    ((com.tencent.mm.kernel.f)localObject2).aHp().set(ar.a.Vwb, localObject1);
    AppMethodBeat.o(112493);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/DeleteCardInInvalidListResponse;", "kotlin.jvm.PlatformType", "call"})
  static final class b<_Ret, _Var>
    implements com.tencent.mm.vending.c.a<_Ret, _Var>
  {
    b(CardInvalidTicketListUI paramCardInvalidTicketListUI, String paramString) {}
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "kotlin.jvm.PlatformType", "it", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/GetMktInvalidTicketHomePageResponse;", "call"})
  static final class c<_Ret, _Var>
    implements com.tencent.mm.vending.c.a<_Ret, _Var>
  {
    c(CardInvalidTicketListUI paramCardInvalidTicketListUI) {}
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "parent", "Lcom/tencent/mm/plugin/appbrand/widget/recyclerview/LoadMoreRecyclerView;", "kotlin.jvm.PlatformType", "adapter", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "onLoadMore"})
  static final class d
    implements LoadMoreRecyclerView.a
  {
    d(CardInvalidTicketListUI paramCardInvalidTicketListUI) {}
    
    public final void clj()
    {
      AppMethodBeat.i(245003);
      CardInvalidTicketListUI.a(this.tCh);
      AppMethodBeat.o(245003);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "parent", "Landroidx/recyclerview/widget/RecyclerView;", "kotlin.jvm.PlatformType", "view", "Landroid/view/View;", "position", "", "id", "", "onItemClick"})
  static final class e
    implements MRecyclerView.a
  {
    e(CardInvalidTicketListUI paramCardInvalidTicketListUI) {}
    
    public final void U(View paramView, int paramInt)
    {
      AppMethodBeat.i(244284);
      Log.i("MicroMsg.CardInvalidTicketListUI", "click item");
      paramView = this.tCh.cKH().Id(paramInt);
      if (paramView != null)
      {
        switch (paramView.type)
        {
        }
        do
        {
          AppMethodBeat.o(244284);
          return;
          localObject = paramView.tCC;
        } while (localObject == null);
        paramView = this.tCh;
        Object localObject = ((dib)localObject).RFf;
        p.j(localObject, "user_card_id");
        CardInvalidTicketListUI.a(paramView, (String)localObject);
        AppMethodBeat.o(244284);
        return;
      }
      AppMethodBeat.o(244284);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "parent", "Landroidx/recyclerview/widget/RecyclerView;", "kotlin.jvm.PlatformType", "view", "Landroid/view/View;", "position", "", "id", "", "onItemLongClick"})
  static final class f
    implements MRecyclerView.b
  {
    f(CardInvalidTicketListUI paramCardInvalidTicketListUI) {}
    
    public final boolean V(View paramView, int paramInt)
    {
      AppMethodBeat.i(250642);
      Log.i("MicroMsg.CardInvalidTicketListUI", "long click item");
      Object localObject = this.tCh.cKH().Id(paramInt);
      if (localObject != null) {
        switch (((b)localObject).type)
        {
        }
      }
      for (;;)
      {
        AppMethodBeat.o(250642);
        return false;
        localObject = ((b)localObject).tCC;
        CardInvalidTicketListUI localCardInvalidTicketListUI = this.tCh;
        p.j(paramView, "view");
        CardInvalidTicketListUI.a(localCardInvalidTicketListUI, (dib)localObject, paramView);
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "menu", "Landroid/view/ContextMenu;", "kotlin.jvm.PlatformType", "v", "Landroid/view/View;", "menuInfo", "Landroid/view/ContextMenu$ContextMenuInfo;", "onCreateContextMenu", "com/tencent/mm/plugin/card/ui/v2/CardInvalidTicketListUI$showDeleteCardAlert$1$1"})
  static final class h
    implements View.OnCreateContextMenuListener
  {
    h(CardInvalidTicketListUI paramCardInvalidTicketListUI, View paramView, dib paramdib) {}
    
    public final void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
    {
      AppMethodBeat.i(254857);
      paramContextMenu.add(0, 1, 0, (CharSequence)this.tCh.getString(a.g.app_delete));
      AppMethodBeat.o(254857);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "menuItem", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "index", "", "onMMMenuItemSelected", "com/tencent/mm/plugin/card/ui/v2/CardInvalidTicketListUI$showDeleteCardAlert$1$2"})
  static final class i
    implements q.g
  {
    i(CardInvalidTicketListUI paramCardInvalidTicketListUI, View paramView, dib paramdib) {}
    
    public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
    {
      AppMethodBeat.i(255427);
      CardInvalidTicketListUI.a(this.tCh, this.tCk);
      AppMethodBeat.o(255427);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Lcom/tencent/mm/ui/base/MMMenu;", "kotlin.jvm.PlatformType", "onCreateMMMenu"})
  static final class j
    implements q.f
  {
    j(CardInvalidTicketListUI paramCardInvalidTicketListUI) {}
    
    public final void onCreateMMMenu(o paramo)
    {
      AppMethodBeat.i(248389);
      paramo.a(1, this.tCh.getResources().getColor(a.a.red_text_color), (CharSequence)this.tCh.getString(a.g.app_delete));
      AppMethodBeat.o(248389);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "menuItem", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "", "onMMMenuItemSelected"})
  static final class k
    implements q.g
  {
    k(CardInvalidTicketListUI paramCardInvalidTicketListUI, dib paramdib) {}
    
    public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
    {
      AppMethodBeat.i(245588);
      p.j(paramMenuItem, "menuItem");
      switch (paramMenuItem.getItemId())
      {
      }
      for (;;)
      {
        AppMethodBeat.o(245588);
        return;
        paramMenuItem = this.tCh;
        Object localObject = this.tCl;
        if (localObject == null) {
          p.iCn();
        }
        localObject = ((dib)localObject).RFf;
        p.j(localObject, "ticketElement!!.user_card_id");
        CardInvalidTicketListUI.b(paramMenuItem, (String)localObject);
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class l
    implements MenuItem.OnMenuItemClickListener
  {
    l(CardInvalidTicketListUI paramCardInvalidTicketListUI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(112488);
      com.tencent.mm.ui.base.h.a((Context)this.tCh.getContext(), false, this.tCh.getString(a.g.tkE), "", this.tCh.getString(a.g.confirm_dialog_ok), this.tCh.getString(a.g.confirm_dialog_cancel), (DialogInterface.OnClickListener)new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(112485);
          CardInvalidTicketListUI.cKJ();
          com.tencent.mm.plugin.report.service.h.IzE.a(16322, new Object[] { Integer.valueOf(11) });
          AppMethodBeat.o(112485);
        }
      }, (DialogInterface.OnClickListener)CardInvalidTicketListUI.l.2.tCn);
      com.tencent.mm.plugin.report.service.h.IzE.a(16322, new Object[] { Integer.valueOf(10) });
      AppMethodBeat.o(112488);
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.v2.CardInvalidTicketListUI
 * JD-Core Version:    0.7.0.1
 */