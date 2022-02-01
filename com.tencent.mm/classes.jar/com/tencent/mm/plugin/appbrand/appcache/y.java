package com.tencent.mm.plugin.appbrand.appcache;

import android.text.TextUtils;
import com.tencent.e.i;
import com.tencent.e.i.d;
import com.tencent.luggage.h.k;
import com.tencent.mars.cdn.CdnLogic.C2CDownloadResult;
import com.tencent.mars.cdn.CdnLogic.CronetTaskResult;
import com.tencent.mars.cdn.CdnLogic.DownloadCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.AppBrandGlobalSystemConfig;
import com.tencent.mm.sdk.platformtools.ac;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

public final class y
{
  private static volatile boolean jmL;
  private static final ConcurrentHashMap<String, d<ArrayList<String>>> jmM;
  
  static
  {
    AppMethodBeat.i(161747);
    jmL = false;
    jmM = new ConcurrentHashMap();
    AppMethodBeat.o(161747);
  }
  
  static ArrayList<String> HZ(String paramString)
  {
    AppMethodBeat.i(161745);
    if (TextUtils.isEmpty(paramString))
    {
      ac.w("MicroMsg.PkgNetworkOpt", "getNewDNSIPListByHost with EMPTY host");
      paramString = new ArrayList(0);
      AppMethodBeat.o(161745);
      return paramString;
    }
    ac.i("MicroMsg.PkgNetworkOpt", "getNewDNSIPListByHost with host[%s]", new Object[] { paramString });
    d locald2 = (d)jmM.get(paramString);
    d locald1 = locald2;
    if (locald2 == null)
    {
      locald1 = com.tencent.e.h.JZN.a(new y.3(paramString), "MicroMsg.PkgNetworkOpt");
      jmM.put(paramString, locald1);
    }
    try
    {
      paramString = (ArrayList)locald1.get(500L, TimeUnit.MILLISECONDS);
      AppMethodBeat.o(161745);
      return paramString;
    }
    catch (Throwable paramString)
    {
      ac.e("MicroMsg.PkgNetworkOpt", "getNewDNSIPListByHost await future t=%s", new Object[] { paramString });
      paramString = new ArrayList(0);
      AppMethodBeat.o(161745);
    }
    return paramString;
  }
  
  public static void aWC()
  {
    AppMethodBeat.i(44304);
    if (jmL)
    {
      AppMethodBeat.o(44304);
      return;
    }
    jmL = true;
    com.tencent.e.h.JZN.aS(new com.tencent.e.i.h()
    {
      public final String getKey()
      {
        return "PkgNetworkOpt.triggerPreConnect";
      }
      
      public final void run()
      {
        AppMethodBeat.i(44303);
        try
        {
          String str = AppBrandGlobalSystemConfig.bat().jCD;
          boolean bool = TextUtils.isEmpty(str);
          if (bool) {
            return;
          }
          y.rv(str);
          y.HZ(k.co(str));
          ac.i("MicroMsg.PkgNetworkOpt", "triggerPreConnect, url:%s", new Object[] { str });
          return;
        }
        catch (Exception localException)
        {
          ac.printErrStackTrace("MicroMsg.PkgNetworkOpt", localException, "triggerPreConnect", new Object[0]);
          return;
        }
        finally
        {
          y.aWD();
          AppMethodBeat.o(44303);
        }
      }
    });
    AppMethodBeat.o(44304);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.y
 * JD-Core Version:    0.7.0.1
 */