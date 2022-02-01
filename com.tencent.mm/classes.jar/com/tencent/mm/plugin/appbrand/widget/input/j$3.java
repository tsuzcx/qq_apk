package com.tencent.mm.plugin.appbrand.widget.input;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.jsapi.i.h.a;
import com.tencent.mm.plugin.appbrand.jsapi.r;
import com.tencent.mm.plugin.appbrand.page.ad;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

public final class j$3
  implements aj
{
  public j$3(j paramj, WeakReference paramWeakReference, c paramc, int paramInt, String paramString) {}
  
  public final void a(String paramString, int paramInt, aj.a parama)
  {
    AppMethodBeat.i(136382);
    for (;;)
    {
      try
      {
        ad localad = (ad)this.oUm.get();
        if (localad == null)
        {
          AppMethodBeat.o(136382);
          return;
        }
        JSONObject localJSONObject = new JSONObject().put("value", paramString).put("keyCode", ((af)this.ruV.cnZ()).getLastKeyPressed()).put("inputId", this.oUo).put("cursor", paramInt);
        if (aj.a.rxA.equals(parama))
        {
          paramString = new h.a();
          paramString.a(localad.getRuntime().QW(), localad.getComponentId()).bPO();
          paramString.agT(localJSONObject.put("data", this.ruW).toString());
          paramString.bPO();
          AppMethodBeat.o(136382);
          return;
        }
        switch (j.5.ruX[parama.ordinal()])
        {
        case 1: 
          boolean bool = Util.isNullOrNil(paramString);
          if (bool)
          {
            AppMethodBeat.o(136382);
            return;
            paramString = "onKeyboardComplete";
            continue;
          }
          localad.ct(paramString, localJSONObject.toString());
          AppMethodBeat.o(136382);
          return;
        }
      }
      catch (Exception paramString)
      {
        AppMethodBeat.o(136382);
        return;
      }
      paramString = null;
      continue;
      paramString = "onKeyboardConfirm";
    }
  }
  
  public final void f(String paramString1, int paramInt, String paramString2, String paramString3)
  {
    AppMethodBeat.i(214439);
    try
    {
      ad localad = (ad)this.oUm.get();
      if (localad == null)
      {
        AppMethodBeat.o(214439);
        return;
      }
      paramString1 = new JSONObject().put("value", paramString1).put("keyCode", ((af)this.ruV.cnZ()).getLastKeyPressed()).put("inputId", this.oUo).put("cursor", paramInt);
      if (paramString2 != null) {
        paramString1.put("encryptValue", paramString2);
      }
      if (paramString3 != null) {
        paramString1.put("encryptError", paramString3);
      }
      paramString1 = paramString1.toString();
      Log.i("MicroMsg.AppBrandInputJsApiHandler", "onKeyboardCompleteWithEncryptedValue, eventData: ".concat(String.valueOf(paramString1)));
      localad.ct("onKeyboardComplete", paramString1);
      AppMethodBeat.o(214439);
      return;
    }
    catch (Exception paramString1)
    {
      AppMethodBeat.o(214439);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.j.3
 * JD-Core Version:    0.7.0.1
 */