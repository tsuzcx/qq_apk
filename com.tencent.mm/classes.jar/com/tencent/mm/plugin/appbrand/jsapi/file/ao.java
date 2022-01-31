package com.tencent.mm.plugin.appbrand.jsapi.file;

import com.tencent.luggage.j.a;
import com.tencent.mm.plugin.appbrand.appstorage.h;
import com.tencent.mm.plugin.appbrand.appstorage.i;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.sdk.platformtools.bk;
import java.io.File;
import java.nio.ByteBuffer;
import java.util.Locale;
import org.json.JSONObject;

final class ao
  extends d
{
  final f.a a(c paramc, String paramString, JSONObject paramJSONObject)
  {
    paramJSONObject = paramJSONObject.optString("destPath");
    String str1 = String.format(Locale.US, "fail no such file or directory, copyFile \"%s\" -> \"%s\"", new Object[] { paramString, paramJSONObject });
    String str2 = String.format(Locale.US, "fail permission denied, copyFile \"%s\" -> \"%s\"", new Object[] { paramString, paramJSONObject });
    Object localObject = paramc.Zl().rx(paramString);
    if ((localObject == null) || (!((File)localObject).exists()) || (!((File)localObject).isFile()))
    {
      localObject = new com.tencent.mm.plugin.appbrand.u.k();
      paramc.Zl().b(paramString, (com.tencent.mm.plugin.appbrand.u.k)localObject);
      if (((com.tencent.mm.plugin.appbrand.u.k)localObject).value == null) {
        return new f.a(str1, new Object[0]);
      }
      paramString = new a((ByteBuffer)((com.tencent.mm.plugin.appbrand.u.k)localObject).value);
      paramc = paramc.Zl().a(paramJSONObject, paramString, false);
      bk.b(paramString);
    }
    for (;;)
    {
      switch (ao.1.gqS[paramc.ordinal()])
      {
      default: 
        return new f.a("fail " + paramc.name(), new Object[0]);
        if (i.w((File)localObject)) {
          return new f.a("fail \"%s\" not a regular file", new Object[] { paramString });
        }
        paramc = paramc.Zl().a(paramJSONObject, (File)localObject, false);
      }
    }
    return new f.a(str2, new Object[0]);
    return new f.a(str1, new Object[0]);
    return new f.a("fail sdcard not mounted", new Object[0]);
    return new f.a("fail illegal operation on a directory, open \"%s\"", new Object[] { paramJSONObject });
    return new f.a("fail \"%s\" is not a regular file", new Object[] { paramJSONObject });
    return new f.a("fail the maximum size of the file storage limit is exceeded", new Object[0]);
    return new f.a("ok", new Object[0]);
  }
  
  protected final String v(JSONObject paramJSONObject)
  {
    return paramJSONObject.optString("srcPath");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.file.ao
 * JD-Core Version:    0.7.0.1
 */