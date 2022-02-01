package com.tencent.mm.plugin.appbrand.jsapi.file;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appstorage.l;
import com.tencent.mm.plugin.appbrand.appstorage.p;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import org.json.JSONObject;

final class be
  extends g
{
  final i.a a(c paramc, String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(128930);
    paramc = paramc.Fg().Mi(paramString);
    switch (1.kMS[paramc.ordinal()])
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.file.be
 * JD-Core Version:    0.7.0.1
 */