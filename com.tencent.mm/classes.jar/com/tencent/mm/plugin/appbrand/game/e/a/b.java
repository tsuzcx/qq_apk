package com.tencent.mm.plugin.appbrand.game.e.a;

import com.tencent.magicbrush.ui.MagicBrushView;
import com.tencent.mm.plugin.appbrand.appstorage.x;
import com.tencent.mm.plugin.appbrand.game.g.c.a;
import com.tencent.mm.plugin.appbrand.jsapi.file.ar;
import com.tencent.mm.plugin.appbrand.page.aa;
import com.tencent.mm.plugin.appbrand.service.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.vfs.e;
import com.tencent.mm.vfs.i;
import java.io.IOException;

public abstract class b
  extends com.tencent.mm.plugin.appbrand.jsapi.a<c>
{
  private static String OT(String paramString)
  {
    return "wxfile://clientdata/".concat(String.valueOf(paramString));
  }
  
  private static void OU(String paramString)
  {
    paramString = new e(paramString + ".nomedia");
    if (!paramString.exists()) {
      ad.i("MicroMsg.WAGameJsApiScreenRecorderBase", "hy: no nomedia file. trigger new");
    }
    try
    {
      paramString.createNewFile();
      return;
    }
    catch (IOException paramString)
    {
      ad.printErrStackTrace("MicroMsg.WAGameJsApiScreenRecorderBase", paramString, "hy: create no media file failed!", new Object[0]);
    }
  }
  
  private static String b(c paramc, String paramString)
  {
    if ((paramc == null) || (bt.isNullOrNil(paramString)))
    {
      if (paramc == null) {}
      for (boolean bool = true;; bool = false)
      {
        ad.w("MicroMsg.WAGameJsApiScreenRecorderBase", "hy: param error %b, %s", new Object[] { Boolean.valueOf(bool), paramString });
        return null;
      }
    }
    paramc = (ar)paramc.Fg();
    if (paramc == null)
    {
      ad.w("MicroMsg.WAGameJsApiScreenRecorderBase", "hy: fs is null");
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
  
  protected static MagicBrushView f(com.tencent.mm.plugin.appbrand.q paramq)
  {
    paramq = (com.tencent.mm.plugin.appbrand.game.f.a)paramq.getCurrentPageView().Q(com.tencent.mm.plugin.appbrand.game.f.a.class);
    if (paramq == null) {
      return null;
    }
    return paramq.getMagicBrushView();
  }
  
  protected final a a(c paramc, String paramString)
  {
    paramc = b(paramc, paramString);
    if (paramc == null)
    {
      ad.e("MicroMsg.WAGameJsApiScreenRecorderBase", "hy: can not generate!");
      return null;
    }
    ad.i("MicroMsg.WAGameJsApiScreenRecorderBase", "hy: creating file: %s", new Object[] { paramc });
    if (i.fv(paramc))
    {
      ad.w("MicroMsg.WAGameJsApiScreenRecorderBase", "hy: file already exists, auto delete: %b", new Object[] { Boolean.TRUE });
      i.deleteFile(paramc);
    }
    e locale = new e(paramc);
    i.aYg(i.aYr(paramc));
    try
    {
      if (!locale.createNewFile())
      {
        ad.w("MicroMsg.WAGameJsApiScreenRecorderBase", "hy: create file failed!");
        return null;
      }
    }
    catch (IOException paramc)
    {
      ad.printErrStackTrace("MicroMsg.WAGameJsApiScreenRecorderBase", paramc, "hy: create file failed!", new Object[0]);
      return null;
    }
    return new a(com.tencent.mm.vfs.q.B(locale.fOK()), OT(paramString), (byte)0);
  }
  
  protected final a a(c paramc, String paramString1, String paramString2, boolean paramBoolean)
  {
    ad.i("MicroMsg.WAGameJsApiScreenRecorderBase", "hy: request saveFileToClientData: %s, %b, %b", new Object[] { paramString1, Boolean.TRUE, Boolean.valueOf(paramBoolean) });
    if (!i.fv(paramString1))
    {
      ad.w("MicroMsg.WAGameJsApiScreenRecorderBase", "hy: src file not exists!");
      return null;
    }
    paramc = b(paramc, paramString2);
    if (paramc == null)
    {
      ad.w("MicroMsg.WAGameJsApiScreenRecorderBase", "hy: can not generate dest file!");
      return null;
    }
    if (i.fv(paramc))
    {
      ad.w("MicroMsg.WAGameJsApiScreenRecorderBase", "hy: file already exists, auto delete: %b", new Object[] { Boolean.TRUE });
      i.deleteFile(paramc);
    }
    e locale = new e(paramc);
    if (paramBoolean)
    {
      if (!i.mA(com.tencent.mm.vfs.q.B(new e(paramString1).mUri), com.tencent.mm.vfs.q.B(locale.mUri)))
      {
        ad.w("MicroMsg.WAGameJsApiScreenRecorderBase", "hy: rename failed!");
        return null;
      }
    }
    else if (i.mz(paramString1, paramc) <= 0L)
    {
      ad.w("MicroMsg.WAGameJsApiScreenRecorderBase", "hy: copy failed!");
      return null;
    }
    return new a(paramc, OT(paramString2), (byte)0);
  }
  
  protected final class a
    implements c.a
  {
    String klC;
    String klD;
    
    private a(String paramString1, String paramString2)
    {
      this.klC = paramString1;
      this.klD = paramString2;
    }
    
    public final String getAbsolutePath()
    {
      return this.klC;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.game.e.a.b
 * JD-Core Version:    0.7.0.1
 */