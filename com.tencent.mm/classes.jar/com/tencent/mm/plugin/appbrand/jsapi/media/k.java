package com.tencent.mm.plugin.appbrand.jsapi.media;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appstorage.r;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.plugin.appbrand.jsapi.o;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.q;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class k
  extends c
{
  private static final int CTRL_INDEX = 732;
  public static final String NAME = "getVideoInfo";
  
  public final void a(e parame, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(46575);
    if (parame == null)
    {
      Log.e("MicroMsg.JsApiGetVideoInfo", "fail:internal error");
      AppMethodBeat.o(46575);
      return;
    }
    if (paramJSONObject == null)
    {
      Log.w("MicroMsg.JsApiGetVideoInfo", "fail:data is null");
      parame.j(paramInt, h("fail:invalid data", null));
      AppMethodBeat.o(46575);
      return;
    }
    if (parame.getFileSystem() == null)
    {
      Log.w("MicroMsg.JsApiGetVideoInfo", "fail:file system is null");
      parame.j(paramInt, h("fail:internal error", null));
      AppMethodBeat.o(46575);
      return;
    }
    paramJSONObject = paramJSONObject.optString("src");
    if (Util.isNullOrNil(paramJSONObject))
    {
      Log.w("MicroMsg.JsApiGetVideoInfo", "fail:data src is null");
      parame.j(paramInt, h("fail:invalid data", null));
      AppMethodBeat.o(46575);
      return;
    }
    if (!paramJSONObject.startsWith("wxfile://"))
    {
      Log.w("MicroMsg.JsApiGetVideoInfo", "fail:src path not supported");
      parame.j(paramInt, h("fail:src path not be supported", null));
      AppMethodBeat.o(46575);
      return;
    }
    paramJSONObject = parame.getFileSystem().adL(paramJSONObject);
    if (paramJSONObject == null)
    {
      parame.j(paramInt, h("fail:file doesn't exist", null));
      AppMethodBeat.o(46575);
      return;
    }
    t.b localb = t.aif(paramJSONObject.bOF());
    if (localb == null)
    {
      Log.w("MicroMsg.JsApiGetVideoInfo", "fail:videoInfo is null");
      parame.j(paramInt, h("fail:can't get info from video file", null));
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
      localHashMap.put("duration", Float.valueOf(Util.safeParseFloat(new DecimalFormat("#.#").format(localb.duration * 1.0F / 1000.0F))));
      localHashMap.put("size", Integer.valueOf(Math.round((float)localb.size * 1.0F / 1024.0F)));
      localHashMap.put("height", Integer.valueOf(localb.height));
      localHashMap.put("width", Integer.valueOf(localb.width));
      localHashMap.put("bitrate", Integer.valueOf(Math.round(localb.bitrate * 1.0F / 1000.0F)));
      localHashMap.put("fps", Float.valueOf(localb.cLa));
      parame.j(paramInt, m("ok", localHashMap));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.media.k
 * JD-Core Version:    0.7.0.1
 */