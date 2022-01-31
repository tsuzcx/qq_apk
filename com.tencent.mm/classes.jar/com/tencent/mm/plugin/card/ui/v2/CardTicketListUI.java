package com.tencent.mm.plugin.card.ui.v2;

import a.l;
import a.v;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.h;
import android.support.v7.widget.RecyclerView.i;
import android.support.v7.widget.w;
import android.view.LayoutInflater;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cm.f;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.widget.recyclerview.LoadMoreRecyclerView;
import com.tencent.mm.plugin.appbrand.widget.recyclerview.LoadMoreRecyclerView.a;
import com.tencent.mm.plugin.appbrand.widget.recyclerview.MRecyclerView.a;
import com.tencent.mm.plugin.appbrand.widget.recyclerview.MRecyclerView.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.bkj;
import com.tencent.mm.protocal.protobuf.bkk;
import com.tencent.mm.protocal.protobuf.bkl;
import com.tencent.mm.protocal.protobuf.bkm;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/card/ui/v2/CardTicketListUI;", "Lcom/tencent/mm/plugin/card/ui/v2/CardNewBaseUI;", "()V", "firstLoad", "", "getMktTicketHomePage", "Lcom/tencent/mm/plugin/card/model/v2/CgiGetMktTicketHomePage;", "isAll", "isLoading", "jumpList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/card/ui/v2/CardTicketListModel;", "licenseList", "mEmptyView", "Landroid/view/ViewGroup;", "mFooterView", "mTicketAdapter", "Lcom/tencent/mm/plugin/card/ui/v2/CardTicketAdapter;", "mTicketRv", "Lcom/tencent/mm/plugin/appbrand/widget/recyclerview/LoadMoreRecyclerView;", "offset", "", "reqNum", "ticketList", "adjustFooterView", "", "doDeleteTicket", "cardId", "", "doGetTicketHomePage", "getLayoutId", "gotoCardDetailUI", "initView", "loadSnapshot", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onFinishLocationThings", "ret", "isLocationOk", "saveSnapshot", "updateModelList", "Lcom/tencent/mm/protocal/protobuf/PageTicketJumpList;", "Lcom/tencent/mm/protocal/protobuf/PageTicketList;", "Companion", "plugin-card_release"})
public final class CardTicketListUI
  extends CardNewBaseUI
{
  public static final a kAD;
  private boolean evP;
  private boolean isLoading;
  private com.tencent.mm.plugin.card.model.a.j kAC;
  private LoadMoreRecyclerView kAc;
  private c kAd;
  private final ArrayList<d> kAt;
  private final ArrayList<d> kAu;
  private final ArrayList<d> kAv;
  private ViewGroup kyN;
  private ViewGroup kyO;
  private int kyR;
  private boolean kyS;
  private int offset;
  
  static
  {
    AppMethodBeat.i(89319);
    kAD = new a((byte)0);
    AppMethodBeat.o(89319);
  }
  
  public CardTicketListUI()
  {
    AppMethodBeat.i(89318);
    this.kyR = 10;
    this.evP = true;
    this.kAt = new ArrayList();
    this.kAu = new ArrayList();
    this.kAv = new ArrayList();
    AppMethodBeat.o(89318);
  }
  
  private final void Iq(final String paramString)
  {
    AppMethodBeat.i(89316);
    ab.i("MicroMsg.CardTicketListUI", "do delete ticket: %s", new Object[] { paramString });
    new com.tencent.mm.plugin.card.model.a.d(paramString).adl().b((com.tencent.mm.vending.c.a)new c(this, paramString));
    AppMethodBeat.o(89316);
  }
  
  private final void a(bkl parambkl, bkm parambkm1, bkm parambkm2)
  {
    AppMethodBeat.i(89315);
    Object localObject;
    int i;
    if (parambkl != null)
    {
      this.kAv.clear();
      localObject = parambkl.xze;
      a.f.b.j.p(localObject, "page_ticket_jump_element");
      if (!((Collection)localObject).isEmpty()) {}
      for (i = 1; i != 0; i = 0)
      {
        parambkl = parambkl.xze.iterator();
        while (parambkl.hasNext())
        {
          localObject = (bkk)parambkl.next();
          d locald = new d();
          locald.kAA = ((bkk)localObject);
          locald.type = 1;
          this.kAv.add(locald);
        }
      }
    }
    if (parambkm1 != null)
    {
      parambkl = parambkm1.xzf;
      a.f.b.j.p(parambkl, "page_ticket_element");
      if (!((Collection)parambkl).isEmpty()) {}
      for (i = 1; i != 0; i = 0)
      {
        parambkl = parambkm1.xzf.iterator();
        while (parambkl.hasNext())
        {
          parambkm1 = (bkj)parambkl.next();
          localObject = new d();
          ((d)localObject).kAB = parambkm1;
          ((d)localObject).type = 2;
          this.kAt.add(localObject);
        }
      }
    }
    if (parambkm2 != null)
    {
      parambkl = parambkm2.xzf;
      a.f.b.j.p(parambkl, "page_ticket_element");
      if (!((Collection)parambkl).isEmpty()) {}
      for (i = 1; i != 0; i = 0)
      {
        parambkl = parambkm2.xzf.iterator();
        while (parambkl.hasNext())
        {
          parambkm1 = (bkj)parambkl.next();
          parambkm2 = new d();
          parambkm2.kAB = parambkm1;
          parambkm2.type = 2;
          this.kAu.add(parambkm2);
        }
      }
    }
    if (!((Collection)this.kAv).isEmpty())
    {
      i = 1;
      if (i == 0)
      {
        if (((Collection)this.kAt).isEmpty()) {
          break label503;
        }
        i = 1;
        label362:
        if (i == 0) {
          break label515;
        }
      }
      if (((Collection)this.kAu).isEmpty()) {
        break label509;
      }
      i = 1;
      label385:
      if (i == 0) {
        break label515;
      }
      parambkl = this.kAd;
      if (parambkl == null) {
        a.f.b.j.ays("mTicketAdapter");
      }
      parambkm1 = getString(2131298078);
      a.f.b.j.p(parambkm1, "getString(R.string.card_ticket_section_title)");
      parambkl.Io(parambkm1);
      parambkl = this.kAd;
      if (parambkl == null) {
        a.f.b.j.ays("mTicketAdapter");
      }
      parambkm1 = getString(2131297969);
      a.f.b.j.p(parambkm1, "getString(R.string.card_license_section_title)");
      parambkl.Ip(parambkm1);
    }
    for (;;)
    {
      parambkl = this.kAd;
      if (parambkl == null) {
        a.f.b.j.ays("mTicketAdapter");
      }
      parambkl.a(this.kAv, this.kAt, this.kAu);
      AppMethodBeat.o(89315);
      return;
      i = 0;
      break;
      label503:
      i = 0;
      break label362;
      label509:
      i = 0;
      break label385;
      label515:
      parambkl = this.kAd;
      if (parambkl == null) {
        a.f.b.j.ays("mTicketAdapter");
      }
      parambkl.Io("");
      parambkl = this.kAd;
      if (parambkl == null) {
        a.f.b.j.ays("mTicketAdapter");
      }
      parambkl.Ip("");
    }
  }
  
  private final void bfo()
  {
    AppMethodBeat.i(89317);
    ab.i("MicroMsg.CardTicketListUI", "do get ticket: %s, %s, %s, %s", new Object[] { Integer.valueOf(this.offset), Integer.valueOf(this.kyR), Boolean.valueOf(this.kyS), Boolean.valueOf(this.isLoading) });
    if ((!this.kyS) && (!this.isLoading))
    {
      this.isLoading = true;
      this.kAC = new com.tencent.mm.plugin.card.model.a.j(this.offset, this.kyR, this.cyV, this.cAH);
      com.tencent.mm.plugin.card.model.a.j localj = this.kAC;
      if (localj == null) {
        a.f.b.j.ebi();
      }
      localj.adl().b((com.tencent.mm.vending.c.a)new CardTicketListUI.d(this));
    }
    AppMethodBeat.o(89317);
  }
  
  public final void R(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(89314);
    ab.i("MicroMsg.CardTicketListUI", "location finish: [%s, %s], ret: %s, isOk: %s", new Object[] { Float.valueOf(this.cyV), Float.valueOf(this.cAH), Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean) });
    if (this.evP)
    {
      bfo();
      AppMethodBeat.o(89314);
      return;
    }
    if (!paramBoolean) {
      bfn();
    }
    AppMethodBeat.o(89314);
  }
  
  public final int getLayoutId()
  {
    return 2130969011;
  }
  
  public final void initView()
  {
    AppMethodBeat.i(89311);
    Object localObject1 = findViewById(2131822391);
    a.f.b.j.p(localObject1, "findViewById(R.id.ctlu_rv)");
    this.kAc = ((LoadMoreRecyclerView)localObject1);
    this.kAd = new c();
    localObject1 = this.kAc;
    if (localObject1 == null) {
      a.f.b.j.ays("mTicketRv");
    }
    Object localObject2 = this.kAd;
    if (localObject2 == null) {
      a.f.b.j.ays("mTicketAdapter");
    }
    ((LoadMoreRecyclerView)localObject1).setAdapter((RecyclerView.a)localObject2);
    localObject1 = this.kAc;
    if (localObject1 == null) {
      a.f.b.j.ays("mTicketRv");
    }
    getContext();
    ((LoadMoreRecyclerView)localObject1).setLayoutManager((RecyclerView.i)new LinearLayoutManager());
    localObject1 = new w((Context)this);
    ((w)localObject1).setDrawable(getResources().getDrawable(2130838131));
    localObject2 = this.kAc;
    if (localObject2 == null) {
      a.f.b.j.ays("mTicketRv");
    }
    ((LoadMoreRecyclerView)localObject2).b((RecyclerView.h)localObject1);
    localObject1 = this.kAc;
    if (localObject1 == null) {
      a.f.b.j.ays("mTicketRv");
    }
    ((LoadMoreRecyclerView)localObject1).setLoadingView(2130968952);
    localObject1 = LayoutInflater.from((Context)this);
    localObject2 = this.kAc;
    if (localObject2 == null) {
      a.f.b.j.ays("mTicketRv");
    }
    localObject1 = ((LayoutInflater)localObject1).inflate(2130968950, (ViewGroup)localObject2, false);
    if (localObject1 == null)
    {
      localObject1 = new v("null cannot be cast to non-null type android.view.ViewGroup");
      AppMethodBeat.o(89311);
      throw ((Throwable)localObject1);
    }
    this.kyN = ((ViewGroup)localObject1);
    localObject1 = this.kyN;
    if (localObject1 == null) {
      a.f.b.j.ays("mFooterView");
    }
    ((TextView)((ViewGroup)localObject1).findViewById(2131822221)).setOnClickListener((View.OnClickListener)new CardTicketListUI.e(this));
    localObject1 = this.kAc;
    if (localObject1 == null) {
      a.f.b.j.ays("mTicketRv");
    }
    localObject2 = this.kyN;
    if (localObject2 == null) {
      a.f.b.j.ays("mFooterView");
    }
    ((LoadMoreRecyclerView)localObject1).addFooterView((View)localObject2);
    localObject1 = this.kyN;
    if (localObject1 == null) {
      a.f.b.j.ays("mFooterView");
    }
    ((ViewGroup)localObject1).setVisibility(8);
    localObject1 = findViewById(2131822219);
    a.f.b.j.p(localObject1, "findViewById(R.id.chpe_root_layout)");
    this.kyO = ((ViewGroup)localObject1);
    localObject1 = this.kAc;
    if (localObject1 == null) {
      a.f.b.j.ays("mTicketRv");
    }
    localObject2 = this.kyO;
    if (localObject2 == null) {
      a.f.b.j.ays("mEmptyView");
    }
    ((LoadMoreRecyclerView)localObject1).setEmptyView((View)localObject2);
    localObject1 = this.kAc;
    if (localObject1 == null) {
      a.f.b.j.ays("mTicketRv");
    }
    ((LoadMoreRecyclerView)localObject1).setOnLoadingStateChangedListener((LoadMoreRecyclerView.a)new CardTicketListUI.f(this));
    localObject1 = this.kAc;
    if (localObject1 == null) {
      a.f.b.j.ays("mTicketRv");
    }
    ((LoadMoreRecyclerView)localObject1).setOnItemClickListener((MRecyclerView.a)new CardTicketListUI.g(this));
    localObject1 = this.kAc;
    if (localObject1 == null) {
      a.f.b.j.ays("mTicketRv");
    }
    ((LoadMoreRecyclerView)localObject1).setOnItemLongClickListener((MRecyclerView.b)new CardTicketListUI.h(this));
    AppMethodBeat.o(89311);
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    Object localObject2 = null;
    AppMethodBeat.i(89313);
    Object localObject1;
    if ((paramInt1 == 256) && (paramInt2 == -1))
    {
      if (paramIntent == null) {
        break label62;
      }
      localObject1 = Integer.valueOf(paramIntent.getIntExtra("key_finish_action", -1));
      if (localObject1 != null) {
        break label68;
      }
    }
    label62:
    label68:
    while (((Integer)localObject1).intValue() != 1)
    {
      if (localObject1 != null) {
        break label110;
      }
      super.onActivityResult(paramInt1, paramInt2, paramIntent);
      AppMethodBeat.o(89313);
      return;
      localObject1 = null;
      break;
    }
    for (;;)
    {
      localObject1 = localObject2;
      if (paramIntent != null) {
        localObject1 = paramIntent.getStringExtra("key_card_id");
      }
      a.f.b.j.p(localObject1, "cardId");
      Iq((String)localObject1);
      break;
      label110:
      if (((Integer)localObject1).intValue() != 2) {
        break;
      }
    }
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(89310);
    fixStatusbar(true);
    super.onCreate(paramBundle);
    setActionbarColor(Color.parseColor("#f3f3f3"));
    hideActionbarLine();
    initView();
    paramBundle = new bkl();
    bkm localbkm1 = new bkm();
    bkm localbkm2 = new bkm();
    Object localObject = com.tencent.mm.plugin.card.model.a.a.kpr;
    a.f.b.j.q(paramBundle, "jumpList");
    a.f.b.j.q(localbkm1, "ticketList");
    a.f.b.j.q(localbkm2, "licenseList");
    ab.d(com.tencent.mm.plugin.card.model.a.a.access$getTAG$cp(), "load ticket page snapshot");
    localObject = g.RL();
    a.f.b.j.p(localObject, "MMKernel.storage()");
    localObject = (String)((e)localObject).Ru().i(ac.a.yKZ);
    Charset localCharset;
    if (localObject != null)
    {
      localCharset = a.l.d.ISO_8859_1;
      if (localObject == null)
      {
        paramBundle = new v("null cannot be cast to non-null type java.lang.String");
        AppMethodBeat.o(89310);
        throw paramBundle;
      }
      localObject = ((String)localObject).getBytes(localCharset);
      a.f.b.j.p(localObject, "(this as java.lang.String).getBytes(charset)");
      paramBundle.parseFrom((byte[])localObject);
    }
    localObject = g.RL();
    a.f.b.j.p(localObject, "MMKernel.storage()");
    localObject = (String)((e)localObject).Ru().i(ac.a.yLa);
    if (localObject != null)
    {
      localCharset = a.l.d.ISO_8859_1;
      if (localObject == null)
      {
        paramBundle = new v("null cannot be cast to non-null type java.lang.String");
        AppMethodBeat.o(89310);
        throw paramBundle;
      }
      localObject = ((String)localObject).getBytes(localCharset);
      a.f.b.j.p(localObject, "(this as java.lang.String).getBytes(charset)");
      localbkm1.parseFrom((byte[])localObject);
    }
    localObject = g.RL();
    a.f.b.j.p(localObject, "MMKernel.storage()");
    localObject = (String)((e)localObject).Ru().i(ac.a.yLb);
    if (localObject != null)
    {
      localCharset = a.l.d.ISO_8859_1;
      if (localObject == null)
      {
        paramBundle = new v("null cannot be cast to non-null type java.lang.String");
        AppMethodBeat.o(89310);
        throw paramBundle;
      }
      localObject = ((String)localObject).getBytes(localCharset);
      a.f.b.j.p(localObject, "(this as java.lang.String).getBytes(charset)");
      localbkm2.parseFrom((byte[])localObject);
    }
    a(paramBundle, localbkm1, localbkm2);
    setMMTitle(2131304289);
    setBackBtn((MenuItem.OnMenuItemClickListener)new CardTicketListUI.i(this));
    h.qsU.e(16322, new Object[] { Integer.valueOf(6) });
    AppMethodBeat.o(89310);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(89312);
    super.onDestroy();
    Object localObject1 = this.kAC;
    if (localObject1 != null) {
      ((com.tencent.mm.plugin.card.model.a.j)localObject1).cancel();
    }
    ab.i("MicroMsg.CardTicketListUI", "do save snapshot");
    Object localObject3 = new bkl();
    ((bkl)localObject3).xze = new LinkedList();
    localObject1 = this.kAv.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = ((d)((Iterator)localObject1).next()).kAA;
      if (localObject2 != null) {
        ((bkl)localObject3).xze.add(localObject2);
      }
    }
    Object localObject2 = new bkm();
    ((bkm)localObject2).xzf = new LinkedList();
    localObject1 = this.kAt.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject4 = ((d)((Iterator)localObject1).next()).kAB;
      if (localObject4 != null) {
        ((bkm)localObject2).xzf.add(localObject4);
      }
    }
    localObject1 = new bkm();
    ((bkm)localObject1).xzf = new LinkedList();
    Object localObject4 = this.kAu.iterator();
    while (((Iterator)localObject4).hasNext())
    {
      bkj localbkj = ((d)((Iterator)localObject4).next()).kAB;
      if (localbkj != null) {
        ((bkm)localObject1).xzf.add(localbkj);
      }
    }
    localObject4 = com.tencent.mm.plugin.card.model.a.a.kpr;
    a.f.b.j.q(localObject3, "jumpList");
    a.f.b.j.q(localObject2, "ticketList");
    a.f.b.j.q(localObject1, "licenseList");
    ab.d(com.tencent.mm.plugin.card.model.a.a.access$getTAG$cp(), "save ticket page snapshot");
    localObject3 = ((bkl)localObject3).toByteArray();
    a.f.b.j.p(localObject3, "jumpList.toByteArray()");
    localObject3 = new String((byte[])localObject3, a.l.d.ISO_8859_1);
    localObject4 = g.RL();
    a.f.b.j.p(localObject4, "MMKernel.storage()");
    ((e)localObject4).Ru().set(ac.a.yKZ, localObject3);
    localObject2 = ((bkm)localObject2).toByteArray();
    a.f.b.j.p(localObject2, "ticketList.toByteArray()");
    localObject2 = new String((byte[])localObject2, a.l.d.ISO_8859_1);
    localObject3 = g.RL();
    a.f.b.j.p(localObject3, "MMKernel.storage()");
    ((e)localObject3).Ru().set(ac.a.yLa, localObject2);
    localObject1 = ((bkm)localObject1).toByteArray();
    a.f.b.j.p(localObject1, "licenseList.toByteArray()");
    localObject1 = new String((byte[])localObject1, a.l.d.ISO_8859_1);
    localObject2 = g.RL();
    a.f.b.j.p(localObject2, "MMKernel.storage()");
    ((e)localObject2).Ru().set(ac.a.yLb, localObject1);
    AppMethodBeat.o(89312);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/card/ui/v2/CardTicketListUI$Companion;", "", "()V", "REQ_CARD_DETAIL", "", "TAG", "", "plugin-card_release"})
  public static final class a {}
  
  @l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(CardTicketListUI paramCardTicketListUI) {}
    
    public final void run()
    {
      AppMethodBeat.i(89298);
      Object localObject = (ViewGroup)this.kAE.findViewById(2131820898);
      if (localObject == null)
      {
        AppMethodBeat.o(89298);
        return;
      }
      int i = ((ViewGroup)localObject).getHeight();
      int j = CardTicketListUI.d(this.kAE).computeVerticalScrollRange();
      ab.d("MicroMsg.CardTicketListUI", "range: %s, extent: %s, contentHeight: %s", new Object[] { Integer.valueOf(j), Integer.valueOf(CardTicketListUI.d(this.kAE).computeVerticalScrollExtent()), Integer.valueOf(i) });
      if (i > j)
      {
        i -= j;
        if (i >= 0)
        {
          j = CardTicketListUI.e(this.kAE).getPaddingTop();
          int k = CardTicketListUI.e(this.kAE).getPaddingBottom();
          CardTicketListUI.e(this.kAE).setPadding(0, i + j, 0, k);
        }
      }
      for (;;)
      {
        localObject = (TextView)CardTicketListUI.e(this.kAE).findViewById(2131822221);
        a.f.b.j.p(localObject, "faqTv");
        ((TextView)localObject).setText((CharSequence)this.kAE.getString(2131304288));
        ((TextView)localObject).setVisibility(0);
        AppMethodBeat.o(89298);
        return;
        CardTicketListUI.e(this.kAE).setPadding(0, com.tencent.mm.cb.a.fromDPToPix((Context)this.kAE.getContext(), 48), 0, com.tencent.mm.cb.a.fromDPToPix((Context)this.kAE.getContext(), 24));
      }
    }
  }
  
  @l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "kotlin.jvm.PlatformType", "it", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/DeleteCardInTicketListResponse;", "call"})
  static final class c<_Ret, _Var>
    implements com.tencent.mm.vending.c.a<_Ret, _Var>
  {
    c(CardTicketListUI paramCardTicketListUI, String paramString) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.v2.CardTicketListUI
 * JD-Core Version:    0.7.0.1
 */