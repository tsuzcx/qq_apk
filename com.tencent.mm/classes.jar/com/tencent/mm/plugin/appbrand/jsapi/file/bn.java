package com.tencent.mm.plugin.appbrand.jsapi.file;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.af.k;
import com.tencent.mm.plugin.appbrand.appstorage.r;
import com.tencent.mm.plugin.appbrand.appstorage.t;
import com.tencent.mm.plugin.appbrand.appstorage.w;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.ah;
import com.tencent.mm.vfs.u;
import com.tencent.mm.vfs.y;
import java.io.IOException;
import java.net.URLEncoder;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.WritableByteChannel;
import org.json.JSONObject;

final class bn
  extends g
{
  final i.a a(f paramf, String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(128932);
    String str = paramJSONObject.optString("targetDirectory", "");
    paramJSONObject = paramf.getFileSystem().Vt(str);
    switch (1.rXN[paramJSONObject.ordinal()])
    {
    default: 
      paramJSONObject = paramf.getFileSystem().Wm(paramString);
      if ((paramJSONObject != null) && (paramJSONObject.jKS())) {
        break label299;
      }
      if (paramf.getFileSystem().Vr(paramString) != r.qML) {
        break label667;
      }
      paramJSONObject = paramf.getFileSystem().Wo(URLEncoder.encode(paramString));
      if (paramJSONObject != null)
      {
        localObject = new k();
        paramf.getFileSystem().b(paramString, (k)localObject);
      }
      break;
    case 1: 
    case 2: 
    case 3: 
      try
      {
        Channels.newChannel(y.ap(paramJSONObject)).write((ByteBuffer)((k)localObject).value);
        paramJSONObject = new u(ah.v(paramJSONObject.jKT()));
        i = 1;
      }
      catch (IOException paramJSONObject)
      {
        for (;;)
        {
          Log.e("MicroMsg.AppBrand.FileSystem.UnitUnzip", "copy ByteBuffer failed e = %s", new Object[] { paramJSONObject });
          paramJSONObject = null;
          i = 0;
        }
      }
      localObject = paramJSONObject;
      if (paramJSONObject != null) {
        break label344;
      }
      paramf = new i.a("fail no such file \"%s\"", new Object[] { paramString });
      AppMethodBeat.o(128932);
      return paramf;
      paramf = new i.a(String.format("fail permission denied, open \"%s\"", new Object[] { str }), new Object[0]);
      AppMethodBeat.o(128932);
      return paramf;
    }
    paramf = new i.a("fail allocTempFile failed", new Object[0]);
    AppMethodBeat.o(128932);
    return paramf;
    label299:
    if ((paramJSONObject.isDirectory()) || (t.u(paramJSONObject)))
    {
      paramf = new i.a("fail permission denied, open \"%s\"", new Object[] { paramString });
      AppMethodBeat.o(128932);
      return paramf;
    }
    int i = 0;
    Object localObject = paramJSONObject;
    for (;;)
    {
      try
      {
        label344:
        paramf = paramf.getFileSystem().a(str, (u)localObject);
        if (i != 0) {
          y.deleteFile(ah.v(((u)localObject).jKT()));
        }
        switch (1.rXN[paramf.ordinal()])
        {
        case 2: 
        case 3: 
          paramf = new i.a("fail " + paramf.name(), new Object[0]);
          AppMethodBeat.o(128932);
          return paramf;
        }
      }
      catch (Exception paramf)
      {
        Log.printErrStackTrace("MicroMsg.AppBrand.FileSystem.UnitUnzip", paramf, "write zip stream", new Object[0]);
        paramf = new i.a("fail read zip data", new Object[0]);
        AppMethodBeat.o(128932);
        return paramf;
      }
      paramf = new i.a("fail no such file or directory, open \"%s\"", new Object[] { paramString });
      AppMethodBeat.o(128932);
      return paramf;
      paramf = new i.a("fail illegal operation on a filePath, open \"%s\"", new Object[] { paramString });
      AppMethodBeat.o(128932);
      return paramf;
      paramf = new i.a("fail permission denied, open \"%s\"", new Object[] { paramString });
      AppMethodBeat.o(128932);
      return paramf;
      paramf = new i.a("fail the maximum size of the file storage limit is exceeded", new Object[0]);
      AppMethodBeat.o(128932);
      return paramf;
      paramf = new i.a("fail read zip data", new Object[0]);
      AppMethodBeat.o(128932);
      return paramf;
      paramf = new i.a("fail write entry", new Object[0]);
      AppMethodBeat.o(128932);
      return paramf;
      paramf = new i.a("ok", new Object[0]);
      AppMethodBeat.o(128932);
      return paramf;
      label667:
      i = 0;
      break;
    }
  }
  
  protected final String aj(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(128933);
    paramJSONObject = paramJSONObject.optString("zipFilePath");
    AppMethodBeat.o(128933);
    return paramJSONObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.file.bn
 * JD-Core Version:    0.7.0.1
 */