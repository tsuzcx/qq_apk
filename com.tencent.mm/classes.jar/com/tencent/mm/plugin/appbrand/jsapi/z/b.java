package com.tencent.mm.plugin.appbrand.jsapi.z;

import com.tencent.mm.plugin.appbrand.appstorage.ab;
import com.tencent.mm.plugin.appbrand.jsapi.file.av;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.q;
import com.tencent.mm.vfs.u;
import java.io.IOException;
import org.json.JSONObject;

public abstract class b
  extends com.tencent.mm.plugin.appbrand.jsapi.c<com.tencent.mm.plugin.appbrand.service.c>
{
  private static String agA(String paramString)
  {
    return "wxfile://clientdata/".concat(String.valueOf(paramString));
  }
  
  private static void agB(String paramString)
  {
    paramString = new q(paramString + ".nomedia");
    if (!paramString.ifE()) {
      Log.i("MicroMsg.GameRecord.JsApiScreenRecorderBase", "hy: no nomedia file. trigger new");
    }
    try
    {
      paramString.ifM();
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
    paramc = (av)paramc.getFileSystem();
    if (paramc == null)
    {
      Log.w("MicroMsg.GameRecord.JsApiScreenRecorderBase", "hy: fs is null");
      return null;
    }
    String str = ((ab)paramc.adY("wxfile://clientdata")).nMO;
    paramc = str;
    if (!str.endsWith("/")) {
      paramc = str + "/";
    }
    agB(paramc);
    return paramc + paramString;
  }
  
  protected static com.tencent.mm.plugin.appbrand.game.g.b e(com.tencent.mm.plugin.appbrand.service.c paramc)
  {
    return com.tencent.mm.plugin.appbrand.game.g.b.a("1234", null, paramc.getContext());
  }
  
  protected final a a(com.tencent.mm.plugin.appbrand.service.c paramc, String paramString1, String paramString2)
  {
    Log.i("MicroMsg.GameRecord.JsApiScreenRecorderBase", "hy: request saveFileToClientData: %s, %b, %b", new Object[] { paramString1, Boolean.TRUE, Boolean.TRUE });
    if (!u.agG(paramString1))
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
    if (u.agG(paramc))
    {
      Log.w("MicroMsg.GameRecord.JsApiScreenRecorderBase", "hy: file already exists, auto delete: %b", new Object[] { Boolean.TRUE });
      u.deleteFile(paramc);
    }
    q localq = new q(paramc);
    if (!u.or(new q(paramString1).getPath(), localq.getPath()))
    {
      Log.w("MicroMsg.GameRecord.JsApiScreenRecorderBase", "hy: rename failed!");
      return null;
    }
    return new a(paramc, agA(paramString2), (byte)0);
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
    if (u.agG(paramc))
    {
      Log.w("MicroMsg.GameRecord.JsApiScreenRecorderBase", "hy: file already exists, auto delete: %b", new Object[] { Boolean.TRUE });
      u.deleteFile(paramc);
    }
    q localq = new q(paramc);
    u.bBD(u.bBT(paramc));
    try
    {
      if (!localq.ifM())
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
    return new a(localq.bOF(), agA(paramString), (byte)0);
  }
  
  protected final class a
  {
    String ony;
    String onz;
    
    private a(String paramString1, String paramString2)
    {
      this.ony = paramString1;
      this.onz = paramString2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.z.b
 * JD-Core Version:    0.7.0.1
 */