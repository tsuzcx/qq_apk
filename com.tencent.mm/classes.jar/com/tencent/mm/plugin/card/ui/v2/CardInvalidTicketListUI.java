package com.tencent.mm.plugin.card.ui.v2;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.h;
import android.support.v7.widget.w;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.co.f;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.widget.recyclerview.LoadMoreRecyclerView;
import com.tencent.mm.plugin.appbrand.widget.recyclerview.LoadMoreRecyclerView.a;
import com.tencent.mm.plugin.appbrand.widget.recyclerview.MRecyclerView.a;
import com.tencent.mm.plugin.appbrand.widget.recyclerview.MRecyclerView.b;
import com.tencent.mm.protocal.protobuf.cyp;
import com.tencent.mm.protocal.protobuf.cys;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.ui.base.o.g;
import com.tencent.mm.ui.base.q;
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

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/card/ui/v2/CardInvalidTicketListUI;", "Lcom/tencent/mm/plugin/card/ui/v2/CardNewBaseUI;", "()V", "firstLoad", "", "isAll", "isLoading", "isShowClearBtn", "mInvalidTicketList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/card/ui/v2/CardTicketListModel;", "mProgressDialog", "Lcom/tencent/mm/ui/base/MMProgressDialog;", "mTicketAdapter", "Lcom/tencent/mm/plugin/card/ui/v2/CardTicketAdapter;", "getMTicketAdapter", "()Lcom/tencent/mm/plugin/card/ui/v2/CardTicketAdapter;", "setMTicketAdapter", "(Lcom/tencent/mm/plugin/card/ui/v2/CardTicketAdapter;)V", "mTicketRv", "Lcom/tencent/mm/plugin/appbrand/widget/recyclerview/LoadMoreRecyclerView;", "getMTicketRv", "()Lcom/tencent/mm/plugin/appbrand/widget/recyclerview/LoadMoreRecyclerView;", "setMTicketRv", "(Lcom/tencent/mm/plugin/appbrand/widget/recyclerview/LoadMoreRecyclerView;)V", "offset", "", "reqNum", "doClearInvalidTicketList", "", "doDeleteInvalidTicket", "cardId", "", "doGetInvalidTicketHomePage", "getLayoutId", "gotoCardDetailUI", "initView", "invalidTicketIds", "loadSnapshot", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onFinishLocationThings", "ret", "isLocationOk", "saveSnapshot", "showDeleteCardAlert", "ticketElement", "Lcom/tencent/mm/protocal/protobuf/PageTicketElement;", "item", "Landroid/view/View;", "showDeleteConfirmDialog", "showProgressDialog", "isShow", "(Ljava/lang/Boolean;)V", "updateModelList", "ticketList", "Lcom/tencent/mm/protocal/protobuf/PageTicketList;", "updateOptionMenu", "Companion", "plugin-card_release"})
public final class CardInvalidTicketListUI
  extends CardNewBaseUI
{
  public static final CardInvalidTicketListUI.a qgj;
  private boolean gWt;
  private q gxX;
  private boolean isLoading;
  private int offset;
  private int qeS;
  private boolean qeT;
  public LoadMoreRecyclerView qgf;
  public a qgg;
  private ArrayList<b> qgh;
  private boolean qgi;
  
  static
  {
    AppMethodBeat.i(112498);
    qgj = new CardInvalidTicketListUI.a((byte)0);
    AppMethodBeat.o(112498);
  }
  
  public CardInvalidTicketListUI()
  {
    AppMethodBeat.i(112497);
    this.qgh = new ArrayList();
    this.qeS = 10;
    this.gWt = true;
    AppMethodBeat.o(112497);
  }
  
  private final void a(cys paramcys)
  {
    AppMethodBeat.i(112495);
    if (paramcys != null)
    {
      Object localObject = paramcys.MDL;
      p.g(localObject, "page_ticket_element");
      if (!((Collection)localObject).isEmpty()) {}
      for (int i = 1; i != 0; i = 0)
      {
        paramcys = paramcys.MDL.iterator();
        while (paramcys.hasNext())
        {
          localObject = (cyp)paramcys.next();
          b localb = new b();
          localb.qgG = ((cyp)localObject);
          localb.type = 2;
          this.qgh.add(localb);
        }
      }
    }
    paramcys = this.qgg;
    if (paramcys == null) {
      p.btv("mTicketAdapter");
    }
    paramcys.a(null, this.qgh, null, null);
    AppMethodBeat.o(112495);
  }
  
  private final void cxf()
  {
    AppMethodBeat.i(112496);
    Log.i("MicroMsg.CardInvalidTicketListUI", "do get invalid ticket: %s, %s, %s, %s", new Object[] { Integer.valueOf(this.offset), Integer.valueOf(this.qeS), Boolean.valueOf(this.qeT), Boolean.valueOf(this.isLoading) });
    if ((!this.qeT) && (!this.isLoading))
    {
      this.isLoading = true;
      new com.tencent.mm.plugin.card.model.a.h(this.offset, this.qeS, this.latitude, this.dTj).aYI().b((com.tencent.mm.vending.c.a)new c(this));
    }
    AppMethodBeat.o(112496);
  }
  
  private final void j(Boolean paramBoolean)
  {
    AppMethodBeat.i(201394);
    if (paramBoolean == null)
    {
      AppMethodBeat.o(201394);
      return;
    }
    if (paramBoolean.booleanValue()) {}
    for (paramBoolean = q.a((Context)getContext(), (CharSequence)getString(2131756029), true, 3, null);; paramBoolean = null)
    {
      this.gxX = paramBoolean;
      AppMethodBeat.o(201394);
      return;
      paramBoolean = this.gxX;
      if (paramBoolean != null) {
        paramBoolean.dismiss();
      }
    }
  }
  
  public final void ad(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(112494);
    Log.i("MicroMsg.CardInvalidTicketListUI", "location finish: [%s, %s], ret: %s, isOk: %s", new Object[] { Float.valueOf(this.latitude), Float.valueOf(this.dTj), Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean) });
    if (this.gWt)
    {
      cxf();
      AppMethodBeat.o(112494);
      return;
    }
    if (!paramBoolean) {
      cxi();
    }
    AppMethodBeat.o(112494);
  }
  
  public final LoadMoreRecyclerView cxd()
  {
    AppMethodBeat.i(112489);
    LoadMoreRecyclerView localLoadMoreRecyclerView = this.qgf;
    if (localLoadMoreRecyclerView == null) {
      p.btv("mTicketRv");
    }
    AppMethodBeat.o(112489);
    return localLoadMoreRecyclerView;
  }
  
  public final a cxe()
  {
    AppMethodBeat.i(112490);
    a locala = this.qgg;
    if (locala == null) {
      p.btv("mTicketAdapter");
    }
    AppMethodBeat.o(112490);
    return locala;
  }
  
  public final int getLayoutId()
  {
    return 2131493453;
  }
  
  public final void initView()
  {
    AppMethodBeat.i(112492);
    Object localObject1 = findViewById(2131299368);
    p.g(localObject1, "findViewById(R.id.ctlu_rv)");
    this.qgf = ((LoadMoreRecyclerView)localObject1);
    this.qgg = new a(true);
    localObject1 = this.qgg;
    if (localObject1 == null) {
      p.btv("mTicketAdapter");
    }
    ((a)localObject1).au(true);
    localObject1 = this.qgf;
    if (localObject1 == null) {
      p.btv("mTicketRv");
    }
    Object localObject2 = this.qgg;
    if (localObject2 == null) {
      p.btv("mTicketAdapter");
    }
    ((LoadMoreRecyclerView)localObject1).setAdapter((RecyclerView.a)localObject2);
    localObject1 = this.qgf;
    if (localObject1 == null) {
      p.btv("mTicketRv");
    }
    getContext();
    ((LoadMoreRecyclerView)localObject1).setLayoutManager((RecyclerView.LayoutManager)new LinearLayoutManager());
    localObject1 = this.qgf;
    if (localObject1 == null) {
      p.btv("mTicketRv");
    }
    ((LoadMoreRecyclerView)localObject1).setEmptyView(findViewById(2131298671));
    localObject1 = this.qgf;
    if (localObject1 == null) {
      p.btv("mTicketRv");
    }
    localObject1 = (TextView)((LoadMoreRecyclerView)localObject1).getEmptyView().findViewById(2131298672);
    p.g(localObject1, "emptyTv");
    ((TextView)localObject1).setText((CharSequence)getString(2131757055));
    localObject1 = this.qgf;
    if (localObject1 == null) {
      p.btv("mTicketRv");
    }
    localObject1 = (WeImageView)((LoadMoreRecyclerView)localObject1).getEmptyView().findViewById(2131298670);
    ((WeImageView)localObject1).setImageResource(2131690447);
    ((WeImageView)localObject1).setIconColor(getResources().getColor(2131099749));
    localObject1 = new w((Context)this, 1);
    ((w)localObject1).setDrawable(getResources().getDrawable(2131231523));
    localObject2 = this.qgf;
    if (localObject2 == null) {
      p.btv("mTicketRv");
    }
    ((LoadMoreRecyclerView)localObject2).b((RecyclerView.h)localObject1);
    localObject1 = this.qgf;
    if (localObject1 == null) {
      p.btv("mTicketRv");
    }
    ((LoadMoreRecyclerView)localObject1).setLoadingView(2131493384);
    localObject1 = this.qgf;
    if (localObject1 == null) {
      p.btv("mTicketRv");
    }
    ((LoadMoreRecyclerView)localObject1).setOnLoadingStateChangedListener((LoadMoreRecyclerView.a)new d(this));
    localObject1 = this.qgf;
    if (localObject1 == null) {
      p.btv("mTicketRv");
    }
    ((LoadMoreRecyclerView)localObject1).setOnItemClickListener((MRecyclerView.a)new e(this));
    localObject1 = this.qgf;
    if (localObject1 == null) {
      p.btv("mTicketRv");
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
    paramBundle = new cys();
    Object localObject = com.tencent.mm.plugin.card.model.a.a.pVg;
    p.h(paramBundle, "invalidTicketList");
    Log.d(com.tencent.mm.plugin.card.model.a.a.access$getTAG$cp(), "load invalid ticket page snapshot");
    localObject = g.aAh();
    p.g(localObject, "MMKernel.storage()");
    localObject = (String)((e)localObject).azQ().i(ar.a.OhL);
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
      p.g(localObject, "(this as java.lang.String).getBytes(charset)");
      paramBundle.parseFrom((byte[])localObject);
    }
    a(paramBundle);
    setMMTitle(2131766757);
    setBackBtn((MenuItem.OnMenuItemClickListener)new CardInvalidTicketListUI.g(this));
    com.tencent.mm.plugin.report.service.h.CyF.a(16322, new Object[] { Integer.valueOf(9) });
    AppMethodBeat.o(112491);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(112493);
    super.onDestroy();
    Object localObject1 = new cys();
    ((cys)localObject1).MDL = new LinkedList();
    Object localObject2 = this.qgh.iterator();
    while (((Iterator)localObject2).hasNext())
    {
      cyp localcyp = ((b)((Iterator)localObject2).next()).qgG;
      if (localcyp != null) {
        ((cys)localObject1).MDL.add(localcyp);
      }
    }
    localObject2 = com.tencent.mm.plugin.card.model.a.a.pVg;
    p.h(localObject1, "invalidTicketList");
    Log.d(com.tencent.mm.plugin.card.model.a.a.access$getTAG$cp(), "save invalid ticket snapshot");
    localObject1 = ((cys)localObject1).toByteArray();
    p.g(localObject1, "invalidTicketList.toByteArray()");
    localObject1 = new String((byte[])localObject1, d.ISO_8859_1);
    localObject2 = g.aAh();
    p.g(localObject2, "MMKernel.storage()");
    ((e)localObject2).azQ().set(ar.a.OhL, localObject1);
    AppMethodBeat.o(112493);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/DeleteCardInInvalidListResponse;", "kotlin.jvm.PlatformType", "call"})
  static final class b<_Ret, _Var>
    implements com.tencent.mm.vending.c.a<_Ret, _Var>
  {
    b(CardInvalidTicketListUI paramCardInvalidTicketListUI, String paramString) {}
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "kotlin.jvm.PlatformType", "it", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/GetMktInvalidTicketHomePageResponse;", "call"})
  static final class c<_Ret, _Var>
    implements com.tencent.mm.vending.c.a<_Ret, _Var>
  {
    c(CardInvalidTicketListUI paramCardInvalidTicketListUI) {}
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "parent", "Lcom/tencent/mm/plugin/appbrand/widget/recyclerview/LoadMoreRecyclerView;", "kotlin.jvm.PlatformType", "adapter", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "onLoadMore"})
  static final class d
    implements LoadMoreRecyclerView.a
  {
    d(CardInvalidTicketListUI paramCardInvalidTicketListUI) {}
    
    public final void bYy()
    {
      AppMethodBeat.i(112479);
      CardInvalidTicketListUI.a(this.qgk);
      AppMethodBeat.o(112479);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "parent", "Landroid/support/v7/widget/RecyclerView;", "kotlin.jvm.PlatformType", "view", "Landroid/view/View;", "position", "", "id", "", "onItemClick"})
  static final class e
    implements MRecyclerView.a
  {
    e(CardInvalidTicketListUI paramCardInvalidTicketListUI) {}
    
    public final void S(View paramView, int paramInt)
    {
      AppMethodBeat.i(112480);
      Log.i("MicroMsg.CardInvalidTicketListUI", "click item");
      paramView = this.qgk.cxe().EB(paramInt);
      if (paramView != null)
      {
        switch (paramView.type)
        {
        }
        do
        {
          AppMethodBeat.o(112480);
          return;
          localObject = paramView.qgG;
        } while (localObject == null);
        paramView = this.qgk;
        Object localObject = ((cyp)localObject).KDM;
        p.g(localObject, "user_card_id");
        CardInvalidTicketListUI.a(paramView, (String)localObject);
        AppMethodBeat.o(112480);
        return;
      }
      AppMethodBeat.o(112480);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "parent", "Landroid/support/v7/widget/RecyclerView;", "kotlin.jvm.PlatformType", "view", "Landroid/view/View;", "position", "", "id", "", "onItemLongClick"})
  static final class f
    implements MRecyclerView.b
  {
    f(CardInvalidTicketListUI paramCardInvalidTicketListUI) {}
    
    public final boolean T(View paramView, int paramInt)
    {
      AppMethodBeat.i(112483);
      Log.i("MicroMsg.CardInvalidTicketListUI", "long click item");
      Object localObject = this.qgk.cxe().EB(paramInt);
      if (localObject != null) {
        switch (((b)localObject).type)
        {
        }
      }
      for (;;)
      {
        AppMethodBeat.o(112483);
        return false;
        localObject = ((b)localObject).qgG;
        CardInvalidTicketListUI localCardInvalidTicketListUI = this.qgk;
        p.g(paramView, "view");
        CardInvalidTicketListUI.a(localCardInvalidTicketListUI, (cyp)localObject, paramView);
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "menuItem", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "", "onMMMenuItemSelected"})
  static final class k
    implements o.g
  {
    k(CardInvalidTicketListUI paramCardInvalidTicketListUI, cyp paramcyp) {}
    
    public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
    {
      AppMethodBeat.i(201393);
      p.g(paramMenuItem, "menuItem");
      switch (paramMenuItem.getItemId())
      {
      }
      for (;;)
      {
        AppMethodBeat.o(201393);
        return;
        paramMenuItem = this.qgk;
        Object localObject = this.qgo;
        if (localObject == null) {
          p.hyc();
        }
        localObject = ((cyp)localObject).KDM;
        p.g(localObject, "ticketElement!!.user_card_id");
        CardInvalidTicketListUI.b(paramMenuItem, (String)localObject);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.v2.CardInvalidTicketListUI
 * JD-Core Version:    0.7.0.1
 */