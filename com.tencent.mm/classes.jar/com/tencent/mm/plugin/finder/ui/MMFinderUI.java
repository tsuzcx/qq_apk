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
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.api.e;
import com.tencent.mm.plugin.finder.storage.data.q;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.bi.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.component.UIComponentActivity;
import d.g.b.p;
import d.l;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "Lcom/tencent/mm/ui/component/UIComponentActivity;", "()V", "screenShotCallback", "com/tencent/mm/plugin/finder/ui/MMFinderUI$screenShotCallback$1", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI$screenShotCallback$1;", "finish", "", "getCommentScene", "", "getReportType", "importUIComponents", "", "Ljava/lang/Class;", "Lcom/tencent/mm/ui/component/UIComponent;", "initializeUIC", "uiComponents", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onPause", "onResume", "setRequestedOrientation", "requestedOrientation", "Companion", "plugin-finder_release"})
public abstract class MMFinderUI
  extends UIComponentActivity
{
  private static final String TAG = "Finder.MMFinderUI";
  public static final MMFinderUI.a sTs = new MMFinderUI.a((byte)0);
  private HashMap _$_findViewCache;
  private final MMFinderUI.b sTr = new MMFinderUI.b(this);
  
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
    com.tencent.mm.ui.component.a locala = com.tencent.mm.ui.component.a.KEX;
    paramHashSet.add(com.tencent.mm.ui.component.a.s((MMActivity)this).get(FinderReporterUIC.class));
  }
  
  public int cCL()
  {
    return 0;
  }
  
  public int cDL()
  {
    return 0;
  }
  
  public Set<Class<? extends UIComponent>> cEg()
  {
    return null;
  }
  
  public void finish()
  {
    super.finish();
    ae.i(TAG, "finish " + getClass().getSimpleName() + ", " + hashCode() + ", " + getTaskId());
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    ae.i(TAG, "onCreate " + getClass().getSimpleName() + ", " + hashCode() + ", " + getTaskId() + '}');
    ((PluginFinder)com.tencent.mm.kernel.g.ad(PluginFinder.class)).onEnterFinder(this);
    paramBundle = q.sLl;
    q.cLQ();
    paramBundle = com.tencent.mm.plugin.finder.utils.g.sWu;
    com.tencent.mm.plugin.finder.utils.g.cNK();
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    ae.i(TAG, "onDestroy " + getClass().getSimpleName() + ", " + hashCode() + ", " + getTaskId());
    com.tencent.mm.plugin.finder.utils.g localg = com.tencent.mm.plugin.finder.utils.g.sWu;
    com.tencent.mm.plugin.finder.utils.g.cNL();
    ((PluginFinder)com.tencent.mm.kernel.g.ad(PluginFinder.class)).onExitFinder(this);
  }
  
  public void onPause()
  {
    super.onPause();
    ((PluginFinder)com.tencent.mm.kernel.g.ad(PluginFinder.class)).getFinderSyncExtension().b(this);
    ae.i(TAG, "onPause " + getClass().getSimpleName() + ", " + hashCode() + ", " + getTaskId());
    com.tencent.mm.plugin.finder.storage.b localb = com.tencent.mm.plugin.finder.storage.b.sHP;
    if (((Number)com.tencent.mm.plugin.finder.storage.b.cJR().value()).intValue() == 1)
    {
      ae.i(TAG, "REPORT_WHEN_SCREEN_SHOT remove");
      bi.a((Context)this, null);
    }
  }
  
  public void onResume()
  {
    super.onResume();
    ((PluginFinder)com.tencent.mm.kernel.g.ad(PluginFinder.class)).getFinderSyncExtension().a(this);
    ae.i(TAG, "onResume " + getClass().getSimpleName() + ", " + hashCode() + ", " + getTaskId());
    Object localObject = com.tencent.mm.plugin.finder.storage.b.sHP;
    if (((Boolean)com.tencent.mm.plugin.finder.storage.b.cJv().value()).booleanValue())
    {
      localObject = new Intent((Context)this, Class.forName("com.tencent.testcrash"));
      localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
      com.tencent.mm.hellhoundlib.a.a.a(this, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahE(), "com/tencent/mm/plugin/finder/ui/MMFinderUI", "onResume", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mt(0));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/ui/MMFinderUI", "onResume", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    }
    localObject = com.tencent.mm.plugin.finder.storage.b.sHP;
    if (((Number)com.tencent.mm.plugin.finder.storage.b.cJR().value()).intValue() == 1)
    {
      ae.i(TAG, "REPORT_WHEN_SCREEN_SHOT register");
      bi.a((Context)this, (bi.a)this.sTr);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.MMFinderUI
 * JD-Core Version:    0.7.0.1
 */