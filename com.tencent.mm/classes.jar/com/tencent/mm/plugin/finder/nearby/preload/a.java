package com.tencent.mm.plugin.finder.nearby.preload;

import android.content.Intent;
import android.os.Looper;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.nearby.preload.firstpage.c;
import com.tencent.mm.protocal.protobuf.bnn;
import com.tencent.mm.protocal.protobuf.btw;
import com.tencent.mm.protocal.protobuf.btx;
import com.tencent.mm.protocal.protobuf.bui;
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
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/nearby/preload/NearbyPreloadManager;", "", "()V", "START_PRELOAD_LIVE_PAGES_DELAY_MS", "", "TAG", "", "enableInvokeStartPreload", "", "getEnableInvokeStartPreload", "()Z", "enableNearbyLivePagesPreload", "getEnableNearbyLivePagesPreload", "enableNearbySquareTabsPreload", "getEnableNearbySquareTabsPreload", "enableRedDotStartPreload", "getEnableRedDotStartPreload", "finderLiveTabList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/FinderLiveTabInfo;", "firstPageRenderedList", "nearbyLivePageFirstPagePreloadMap", "Ljava/util/HashMap;", "", "Lcom/tencent/mm/plugin/finder/nearby/preload/firstpage/NearbyLiveFirstPagePreload;", "Lkotlin/collections/HashMap;", "nearbySquareTabsPreload", "Lcom/tencent/mm/plugin/finder/nearby/preload/firstpage/NearbySquareTabsPreload;", "preloadLivePagesRunnable", "Ljava/lang/Runnable;", "subTabCommentSceneMap", "Landroid/util/SparseArray;", "uiHandler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "findNextTabInfo", "liveTabInfo", "findPreTabInfo", "getCommentScene", "tabId", "getLiveRecomTabType", "getMemoryCacheFlag", "getNearbyLiveFirstPagePreload", "tabInfo", "getNearbySquareTabsPreload", "getTargetNearbyLiveSquareTabPagePreload", "commentScene", "pullType", "isEnableClickPreload", "onClickRedDotEnterLiveRoom", "", "contextId", "targetTabId", "onEnterLiveSquareTabPage", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "onFirstPageRender", "onGetLiveTabList", "tabList", "release", "resetTargetTabCache", "saveSubTabCommentScene", "startAndPutTargetNearbyLiveSquareTabPagePreload", "intent", "Landroid/content/Intent;", "startLiveSquareTabPagePreload", "invokeSource", "startPreloadForFindPageRedDot", "startPreloadInFinderLiveEntry", "startPreloadInNearbyLiveFriendsEntry", "startPreloadNearbyLiveTabPages", "startPreloadNearbyLiveTabPagesDelay", "delayMs", "startPreloadSquareTabs", "startSquareTabPagePreloadFromClick", "tabName", "plugin-finder-nearby_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
{
  public static final a EPD;
  private static boolean EPE;
  private static boolean EPF;
  private static boolean EPG;
  private static boolean EPH;
  private static c EPI;
  private static HashMap<Integer, com.tencent.mm.plugin.finder.nearby.preload.firstpage.b> EPJ;
  public static LinkedList<bnn> EPK;
  private static LinkedList<bnn> EPL;
  private static SparseArray<Integer> EPM;
  private static Runnable EPN;
  private static MMHandler mRi;
  
  static
  {
    AppMethodBeat.i(340313);
    EPD = new a();
    EPE = true;
    EPF = true;
    EPG = true;
    EPH = true;
    EPJ = new HashMap();
    EPK = new LinkedList();
    EPL = new LinkedList();
    EPM = new SparseArray();
    mRi = new MMHandler(Looper.getMainLooper());
    AppMethodBeat.o(340313);
  }
  
  private static int QT(int paramInt)
  {
    AppMethodBeat.i(340183);
    com.tencent.mm.plugin.finder.nearby.live.square.page.b localb = com.tencent.mm.plugin.finder.nearby.live.square.page.b.ELW;
    paramInt = com.tencent.mm.plugin.finder.nearby.live.square.page.b.parseTabIdFlag(QU(paramInt), paramInt);
    AppMethodBeat.o(340183);
    return paramInt;
  }
  
  private static int QU(int paramInt)
  {
    AppMethodBeat.i(340199);
    Integer localInteger = (Integer)EPM.get(paramInt);
    if (localInteger == null)
    {
      AppMethodBeat.o(340199);
      return 0;
    }
    paramInt = localInteger.intValue();
    AppMethodBeat.o(340199);
    return paramInt;
  }
  
  private static void QV(int paramInt)
  {
    AppMethodBeat.i(340264);
    int i = paramInt;
    if (paramInt == 0) {
      i = 88890;
    }
    Object localObject = com.tencent.mm.plugin.finder.nearby.d.EFs;
    com.tencent.mm.plugin.finder.nearby.d.eEe();
    new com.tencent.mm.plugin.finder.nearby.preload.cache.a();
    paramInt = ((com.tencent.d.a.b.a.d)h.az(com.tencent.d.a.b.a.d.class)).getTargetCommentScene(94, i);
    localObject = com.tencent.mm.plugin.finder.nearby.live.square.page.b.ELW;
    int j = com.tencent.mm.plugin.finder.nearby.live.square.page.b.parseTabIdFlag(paramInt, i);
    com.tencent.mm.plugin.finder.nearby.preload.cache.a.QX(j);
    Log.i("NearbyPreloadManager", "resetTargetTabCache tabId:" + i + " commentScene: " + paramInt + " memoryCacheFlag: " + j);
    AppMethodBeat.o(340264);
  }
  
  public static bnn a(bnn parambnn, LinkedList<bnn> paramLinkedList)
  {
    AppMethodBeat.i(340240);
    int m = paramLinkedList.size();
    int i;
    int j;
    int k;
    if (m > 0)
    {
      i = 0;
      j = -1;
      k = i + 1;
      if (parambnn.ZVZ == ((bnn)paramLinkedList.get(i)).ZVZ) {
        label44:
        if (k < m) {}
      }
    }
    for (;;)
    {
      i -= 1;
      if ((i >= 0) && (i < paramLinkedList.size()))
      {
        parambnn = (bnn)paramLinkedList.get(i);
        AppMethodBeat.o(340240);
        return parambnn;
      }
      AppMethodBeat.o(340240);
      return null;
      j = k;
      k = i;
      i = j;
      j = k;
      break;
      i = j;
      break label44;
      i = -1;
    }
  }
  
  public static void a(Intent paramIntent, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(340223);
    s.u(paramIntent, "intent");
    Object localObject = com.tencent.mm.plugin.finder.nearby.live.square.page.b.ELW;
    int i = com.tencent.mm.plugin.finder.nearby.live.square.page.b.parseTabCommentScene(94, paramInt1);
    localObject = aE(i, paramInt1, paramInt2);
    ((com.tencent.mm.plugin.finder.nearby.preload.firstpage.b)localObject).aE(paramIntent);
    ((com.tencent.mm.plugin.finder.nearby.preload.firstpage.b)localObject).eGy();
    ((Map)EPJ).put(Integer.valueOf(paramInt1), localObject);
    Log.i("NearbyPreloadManager", "startRedDot preload PagePreloadMap commentScene: " + i + " TabId: " + paramInt1 + " memoryType: " + QT(paramInt1));
    AppMethodBeat.o(340223);
  }
  
  public static void a(bui parambui, bnn parambnn)
  {
    AppMethodBeat.i(340139);
    s.u(parambui, "contextObj");
    StringBuilder localStringBuilder = new StringBuilder("onFirstPageRender tab:[");
    if (parambnn == null)
    {
      localObject = null;
      localStringBuilder = localStringBuilder.append(localObject).append(", ");
      if (parambnn != null) {
        break label116;
      }
    }
    label116:
    for (Object localObject = null;; localObject = parambnn.ZWa)
    {
      Log.i("NearbyPreloadManager", localObject + ']');
      if (eGs()) {
        break label125;
      }
      Log.w("NearbyPreloadManager", s.X("onFirstPageRender return for enableNearbyLivePagesPreload:", Boolean.valueOf(eGs())));
      AppMethodBeat.o(340139);
      return;
      localObject = Integer.valueOf(parambnn.ZVZ);
      break;
    }
    label125:
    if (parambnn != null)
    {
      if (EPL.size() == 0)
      {
        localObject = EPK;
        if (EPN != null)
        {
          mRi.removeCallbacks(EPN);
          EPN = null;
        }
        EPN = new a..ExternalSyntheticLambda0(parambui, (LinkedList)localObject);
        mRi.postDelayed(EPN, 700L);
      }
      parambui = ((List)EPL).iterator();
      int i = 0;
      int j;
      if (parambui.hasNext()) {
        if (((bnn)parambui.next()).ZVZ == parambnn.ZVZ)
        {
          j = 1;
          if (j == 0) {
            break label296;
          }
        }
      }
      for (;;)
      {
        if (i == -1) {
          break label308;
        }
        Log.w("NearbyPreloadManager", "onFirstPageRender return for tab page rendered tab:[" + parambnn.ZVZ + ", " + parambnn.ZWa + ']');
        AppMethodBeat.o(340139);
        return;
        j = 0;
        break label232;
        i += 1;
        break;
        i = -1;
      }
      EPL.add(parambnn);
    }
    label232:
    AppMethodBeat.o(340139);
    label296:
    label308:
    return;
  }
  
  public static void a(bui parambui, bnn parambnn, int paramInt, String paramString)
  {
    AppMethodBeat.i(340170);
    if (parambnn == null) {}
    for (parambui = null;; parambui = ah.aiuX)
    {
      if (parambui == null) {
        Log.w("NearbyPreloadManager", "startLiveSquareTabPagePreload " + paramString + " return for null");
      }
      AppMethodBeat.o(340170);
      return;
      int i = QU(parambnn.ZVZ);
      com.tencent.mm.plugin.finder.nearby.preload.firstpage.b localb = aE(i, parambnn.ZVZ, paramInt);
      localb.d(parambui);
      localb.eGy();
      Log.i("NearbyPreloadManager", "startLiveSquareTabPagePreload PagePreloadMap commentScene " + i + " TabId: " + parambnn.ZVZ + " Tabname: " + parambnn.ZWa + " memoryType: " + QT(parambnn.ZVZ));
    }
  }
  
  private static final void a(bui parambui, LinkedList paramLinkedList)
  {
    AppMethodBeat.i(340285);
    s.u(parambui, "$contextObj");
    s.u(paramLinkedList, "$tabList");
    if (!eGs())
    {
      Log.w("NearbyPreloadManager", s.X("startPreloadNearbyLiveTabPages return for enableNearbyLivePagesPreload:", Boolean.valueOf(eGs())));
      AppMethodBeat.o(340285);
      return;
    }
    Log.i("NearbyPreloadManager", s.X("startPreloadNearbyLiveTabPages tabList:", Integer.valueOf(paramLinkedList.size())));
    paramLinkedList = ((Iterable)paramLinkedList).iterator();
    while (paramLinkedList.hasNext())
    {
      Object localObject = (bnn)paramLinkedList.next();
      if (EPJ.containsKey(Integer.valueOf(((bnn)localObject).ZVZ)))
      {
        Log.w("NearbyPreloadManager", "startPreloadNearbyLiveTabPages return for map contains tab:[" + ((bnn)localObject).ZVZ + ", " + ((bnn)localObject).ZWa + ']');
      }
      else
      {
        Iterator localIterator = ((List)EPL).iterator();
        int i = 0;
        label178:
        int j;
        if (localIterator.hasNext()) {
          if (((bnn)localIterator.next()).ZVZ == ((bnn)localObject).ZVZ)
          {
            j = 1;
            label211:
            if (j == 0) {
              break label273;
            }
          }
        }
        for (;;)
        {
          if (i == -1) {
            break label285;
          }
          Log.w("NearbyPreloadManager", "startPreloadNearbyLiveTabPages return for tab page rendered tab:[" + ((bnn)localObject).ZVZ + ", " + ((bnn)localObject).ZWa + ']');
          break;
          j = 0;
          break label211;
          label273:
          i += 1;
          break label178;
          i = -1;
        }
        label285:
        if (!((bnn)localObject).ZWb)
        {
          Log.w("NearbyPreloadManager", "startPreloadNearbyLiveTabPages return for tab disable preload:[" + ((bnn)localObject).ZVZ + ", " + ((bnn)localObject).ZWa + ']');
        }
        else
        {
          i = ((bnn)localObject).ZVZ;
          j = QU(i);
          localObject = aE(j, i, 12);
          ((com.tencent.mm.plugin.finder.nearby.preload.firstpage.b)localObject).d(parambui);
          ((com.tencent.mm.plugin.finder.nearby.preload.firstpage.b)localObject).eGy();
          ((Map)EPJ).put(Integer.valueOf(i), localObject);
          Log.i("NearbyPreloadManager", "startAndPutTargetNearbyLiveSquareTabPagePreload PagePreloadMap commentScene " + j + " TabId: " + i + " memoryType: " + QT(i));
        }
      }
    }
    AppMethodBeat.o(340285);
  }
  
  public static void aA(Intent paramIntent)
  {
    AppMethodBeat.i(340080);
    s.u(paramIntent, "intent");
    if (!eGr())
    {
      Log.w("NearbyPreloadManager", s.X("startPreloadSquareTabs return for enableNearbySquareTabsPreload:", Boolean.valueOf(eGr())));
      AppMethodBeat.o(340080);
      return;
    }
    paramIntent = (kotlin.g.a.b)new c(paramIntent);
    c localc = EPI;
    if (localc != null)
    {
      com.tencent.mm.plugin.finder.nearby.preload.firstpage.a.a locala = localc.EPU;
      switch (a.$EnumSwitchMapping$0[locala.ordinal()])
      {
      }
    }
    do
    {
      paramIntent.invoke("main");
      AppMethodBeat.o(340080);
      return;
      localc.at((kotlin.g.a.b)new b(paramIntent));
      AppMethodBeat.o(340080);
      return;
    } while (localc.eGz() == null);
    Log.i("NearbyPreloadManager", "startPreloadSquareTabs hit requestCache");
    AppMethodBeat.o(340080);
  }
  
  private final void aD(Intent paramIntent)
  {
    AppMethodBeat.i(340104);
    if (!eGq())
    {
      Log.w("NearbyPreloadManager", s.X("startPreloadForFindPageRedDot return for enableRedHotStartPreload:", Boolean.valueOf(eGq())));
      AppMethodBeat.o(340104);
      return;
    }
    release();
    com.tencent.mm.plugin.finder.extension.reddot.i locali = ((PluginFinder)h.az(PluginFinder.class)).getRedDotManager();
    long l = 0L;
    Object localObject = com.tencent.mm.plugin.finder.nearby.abtest.a.EHr;
    int k;
    int j;
    int i;
    if (com.tencent.mm.plugin.finder.nearby.abtest.a.eEi())
    {
      localObject = "FinderLiveEntrance";
      com.tencent.mm.plugin.finder.extension.reddot.p localp = locali.Su((String)localObject);
      if ((localp == null) || (localp.avK((String)localObject) == null) || (localp.field_ctrInfo.type != 16)) {
        break label280;
      }
      locali.e(localp);
      k = localp.ASz.aabK;
      j = localp.ASz.aabO;
      i = localp.ASz.aabL;
      l = localp.ASz.object_id;
      QV(k);
    }
    for (;;)
    {
      if ((k != 0) && (j != 0))
      {
        aA(paramIntent);
        a(paramIntent, k, 11);
        Log.i("NearbyPreloadManager", "startPreloadForFindPageRedDot preLoad:" + j + " targetTabId:" + k);
      }
      if (i == 1) {
        com.tencent.mm.plugin.finder.nearby.live.base.b.EJG.a(l, "", 94, null);
      }
      Log.i("NearbyPreloadManager", "startPreloadForFindPageRedDot checkEnterTargetLiveRoom enterLiveAction:" + i + " targetObjectId:" + l);
      AppMethodBeat.o(340104);
      return;
      localObject = "NearbyEntrance";
      break;
      label280:
      i = 0;
      j = 0;
      k = 0;
    }
  }
  
  private static com.tencent.mm.plugin.finder.nearby.preload.firstpage.b aE(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(340232);
    Object localObject = new bnn();
    ((bnn)localObject).ZVZ = paramInt2;
    ah localah = ah.aiuX;
    localObject = b((bnn)localObject);
    if ((localObject != null) && (((com.tencent.mm.plugin.finder.nearby.preload.firstpage.b)localObject).odF == paramInt1) && (((com.tencent.mm.plugin.finder.nearby.preload.firstpage.b)localObject).pullType == paramInt3))
    {
      Log.i("NearbyPreloadManager", s.X("getTargetNearbyLiveSquareTabPagePreload return map cache tabId: ", Integer.valueOf(paramInt2)));
      AppMethodBeat.o(340232);
      return localObject;
    }
    localObject = new bnn();
    ((bnn)localObject).ZVZ = paramInt2;
    localObject = new com.tencent.mm.plugin.finder.nearby.preload.firstpage.b(paramInt1, (bnn)localObject, paramInt3);
    AppMethodBeat.o(340232);
    return localObject;
  }
  
  public static void aO(LinkedList<bnn> paramLinkedList)
  {
    AppMethodBeat.i(340114);
    s.u(paramLinkedList, "tabList");
    Log.i("NearbyPreloadManager", s.X("onGetLiveTabList tabSize:", Integer.valueOf(paramLinkedList.size())));
    EPK.clear();
    EPK.addAll((Collection)paramLinkedList);
    AppMethodBeat.o(340114);
  }
  
  public static com.tencent.mm.plugin.finder.nearby.preload.firstpage.b b(bnn parambnn)
  {
    AppMethodBeat.i(340061);
    s.u(parambnn, "tabInfo");
    parambnn = (com.tencent.mm.plugin.finder.nearby.preload.firstpage.b)EPJ.get(Integer.valueOf(parambnn.ZVZ));
    AppMethodBeat.o(340061);
    return parambnn;
  }
  
  public static bnn b(bnn parambnn, LinkedList<bnn> paramLinkedList)
  {
    AppMethodBeat.i(340251);
    int m = paramLinkedList.size();
    int i;
    int j;
    int k;
    if (m > 0)
    {
      i = 0;
      j = -1;
      k = i + 1;
      if (parambnn.ZVZ == ((bnn)paramLinkedList.get(i)).ZVZ) {
        label44:
        if (k < m) {}
      }
    }
    for (;;)
    {
      i += 1;
      if ((i >= 0) && (i < paramLinkedList.size()))
      {
        parambnn = (bnn)paramLinkedList.get(i);
        AppMethodBeat.o(340251);
        return parambnn;
      }
      AppMethodBeat.o(340251);
      return null;
      j = k;
      k = i;
      i = j;
      j = k;
      break;
      i = j;
      break label44;
      i = -1;
    }
  }
  
  private static boolean eGq()
  {
    AppMethodBeat.i(340020);
    com.tencent.mm.plugin.finder.storage.d locald = com.tencent.mm.plugin.finder.storage.d.FAy;
    if (((Number)com.tencent.mm.plugin.finder.storage.d.eWq().bmg()).intValue() == 1)
    {
      AppMethodBeat.o(340020);
      return true;
    }
    AppMethodBeat.o(340020);
    return false;
  }
  
  private static boolean eGr()
  {
    AppMethodBeat.i(340031);
    com.tencent.mm.plugin.finder.storage.d locald = com.tencent.mm.plugin.finder.storage.d.FAy;
    if (((Number)com.tencent.mm.plugin.finder.storage.d.eWs().bmg()).intValue() == 1)
    {
      AppMethodBeat.o(340031);
      return true;
    }
    AppMethodBeat.o(340031);
    return false;
  }
  
  public static boolean eGs()
  {
    AppMethodBeat.i(340043);
    com.tencent.d.a.a.a.a.a locala = com.tencent.d.a.a.a.a.a.ahiX;
    if (((Number)com.tencent.d.a.a.a.a.a.jSc().bmg()).intValue() == 1)
    {
      AppMethodBeat.o(340043);
      return true;
    }
    AppMethodBeat.o(340043);
    return false;
  }
  
  public static c eGt()
  {
    return EPI;
  }
  
  public static boolean eGu()
  {
    AppMethodBeat.i(340213);
    com.tencent.mm.plugin.finder.storage.d locald = com.tencent.mm.plugin.finder.storage.d.FAy;
    if (((Number)com.tencent.mm.plugin.finder.storage.d.eXN().bmg()).intValue() == 1)
    {
      AppMethodBeat.o(340213);
      return true;
    }
    AppMethodBeat.o(340213);
    return false;
  }
  
  public static void hX(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(340071);
    EPM.put(paramInt1, Integer.valueOf(paramInt2));
    AppMethodBeat.o(340071);
  }
  
  public static void release()
  {
    AppMethodBeat.i(340157);
    Log.i("NearbyPreloadManager", "release");
    mRi.removeCallbacks(EPN);
    EPN = null;
    Object localObject = EPI;
    if (localObject != null) {
      ((c)localObject).eGB();
    }
    localObject = ((Map)EPJ).entrySet().iterator();
    while (((Iterator)localObject).hasNext()) {
      ((com.tencent.mm.plugin.finder.nearby.preload.firstpage.b)((Map.Entry)((Iterator)localObject).next()).getValue()).eGB();
    }
    EPJ.clear();
    EPL.clear();
    EPK.clear();
    AppMethodBeat.o(340157);
  }
  
  public final void a(Intent paramIntent, int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(340363);
    s.u(paramIntent, "intent");
    s.u(paramString, "tabName");
    Log.i("NearbyPreloadManager", s.X("startSquareTabPagePreloadFromClick isEnableClickPreload: ", Boolean.valueOf(eGu())));
    if (!eGu())
    {
      AppMethodBeat.o(340363);
      return;
    }
    com.tencent.mm.plugin.finder.nearby.report.b localb = com.tencent.mm.plugin.finder.nearby.report.b.EQs;
    com.tencent.mm.plugin.finder.nearby.report.b.x(paramInt2, paramInt1 + 1001, paramString);
    a(paramIntent, paramInt1, paramInt2);
    AppMethodBeat.o(340363);
  }
  
  public final void aB(Intent paramIntent)
  {
    AppMethodBeat.i(340336);
    s.u(paramIntent, "intent");
    com.tencent.mm.plugin.finder.nearby.abtest.a locala = com.tencent.mm.plugin.finder.nearby.abtest.a.EHr;
    if (!com.tencent.mm.plugin.finder.nearby.abtest.a.eEi())
    {
      Log.w("NearbyPreloadManager", "startPreloadInFinderLiveEntry return for not isEnableFindLive.");
      AppMethodBeat.o(340336);
      return;
    }
    aD(paramIntent);
    AppMethodBeat.o(340336);
  }
  
  public final void aC(Intent paramIntent)
  {
    AppMethodBeat.i(340344);
    s.u(paramIntent, "intent");
    com.tencent.mm.plugin.finder.nearby.abtest.a locala = com.tencent.mm.plugin.finder.nearby.abtest.a.EHr;
    if (com.tencent.mm.plugin.finder.nearby.abtest.a.eEi())
    {
      Log.w("NearbyPreloadManager", "startPreloadInNearbyLiveFriendsEntry return for isEnableFindLive.");
      AppMethodBeat.o(340344);
      return;
    }
    aD(paramIntent);
    AppMethodBeat.o(340344);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/findersdk/cgi/PreloadResponse;", "Lcom/tencent/mm/modelbase/NetSceneBase;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.b<com.tencent.mm.plugin.findersdk.b.i<com.tencent.mm.am.p>, ah>
  {
    b(kotlin.g.a.b<? super String, ah> paramb)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "invokeSource", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements kotlin.g.a.b<String, ah>
  {
    c(Intent paramIntent)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.nearby.preload.a
 * JD-Core Version:    0.7.0.1
 */