package com.tencent.mm.plugin.appbrand.jsapi.file;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appstorage.j;
import com.tencent.mm.plugin.appbrand.appstorage.o;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import org.json.JSONObject;

final class as
  extends f
{
  final h.a a(c paramc, String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(102823);
    boolean bool = paramJSONObject.optBoolean("recursive", false);
    paramc = paramc.wX().Y(paramString, bool);
    switch (1.hMg[paramc.ordinal()])
    {
    default: 
      paramc = new h.a("fail " + paramc.name(), new Object[0]);
      AppMethodBeat.o(102823);
      return paramc;
    case 1: 
      paramc = new h.a("fail no such file or directory \"%s\"", new Object[] { paramString });
      AppMethodBeat.o(102823);
      return paramc;
    case 2: 
      paramc = new h.a("fail permission denied, open \"%s\"", new Object[] { paramString });
      AppMethodBeat.o(102823);
      return paramc;
    case 3: 
      paramc = new h.a("fail file already exists \"%s\"", new Object[] { paramString });
      AppMethodBeat.o(102823);
      return paramc;
    }
    paramc = new h.a("ok", new Object[0]);
    AppMethodBeat.o(102823);
    return paramc;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.file.as
 * JD-Core Version:    0.7.0.1
 */