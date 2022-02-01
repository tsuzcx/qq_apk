package com.tencent.mm.plugin.appbrand.jsapi.j;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.tencent.luggage.sdk.b.a.a.e.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.e.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;

public final class l
  implements e.b
{
  public final boolean isOpen()
  {
    AppMethodBeat.i(174843);
    Object localObject = aj.eFF().getString("appbrandgame_open_nativewss", "");
    if ((localObject != null) && (((String)localObject).equalsIgnoreCase("close"))) {}
    for (localObject = Boolean.TRUE; ((Boolean)localObject).booleanValue(); localObject = Boolean.FALSE)
    {
      ad.i("MicroMsg.AppBrand.WcWssNativeSwitchDelegateImpl", "createWcWssBinding Command close");
      AppMethodBeat.o(174843);
      return false;
    }
    localObject = b.ceD().b("clicfg_appbrand_native_socket_default_wcwss", "1", true, true);
    ad.i("MicroMsg.AppBrand.WcWssNativeSwitchDelegateImpl", "createWcWssBinding xSwitch xSwitchStr:%s", new Object[] { localObject });
    if (!TextUtils.equals((CharSequence)localObject, "1"))
    {
      ad.i("MicroMsg.AppBrand.WcWssNativeSwitchDelegateImpl", "createWcWssBinding xSwitch false");
      AppMethodBeat.o(174843);
      return false;
    }
    AppMethodBeat.o(174843);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.j.l
 * JD-Core Version:    0.7.0.1
 */