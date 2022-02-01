package com.tencent.mm.plugin.appbrand.jsapi.file;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ac.i;
import com.tencent.mm.plugin.appbrand.appstorage.m;
import com.tencent.mm.plugin.appbrand.appstorage.n;
import com.tencent.mm.plugin.appbrand.appstorage.q;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.aa;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.s;
import java.io.IOException;
import java.net.URLEncoder;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.WritableByteChannel;
import org.json.JSONObject;

final class bh
  extends g
{
  protected final String V(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(128933);
    paramJSONObject = paramJSONObject.optString("zipFilePath");
    AppMethodBeat.o(128933);
    return paramJSONObject;
  }
  
  final i.a a(f paramf, String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(128932);
    String str = paramJSONObject.optString("targetDirectory", "");
    paramJSONObject = paramf.getFileSystem().Vl(str);
    switch (1.lVs[paramJSONObject.ordinal()])
    {
    default: 
      paramJSONObject = paramf.getFileSystem().VY(paramString);
      if ((paramJSONObject == null) || (!paramJSONObject.exists()))
      {
        if (paramf.getFileSystem().Vj(paramString) != m.kSu) {
          break label647;
        }
        localObject = paramf.getFileSystem().Wa(URLEncoder.encode(paramString));
        if (localObject == null) {
          break label647;
        }
        paramJSONObject = new i();
        paramf.getFileSystem().b(paramString, paramJSONObject);
      }
      break;
    case 1: 
    case 2: 
    case 3: 
      try
      {
        Channels.newChannel(s.ap((o)localObject)).write((ByteBuffer)paramJSONObject.value);
        paramJSONObject = new o(aa.z(((o)localObject).her()));
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
        break label324;
      }
      paramf = new i.a("fail no such file \"%s\"", new Object[] { paramString });
      AppMethodBeat.o(128932);
      return paramf;
      paramf = new i.a(String.format("fail permission denied, open \"%s\"", new Object[] { str }), new Object[0]);
      AppMethodBeat.o(128932);
      return paramf;
    }
    if ((paramJSONObject.isDirectory()) || (n.u(paramJSONObject)))
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
        label324:
        paramf = paramf.getFileSystem().a(str, (o)localObject);
        if (i != 0) {
          s.deleteFile(aa.z(((o)localObject).her()));
        }
        switch (1.lVs[paramf.ordinal()])
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
      label647:
      i = 0;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.file.bh
 * JD-Core Version:    0.7.0.1
 */