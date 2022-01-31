package com.tencent.mm.plugin.appbrand.jsapi.nfc;

import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.sdk.platformtools.y;
import java.util.HashMap;
import java.util.Map;

final class b$1
  implements JsApiAppBrandNFCBase.a
{
  b$1(b paramb, c paramc, int paramInt) {}
  
  public final void J(int paramInt, String paramString)
  {
    y.i("MicroMsg.JsApiGetHCEState", "alvinluo checkIsSupport onResult errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt), paramString });
    HashMap localHashMap = new HashMap();
    localHashMap.put("errCode", Integer.valueOf(paramInt));
    if (paramInt == 0)
    {
      this.ggH.C(this.dIS, this.gxT.h("ok", localHashMap));
      return;
    }
    this.ggH.C(this.dIS, this.gxT.h("fail " + paramString, localHashMap));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.nfc.b.1
 * JD-Core Version:    0.7.0.1
 */