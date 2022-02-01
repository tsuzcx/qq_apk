package com.tencent.mm.plugin.appbrand.jsapi.file;

import com.tencent.luggage.k.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ac.i;
import com.tencent.mm.plugin.appbrand.appstorage.m;
import com.tencent.mm.plugin.appbrand.appstorage.r;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.nio.ByteBuffer;
import java.util.Map;
import org.json.JSONObject;

final class be
  extends g
{
  final i.a a(e parame, String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(128919);
    Object localObject = paramJSONObject.optString("encoding");
    Log.i("MicroMsg.AppBrand.UnitReadFile", "call, path %s, encoding %s", new Object[] { paramString, localObject });
    if (Util.isNullOrNil((String)localObject)) {
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
        parame = parame.getFileSystem().a(paramString, l1, l2, paramJSONObject);
        if (parame != m.nMR) {
          break label279;
        }
        if (localObject != null) {
          break label261;
        }
      }
      for (parame = (Comparable)paramJSONObject.value;; parame = ((h)localObject).k((ByteBuffer)paramJSONObject.value))
      {
        if (!(parame instanceof ByteBuffer)) {
          a.f((ByteBuffer)paramJSONObject.value);
        }
        parame = new i.a("ok", new Object[0]).p("data", parame);
        AppMethodBeat.o(128919);
        return parame;
        localObject = (h)h.a.oRM.get(((String)localObject).toLowerCase());
        if (localObject != null) {
          break label475;
        }
        parame = new i.a("fail invalid encoding", new Object[0]);
        AppMethodBeat.o(128919);
        return parame;
        parame = parame.getFileSystem().b(paramString, paramJSONObject);
        break;
      }
      switch (1.oSw[parame.ordinal()])
      {
      default: 
        parame = new i.a("fail " + parame.name(), new Object[0]);
        AppMethodBeat.o(128919);
        return parame;
      case 1: 
        parame = new i.a("fail no such file \"%s\"", new Object[] { paramString });
        AppMethodBeat.o(128919);
        return parame;
      case 2: 
        parame = new i.a("fail permission denied, open \"%s\"", new Object[] { paramString });
        AppMethodBeat.o(128919);
        return parame;
      case 3: 
        parame = new i.a("fail \"%s\" is not a regular file", new Object[] { paramString });
        AppMethodBeat.o(128919);
        return parame;
      case 4: 
        parame = new i.a("fail the value of \"position\" is out of range", new Object[0]);
        AppMethodBeat.o(128919);
        return parame;
      }
      parame = new i.a("fail the value of \"length\" is out of range", new Object[0]);
      AppMethodBeat.o(128919);
      return parame;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.file.be
 * JD-Core Version:    0.7.0.1
 */