package com.tencent.mm.plugin.appbrand.launching.e;

import android.app.Activity;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.launching.AppBrandLaunchProxyUI;
import com.tencent.mm.plugin.appbrand.launching.params.LaunchParcel;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.service.d;
import com.tencent.mm.plugin.appbrand.ui.AppBrandPluginUI;
import com.tencent.mm.plugin.appbrand.ui.AppBrandUI;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ai;
import java.lang.ref.WeakReference;

final class b
  extends com.tencent.mm.plugin.appbrand.launching.a
{
  public final boolean b(final Context paramContext, LaunchParcel paramLaunchParcel)
  {
    AppMethodBeat.i(47437);
    Intent localIntent = new Intent(paramContext, AppBrandLaunchProxyUI.class);
    int i;
    if (!(paramContext instanceof Activity))
    {
      localIntent.addFlags(268435456);
      localIntent.putExtra("extra_from_mm", false);
      localIntent.putExtra("extra_launch_parcel", paramLaunchParcel);
      localIntent.putExtra("extra_launch_source_context", paramContext.getClass().getName());
      localIntent.putExtra("extra_launch_source_process_name", ai.getProcessName());
      if ((paramContext instanceof AppBrandUI)) {
        break label179;
      }
      i = 0;
    }
    for (;;)
    {
      if (i != 0) {
        new a(paramContext);
      }
      paramLaunchParcel = new com.tencent.mm.hellhoundlib.b.a().ba(localIntent);
      com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramLaunchParcel.aeD(), "com/tencent/mm/plugin/appbrand/launching/precondition/ClientLaunchEntry", "startWithParcel", "(Landroid/content/Context;Lcom/tencent/mm/plugin/appbrand/launching/params/LaunchParcel;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramContext.startActivity((Intent)paramLaunchParcel.lR(0));
      com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/plugin/appbrand/launching/precondition/ClientLaunchEntry", "startWithParcel", "(Landroid/content/Context;Lcom/tencent/mm/plugin/appbrand/launching/params/LaunchParcel;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(47437);
      return true;
      h.c(localIntent, (Activity)paramContext);
      break;
      label179:
      if ((paramContext instanceof AppBrandPluginUI)) {
        i = 0;
      } else if (paramLaunchParcel.lpG.scene != 1090) {
        i = 0;
      } else {
        i = 1;
      }
    }
  }
  
  final class a
    extends c<d>
    implements Application.ActivityLifecycleCallbacks
  {
    private final Application app;
    private final WeakReference<Activity> lpX;
    
    a()
    {
      AppMethodBeat.i(47431);
      this.app = ((Application)paramContext.getApplicationContext());
      this.lpX = new WeakReference((Activity)paramContext);
      alive();
      this.app.registerActivityLifecycleCallbacks(this);
      this.__eventId = d.class.getName().hashCode();
      AppMethodBeat.o(47431);
    }
    
    private void unregisterAll()
    {
      AppMethodBeat.i(47435);
      dead();
      this.app.unregisterActivityLifecycleCallbacks(this);
      AppMethodBeat.o(47435);
    }
    
    public final void onActivityCreated(Activity paramActivity, Bundle paramBundle) {}
    
    public final void onActivityDestroyed(Activity paramActivity)
    {
      AppMethodBeat.i(47434);
      if (paramActivity == this.lpX.get()) {
        unregisterAll();
      }
      AppMethodBeat.o(47434);
    }
    
    public final void onActivityPaused(Activity paramActivity) {}
    
    public final void onActivityResumed(Activity paramActivity)
    {
      AppMethodBeat.i(47433);
      if (paramActivity == this.lpX.get()) {
        unregisterAll();
      }
      AppMethodBeat.o(47433);
    }
    
    public final void onActivitySaveInstanceState(Activity paramActivity, Bundle paramBundle) {}
    
    public final void onActivityStarted(Activity paramActivity)
    {
      AppMethodBeat.i(47432);
      if (paramActivity == this.lpX.get()) {
        unregisterAll();
      }
      AppMethodBeat.o(47432);
    }
    
    public final void onActivityStopped(Activity paramActivity) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.e.b
 * JD-Core Version:    0.7.0.1
 */