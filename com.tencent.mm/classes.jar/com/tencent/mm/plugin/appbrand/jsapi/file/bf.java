package com.tencent.mm.plugin.appbrand.jsapi.file;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appstorage.l;
import com.tencent.mm.plugin.appbrand.appstorage.m;
import com.tencent.mm.plugin.appbrand.appstorage.p;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.vfs.e;
import com.tencent.mm.vfs.q;
import java.io.IOException;
import java.net.URLEncoder;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.WritableByteChannel;
import org.json.JSONObject;

final class bf
  extends g
{
  protected final String M(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(128933);
    paramJSONObject = paramJSONObject.optString("zipFilePath");
    AppMethodBeat.o(128933);
    return paramJSONObject;
  }
  
  final i.a a(c paramc, String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(128932);
    String str = paramJSONObject.optString("targetDirectory", "");
    paramJSONObject = paramc.DH().Ih(str);
    switch (1.krw[paramJSONObject.ordinal()])
    {
    default: 
      paramJSONObject = paramc.DH().IS(paramString);
      if ((paramJSONObject == null) || (!paramJSONObject.exists()))
      {
        if (paramc.DH().If(paramString) != l.jsB) {
          break label647;
        }
        localObject = paramc.DH().IU(URLEncoder.encode(paramString));
        if (localObject == null) {
          break label647;
        }
        paramJSONObject = new com.tencent.mm.plugin.appbrand.z.i();
        paramc.DH().b(paramString, paramJSONObject);
      }
      break;
    case 1: 
    case 2: 
    case 3: 
      try
      {
        Channels.newChannel(com.tencent.mm.vfs.i.ah((e)localObject)).write((ByteBuffer)paramJSONObject.value);
        paramJSONObject = new e(q.B(((e)localObject).fxV()));
        i = 1;
      }
      catch (IOException paramJSONObject)
      {
        for (;;)
        {
          ac.e("MicroMsg.AppBrand.FileSystem.UnitUnzip", "copy ByteBuffer failed e = %s", new Object[] { paramJSONObject });
          paramJSONObject = null;
          i = 0;
        }
      }
      localObject = paramJSONObject;
      if (paramJSONObject != null) {
        break label324;
      }
      paramc = new i.a("fail no such file \"%s\"", new Object[] { paramString });
      AppMethodBeat.o(128932);
      return paramc;
      paramc = new i.a(String.format("fail permission denied, open \"%s\"", new Object[] { str }), new Object[0]);
      AppMethodBeat.o(128932);
      return paramc;
    }
    if ((paramJSONObject.isDirectory()) || (m.v(paramJSONObject)))
    {
      paramc = new i.a("fail permission denied, open \"%s\"", new Object[] { paramString });
      AppMethodBeat.o(128932);
      return paramc;
    }
    int i = 0;
    Object localObject = paramJSONObject;
    for (;;)
    {
      try
      {
        label324:
        paramc = paramc.DH().a(str, (e)localObject);
        if (i != 0) {
          com.tencent.mm.vfs.i.deleteFile(q.B(((e)localObject).fxV()));
        }
        switch (1.krw[paramc.ordinal()])
        {
        case 2: 
        case 3: 
          paramc = new i.a("fail " + paramc.name(), new Object[0]);
          AppMethodBeat.o(128932);
          return paramc;
        }
      }
      catch (Exception paramc)
      {
        ac.printErrStackTrace("MicroMsg.AppBrand.FileSystem.UnitUnzip", paramc, "write zip stream", new Object[0]);
        paramc = new i.a("fail read zip data", new Object[0]);
        AppMethodBeat.o(128932);
        return paramc;
      }
      paramc = new i.a("fail no such file or directory, open \"%s\"", new Object[] { paramString });
      AppMethodBeat.o(128932);
      return paramc;
      paramc = new i.a("fail illegal operation on a filePath, open \"%s\"", new Object[] { paramString });
      AppMethodBeat.o(128932);
      return paramc;
      paramc = new i.a("fail permission denied, open \"%s\"", new Object[] { paramString });
      AppMethodBeat.o(128932);
      return paramc;
      paramc = new i.a("fail the maximum size of the file storage limit is exceeded", new Object[0]);
      AppMethodBeat.o(128932);
      return paramc;
      paramc = new i.a("fail read zip data", new Object[0]);
      AppMethodBeat.o(128932);
      return paramc;
      paramc = new i.a("fail write entry", new Object[0]);
      AppMethodBeat.o(128932);
      return paramc;
      paramc = new i.a("ok", new Object[0]);
      AppMethodBeat.o(128932);
      return paramc;
      label647:
      i = 0;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.file.bf
 * JD-Core Version:    0.7.0.1
 */