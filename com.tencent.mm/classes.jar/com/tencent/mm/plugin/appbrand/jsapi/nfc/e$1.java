package com.tencent.mm.plugin.appbrand.jsapi.nfc;

import com.tencent.mm.plugin.appbrand.jsapi.c;
import java.util.HashMap;
import java.util.Map;

final class e$1
  implements JsApiAppBrandNFCBase.a
{
  e$1(e parame, c paramc, int paramInt) {}
  
  public final void J(int paramInt, String paramString)
  {
    Object localObject = new HashMap();
    ((Map)localObject).put("errCode", Integer.valueOf(paramInt));
    if (paramInt == 0)
    {
      paramString = this.gyc;
      localObject = this.ggH;
      paramInt = this.dIS;
      HCEEventLogic.ux(((c)localObject).getAppId());
      HCEEventLogic.a(((c)localObject).getAppId(), 13, null);
      HashMap localHashMap = new HashMap(2);
      localHashMap.put("errCode", Integer.valueOf(0));
      e.a((c)localObject, paramInt, paramString.h("ok", localHashMap));
      return;
    }
    e.a(this.ggH, this.dIS, this.gyc.h("fail: " + paramString, (Map)localObject));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.nfc.e.1
 * JD-Core Version:    0.7.0.1
 */