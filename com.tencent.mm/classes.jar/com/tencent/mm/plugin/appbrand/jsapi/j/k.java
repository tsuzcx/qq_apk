package com.tencent.mm.plugin.appbrand.jsapi.j;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;

public final class k
  implements com.tencent.luggage.sdk.b.a.a.b
{
  public final boolean Dw()
  {
    AppMethodBeat.i(195922);
    Object localObject = aj.eFF().getString("appbrandgame_open_nativelibuv", "");
    if ((localObject != null) && (((String)localObject).equalsIgnoreCase("close"))) {}
    for (localObject = Boolean.TRUE; ((Boolean)localObject).booleanValue(); localObject = Boolean.FALSE)
    {
      ad.i("MicroMsg.AppBrand.NativeInstallHelperSwitchDelegateImpl", "use libuv Command close");
      AppMethodBeat.o(195922);
      return false;
    }
    localObject = com.tencent.mm.plugin.expt.e.b.ceD().b("clicfg_appbrand_native_install_default_libuv", "1", true, true);
    ad.i("MicroMsg.AppBrand.NativeInstallHelperSwitchDelegateImpl", "use libuv xSwitch xSwitchStr:%s", new Object[] { localObject });
    if (!TextUtils.equals((CharSequence)localObject, "1"))
    {
      ad.i("MicroMsg.AppBrand.NativeInstallHelperSwitchDelegateImpl", "use libuv xSwitch false");
      AppMethodBeat.o(195922);
      return false;
    }
    AppMethodBeat.o(195922);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.j.k
 * JD-Core Version:    0.7.0.1
 */