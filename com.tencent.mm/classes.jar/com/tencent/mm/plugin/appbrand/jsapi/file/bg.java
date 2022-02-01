package com.tencent.mm.plugin.appbrand.jsapi.file;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appstorage.m;
import com.tencent.mm.plugin.appbrand.appstorage.q;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import org.json.JSONObject;

final class bg
  extends g
{
  final i.a a(f paramf, String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(128930);
    paramf = paramf.getFileSystem().VX(paramString);
    switch (1.lVs[paramf.ordinal()])
    {
    default: 
      paramf = new i.a("fail " + paramf.name(), new Object[0]);
      AppMethodBeat.o(128930);
      return paramf;
    case 1: 
      paramf = new i.a("fail permission denied, open \"%s\"", new Object[] { paramString });
      AppMethodBeat.o(128930);
      return paramf;
    case 2: 
      paramf = new i.a("fail no such file or directory \"%s\"", new Object[] { paramString });
      AppMethodBeat.o(128930);
      return paramf;
    case 3: 
      paramf = new i.a("fail operation not permitted, unlink \"%s\"", new Object[] { paramString });
      AppMethodBeat.o(128930);
      return paramf;
    }
    paramf = new i.a("ok", new Object[0]);
    AppMethodBeat.o(128930);
    return paramf;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.file.bg
 * JD-Core Version:    0.7.0.1
 */