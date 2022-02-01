package com.tencent.mm.plugin.appbrand.jsapi.file;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appstorage.m;
import com.tencent.mm.plugin.appbrand.appstorage.o;
import com.tencent.mm.plugin.appbrand.appstorage.r;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.vfs.q;
import java.util.Locale;
import org.json.JSONObject;

final class bg
  extends g
{
  protected final String Z(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(128922);
    paramJSONObject = paramJSONObject.optString("oldPath");
    AppMethodBeat.o(128922);
    return paramJSONObject;
  }
  
  final i.a a(e parame, String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(128921);
    Object localObject = parame.getFileSystem();
    if (localObject == null)
    {
      parame = new i.a("fail:internal error", new Object[0]);
      AppMethodBeat.o(128921);
      return parame;
    }
    String str2 = paramJSONObject.optString("newPath");
    paramJSONObject = String.format(Locale.US, "fail no such file or directory, rename \"%s\" -> \"%s\"", new Object[] { paramString, str2 });
    String str1 = String.format(Locale.US, "fail permission denied, rename \"%s\" -> \"%s\"", new Object[] { paramString, str2 });
    if (!((r)localObject).adM(paramString))
    {
      parame = new i.a(str1, new Object[0]);
      AppMethodBeat.o(128921);
      return parame;
    }
    localObject = parame.getFileSystem().ah(paramString, true);
    if ((localObject == null) || (!((q)localObject).ifE()))
    {
      parame = new i.a(paramJSONObject, new Object[0]);
      AppMethodBeat.o(128921);
      return parame;
    }
    if (o.t((q)localObject))
    {
      parame = new i.a("fail \"%s\" not a regular file", new Object[] { paramString });
      AppMethodBeat.o(128921);
      return parame;
    }
    parame = parame.getFileSystem().a(str2, (q)localObject, true);
    switch (1.oSw[parame.ordinal()])
    {
    default: 
      parame = new i.a("fail " + parame.name(), new Object[0]);
      AppMethodBeat.o(128921);
      return parame;
    case 1: 
      parame = new i.a(str1, new Object[0]);
      AppMethodBeat.o(128921);
      return parame;
    case 2: 
      parame = new i.a(paramJSONObject, new Object[0]);
      AppMethodBeat.o(128921);
      return parame;
    case 3: 
      parame = new i.a("fail sdcard not mounted", new Object[0]);
      AppMethodBeat.o(128921);
      return parame;
    }
    parame = new i.a("ok", new Object[0]);
    AppMethodBeat.o(128921);
    return parame;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.file.bg
 * JD-Core Version:    0.7.0.1
 */