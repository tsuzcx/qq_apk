package com.tencent.mm.plugin.appbrand.jsapi.file;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appstorage.l;
import com.tencent.mm.plugin.appbrand.appstorage.p;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import org.json.JSONObject;

final class au
  extends g
{
  final i.a a(c paramc, String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(128907);
    if (paramc.Ee().Ec(paramString) == l.iSq) {}
    for (paramc = "ok";; paramc = String.format("fail no such file or directory \"%s\"", new Object[] { paramString }))
    {
      paramc = new i.a(paramc, new Object[0]);
      AppMethodBeat.o(128907);
      return paramc;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.file.au
 * JD-Core Version:    0.7.0.1
 */