package com.tencent.mm.plugin.finder.nearby;

import android.app.Activity;
import android.os.SystemClock;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.finder.feed.ui.FinderLiveOperationUI;
import com.tencent.mm.plugin.finder.nearby.live.square.find.FinderLiveFindPageUI;
import com.tencent.mm.plugin.finder.nearby.live.square.more.NearbyLiveMoreUI;
import com.tencent.mm.plugin.findersdk.e.b.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/nearby/NearbyConfig;", "", "()V", "CACHE_DATA_EXPIRED_MS", "", "TAG", "", "isShowGuide", "", "()Z", "setShowGuide", "(Z)V", "lastExitLiveCSTabIdMap", "Landroid/util/SparseArray;", "lastExitNearbyTimeStampMs", "", "fixLastTabType", "lastTabType", "get3TabTargetTabCommentScene", "get3TabTargetTabType", "getExitLiveTabId", "commentScene", "getExitTabType", "getNearby3TabTargetTabContextId", "getNearby3TabTargetTabId", "init", "", "removeExitLiveTabId", "saveExitLiveTabId", "tabId", "saveExitTabType", "tabType", "plugin-finder-nearby_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d
{
  public static final d EFs;
  private static int EFt;
  private static long EFu;
  private static final SparseArray<Integer> EFv;
  private static boolean EFw;
  
  static
  {
    AppMethodBeat.i(339644);
    EFs = new d();
    Object localObject = com.tencent.mm.plugin.finder.storage.d.FAy;
    EFt = ((Number)com.tencent.mm.plugin.finder.storage.d.eRD().bmg()).intValue();
    EFv = new SparseArray();
    EFw = true;
    Log.i("NearbyConfig", s.X("CACHE_DATA_EXPIRED_MS:", Integer.valueOf(EFt)));
    localObject = com.tencent.mm.plugin.findersdk.e.b.HeH;
    com.tencent.mm.plugin.findersdk.e.b.a((b.a)new b.a()
    {
      public final boolean aD(Activity paramAnonymousActivity)
      {
        AppMethodBeat.i(339561);
        s.u(paramAnonymousActivity, "activity");
        boolean bool = paramAnonymousActivity instanceof FinderLiveFindPageUI;
        AppMethodBeat.o(339561);
        return bool;
      }
      
      public final boolean aE(Activity paramAnonymousActivity)
      {
        AppMethodBeat.i(339568);
        s.u(paramAnonymousActivity, "activity");
        boolean bool = paramAnonymousActivity instanceof NearbyUI;
        AppMethodBeat.o(339568);
        return bool;
      }
      
      public final boolean aF(Activity paramAnonymousActivity)
      {
        AppMethodBeat.i(339575);
        s.u(paramAnonymousActivity, "activity");
        if (((paramAnonymousActivity instanceof NearbyLiveMoreUI)) || ((paramAnonymousActivity instanceof FinderLiveOperationUI)))
        {
          AppMethodBeat.o(339575);
          return true;
        }
        AppMethodBeat.o(339575);
        return false;
      }
    });
    AppMethodBeat.o(339644);
  }
  
  public static void Qy(int paramInt)
  {
    AppMethodBeat.i(339619);
    Log.i("NearbyConfig", s.X("saveExitTabType tabType:", Integer.valueOf(paramInt)));
    h.baE().ban().set(at.a.adbh, Integer.valueOf(paramInt));
    EFw = true;
    AppMethodBeat.o(339619);
  }
  
  public static int eEc()
  {
    int i = 1006;
    AppMethodBeat.i(339596);
    Object localObject = com.tencent.mm.plugin.finder.nearby.abtest.a.EHr;
    int j;
    int k;
    if (com.tencent.mm.plugin.finder.nearby.abtest.a.eEi())
    {
      j = 1006;
      k = h.baE().ban().getInt(at.a.adbh, -1);
      localObject = com.tencent.mm.plugin.finder.nearby.abtest.a.EHr;
      if (!com.tencent.mm.plugin.finder.nearby.abtest.a.eEi()) {
        break label120;
      }
      if (k != 1001) {
        break label134;
      }
    }
    label134:
    for (;;)
    {
      localObject = com.tencent.mm.plugin.finder.extension.reddot.nearby.a.ASI;
      k = com.tencent.mm.plugin.finder.extension.reddot.nearby.a.ebh();
      Log.i("NearbyConfig", "get3TabTargetTabType defaultType=" + j + ", lastExitType:" + i + " aliveType=" + k);
      if (k == -1) {
        break label139;
      }
      AppMethodBeat.o(339596);
      return k;
      j = 1001;
      break;
      label120:
      if (k == 1006) {
        i = 1001;
      } else {
        i = k;
      }
    }
    label139:
    if ((i != -1) && (i != 1003))
    {
      AppMethodBeat.o(339596);
      return i;
    }
    AppMethodBeat.o(339596);
    return j;
  }
  
  public static String eEd()
  {
    AppMethodBeat.i(339612);
    switch (eEc())
    {
    case 1004: 
    case 1005: 
    default: 
      AppMethodBeat.o(339612);
      return "1001";
    case 1002: 
      AppMethodBeat.o(339612);
      return "1002";
    case 1001: 
      AppMethodBeat.o(339612);
      return "1001";
    case 1006: 
      AppMethodBeat.o(339612);
      return "8003";
    }
    AppMethodBeat.o(339612);
    return "1003";
  }
  
  public static void eEe()
  {
    AppMethodBeat.i(339629);
    EFv.remove(94);
    AppMethodBeat.o(339629);
  }
  
  public static int get3TabTargetTabCommentScene()
  {
    AppMethodBeat.i(339604);
    switch (eEc())
    {
    case 1004: 
    case 1005: 
    default: 
      AppMethodBeat.o(339604);
      return 94;
    case 1002: 
      AppMethodBeat.o(339604);
      return 15;
    case 1006: 
      AppMethodBeat.o(339604);
      return 112;
    case 1001: 
      AppMethodBeat.o(339604);
      return 94;
    }
    AppMethodBeat.o(339604);
    return 77;
  }
  
  public static int getExitLiveTabId(int paramInt)
  {
    int j = 0;
    AppMethodBeat.i(339637);
    long l = SystemClock.elapsedRealtime() - EFu;
    Integer localInteger = (Integer)EFv.get(paramInt);
    int i;
    if (localInteger == null)
    {
      i = 0;
      Log.i("NearbyConfig", "getExitLiveTabId expiredMs:" + l + " tabId:" + i + " commentScene: " + paramInt);
      if (l <= EFt) {
        break label100;
      }
    }
    label100:
    for (paramInt = j;; paramInt = i)
    {
      AppMethodBeat.o(339637);
      return paramInt;
      i = localInteger.intValue();
      break;
    }
  }
  
  public static void hU(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(339626);
    Log.i("NearbyConfig", "saveExitLiveTabId tabId:" + paramInt1 + " commentScene: " + paramInt2);
    EFu = SystemClock.elapsedRealtime();
    EFv.put(paramInt2, Integer.valueOf(paramInt1));
    AppMethodBeat.o(339626);
  }
  
  public static void init()
  {
    AppMethodBeat.i(339586);
    Log.i("NearbyConfig", "NearbyConfig init");
    AppMethodBeat.o(339586);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.nearby.d
 * JD-Core Version:    0.7.0.1
 */