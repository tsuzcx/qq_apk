package com.tencent.mm.plugin.finder.nearby.report;

import android.content.Intent;
import com.tencent.d.a.b.a.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.mmdata.rpt.kz;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.expt.b.d;
import com.tencent.mm.plugin.expt.hellhound.core.b;
import com.tencent.mm.plugin.finder.nearby.base.AbsNearByFragment;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/nearby/report/NearbyTabLifecycleReporter;", "Lcom/tencent/plugin/finder/nearby/api/INearbyTabLifecycleReporter;", "()V", "TAG", "", "contextId", "kotlin.jvm.PlatformType", "currentClickTabContextID", "enterClickTabContextID", "enterNearbyTabMs", "", "lastSwitchClickTabContextID", "lastSwitchTabMs", "enterNearbyTab", "", "exitNearbyTab", "getContextId", "getCurrentClickTabContextID", "getEnterClickTabContextID", "getLastSwitchClickTabContextID", "report", "pageName", "enterTimeMs", "exitTimeMs", "clickTabContextId", "reportType", "resetSwitchTabTime", "switchInNearbyTab", "fragment", "Lcom/tencent/mm/plugin/finder/nearby/base/AbsNearByFragment;", "switchOutNearbyTab", "plugin-finder-nearby_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class g
  implements c
{
  public static final g ERj;
  private static long ERk;
  private static String ERl;
  private static long ERm;
  private static String ERn;
  private static String ERo;
  private static String zIO;
  
  static
  {
    AppMethodBeat.i(339773);
    ERj = new g();
    zIO = ((com.tencent.mm.plugin.findersdk.a.cn)h.az(com.tencent.mm.plugin.findersdk.a.cn.class)).fillContextIdToIntent(12, 1, 94, new Intent());
    ERk = com.tencent.mm.model.cn.bDw();
    ERl = "";
    ERm = com.tencent.mm.model.cn.bDw();
    ERn = "";
    ERo = "1001";
    AppMethodBeat.o(339773);
  }
  
  private static void a(String paramString1, long paramLong1, long paramLong2, String paramString2, long paramLong3)
  {
    AppMethodBeat.i(339765);
    kz localkz = new kz();
    String str2 = ((d)h.ax(d.class)).dHN();
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    localkz.tU(str1);
    localkz.tV(paramString1);
    long l2 = paramLong2 - paramLong1;
    long l1 = l2;
    if (l2 <= 0L) {
      l1 = 0L;
    }
    localkz.fi(l1);
    localkz.fj(paramLong1);
    localkz.fk(paramLong2);
    localkz.tW(paramString2);
    localkz.tX("");
    localkz.iLL = paramLong3;
    localkz.tY(zIO);
    Log.i("NearbyTabLifecycleReporter", s.X("report ", localkz.aIF()));
    localkz.bMH();
    AppMethodBeat.o(339765);
  }
  
  public static void d(AbsNearByFragment paramAbsNearByFragment)
  {
    AppMethodBeat.i(339737);
    String str = paramAbsNearByFragment.eEt();
    paramAbsNearByFragment = str;
    if (str == null) {
      paramAbsNearByFragment = "";
    }
    ERo = paramAbsNearByFragment + '-' + com.tencent.mm.model.cn.bDw();
    AppMethodBeat.o(339737);
  }
  
  public static void e(AbsNearByFragment paramAbsNearByFragment)
  {
    AppMethodBeat.i(339744);
    Object localObject;
    if (paramAbsNearByFragment == null)
    {
      localObject = "";
      if (paramAbsNearByFragment != null) {
        break label103;
      }
      paramAbsNearByFragment = "";
    }
    for (;;)
    {
      long l = com.tencent.mm.model.cn.bDw();
      paramAbsNearByFragment = paramAbsNearByFragment + '-' + com.tencent.mm.model.cn.bDw();
      b.aqZ(zIO);
      b.aqY(paramAbsNearByFragment);
      a((String)localObject, ERm, l, paramAbsNearByFragment, 0L);
      ERn = paramAbsNearByFragment;
      ERm = l;
      AppMethodBeat.o(339744);
      return;
      String str = paramAbsNearByFragment.eEw();
      localObject = str;
      if (str != null) {
        break;
      }
      localObject = "";
      break;
      label103:
      str = paramAbsNearByFragment.eEt();
      paramAbsNearByFragment = str;
      if (str == null) {
        paramAbsNearByFragment = "";
      }
    }
  }
  
  public static String eGL()
  {
    return ERn;
  }
  
  public static void eGN()
  {
    AppMethodBeat.i(339729);
    ERm = com.tencent.mm.model.cn.bDw();
    AppMethodBeat.o(339729);
  }
  
  public static void eGO()
  {
    AppMethodBeat.i(339752);
    a("all", ERk, com.tencent.mm.model.cn.bDw(), ERo, 1L);
    AppMethodBeat.o(339752);
  }
  
  public static void hW(String paramString1, String paramString2)
  {
    AppMethodBeat.i(339721);
    s.u(paramString1, "contextId");
    s.u(paramString2, "enterClickTabContextID");
    zIO = paramString1;
    ERl = paramString2;
    long l = com.tencent.mm.model.cn.bDw();
    ERk = l;
    ERm = l;
    AppMethodBeat.o(339721);
  }
  
  public final String eGM()
  {
    return ERo;
  }
  
  public final String eeL()
  {
    AppMethodBeat.i(339776);
    String str = zIO;
    s.s(str, "contextId");
    AppMethodBeat.o(339776);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.nearby.report.g
 * JD-Core Version:    0.7.0.1
 */