package com.tencent.mm.plugin.appbrand.game.e.a;

import com.tencent.magicbrush.ui.MagicBrushView;
import com.tencent.mm.plugin.appbrand.appstorage.z;
import com.tencent.mm.plugin.appbrand.game.f.a;
import com.tencent.mm.plugin.appbrand.game.g.c.a;
import com.tencent.mm.plugin.appbrand.jsapi.d;
import com.tencent.mm.plugin.appbrand.jsapi.file.at;
import com.tencent.mm.plugin.appbrand.page.ac;
import com.tencent.mm.plugin.appbrand.service.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.aa;
import com.tencent.mm.vfs.o;
import java.io.IOException;

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
      Log.i("MicroMsg.WAGameJsApiScreenRecorderBase", "hy: no nomedia file. trigger new");
    }
    try
    {
      paramString.createNewFile();
      return;
    }
    catch (IOException paramString)
    {
      Log.printErrStackTrace("MicroMsg.WAGameJsApiScreenRecorderBase", paramString, "hy: create no media file failed!", new Object[0]);
    }
  }
  
  private static String b(c paramc, String paramString)
  {
    if ((paramc == null) || (Util.isNullOrNil(paramString)))
    {
      if (paramc == null) {}
      for (boolean bool = true;; bool = false)
      {
        Log.w("MicroMsg.WAGameJsApiScreenRecorderBase", "hy: param error %b, %s", new Object[] { Boolean.valueOf(bool), paramString });
        return null;
      }
    }
    paramc = (at)paramc.getFileSystem();
    if (paramc == null)
    {
      Log.w("MicroMsg.WAGameJsApiScreenRecorderBase", "hy: fs is null");
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
  
  public static com.tencent.mm.plugin.appbrand.game.g.b g(com.tencent.mm.plugin.appbrand.s params)
  {
    return com.tencent.mm.plugin.appbrand.game.g.b.a(params.getAppId(), h(params), params.getContext());
  }
  
  protected static MagicBrushView h(com.tencent.mm.plugin.appbrand.s params)
  {
    params = (a)params.getCurrentPageView().S(a.class);
    if (params == null) {
      return null;
    }
    return params.MQ();
  }
  
  protected final a a(c paramc, String paramString)
  {
    paramc = b(paramc, paramString);
    if (paramc == null)
    {
      Log.e("MicroMsg.WAGameJsApiScreenRecorderBase", "hy: can not generate!");
      return null;
    }
    Log.i("MicroMsg.WAGameJsApiScreenRecorderBase", "hy: creating file: %s", new Object[] { paramc });
    if (com.tencent.mm.vfs.s.YS(paramc))
    {
      Log.w("MicroMsg.WAGameJsApiScreenRecorderBase", "hy: file already exists, auto delete: %b", new Object[] { Boolean.TRUE });
      com.tencent.mm.vfs.s.deleteFile(paramc);
    }
    o localo = new o(paramc);
    com.tencent.mm.vfs.s.boN(com.tencent.mm.vfs.s.boZ(paramc));
    try
    {
      if (!localo.createNewFile())
      {
        Log.w("MicroMsg.WAGameJsApiScreenRecorderBase", "hy: create file failed!");
        return null;
      }
    }
    catch (IOException paramc)
    {
      Log.printErrStackTrace("MicroMsg.WAGameJsApiScreenRecorderBase", paramc, "hy: create file failed!", new Object[0]);
      return null;
    }
    return new a(aa.z(localo.her()), YM(paramString), (byte)0);
  }
  
  protected final a a(c paramc, String paramString1, String paramString2, boolean paramBoolean)
  {
    Log.i("MicroMsg.WAGameJsApiScreenRecorderBase", "hy: request saveFileToClientData: %s, %b, %b", new Object[] { paramString1, Boolean.TRUE, Boolean.valueOf(paramBoolean) });
    if (!com.tencent.mm.vfs.s.YS(paramString1))
    {
      Log.w("MicroMsg.WAGameJsApiScreenRecorderBase", "hy: src file not exists!");
      return null;
    }
    paramc = b(paramc, paramString2);
    if (paramc == null)
    {
      Log.w("MicroMsg.WAGameJsApiScreenRecorderBase", "hy: can not generate dest file!");
      return null;
    }
    if (com.tencent.mm.vfs.s.YS(paramc))
    {
      Log.w("MicroMsg.WAGameJsApiScreenRecorderBase", "hy: file already exists, auto delete: %b", new Object[] { Boolean.TRUE });
      com.tencent.mm.vfs.s.deleteFile(paramc);
    }
    o localo = new o(paramc);
    if (paramBoolean)
    {
      if (!com.tencent.mm.vfs.s.nx(aa.z(new o(paramString1).mUri), aa.z(localo.mUri)))
      {
        Log.w("MicroMsg.WAGameJsApiScreenRecorderBase", "hy: rename failed!");
        return null;
      }
    }
    else if (com.tencent.mm.vfs.s.nw(paramString1, paramc) <= 0L)
    {
      Log.w("MicroMsg.WAGameJsApiScreenRecorderBase", "hy: copy failed!");
      return null;
    }
    return new a(paramc, YM(paramString2), (byte)0);
  }
  
  protected final class a
    implements c.a
  {
    String lsB;
    String lsC;
    
    private a(String paramString1, String paramString2)
    {
      this.lsB = paramString1;
      this.lsC = paramString2;
    }
    
    public final String getAbsolutePath()
    {
      return this.lsB;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.game.e.a.b
 * JD-Core Version:    0.7.0.1
 */