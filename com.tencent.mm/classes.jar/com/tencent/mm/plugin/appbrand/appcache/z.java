package com.tencent.mm.plugin.appbrand.appcache;

import android.os.Looper;
import android.text.TextUtils;
import android.util.SparseLongArray;
import com.tencent.e.i;
import com.tencent.e.i.d;
import com.tencent.luggage.h.k;
import com.tencent.mars.cdn.CdnLogic.C2CDownloadResult;
import com.tencent.mars.cdn.CdnLogic.CronetTaskResult;
import com.tencent.mars.cdn.CdnLogic.DownloadCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.zs;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.config.AppBrandGlobalSystemConfig;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

public final class z
{
  private static volatile boolean jGH;
  private static final SparseLongArray jGI;
  private static final long jGJ;
  private static final ConcurrentHashMap<String, d<ArrayList<String>>> jGK;
  
  static
  {
    AppMethodBeat.i(161747);
    jGH = false;
    jGI = new SparseLongArray();
    jGJ = TimeUnit.MINUTES.toMillis(5L);
    jGK = new ConcurrentHashMap();
    AppMethodBeat.o(161747);
  }
  
  static ArrayList<String> Lr(String paramString)
  {
    AppMethodBeat.i(161745);
    if (TextUtils.isEmpty(paramString))
    {
      ad.w("MicroMsg.PkgNetworkOpt", "getNewDNSIPListByHost with EMPTY host");
      paramString = new ArrayList(0);
      AppMethodBeat.o(161745);
      return paramString;
    }
    ad.i("MicroMsg.PkgNetworkOpt", "getNewDNSIPListByHost with host[%s]", new Object[] { paramString });
    d locald2 = (d)jGK.get(paramString);
    d locald1 = locald2;
    if (locald2 == null)
    {
      locald1 = com.tencent.e.h.LTJ.a(new z.3(paramString), "MicroMsg.PkgNetworkOpt");
      jGK.put(paramString, locald1);
    }
    try
    {
      paramString = (ArrayList)locald1.get(500L, TimeUnit.MILLISECONDS);
      AppMethodBeat.o(161745);
      return paramString;
    }
    catch (Throwable paramString)
    {
      ad.e("MicroMsg.PkgNetworkOpt", "getNewDNSIPListByHost await future t=%s", new Object[] { paramString });
      paramString = new ArrayList(0);
      AppMethodBeat.o(161745);
    }
    return paramString;
  }
  
  public static boolean aZX()
  {
    AppMethodBeat.i(207431);
    boolean bool = ((b)g.ab(b.class)).a(b.a.quN, false);
    AppMethodBeat.o(207431);
    return bool;
  }
  
  public static void aZY()
  {
    AppMethodBeat.i(44304);
    if (jGH)
    {
      AppMethodBeat.o(44304);
      return;
    }
    jGH = true;
    com.tencent.e.h.LTJ.aR(new com.tencent.e.i.h()
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
          String str = AppBrandGlobalSystemConfig.bdT().jWz;
          boolean bool = TextUtils.isEmpty(str);
          if (bool) {
            return;
          }
          z.uh(str);
          z.Lr(k.dq(str));
          return;
        }
        catch (Exception localException)
        {
          ad.printErrStackTrace("MicroMsg.PkgNetworkOpt", localException, "triggerPreConnect", new Object[0]);
          return;
        }
        finally
        {
          z.aZZ();
          AppMethodBeat.o(44303);
        }
      }
    });
    AppMethodBeat.o(44304);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.z
 * JD-Core Version:    0.7.0.1
 */