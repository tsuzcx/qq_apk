package com.tencent.mm.plugin.appbrand.jsapi.file;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ac.i;
import com.tencent.mm.plugin.appbrand.appstorage.m;
import com.tencent.mm.plugin.appbrand.appstorage.o;
import com.tencent.mm.plugin.appbrand.appstorage.r;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.q;
import com.tencent.mm.vfs.u;
import java.io.IOException;
import java.net.URLEncoder;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.WritableByteChannel;
import org.json.JSONObject;

final class bk
  extends g
{
  protected final String Z(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(128933);
    paramJSONObject = paramJSONObject.optString("zipFilePath");
    AppMethodBeat.o(128933);
    return paramJSONObject;
  }
  
  final i.a a(e parame, String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(128932);
    String str = paramJSONObject.optString("targetDirectory", "");
    paramJSONObject = parame.getFileSystem().acV(str);
    switch (1.oSw[paramJSONObject.ordinal()])
    {
    default: 
      paramJSONObject = parame.getFileSystem().adL(paramString);
      if ((paramJSONObject != null) && (paramJSONObject.ifE())) {
        break label296;
      }
      if (parame.getFileSystem().acT(paramString) != m.nMR) {
        break label659;
      }
      paramJSONObject = parame.getFileSystem().adN(URLEncoder.encode(paramString));
      if (paramJSONObject != null)
      {
        localObject = new i();
        parame.getFileSystem().b(paramString, (i)localObject);
      }
      break;
    case 1: 
    case 2: 
    case 3: 
      try
      {
        Channels.newChannel(u.an(paramJSONObject)).write((ByteBuffer)((i)localObject).value);
        paramJSONObject = new q(paramJSONObject.bOF());
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
        break label341;
      }
      parame = new i.a("fail no such file \"%s\"", new Object[] { paramString });
      AppMethodBeat.o(128932);
      return parame;
      parame = new i.a(String.format("fail permission denied, open \"%s\"", new Object[] { str }), new Object[0]);
      AppMethodBeat.o(128932);
      return parame;
    }
    parame = new i.a("fail allocTempFile failed", new Object[0]);
    AppMethodBeat.o(128932);
    return parame;
    label296:
    if ((paramJSONObject.isDirectory()) || (o.t(paramJSONObject)))
    {
      parame = new i.a("fail permission denied, open \"%s\"", new Object[] { paramString });
      AppMethodBeat.o(128932);
      return parame;
    }
    int i = 0;
    Object localObject = paramJSONObject;
    for (;;)
    {
      try
      {
        label341:
        parame = parame.getFileSystem().a(str, (q)localObject);
        if (i != 0) {
          u.deleteFile(((q)localObject).bOF());
        }
        switch (1.oSw[parame.ordinal()])
        {
        case 2: 
        case 3: 
          parame = new i.a("fail " + parame.name(), new Object[0]);
          AppMethodBeat.o(128932);
          return parame;
        }
      }
      catch (Exception parame)
      {
        Log.printErrStackTrace("MicroMsg.AppBrand.FileSystem.UnitUnzip", parame, "write zip stream", new Object[0]);
        parame = new i.a("fail read zip data", new Object[0]);
        AppMethodBeat.o(128932);
        return parame;
      }
      parame = new i.a("fail no such file or directory, open \"%s\"", new Object[] { paramString });
      AppMethodBeat.o(128932);
      return parame;
      parame = new i.a("fail illegal operation on a filePath, open \"%s\"", new Object[] { paramString });
      AppMethodBeat.o(128932);
      return parame;
      parame = new i.a("fail permission denied, open \"%s\"", new Object[] { paramString });
      AppMethodBeat.o(128932);
      return parame;
      parame = new i.a("fail the maximum size of the file storage limit is exceeded", new Object[0]);
      AppMethodBeat.o(128932);
      return parame;
      parame = new i.a("fail read zip data", new Object[0]);
      AppMethodBeat.o(128932);
      return parame;
      parame = new i.a("fail write entry", new Object[0]);
      AppMethodBeat.o(128932);
      return parame;
      parame = new i.a("ok", new Object[0]);
      AppMethodBeat.o(128932);
      return parame;
      label659:
      i = 0;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.file.bk
 * JD-Core Version:    0.7.0.1
 */