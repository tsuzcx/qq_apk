package com.tencent.mm.plugin.appbrand.jsapi.file;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appstorage.j;
import com.tencent.mm.plugin.appbrand.appstorage.o;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import org.json.JSONObject;

final class ar
  extends f
{
  final h.a a(c paramc, String paramString, JSONObject paramJSONObject)
  {
    boolean bool = true;
    AppMethodBeat.i(102821);
    paramc = paramc.wX().ze(paramString);
    switch (ar.1.hMg[paramc.ordinal()])
    {
    default: 
      paramc = new h.a("fail " + paramc.name(), new Object[0]);
      AppMethodBeat.o(102821);
      return paramc;
    case 1: 
      paramc = new h.a("fail no such file or directory \"%s\"", new Object[] { paramString });
      AppMethodBeat.o(102821);
      return paramc;
    }
    paramString = new h.a("ok", new Object[0]);
    if (paramc == j.gZA) {}
    for (;;)
    {
      paramc = paramString.n("result", Boolean.valueOf(bool));
      AppMethodBeat.o(102821);
      return paramc;
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.file.ar
 * JD-Core Version:    0.7.0.1
 */