package com.tencent.mm.plugin.finder.nearby.newlivesquare;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.model.cc;
import com.tencent.mm.plugin.finder.storage.d;
import com.tencent.mm.plugin.findersdk.storage.config.base.b;
import com.tencent.mm.protocal.protobuf.bqr;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/nearby/newlivesquare/CacheUtils;", "", "()V", "TAG", "", "isLastExitEntranceTimeOut", "", "()Z", "lastExitEntranceDataInterval", "", "getLastExitEntranceDataInterval", "()I", "setLastExitEntranceDataInterval", "(I)V", "lastExitEntranceDataList", "", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "getLastExitEntranceDataList", "()Ljava/util/List;", "lastExitEntranceResp", "Lcom/tencent/mm/protocal/protobuf/FinderNavLiveStreamResponse;", "getLastExitEntranceResp", "()Lcom/tencent/mm/protocal/protobuf/FinderNavLiveStreamResponse;", "setLastExitEntranceResp", "(Lcom/tencent/mm/protocal/protobuf/FinderNavLiveStreamResponse;)V", "lastExitEntranceTime", "", "getLastExitEntranceTime", "()J", "setLastExitEntranceTime", "(J)V", "lastPrefetchTime", "getLastPrefetchTime", "setLastPrefetchTime", "prefetchInterval", "getPrefetchInterval", "setPrefetchInterval", "rvScrollOffset", "getRvScrollOffset", "setRvScrollOffset", "plugin-finder-nearby_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
{
  private static long EMA;
  private static int EMB;
  public static final a EMv;
  private static long EMw;
  private static long EMx;
  private static int EMy;
  private static final List<cc> EMz;
  private static bqr akhA;
  
  static
  {
    AppMethodBeat.i(340295);
    EMv = new a();
    EMw = 1200000L;
    d locald = d.FAy;
    EMy = ((Number)d.eRD().bmg()).intValue();
    EMz = (List)new ArrayList();
    AppMethodBeat.o(340295);
  }
  
  public static void QP(int paramInt)
  {
    EMB = paramInt;
  }
  
  public static void a(bqr parambqr)
  {
    akhA = parambqr;
  }
  
  public static long eFF()
  {
    return EMw;
  }
  
  public static long eFG()
  {
    return EMx;
  }
  
  public static List<cc> eFH()
  {
    return EMz;
  }
  
  public static boolean eFI()
  {
    AppMethodBeat.i(340281);
    if (System.currentTimeMillis() > EMA + EMy)
    {
      AppMethodBeat.o(340281);
      return true;
    }
    AppMethodBeat.o(340281);
    return false;
  }
  
  public static int eFJ()
  {
    return EMB;
  }
  
  public static bqr kLp()
  {
    return akhA;
  }
  
  public static void pk(long paramLong)
  {
    EMw = paramLong;
  }
  
  public static void pl(long paramLong)
  {
    EMx = paramLong;
  }
  
  public static void pm(long paramLong)
  {
    EMA = paramLong;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.nearby.newlivesquare.a
 * JD-Core Version:    0.7.0.1
 */