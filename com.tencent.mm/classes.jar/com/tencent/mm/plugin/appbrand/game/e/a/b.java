package com.tencent.mm.plugin.appbrand.game.e.a;

import com.tencent.magicbrush.ui.MagicBrushView;
import com.tencent.mm.plugin.appbrand.appstorage.af;
import com.tencent.mm.plugin.appbrand.game.f.a;
import com.tencent.mm.plugin.appbrand.game.g.c.a;
import com.tencent.mm.plugin.appbrand.jsapi.file.ax;
import com.tencent.mm.plugin.appbrand.page.ad;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.ah;
import com.tencent.mm.vfs.u;
import java.io.IOException;

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
      Log.i("MicroMsg.WAGameJsApiScreenRecorderBase", "hy: no nomedia file. trigger new");
    }
    try
    {
      paramString.jKZ();
      return;
    }
    catch (IOException paramString)
    {
      Log.printErrStackTrace("MicroMsg.WAGameJsApiScreenRecorderBase", paramString, "hy: create no media file failed!", new Object[0]);
    }
  }
  
  private static String b(com.tencent.mm.plugin.appbrand.service.c paramc, String paramString)
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
    paramc = (ax)paramc.getFileSystem();
    if (paramc == null)
    {
      Log.w("MicroMsg.WAGameJsApiScreenRecorderBase", "hy: fs is null");
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
  
  public static com.tencent.mm.plugin.appbrand.game.g.b h(com.tencent.mm.plugin.appbrand.y paramy)
  {
    return com.tencent.mm.plugin.appbrand.game.g.b.a(paramy.getAppId(), i(paramy), paramy.getContext());
  }
  
  protected static MagicBrushView i(com.tencent.mm.plugin.appbrand.y paramy)
  {
    paramy = (a)paramy.getCurrentPageView().aa(a.class);
    if (paramy == null) {
      return null;
    }
    return paramy.apS();
  }
  
  protected final a a(com.tencent.mm.plugin.appbrand.service.c paramc, String paramString)
  {
    paramc = b(paramc, paramString);
    if (paramc == null)
    {
      Log.e("MicroMsg.WAGameJsApiScreenRecorderBase", "hy: can not generate!");
      return null;
    }
    Log.i("MicroMsg.WAGameJsApiScreenRecorderBase", "hy: creating file: %s", new Object[] { paramc });
    if (com.tencent.mm.vfs.y.ZC(paramc))
    {
      Log.w("MicroMsg.WAGameJsApiScreenRecorderBase", "hy: file already exists, auto delete: %b", new Object[] { Boolean.TRUE });
      com.tencent.mm.vfs.y.deleteFile(paramc);
    }
    u localu = new u(paramc);
    com.tencent.mm.vfs.y.bDX(com.tencent.mm.vfs.y.bEo(paramc));
    try
    {
      if (!localu.jKZ())
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
    return new a(ah.v(localu.jKT()), Zw(paramString), (byte)0);
  }
  
  protected final a a(com.tencent.mm.plugin.appbrand.service.c paramc, String paramString1, String paramString2, boolean paramBoolean)
  {
    Log.i("MicroMsg.WAGameJsApiScreenRecorderBase", "hy: request saveFileToClientData: %s, %b, %b", new Object[] { paramString1, Boolean.TRUE, Boolean.valueOf(paramBoolean) });
    if (!com.tencent.mm.vfs.y.ZC(paramString1))
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
    if (com.tencent.mm.vfs.y.ZC(paramc))
    {
      Log.w("MicroMsg.WAGameJsApiScreenRecorderBase", "hy: file already exists, auto delete: %b", new Object[] { Boolean.TRUE });
      com.tencent.mm.vfs.y.deleteFile(paramc);
    }
    u localu = new u(paramc);
    if (paramBoolean)
    {
      if (!com.tencent.mm.vfs.y.qn(ah.v(new u(paramString1).mUri), ah.v(localu.mUri)))
      {
        Log.w("MicroMsg.WAGameJsApiScreenRecorderBase", "hy: rename failed!");
        return null;
      }
    }
    else if (com.tencent.mm.vfs.y.O(paramString1, paramc, false) <= 0L)
    {
      Log.w("MicroMsg.WAGameJsApiScreenRecorderBase", "hy: copy failed!");
      return null;
    }
    return new a(paramc, Zw(paramString2), (byte)0);
  }
  
  protected final class a
    implements c.a
  {
    String rrh;
    String rri;
    
    private a(String paramString1, String paramString2)
    {
      this.rrh = paramString1;
      this.rri = paramString2;
    }
    
    public final String coT()
    {
      return this.rrh;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.game.e.a.b
 * JD-Core Version:    0.7.0.1
 */