package com.tencent.mm.plugin.appbrand.jsapi.t.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appstorage.o;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.vfs.j;
import org.json.JSONObject;

public final class g
  extends b
{
  public static final int CTRL_INDEX = 295;
  public static final String NAME = "operateRecorder";
  com.tencent.mm.plugin.appbrand.e.c ifl;
  
  public final void c(c paramc, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(145958);
    e locale = (e)paramc.q(e.class);
    if (locale == null)
    {
      ab.e("MicroMsg.JsApiOperateRecorder", "luggageRecorder is null, return");
      paramc.h(paramInt, j("fail:internal error", null));
      AppMethodBeat.o(145958);
      return;
    }
    if (this.ifl == null)
    {
      localObject1 = paramc.getAppId();
      this.ifl = new g.1(this, locale, (String)localObject1);
      com.tencent.mm.plugin.appbrand.e.a((String)localObject1, this.ifl);
    }
    Object localObject1 = paramJSONObject.optString("operationType");
    if ((localObject1 == null) || (((String)localObject1).length() <= 0))
    {
      ab.e("MicroMsg.JsApiOperateRecorder", "operateType is null, return");
      paramc.h(paramInt, j("fail:invalid data", null));
      AppMethodBeat.o(145958);
      return;
    }
    String str = paramc.getAppId();
    int i = -1;
    switch (((String)localObject1).hashCode())
    {
    default: 
      switch (i)
      {
      default: 
        localObject1 = null;
      }
      break;
    }
    for (;;)
    {
      if (localObject1 != null) {
        break label634;
      }
      ab.e("MicroMsg.JsApiOperateRecorder", "result is null, return");
      paramc.h(paramInt, j("fail:internal error", null));
      AppMethodBeat.o(145958);
      return;
      if (!((String)localObject1).equals("start")) {
        break;
      }
      i = 0;
      break;
      if (!((String)localObject1).equals("resume")) {
        break;
      }
      i = 1;
      break;
      if (!((String)localObject1).equals("pause")) {
        break;
      }
      i = 2;
      break;
      if (!((String)localObject1).equals("stop")) {
        break;
      }
      i = 3;
      break;
      Object localObject2 = locale.CV(str);
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = new g.2(this, paramc);
      }
      localObject2 = new e.d();
      ((e.d)localObject2).duration = paramJSONObject.optInt("duration");
      ((e.d)localObject2).sampleRate = paramJSONObject.optInt("sampleRate");
      ((e.d)localObject2).ifH = paramJSONObject.optInt("numberOfChannels");
      ((e.d)localObject2).ifJ = paramJSONObject.optInt("encodeBitRate");
      ((e.d)localObject2).ifI = paramJSONObject.optString("format");
      ((e.d)localObject2).ifK = paramJSONObject.optDouble("frameSize");
      ((e.d)localObject2).ifL = e.a.a(paramJSONObject.optString("audioSource"), e.a.ify);
      com.tencent.mm.vfs.b localb = paramc.wX().zh("voice_" + System.currentTimeMillis() + "." + ((e.d)localObject2).ifI);
      if (localb == null)
      {
        ab.e("MicroMsg.JsApiOperateRecorder", "toTempFilePath, alloc file failed");
        paramc.h(paramInt, j("fail alloc file failed", null));
        AppMethodBeat.o(145958);
        return;
      }
      ((e.d)localObject2).filePath = j.p(localb.dQJ());
      locale.a(str, (e.c)localObject1);
      localObject2 = locale.a((e.d)localObject2);
      localObject1 = localObject2;
      if (!((com.tencent.mm.plugin.appbrand.jsapi.t.g)localObject2).isSuccess())
      {
        locale.CW(str);
        localObject1 = localObject2;
        continue;
        localObject1 = locale.aGf();
        continue;
        localObject1 = locale.aGd();
        continue;
        localObject1 = locale.aGg();
        locale.CW(str);
      }
    }
    label634:
    ab.i("MicroMsg.JsApiOperateRecorder", "data:%s result:%s", new Object[] { paramJSONObject, localObject1 });
    if (((com.tencent.mm.plugin.appbrand.jsapi.t.g)localObject1).isSuccess())
    {
      paramc.h(paramInt, j("ok", null));
      AppMethodBeat.o(145958);
      return;
    }
    paramc.h(paramInt, j("fail:" + ((com.tencent.mm.plugin.appbrand.jsapi.t.g)localObject1).errMsg, null));
    AppMethodBeat.o(145958);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.t.a.g
 * JD-Core Version:    0.7.0.1
 */