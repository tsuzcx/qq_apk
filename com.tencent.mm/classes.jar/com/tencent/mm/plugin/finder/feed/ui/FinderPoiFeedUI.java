package com.tencent.mm.plugin.finder.feed.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.k.b;
import com.tencent.mm.by.c;
import com.tencent.mm.model.cm;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.b.c;
import com.tencent.mm.plugin.finder.b.g;
import com.tencent.mm.plugin.finder.b.i;
import com.tencent.mm.plugin.finder.b.j;
import com.tencent.mm.plugin.finder.feed.ae.a;
import com.tencent.mm.plugin.finder.feed.ae.b;
import com.tencent.mm.plugin.finder.feed.c.a;
import com.tencent.mm.plugin.finder.feed.c.b;
import com.tencent.mm.plugin.finder.feed.model.FinderPoiFeedLoader;
import com.tencent.mm.plugin.finder.report.n;
import com.tencent.mm.plugin.finder.ui.MMFinderUI;
import com.tencent.mm.plugin.finder.utils.ac;
import com.tencent.mm.plugin.finder.utils.ac.a;
import com.tencent.mm.plugin.finder.utils.ac.a.h;
import com.tencent.mm.plugin.finder.utils.ac.a.i;
import com.tencent.mm.plugin.finder.viewmodel.component.aj.a;
import com.tencent.mm.plugin.findersdk.a.y.a;
import com.tencent.mm.protocal.protobuf.bid;
import com.tencent.mm.protocal.protobuf.bjf;
import com.tencent.mm.protocal.protobuf.eka;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMActivity.a;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.base.q.f;
import com.tencent.mm.ui.base.q.g;
import com.tencent.mm.ui.base.w;
import java.util.HashMap;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/feed/ui/FinderPoiFeedUI;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "()V", "feedLoader", "Lcom/tencent/mm/plugin/finder/feed/model/FinderPoiFeedLoader;", "getFeedLoader", "()Lcom/tencent/mm/plugin/finder/feed/model/FinderPoiFeedLoader;", "feedLoader$delegate", "Lkotlin/Lazy;", "lastEnterTime", "", "presenter", "Lcom/tencent/mm/plugin/finder/feed/FinderPoiFeedUIContract$PoiFeedPresenter;", "getPresenter", "()Lcom/tencent/mm/plugin/finder/feed/FinderPoiFeedUIContract$PoiFeedPresenter;", "presenter$delegate", "snsFeedId", "", "viewCallback", "Lcom/tencent/mm/plugin/finder/feed/FinderPoiFeedUIContract$PoiFeedViewCallback;", "getViewCallback", "()Lcom/tencent/mm/plugin/finder/feed/FinderPoiFeedUIContract$PoiFeedViewCallback;", "viewCallback$delegate", "getCommentScene", "", "getLayoutId", "getReportSourceId", "getReportType", "goBack", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onPause", "onResume", "reportClickPhone", "reportGoToMap", "setIconMenu", "Action", "Companion", "plugin-finder_release"})
public final class FinderPoiFeedUI
  extends MMFinderUI
{
  public static final int wXe = 10001;
  public static final b xQX;
  private HashMap _$_findViewCache;
  private long wGG;
  private final kotlin.f xAp;
  private final kotlin.f xQU;
  private final kotlin.f xQV;
  private String xQW;
  
  static
  {
    AppMethodBeat.i(278632);
    xQX = new b((byte)0);
    wXe = 10001;
    AppMethodBeat.o(278632);
  }
  
  public FinderPoiFeedUI()
  {
    AppMethodBeat.i(278631);
    this.xQU = kotlin.g.ar((kotlin.g.a.a)new e(this));
    this.xQV = kotlin.g.ar((kotlin.g.a.a)new j(this));
    this.xAp = kotlin.g.ar((kotlin.g.a.a)new c(this));
    AppMethodBeat.o(278631);
  }
  
  private final ae.a dvJ()
  {
    AppMethodBeat.i(278622);
    ae.a locala = (ae.a)this.xQU.getValue();
    AppMethodBeat.o(278622);
    return locala;
  }
  
  public final void _$_clearFindViewByIdCache()
  {
    AppMethodBeat.i(278638);
    if (this._$_findViewCache != null) {
      this._$_findViewCache.clear();
    }
    AppMethodBeat.o(278638);
  }
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(278637);
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
    AppMethodBeat.o(278637);
    return localView1;
  }
  
  public final int duR()
  {
    return 3;
  }
  
  public final ae.b dvK()
  {
    AppMethodBeat.i(278623);
    ae.b localb = (ae.b)this.xQV.getValue();
    AppMethodBeat.o(278623);
    return localb;
  }
  
  public final FinderPoiFeedLoader dvL()
  {
    AppMethodBeat.i(278624);
    FinderPoiFeedLoader localFinderPoiFeedLoader = (FinderPoiFeedLoader)this.xAp.getValue();
    AppMethodBeat.o(278624);
    return localFinderPoiFeedLoader;
  }
  
  public final String dvM()
  {
    AppMethodBeat.i(278630);
    String str2 = this.xQW;
    String str1 = str2;
    if (str2 == null) {
      str1 = z.bcZ();
    }
    AppMethodBeat.o(278630);
    return str1;
  }
  
  public final int getCommentScene()
  {
    return 81;
  }
  
  public final int getLayoutId()
  {
    return b.g.finder_poi_feed_ui;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(278625);
    super.onCreate(paramBundle);
    setBackBtn((MenuItem.OnMenuItemClickListener)new d(this));
    setActionbarColor(getResources().getColor(b.c.BG_2));
    setMMTitle("");
    Object localObject1 = dvL();
    paramBundle = (com.tencent.mm.cd.a)new eka();
    Object localObject2 = getIntent().getByteArrayExtra("key_location");
    try
    {
      paramBundle.parseFrom((byte[])localObject2);
      ((FinderPoiFeedLoader)localObject1).xIr = ((eka)paramBundle);
      localObject2 = dvL();
      localObject1 = getIntent().getSerializableExtra("key_from_type");
      paramBundle = (Bundle)localObject1;
      if (!(localObject1 instanceof y.a)) {
        paramBundle = null;
      }
      ((FinderPoiFeedLoader)localObject2).xIs = ((y.a)paramBundle);
      if (getIntent().hasExtra("key_from_scene")) {
        dvL().xIt = Integer.valueOf(getIntent().getIntExtra("key_from_scene", 0));
      }
      this.xQW = getIntent().getStringExtra("key_sns_feed_id");
      dvK().a((c.a)dvJ());
      dvJ().a((c.b)dvK());
      AppMethodBeat.o(278625);
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
    AppMethodBeat.i(278629);
    dvJ().onDetach();
    super.onDestroy();
    AppMethodBeat.o(278629);
  }
  
  public final void onPause()
  {
    String str = null;
    AppMethodBeat.i(278628);
    super.onPause();
    Object localObject = n.zWF;
    a locala = a.xRg;
    long l = dvK().xzP;
    localObject = com.tencent.mm.plugin.finder.viewmodel.component.aj.Bnu;
    localObject = aj.a.fZ((Context)this);
    if (localObject != null) {}
    for (localObject = ((com.tencent.mm.plugin.finder.viewmodel.component.aj)localObject).ekY();; localObject = null)
    {
      eka localeka = dvL().xIr;
      if (localeka != null) {
        str = localeka.SOz;
      }
      n.a(locala, l, (bid)localObject, str, dvK().xzQ, dvM(), cm.bfE() - this.wGG);
      AppMethodBeat.o(278628);
      return;
    }
  }
  
  public final void onResume()
  {
    String str = null;
    AppMethodBeat.i(278627);
    super.onResume();
    this.wGG = cm.bfE();
    Object localObject = n.zWF;
    a locala = a.xQZ;
    long l = dvK().xzP;
    localObject = com.tencent.mm.plugin.finder.viewmodel.component.aj.Bnu;
    localObject = aj.a.fZ((Context)this);
    if (localObject != null) {}
    for (localObject = ((com.tencent.mm.plugin.finder.viewmodel.component.aj)localObject).ekY();; localObject = null)
    {
      eka localeka = dvL().xIr;
      if (localeka != null) {
        str = localeka.SOz;
      }
      n.a(locala, l, (bid)localObject, str, dvK().xzQ, dvM());
      AppMethodBeat.o(278627);
      return;
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/feed/ui/FinderPoiFeedUI$Action;", "", "(Ljava/lang/String;I)V", "ACTION_UNKNOWN", "ACTION_ENTER_POI_FEED_UI", "ACTION_GO_TO_MAP", "ACTION_CLICK_PHONE", "ACTION_SHARE_TO_CHAT", "ACTION_ADD_TO_FAV", "ACTION_REPORT_POI_ERROR", "ACTION_GO_TO_FINDER_PROFILE", "ACTION_LEAVE_POI_FEED_UI", "ACTION_SHARE_TO_TIMELINE", "plugin-finder_release"})
  public static enum a
  {
    static
    {
      AppMethodBeat.i(270531);
      a locala1 = new a("ACTION_UNKNOWN", 0);
      xQY = locala1;
      a locala2 = new a("ACTION_ENTER_POI_FEED_UI", 1);
      xQZ = locala2;
      a locala3 = new a("ACTION_GO_TO_MAP", 2);
      xRa = locala3;
      a locala4 = new a("ACTION_CLICK_PHONE", 3);
      xRb = locala4;
      a locala5 = new a("ACTION_SHARE_TO_CHAT", 4);
      xRc = locala5;
      a locala6 = new a("ACTION_ADD_TO_FAV", 5);
      xRd = locala6;
      a locala7 = new a("ACTION_REPORT_POI_ERROR", 6);
      xRe = locala7;
      a locala8 = new a("ACTION_GO_TO_FINDER_PROFILE", 7);
      xRf = locala8;
      a locala9 = new a("ACTION_LEAVE_POI_FEED_UI", 8);
      xRg = locala9;
      a locala10 = new a("ACTION_SHARE_TO_TIMELINE", 9);
      xRh = locala10;
      xRi = new a[] { locala1, locala2, locala3, locala4, locala5, locala6, locala7, locala8, locala9, locala10 };
      AppMethodBeat.o(270531);
    }
    
    private a() {}
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/feed/ui/FinderPoiFeedUI$Companion;", "", "()V", "MENU_ID_MORE", "", "MENU_ID_SHARE_TO_CHAT", "MENU_ID_SHARE_TO_TIMELINE", "TAG", "", "plugin-finder_release"})
  public static final class b {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Lcom/tencent/mm/plugin/finder/feed/model/FinderPoiFeedLoader;", "invoke"})
  static final class c
    extends q
    implements kotlin.g.a.a<FinderPoiFeedLoader>
  {
    c(FinderPoiFeedUI paramFinderPoiFeedUI)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class d
    implements MenuItem.OnMenuItemClickListener
  {
    d(FinderPoiFeedUI paramFinderPoiFeedUI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(288742);
      FinderPoiFeedUI.a(this.xRj);
      AppMethodBeat.o(288742);
      return true;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Lcom/tencent/mm/plugin/finder/feed/FinderPoiFeedUIContract$PoiFeedPresenter;", "invoke"})
  static final class e
    extends q
    implements kotlin.g.a.a<ae.a>
  {
    e(FinderPoiFeedUI paramFinderPoiFeedUI)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "menu", "Lcom/tencent/mm/ui/base/MMMenu;", "kotlin.jvm.PlatformType", "onCreateMMMenu"})
  public static final class f
    implements q.f
  {
    public f(FinderPoiFeedUI paramFinderPoiFeedUI) {}
    
    public final void onCreateMMMenu(o paramo)
    {
      AppMethodBeat.i(277797);
      p.j(paramo, "menu");
      Object localObject2;
      Object localObject1;
      boolean bool2;
      if (paramo.hJO())
      {
        localObject2 = this.xRj.getContext().getString(b.j.app_share_to_weixin);
        p.j(localObject2, "context.getString(R.string.app_share_to_weixin)");
        localObject1 = this.xRj.getContext().getString(b.j.finder_share_timeline);
        p.j(localObject1, "context.getString(R.string.finder_share_timeline)");
        if (FinderPoiFeedUI.b(this.xRj).xIr != null) {
          break label185;
        }
        localObject1 = com.tencent.mm.plugin.finder.utils.aj.AGc;
        localObject2 = com.tencent.mm.plugin.finder.utils.aj.el("", b.j.finder_self_see_tips_forward);
        localObject1 = com.tencent.mm.plugin.finder.utils.aj.AGc;
        localObject1 = com.tencent.mm.plugin.finder.utils.aj.el("", b.j.finder_self_see_tips_sns);
        bool2 = true;
      }
      for (boolean bool1 = true;; bool1 = false)
      {
        localObject2 = (CharSequence)localObject2;
        int i = b.i.finder_icons_filled_share;
        AppCompatActivity localAppCompatActivity = this.xRj.getContext();
        p.j(localAppCompatActivity, "context");
        paramo.a(10002, (CharSequence)localObject2, i, localAppCompatActivity.getResources().getColor(b.c.Brand), bool1);
        paramo.a(10003, (CharSequence)localObject1, b.i.bottomsheet_icon_moment, 0, bool2);
        AppMethodBeat.o(277797);
        return;
        label185:
        bool2 = false;
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "menuItem", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "index", "", "onMMMenuItemSelected"})
  public static final class g
    implements q.g
  {
    public g(FinderPoiFeedUI paramFinderPoiFeedUI) {}
    
    public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
    {
      AppMethodBeat.i(267614);
      Object localObject2 = FinderPoiFeedUI.b(this.xRj).xIr;
      String str1 = FinderPoiFeedUI.c(this.xRj).xzN;
      p.j(paramMenuItem, "menuItem");
      Object localObject5;
      Object localObject4;
      switch (paramMenuItem.getItemId())
      {
      default: 
        AppMethodBeat.o(267614);
        return;
      case 10002: 
        if (localObject2 == null)
        {
          w.makeText((Context)this.xRj, b.j.finder_self_see_tips_forward, 0).show();
          AppMethodBeat.o(267614);
          return;
        }
        paramMenuItem = n.zWF;
        localObject3 = FinderPoiFeedUI.a.xRc;
        l = FinderPoiFeedUI.c(this.xRj).xzP;
        paramMenuItem = com.tencent.mm.plugin.finder.viewmodel.component.aj.Bnu;
        paramMenuItem = aj.a.fZ((Context)this.xRj);
        if (paramMenuItem != null)
        {
          paramMenuItem = paramMenuItem.ekY();
          localObject1 = FinderPoiFeedUI.b(this.xRj).xIr;
          if (localObject1 == null) {
            break label471;
          }
        }
        label471:
        for (localObject1 = ((eka)localObject1).SOz;; localObject1 = null)
        {
          n.a((FinderPoiFeedUI.a)localObject3, l, paramMenuItem, (String)localObject1, FinderPoiFeedUI.c(this.xRj).xzQ, FinderPoiFeedUI.d(this.xRj));
          paramMenuItem = ac.AEJ;
          localObject1 = (MMActivity)this.xRj;
          localObject5 = FinderPoiFeedUI.c(this.xRj).getIconUrl();
          String str2 = FinderPoiFeedUI.c(this.xRj).poiName;
          paramInt = FinderPoiFeedUI.c(this.xRj).xzT;
          p.k(localObject1, "context");
          p.k(localObject2, "location");
          p.k(str1, "poiCategories");
          localObject3 = com.tencent.mm.plugin.findersdk.c.a.Bwg;
          if (!com.tencent.mm.plugin.findersdk.c.a.aGS("share"))
          {
            localObject3 = new k.b();
            localObject4 = new com.tencent.mm.plugin.findersdk.a.g();
            localObject2 = ac.a.a((eka)localObject2, str1, (String)localObject5, str2, paramInt);
            p.k(localObject2, "<set-?>");
            ((com.tencent.mm.plugin.findersdk.a.g)localObject4).mbj = ((bjf)localObject2);
            ((k.b)localObject3).a((com.tencent.mm.aj.f)localObject4);
            ((k.b)localObject3).type = 75;
            ((k.b)localObject3).loX = 2;
            ((k.b)localObject3).title = MMApplicationContext.getContext().getString(b.j.low_version_upgrade_tip);
            ((k.b)localObject3).url = MMApplicationContext.getContext().getString(b.j.low_version_upgrade_url);
            localObject2 = new Intent();
            ((Intent)localObject2).putExtra("Retr_Msg_Type", 28);
            ((Intent)localObject2).putExtra("Multi_Retr", true);
            ((Intent)localObject2).putExtra("Retr_Msg_content", k.b.a((k.b)localObject3, null, null));
            ((Intent)localObject2).putExtra("Retr_go_to_chattingUI", false);
            ((Intent)localObject2).putExtra("Retr_show_success_tips", true);
            c.a((MMActivity)localObject1, ".ui.transmit.MsgRetransmitUI", (Intent)localObject2, 1001, (MMActivity.a)new ac.a.h(paramMenuItem, (com.tencent.mm.plugin.findersdk.a.g)localObject4));
          }
          AppMethodBeat.o(267614);
          return;
          paramMenuItem = null;
          break;
        }
      }
      if (localObject2 == null)
      {
        w.makeText((Context)this.xRj, b.j.finder_self_see_tips_sns, 0).show();
        AppMethodBeat.o(267614);
        return;
      }
      paramMenuItem = n.zWF;
      Object localObject3 = FinderPoiFeedUI.a.xRh;
      long l = FinderPoiFeedUI.c(this.xRj).xzP;
      paramMenuItem = com.tencent.mm.plugin.finder.viewmodel.component.aj.Bnu;
      paramMenuItem = aj.a.fZ((Context)this.xRj);
      if (paramMenuItem != null)
      {
        paramMenuItem = paramMenuItem.ekY();
        label549:
        localObject1 = FinderPoiFeedUI.b(this.xRj).xIr;
        if (localObject1 == null) {
          break label780;
        }
      }
      label780:
      for (Object localObject1 = ((eka)localObject1).SOz;; localObject1 = null)
      {
        n.a((FinderPoiFeedUI.a)localObject3, l, paramMenuItem, (String)localObject1, FinderPoiFeedUI.c(this.xRj).xzQ, FinderPoiFeedUI.d(this.xRj));
        paramMenuItem = ac.AEJ;
        paramMenuItem = (MMActivity)this.xRj;
        localObject1 = FinderPoiFeedUI.c(this.xRj).getIconUrl();
        localObject3 = FinderPoiFeedUI.c(this.xRj).poiName;
        paramInt = FinderPoiFeedUI.c(this.xRj).xzT;
        p.k(paramMenuItem, "context");
        p.k(localObject2, "location");
        p.k(str1, "poiCategories");
        localObject4 = com.tencent.mm.plugin.findersdk.c.a.Bwg;
        if (com.tencent.mm.plugin.findersdk.c.a.aGS("share")) {
          break;
        }
        localObject4 = new Intent();
        localObject5 = new com.tencent.mm.modelsns.f();
        ((com.tencent.mm.modelsns.f)localObject5).mbj = ac.a.a((eka)localObject2, str1, (String)localObject1, (String)localObject3, paramInt);
        ((Intent)localObject4).putExtra("ksnsupload_finder_poi_xml", ((com.tencent.mm.modelsns.f)localObject5).boV());
        ((Intent)localObject4).putExtra("Ksnsupload_type", 29);
        ((Intent)localObject4).putExtra("need_result", true);
        c.a(paramMenuItem, ".plugin.sns.ui.SnsUploadUI", (Intent)localObject4, 1002, (MMActivity.a)new ac.a.i(paramMenuItem));
        break;
        paramMenuItem = null;
        break label549;
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Lcom/tencent/mm/plugin/finder/feed/FinderPoiFeedUIContract$PoiFeedViewCallback;", "invoke"})
  static final class j
    extends q
    implements kotlin.g.a.a<ae.b>
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