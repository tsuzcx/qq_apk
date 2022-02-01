package com.tencent.mm.plugin.appbrand.config;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.f;
import com.tencent.mm.autogen.a.cd;
import com.tencent.mm.pluginsdk.res.downloader.checkresupdate.b;
import com.tencent.mm.pluginsdk.res.downloader.model.p;
import com.tencent.mm.pluginsdk.res.downloader.model.p.a;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.FilesCopy;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.y;

public final class AppBrandGlobalSystemConfigResUpdateListener
  extends IListener<cd>
{
  public AppBrandGlobalSystemConfigResUpdateListener()
  {
    super(f.hfK);
    AppMethodBeat.i(160970);
    this.__eventId = cd.class.getName().hashCode();
    AppMethodBeat.o(160970);
  }
  
  static String ckB()
  {
    AppMethodBeat.i(370022);
    String str = AppBrandGlobalSystemConfig.ckB();
    AppMethodBeat.o(370022);
    return str;
  }
  
  public static void ckE()
  {
    AppMethodBeat.i(323489);
    if (MMApplicationContext.isMainProcess())
    {
      b localb = b.iJf();
      b.iJf();
      localb.f(38, 1, b.nJ(38, 1), false);
      AppMethodBeat.o(323489);
      return;
    }
    Log.i("MicroMsg.AppBrandGlobalSystemConfigResUpdateListener", "onConfigFileDeleted: not in main proc, ignore");
    AppMethodBeat.o(323489);
  }
  
  private static void r(int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(323478);
    if ((Util.isNullOrNil(paramString)) && (!y.ZC(paramString)))
    {
      Log.e("MicroMsg.AppBrandGlobalSystemConfigResUpdateListener", "handleResUpdate(%dv%d) resPath(%s) not exists", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
      AppMethodBeat.o(323478);
      return;
    }
    String str2 = AppBrandGlobalSystemConfig.ckB();
    String str1;
    boolean bool1;
    if (!y.ZC(str2))
    {
      str1 = "!fileExists";
      bool1 = true;
      if ((!bool1) || (!FilesCopy.copyFile(paramString, str2))) {
        break label212;
      }
    }
    label212:
    for (boolean bool2 = true;; bool2 = false)
    {
      Log.i("MicroMsg.AppBrandGlobalSystemConfigResUpdateListener", "handleResUpdate(%dv%d) resPath(%s) doCopy?:%b, reason:%s, copyOK?:%b", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString, Boolean.valueOf(bool1), str1, Boolean.valueOf(bool2) });
      if (bool2)
      {
        AppBrandGlobalSystemConfig.ckA();
        b.iJf().bu(38, paramInt1, paramInt2);
      }
      AppMethodBeat.o(323478);
      return;
      str1 = y.bub(paramString);
      String str3 = y.bub(str2);
      if ((!Util.isNullOrNil(str1)) && (!str1.equals(str3)))
      {
        str1 = "md5 updated";
        bool1 = true;
        break;
      }
      str1 = "md5 latested";
      bool1 = false;
      break;
    }
  }
  
  public final void alive()
  {
    try
    {
      AppMethodBeat.i(323500);
      p.a.iJK().handler.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(323348);
          try
          {
            if (!y.ZC(AppBrandGlobalSystemConfigResUpdateListener.ckB())) {
              Log.i("MicroMsg.AppBrandGlobalSystemConfigResUpdateListener", "alive() double check for missing cfg file, continue to check if resource cached");
            }
            for (;;)
            {
              b.iJf();
              String str = b.nK(38, 1);
              if (y.ZC(str))
              {
                b.iJf();
                AppBrandGlobalSystemConfigResUpdateListener.an(b.nJ(38, 1), str);
              }
              AppMethodBeat.o(323348);
              return;
              Log.i("MicroMsg.AppBrandGlobalSystemConfigResUpdateListener", "alive() double check, cfg file ready, continue to check if resource updated");
            }
            return;
          }
          catch (Exception localException)
          {
            Log.e("MicroMsg.AppBrandGlobalSystemConfigResUpdateListener", "alive() double check for missing cfg file, get exception %s", new Object[] { localException });
            AppMethodBeat.o(323348);
          }
        }
      });
      AppMethodBeat.o(323500);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.config.AppBrandGlobalSystemConfigResUpdateListener
 * JD-Core Version:    0.7.0.1
 */