package com.tencent.mm.plugin.finder.live.model;

import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.e.i.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.live.viewmodel.data.business.c;
import com.tencent.mm.protocal.protobuf.bac;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/model/FinderLiveGuard;", "", "()V", "HEART_BEAT_GUARD_INTERVAL", "", "KEEP_ALIVE_GUARD_ENABLE", "", "TAG", "", "heartbeatGuardFuture", "Lcom/tencent/threadpool/runnable/FutureEx;", "heartbeatGuardTask", "Ljava/lang/Runnable;", "keepAliveGuardFuture", "keepAliveGuardTask", "cancelHeartBeatGuard", "", "cancelKeepAliveGuard", "heartBeatGuard", "heartbeatGuardEnable", "keepAliveGuard", "delay", "keepAliveGuardEnable", "release", "setup", "plugin-finder_release"})
public final class o
{
  private static final String TAG = "FinderLiveGuard";
  private static Runnable yfA;
  private static boolean yfB;
  private static d<?> yfC;
  private static Runnable yfD;
  public static final o yfE;
  private static long yfy;
  private static d<?> yfz;
  
  static
  {
    AppMethodBeat.i(273939);
    yfE = new o();
    TAG = "FinderLiveGuard";
    yfy = 10000L;
    yfB = true;
    AppMethodBeat.o(273939);
  }
  
  public static void Lj(long paramLong)
  {
    AppMethodBeat.i(273937);
    Object localObject1 = com.tencent.mm.plugin.finder.live.model.context.a.ykr;
    localObject1 = com.tencent.mm.plugin.finder.live.model.context.a.dAc();
    if (localObject1 != null)
    {
      Object localObject2 = (c)((com.tencent.mm.plugin.finder.live.model.context.a)localObject1).business(c.class);
      if (localObject2 != null)
      {
        String str = TAG;
        StringBuilder localStringBuilder = new StringBuilder("keepAliveGuard it.isLiveStarted():").append(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)((c)localObject2).business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).isLiveStarted()).append(" heartbeatGuardEnable:").append(dyD()).append(" liveId:");
        localObject1 = ((c)localObject2).liveInfo;
        if (localObject1 != null) {}
        for (localObject1 = Long.valueOf(((bac)localObject1).liveId);; localObject1 = null)
        {
          Log.i(str, ((Long)localObject1).longValue() + " HEART_BEAT_GUARD_INTERVAL:" + yfy);
          if (!yfB) {
            break label235;
          }
          if (!((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)((c)localObject2).business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).isLiveStarted()) {
            break;
          }
          localObject1 = new ah.c(((c)localObject2).liveInfo.liveId);
          localObject2 = yfC;
          if (localObject2 != null) {
            ((d)localObject2).cancel(false);
          }
          yfC = h.ZvG.n((Runnable)localObject1, 60000L + paramLong);
          yfD = (Runnable)localObject1;
          AppMethodBeat.o(273937);
          return;
        }
        localObject1 = yfC;
        if (localObject1 != null)
        {
          ((d)localObject1).cancel(false);
          AppMethodBeat.o(273937);
          return;
        }
        label235:
        AppMethodBeat.o(273937);
        return;
      }
    }
    AppMethodBeat.o(273937);
  }
  
  private static boolean dyD()
  {
    return yfy > 0L;
  }
  
  public static void dyE()
  {
    d locald = null;
    AppMethodBeat.i(273935);
    Object localObject1 = com.tencent.mm.plugin.finder.live.model.context.a.ykr;
    localObject1 = com.tencent.mm.plugin.finder.live.model.context.a.dAc();
    if (localObject1 != null)
    {
      Object localObject2 = (c)((com.tencent.mm.plugin.finder.live.model.context.a)localObject1).business(c.class);
      if (localObject2 != null)
      {
        String str = TAG;
        StringBuilder localStringBuilder = new StringBuilder("heartBeatGuard it.isLiveStarted():").append(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)((c)localObject2).business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).isLiveStarted()).append(" heartbeatGuardEnable:").append(dyD()).append(" liveId:");
        localObject1 = ((c)localObject2).liveInfo;
        if (localObject1 != null) {}
        for (localObject1 = Long.valueOf(((bac)localObject1).liveId);; localObject1 = null)
        {
          Log.i(str, ((Long)localObject1).longValue() + " HEART_BEAT_GUARD_INTERVAL:" + yfy);
          if (!dyD()) {
            break label249;
          }
          if (!((com.tencent.mm.plugin.finder.live.viewmodel.data.business.b)((c)localObject2).business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.b.class)).isLiveStarted()) {
            break;
          }
          localObject2 = ((c)localObject2).liveInfo;
          localObject1 = locald;
          if (localObject2 != null) {
            localObject1 = Long.valueOf(((bac)localObject2).liveId);
          }
          localObject1 = new ah.b(((Long)localObject1).longValue());
          locald = yfz;
          if (locald != null) {
            locald.cancel(false);
          }
          yfz = h.ZvG.n((Runnable)localObject1, yfy);
          yfA = (Runnable)localObject1;
          AppMethodBeat.o(273935);
          return;
        }
        localObject1 = yfz;
        if (localObject1 != null)
        {
          ((d)localObject1).cancel(false);
          AppMethodBeat.o(273935);
          return;
        }
        label249:
        AppMethodBeat.o(273935);
        return;
      }
    }
    AppMethodBeat.o(273935);
  }
  
  public static void dyF()
  {
    AppMethodBeat.i(273936);
    d locald = yfz;
    if (locald != null)
    {
      locald.cancel(true);
      AppMethodBeat.o(273936);
      return;
    }
    AppMethodBeat.o(273936);
  }
  
  public static void dyG()
  {
    AppMethodBeat.i(273938);
    d locald = yfC;
    if (locald != null)
    {
      locald.cancel(true);
      AppMethodBeat.o(273938);
      return;
    }
    AppMethodBeat.o(273938);
  }
  
  public static void release()
  {
    yfz = null;
    yfC = null;
  }
  
  public static void setup()
  {
    AppMethodBeat.i(273933);
    com.tencent.c.a.a.a.a.a locala = com.tencent.c.a.a.a.a.a.Zlt;
    yfy = ((Number)com.tencent.c.a.a.a.a.a.iln().aSr()).longValue();
    locala = com.tencent.c.a.a.a.a.a.Zlt;
    if (((Number)com.tencent.c.a.a.a.a.a.ilo().aSr()).intValue() == 1) {}
    for (boolean bool = true;; bool = false)
    {
      yfB = bool;
      AppMethodBeat.o(273933);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.model.o
 * JD-Core Version:    0.7.0.1
 */