package com.tencent.mm.plugin.appbrand.jsapi.file;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appstorage.m;
import com.tencent.mm.plugin.appbrand.appstorage.r;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import org.json.JSONObject;

final class bj
  extends g
{
  final i.a a(e parame, String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(128930);
    parame = parame.getFileSystem().adK(paramString);
    switch (1.oSw[parame.ordinal()])
    {
    default: 
      parame = new i.a("fail " + parame.name(), new Object[0]);
      AppMethodBeat.o(128930);
      return parame;
    case 1: 
      parame = new i.a("fail permission denied, open \"%s\"", new Object[] { paramString });
      AppMethodBeat.o(128930);
      return parame;
    case 2: 
      parame = new i.a("fail no such file or directory \"%s\"", new Object[] { paramString });
      AppMethodBeat.o(128930);
      return parame;
    case 3: 
      parame = new i.a("fail operation not permitted, unlink \"%s\"", new Object[] { paramString });
      AppMethodBeat.o(128930);
      return parame;
    }
    parame = new i.a("ok", new Object[0]);
    AppMethodBeat.o(128930);
    return parame;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.file.bj
 * JD-Core Version:    0.7.0.1
 */