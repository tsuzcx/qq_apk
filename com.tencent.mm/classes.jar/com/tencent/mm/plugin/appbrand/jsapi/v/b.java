package com.tencent.mm.plugin.appbrand.jsapi.v;

import com.tencent.mm.plugin.appbrand.appstorage.z;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.file.at;
import com.tencent.mm.plugin.appbrand.service.c;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.vfs.k;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.w;
import java.io.IOException;
import org.json.JSONObject;

public abstract class b
  extends a<c>
{
  private static String PB(String paramString)
  {
    return "wxfile://clientdata/".concat(String.valueOf(paramString));
  }
  
  private static void PC(String paramString)
  {
    paramString = new k(paramString + ".nomedia");
    if (!paramString.exists()) {
      ae.i("MicroMsg.GameRecord.JsApiScreenRecorderBase", "hy: no nomedia file. trigger new");
    }
    try
    {
      paramString.createNewFile();
      return;
    }
    catch (IOException paramString)
    {
      ae.printErrStackTrace("MicroMsg.GameRecord.JsApiScreenRecorderBase", paramString, "hy: create no media file failed!", new Object[0]);
    }
  }
  
  private static String b(c paramc, String paramString)
  {
    if ((paramc == null) || (bu.isNullOrNil(paramString)))
    {
      if (paramc == null) {}
      for (boolean bool = true;; bool = false)
      {
        ae.w("MicroMsg.GameRecord.JsApiScreenRecorderBase", "hy: param error %b, %s", new Object[] { Boolean.valueOf(bool), paramString });
        return null;
      }
    }
    paramc = (at)paramc.Fl();
    if (paramc == null)
    {
      ae.w("MicroMsg.GameRecord.JsApiScreenRecorderBase", "hy: fs is null");
      return null;
    }
    String str = ((z)paramc.Na("wxfile://clientdata")).jPJ;
    paramc = str;
    if (!str.endsWith("/")) {
      paramc = str + "/";
    }
    PC(paramc);
    return paramc + paramString;
  }
  
  protected final a a(c paramc, String paramString1, String paramString2)
  {
    ae.i("MicroMsg.GameRecord.JsApiScreenRecorderBase", "hy: request saveFileToClientData: %s, %b, %b", new Object[] { paramString1, Boolean.TRUE, Boolean.TRUE });
    if (!o.fB(paramString1))
    {
      ae.w("MicroMsg.GameRecord.JsApiScreenRecorderBase", "hy: src file not exists!");
      return null;
    }
    paramc = b(paramc, paramString2);
    if (paramc == null)
    {
      ae.w("MicroMsg.GameRecord.JsApiScreenRecorderBase", "hy: can not generate dest file!");
      return null;
    }
    if (o.fB(paramc))
    {
      ae.w("MicroMsg.GameRecord.JsApiScreenRecorderBase", "hy: file already exists, auto delete: %b", new Object[] { Boolean.TRUE });
      o.deleteFile(paramc);
    }
    k localk = new k(paramc);
    if (!o.cx(w.B(new k(paramString1).mUri), w.B(localk.mUri)))
    {
      ae.w("MicroMsg.GameRecord.JsApiScreenRecorderBase", "hy: rename failed!");
      return null;
    }
    return new a(paramc, PB(paramString2), (byte)0);
  }
  
  abstract void a(c paramc, JSONObject paramJSONObject, int paramInt);
  
  protected final a c(c paramc, String paramString)
  {
    paramc = b(paramc, paramString);
    if (paramc == null)
    {
      ae.e("MicroMsg.GameRecord.JsApiScreenRecorderBase", "hy: can not generate!");
      return null;
    }
    ae.i("MicroMsg.GameRecord.JsApiScreenRecorderBase", "hy: creating file: %s", new Object[] { paramc });
    if (o.fB(paramc))
    {
      ae.w("MicroMsg.GameRecord.JsApiScreenRecorderBase", "hy: file already exists, auto delete: %b", new Object[] { Boolean.TRUE });
      o.deleteFile(paramc);
    }
    k localk = new k(paramc);
    o.aZI(o.aZU(paramc));
    try
    {
      if (!localk.createNewFile())
      {
        ae.w("MicroMsg.GameRecord.JsApiScreenRecorderBase", "hy: create file failed!");
        return null;
      }
    }
    catch (IOException paramc)
    {
      ae.printErrStackTrace("MicroMsg.GameRecord.JsApiScreenRecorderBase", paramc, "hy: create file failed!", new Object[0]);
      return null;
    }
    return new a(w.B(localk.fTh()), PB(paramString), (byte)0);
  }
  
  protected final class a
  {
    String koS;
    String koT;
    
    private a(String paramString1, String paramString2)
    {
      this.koS = paramString1;
      this.koT = paramString2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.v.b
 * JD-Core Version:    0.7.0.1
 */