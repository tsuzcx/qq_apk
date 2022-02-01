package com.tencent.mm.plugin.appbrand.jsapi.j;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;

public final class k
  implements com.tencent.luggage.sdk.b.a.a.b
{
  public final boolean CZ()
  {
    AppMethodBeat.i(186712);
    Object localObject = ai.eUZ().getString("appbrandgame_open_nativelibuv", "");
    if ((localObject != null) && (((String)localObject).equalsIgnoreCase("close"))) {}
    for (localObject = Boolean.TRUE; ((Boolean)localObject).booleanValue(); localObject = Boolean.FALSE)
    {
      ac.i("MicroMsg.AppBrand.NativeInstallHelperSwitchDelegateImpl", "use libuv Command close");
      AppMethodBeat.o(186712);
      return false;
    }
    localObject = com.tencent.mm.plugin.expt.e.b.cmk().b("clicfg_appbrand_native_install_default_libuv", "1", true, true);
    ac.i("MicroMsg.AppBrand.NativeInstallHelperSwitchDelegateImpl", "use libuv xSwitch xSwitchStr:%s", new Object[] { localObject });
    if (!TextUtils.equals((CharSequence)localObject, "1"))
    {
      ac.i("MicroMsg.AppBrand.NativeInstallHelperSwitchDelegateImpl", "use libuv xSwitch false");
      AppMethodBeat.o(186712);
      return false;
    }
    AppMethodBeat.o(186712);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.j.k
 * JD-Core Version:    0.7.0.1
 */