package com.tencent.mm.plugin.appbrand.jsapi.nfc;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class f
  extends JsApiAppBrandNFCBase
{
  public static final int CTRL_INDEX = 354;
  public static final String NAME = "sendHCEMessage";
  
  static void a(c paramc, int paramInt, String paramString)
  {
    AppMethodBeat.i(136106);
    ad.i("MicroMsg.JsApiNFCSendHCEResponseCommand", "alvinluo sendHCEMessage callback json: %s", new Object[] { paramString });
    if (paramc != null) {
      paramc.h(paramInt, paramString);
    }
    AppMethodBeat.o(136106);
  }
  
  public final void a(final c paramc, final JSONObject paramJSONObject, final int paramInt)
  {
    AppMethodBeat.i(136105);
    a(new JsApiAppBrandNFCBase.a()
    {
      public final void y(int paramAnonymousInt, String paramAnonymousString)
      {
        AppMethodBeat.i(136104);
        Object localObject1 = new HashMap();
        ((Map)localObject1).put("errCode", Integer.valueOf(paramAnonymousInt));
        if (paramAnonymousInt == 0)
        {
          paramAnonymousString = f.this;
          localObject1 = paramc;
          paramAnonymousInt = paramInt;
          Object localObject2 = paramJSONObject;
          HashMap localHashMap = new HashMap();
          localObject2 = ((JSONObject)localObject2).optString("data");
          if (bt.isNullOrNil((String)localObject2))
          {
            localHashMap.put("errCode", Integer.valueOf(13005));
            f.a((c)localObject1, paramAnonymousInt, paramAnonymousString.m("fail", localHashMap));
            AppMethodBeat.o(136104);
            return;
          }
          Bundle localBundle = new Bundle();
          localBundle.putString("key_apdu_command", (String)localObject2);
          HCEEventLogic.a(((c)localObject1).getAppId(), 32, localBundle);
          localHashMap.put("errCode", Integer.valueOf(0));
          ((c)localObject1).h(paramAnonymousInt, paramAnonymousString.m("ok", localHashMap));
          AppMethodBeat.o(136104);
          return;
        }
        f.a(paramc, paramInt, f.this.m("fail: ".concat(String.valueOf(paramAnonymousString)), (Map)localObject1));
        AppMethodBeat.o(136104);
      }
    });
    AppMethodBeat.o(136105);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.nfc.f
 * JD-Core Version:    0.7.0.1
 */