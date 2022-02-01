package com.tencent.mm.plugin.appbrand.jsapi.v;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.game.g.b.10;
import com.tencent.mm.plugin.appbrand.game.g.b.4;
import com.tencent.mm.plugin.appbrand.game.g.b.9;
import com.tencent.mm.plugin.appbrand.game.g.d;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bt;
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
    ad.i("MicroMsg.GameRecord.JsApiScreenRecorderOperateMediaContainer", "hy: %s %s", new Object[] { "operateMediaContainer", paramJSONObject.toString() });
    Object localObject1 = paramJSONObject.optString("operationType");
    if (((String)localObject1).equalsIgnoreCase("create"))
    {
      localObject1 = com.tencent.mm.plugin.appbrand.game.g.b.a("1234", null);
      paramc = new d() {};
      ad.i("MicroMsg.GameRecorderMgr", "hy: trigger createMediaContainer");
      ((com.tencent.mm.plugin.appbrand.game.g.b)localObject1).knP.postToWorker(new b.4((com.tencent.mm.plugin.appbrand.game.g.b)localObject1, paramJSONObject, paramc));
      AppMethodBeat.o(46755);
      return;
    }
    if (((String)localObject1).equalsIgnoreCase("export"))
    {
      int i = paramJSONObject.optInt("containerId");
      localObject1 = paramJSONObject.optString("mimeType");
      if (bt.isNullOrNil((String)localObject1))
      {
        paramc.h(paramInt, e(String.format("fail: parmas error %s", new Object[] { paramJSONObject.toString() }), null));
        AppMethodBeat.o(46755);
        return;
      }
      Object localObject2 = c(paramc, i + "." + (String)localObject1);
      if ((localObject2 == null) || (bt.isNullOrNil(((b.a)localObject2).klC)) || (bt.isNullOrNil(((b.a)localObject2).klD)))
      {
        ad.e("MicroMsg.GameRecord.JsApiScreenRecorderOperateMediaContainer", "hy: %s, alloc file failed", new Object[] { "operateMediaContainer" });
        paramc.h(paramInt, e(String.format("fail: internal create file failed", new Object[0]), null));
        AppMethodBeat.o(46755);
        return;
      }
      try
      {
        paramJSONObject.put("filePath", ((b.a)localObject2).klC);
        localObject1 = com.tencent.mm.plugin.appbrand.game.g.b.a("1234", null);
        localObject2 = new d() {};
        ((com.tencent.mm.plugin.appbrand.game.g.b)localObject1).knP.postToWorker(new b.9((com.tencent.mm.plugin.appbrand.game.g.b)localObject1, paramJSONObject, (d)localObject2));
        AppMethodBeat.o(46755);
        return;
      }
      catch (JSONException paramJSONObject)
      {
        paramc.h(paramInt, e(String.format("fail: error %s", new Object[] { paramJSONObject.getMessage() }), null));
        AppMethodBeat.o(46755);
        return;
      }
      catch (Exception paramJSONObject)
      {
        paramc.h(paramInt, e(String.format("fail: error %s", new Object[] { paramJSONObject.getMessage() }), null));
        AppMethodBeat.o(46755);
        return;
      }
    }
    if (((String)localObject1).equalsIgnoreCase("remove"))
    {
      localObject1 = com.tencent.mm.plugin.appbrand.game.g.b.a("1234", null);
      paramc = new d() {};
      ((com.tencent.mm.plugin.appbrand.game.g.b)localObject1).knP.postToWorker(new b.10((com.tencent.mm.plugin.appbrand.game.g.b)localObject1, paramJSONObject, paramc));
      AppMethodBeat.o(46755);
      return;
    }
    ad.e("MicroMsg.GameRecord.JsApiScreenRecorderOperateMediaContainer", "hy: invalid operate type: %s", new Object[] { localObject1 });
    paramc.h(paramInt, e(String.format("fail: not valid operate type: %s", new Object[] { localObject1 }), null));
    AppMethodBeat.o(46755);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.v.c
 * JD-Core Version:    0.7.0.1
 */