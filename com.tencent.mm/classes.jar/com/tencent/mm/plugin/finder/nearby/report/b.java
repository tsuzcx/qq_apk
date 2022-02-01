package com.tencent.mm.plugin.finder.nearby.report;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.cn;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.extension.reddot.i;
import com.tencent.mm.protocal.protobuf.axm;
import com.tencent.mm.protocal.protobuf.yf;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/nearby/report/FinderNearbyLiveLoadingReporter;", "", "()V", "TAG", "", "USER_VERSION", "", "activityCreateTime", "", "clickEnterTime", "hasCacheFromClick", "", "isFromClick", "isFromRedClick", "isTabCgiStart", "loadingTimeConsumeDataMap", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/tencent/mm/plugin/finder/nearby/report/FinderNearbyLiveLoadingReporter$TimeConsumeData;", "reportedData", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "tabCgiCost", "checkHasRed", "checkPullType", "pullTypeParams", "getData", "tabType", "getDeviceLevel", "getStatsReportFluencyInfo", "", "Lcom/tencent/mm/protocal/protobuf/FinderFluencyInfo;", "onCgiBack", "", "debugMsg", "Lcom/tencent/mm/protobuf/ByteString;", "profile", "Lcom/tencent/mm/protocal/protobuf/CgiProfile;", "onDbEnd", "onDbStart", "onUIShowBegin", "onUIShowEnd", "reportILog", "it", "saveClickEnterTime", "isFromNearby", "startCgi", "pullType", "tickActivityOnCreate", "tickEnterTimer", "tickHasCacheFromClick", "hasCache", "tickReportEnd", "tickReportStart", "tabName", "tickTabCgiEnd", "tickTabCgiStart", "TimeConsumeData", "plugin-finder-nearby_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
{
  private static long EQA;
  private static long EQB;
  public static final b EQs;
  private static long EQt;
  private static long EQu;
  private static boolean EQv;
  private static boolean EQw;
  private static boolean EQx;
  public static final ConcurrentHashMap<Integer, b.a> EQy;
  private static final HashSet<b.a> EQz;
  
  static
  {
    AppMethodBeat.i(339890);
    EQs = new b();
    EQy = new ConcurrentHashMap();
    EQz = new HashSet();
    AppMethodBeat.o(339890);
  }
  
  public static b.a Rb(int paramInt)
  {
    AppMethodBeat.i(339740);
    b.a locala = (b.a)EQy.get(Integer.valueOf(paramInt));
    AppMethodBeat.o(339740);
    return locala;
  }
  
  public static boolean Rc(int paramInt)
  {
    AppMethodBeat.i(339769);
    Log.i("FinderNearbyLiveLoadingReporter", s.X("checkPullType: ", Integer.valueOf(paramInt)));
    if ((paramInt != 1) && (paramInt != 0))
    {
      AppMethodBeat.o(339769);
      return true;
    }
    AppMethodBeat.o(339769);
    return false;
  }
  
  public static void Rd(int paramInt)
  {
    AppMethodBeat.i(339806);
    Object localObject1 = Rb(paramInt);
    if (localObject1 != null)
    {
      ((b.a)localObject1).EQK = (((b.a)localObject1).EQC - ((b.a)localObject1).enterTime);
      ((b.a)localObject1).EQL = (((b.a)localObject1).EQD - ((b.a)localObject1).EQC);
      ((b.a)localObject1).EQN = (((b.a)localObject1).EQF - ((b.a)localObject1).EQE);
      ((b.a)localObject1).EQM = (((b.a)localObject1).EQH - ((b.a)localObject1).EQG);
      if (EQv)
      {
        ((b.a)localObject1).EQO = (EQu - ((b.a)localObject1).enterTime);
        ((b.a)localObject1).EQP = (((b.a)localObject1).EQC - EQu);
      }
      ((b.a)localObject1).EQK = (((b.a)localObject1).EQC - ((b.a)localObject1).enterTime);
      ((b.a)localObject1).EQL = (((b.a)localObject1).EQD - ((b.a)localObject1).EQC);
      ((b.a)localObject1).EQN = (((b.a)localObject1).EQF - ((b.a)localObject1).EQE);
      ((b.a)localObject1).EQM = (((b.a)localObject1).EQH - ((b.a)localObject1).EQG);
      Log.i("FinderNearbyLiveLoadingReporter", "add to report list: pullType = " + ((b.a)localObject1).pullType + ", tabType = " + paramInt + ", enterCost = " + ((b.a)localObject1).EQK + ", cgiCost = " + ((b.a)localObject1).EQL + ",dbCost = " + ((b.a)localObject1).EQN + ",uiCost = " + ((b.a)localObject1).EQM);
    }
    for (;;)
    {
      synchronized (EQz)
      {
        int i;
        if ((((b.a)localObject1).EQK >= 0L) && (((b.a)localObject1).EQK <= 60000L) && (((b.a)localObject1).EQL >= 0L) && (((b.a)localObject1).EQM >= 0L) && (((b.a)localObject1).EQN >= 0L))
        {
          i = 1;
          if (i != 0) {
            EQz.add(localObject1);
          }
          localObject1 = ah.aiuX;
          EQy.remove(Integer.valueOf(paramInt));
          if (EQw) {
            EQz.clear();
          }
          if (!((Collection)EQz).isEmpty())
          {
            paramInt = 1;
            if (paramInt != 0) {
              new c().bFJ();
            }
            AppMethodBeat.o(339806);
          }
        }
        else
        {
          i = 0;
        }
      }
      paramInt = 0;
    }
  }
  
  public static void aj(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(339811);
    EQv = paramBoolean1;
    EQt = cn.bDw();
    if ((!paramBoolean2) && (eGH())) {}
    for (boolean bool = true;; bool = false)
    {
      EQw = bool;
      Log.i("FinderNearbyLiveLoadingReporter", "saveClickEnterTime isFromClick : " + paramBoolean1 + " isFromRedClick: " + EQw + " isFromNearby: " + paramBoolean2);
      AppMethodBeat.o(339811);
      return;
    }
  }
  
  public static void eGF()
  {
    AppMethodBeat.i(339779);
    Log.i("FinderNearbyLiveLoadingReporter", "tickTabCgiStart");
    EQA = cn.bDw();
    AppMethodBeat.o(339779);
  }
  
  public static void eGG()
  {
    AppMethodBeat.i(339789);
    Log.i("FinderNearbyLiveLoadingReporter", "tickTabCgiEnd");
    EQB = cn.bDw() - EQA;
    AppMethodBeat.o(339789);
  }
  
  public static boolean eGH()
  {
    AppMethodBeat.i(339831);
    i locali = ((PluginFinder)h.az(PluginFinder.class)).getRedDotManager();
    Object localObject = com.tencent.mm.plugin.finder.nearby.abtest.a.EHr;
    if (com.tencent.mm.plugin.finder.nearby.abtest.a.eEi()) {}
    for (localObject = "FinderLiveEntrance"; locali.Su((String)localObject) != null; localObject = "NearbyEntrance")
    {
      AppMethodBeat.o(339831);
      return true;
    }
    AppMethodBeat.o(339831);
    return false;
  }
  
  public static void eGI()
  {
    AppMethodBeat.i(339847);
    EQu = cn.bDw();
    Log.i("FinderNearbyLiveLoadingReporter", "tickActivityOnCreate");
    AppMethodBeat.o(339847);
  }
  
  public static List<axm> eGJ()
  {
    AppMethodBeat.i(339863);
    LinkedList localLinkedList = new LinkedList();
    synchronized (EQz)
    {
      localObject3 = ((Iterable)EQz).iterator();
      if (((Iterator)localObject3).hasNext())
      {
        b.a locala = (b.a)((Iterator)localObject3).next();
        axm localaxm = new axm();
        localaxm.scene = 3;
        localaxm.pullType = locala.pullType;
        localaxm.ZIz = ((int)locala.EQK);
        localaxm.ZIA = ((int)locala.EQL);
        localaxm.ZIE = ((int)locala.EQN);
        localaxm.ZIB = ((int)locala.EQM);
        localaxm.ZIF = locala.EQI;
        Object localObject4 = locala.EQQ;
        if (localObject4 != null)
        {
          localaxm.Rsc = ((yf)localObject4).taskStartTime;
          localaxm.ZIJ = ((yf)localObject4).startConnectTime;
          localaxm.ZIK = ((yf)localObject4).connectSuccessfulTime;
          localaxm.ZIL = ((yf)localObject4).startHandshakeTime;
          localaxm.ZIM = ((yf)localObject4).handshakeSuccessfulTime;
          localaxm.ZIN = ((yf)localObject4).startSendPacketTime;
          localaxm.ZIO = ((yf)localObject4).startReadPacketTime;
          localaxm.ZIP = ((yf)localObject4).readPacketFinishedTime;
        }
        localLinkedList.add(localaxm);
        d.B((kotlin.g.a.a)new b(locala));
        localObject4 = new StringBuilder();
        ((StringBuilder)localObject4).append("getStatsReportFluencyInfo real report: \npullType = ").append(locala.pullType).append(", \nenterCost = ").append(locala.EQK).append(", \ncgiCost = ").append(locala.EQL).append(",\ndbCost = ").append(locala.EQN).append(",\ndebugMessage = ").append(locala.EQI).append(",\nisFromClick = ").append(EQv).append(",\ntabName = ").append(locala.EQJ).append(",\nstart_time = ").append(localaxm.Rsc).append("\nstart_connect_time = ").append(localaxm.ZIJ).append("\nconnect_successful_time = ").append(localaxm.ZIK).append("\nstart_tls_handshake_time = ").append(localaxm.ZIL).append("\ntls_handshake_successful_time = ");
        ((StringBuilder)localObject4).append(localaxm.ZIM).append("\nstart_send_packet_time = ").append(localaxm.ZIN).append("\nstart_read_packet_time = ").append(localaxm.ZIO).append("\nread_packet_finished_time = ").append(localaxm.ZIP);
        Log.i("FinderNearbyLiveLoadingReporter", ((StringBuilder)localObject4).toString());
      }
    }
    EQz.clear();
    Object localObject3 = ah.aiuX;
    ??? = (List)localObject2;
    AppMethodBeat.o(339863);
    return ???;
  }
  
  public static void sT(boolean paramBoolean)
  {
    AppMethodBeat.i(339838);
    Log.i("FinderNearbyLiveLoadingReporter", "tickHasCacheFromClick isFromClick : " + EQv + " hasCache: " + paramBoolean);
    if (EQv) {
      EQx = paramBoolean;
    }
    AppMethodBeat.o(339838);
  }
  
  public static void x(int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(339757);
    s.u(paramString, "tabName");
    if (Rc(paramInt1))
    {
      EQy.remove(Integer.valueOf(paramInt2));
      AppMethodBeat.o(339757);
      return;
    }
    if (!EQy.containsKey(Integer.valueOf(paramInt2)))
    {
      b.a locala = new b.a();
      locala.hJx = paramInt2;
      locala.pullType = paramInt1;
      s.u(paramString, "<set-?>");
      locala.EQJ = paramString;
      ((Map)EQy).put(Integer.valueOf(paramInt2), locala);
    }
    Log.i("FinderNearbyLiveLoadingReporter", "tickReportStart pullTypeParams: " + paramInt1 + " tabType: " + paramInt2 + " tabName: " + paramString);
    paramString = Rb(paramInt2);
    if (paramString != null) {
      if (paramInt1 != 0) {
        break label174;
      }
    }
    for (long l = EQt;; l = cn.bDw())
    {
      paramString.enterTime = l;
      AppMethodBeat.o(339757);
      return;
      label174:
      EQv = false;
      EQw = false;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.a<ah>
  {
    b(b.a parama)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.nearby.report.b
 * JD-Core Version:    0.7.0.1
 */