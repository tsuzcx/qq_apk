package com.tencent.mm.plugin.appbrand.jsapi.storage;

import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.sdk.platformtools.y;
import java.util.HashMap;
import java.util.Map;

final class f$1
  implements Runnable
{
  f$1(f paramf, JsApiGetStorageTask paramJsApiGetStorageTask, c paramc, int paramInt, long paramLong) {}
  
  public final void run()
  {
    String str1;
    HashMap localHashMap;
    if (this.gBX.value == null)
    {
      str1 = "fail:data not found";
      localHashMap = new HashMap();
      if (this.gBX.value != null) {
        break label138;
      }
      str2 = "";
      label34:
      localHashMap.put("data", str2);
      if (this.gBX.type != null) {
        break label149;
      }
    }
    label138:
    label149:
    for (String str2 = "";; str2 = this.gBX.type)
    {
      localHashMap.put("dataType", str2);
      this.ggE.C(this.dIS, this.gBY.h(str1, localHashMap));
      this.gBX.ahD();
      y.i("MicroMsg.JsApiGetStorage", "getStorage: %s, time: %d", new Object[] { this.gBX.key, Long.valueOf(System.currentTimeMillis() - this.dhV) });
      return;
      str1 = "ok";
      break;
      str2 = this.gBX.value;
      break label34;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.storage.f.1
 * JD-Core Version:    0.7.0.1
 */