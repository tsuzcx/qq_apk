package com.tencent.mm.plugin.appbrand.jsapi.file;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.aa.i;
import com.tencent.mm.plugin.appbrand.appstorage.l;
import com.tencent.mm.plugin.appbrand.appstorage.p;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.m.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ThreadPoolExecutor;
import org.json.JSONObject;

public final class ak
  extends a
{
  public static final int CTRL_INDEX = 51;
  public static final String NAME = "saveFile";
  
  public static String a(c paramc, com.tencent.mm.vfs.e parame, String paramString, i<String> parami)
  {
    AppMethodBeat.i(170099);
    if ((parame == null) || (!parame.exists()))
    {
      AppMethodBeat.o(170099);
      return "fail:file not exists";
    }
    Object localObject2 = paramc.Ee().Ee(paramString);
    Object localObject1 = localObject2;
    if (localObject2 != l.iSq) {}
    try
    {
      localObject2 = new i();
      paramc = paramc.Ee().a(parame, paramString, (i)localObject2);
      localObject1 = paramc;
      if (parami != null)
      {
        parami.value = ((i)localObject2).value;
        localObject1 = paramc;
      }
      switch (2.jQL[localObject1.ordinal()])
      {
      default: 
        paramc = "fail " + ((l)localObject1).name();
        AppMethodBeat.o(170099);
        return paramc;
      }
    }
    catch (Exception paramc)
    {
      paramc = "fail:writeFile exception: " + paramc.toString();
      AppMethodBeat.o(170099);
      return paramc;
    }
    paramc = String.format("fail permission denied, open \"%s\"", new Object[] { paramString });
    AppMethodBeat.o(170099);
    return paramc;
    paramc = String.format("fail no such file or directory \"%s\"", new Object[] { paramString });
    AppMethodBeat.o(170099);
    return paramc;
    paramc = String.format("fail illegal operation on a directory, open \"%s\"", new Object[] { paramString });
    AppMethodBeat.o(170099);
    return paramc;
    AppMethodBeat.o(170099);
    return "fail the maximum size of the file storage limit is exceeded";
    AppMethodBeat.o(170099);
    return "ok";
  }
  
  static m.a f(c paramc, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(128899);
    Object localObject2 = paramJSONObject.optString("tempFilePath");
    Object localObject1 = paramJSONObject.optString("filePath");
    if (bt.isNullOrNil((String)localObject2))
    {
      ad.e("MicroMsg.JsApiSaveFile", "temp localId is null or nil");
      paramc = new m.a("fail", new Object[0]);
      AppMethodBeat.o(128899);
      return paramc;
    }
    localObject2 = paramc.Ee().EP((String)localObject2);
    if ((localObject2 == null) || (!((com.tencent.mm.vfs.e)localObject2).exists()))
    {
      paramc = new m.a("fail tempFilePath file not exist", new Object[0]);
      AppMethodBeat.o(128899);
      return paramc;
    }
    paramJSONObject = new i();
    paramc = a(paramc, (com.tencent.mm.vfs.e)localObject2, (String)localObject1, paramJSONObject);
    localObject1 = new HashMap();
    if ("ok".equals(paramc)) {
      ((Map)localObject1).put("savedFilePath", paramJSONObject.value);
    }
    paramc = new m.a(paramc, new Object[0]).z((Map)localObject1);
    AppMethodBeat.o(128899);
    return paramc;
  }
  
  public final void a(final c paramc, final JSONObject paramJSONObject, final int paramInt)
  {
    AppMethodBeat.i(128898);
    e.jQn.execute(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(128896);
        if (!paramc.isRunning())
        {
          AppMethodBeat.o(128896);
          return;
        }
        m.a locala = ak.f(paramc, paramJSONObject);
        paramc.h(paramInt, ak.this.k(locala.errMsg, locala.values));
        AppMethodBeat.o(128896);
      }
    });
    AppMethodBeat.o(128898);
  }
  
  public final boolean aXA()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.file.ak
 * JD-Core Version:    0.7.0.1
 */