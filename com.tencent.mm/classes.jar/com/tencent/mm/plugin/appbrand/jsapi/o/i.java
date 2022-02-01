package com.tencent.mm.plugin.appbrand.jsapi.o;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.tencent.luggage.sdk.b.a.a.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.h.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

public final class i
  implements b
{
  public final boolean Oa()
  {
    AppMethodBeat.i(226912);
    Object localObject = MMApplicationContext.getToolsProcesstPreference().getString("appbrandgame_open_nativelibuv", "");
    if ((localObject != null) && (((String)localObject).equalsIgnoreCase("close"))) {}
    for (localObject = Boolean.TRUE; ((Boolean)localObject).booleanValue(); localObject = Boolean.FALSE)
    {
      Log.i("MicroMsg.AppBrand.NativeInstallHelperSwitchDelegateImpl", "use libuv Command close");
      AppMethodBeat.o(226912);
      return false;
    }
    localObject = d.cRY().b("clicfg_appbrand_native_install_default_libuv", "1", true, true);
    Log.i("MicroMsg.AppBrand.NativeInstallHelperSwitchDelegateImpl", "use libuv xSwitch xSwitchStr:%s", new Object[] { localObject });
    if (!TextUtils.equals((CharSequence)localObject, "1"))
    {
      Log.i("MicroMsg.AppBrand.NativeInstallHelperSwitchDelegateImpl", "use libuv xSwitch false");
      AppMethodBeat.o(226912);
      return false;
    }
    AppMethodBeat.o(226912);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.o.i
 * JD-Core Version:    0.7.0.1
 */