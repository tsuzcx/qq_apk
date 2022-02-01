package com.tencent.mm.plugin.appbrand.jsapi.file;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appstorage.m;
import com.tencent.mm.plugin.appbrand.appstorage.q;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import org.json.JSONObject;

final class aw
  extends g
{
  final i.a a(f paramf, String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(128907);
    if (paramf.getFileSystem().Vj(paramString) == m.kSu) {}
    for (paramf = "ok";; paramf = String.format("fail no such file or directory \"%s\"", new Object[] { paramString }))
    {
      paramf = new i.a(paramf, new Object[0]);
      AppMethodBeat.o(128907);
      return paramf;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.file.aw
 * JD-Core Version:    0.7.0.1
 */