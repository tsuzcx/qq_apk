package com.tencent.mm.plugin.card.ui.v2;

import a.f.b.j;
import a.l;
import a.v;
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
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cm.f;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.widget.recyclerview.LoadMoreRecyclerView;
import com.tencent.mm.plugin.appbrand.widget.recyclerview.LoadMoreRecyclerView.a;
import com.tencent.mm.plugin.appbrand.widget.recyclerview.MRecyclerView.a;
import com.tencent.mm.plugin.appbrand.widget.recyclerview.MRecyclerView.b;
import com.tencent.mm.plugin.card.model.a.i;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.bkj;
import com.tencent.mm.protocal.protobuf.bkm;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/card/ui/v2/CardInvalidTicketListUI;", "Lcom/tencent/mm/plugin/card/ui/v2/CardNewBaseUI;", "()V", "firstLoad", "", "isAll", "isLoading", "isShowClearBtn", "mInvalidTicketList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/card/ui/v2/CardTicketListModel;", "mTicketAdapter", "Lcom/tencent/mm/plugin/card/ui/v2/CardTicketAdapter;", "getMTicketAdapter", "()Lcom/tencent/mm/plugin/card/ui/v2/CardTicketAdapter;", "setMTicketAdapter", "(Lcom/tencent/mm/plugin/card/ui/v2/CardTicketAdapter;)V", "mTicketRv", "Lcom/tencent/mm/plugin/appbrand/widget/recyclerview/LoadMoreRecyclerView;", "getMTicketRv", "()Lcom/tencent/mm/plugin/appbrand/widget/recyclerview/LoadMoreRecyclerView;", "setMTicketRv", "(Lcom/tencent/mm/plugin/appbrand/widget/recyclerview/LoadMoreRecyclerView;)V", "offset", "", "reqNum", "doClearInvalidTicketList", "", "doDeleteInvalidTicket", "cardId", "", "doGetInvalidTicketHomePage", "getLayoutId", "gotoCardDetailUI", "initView", "invalidTicketIds", "loadSnapshot", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onFinishLocationThings", "ret", "isLocationOk", "saveSnapshot", "updateModelList", "ticketList", "Lcom/tencent/mm/protocal/protobuf/PageTicketList;", "updateOptionMenu", "Companion", "plugin-card_release"})
public final class CardInvalidTicketListUI
  extends CardNewBaseUI
{
  public static final CardInvalidTicketListUI.a kAg;
  private boolean evP;
  private boolean isLoading;
  public LoadMoreRecyclerView kAc;
  public c kAd;
  private ArrayList<d> kAe;
  private boolean kAf;
  private int kyR;
  private boolean kyS;
  private int offset;
  
  static
  {
    AppMethodBeat.i(89273);
    kAg = new CardInvalidTicketListUI.a((byte)0);
    AppMethodBeat.o(89273);
  }
  
  public CardInvalidTicketListUI()
  {
    AppMethodBeat.i(89272);
    this.kAe = new ArrayList();
    this.kyR = 10;
    this.evP = true;
    AppMethodBeat.o(89272);
  }
  
  private final void a(bkm parambkm)
  {
    AppMethodBeat.i(89270);
    if (parambkm != null)
    {
      Object localObject = parambkm.xzf;
      j.p(localObject, "page_ticket_element");
      if (!((Collection)localObject).isEmpty()) {}
      for (int i = 1; i != 0; i = 0)
      {
        parambkm = parambkm.xzf.iterator();
        while (parambkm.hasNext())
        {
          localObject = (bkj)parambkm.next();
          d locald = new d();
          locald.kAB = ((bkj)localObject);
          locald.type = 2;
          this.kAe.add(locald);
        }
      }
    }
    parambkm = this.kAd;
    if (parambkm == null) {
      j.ays("mTicketAdapter");
    }
    parambkm.a(null, this.kAe, null);
    AppMethodBeat.o(89270);
  }
  
  private final void bfl()
  {
    AppMethodBeat.i(89271);
    ab.i("MicroMsg.CardInvalidTicketListUI", "do get invalid ticket: %s, %s, %s, %s", new Object[] { Integer.valueOf(this.offset), Integer.valueOf(this.kyR), Boolean.valueOf(this.kyS), Boolean.valueOf(this.isLoading) });
    if ((!this.kyS) && (!this.isLoading))
    {
      this.isLoading = true;
      new i(this.offset, this.kyR, this.cyV, this.cAH).adl().b((com.tencent.mm.vending.c.a)new CardInvalidTicketListUI.d(this));
    }
    AppMethodBeat.o(89271);
  }
  
  public final void R(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(89269);
    ab.i("MicroMsg.CardInvalidTicketListUI", "location finish: [%s, %s], ret: %s, isOk: %s", new Object[] { Float.valueOf(this.cyV), Float.valueOf(this.cAH), Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean) });
    if (this.evP)
    {
      bfl();
      AppMethodBeat.o(89269);
      return;
    }
    if (!paramBoolean) {
      bfn();
    }
    AppMethodBeat.o(89269);
  }
  
  public final LoadMoreRecyclerView bfj()
  {
    AppMethodBeat.i(89264);
    LoadMoreRecyclerView localLoadMoreRecyclerView = this.kAc;
    if (localLoadMoreRecyclerView == null) {
      j.ays("mTicketRv");
    }
    AppMethodBeat.o(89264);
    return localLoadMoreRecyclerView;
  }
  
  public final c bfk()
  {
    AppMethodBeat.i(89265);
    c localc = this.kAd;
    if (localc == null) {
      j.ays("mTicketAdapter");
    }
    AppMethodBeat.o(89265);
    return localc;
  }
  
  public final int getLayoutId()
  {
    return 2130969011;
  }
  
  public final void initView()
  {
    AppMethodBeat.i(89267);
    Object localObject1 = findViewById(2131822391);
    j.p(localObject1, "findViewById(R.id.ctlu_rv)");
    this.kAc = ((LoadMoreRecyclerView)localObject1);
    this.kAd = new c(true);
    localObject1 = this.kAc;
    if (localObject1 == null) {
      j.ays("mTicketRv");
    }
    Object localObject2 = this.kAd;
    if (localObject2 == null) {
      j.ays("mTicketAdapter");
    }
    ((LoadMoreRecyclerView)localObject1).setAdapter((RecyclerView.a)localObject2);
    localObject1 = this.kAc;
    if (localObject1 == null) {
      j.ays("mTicketRv");
    }
    getContext();
    ((LoadMoreRecyclerView)localObject1).setLayoutManager((RecyclerView.i)new LinearLayoutManager());
    localObject1 = this.kAc;
    if (localObject1 == null) {
      j.ays("mTicketRv");
    }
    ((LoadMoreRecyclerView)localObject1).setEmptyView(findViewById(2131822219));
    localObject1 = this.kAc;
    if (localObject1 == null) {
      j.ays("mTicketRv");
    }
    localObject1 = (TextView)((LoadMoreRecyclerView)localObject1).getEmptyView().findViewById(2131822220);
    j.p(localObject1, "emptyTv");
    ((TextView)localObject1).setText((CharSequence)getString(2131298019));
    localObject1 = new w((Context)this);
    ((w)localObject1).setDrawable(getResources().getDrawable(2130838131));
    localObject2 = this.kAc;
    if (localObject2 == null) {
      j.ays("mTicketRv");
    }
    ((LoadMoreRecyclerView)localObject2).b((RecyclerView.h)localObject1);
    localObject1 = this.kAc;
    if (localObject1 == null) {
      j.ays("mTicketRv");
    }
    ((LoadMoreRecyclerView)localObject1).setLoadingView(2130968952);
    localObject1 = this.kAc;
    if (localObject1 == null) {
      j.ays("mTicketRv");
    }
    ((LoadMoreRecyclerView)localObject1).setOnLoadingStateChangedListener((LoadMoreRecyclerView.a)new CardInvalidTicketListUI.e(this));
    localObject1 = this.kAc;
    if (localObject1 == null) {
      j.ays("mTicketRv");
    }
    ((LoadMoreRecyclerView)localObject1).setOnItemClickListener((MRecyclerView.a)new CardInvalidTicketListUI.f(this));
    localObject1 = this.kAc;
    if (localObject1 == null) {
      j.ays("mTicketRv");
    }
    ((LoadMoreRecyclerView)localObject1).setOnItemLongClickListener((MRecyclerView.b)new CardInvalidTicketListUI.g(this));
    AppMethodBeat.o(89267);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(89266);
    fixStatusbar(true);
    super.onCreate(paramBundle);
    setActionbarColor(Color.parseColor("#f3f3f3"));
    hideActionbarLine();
    initView();
    paramBundle = new bkm();
    Object localObject = com.tencent.mm.plugin.card.model.a.a.kpr;
    j.q(paramBundle, "invalidTicketList");
    ab.d(com.tencent.mm.plugin.card.model.a.a.access$getTAG$cp(), "load invalid ticket page snapshot");
    localObject = g.RL();
    j.p(localObject, "MMKernel.storage()");
    localObject = (String)((e)localObject).Ru().i(ac.a.yLc);
    if (localObject != null)
    {
      Charset localCharset = a.l.d.ISO_8859_1;
      if (localObject == null)
      {
        paramBundle = new v("null cannot be cast to non-null type java.lang.String");
        AppMethodBeat.o(89266);
        throw paramBundle;
      }
      localObject = ((String)localObject).getBytes(localCharset);
      j.p(localObject, "(this as java.lang.String).getBytes(charset)");
      paramBundle.parseFrom((byte[])localObject);
    }
    a(paramBundle);
    setMMTitle(2131304288);
    setBackBtn((MenuItem.OnMenuItemClickListener)new CardInvalidTicketListUI.h(this));
    h.qsU.e(16322, new Object[] { Integer.valueOf(9) });
    AppMethodBeat.o(89266);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(89268);
    super.onDestroy();
    Object localObject1 = new bkm();
    ((bkm)localObject1).xzf = new LinkedList();
    Object localObject2 = this.kAe.iterator();
    while (((Iterator)localObject2).hasNext())
    {
      bkj localbkj = ((d)((Iterator)localObject2).next()).kAB;
      if (localbkj != null) {
        ((bkm)localObject1).xzf.add(localbkj);
      }
    }
    localObject2 = com.tencent.mm.plugin.card.model.a.a.kpr;
    j.q(localObject1, "invalidTicketList");
    ab.d(com.tencent.mm.plugin.card.model.a.a.access$getTAG$cp(), "save invalid ticket snapshot");
    localObject1 = ((bkm)localObject1).toByteArray();
    j.p(localObject1, "invalidTicketList.toByteArray()");
    localObject1 = new String((byte[])localObject1, a.l.d.ISO_8859_1);
    localObject2 = g.RL();
    j.p(localObject2, "MMKernel.storage()");
    ((e)localObject2).Ru().set(ac.a.yLc, localObject1);
    AppMethodBeat.o(89268);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.v2.CardInvalidTicketListUI
 * JD-Core Version:    0.7.0.1
 */