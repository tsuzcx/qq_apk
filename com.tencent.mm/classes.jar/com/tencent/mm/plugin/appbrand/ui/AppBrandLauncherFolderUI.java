package com.tencent.mm.plugin.appbrand.ui;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.j;
import androidx.lifecycle.p;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.k;
import com.tencent.mm.plugin.appbrand.ba.c;
import com.tencent.mm.plugin.appbrand.ui.collection.CollectionFolderActivityContext;
import com.tencent.mm.plugin.appbrand.ui.launcher.FolderActivityContextWithLifecycle;
import com.tencent.mm.plugin.appbrand.ui.launcher.a;
import com.tencent.mm.plugin.appbrand.ui.recents.RecentsFolderActivityContext;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMFragmentActivity.a;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.base.b;
import kotlin.Metadata;
import kotlin.g.b.s;

@k
@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/ui/AppBrandLauncherFolderUI;", "Lcom/tencent/mm/ui/MMActivity;", "Lcom/tencent/mm/plugin/appbrand/ui/launcher/IFolderActivityContext;", "()V", "mFolderContextImpl", "Lcom/tencent/mm/plugin/appbrand/ui/launcher/FolderActivityContextWithLifecycle;", "dispatchTouchEvent", "", "ev", "Landroid/view/MotionEvent;", "finish", "", "getLayoutId", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "showListPage", "showList", "Companion", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class AppBrandLauncherFolderUI
  extends MMActivity
  implements a
{
  public static final AppBrandLauncherFolderUI.a uaM;
  private FolderActivityContextWithLifecycle uaN;
  
  static
  {
    AppMethodBeat.i(51114);
    uaM = new AppBrandLauncherFolderUI.a((byte)0);
    AppMethodBeat.o(51114);
  }
  
  public static final void E(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(51116);
    AppBrandLauncherFolderUI.a.E(paramContext, paramIntent);
    AppMethodBeat.o(51116);
  }
  
  private static final void a(AppBrandLauncherFolderUI paramAppBrandLauncherFolderUI)
  {
    AppMethodBeat.i(321958);
    s.u(paramAppBrandLauncherFolderUI, "this$0");
    paramAppBrandLauncherFolderUI = paramAppBrandLauncherFolderUI.getSupportFragmentManager().findFragmentById(16908290);
    if ((paramAppBrandLauncherFolderUI instanceof AppBrandLauncherUI.Fragment)) {}
    for (paramAppBrandLauncherFolderUI = (AppBrandLauncherUI.Fragment)paramAppBrandLauncherFolderUI;; paramAppBrandLauncherFolderUI = null)
    {
      if (paramAppBrandLauncherFolderUI != null) {
        paramAppBrandLauncherFolderUI.cKT();
      }
      AppMethodBeat.o(321958);
      return;
    }
  }
  
  private static final boolean a(AppBrandLauncherFolderUI paramAppBrandLauncherFolderUI, MenuItem paramMenuItem)
  {
    AppMethodBeat.i(321951);
    s.u(paramAppBrandLauncherFolderUI, "this$0");
    paramAppBrandLauncherFolderUI.finish();
    AppMethodBeat.o(321951);
    return true;
  }
  
  public final void _$_clearFindViewByIdCache() {}
  
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
  
  public final void kT(boolean paramBoolean)
  {
    AppMethodBeat.i(51111);
    FolderActivityContextWithLifecycle localFolderActivityContextWithLifecycle = this.uaN;
    if (localFolderActivityContextWithLifecycle != null) {
      localFolderActivityContextWithLifecycle.kT(paramBoolean);
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
    if ((b.cl(getClass())) && (!aw.jlc())) {
      super.overridePendingTransition(MMFragmentActivity.a.upU, MMFragmentActivity.a.upV);
    }
    int i = getIntent().getIntExtra("KEY_MODE", 0);
    switch (i)
    {
    default: 
      Log.e("MicroMsg.AppBrandLauncherFolderUI", "onCreate with invalid mode(" + i + ')');
      finish();
      setActionbarColor(getContext().getResources().getColor(ba.c.normal_actionbar_color));
      getContentView().setBackgroundColor(getActionbarColor());
      setBackBtn(new AppBrandLauncherFolderUI..ExternalSyntheticLambda0(this));
      setTitleBarDoubleClickListener(new AppBrandLauncherFolderUI..ExternalSyntheticLambda1(this));
      paramBundle = getLifecycle();
      FolderActivityContextWithLifecycle localFolderActivityContextWithLifecycle = this.uaN;
      s.checkNotNull(localFolderActivityContextWithLifecycle);
      paramBundle.addObserver((p)localFolderActivityContextWithLifecycle);
      AppMethodBeat.o(51110);
      return;
    }
    for (paramBundle = (FolderActivityContextWithLifecycle)new RecentsFolderActivityContext((MMActivity)this);; paramBundle = (FolderActivityContextWithLifecycle)new CollectionFolderActivityContext((MMActivity)this))
    {
      this.uaN = paramBundle;
      break;
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.AppBrandLauncherFolderUI
 * JD-Core Version:    0.7.0.1
 */