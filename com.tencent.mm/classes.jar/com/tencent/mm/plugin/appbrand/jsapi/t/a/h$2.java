package com.tencent.mm.plugin.appbrand.jsapi.t.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appstorage.o;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.sdk.platformtools.ab;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

final class h$2
  extends e.b
{
  h$2(h paramh, c paramc, int paramInt, e parame, String paramString) {}
  
  public final void S(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(145962);
    com.tencent.mm.plugin.appbrand.s.j localj = new com.tencent.mm.plugin.appbrand.s.j();
    if (this.hKB.wX().a(new File(paramString), h.cP(paramString), true, localj) == com.tencent.mm.plugin.appbrand.appstorage.j.gZA)
    {
      paramString = new HashMap();
      paramString.put("state", e.e.ifO.state);
      paramString.put("tempFilePath", localj.value);
      paramString.put("duration", Integer.valueOf(paramInt1));
      paramString.put("fileSize", Integer.valueOf(paramInt2));
      ab.i("MicroMsg.JsApiStartRecordVoice", "startRecord ok:%s", new Object[] { paramString });
      this.hKB.h(this.bAX, this.ifW.j("ok", paramString));
    }
    for (;;)
    {
      this.ifU.CW(this.val$appId);
      AppMethodBeat.o(145962);
      return;
      ab.e("MicroMsg.JsApiStartRecordVoice", "create file fail");
      this.hKB.h(this.bAX, this.ifW.j("fail:create file fail", null));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.t.a.h.2
 * JD-Core Version:    0.7.0.1
 */