package com.tencent.mm.plugin.appbrand.menu.b;

import android.content.Context;
import android.content.res.Resources;
import android.widget.Toast;
import com.tencent.luggage.l.a.g;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.config.m;
import com.tencent.mm.plugin.appbrand.g;
import com.tencent.mm.plugin.appbrand.menu.a.b;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;

public final class c
  implements b<com.tencent.luggage.sdk.b.a.c>
{
  public static void a(g paramg, final String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(147336);
    m.ao(paramString, paramBoolean);
    if (paramBoolean) {}
    for (paramString = paramg.getContext().getResources().getString(a.g.app_brand_debug_enabled_toast);; paramString = paramg.getContext().getResources().getString(a.g.app_brand_debug_disabled_toast))
    {
      MMHandlerThread.postToMainThread(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(147335);
          Toast.makeText(this.oAW.getContext(), paramString, 0).show();
          this.oAW.getRuntime().finish();
          AppMethodBeat.o(147335);
        }
      });
      AppMethodBeat.o(147336);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.menu.b.c
 * JD-Core Version:    0.7.0.1
 */