package com.tencent.mm.plugin.appbrand.jsapi.nfc;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

final class c$1
  implements JsApiAppBrandNFCBase.a
{
  c$1(c paramc, com.tencent.mm.plugin.appbrand.jsapi.c paramc1, int paramInt, JSONObject paramJSONObject) {}
  
  public final void U(int paramInt, String paramString)
  {
    AppMethodBeat.i(137869);
    Object localObject1 = new HashMap();
    ((Map)localObject1).put("errCode", Integer.valueOf(paramInt));
    if (paramInt == 0)
    {
      paramString = this.hUv;
      localObject1 = this.hxW;
      paramInt = this.bAX;
      Object localObject2 = this.hUu;
      HashMap localHashMap = new HashMap();
      localObject2 = ((JSONObject)localObject2).optString("data");
      if (bo.isNullOrNil((String)localObject2))
      {
        localHashMap.put("errCode", Integer.valueOf(13005));
        c.a((com.tencent.mm.plugin.appbrand.jsapi.c)localObject1, paramInt, paramString.j("fail", localHashMap));
        AppMethodBeat.o(137869);
        return;
      }
      Bundle localBundle = new Bundle();
      localBundle.putString("key_apdu_command", (String)localObject2);
      HCEEventLogic.a(((com.tencent.mm.plugin.appbrand.jsapi.c)localObject1).getAppId(), 32, localBundle);
      localHashMap.put("errCode", Integer.valueOf(0));
      ((com.tencent.mm.plugin.appbrand.jsapi.c)localObject1).h(paramInt, paramString.j("ok", localHashMap));
      AppMethodBeat.o(137869);
      return;
    }
    c.a(this.hxW, this.bAX, this.hUv.j("fail: ".concat(String.valueOf(paramString)), (Map)localObject1));
    AppMethodBeat.o(137869);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.nfc.c.1
 * JD-Core Version:    0.7.0.1
 */