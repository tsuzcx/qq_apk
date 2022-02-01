package com.tencent.mm.plugin.appbrand.jsapi.x;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.game.g.b.4;
import com.tencent.mm.plugin.appbrand.game.g.b.5;
import com.tencent.mm.plugin.appbrand.game.g.b.6;
import com.tencent.mm.plugin.appbrand.game.g.b.7;
import com.tencent.mm.plugin.appbrand.jsapi.file.at;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.plugin.appbrand.service.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.aa;
import com.tencent.mm.vfs.o;
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
    Log.i("MicroMsg.GameRecord.JsApiScreenRecorderOperateMediaTrack", "hy: %s %s", new Object[] { "operateMediaTrack", paramJSONObject.toString() });
    Object localObject1 = paramJSONObject.optString("operationType");
    Object localObject2;
    if (((String)localObject1).equalsIgnoreCase("get"))
    {
      localObject1 = paramJSONObject.optString("source");
      if (Util.isNullOrNil((String)localObject1))
      {
        paramc.i(paramInt, h(String.format("fail: parmas error %s", new Object[] { paramJSONObject.toString() }), null));
        AppMethodBeat.o(46760);
        return;
      }
      try
      {
        paramJSONObject.put("filePath", aa.z(paramc.getRuntime().OK().VY((String)localObject1).her()));
        localObject1 = d(paramc);
        localObject2 = new com.tencent.mm.plugin.appbrand.game.g.d() {};
        ((com.tencent.mm.plugin.appbrand.game.g.b)localObject1).luO.postToWorker(new b.4((com.tencent.mm.plugin.appbrand.game.g.b)localObject1, paramJSONObject, (com.tencent.mm.plugin.appbrand.game.g.d)localObject2));
        AppMethodBeat.o(46760);
        return;
      }
      catch (JSONException paramJSONObject)
      {
        paramc.i(paramInt, h(String.format("fail: error %s", new Object[] { paramJSONObject.getMessage() }), null));
        AppMethodBeat.o(46760);
        return;
      }
      catch (Exception paramJSONObject)
      {
        paramc.i(paramInt, h(String.format("fail: error %s", new Object[] { paramJSONObject.getMessage() }), null));
        AppMethodBeat.o(46760);
        return;
      }
    }
    if (((String)localObject1).equalsIgnoreCase("create"))
    {
      localObject1 = d(paramc);
      paramc = new com.tencent.mm.plugin.appbrand.game.g.d() {};
      ((com.tencent.mm.plugin.appbrand.game.g.b)localObject1).luO.postToWorker(new b.5((com.tencent.mm.plugin.appbrand.game.g.b)localObject1, paramJSONObject, paramc));
      AppMethodBeat.o(46760);
      return;
    }
    if (((String)localObject1).equalsIgnoreCase("update")) {
      try
      {
        localObject1 = d(paramc);
        localObject2 = new com.tencent.mm.plugin.appbrand.game.g.d() {};
        ((com.tencent.mm.plugin.appbrand.game.g.b)localObject1).luO.postToWorker(new b.6((com.tencent.mm.plugin.appbrand.game.g.b)localObject1, paramJSONObject, (com.tencent.mm.plugin.appbrand.game.g.d)localObject2));
        AppMethodBeat.o(46760);
        return;
      }
      catch (Exception paramJSONObject)
      {
        paramc.i(paramInt, h(String.format("fail: error %s", new Object[] { paramJSONObject.getMessage() }), null));
        AppMethodBeat.o(46760);
        return;
      }
    }
    if (((String)localObject1).equalsIgnoreCase("remove"))
    {
      localObject1 = d(paramc);
      paramc = new com.tencent.mm.plugin.appbrand.game.g.d() {};
      ((com.tencent.mm.plugin.appbrand.game.g.b)localObject1).luO.postToWorker(new b.7((com.tencent.mm.plugin.appbrand.game.g.b)localObject1, paramJSONObject, paramc));
      AppMethodBeat.o(46760);
      return;
    }
    Log.e("MicroMsg.GameRecord.JsApiScreenRecorderOperateMediaTrack", "hy: invalid operate type: %s", new Object[] { localObject1 });
    paramc.i(paramInt, h(String.format("fail: not valid operate type: %s", new Object[] { localObject1 }), null));
    AppMethodBeat.o(46760);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.x.d
 * JD-Core Version:    0.7.0.1
 */