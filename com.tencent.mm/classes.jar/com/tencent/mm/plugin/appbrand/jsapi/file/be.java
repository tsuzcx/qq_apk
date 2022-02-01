package com.tencent.mm.plugin.appbrand.jsapi.file;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appstorage.m;
import com.tencent.mm.plugin.appbrand.appstorage.q;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import org.json.JSONObject;

final class be
  extends g
{
  final i.a a(c paramc, String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(128924);
    boolean bool = paramJSONObject.optBoolean("recursive", false);
    paramc = paramc.Fl().ah(paramString, bool);
    switch (1.kQn[paramc.ordinal()])
    {
    default: 
      paramc = new i.a("fail " + paramc.name(), new Object[0]);
      AppMethodBeat.o(128924);
      return paramc;
    case 1: 
    case 2: 
      paramc = new i.a("fail no such file or directory \"%s\"", new Object[] { paramString });
      AppMethodBeat.o(128924);
      return paramc;
    case 3: 
      paramc = new i.a("fail directory not empty", new Object[0]);
      AppMethodBeat.o(128924);
      return paramc;
    case 4: 
      paramc = new i.a("fail permission denied, open \"%s\"", new Object[] { paramString });
      AppMethodBeat.o(128924);
      return paramc;
    }
    paramc = new i.a("ok", new Object[0]);
    AppMethodBeat.o(128924);
    return paramc;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.file.be
 * JD-Core Version:    0.7.0.1
 */