package com.tencent.mm.plugin.appbrand.jsapi.file;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appstorage.m;
import com.tencent.mm.plugin.appbrand.appstorage.r;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import org.json.JSONObject;

final class ay
  extends g
{
  final i.a a(e parame, String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(128907);
    if (parame.getFileSystem().acT(paramString) == m.nMR) {}
    for (parame = "ok";; parame = String.format("fail no such file or directory \"%s\"", new Object[] { paramString }))
    {
      parame = new i.a(parame, new Object[0]);
      AppMethodBeat.o(128907);
      return parame;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.file.ay
 * JD-Core Version:    0.7.0.1
 */