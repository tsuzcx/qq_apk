package com.tencent.mm.plugin.appbrand.jsapi.file;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appstorage.m;
import com.tencent.mm.plugin.appbrand.appstorage.q;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import org.json.JSONObject;

final class bg
  extends g
{
  final i.a a(c paramc, String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(128930);
    paramc = paramc.Fl().MO(paramString);
    switch (1.kQn[paramc.ordinal()])
    {
    default: 
      paramc = new i.a("fail " + paramc.name(), new Object[0]);
      AppMethodBeat.o(128930);
      return paramc;
    case 1: 
      paramc = new i.a("fail permission denied, open \"%s\"", new Object[] { paramString });
      AppMethodBeat.o(128930);
      return paramc;
    case 2: 
      paramc = new i.a("fail no such file or directory \"%s\"", new Object[] { paramString });
      AppMethodBeat.o(128930);
      return paramc;
    case 3: 
      paramc = new i.a("fail operation not permitted, unlink \"%s\"", new Object[] { paramString });
      AppMethodBeat.o(128930);
      return paramc;
    }
    paramc = new i.a("ok", new Object[0]);
    AppMethodBeat.o(128930);
    return paramc;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.file.bg
 * JD-Core Version:    0.7.0.1
 */