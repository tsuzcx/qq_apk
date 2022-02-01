package com.tencent.mm.plugin.appbrand.jsapi.s;

import android.content.SharedPreferences;
import com.tencent.luggage.sdk.b.a.b.e.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.expt.b.c;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

public final class k
  implements e.b
{
  public final boolean arp()
  {
    AppMethodBeat.i(327275);
    if (((c)h.ax(c.class)).a(c.a.yPv, 1) > 0)
    {
      AppMethodBeat.o(327275);
      return true;
    }
    AppMethodBeat.o(327275);
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
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.s.k
 * JD-Core Version:    0.7.0.1
 */