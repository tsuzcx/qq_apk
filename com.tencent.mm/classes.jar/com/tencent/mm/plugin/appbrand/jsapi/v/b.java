package com.tencent.mm.plugin.appbrand.jsapi.v;

import com.tencent.mm.plugin.appbrand.appstorage.x;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.file.ar;
import com.tencent.mm.plugin.appbrand.service.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.vfs.e;
import com.tencent.mm.vfs.i;
import com.tencent.mm.vfs.q;
import java.io.IOException;
import org.json.JSONObject;

public abstract class b
  extends a<c>
{
  private static String OT(String paramString)
  {
    return "wxfile://clientdata/".concat(String.valueOf(paramString));
  }
  
  private static void OU(String paramString)
  {
    paramString = new e(paramString + ".nomedia");
    if (!paramString.exists()) {
      ad.i("MicroMsg.GameRecord.JsApiScreenRecorderBase", "hy: no nomedia file. trigger new");
    }
    try
    {
      paramString.createNewFile();
      return;
    }
    catch (IOException paramString)
    {
      ad.printErrStackTrace("MicroMsg.GameRecord.JsApiScreenRecorderBase", paramString, "hy: create no media file failed!", new Object[0]);
    }
  }
  
  private static String b(c paramc, String paramString)
  {
    if ((paramc == null) || (bt.isNullOrNil(paramString)))
    {
      if (paramc == null) {}
      for (boolean bool = true;; bool = false)
      {
        ad.w("MicroMsg.GameRecord.JsApiScreenRecorderBase", "hy: param error %b, %s", new Object[] { Boolean.valueOf(bool), paramString });
        return null;
      }
    }
    paramc = (ar)paramc.Fg();
    if (paramc == null)
    {
      ad.w("MicroMsg.GameRecord.JsApiScreenRecorderBase", "hy: fs is null");
      return null;
    }
    String str = ((x)paramc.Mt("wxfile://clientdata")).jMN;
    paramc = str;
    if (!str.endsWith("/")) {
      paramc = str + "/";
    }
    OU(paramc);
    return paramc + paramString;
  }
  
  protected final a a(c paramc, String paramString1, String paramString2)
  {
    ad.i("MicroMsg.GameRecord.JsApiScreenRecorderBase", "hy: request saveFileToClientData: %s, %b, %b", new Object[] { paramString1, Boolean.TRUE, Boolean.TRUE });
    if (!i.fv(paramString1))
    {
      ad.w("MicroMsg.GameRecord.JsApiScreenRecorderBase", "hy: src file not exists!");
      return null;
    }
    paramc = b(paramc, paramString2);
    if (paramc == null)
    {
      ad.w("MicroMsg.GameRecord.JsApiScreenRecorderBase", "hy: can not generate dest file!");
      return null;
    }
    if (i.fv(paramc))
    {
      ad.w("MicroMsg.GameRecord.JsApiScreenRecorderBase", "hy: file already exists, auto delete: %b", new Object[] { Boolean.TRUE });
      i.deleteFile(paramc);
    }
    e locale = new e(paramc);
    if (!i.cv(q.B(new e(paramString1).mUri), q.B(locale.mUri)))
    {
      ad.w("MicroMsg.GameRecord.JsApiScreenRecorderBase", "hy: rename failed!");
      return null;
    }
    return new a(paramc, OT(paramString2), (byte)0);
  }
  
  abstract void a(c paramc, JSONObject paramJSONObject, int paramInt);
  
  protected final a c(c paramc, String paramString)
  {
    paramc = b(paramc, paramString);
    if (paramc == null)
    {
      ad.e("MicroMsg.GameRecord.JsApiScreenRecorderBase", "hy: can not generate!");
      return null;
    }
    ad.i("MicroMsg.GameRecord.JsApiScreenRecorderBase", "hy: creating file: %s", new Object[] { paramc });
    if (i.fv(paramc))
    {
      ad.w("MicroMsg.GameRecord.JsApiScreenRecorderBase", "hy: file already exists, auto delete: %b", new Object[] { Boolean.TRUE });
      i.deleteFile(paramc);
    }
    e locale = new e(paramc);
    i.aYg(i.aYr(paramc));
    try
    {
      if (!locale.createNewFile())
      {
        ad.w("MicroMsg.GameRecord.JsApiScreenRecorderBase", "hy: create file failed!");
        return null;
      }
    }
    catch (IOException paramc)
    {
      ad.printErrStackTrace("MicroMsg.GameRecord.JsApiScreenRecorderBase", paramc, "hy: create file failed!", new Object[0]);
      return null;
    }
    return new a(q.B(locale.fOK()), OT(paramString), (byte)0);
  }
  
  protected final class a
  {
    String klC;
    String klD;
    
    private a(String paramString1, String paramString2)
    {
      this.klC = paramString1;
      this.klD = paramString2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.v.b
 * JD-Core Version:    0.7.0.1
 */