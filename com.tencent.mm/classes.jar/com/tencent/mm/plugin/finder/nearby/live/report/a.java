package com.tencent.mm.plugin.finder.nearby.live.report;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ad.i;
import com.tencent.mm.f.b.a.bt;
import com.tencent.mm.f.b.a.bu;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.cm;
import com.tencent.mm.plugin.expt.b.c;
import com.tencent.mm.plugin.finder.nearby.base.AbsNearByFragment;
import com.tencent.mm.plugin.finder.nearby.live.localcity.NearbyLiveLocalCityFragment;
import com.tencent.mm.plugin.finder.nearby.live.square.page.NearbyLiveSquareTabFragment;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/nearby/live/report/FinderLiveSquareTabLifeCycleReport;", "", "()V", "TAG", "", "clickTabContextId", "clickTabId", "contextId", "isInOnPauseState", "", "isNeverPageIn", "pageInMs", "", "refPageId", "enterLiveRoom", "", "enterLiveSquare", "fragment", "Lcom/tencent/mm/plugin/finder/nearby/base/AbsNearByFragment;", "enterProfile", "getPageStayMs", "getTabContextId", "liveTabPageIn", "commentscene", "pagId", "tabId", "subTabId", "subTabContextID", "liveTabPageOut", "onPause", "onResume", "reset", "plugin-finder-nearby_release"})
public final class a
{
  private static String wmL;
  private static String wmz;
  private static String zDs;
  private static String zFY;
  private static long zFZ;
  private static boolean zGa;
  private static boolean zGb;
  public static final a zGc;
  
  static
  {
    AppMethodBeat.i(199420);
    zGc = new a();
    wmL = "";
    zDs = "";
    wmz = "";
    zFY = "";
    zGa = true;
    AppMethodBeat.o(199420);
  }
  
  public static void a(String paramString1, AbsNearByFragment paramAbsNearByFragment, String paramString2)
  {
    AppMethodBeat.i(199406);
    p.k(paramString1, "contextId");
    p.k(paramAbsNearByFragment, "fragment");
    p.k(paramString2, "clickTabContextId");
    Log.i("FinderLiveSquareTabLifeCycleReport", "enterLiveSquare contextId:".concat(String.valueOf(paramString1)));
    wmL = paramString1;
    zDs = paramAbsNearByFragment.dLv();
    zFZ = 0L;
    wmz = paramString2;
    AppMethodBeat.o(199406);
  }
  
  public static void b(AbsNearByFragment paramAbsNearByFragment)
  {
    AppMethodBeat.i(199417);
    if (zGb)
    {
      Log.w("FinderLiveSquareTabLifeCycleReport", "liveTabPageIn return for isInOnPauseState");
      AppMethodBeat.o(199417);
      return;
    }
    if ((!(paramAbsNearByFragment instanceof NearbyLiveSquareTabFragment)) && (!(paramAbsNearByFragment instanceof NearbyLiveLocalCityFragment)))
    {
      AppMethodBeat.o(199417);
      return;
    }
    String str1 = paramAbsNearByFragment.dLv();
    String str5 = paramAbsNearByFragment.dLw();
    int i = paramAbsNearByFragment.getCommentScene();
    String str2 = "page_tab_" + str1 + '_' + str5;
    String str3 = paramAbsNearByFragment.aiS();
    if (TextUtils.isEmpty((CharSequence)zFY))
    {
      paramAbsNearByFragment = com.tencent.mm.plugin.finder.nearby.live.square.page.a.zGC;
      if (com.tencent.mm.plugin.finder.nearby.live.square.page.a.isFinderLiveSquareMoreCommentScene(i)) {
        zFY = "page_live_flow";
      }
    }
    String str4 = zFY;
    bt localbt = new bt();
    localbt.eg(cm.bfE());
    localbt.kW(str2);
    localbt.kX(str1);
    localbt.kY(str5);
    str1 = ((c)h.ae(c.class)).dbr();
    paramAbsNearByFragment = str1;
    if (str1 == null) {
      paramAbsNearByFragment = "";
    }
    localbt.kZ(paramAbsNearByFragment);
    localbt.la(wmL);
    localbt.lb(wmz);
    localbt.lc(str3);
    localbt.ld("");
    localbt.le(str4);
    localbt.lf(String.valueOf(i));
    localbt.bpa();
    Log.i("FinderLiveSquareTabLifeCycleReport", "liveTabPageIn " + localbt.agI());
    zFY = str2;
    zFZ = cm.bfE();
    zGa = false;
    AppMethodBeat.o(199417);
  }
  
  public static void c(AbsNearByFragment paramAbsNearByFragment)
  {
    AppMethodBeat.i(199419);
    if (zGa)
    {
      Log.w("FinderLiveSquareTabLifeCycleReport", "liveTabPageOut return for isNeverPageIn");
      AppMethodBeat.o(199419);
      return;
    }
    if ((!(paramAbsNearByFragment instanceof NearbyLiveSquareTabFragment)) && (!(paramAbsNearByFragment instanceof NearbyLiveLocalCityFragment)))
    {
      AppMethodBeat.o(199419);
      return;
    }
    String str1 = paramAbsNearByFragment.dLv();
    String str3 = paramAbsNearByFragment.dLw();
    int i = paramAbsNearByFragment.getCommentScene();
    String str4 = "page_tab_" + str1 + '_' + str3;
    String str2 = paramAbsNearByFragment.aiS();
    p.k("", "clickSubTabContextId");
    paramAbsNearByFragment.yAU = "";
    bu localbu = new bu();
    localbu.eh(cm.bfE());
    localbu.lg(str4);
    localbu.lh(str1);
    localbu.li(str3);
    str1 = ((c)h.ae(c.class)).dbr();
    paramAbsNearByFragment = str1;
    if (str1 == null) {
      paramAbsNearByFragment = "";
    }
    localbu.lj(paramAbsNearByFragment);
    localbu.lk(wmL);
    localbu.ll(wmz);
    localbu.lm(str2);
    if (zFZ <= 0L) {
      paramAbsNearByFragment = "";
    }
    for (;;)
    {
      localbu.ln(paramAbsNearByFragment);
      localbu.lo(String.valueOf(i));
      localbu.bpa();
      Log.i("FinderLiveSquareTabLifeCycleReport", "liveTabPageOut " + localbu.agI());
      AppMethodBeat.o(199419);
      return;
      long l1 = cm.bfE();
      long l2 = zFZ;
      paramAbsNearByFragment = new i();
      paramAbsNearByFragment.s("staytime", l1 - l2);
      paramAbsNearByFragment = paramAbsNearByFragment.toString();
      p.j(paramAbsNearByFragment, "pgUdfKv.toString()");
    }
  }
  
  public static String dMb()
  {
    return wmz;
  }
  
  public static void dMc()
  {
    AppMethodBeat.i(199409);
    Log.i("FinderLiveSquareTabLifeCycleReport", "enterLiveRoom");
    zFY = "page_live_flow";
    AppMethodBeat.o(199409);
  }
  
  public static void dMd()
  {
    AppMethodBeat.i(199410);
    Log.i("FinderLiveSquareTabLifeCycleReport", "enterProfile");
    zFY = "page_profile";
    AppMethodBeat.o(199410);
  }
  
  public static void onPause()
  {
    zGb = true;
  }
  
  public static void onResume()
  {
    zGb = false;
  }
  
  public static void reset()
  {
    wmL = "";
    zDs = "";
    zFY = "";
    zFZ = 0L;
    wmz = "";
    zGa = true;
    zGb = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.nearby.live.report.a
 * JD-Core Version:    0.7.0.1
 */