package com.tencent.mm.plugin.appbrand.game.e.a;

import com.tencent.magicbrush.ui.MagicBrushView;
import com.tencent.mm.plugin.appbrand.appstorage.ab;
import com.tencent.mm.plugin.appbrand.game.f.a;
import com.tencent.mm.plugin.appbrand.game.g.c.a;
import com.tencent.mm.plugin.appbrand.jsapi.file.av;
import com.tencent.mm.plugin.appbrand.page.ad;
import com.tencent.mm.plugin.appbrand.v;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.q;
import com.tencent.mm.vfs.u;
import java.io.IOException;

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
      Log.i("MicroMsg.WAGameJsApiScreenRecorderBase", "hy: no nomedia file. trigger new");
    }
    try
    {
      paramString.ifM();
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
    paramc = (av)paramc.getFileSystem();
    if (paramc == null)
    {
      Log.w("MicroMsg.WAGameJsApiScreenRecorderBase", "hy: fs is null");
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
  
  public static com.tencent.mm.plugin.appbrand.game.g.b g(v paramv)
  {
    return com.tencent.mm.plugin.appbrand.game.g.b.a(paramv.getAppId(), h(paramv), paramv.getContext());
  }
  
  protected static MagicBrushView h(v paramv)
  {
    paramv = (a)paramv.getCurrentPageView().R(a.class);
    if (paramv == null) {
      return null;
    }
    return paramv.PI();
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
    if (u.agG(paramc))
    {
      Log.w("MicroMsg.WAGameJsApiScreenRecorderBase", "hy: file already exists, auto delete: %b", new Object[] { Boolean.TRUE });
      u.deleteFile(paramc);
    }
    q localq = new q(paramc);
    u.bBD(u.bBT(paramc));
    try
    {
      if (!localq.ifM())
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
    return new a(localq.bOF(), agA(paramString), (byte)0);
  }
  
  protected final a a(com.tencent.mm.plugin.appbrand.service.c paramc, String paramString1, String paramString2, boolean paramBoolean)
  {
    Log.i("MicroMsg.WAGameJsApiScreenRecorderBase", "hy: request saveFileToClientData: %s, %b, %b", new Object[] { paramString1, Boolean.TRUE, Boolean.valueOf(paramBoolean) });
    if (!u.agG(paramString1))
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
    if (u.agG(paramc))
    {
      Log.w("MicroMsg.WAGameJsApiScreenRecorderBase", "hy: file already exists, auto delete: %b", new Object[] { Boolean.TRUE });
      u.deleteFile(paramc);
    }
    q localq = new q(paramc);
    if (paramBoolean)
    {
      if (!u.oo(new q(paramString1).getPath(), localq.getPath()))
      {
        Log.w("MicroMsg.WAGameJsApiScreenRecorderBase", "hy: rename failed!");
        return null;
      }
    }
    else if (u.on(paramString1, paramc) <= 0L)
    {
      Log.w("MicroMsg.WAGameJsApiScreenRecorderBase", "hy: copy failed!");
      return null;
    }
    return new a(paramc, agA(paramString2), (byte)0);
  }
  
  protected final class a
    implements c.a
  {
    String ony;
    String onz;
    
    private a(String paramString1, String paramString2)
    {
      this.ony = paramString1;
      this.onz = paramString2;
    }
    
    public final String bOF()
    {
      return this.ony;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.game.e.a.b
 * JD-Core Version:    0.7.0.1
 */