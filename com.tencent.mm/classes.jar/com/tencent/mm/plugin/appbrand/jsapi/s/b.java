package com.tencent.mm.plugin.appbrand.jsapi.s;

import com.tencent.mm.plugin.appbrand.appstorage.x;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.file.ar;
import com.tencent.mm.plugin.appbrand.service.c;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.vfs.e;
import com.tencent.mm.vfs.i;
import com.tencent.mm.vfs.q;
import java.io.IOException;
import org.json.JSONObject;

public abstract class b
  extends a<c>
{
  private static void LA(String paramString)
  {
    paramString = new e(paramString + ".nomedia");
    if (!paramString.exists()) {
      ac.i("MicroMsg.GameRecord.JsApiScreenRecorderBase", "hy: no nomedia file. trigger new");
    }
    try
    {
      paramString.createNewFile();
      return;
    }
    catch (IOException paramString)
    {
      ac.printErrStackTrace("MicroMsg.GameRecord.JsApiScreenRecorderBase", paramString, "hy: create no media file failed!", new Object[0]);
    }
  }
  
  private static String Lz(String paramString)
  {
    return "wxfile://clientdata/".concat(String.valueOf(paramString));
  }
  
  private static String b(c paramc, String paramString)
  {
    if ((paramc == null) || (bs.isNullOrNil(paramString)))
    {
      if (paramc == null) {}
      for (boolean bool = true;; bool = false)
      {
        ac.w("MicroMsg.GameRecord.JsApiScreenRecorderBase", "hy: param error %b, %s", new Object[] { Boolean.valueOf(bool), paramString });
        return null;
      }
    }
    paramc = (ar)paramc.DH();
    if (paramc == null)
    {
      ac.w("MicroMsg.GameRecord.JsApiScreenRecorderBase", "hy: fs is null");
      return null;
    }
    String str = ((x)paramc.Jc("wxfile://clientdata")).jsT;
    paramc = str;
    if (!str.endsWith("/")) {
      paramc = str + "/";
    }
    LA(paramc);
    return paramc + paramString;
  }
  
  protected final a a(c paramc, String paramString1, String paramString2)
  {
    ac.i("MicroMsg.GameRecord.JsApiScreenRecorderBase", "hy: request saveFileToClientData: %s, %b, %b", new Object[] { paramString1, Boolean.TRUE, Boolean.TRUE });
    if (!i.eA(paramString1))
    {
      ac.w("MicroMsg.GameRecord.JsApiScreenRecorderBase", "hy: src file not exists!");
      return null;
    }
    paramc = b(paramc, paramString2);
    if (paramc == null)
    {
      ac.w("MicroMsg.GameRecord.JsApiScreenRecorderBase", "hy: can not generate dest file!");
      return null;
    }
    if (i.eA(paramc))
    {
      ac.w("MicroMsg.GameRecord.JsApiScreenRecorderBase", "hy: file already exists, auto delete: %b", new Object[] { Boolean.TRUE });
      i.deleteFile(paramc);
    }
    e locale = new e(paramc);
    if (!i.ct(q.B(new e(paramString1).mUri), q.B(locale.mUri)))
    {
      ac.w("MicroMsg.GameRecord.JsApiScreenRecorderBase", "hy: rename failed!");
      return null;
    }
    return new a(paramc, Lz(paramString2), (byte)0);
  }
  
  abstract void a(c paramc, JSONObject paramJSONObject, int paramInt);
  
  protected final a c(c paramc, String paramString)
  {
    paramc = b(paramc, paramString);
    if (paramc == null)
    {
      ac.e("MicroMsg.GameRecord.JsApiScreenRecorderBase", "hy: can not generate!");
      return null;
    }
    ac.i("MicroMsg.GameRecord.JsApiScreenRecorderBase", "hy: creating file: %s", new Object[] { paramc });
    if (i.eA(paramc))
    {
      ac.w("MicroMsg.GameRecord.JsApiScreenRecorderBase", "hy: file already exists, auto delete: %b", new Object[] { Boolean.TRUE });
      i.deleteFile(paramc);
    }
    e locale = new e(paramc);
    i.aSh(i.aSs(paramc));
    try
    {
      if (!locale.createNewFile())
      {
        ac.w("MicroMsg.GameRecord.JsApiScreenRecorderBase", "hy: create file failed!");
        return null;
      }
    }
    catch (IOException paramc)
    {
      ac.printErrStackTrace("MicroMsg.GameRecord.JsApiScreenRecorderBase", paramc, "hy: create file failed!", new Object[0]);
      return null;
    }
    return new a(q.B(locale.fxV()), Lz(paramString), (byte)0);
  }
  
  protected final class a
  {
    String jRo;
    String jRp;
    
    private a(String paramString1, String paramString2)
    {
      this.jRo = paramString1;
      this.jRp = paramString2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.s.b
 * JD-Core Version:    0.7.0.1
 */