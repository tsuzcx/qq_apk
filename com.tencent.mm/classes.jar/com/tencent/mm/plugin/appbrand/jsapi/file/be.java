package com.tencent.mm.plugin.appbrand.jsapi.file;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appstorage.m;
import com.tencent.mm.plugin.appbrand.appstorage.q;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import org.json.JSONObject;

final class be
  extends g
{
  final i.a a(f paramf, String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(128924);
    boolean bool = paramJSONObject.optBoolean("recursive", false);
    paramf = paramf.getFileSystem().aj(paramString, bool);
    switch (1.lVs[paramf.ordinal()])
    {
    default: 
      paramf = new i.a("fail " + paramf.name(), new Object[0]);
      AppMethodBeat.o(128924);
      return paramf;
    case 1: 
    case 2: 
      paramf = new i.a("fail no such file or directory \"%s\"", new Object[] { paramString });
      AppMethodBeat.o(128924);
      return paramf;
    case 3: 
      paramf = new i.a("fail directory not empty", new Object[0]);
      AppMethodBeat.o(128924);
      return paramf;
    case 4: 
      paramf = new i.a("fail permission denied, open \"%s\"", new Object[] { paramString });
      AppMethodBeat.o(128924);
      return paramf;
    }
    paramf = new i.a("ok", new Object[0]);
    AppMethodBeat.o(128924);
    return paramf;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.file.be
 * JD-Core Version:    0.7.0.1
 */