package com.tencent.mm.plugin.appbrand.jsapi.v;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.game.g.b.5;
import com.tencent.mm.plugin.appbrand.game.g.b.6;
import com.tencent.mm.plugin.appbrand.game.g.b.7;
import com.tencent.mm.plugin.appbrand.game.g.b.8;
import com.tencent.mm.plugin.appbrand.jsapi.file.ar;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.plugin.appbrand.o;
import com.tencent.mm.plugin.appbrand.service.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.vfs.e;
import com.tencent.mm.vfs.q;
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
    ad.i("MicroMsg.GameRecord.JsApiScreenRecorderOperateMediaTrack", "hy: %s %s", new Object[] { "operateMediaTrack", paramJSONObject.toString() });
    Object localObject1 = paramJSONObject.optString("operationType");
    Object localObject2;
    if (((String)localObject1).equalsIgnoreCase("get"))
    {
      localObject1 = paramJSONObject.optString("source");
      if (bt.isNullOrNil((String)localObject1))
      {
        paramc.h(paramInt, e(String.format("fail: parmas error %s", new Object[] { paramJSONObject.toString() }), null));
        AppMethodBeat.o(46760);
        return;
      }
      try
      {
        paramJSONObject.put("filePath", q.B(paramc.getRuntime().EY().Mj((String)localObject1).fOK()));
        localObject1 = com.tencent.mm.plugin.appbrand.game.g.b.a("1234", null);
        localObject2 = new com.tencent.mm.plugin.appbrand.game.g.d() {};
        ((com.tencent.mm.plugin.appbrand.game.g.b)localObject1).knP.postToWorker(new b.5((com.tencent.mm.plugin.appbrand.game.g.b)localObject1, paramJSONObject, (com.tencent.mm.plugin.appbrand.game.g.d)localObject2));
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
      ((com.tencent.mm.plugin.appbrand.game.g.b)localObject1).knP.postToWorker(new b.6((com.tencent.mm.plugin.appbrand.game.g.b)localObject1, paramJSONObject, paramc));
      AppMethodBeat.o(46760);
      return;
    }
    if (((String)localObject1).equalsIgnoreCase("update")) {
      try
      {
        localObject1 = com.tencent.mm.plugin.appbrand.game.g.b.a("1234", null);
        localObject2 = new com.tencent.mm.plugin.appbrand.game.g.d() {};
        ((com.tencent.mm.plugin.appbrand.game.g.b)localObject1).knP.postToWorker(new b.7((com.tencent.mm.plugin.appbrand.game.g.b)localObject1, paramJSONObject, (com.tencent.mm.plugin.appbrand.game.g.d)localObject2));
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
      ((com.tencent.mm.plugin.appbrand.game.g.b)localObject1).knP.postToWorker(new b.8((com.tencent.mm.plugin.appbrand.game.g.b)localObject1, paramJSONObject, paramc));
      AppMethodBeat.o(46760);
      return;
    }
    ad.e("MicroMsg.GameRecord.JsApiScreenRecorderOperateMediaTrack", "hy: invalid operate type: %s", new Object[] { localObject1 });
    paramc.h(paramInt, e(String.format("fail: not valid operate type: %s", new Object[] { localObject1 }), null));
    AppMethodBeat.o(46760);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.v.d
 * JD-Core Version:    0.7.0.1
 */