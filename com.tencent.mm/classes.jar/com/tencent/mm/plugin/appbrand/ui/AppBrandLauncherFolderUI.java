package com.tencent.mm.plugin.appbrand.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.MotionEvent;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.e;
import androidx.lifecycle.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.au.c;
import com.tencent.mm.plugin.appbrand.ui.collection.CollectionFolderActivityContext;
import com.tencent.mm.plugin.appbrand.ui.launcher.FolderActivityContextWithLifecycle;
import com.tencent.mm.plugin.appbrand.ui.recents.RecentsFolderActivityContext;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMFragmentActivity.a;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.base.b;
import java.util.HashMap;
import kotlin.g.b.p;
import kotlin.l;

@com.tencent.mm.kernel.k
@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/ui/AppBrandLauncherFolderUI;", "Lcom/tencent/mm/ui/MMActivity;", "Lcom/tencent/mm/plugin/appbrand/ui/launcher/IFolderActivityContext;", "()V", "mFolderContextImpl", "Lcom/tencent/mm/plugin/appbrand/ui/launcher/FolderActivityContextWithLifecycle;", "dispatchTouchEvent", "", "ev", "Landroid/view/MotionEvent;", "finish", "", "getLayoutId", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "showListPage", "showList", "Companion", "plugin-appbrand-integration_release"})
public final class AppBrandLauncherFolderUI
  extends MMActivity
  implements com.tencent.mm.plugin.appbrand.ui.launcher.a
{
  public static final a qVg;
  private HashMap _$_findViewCache;
  private FolderActivityContextWithLifecycle qVf;
  
  static
  {
    AppMethodBeat.i(51114);
    qVg = new a((byte)0);
    AppMethodBeat.o(51114);
  }
  
  public static final void m(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(51116);
    a.m(paramContext, paramIntent);
    AppMethodBeat.o(51116);
  }
  
  public final void _$_clearFindViewByIdCache()
  {
    AppMethodBeat.i(242817);
    if (this._$_findViewCache != null) {
      this._$_findViewCache.clear();
    }
    AppMethodBeat.o(242817);
  }
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(242815);
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
    AppMethodBeat.o(242815);
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
  
  public final void jE(boolean paramBoolean)
  {
    AppMethodBeat.i(51111);
    FolderActivityContextWithLifecycle localFolderActivityContextWithLifecycle = this.qVf;
    if (localFolderActivityContextWithLifecycle != null)
    {
      localFolderActivityContextWithLifecycle.jE(paramBoolean);
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
    if ((b.bB(getClass())) && (!ar.hIO())) {
      super.overridePendingTransition(MMFragmentActivity.a.rhY, MMFragmentActivity.a.rhZ);
    }
    int i = getIntent().getIntExtra("KEY_MODE", 0);
    switch (i)
    {
    default: 
      Log.e("MicroMsg.AppBrandLauncherFolderUI", "onCreate with invalid mode(" + i + ')');
      finish();
      setActionbarColor(getContext().getResources().getColor(au.c.normal_actionbar_color));
      getContentView().setBackgroundColor(getActionbarColor());
      setBackBtn((MenuItem.OnMenuItemClickListener)new b(this));
      setTitleBarDoubleClickListener((Runnable)new c(this));
      paramBundle = getLifecycle();
      FolderActivityContextWithLifecycle localFolderActivityContextWithLifecycle = this.qVf;
      if (localFolderActivityContextWithLifecycle == null) {
        p.iCn();
      }
      paramBundle.a((androidx.lifecycle.k)localFolderActivityContextWithLifecycle);
      AppMethodBeat.o(51110);
      return;
    }
    for (paramBundle = (FolderActivityContextWithLifecycle)new RecentsFolderActivityContext((MMActivity)this);; paramBundle = (FolderActivityContextWithLifecycle)new CollectionFolderActivityContext((MMActivity)this))
    {
      this.qVf = paramBundle;
      break;
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/ui/AppBrandLauncherFolderUI$Companion;", "", "()V", "KEY_MODE_INT", "", "MODE_COLLECTION", "", "MODE_RECENTS", "startCollectionList", "", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "startRecentsList", "plugin-appbrand-integration_release"})
  public static final class a
  {
    public static void m(Context paramContext, Intent paramIntent)
    {
      AppMethodBeat.i(51107);
      p.k(paramContext, "context");
      Intent localIntent = new Intent(paramContext, AppBrandLauncherFolderUI.class);
      if (!(paramContext instanceof Activity)) {
        localIntent.addFlags(268435456);
      }
      if (paramIntent != null)
      {
        Bundle localBundle = paramIntent.getExtras();
        paramIntent = localBundle;
        if (localBundle != null) {}
      }
      else
      {
        paramIntent = Bundle.EMPTY;
      }
      localIntent.putExtras(paramIntent);
      localIntent.putExtra("KEY_MODE", 2);
      paramIntent = new com.tencent.mm.hellhoundlib.b.a().bm(localIntent);
      com.tencent.mm.hellhoundlib.a.a.b(paramContext, paramIntent.aFh(), "com/tencent/mm/plugin/appbrand/ui/AppBrandLauncherFolderUI$Companion", "startCollectionList", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramContext.startActivity((Intent)paramIntent.sf(0));
      com.tencent.mm.hellhoundlib.a.a.c(paramContext, "com/tencent/mm/plugin/appbrand/ui/AppBrandLauncherFolderUI$Companion", "startCollectionList", "(Landroid/content/Context;Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(51107);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class b
    implements MenuItem.OnMenuItemClickListener
  {
    b(AppBrandLauncherFolderUI paramAppBrandLauncherFolderUI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(51108);
      this.qVh.finish();
      AppMethodBeat.o(51108);
      return true;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class c
    implements Runnable
  {
    c(AppBrandLauncherFolderUI paramAppBrandLauncherFolderUI) {}
    
    public final void run()
    {
      AppMethodBeat.i(51109);
      Fragment localFragment = this.qVh.getSupportFragmentManager().findFragmentById(16908290);
      Object localObject = localFragment;
      if (!(localFragment instanceof AppBrandLauncherUI.Fragment)) {
        localObject = null;
      }
      localObject = (AppBrandLauncherUI.Fragment)localObject;
      if (localObject != null)
      {
        ((AppBrandLauncherUI.Fragment)localObject).cjF();
        AppMethodBeat.o(51109);
        return;
      }
      AppMethodBeat.o(51109);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.AppBrandLauncherFolderUI
 * JD-Core Version:    0.7.0.1
 */