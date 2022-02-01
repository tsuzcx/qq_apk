package com.tencent.mm.plugin.appbrand.jsapi.o;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.tencent.luggage.sdk.b.a.a.d.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.expt.h.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

public final class j
  implements d.b
{
  public final boolean Ob()
  {
    AppMethodBeat.i(226913);
    if (((b)g.af(b.class)).a(b.a.rUO, 1) > 0)
    {
      AppMethodBeat.o(226913);
      return true;
    }
    AppMethodBeat.o(226913);
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
    localObject = d.cRY().b("clicfg_appbrand_native_socket_default_wcwss", "1", true, true);
    Log.i("MicroMsg.AppBrand.WcWssNativeSwitchDelegateImpl", "createWcWssBinding xSwitch xSwitchStr:%s", new Object[] { localObject });
    if (!TextUtils.equals((CharSequence)localObject, "1"))
    {
      Log.i("MicroMsg.AppBrand.WcWssNativeSwitchDelegateImpl", "createWcWssBinding xSwitch false");
      AppMethodBeat.o(174843);
      return false;
    }
    AppMethodBeat.o(174843);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.o.j
 * JD-Core Version:    0.7.0.1
 */