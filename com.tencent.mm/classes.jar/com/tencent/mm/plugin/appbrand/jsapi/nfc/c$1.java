package com.tencent.mm.plugin.appbrand.jsapi.nfc;

import android.os.Bundle;
import com.tencent.mm.sdk.platformtools.bk;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

final class c$1
  implements JsApiAppBrandNFCBase.a
{
  c$1(c paramc, com.tencent.mm.plugin.appbrand.jsapi.c paramc1, int paramInt, JSONObject paramJSONObject) {}
  
  public final void J(int paramInt, String paramString)
  {
    Object localObject1 = new HashMap();
    ((Map)localObject1).put("errCode", Integer.valueOf(paramInt));
    if (paramInt == 0)
    {
      paramString = this.gxV;
      localObject1 = this.ggH;
      paramInt = this.dIS;
      Object localObject2 = this.gxU;
      HashMap localHashMap = new HashMap();
      localObject2 = ((JSONObject)localObject2).optString("data");
      if (bk.bl((String)localObject2))
      {
        localHashMap.put("errCode", Integer.valueOf(13005));
        c.a((com.tencent.mm.plugin.appbrand.jsapi.c)localObject1, paramInt, paramString.h("fail", localHashMap));
        return;
      }
      Bundle localBundle = new Bundle();
      localBundle.putString("key_apdu_command", (String)localObject2);
      HCEEventLogic.a(((com.tencent.mm.plugin.appbrand.jsapi.c)localObject1).getAppId(), 32, localBundle);
      localHashMap.put("errCode", Integer.valueOf(0));
      ((com.tencent.mm.plugin.appbrand.jsapi.c)localObject1).C(paramInt, paramString.h("ok", localHashMap));
      return;
    }
    c.a(this.ggH, this.dIS, this.gxV.h("fail: " + paramString, (Map)localObject1));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.nfc.c.1
 * JD-Core Version:    0.7.0.1
 */