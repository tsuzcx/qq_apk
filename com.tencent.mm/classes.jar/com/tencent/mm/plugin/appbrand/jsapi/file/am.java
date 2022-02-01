package com.tencent.mm.plugin.appbrand.jsapi.file;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appstorage.m;
import com.tencent.mm.plugin.appbrand.appstorage.q;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.m.a;
import com.tencent.mm.plugin.appbrand.y.i;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.vfs.k;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ThreadPoolExecutor;
import org.json.JSONObject;

public final class am
  extends a
{
  public static final int CTRL_INDEX = 51;
  public static final String NAME = "saveFile";
  
  public static String a(c paramc, k paramk, String paramString, i<String> parami)
  {
    AppMethodBeat.i(170099);
    if ((paramk == null) || (!paramk.exists()))
    {
      AppMethodBeat.o(170099);
      return "fail:file not exists";
    }
    Object localObject2 = paramc.Fl().Mc(paramString);
    Object localObject1 = localObject2;
    if (localObject2 != m.jPM) {}
    try
    {
      localObject2 = new i();
      paramc = paramc.Fl().a(paramk, paramString, (i)localObject2);
      localObject1 = paramc;
      if (parami != null)
      {
        parami.value = ((i)localObject2).value;
        localObject1 = paramc;
      }
      switch (2.kQn[localObject1.ordinal()])
      {
      default: 
        paramc = "fail " + ((m)localObject1).name();
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
    if (bu.isNullOrNil((String)localObject2))
    {
      ae.e("MicroMsg.JsApiSaveFile", "temp localId is null or nil");
      paramc = new m.a("fail", new Object[0]);
      AppMethodBeat.o(128899);
      return paramc;
    }
    localObject2 = paramc.Fl().MP((String)localObject2);
    if ((localObject2 == null) || (!((k)localObject2).exists()))
    {
      paramc = new m.a("fail tempFilePath file not exist", new Object[0]);
      AppMethodBeat.o(128899);
      return paramc;
    }
    paramJSONObject = new i();
    paramc = a(paramc, (k)localObject2, (String)localObject1, paramJSONObject);
    localObject1 = new HashMap();
    if ("ok".equals(paramc)) {
      ((Map)localObject1).put("savedFilePath", paramJSONObject.value);
    }
    paramc = new m.a(paramc, new Object[0]).F((Map)localObject1);
    AppMethodBeat.o(128899);
    return paramc;
  }
  
  public final void a(final c paramc, final JSONObject paramJSONObject, final int paramInt)
  {
    AppMethodBeat.i(128898);
    e.kPL.execute(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(128896);
        if (!paramc.isRunning())
        {
          AppMethodBeat.o(128896);
          return;
        }
        m.a locala = am.f(paramc, paramJSONObject);
        paramc.h(paramInt, am.this.n(locala.errMsg, locala.values));
        AppMethodBeat.o(128896);
      }
    });
    AppMethodBeat.o(128898);
  }
  
  public final boolean biK()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.file.am
 * JD-Core Version:    0.7.0.1
 */