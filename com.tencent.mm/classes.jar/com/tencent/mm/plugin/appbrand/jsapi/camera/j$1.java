package com.tencent.mm.plugin.appbrand.jsapi.camera;

import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.i;
import com.tencent.mm.sdk.platformtools.y;
import java.util.HashMap;
import org.json.JSONObject;

final class j$1
  implements Runnable
{
  j$1(j paramj, JSONObject paramJSONObject, c paramc, int paramInt) {}
  
  public final void run()
  {
    int i = this.gbZ.optInt("cameraId");
    String str = this.gbZ.optString("type");
    y.i("MicroMsg.JsApiOperateCamera", "cameraId=%d type=%s", new Object[] { Integer.valueOf(i), str });
    Object localObject = a.a.aiD();
    Integer localInteger = Integer.valueOf(i);
    if (((a)localObject).goq.containsKey(localInteger)) {}
    for (localObject = (d)((a)localObject).goq.get(localInteger); localObject == null; localObject = null)
    {
      this.ggE.C(this.dIS, this.gpd.h("fail:no such camera", null));
      return;
    }
    ((d)localObject).setOperateCallBack(new j.1.1(this));
    i = -1;
    switch (str.hashCode())
    {
    }
    for (;;)
    {
      switch (i)
      {
      default: 
        y.w("MicroMsg.JsApiOperateCamera", "operateType not supported: %s", new Object[] { str });
        this.ggE.C(this.dIS, this.gpd.h("fail:operateType not supported", null));
        return;
        if (str.equals("takePhoto"))
        {
          i = 0;
          continue;
          if (str.equals("startRecord"))
          {
            i = 1;
            continue;
            if (str.equals("stopRecord")) {
              i = 2;
            }
          }
        }
        break;
      }
    }
    ((d)localObject).setQuality(this.gbZ.optString("quality", "high"));
    ((d)localObject).aiF();
    return;
    ((d)localObject).startRecord();
    return;
    ((d)localObject).aiN();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.camera.j.1
 * JD-Core Version:    0.7.0.1
 */