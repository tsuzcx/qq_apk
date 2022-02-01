package com.tencent.mm.plugin.appbrand.jsapi.m;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.tencent.luggage.sdk.b.a.a.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.h.d;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;

public final class i
  implements b
{
  public final boolean Ey()
  {
    AppMethodBeat.i(188456);
    Object localObject = aj.fkE().getString("appbrandgame_open_nativelibuv", "");
    if ((localObject != null) && (((String)localObject).equalsIgnoreCase("close"))) {}
    for (localObject = Boolean.TRUE; ((Boolean)localObject).booleanValue(); localObject = Boolean.FALSE)
    {
      ad.i("MicroMsg.AppBrand.NativeInstallHelperSwitchDelegateImpl", "use libuv Command close");
      AppMethodBeat.o(188456);
      return false;
    }
    localObject = d.crP().b("clicfg_appbrand_native_install_default_libuv", "1", true, true);
    ad.i("MicroMsg.AppBrand.NativeInstallHelperSwitchDelegateImpl", "use libuv xSwitch xSwitchStr:%s", new Object[] { localObject });
    if (!TextUtils.equals((CharSequence)localObject, "1"))
    {
      ad.i("MicroMsg.AppBrand.NativeInstallHelperSwitchDelegateImpl", "use libuv xSwitch false");
      AppMethodBeat.o(188456);
      return false;
    }
    AppMethodBeat.o(188456);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.m.i
 * JD-Core Version:    0.7.0.1
 */