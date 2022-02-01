package com.tencent.mm.plugin.appbrand.jsapi.file;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ac.i;
import com.tencent.mm.plugin.appbrand.appstorage.m;
import com.tencent.mm.plugin.appbrand.appstorage.r;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.o.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.q;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ThreadPoolExecutor;
import org.json.JSONObject;

public final class ao
  extends c
{
  public static final int CTRL_INDEX = 51;
  public static final String NAME = "saveFile";
  
  public static String a(com.tencent.mm.plugin.appbrand.jsapi.e parame, q paramq, String paramString, i<String> parami)
  {
    AppMethodBeat.i(170099);
    if ((paramq == null) || (!paramq.ifE()))
    {
      AppMethodBeat.o(170099);
      return "fail:file not exists";
    }
    Object localObject2 = parame.getFileSystem().acV(paramString);
    Object localObject1 = localObject2;
    if (localObject2 != m.nMR) {}
    try
    {
      localObject2 = new i();
      parame = parame.getFileSystem().a(paramq, paramString, (i)localObject2);
      localObject1 = parame;
      if (parami != null)
      {
        parami.value = ((i)localObject2).value;
        localObject1 = parame;
      }
      switch (2.oSw[localObject1.ordinal()])
      {
      default: 
        parame = "fail " + ((m)localObject1).name();
        AppMethodBeat.o(170099);
        return parame;
      }
    }
    catch (Exception parame)
    {
      parame = "fail:writeFile exception: " + parame.toString();
      AppMethodBeat.o(170099);
      return parame;
    }
    parame = String.format("fail permission denied, open \"%s\"", new Object[] { paramString });
    AppMethodBeat.o(170099);
    return parame;
    parame = String.format("fail no such file or directory \"%s\"", new Object[] { paramString });
    AppMethodBeat.o(170099);
    return parame;
    parame = String.format("fail illegal operation on a directory, open \"%s\"", new Object[] { paramString });
    AppMethodBeat.o(170099);
    return parame;
    AppMethodBeat.o(170099);
    return "fail the maximum size of the file storage limit is exceeded";
    AppMethodBeat.o(170099);
    return "ok";
  }
  
  static o.a e(com.tencent.mm.plugin.appbrand.jsapi.e parame, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(128899);
    Object localObject2 = paramJSONObject.optString("tempFilePath");
    Object localObject1 = paramJSONObject.optString("filePath");
    if (Util.isNullOrNil((String)localObject2))
    {
      Log.e("MicroMsg.JsApiSaveFile", "temp localId is null or nil");
      parame = new o.a("fail", new Object[0]);
      AppMethodBeat.o(128899);
      return parame;
    }
    localObject2 = parame.getFileSystem().adL((String)localObject2);
    if ((localObject2 == null) || (!((q)localObject2).ifE()))
    {
      Log.e("MicroMsg.JsApiSaveFile", "fail tempFilePath file not exist");
      parame = new o.a("fail tempFilePath file not exist", new Object[0]);
      AppMethodBeat.o(128899);
      return parame;
    }
    paramJSONObject = new i();
    parame = a(parame, (q)localObject2, (String)localObject1, paramJSONObject);
    localObject1 = new HashMap();
    if ("ok".equals(parame)) {
      ((Map)localObject1).put("savedFilePath", paramJSONObject.value);
    }
    parame = new o.a(parame, new Object[0]).B((Map)localObject1);
    AppMethodBeat.o(128899);
    return parame;
  }
  
  public final void a(final com.tencent.mm.plugin.appbrand.jsapi.e parame, final JSONObject paramJSONObject, final int paramInt)
  {
    AppMethodBeat.i(128898);
    e.oRI.execute(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(128896);
        if (!parame.isRunning())
        {
          AppMethodBeat.o(128896);
          return;
        }
        o.a locala = ao.e(parame, paramJSONObject);
        parame.j(paramInt, ao.this.m(locala.errMsg, locala.values));
        AppMethodBeat.o(128896);
      }
    });
    AppMethodBeat.o(128898);
  }
  
  public final boolean bPy()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.file.ao
 * JD-Core Version:    0.7.0.1
 */