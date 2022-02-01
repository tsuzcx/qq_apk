package com.tencent.mm.plugin.finder.nearby.report;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.b.a.iq;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.cm;
import com.tencent.mm.plugin.expt.hellhound.core.b;
import com.tencent.mm.plugin.finder.nearby.base.AbsNearByFragment;
import com.tencent.mm.plugin.findersdk.a.ak;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/nearby/report/NearbyTabLifecycleReporter;", "Lcom/tencent/plugin/finder/nearby/api/INearbyTabLifecycleReporter;", "()V", "TAG", "", "contextId", "kotlin.jvm.PlatformType", "currentClickTabContextID", "enterClickTabContextID", "enterNearbyTabMs", "", "lastSwitchClickTabContextID", "lastSwitchTabMs", "enterNearbyTab", "", "exitNearbyTab", "getContextId", "getCurrentClickTabContextID", "getEnterClickTabContextID", "getLastSwitchClickTabContextID", "report", "pageName", "enterTimeMs", "exitTimeMs", "clickTabContextId", "reportType", "resetSwitchTabTime", "switchInNearbyTab", "fragment", "Lcom/tencent/mm/plugin/finder/nearby/base/AbsNearByFragment;", "switchOutNearbyTab", "plugin-finder-nearby_release"})
public final class e
  implements com.tencent.c.a.b.a.c
{
  private static String wmL;
  private static long zJn;
  private static String zJo;
  private static long zJp;
  private static String zJq;
  public static String zJr;
  public static final e zJs;
  
  static
  {
    AppMethodBeat.i(203265);
    zJs = new e();
    wmL = ((ak)h.ag(ak.class)).fillContextIdToIntent(12, 1, 94, new Intent());
    zJn = cm.bfE();
    zJo = "";
    zJp = cm.bfE();
    zJq = "";
    zJr = "1001";
    AppMethodBeat.o(203265);
  }
  
  private static void a(String paramString1, long paramLong1, long paramLong2, String paramString2, long paramLong3)
  {
    AppMethodBeat.i(203262);
    iq localiq = new iq();
    String str2 = ((com.tencent.mm.plugin.expt.b.c)h.ae(com.tencent.mm.plugin.expt.b.c.class)).dbr();
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    localiq.zE(str1);
    localiq.zF(paramString1);
    long l2 = paramLong2 - paramLong1;
    long l1 = l2;
    if (l2 <= 0L) {
      l1 = 0L;
    }
    localiq.tW(l1);
    localiq.tX(paramLong1);
    localiq.tY(paramLong2);
    localiq.zG(paramString2);
    localiq.zH("");
    localiq.tZ(paramLong3);
    localiq.zI(wmL);
    Log.i("NearbyTabLifecycleReporter", "report " + localiq.agI());
    localiq.bpa();
    AppMethodBeat.o(203262);
  }
  
  public static void d(AbsNearByFragment paramAbsNearByFragment)
  {
    AppMethodBeat.i(203250);
    String str = paramAbsNearByFragment.dLv();
    paramAbsNearByFragment = str;
    if (str == null) {
      paramAbsNearByFragment = "";
    }
    zJr = paramAbsNearByFragment + "-" + cm.bfE();
    AppMethodBeat.o(203250);
  }
  
  public static void dMA()
  {
    AppMethodBeat.i(203248);
    zJp = cm.bfE();
    AppMethodBeat.o(203248);
  }
  
  public static void dMB()
  {
    AppMethodBeat.i(203254);
    a("all", zJn, cm.bfE(), zJr, 1L);
    AppMethodBeat.o(203254);
  }
  
  public static String dMy()
  {
    return zJq;
  }
  
  public static void e(AbsNearByFragment paramAbsNearByFragment)
  {
    AppMethodBeat.i(203253);
    String str2;
    String str1;
    if (paramAbsNearByFragment != null)
    {
      str2 = paramAbsNearByFragment.akA();
      str1 = str2;
      if (str2 != null) {}
    }
    else
    {
      str1 = "";
    }
    if (paramAbsNearByFragment != null)
    {
      str2 = paramAbsNearByFragment.dLv();
      paramAbsNearByFragment = str2;
      if (str2 != null) {}
    }
    else
    {
      paramAbsNearByFragment = "";
    }
    long l = cm.bfE();
    paramAbsNearByFragment = paramAbsNearByFragment + "-" + cm.bfE();
    b.awV(wmL);
    b.awU(paramAbsNearByFragment);
    a(str1, zJp, l, paramAbsNearByFragment, 0L);
    zJq = paramAbsNearByFragment;
    zJp = l;
    AppMethodBeat.o(203253);
  }
  
  public static void hf(String paramString1, String paramString2)
  {
    AppMethodBeat.i(203246);
    p.k(paramString1, "contextId");
    p.k(paramString2, "enterClickTabContextID");
    wmL = paramString1;
    zJo = paramString2;
    long l = cm.bfE();
    zJn = l;
    zJp = l;
    AppMethodBeat.o(203246);
  }
  
  public final String agX()
  {
    AppMethodBeat.i(203242);
    String str = wmL;
    p.j(str, "contextId");
    AppMethodBeat.o(203242);
    return str;
  }
  
  public final String dMz()
  {
    return zJr;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.nearby.report.e
 * JD-Core Version:    0.7.0.1
 */