package com.tencent.mm.plugin.appbrand.menu.b;

import android.content.Context;
import android.content.res.Resources;
import com.tencent.luggage.m.a.g;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.o;
import com.tencent.mm.plugin.appbrand.g;
import com.tencent.mm.plugin.appbrand.menu.a.b;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;

public final class c
  implements b<com.tencent.luggage.sdk.b.a.c>
{
  public static void a(g paramg, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(147336);
    o.aw(paramString, paramBoolean);
    if (paramBoolean) {}
    for (paramString = paramg.getContext().getResources().getString(a.g.app_brand_debug_enabled_toast);; paramString = paramg.getContext().getResources().getString(a.g.app_brand_debug_disabled_toast))
    {
      MMHandlerThread.postToMainThread(new c.1(paramg, paramString));
      AppMethodBeat.o(147336);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.menu.b.c
 * JD-Core Version:    0.7.0.1
 */