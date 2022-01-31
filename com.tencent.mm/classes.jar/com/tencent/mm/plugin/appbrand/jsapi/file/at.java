package com.tencent.mm.plugin.appbrand.jsapi.file;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appstorage.h;
import com.tencent.mm.plugin.appbrand.appstorage.o;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

final class at
  extends f
{
  final h.a a(com.tencent.mm.plugin.appbrand.jsapi.c paramc, String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(102825);
    paramJSONObject = new LinkedList();
    com.tencent.mm.plugin.appbrand.s.j localj = new com.tencent.mm.plugin.appbrand.s.j();
    paramc = paramc.wX().a(paramString, localj);
    com.tencent.luggage.g.c.c(paramJSONObject, (List)localj.value);
    switch (at.1.hMg[paramc.ordinal()])
    {
    default: 
      paramc = new h.a("fail " + paramc.name(), new Object[0]);
      AppMethodBeat.o(102825);
      return paramc;
    case 1: 
    case 2: 
      paramc = new h.a("fail no such file or directory \"%s\"", new Object[] { paramString });
      AppMethodBeat.o(102825);
      return paramc;
    case 3: 
      paramc = new h.a("fail not a directory \"%s\"", new Object[] { paramString });
      AppMethodBeat.o(102825);
      return paramc;
    case 4: 
      paramc = new h.a("fail permission denied, open \"%s\"", new Object[] { paramString });
      AppMethodBeat.o(102825);
      return paramc;
    case 5: 
      paramc = new h.a("fail \"%s\" is not a regular file", new Object[] { paramString });
      AppMethodBeat.o(102825);
      return paramc;
    }
    paramc = new JSONArray();
    paramString = paramJSONObject.iterator();
    while (paramString.hasNext()) {
      paramc.put(((h)paramString.next()).fileName);
    }
    paramc = new h.a("ok", new Object[0]).n("files", paramc);
    AppMethodBeat.o(102825);
    return paramc;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.file.at
 * JD-Core Version:    0.7.0.1
 */