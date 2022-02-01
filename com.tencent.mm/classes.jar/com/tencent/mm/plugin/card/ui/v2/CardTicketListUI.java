package com.tencent.mm.plugin.card.ui.v2;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
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
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.co.f;
import com.tencent.mm.kernel.e;
import com.tencent.mm.plugin.appbrand.service.r;
import com.tencent.mm.plugin.appbrand.widget.recyclerview.LoadMoreRecyclerView;
import com.tencent.mm.plugin.appbrand.widget.recyclerview.LoadMoreRecyclerView.a;
import com.tencent.mm.plugin.appbrand.widget.recyclerview.MRecyclerView.a;
import com.tencent.mm.plugin.appbrand.widget.recyclerview.MRecyclerView.b;
import com.tencent.mm.plugin.card.model.a.c;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.cnf;
import com.tencent.mm.protocal.protobuf.cyp;
import com.tencent.mm.protocal.protobuf.cyq;
import com.tencent.mm.protocal.protobuf.cyr;
import com.tencent.mm.protocal.protobuf.cys;
import com.tencent.mm.protocal.protobuf.cyt;
import com.tencent.mm.protocal.protobuf.un;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.o.g;
import com.tencent.mm.ui.base.q;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.d;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/card/ui/v2/CardTicketListUI;", "Lcom/tencent/mm/plugin/card/ui/v2/CardNewBaseUI;", "()V", "firstLoad", "", "getMktTicketHomePage", "Lcom/tencent/mm/plugin/card/model/v2/CgiGetMktTicketHomePage;", "isAll", "isLoading", "jumpList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/card/ui/v2/CardTicketListModel;", "licenseList", "mEmptyView", "Landroid/view/ViewGroup;", "mProgressDialog", "Lcom/tencent/mm/ui/base/MMProgressDialog;", "mTicketAdapter", "Lcom/tencent/mm/plugin/card/ui/v2/CardTicketAdapter;", "mTicketRv", "Lcom/tencent/mm/plugin/appbrand/widget/recyclerview/LoadMoreRecyclerView;", "medicareCard", "needRefreshList", "offset", "", "reqNum", "ticketList", "weAppOpenUICallback", "com/tencent/mm/plugin/card/ui/v2/CardTicketListUI$weAppOpenUICallback$1", "Lcom/tencent/mm/plugin/card/ui/v2/CardTicketListUI$weAppOpenUICallback$1;", "adjustFooterView", "", "doDeleteTicket", "cardId", "", "doGetTicketHomePage", "refresh", "getLayoutId", "gotoCardDetailUI", "initView", "loadSnapshot", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onFinishLocationThings", "ret", "isLocationOk", "onResume", "saveSnapshot", "showDeleteCardAlert", "ticketElement", "Lcom/tencent/mm/protocal/protobuf/PageTicketElement;", "item", "Landroid/view/View;", "showDeleteConfirmDialog", "showProgressDialog", "isShow", "(Ljava/lang/Boolean;)V", "updateModelList", "Lcom/tencent/mm/protocal/protobuf/PageTicketJumpList;", "Lcom/tencent/mm/protocal/protobuf/PageTicketList;", "underList", "Lcom/tencent/mm/protocal/protobuf/PageUnderList;", "updateTextMenu", "Companion", "plugin-card_release"})
public final class CardTicketListUI
  extends CardNewBaseUI
{
  public static final CardTicketListUI.a qgM;
  private boolean gWt;
  private q gxX;
  private boolean isLoading;
  private int offset;
  private int qeS;
  private boolean qeT;
  private b qgC;
  private ViewGroup qgI;
  private boolean qgJ;
  private final CardTicketListUI.m qgK;
  private com.tencent.mm.plugin.card.model.a.i qgL;
  private LoadMoreRecyclerView qgf;
  private a qgg;
  private final ArrayList<b> qgx;
  private final ArrayList<b> qgy;
  private final ArrayList<b> qgz;
  
  static
  {
    AppMethodBeat.i(112545);
    qgM = new CardTicketListUI.a((byte)0);
    AppMethodBeat.o(112545);
  }
  
  public CardTicketListUI()
  {
    AppMethodBeat.i(112544);
    this.qeS = 10;
    this.gWt = true;
    this.qgx = new ArrayList();
    this.qgy = new ArrayList();
    this.qgz = new ArrayList();
    this.qgK = new CardTicketListUI.m(this);
    AppMethodBeat.o(112544);
  }
  
  private final void a(cyr paramcyr, cys paramcys1, cys paramcys2, cyt paramcyt)
  {
    AppMethodBeat.i(201417);
    Object localObject;
    int i;
    if (paramcyr != null)
    {
      this.qgz.clear();
      localObject = paramcyr.MDK;
      p.g(localObject, "page_ticket_jump_element");
      if (!((Collection)localObject).isEmpty()) {}
      for (i = 1; i != 0; i = 0)
      {
        paramcyr = paramcyr.MDK.iterator();
        while (paramcyr.hasNext())
        {
          localObject = (cyq)paramcyr.next();
          b localb = new b();
          localb.qgF = ((cyq)localObject);
          localb.type = 1;
          this.qgz.add(localb);
        }
      }
    }
    if (paramcys1 != null)
    {
      paramcyr = paramcys1.MDL;
      p.g(paramcyr, "page_ticket_element");
      if (!((Collection)paramcyr).isEmpty()) {}
      for (i = 1; i != 0; i = 0)
      {
        paramcyr = paramcys1.MDL.iterator();
        while (paramcyr.hasNext())
        {
          paramcys1 = (cyp)paramcyr.next();
          localObject = new b();
          ((b)localObject).qgG = paramcys1;
          ((b)localObject).type = 2;
          this.qgx.add(localObject);
        }
      }
    }
    if (paramcys2 != null)
    {
      paramcyr = paramcys2.MDL;
      p.g(paramcyr, "page_ticket_element");
      if (!((Collection)paramcyr).isEmpty()) {}
      for (i = 1; i != 0; i = 0)
      {
        paramcyr = paramcys2.MDL.iterator();
        while (paramcyr.hasNext())
        {
          paramcys1 = (cyp)paramcyr.next();
          paramcys2 = new b();
          paramcys2.qgG = paramcys1;
          paramcys2.type = 2;
          this.qgy.add(paramcys2);
        }
      }
    }
    if (paramcyt != null)
    {
      paramcyr = paramcyt.MDM;
      if (paramcyr != null)
      {
        this.qgC = new b();
        paramcys1 = this.qgC;
        if (paramcys1 == null) {
          p.hyc();
        }
        paramcys1.type = 3;
        paramcys1 = this.qgC;
        if (paramcys1 == null) {
          p.hyc();
        }
        paramcys1.qgH = paramcyr;
      }
    }
    if (!((Collection)this.qgz).isEmpty())
    {
      i = 1;
      if (i == 0)
      {
        if (((Collection)this.qgx).isEmpty()) {
          break label577;
        }
        i = 1;
        label424:
        if (i == 0) {
          break label589;
        }
      }
      if (((Collection)this.qgy).isEmpty()) {
        break label583;
      }
      i = 1;
      label447:
      if ((i == 0) && (this.qgC == null)) {
        break label589;
      }
      paramcyr = this.qgg;
      if (paramcyr == null) {
        p.btv("mTicketAdapter");
      }
      paramcys1 = getString(2131757190);
      p.g(paramcys1, "getString(R.string.card_ticket_section_title)");
      paramcyr.ajP(paramcys1);
      paramcyr = this.qgg;
      if (paramcyr == null) {
        p.btv("mTicketAdapter");
      }
      paramcys1 = getString(2131757081);
      p.g(paramcys1, "getString(R.string.card_license_section_title)");
      paramcyr.ajQ(paramcys1);
    }
    for (;;)
    {
      paramcyr = this.qgg;
      if (paramcyr == null) {
        p.btv("mTicketAdapter");
      }
      paramcyr.a(this.qgz, this.qgx, this.qgy, this.qgC);
      AppMethodBeat.o(201417);
      return;
      i = 0;
      break;
      label577:
      i = 0;
      break label424;
      label583:
      i = 0;
      break label447;
      label589:
      paramcyr = this.qgg;
      if (paramcyr == null) {
        p.btv("mTicketAdapter");
      }
      paramcyr.ajP("");
      paramcyr = this.qgg;
      if (paramcyr == null) {
        p.btv("mTicketAdapter");
      }
      paramcyr.ajQ("");
    }
  }
  
  private final void ajR(final String paramString)
  {
    AppMethodBeat.i(112542);
    Log.i("MicroMsg.CardTicketListUI", "do delete ticket: %s", new Object[] { paramString });
    j(Boolean.TRUE);
    new c(paramString).aYI().b((com.tencent.mm.vending.c.a)new b(this, paramString));
    AppMethodBeat.o(112542);
  }
  
  private final void j(Boolean paramBoolean)
  {
    AppMethodBeat.i(201415);
    if (paramBoolean == null)
    {
      AppMethodBeat.o(201415);
      return;
    }
    if (paramBoolean.booleanValue()) {}
    for (paramBoolean = q.a((Context)getContext(), (CharSequence)getString(2131756029), true, 3, null);; paramBoolean = null)
    {
      this.gxX = paramBoolean;
      AppMethodBeat.o(201415);
      return;
      paramBoolean = this.gxX;
      if (paramBoolean != null) {
        paramBoolean.dismiss();
      }
    }
  }
  
  private final void ky(final boolean paramBoolean)
  {
    AppMethodBeat.i(201418);
    Log.i("MicroMsg.CardTicketListUI", "do get ticket: %s, %s, %s, %s", new Object[] { Integer.valueOf(this.offset), Integer.valueOf(this.qeS), Boolean.valueOf(this.qeT), Boolean.valueOf(this.isLoading) });
    if ((paramBoolean) || ((!this.qeT) && (!this.isLoading)))
    {
      this.isLoading = true;
      i = this.qeS;
      if (paramBoolean) {
        if (this.offset * 2 >= this.qeS) {
          break label179;
        }
      }
    }
    label179:
    for (int i = this.qeS;; i = this.offset * 2)
    {
      this.offset = 0;
      this.qgL = new com.tencent.mm.plugin.card.model.a.i(this.offset, i, this.latitude, this.dTj);
      com.tencent.mm.plugin.card.model.a.i locali = this.qgL;
      if (locali == null) {
        p.hyc();
      }
      locali.aYI().b((com.tencent.mm.vending.c.a)new c(this, paramBoolean));
      AppMethodBeat.o(201418);
      return;
    }
  }
  
  public final void ad(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(112540);
    Log.i("MicroMsg.CardTicketListUI", "location finish: [%s, %s], ret: %s, isOk: %s", new Object[] { Float.valueOf(this.latitude), Float.valueOf(this.dTj), Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean) });
    if (this.gWt)
    {
      ky(false);
      AppMethodBeat.o(112540);
      return;
    }
    if (!paramBoolean) {
      cxi();
    }
    AppMethodBeat.o(112540);
  }
  
  public final int getLayoutId()
  {
    return 2131493453;
  }
  
  public final void initView()
  {
    AppMethodBeat.i(112537);
    Object localObject1 = findViewById(2131299368);
    p.g(localObject1, "findViewById(R.id.ctlu_rv)");
    this.qgf = ((LoadMoreRecyclerView)localObject1);
    this.qgg = new a();
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
    localObject1 = findViewById(2131298671);
    p.g(localObject1, "findViewById(R.id.chpe_root_layout)");
    this.qgI = ((ViewGroup)localObject1);
    localObject1 = this.qgf;
    if (localObject1 == null) {
      p.btv("mTicketRv");
    }
    localObject2 = this.qgI;
    if (localObject2 == null) {
      p.btv("mEmptyView");
    }
    ((LoadMoreRecyclerView)localObject1).setEmptyView((View)localObject2);
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
        break label111;
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
      ajR((String)localObject1);
      break;
      label111:
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
    paramBundle = new cyr();
    cys localcys1 = new cys();
    cys localcys2 = new cys();
    cyt localcyt = new cyt();
    Object localObject = com.tencent.mm.plugin.card.model.a.a.pVg;
    p.h(paramBundle, "jumpList");
    p.h(localcys1, "ticketList");
    p.h(localcys2, "licenseList");
    p.h(localcyt, "underList");
    Log.d(com.tencent.mm.plugin.card.model.a.a.access$getTAG$cp(), "load ticket page snapshot");
    localObject = com.tencent.mm.kernel.g.aAh();
    p.g(localObject, "MMKernel.storage()");
    localObject = (String)((e)localObject).azQ().i(ar.a.OhH);
    Charset localCharset;
    if (localObject != null)
    {
      localCharset = d.ISO_8859_1;
      if (localObject == null)
      {
        paramBundle = new t("null cannot be cast to non-null type java.lang.String");
        AppMethodBeat.o(112536);
        throw paramBundle;
      }
      localObject = ((String)localObject).getBytes(localCharset);
      p.g(localObject, "(this as java.lang.String).getBytes(charset)");
      paramBundle.parseFrom((byte[])localObject);
    }
    localObject = com.tencent.mm.kernel.g.aAh();
    p.g(localObject, "MMKernel.storage()");
    localObject = (String)((e)localObject).azQ().i(ar.a.OhI);
    if (localObject != null)
    {
      localCharset = d.ISO_8859_1;
      if (localObject == null)
      {
        paramBundle = new t("null cannot be cast to non-null type java.lang.String");
        AppMethodBeat.o(112536);
        throw paramBundle;
      }
      localObject = ((String)localObject).getBytes(localCharset);
      p.g(localObject, "(this as java.lang.String).getBytes(charset)");
      localcys1.parseFrom((byte[])localObject);
    }
    localObject = com.tencent.mm.kernel.g.aAh();
    p.g(localObject, "MMKernel.storage()");
    localObject = (String)((e)localObject).azQ().i(ar.a.OhJ);
    if (localObject != null)
    {
      localCharset = d.ISO_8859_1;
      if (localObject == null)
      {
        paramBundle = new t("null cannot be cast to non-null type java.lang.String");
        AppMethodBeat.o(112536);
        throw paramBundle;
      }
      localObject = ((String)localObject).getBytes(localCharset);
      p.g(localObject, "(this as java.lang.String).getBytes(charset)");
      localcys2.parseFrom((byte[])localObject);
    }
    localObject = com.tencent.mm.kernel.g.aAh();
    p.g(localObject, "MMKernel.storage()");
    localObject = (String)((e)localObject).azQ().i(ar.a.OhK);
    if (localObject != null)
    {
      localCharset = d.ISO_8859_1;
      if (localObject == null)
      {
        paramBundle = new t("null cannot be cast to non-null type java.lang.String");
        AppMethodBeat.o(112536);
        throw paramBundle;
      }
      localObject = ((String)localObject).getBytes(localCharset);
      p.g(localObject, "(this as java.lang.String).getBytes(charset)");
      localcyt.parseFrom((byte[])localObject);
    }
    a(paramBundle, localcys1, localcys2, localcyt);
    setMMTitle(2131766758);
    setBackBtn((MenuItem.OnMenuItemClickListener)new CardTicketListUI.g(this));
    addIconOptionMenu(0, 2131690843, (MenuItem.OnMenuItemClickListener)new CardTicketListUI.l(this));
    h.CyF.a(16322, new Object[] { Integer.valueOf(6) });
    AppMethodBeat.o(112536);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(112538);
    super.onDestroy();
    Object localObject1 = this.qgL;
    if (localObject1 != null) {
      ((com.tencent.mm.plugin.card.model.a.i)localObject1).cancel();
    }
    ((r)com.tencent.mm.kernel.g.af(r.class)).a((com.tencent.mm.plugin.appbrand.api.i)this.qgK);
    Log.i("MicroMsg.CardTicketListUI", "do save snapshot");
    Object localObject4 = new cyr();
    ((cyr)localObject4).MDK = new LinkedList();
    localObject1 = this.qgz.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = ((b)((Iterator)localObject1).next()).qgF;
      if (localObject2 != null) {
        ((cyr)localObject4).MDK.add(localObject2);
      }
    }
    Object localObject3 = new cys();
    ((cys)localObject3).MDL = new LinkedList();
    localObject1 = this.qgx.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = ((b)((Iterator)localObject1).next()).qgG;
      if (localObject2 != null) {
        ((cys)localObject3).MDL.add(localObject2);
      }
    }
    Object localObject2 = new cys();
    ((cys)localObject2).MDL = new LinkedList();
    localObject1 = this.qgy.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject5 = ((b)((Iterator)localObject1).next()).qgG;
      if (localObject5 != null) {
        ((cys)localObject2).MDL.add(localObject5);
      }
    }
    localObject1 = new cyt();
    Object localObject5 = this.qgC;
    if (localObject5 != null) {
      ((cyt)localObject1).MDM = ((b)localObject5).qgH;
    }
    localObject5 = com.tencent.mm.plugin.card.model.a.a.pVg;
    p.h(localObject4, "jumpList");
    p.h(localObject3, "ticketList");
    p.h(localObject2, "licenseList");
    p.h(localObject1, "underList");
    Log.d(com.tencent.mm.plugin.card.model.a.a.access$getTAG$cp(), "save ticket page snapshot");
    localObject4 = ((cyr)localObject4).toByteArray();
    p.g(localObject4, "jumpList.toByteArray()");
    localObject4 = new String((byte[])localObject4, d.ISO_8859_1);
    localObject5 = com.tencent.mm.kernel.g.aAh();
    p.g(localObject5, "MMKernel.storage()");
    ((e)localObject5).azQ().set(ar.a.OhH, localObject4);
    localObject3 = ((cys)localObject3).toByteArray();
    p.g(localObject3, "ticketList.toByteArray()");
    localObject3 = new String((byte[])localObject3, d.ISO_8859_1);
    localObject4 = com.tencent.mm.kernel.g.aAh();
    p.g(localObject4, "MMKernel.storage()");
    ((e)localObject4).azQ().set(ar.a.OhI, localObject3);
    localObject2 = ((cys)localObject2).toByteArray();
    p.g(localObject2, "licenseList.toByteArray()");
    localObject2 = new String((byte[])localObject2, d.ISO_8859_1);
    localObject3 = com.tencent.mm.kernel.g.aAh();
    p.g(localObject3, "MMKernel.storage()");
    ((e)localObject3).azQ().set(ar.a.OhJ, localObject2);
    localObject1 = ((cyt)localObject1).toByteArray();
    p.g(localObject1, "underList.toByteArray()");
    localObject1 = new String((byte[])localObject1, d.ISO_8859_1);
    localObject2 = com.tencent.mm.kernel.g.aAh();
    p.g(localObject2, "MMKernel.storage()");
    ((e)localObject2).azQ().set(ar.a.OhK, localObject1);
    AppMethodBeat.o(112538);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(201416);
    if (this.qgJ)
    {
      ky(true);
      this.qgJ = false;
    }
    super.onResume();
    AppMethodBeat.o(201416);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/DeleteCardInTicketListResponse;", "kotlin.jvm.PlatformType", "call"})
  static final class b<_Ret, _Var>
    implements com.tencent.mm.vending.c.a<_Ret, _Var>
  {
    b(CardTicketListUI paramCardTicketListUI, String paramString) {}
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "kotlin.jvm.PlatformType", "it", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/GetMktTicketHomePageResponse;", "call"})
  static final class c<_Ret, _Var>
    implements com.tencent.mm.vending.c.a<_Ret, _Var>
  {
    c(CardTicketListUI paramCardTicketListUI, boolean paramBoolean) {}
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "parent", "Lcom/tencent/mm/plugin/appbrand/widget/recyclerview/LoadMoreRecyclerView;", "kotlin.jvm.PlatformType", "adapter", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "onLoadMore"})
  static final class d
    implements LoadMoreRecyclerView.a
  {
    d(CardTicketListUI paramCardTicketListUI) {}
    
    public final void bYy()
    {
      AppMethodBeat.i(201401);
      CardTicketListUI.a(this.qgN);
      AppMethodBeat.o(201401);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "parent", "Landroid/support/v7/widget/RecyclerView;", "kotlin.jvm.PlatformType", "view", "Landroid/view/View;", "position", "", "id", "", "onItemClick"})
  static final class e
    implements MRecyclerView.a
  {
    e(CardTicketListUI paramCardTicketListUI) {}
    
    public final void S(View paramView, int paramInt)
    {
      AppMethodBeat.i(201402);
      Log.i("MicroMsg.CardTicketListUI", "click item");
      paramView = CardTicketListUI.b(this.qgN).EB(paramInt);
      if (paramView != null)
      {
        switch (paramView.type)
        {
        }
        do
        {
          AppMethodBeat.o(201402);
          return;
          paramView = paramView.qgF;
          if (paramView != null) {
            switch (paramView.MtC)
            {
            }
          }
          for (;;)
          {
            h.CyF.a(16322, new Object[] { Integer.valueOf(7) });
            AppMethodBeat.o(201402);
            return;
            com.tencent.mm.plugin.card.d.b.a((MMActivity)this.qgN, paramView.MDH);
            continue;
            paramView = paramView.MDI;
            if (paramView != null) {
              com.tencent.mm.plugin.card.d.b.H(paramView.Hwr, paramView.Hws, paramView.IhZ);
            }
          }
          paramView = paramView.qgG;
          if (paramView != null)
          {
            localObject1 = this.qgN;
            localObject2 = paramView.KDM;
            p.g(localObject2, "user_card_id");
            CardTicketListUI.a((CardTicketListUI)localObject1, (String)localObject2);
            h.CyF.a(16322, new Object[] { Integer.valueOf(10) });
            localObject1 = h.CyF;
            paramInt = paramView.MDA;
            localObject2 = paramView.KDM;
            localObject3 = CardTicketListUI.b(this.qgN);
            String str = paramView.KDM;
            p.g(str, "user_card_id");
            ((h)localObject1).a(16326, new Object[] { Integer.valueOf(paramInt), localObject2, Integer.valueOf(((a)localObject3).cQ(str, paramView.MDA)), Integer.valueOf(1) });
            AppMethodBeat.o(201402);
            return;
          }
          AppMethodBeat.o(201402);
          return;
          paramView = paramView.qgH;
        } while (paramView == null);
        switch (paramView.MtC)
        {
        }
        do
        {
          AppMethodBeat.o(201402);
          return;
          com.tencent.mm.plugin.card.d.b.a((MMActivity)this.qgN, paramView.MtD);
          CardTicketListUI.c(this.qgN);
          AppMethodBeat.o(201402);
          return;
          paramView = paramView.MtE;
        } while (paramView == null);
        Object localObject1 = (r)com.tencent.mm.kernel.g.af(r.class);
        Object localObject2 = (Context)this.qgN;
        Object localObject3 = new com.tencent.mm.plugin.appbrand.api.g();
        ((com.tencent.mm.plugin.appbrand.api.g)localObject3).username = paramView.Hwr;
        ((com.tencent.mm.plugin.appbrand.api.g)localObject3).kHw = paramView.Hws;
        ((com.tencent.mm.plugin.appbrand.api.g)localObject3).version = paramView.IhZ;
        ((com.tencent.mm.plugin.appbrand.api.g)localObject3).scene = 1028;
        ((com.tencent.mm.plugin.appbrand.api.g)localObject3).kHN = ((com.tencent.mm.plugin.appbrand.api.i)CardTicketListUI.d(this.qgN));
        ((r)localObject1).a((Context)localObject2, (com.tencent.mm.plugin.appbrand.api.g)localObject3);
        AppMethodBeat.o(201402);
        return;
      }
      AppMethodBeat.o(201402);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "parent", "Landroid/support/v7/widget/RecyclerView;", "kotlin.jvm.PlatformType", "view", "Landroid/view/View;", "position", "", "id", "", "onItemLongClick"})
  static final class f
    implements MRecyclerView.b
  {
    f(CardTicketListUI paramCardTicketListUI) {}
    
    public final boolean T(View paramView, int paramInt)
    {
      AppMethodBeat.i(201403);
      Log.i("MicroMsg.CardTicketListUI", "long click item");
      Object localObject = CardTicketListUI.b(this.qgN).EB(paramInt);
      cyp localcyp;
      if (localObject != null)
      {
        localcyp = ((b)localObject).qgG;
        switch (((b)localObject).type)
        {
        }
      }
      for (;;)
      {
        AppMethodBeat.o(201403);
        return false;
        localObject = this.qgN;
        p.g(paramView, "view");
        CardTicketListUI.a((CardTicketListUI)localObject, localcyp, paramView);
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "menuItem", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "", "onMMMenuItemSelected"})
  static final class k
    implements o.g
  {
    k(CardTicketListUI paramCardTicketListUI, cyp paramcyp) {}
    
    public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
    {
      AppMethodBeat.i(201407);
      p.g(paramMenuItem, "menuItem");
      switch (paramMenuItem.getItemId())
      {
      }
      for (;;)
      {
        AppMethodBeat.o(201407);
        return;
        paramMenuItem = this.qgN;
        Object localObject1 = this.qgo;
        if (localObject1 == null) {
          p.hyc();
        }
        localObject1 = ((cyp)localObject1).KDM;
        p.g(localObject1, "ticketElement!!.user_card_id");
        CardTicketListUI.b(paramMenuItem, (String)localObject1);
        paramMenuItem = h.CyF;
        localObject1 = this.qgo;
        if (localObject1 == null) {
          p.hyc();
        }
        paramInt = ((cyp)localObject1).MDA;
        localObject1 = this.qgo;
        if (localObject1 == null) {
          p.hyc();
        }
        localObject1 = ((cyp)localObject1).KDM;
        a locala = CardTicketListUI.b(this.qgN);
        Object localObject2 = this.qgo;
        if (localObject2 == null) {
          p.hyc();
        }
        localObject2 = ((cyp)localObject2).KDM;
        p.g(localObject2, "ticketElement!!.user_card_id");
        cyp localcyp = this.qgo;
        if (localcyp == null) {
          p.hyc();
        }
        paramMenuItem.a(16326, new Object[] { Integer.valueOf(paramInt), localObject1, Integer.valueOf(locala.cQ((String)localObject2, localcyp.MDA)), Integer.valueOf(4) });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.v2.CardTicketListUI
 * JD-Core Version:    0.7.0.1
 */