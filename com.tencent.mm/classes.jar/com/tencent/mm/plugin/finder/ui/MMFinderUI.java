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
import com.tencent.mm.plugin.finder.storage.b;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.component.UIComponentActivity;
import d.l;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "Lcom/tencent/mm/ui/component/UIComponentActivity;", "()V", "finish", "", "getCommentScene", "", "getReportType", "importUIComponents", "", "Ljava/lang/Class;", "Lcom/tencent/mm/ui/component/UIComponent;", "initializeUIC", "uiComponents", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onPause", "onResume", "setRequestedOrientation", "requestedOrientation", "Companion", "plugin-finder_release"})
public abstract class MMFinderUI
  extends UIComponentActivity
{
  private static final String TAG = "Finder.MMFinderUI";
  public static final a qQu = new a((byte)0);
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
  
  public final void a(HashSet<UIComponent> paramHashSet)
  {
    d.g.b.k.h(paramHashSet, "uiComponents");
    super.a(paramHashSet);
    com.tencent.mm.ui.component.a locala = com.tencent.mm.ui.component.a.LCX;
    paramHashSet.add(com.tencent.mm.ui.component.a.s((MMActivity)this).get(FinderReporterUIC.class));
  }
  
  public int fTB()
  {
    return 0;
  }
  
  public Set<Class<? extends UIComponent>> fTM()
  {
    return null;
  }
  
  public void finish()
  {
    super.finish();
    ad.i(TAG, "finish " + getClass().getSimpleName() + ", " + hashCode() + ", " + getTaskId());
  }
  
  public int getCommentScene()
  {
    return 0;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    ad.i(TAG, "onCreate " + getClass().getSimpleName() + ", " + hashCode() + ", " + getTaskId() + '}');
    ((PluginFinder)g.ad(PluginFinder.class)).onEnterFinder(this);
    paramBundle = com.tencent.mm.plugin.finder.storage.data.k.KXB;
    com.tencent.mm.plugin.finder.storage.data.k.fVj();
    paramBundle = com.tencent.mm.plugin.finder.utils.d.qSo;
    com.tencent.mm.plugin.finder.utils.d.crO();
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    ad.i(TAG, "onDestroy " + getClass().getSimpleName() + ", " + hashCode() + ", " + getTaskId());
    com.tencent.mm.plugin.finder.utils.d locald = com.tencent.mm.plugin.finder.utils.d.qSo;
    com.tencent.mm.plugin.finder.utils.d.crP();
    ((PluginFinder)g.ad(PluginFinder.class)).onExitFinder(this);
  }
  
  public void onPause()
  {
    super.onPause();
    ((PluginFinder)g.ad(PluginFinder.class)).getFinderSyncExtension().b(this);
    ad.i(TAG, "onPause " + getClass().getSimpleName() + ", " + hashCode() + ", " + getTaskId());
  }
  
  public void onResume()
  {
    super.onResume();
    ((PluginFinder)g.ad(PluginFinder.class)).getFinderSyncExtension().a(this);
    ad.i(TAG, "onResume " + getClass().getSimpleName() + ", " + hashCode() + ", " + getTaskId());
    Object localObject = b.qJA;
    if (b.fUJ())
    {
      localObject = new Intent((Context)this, Class.forName("com.tencent.testcrash"));
      localObject = new com.tencent.mm.hellhoundlib.b.a().bd(localObject);
      com.tencent.mm.hellhoundlib.a.a.a(this, ((com.tencent.mm.hellhoundlib.b.a)localObject).adn(), "com/tencent/mm/plugin/finder/ui/MMFinderUI", "onResume", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lS(0));
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
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/ui/MMFinderUI$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.MMFinderUI
 * JD-Core Version:    0.7.0.1
 */