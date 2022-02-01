package com.tencent.mm.plugin.appbrand.jsapi.file;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appstorage.m;
import com.tencent.mm.plugin.appbrand.appstorage.q;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import org.json.JSONObject;

final class aw
  extends g
{
  final i.a a(c paramc, String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(128907);
    if (paramc.Fl().Ma(paramString) == m.jPM) {}
    for (paramc = "ok";; paramc = String.format("fail no such file or directory \"%s\"", new Object[] { paramString }))
    {
      paramc = new i.a(paramc, new Object[0]);
      AppMethodBeat.o(128907);
      return paramc;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.file.aw
 * JD-Core Version:    0.7.0.1
 */