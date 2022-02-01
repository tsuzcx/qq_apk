package com.tencent.mm.plugin.appbrand.jsapi.file;

import com.tencent.luggage.h.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appstorage.l;
import com.tencent.mm.plugin.appbrand.appstorage.p;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.z.i;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.nio.ByteBuffer;
import java.util.Map;
import org.json.JSONObject;

final class ba
  extends g
{
  final i.a a(c paramc, String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(128919);
    Object localObject = paramJSONObject.optString("encoding");
    ad.i("MicroMsg.AppBrand.UnitReadFile", "call, path %s, encoding %s", new Object[] { paramString, localObject });
    if (bt.isNullOrNil((String)localObject)) {
      localObject = null;
    }
    label261:
    label279:
    label475:
    for (;;)
    {
      long l1 = -9223372036854775808L;
      long l2 = -9223372036854775808L;
      if ((paramJSONObject.has("position")) || (paramJSONObject.has("length")))
      {
        l1 = paramJSONObject.optLong("position", 0L);
        l2 = paramJSONObject.optLong("length", 9223372036854775807L);
      }
      paramJSONObject = new i();
      if ((l1 != -9223372036854775808L) && (l2 != -9223372036854775808L))
      {
        paramc = paramc.Fg().a(paramString, l1, l2, paramJSONObject);
        if (paramc != l.jMv) {
          break label279;
        }
        if (localObject != null) {
          break label261;
        }
      }
      for (paramc = (Comparable)paramJSONObject.value;; paramc = ((h)localObject).n((ByteBuffer)paramJSONObject.value))
      {
        if (!(paramc instanceof ByteBuffer)) {
          a.i((ByteBuffer)paramJSONObject.value);
        }
        paramc = new i.a("ok", new Object[0]).q("data", paramc);
        AppMethodBeat.o(128919);
        return paramc;
        localObject = (h)h.a.kMz.get(((String)localObject).toLowerCase());
        if (localObject != null) {
          break label475;
        }
        paramc = new i.a("fail invalid encoding", new Object[0]);
        AppMethodBeat.o(128919);
        return paramc;
        paramc = paramc.Fg().b(paramString, paramJSONObject);
        break;
      }
      switch (1.kMS[paramc.ordinal()])
      {
      default: 
        paramc = new i.a("fail " + paramc.name(), new Object[0]);
        AppMethodBeat.o(128919);
        return paramc;
      case 1: 
        paramc = new i.a("fail no such file \"%s\"", new Object[] { paramString });
        AppMethodBeat.o(128919);
        return paramc;
      case 2: 
        paramc = new i.a("fail permission denied, open \"%s\"", new Object[] { paramString });
        AppMethodBeat.o(128919);
        return paramc;
      case 3: 
        paramc = new i.a("fail \"%s\" is not a regular file", new Object[] { paramString });
        AppMethodBeat.o(128919);
        return paramc;
      case 4: 
        paramc = new i.a("fail the value of \"position\" is out of range", new Object[0]);
        AppMethodBeat.o(128919);
        return paramc;
      }
      paramc = new i.a("fail the value of \"length\" is out of range", new Object[0]);
      AppMethodBeat.o(128919);
      return paramc;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.file.ba
 * JD-Core Version:    0.7.0.1
 */