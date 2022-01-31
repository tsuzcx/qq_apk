package com.tencent.mm.plugin.appbrand.jsapi.camera;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.HashMap;
import org.json.JSONObject;

final class l$1
  implements Runnable
{
  l$1(l paraml, JSONObject paramJSONObject, c paramc, int paramInt) {}
  
  public final void run()
  {
    AppMethodBeat.i(126251);
    int i = this.bBa.optInt("cameraId");
    String str = this.bBa.optString("type");
    ab.i("MicroMsg.JsApiOperateCamera", "cameraId=%d type=%s", new Object[] { Integer.valueOf(i), str });
    Object localObject = a.a.aCy();
    Integer localInteger = Integer.valueOf(i);
    if (((a)localObject).hIm.containsKey(localInteger)) {}
    for (localObject = (e)((a)localObject).hIm.get(localInteger); localObject == null; localObject = null)
    {
      this.hza.h(this.bAX, this.hJh.j("fail:no such camera", null));
      AppMethodBeat.o(126251);
      return;
    }
    ((e)localObject).setOperateCallBack(new l.1.1(this));
    i = -1;
    switch (str.hashCode())
    {
    }
    for (;;)
    {
      switch (i)
      {
      default: 
        ab.w("MicroMsg.JsApiOperateCamera", "operateType not supported: %s", new Object[] { str });
        this.hza.h(this.bAX, this.hJh.j("fail:operateType not supported", null));
        AppMethodBeat.o(126251);
        return;
        if (str.equals("takePhoto"))
        {
          i = 0;
          continue;
          if (str.equals("startRecord"))
          {
            i = 1;
            continue;
            if (str.equals("stopRecord"))
            {
              i = 2;
              continue;
              if (str.equals("listenFrameChange"))
              {
                i = 3;
                continue;
                if (str.equals("closeFrameChange")) {
                  i = 4;
                }
              }
            }
          }
        }
        break;
      }
    }
    ((e)localObject).setQuality(this.bBa.optString("quality", "high"));
    ((e)localObject).aCA();
    AppMethodBeat.o(126251);
    return;
    ((e)localObject).aCJ();
    AppMethodBeat.o(126251);
    return;
    ((e)localObject).setCompressRecord(this.bBa.optBoolean("compressed"));
    ((e)localObject).aCK();
    AppMethodBeat.o(126251);
    return;
    this.bBa.optString("size");
    ((e)localObject).p(this.hza);
    AppMethodBeat.o(126251);
    return;
    ((e)localObject).aCD();
    this.hza.h(this.bAX, this.hJh.j("ok", null));
    AppMethodBeat.o(126251);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.camera.l.1
 * JD-Core Version:    0.7.0.1
 */