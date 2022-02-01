package com.tencent.mm.plugin.finder.nearby.report;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.gl;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.cl;
import com.tencent.mm.plugin.expt.b.c;
import com.tencent.mm.plugin.expt.hellhound.core.b;
import com.tencent.mm.plugin.finder.nearby.base.AbsNearByFragment;
import com.tencent.mm.plugin.i.a.aj;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/nearby/report/NearbyTabLifecycleReporter;", "", "()V", "CLICK_TAB_CONTEXT_LIVE", "", "CLICK_TAB_CONTEXT_LIVE_MORE", "CLICK_TAB_CONTEXT_PERSON", "CLICK_TAB_CONTEXT_VIDEO", "TAG", "contextId", "kotlin.jvm.PlatformType", "currentClickTabContextID", "enterClickTabContextID", "enterNearbyTabMs", "", "lastSwitchClickTabContextID", "lastSwitchTabMs", "enterNearbyTab", "", "exitNearbyTab", "getContextId", "getCurrentClickTabContextID", "getEnterClickTabContextID", "getLastSwitchClickTabContextID", "report", "pageName", "enterTimeMs", "exitTimeMs", "clickTabContextId", "reportType", "resetSwitchTabTime", "switchInNearbyTab", "fragment", "Lcom/tencent/mm/plugin/finder/nearby/base/AbsNearByFragment;", "switchOutNearbyTab", "plugin-finder_release"})
public final class d
{
  private static String sGQ;
  private static long uTl;
  private static String uTm;
  private static long uTn;
  private static String uTo;
  private static String uTp;
  public static final d uTq;
  
  static
  {
    AppMethodBeat.i(249356);
    uTq = new d();
    sGQ = ((aj)g.ah(aj.class)).fillContextIdToIntent(12, 1, 76, new Intent());
    uTl = cl.aWA();
    uTm = "";
    uTn = cl.aWA();
    uTo = "";
    uTp = "1001";
    AppMethodBeat.o(249356);
  }
  
  private static void a(String paramString1, long paramLong1, long paramLong2, String paramString2, long paramLong3)
  {
    AppMethodBeat.i(249355);
    gl localgl = new gl();
    String str2 = ((c)g.af(c.class)).cMD();
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    localgl.uf(str1);
    localgl.ug(paramString1);
    long l2 = paramLong2 - paramLong1;
    long l1 = l2;
    if (l2 <= 0L) {
      l1 = 0L;
    }
    localgl.qp(l1);
    localgl.qq(paramLong1);
    localgl.qr(paramLong2);
    localgl.uh(paramString2);
    localgl.ui("");
    localgl.qs(paramLong3);
    localgl.uj(sGQ);
    Log.i("NearbyTabLifecycleReporter", "report " + localgl.abW());
    localgl.bfK();
    AppMethodBeat.o(249355);
  }
  
  public static String acj()
  {
    AppMethodBeat.i(249349);
    String str = sGQ;
    p.g(str, "contextId");
    AppMethodBeat.o(249349);
    return str;
  }
  
  public static void b(AbsNearByFragment paramAbsNearByFragment)
  {
    AppMethodBeat.i(249352);
    if (paramAbsNearByFragment != null) {}
    for (paramAbsNearByFragment = paramAbsNearByFragment.ack();; paramAbsNearByFragment = "")
    {
      uTp = paramAbsNearByFragment + "-" + cl.aWA();
      AppMethodBeat.o(249352);
      return;
    }
  }
  
  public static void c(AbsNearByFragment paramAbsNearByFragment)
  {
    AppMethodBeat.i(249353);
    String str1;
    if (paramAbsNearByFragment != null)
    {
      String str2 = paramAbsNearByFragment.afB();
      str1 = str2;
      if (str2 != null) {}
    }
    else
    {
      str1 = "";
    }
    if (paramAbsNearByFragment != null) {}
    for (paramAbsNearByFragment = paramAbsNearByFragment.ack();; paramAbsNearByFragment = "")
    {
      long l = cl.aWA();
      paramAbsNearByFragment = paramAbsNearByFragment + "-" + cl.aWA();
      b.aoW(sGQ);
      b.aoV(paramAbsNearByFragment);
      a(str1, uTn, l, paramAbsNearByFragment, 0L);
      uTo = paramAbsNearByFragment;
      uTn = l;
      AppMethodBeat.o(249353);
      return;
    }
  }
  
  public static String dlA()
  {
    return uTp;
  }
  
  public static void dlB()
  {
    AppMethodBeat.i(249351);
    uTn = cl.aWA();
    AppMethodBeat.o(249351);
  }
  
  public static void dlC()
  {
    AppMethodBeat.i(249354);
    a("all", uTl, cl.aWA(), uTp, 1L);
    AppMethodBeat.o(249354);
  }
  
  public static String dlz()
  {
    return uTo;
  }
  
  public static void gO(String paramString1, String paramString2)
  {
    AppMethodBeat.i(249350);
    p.h(paramString1, "contextId");
    p.h(paramString2, "enterClickTabContextID");
    sGQ = paramString1;
    uTm = paramString2;
    long l = cl.aWA();
    uTl = l;
    uTn = l;
    AppMethodBeat.o(249350);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.nearby.report.d
 * JD-Core Version:    0.7.0.1
 */