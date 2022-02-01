package com.tencent.mm.plugin.appbrand.jsapi.file;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appstorage.m;
import com.tencent.mm.plugin.appbrand.appstorage.q;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import org.json.JSONObject;

final class az
  extends g
{
  final i.a a(f paramf, String paramString, JSONObject paramJSONObject)
  {
    boolean bool = true;
    AppMethodBeat.i(128913);
    paramf = paramf.getFileSystem().Vl(paramString);
    switch (1.lVs[paramf.ordinal()])
    {
    default: 
      paramf = new i.a("fail " + paramf.name(), new Object[0]);
      AppMethodBeat.o(128913);
      return paramf;
    case 1: 
      paramf = new i.a("fail no such file or directory \"%s\"", new Object[] { paramString });
      AppMethodBeat.o(128913);
      return paramf;
    }
    paramString = new i.a("ok", new Object[0]);
    if (paramf == m.kSu) {}
    for (;;)
    {
      paramf = paramString.q("result", Boolean.valueOf(bool));
      AppMethodBeat.o(128913);
      return paramf;
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.file.az
 * JD-Core Version:    0.7.0.1
 */