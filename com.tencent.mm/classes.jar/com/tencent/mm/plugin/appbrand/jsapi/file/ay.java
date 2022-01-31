package com.tencent.mm.plugin.appbrand.jsapi.file;

import com.tencent.luggage.j.a;
import com.tencent.mm.plugin.appbrand.appstorage.h;
import com.tencent.mm.plugin.appbrand.appstorage.k;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.v.n;
import com.tencent.mm.plugin.appbrand.v.n.a;
import com.tencent.mm.sdk.platformtools.bk;
import java.io.ByteArrayInputStream;
import java.nio.ByteBuffer;
import java.util.Map;
import org.json.JSONObject;

class ay
  extends d
{
  f.a a(c paramc, String paramString, JSONObject paramJSONObject)
  {
    boolean bool = paramJSONObject.optBoolean("append", false);
    String str = paramJSONObject.optString("encoding");
    n.a(paramc.ahK(), paramJSONObject, (n.a)paramc.D(n.a.class));
    Object localObject = paramJSONObject.opt("data");
    if ((localObject instanceof String)) {
      if (bk.bl(str)) {
        paramJSONObject = (e)e.a.gqH.get("utf8");
      }
    }
    for (;;)
    {
      try
      {
        paramJSONObject = paramJSONObject.ua((String)localObject);
        paramJSONObject = new a(paramJSONObject);
        paramc = paramc.Zl().a(paramString, paramJSONObject, bool);
        switch (ay.1.gqS[paramc.ordinal()])
        {
        default: 
          return new f.a("fail " + paramc.name(), new Object[0]);
        }
      }
      catch (Exception paramc)
      {
        return new f.a("fail " + paramc.getMessage(), new Object[0]);
      }
      paramJSONObject = (e)e.a.gqH.get(str.toLowerCase());
      if (paramJSONObject == null)
      {
        return new f.a("fail invalid encoding", new Object[0]);
        if ((localObject instanceof ByteBuffer))
        {
          paramJSONObject = new a((ByteBuffer)localObject);
        }
        else if (localObject == null)
        {
          if (bool) {
            return new f.a("ok", new Object[0]);
          }
          paramJSONObject = new ByteArrayInputStream(new byte[0]);
        }
        else
        {
          return new f.a("fail invalid data", new Object[0]);
          return new f.a("fail no such file or directory, open \"%s\"", new Object[] { paramString });
          return new f.a("fail illegal operation on a directory, open \"%s\"", new Object[] { paramString });
          return new f.a("fail permission denied, open \"%s\"", new Object[] { paramString });
          return new f.a("fail \"%s\" is not a regular file", new Object[] { paramString });
          return new f.a("fail the maximum size of the file storage limit is exceeded", new Object[0]);
          return new f.a("ok", new Object[0]);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.file.ay
 * JD-Core Version:    0.7.0.1
 */