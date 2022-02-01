package com.tencent.mm.plugin.appbrand.jsapi.ac;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.game.g.b.3;
import com.tencent.mm.plugin.appbrand.game.g.b.8;
import com.tencent.mm.plugin.appbrand.game.g.b.9;
import com.tencent.mm.plugin.appbrand.game.g.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import org.json.JSONException;
import org.json.JSONObject;

public final class c
  extends b
{
  public static final int CTRL_INDEX = 686;
  public static final String NAME = "operateMediaContainer";
  
  public final void a(final com.tencent.mm.plugin.appbrand.service.c paramc, JSONObject paramJSONObject, final int paramInt)
  {
    AppMethodBeat.i(46755);
    Log.i("MicroMsg.GameRecord.JsApiScreenRecorderOperateMediaContainer", "hy: %s %s", new Object[] { "operateMediaContainer", paramJSONObject.toString() });
    Object localObject1 = paramJSONObject.optString("operationType");
    if (((String)localObject1).equalsIgnoreCase("create"))
    {
      localObject1 = e(paramc);
      paramc = new d() {};
      Log.i("MicroMsg.GameRecorderMgr", "hy: trigger createMediaContainer");
      ((com.tencent.mm.plugin.appbrand.game.g.b)localObject1).rtv.postToWorker(new b.3((com.tencent.mm.plugin.appbrand.game.g.b)localObject1, paramJSONObject, paramc));
      AppMethodBeat.o(46755);
      return;
    }
    if (((String)localObject1).equalsIgnoreCase("export"))
    {
      int i = paramJSONObject.optInt("containerId");
      localObject1 = paramJSONObject.optString("mimeType");
      if (Util.isNullOrNil((String)localObject1))
      {
        paramc.callback(paramInt, ZP(String.format("fail: parmas error %s", new Object[] { paramJSONObject.toString() })));
        AppMethodBeat.o(46755);
        return;
      }
      Object localObject2 = d(paramc, i + "." + (String)localObject1);
      if ((localObject2 == null) || (Util.isNullOrNil(((b.a)localObject2).rrh)) || (Util.isNullOrNil(((b.a)localObject2).rri)))
      {
        Log.e("MicroMsg.GameRecord.JsApiScreenRecorderOperateMediaContainer", "hy: %s, alloc file failed", new Object[] { "operateMediaContainer" });
        paramc.callback(paramInt, ZP(String.format("fail: internal create file failed", new Object[0])));
        AppMethodBeat.o(46755);
        return;
      }
      try
      {
        paramJSONObject.put("filePath", ((b.a)localObject2).rrh);
        localObject1 = e(paramc);
        localObject2 = new d() {};
        ((com.tencent.mm.plugin.appbrand.game.g.b)localObject1).rtv.postToWorker(new b.8((com.tencent.mm.plugin.appbrand.game.g.b)localObject1, paramJSONObject, (d)localObject2));
        AppMethodBeat.o(46755);
        return;
      }
      catch (JSONException paramJSONObject)
      {
        paramc.callback(paramInt, ZP(String.format("fail: error %s", new Object[] { paramJSONObject.getMessage() })));
        AppMethodBeat.o(46755);
        return;
      }
      catch (Exception paramJSONObject)
      {
        paramc.callback(paramInt, ZP(String.format("fail: error %s", new Object[] { paramJSONObject.getMessage() })));
        AppMethodBeat.o(46755);
        return;
      }
    }
    if (((String)localObject1).equalsIgnoreCase("remove"))
    {
      localObject1 = e(paramc);
      paramc = new d() {};
      ((com.tencent.mm.plugin.appbrand.game.g.b)localObject1).rtv.postToWorker(new b.9((com.tencent.mm.plugin.appbrand.game.g.b)localObject1, paramJSONObject, paramc));
      AppMethodBeat.o(46755);
      return;
    }
    Log.e("MicroMsg.GameRecord.JsApiScreenRecorderOperateMediaContainer", "hy: invalid operate type: %s", new Object[] { localObject1 });
    paramc.callback(paramInt, ZP(String.format("fail: not valid operate type: %s", new Object[] { localObject1 })));
    AppMethodBeat.o(46755);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.ac.c
 * JD-Core Version:    0.7.0.1
 */