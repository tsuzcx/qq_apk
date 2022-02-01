package com.tencent.mm.plugin.appbrand.appcache;

import android.os.Looper;
import android.text.TextUtils;
import android.util.SparseLongArray;
import com.tencent.luggage.l.m;
import com.tencent.mars.cdn.CdnLogic.C2CDownloadResult;
import com.tencent.mars.cdn.CdnLogic.CronetTaskResult;
import com.tencent.mars.cdn.CdnLogic.DownloadCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.aem;
import com.tencent.mm.plugin.appbrand.config.AppBrandGlobalSystemConfig;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.threadpool.i;
import com.tencent.threadpool.i.d;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

public final class ac
{
  private static volatile boolean qFr;
  private static final SparseLongArray qFs;
  private static final long qFt;
  private static final ConcurrentHashMap<String, d<ArrayList<String>>> qFu;
  
  static
  {
    AppMethodBeat.i(161747);
    qFr = false;
    qFs = new SparseLongArray();
    qFt = TimeUnit.MINUTES.toMillis(5L);
    qFu = new ConcurrentHashMap();
    AppMethodBeat.o(161747);
  }
  
  static ArrayList<String> Vl(String paramString)
  {
    AppMethodBeat.i(161745);
    if (TextUtils.isEmpty(paramString))
    {
      Log.w("MicroMsg.PkgNetworkOpt", "getNewDNSIPListByHost with EMPTY host");
      paramString = new ArrayList(0);
      AppMethodBeat.o(161745);
      return paramString;
    }
    Log.i("MicroMsg.PkgNetworkOpt", "getNewDNSIPListByHost with host[%s]", new Object[] { paramString });
    d locald2 = (d)qFu.get(paramString);
    d locald1 = locald2;
    if (locald2 == null)
    {
      locald1 = com.tencent.threadpool.h.ahAA.a(new ac.3(paramString), "MicroMsg.PkgNetworkOpt");
      qFu.put(paramString, locald1);
    }
    try
    {
      paramString = (ArrayList)locald1.get(500L, TimeUnit.MILLISECONDS);
      AppMethodBeat.o(161745);
      return paramString;
    }
    finally
    {
      Log.e("MicroMsg.PkgNetworkOpt", "getNewDNSIPListByHost await future t=%s", new Object[] { paramString });
      paramString = new ArrayList(0);
      AppMethodBeat.o(161745);
    }
    return paramString;
  }
  
  public static void cgo()
  {
    AppMethodBeat.i(44304);
    if (qFr)
    {
      AppMethodBeat.o(44304);
      return;
    }
    qFr = true;
    com.tencent.threadpool.h.ahAA.bm(new com.tencent.threadpool.i.h()
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
          String str = AppBrandGlobalSystemConfig.ckD().qWQ;
          boolean bool = TextUtils.isEmpty(str);
          if (bool) {
            return;
          }
          ac.Co(str);
          ac.Vl(m.fK(str));
          return;
        }
        catch (Exception localException)
        {
          Log.printErrStackTrace("MicroMsg.PkgNetworkOpt", localException, "triggerPreConnect", new Object[0]);
          return;
        }
        finally
        {
          ac.bDd();
          AppMethodBeat.o(44303);
        }
      }
    });
    AppMethodBeat.o(44304);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.ac
 * JD-Core Version:    0.7.0.1
 */