package com.tencent.mm.plugin.appbrand.appcache;

import android.os.Looper;
import android.text.TextUtils;
import android.util.SparseLongArray;
import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.e.i.d;
import com.tencent.mars.cdn.CdnLogic.C2CDownloadResult;
import com.tencent.mars.cdn.CdnLogic.CronetTaskResult;
import com.tencent.mars.cdn.CdnLogic.DownloadCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.zy;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

public final class aa
{
  private static volatile boolean jJH;
  private static final SparseLongArray jJI;
  private static final long jJJ;
  private static final ConcurrentHashMap<String, d<ArrayList<String>>> jJK;
  
  static
  {
    AppMethodBeat.i(161747);
    jJH = false;
    jJI = new SparseLongArray();
    jJJ = TimeUnit.MINUTES.toMillis(5L);
    jJK = new ConcurrentHashMap();
    AppMethodBeat.o(161747);
  }
  
  static ArrayList<String> LU(String paramString)
  {
    AppMethodBeat.i(161745);
    if (TextUtils.isEmpty(paramString))
    {
      ae.w("MicroMsg.PkgNetworkOpt", "getNewDNSIPListByHost with EMPTY host");
      paramString = new ArrayList(0);
      AppMethodBeat.o(161745);
      return paramString;
    }
    ae.i("MicroMsg.PkgNetworkOpt", "getNewDNSIPListByHost with host[%s]", new Object[] { paramString });
    d locald2 = (d)jJK.get(paramString);
    d locald1 = locald2;
    if (locald2 == null)
    {
      locald1 = h.MqF.a(new aa.3(paramString), "MicroMsg.PkgNetworkOpt");
      jJK.put(paramString, locald1);
    }
    try
    {
      paramString = (ArrayList)locald1.get(500L, TimeUnit.MILLISECONDS);
      AppMethodBeat.o(161745);
      return paramString;
    }
    catch (Throwable paramString)
    {
      ae.e("MicroMsg.PkgNetworkOpt", "getNewDNSIPListByHost await future t=%s", new Object[] { paramString });
      paramString = new ArrayList(0);
      AppMethodBeat.o(161745);
    }
    return paramString;
  }
  
  public static boolean baw()
  {
    AppMethodBeat.i(212492);
    boolean bool = ((b)g.ab(b.class)).a(b.a.qBI, false);
    AppMethodBeat.o(212492);
    return bool;
  }
  
  public static void bax()
  {
    AppMethodBeat.i(44304);
    if (jJH)
    {
      AppMethodBeat.o(44304);
      return;
    }
    jJH = true;
    h.MqF.aO(new aa.1());
    AppMethodBeat.o(44304);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.aa
 * JD-Core Version:    0.7.0.1
 */