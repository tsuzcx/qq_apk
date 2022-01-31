package com.tencent.mm.plugin.appbrand.jsapi.nfc;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.HashMap;
import java.util.Map;

final class b$1
  implements JsApiAppBrandNFCBase.a
{
  b$1(b paramb, c paramc, int paramInt) {}
  
  public final void U(int paramInt, String paramString)
  {
    AppMethodBeat.i(137867);
    ab.i("MicroMsg.JsApiGetHCEState", "alvinluo checkIsSupport onResult errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt), paramString });
    HashMap localHashMap = new HashMap();
    localHashMap.put("errCode", Integer.valueOf(paramInt));
    if (paramInt == 0)
    {
      this.hxW.h(this.bAX, this.hUt.j("ok", localHashMap));
      AppMethodBeat.o(137867);
      return;
    }
    this.hxW.h(this.bAX, this.hUt.j("fail ".concat(String.valueOf(paramString)), localHashMap));
    AppMethodBeat.o(137867);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.nfc.b.1
 * JD-Core Version:    0.7.0.1
 */