package com.tencent.mm.plugin.appbrand.jsapi.file;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appstorage.j;
import com.tencent.mm.plugin.appbrand.appstorage.o;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import org.json.JSONObject;

final class ao
  extends f
{
  final h.a a(c paramc, String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(102815);
    if (paramc.wX().zd(paramString) == j.gZA) {}
    for (paramc = "ok";; paramc = String.format("fail no such file or directory \"%s\"", new Object[] { paramString }))
    {
      paramc = new h.a(paramc, new Object[0]);
      AppMethodBeat.o(102815);
      return paramc;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.file.ao
 * JD-Core Version:    0.7.0.1
 */