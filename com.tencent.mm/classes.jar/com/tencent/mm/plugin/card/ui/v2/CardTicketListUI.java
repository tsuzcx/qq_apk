package com.tencent.mm.plugin.card.ui.v2;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnCreateContextMenuListener;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.api.g;
import com.tencent.mm.plugin.appbrand.service.r;
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
import com.tencent.mm.plugin.card.model.a.c;
import com.tencent.mm.protocal.protobuf.cvx;
import com.tencent.mm.protocal.protobuf.dib;
import com.tencent.mm.protocal.protobuf.dic;
import com.tencent.mm.protocal.protobuf.did;
import com.tencent.mm.protocal.protobuf.die;
import com.tencent.mm.protocal.protobuf.dif;
import com.tencent.mm.protocal.protobuf.up;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.base.q.f;
import com.tencent.mm.ui.base.q.g;
import com.tencent.mm.ui.base.s;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.d;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/card/ui/v2/CardTicketListUI;", "Lcom/tencent/mm/plugin/card/ui/v2/CardNewBaseUI;", "()V", "firstLoad", "", "getMktTicketHomePage", "Lcom/tencent/mm/plugin/card/model/v2/CgiGetMktTicketHomePage;", "isAll", "isLoading", "jumpList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/card/ui/v2/CardTicketListModel;", "licenseList", "mEmptyView", "Landroid/view/ViewGroup;", "mProgressDialog", "Lcom/tencent/mm/ui/base/MMProgressDialog;", "mTicketAdapter", "Lcom/tencent/mm/plugin/card/ui/v2/CardTicketAdapter;", "mTicketRv", "Lcom/tencent/mm/plugin/appbrand/widget/recyclerview/LoadMoreRecyclerView;", "medicareCard", "needRefreshList", "offset", "", "reqNum", "ticketList", "weAppOpenUICallback", "com/tencent/mm/plugin/card/ui/v2/CardTicketListUI$weAppOpenUICallback$1", "Lcom/tencent/mm/plugin/card/ui/v2/CardTicketListUI$weAppOpenUICallback$1;", "adjustFooterView", "", "doDeleteTicket", "cardId", "", "doGetTicketHomePage", "refresh", "getLayoutId", "gotoCardDetailUI", "initView", "loadSnapshot", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onFinishLocationThings", "ret", "isLocationOk", "onResume", "saveSnapshot", "showDeleteCardAlert", "ticketElement", "Lcom/tencent/mm/protocal/protobuf/PageTicketElement;", "item", "Landroid/view/View;", "showDeleteConfirmDialog", "showProgressDialog", "isShow", "(Ljava/lang/Boolean;)V", "updateModelList", "Lcom/tencent/mm/protocal/protobuf/PageTicketJumpList;", "Lcom/tencent/mm/protocal/protobuf/PageTicketList;", "underList", "Lcom/tencent/mm/protocal/protobuf/PageUnderList;", "updateTextMenu", "Companion", "plugin-card_release"})
public final class CardTicketListUI
  extends CardNewBaseUI
{
  public static final CardTicketListUI.a tCI;
  private boolean isLoading;
  private boolean jHo;
  private s jhZ;
  private int offset;
  private int tAP;
  private boolean tAQ;
  private ViewGroup tCE;
  private boolean tCF;
  private final CardTicketListUI.m tCG;
  private com.tencent.mm.plugin.card.model.a.i tCH;
  private LoadMoreRecyclerView tCc;
  private a tCd;
  private final ArrayList<b> tCt;
  private final ArrayList<b> tCu;
  private final ArrayList<b> tCv;
  private b tCy;
  
  static
  {
    AppMethodBeat.i(112545);
    tCI = new CardTicketListUI.a((byte)0);
    AppMethodBeat.o(112545);
  }
  
  public CardTicketListUI()
  {
    AppMethodBeat.i(112544);
    this.tAP = 10;
    this.jHo = true;
    this.tCt = new ArrayList();
    this.tCu = new ArrayList();
    this.tCv = new ArrayList();
    this.tCG = new CardTicketListUI.m(this);
    AppMethodBeat.o(112544);
  }
  
  private final void a(did paramdid, die paramdie1, die paramdie2, dif paramdif)
  {
    AppMethodBeat.i(247315);
    Object localObject;
    int i;
    if (paramdid != null)
    {
      this.tCv.clear();
      localObject = paramdid.TPt;
      p.j(localObject, "page_ticket_jump_element");
      if (!((Collection)localObject).isEmpty()) {}
      for (i = 1; i != 0; i = 0)
      {
        paramdid = paramdid.TPt.iterator();
        while (paramdid.hasNext())
        {
          localObject = (dic)paramdid.next();
          b localb = new b();
          localb.tCB = ((dic)localObject);
          localb.type = 1;
          this.tCv.add(localb);
        }
      }
    }
    if (paramdie1 != null)
    {
      paramdid = paramdie1.TPu;
      p.j(paramdid, "page_ticket_element");
      if (!((Collection)paramdid).isEmpty()) {}
      for (i = 1; i != 0; i = 0)
      {
        paramdid = paramdie1.TPu.iterator();
        while (paramdid.hasNext())
        {
          paramdie1 = (dib)paramdid.next();
          localObject = new b();
          ((b)localObject).tCC = paramdie1;
          ((b)localObject).type = 2;
          this.tCt.add(localObject);
        }
      }
    }
    if (paramdie2 != null)
    {
      paramdid = paramdie2.TPu;
      p.j(paramdid, "page_ticket_element");
      if (!((Collection)paramdid).isEmpty()) {}
      for (i = 1; i != 0; i = 0)
      {
        paramdid = paramdie2.TPu.iterator();
        while (paramdid.hasNext())
        {
          paramdie1 = (dib)paramdid.next();
          paramdie2 = new b();
          paramdie2.tCC = paramdie1;
          paramdie2.type = 2;
          this.tCu.add(paramdie2);
        }
      }
    }
    if (paramdif != null)
    {
      paramdid = paramdif.TPv;
      if (paramdid != null)
      {
        this.tCy = new b();
        paramdie1 = this.tCy;
        if (paramdie1 == null) {
          p.iCn();
        }
        paramdie1.type = 3;
        paramdie1 = this.tCy;
        if (paramdie1 == null) {
          p.iCn();
        }
        paramdie1.tCD = paramdid;
      }
    }
    if (!((Collection)this.tCv).isEmpty())
    {
      i = 1;
      if (i == 0)
      {
        if (((Collection)this.tCt).isEmpty()) {
          break label577;
        }
        i = 1;
        label424:
        if (i == 0) {
          break label589;
        }
      }
      if (((Collection)this.tCu).isEmpty()) {
        break label583;
      }
      i = 1;
      label447:
      if ((i == 0) && (this.tCy == null)) {
        break label589;
      }
      paramdid = this.tCd;
      if (paramdid == null) {
        p.bGy("mTicketAdapter");
      }
      paramdie1 = getString(a.g.tme);
      p.j(paramdie1, "getString(R.string.card_ticket_section_title)");
      paramdid.arC(paramdie1);
      paramdid = this.tCd;
      if (paramdid == null) {
        p.bGy("mTicketAdapter");
      }
      paramdie1 = getString(a.g.tkK);
      p.j(paramdie1, "getString(R.string.card_license_section_title)");
      paramdid.arD(paramdie1);
    }
    for (;;)
    {
      paramdid = this.tCd;
      if (paramdid == null) {
        p.bGy("mTicketAdapter");
      }
      paramdid.a(this.tCv, this.tCt, this.tCu, this.tCy);
      AppMethodBeat.o(247315);
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
      paramdid = this.tCd;
      if (paramdid == null) {
        p.bGy("mTicketAdapter");
      }
      paramdid.arC("");
      paramdid = this.tCd;
      if (paramdid == null) {
        p.bGy("mTicketAdapter");
      }
      paramdid.arD("");
    }
  }
  
  private final void arE(final String paramString)
  {
    AppMethodBeat.i(112542);
    Log.i("MicroMsg.CardTicketListUI", "do delete ticket: %s", new Object[] { paramString });
    n(Boolean.TRUE);
    new c(paramString).bhW().b((com.tencent.mm.vending.c.a)new b(this, paramString));
    AppMethodBeat.o(112542);
  }
  
  private final void lK(final boolean paramBoolean)
  {
    AppMethodBeat.i(247320);
    Log.i("MicroMsg.CardTicketListUI", "do get ticket: %s, %s, %s, %s", new Object[] { Integer.valueOf(this.offset), Integer.valueOf(this.tAP), Boolean.valueOf(this.tAQ), Boolean.valueOf(this.isLoading) });
    if ((paramBoolean) || ((!this.tAQ) && (!this.isLoading)))
    {
      this.isLoading = true;
      i = this.tAP;
      if (paramBoolean) {
        if (this.offset * 2 >= this.tAP) {
          break label179;
        }
      }
    }
    label179:
    for (int i = this.tAP;; i = this.offset * 2)
    {
      this.offset = 0;
      this.tCH = new com.tencent.mm.plugin.card.model.a.i(this.offset, i, this.latitude, this.longitude);
      com.tencent.mm.plugin.card.model.a.i locali = this.tCH;
      if (locali == null) {
        p.iCn();
      }
      locali.bhW().b((com.tencent.mm.vending.c.a)new c(this, paramBoolean));
      AppMethodBeat.o(247320);
      return;
    }
  }
  
  private final void n(Boolean paramBoolean)
  {
    AppMethodBeat.i(247300);
    if (paramBoolean == null)
    {
      AppMethodBeat.o(247300);
      return;
    }
    if (paramBoolean.booleanValue()) {}
    for (paramBoolean = s.a((Context)getContext(), (CharSequence)getString(a.g.app_waiting), true, 3, null);; paramBoolean = null)
    {
      this.jhZ = paramBoolean;
      AppMethodBeat.o(247300);
      return;
      paramBoolean = this.jhZ;
      if (paramBoolean != null) {
        paramBoolean.dismiss();
      }
    }
  }
  
  public final void ac(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(112540);
    Log.i("MicroMsg.CardTicketListUI", "location finish: [%s, %s], ret: %s, isOk: %s", new Object[] { Float.valueOf(this.latitude), Float.valueOf(this.longitude), Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean) });
    if (this.jHo)
    {
      lK(false);
      AppMethodBeat.o(112540);
      return;
    }
    if (!paramBoolean) {
      cKL();
    }
    AppMethodBeat.o(112540);
  }
  
  public final int getLayoutId()
  {
    return a.e.tjr;
  }
  
  public final void initView()
  {
    AppMethodBeat.i(112537);
    Object localObject1 = findViewById(a.d.tfx);
    p.j(localObject1, "findViewById(R.id.ctlu_rv)");
    this.tCc = ((LoadMoreRecyclerView)localObject1);
    this.tCd = new a();
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
    localObject1 = new androidx.recyclerview.widget.i((Context)this, 1);
    ((androidx.recyclerview.widget.i)localObject1).t(getResources().getDrawable(a.c.tah));
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
    localObject1 = findViewById(a.d.tdT);
    p.j(localObject1, "findViewById(R.id.chpe_root_layout)");
    this.tCE = ((ViewGroup)localObject1);
    localObject1 = this.tCc;
    if (localObject1 == null) {
      p.bGy("mTicketRv");
    }
    localObject2 = this.tCE;
    if (localObject2 == null) {
      p.bGy("mEmptyView");
    }
    ((LoadMoreRecyclerView)localObject1).setEmptyView((View)localObject2);
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
      p.j(localObject1, "cardId");
      arE((String)localObject1);
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
    paramBundle = new did();
    die localdie1 = new die();
    die localdie2 = new die();
    dif localdif = new dif();
    Object localObject = com.tencent.mm.plugin.card.model.a.a.trh;
    p.k(paramBundle, "jumpList");
    p.k(localdie1, "ticketList");
    p.k(localdie2, "licenseList");
    p.k(localdif, "underList");
    Log.d(com.tencent.mm.plugin.card.model.a.a.access$getTAG$cp(), "load ticket page snapshot");
    localObject = com.tencent.mm.kernel.h.aHG();
    p.j(localObject, "MMKernel.storage()");
    localObject = (String)((com.tencent.mm.kernel.f)localObject).aHp().j(ar.a.VvX);
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
      p.j(localObject, "(this as java.lang.String).getBytes(charset)");
      paramBundle.parseFrom((byte[])localObject);
    }
    localObject = com.tencent.mm.kernel.h.aHG();
    p.j(localObject, "MMKernel.storage()");
    localObject = (String)((com.tencent.mm.kernel.f)localObject).aHp().j(ar.a.VvY);
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
      p.j(localObject, "(this as java.lang.String).getBytes(charset)");
      localdie1.parseFrom((byte[])localObject);
    }
    localObject = com.tencent.mm.kernel.h.aHG();
    p.j(localObject, "MMKernel.storage()");
    localObject = (String)((com.tencent.mm.kernel.f)localObject).aHp().j(ar.a.VvZ);
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
      p.j(localObject, "(this as java.lang.String).getBytes(charset)");
      localdie2.parseFrom((byte[])localObject);
    }
    localObject = com.tencent.mm.kernel.h.aHG();
    p.j(localObject, "MMKernel.storage()");
    localObject = (String)((com.tencent.mm.kernel.f)localObject).aHp().j(ar.a.Vwa);
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
      p.j(localObject, "(this as java.lang.String).getBytes(charset)");
      localdif.parseFrom((byte[])localObject);
    }
    a(paramBundle, localdie1, localdie2, localdif);
    setMMTitle(a.g.tmo);
    setBackBtn((MenuItem.OnMenuItemClickListener)new CardTicketListUI.g(this));
    addIconOptionMenu(0, a.f.icons_outlined_more, (MenuItem.OnMenuItemClickListener)new CardTicketListUI.l(this));
    com.tencent.mm.plugin.report.service.h.IzE.a(16322, new Object[] { Integer.valueOf(6) });
    AppMethodBeat.o(112536);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(112538);
    super.onDestroy();
    Object localObject1 = this.tCH;
    if (localObject1 != null) {
      ((com.tencent.mm.plugin.card.model.a.i)localObject1).cancel();
    }
    ((r)com.tencent.mm.kernel.h.ae(r.class)).a((com.tencent.mm.plugin.appbrand.api.i)this.tCG);
    Log.i("MicroMsg.CardTicketListUI", "do save snapshot");
    Object localObject4 = new did();
    ((did)localObject4).TPt = new LinkedList();
    localObject1 = this.tCv.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = ((b)((Iterator)localObject1).next()).tCB;
      if (localObject2 != null) {
        ((did)localObject4).TPt.add(localObject2);
      }
    }
    Object localObject3 = new die();
    ((die)localObject3).TPu = new LinkedList();
    localObject1 = this.tCt.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = ((b)((Iterator)localObject1).next()).tCC;
      if (localObject2 != null) {
        ((die)localObject3).TPu.add(localObject2);
      }
    }
    Object localObject2 = new die();
    ((die)localObject2).TPu = new LinkedList();
    localObject1 = this.tCu.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject5 = ((b)((Iterator)localObject1).next()).tCC;
      if (localObject5 != null) {
        ((die)localObject2).TPu.add(localObject5);
      }
    }
    localObject1 = new dif();
    Object localObject5 = this.tCy;
    if (localObject5 != null) {
      ((dif)localObject1).TPv = ((b)localObject5).tCD;
    }
    localObject5 = com.tencent.mm.plugin.card.model.a.a.trh;
    p.k(localObject4, "jumpList");
    p.k(localObject3, "ticketList");
    p.k(localObject2, "licenseList");
    p.k(localObject1, "underList");
    Log.d(com.tencent.mm.plugin.card.model.a.a.access$getTAG$cp(), "save ticket page snapshot");
    localObject4 = ((did)localObject4).toByteArray();
    p.j(localObject4, "jumpList.toByteArray()");
    localObject4 = new String((byte[])localObject4, d.ISO_8859_1);
    localObject5 = com.tencent.mm.kernel.h.aHG();
    p.j(localObject5, "MMKernel.storage()");
    ((com.tencent.mm.kernel.f)localObject5).aHp().set(ar.a.VvX, localObject4);
    localObject3 = ((die)localObject3).toByteArray();
    p.j(localObject3, "ticketList.toByteArray()");
    localObject3 = new String((byte[])localObject3, d.ISO_8859_1);
    localObject4 = com.tencent.mm.kernel.h.aHG();
    p.j(localObject4, "MMKernel.storage()");
    ((com.tencent.mm.kernel.f)localObject4).aHp().set(ar.a.VvY, localObject3);
    localObject2 = ((die)localObject2).toByteArray();
    p.j(localObject2, "licenseList.toByteArray()");
    localObject2 = new String((byte[])localObject2, d.ISO_8859_1);
    localObject3 = com.tencent.mm.kernel.h.aHG();
    p.j(localObject3, "MMKernel.storage()");
    ((com.tencent.mm.kernel.f)localObject3).aHp().set(ar.a.VvZ, localObject2);
    localObject1 = ((dif)localObject1).toByteArray();
    p.j(localObject1, "underList.toByteArray()");
    localObject1 = new String((byte[])localObject1, d.ISO_8859_1);
    localObject2 = com.tencent.mm.kernel.h.aHG();
    p.j(localObject2, "MMKernel.storage()");
    ((com.tencent.mm.kernel.f)localObject2).aHp().set(ar.a.Vwa, localObject1);
    AppMethodBeat.o(112538);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(247304);
    if (this.tCF)
    {
      lK(true);
      this.tCF = false;
    }
    super.onResume();
    AppMethodBeat.o(247304);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/DeleteCardInTicketListResponse;", "kotlin.jvm.PlatformType", "call"})
  static final class b<_Ret, _Var>
    implements com.tencent.mm.vending.c.a<_Ret, _Var>
  {
    b(CardTicketListUI paramCardTicketListUI, String paramString) {}
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "kotlin.jvm.PlatformType", "it", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/GetMktTicketHomePageResponse;", "call"})
  static final class c<_Ret, _Var>
    implements com.tencent.mm.vending.c.a<_Ret, _Var>
  {
    c(CardTicketListUI paramCardTicketListUI, boolean paramBoolean) {}
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "parent", "Lcom/tencent/mm/plugin/appbrand/widget/recyclerview/LoadMoreRecyclerView;", "kotlin.jvm.PlatformType", "adapter", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "onLoadMore"})
  static final class d
    implements LoadMoreRecyclerView.a
  {
    d(CardTicketListUI paramCardTicketListUI) {}
    
    public final void clj()
    {
      AppMethodBeat.i(245583);
      CardTicketListUI.a(this.tCJ);
      AppMethodBeat.o(245583);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "parent", "Landroidx/recyclerview/widget/RecyclerView;", "kotlin.jvm.PlatformType", "view", "Landroid/view/View;", "position", "", "id", "", "onItemClick"})
  static final class e
    implements MRecyclerView.a
  {
    e(CardTicketListUI paramCardTicketListUI) {}
    
    public final void U(View paramView, int paramInt)
    {
      AppMethodBeat.i(245220);
      Log.i("MicroMsg.CardTicketListUI", "click item");
      paramView = CardTicketListUI.b(this.tCJ).Id(paramInt);
      if (paramView != null)
      {
        switch (paramView.type)
        {
        }
        do
        {
          AppMethodBeat.o(245220);
          return;
          paramView = paramView.tCB;
          if (paramView != null) {
            switch (paramView.TEI)
            {
            }
          }
          for (;;)
          {
            com.tencent.mm.plugin.report.service.h.IzE.a(16322, new Object[] { Integer.valueOf(7) });
            AppMethodBeat.o(245220);
            return;
            com.tencent.mm.plugin.card.d.b.a((MMActivity)this.tCJ, paramView.TPq);
            continue;
            paramView = paramView.TPr;
            if (paramView != null) {
              com.tencent.mm.plugin.card.d.b.L(paramView.Ooe, paramView.Oof, paramView.Paq);
            }
          }
          paramView = paramView.tCC;
          if (paramView != null)
          {
            localObject1 = this.tCJ;
            localObject2 = paramView.RFf;
            p.j(localObject2, "user_card_id");
            CardTicketListUI.a((CardTicketListUI)localObject1, (String)localObject2);
            com.tencent.mm.plugin.report.service.h.IzE.a(16322, new Object[] { Integer.valueOf(10) });
            localObject1 = com.tencent.mm.plugin.report.service.h.IzE;
            paramInt = paramView.TPj;
            localObject2 = paramView.RFf;
            localObject3 = CardTicketListUI.b(this.tCJ);
            String str = paramView.RFf;
            p.j(str, "user_card_id");
            ((com.tencent.mm.plugin.report.service.h)localObject1).a(16326, new Object[] { Integer.valueOf(paramInt), localObject2, Integer.valueOf(((a)localObject3).dk(str, paramView.TPj)), Integer.valueOf(1) });
            AppMethodBeat.o(245220);
            return;
          }
          AppMethodBeat.o(245220);
          return;
          paramView = paramView.tCD;
        } while (paramView == null);
        switch (paramView.TEI)
        {
        }
        do
        {
          AppMethodBeat.o(245220);
          return;
          com.tencent.mm.plugin.card.d.b.a((MMActivity)this.tCJ, paramView.TEJ);
          CardTicketListUI.c(this.tCJ);
          AppMethodBeat.o(245220);
          return;
          paramView = paramView.TEK;
        } while (paramView == null);
        Object localObject1 = (r)com.tencent.mm.kernel.h.ae(r.class);
        Object localObject2 = (Context)this.tCJ;
        Object localObject3 = new g();
        ((g)localObject3).username = paramView.Ooe;
        ((g)localObject3).nBq = paramView.Oof;
        ((g)localObject3).version = paramView.Paq;
        ((g)localObject3).scene = 1028;
        ((g)localObject3).nBG = ((com.tencent.mm.plugin.appbrand.api.i)CardTicketListUI.d(this.tCJ));
        ((r)localObject1).a((Context)localObject2, (g)localObject3);
        AppMethodBeat.o(245220);
        return;
      }
      AppMethodBeat.o(245220);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "parent", "Landroidx/recyclerview/widget/RecyclerView;", "kotlin.jvm.PlatformType", "view", "Landroid/view/View;", "position", "", "id", "", "onItemLongClick"})
  static final class f
    implements MRecyclerView.b
  {
    f(CardTicketListUI paramCardTicketListUI) {}
    
    public final boolean V(View paramView, int paramInt)
    {
      AppMethodBeat.i(249470);
      Log.i("MicroMsg.CardTicketListUI", "long click item");
      Object localObject = CardTicketListUI.b(this.tCJ).Id(paramInt);
      dib localdib;
      if (localObject != null)
      {
        localdib = ((b)localObject).tCC;
        switch (((b)localObject).type)
        {
        }
      }
      for (;;)
      {
        AppMethodBeat.o(249470);
        return false;
        localObject = this.tCJ;
        p.j(paramView, "view");
        CardTicketListUI.a((CardTicketListUI)localObject, localdib, paramView);
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "menu", "Landroid/view/ContextMenu;", "kotlin.jvm.PlatformType", "v", "Landroid/view/View;", "menuInfo", "Landroid/view/ContextMenu$ContextMenuInfo;", "onCreateContextMenu", "com/tencent/mm/plugin/card/ui/v2/CardTicketListUI$showDeleteCardAlert$1$1"})
  static final class h
    implements View.OnCreateContextMenuListener
  {
    h(CardTicketListUI paramCardTicketListUI, View paramView, dib paramdib) {}
    
    public final void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
    {
      AppMethodBeat.i(246885);
      paramContextMenu.add(0, 1, 0, (CharSequence)this.tCJ.getString(a.g.app_delete));
      AppMethodBeat.o(246885);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "menuItem", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "index", "", "onMMMenuItemSelected", "com/tencent/mm/plugin/card/ui/v2/CardTicketListUI$showDeleteCardAlert$1$2"})
  static final class i
    implements q.g
  {
    i(CardTicketListUI paramCardTicketListUI, View paramView, dib paramdib) {}
    
    public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
    {
      AppMethodBeat.i(246206);
      CardTicketListUI.a(this.tCJ, this.tCk);
      AppMethodBeat.o(246206);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Lcom/tencent/mm/ui/base/MMMenu;", "kotlin.jvm.PlatformType", "onCreateMMMenu"})
  static final class j
    implements q.f
  {
    j(CardTicketListUI paramCardTicketListUI) {}
    
    public final void onCreateMMMenu(o paramo)
    {
      AppMethodBeat.i(245148);
      paramo.a(1, this.tCJ.getResources().getColor(a.a.red_text_color), (CharSequence)this.tCJ.getString(a.g.app_delete));
      AppMethodBeat.o(245148);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "menuItem", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "", "onMMMenuItemSelected"})
  static final class k
    implements q.g
  {
    k(CardTicketListUI paramCardTicketListUI, dib paramdib) {}
    
    public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
    {
      AppMethodBeat.i(245424);
      p.j(paramMenuItem, "menuItem");
      switch (paramMenuItem.getItemId())
      {
      }
      for (;;)
      {
        AppMethodBeat.o(245424);
        return;
        paramMenuItem = this.tCJ;
        Object localObject1 = this.tCl;
        if (localObject1 == null) {
          p.iCn();
        }
        localObject1 = ((dib)localObject1).RFf;
        p.j(localObject1, "ticketElement!!.user_card_id");
        CardTicketListUI.b(paramMenuItem, (String)localObject1);
        paramMenuItem = com.tencent.mm.plugin.report.service.h.IzE;
        localObject1 = this.tCl;
        if (localObject1 == null) {
          p.iCn();
        }
        paramInt = ((dib)localObject1).TPj;
        localObject1 = this.tCl;
        if (localObject1 == null) {
          p.iCn();
        }
        localObject1 = ((dib)localObject1).RFf;
        a locala = CardTicketListUI.b(this.tCJ);
        Object localObject2 = this.tCl;
        if (localObject2 == null) {
          p.iCn();
        }
        localObject2 = ((dib)localObject2).RFf;
        p.j(localObject2, "ticketElement!!.user_card_id");
        dib localdib = this.tCl;
        if (localdib == null) {
          p.iCn();
        }
        paramMenuItem.a(16326, new Object[] { Integer.valueOf(paramInt), localObject1, Integer.valueOf(locala.dk((String)localObject2, localdib.TPj)), Integer.valueOf(4) });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.v2.CardTicketListUI
 * JD-Core Version:    0.7.0.1
 */