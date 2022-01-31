package com.tencent.mm.plugin.appbrand.jsapi.file;

import com.tencent.luggage.g.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appstorage.o;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.nio.ByteBuffer;
import java.util.Map;
import org.json.JSONObject;

final class au
  extends f
{
  final h.a a(c paramc, String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(102827);
    paramJSONObject = paramJSONObject.optString("encoding");
    ab.i("MicroMsg.AppBrand.UnitReadFile", "call, path %s, encoding %s", new Object[] { paramString, paramJSONObject });
    if (bo.isNullOrNil(paramJSONObject)) {
      paramJSONObject = null;
    }
    for (;;)
    {
      com.tencent.mm.plugin.appbrand.s.j localj = new com.tencent.mm.plugin.appbrand.s.j();
      paramc = paramc.wX().b(paramString, localj);
      if (paramc == com.tencent.mm.plugin.appbrand.appstorage.j.gZA)
      {
        if (paramJSONObject == null) {}
        for (paramc = (Comparable)localj.value;; paramc = paramJSONObject.k((ByteBuffer)localj.value))
        {
          if (!(paramc instanceof ByteBuffer)) {
            a.f((ByteBuffer)localj.value);
          }
          paramc = new h.a("ok", new Object[0]).n("data", paramc);
          AppMethodBeat.o(102827);
          return paramc;
          paramJSONObject = (g)g.a.hLT.get(paramJSONObject.toLowerCase());
          if (paramJSONObject != null) {
            break;
          }
          paramc = new h.a("fail invalid encoding", new Object[0]);
          AppMethodBeat.o(102827);
          return paramc;
        }
      }
      switch (au.1.hMg[paramc.ordinal()])
      {
      default: 
        paramc = new h.a("fail " + paramc.name(), new Object[0]);
        AppMethodBeat.o(102827);
        return paramc;
      case 1: 
        paramc = new h.a("fail no such file \"%s\"", new Object[] { paramString });
        AppMethodBeat.o(102827);
        return paramc;
      case 2: 
        paramc = new h.a("fail permission denied, open \"%s\"", new Object[] { paramString });
        AppMethodBeat.o(102827);
        return paramc;
      }
      paramc = new h.a("fail \"%s\" is not a regular file", new Object[] { paramString });
      AppMethodBeat.o(102827);
      return paramc;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.file.au
 * JD-Core Version:    0.7.0.1
 */