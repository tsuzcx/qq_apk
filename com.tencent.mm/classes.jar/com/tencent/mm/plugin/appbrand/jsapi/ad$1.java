package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.mm.plugin.appbrand.p;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.HashMap;
import java.util.Map;

final class ad$1
  implements Runnable
{
  ad$1(ad paramad, int paramInt1, JsApiGetAppConfigTask paramJsApiGetAppConfigTask, p paramp, int paramInt2) {}
  
  public final void run()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("type", this.bns);
    localHashMap.put("data", this.gfW.value);
    y.i("MicroMsg.JsApiGetAppConfig", "getAppConfig type:%d,data:\n%s", new Object[] { Integer.valueOf(this.bns), this.gfW.value });
    if (bk.bl(this.gfW.value)) {
      this.gbW.C(this.dIS, this.gfX.h("fail", null));
    }
    for (;;)
    {
      this.gfW.ahD();
      return;
      this.gbW.C(this.dIS, this.gfX.h("ok", localHashMap));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.ad.1
 * JD-Core Version:    0.7.0.1
 */