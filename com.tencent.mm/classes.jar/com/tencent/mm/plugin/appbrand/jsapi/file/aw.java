package com.tencent.mm.plugin.appbrand.jsapi.file;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appstorage.j;
import com.tencent.mm.plugin.appbrand.appstorage.o;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import org.json.JSONObject;

final class aw
  extends f
{
  final h.a a(c paramc, String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(102832);
    boolean bool = paramJSONObject.optBoolean("recursive", false);
    paramc = paramc.wX().Z(paramString, bool);
    switch (aw.1.hMg[paramc.ordinal()])
    {
    default: 
      paramc = new h.a("fail " + paramc.name(), new Object[0]);
      AppMethodBeat.o(102832);
      return paramc;
    case 1: 
    case 2: 
      paramc = new h.a("fail no such file or directory \"%s\"", new Object[] { paramString });
      AppMethodBeat.o(102832);
      return paramc;
    case 3: 
      paramc = new h.a("fail directory not empty", new Object[0]);
      AppMethodBeat.o(102832);
      return paramc;
    case 4: 
      paramc = new h.a("fail permission denied, open \"%s\"", new Object[] { paramString });
      AppMethodBeat.o(102832);
      return paramc;
    }
    paramc = new h.a("ok", new Object[0]);
    AppMethodBeat.o(102832);
    return paramc;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.file.aw
 * JD-Core Version:    0.7.0.1
 */