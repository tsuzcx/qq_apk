package com.tencent.mm.plugin.appbrand.jsapi.file;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appstorage.r;
import com.tencent.mm.plugin.appbrand.appstorage.t;
import com.tencent.mm.plugin.appbrand.appstorage.w;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.vfs.u;
import java.util.Locale;
import org.json.JSONObject;

final class bj
  extends g
{
  final i.a a(f paramf, String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(128921);
    Object localObject = paramf.getFileSystem();
    if (localObject == null)
    {
      paramf = new i.a("fail:internal error", new Object[0]);
      AppMethodBeat.o(128921);
      return paramf;
    }
    String str2 = paramJSONObject.optString("newPath");
    paramJSONObject = String.format(Locale.US, "fail no such file or directory, rename \"%s\" -> \"%s\"", new Object[] { paramString, str2 });
    String str1 = String.format(Locale.US, "fail permission denied, rename \"%s\" -> \"%s\"", new Object[] { paramString, str2 });
    if (!((w)localObject).Wn(paramString))
    {
      paramf = new i.a(str1, new Object[0]);
      AppMethodBeat.o(128921);
      return paramf;
    }
    localObject = paramf.getFileSystem().ao(paramString, true);
    if ((localObject == null) || (!((u)localObject).jKS()))
    {
      paramf = new i.a(paramJSONObject, new Object[0]);
      AppMethodBeat.o(128921);
      return paramf;
    }
    if (t.u((u)localObject))
    {
      paramf = new i.a("fail \"%s\" not a regular file", new Object[] { paramString });
      AppMethodBeat.o(128921);
      return paramf;
    }
    paramf = paramf.getFileSystem().a(str2, (u)localObject, true);
    switch (1.rXN[paramf.ordinal()])
    {
    default: 
      paramf = new i.a("fail " + paramf.name(), new Object[0]);
      AppMethodBeat.o(128921);
      return paramf;
    case 1: 
      paramf = new i.a(str1, new Object[0]);
      AppMethodBeat.o(128921);
      return paramf;
    case 2: 
      paramf = new i.a(paramJSONObject, new Object[0]);
      AppMethodBeat.o(128921);
      return paramf;
    case 3: 
      paramf = new i.a("fail sdcard not mounted", new Object[0]);
      AppMethodBeat.o(128921);
      return paramf;
    }
    paramf = new i.a("ok", new Object[0]);
    AppMethodBeat.o(128921);
    return paramf;
  }
  
  protected final String aj(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(128922);
    paramJSONObject = paramJSONObject.optString("oldPath");
    AppMethodBeat.o(128922);
    return paramJSONObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.file.bj
 * JD-Core Version:    0.7.0.1
 */