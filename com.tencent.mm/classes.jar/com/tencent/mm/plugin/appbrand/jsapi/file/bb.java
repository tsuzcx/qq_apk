package com.tencent.mm.plugin.appbrand.jsapi.file;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appstorage.m;
import com.tencent.mm.plugin.appbrand.appstorage.r;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import org.json.JSONObject;

final class bb
  extends g
{
  final i.a a(e parame, String paramString, JSONObject paramJSONObject)
  {
    boolean bool = true;
    AppMethodBeat.i(128913);
    parame = parame.getFileSystem().acV(paramString);
    switch (1.oSw[parame.ordinal()])
    {
    default: 
      parame = new i.a("fail " + parame.name(), new Object[0]);
      AppMethodBeat.o(128913);
      return parame;
    case 1: 
      parame = new i.a("fail no such file or directory \"%s\"", new Object[] { paramString });
      AppMethodBeat.o(128913);
      return parame;
    }
    paramString = new i.a("ok", new Object[0]);
    if (parame == m.nMR) {}
    for (;;)
    {
      parame = paramString.p("result", Boolean.valueOf(bool));
      AppMethodBeat.o(128913);
      return parame;
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.file.bb
 * JD-Core Version:    0.7.0.1
 */