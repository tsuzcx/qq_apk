package com.tencent.mm.plugin.appbrand.widget.input;

import android.widget.EditText;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.jsapi.i.h.a;
import com.tencent.mm.plugin.appbrand.jsapi.r;
import com.tencent.mm.plugin.appbrand.page.ad;
import com.tencent.mm.sdk.platformtools.Log;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

public final class j$2
  implements af.b
{
  public j$2(j paramj, WeakReference paramWeakReference, c paramc, String paramString) {}
  
  public final boolean DK(int paramInt)
  {
    AppMethodBeat.i(136381);
    if (paramInt == 67)
    {
      ad localad = (ad)this.oUm.get();
      if (localad != null) {}
      try
      {
        paramInt = this.ruV.rtN;
        h.a locala = new h.a();
        JSONObject localJSONObject = new JSONObject().put("value", this.ruV.cnZ().getText().toString()).put("data", this.ruW).put("cursor", 0).put("inputId", paramInt).put("keyCode", 8);
        locala.a(localad.getRuntime().QW(), localad.getComponentId()).agT(localJSONObject.toString()).bPO();
        AppMethodBeat.o(136381);
        return true;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Log.e("MicroMsg.AppBrandInputJsApiHandler", "onKeyUpPostIme DEL, e = %s", new Object[] { localException });
        }
      }
    }
    AppMethodBeat.o(136381);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.j.2
 * JD-Core Version:    0.7.0.1
 */