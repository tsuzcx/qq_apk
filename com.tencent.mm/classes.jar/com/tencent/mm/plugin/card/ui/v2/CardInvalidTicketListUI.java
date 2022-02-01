package com.tencent.mm.plugin.card.ui.v2;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.h;
import android.support.v7.widget.RecyclerView.i;
import android.support.v7.widget.w;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cm.f;
import com.tencent.mm.kernel.e;
import com.tencent.mm.plugin.appbrand.widget.recyclerview.LoadMoreRecyclerView;
import com.tencent.mm.plugin.appbrand.widget.recyclerview.LoadMoreRecyclerView.a;
import com.tencent.mm.plugin.appbrand.widget.recyclerview.MRecyclerView.a;
import com.tencent.mm.plugin.appbrand.widget.recyclerview.MRecyclerView.b;
import com.tencent.mm.plugin.card.model.a.h;
import com.tencent.mm.protocal.protobuf.cii;
import com.tencent.mm.protocal.protobuf.cil;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.n.e;
import d.g.b.p;
import d.n.d;
import d.v;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;

@d.l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/card/ui/v2/CardInvalidTicketListUI;", "Lcom/tencent/mm/plugin/card/ui/v2/CardNewBaseUI;", "()V", "firstLoad", "", "isAll", "isLoading", "isShowClearBtn", "mInvalidTicketList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/card/ui/v2/CardTicketListModel;", "mTicketAdapter", "Lcom/tencent/mm/plugin/card/ui/v2/CardTicketAdapter;", "getMTicketAdapter", "()Lcom/tencent/mm/plugin/card/ui/v2/CardTicketAdapter;", "setMTicketAdapter", "(Lcom/tencent/mm/plugin/card/ui/v2/CardTicketAdapter;)V", "mTicketRv", "Lcom/tencent/mm/plugin/appbrand/widget/recyclerview/LoadMoreRecyclerView;", "getMTicketRv", "()Lcom/tencent/mm/plugin/appbrand/widget/recyclerview/LoadMoreRecyclerView;", "setMTicketRv", "(Lcom/tencent/mm/plugin/appbrand/widget/recyclerview/LoadMoreRecyclerView;)V", "offset", "", "reqNum", "doClearInvalidTicketList", "", "doDeleteInvalidTicket", "cardId", "", "doGetInvalidTicketHomePage", "getLayoutId", "gotoCardDetailUI", "initView", "invalidTicketIds", "loadSnapshot", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onFinishLocationThings", "ret", "isLocationOk", "saveSnapshot", "updateModelList", "ticketList", "Lcom/tencent/mm/protocal/protobuf/PageTicketList;", "updateOptionMenu", "Companion", "plugin-card_release"})
public final class CardInvalidTicketListUI
  extends CardNewBaseUI
{
  public static final CardInvalidTicketListUI.a oSv;
  private boolean glB;
  private boolean isLoading;
  private int oRe;
  private boolean oRf;
  public LoadMoreRecyclerView oSr;
  public a oSs;
  private ArrayList<b> oSt;
  private boolean oSu;
  private int offset;
  
  static
  {
    AppMethodBeat.i(112498);
    oSv = new CardInvalidTicketListUI.a((byte)0);
    AppMethodBeat.o(112498);
  }
  
  public CardInvalidTicketListUI()
  {
    AppMethodBeat.i(112497);
    this.oSt = new ArrayList();
    this.oRe = 10;
    this.glB = true;
    AppMethodBeat.o(112497);
  }
  
  private final void a(cil paramcil)
  {
    AppMethodBeat.i(112495);
    if (paramcil != null)
    {
      Object localObject = paramcil.HuN;
      p.g(localObject, "page_ticket_element");
      if (!((Collection)localObject).isEmpty()) {}
      for (int i = 1; i != 0; i = 0)
      {
        paramcil = paramcil.HuN.iterator();
        while (paramcil.hasNext())
        {
          localObject = (cii)paramcil.next();
          b localb = new b();
          localb.oSR = ((cii)localObject);
          localb.type = 2;
          this.oSt.add(localb);
        }
      }
    }
    paramcil = this.oSs;
    if (paramcil == null) {
      p.bdF("mTicketAdapter");
    }
    paramcil.a(null, this.oSt, null, null);
    AppMethodBeat.o(112495);
  }
  
  private final void bZp()
  {
    AppMethodBeat.i(112496);
    ae.i("MicroMsg.CardInvalidTicketListUI", "do get invalid ticket: %s, %s, %s, %s", new Object[] { Integer.valueOf(this.offset), Integer.valueOf(this.oRe), Boolean.valueOf(this.oRf), Boolean.valueOf(this.isLoading) });
    if ((!this.oRf) && (!this.isLoading))
    {
      this.isLoading = true;
      new h(this.offset, this.oRe, this.dzE, this.dBu).aET().b((com.tencent.mm.vending.c.a)new c(this));
    }
    AppMethodBeat.o(112496);
  }
  
  public final void X(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(112494);
    ae.i("MicroMsg.CardInvalidTicketListUI", "location finish: [%s, %s], ret: %s, isOk: %s", new Object[] { Float.valueOf(this.dzE), Float.valueOf(this.dBu), Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean) });
    if (this.glB)
    {
      bZp();
      AppMethodBeat.o(112494);
      return;
    }
    if (!paramBoolean) {
      bZs();
    }
    AppMethodBeat.o(112494);
  }
  
  public final LoadMoreRecyclerView bZn()
  {
    AppMethodBeat.i(112489);
    LoadMoreRecyclerView localLoadMoreRecyclerView = this.oSr;
    if (localLoadMoreRecyclerView == null) {
      p.bdF("mTicketRv");
    }
    AppMethodBeat.o(112489);
    return localLoadMoreRecyclerView;
  }
  
  public final a bZo()
  {
    AppMethodBeat.i(112490);
    a locala = this.oSs;
    if (locala == null) {
      p.bdF("mTicketAdapter");
    }
    AppMethodBeat.o(112490);
    return locala;
  }
  
  public final int getLayoutId()
  {
    return 2131493362;
  }
  
  public final void initView()
  {
    AppMethodBeat.i(112492);
    Object localObject1 = findViewById(2131298893);
    p.g(localObject1, "findViewById(R.id.ctlu_rv)");
    this.oSr = ((LoadMoreRecyclerView)localObject1);
    this.oSs = new a(true);
    localObject1 = this.oSr;
    if (localObject1 == null) {
      p.bdF("mTicketRv");
    }
    Object localObject2 = this.oSs;
    if (localObject2 == null) {
      p.bdF("mTicketAdapter");
    }
    ((LoadMoreRecyclerView)localObject1).setAdapter((RecyclerView.a)localObject2);
    localObject1 = this.oSr;
    if (localObject1 == null) {
      p.bdF("mTicketRv");
    }
    getContext();
    ((LoadMoreRecyclerView)localObject1).setLayoutManager((RecyclerView.i)new LinearLayoutManager());
    localObject1 = this.oSr;
    if (localObject1 == null) {
      p.bdF("mTicketRv");
    }
    ((LoadMoreRecyclerView)localObject1).setEmptyView(findViewById(2131298280));
    localObject1 = this.oSr;
    if (localObject1 == null) {
      p.bdF("mTicketRv");
    }
    localObject1 = (TextView)((LoadMoreRecyclerView)localObject1).getEmptyView().findViewById(2131298281);
    p.g(localObject1, "emptyTv");
    ((TextView)localObject1).setText((CharSequence)getString(2131756961));
    localObject1 = new w((Context)this);
    ((w)localObject1).setDrawable(getResources().getDrawable(2131231459));
    localObject2 = this.oSr;
    if (localObject2 == null) {
      p.bdF("mTicketRv");
    }
    ((LoadMoreRecyclerView)localObject2).b((RecyclerView.h)localObject1);
    localObject1 = this.oSr;
    if (localObject1 == null) {
      p.bdF("mTicketRv");
    }
    ((LoadMoreRecyclerView)localObject1).setLoadingView(2131493294);
    localObject1 = this.oSr;
    if (localObject1 == null) {
      p.bdF("mTicketRv");
    }
    ((LoadMoreRecyclerView)localObject1).setOnLoadingStateChangedListener((LoadMoreRecyclerView.a)new d(this));
    localObject1 = this.oSr;
    if (localObject1 == null) {
      p.bdF("mTicketRv");
    }
    ((LoadMoreRecyclerView)localObject1).setOnItemClickListener((MRecyclerView.a)new e(this));
    localObject1 = this.oSr;
    if (localObject1 == null) {
      p.bdF("mTicketRv");
    }
    ((LoadMoreRecyclerView)localObject1).setOnItemLongClickListener((MRecyclerView.b)new f(this));
    AppMethodBeat.o(112492);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(112491);
    fixStatusbar(true);
    super.onCreate(paramBundle);
    setActionbarColor(Color.parseColor("#f3f3f3"));
    hideActionbarLine();
    initView();
    paramBundle = new cil();
    Object localObject = com.tencent.mm.plugin.card.model.a.a.oHA;
    p.h(paramBundle, "invalidTicketList");
    ae.d(com.tencent.mm.plugin.card.model.a.a.access$getTAG$cp(), "load invalid ticket page snapshot");
    localObject = com.tencent.mm.kernel.g.ajR();
    p.g(localObject, "MMKernel.storage()");
    localObject = (String)((e)localObject).ajA().i(am.a.IZp);
    if (localObject != null)
    {
      Charset localCharset = d.ISO_8859_1;
      if (localObject == null)
      {
        paramBundle = new v("null cannot be cast to non-null type java.lang.String");
        AppMethodBeat.o(112491);
        throw paramBundle;
      }
      localObject = ((String)localObject).getBytes(localCharset);
      p.g(localObject, "(this as java.lang.String).getBytes(charset)");
      paramBundle.parseFrom((byte[])localObject);
    }
    a(paramBundle);
    setMMTitle(2131764414);
    setBackBtn((MenuItem.OnMenuItemClickListener)new CardInvalidTicketListUI.g(this));
    com.tencent.mm.plugin.report.service.g.yxI.f(16322, new Object[] { Integer.valueOf(9) });
    AppMethodBeat.o(112491);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(112493);
    super.onDestroy();
    Object localObject1 = new cil();
    ((cil)localObject1).HuN = new LinkedList();
    Object localObject2 = this.oSt.iterator();
    while (((Iterator)localObject2).hasNext())
    {
      cii localcii = ((b)((Iterator)localObject2).next()).oSR;
      if (localcii != null) {
        ((cil)localObject1).HuN.add(localcii);
      }
    }
    localObject2 = com.tencent.mm.plugin.card.model.a.a.oHA;
    p.h(localObject1, "invalidTicketList");
    ae.d(com.tencent.mm.plugin.card.model.a.a.access$getTAG$cp(), "save invalid ticket snapshot");
    localObject1 = ((cil)localObject1).toByteArray();
    p.g(localObject1, "invalidTicketList.toByteArray()");
    localObject1 = new String((byte[])localObject1, d.ISO_8859_1);
    localObject2 = com.tencent.mm.kernel.g.ajR();
    p.g(localObject2, "MMKernel.storage()");
    ((e)localObject2).ajA().set(am.a.IZp, localObject1);
    AppMethodBeat.o(112493);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "kotlin.jvm.PlatformType", "it", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/DeleteCardInInvalidListResponse;", "call"})
  static final class b<_Ret, _Var>
    implements com.tencent.mm.vending.c.a<_Ret, _Var>
  {
    b(CardInvalidTicketListUI paramCardInvalidTicketListUI, String paramString) {}
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "kotlin.jvm.PlatformType", "it", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/GetMktInvalidTicketHomePageResponse;", "call"})
  static final class c<_Ret, _Var>
    implements com.tencent.mm.vending.c.a<_Ret, _Var>
  {
    c(CardInvalidTicketListUI paramCardInvalidTicketListUI) {}
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "parent", "Lcom/tencent/mm/plugin/appbrand/widget/recyclerview/LoadMoreRecyclerView;", "kotlin.jvm.PlatformType", "adapter", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "onLoadMore"})
  static final class d
    implements LoadMoreRecyclerView.a
  {
    d(CardInvalidTicketListUI paramCardInvalidTicketListUI) {}
    
    public final void bBz()
    {
      AppMethodBeat.i(112479);
      CardInvalidTicketListUI.a(this.oSw);
      AppMethodBeat.o(112479);
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "parent", "Landroid/support/v7/widget/RecyclerView;", "kotlin.jvm.PlatformType", "view", "Landroid/view/View;", "position", "", "id", "", "onItemClick"})
  static final class e
    implements MRecyclerView.a
  {
    e(CardInvalidTicketListUI paramCardInvalidTicketListUI) {}
    
    public final void T(View paramView, int paramInt)
    {
      AppMethodBeat.i(112480);
      ae.i("MicroMsg.CardInvalidTicketListUI", "click item");
      paramView = this.oSw.bZo().AW(paramInt);
      if (paramView != null)
      {
        switch (paramView.type)
        {
        }
        do
        {
          AppMethodBeat.o(112480);
          return;
          localObject = paramView.oSR;
        } while (localObject == null);
        paramView = this.oSw;
        Object localObject = ((cii)localObject).FKu;
        p.g(localObject, "user_card_id");
        CardInvalidTicketListUI.a(paramView, (String)localObject);
        AppMethodBeat.o(112480);
        return;
      }
      AppMethodBeat.o(112480);
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "parent", "Landroid/support/v7/widget/RecyclerView;", "kotlin.jvm.PlatformType", "view", "Landroid/view/View;", "position", "", "id", "", "onItemLongClick"})
  static final class f
    implements MRecyclerView.b
  {
    f(CardInvalidTicketListUI paramCardInvalidTicketListUI) {}
    
    public final boolean U(final View paramView, int paramInt)
    {
      AppMethodBeat.i(112483);
      ae.i("MicroMsg.CardInvalidTicketListUI", "long click item");
      paramView = this.oSw.bZo().AW(paramInt);
      if (paramView != null) {
        switch (paramView.type)
        {
        }
      }
      for (;;)
      {
        AppMethodBeat.o(112483);
        return false;
        com.tencent.mm.ui.tools.l locall = new com.tencent.mm.ui.tools.l((Context)this.oSw.getContext());
        locall.a((n.d)new a(this, paramView));
        locall.a((n.e)new b(this, paramView));
        locall.fOP();
      }
    }
    
    @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Lcom/tencent/mm/ui/base/MMMenu;", "kotlin.jvm.PlatformType", "onCreateMMMenu", "com/tencent/mm/plugin/card/ui/v2/CardInvalidTicketListUI$initView$3$1$1"})
    static final class a
      implements n.d
    {
      a(CardInvalidTicketListUI.f paramf, b paramb) {}
      
      public final void onCreateMMMenu(com.tencent.mm.ui.base.l paraml)
      {
        AppMethodBeat.i(112481);
        paraml.d(1, (CharSequence)this.oSy.oSw.getString(2131755707));
        AppMethodBeat.o(112481);
      }
    }
    
    @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "menuItem", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "index", "", "onMMMenuItemSelected", "com/tencent/mm/plugin/card/ui/v2/CardInvalidTicketListUI$initView$3$1$2"})
    static final class b
      implements n.e
    {
      b(CardInvalidTicketListUI.f paramf, b paramb) {}
      
      public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
      {
        AppMethodBeat.i(112482);
        p.g(paramMenuItem, "menuItem");
        switch (paramMenuItem.getItemId())
        {
        }
        for (;;)
        {
          AppMethodBeat.o(112482);
          return;
          paramMenuItem = this.oSy.oSw;
          Object localObject = paramView.oSR;
          if (localObject == null) {
            p.gkB();
          }
          localObject = ((cii)localObject).FKu;
          p.g(localObject, "model.ticketElement!!.user_card_id");
          CardInvalidTicketListUI.b(paramMenuItem, (String)localObject);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.v2.CardInvalidTicketListUI
 * JD-Core Version:    0.7.0.1
 */