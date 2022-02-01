package com.tencent.mm.plugin.appbrand.jsapi.file;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appstorage.m;
import com.tencent.mm.plugin.appbrand.appstorage.r;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import org.json.JSONObject;

final class bc
  extends g
{
  final i.a a(e parame, String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(128915);
    boolean bool = paramJSONObject.optBoolean("recursive", false);
    parame = parame.getFileSystem().aj(paramString, bool);
    switch (1.oSw[parame.ordinal()])
    {
    default: 
      parame = new i.a("fail " + parame.name(), new Object[0]);
      AppMethodBeat.o(128915);
      return parame;
    case 1: 
      parame = new i.a("fail no such file or directory \"%s\"", new Object[] { paramString });
      AppMethodBeat.o(128915);
      return parame;
    case 2: 
      parame = new i.a("fail permission denied, open \"%s\"", new Object[] { paramString });
      AppMethodBeat.o(128915);
      return parame;
    case 3: 
      parame = new i.a("fail file already exists \"%s\"", new Object[] { paramString });
      AppMethodBeat.o(128915);
      return parame;
    }
    parame = new i.a("ok", new Object[0]);
    AppMethodBeat.o(128915);
    return parame;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.file.bc
 * JD-Core Version:    0.7.0.1
 */