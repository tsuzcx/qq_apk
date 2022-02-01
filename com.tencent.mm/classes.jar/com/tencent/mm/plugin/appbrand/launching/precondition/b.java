package com.tencent.mm.plugin.appbrand.launching.precondition;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.tencent.luggage.sdk.launching.ActivityStarterIpcDelegate;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.launching.AppBrandLaunchProxyUI;
import com.tencent.mm.plugin.appbrand.launching.params.LaunchParcel;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.ui.AppBrandPluginUI;
import com.tencent.mm.plugin.appbrand.ui.AppBrandUI;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

final class b
  extends com.tencent.mm.plugin.appbrand.launching.a
{
  public final boolean b(Context paramContext, LaunchParcel paramLaunchParcel)
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
      localIntent.putExtra("extra_launch_source_process_name", MMApplicationContext.getProcessName());
      if ((paramContext instanceof AppBrandUI)) {
        break label210;
      }
      i = 0;
      label85:
      if (i != 0) {
        new ClientLaunchEntry.1Observer(this, paramContext);
      }
      if (paramLaunchParcel.sWl == null) {
        break label317;
      }
      i = localIntent.getFlags();
    }
    for (;;)
    {
      try
      {
        localIntent.setFlags(0xEFFFFFFF & i);
        paramLaunchParcel = paramLaunchParcel.sWl;
        com.tencent.mm.hellhoundlib.b.a locala = new com.tencent.mm.hellhoundlib.b.a().cG(localIntent);
        com.tencent.mm.hellhoundlib.a.a.b(paramLaunchParcel, locala.aYi(), "com/tencent/mm/plugin/appbrand/launching/precondition/ClientLaunchEntry", "startWithParcel", "(Landroid/content/Context;Lcom/tencent/mm/plugin/appbrand/launching/params/LaunchParcel;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramLaunchParcel.startActivity((Intent)locala.sb(0));
        com.tencent.mm.hellhoundlib.a.a.c(paramLaunchParcel, "com/tencent/mm/plugin/appbrand/launching/precondition/ClientLaunchEntry", "startWithParcel", "(Landroid/content/Context;Lcom/tencent/mm/plugin/appbrand/launching/params/LaunchParcel;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(47437);
        return true;
        i.c(localIntent, (Activity)paramContext);
        break;
        label210:
        if ((paramContext instanceof AppBrandPluginUI))
        {
          i = 0;
          break label85;
        }
        if (paramLaunchParcel.siB.scene != 1090)
        {
          i = 0;
          break label85;
        }
        i = 1;
      }
      catch (Exception paramLaunchParcel)
      {
        localIntent.setFlags(i);
        paramLaunchParcel = new com.tencent.mm.hellhoundlib.b.a().cG(localIntent);
        com.tencent.mm.hellhoundlib.a.a.b(paramContext, paramLaunchParcel.aYi(), "com/tencent/mm/plugin/appbrand/launching/precondition/ClientLaunchEntry", "startWithParcel", "(Landroid/content/Context;Lcom/tencent/mm/plugin/appbrand/launching/params/LaunchParcel;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramContext.startActivity((Intent)paramLaunchParcel.sb(0));
        com.tencent.mm.hellhoundlib.a.a.c(paramContext, "com/tencent/mm/plugin/appbrand/launching/precondition/ClientLaunchEntry", "startWithParcel", "(Landroid/content/Context;Lcom/tencent/mm/plugin/appbrand/launching/params/LaunchParcel;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        continue;
      }
      label317:
      paramLaunchParcel = new com.tencent.mm.hellhoundlib.b.a().cG(localIntent);
      com.tencent.mm.hellhoundlib.a.a.b(paramContext, paramLaunchParcel.aYi(), "com/tencent/mm/plugin/appbrand/launching/precondition/ClientLaunchEntry", "startWithParcel", "(Landroid/content/Context;Lcom/tencent/mm/plugin/appbrand/launching/params/LaunchParcel;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramContext.startActivity((Intent)paramLaunchParcel.sb(0));
      com.tencent.mm.hellhoundlib.a.a.c(paramContext, "com/tencent/mm/plugin/appbrand/launching/precondition/ClientLaunchEntry", "startWithParcel", "(Landroid/content/Context;Lcom/tencent/mm/plugin/appbrand/launching/params/LaunchParcel;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.precondition.b
 * JD-Core Version:    0.7.0.1
 */