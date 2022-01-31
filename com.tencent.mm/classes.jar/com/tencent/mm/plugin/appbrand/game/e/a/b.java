package com.tencent.mm.plugin.appbrand.game.e.a;

import com.tencent.magicbrush.MagicBrushView;
import com.tencent.mm.a.e;
import com.tencent.mm.plugin.appbrand.appstorage.w;
import com.tencent.mm.plugin.appbrand.jsapi.file.an;
import com.tencent.mm.plugin.appbrand.page.v;
import com.tencent.mm.plugin.appbrand.r;
import com.tencent.mm.plugin.appbrand.service.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.io.File;
import java.io.IOException;

public abstract class b
  extends com.tencent.mm.plugin.appbrand.jsapi.a<c>
{
  private static String BA(String paramString)
  {
    return "wxfile://clientdata/".concat(String.valueOf(paramString));
  }
  
  private static void BB(String paramString)
  {
    paramString = new File(paramString + ".nomedia");
    if (!paramString.exists()) {
      ab.i("MicroMsg.WAGameJsApiScreenRecorderBase", "hy: no nomedia file. trigger new");
    }
    try
    {
      paramString.createNewFile();
      return;
    }
    catch (IOException paramString)
    {
      ab.printErrStackTrace("MicroMsg.WAGameJsApiScreenRecorderBase", paramString, "hy: create no media file failed!", new Object[0]);
    }
  }
  
  private static String b(c paramc, String paramString)
  {
    if ((paramc == null) || (bo.isNullOrNil(paramString)))
    {
      if (paramc == null) {}
      for (boolean bool = true;; bool = false)
      {
        ab.w("MicroMsg.WAGameJsApiScreenRecorderBase", "hy: param error %b, %s", new Object[] { Boolean.valueOf(bool), paramString });
        return null;
      }
    }
    paramc = (an)paramc.wX();
    if (paramc == null)
    {
      ab.w("MicroMsg.WAGameJsApiScreenRecorderBase", "hy: fs is null");
      return null;
    }
    String str = ((w)paramc.zn("wxfile://clientdata")).gZQ;
    paramc = str;
    if (!str.endsWith("/")) {
      paramc = str + "/";
    }
    BB(paramc);
    return paramc + paramString;
  }
  
  protected static MagicBrushView f(r paramr)
  {
    paramr = (com.tencent.mm.plugin.appbrand.game.f.a)paramr.getCurrentPageView().x(com.tencent.mm.plugin.appbrand.game.f.a.class);
    if (paramr == null) {
      return null;
    }
    return paramr.vI();
  }
  
  protected final b.a a(c paramc, String paramString)
  {
    paramc = b(paramc, paramString);
    if (paramc == null)
    {
      ab.e("MicroMsg.WAGameJsApiScreenRecorderBase", "hy: can not generate!");
      return null;
    }
    ab.i("MicroMsg.WAGameJsApiScreenRecorderBase", "hy: creating file: %s", new Object[] { paramc });
    if (e.cN(paramc))
    {
      ab.w("MicroMsg.WAGameJsApiScreenRecorderBase", "hy: file already exists, auto delete: %b", new Object[] { Boolean.TRUE });
      e.deleteFile(paramc);
    }
    File localFile = new File(paramc);
    e.cR(paramc);
    try
    {
      if (!localFile.createNewFile())
      {
        ab.w("MicroMsg.WAGameJsApiScreenRecorderBase", "hy: create file failed!");
        return null;
      }
    }
    catch (IOException paramc)
    {
      ab.printErrStackTrace("MicroMsg.WAGameJsApiScreenRecorderBase", paramc, "hy: create file failed!", new Object[0]);
      return null;
    }
    return new b.a(this, localFile.getAbsolutePath(), BA(paramString), (byte)0);
  }
  
  protected final b.a a(c paramc, String paramString1, String paramString2, boolean paramBoolean)
  {
    ab.i("MicroMsg.WAGameJsApiScreenRecorderBase", "hy: request saveFileToClientData: %s, %b, %b", new Object[] { paramString1, Boolean.TRUE, Boolean.valueOf(paramBoolean) });
    if (!e.cN(paramString1))
    {
      ab.w("MicroMsg.WAGameJsApiScreenRecorderBase", "hy: src file not exists!");
      return null;
    }
    paramc = b(paramc, paramString2);
    if (paramc == null)
    {
      ab.w("MicroMsg.WAGameJsApiScreenRecorderBase", "hy: can not generate dest file!");
      return null;
    }
    if (e.cN(paramc))
    {
      ab.w("MicroMsg.WAGameJsApiScreenRecorderBase", "hy: file already exists, auto delete: %b", new Object[] { Boolean.TRUE });
      e.deleteFile(paramc);
    }
    File localFile = new File(paramc);
    if (paramBoolean)
    {
      if (!e.d(new File(paramString1), localFile))
      {
        ab.w("MicroMsg.WAGameJsApiScreenRecorderBase", "hy: rename failed!");
        return null;
      }
    }
    else if (e.C(paramString1, paramc) <= 0L)
    {
      ab.w("MicroMsg.WAGameJsApiScreenRecorderBase", "hy: copy failed!");
      return null;
    }
    return new b.a(this, paramc, BA(paramString2), (byte)0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.game.e.a.b
 * JD-Core Version:    0.7.0.1
 */