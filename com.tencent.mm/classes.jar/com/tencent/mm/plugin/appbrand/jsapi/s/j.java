package com.tencent.mm.plugin.appbrand.jsapi.s;

import android.content.SharedPreferences;
import com.tencent.luggage.sdk.b.a.b.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

public final class j
  implements b
{
  public final boolean aro()
  {
    AppMethodBeat.i(327276);
    Object localObject = MMApplicationContext.getToolsProcesstPreference().getString("appbrandgame_open_nativelibuv", "");
    if ((localObject != null) && (((String)localObject).equalsIgnoreCase("close"))) {}
    for (localObject = Boolean.TRUE; ((Boolean)localObject).booleanValue(); localObject = Boolean.FALSE)
    {
      Log.i("MicroMsg.AppBrand.NativeInstallHelperSwitchDelegateImpl", "use libuv Command close");
      AppMethodBeat.o(327276);
      return false;
    }
    AppMethodBeat.o(327276);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.s.j
 * JD-Core Version:    0.7.0.1
 */