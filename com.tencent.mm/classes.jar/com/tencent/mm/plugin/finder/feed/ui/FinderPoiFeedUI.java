package com.tencent.mm.plugin.finder.feed.ui;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.c;
import com.tencent.mm.model.cn;
import com.tencent.mm.plugin.finder.e.b;
import com.tencent.mm.plugin.finder.e.d;
import com.tencent.mm.plugin.finder.e.f;
import com.tencent.mm.plugin.finder.e.g;
import com.tencent.mm.plugin.finder.e.h;
import com.tencent.mm.plugin.finder.feed.ai.a;
import com.tencent.mm.plugin.finder.feed.ai.b;
import com.tencent.mm.plugin.finder.feed.c.a;
import com.tencent.mm.plugin.finder.feed.c.b;
import com.tencent.mm.plugin.finder.feed.model.FinderPoiFeedLoader;
import com.tencent.mm.plugin.finder.ui.MMFinderUI;
import com.tencent.mm.plugin.finder.utils.an;
import com.tencent.mm.plugin.finder.utils.an.a;
import com.tencent.mm.plugin.finder.utils.av;
import com.tencent.mm.plugin.finder.viewmodel.component.as;
import com.tencent.mm.plugin.finder.viewmodel.component.as.a;
import com.tencent.mm.plugin.findersdk.a.bi.a;
import com.tencent.mm.protocal.protobuf.bui;
import com.tencent.mm.protocal.protobuf.eer;
import com.tencent.mm.protocal.protobuf.fei;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.aa;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.widget.a.f;
import java.util.HashSet;
import kotlin.Metadata;
import kotlin.g.b.u;
import kotlin.j;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/ui/FinderPoiFeedUI;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "()V", "feedLoader", "Lcom/tencent/mm/plugin/finder/feed/model/FinderPoiFeedLoader;", "getFeedLoader", "()Lcom/tencent/mm/plugin/finder/feed/model/FinderPoiFeedLoader;", "feedLoader$delegate", "Lkotlin/Lazy;", "lastEnterTime", "", "presenter", "Lcom/tencent/mm/plugin/finder/feed/FinderPoiFeedUIContract$PoiFeedPresenter;", "getPresenter", "()Lcom/tencent/mm/plugin/finder/feed/FinderPoiFeedUIContract$PoiFeedPresenter;", "presenter$delegate", "snsFeedId", "", "viewCallback", "Lcom/tencent/mm/plugin/finder/feed/FinderPoiFeedUIContract$PoiFeedViewCallback;", "getViewCallback", "()Lcom/tencent/mm/plugin/finder/feed/FinderPoiFeedUIContract$PoiFeedViewCallback;", "viewCallback$delegate", "enterPoiReportErr", "", "getCommentScene", "", "getLayoutId", "getReportSourceId", "getReportType", "goBack", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onPause", "onResume", "reportClickPhone", "reportGoToMap", "setIconMenu", "showPoiClaimBottomDig", "superImportUIComponents", "set", "Ljava/util/HashSet;", "Ljava/lang/Class;", "Lcom/tencent/mm/ui/component/UIComponent;", "Action", "Companion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class FinderPoiFeedUI
  extends MMFinderUI
{
  public static final b Bqu;
  private final j AYa;
  private long AcP;
  private final j Bqv;
  private final j Bqw;
  private String Bqx;
  
  static
  {
    AppMethodBeat.i(365332);
    Bqu = new b((byte)0);
    AppMethodBeat.o(365332);
  }
  
  public FinderPoiFeedUI()
  {
    AppMethodBeat.i(365252);
    this.Bqv = kotlin.k.cm((kotlin.g.a.a)new d(this));
    this.Bqw = kotlin.k.cm((kotlin.g.a.a)new e(this));
    this.AYa = kotlin.k.cm((kotlin.g.a.a)new c(this));
    AppMethodBeat.o(365252);
  }
  
  private static final void a(FinderPoiFeedUI paramFinderPoiFeedUI)
  {
    AppMethodBeat.i(365306);
    kotlin.g.b.s.u(paramFinderPoiFeedUI, "this$0");
    Object localObject1 = new JSONObject();
    ((JSONObject)localObject1).put("click_option", "cancel");
    Object localObject2 = com.tencent.mm.plugin.finder.report.z.FrZ;
    localObject1 = ((JSONObject)localObject1).toString();
    kotlin.g.b.s.s(localObject1, "kvJson.toString()");
    localObject1 = kotlin.n.n.bV((String)localObject1, ",", ";");
    localObject2 = as.GSQ;
    paramFinderPoiFeedUI = paramFinderPoiFeedUI.getContext();
    kotlin.g.b.s.s(paramFinderPoiFeedUI, "context");
    paramFinderPoiFeedUI = as.a.hu((Context)paramFinderPoiFeedUI);
    if (paramFinderPoiFeedUI == null) {}
    for (paramFinderPoiFeedUI = null;; paramFinderPoiFeedUI = paramFinderPoiFeedUI.fou())
    {
      com.tencent.mm.plugin.finder.report.z.b(1, "poi_detail_panel", (String)localObject1, paramFinderPoiFeedUI);
      AppMethodBeat.o(365306);
      return;
    }
  }
  
  private static final void a(FinderPoiFeedUI paramFinderPoiFeedUI, MenuItem paramMenuItem, int paramInt)
  {
    a locala = null;
    Object localObject2 = null;
    Object localObject1 = null;
    AppMethodBeat.i(365298);
    kotlin.g.b.s.u(paramFinderPoiFeedUI, "this$0");
    fei localfei = paramFinderPoiFeedUI.efH().BhH;
    String str = paramFinderPoiFeedUI.efG().AXm;
    switch (paramMenuItem.getItemId())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(365298);
      return;
      if (localfei == null)
      {
        aa.makeText((Context)paramFinderPoiFeedUI, e.h.finder_self_see_tips_forward, 0).show();
        AppMethodBeat.o(365298);
        return;
      }
      paramMenuItem = com.tencent.mm.plugin.finder.report.z.FrZ;
      locala = a.BqC;
      long l = paramFinderPoiFeedUI.efG().AXo;
      paramMenuItem = as.GSQ;
      paramMenuItem = as.a.hu((Context)paramFinderPoiFeedUI);
      if (paramMenuItem == null)
      {
        paramMenuItem = null;
        localObject2 = paramFinderPoiFeedUI.efH().BhH;
        if (localObject2 != null) {
          break label226;
        }
      }
      for (;;)
      {
        com.tencent.mm.plugin.finder.report.z.a(locala, l, paramMenuItem, (String)localObject1, paramFinderPoiFeedUI.efG().AXp, paramFinderPoiFeedUI.efJ());
        paramMenuItem = an.GhR;
        an.a.a((MMActivity)paramFinderPoiFeedUI, localfei, str, paramFinderPoiFeedUI.efG().getIconUrl(), paramFinderPoiFeedUI.efG().poiName, paramFinderPoiFeedUI.efG().AXs);
        AppMethodBeat.o(365298);
        return;
        paramMenuItem = paramMenuItem.fou();
        break;
        label226:
        localObject1 = ((fei)localObject2).ZWG;
      }
      if (localfei == null)
      {
        aa.makeText((Context)paramFinderPoiFeedUI, e.h.finder_self_see_tips_sns, 0).show();
        AppMethodBeat.o(365298);
        return;
      }
      paramMenuItem = com.tencent.mm.plugin.finder.report.z.FrZ;
      localObject2 = a.BqE;
      l = paramFinderPoiFeedUI.efG().AXo;
      paramMenuItem = as.GSQ;
      paramMenuItem = as.a.hu((Context)paramFinderPoiFeedUI);
      if (paramMenuItem == null)
      {
        paramMenuItem = null;
        localObject1 = paramFinderPoiFeedUI.efH().BhH;
        if (localObject1 != null) {
          break label384;
        }
      }
      label384:
      for (localObject1 = locala;; localObject1 = ((fei)localObject1).ZWG)
      {
        com.tencent.mm.plugin.finder.report.z.a((a)localObject2, l, paramMenuItem, (String)localObject1, paramFinderPoiFeedUI.efG().AXp, paramFinderPoiFeedUI.efJ());
        paramMenuItem = an.GhR;
        an.a.b((MMActivity)paramFinderPoiFeedUI, localfei, str, paramFinderPoiFeedUI.efG().getIconUrl(), paramFinderPoiFeedUI.efG().poiName, paramFinderPoiFeedUI.efG().AXs);
        AppMethodBeat.o(365298);
        return;
        paramMenuItem = paramMenuItem.fou();
        break;
      }
      new com.tencent.mm.plugin.finder.view.k((Context)paramFinderPoiFeedUI).setPoiPrepare(paramFinderPoiFeedUI.efH().BhI);
      paramMenuItem = new JSONObject();
      paramMenuItem.put("click_option", "channelclaim");
      localObject1 = com.tencent.mm.plugin.finder.report.z.FrZ;
      paramMenuItem = paramMenuItem.toString();
      kotlin.g.b.s.s(paramMenuItem, "kvJson.toString()");
      paramMenuItem = kotlin.n.n.bV(paramMenuItem, ",", ";");
      localObject1 = as.GSQ;
      paramFinderPoiFeedUI = paramFinderPoiFeedUI.getContext();
      kotlin.g.b.s.s(paramFinderPoiFeedUI, "context");
      paramFinderPoiFeedUI = as.a.hu((Context)paramFinderPoiFeedUI);
      if (paramFinderPoiFeedUI == null) {}
      for (paramFinderPoiFeedUI = (FinderPoiFeedUI)localObject2;; paramFinderPoiFeedUI = paramFinderPoiFeedUI.fou())
      {
        com.tencent.mm.plugin.finder.report.z.b(1, "poi_detail_panel", paramMenuItem, paramFinderPoiFeedUI);
        AppMethodBeat.o(365298);
        return;
      }
      paramMenuItem = paramFinderPoiFeedUI.efH().BhI;
      if (paramMenuItem != null)
      {
        localObject1 = new Intent();
        ((Intent)localObject1).putExtra("rawUrl", paramMenuItem.abkl);
        c.b((Context)paramFinderPoiFeedUI.getContext(), "webview", ".ui.tools.WebViewUI", (Intent)localObject1);
      }
    }
  }
  
  private static final void a(FinderPoiFeedUI paramFinderPoiFeedUI, com.tencent.mm.ui.base.s params)
  {
    AppMethodBeat.i(365280);
    kotlin.g.b.s.u(paramFinderPoiFeedUI, "this$0");
    Object localObject1;
    Object localObject2;
    String str1;
    String str2;
    boolean bool2;
    if (params.jmw())
    {
      localObject1 = paramFinderPoiFeedUI.getContext().getString(e.h.app_share_to_weixin);
      kotlin.g.b.s.s(localObject1, "context.getString(R.string.app_share_to_weixin)");
      localObject2 = paramFinderPoiFeedUI.getContext().getString(e.h.finder_share_timeline);
      kotlin.g.b.s.s(localObject2, "context.getString(R.string.finder_share_timeline)");
      str1 = paramFinderPoiFeedUI.getContext().getString(e.h.finder_poi_claim);
      kotlin.g.b.s.s(str1, "context.getString(R.string.finder_poi_claim)");
      str2 = paramFinderPoiFeedUI.getContext().getString(e.h.finder_poi_report_err);
      kotlin.g.b.s.s(str2, "context.getString(R.string.finder_poi_report_err)");
      if (paramFinderPoiFeedUI.efH().BhH != null) {
        break label254;
      }
      localObject1 = av.GiL;
      localObject1 = av.eX("", e.h.finder_self_see_tips_forward);
      localObject2 = av.GiL;
      localObject2 = av.eX("", e.h.finder_self_see_tips_sns);
      bool2 = true;
    }
    for (boolean bool1 = true;; bool1 = false)
    {
      params.a(10002, (CharSequence)localObject1, e.g.finder_icons_filled_share, paramFinderPoiFeedUI.getContext().getResources().getColor(e.b.Brand), bool1);
      params.a(10003, (CharSequence)localObject2, e.g.bottomsheet_icon_moment, 0, bool2);
      paramFinderPoiFeedUI = paramFinderPoiFeedUI.efH().BhI;
      if (paramFinderPoiFeedUI != null)
      {
        if (paramFinderPoiFeedUI.abkh == 1) {
          params.c(10004, (CharSequence)str1);
        }
        if (paramFinderPoiFeedUI.abki == 1) {
          params.c(10005, (CharSequence)str2);
        }
      }
      AppMethodBeat.o(365280);
      return;
      label254:
      bool2 = false;
    }
  }
  
  private static final boolean a(FinderPoiFeedUI paramFinderPoiFeedUI, MenuItem paramMenuItem)
  {
    AppMethodBeat.i(365268);
    kotlin.g.b.s.u(paramFinderPoiFeedUI, "this$0");
    paramFinderPoiFeedUI.finish();
    AppMethodBeat.o(365268);
    return true;
  }
  
  private static final boolean a(f paramf, MenuItem paramMenuItem)
  {
    AppMethodBeat.i(365321);
    kotlin.g.b.s.u(paramf, "$bottomSheet");
    paramf.dDn();
    AppMethodBeat.o(365321);
    return true;
  }
  
  private static final void b(FinderPoiFeedUI paramFinderPoiFeedUI)
  {
    AppMethodBeat.i(365312);
    kotlin.g.b.s.u(paramFinderPoiFeedUI, "this$0");
    Object localObject = com.tencent.mm.plugin.finder.report.z.FrZ;
    localObject = as.GSQ;
    paramFinderPoiFeedUI = paramFinderPoiFeedUI.getContext();
    kotlin.g.b.s.s(paramFinderPoiFeedUI, "context");
    paramFinderPoiFeedUI = as.a.hu((Context)paramFinderPoiFeedUI);
    if (paramFinderPoiFeedUI == null) {}
    for (paramFinderPoiFeedUI = null;; paramFinderPoiFeedUI = paramFinderPoiFeedUI.fou())
    {
      com.tencent.mm.plugin.finder.report.z.b(0, "poi_detail_panel", "", paramFinderPoiFeedUI);
      AppMethodBeat.o(365312);
      return;
    }
  }
  
  private final ai.a efF()
  {
    AppMethodBeat.i(365259);
    ai.a locala = (ai.a)this.Bqv.getValue();
    AppMethodBeat.o(365259);
    return locala;
  }
  
  public final void _$_clearFindViewByIdCache() {}
  
  public final int edC()
  {
    return 3;
  }
  
  public final ai.b efG()
  {
    AppMethodBeat.i(365383);
    ai.b localb = (ai.b)this.Bqw.getValue();
    AppMethodBeat.o(365383);
    return localb;
  }
  
  public final FinderPoiFeedLoader efH()
  {
    AppMethodBeat.i(365390);
    FinderPoiFeedLoader localFinderPoiFeedLoader = (FinderPoiFeedLoader)this.AYa.getValue();
    AppMethodBeat.o(365390);
    return localFinderPoiFeedLoader;
  }
  
  public final void efI()
  {
    AppMethodBeat.i(365420);
    f localf = new f((Context)this, 1, false);
    localf.Vtg = new FinderPoiFeedUI..ExternalSyntheticLambda2(this);
    localf.GAC = new FinderPoiFeedUI..ExternalSyntheticLambda3(this);
    localf.aeLi = new FinderPoiFeedUI..ExternalSyntheticLambda4(this);
    localf.agei = new FinderPoiFeedUI..ExternalSyntheticLambda5(this);
    addIconOptionMenu(10001, e.d.actionbar_icon_dark_more, new FinderPoiFeedUI..ExternalSyntheticLambda1(localf));
    AppMethodBeat.o(365420);
  }
  
  public final String efJ()
  {
    AppMethodBeat.i(365450);
    String str = this.Bqx;
    if (str == null)
    {
      str = com.tencent.mm.model.z.bAM();
      AppMethodBeat.o(365450);
      return str;
    }
    AppMethodBeat.o(365450);
    return str;
  }
  
  public final int getCommentScene()
  {
    return 81;
  }
  
  public final int getLayoutId()
  {
    return e.f.finder_poi_feed_ui;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(365407);
    super.onCreate(paramBundle);
    setBackBtn(new FinderPoiFeedUI..ExternalSyntheticLambda0(this));
    setActionbarColor(getResources().getColor(e.b.BG_2));
    setMMTitle("");
    FinderPoiFeedLoader localFinderPoiFeedLoader = efH();
    paramBundle = (com.tencent.mm.bx.a)new fei();
    byte[] arrayOfByte = getIntent().getByteArrayExtra("key_location");
    try
    {
      paramBundle.parseFrom(arrayOfByte);
      localFinderPoiFeedLoader.BhH = ((fei)paramBundle);
      localFinderPoiFeedLoader = efH();
      paramBundle = getIntent().getSerializableExtra("key_from_type");
      if ((paramBundle instanceof bi.a))
      {
        paramBundle = (bi.a)paramBundle;
        localFinderPoiFeedLoader.BhJ = paramBundle;
        if (getIntent().hasExtra("key_from_scene")) {
          efH().BhK = Integer.valueOf(getIntent().getIntExtra("key_from_scene", 0));
        }
        this.Bqx = getIntent().getStringExtra("key_sns_feed_id");
        efG().a((c.a)efF());
        efF().a((c.b)efG());
        AppMethodBeat.o(365407);
        return;
      }
    }
    catch (Exception paramBundle)
    {
      for (;;)
      {
        Log.printDebugStack("safeParser", "", new Object[] { paramBundle });
        paramBundle = null;
        continue;
        paramBundle = null;
      }
    }
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(365434);
    efF().onDetach();
    super.onDestroy();
    AppMethodBeat.o(365434);
  }
  
  public final void onPause()
  {
    String str = null;
    AppMethodBeat.i(365429);
    super.onPause();
    efF().onUIPause();
    Object localObject = com.tencent.mm.plugin.finder.report.z.FrZ;
    a locala = a.BqD;
    long l = efG().AXo;
    localObject = as.GSQ;
    localObject = as.a.hu((Context)this);
    fei localfei;
    if (localObject == null)
    {
      localObject = null;
      localfei = efH().BhH;
      if (localfei != null) {
        break label112;
      }
    }
    for (;;)
    {
      com.tencent.mm.plugin.finder.report.z.a(locala, l, (bui)localObject, str, efG().AXp, efJ(), cn.bDw() - this.AcP);
      AppMethodBeat.o(365429);
      return;
      localObject = ((as)localObject).fou();
      break;
      label112:
      str = localfei.ZWG;
    }
  }
  
  public final void onResume()
  {
    String str = null;
    AppMethodBeat.i(365424);
    super.onResume();
    this.AcP = cn.bDw();
    efF().onUIResume();
    Object localObject = com.tencent.mm.plugin.finder.report.z.FrZ;
    a locala = a.Bqz;
    long l = efG().AXo;
    localObject = as.GSQ;
    localObject = as.a.hu((Context)this);
    fei localfei;
    if (localObject == null)
    {
      localObject = null;
      localfei = efH().BhH;
      if (localfei != null) {
        break label111;
      }
    }
    for (;;)
    {
      com.tencent.mm.plugin.finder.report.z.a(locala, l, (bui)localObject, str, efG().AXp, efJ());
      AppMethodBeat.o(365424);
      return;
      localObject = ((as)localObject).fou();
      break;
      label111:
      str = localfei.ZWG;
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public final void superImportUIComponents(HashSet<Class<? extends UIComponent>> paramHashSet)
  {
    AppMethodBeat.i(365413);
    kotlin.g.b.s.u(paramHashSet, "set");
    super.superImportUIComponents(paramHashSet);
    paramHashSet.add(com.tencent.mm.plugin.finder.accessibility.n.class);
    AppMethodBeat.o(365413);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/ui/FinderPoiFeedUI$Action;", "", "(Ljava/lang/String;I)V", "ACTION_UNKNOWN", "ACTION_ENTER_POI_FEED_UI", "ACTION_GO_TO_MAP", "ACTION_CLICK_PHONE", "ACTION_SHARE_TO_CHAT", "ACTION_LEAVE_POI_FEED_UI", "ACTION_SHARE_TO_TIMELINE", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static enum a
  {
    static
    {
      AppMethodBeat.i(364774);
      Bqy = new a("ACTION_UNKNOWN", 0);
      Bqz = new a("ACTION_ENTER_POI_FEED_UI", 1);
      BqA = new a("ACTION_GO_TO_MAP", 2);
      BqB = new a("ACTION_CLICK_PHONE", 3);
      BqC = new a("ACTION_SHARE_TO_CHAT", 4);
      BqD = new a("ACTION_LEAVE_POI_FEED_UI", 5);
      BqE = new a("ACTION_SHARE_TO_TIMELINE", 6);
      BqF = new a[] { Bqy, Bqz, BqA, BqB, BqC, BqD, BqE };
      AppMethodBeat.o(364774);
    }
    
    private a() {}
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/ui/FinderPoiFeedUI$Companion;", "", "()V", "MENU_ID_MORE", "", "MENU_ID_POI_CLAIM", "MENU_ID_POI_REPORT_ERR", "MENU_ID_SHARE_TO_CHAT", "MENU_ID_SHARE_TO_TIMELINE", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b {}
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/plugin/finder/feed/model/FinderPoiFeedLoader;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements kotlin.g.a.a<FinderPoiFeedLoader>
  {
    c(FinderPoiFeedUI paramFinderPoiFeedUI)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/plugin/finder/feed/FinderPoiFeedUIContract$PoiFeedPresenter;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements kotlin.g.a.a<ai.a>
  {
    d(FinderPoiFeedUI paramFinderPoiFeedUI)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/plugin/finder/feed/FinderPoiFeedUIContract$PoiFeedViewCallback;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends u
    implements kotlin.g.a.a<ai.b>
  {
    e(FinderPoiFeedUI paramFinderPoiFeedUI)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.ui.FinderPoiFeedUI
 * JD-Core Version:    0.7.0.1
 */