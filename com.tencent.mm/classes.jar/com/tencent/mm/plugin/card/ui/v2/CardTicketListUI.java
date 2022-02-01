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
import com.tencent.mm.cn.f;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.widget.recyclerview.LoadMoreRecyclerView;
import com.tencent.mm.plugin.appbrand.widget.recyclerview.LoadMoreRecyclerView.a;
import com.tencent.mm.plugin.appbrand.widget.recyclerview.MRecyclerView.a;
import com.tencent.mm.plugin.appbrand.widget.recyclerview.MRecyclerView.b;
import com.tencent.mm.plugin.card.model.a.c;
import com.tencent.mm.plugin.card.model.a.i;
import com.tencent.mm.protocal.protobuf.ccu;
import com.tencent.mm.protocal.protobuf.ccv;
import com.tencent.mm.protocal.protobuf.ccw;
import com.tencent.mm.protocal.protobuf.ccx;
import com.tencent.mm.protocal.protobuf.rm;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.base.n.d;
import d.g.b.k;
import d.n.d;
import d.v;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/card/ui/v2/CardTicketListUI;", "Lcom/tencent/mm/plugin/card/ui/v2/CardNewBaseUI;", "()V", "firstLoad", "", "getMktTicketHomePage", "Lcom/tencent/mm/plugin/card/model/v2/CgiGetMktTicketHomePage;", "isAll", "isLoading", "jumpList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/card/ui/v2/CardTicketListModel;", "licenseList", "mEmptyView", "Landroid/view/ViewGroup;", "mTicketAdapter", "Lcom/tencent/mm/plugin/card/ui/v2/CardTicketAdapter;", "mTicketRv", "Lcom/tencent/mm/plugin/appbrand/widget/recyclerview/LoadMoreRecyclerView;", "offset", "", "reqNum", "ticketList", "adjustFooterView", "", "doDeleteTicket", "cardId", "", "doGetTicketHomePage", "getLayoutId", "gotoCardDetailUI", "initView", "loadSnapshot", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onFinishLocationThings", "ret", "isLocationOk", "saveSnapshot", "updateModelList", "Lcom/tencent/mm/protocal/protobuf/PageTicketJumpList;", "Lcom/tencent/mm/protocal/protobuf/PageTicketList;", "updateTextMenu", "Companion", "plugin-card_release"})
public final class CardTicketListUI
  extends CardNewBaseUI
{
  public static final CardTicketListUI.a oiX;
  private boolean fPJ;
  private boolean isLoading;
  private int offset;
  private int ohj;
  private boolean ohk;
  private final ArrayList<b> oiM;
  private final ArrayList<b> oiN;
  private final ArrayList<b> oiO;
  private ViewGroup oiV;
  private i oiW;
  private LoadMoreRecyclerView oiv;
  private a oiw;
  
  static
  {
    AppMethodBeat.i(112545);
    oiX = new CardTicketListUI.a((byte)0);
    AppMethodBeat.o(112545);
  }
  
  public CardTicketListUI()
  {
    AppMethodBeat.i(112544);
    this.ohj = 10;
    this.fPJ = true;
    this.oiM = new ArrayList();
    this.oiN = new ArrayList();
    this.oiO = new ArrayList();
    AppMethodBeat.o(112544);
  }
  
  private final void Vm(final String paramString)
  {
    AppMethodBeat.i(112542);
    ac.i("MicroMsg.CardTicketListUI", "do delete ticket: %s", new Object[] { paramString });
    new c(paramString).aBB().b((com.tencent.mm.vending.c.a)new b(this, paramString));
    AppMethodBeat.o(112542);
  }
  
  private final void a(ccw paramccw, ccx paramccx1, ccx paramccx2)
  {
    AppMethodBeat.i(112541);
    Object localObject;
    int i;
    if (paramccw != null)
    {
      this.oiO.clear();
      localObject = paramccw.Frz;
      k.g(localObject, "page_ticket_jump_element");
      if (!((Collection)localObject).isEmpty()) {}
      for (i = 1; i != 0; i = 0)
      {
        paramccw = paramccw.Frz.iterator();
        while (paramccw.hasNext())
        {
          localObject = (ccv)paramccw.next();
          b localb = new b();
          localb.oiT = ((ccv)localObject);
          localb.type = 1;
          this.oiO.add(localb);
        }
      }
    }
    if (paramccx1 != null)
    {
      paramccw = paramccx1.FrA;
      k.g(paramccw, "page_ticket_element");
      if (!((Collection)paramccw).isEmpty()) {}
      for (i = 1; i != 0; i = 0)
      {
        paramccw = paramccx1.FrA.iterator();
        while (paramccw.hasNext())
        {
          paramccx1 = (ccu)paramccw.next();
          localObject = new b();
          ((b)localObject).oiU = paramccx1;
          ((b)localObject).type = 2;
          this.oiM.add(localObject);
        }
      }
    }
    if (paramccx2 != null)
    {
      paramccw = paramccx2.FrA;
      k.g(paramccw, "page_ticket_element");
      if (!((Collection)paramccw).isEmpty()) {}
      for (i = 1; i != 0; i = 0)
      {
        paramccw = paramccx2.FrA.iterator();
        while (paramccw.hasNext())
        {
          paramccx1 = (ccu)paramccw.next();
          paramccx2 = new b();
          paramccx2.oiU = paramccx1;
          paramccx2.type = 2;
          this.oiN.add(paramccx2);
        }
      }
    }
    if (!((Collection)this.oiO).isEmpty())
    {
      i = 1;
      if (i == 0)
      {
        if (((Collection)this.oiM).isEmpty()) {
          break label503;
        }
        i = 1;
        label362:
        if (i == 0) {
          break label515;
        }
      }
      if (((Collection)this.oiN).isEmpty()) {
        break label509;
      }
      i = 1;
      label385:
      if (i == 0) {
        break label515;
      }
      paramccw = this.oiw;
      if (paramccw == null) {
        k.aVY("mTicketAdapter");
      }
      paramccx1 = getString(2131757020);
      k.g(paramccx1, "getString(R.string.card_ticket_section_title)");
      paramccw.Vk(paramccx1);
      paramccw = this.oiw;
      if (paramccw == null) {
        k.aVY("mTicketAdapter");
      }
      paramccx1 = getString(2131756911);
      k.g(paramccx1, "getString(R.string.card_license_section_title)");
      paramccw.Vl(paramccx1);
    }
    for (;;)
    {
      paramccw = this.oiw;
      if (paramccw == null) {
        k.aVY("mTicketAdapter");
      }
      paramccw.a(this.oiO, this.oiM, this.oiN);
      AppMethodBeat.o(112541);
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
      paramccw = this.oiw;
      if (paramccw == null) {
        k.aVY("mTicketAdapter");
      }
      paramccw.Vk("");
      paramccw = this.oiw;
      if (paramccw == null) {
        k.aVY("mTicketAdapter");
      }
      paramccw.Vl("");
    }
  }
  
  private final void bTz()
  {
    AppMethodBeat.i(112543);
    ac.i("MicroMsg.CardTicketListUI", "do get ticket: %s, %s, %s, %s", new Object[] { Integer.valueOf(this.offset), Integer.valueOf(this.ohj), Boolean.valueOf(this.ohk), Boolean.valueOf(this.isLoading) });
    if ((!this.ohk) && (!this.isLoading))
    {
      this.isLoading = true;
      this.oiW = new i(this.offset, this.ohj, this.dmL, this.doB);
      i locali = this.oiW;
      if (locali == null) {
        k.fOy();
      }
      locali.aBB().b((com.tencent.mm.vending.c.a)new c(this));
    }
    AppMethodBeat.o(112543);
  }
  
  public final void V(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(112540);
    ac.i("MicroMsg.CardTicketListUI", "location finish: [%s, %s], ret: %s, isOk: %s", new Object[] { Float.valueOf(this.dmL), Float.valueOf(this.doB), Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean) });
    if (this.fPJ)
    {
      bTz();
      AppMethodBeat.o(112540);
      return;
    }
    if (!paramBoolean) {
      bTy();
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
    k.g(localObject1, "findViewById(R.id.ctlu_rv)");
    this.oiv = ((LoadMoreRecyclerView)localObject1);
    this.oiw = new a();
    localObject1 = this.oiv;
    if (localObject1 == null) {
      k.aVY("mTicketRv");
    }
    Object localObject2 = this.oiw;
    if (localObject2 == null) {
      k.aVY("mTicketAdapter");
    }
    ((LoadMoreRecyclerView)localObject1).setAdapter((RecyclerView.a)localObject2);
    localObject1 = this.oiv;
    if (localObject1 == null) {
      k.aVY("mTicketRv");
    }
    getContext();
    ((LoadMoreRecyclerView)localObject1).setLayoutManager((RecyclerView.i)new LinearLayoutManager());
    localObject1 = new w((Context)this);
    ((w)localObject1).setDrawable(getResources().getDrawable(2131231459));
    localObject2 = this.oiv;
    if (localObject2 == null) {
      k.aVY("mTicketRv");
    }
    ((LoadMoreRecyclerView)localObject2).b((RecyclerView.h)localObject1);
    localObject1 = this.oiv;
    if (localObject1 == null) {
      k.aVY("mTicketRv");
    }
    ((LoadMoreRecyclerView)localObject1).setLoadingView(2131493294);
    localObject1 = findViewById(2131298280);
    k.g(localObject1, "findViewById(R.id.chpe_root_layout)");
    this.oiV = ((ViewGroup)localObject1);
    localObject1 = this.oiv;
    if (localObject1 == null) {
      k.aVY("mTicketRv");
    }
    localObject2 = this.oiV;
    if (localObject2 == null) {
      k.aVY("mEmptyView");
    }
    ((LoadMoreRecyclerView)localObject1).setEmptyView((View)localObject2);
    localObject1 = this.oiv;
    if (localObject1 == null) {
      k.aVY("mTicketRv");
    }
    ((LoadMoreRecyclerView)localObject1).setOnLoadingStateChangedListener((LoadMoreRecyclerView.a)new d(this));
    localObject1 = this.oiv;
    if (localObject1 == null) {
      k.aVY("mTicketRv");
    }
    ((LoadMoreRecyclerView)localObject1).setOnItemClickListener((MRecyclerView.a)new e(this));
    localObject1 = this.oiv;
    if (localObject1 == null) {
      k.aVY("mTicketRv");
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
      k.g(localObject1, "cardId");
      Vm((String)localObject1);
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
    paramBundle = new ccw();
    ccx localccx1 = new ccx();
    ccx localccx2 = new ccx();
    Object localObject = com.tencent.mm.plugin.card.model.a.a.nXE;
    k.h(paramBundle, "jumpList");
    k.h(localccx1, "ticketList");
    k.h(localccx2, "licenseList");
    ac.d(com.tencent.mm.plugin.card.model.a.a.access$getTAG$cp(), "load ticket page snapshot");
    localObject = g.agR();
    k.g(localObject, "MMKernel.storage()");
    localObject = (String)((e)localObject).agA().i(ah.a.GSh);
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
      k.g(localObject, "(this as java.lang.String).getBytes(charset)");
      paramBundle.parseFrom((byte[])localObject);
    }
    localObject = g.agR();
    k.g(localObject, "MMKernel.storage()");
    localObject = (String)((e)localObject).agA().i(ah.a.GSi);
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
      k.g(localObject, "(this as java.lang.String).getBytes(charset)");
      localccx1.parseFrom((byte[])localObject);
    }
    localObject = g.agR();
    k.g(localObject, "MMKernel.storage()");
    localObject = (String)((e)localObject).agA().i(ah.a.GSj);
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
      k.g(localObject, "(this as java.lang.String).getBytes(charset)");
      localccx2.parseFrom((byte[])localObject);
    }
    a(paramBundle, localccx1, localccx2);
    setMMTitle(2131764415);
    setBackBtn((MenuItem.OnMenuItemClickListener)new CardTicketListUI.g(this));
    addIconOptionMenu(0, 2131690603, (MenuItem.OnMenuItemClickListener)new CardTicketListUI.h(this));
    com.tencent.mm.plugin.report.service.h.wUl.f(16322, new Object[] { Integer.valueOf(6) });
    AppMethodBeat.o(112536);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(112538);
    super.onDestroy();
    Object localObject1 = this.oiW;
    if (localObject1 != null) {
      ((i)localObject1).cancel();
    }
    ac.i("MicroMsg.CardTicketListUI", "do save snapshot");
    Object localObject3 = new ccw();
    ((ccw)localObject3).Frz = new LinkedList();
    localObject1 = this.oiO.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = ((b)((Iterator)localObject1).next()).oiT;
      if (localObject2 != null) {
        ((ccw)localObject3).Frz.add(localObject2);
      }
    }
    Object localObject2 = new ccx();
    ((ccx)localObject2).FrA = new LinkedList();
    localObject1 = this.oiM.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject4 = ((b)((Iterator)localObject1).next()).oiU;
      if (localObject4 != null) {
        ((ccx)localObject2).FrA.add(localObject4);
      }
    }
    localObject1 = new ccx();
    ((ccx)localObject1).FrA = new LinkedList();
    Object localObject4 = this.oiN.iterator();
    while (((Iterator)localObject4).hasNext())
    {
      ccu localccu = ((b)((Iterator)localObject4).next()).oiU;
      if (localccu != null) {
        ((ccx)localObject1).FrA.add(localccu);
      }
    }
    localObject4 = com.tencent.mm.plugin.card.model.a.a.nXE;
    k.h(localObject3, "jumpList");
    k.h(localObject2, "ticketList");
    k.h(localObject1, "licenseList");
    ac.d(com.tencent.mm.plugin.card.model.a.a.access$getTAG$cp(), "save ticket page snapshot");
    localObject3 = ((ccw)localObject3).toByteArray();
    k.g(localObject3, "jumpList.toByteArray()");
    localObject3 = new String((byte[])localObject3, d.ISO_8859_1);
    localObject4 = g.agR();
    k.g(localObject4, "MMKernel.storage()");
    ((e)localObject4).agA().set(ah.a.GSh, localObject3);
    localObject2 = ((ccx)localObject2).toByteArray();
    k.g(localObject2, "ticketList.toByteArray()");
    localObject2 = new String((byte[])localObject2, d.ISO_8859_1);
    localObject3 = g.agR();
    k.g(localObject3, "MMKernel.storage()");
    ((e)localObject3).agA().set(ah.a.GSi, localObject2);
    localObject1 = ((ccx)localObject1).toByteArray();
    k.g(localObject1, "licenseList.toByteArray()");
    localObject1 = new String((byte[])localObject1, d.ISO_8859_1);
    localObject2 = g.agR();
    k.g(localObject2, "MMKernel.storage()");
    ((e)localObject2).agA().set(ah.a.GSj, localObject1);
    AppMethodBeat.o(112538);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "kotlin.jvm.PlatformType", "it", "Lcom/tencent/mm/modelbase/DeprecatedCgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/DeleteCardInTicketListResponse;", "call"})
  static final class b<_Ret, _Var>
    implements com.tencent.mm.vending.c.a<_Ret, _Var>
  {
    b(CardTicketListUI paramCardTicketListUI, String paramString) {}
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "kotlin.jvm.PlatformType", "it", "Lcom/tencent/mm/modelbase/DeprecatedCgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/GetMktTicketHomePageResponse;", "call"})
  static final class c<_Ret, _Var>
    implements com.tencent.mm.vending.c.a<_Ret, _Var>
  {
    c(CardTicketListUI paramCardTicketListUI) {}
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "parent", "Lcom/tencent/mm/plugin/appbrand/widget/recyclerview/LoadMoreRecyclerView;", "kotlin.jvm.PlatformType", "adapter", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "onLoadMore"})
  static final class d
    implements LoadMoreRecyclerView.a
  {
    d(CardTicketListUI paramCardTicketListUI) {}
    
    public final void bwz()
    {
      AppMethodBeat.i(206252);
      CardTicketListUI.a(this.oiY);
      AppMethodBeat.o(206252);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "parent", "Landroid/support/v7/widget/RecyclerView;", "kotlin.jvm.PlatformType", "view", "Landroid/view/View;", "position", "", "id", "", "onItemClick"})
  static final class e
    implements MRecyclerView.a
  {
    e(CardTicketListUI paramCardTicketListUI) {}
    
    public final void T(View paramView, int paramInt)
    {
      AppMethodBeat.i(206253);
      ac.i("MicroMsg.CardTicketListUI", "click item");
      paramView = CardTicketListUI.b(this.oiY).Ab(paramInt);
      if (paramView != null)
      {
        switch (paramView.type)
        {
        }
        do
        {
          AppMethodBeat.o(206253);
          return;
          paramView = paramView.oiT;
          if (paramView != null) {
            switch (paramView.Frv)
            {
            }
          }
          for (;;)
          {
            com.tencent.mm.plugin.report.service.h.wUl.f(16322, new Object[] { Integer.valueOf(7) });
            AppMethodBeat.o(206253);
            return;
            com.tencent.mm.plugin.card.d.b.a((MMActivity)this.oiY, paramView.Frw);
            continue;
            paramView = paramView.Frx;
            if (paramView != null) {
              com.tencent.mm.plugin.card.d.b.H(paramView.AZE, paramView.AZF, paramView.BGS);
            }
          }
          paramView = paramView.oiU;
        } while (paramView == null);
        Object localObject = this.oiY;
        String str1 = paramView.DMR;
        k.g(str1, "user_card_id");
        CardTicketListUI.a((CardTicketListUI)localObject, str1);
        com.tencent.mm.plugin.report.service.h.wUl.f(16322, new Object[] { Integer.valueOf(10) });
        localObject = com.tencent.mm.plugin.report.service.h.wUl;
        paramInt = paramView.Fro;
        str1 = paramView.DMR;
        a locala = CardTicketListUI.b(this.oiY);
        String str2 = paramView.DMR;
        k.g(str2, "user_card_id");
        ((com.tencent.mm.plugin.report.service.h)localObject).f(16326, new Object[] { Integer.valueOf(paramInt), str1, Integer.valueOf(locala.cD(str2, paramView.Fro)), Integer.valueOf(1) });
        AppMethodBeat.o(206253);
        return;
      }
      AppMethodBeat.o(206253);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "parent", "Landroid/support/v7/widget/RecyclerView;", "kotlin.jvm.PlatformType", "view", "Landroid/view/View;", "position", "", "id", "", "onItemLongClick"})
  static final class f
    implements MRecyclerView.b
  {
    f(CardTicketListUI paramCardTicketListUI) {}
    
    public final boolean U(final View paramView, int paramInt)
    {
      AppMethodBeat.i(206258);
      ac.i("MicroMsg.CardTicketListUI", "long click item");
      Object localObject = CardTicketListUI.b(this.oiY).Ab(paramInt);
      if (localObject != null)
      {
        paramView = ((b)localObject).oiU;
        switch (((b)localObject).type)
        {
        }
      }
      for (;;)
      {
        AppMethodBeat.o(206258);
        return false;
        localObject = new com.tencent.mm.ui.tools.l((Context)this.oiY.getContext());
        ((com.tencent.mm.ui.tools.l)localObject).a((n.c)new n.c()
        {
          public final void onCreateMMMenu(com.tencent.mm.ui.base.l paramAnonymousl)
          {
            AppMethodBeat.i(206254);
            paramAnonymousl.c(1, (CharSequence)this.oiZ.oiY.getString(2131755707));
            AppMethodBeat.o(206254);
          }
        });
        ((com.tencent.mm.ui.tools.l)localObject).a((n.d)new n.d()
        {
          public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
          {
            AppMethodBeat.i(206257);
            k.g(paramAnonymousMenuItem, "menuItem");
            switch (paramAnonymousMenuItem.getItemId())
            {
            }
            for (;;)
            {
              AppMethodBeat.o(206257);
              return;
              if (paramView != null)
              {
                com.tencent.mm.ui.base.h.a((Context)this.oiZ.oiY.getContext(), this.oiZ.oiY.getString(2131756898), "", this.oiZ.oiY.getString(2131755835), this.oiZ.oiY.getString(2131755691), false, (DialogInterface.OnClickListener)new DialogInterface.OnClickListener()
                {
                  public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
                  {
                    AppMethodBeat.i(206255);
                    Object localObject1 = this.ojb.oiZ.oiY;
                    Object localObject2 = this.ojb.oja;
                    if (localObject2 == null) {
                      k.fOy();
                    }
                    localObject2 = ((ccu)localObject2).DMR;
                    k.g(localObject2, "ticketElement!!.user_card_id");
                    CardTicketListUI.b((CardTicketListUI)localObject1, (String)localObject2);
                    paramAnonymous2DialogInterface.dismiss();
                    paramAnonymous2DialogInterface = com.tencent.mm.plugin.report.service.h.wUl;
                    localObject1 = this.ojb.oja;
                    if (localObject1 == null) {
                      k.fOy();
                    }
                    paramAnonymous2Int = ((ccu)localObject1).Fro;
                    localObject1 = this.ojb.oja;
                    if (localObject1 == null) {
                      k.fOy();
                    }
                    localObject1 = ((ccu)localObject1).DMR;
                    localObject2 = CardTicketListUI.b(this.ojb.oiZ.oiY);
                    Object localObject3 = this.ojb.oja;
                    if (localObject3 == null) {
                      k.fOy();
                    }
                    localObject3 = ((ccu)localObject3).DMR;
                    k.g(localObject3, "ticketElement!!.user_card_id");
                    ccu localccu = this.ojb.oja;
                    if (localccu == null) {
                      k.fOy();
                    }
                    paramAnonymous2DialogInterface.f(16326, new Object[] { Integer.valueOf(paramAnonymous2Int), localObject1, Integer.valueOf(((a)localObject2).cD((String)localObject3, localccu.Fro)), Integer.valueOf(4) });
                    AppMethodBeat.o(206255);
                  }
                }, (DialogInterface.OnClickListener)CardTicketListUI.f.2.2.ojc);
                paramAnonymousMenuItem = com.tencent.mm.plugin.report.service.h.wUl;
                Object localObject1 = paramView;
                if (localObject1 == null) {
                  k.fOy();
                }
                paramAnonymousInt = ((ccu)localObject1).Fro;
                localObject1 = paramView;
                if (localObject1 == null) {
                  k.fOy();
                }
                localObject1 = ((ccu)localObject1).DMR;
                a locala = CardTicketListUI.b(this.oiZ.oiY);
                Object localObject2 = paramView;
                if (localObject2 == null) {
                  k.fOy();
                }
                localObject2 = ((ccu)localObject2).DMR;
                k.g(localObject2, "ticketElement!!.user_card_id");
                ccu localccu = paramView;
                if (localccu == null) {
                  k.fOy();
                }
                paramAnonymousMenuItem.f(16326, new Object[] { Integer.valueOf(paramAnonymousInt), localObject1, Integer.valueOf(locala.cD((String)localObject2, localccu.Fro)), Integer.valueOf(3) });
              }
            }
          }
        });
        ((com.tencent.mm.ui.tools.l)localObject).ftL();
        if (paramView != null)
        {
          localObject = com.tencent.mm.plugin.report.service.h.wUl;
          paramInt = paramView.Fro;
          String str1 = paramView.DMR;
          a locala = CardTicketListUI.b(this.oiY);
          String str2 = paramView.DMR;
          k.g(str2, "user_card_id");
          ((com.tencent.mm.plugin.report.service.h)localObject).f(16326, new Object[] { Integer.valueOf(paramInt), str1, Integer.valueOf(locala.cD(str2, paramView.Fro)), Integer.valueOf(2) });
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.v2.CardTicketListUI
 * JD-Core Version:    0.7.0.1
 */