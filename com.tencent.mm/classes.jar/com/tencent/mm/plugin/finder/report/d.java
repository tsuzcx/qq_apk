package com.tencent.mm.plugin.finder.report;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.mmdata.rpt.ds;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.report.a;
import com.tencent.mm.protocal.protobuf.bui;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/report/FinderBulletSubtitleReporter;", "", "()V", "cache", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lcom/tencent/mm/plugin/finder/report/FinderBulletSubtitleReporter$FeedBulletData;", "getCache", "()Ljava/util/concurrent/ConcurrentHashMap;", "dequeReportData", "", "feedId", "everclosed", "", "everopened", "expocnt", "expotimes", "is_open", "value", "", "report20353", "mediaType", "action", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "start", "totalcnt", "FeedBulletData", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d
{
  private static final ConcurrentHashMap<Long, a> BvD;
  public static final d FnC;
  
  static
  {
    AppMethodBeat.i(331418);
    FnC = new d();
    BvD = new ConcurrentHashMap();
    AppMethodBeat.o(331418);
  }
  
  public static void Y(long paramLong, int paramInt)
  {
    AppMethodBeat.i(331375);
    a locala = (a)BvD.get(Long.valueOf(paramLong));
    if (locala != null) {
      locala.FnF = paramInt;
    }
    AppMethodBeat.o(331375);
  }
  
  public static void Z(long paramLong, int paramInt)
  {
    AppMethodBeat.i(331379);
    a locala = (a)BvD.get(Long.valueOf(paramLong));
    if (locala != null) {
      locala.FnG = paramInt;
    }
    AppMethodBeat.o(331379);
  }
  
  public static void a(long paramLong, int paramInt1, int paramInt2, bui parambui)
  {
    AppMethodBeat.i(331413);
    s.u(parambui, "contextObj");
    ds localds = new ds();
    localds.ipW = localds.F("feedid", com.tencent.mm.ae.d.hF(paramLong), true);
    localds.iAB = paramInt1;
    localds.iwD = parambui.AJo;
    localds.ila = paramInt2;
    localds.ixm = localds.F("Sessionid", parambui.sessionId, true);
    localds.iwI = localds.F("Contextid", parambui.zIO, true);
    localds.ijl = localds.F("ClickTabContextid", parambui.zIB, true);
    localds.bMH();
    parambui = z.FrZ;
    z.a((a)localds);
    AppMethodBeat.o(331413);
  }
  
  public static void pv(long paramLong)
  {
    AppMethodBeat.i(331363);
    a locala = (a)BvD.get(Long.valueOf(paramLong));
    if (locala != null) {
      locala.FnD += 1;
    }
    AppMethodBeat.o(331363);
  }
  
  public static void pw(long paramLong)
  {
    AppMethodBeat.i(331368);
    a locala = (a)BvD.get(Long.valueOf(paramLong));
    if (locala != null) {
      locala.FnE += 1;
    }
    AppMethodBeat.o(331368);
  }
  
  public static void px(long paramLong)
  {
    AppMethodBeat.i(331385);
    a locala = (a)BvD.get(Long.valueOf(paramLong));
    if (locala != null) {
      locala.FnH = 1;
    }
    AppMethodBeat.o(331385);
  }
  
  public static void py(long paramLong)
  {
    AppMethodBeat.i(331389);
    a locala = (a)BvD.get(Long.valueOf(paramLong));
    if (locala != null) {
      locala.FnI = 1;
    }
    AppMethodBeat.o(331389);
  }
  
  public static String pz(long paramLong)
  {
    int i = 1;
    AppMethodBeat.i(331406);
    Object localObject = (a)BvD.get(Long.valueOf(paramLong));
    if (localObject == null)
    {
      AppMethodBeat.o(331406);
      return "";
    }
    BvD.remove(Long.valueOf(paramLong));
    if (h.baE().ban().getBoolean(at.a.adee, true)) {}
    for (;;)
    {
      ((a)localObject).FnG = i;
      localObject = "{expocnt:" + ((a)localObject).FnD + ";expotimes:" + ((a)localObject).FnE + ";totalcnt:" + ((a)localObject).FnF + ";is_open:" + ((a)localObject).FnG + ";everclosed:" + ((a)localObject).FnH + ";everopened:" + ((a)localObject).FnI + '}';
      AppMethodBeat.o(331406);
      return localObject;
      i = 0;
    }
  }
  
  public static void start(long paramLong)
  {
    AppMethodBeat.i(331396);
    if (!BvD.containsKey(Long.valueOf(paramLong))) {
      BvD.put(Long.valueOf(paramLong), new a());
    }
    AppMethodBeat.o(331396);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/report/FinderBulletSubtitleReporter$FeedBulletData;", "", "()V", "everclosed", "", "getEverclosed", "()I", "setEverclosed", "(I)V", "everopened", "getEveropened", "setEveropened", "expocnt", "getExpocnt", "setExpocnt", "expotimes", "getExpotimes", "setExpotimes", "is_open", "set_open", "totalcnt", "getTotalcnt", "setTotalcnt", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    int FnD;
    int FnE;
    int FnF;
    int FnG = 1;
    int FnH;
    int FnI;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.report.d
 * JD-Core Version:    0.7.0.1
 */