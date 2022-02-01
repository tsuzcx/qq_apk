package com.tencent.mm.plugin.appbrand.ui;

import android.app.Activity;
import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleObserver;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.g;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.i;
import com.tencent.mm.plugin.appbrand.ui.collection.CollectionFolderActivityContext;
import com.tencent.mm.plugin.appbrand.ui.launcher.FolderActivityContextWithLifecycle;
import com.tencent.mm.plugin.appbrand.ui.launcher.a;
import com.tencent.mm.plugin.appbrand.ui.recents.RecentsFolderActivityContext;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMFragmentActivity.a;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.base.b;
import java.util.HashMap;
import kotlin.g.b.p;
import kotlin.l;

@i
@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/ui/AppBrandLauncherFolderUI;", "Lcom/tencent/mm/ui/MMActivity;", "Lcom/tencent/mm/plugin/appbrand/ui/launcher/IFolderActivityContext;", "()V", "mFolderContextImpl", "Lcom/tencent/mm/plugin/appbrand/ui/launcher/FolderActivityContextWithLifecycle;", "dispatchTouchEvent", "", "ev", "Landroid/view/MotionEvent;", "finish", "", "getLayoutId", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "showListPage", "showList", "Companion", "plugin-appbrand-integration_release"})
public final class AppBrandLauncherFolderUI
  extends MMActivity
  implements a
{
  public static final AppBrandLauncherFolderUI.a nTH;
  private HashMap _$_findViewCache;
  private FolderActivityContextWithLifecycle nTG;
  
  static
  {
    AppMethodBeat.i(51114);
    nTH = new AppBrandLauncherFolderUI.a((byte)0);
    AppMethodBeat.o(51114);
  }
  
  public static final void m(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(51115);
    AppBrandLauncherFolderUI.a.m(paramContext, paramIntent);
    AppMethodBeat.o(51115);
  }
  
  public static final void n(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(51116);
    AppBrandLauncherFolderUI.a.n(paramContext, paramIntent);
    AppMethodBeat.o(51116);
  }
  
  public final void _$_clearFindViewByIdCache()
  {
    AppMethodBeat.i(229481);
    if (this._$_findViewCache != null) {
      this._$_findViewCache.clear();
    }
    AppMethodBeat.o(229481);
  }
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(229480);
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
    AppMethodBeat.o(229480);
    return localView1;
  }
  
  public final boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(51112);
    if (isFinishing())
    {
      AppMethodBeat.o(51112);
      return false;
    }
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    AppMethodBeat.o(51112);
    return bool;
  }
  
  public final void finish()
  {
    AppMethodBeat.i(51113);
    if ((isFinishing()) || (isDestroyed()))
    {
      AppMethodBeat.o(51113);
      return;
    }
    super.finish();
    AppMethodBeat.o(51113);
  }
  
  public final int getLayoutId()
  {
    return -1;
  }
  
  public final void iI(boolean paramBoolean)
  {
    AppMethodBeat.i(51111);
    FolderActivityContextWithLifecycle localFolderActivityContextWithLifecycle = this.nTG;
    if (localFolderActivityContextWithLifecycle != null)
    {
      localFolderActivityContextWithLifecycle.iI(paramBoolean);
      AppMethodBeat.o(51111);
      return;
    }
    AppMethodBeat.o(51111);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(51110);
    super.onCreate(paramBundle);
    if (getIntent() == null)
    {
      finish();
      AppMethodBeat.o(51110);
      return;
    }
    overridePendingTransition(0, 0);
    if ((b.bg(getClass())) && (!ao.gJN())) {
      super.overridePendingTransition(MMFragmentActivity.a.ogm, MMFragmentActivity.a.ogn);
    }
    int i = getIntent().getIntExtra("KEY_MODE", 0);
    switch (i)
    {
    default: 
      Log.e("MicroMsg.AppBrandLauncherFolderUI", "onCreate with invalid mode(" + i + ')');
      finish();
      setActionbarColor(getContext().getResources().getColor(2131100898));
      getContentView().setBackgroundColor(getActionbarColor());
      setBackBtn((MenuItem.OnMenuItemClickListener)new b(this));
      setTitleBarDoubleClickListener((Runnable)new c(this));
      paramBundle = getLifecycle();
      FolderActivityContextWithLifecycle localFolderActivityContextWithLifecycle = this.nTG;
      if (localFolderActivityContextWithLifecycle == null) {
        p.hyc();
      }
      paramBundle.addObserver((LifecycleObserver)localFolderActivityContextWithLifecycle);
      AppMethodBeat.o(51110);
      return;
    }
    for (paramBundle = (FolderActivityContextWithLifecycle)new RecentsFolderActivityContext((MMActivity)this);; paramBundle = (FolderActivityContextWithLifecycle)new CollectionFolderActivityContext((MMActivity)this))
    {
      this.nTG = paramBundle;
      break;
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class b
    implements MenuItem.OnMenuItemClickListener
  {
    b(AppBrandLauncherFolderUI paramAppBrandLauncherFolderUI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(51108);
      this.nTI.finish();
      AppMethodBeat.o(51108);
      return true;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class c
    implements Runnable
  {
    c(AppBrandLauncherFolderUI paramAppBrandLauncherFolderUI) {}
    
    public final void run()
    {
      AppMethodBeat.i(51109);
      Fragment localFragment = this.nTI.getSupportFragmentManager().findFragmentById(16908290);
      Object localObject = localFragment;
      if (!(localFragment instanceof AppBrandLauncherUI.Fragment)) {
        localObject = null;
      }
      localObject = (AppBrandLauncherUI.Fragment)localObject;
      if (localObject != null)
      {
        ((AppBrandLauncherUI.Fragment)localObject).bXb();
        AppMethodBeat.o(51109);
        return;
      }
      AppMethodBeat.o(51109);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.AppBrandLauncherFolderUI
 * JD-Core Version:    0.7.0.1
 */