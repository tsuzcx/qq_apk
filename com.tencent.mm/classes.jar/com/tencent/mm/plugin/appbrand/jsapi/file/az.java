package com.tencent.mm.plugin.appbrand.jsapi.file;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appstorage.m;
import com.tencent.mm.plugin.appbrand.appstorage.q;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import org.json.JSONObject;

final class az
  extends g
{
  final i.a a(c paramc, String paramString, JSONObject paramJSONObject)
  {
    boolean bool = true;
    AppMethodBeat.i(128913);
    paramc = paramc.Fl().Mc(paramString);
    switch (1.kQn[paramc.ordinal()])
    {
    default: 
      paramc = new i.a("fail " + paramc.name(), new Object[0]);
      AppMethodBeat.o(128913);
      return paramc;
    case 1: 
      paramc = new i.a("fail no such file or directory \"%s\"", new Object[] { paramString });
      AppMethodBeat.o(128913);
      return paramc;
    }
    paramString = new i.a("ok", new Object[0]);
    if (paramc == m.jPM) {}
    for (;;)
    {
      paramc = paramString.q("result", Boolean.valueOf(bool));
      AppMethodBeat.o(128913);
      return paramc;
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.file.az
 * JD-Core Version:    0.7.0.1
 */