package com.tencent.mm.plugin.finder.ui;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.arch.lifecycle.ViewModelProvider;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.t;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.cgi.cx;
import com.tencent.mm.plugin.finder.report.k;
import com.tencent.mm.plugin.finder.report.o;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.c;
import com.tencent.mm.plugin.finder.storage.config.b;
import com.tencent.mm.plugin.finder.storage.data.v;
import com.tencent.mm.plugin.finder.utils.j;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.plugin.secdata.ui.SecDataUIC;
import com.tencent.mm.protocal.protobuf.alc;
import com.tencent.mm.protocal.protobuf.bbn;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.ScreenShotUtil;
import com.tencent.mm.sdk.platformtools.ScreenShotUtil.ScreenShotCallback;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.component.UIComponent;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "Lcom/tencent/mm/ui/MMActivity;", "()V", "activeFinish", "", "callOnce", "needChangeOrientation", "getNeedChangeOrientation", "()Z", "setNeedChangeOrientation", "(Z)V", "screenShotCallback", "com/tencent/mm/plugin/finder/ui/MMFinderUI$screenShotCallback$1", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI$screenShotCallback$1;", "unInitTask", "Ljava/lang/Runnable;", "finish", "", "getCommentScene", "", "getLayoutId", "getReportType", "importUIComponents", "", "Ljava/lang/Class;", "Lcom/tencent/mm/ui/component/UIComponent;", "initBusiness", "initializeUIC", "uiComponents", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onPause", "onResume", "setRequestedOrientation", "requestedOrientation", "uninitBusiness", "uninitBusinessCheck", "Companion", "plugin-finder_release"})
public abstract class MMFinderUI
  extends MMActivity
{
  private static final String TAG = "Finder.MMFinderUI";
  public static final a vPX = new a((byte)0);
  private HashMap _$_findViewCache;
  public boolean vPS;
  private Runnable vPT;
  private boolean vPU;
  private boolean vPV;
  private final c vPW = new c(this);
  
  private final void dAn()
  {
    if (this.vPV) {
      return;
    }
    dei();
    this.vPV = true;
  }
  
  public void _$_clearFindViewByIdCache()
  {
    if (this._$_findViewCache != null) {
      this._$_findViewCache.clear();
    }
  }
  
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
  
  public int ddN()
  {
    return 0;
  }
  
  public void deh() {}
  
  public void dei() {}
  
  public void finish()
  {
    super.finish();
    Log.i(TAG, "finish " + getClass().getSimpleName() + ", " + hashCode() + ", " + getTaskId() + ", " + isPaused());
    if (isPaused()) {
      dei();
    }
    for (;;)
    {
      this.vPU = true;
      return;
      this.vPT = ((Runnable)new b(this));
    }
  }
  
  public int getCommentScene()
  {
    return 0;
  }
  
  public int getLayoutId()
  {
    return 0;
  }
  
  public Set<Class<? extends UIComponent>> importUIComponents()
  {
    return null;
  }
  
  public void initializeUIC(HashSet<UIComponent> paramHashSet)
  {
    kotlin.g.b.p.h(paramHashSet, "uiComponents");
    super.initializeUIC(paramHashSet);
    com.tencent.mm.ui.component.a locala = com.tencent.mm.ui.component.a.PRN;
    paramHashSet.add(com.tencent.mm.ui.component.a.b((AppCompatActivity)this).get(FinderReporterUIC.class));
    locala = com.tencent.mm.ui.component.a.PRN;
    paramHashSet.add(com.tencent.mm.ui.component.a.b((AppCompatActivity)this).get(SecDataUIC.class));
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    kotlin.g.b.p.h(paramConfiguration, "newConfig");
    super.onConfigurationChanged(paramConfiguration);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    Log.i(TAG, "onCreate " + getClass().getSimpleName() + ", " + hashCode() + ", " + getTaskId() + '}');
    ((PluginFinder)g.ah(PluginFinder.class)).onEnterFinder(this);
    paramBundle = v.vGG;
    v.dyK();
    paramBundle = j.vVA;
    j.dBG();
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    Log.i(TAG, "onDestroy " + getClass().getSimpleName() + ", " + hashCode() + ", " + getTaskId() + ", " + this.vPU);
    if (!this.vPU) {
      dAn();
    }
    j localj = j.vVA;
    j.dBH();
    ((PluginFinder)g.ah(PluginFinder.class)).onExitFinder(this);
  }
  
  public void onPause()
  {
    super.onPause();
    ((PluginFinder)g.ah(PluginFinder.class)).getFinderSyncExtension().b(this);
    Log.i(TAG, "onPause " + getClass().getSimpleName() + ", " + hashCode() + ", " + getTaskId() + ", " + this.vPT);
    Object localObject = c.vCb;
    if (((Number)c.dtI().value()).intValue() == 1)
    {
      Log.i(TAG, "REPORT_WHEN_SCREEN_SHOT remove");
      ScreenShotUtil.setScreenShotCallback((Context)this, null);
    }
    localObject = this.vPT;
    if (localObject != null) {
      ((Runnable)localObject).run();
    }
    this.vPT = null;
  }
  
  public void onResume()
  {
    super.onResume();
    ((PluginFinder)g.ah(PluginFinder.class)).getFinderSyncExtension().a(this);
    Log.i(TAG, "onResume " + getClass().getSimpleName() + ", " + hashCode() + ", " + getTaskId());
    Object localObject = c.vCb;
    if (((Boolean)c.dtk().value()).booleanValue())
    {
      localObject = new Intent((Context)this, Class.forName("com.tencent.testcrash"));
      localObject = new com.tencent.mm.hellhoundlib.b.a().bl(localObject);
      com.tencent.mm.hellhoundlib.a.a.a(this, ((com.tencent.mm.hellhoundlib.b.a)localObject).axQ(), "com/tencent/mm/plugin/finder/ui/MMFinderUI", "onResume", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(0));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/ui/MMFinderUI", "onResume", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    }
    localObject = c.vCb;
    if (((Number)c.dtI().value()).intValue() == 1)
    {
      Log.i(TAG, "REPORT_WHEN_SCREEN_SHOT register");
      ScreenShotUtil.setScreenShotCallback((Context)this, (ScreenShotUtil.ScreenShotCallback)this.vPW);
    }
    deh();
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @SuppressLint({"SourceLockedOrientationActivity"})
  public void setRequestedOrientation(int paramInt)
  {
    if (!this.vPS)
    {
      super.setRequestedOrientation(1);
      return;
    }
    super.setRequestedOrientation(paramInt);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/ui/MMFinderUI$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(MMFinderUI paramMMFinderUI) {}
    
    public final void run()
    {
      AppMethodBeat.i(252804);
      MMFinderUI.c(this.vPY);
      AppMethodBeat.o(252804);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/ui/MMFinderUI$screenShotCallback$1", "Lcom/tencent/mm/sdk/platformtools/ScreenShotUtil$ScreenShotCallback;", "onScreenShot", "", "path", "", "dateAdded", "", "plugin-finder_release"})
  public static final class c
    implements ScreenShotUtil.ScreenShotCallback
  {
    public final void onScreenShot(String paramString, long paramLong)
    {
      AppMethodBeat.i(252805);
      for (;;)
      {
        try
        {
          paramString = com.tencent.mm.ui.component.a.PRN;
          com.tencent.mm.plugin.finder.report.e locale = FinderReporterUIC.c((FinderReporterUIC)com.tencent.mm.ui.component.a.b((AppCompatActivity)this.vPY).get(FinderReporterUIC.class));
          if (!(locale instanceof o)) {
            break label256;
          }
          LinkedList localLinkedList = new LinkedList();
          Iterator localIterator = ((Map)((o)locale).vfK).entrySet().iterator();
          if (localIterator.hasNext())
          {
            paramString = (Map.Entry)localIterator.next();
            alc localalc = new alc();
            localalc.hFK = ((com.tencent.mm.plugin.finder.report.p)paramString.getValue()).feedId;
            paramString = ((com.tencent.mm.plugin.finder.report.p)paramString.getValue()).tHo;
            if (paramString == null) {
              break label270;
            }
            String str = paramString.getUserName();
            paramString = str;
            if (str == null) {
              break label270;
            }
            localalc.finderUsername = paramString;
            paramString = k.vfA;
            str = k.G(localalc.hFK, locale.ttO.tCE);
            paramString = str;
            if (str == null) {
              paramString = "";
            }
            localalc.sessionBuffer = paramString;
            localLinkedList.add(localalc);
            continue;
          }
          paramString = new cx(localLinkedList);
        }
        catch (Throwable paramString)
        {
          Log.printErrStackTrace(MMFinderUI.access$getTAG$cp(), paramString, "onScreenShot", new Object[0]);
          AppMethodBeat.o(252805);
          return;
        }
        g.azz().b((q)paramString);
        AppMethodBeat.o(252805);
        return;
        label256:
        Log.i(MMFinderUI.access$getTAG$cp(), "onScreenShot: not FinderSingleFeedFlowReporter");
        AppMethodBeat.o(252805);
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