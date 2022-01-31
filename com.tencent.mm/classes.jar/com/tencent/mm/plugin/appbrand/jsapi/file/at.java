package com.tencent.mm.plugin.appbrand.jsapi.file;

import com.tencent.mm.plugin.appbrand.appstorage.h;
import com.tencent.mm.plugin.appbrand.appstorage.i;
import com.tencent.mm.plugin.appbrand.appstorage.k;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import java.io.File;
import java.util.Locale;
import org.json.JSONObject;

final class at
  extends d
{
  final f.a a(c paramc, String paramString, JSONObject paramJSONObject)
  {
    String str2 = paramJSONObject.optString("newPath");
    paramJSONObject = String.format(Locale.US, "fail no such file or directory, rename \"%s\" -> \"%s\"", new Object[] { paramString, str2 });
    String str1 = String.format(Locale.US, "fail permission denied, rename \"%s\" -> \"%s\"", new Object[] { paramString, str2 });
    File localFile = paramc.Zl().rx(paramString);
    if ((localFile == null) || (!localFile.exists())) {
      return new f.a(paramJSONObject, new Object[0]);
    }
    if (i.w(localFile)) {
      return new f.a("fail \"%s\" not a regular file", new Object[] { paramString });
    }
    paramc = paramc.Zl().a(str2, localFile, true);
    switch (at.1.gqS[paramc.ordinal()])
    {
    default: 
      return new f.a("fail " + paramc.name(), new Object[0]);
    case 1: 
      return new f.a(str1, new Object[0]);
    case 2: 
      return new f.a(paramJSONObject, new Object[0]);
    case 3: 
      return new f.a("fail sdcard not mounted", new Object[0]);
    }
    return new f.a("ok", new Object[0]);
  }
  
  protected final String v(JSONObject paramJSONObject)
  {
    return paramJSONObject.optString("oldPath");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.file.at
 * JD-Core Version:    0.7.0.1
 */