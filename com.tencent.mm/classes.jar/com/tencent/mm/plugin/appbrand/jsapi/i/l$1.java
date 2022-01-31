package com.tencent.mm.plugin.appbrand.jsapi.i;

import com.tencent.mm.plugin.appbrand.o;
import com.tencent.mm.pluginsdk.wallet.b.a;
import com.tencent.mm.sdk.platformtools.y;
import java.util.HashMap;
import java.util.Map;

final class l$1
  implements b.a
{
  l$1(l paraml, o paramo, int paramInt) {}
  
  public final void onSuccess(String paramString)
  {
    y.i("MicroMsg.JsApiSecureTunnel", "secureTunnel callback success: %s", new Object[] { paramString });
    HashMap localHashMap = new HashMap();
    localHashMap.put("respbuf", paramString);
    this.gcp.C(this.dIS, this.gxJ.h("ok", localHashMap));
  }
  
  public final void uv(String paramString)
  {
    y.i("MicroMsg.JsApiSecureTunnel", "secureTunnel callback fail");
    HashMap localHashMap = new HashMap();
    localHashMap.put("err_desc", paramString);
    this.gcp.C(this.dIS, this.gxJ.h("fail", localHashMap));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.i.l.1
 * JD-Core Version:    0.7.0.1
 */