package com.tencent.mm.plugin.finder.feed.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ag.k.b;
import com.tencent.mm.br.c;
import com.tencent.mm.model.cl;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.feed.c.a;
import com.tencent.mm.plugin.finder.feed.c.b;
import com.tencent.mm.plugin.finder.feed.model.FinderPoiFeedLoader;
import com.tencent.mm.plugin.finder.feed.z.a;
import com.tencent.mm.plugin.finder.feed.z.b;
import com.tencent.mm.plugin.finder.report.k;
import com.tencent.mm.plugin.finder.ui.MMFinderUI;
import com.tencent.mm.plugin.finder.utils.s;
import com.tencent.mm.plugin.finder.utils.s.a.i;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC.a;
import com.tencent.mm.plugin.i.a.y.a;
import com.tencent.mm.protocal.protobuf.bbn;
import com.tencent.mm.protocal.protobuf.eaa;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMActivity.a;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.base.o.f;
import com.tencent.mm.ui.base.o.g;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.ui.widget.a.e;
import java.util.HashMap;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/feed/ui/FinderPoiFeedUI;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "()V", "feedLoader", "Lcom/tencent/mm/plugin/finder/feed/model/FinderPoiFeedLoader;", "getFeedLoader", "()Lcom/tencent/mm/plugin/finder/feed/model/FinderPoiFeedLoader;", "feedLoader$delegate", "Lkotlin/Lazy;", "lastEnterTime", "", "presenter", "Lcom/tencent/mm/plugin/finder/feed/FinderPoiFeedUIContract$PoiFeedPresenter;", "getPresenter", "()Lcom/tencent/mm/plugin/finder/feed/FinderPoiFeedUIContract$PoiFeedPresenter;", "presenter$delegate", "snsFeedId", "", "viewCallback", "Lcom/tencent/mm/plugin/finder/feed/FinderPoiFeedUIContract$PoiFeedViewCallback;", "getViewCallback", "()Lcom/tencent/mm/plugin/finder/feed/FinderPoiFeedUIContract$PoiFeedViewCallback;", "viewCallback$delegate", "getCommentScene", "", "getLayoutId", "getReportSourceId", "getReportType", "goBack", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onPause", "onResume", "reportClickPhone", "reportGoToMap", "setIconMenu", "Action", "Companion", "plugin-finder_release"})
public final class FinderPoiFeedUI
  extends MMFinderUI
{
  public static final int tqu = 10001;
  public static final b uce;
  private HashMap _$_findViewCache;
  private final kotlin.f tPy;
  private long taC;
  private final kotlin.f ucb;
  private final kotlin.f ucc;
  private String ucd;
  
  static
  {
    AppMethodBeat.i(245468);
    uce = new b((byte)0);
    tqu = 10001;
    AppMethodBeat.o(245468);
  }
  
  public FinderPoiFeedUI()
  {
    AppMethodBeat.i(245467);
    this.ucb = kotlin.g.ah((kotlin.g.a.a)new e(this));
    this.ucc = kotlin.g.ah((kotlin.g.a.a)new j(this));
    this.tPy = kotlin.g.ah((kotlin.g.a.a)new c(this));
    AppMethodBeat.o(245467);
  }
  
  private final z.a del()
  {
    AppMethodBeat.i(245459);
    z.a locala = (z.a)this.ucb.getValue();
    AppMethodBeat.o(245459);
    return locala;
  }
  
  public final void _$_clearFindViewByIdCache()
  {
    AppMethodBeat.i(245474);
    if (this._$_findViewCache != null) {
      this._$_findViewCache.clear();
    }
    AppMethodBeat.o(245474);
  }
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(245473);
    if (this._$_findViewCache == null) {
      this._$_findViewCache = new HashMap();
    }
    View localView2 = (View)this._$_findViewCache.get(Integer.valueOf(paramInt));
    View localView1 = localView2;
    if (localView2 == null)
    {
      localView1 = findViewById(paramInt);
      this._$_findViewCache.put(Integer.valueOf(paramInt), localView1);
    }
    AppMethodBeat.o(245473);
    return localView1;
  }
  
  public final int ddN()
  {
    return 3;
  }
  
  public final z.b dem()
  {
    AppMethodBeat.i(245460);
    z.b localb = (z.b)this.ucc.getValue();
    AppMethodBeat.o(245460);
    return localb;
  }
  
  public final FinderPoiFeedLoader den()
  {
    AppMethodBeat.i(245461);
    FinderPoiFeedLoader localFinderPoiFeedLoader = (FinderPoiFeedLoader)this.tPy.getValue();
    AppMethodBeat.o(245461);
    return localFinderPoiFeedLoader;
  }
  
  public final String deo()
  {
    AppMethodBeat.i(245466);
    String str2 = this.ucd;
    String str1 = str2;
    if (str2 == null) {
      str1 = z.aTY();
    }
    AppMethodBeat.o(245466);
    return str1;
  }
  
  public final int getCommentScene()
  {
    return 81;
  }
  
  public final int getLayoutId()
  {
    return 2131494559;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(245462);
    super.onCreate(paramBundle);
    setBackBtn((MenuItem.OnMenuItemClickListener)new d(this));
    setActionbarColor(getResources().getColor(2131099650));
    setMMTitle("");
    Object localObject1 = den();
    paramBundle = (com.tencent.mm.bw.a)new eaa();
    Object localObject2 = getIntent().getByteArrayExtra("key_location");
    try
    {
      paramBundle.parseFrom((byte[])localObject2);
      ((FinderPoiFeedLoader)localObject1).tWy = ((eaa)paramBundle);
      localObject2 = den();
      localObject1 = getIntent().getSerializableExtra("key_from_type");
      paramBundle = (Bundle)localObject1;
      if (!(localObject1 instanceof y.a)) {
        paramBundle = null;
      }
      ((FinderPoiFeedLoader)localObject2).tWz = ((y.a)paramBundle);
      this.ucd = getIntent().getStringExtra("key_sns_feed_id");
      dem().a((c.a)del());
      del().a((c.b)dem());
      AppMethodBeat.o(245462);
      return;
    }
    catch (Exception paramBundle)
    {
      for (;;)
      {
        Log.printDebugStack("safeParser", "", new Object[] { paramBundle });
        paramBundle = null;
      }
    }
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(245465);
    del().onDetach();
    super.onDestroy();
    AppMethodBeat.o(245465);
  }
  
  public final void onPause()
  {
    String str = null;
    AppMethodBeat.i(245464);
    super.onPause();
    Object localObject = k.vfA;
    a locala = a.ucn;
    long l = dem().tPc;
    localObject = FinderReporterUIC.wzC;
    localObject = FinderReporterUIC.a.fH((Context)this);
    if (localObject != null) {}
    for (localObject = ((FinderReporterUIC)localObject).dIx();; localObject = null)
    {
      eaa localeaa = den().tWy;
      if (localeaa != null) {
        str = localeaa.LIb;
      }
      k.a(locala, l, (bbn)localObject, str, dem().tPd, deo(), cl.aWA() - this.taC);
      AppMethodBeat.o(245464);
      return;
    }
  }
  
  public final void onResume()
  {
    String str = null;
    AppMethodBeat.i(245463);
    super.onResume();
    this.taC = cl.aWA();
    Object localObject = k.vfA;
    a locala = a.ucg;
    long l = dem().tPc;
    localObject = FinderReporterUIC.wzC;
    localObject = FinderReporterUIC.a.fH((Context)this);
    if (localObject != null) {}
    for (localObject = ((FinderReporterUIC)localObject).dIx();; localObject = null)
    {
      eaa localeaa = den().tWy;
      if (localeaa != null) {
        str = localeaa.LIb;
      }
      k.a(locala, l, (bbn)localObject, str, dem().tPd, deo());
      AppMethodBeat.o(245463);
      return;
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/feed/ui/FinderPoiFeedUI$Action;", "", "(Ljava/lang/String;I)V", "ACTION_UNKNOWN", "ACTION_ENTER_POI_FEED_UI", "ACTION_GO_TO_MAP", "ACTION_CLICK_PHONE", "ACTION_SHARE_TO_CHAT", "ACTION_ADD_TO_FAV", "ACTION_REPORT_POI_ERROR", "ACTION_GO_TO_FINDER_PROFILE", "ACTION_LEAVE_POI_FEED_UI", "plugin-finder_release"})
  public static enum a
  {
    static
    {
      AppMethodBeat.i(245448);
      a locala1 = new a("ACTION_UNKNOWN", 0);
      ucf = locala1;
      a locala2 = new a("ACTION_ENTER_POI_FEED_UI", 1);
      ucg = locala2;
      a locala3 = new a("ACTION_GO_TO_MAP", 2);
      uch = locala3;
      a locala4 = new a("ACTION_CLICK_PHONE", 3);
      uci = locala4;
      a locala5 = new a("ACTION_SHARE_TO_CHAT", 4);
      ucj = locala5;
      a locala6 = new a("ACTION_ADD_TO_FAV", 5);
      uck = locala6;
      a locala7 = new a("ACTION_REPORT_POI_ERROR", 6);
      ucl = locala7;
      a locala8 = new a("ACTION_GO_TO_FINDER_PROFILE", 7);
      ucm = locala8;
      a locala9 = new a("ACTION_LEAVE_POI_FEED_UI", 8);
      ucn = locala9;
      uco = new a[] { locala1, locala2, locala3, locala4, locala5, locala6, locala7, locala8, locala9 };
      AppMethodBeat.o(245448);
    }
    
    private a() {}
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/feed/ui/FinderPoiFeedUI$Companion;", "", "()V", "MENU_ID_MORE", "", "MENU_ID_SHARE_TO_CHAT", "TAG", "", "plugin-finder_release"})
  public static final class b {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Lcom/tencent/mm/plugin/finder/feed/model/FinderPoiFeedLoader;", "invoke"})
  static final class c
    extends q
    implements kotlin.g.a.a<FinderPoiFeedLoader>
  {
    c(FinderPoiFeedUI paramFinderPoiFeedUI)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class d
    implements MenuItem.OnMenuItemClickListener
  {
    d(FinderPoiFeedUI paramFinderPoiFeedUI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(245452);
      FinderPoiFeedUI.a(this.ucp);
      AppMethodBeat.o(245452);
      return true;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Lcom/tencent/mm/plugin/finder/feed/FinderPoiFeedUIContract$PoiFeedPresenter;", "invoke"})
  static final class e
    extends q
    implements kotlin.g.a.a<z.a>
  {
    e(FinderPoiFeedUI paramFinderPoiFeedUI)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "menu", "Lcom/tencent/mm/ui/base/MMMenu;", "kotlin.jvm.PlatformType", "onCreateMMMenu"})
  public static final class f
    implements o.f
  {
    public f(FinderPoiFeedUI paramFinderPoiFeedUI) {}
    
    public final void onCreateMMMenu(m paramm)
    {
      AppMethodBeat.i(245454);
      p.g(paramm, "menu");
      if (paramm.gKQ())
      {
        Object localObject = this.ucp.getContext().getString(2131755985);
        p.g(localObject, "context.getString(R.string.app_share_to_weixin)");
        boolean bool = false;
        if (FinderPoiFeedUI.b(this.ucp).tWy == null)
        {
          localObject = y.vXH;
          localObject = y.dP("", 2131760540);
          bool = true;
        }
        localObject = (CharSequence)localObject;
        AppCompatActivity localAppCompatActivity = this.ucp.getContext();
        p.g(localAppCompatActivity, "context");
        paramm.a(10002, (CharSequence)localObject, 2131690251, localAppCompatActivity.getResources().getColor(2131099710), bool);
      }
      AppMethodBeat.o(245454);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "menuItem", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "index", "", "onMMMenuItemSelected"})
  public static final class g
    implements o.g
  {
    public g(FinderPoiFeedUI paramFinderPoiFeedUI) {}
    
    public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
    {
      AppMethodBeat.i(245455);
      p.g(paramMenuItem, "menuItem");
      switch (paramMenuItem.getItemId())
      {
      default: 
        AppMethodBeat.o(245455);
        return;
      }
      Object localObject2 = FinderPoiFeedUI.b(this.ucp).tWy;
      String str = FinderPoiFeedUI.c(this.ucp).tPa;
      if (localObject2 == null)
      {
        u.makeText((Context)this.ucp, 2131760540, 0).show();
        AppMethodBeat.o(245455);
        return;
      }
      paramMenuItem = k.vfA;
      Object localObject3 = FinderPoiFeedUI.a.ucj;
      long l = FinderPoiFeedUI.c(this.ucp).tPc;
      paramMenuItem = FinderReporterUIC.wzC;
      paramMenuItem = FinderReporterUIC.a.fH((Context)this.ucp);
      if (paramMenuItem != null)
      {
        paramMenuItem = paramMenuItem.dIx();
        label137:
        localObject1 = FinderPoiFeedUI.b(this.ucp).tWy;
        if (localObject1 == null) {
          break label511;
        }
      }
      label511:
      for (Object localObject1 = ((eaa)localObject1).LIb;; localObject1 = null)
      {
        k.a((FinderPoiFeedUI.a)localObject3, l, paramMenuItem, (String)localObject1, FinderPoiFeedUI.c(this.ucp).tPd, FinderPoiFeedUI.d(this.ucp));
        paramMenuItem = s.vWt;
        localObject1 = (MMActivity)this.ucp;
        p.h(localObject1, "context");
        p.h(localObject2, "location");
        p.h(str, "poiCategories");
        localObject3 = com.tencent.mm.plugin.finder.spam.a.vwk;
        if (com.tencent.mm.plugin.finder.spam.a.avp("share")) {
          break;
        }
        localObject3 = new k.b();
        com.tencent.mm.plugin.i.a.g localg = new com.tencent.mm.plugin.i.a.g();
        localg.wDZ.LLz = String.valueOf(((eaa)localObject2).LbC);
        localg.wDZ.LLy = String.valueOf(((eaa)localObject2).LbD);
        localg.wDZ.LIb = ((eaa)localObject2).LIb;
        localg.wDZ.LLA = String.valueOf(((eaa)localObject2).Mpu);
        localg.wDZ.JTr = ((eaa)localObject2).Mpt;
        localg.wDZ.iUO = ((eaa)localObject2).ErZ;
        localg.wDZ.kHV = ((eaa)localObject2).kHV;
        localg.wDZ.tPa = str;
        ((k.b)localObject3).a((com.tencent.mm.ag.f)localg);
        ((k.b)localObject3).type = 75;
        ((k.b)localObject3).izD = 2;
        ((k.b)localObject3).title = MMApplicationContext.getContext().getString(2131762562);
        ((k.b)localObject3).url = MMApplicationContext.getContext().getString(2131762563);
        localObject2 = new Intent();
        ((Intent)localObject2).putExtra("Retr_Msg_Type", 28);
        ((Intent)localObject2).putExtra("Multi_Retr", true);
        ((Intent)localObject2).putExtra("Retr_Msg_content", k.b.a((k.b)localObject3, null, null));
        ((Intent)localObject2).putExtra("Retr_go_to_chattingUI", false);
        ((Intent)localObject2).putExtra("Retr_show_success_tips", true);
        c.a((MMActivity)localObject1, ".ui.transmit.MsgRetransmitUI", (Intent)localObject2, 1001, (MMActivity.a)new s.a.i(paramMenuItem, localg));
        break;
        paramMenuItem = null;
        break label137;
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  public static final class i
    implements MenuItem.OnMenuItemClickListener
  {
    public i(e parame) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(245457);
      this.nkZ.dGm();
      AppMethodBeat.o(245457);
      return true;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Lcom/tencent/mm/plugin/finder/feed/FinderPoiFeedUIContract$PoiFeedViewCallback;", "invoke"})
  static final class j
    extends q
    implements kotlin.g.a.a<z.b>
  {
    j(FinderPoiFeedUI paramFinderPoiFeedUI)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.ui.FinderPoiFeedUI
 * JD-Core Version:    0.7.0.1
 */