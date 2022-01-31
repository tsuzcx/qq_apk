package com.tencent.mm.plugin.appbrand.jsapi.t.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appstorage.o;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.plugin.appbrand.jsapi.t.g;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.vfs.j;
import org.json.JSONObject;

public final class h
  extends b
{
  public static final int CTRL_INDEX = 31;
  public static final String NAME = "startRecord";
  com.tencent.mm.plugin.appbrand.e.c ifl;
  
  public final void c(c paramc, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(145963);
    e locale = (e)paramc.q(e.class);
    if (locale == null)
    {
      ab.e("MicroMsg.JsApiStartRecordVoice", "luggageRecorder is null, return");
      paramc.h(paramInt, j("fail:internal error", null));
      AppMethodBeat.o(145963);
      return;
    }
    Object localObject = paramc.wX().zh("voice_" + System.currentTimeMillis() + ".pcm");
    if (localObject == null)
    {
      ab.e("MicroMsg.JsApiStartRecordVoice", "toTempFilePath, alloc file failed");
      paramc.h(paramInt, j("fail alloc file failed", null));
      AppMethodBeat.o(145963);
      return;
    }
    e.d locald = new e.d();
    locald.filePath = j.p(((com.tencent.mm.vfs.b)localObject).dQJ());
    if (paramJSONObject.has("duration"))
    {
      locald.duration = paramJSONObject.optInt("duration");
      if (locald.duration <= 0)
      {
        ab.w("MicroMsg.JsApiStartRecordVoice", "duration is invalid, less than 0");
        locald.duration = 60000;
      }
      if (locald.duration > 600000)
      {
        ab.w("MicroMsg.JsApiStartRecordVoice", "duration is invalid, more than %d", new Object[] { Integer.valueOf(600000) });
        locald.duration = 600000;
      }
    }
    if (this.ifl == null)
    {
      localObject = paramc.getAppId();
      this.ifl = new h.1(this, locale, (String)localObject);
      com.tencent.mm.plugin.appbrand.e.a((String)localObject, this.ifl);
    }
    String str = paramc.getAppId();
    e.c localc = locale.CV(str);
    localObject = localc;
    if (localc == null) {
      localObject = new h.2(this, paramc, paramInt, locale, str);
    }
    locale.a(str, (e.c)localObject);
    localObject = locale.a(locald);
    ab.i("MicroMsg.JsApiStartRecordVoice", "startRecord data:%s result:%s", new Object[] { paramJSONObject, localObject });
    if ((localObject == null) || (!((g)localObject).isSuccess()))
    {
      ab.e("MicroMsg.JsApiStartRecordVoice", "startRecord fail");
      paramc.h(paramInt, j("fail:" + ((g)localObject).errMsg, null));
      locale.CW(str);
    }
    AppMethodBeat.o(145963);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.t.a.h
 * JD-Core Version:    0.7.0.1
 */