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
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.api.d;
import com.tencent.mm.plugin.finder.storage.b;
import com.tencent.mm.plugin.finder.utils.f;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.component.UIComponentActivity;
import d.l;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "Lcom/tencent/mm/ui/component/UIComponentActivity;", "()V", "finish", "", "getCommentScene", "", "getReportType", "importUIComponents", "", "Ljava/lang/Class;", "Lcom/tencent/mm/ui/component/UIComponent;", "initializeUIC", "uiComponents", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onPause", "onResume", "setRequestedOrientation", "requestedOrientation", "Companion", "plugin-finder_release"})
public abstract class MMFinderUI
  extends UIComponentActivity
{
  private static final String TAG = "Finder.MMFinderUI";
  public static final MMFinderUI.a rMp = new MMFinderUI.a((byte)0);
  private HashMap _$_findViewCache;
  
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
    d.g.b.k.h(paramHashSet, "uiComponents");
    super.b(paramHashSet);
    com.tencent.mm.ui.component.a locala = com.tencent.mm.ui.component.a.IrY;
    paramHashSet.add(com.tencent.mm.ui.component.a.q((MMActivity)this).get(FinderReporterUIC.class));
  }
  
  public int cuI()
  {
    return 0;
  }
  
  public int cvJ()
  {
    return 0;
  }
  
  public Set<Class<? extends UIComponent>> cwg()
  {
    return null;
  }
  
  public void finish()
  {
    super.finish();
    ac.i(TAG, "finish " + getClass().getSimpleName() + ", " + hashCode() + ", " + getTaskId());
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    ac.i(TAG, "onCreate " + getClass().getSimpleName() + ", " + hashCode() + ", " + getTaskId() + '}');
    ((PluginFinder)g.ad(PluginFinder.class)).onEnterFinder(this);
    paramBundle = com.tencent.mm.plugin.finder.storage.data.k.rFg;
    com.tencent.mm.plugin.finder.storage.data.k.cBm();
    paramBundle = f.rON;
    f.cCP();
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    ac.i(TAG, "onDestroy " + getClass().getSimpleName() + ", " + hashCode() + ", " + getTaskId());
    f localf = f.rON;
    f.cCQ();
    ((PluginFinder)g.ad(PluginFinder.class)).onExitFinder(this);
  }
  
  public void onPause()
  {
    super.onPause();
    ((PluginFinder)g.ad(PluginFinder.class)).getFinderSyncExtension().b(this);
    ac.i(TAG, "onPause " + getClass().getSimpleName() + ", " + hashCode() + ", " + getTaskId());
  }
  
  public void onResume()
  {
    super.onResume();
    ((PluginFinder)g.ad(PluginFinder.class)).getFinderSyncExtension().a(this);
    ac.i(TAG, "onResume " + getClass().getSimpleName() + ", " + hashCode() + ", " + getTaskId());
    Object localObject = b.rCU;
    if (b.cAg())
    {
      localObject = new Intent((Context)this, Class.forName("com.tencent.testcrash"));
      localObject = new com.tencent.mm.hellhoundlib.b.a().ba(localObject);
      com.tencent.mm.hellhoundlib.a.a.a(this, ((com.tencent.mm.hellhoundlib.b.a)localObject).aeD(), "com/tencent/mm/plugin/finder/ui/MMFinderUI", "onResume", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lR(0));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/ui/MMFinderUI", "onResume", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.MMFinderUI
 * JD-Core Version:    0.7.0.1
 */