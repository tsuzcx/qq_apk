package com.tencent.mm.plugin.finder.nearby.preload;

import android.content.Intent;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.extension.reddot.f;
import com.tencent.mm.plugin.finder.nearby.preload.firstpage.c;
import com.tencent.mm.protocal.protobuf.bcz;
import com.tencent.mm.protocal.protobuf.bhw;
import com.tencent.mm.protocal.protobuf.bhx;
import com.tencent.mm.protocal.protobuf.bid;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import kotlin.g.b.p;
import kotlin.x;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/nearby/preload/NearbyPreloadManager;", "", "()V", "START_PRELOAD_LIVE_PAGES_DELAY_MS", "", "TAG", "", "enableInvokeStartPreload", "", "getEnableInvokeStartPreload", "()Z", "enableNearbyLivePagesPreload", "getEnableNearbyLivePagesPreload", "enableNearbySquareTabsPreload", "getEnableNearbySquareTabsPreload", "enableRedDotStartPreload", "getEnableRedDotStartPreload", "finderLiveTabList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/FinderLiveTabInfo;", "firstPageRenderedList", "nearbyLivePageFirstPagePreloadMap", "Ljava/util/HashMap;", "", "Lcom/tencent/mm/plugin/finder/nearby/preload/firstpage/NearbyLiveFirstPagePreload;", "Lkotlin/collections/HashMap;", "nearbySquareTabsPreload", "Lcom/tencent/mm/plugin/finder/nearby/preload/firstpage/NearbySquareTabsPreload;", "preloadLivePagesRunnable", "Ljava/lang/Runnable;", "uiHandler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "findNextTabInfo", "liveTabInfo", "findPreTabInfo", "getNearbyLiveFirstPagePreload", "tabInfo", "getNearbySquareTabsPreload", "getTargetNearbyLiveSquareTabPagePreload", "tabId", "pullType", "onEnterLiveSquareTabPage", "", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "onFirstPageRender", "onGetLiveTabList", "tabList", "release", "resetTargetTabCache", "startAndPutTargetNearbyLiveSquareTabPagePreload", "intent", "Landroid/content/Intent;", "targetTabId", "startLiveSquareTabPagePreload", "invokeSource", "startPreloadForFindPageRedDot", "startPreloadInFinderLiveEntry", "startPreloadInNearbyLiveFriendsEntry", "startPreloadNearbyLiveTabPages", "startPreloadNearbyLiveTabPagesDelay", "delayMs", "startPreloadSquareTabs", "plugin-finder-nearby_release"})
public final class a
{
  private static MMHandler knk;
  private static boolean zIm;
  private static boolean zIn;
  private static boolean zIo;
  private static boolean zIp;
  private static c zIq;
  private static HashMap<Integer, com.tencent.mm.plugin.finder.nearby.preload.firstpage.b> zIr;
  public static LinkedList<bcz> zIs;
  private static LinkedList<bcz> zIt;
  private static Runnable zIu;
  public static final a zIv;
  
  static
  {
    AppMethodBeat.i(202581);
    zIv = new a();
    zIm = true;
    zIn = true;
    zIo = true;
    zIp = true;
    zIr = new HashMap();
    zIs = new LinkedList();
    zIt = new LinkedList();
    knk = new MMHandler(Looper.getMainLooper());
    AppMethodBeat.o(202581);
  }
  
  private static void Oy(int paramInt)
  {
    AppMethodBeat.i(202574);
    Log.i("NearbyPreloadManager", "resetTargetTabCache tabId:".concat(String.valueOf(paramInt)));
    new com.tencent.mm.plugin.finder.nearby.preload.cache.a();
    ((com.tencent.c.a.b.a.d)com.tencent.mm.kernel.h.ag(com.tencent.c.a.b.a.d.class)).getTargetCommentScene(94);
    com.tencent.mm.plugin.finder.nearby.live.square.page.a locala = com.tencent.mm.plugin.finder.nearby.live.square.page.a.zGC;
    com.tencent.mm.plugin.finder.nearby.preload.cache.a.OA(com.tencent.mm.plugin.finder.nearby.live.square.page.a.Ou(paramInt));
    AppMethodBeat.o(202574);
  }
  
  public static bcz a(bcz parambcz, LinkedList<bcz> paramLinkedList)
  {
    AppMethodBeat.i(202570);
    int j = -1;
    int i = 0;
    int k = paramLinkedList.size();
    if (i < k)
    {
      if (parambcz.SOa != ((bcz)paramLinkedList.get(i)).SOa) {
        break label87;
      }
      j = i;
    }
    label87:
    for (;;)
    {
      i += 1;
      break;
      i = j - 1;
      if ((i >= 0) && (i < paramLinkedList.size()))
      {
        parambcz = (bcz)paramLinkedList.get(i);
        AppMethodBeat.o(202570);
        return parambcz;
      }
      AppMethodBeat.o(202570);
      return null;
    }
  }
  
  public static void a(bid parambid, bcz parambcz)
  {
    AppMethodBeat.i(202547);
    p.k(parambid, "contextObj");
    StringBuilder localStringBuilder = new StringBuilder("onFirstPageRender tab:[");
    if (parambcz != null)
    {
      localObject = Integer.valueOf(parambcz.SOa);
      localStringBuilder = localStringBuilder.append(localObject).append(", ");
      if (parambcz == null) {
        break label121;
      }
    }
    label121:
    for (Object localObject = parambcz.SOb;; localObject = null)
    {
      Log.i("NearbyPreloadManager", (String)localObject + ']');
      if (dMn()) {
        break label127;
      }
      Log.w("NearbyPreloadManager", "onFirstPageRender return for enableNearbyLivePagesPreload:" + dMn());
      AppMethodBeat.o(202547);
      return;
      localObject = null;
      break;
    }
    label127:
    if (parambcz != null)
    {
      if (zIt.size() == 0)
      {
        localObject = zIs;
        if (zIu != null)
        {
          knk.removeCallbacks(zIu);
          zIu = null;
        }
        zIu = (Runnable)new a(parambid, (LinkedList)localObject);
        knk.postDelayed(zIu, 700L);
      }
      parambid = ((List)zIt).iterator();
      int i = 0;
      int j;
      if (parambid.hasNext()) {
        if (((bcz)parambid.next()).SOa == parambcz.SOa)
        {
          j = 1;
          if (j == 0) {
            break label299;
          }
        }
      }
      for (;;)
      {
        if (i == -1) {
          break label311;
        }
        Log.w("NearbyPreloadManager", "onFirstPageRender return for tab page rendered tab:[" + parambcz.SOa + ", " + parambcz.SOb + ']');
        AppMethodBeat.o(202547);
        return;
        j = 0;
        break label237;
        i += 1;
        break;
        i = -1;
      }
      zIt.add(parambcz);
    }
    label237:
    AppMethodBeat.o(202547);
    label299:
    label311:
    return;
  }
  
  public static void a(bid parambid, bcz parambcz, String paramString)
  {
    AppMethodBeat.i(202553);
    if (parambcz != null)
    {
      parambcz = gM(parambcz.SOa, 12);
      parambcz.d(parambid);
      parambcz.dMs();
      AppMethodBeat.o(202553);
      return;
    }
    Log.w("NearbyPreloadManager", "startLiveSquareTabPagePreload " + paramString + " return for null");
    AppMethodBeat.o(202553);
  }
  
  public static void aJ(LinkedList<bcz> paramLinkedList)
  {
    AppMethodBeat.i(202542);
    p.k(paramLinkedList, "tabList");
    Log.i("NearbyPreloadManager", "onGetLiveTabList tabSize:" + paramLinkedList.size());
    zIs.clear();
    zIs.addAll((Collection)paramLinkedList);
    AppMethodBeat.o(202542);
  }
  
  public static void al(Intent paramIntent)
  {
    AppMethodBeat.i(202517);
    p.k(paramIntent, "intent");
    if (!dMm())
    {
      Log.w("NearbyPreloadManager", "startPreloadSquareTabs return for enableNearbySquareTabsPreload:" + dMm());
      AppMethodBeat.o(202517);
      return;
    }
    paramIntent = (kotlin.g.a.b)new c(paramIntent);
    c localc = zIq;
    if (localc != null)
    {
      com.tencent.mm.plugin.finder.nearby.preload.firstpage.a.a locala = localc.zIC;
      switch (b.$EnumSwitchMapping$0[locala.ordinal()])
      {
      }
    }
    do
    {
      paramIntent.invoke("main");
      AppMethodBeat.o(202517);
      return;
      localc.N((kotlin.g.a.b)new b(paramIntent));
      AppMethodBeat.o(202517);
      return;
    } while (localc.dMt() == null);
    Log.i("NearbyPreloadManager", "startPreloadSquareTabs hit requestCache");
    AppMethodBeat.o(202517);
  }
  
  private static void ap(Intent paramIntent)
  {
    AppMethodBeat.i(202541);
    if (!dMl())
    {
      Log.w("NearbyPreloadManager", "startPreloadForFindPageRedDot return for enableRedHotStartPreload:" + dMl());
      AppMethodBeat.o(202541);
      return;
    }
    release();
    Object localObject = com.tencent.mm.kernel.h.ag(PluginFinder.class);
    p.j(localObject, "MMKernel.plugin(PluginFinder::class.java)");
    f localf = ((PluginFinder)localObject).getRedDotManager();
    long l = 0L;
    localObject = com.tencent.mm.plugin.finder.nearby.abtest.a.zDp;
    int j;
    int i;
    int k;
    if (com.tencent.mm.plugin.finder.nearby.abtest.a.dLo())
    {
      localObject = "FinderLiveEntrance";
      com.tencent.mm.plugin.finder.extension.reddot.l locall = localf.aBf((String)localObject);
      if (locall == null) {
        break label292;
      }
      if ((locall.aBy((String)localObject) == null) || (locall.field_ctrInfo.type != 16)) {
        break label402;
      }
      localf.b(locall);
      j = locall.xuM.SSv;
      i = locall.xuM.SSz;
      k = locall.xuM.SSw;
      l = locall.xuM.object_id;
      Oy(j);
    }
    for (;;)
    {
      label176:
      if ((j != 0) && (i != 0))
      {
        al(paramIntent);
        b(paramIntent, j);
        Log.i("NearbyPreloadManager", "startPreloadForFindPageRedDot preLoad:" + i + " targetTabId:" + j);
      }
      label292:
      while ((!BuildInfo.DEBUG) && (!BuildInfo.IS_FLAVOR_RED) && (!BuildInfo.IS_FLAVOR_PURPLE))
      {
        if (k == 1) {
          com.tencent.mm.plugin.finder.nearby.live.base.b.zET.a(l, "", 94, null);
        }
        Log.i("NearbyPreloadManager", "startPreloadForFindPageRedDot checkEnterTargetLiveRoom enterLiveAction:" + k + " targetObjectId:" + l);
        AppMethodBeat.o(202541);
        return;
        localObject = "NearbyEntrance";
        break;
        k = 0;
        i = 0;
        j = 0;
        break label176;
      }
      if (j == 0)
      {
        localObject = com.tencent.mm.plugin.finder.nearby.d.zCK;
        j = com.tencent.mm.plugin.finder.nearby.d.getExitLiveTabId();
      }
      for (;;)
      {
        if (j != 0)
        {
          al(paramIntent);
          b(paramIntent, j);
        }
        paramIntent = new StringBuilder("startPreloadForFindPageRedDot debug preLoad:").append(i).append(" targetTabId:").append(j).append(" exitTabId:");
        localObject = com.tencent.mm.plugin.finder.nearby.d.zCK;
        Log.i("NearbyPreloadManager", com.tencent.mm.plugin.finder.nearby.d.getExitLiveTabId());
        break;
      }
      label402:
      l = 0L;
      k = 0;
      i = 0;
      j = 0;
    }
  }
  
  public static com.tencent.mm.plugin.finder.nearby.preload.firstpage.b b(bcz parambcz)
  {
    AppMethodBeat.i(202506);
    p.k(parambcz, "tabInfo");
    parambcz = (com.tencent.mm.plugin.finder.nearby.preload.firstpage.b)zIr.get(Integer.valueOf(parambcz.SOa));
    AppMethodBeat.o(202506);
    return parambcz;
  }
  
  public static bcz b(bcz parambcz, LinkedList<bcz> paramLinkedList)
  {
    AppMethodBeat.i(202573);
    int j = -1;
    int i = 0;
    int k = paramLinkedList.size();
    if (i < k)
    {
      if (parambcz.SOa != ((bcz)paramLinkedList.get(i)).SOa) {
        break label90;
      }
      j = i;
    }
    label90:
    for (;;)
    {
      i += 1;
      break;
      i = j + 1;
      if ((i >= 0) && (i < paramLinkedList.size()))
      {
        parambcz = (bcz)paramLinkedList.get(i);
        AppMethodBeat.o(202573);
        return parambcz;
      }
      AppMethodBeat.o(202573);
      return null;
    }
  }
  
  private static void b(Intent paramIntent, int paramInt)
  {
    AppMethodBeat.i(202556);
    com.tencent.mm.plugin.finder.nearby.preload.firstpage.b localb = gM(paramInt, 11);
    localb.aq(paramIntent);
    localb.dMs();
    ((Map)zIr).put(Integer.valueOf(paramInt), localb);
    AppMethodBeat.o(202556);
  }
  
  private static boolean dMl()
  {
    AppMethodBeat.i(202492);
    com.tencent.mm.plugin.finder.storage.d locald = com.tencent.mm.plugin.finder.storage.d.AjH;
    if (((Number)com.tencent.mm.plugin.finder.storage.d.dXy().aSr()).intValue() == 1)
    {
      AppMethodBeat.o(202492);
      return true;
    }
    AppMethodBeat.o(202492);
    return false;
  }
  
  private static boolean dMm()
  {
    AppMethodBeat.i(202498);
    com.tencent.mm.plugin.finder.storage.d locald = com.tencent.mm.plugin.finder.storage.d.AjH;
    if (((Number)com.tencent.mm.plugin.finder.storage.d.dXA().aSr()).intValue() == 1)
    {
      AppMethodBeat.o(202498);
      return true;
    }
    AppMethodBeat.o(202498);
    return false;
  }
  
  public static boolean dMn()
  {
    AppMethodBeat.i(202500);
    com.tencent.c.a.a.a.a.a locala = com.tencent.c.a.a.a.a.a.Zlt;
    if (((Number)com.tencent.c.a.a.a.a.a.ilA().aSr()).intValue() == 1)
    {
      AppMethodBeat.o(202500);
      return true;
    }
    AppMethodBeat.o(202500);
    return false;
  }
  
  public static c dMo()
  {
    return zIq;
  }
  
  private static com.tencent.mm.plugin.finder.nearby.preload.firstpage.b gM(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(202559);
    Object localObject = new bcz();
    ((bcz)localObject).SOa = paramInt1;
    localObject = new com.tencent.mm.plugin.finder.nearby.preload.firstpage.b((bcz)localObject, paramInt2);
    AppMethodBeat.o(202559);
    return localObject;
  }
  
  public static void release()
  {
    AppMethodBeat.i(202551);
    Log.i("NearbyPreloadManager", "release");
    knk.removeCallbacks(zIu);
    zIu = null;
    Object localObject = zIq;
    if (localObject != null) {
      ((c)localObject).dMv();
    }
    localObject = ((Map)zIr).entrySet().iterator();
    while (((Iterator)localObject).hasNext()) {
      ((com.tencent.mm.plugin.finder.nearby.preload.firstpage.b)((Map.Entry)((Iterator)localObject).next()).getValue()).dMv();
    }
    zIr.clear();
    zIt.clear();
    zIs.clear();
    AppMethodBeat.o(202551);
  }
  
  public final void an(Intent paramIntent)
  {
    AppMethodBeat.i(202522);
    p.k(paramIntent, "intent");
    com.tencent.mm.plugin.finder.nearby.abtest.a locala = com.tencent.mm.plugin.finder.nearby.abtest.a.zDp;
    if (!com.tencent.mm.plugin.finder.nearby.abtest.a.dLo())
    {
      Log.w("NearbyPreloadManager", "startPreloadInFinderLiveEntry return for not isEnableFindLive.");
      AppMethodBeat.o(202522);
      return;
    }
    ap(paramIntent);
    AppMethodBeat.o(202522);
  }
  
  public final void ao(Intent paramIntent)
  {
    AppMethodBeat.i(202527);
    p.k(paramIntent, "intent");
    com.tencent.mm.plugin.finder.nearby.abtest.a locala = com.tencent.mm.plugin.finder.nearby.abtest.a.zDp;
    if (com.tencent.mm.plugin.finder.nearby.abtest.a.dLo())
    {
      Log.w("NearbyPreloadManager", "startPreloadInNearbyLiveFriendsEntry return for isEnableFindLive.");
      AppMethodBeat.o(202527);
      return;
    }
    ap(paramIntent);
    AppMethodBeat.o(202527);
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class a
    implements Runnable
  {
    a(bid parambid, LinkedList paramLinkedList) {}
    
    public final void run()
    {
      AppMethodBeat.i(201162);
      a locala = a.zIv;
      a.a(this.$contextObj, this.zHh);
      AppMethodBeat.o(201162);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/findersdk/cgi/PreloadResponse;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "invoke", "com/tencent/mm/plugin/finder/nearby/preload/NearbyPreloadManager$startPreloadSquareTabs$1$1"})
  static final class b
    extends kotlin.g.b.q
    implements kotlin.g.a.b<com.tencent.mm.plugin.findersdk.b.h<com.tencent.mm.an.q>, x>
  {
    b(kotlin.g.a.b paramb)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invokeSource", "", "invoke"})
  static final class c
    extends kotlin.g.b.q
    implements kotlin.g.a.b<String, x>
  {
    c(Intent paramIntent)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.nearby.preload.a
 * JD-Core Version:    0.7.0.1
 */