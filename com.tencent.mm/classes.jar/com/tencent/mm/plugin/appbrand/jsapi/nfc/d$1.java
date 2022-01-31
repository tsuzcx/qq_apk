package com.tencent.mm.plugin.appbrand.jsapi.nfc;

import android.app.Activity;
import android.app.Application;
import android.content.ComponentName;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.plugin.appbrand.jsapi.nfc.hce.HCEService;
import com.tencent.mm.plugin.appbrand.jsapi.nfc.hce.a;
import com.tencent.mm.sdk.platformtools.ak;
import java.util.HashMap;
import java.util.Map;

final class d$1
  implements JsApiAppBrandNFCBase.a
{
  d$1(d paramd) {}
  
  public final void U(int paramInt, String paramString)
  {
    AppMethodBeat.i(137872);
    HashMap localHashMap = new HashMap();
    localHashMap.put("errCode", Integer.valueOf(paramInt));
    if (paramInt == 0)
    {
      paramString = this.hUA;
      if (!(paramString.hAC.getContext() instanceof Activity))
      {
        paramString.BS(paramString.j("fail: unknown error", null));
        AppMethodBeat.o(137872);
        return;
      }
      paramString.gQx = ((Activity)paramString.hAC.getContext());
      paramString.hUx = new d.2(paramString);
      paramString.gQx.getApplication().registerActivityLifecycleCallbacks(paramString.hUx);
      paramString.Di = new JsApiNFCStartHCE.3(paramString, ak.fetchFreeHandler(Looper.getMainLooper()));
      a.hUM.a(paramString.gQx, paramString.Di);
      a.hUM.aEa();
      paramString = new ComponentName(paramString.gQx, HCEService.class.getCanonicalName());
      a.hUM.b(paramString);
      a.hUM.aDZ();
      AppMethodBeat.o(137872);
      return;
    }
    com.tencent.mm.plugin.appbrand.jsapi.nfc.hce.a.c.Q(this.hUA.hAC.getAppId(), paramInt, -1);
    this.hUA.BS(this.hUA.j("fail: ".concat(String.valueOf(paramString)), localHashMap));
    AppMethodBeat.o(137872);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.nfc.d.1
 * JD-Core Version:    0.7.0.1
 */