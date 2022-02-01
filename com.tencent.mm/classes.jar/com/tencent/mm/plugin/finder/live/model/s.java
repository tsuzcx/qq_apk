package com.tencent.mm.plugin.finder.live.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.live.viewmodel.data.business.e;
import com.tencent.mm.plugin.finder.live.viewmodel.data.business.f;
import com.tencent.mm.plugin.findersdk.storage.config.base.b;
import com.tencent.mm.protocal.protobuf.bip;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.threadpool.h;
import com.tencent.threadpool.i;
import com.tencent.threadpool.i.d;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/model/FinderLiveGuard;", "", "()V", "HEART_BEAT_GUARD_INTERVAL", "", "KEEP_ALIVE_GUARD_ENABLE", "", "TAG", "", "heartbeatGuardFuture", "Lcom/tencent/threadpool/runnable/FutureEx;", "heartbeatGuardTask", "Ljava/lang/Runnable;", "keepAliveGuardFuture", "keepAliveGuardTask", "cancelHeartBeatGuard", "", "cancelKeepAliveGuard", "heartBeatGuard", "heartbeatGuardEnable", "keepAliveGuard", "delay", "keepAliveGuardEnable", "release", "setup", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class s
{
  public static final s CGa;
  private static long CGb;
  private static d<?> CGc;
  private static Runnable CGd;
  private static boolean CGe;
  private static d<?> CGf;
  private static Runnable CGg;
  private static final String TAG;
  
  static
  {
    AppMethodBeat.i(359457);
    CGa = new s();
    TAG = "FinderLiveGuard";
    CGb = 10000L;
    CGe = true;
    AppMethodBeat.o(359457);
  }
  
  private static boolean ekR()
  {
    return CGb > 0L;
  }
  
  public static void ekS()
  {
    AppMethodBeat.i(359422);
    Object localObject1 = com.tencent.mm.plugin.finder.live.model.context.a.CMm;
    localObject1 = com.tencent.mm.plugin.finder.live.model.context.a.emY();
    if (localObject1 != null)
    {
      Object localObject2 = (f)((com.tencent.mm.plugin.finder.live.model.context.a)localObject1).business(f.class);
      if (localObject2 != null)
      {
        String str = TAG;
        StringBuilder localStringBuilder = new StringBuilder("heartBeatGuard it.isLiveStarted():").append(((e)((f)localObject2).business(e.class)).isLiveStarted()).append(" heartbeatGuardEnable:").append(ekR()).append(" liveId:");
        localObject1 = ((f)localObject2).liveInfo;
        if (localObject1 == null)
        {
          localObject1 = null;
          Log.i(str, localObject1 + " HEART_BEAT_GUARD_INTERVAL:" + CGb);
          if (!ekR()) {
            break label237;
          }
          if (!((e)((f)localObject2).business(e.class)).isLiveStarted()) {
            break label221;
          }
          localObject1 = ((f)localObject2).liveInfo;
          if (localObject1 != null) {
            break label213;
          }
        }
        label213:
        for (long l = 0L;; l = ((bip)localObject1).liveId)
        {
          localObject1 = new aj.c(l);
          localObject2 = CGc;
          if (localObject2 != null) {
            ((d)localObject2).cancel(false);
          }
          CGc = h.ahAA.o((Runnable)localObject1, CGb);
          CGd = (Runnable)localObject1;
          AppMethodBeat.o(359422);
          return;
          localObject1 = Long.valueOf(((bip)localObject1).liveId);
          break;
        }
        label221:
        localObject1 = CGc;
        if (localObject1 != null) {
          ((d)localObject1).cancel(false);
        }
      }
    }
    label237:
    AppMethodBeat.o(359422);
  }
  
  public static void ekT()
  {
    AppMethodBeat.i(359433);
    d locald = CGc;
    if (locald != null) {
      locald.cancel(true);
    }
    AppMethodBeat.o(359433);
  }
  
  public static void ekU()
  {
    AppMethodBeat.i(359450);
    d locald = CGf;
    if (locald != null) {
      locald.cancel(true);
    }
    AppMethodBeat.o(359450);
  }
  
  public static void ob(long paramLong)
  {
    AppMethodBeat.i(359441);
    Object localObject1 = com.tencent.mm.plugin.finder.live.model.context.a.CMm;
    localObject1 = com.tencent.mm.plugin.finder.live.model.context.a.emY();
    if (localObject1 != null)
    {
      Object localObject2 = (f)((com.tencent.mm.plugin.finder.live.model.context.a)localObject1).business(f.class);
      if (localObject2 != null)
      {
        String str = TAG;
        StringBuilder localStringBuilder = new StringBuilder("keepAliveGuard it.isLiveStarted():").append(((e)((f)localObject2).business(e.class)).isLiveStarted()).append(" heartbeatGuardEnable:").append(ekR()).append(" liveId:");
        localObject1 = ((f)localObject2).liveInfo;
        if (localObject1 == null) {}
        for (localObject1 = null;; localObject1 = Long.valueOf(((bip)localObject1).liveId))
        {
          Log.i(str, localObject1 + " HEART_BEAT_GUARD_INTERVAL:" + CGb);
          if (!CGe) {
            break label226;
          }
          if (!((e)((f)localObject2).business(e.class)).isLiveStarted()) {
            break;
          }
          localObject1 = new aj.d(((f)localObject2).liveInfo.liveId);
          localObject2 = CGf;
          if (localObject2 != null) {
            ((d)localObject2).cancel(false);
          }
          CGf = h.ahAA.o((Runnable)localObject1, 60000L + paramLong);
          CGg = (Runnable)localObject1;
          AppMethodBeat.o(359441);
          return;
        }
        localObject1 = CGf;
        if (localObject1 != null) {
          ((d)localObject1).cancel(false);
        }
      }
    }
    label226:
    AppMethodBeat.o(359441);
  }
  
  public static void release()
  {
    CGc = null;
    CGf = null;
  }
  
  public static void setup()
  {
    AppMethodBeat.i(359405);
    com.tencent.d.a.a.a.a.a locala = com.tencent.d.a.a.a.a.a.ahiX;
    CGb = ((Number)com.tencent.d.a.a.a.a.a.jRN().bmg()).longValue();
    locala = com.tencent.d.a.a.a.a.a.ahiX;
    if (((Number)com.tencent.d.a.a.a.a.a.jRO().bmg()).intValue() == 1) {}
    for (boolean bool = true;; bool = false)
    {
      CGe = bool;
      AppMethodBeat.o(359405);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.model.s
 * JD-Core Version:    0.7.0.1
 */