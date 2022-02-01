package com.tencent.mm.plugin.appbrand.jsapi.nfc;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class h
  extends JsApiAppBrandNFCBase
{
  public static final int CTRL_INDEX = 353;
  public static final String NAME = "stopHCE";
  
  static void a(e parame, int paramInt, String paramString)
  {
    AppMethodBeat.i(136120);
    Log.i("MicroMsg.JsApiNFCStartHCE", "alvinluo stopHCE callback result: %s", new Object[] { paramString });
    if (parame != null) {
      parame.j(paramInt, paramString);
    }
    AppMethodBeat.o(136120);
  }
  
  public final void a(final e parame, JSONObject paramJSONObject, final int paramInt)
  {
    AppMethodBeat.i(136119);
    a(new JsApiAppBrandNFCBase.a()
    {
      public final void B(int paramAnonymousInt, String paramAnonymousString)
      {
        AppMethodBeat.i(136118);
        Object localObject = new HashMap();
        ((Map)localObject).put("errCode", Integer.valueOf(paramAnonymousInt));
        if (paramAnonymousInt == 0)
        {
          paramAnonymousString = h.this;
          localObject = parame;
          paramAnonymousInt = paramInt;
          HCEEventLogic.aim(((e)localObject).getAppId());
          HCEEventLogic.a(((e)localObject).getAppId(), 13, null);
          HashMap localHashMap = new HashMap(2);
          localHashMap.put("errCode", Integer.valueOf(0));
          h.a((e)localObject, paramAnonymousInt, paramAnonymousString.m("ok", localHashMap));
          AppMethodBeat.o(136118);
          return;
        }
        h.a(parame, paramInt, h.this.m("fail: ".concat(String.valueOf(paramAnonymousString)), (Map)localObject));
        AppMethodBeat.o(136118);
      }
    });
    AppMethodBeat.o(136119);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.nfc.h
 * JD-Core Version:    0.7.0.1
 */