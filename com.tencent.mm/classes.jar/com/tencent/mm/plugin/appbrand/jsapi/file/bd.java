package com.tencent.mm.plugin.appbrand.jsapi.file;

import com.tencent.luggage.k.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ac.i;
import com.tencent.mm.plugin.appbrand.appstorage.k;
import com.tencent.mm.plugin.appbrand.appstorage.m;
import com.tencent.mm.plugin.appbrand.appstorage.r;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

final class bd
  extends g
{
  final i.a a(e parame, String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(128917);
    paramJSONObject = new LinkedList();
    i locali = new i();
    parame = parame.getFileSystem().a(paramString, locali);
    b.c(paramJSONObject, (List)locali.value);
    switch (1.oSw[parame.ordinal()])
    {
    default: 
      parame = new i.a("fail " + parame.name(), new Object[0]);
      AppMethodBeat.o(128917);
      return parame;
    case 1: 
    case 2: 
      parame = new i.a("fail no such file or directory \"%s\"", new Object[] { paramString });
      AppMethodBeat.o(128917);
      return parame;
    case 3: 
      parame = new i.a("fail not a directory \"%s\"", new Object[] { paramString });
      AppMethodBeat.o(128917);
      return parame;
    case 4: 
      parame = new i.a("fail permission denied, open \"%s\"", new Object[] { paramString });
      AppMethodBeat.o(128917);
      return parame;
    case 5: 
      parame = new i.a("fail \"%s\" is not a regular file", new Object[] { paramString });
      AppMethodBeat.o(128917);
      return parame;
    }
    parame = new JSONArray();
    paramString = paramJSONObject.iterator();
    while (paramString.hasNext()) {
      parame.put(((k)paramString.next()).fileName);
    }
    parame = new i.a("ok", new Object[0]).p("files", parame);
    AppMethodBeat.o(128917);
    return parame;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.file.bd
 * JD-Core Version:    0.7.0.1
 */