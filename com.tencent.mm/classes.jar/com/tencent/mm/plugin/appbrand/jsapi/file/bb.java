package com.tencent.mm.plugin.appbrand.jsapi.file;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appstorage.l;
import com.tencent.mm.plugin.appbrand.appstorage.m;
import com.tencent.mm.plugin.appbrand.appstorage.p;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.vfs.e;
import java.util.Locale;
import org.json.JSONObject;

final class bb
  extends g
{
  protected final String M(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(128922);
    paramJSONObject = paramJSONObject.optString("oldPath");
    AppMethodBeat.o(128922);
    return paramJSONObject;
  }
  
  final i.a a(c paramc, String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(128921);
    Object localObject = paramc.Fg();
    if (localObject == null)
    {
      paramc = new i.a("fail:internal error", new Object[0]);
      AppMethodBeat.o(128921);
      return paramc;
    }
    String str2 = paramJSONObject.optString("newPath");
    paramJSONObject = String.format(Locale.US, "fail no such file or directory, rename \"%s\" -> \"%s\"", new Object[] { paramString, str2 });
    String str1 = String.format(Locale.US, "fail permission denied, rename \"%s\" -> \"%s\"", new Object[] { paramString, str2 });
    if (!((p)localObject).Mk(paramString))
    {
      paramc = new i.a(str1, new Object[0]);
      AppMethodBeat.o(128921);
      return paramc;
    }
    localObject = paramc.Fg().ae(paramString, true);
    if ((localObject == null) || (!((e)localObject).exists()))
    {
      paramc = new i.a(paramJSONObject, new Object[0]);
      AppMethodBeat.o(128921);
      return paramc;
    }
    if (m.v((e)localObject))
    {
      paramc = new i.a("fail \"%s\" not a regular file", new Object[] { paramString });
      AppMethodBeat.o(128921);
      return paramc;
    }
    paramc = paramc.Fg().a(str2, (e)localObject, true);
    switch (1.kMS[paramc.ordinal()])
    {
    default: 
      paramc = new i.a("fail " + paramc.name(), new Object[0]);
      AppMethodBeat.o(128921);
      return paramc;
    case 1: 
      paramc = new i.a(str1, new Object[0]);
      AppMethodBeat.o(128921);
      return paramc;
    case 2: 
      paramc = new i.a(paramJSONObject, new Object[0]);
      AppMethodBeat.o(128921);
      return paramc;
    case 3: 
      paramc = new i.a("fail sdcard not mounted", new Object[0]);
      AppMethodBeat.o(128921);
      return paramc;
    }
    paramc = new i.a("ok", new Object[0]);
    AppMethodBeat.o(128921);
    return paramc;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.file.bb
 * JD-Core Version:    0.7.0.1
 */