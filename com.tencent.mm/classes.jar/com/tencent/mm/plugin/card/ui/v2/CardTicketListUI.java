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
import com.tencent.mm.plugin.appbrand.widget.recyclerview.LoadMoreRecyclerView;
import com.tencent.mm.plugin.appbrand.widget.recyclerview.LoadMoreRecyclerView.a;
import com.tencent.mm.plugin.appbrand.widget.recyclerview.MRecyclerView.a;
import com.tencent.mm.plugin.appbrand.widget.recyclerview.MRecyclerView.b;
import com.tencent.mm.plugin.card.model.a.c;
import com.tencent.mm.plugin.card.model.a.i;
import com.tencent.mm.protocal.protobuf.byr;
import com.tencent.mm.protocal.protobuf.cho;
import com.tencent.mm.protocal.protobuf.chp;
import com.tencent.mm.protocal.protobuf.chq;
import com.tencent.mm.protocal.protobuf.chr;
import com.tencent.mm.protocal.protobuf.chs;
import com.tencent.mm.protocal.protobuf.tg;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;
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

@d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/card/ui/v2/CardTicketListUI;", "Lcom/tencent/mm/plugin/card/ui/v2/CardNewBaseUI;", "()V", "firstLoad", "", "getMktTicketHomePage", "Lcom/tencent/mm/plugin/card/model/v2/CgiGetMktTicketHomePage;", "isAll", "isLoading", "jumpList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/card/ui/v2/CardTicketListModel;", "licenseList", "mEmptyView", "Landroid/view/ViewGroup;", "mTicketAdapter", "Lcom/tencent/mm/plugin/card/ui/v2/CardTicketAdapter;", "mTicketRv", "Lcom/tencent/mm/plugin/appbrand/widget/recyclerview/LoadMoreRecyclerView;", "medicareCard", "offset", "", "reqNum", "ticketList", "adjustFooterView", "", "doDeleteTicket", "cardId", "", "doGetTicketHomePage", "getLayoutId", "gotoCardDetailUI", "initView", "loadSnapshot", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onFinishLocationThings", "ret", "isLocationOk", "saveSnapshot", "updateModelList", "Lcom/tencent/mm/protocal/protobuf/PageTicketJumpList;", "Lcom/tencent/mm/protocal/protobuf/PageTicketList;", "underList", "Lcom/tencent/mm/protocal/protobuf/PageUnderList;", "updateTextMenu", "Companion", "plugin-card_release"})
public final class CardTicketListUI
  extends CardNewBaseUI
{
  public static final CardTicketListUI.a oMt;
  private boolean gjj;
  private boolean isLoading;
  private int oKC;
  private boolean oKD;
  private LoadMoreRecyclerView oLP;
  private a oLQ;
  private final ArrayList<b> oMg;
  private final ArrayList<b> oMh;
  private final ArrayList<b> oMi;
  private b oMl;
  private ViewGroup oMr;
  private i oMs;
  private int offset;
  
  static
  {
    AppMethodBeat.i(112545);
    oMt = new CardTicketListUI.a((byte)0);
    AppMethodBeat.o(112545);
  }
  
  public CardTicketListUI()
  {
    AppMethodBeat.i(112544);
    this.oKC = 10;
    this.gjj = true;
    this.oMg = new ArrayList();
    this.oMh = new ArrayList();
    this.oMi = new ArrayList();
    AppMethodBeat.o(112544);
  }
  
  private final void YV(final String paramString)
  {
    AppMethodBeat.i(112542);
    ad.i("MicroMsg.CardTicketListUI", "do delete ticket: %s", new Object[] { paramString });
    new c(paramString).aED().b((com.tencent.mm.vending.c.a)new b(this, paramString));
    AppMethodBeat.o(112542);
  }
  
  private final void a(chq paramchq, chr paramchr1, chr paramchr2, chs paramchs)
  {
    AppMethodBeat.i(215458);
    Object localObject;
    int i;
    if (paramchq != null)
    {
      this.oMi.clear();
      localObject = paramchq.Hbm;
      p.g(localObject, "page_ticket_jump_element");
      if (!((Collection)localObject).isEmpty()) {}
      for (i = 1; i != 0; i = 0)
      {
        paramchq = paramchq.Hbm.iterator();
        while (paramchq.hasNext())
        {
          localObject = (chp)paramchq.next();
          b localb = new b();
          localb.oMo = ((chp)localObject);
          localb.type = 1;
          this.oMi.add(localb);
        }
      }
    }
    if (paramchr1 != null)
    {
      paramchq = paramchr1.Hbn;
      p.g(paramchq, "page_ticket_element");
      if (!((Collection)paramchq).isEmpty()) {}
      for (i = 1; i != 0; i = 0)
      {
        paramchq = paramchr1.Hbn.iterator();
        while (paramchq.hasNext())
        {
          paramchr1 = (cho)paramchq.next();
          localObject = new b();
          ((b)localObject).oMp = paramchr1;
          ((b)localObject).type = 2;
          this.oMg.add(localObject);
        }
      }
    }
    if (paramchr2 != null)
    {
      paramchq = paramchr2.Hbn;
      p.g(paramchq, "page_ticket_element");
      if (!((Collection)paramchq).isEmpty()) {}
      for (i = 1; i != 0; i = 0)
      {
        paramchq = paramchr2.Hbn.iterator();
        while (paramchq.hasNext())
        {
          paramchr1 = (cho)paramchq.next();
          paramchr2 = new b();
          paramchr2.oMp = paramchr1;
          paramchr2.type = 2;
          this.oMh.add(paramchr2);
        }
      }
    }
    if (paramchs != null)
    {
      paramchq = paramchs.Hbo;
      if (paramchq != null)
      {
        this.oMl = new b();
        paramchr1 = this.oMl;
        if (paramchr1 == null) {
          p.gfZ();
        }
        paramchr1.type = 3;
        paramchr1 = this.oMl;
        if (paramchr1 == null) {
          p.gfZ();
        }
        paramchr1.oMq = paramchq;
      }
    }
    if (!((Collection)this.oMi).isEmpty())
    {
      i = 1;
      if (i == 0)
      {
        if (((Collection)this.oMg).isEmpty()) {
          break label574;
        }
        i = 1;
        label422:
        if (i == 0) {
          break label586;
        }
      }
      if (((Collection)this.oMh).isEmpty()) {
        break label580;
      }
      i = 1;
      label445:
      if ((i == 0) && (this.oMl == null)) {
        break label586;
      }
      paramchq = this.oLQ;
      if (paramchq == null) {
        p.bcb("mTicketAdapter");
      }
      paramchr1 = getString(2131757020);
      p.g(paramchr1, "getString(R.string.card_ticket_section_title)");
      paramchq.YT(paramchr1);
      paramchq = this.oLQ;
      if (paramchq == null) {
        p.bcb("mTicketAdapter");
      }
      paramchr1 = getString(2131756911);
      p.g(paramchr1, "getString(R.string.card_license_section_title)");
      paramchq.YU(paramchr1);
    }
    for (;;)
    {
      paramchq = this.oLQ;
      if (paramchq == null) {
        p.bcb("mTicketAdapter");
      }
      paramchq.a(this.oMi, this.oMg, this.oMh, this.oMl);
      AppMethodBeat.o(215458);
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
      paramchq = this.oLQ;
      if (paramchq == null) {
        p.bcb("mTicketAdapter");
      }
      paramchq.YT("");
      paramchq = this.oLQ;
      if (paramchq == null) {
        p.bcb("mTicketAdapter");
      }
      paramchq.YU("");
    }
  }
  
  private final void bYe()
  {
    AppMethodBeat.i(112543);
    ad.i("MicroMsg.CardTicketListUI", "do get ticket: %s, %s, %s, %s", new Object[] { Integer.valueOf(this.offset), Integer.valueOf(this.oKC), Boolean.valueOf(this.oKD), Boolean.valueOf(this.isLoading) });
    if ((!this.oKD) && (!this.isLoading))
    {
      this.isLoading = true;
      this.oMs = new i(this.offset, this.oKC, this.dyz, this.dAp);
      i locali = this.oMs;
      if (locali == null) {
        p.gfZ();
      }
      locali.aED().b((com.tencent.mm.vending.c.a)new c(this));
    }
    AppMethodBeat.o(112543);
  }
  
  public final void V(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(112540);
    ad.i("MicroMsg.CardTicketListUI", "location finish: [%s, %s], ret: %s, isOk: %s", new Object[] { Float.valueOf(this.dyz), Float.valueOf(this.dAp), Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean) });
    if (this.gjj)
    {
      bYe();
      AppMethodBeat.o(112540);
      return;
    }
    if (!paramBoolean) {
      bYd();
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
    this.oLP = ((LoadMoreRecyclerView)localObject1);
    this.oLQ = new a();
    localObject1 = this.oLP;
    if (localObject1 == null) {
      p.bcb("mTicketRv");
    }
    Object localObject2 = this.oLQ;
    if (localObject2 == null) {
      p.bcb("mTicketAdapter");
    }
    ((LoadMoreRecyclerView)localObject1).setAdapter((RecyclerView.a)localObject2);
    localObject1 = this.oLP;
    if (localObject1 == null) {
      p.bcb("mTicketRv");
    }
    getContext();
    ((LoadMoreRecyclerView)localObject1).setLayoutManager((RecyclerView.i)new LinearLayoutManager());
    localObject1 = new w((Context)this);
    ((w)localObject1).setDrawable(getResources().getDrawable(2131231459));
    localObject2 = this.oLP;
    if (localObject2 == null) {
      p.bcb("mTicketRv");
    }
    ((LoadMoreRecyclerView)localObject2).b((RecyclerView.h)localObject1);
    localObject1 = this.oLP;
    if (localObject1 == null) {
      p.bcb("mTicketRv");
    }
    ((LoadMoreRecyclerView)localObject1).setLoadingView(2131493294);
    localObject1 = findViewById(2131298280);
    p.g(localObject1, "findViewById(R.id.chpe_root_layout)");
    this.oMr = ((ViewGroup)localObject1);
    localObject1 = this.oLP;
    if (localObject1 == null) {
      p.bcb("mTicketRv");
    }
    localObject2 = this.oMr;
    if (localObject2 == null) {
      p.bcb("mEmptyView");
    }
    ((LoadMoreRecyclerView)localObject1).setEmptyView((View)localObject2);
    localObject1 = this.oLP;
    if (localObject1 == null) {
      p.bcb("mTicketRv");
    }
    ((LoadMoreRecyclerView)localObject1).setOnLoadingStateChangedListener((LoadMoreRecyclerView.a)new d(this));
    localObject1 = this.oLP;
    if (localObject1 == null) {
      p.bcb("mTicketRv");
    }
    ((LoadMoreRecyclerView)localObject1).setOnItemClickListener((MRecyclerView.a)new e(this));
    localObject1 = this.oLP;
    if (localObject1 == null) {
      p.bcb("mTicketRv");
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
      YV((String)localObject1);
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
    paramBundle = new chq();
    chr localchr1 = new chr();
    chr localchr2 = new chr();
    chs localchs = new chs();
    Object localObject = com.tencent.mm.plugin.card.model.a.a.oAY;
    p.h(paramBundle, "jumpList");
    p.h(localchr1, "ticketList");
    p.h(localchr2, "licenseList");
    p.h(localchs, "underList");
    ad.d(com.tencent.mm.plugin.card.model.a.a.access$getTAG$cp(), "load ticket page snapshot");
    localObject = com.tencent.mm.kernel.g.ajC();
    p.g(localObject, "MMKernel.storage()");
    localObject = (String)((e)localObject).ajl().i(al.a.IEL);
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
    localObject = com.tencent.mm.kernel.g.ajC();
    p.g(localObject, "MMKernel.storage()");
    localObject = (String)((e)localObject).ajl().i(al.a.IEM);
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
      localchr1.parseFrom((byte[])localObject);
    }
    localObject = com.tencent.mm.kernel.g.ajC();
    p.g(localObject, "MMKernel.storage()");
    localObject = (String)((e)localObject).ajl().i(al.a.IEN);
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
      localchr2.parseFrom((byte[])localObject);
    }
    localObject = com.tencent.mm.kernel.g.ajC();
    p.g(localObject, "MMKernel.storage()");
    localObject = (String)((e)localObject).ajl().i(al.a.IEO);
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
      localchs.parseFrom((byte[])localObject);
    }
    a(paramBundle, localchr1, localchr2, localchs);
    setMMTitle(2131764415);
    setBackBtn((MenuItem.OnMenuItemClickListener)new CardTicketListUI.g(this));
    addIconOptionMenu(0, 2131690603, (MenuItem.OnMenuItemClickListener)new CardTicketListUI.h(this));
    com.tencent.mm.plugin.report.service.g.yhR.f(16322, new Object[] { Integer.valueOf(6) });
    AppMethodBeat.o(112536);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(112538);
    super.onDestroy();
    Object localObject1 = this.oMs;
    if (localObject1 != null) {
      ((i)localObject1).cancel();
    }
    ad.i("MicroMsg.CardTicketListUI", "do save snapshot");
    Object localObject4 = new chq();
    ((chq)localObject4).Hbm = new LinkedList();
    localObject1 = this.oMi.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = ((b)((Iterator)localObject1).next()).oMo;
      if (localObject2 != null) {
        ((chq)localObject4).Hbm.add(localObject2);
      }
    }
    Object localObject3 = new chr();
    ((chr)localObject3).Hbn = new LinkedList();
    localObject1 = this.oMg.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = ((b)((Iterator)localObject1).next()).oMp;
      if (localObject2 != null) {
        ((chr)localObject3).Hbn.add(localObject2);
      }
    }
    Object localObject2 = new chr();
    ((chr)localObject2).Hbn = new LinkedList();
    localObject1 = this.oMh.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject5 = ((b)((Iterator)localObject1).next()).oMp;
      if (localObject5 != null) {
        ((chr)localObject2).Hbn.add(localObject5);
      }
    }
    localObject1 = new chs();
    Object localObject5 = this.oMl;
    if (localObject5 != null) {
      ((chs)localObject1).Hbo = ((b)localObject5).oMq;
    }
    localObject5 = com.tencent.mm.plugin.card.model.a.a.oAY;
    p.h(localObject4, "jumpList");
    p.h(localObject3, "ticketList");
    p.h(localObject2, "licenseList");
    p.h(localObject1, "underList");
    ad.d(com.tencent.mm.plugin.card.model.a.a.access$getTAG$cp(), "save ticket page snapshot");
    localObject4 = ((chq)localObject4).toByteArray();
    p.g(localObject4, "jumpList.toByteArray()");
    localObject4 = new String((byte[])localObject4, d.ISO_8859_1);
    localObject5 = com.tencent.mm.kernel.g.ajC();
    p.g(localObject5, "MMKernel.storage()");
    ((e)localObject5).ajl().set(al.a.IEL, localObject4);
    localObject3 = ((chr)localObject3).toByteArray();
    p.g(localObject3, "ticketList.toByteArray()");
    localObject3 = new String((byte[])localObject3, d.ISO_8859_1);
    localObject4 = com.tencent.mm.kernel.g.ajC();
    p.g(localObject4, "MMKernel.storage()");
    ((e)localObject4).ajl().set(al.a.IEM, localObject3);
    localObject2 = ((chr)localObject2).toByteArray();
    p.g(localObject2, "licenseList.toByteArray()");
    localObject2 = new String((byte[])localObject2, d.ISO_8859_1);
    localObject3 = com.tencent.mm.kernel.g.ajC();
    p.g(localObject3, "MMKernel.storage()");
    ((e)localObject3).ajl().set(al.a.IEN, localObject2);
    localObject1 = ((chs)localObject1).toByteArray();
    p.g(localObject1, "underList.toByteArray()");
    localObject1 = new String((byte[])localObject1, d.ISO_8859_1);
    localObject2 = com.tencent.mm.kernel.g.ajC();
    p.g(localObject2, "MMKernel.storage()");
    ((e)localObject2).ajl().set(al.a.IEO, localObject1);
    AppMethodBeat.o(112538);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "kotlin.jvm.PlatformType", "it", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/DeleteCardInTicketListResponse;", "call"})
  static final class b<_Ret, _Var>
    implements com.tencent.mm.vending.c.a<_Ret, _Var>
  {
    b(CardTicketListUI paramCardTicketListUI, String paramString) {}
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "kotlin.jvm.PlatformType", "it", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/GetMktTicketHomePageResponse;", "call"})
  static final class c<_Ret, _Var>
    implements com.tencent.mm.vending.c.a<_Ret, _Var>
  {
    c(CardTicketListUI paramCardTicketListUI) {}
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "parent", "Lcom/tencent/mm/plugin/appbrand/widget/recyclerview/LoadMoreRecyclerView;", "kotlin.jvm.PlatformType", "adapter", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "onLoadMore"})
  static final class d
    implements LoadMoreRecyclerView.a
  {
    d(CardTicketListUI paramCardTicketListUI) {}
    
    public final void bAF()
    {
      AppMethodBeat.i(215448);
      CardTicketListUI.a(this.oMu);
      AppMethodBeat.o(215448);
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "parent", "Landroid/support/v7/widget/RecyclerView;", "kotlin.jvm.PlatformType", "view", "Landroid/view/View;", "position", "", "id", "", "onItemClick"})
  static final class e
    implements MRecyclerView.a
  {
    e(CardTicketListUI paramCardTicketListUI) {}
    
    public final void T(View paramView, int paramInt)
    {
      AppMethodBeat.i(215449);
      ad.i("MicroMsg.CardTicketListUI", "click item");
      paramView = CardTicketListUI.b(this.oMu).AK(paramInt);
      if (paramView != null)
      {
        switch (paramView.type)
        {
        }
        do
        {
          AppMethodBeat.o(215449);
          return;
          paramView = paramView.oMo;
          if (paramView != null) {
            switch (paramView.GTN)
            {
            }
          }
          for (;;)
          {
            com.tencent.mm.plugin.report.service.g.yhR.f(16322, new Object[] { Integer.valueOf(7) });
            AppMethodBeat.o(215449);
            return;
            com.tencent.mm.plugin.card.d.b.a((MMActivity)this.oMu, paramView.Hbj);
            continue;
            paramView = paramView.Hbk;
            if (paramView != null) {
              com.tencent.mm.plugin.card.d.b.I(paramView.CzQ, paramView.CzR, paramView.Dhk);
            }
          }
          paramView = paramView.oMp;
          if (paramView != null)
          {
            Object localObject = this.oMu;
            String str1 = paramView.FrW;
            p.g(str1, "user_card_id");
            CardTicketListUI.a((CardTicketListUI)localObject, str1);
            com.tencent.mm.plugin.report.service.g.yhR.f(16322, new Object[] { Integer.valueOf(10) });
            localObject = com.tencent.mm.plugin.report.service.g.yhR;
            paramInt = paramView.Hbc;
            str1 = paramView.FrW;
            a locala = CardTicketListUI.b(this.oMu);
            String str2 = paramView.FrW;
            p.g(str2, "user_card_id");
            ((com.tencent.mm.plugin.report.service.g)localObject).f(16326, new Object[] { Integer.valueOf(paramInt), str1, Integer.valueOf(locala.cG(str2, paramView.Hbc)), Integer.valueOf(1) });
            AppMethodBeat.o(215449);
            return;
          }
          AppMethodBeat.o(215449);
          return;
          paramView = paramView.oMq;
        } while (paramView == null);
        switch (paramView.GTN)
        {
        }
        do
        {
          AppMethodBeat.o(215449);
          return;
          com.tencent.mm.plugin.card.d.b.a((MMActivity)this.oMu, paramView.GTO);
          AppMethodBeat.o(215449);
          return;
          paramView = paramView.GTP;
        } while (paramView == null);
        com.tencent.mm.plugin.card.d.b.I(paramView.CzQ, paramView.CzR, paramView.Dhk);
        AppMethodBeat.o(215449);
        return;
      }
      AppMethodBeat.o(215449);
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "parent", "Landroid/support/v7/widget/RecyclerView;", "kotlin.jvm.PlatformType", "view", "Landroid/view/View;", "position", "", "id", "", "onItemLongClick"})
  static final class f
    implements MRecyclerView.b
  {
    f(CardTicketListUI paramCardTicketListUI) {}
    
    public final boolean U(final View paramView, int paramInt)
    {
      AppMethodBeat.i(215454);
      ad.i("MicroMsg.CardTicketListUI", "long click item");
      Object localObject = CardTicketListUI.b(this.oMu).AK(paramInt);
      if (localObject != null)
      {
        paramView = ((b)localObject).oMp;
        switch (((b)localObject).type)
        {
        }
      }
      for (;;)
      {
        AppMethodBeat.o(215454);
        return false;
        localObject = new com.tencent.mm.ui.tools.l((Context)this.oMu.getContext());
        ((com.tencent.mm.ui.tools.l)localObject).a((n.d)new n.d()
        {
          public final void onCreateMMMenu(com.tencent.mm.ui.base.l paramAnonymousl)
          {
            AppMethodBeat.i(215450);
            paramAnonymousl.c(1, (CharSequence)this.oMv.oMu.getString(2131755707));
            AppMethodBeat.o(215450);
          }
        });
        ((com.tencent.mm.ui.tools.l)localObject).a((n.e)new n.e()
        {
          public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
          {
            AppMethodBeat.i(215453);
            p.g(paramAnonymousMenuItem, "menuItem");
            switch (paramAnonymousMenuItem.getItemId())
            {
            }
            for (;;)
            {
              AppMethodBeat.o(215453);
              return;
              if (paramView != null)
              {
                h.a((Context)this.oMv.oMu.getContext(), this.oMv.oMu.getString(2131756898), "", this.oMv.oMu.getString(2131755835), this.oMv.oMu.getString(2131755691), false, (DialogInterface.OnClickListener)new DialogInterface.OnClickListener()
                {
                  public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
                  {
                    AppMethodBeat.i(215451);
                    Object localObject1 = this.oMx.oMv.oMu;
                    Object localObject2 = this.oMx.oMw;
                    if (localObject2 == null) {
                      p.gfZ();
                    }
                    localObject2 = ((cho)localObject2).FrW;
                    p.g(localObject2, "ticketElement!!.user_card_id");
                    CardTicketListUI.b((CardTicketListUI)localObject1, (String)localObject2);
                    paramAnonymous2DialogInterface.dismiss();
                    paramAnonymous2DialogInterface = com.tencent.mm.plugin.report.service.g.yhR;
                    localObject1 = this.oMx.oMw;
                    if (localObject1 == null) {
                      p.gfZ();
                    }
                    paramAnonymous2Int = ((cho)localObject1).Hbc;
                    localObject1 = this.oMx.oMw;
                    if (localObject1 == null) {
                      p.gfZ();
                    }
                    localObject1 = ((cho)localObject1).FrW;
                    localObject2 = CardTicketListUI.b(this.oMx.oMv.oMu);
                    Object localObject3 = this.oMx.oMw;
                    if (localObject3 == null) {
                      p.gfZ();
                    }
                    localObject3 = ((cho)localObject3).FrW;
                    p.g(localObject3, "ticketElement!!.user_card_id");
                    cho localcho = this.oMx.oMw;
                    if (localcho == null) {
                      p.gfZ();
                    }
                    paramAnonymous2DialogInterface.f(16326, new Object[] { Integer.valueOf(paramAnonymous2Int), localObject1, Integer.valueOf(((a)localObject2).cG((String)localObject3, localcho.Hbc)), Integer.valueOf(4) });
                    AppMethodBeat.o(215451);
                  }
                }, (DialogInterface.OnClickListener)CardTicketListUI.f.2.2.oMy);
                paramAnonymousMenuItem = com.tencent.mm.plugin.report.service.g.yhR;
                Object localObject1 = paramView;
                if (localObject1 == null) {
                  p.gfZ();
                }
                paramAnonymousInt = ((cho)localObject1).Hbc;
                localObject1 = paramView;
                if (localObject1 == null) {
                  p.gfZ();
                }
                localObject1 = ((cho)localObject1).FrW;
                a locala = CardTicketListUI.b(this.oMv.oMu);
                Object localObject2 = paramView;
                if (localObject2 == null) {
                  p.gfZ();
                }
                localObject2 = ((cho)localObject2).FrW;
                p.g(localObject2, "ticketElement!!.user_card_id");
                cho localcho = paramView;
                if (localcho == null) {
                  p.gfZ();
                }
                paramAnonymousMenuItem.f(16326, new Object[] { Integer.valueOf(paramAnonymousInt), localObject1, Integer.valueOf(locala.cG((String)localObject2, localcho.Hbc)), Integer.valueOf(3) });
              }
            }
          }
        });
        ((com.tencent.mm.ui.tools.l)localObject).fKy();
        if (paramView != null)
        {
          localObject = com.tencent.mm.plugin.report.service.g.yhR;
          paramInt = paramView.Hbc;
          String str1 = paramView.FrW;
          a locala = CardTicketListUI.b(this.oMu);
          String str2 = paramView.FrW;
          p.g(str2, "user_card_id");
          ((com.tencent.mm.plugin.report.service.g)localObject).f(16326, new Object[] { Integer.valueOf(paramInt), str1, Integer.valueOf(locala.cG(str2, paramView.Hbc)), Integer.valueOf(2) });
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.v2.CardTicketListUI
 * JD-Core Version:    0.7.0.1
 */