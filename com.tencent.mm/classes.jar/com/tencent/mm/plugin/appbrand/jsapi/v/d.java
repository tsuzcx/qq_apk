package com.tencent.mm.plugin.appbrand.jsapi.v;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.game.g.b.5;
import com.tencent.mm.plugin.appbrand.game.g.b.6;
import com.tencent.mm.plugin.appbrand.game.g.b.7;
import com.tencent.mm.plugin.appbrand.game.g.b.8;
import com.tencent.mm.plugin.appbrand.jsapi.file.at;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.plugin.appbrand.p;
import com.tencent.mm.plugin.appbrand.service.c;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.vfs.k;
import com.tencent.mm.vfs.w;
import org.json.JSONException;
import org.json.JSONObject;

public final class d
  extends b
{
  public static final int CTRL_INDEX = 687;
  public static final String NAME = "operateMediaTrack";
  
  public final void a(final c paramc, JSONObject paramJSONObject, final int paramInt)
  {
    AppMethodBeat.i(46760);
    ae.i("MicroMsg.GameRecord.JsApiScreenRecorderOperateMediaTrack", "hy: %s %s", new Object[] { "operateMediaTrack", paramJSONObject.toString() });
    Object localObject1 = paramJSONObject.optString("operationType");
    Object localObject2;
    if (((String)localObject1).equalsIgnoreCase("get"))
    {
      localObject1 = paramJSONObject.optString("source");
      if (bu.isNullOrNil((String)localObject1))
      {
        paramc.h(paramInt, e(String.format("fail: parmas error %s", new Object[] { paramJSONObject.toString() }), null));
        AppMethodBeat.o(46760);
        return;
      }
      try
      {
        paramJSONObject.put("filePath", w.B(paramc.getRuntime().Fd().MP((String)localObject1).fTh()));
        localObject1 = com.tencent.mm.plugin.appbrand.game.g.b.a("1234", null);
        localObject2 = new com.tencent.mm.plugin.appbrand.game.g.d() {};
        ((com.tencent.mm.plugin.appbrand.game.g.b)localObject1).krf.postToWorker(new b.5((com.tencent.mm.plugin.appbrand.game.g.b)localObject1, paramJSONObject, (com.tencent.mm.plugin.appbrand.game.g.d)localObject2));
        AppMethodBeat.o(46760);
        return;
      }
      catch (JSONException paramJSONObject)
      {
        paramc.h(paramInt, e(String.format("fail: error %s", new Object[] { paramJSONObject.getMessage() }), null));
        AppMethodBeat.o(46760);
        return;
      }
      catch (Exception paramJSONObject)
      {
        paramc.h(paramInt, e(String.format("fail: error %s", new Object[] { paramJSONObject.getMessage() }), null));
        AppMethodBeat.o(46760);
        return;
      }
    }
    if (((String)localObject1).equalsIgnoreCase("create"))
    {
      localObject1 = com.tencent.mm.plugin.appbrand.game.g.b.a("1234", null);
      paramc = new com.tencent.mm.plugin.appbrand.game.g.d() {};
      ((com.tencent.mm.plugin.appbrand.game.g.b)localObject1).krf.postToWorker(new b.6((com.tencent.mm.plugin.appbrand.game.g.b)localObject1, paramJSONObject, paramc));
      AppMethodBeat.o(46760);
      return;
    }
    if (((String)localObject1).equalsIgnoreCase("update")) {
      try
      {
        localObject1 = com.tencent.mm.plugin.appbrand.game.g.b.a("1234", null);
        localObject2 = new com.tencent.mm.plugin.appbrand.game.g.d() {};
        ((com.tencent.mm.plugin.appbrand.game.g.b)localObject1).krf.postToWorker(new b.7((com.tencent.mm.plugin.appbrand.game.g.b)localObject1, paramJSONObject, (com.tencent.mm.plugin.appbrand.game.g.d)localObject2));
        AppMethodBeat.o(46760);
        return;
      }
      catch (Exception paramJSONObject)
      {
        paramc.h(paramInt, e(String.format("fail: error %s", new Object[] { paramJSONObject.getMessage() }), null));
        AppMethodBeat.o(46760);
        return;
      }
    }
    if (((String)localObject1).equalsIgnoreCase("remove"))
    {
      localObject1 = com.tencent.mm.plugin.appbrand.game.g.b.a("1234", null);
      paramc = new com.tencent.mm.plugin.appbrand.game.g.d() {};
      ((com.tencent.mm.plugin.appbrand.game.g.b)localObject1).krf.postToWorker(new b.8((com.tencent.mm.plugin.appbrand.game.g.b)localObject1, paramJSONObject, paramc));
      AppMethodBeat.o(46760);
      return;
    }
    ae.e("MicroMsg.GameRecord.JsApiScreenRecorderOperateMediaTrack", "hy: invalid operate type: %s", new Object[] { localObject1 });
    paramc.h(paramInt, e(String.format("fail: not valid operate type: %s", new Object[] { localObject1 }), null));
    AppMethodBeat.o(46760);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.v.d
 * JD-Core Version:    0.7.0.1
 */