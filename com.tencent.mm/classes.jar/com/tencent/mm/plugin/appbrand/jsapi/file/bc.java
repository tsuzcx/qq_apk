package com.tencent.mm.plugin.appbrand.jsapi.file;

import com.tencent.luggage.l.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.af.k;
import com.tencent.mm.plugin.appbrand.appstorage.r;
import com.tencent.mm.plugin.appbrand.appstorage.t;
import com.tencent.mm.plugin.appbrand.appstorage.w;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.u;
import java.nio.ByteBuffer;
import java.util.Locale;
import org.json.JSONObject;

final class bc
  extends g
{
  final i.a a(f paramf, String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(128910);
    paramJSONObject = paramJSONObject.optString("destPath");
    String str1 = String.format(Locale.US, "fail no such file or directory, copyFile \"%s\" -> \"%s\"", new Object[] { paramString, paramJSONObject });
    String str2 = String.format(Locale.US, "fail permission denied, copyFile \"%s\" -> \"%s\"", new Object[] { paramString, paramJSONObject });
    Object localObject = paramf.getFileSystem().Wm(paramString);
    boolean bool = paramf.getFileSystem().Wk(paramString);
    if ((localObject == null) || (!((u)localObject).jKS()) || (!((u)localObject).jKV()))
    {
      if (!bool)
      {
        paramf = new i.a(str2, new Object[0]);
        AppMethodBeat.o(128910);
        return paramf;
      }
      localObject = new k();
      paramf.getFileSystem().b(paramString, (k)localObject);
      if (((k)localObject).value == null)
      {
        paramf = new i.a(str1, new Object[0]);
        AppMethodBeat.o(128910);
        return paramf;
      }
      paramString = new a((ByteBuffer)((k)localObject).value);
      paramf = paramf.getFileSystem().a(paramJSONObject, paramString, false);
      Util.qualityClose(paramString);
    }
    for (;;)
    {
      switch (1.rXN[paramf.ordinal()])
      {
      default: 
        paramf = new i.a("fail " + paramf.name(), new Object[0]);
        AppMethodBeat.o(128910);
        return paramf;
        if (t.u((u)localObject))
        {
          paramf = new i.a("fail \"%s\" not a regular file", new Object[] { paramString });
          AppMethodBeat.o(128910);
          return paramf;
        }
        paramf = paramf.getFileSystem().a(paramJSONObject, (u)localObject, false);
      }
    }
    paramf = new i.a(str2, new Object[0]);
    AppMethodBeat.o(128910);
    return paramf;
    paramf = new i.a(str1, new Object[0]);
    AppMethodBeat.o(128910);
    return paramf;
    paramf = new i.a("fail sdcard not mounted", new Object[0]);
    AppMethodBeat.o(128910);
    return paramf;
    paramf = new i.a("fail illegal operation on a directory, open \"%s\"", new Object[] { paramJSONObject });
    AppMethodBeat.o(128910);
    return paramf;
    paramf = new i.a("fail \"%s\" is not a regular file", new Object[] { paramJSONObject });
    AppMethodBeat.o(128910);
    return paramf;
    paramf = new i.a("fail the maximum size of the file storage limit is exceeded", new Object[0]);
    AppMethodBeat.o(128910);
    return paramf;
    paramf = new i.a("ok", new Object[0]);
    AppMethodBeat.o(128910);
    return paramf;
  }
  
  protected final String aj(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(128911);
    paramJSONObject = paramJSONObject.optString("srcPath");
    AppMethodBeat.o(128911);
    return paramJSONObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.file.bc
 * JD-Core Version:    0.7.0.1
 */