package com.tencent.mm.plugin.appbrand.jsapi.p;

import android.content.SharedPreferences;
import com.tencent.luggage.sdk.b.a.a.e.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

public final class j
  implements e.b
{
  public final boolean QZ()
  {
    AppMethodBeat.i(279954);
    if (((b)h.ae(b.class)).a(b.a.vBu, 1) > 0)
    {
      AppMethodBeat.o(279954);
      return true;
    }
    AppMethodBeat.o(279954);
    return false;
  }
  
  public final boolean isOpen()
  {
    AppMethodBeat.i(174843);
    Object localObject = MMApplicationContext.getToolsProcesstPreference().getString("appbrandgame_open_nativewss", "");
    if ((localObject != null) && (((String)localObject).equalsIgnoreCase("close"))) {}
    for (localObject = Boolean.TRUE; ((Boolean)localObject).booleanValue(); localObject = Boolean.FALSE)
    {
      Log.i("MicroMsg.AppBrand.WcWssNativeSwitchDelegateImpl", "createWcWssBinding Command close");
      AppMethodBeat.o(174843);
      return false;
    }
    AppMethodBeat.o(174843);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.p.j
 * JD-Core Version:    0.7.0.1
 */