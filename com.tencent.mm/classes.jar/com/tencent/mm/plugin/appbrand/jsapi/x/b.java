package com.tencent.mm.plugin.appbrand.jsapi.x;

import com.tencent.mm.plugin.appbrand.appstorage.z;
import com.tencent.mm.plugin.appbrand.jsapi.d;
import com.tencent.mm.plugin.appbrand.jsapi.file.at;
import com.tencent.mm.plugin.appbrand.service.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.aa;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.s;
import java.io.IOException;
import org.json.JSONObject;

public abstract class b
  extends d<c>
{
  private static String YM(String paramString)
  {
    return "wxfile://clientdata/".concat(String.valueOf(paramString));
  }
  
  private static void YN(String paramString)
  {
    paramString = new o(paramString + ".nomedia");
    if (!paramString.exists()) {
      Log.i("MicroMsg.GameRecord.JsApiScreenRecorderBase", "hy: no nomedia file. trigger new");
    }
    try
    {
      paramString.createNewFile();
      return;
    }
    catch (IOException paramString)
    {
      Log.printErrStackTrace("MicroMsg.GameRecord.JsApiScreenRecorderBase", paramString, "hy: create no media file failed!", new Object[0]);
    }
  }
  
  private static String b(c paramc, String paramString)
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
    paramc = (at)paramc.getFileSystem();
    if (paramc == null)
    {
      Log.w("MicroMsg.GameRecord.JsApiScreenRecorderBase", "hy: fs is null");
      return null;
    }
    String str = ((z)paramc.Wj("wxfile://clientdata")).kSr;
    paramc = str;
    if (!str.endsWith("/")) {
      paramc = str + "/";
    }
    YN(paramc);
    return paramc + paramString;
  }
  
  protected static com.tencent.mm.plugin.appbrand.game.g.b d(c paramc)
  {
    return com.tencent.mm.plugin.appbrand.game.g.b.a("1234", null, paramc.getContext());
  }
  
  protected final a a(c paramc, String paramString1, String paramString2)
  {
    Log.i("MicroMsg.GameRecord.JsApiScreenRecorderBase", "hy: request saveFileToClientData: %s, %b, %b", new Object[] { paramString1, Boolean.TRUE, Boolean.TRUE });
    if (!s.YS(paramString1))
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
    if (s.YS(paramc))
    {
      Log.w("MicroMsg.GameRecord.JsApiScreenRecorderBase", "hy: file already exists, auto delete: %b", new Object[] { Boolean.TRUE });
      s.deleteFile(paramc);
    }
    o localo = new o(paramc);
    if (!s.cL(aa.z(new o(paramString1).mUri), aa.z(localo.mUri)))
    {
      Log.w("MicroMsg.GameRecord.JsApiScreenRecorderBase", "hy: rename failed!");
      return null;
    }
    return new a(paramc, YM(paramString2), (byte)0);
  }
  
  abstract void a(c paramc, JSONObject paramJSONObject, int paramInt);
  
  protected final a d(c paramc, String paramString)
  {
    paramc = b(paramc, paramString);
    if (paramc == null)
    {
      Log.e("MicroMsg.GameRecord.JsApiScreenRecorderBase", "hy: can not generate!");
      return null;
    }
    Log.i("MicroMsg.GameRecord.JsApiScreenRecorderBase", "hy: creating file: %s", new Object[] { paramc });
    if (s.YS(paramc))
    {
      Log.w("MicroMsg.GameRecord.JsApiScreenRecorderBase", "hy: file already exists, auto delete: %b", new Object[] { Boolean.TRUE });
      s.deleteFile(paramc);
    }
    o localo = new o(paramc);
    s.boN(s.boZ(paramc));
    try
    {
      if (!localo.createNewFile())
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
    return new a(aa.z(localo.her()), YM(paramString), (byte)0);
  }
  
  protected final class a
  {
    String lsB;
    String lsC;
    
    private a(String paramString1, String paramString2)
    {
      this.lsB = paramString1;
      this.lsC = paramString2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.x.b
 * JD-Core Version:    0.7.0.1
 */