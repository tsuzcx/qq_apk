package com.tencent.mm.plugin.appbrand.appcache;

import android.os.Looper;
import android.text.TextUtils;
import android.util.SparseLongArray;
import com.tencent.f.i;
import com.tencent.f.i.d;
import com.tencent.luggage.h.l;
import com.tencent.mars.cdn.CdnLogic.C2CDownloadResult;
import com.tencent.mars.cdn.CdnLogic.CronetTaskResult;
import com.tencent.mars.cdn.CdnLogic.DownloadCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.t;
import com.tencent.mm.g.a.abf;
import com.tencent.mm.plugin.appbrand.config.AppBrandGlobalSystemConfig;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

public final class aa
{
  private static volatile boolean kLE;
  private static final SparseLongArray kLF;
  private static final long kLG;
  private static final ConcurrentHashMap<String, d<ArrayList<String>>> kLH;
  
  static
  {
    AppMethodBeat.i(161747);
    kLE = false;
    kLF = new SparseLongArray();
    kLG = TimeUnit.MINUTES.toMillis(5L);
    kLH = new ConcurrentHashMap();
    AppMethodBeat.o(161747);
  }
  
  static ArrayList<String> Vd(String paramString)
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
    d locald2 = (d)kLH.get(paramString);
    d locald1 = locald2;
    if (locald2 == null)
    {
      locald1 = com.tencent.f.h.RTc.a(new Callable()
      {
        private ArrayList<String> bvO()
        {
          AppMethodBeat.i(230557);
          try
          {
            ArrayList localArrayList1 = new ArrayList();
            com.tencent.mm.kernel.g.aAg().hqi.iMw.getHostByName(this.jEO, localArrayList1);
            AppMethodBeat.o(230557);
            return localArrayList1;
          }
          catch (Throwable localThrowable)
          {
            ArrayList localArrayList2 = new ArrayList(0);
            AppMethodBeat.o(230557);
            return localArrayList2;
          }
        }
      }, "MicroMsg.PkgNetworkOpt");
      kLH.put(paramString, locald1);
    }
    try
    {
      paramString = (ArrayList)locald1.get(500L, TimeUnit.MILLISECONDS);
      AppMethodBeat.o(161745);
      return paramString;
    }
    catch (Throwable paramString)
    {
      Log.e("MicroMsg.PkgNetworkOpt", "getNewDNSIPListByHost await future t=%s", new Object[] { paramString });
      paramString = new ArrayList(0);
      AppMethodBeat.o(161745);
    }
    return paramString;
  }
  
  public static boolean bvK()
  {
    AppMethodBeat.i(230559);
    boolean bool = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.rUu, false);
    AppMethodBeat.o(230559);
    return bool;
  }
  
  public static void bvL()
  {
    AppMethodBeat.i(44304);
    if (kLE)
    {
      AppMethodBeat.o(44304);
      return;
    }
    kLE = true;
    com.tencent.f.h.RTc.aX(new com.tencent.f.i.h()
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
          String str = AppBrandGlobalSystemConfig.bzP().lcR;
          boolean bool = TextUtils.isEmpty(str);
          if (bool) {
            return;
          }
          aa.CS(str);
          aa.Vd(l.dL(str));
          return;
        }
        catch (Exception localException)
        {
          Log.printErrStackTrace("MicroMsg.PkgNetworkOpt", localException, "triggerPreConnect", new Object[0]);
          return;
        }
        finally
        {
          aa.bvM();
          AppMethodBeat.o(44303);
        }
      }
    });
    AppMethodBeat.o(44304);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.aa
 * JD-Core Version:    0.7.0.1
 */