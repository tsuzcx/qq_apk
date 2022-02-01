package com.tencent.mm.plugin.appbrand.jsapi.nfc;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class f
  extends JsApiAppBrandNFCBase
{
  public static final int CTRL_INDEX = 354;
  public static final String NAME = "sendHCEMessage";
  
  static void a(com.tencent.mm.plugin.appbrand.jsapi.f paramf, int paramInt, String paramString)
  {
    AppMethodBeat.i(136106);
    Log.i("MicroMsg.JsApiNFCSendHCEResponseCommand", "alvinluo sendHCEMessage callback json: %s", new Object[] { paramString });
    if (paramf != null) {
      paramf.callback(paramInt, paramString);
    }
    AppMethodBeat.o(136106);
  }
  
  public final void a(final com.tencent.mm.plugin.appbrand.jsapi.f paramf, final JSONObject paramJSONObject, final int paramInt)
  {
    AppMethodBeat.i(136105);
    a(new JsApiAppBrandNFCBase.a()
    {
      public final void onResult(int paramAnonymousInt, String paramAnonymousString)
      {
        AppMethodBeat.i(136104);
        Object localObject1 = new HashMap();
        ((Map)localObject1).put("errCode", Integer.valueOf(paramAnonymousInt));
        if (paramAnonymousInt == 0)
        {
          paramAnonymousString = f.this;
          localObject1 = paramf;
          paramAnonymousInt = paramInt;
          Object localObject2 = paramJSONObject;
          HashMap localHashMap = new HashMap();
          localObject2 = ((JSONObject)localObject2).optString("data");
          if (Util.isNullOrNil((String)localObject2))
          {
            localHashMap.put("errCode", Integer.valueOf(13005));
            f.a((com.tencent.mm.plugin.appbrand.jsapi.f)localObject1, paramAnonymousInt, j.a(paramAnonymousString, 13005, "fail", localHashMap));
            AppMethodBeat.o(136104);
            return;
          }
          Bundle localBundle = new Bundle();
          localBundle.putString("key_apdu_command", (String)localObject2);
          HCEEventLogic.a(((com.tencent.mm.plugin.appbrand.jsapi.f)localObject1).getAppId(), 32, localBundle);
          localHashMap.put("errCode", Integer.valueOf(0));
          ((com.tencent.mm.plugin.appbrand.jsapi.f)localObject1).callback(paramAnonymousInt, j.a(paramAnonymousString, 0, "ok", localHashMap));
          AppMethodBeat.o(136104);
          return;
        }
        f.a(paramf, paramInt, j.a(f.this, paramAnonymousInt, "fail: ".concat(String.valueOf(paramAnonymousString)), (Map)localObject1));
        AppMethodBeat.o(136104);
      }
    });
    AppMethodBeat.o(136105);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.nfc.f
 * JD-Core Version:    0.7.0.1
 */