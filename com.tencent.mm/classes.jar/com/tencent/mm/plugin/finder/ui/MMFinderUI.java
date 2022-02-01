package com.tencent.mm.plugin.finder.ui;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.arch.lifecycle.ViewModelProvider;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.api.e;
import com.tencent.mm.plugin.finder.cgi.bi;
import com.tencent.mm.plugin.finder.report.c;
import com.tencent.mm.plugin.finder.report.h;
import com.tencent.mm.plugin.finder.report.k;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.protocal.protobuf.aie;
import com.tencent.mm.protocal.protobuf.aqy;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.bh.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.component.UIComponentActivity;
import d.g.b.p;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

@d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "Lcom/tencent/mm/ui/component/UIComponentActivity;", "()V", "screenShotCallback", "com/tencent/mm/plugin/finder/ui/MMFinderUI$screenShotCallback$1", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI$screenShotCallback$1;", "finish", "", "getCommentScene", "", "getReportType", "importUIComponents", "", "Ljava/lang/Class;", "Lcom/tencent/mm/ui/component/UIComponent;", "initializeUIC", "uiComponents", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onPause", "onResume", "setRequestedOrientation", "requestedOrientation", "Companion", "plugin-finder_release"})
public abstract class MMFinderUI
  extends UIComponentActivity
{
  private static final String TAG = "Finder.MMFinderUI";
  public static final a sIg = new a((byte)0);
  private HashMap _$_findViewCache;
  private final b sIf = new b(this);
  
  public View _$_findCachedViewById(int paramInt)
  {
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
    return localView1;
  }
  
  public final void b(HashSet<UIComponent> paramHashSet)
  {
    p.h(paramHashSet, "uiComponents");
    super.b(paramHashSet);
    com.tencent.mm.ui.component.a locala = com.tencent.mm.ui.component.a.KiD;
    paramHashSet.add(com.tencent.mm.ui.component.a.s((MMActivity)this).get(FinderReporterUIC.class));
  }
  
  public int cAZ()
  {
    return 0;
  }
  
  public int cBZ()
  {
    return 0;
  }
  
  public Set<Class<? extends UIComponent>> cCu()
  {
    return null;
  }
  
  public void finish()
  {
    super.finish();
    ad.i(TAG, "finish " + getClass().getSimpleName() + ", " + hashCode() + ", " + getTaskId());
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    ad.i(TAG, "onCreate " + getClass().getSimpleName() + ", " + hashCode() + ", " + getTaskId() + '}');
    ((PluginFinder)com.tencent.mm.kernel.g.ad(PluginFinder.class)).onEnterFinder(this);
    paramBundle = com.tencent.mm.plugin.finder.storage.data.q.sAn;
    com.tencent.mm.plugin.finder.storage.data.q.cJn();
    paramBundle = com.tencent.mm.plugin.finder.utils.g.sLj;
    com.tencent.mm.plugin.finder.utils.g.cLg();
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    ad.i(TAG, "onDestroy " + getClass().getSimpleName() + ", " + hashCode() + ", " + getTaskId());
    com.tencent.mm.plugin.finder.utils.g localg = com.tencent.mm.plugin.finder.utils.g.sLj;
    com.tencent.mm.plugin.finder.utils.g.cLh();
    ((PluginFinder)com.tencent.mm.kernel.g.ad(PluginFinder.class)).onExitFinder(this);
  }
  
  public void onPause()
  {
    super.onPause();
    ((PluginFinder)com.tencent.mm.kernel.g.ad(PluginFinder.class)).getFinderSyncExtension().b(this);
    ad.i(TAG, "onPause " + getClass().getSimpleName() + ", " + hashCode() + ", " + getTaskId());
    com.tencent.mm.plugin.finder.storage.b localb = com.tencent.mm.plugin.finder.storage.b.sxa;
    if (((Number)com.tencent.mm.plugin.finder.storage.b.cHV().value()).intValue() == 1)
    {
      ad.i(TAG, "REPORT_WHEN_SCREEN_SHOT remove");
      bh.a((Context)this, null);
    }
  }
  
  public void onResume()
  {
    super.onResume();
    ((PluginFinder)com.tencent.mm.kernel.g.ad(PluginFinder.class)).getFinderSyncExtension().a(this);
    ad.i(TAG, "onResume " + getClass().getSimpleName() + ", " + hashCode() + ", " + getTaskId());
    Object localObject = com.tencent.mm.plugin.finder.storage.b.sxa;
    if (((Boolean)com.tencent.mm.plugin.finder.storage.b.cHw().value()).booleanValue())
    {
      localObject = new Intent((Context)this, Class.forName("com.tencent.testcrash"));
      localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
      com.tencent.mm.hellhoundlib.a.a.a(this, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahp(), "com/tencent/mm/plugin/finder/ui/MMFinderUI", "onResume", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mq(0));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/ui/MMFinderUI", "onResume", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    }
    localObject = com.tencent.mm.plugin.finder.storage.b.sxa;
    if (((Number)com.tencent.mm.plugin.finder.storage.b.cHV().value()).intValue() == 1)
    {
      ad.i(TAG, "REPORT_WHEN_SCREEN_SHOT register");
      bh.a((Context)this, (bh.a)this.sIf);
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @SuppressLint({"SourceLockedOrientationActivity"})
  public void setRequestedOrientation(int paramInt)
  {
    super.setRequestedOrientation(1);
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/ui/MMFinderUI$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/finder/ui/MMFinderUI$screenShotCallback$1", "Lcom/tencent/mm/sdk/platformtools/ScreenShotUtil$ScreenShotCallback;", "onScreenShot", "", "path", "", "dateAdded", "", "plugin-finder_release"})
  public static final class b
    implements bh.a
  {
    public final void X(String paramString, long paramLong)
    {
      AppMethodBeat.i(204256);
      for (;;)
      {
        try
        {
          paramString = com.tencent.mm.ui.component.a.KiD;
          c localc = FinderReporterUIC.c((FinderReporterUIC)com.tencent.mm.ui.component.a.s((MMActivity)this.sIh).get(FinderReporterUIC.class));
          if (!(localc instanceof k)) {
            break label256;
          }
          LinkedList localLinkedList = new LinkedList();
          Iterator localIterator = ((Map)((k)localc).soR).entrySet().iterator();
          if (localIterator.hasNext())
          {
            paramString = (Map.Entry)localIterator.next();
            aie localaie = new aie();
            localaie.rIZ = ((com.tencent.mm.plugin.finder.report.l)paramString.getValue()).dtq;
            paramString = ((com.tencent.mm.plugin.finder.report.l)paramString.getValue()).feed;
            if (paramString == null) {
              break label270;
            }
            String str = paramString.getUserName();
            paramString = str;
            if (str == null) {
              break label270;
            }
            localaie.rTn = paramString;
            paramString = h.soM;
            str = h.I(localaie.rIZ, localc.rIl.rTD);
            paramString = str;
            if (str == null) {
              paramString = "";
            }
            localaie.sessionBuffer = paramString;
            localLinkedList.add(localaie);
            continue;
          }
          paramString = new bi(localLinkedList);
        }
        catch (Throwable paramString)
        {
          ad.printErrStackTrace(MMFinderUI.access$getTAG$cp(), paramString, "onScreenShot", new Object[0]);
          AppMethodBeat.o(204256);
          return;
        }
        com.tencent.mm.kernel.g.aiU().b((n)paramString);
        AppMethodBeat.o(204256);
        return;
        label256:
        ad.i(MMFinderUI.access$getTAG$cp(), "onScreenShot: not FinderSingleFeedFlowReporter");
        AppMethodBeat.o(204256);
        return;
        label270:
        paramString = "";
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.MMFinderUI
 * JD-Core Version:    0.7.0.1
 */