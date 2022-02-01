package com.tencent.mm.plugin.card.ui.v2;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.h;
import android.support.v7.widget.RecyclerView.i;
import android.support.v7.widget.w;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cm.f;
import com.tencent.mm.kernel.e;
import com.tencent.mm.plugin.appbrand.widget.recyclerview.LoadMoreRecyclerView;
import com.tencent.mm.plugin.appbrand.widget.recyclerview.LoadMoreRecyclerView.a;
import com.tencent.mm.plugin.appbrand.widget.recyclerview.MRecyclerView.a;
import com.tencent.mm.plugin.appbrand.widget.recyclerview.MRecyclerView.b;
import com.tencent.mm.plugin.card.model.a.c;
import com.tencent.mm.plugin.card.model.a.i;
import com.tencent.mm.protocal.protobuf.bzl;
import com.tencent.mm.protocal.protobuf.cii;
import com.tencent.mm.protocal.protobuf.cij;
import com.tencent.mm.protocal.protobuf.cik;
import com.tencent.mm.protocal.protobuf.cil;
import com.tencent.mm.protocal.protobuf.cim;
import com.tencent.mm.protocal.protobuf.ti;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
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

@d.l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/card/ui/v2/CardTicketListUI;", "Lcom/tencent/mm/plugin/card/ui/v2/CardNewBaseUI;", "()V", "firstLoad", "", "getMktTicketHomePage", "Lcom/tencent/mm/plugin/card/model/v2/CgiGetMktTicketHomePage;", "isAll", "isLoading", "jumpList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/card/ui/v2/CardTicketListModel;", "licenseList", "mEmptyView", "Landroid/view/ViewGroup;", "mTicketAdapter", "Lcom/tencent/mm/plugin/card/ui/v2/CardTicketAdapter;", "mTicketRv", "Lcom/tencent/mm/plugin/appbrand/widget/recyclerview/LoadMoreRecyclerView;", "medicareCard", "offset", "", "reqNum", "ticketList", "adjustFooterView", "", "doDeleteTicket", "cardId", "", "doGetTicketHomePage", "getLayoutId", "gotoCardDetailUI", "initView", "loadSnapshot", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onFinishLocationThings", "ret", "isLocationOk", "saveSnapshot", "updateModelList", "Lcom/tencent/mm/protocal/protobuf/PageTicketJumpList;", "Lcom/tencent/mm/protocal/protobuf/PageTicketList;", "underList", "Lcom/tencent/mm/protocal/protobuf/PageUnderList;", "updateTextMenu", "Companion", "plugin-card_release"})
public final class CardTicketListUI
  extends CardNewBaseUI
{
  public static final CardTicketListUI.a oSV;
  private boolean glB;
  private boolean isLoading;
  private int oRe;
  private boolean oRf;
  private final ArrayList<b> oSI;
  private final ArrayList<b> oSJ;
  private final ArrayList<b> oSK;
  private b oSN;
  private ViewGroup oST;
  private i oSU;
  private LoadMoreRecyclerView oSr;
  private a oSs;
  private int offset;
  
  static
  {
    AppMethodBeat.i(112545);
    oSV = new CardTicketListUI.a((byte)0);
    AppMethodBeat.o(112545);
  }
  
  public CardTicketListUI()
  {
    AppMethodBeat.i(112544);
    this.oRe = 10;
    this.glB = true;
    this.oSI = new ArrayList();
    this.oSJ = new ArrayList();
    this.oSK = new ArrayList();
    AppMethodBeat.o(112544);
  }
  
  private final void ZM(final String paramString)
  {
    AppMethodBeat.i(112542);
    ae.i("MicroMsg.CardTicketListUI", "do delete ticket: %s", new Object[] { paramString });
    new c(paramString).aET().b((com.tencent.mm.vending.c.a)new b(this, paramString));
    AppMethodBeat.o(112542);
  }
  
  private final void a(cik paramcik, cil paramcil1, cil paramcil2, cim paramcim)
  {
    AppMethodBeat.i(218419);
    Object localObject;
    int i;
    if (paramcik != null)
    {
      this.oSK.clear();
      localObject = paramcik.HuM;
      p.g(localObject, "page_ticket_jump_element");
      if (!((Collection)localObject).isEmpty()) {}
      for (i = 1; i != 0; i = 0)
      {
        paramcik = paramcik.HuM.iterator();
        while (paramcik.hasNext())
        {
          localObject = (cij)paramcik.next();
          b localb = new b();
          localb.oSQ = ((cij)localObject);
          localb.type = 1;
          this.oSK.add(localb);
        }
      }
    }
    if (paramcil1 != null)
    {
      paramcik = paramcil1.HuN;
      p.g(paramcik, "page_ticket_element");
      if (!((Collection)paramcik).isEmpty()) {}
      for (i = 1; i != 0; i = 0)
      {
        paramcik = paramcil1.HuN.iterator();
        while (paramcik.hasNext())
        {
          paramcil1 = (cii)paramcik.next();
          localObject = new b();
          ((b)localObject).oSR = paramcil1;
          ((b)localObject).type = 2;
          this.oSI.add(localObject);
        }
      }
    }
    if (paramcil2 != null)
    {
      paramcik = paramcil2.HuN;
      p.g(paramcik, "page_ticket_element");
      if (!((Collection)paramcik).isEmpty()) {}
      for (i = 1; i != 0; i = 0)
      {
        paramcik = paramcil2.HuN.iterator();
        while (paramcik.hasNext())
        {
          paramcil1 = (cii)paramcik.next();
          paramcil2 = new b();
          paramcil2.oSR = paramcil1;
          paramcil2.type = 2;
          this.oSJ.add(paramcil2);
        }
      }
    }
    if (paramcim != null)
    {
      paramcik = paramcim.HuO;
      if (paramcik != null)
      {
        this.oSN = new b();
        paramcil1 = this.oSN;
        if (paramcil1 == null) {
          p.gkB();
        }
        paramcil1.type = 3;
        paramcil1 = this.oSN;
        if (paramcil1 == null) {
          p.gkB();
        }
        paramcil1.oSS = paramcik;
      }
    }
    if (!((Collection)this.oSK).isEmpty())
    {
      i = 1;
      if (i == 0)
      {
        if (((Collection)this.oSI).isEmpty()) {
          break label574;
        }
        i = 1;
        label422:
        if (i == 0) {
          break label586;
        }
      }
      if (((Collection)this.oSJ).isEmpty()) {
        break label580;
      }
      i = 1;
      label445:
      if ((i == 0) && (this.oSN == null)) {
        break label586;
      }
      paramcik = this.oSs;
      if (paramcik == null) {
        p.bdF("mTicketAdapter");
      }
      paramcil1 = getString(2131757020);
      p.g(paramcil1, "getString(R.string.card_ticket_section_title)");
      paramcik.ZK(paramcil1);
      paramcik = this.oSs;
      if (paramcik == null) {
        p.bdF("mTicketAdapter");
      }
      paramcil1 = getString(2131756911);
      p.g(paramcil1, "getString(R.string.card_license_section_title)");
      paramcik.ZL(paramcil1);
    }
    for (;;)
    {
      paramcik = this.oSs;
      if (paramcik == null) {
        p.bdF("mTicketAdapter");
      }
      paramcik.a(this.oSK, this.oSI, this.oSJ, this.oSN);
      AppMethodBeat.o(218419);
      return;
      i = 0;
      break;
      label574:
      i = 0;
      break label422;
      label580:
      i = 0;
      break label445;
      label586:
      paramcik = this.oSs;
      if (paramcik == null) {
        p.bdF("mTicketAdapter");
      }
      paramcik.ZK("");
      paramcik = this.oSs;
      if (paramcik == null) {
        p.bdF("mTicketAdapter");
      }
      paramcik.ZL("");
    }
  }
  
  private final void bZt()
  {
    AppMethodBeat.i(112543);
    ae.i("MicroMsg.CardTicketListUI", "do get ticket: %s, %s, %s, %s", new Object[] { Integer.valueOf(this.offset), Integer.valueOf(this.oRe), Boolean.valueOf(this.oRf), Boolean.valueOf(this.isLoading) });
    if ((!this.oRf) && (!this.isLoading))
    {
      this.isLoading = true;
      this.oSU = new i(this.offset, this.oRe, this.dzE, this.dBu);
      i locali = this.oSU;
      if (locali == null) {
        p.gkB();
      }
      locali.aET().b((com.tencent.mm.vending.c.a)new c(this));
    }
    AppMethodBeat.o(112543);
  }
  
  public final void X(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(112540);
    ae.i("MicroMsg.CardTicketListUI", "location finish: [%s, %s], ret: %s, isOk: %s", new Object[] { Float.valueOf(this.dzE), Float.valueOf(this.dBu), Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean) });
    if (this.glB)
    {
      bZt();
      AppMethodBeat.o(112540);
      return;
    }
    if (!paramBoolean) {
      bZs();
    }
    AppMethodBeat.o(112540);
  }
  
  public final int getLayoutId()
  {
    return 2131493362;
  }
  
  public final void initView()
  {
    AppMethodBeat.i(112537);
    Object localObject1 = findViewById(2131298893);
    p.g(localObject1, "findViewById(R.id.ctlu_rv)");
    this.oSr = ((LoadMoreRecyclerView)localObject1);
    this.oSs = new a();
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
    localObject1 = findViewById(2131298280);
    p.g(localObject1, "findViewById(R.id.chpe_root_layout)");
    this.oST = ((ViewGroup)localObject1);
    localObject1 = this.oSr;
    if (localObject1 == null) {
      p.bdF("mTicketRv");
    }
    localObject2 = this.oST;
    if (localObject2 == null) {
      p.bdF("mEmptyView");
    }
    ((LoadMoreRecyclerView)localObject1).setEmptyView((View)localObject2);
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
    AppMethodBeat.o(112537);
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    Object localObject2 = null;
    AppMethodBeat.i(112539);
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
      AppMethodBeat.o(112539);
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
      p.g(localObject1, "cardId");
      ZM((String)localObject1);
      break;
      label110:
      if (((Integer)localObject1).intValue() != 2) {
        break;
      }
    }
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(112536);
    fixStatusbar(true);
    super.onCreate(paramBundle);
    hideActionbarLine();
    initView();
    paramBundle = new cik();
    cil localcil1 = new cil();
    cil localcil2 = new cil();
    cim localcim = new cim();
    Object localObject = com.tencent.mm.plugin.card.model.a.a.oHA;
    p.h(paramBundle, "jumpList");
    p.h(localcil1, "ticketList");
    p.h(localcil2, "licenseList");
    p.h(localcim, "underList");
    ae.d(com.tencent.mm.plugin.card.model.a.a.access$getTAG$cp(), "load ticket page snapshot");
    localObject = com.tencent.mm.kernel.g.ajR();
    p.g(localObject, "MMKernel.storage()");
    localObject = (String)((e)localObject).ajA().i(am.a.IZl);
    Charset localCharset;
    if (localObject != null)
    {
      localCharset = d.ISO_8859_1;
      if (localObject == null)
      {
        paramBundle = new v("null cannot be cast to non-null type java.lang.String");
        AppMethodBeat.o(112536);
        throw paramBundle;
      }
      localObject = ((String)localObject).getBytes(localCharset);
      p.g(localObject, "(this as java.lang.String).getBytes(charset)");
      paramBundle.parseFrom((byte[])localObject);
    }
    localObject = com.tencent.mm.kernel.g.ajR();
    p.g(localObject, "MMKernel.storage()");
    localObject = (String)((e)localObject).ajA().i(am.a.IZm);
    if (localObject != null)
    {
      localCharset = d.ISO_8859_1;
      if (localObject == null)
      {
        paramBundle = new v("null cannot be cast to non-null type java.lang.String");
        AppMethodBeat.o(112536);
        throw paramBundle;
      }
      localObject = ((String)localObject).getBytes(localCharset);
      p.g(localObject, "(this as java.lang.String).getBytes(charset)");
      localcil1.parseFrom((byte[])localObject);
    }
    localObject = com.tencent.mm.kernel.g.ajR();
    p.g(localObject, "MMKernel.storage()");
    localObject = (String)((e)localObject).ajA().i(am.a.IZn);
    if (localObject != null)
    {
      localCharset = d.ISO_8859_1;
      if (localObject == null)
      {
        paramBundle = new v("null cannot be cast to non-null type java.lang.String");
        AppMethodBeat.o(112536);
        throw paramBundle;
      }
      localObject = ((String)localObject).getBytes(localCharset);
      p.g(localObject, "(this as java.lang.String).getBytes(charset)");
      localcil2.parseFrom((byte[])localObject);
    }
    localObject = com.tencent.mm.kernel.g.ajR();
    p.g(localObject, "MMKernel.storage()");
    localObject = (String)((e)localObject).ajA().i(am.a.IZo);
    if (localObject != null)
    {
      localCharset = d.ISO_8859_1;
      if (localObject == null)
      {
        paramBundle = new v("null cannot be cast to non-null type java.lang.String");
        AppMethodBeat.o(112536);
        throw paramBundle;
      }
      localObject = ((String)localObject).getBytes(localCharset);
      p.g(localObject, "(this as java.lang.String).getBytes(charset)");
      localcim.parseFrom((byte[])localObject);
    }
    a(paramBundle, localcil1, localcil2, localcim);
    setMMTitle(2131764415);
    setBackBtn((MenuItem.OnMenuItemClickListener)new CardTicketListUI.g(this));
    addIconOptionMenu(0, 2131690603, (MenuItem.OnMenuItemClickListener)new CardTicketListUI.h(this));
    com.tencent.mm.plugin.report.service.g.yxI.f(16322, new Object[] { Integer.valueOf(6) });
    AppMethodBeat.o(112536);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(112538);
    super.onDestroy();
    Object localObject1 = this.oSU;
    if (localObject1 != null) {
      ((i)localObject1).cancel();
    }
    ae.i("MicroMsg.CardTicketListUI", "do save snapshot");
    Object localObject4 = new cik();
    ((cik)localObject4).HuM = new LinkedList();
    localObject1 = this.oSK.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = ((b)((Iterator)localObject1).next()).oSQ;
      if (localObject2 != null) {
        ((cik)localObject4).HuM.add(localObject2);
      }
    }
    Object localObject3 = new cil();
    ((cil)localObject3).HuN = new LinkedList();
    localObject1 = this.oSI.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = ((b)((Iterator)localObject1).next()).oSR;
      if (localObject2 != null) {
        ((cil)localObject3).HuN.add(localObject2);
      }
    }
    Object localObject2 = new cil();
    ((cil)localObject2).HuN = new LinkedList();
    localObject1 = this.oSJ.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject5 = ((b)((Iterator)localObject1).next()).oSR;
      if (localObject5 != null) {
        ((cil)localObject2).HuN.add(localObject5);
      }
    }
    localObject1 = new cim();
    Object localObject5 = this.oSN;
    if (localObject5 != null) {
      ((cim)localObject1).HuO = ((b)localObject5).oSS;
    }
    localObject5 = com.tencent.mm.plugin.card.model.a.a.oHA;
    p.h(localObject4, "jumpList");
    p.h(localObject3, "ticketList");
    p.h(localObject2, "licenseList");
    p.h(localObject1, "underList");
    ae.d(com.tencent.mm.plugin.card.model.a.a.access$getTAG$cp(), "save ticket page snapshot");
    localObject4 = ((cik)localObject4).toByteArray();
    p.g(localObject4, "jumpList.toByteArray()");
    localObject4 = new String((byte[])localObject4, d.ISO_8859_1);
    localObject5 = com.tencent.mm.kernel.g.ajR();
    p.g(localObject5, "MMKernel.storage()");
    ((e)localObject5).ajA().set(am.a.IZl, localObject4);
    localObject3 = ((cil)localObject3).toByteArray();
    p.g(localObject3, "ticketList.toByteArray()");
    localObject3 = new String((byte[])localObject3, d.ISO_8859_1);
    localObject4 = com.tencent.mm.kernel.g.ajR();
    p.g(localObject4, "MMKernel.storage()");
    ((e)localObject4).ajA().set(am.a.IZm, localObject3);
    localObject2 = ((cil)localObject2).toByteArray();
    p.g(localObject2, "licenseList.toByteArray()");
    localObject2 = new String((byte[])localObject2, d.ISO_8859_1);
    localObject3 = com.tencent.mm.kernel.g.ajR();
    p.g(localObject3, "MMKernel.storage()");
    ((e)localObject3).ajA().set(am.a.IZn, localObject2);
    localObject1 = ((cim)localObject1).toByteArray();
    p.g(localObject1, "underList.toByteArray()");
    localObject1 = new String((byte[])localObject1, d.ISO_8859_1);
    localObject2 = com.tencent.mm.kernel.g.ajR();
    p.g(localObject2, "MMKernel.storage()");
    ((e)localObject2).ajA().set(am.a.IZo, localObject1);
    AppMethodBeat.o(112538);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "kotlin.jvm.PlatformType", "it", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/DeleteCardInTicketListResponse;", "call"})
  static final class b<_Ret, _Var>
    implements com.tencent.mm.vending.c.a<_Ret, _Var>
  {
    b(CardTicketListUI paramCardTicketListUI, String paramString) {}
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "kotlin.jvm.PlatformType", "it", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/GetMktTicketHomePageResponse;", "call"})
  static final class c<_Ret, _Var>
    implements com.tencent.mm.vending.c.a<_Ret, _Var>
  {
    c(CardTicketListUI paramCardTicketListUI) {}
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "parent", "Lcom/tencent/mm/plugin/appbrand/widget/recyclerview/LoadMoreRecyclerView;", "kotlin.jvm.PlatformType", "adapter", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "onLoadMore"})
  static final class d
    implements LoadMoreRecyclerView.a
  {
    d(CardTicketListUI paramCardTicketListUI) {}
    
    public final void bBz()
    {
      AppMethodBeat.i(218409);
      CardTicketListUI.a(this.oSW);
      AppMethodBeat.o(218409);
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "parent", "Landroid/support/v7/widget/RecyclerView;", "kotlin.jvm.PlatformType", "view", "Landroid/view/View;", "position", "", "id", "", "onItemClick"})
  static final class e
    implements MRecyclerView.a
  {
    e(CardTicketListUI paramCardTicketListUI) {}
    
    public final void T(View paramView, int paramInt)
    {
      AppMethodBeat.i(218410);
      ae.i("MicroMsg.CardTicketListUI", "click item");
      paramView = CardTicketListUI.b(this.oSW).AW(paramInt);
      if (paramView != null)
      {
        switch (paramView.type)
        {
        }
        do
        {
          AppMethodBeat.o(218410);
          return;
          paramView = paramView.oSQ;
          if (paramView != null) {
            switch (paramView.Hno)
            {
            }
          }
          for (;;)
          {
            com.tencent.mm.plugin.report.service.g.yxI.f(16322, new Object[] { Integer.valueOf(7) });
            AppMethodBeat.o(218410);
            return;
            com.tencent.mm.plugin.card.d.b.a((MMActivity)this.oSW, paramView.HuJ);
            continue;
            paramView = paramView.HuK;
            if (paramView != null) {
              com.tencent.mm.plugin.card.d.b.I(paramView.CRv, paramView.CRw, paramView.DyO);
            }
          }
          paramView = paramView.oSR;
          if (paramView != null)
          {
            Object localObject = this.oSW;
            String str1 = paramView.FKu;
            p.g(str1, "user_card_id");
            CardTicketListUI.a((CardTicketListUI)localObject, str1);
            com.tencent.mm.plugin.report.service.g.yxI.f(16322, new Object[] { Integer.valueOf(10) });
            localObject = com.tencent.mm.plugin.report.service.g.yxI;
            paramInt = paramView.HuC;
            str1 = paramView.FKu;
            a locala = CardTicketListUI.b(this.oSW);
            String str2 = paramView.FKu;
            p.g(str2, "user_card_id");
            ((com.tencent.mm.plugin.report.service.g)localObject).f(16326, new Object[] { Integer.valueOf(paramInt), str1, Integer.valueOf(locala.cK(str2, paramView.HuC)), Integer.valueOf(1) });
            AppMethodBeat.o(218410);
            return;
          }
          AppMethodBeat.o(218410);
          return;
          paramView = paramView.oSS;
        } while (paramView == null);
        switch (paramView.Hno)
        {
        }
        do
        {
          AppMethodBeat.o(218410);
          return;
          com.tencent.mm.plugin.card.d.b.a((MMActivity)this.oSW, paramView.Hnp);
          AppMethodBeat.o(218410);
          return;
          paramView = paramView.Hnq;
        } while (paramView == null);
        com.tencent.mm.plugin.card.d.b.I(paramView.CRv, paramView.CRw, paramView.DyO);
        AppMethodBeat.o(218410);
        return;
      }
      AppMethodBeat.o(218410);
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "parent", "Landroid/support/v7/widget/RecyclerView;", "kotlin.jvm.PlatformType", "view", "Landroid/view/View;", "position", "", "id", "", "onItemLongClick"})
  static final class f
    implements MRecyclerView.b
  {
    f(CardTicketListUI paramCardTicketListUI) {}
    
    public final boolean U(final View paramView, int paramInt)
    {
      AppMethodBeat.i(218415);
      ae.i("MicroMsg.CardTicketListUI", "long click item");
      Object localObject = CardTicketListUI.b(this.oSW).AW(paramInt);
      if (localObject != null)
      {
        paramView = ((b)localObject).oSR;
        switch (((b)localObject).type)
        {
        }
      }
      for (;;)
      {
        AppMethodBeat.o(218415);
        return false;
        localObject = new com.tencent.mm.ui.tools.l((Context)this.oSW.getContext());
        ((com.tencent.mm.ui.tools.l)localObject).a((n.d)new n.d()
        {
          public final void onCreateMMMenu(com.tencent.mm.ui.base.l paramAnonymousl)
          {
            AppMethodBeat.i(218411);
            paramAnonymousl.d(1, (CharSequence)this.oSX.oSW.getString(2131755707));
            AppMethodBeat.o(218411);
          }
        });
        ((com.tencent.mm.ui.tools.l)localObject).a((n.e)new n.e()
        {
          public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
          {
            AppMethodBeat.i(218414);
            p.g(paramAnonymousMenuItem, "menuItem");
            switch (paramAnonymousMenuItem.getItemId())
            {
            }
            for (;;)
            {
              AppMethodBeat.o(218414);
              return;
              if (paramView != null)
              {
                h.a((Context)this.oSX.oSW.getContext(), this.oSX.oSW.getString(2131756898), "", this.oSX.oSW.getString(2131755835), this.oSX.oSW.getString(2131755691), false, (DialogInterface.OnClickListener)new DialogInterface.OnClickListener()
                {
                  public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
                  {
                    AppMethodBeat.i(218412);
                    Object localObject1 = this.oSZ.oSX.oSW;
                    Object localObject2 = this.oSZ.oSY;
                    if (localObject2 == null) {
                      p.gkB();
                    }
                    localObject2 = ((cii)localObject2).FKu;
                    p.g(localObject2, "ticketElement!!.user_card_id");
                    CardTicketListUI.b((CardTicketListUI)localObject1, (String)localObject2);
                    paramAnonymous2DialogInterface.dismiss();
                    paramAnonymous2DialogInterface = com.tencent.mm.plugin.report.service.g.yxI;
                    localObject1 = this.oSZ.oSY;
                    if (localObject1 == null) {
                      p.gkB();
                    }
                    paramAnonymous2Int = ((cii)localObject1).HuC;
                    localObject1 = this.oSZ.oSY;
                    if (localObject1 == null) {
                      p.gkB();
                    }
                    localObject1 = ((cii)localObject1).FKu;
                    localObject2 = CardTicketListUI.b(this.oSZ.oSX.oSW);
                    Object localObject3 = this.oSZ.oSY;
                    if (localObject3 == null) {
                      p.gkB();
                    }
                    localObject3 = ((cii)localObject3).FKu;
                    p.g(localObject3, "ticketElement!!.user_card_id");
                    cii localcii = this.oSZ.oSY;
                    if (localcii == null) {
                      p.gkB();
                    }
                    paramAnonymous2DialogInterface.f(16326, new Object[] { Integer.valueOf(paramAnonymous2Int), localObject1, Integer.valueOf(((a)localObject2).cK((String)localObject3, localcii.HuC)), Integer.valueOf(4) });
                    AppMethodBeat.o(218412);
                  }
                }, (DialogInterface.OnClickListener)CardTicketListUI.f.2.2.oTa);
                paramAnonymousMenuItem = com.tencent.mm.plugin.report.service.g.yxI;
                Object localObject1 = paramView;
                if (localObject1 == null) {
                  p.gkB();
                }
                paramAnonymousInt = ((cii)localObject1).HuC;
                localObject1 = paramView;
                if (localObject1 == null) {
                  p.gkB();
                }
                localObject1 = ((cii)localObject1).FKu;
                a locala = CardTicketListUI.b(this.oSX.oSW);
                Object localObject2 = paramView;
                if (localObject2 == null) {
                  p.gkB();
                }
                localObject2 = ((cii)localObject2).FKu;
                p.g(localObject2, "ticketElement!!.user_card_id");
                cii localcii = paramView;
                if (localcii == null) {
                  p.gkB();
                }
                paramAnonymousMenuItem.f(16326, new Object[] { Integer.valueOf(paramAnonymousInt), localObject1, Integer.valueOf(locala.cK((String)localObject2, localcii.HuC)), Integer.valueOf(3) });
              }
            }
          }
        });
        ((com.tencent.mm.ui.tools.l)localObject).fOP();
        if (paramView != null)
        {
          localObject = com.tencent.mm.plugin.report.service.g.yxI;
          paramInt = paramView.HuC;
          String str1 = paramView.FKu;
          a locala = CardTicketListUI.b(this.oSW);
          String str2 = paramView.FKu;
          p.g(str2, "user_card_id");
          ((com.tencent.mm.plugin.report.service.g)localObject).f(16326, new Object[] { Integer.valueOf(paramInt), str1, Integer.valueOf(locala.cK(str2, paramView.HuC)), Integer.valueOf(2) });
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.v2.CardTicketListUI
 * JD-Core Version:    0.7.0.1
 */