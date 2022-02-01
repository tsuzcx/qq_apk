package com.tencent.mm.plugin.appbrand.menu.b;

import android.content.Context;
import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.m;
import com.tencent.mm.plugin.appbrand.d;
import com.tencent.mm.plugin.appbrand.menu.a.b;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;

public final class c
  implements b<com.tencent.luggage.sdk.b.a.c>
{
  public static void a(d paramd, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(147336);
    m.an(paramString, paramBoolean);
    if (paramBoolean) {}
    for (paramString = paramd.getContext().getResources().getString(2131755410);; paramString = paramd.getContext().getResources().getString(2131755409))
    {
      MMHandlerThread.postToMainThread(new c.1(paramd, paramString));
      AppMethodBeat.o(147336);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.menu.b.c
 * JD-Core Version:    0.7.0.1
 */