package com.tencent.mm.plugin.appbrand.jsapi.file;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appstorage.r;
import com.tencent.mm.plugin.appbrand.appstorage.w;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import org.json.JSONObject;

final class ba
  extends g
{
  final i.a a(f paramf, String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(128907);
    if (paramf.getFileSystem().Vr(paramString) == r.qML) {}
    for (paramf = "ok";; paramf = String.format("fail no such file or directory \"%s\"", new Object[] { paramString }))
    {
      paramf = new i.a(paramf, new Object[0]);
      AppMethodBeat.o(128907);
      return paramf;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.file.ba
 * JD-Core Version:    0.7.0.1
 */