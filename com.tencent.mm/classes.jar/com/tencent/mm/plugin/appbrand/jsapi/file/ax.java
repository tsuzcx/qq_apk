package com.tencent.mm.plugin.appbrand.jsapi.file;

import com.tencent.mm.plugin.appbrand.appstorage.h;
import com.tencent.mm.plugin.appbrand.appstorage.i;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.vfs.b;
import com.tencent.mm.vfs.e;
import com.tencent.mm.vfs.j;
import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.WritableByteChannel;
import org.json.JSONObject;

final class ax
  extends d
{
  final f.a a(c paramc, String paramString, JSONObject paramJSONObject)
  {
    String str = paramJSONObject.optString("targetDirectory", "");
    paramJSONObject = paramc.Zl().rv(str);
    switch (1.gqS[paramJSONObject.ordinal()])
    {
    default: 
      paramJSONObject = paramc.Zl().rx(paramString);
      if ((paramJSONObject == null) || (!paramJSONObject.exists()))
      {
        if (paramc.Zl().ru(paramString) != h.fGU) {
          break label560;
        }
        localObject = paramc.Zl().ry(URLEncoder.encode(paramString));
        if (localObject == null) {
          break label560;
        }
        paramJSONObject = new com.tencent.mm.plugin.appbrand.u.k();
        paramc.Zl().b(paramString, paramJSONObject);
      }
      break;
    case 1: 
    case 2: 
    case 3: 
      try
      {
        Channels.newChannel(e.p((b)localObject)).write((ByteBuffer)paramJSONObject.value);
        paramJSONObject = new File(j.n(((b)localObject).cLr()));
        i = 1;
      }
      catch (IOException paramJSONObject)
      {
        for (;;)
        {
          y.e("MicroMsg.AppBrand.FileSystem.UnitUnzip", "copy ByteBuffer failed e = %s", new Object[] { paramJSONObject });
          paramJSONObject = null;
          i = 0;
        }
      }
      localObject = paramJSONObject;
      if (paramJSONObject != null) {
        break label299;
      }
      return new f.a("fail no such file \"%s\"", new Object[] { paramString });
      return new f.a(String.format("fail permission denied, open \"%s\"", new Object[] { str }), new Object[0]);
    }
    if ((paramJSONObject.isDirectory()) || (i.w(paramJSONObject))) {
      return new f.a("fail permission denied, open \"%s\"", new Object[] { paramString });
    }
    int i = 0;
    Object localObject = paramJSONObject;
    for (;;)
    {
      try
      {
        label299:
        paramc = paramc.Zl().b(str, (File)localObject);
        if (i != 0) {
          e.deleteFile(((File)localObject).getAbsolutePath());
        }
        switch (1.gqS[paramc.ordinal()])
        {
        case 2: 
        case 3: 
          paramc = new f.a("fail " + paramc.name(), new Object[0]);
          return paramc;
        }
      }
      catch (Exception paramc)
      {
        y.printErrStackTrace("MicroMsg.AppBrand.FileSystem.UnitUnzip", paramc, "write zip stream", new Object[0]);
        return new f.a("fail read zip data", new Object[0]);
      }
      return new f.a("fail no such file or directory, open \"%s\"", new Object[] { paramString });
      return new f.a("fail illegal operation on a filePath, open \"%s\"", new Object[] { paramString });
      return new f.a("fail permission denied, open \"%s\"", new Object[] { paramString });
      return new f.a("fail the maximum size of the file storage limit is exceeded", new Object[0]);
      return new f.a("fail read zip data", new Object[0]);
      return new f.a("fail write entry", new Object[0]);
      paramc = new f.a("ok", new Object[0]);
      return paramc;
      label560:
      i = 0;
      break;
    }
  }
  
  protected final String v(JSONObject paramJSONObject)
  {
    return paramJSONObject.optString("zipFilePath");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.file.ax
 * JD-Core Version:    0.7.0.1
 */