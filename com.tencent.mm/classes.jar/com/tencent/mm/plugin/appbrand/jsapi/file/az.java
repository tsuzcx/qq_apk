package com.tencent.mm.plugin.appbrand.jsapi.file;

import com.tencent.luggage.h.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appstorage.j;
import com.tencent.mm.plugin.appbrand.appstorage.l;
import com.tencent.mm.plugin.appbrand.appstorage.p;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.z.i;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

final class az
  extends g
{
  final i.a a(c paramc, String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(128917);
    paramJSONObject = new LinkedList();
    i locali = new i();
    paramc = paramc.Fg().a(paramString, locali);
    b.c(paramJSONObject, (List)locali.value);
    switch (1.kMS[paramc.ordinal()])
    {
    default: 
      paramc = new i.a("fail " + paramc.name(), new Object[0]);
      AppMethodBeat.o(128917);
      return paramc;
    case 1: 
    case 2: 
      paramc = new i.a("fail no such file or directory \"%s\"", new Object[] { paramString });
      AppMethodBeat.o(128917);
      return paramc;
    case 3: 
      paramc = new i.a("fail not a directory \"%s\"", new Object[] { paramString });
      AppMethodBeat.o(128917);
      return paramc;
    case 4: 
      paramc = new i.a("fail permission denied, open \"%s\"", new Object[] { paramString });
      AppMethodBeat.o(128917);
      return paramc;
    case 5: 
      paramc = new i.a("fail \"%s\" is not a regular file", new Object[] { paramString });
      AppMethodBeat.o(128917);
      return paramc;
    }
    paramc = new JSONArray();
    paramString = paramJSONObject.iterator();
    while (paramString.hasNext()) {
      paramc.put(((j)paramString.next()).fileName);
    }
    paramc = new i.a("ok", new Object[0]).q("files", paramc);
    AppMethodBeat.o(128917);
    return paramc;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.file.az
 * JD-Core Version:    0.7.0.1
 */