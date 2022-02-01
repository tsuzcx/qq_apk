package com.tencent.mm.plugin.appbrand.jsapi.file;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appstorage.m;
import com.tencent.mm.plugin.appbrand.appstorage.r;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import org.json.JSONObject;

final class bh
  extends g
{
  final i.a a(e parame, String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(128924);
    boolean bool = paramJSONObject.optBoolean("recursive", false);
    parame = parame.getFileSystem().ak(paramString, bool);
    switch (1.oSw[parame.ordinal()])
    {
    default: 
      parame = new i.a("fail " + parame.name(), new Object[0]);
      AppMethodBeat.o(128924);
      return parame;
    case 1: 
    case 2: 
      parame = new i.a("fail no such file or directory \"%s\"", new Object[] { paramString });
      AppMethodBeat.o(128924);
      return parame;
    case 3: 
      parame = new i.a("fail directory not empty", new Object[0]);
      AppMethodBeat.o(128924);
      return parame;
    case 4: 
      parame = new i.a("fail permission denied, open \"%s\"", new Object[] { paramString });
      AppMethodBeat.o(128924);
      return parame;
    }
    parame = new i.a("ok", new Object[0]);
    AppMethodBeat.o(128924);
    return parame;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.file.bh
 * JD-Core Version:    0.7.0.1
 */