package com.tencent.mm.plugin.appbrand.jsapi.file;

import com.tencent.luggage.h.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ac.i;
import com.tencent.mm.plugin.appbrand.appstorage.m;
import com.tencent.mm.plugin.appbrand.appstorage.q;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.nio.ByteBuffer;
import java.util.Map;
import org.json.JSONObject;

final class bc
  extends g
{
  final i.a a(f paramf, String paramString, JSONObject paramJSONObject)
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
        paramf = paramf.getFileSystem().a(paramString, l1, l2, paramJSONObject);
        if (paramf != m.kSu) {
          break label279;
        }
        if (localObject != null) {
          break label261;
        }
      }
      for (paramf = (Comparable)paramJSONObject.value;; paramf = ((h)localObject).n((ByteBuffer)paramJSONObject.value))
      {
        if (!(paramf instanceof ByteBuffer)) {
          a.i((ByteBuffer)paramJSONObject.value);
        }
        paramf = new i.a("ok", new Object[0]).q("data", paramf);
        AppMethodBeat.o(128919);
        return paramf;
        localObject = (h)h.a.lUN.get(((String)localObject).toLowerCase());
        if (localObject != null) {
          break label475;
        }
        paramf = new i.a("fail invalid encoding", new Object[0]);
        AppMethodBeat.o(128919);
        return paramf;
        paramf = paramf.getFileSystem().b(paramString, paramJSONObject);
        break;
      }
      switch (1.lVs[paramf.ordinal()])
      {
      default: 
        paramf = new i.a("fail " + paramf.name(), new Object[0]);
        AppMethodBeat.o(128919);
        return paramf;
      case 1: 
        paramf = new i.a("fail no such file \"%s\"", new Object[] { paramString });
        AppMethodBeat.o(128919);
        return paramf;
      case 2: 
        paramf = new i.a("fail permission denied, open \"%s\"", new Object[] { paramString });
        AppMethodBeat.o(128919);
        return paramf;
      case 3: 
        paramf = new i.a("fail \"%s\" is not a regular file", new Object[] { paramString });
        AppMethodBeat.o(128919);
        return paramf;
      case 4: 
        paramf = new i.a("fail the value of \"position\" is out of range", new Object[0]);
        AppMethodBeat.o(128919);
        return paramf;
      }
      paramf = new i.a("fail the value of \"length\" is out of range", new Object[0]);
      AppMethodBeat.o(128919);
      return paramf;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.file.bc
 * JD-Core Version:    0.7.0.1
 */