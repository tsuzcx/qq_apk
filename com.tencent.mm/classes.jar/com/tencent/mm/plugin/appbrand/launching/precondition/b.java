package com.tencent.mm.plugin.appbrand.launching.precondition;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import com.tencent.luggage.g.e;
import com.tencent.luggage.sdk.launching.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.AppBrandLaunchReferrer;
import com.tencent.mm.plugin.appbrand.launching.AppBrandLaunchProxyUI;
import com.tencent.mm.plugin.appbrand.launching.params.LaunchParcel;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.ui.AppBrandInToolsUI;
import com.tencent.mm.plugin.appbrand.ui.AppBrandPluginUI;
import com.tencent.mm.plugin.appbrand.ui.AppBrandUI;

final class b
  extends a
{
  public final boolean b(Context paramContext, LaunchParcel paramLaunchParcel)
  {
    AppMethodBeat.i(132056);
    Intent localIntent = new Intent(paramContext, AppBrandLaunchProxyUI.class);
    int i;
    if (!(paramContext instanceof Activity))
    {
      localIntent.addFlags(268435456);
      localIntent.putExtra("extra_from_mm", false);
      localIntent.putExtra("extra_launch_parcel", paramLaunchParcel);
      localIntent.putExtra("extra_launch_source_context", paramContext.getClass().getName());
      if ((paramContext instanceof AppBrandUI)) {
        break label130;
      }
      i = 0;
      label74:
      if (i == 0) {
        break label200;
      }
      localIntent.putExtra("extra_result_receiver", new ClientLaunchEntry.1(this, new Handler(Looper.getMainLooper()), paramContext));
      label105:
      paramContext.startActivity(localIntent);
    }
    for (;;)
    {
      AppMethodBeat.o(132056);
      return true;
      h.c(localIntent, (Activity)paramContext);
      break;
      label130:
      if ((paramContext instanceof AppBrandPluginUI))
      {
        i = 0;
        break label74;
      }
      if ((paramContext instanceof AppBrandInToolsUI))
      {
        i = 0;
        break label74;
      }
      if ((paramLaunchParcel.hiz != null) && (paramLaunchParcel.hiz.hiK == 1))
      {
        i = 0;
        break label74;
      }
      if (paramLaunchParcel.inG.scene == 1085)
      {
        i = 0;
        break label74;
      }
      i = 1;
      break label74;
      label200:
      if (!(paramContext instanceof Activity)) {
        break label105;
      }
      e.at(paramContext).a(localIntent, new b.1(this, paramLaunchParcel));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.precondition.b
 * JD-Core Version:    0.7.0.1
 */