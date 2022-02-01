package com.tencent.mm.plugin.appbrand.game.e.a;

import com.tencent.magicbrush.ui.MagicBrushView;
import com.tencent.mm.plugin.appbrand.appstorage.x;
import com.tencent.mm.plugin.appbrand.game.g.c.a;
import com.tencent.mm.plugin.appbrand.jsapi.file.ar;
import com.tencent.mm.plugin.appbrand.page.aa;
import com.tencent.mm.plugin.appbrand.service.c;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.vfs.e;
import com.tencent.mm.vfs.i;
import java.io.IOException;

public abstract class b
  extends com.tencent.mm.plugin.appbrand.jsapi.a<c>
{
  private static void LA(String paramString)
  {
    paramString = new e(paramString + ".nomedia");
    if (!paramString.exists()) {
      ac.i("MicroMsg.WAGameJsApiScreenRecorderBase", "hy: no nomedia file. trigger new");
    }
    try
    {
      paramString.createNewFile();
      return;
    }
    catch (IOException paramString)
    {
      ac.printErrStackTrace("MicroMsg.WAGameJsApiScreenRecorderBase", paramString, "hy: create no media file failed!", new Object[0]);
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
        ac.w("MicroMsg.WAGameJsApiScreenRecorderBase", "hy: param error %b, %s", new Object[] { Boolean.valueOf(bool), paramString });
        return null;
      }
    }
    paramc = (ar)paramc.DH();
    if (paramc == null)
    {
      ac.w("MicroMsg.WAGameJsApiScreenRecorderBase", "hy: fs is null");
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
  
  protected static MagicBrushView f(com.tencent.mm.plugin.appbrand.q paramq)
  {
    paramq = (com.tencent.mm.plugin.appbrand.game.f.a)paramq.getCurrentPageView().Q(com.tencent.mm.plugin.appbrand.game.f.a.class);
    if (paramq == null) {
      return null;
    }
    return paramq.BR();
  }
  
  protected final a a(c paramc, String paramString)
  {
    paramc = b(paramc, paramString);
    if (paramc == null)
    {
      ac.e("MicroMsg.WAGameJsApiScreenRecorderBase", "hy: can not generate!");
      return null;
    }
    ac.i("MicroMsg.WAGameJsApiScreenRecorderBase", "hy: creating file: %s", new Object[] { paramc });
    if (i.eA(paramc))
    {
      ac.w("MicroMsg.WAGameJsApiScreenRecorderBase", "hy: file already exists, auto delete: %b", new Object[] { Boolean.TRUE });
      i.deleteFile(paramc);
    }
    e locale = new e(paramc);
    i.aSh(i.aSs(paramc));
    try
    {
      if (!locale.createNewFile())
      {
        ac.w("MicroMsg.WAGameJsApiScreenRecorderBase", "hy: create file failed!");
        return null;
      }
    }
    catch (IOException paramc)
    {
      ac.printErrStackTrace("MicroMsg.WAGameJsApiScreenRecorderBase", paramc, "hy: create file failed!", new Object[0]);
      return null;
    }
    return new a(com.tencent.mm.vfs.q.B(locale.fxV()), Lz(paramString), (byte)0);
  }
  
  protected final a a(c paramc, String paramString1, String paramString2, boolean paramBoolean)
  {
    ac.i("MicroMsg.WAGameJsApiScreenRecorderBase", "hy: request saveFileToClientData: %s, %b, %b", new Object[] { paramString1, Boolean.TRUE, Boolean.valueOf(paramBoolean) });
    if (!i.eA(paramString1))
    {
      ac.w("MicroMsg.WAGameJsApiScreenRecorderBase", "hy: src file not exists!");
      return null;
    }
    paramc = b(paramc, paramString2);
    if (paramc == null)
    {
      ac.w("MicroMsg.WAGameJsApiScreenRecorderBase", "hy: can not generate dest file!");
      return null;
    }
    if (i.eA(paramc))
    {
      ac.w("MicroMsg.WAGameJsApiScreenRecorderBase", "hy: file already exists, auto delete: %b", new Object[] { Boolean.TRUE });
      i.deleteFile(paramc);
    }
    e locale = new e(paramc);
    if (paramBoolean)
    {
      if (!i.ma(com.tencent.mm.vfs.q.B(new e(paramString1).mUri), com.tencent.mm.vfs.q.B(locale.mUri)))
      {
        ac.w("MicroMsg.WAGameJsApiScreenRecorderBase", "hy: rename failed!");
        return null;
      }
    }
    else if (i.lZ(paramString1, paramc) <= 0L)
    {
      ac.w("MicroMsg.WAGameJsApiScreenRecorderBase", "hy: copy failed!");
      return null;
    }
    return new a(paramc, Lz(paramString2), (byte)0);
  }
  
  protected final class a
    implements c.a
  {
    String jRo;
    String jRp;
    
    private a(String paramString1, String paramString2)
    {
      this.jRo = paramString1;
      this.jRp = paramString2;
    }
    
    public final String getAbsolutePath()
    {
      return this.jRo;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.game.e.a.b
 * JD-Core Version:    0.7.0.1
 */