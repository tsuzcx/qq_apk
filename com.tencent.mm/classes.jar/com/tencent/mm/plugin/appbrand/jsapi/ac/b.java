package com.tencent.mm.plugin.appbrand.jsapi.ac;

import com.tencent.mm.plugin.appbrand.appstorage.af;
import com.tencent.mm.plugin.appbrand.jsapi.file.ax;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.ah;
import com.tencent.mm.vfs.u;
import com.tencent.mm.vfs.y;
import java.io.IOException;
import org.json.JSONObject;

public abstract class b
  extends com.tencent.mm.plugin.appbrand.jsapi.c<com.tencent.mm.plugin.appbrand.service.c>
{
  private static String Zw(String paramString)
  {
    return "wxfile://clientdata/".concat(String.valueOf(paramString));
  }
  
  private static void Zx(String paramString)
  {
    paramString = new u(paramString + ".nomedia");
    if (!paramString.jKS()) {
      Log.i("MicroMsg.GameRecord.JsApiScreenRecorderBase", "hy: no nomedia file. trigger new");
    }
    try
    {
      paramString.jKZ();
      return;
    }
    catch (IOException paramString)
    {
      Log.printErrStackTrace("MicroMsg.GameRecord.JsApiScreenRecorderBase", paramString, "hy: create no media file failed!", new Object[0]);
    }
  }
  
  private static String b(com.tencent.mm.plugin.appbrand.service.c paramc, String paramString)
  {
    if ((paramc == null) || (Util.isNullOrNil(paramString)))
    {
      if (paramc == null) {}
      for (boolean bool = true;; bool = false)
      {
        Log.w("MicroMsg.GameRecord.JsApiScreenRecorderBase", "hy: param error %b, %s", new Object[] { Boolean.valueOf(bool), paramString });
        return null;
      }
    }
    paramc = (ax)paramc.getFileSystem();
    if (paramc == null)
    {
      Log.w("MicroMsg.GameRecord.JsApiScreenRecorderBase", "hy: fs is null");
      return null;
    }
    String str = ((af)paramc.Wy("wxfile://clientdata")).qMI;
    paramc = str;
    if (!str.endsWith("/")) {
      paramc = str + "/";
    }
    Zx(paramc);
    return paramc + paramString;
  }
  
  protected static com.tencent.mm.plugin.appbrand.game.g.b e(com.tencent.mm.plugin.appbrand.service.c paramc)
  {
    return com.tencent.mm.plugin.appbrand.game.g.b.a("1234", null, paramc.getContext());
  }
  
  protected final a a(com.tencent.mm.plugin.appbrand.service.c paramc, String paramString1, String paramString2)
  {
    Log.i("MicroMsg.GameRecord.JsApiScreenRecorderBase", "hy: request saveFileToClientData: %s, %b, %b", new Object[] { paramString1, Boolean.TRUE, Boolean.TRUE });
    if (!y.ZC(paramString1))
    {
      Log.w("MicroMsg.GameRecord.JsApiScreenRecorderBase", "hy: src file not exists!");
      return null;
    }
    paramc = b(paramc, paramString2);
    if (paramc == null)
    {
      Log.w("MicroMsg.GameRecord.JsApiScreenRecorderBase", "hy: can not generate dest file!");
      return null;
    }
    if (y.ZC(paramc))
    {
      Log.w("MicroMsg.GameRecord.JsApiScreenRecorderBase", "hy: file already exists, auto delete: %b", new Object[] { Boolean.TRUE });
      y.deleteFile(paramc);
    }
    u localu = new u(paramc);
    if (!y.qp(ah.v(new u(paramString1).mUri), ah.v(localu.mUri)))
    {
      Log.w("MicroMsg.GameRecord.JsApiScreenRecorderBase", "hy: rename failed!");
      return null;
    }
    return new a(paramc, Zw(paramString2), (byte)0);
  }
  
  abstract void a(com.tencent.mm.plugin.appbrand.service.c paramc, JSONObject paramJSONObject, int paramInt);
  
  protected final a d(com.tencent.mm.plugin.appbrand.service.c paramc, String paramString)
  {
    paramc = b(paramc, paramString);
    if (paramc == null)
    {
      Log.e("MicroMsg.GameRecord.JsApiScreenRecorderBase", "hy: can not generate!");
      return null;
    }
    Log.i("MicroMsg.GameRecord.JsApiScreenRecorderBase", "hy: creating file: %s", new Object[] { paramc });
    if (y.ZC(paramc))
    {
      Log.w("MicroMsg.GameRecord.JsApiScreenRecorderBase", "hy: file already exists, auto delete: %b", new Object[] { Boolean.TRUE });
      y.deleteFile(paramc);
    }
    u localu = new u(paramc);
    y.bDX(y.bEo(paramc));
    try
    {
      if (!localu.jKZ())
      {
        Log.w("MicroMsg.GameRecord.JsApiScreenRecorderBase", "hy: create file failed!");
        return null;
      }
    }
    catch (IOException paramc)
    {
      Log.printErrStackTrace("MicroMsg.GameRecord.JsApiScreenRecorderBase", paramc, "hy: create file failed!", new Object[0]);
      return null;
    }
    return new a(ah.v(localu.jKT()), Zw(paramString), (byte)0);
  }
  
  protected final class a
  {
    String rrh;
    String rri;
    
    private a(String paramString1, String paramString2)
    {
      this.rrh = paramString1;
      this.rri = paramString2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.ac.b
 * JD-Core Version:    0.7.0.1
 */