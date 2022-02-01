package com.tencent.mm.plugin.appbrand.jsapi.nfc;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.sdk.platformtools.ae;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class h
  extends JsApiAppBrandNFCBase
{
  public static final int CTRL_INDEX = 353;
  public static final String NAME = "stopHCE";
  
  static void a(c paramc, int paramInt, String paramString)
  {
    AppMethodBeat.i(136120);
    ae.i("MicroMsg.JsApiNFCStartHCE", "alvinluo stopHCE callback result: %s", new Object[] { paramString });
    if (paramc != null) {
      paramc.h(paramInt, paramString);
    }
    AppMethodBeat.o(136120);
  }
  
  public final void a(final c paramc, JSONObject paramJSONObject, final int paramInt)
  {
    AppMethodBeat.i(136119);
    a(new JsApiAppBrandNFCBase.a()
    {
      public final void y(int paramAnonymousInt, String paramAnonymousString)
      {
        AppMethodBeat.i(136118);
        Object localObject = new HashMap();
        ((Map)localObject).put("errCode", Integer.valueOf(paramAnonymousInt));
        if (paramAnonymousInt == 0)
        {
          paramAnonymousString = h.this;
          localObject = paramc;
          paramAnonymousInt = paramInt;
          HCEEventLogic.QU(((c)localObject).getAppId());
          HCEEventLogic.a(((c)localObject).getAppId(), 13, null);
          HashMap localHashMap = new HashMap(2);
          localHashMap.put("errCode", Integer.valueOf(0));
          h.a((c)localObject, paramAnonymousInt, paramAnonymousString.n("ok", localHashMap));
          AppMethodBeat.o(136118);
          return;
        }
        h.a(paramc, paramInt, h.this.n("fail: ".concat(String.valueOf(paramAnonymousString)), (Map)localObject));
        AppMethodBeat.o(136118);
      }
    });
    AppMethodBeat.o(136119);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.nfc.h
 * JD-Core Version:    0.7.0.1
 */