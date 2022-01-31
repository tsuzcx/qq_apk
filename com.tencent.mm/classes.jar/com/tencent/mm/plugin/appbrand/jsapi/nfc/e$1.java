package com.tencent.mm.plugin.appbrand.jsapi.nfc;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import java.util.HashMap;
import java.util.Map;

final class e$1
  implements JsApiAppBrandNFCBase.a
{
  e$1(e parame, c paramc, int paramInt) {}
  
  public final void U(int paramInt, String paramString)
  {
    AppMethodBeat.i(137881);
    Object localObject = new HashMap();
    ((Map)localObject).put("errCode", Integer.valueOf(paramInt));
    if (paramInt == 0)
    {
      paramString = this.hUB;
      localObject = this.hxW;
      paramInt = this.bAX;
      HCEEventLogic.CH(((c)localObject).getAppId());
      HCEEventLogic.a(((c)localObject).getAppId(), 13, null);
      HashMap localHashMap = new HashMap(2);
      localHashMap.put("errCode", Integer.valueOf(0));
      e.a((c)localObject, paramInt, paramString.j("ok", localHashMap));
      AppMethodBeat.o(137881);
      return;
    }
    e.a(this.hxW, this.bAX, this.hUB.j("fail: ".concat(String.valueOf(paramString)), (Map)localObject));
    AppMethodBeat.o(137881);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.nfc.e.1
 * JD-Core Version:    0.7.0.1
 */