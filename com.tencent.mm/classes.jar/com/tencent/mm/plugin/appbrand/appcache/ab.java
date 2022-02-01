package com.tencent.mm.plugin.appbrand.appcache;

import android.os.Looper;
import android.text.TextUtils;
import android.util.SparseLongArray;
import com.tencent.e.i;
import com.tencent.e.i.d;
import com.tencent.mars.cdn.CdnLogic.C2CDownloadResult;
import com.tencent.mars.cdn.CdnLogic.CronetTaskResult;
import com.tencent.mars.cdn.CdnLogic.DownloadCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.a.acn;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

public final class ab
{
  private static final ConcurrentHashMap<String, d<ArrayList<String>>> nFA;
  private static volatile boolean nFx;
  private static final SparseLongArray nFy;
  private static final long nFz;
  
  static
  {
    AppMethodBeat.i(161747);
    nFx = false;
    nFy = new SparseLongArray();
    nFz = TimeUnit.MINUTES.toMillis(5L);
    nFA = new ConcurrentHashMap();
    AppMethodBeat.o(161747);
  }
  
  static ArrayList<String> acN(String paramString)
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
    d locald2 = (d)nFA.get(paramString);
    d locald1 = locald2;
    if (locald2 == null)
    {
      locald1 = com.tencent.e.h.ZvG.a(new ab.3(paramString), "MicroMsg.PkgNetworkOpt");
      nFA.put(paramString, locald1);
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
  
  public static boolean bGR()
  {
    AppMethodBeat.i(206437);
    boolean bool = ((b)com.tencent.mm.kernel.h.ae(b.class)).a(b.a.vBf, false);
    AppMethodBeat.o(206437);
    return bool;
  }
  
  public static void bGS()
  {
    AppMethodBeat.i(44304);
    if (nFx)
    {
      AppMethodBeat.o(44304);
      return;
    }
    nFx = true;
    com.tencent.e.h.ZvG.be(new ab.1());
    AppMethodBeat.o(44304);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.ab
 * JD-Core Version:    0.7.0.1
 */