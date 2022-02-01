package com.tencent.mm.plugin.appbrand.jsapi.media;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appstorage.p;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.vfs.e;
import com.tencent.mm.vfs.q;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class k
  extends a
{
  private static final int CTRL_INDEX = 732;
  public static final String NAME = "getVideoInfo";
  
  public final void a(c paramc, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(46575);
    if (paramc == null)
    {
      ad.e("MicroMsg.JsApiGetVideoInfo", "fail:internal error");
      AppMethodBeat.o(46575);
      return;
    }
    if (paramJSONObject == null)
    {
      ad.w("MicroMsg.JsApiGetVideoInfo", "fail:data is null");
      paramc.h(paramInt, e("fail:invalid data", null));
      AppMethodBeat.o(46575);
      return;
    }
    if (paramc.Fg() == null)
    {
      ad.w("MicroMsg.JsApiGetVideoInfo", "fail:file system is null");
      paramc.h(paramInt, e("fail:internal error", null));
      AppMethodBeat.o(46575);
      return;
    }
    paramJSONObject = paramJSONObject.optString("src");
    if (bt.isNullOrNil(paramJSONObject))
    {
      ad.w("MicroMsg.JsApiGetVideoInfo", "fail:data src is null");
      paramc.h(paramInt, e("fail:invalid data", null));
      AppMethodBeat.o(46575);
      return;
    }
    if (!paramJSONObject.startsWith("wxfile://"))
    {
      ad.w("MicroMsg.JsApiGetVideoInfo", "fail:src path not supported");
      paramc.h(paramInt, e("fail:src path not be supported", null));
      AppMethodBeat.o(46575);
      return;
    }
    paramJSONObject = paramc.Fg().Mj(paramJSONObject);
    if (paramJSONObject == null)
    {
      paramc.h(paramInt, e("fail:file doesn't exist", null));
      AppMethodBeat.o(46575);
      return;
    }
    t.b localb = t.Qe(q.B(paramJSONObject.fOK()));
    if (localb == null)
    {
      ad.w("MicroMsg.JsApiGetVideoInfo", "fail:videoInfo is null");
      paramc.h(paramInt, e("fail:can't get info from video file", null));
      AppMethodBeat.o(46575);
      return;
    }
    switch (localb.rotation)
    {
    default: 
      paramJSONObject = "up";
    }
    for (;;)
    {
      HashMap localHashMap = new HashMap(8);
      localHashMap.put("orientation", paramJSONObject);
      localHashMap.put("type", localb.type);
      localHashMap.put("duration", Float.valueOf(bt.aRh(new DecimalFormat("#.#").format(localb.duration * 1.0F / 1000.0F))));
      localHashMap.put("size", Integer.valueOf(Math.round((float)localb.size * 1.0F / 1024.0F)));
      localHashMap.put("height", Integer.valueOf(localb.height));
      localHashMap.put("width", Integer.valueOf(localb.width));
      localHashMap.put("bitrate", Integer.valueOf(Math.round(localb.bitrate * 1.0F / 1000.0F)));
      localHashMap.put("fps", Float.valueOf(localb.cvL));
      paramc.h(paramInt, m("ok", localHashMap));
      AppMethodBeat.o(46575);
      return;
      paramJSONObject = "right";
      continue;
      paramJSONObject = "down";
      continue;
      paramJSONObject = "left";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.media.k
 * JD-Core Version:    0.7.0.1
 */