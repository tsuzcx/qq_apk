package com.tencent.mm.plugin.finder.nearby;

import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.findersdk.d.a.a.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/nearby/NearbyConfig;", "", "()V", "CACHE_DATA_EXPIRED_MS", "", "TAG", "", "lastExitLiveTabId", "lastExitNearbyTimeStampMs", "", "fixLastTabType", "lastTabType", "get3TabTargetTabCommentScene", "get3TabTargetTabType", "getExitLiveTabId", "getExitTabType", "getNearby3TabTargetTabContextId", "getNearby3TabTargetTabId", "saveExitLiveTabId", "", "tabId", "saveExitTabType", "tabType", "plugin-finder-nearby_release"})
public final class d
{
  private static int zCH;
  private static long zCI;
  private static int zCJ;
  public static final d zCK;
  
  static
  {
    AppMethodBeat.i(200415);
    zCK = new d();
    com.tencent.mm.plugin.finder.storage.d locald = com.tencent.mm.plugin.finder.storage.d.AjH;
    zCH = ((Number)com.tencent.mm.plugin.finder.storage.d.dTo().aSr()).intValue();
    Log.i("NearbyConfig", "CACHE_DATA_EXPIRED_MS:" + zCH);
    AppMethodBeat.o(200415);
  }
  
  public static void Ol(int paramInt)
  {
    AppMethodBeat.i(200408);
    Log.i("NearbyConfig", "saveExitTabType tabType:".concat(String.valueOf(paramInt)));
    f localf = h.aHG();
    p.j(localf, "MMKernel.storage()");
    localf.aHp().set(ar.a.Vzf, Integer.valueOf(paramInt));
    AppMethodBeat.o(200408);
  }
  
  public static void Om(int paramInt)
  {
    AppMethodBeat.i(200410);
    Log.i("NearbyConfig", "saveExitLiveTabId tabId:".concat(String.valueOf(paramInt)));
    zCI = SystemClock.elapsedRealtime();
    zCJ = paramInt;
    AppMethodBeat.o(200410);
  }
  
  public static int dLk()
  {
    int i = 1006;
    AppMethodBeat.i(200403);
    Object localObject = com.tencent.mm.plugin.finder.nearby.abtest.a.zDp;
    int j;
    int k;
    if (com.tencent.mm.plugin.finder.nearby.abtest.a.dLo())
    {
      j = 1006;
      localObject = h.aHG();
      p.j(localObject, "MMKernel.storage()");
      k = ((f)localObject).aHp().getInt(ar.a.Vzf, -1);
      localObject = com.tencent.mm.plugin.finder.nearby.abtest.a.zDp;
      if (!com.tencent.mm.plugin.finder.nearby.abtest.a.dLo()) {
        break label128;
      }
      if (k != 1001) {
        break label142;
      }
    }
    for (;;)
    {
      localObject = com.tencent.mm.plugin.finder.extension.reddot.nearby.a.xuX;
      k = com.tencent.mm.plugin.finder.extension.reddot.nearby.a.dsl();
      Log.i("NearbyConfig", "get3TabTargetTabType defaultType=" + j + ", lastExitType:" + i + " aliveType=" + k);
      if (k == -1) {
        break label147;
      }
      AppMethodBeat.o(200403);
      return k;
      j = 1001;
      break;
      label128:
      if (k == 1006) {
        i = 1001;
      } else {
        label142:
        i = k;
      }
    }
    label147:
    if ((i != -1) && (i != 1003))
    {
      AppMethodBeat.o(200403);
      return i;
    }
    AppMethodBeat.o(200403);
    return j;
  }
  
  public static String dLl()
  {
    AppMethodBeat.i(200406);
    switch (dLk())
    {
    case 1004: 
    case 1005: 
    default: 
      AppMethodBeat.o(200406);
      return "1001";
    case 1002: 
      AppMethodBeat.o(200406);
      return "1002";
    case 1001: 
      AppMethodBeat.o(200406);
      return "1001";
    case 1006: 
      AppMethodBeat.o(200406);
      return "8003";
    }
    AppMethodBeat.o(200406);
    return "1003";
  }
  
  public static int get3TabTargetTabCommentScene()
  {
    AppMethodBeat.i(200404);
    switch (dLk())
    {
    case 1004: 
    case 1005: 
    default: 
      AppMethodBeat.o(200404);
      return 94;
    case 1002: 
      AppMethodBeat.o(200404);
      return 15;
    case 1006: 
      AppMethodBeat.o(200404);
      return 112;
    case 1001: 
      AppMethodBeat.o(200404);
      return 94;
    }
    AppMethodBeat.o(200404);
    return 77;
  }
  
  public static int getExitLiveTabId()
  {
    AppMethodBeat.i(200413);
    long l = SystemClock.elapsedRealtime() - zCI;
    Log.i("NearbyConfig", "getExitLiveTabId expiredMs:" + l + " tabId:" + zCJ + ' ');
    if (l > zCH) {
      zCJ = 0;
    }
    int i = zCJ;
    AppMethodBeat.o(200413);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.nearby.d
 * JD-Core Version:    0.7.0.1
 */