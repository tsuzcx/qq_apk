package com.tencent.mm.plugin.appbrand.jsapi.nfc;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class h
  extends JsApiAppBrandNFCBase
{
  public static final int CTRL_INDEX = 353;
  public static final String NAME = "stopHCE";
  
  static void a(f paramf, int paramInt, String paramString)
  {
    AppMethodBeat.i(136120);
    Log.i("MicroMsg.JsApiNFCStartHCE", "alvinluo stopHCE callback result: %s", new Object[] { paramString });
    if (paramf != null) {
      paramf.i(paramInt, paramString);
    }
    AppMethodBeat.o(136120);
  }
  
  public final void a(final f paramf, JSONObject paramJSONObject, final int paramInt)
  {
    AppMethodBeat.i(136119);
    a(new JsApiAppBrandNFCBase.a()
    {
      public final void A(int paramAnonymousInt, String paramAnonymousString)
      {
        AppMethodBeat.i(136118);
        Object localObject = new HashMap();
        ((Map)localObject).put("errCode", Integer.valueOf(paramAnonymousInt));
        if (paramAnonymousInt == 0)
        {
          paramAnonymousString = h.this;
          localObject = paramf;
          paramAnonymousInt = paramInt;
          HCEEventLogic.aav(((f)localObject).getAppId());
          HCEEventLogic.a(((f)localObject).getAppId(), 13, null);
          HashMap localHashMap = new HashMap(2);
          localHashMap.put("errCode", Integer.valueOf(0));
          h.a((f)localObject, paramAnonymousInt, paramAnonymousString.n("ok", localHashMap));
          AppMethodBeat.o(136118);
          return;
        }
        h.a(paramf, paramInt, h.this.n("fail: ".concat(String.valueOf(paramAnonymousString)), (Map)localObject));
        AppMethodBeat.o(136118);
      }
    });
    AppMethodBeat.o(136119);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.nfc.h
 * JD-Core Version:    0.7.0.1
 */