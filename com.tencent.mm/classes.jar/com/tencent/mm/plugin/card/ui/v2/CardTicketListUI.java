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
import com.tencent.mm.co.f;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.widget.recyclerview.LoadMoreRecyclerView;
import com.tencent.mm.plugin.appbrand.widget.recyclerview.LoadMoreRecyclerView.a;
import com.tencent.mm.plugin.appbrand.widget.recyclerview.MRecyclerView.a;
import com.tencent.mm.plugin.appbrand.widget.recyclerview.MRecyclerView.b;
import com.tencent.mm.plugin.card.model.a.c;
import com.tencent.mm.plugin.card.model.a.i;
import com.tencent.mm.protocal.protobuf.bxy;
import com.tencent.mm.protocal.protobuf.bxz;
import com.tencent.mm.protocal.protobuf.bya;
import com.tencent.mm.protocal.protobuf.byb;
import com.tencent.mm.protocal.protobuf.rc;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;
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

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/card/ui/v2/CardTicketListUI;", "Lcom/tencent/mm/plugin/card/ui/v2/CardNewBaseUI;", "()V", "firstLoad", "", "getMktTicketHomePage", "Lcom/tencent/mm/plugin/card/model/v2/CgiGetMktTicketHomePage;", "isAll", "isLoading", "jumpList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/card/ui/v2/CardTicketListModel;", "licenseList", "mEmptyView", "Landroid/view/ViewGroup;", "mTicketAdapter", "Lcom/tencent/mm/plugin/card/ui/v2/CardTicketAdapter;", "mTicketRv", "Lcom/tencent/mm/plugin/appbrand/widget/recyclerview/LoadMoreRecyclerView;", "offset", "", "reqNum", "ticketList", "adjustFooterView", "", "doDeleteTicket", "cardId", "", "doGetTicketHomePage", "getLayoutId", "gotoCardDetailUI", "initView", "loadSnapshot", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onFinishLocationThings", "ret", "isLocationOk", "saveSnapshot", "updateModelList", "Lcom/tencent/mm/protocal/protobuf/PageTicketJumpList;", "Lcom/tencent/mm/protocal/protobuf/PageTicketList;", "updateTextMenu", "Companion", "plugin-card_release"})
public final class CardTicketListUI
  extends CardNewBaseUI
{
  public static final CardTicketListUI.a nFW;
  private boolean fLX;
  private boolean isLoading;
  private int nEi;
  private boolean nEj;
  private final ArrayList<b> nFL;
  private final ArrayList<b> nFM;
  private final ArrayList<b> nFN;
  private ViewGroup nFU;
  private i nFV;
  private LoadMoreRecyclerView nFu;
  private a nFv;
  private int offset;
  
  static
  {
    AppMethodBeat.i(112545);
    nFW = new CardTicketListUI.a((byte)0);
    AppMethodBeat.o(112545);
  }
  
  public CardTicketListUI()
  {
    AppMethodBeat.i(112544);
    this.nEi = 10;
    this.fLX = true;
    this.nFL = new ArrayList();
    this.nFM = new ArrayList();
    this.nFN = new ArrayList();
    AppMethodBeat.o(112544);
  }
  
  private final void Ra(final String paramString)
  {
    AppMethodBeat.i(112542);
    ad.i("MicroMsg.CardTicketListUI", "do delete ticket: %s", new Object[] { paramString });
    new c(paramString).auK().b((com.tencent.mm.vending.c.a)new b(this, paramString));
    AppMethodBeat.o(112542);
  }
  
  private final void a(bya parambya, byb parambyb1, byb parambyb2)
  {
    AppMethodBeat.i(112541);
    Object localObject;
    int i;
    if (parambya != null)
    {
      this.nFN.clear();
      localObject = parambya.DUL;
      k.g(localObject, "page_ticket_jump_element");
      if (!((Collection)localObject).isEmpty()) {}
      for (i = 1; i != 0; i = 0)
      {
        parambya = parambya.DUL.iterator();
        while (parambya.hasNext())
        {
          localObject = (bxz)parambya.next();
          b localb = new b();
          localb.nFS = ((bxz)localObject);
          localb.type = 1;
          this.nFN.add(localb);
        }
      }
    }
    if (parambyb1 != null)
    {
      parambya = parambyb1.DUM;
      k.g(parambya, "page_ticket_element");
      if (!((Collection)parambya).isEmpty()) {}
      for (i = 1; i != 0; i = 0)
      {
        parambya = parambyb1.DUM.iterator();
        while (parambya.hasNext())
        {
          parambyb1 = (bxy)parambya.next();
          localObject = new b();
          ((b)localObject).nFT = parambyb1;
          ((b)localObject).type = 2;
          this.nFL.add(localObject);
        }
      }
    }
    if (parambyb2 != null)
    {
      parambya = parambyb2.DUM;
      k.g(parambya, "page_ticket_element");
      if (!((Collection)parambya).isEmpty()) {}
      for (i = 1; i != 0; i = 0)
      {
        parambya = parambyb2.DUM.iterator();
        while (parambya.hasNext())
        {
          parambyb1 = (bxy)parambya.next();
          parambyb2 = new b();
          parambyb2.nFT = parambyb1;
          parambyb2.type = 2;
          this.nFM.add(parambyb2);
        }
      }
    }
    if (!((Collection)this.nFN).isEmpty())
    {
      i = 1;
      if (i == 0)
      {
        if (((Collection)this.nFL).isEmpty()) {
          break label503;
        }
        i = 1;
        label362:
        if (i == 0) {
          break label515;
        }
      }
      if (((Collection)this.nFM).isEmpty()) {
        break label509;
      }
      i = 1;
      label385:
      if (i == 0) {
        break label515;
      }
      parambya = this.nFv;
      if (parambya == null) {
        k.aPZ("mTicketAdapter");
      }
      parambyb1 = getString(2131757020);
      k.g(parambyb1, "getString(R.string.card_ticket_section_title)");
      parambya.QY(parambyb1);
      parambya = this.nFv;
      if (parambya == null) {
        k.aPZ("mTicketAdapter");
      }
      parambyb1 = getString(2131756911);
      k.g(parambyb1, "getString(R.string.card_license_section_title)");
      parambya.QZ(parambyb1);
    }
    for (;;)
    {
      parambya = this.nFv;
      if (parambya == null) {
        k.aPZ("mTicketAdapter");
      }
      parambya.a(this.nFN, this.nFL, this.nFM);
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
      parambya = this.nFv;
      if (parambya == null) {
        k.aPZ("mTicketAdapter");
      }
      parambya.QY("");
      parambya = this.nFv;
      if (parambya == null) {
        k.aPZ("mTicketAdapter");
      }
      parambya.QZ("");
    }
  }
  
  private final void bMm()
  {
    AppMethodBeat.i(112543);
    ad.i("MicroMsg.CardTicketListUI", "do get ticket: %s, %s, %s, %s", new Object[] { Integer.valueOf(this.offset), Integer.valueOf(this.nEi), Boolean.valueOf(this.nEj), Boolean.valueOf(this.isLoading) });
    if ((!this.nEj) && (!this.isLoading))
    {
      this.isLoading = true;
      this.nFV = new i(this.offset, this.nEi, this.dpb, this.dqQ);
      i locali = this.nFV;
      if (locali == null) {
        k.fvU();
      }
      locali.auK().b((com.tencent.mm.vending.c.a)new c(this));
    }
    AppMethodBeat.o(112543);
  }
  
  public final void V(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(112540);
    ad.i("MicroMsg.CardTicketListUI", "location finish: [%s, %s], ret: %s, isOk: %s", new Object[] { Float.valueOf(this.dpb), Float.valueOf(this.dqQ), Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean) });
    if (this.fLX)
    {
      bMm();
      AppMethodBeat.o(112540);
      return;
    }
    if (!paramBoolean) {
      bMl();
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
    this.nFu = ((LoadMoreRecyclerView)localObject1);
    this.nFv = new a();
    localObject1 = this.nFu;
    if (localObject1 == null) {
      k.aPZ("mTicketRv");
    }
    Object localObject2 = this.nFv;
    if (localObject2 == null) {
      k.aPZ("mTicketAdapter");
    }
    ((LoadMoreRecyclerView)localObject1).setAdapter((RecyclerView.a)localObject2);
    localObject1 = this.nFu;
    if (localObject1 == null) {
      k.aPZ("mTicketRv");
    }
    getContext();
    ((LoadMoreRecyclerView)localObject1).setLayoutManager((RecyclerView.i)new LinearLayoutManager());
    localObject1 = new w((Context)this);
    ((w)localObject1).setDrawable(getResources().getDrawable(2131231459));
    localObject2 = this.nFu;
    if (localObject2 == null) {
      k.aPZ("mTicketRv");
    }
    ((LoadMoreRecyclerView)localObject2).b((RecyclerView.h)localObject1);
    localObject1 = this.nFu;
    if (localObject1 == null) {
      k.aPZ("mTicketRv");
    }
    ((LoadMoreRecyclerView)localObject1).setLoadingView(2131493294);
    localObject1 = findViewById(2131298280);
    k.g(localObject1, "findViewById(R.id.chpe_root_layout)");
    this.nFU = ((ViewGroup)localObject1);
    localObject1 = this.nFu;
    if (localObject1 == null) {
      k.aPZ("mTicketRv");
    }
    localObject2 = this.nFU;
    if (localObject2 == null) {
      k.aPZ("mEmptyView");
    }
    ((LoadMoreRecyclerView)localObject1).setEmptyView((View)localObject2);
    localObject1 = this.nFu;
    if (localObject1 == null) {
      k.aPZ("mTicketRv");
    }
    ((LoadMoreRecyclerView)localObject1).setOnLoadingStateChangedListener((LoadMoreRecyclerView.a)new d(this));
    localObject1 = this.nFu;
    if (localObject1 == null) {
      k.aPZ("mTicketRv");
    }
    ((LoadMoreRecyclerView)localObject1).setOnItemClickListener((MRecyclerView.a)new e(this));
    localObject1 = this.nFu;
    if (localObject1 == null) {
      k.aPZ("mTicketRv");
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
      Ra((String)localObject1);
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
    paramBundle = new bya();
    byb localbyb1 = new byb();
    byb localbyb2 = new byb();
    Object localObject = com.tencent.mm.plugin.card.model.a.a.nuE;
    k.h(paramBundle, "jumpList");
    k.h(localbyb1, "ticketList");
    k.h(localbyb2, "licenseList");
    ad.d(com.tencent.mm.plugin.card.model.a.a.access$getTAG$cp(), "load ticket page snapshot");
    localObject = g.afB();
    k.g(localObject, "MMKernel.storage()");
    localObject = (String)((e)localObject).afk().i(ae.a.Fun);
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
    localObject = g.afB();
    k.g(localObject, "MMKernel.storage()");
    localObject = (String)((e)localObject).afk().i(ae.a.Fuo);
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
      localbyb1.parseFrom((byte[])localObject);
    }
    localObject = g.afB();
    k.g(localObject, "MMKernel.storage()");
    localObject = (String)((e)localObject).afk().i(ae.a.Fup);
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
      localbyb2.parseFrom((byte[])localObject);
    }
    a(paramBundle, localbyb1, localbyb2);
    setMMTitle(2131764415);
    setBackBtn((MenuItem.OnMenuItemClickListener)new CardTicketListUI.g(this));
    addIconOptionMenu(0, 2131690603, (MenuItem.OnMenuItemClickListener)new CardTicketListUI.h(this));
    com.tencent.mm.plugin.report.service.h.vKh.f(16322, new Object[] { Integer.valueOf(6) });
    AppMethodBeat.o(112536);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(112538);
    super.onDestroy();
    Object localObject1 = this.nFV;
    if (localObject1 != null) {
      ((i)localObject1).cancel();
    }
    ad.i("MicroMsg.CardTicketListUI", "do save snapshot");
    Object localObject3 = new bya();
    ((bya)localObject3).DUL = new LinkedList();
    localObject1 = this.nFN.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = ((b)((Iterator)localObject1).next()).nFS;
      if (localObject2 != null) {
        ((bya)localObject3).DUL.add(localObject2);
      }
    }
    Object localObject2 = new byb();
    ((byb)localObject2).DUM = new LinkedList();
    localObject1 = this.nFL.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject4 = ((b)((Iterator)localObject1).next()).nFT;
      if (localObject4 != null) {
        ((byb)localObject2).DUM.add(localObject4);
      }
    }
    localObject1 = new byb();
    ((byb)localObject1).DUM = new LinkedList();
    Object localObject4 = this.nFM.iterator();
    while (((Iterator)localObject4).hasNext())
    {
      bxy localbxy = ((b)((Iterator)localObject4).next()).nFT;
      if (localbxy != null) {
        ((byb)localObject1).DUM.add(localbxy);
      }
    }
    localObject4 = com.tencent.mm.plugin.card.model.a.a.nuE;
    k.h(localObject3, "jumpList");
    k.h(localObject2, "ticketList");
    k.h(localObject1, "licenseList");
    ad.d(com.tencent.mm.plugin.card.model.a.a.access$getTAG$cp(), "save ticket page snapshot");
    localObject3 = ((bya)localObject3).toByteArray();
    k.g(localObject3, "jumpList.toByteArray()");
    localObject3 = new String((byte[])localObject3, d.ISO_8859_1);
    localObject4 = g.afB();
    k.g(localObject4, "MMKernel.storage()");
    ((e)localObject4).afk().set(ae.a.Fun, localObject3);
    localObject2 = ((byb)localObject2).toByteArray();
    k.g(localObject2, "ticketList.toByteArray()");
    localObject2 = new String((byte[])localObject2, d.ISO_8859_1);
    localObject3 = g.afB();
    k.g(localObject3, "MMKernel.storage()");
    ((e)localObject3).afk().set(ae.a.Fuo, localObject2);
    localObject1 = ((byb)localObject1).toByteArray();
    k.g(localObject1, "licenseList.toByteArray()");
    localObject1 = new String((byte[])localObject1, d.ISO_8859_1);
    localObject2 = g.afB();
    k.g(localObject2, "MMKernel.storage()");
    ((e)localObject2).afk().set(ae.a.Fup, localObject1);
    AppMethodBeat.o(112538);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "kotlin.jvm.PlatformType", "it", "Lcom/tencent/mm/modelbase/DeprecatedCgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/DeleteCardInTicketListResponse;", "call"})
  static final class b<_Ret, _Var>
    implements com.tencent.mm.vending.c.a<_Ret, _Var>
  {
    b(CardTicketListUI paramCardTicketListUI, String paramString) {}
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "kotlin.jvm.PlatformType", "it", "Lcom/tencent/mm/modelbase/DeprecatedCgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/GetMktTicketHomePageResponse;", "call"})
  static final class c<_Ret, _Var>
    implements com.tencent.mm.vending.c.a<_Ret, _Var>
  {
    c(CardTicketListUI paramCardTicketListUI) {}
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "parent", "Lcom/tencent/mm/plugin/appbrand/widget/recyclerview/LoadMoreRecyclerView;", "kotlin.jvm.PlatformType", "adapter", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "onLoadMore"})
  static final class d
    implements LoadMoreRecyclerView.a
  {
    d(CardTicketListUI paramCardTicketListUI) {}
    
    public final void bpD()
    {
      AppMethodBeat.i(192678);
      CardTicketListUI.a(this.nFX);
      AppMethodBeat.o(192678);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "parent", "Landroid/support/v7/widget/RecyclerView;", "kotlin.jvm.PlatformType", "view", "Landroid/view/View;", "position", "", "id", "", "onItemClick"})
  static final class e
    implements MRecyclerView.a
  {
    e(CardTicketListUI paramCardTicketListUI) {}
    
    public final void S(View paramView, int paramInt)
    {
      AppMethodBeat.i(192679);
      ad.i("MicroMsg.CardTicketListUI", "click item");
      paramView = CardTicketListUI.b(this.nFX).zl(paramInt);
      if (paramView != null)
      {
        switch (paramView.type)
        {
        }
        do
        {
          AppMethodBeat.o(192679);
          return;
          paramView = paramView.nFS;
          if (paramView != null) {
            switch (paramView.DUH)
            {
            }
          }
          for (;;)
          {
            com.tencent.mm.plugin.report.service.h.vKh.f(16322, new Object[] { Integer.valueOf(7) });
            AppMethodBeat.o(192679);
            return;
            com.tencent.mm.plugin.card.d.b.a((MMActivity)this.nFX, paramView.DUI);
            continue;
            paramView = paramView.DUJ;
            if (paramView != null) {
              com.tencent.mm.plugin.card.d.b.G(paramView.zHs, paramView.zHt, paramView.Aoy);
            }
          }
          paramView = paramView.nFT;
        } while (paramView == null);
        Object localObject = this.nFX;
        String str1 = paramView.CuA;
        k.g(str1, "user_card_id");
        CardTicketListUI.a((CardTicketListUI)localObject, str1);
        com.tencent.mm.plugin.report.service.h.vKh.f(16322, new Object[] { Integer.valueOf(10) });
        localObject = com.tencent.mm.plugin.report.service.h.vKh;
        paramInt = paramView.DUA;
        str1 = paramView.CuA;
        a locala = CardTicketListUI.b(this.nFX);
        String str2 = paramView.CuA;
        k.g(str2, "user_card_id");
        ((com.tencent.mm.plugin.report.service.h)localObject).f(16326, new Object[] { Integer.valueOf(paramInt), str1, Integer.valueOf(locala.cy(str2, paramView.DUA)), Integer.valueOf(1) });
        AppMethodBeat.o(192679);
        return;
      }
      AppMethodBeat.o(192679);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "parent", "Landroid/support/v7/widget/RecyclerView;", "kotlin.jvm.PlatformType", "view", "Landroid/view/View;", "position", "", "id", "", "onItemLongClick"})
  static final class f
    implements MRecyclerView.b
  {
    f(CardTicketListUI paramCardTicketListUI) {}
    
    public final boolean T(final View paramView, int paramInt)
    {
      AppMethodBeat.i(192684);
      ad.i("MicroMsg.CardTicketListUI", "long click item");
      Object localObject = CardTicketListUI.b(this.nFX).zl(paramInt);
      if (localObject != null)
      {
        paramView = ((b)localObject).nFT;
        switch (((b)localObject).type)
        {
        }
      }
      for (;;)
      {
        AppMethodBeat.o(192684);
        return false;
        localObject = new com.tencent.mm.ui.tools.l((Context)this.nFX.getContext());
        ((com.tencent.mm.ui.tools.l)localObject).a((n.c)new n.c()
        {
          public final void onCreateMMMenu(com.tencent.mm.ui.base.l paramAnonymousl)
          {
            AppMethodBeat.i(192680);
            paramAnonymousl.c(1, (CharSequence)this.nFY.nFX.getString(2131755707));
            AppMethodBeat.o(192680);
          }
        });
        ((com.tencent.mm.ui.tools.l)localObject).a((n.d)new n.d()
        {
          public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
          {
            AppMethodBeat.i(192683);
            k.g(paramAnonymousMenuItem, "menuItem");
            switch (paramAnonymousMenuItem.getItemId())
            {
            }
            for (;;)
            {
              AppMethodBeat.o(192683);
              return;
              if (paramView != null)
              {
                com.tencent.mm.ui.base.h.a((Context)this.nFY.nFX.getContext(), this.nFY.nFX.getString(2131756898), "", this.nFY.nFX.getString(2131755835), this.nFY.nFX.getString(2131755691), false, (DialogInterface.OnClickListener)new DialogInterface.OnClickListener()
                {
                  public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
                  {
                    AppMethodBeat.i(192681);
                    Object localObject1 = this.nGa.nFY.nFX;
                    Object localObject2 = this.nGa.nFZ;
                    if (localObject2 == null) {
                      k.fvU();
                    }
                    localObject2 = ((bxy)localObject2).CuA;
                    k.g(localObject2, "ticketElement!!.user_card_id");
                    CardTicketListUI.b((CardTicketListUI)localObject1, (String)localObject2);
                    paramAnonymous2DialogInterface.dismiss();
                    paramAnonymous2DialogInterface = com.tencent.mm.plugin.report.service.h.vKh;
                    localObject1 = this.nGa.nFZ;
                    if (localObject1 == null) {
                      k.fvU();
                    }
                    paramAnonymous2Int = ((bxy)localObject1).DUA;
                    localObject1 = this.nGa.nFZ;
                    if (localObject1 == null) {
                      k.fvU();
                    }
                    localObject1 = ((bxy)localObject1).CuA;
                    localObject2 = CardTicketListUI.b(this.nGa.nFY.nFX);
                    Object localObject3 = this.nGa.nFZ;
                    if (localObject3 == null) {
                      k.fvU();
                    }
                    localObject3 = ((bxy)localObject3).CuA;
                    k.g(localObject3, "ticketElement!!.user_card_id");
                    bxy localbxy = this.nGa.nFZ;
                    if (localbxy == null) {
                      k.fvU();
                    }
                    paramAnonymous2DialogInterface.f(16326, new Object[] { Integer.valueOf(paramAnonymous2Int), localObject1, Integer.valueOf(((a)localObject2).cy((String)localObject3, localbxy.DUA)), Integer.valueOf(4) });
                    AppMethodBeat.o(192681);
                  }
                }, (DialogInterface.OnClickListener)CardTicketListUI.f.2.2.nGb);
                paramAnonymousMenuItem = com.tencent.mm.plugin.report.service.h.vKh;
                Object localObject1 = paramView;
                if (localObject1 == null) {
                  k.fvU();
                }
                paramAnonymousInt = ((bxy)localObject1).DUA;
                localObject1 = paramView;
                if (localObject1 == null) {
                  k.fvU();
                }
                localObject1 = ((bxy)localObject1).CuA;
                a locala = CardTicketListUI.b(this.nFY.nFX);
                Object localObject2 = paramView;
                if (localObject2 == null) {
                  k.fvU();
                }
                localObject2 = ((bxy)localObject2).CuA;
                k.g(localObject2, "ticketElement!!.user_card_id");
                bxy localbxy = paramView;
                if (localbxy == null) {
                  k.fvU();
                }
                paramAnonymousMenuItem.f(16326, new Object[] { Integer.valueOf(paramAnonymousInt), localObject1, Integer.valueOf(locala.cy((String)localObject2, localbxy.DUA)), Integer.valueOf(3) });
              }
            }
          }
        });
        ((com.tencent.mm.ui.tools.l)localObject).fdQ();
        if (paramView != null)
        {
          localObject = com.tencent.mm.plugin.report.service.h.vKh;
          paramInt = paramView.DUA;
          String str1 = paramView.CuA;
          a locala = CardTicketListUI.b(this.nFX);
          String str2 = paramView.CuA;
          k.g(str2, "user_card_id");
          ((com.tencent.mm.plugin.report.service.h)localObject).f(16326, new Object[] { Integer.valueOf(paramInt), str1, Integer.valueOf(locala.cy(str2, paramView.DUA)), Integer.valueOf(2) });
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.v2.CardTicketListUI
 * JD-Core Version:    0.7.0.1
 */