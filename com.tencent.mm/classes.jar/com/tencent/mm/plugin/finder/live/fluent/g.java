package com.tencent.mm.plugin.finder.live.fluent;

import android.content.Context;
import android.graphics.SurfaceTexture;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/fluent/FinderFluentSwitchManager;", "", "()V", "TAG", "", "fluentExitLiveRoomPlayerList", "Ljava/util/HashMap;", "", "Lcom/tencent/mm/plugin/finder/live/fluent/FinderFluentSwitchLiveParams;", "Lkotlin/collections/HashMap;", "fluentSwitchDirectorList", "Lcom/tencent/mm/plugin/finder/live/fluent/IFinderFluentSwitchDirector;", "isLiveRoomOnDestory", "", "()Z", "setLiveRoomOnDestory", "(Z)V", "isLiveRoomTriggerFinish", "setLiveRoomTriggerFinish", "isUseByWindowDirector", "setUseByWindowDirector", "checkAutoPlay", "Lcom/tencent/mm/plugin/finder/live/fluent/FinderFluentSwitchLiveAutoPlayParams;", "feedId", "checkIsExitLiveRoomNeedReusePlayer", "clearFluentList", "", "getFinderFluentSwitchDirector", "ifDelayCheckAutoPlay", "isFluentEnable", "recordFluentSwitchInRoomPlayer", "director", "release", "startSwitchInLiveRoom", "startSwitchOutFromSquare", "context", "Landroid/content/Context;", "params", "Lcom/tencent/mm/plugin/finder/live/fluent/FinderFluentSwitchParams;", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class g
{
  public static final g CCu;
  private static boolean CCv;
  private static boolean CCw;
  private static boolean CCx;
  private static final HashMap<Long, k> CCy;
  private static final HashMap<Long, f> CCz;
  
  static
  {
    AppMethodBeat.i(352213);
    CCu = new g();
    CCw = true;
    CCy = new HashMap();
    CCz = new HashMap();
    AppMethodBeat.o(352213);
  }
  
  public static k a(Context paramContext, h paramh)
  {
    AppMethodBeat.i(352131);
    s.u(paramContext, "context");
    s.u(paramh, "params");
    long l = paramh.feedId;
    if ((paramh instanceof c))
    {
      paramContext = paramContext.getApplicationContext();
      s.s(paramContext, "context.applicationContext");
    }
    for (paramContext = (k)new b(paramContext);; paramContext = (k)new e(paramContext))
    {
      paramContext.a(paramh);
      Log.i("FinderFluentSwitchManager", "startSwitchOutFromSquare feedId: " + l + " director: " + paramContext + ' ');
      eju();
      ((Map)CCy).put(Long.valueOf(l), paramContext);
      AppMethodBeat.o(352131);
      return paramContext;
      paramContext = paramContext.getApplicationContext();
      s.s(paramContext, "context.applicationContext");
    }
  }
  
  public static boolean ejr()
  {
    return CCv;
  }
  
  public static boolean ejs()
  {
    AppMethodBeat.i(352118);
    Log.i("FinderFluentSwitchManager", "isFluentEnable isUseByWindowDirector: " + CCx + " isLiveRoomOnDestory: " + CCw);
    if ((!CCx) || (CCw))
    {
      AppMethodBeat.o(352118);
      return true;
    }
    AppMethodBeat.o(352118);
    return false;
  }
  
  public static boolean ejt()
  {
    AppMethodBeat.i(352168);
    if ((CCz == null) || (CCz.size() <= 0)) {}
    for (boolean bool = true;; bool = false)
    {
      Log.i("FinderFluentSwitchManager", "ifDelayCheckAutoPlay:" + bool + " size:" + CCz.size());
      AppMethodBeat.o(352168);
      return bool;
    }
  }
  
  public static void eju()
  {
    AppMethodBeat.i(352195);
    Log.i("FinderFluentSwitchManager", "clearFluentList exitParamsSize: " + CCz.size() + " directorSize: " + CCy.size());
    CCy.clear();
    CCz.clear();
    AppMethodBeat.o(352195);
  }
  
  public static k nV(long paramLong)
  {
    AppMethodBeat.i(352143);
    k localk = (k)CCy.get(Long.valueOf(paramLong));
    Log.i("FinderFluentSwitchManager", "recordFluentSwitchInRoomPlayer feedId:" + paramLong + " director:" + localk);
    if (((localk instanceof e)) && (((e)localk).ejq() != null)) {
      ((Map)CCz).put(Long.valueOf(paramLong), ((e)localk).ejq());
    }
    Log.i("FinderFluentSwitchManager", "getSwitchInLiveRoomDirector feedId:" + paramLong + " director:" + localk);
    if ((localk != null) && (localk.aFA() == true)) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(352143);
      return null;
    }
    AppMethodBeat.o(352143);
    return localk;
  }
  
  public static k nW(long paramLong)
  {
    AppMethodBeat.i(352151);
    k localk = (k)CCy.get(Long.valueOf(paramLong));
    AppMethodBeat.o(352151);
    return localk;
  }
  
  public static boolean nX(long paramLong)
  {
    AppMethodBeat.i(352161);
    f localf = (f)CCz.get(Long.valueOf(paramLong));
    Object localObject = a.CCh;
    boolean bool;
    label79:
    StringBuilder localStringBuilder;
    if (a.ejm()) {
      if (localf == null)
      {
        localObject = null;
        if (localObject == null) {
          break label167;
        }
        localObject = localf.CCB;
        s.checkNotNull(localObject);
        if ((!((com.tencent.mm.live.core.core.c.b)localObject).isPlaying()) || (localf.CCA == h.a.CCF) || (!CCv)) {
          break label167;
        }
        bool = true;
        if (!bool) {
          CCz.remove(Long.valueOf(paramLong));
        }
        localStringBuilder = new StringBuilder("startExitLiveRoom feedId:").append(paramLong).append(" canReusePlayer: ").append(bool).append(" fluentScene = ");
        if (localf != null) {
          break label172;
        }
      }
    }
    label167:
    label172:
    for (localObject = null;; localObject = localf.CCA)
    {
      Log.i("FinderFluentSwitchManager", localObject);
      if (bool) {
        break label181;
      }
      AppMethodBeat.o(352161);
      return true;
      localObject = localf.CCB;
      break;
      bool = false;
      break label79;
    }
    label181:
    AppMethodBeat.o(352161);
    return false;
  }
  
  public static d nY(long paramLong)
  {
    AppMethodBeat.i(352175);
    f localf = (f)CCz.get(Long.valueOf(paramLong));
    Object localObject = a.CCh;
    boolean bool;
    label77:
    d locald;
    StringBuilder localStringBuilder;
    if (a.ejm()) {
      if (localf == null)
      {
        localObject = null;
        if (localObject == null) {
          break label183;
        }
        localObject = localf.CCB;
        s.checkNotNull(localObject);
        if ((!((com.tencent.mm.live.core.core.c.b)localObject).isPlaying()) || (localf.CCr) || (!CCv)) {
          break label183;
        }
        bool = true;
        locald = new d(paramLong, bool, localf);
        localStringBuilder = new StringBuilder(" checkAutoPlay feedId: ").append(paramLong).append("  canReusePlayer:").append(bool).append("  isFloatWindow: ");
        if (localf != null) {
          break label188;
        }
      }
    }
    label183:
    label188:
    for (localObject = null;; localObject = Boolean.valueOf(localf.CCr))
    {
      Log.i("FinderFluentSwitchManager", localObject + "  feedId= " + paramLong + " map = " + CCz);
      AppMethodBeat.o(352175);
      return locald;
      localObject = localf.CCB;
      break;
      bool = false;
      break label77;
    }
  }
  
  public static void nZ(long paramLong)
  {
    AppMethodBeat.i(352204);
    Log.i("FinderFluentSwitchManager", "clearFluentList feedId: " + paramLong + " exitParamsSize: " + CCz + " directorSize: " + CCy);
    CCy.remove(Long.valueOf(paramLong));
    CCz.remove(Long.valueOf(paramLong));
    AppMethodBeat.o(352204);
  }
  
  public static void qv(boolean paramBoolean)
  {
    CCv = paramBoolean;
  }
  
  public static void qw(boolean paramBoolean)
  {
    CCw = paramBoolean;
  }
  
  public static void qx(boolean paramBoolean)
  {
    CCx = paramBoolean;
  }
  
  public static void release()
  {
    AppMethodBeat.i(352188);
    Log.i("FinderFluentSwitchManager", "release size:" + CCy.size() + ' ' + CCy);
    Iterator localIterator = ((Map)CCy).entrySet().iterator();
    Object localObject1;
    Object localObject2;
    while (localIterator.hasNext())
    {
      localObject1 = (Map.Entry)localIterator.next();
      ((Number)((Map.Entry)localObject1).getKey()).longValue();
      localObject1 = (k)((Map.Entry)localObject1).getValue();
      if ((localObject1 instanceof e))
      {
        localObject2 = ((e)localObject1).ejq();
        if (localObject2 == null) {}
        for (boolean bool = false;; bool = ((f)localObject2).CCr)
        {
          Log.i("FinderFluentSwitchManager", "square exit start releaseDirector: " + localObject1 + " isFloatWindow: " + bool + " isLiveRoomOnDestory: " + CCw);
          if (bool) {
            break;
          }
          localObject2 = a.CCh;
          if ((!a.ejm()) || (!CCw)) {
            break;
          }
          localObject2 = ((e)localObject1).ejq();
          if (localObject2 != null)
          {
            localObject2 = ((h)localObject2).CCB;
            if (localObject2 != null) {
              ((com.tencent.mm.live.core.core.c.b)localObject2).fD(true);
            }
          }
          localObject1 = ((e)localObject1).ejq();
          if (localObject1 == null) {
            break;
          }
          localObject1 = ((f)localObject1).surfaceTexture;
          if (localObject1 == null) {
            break;
          }
          ((SurfaceTexture)localObject1).release();
          break;
        }
      }
    }
    CCy.clear();
    localIterator = ((Map)CCz).entrySet().iterator();
    while (localIterator.hasNext())
    {
      localObject1 = (Map.Entry)localIterator.next();
      ((Number)((Map.Entry)localObject1).getKey()).longValue();
      localObject1 = (f)((Map.Entry)localObject1).getValue();
      Log.i("FinderFluentSwitchManager", "square exit start releaseParams: " + localObject1 + " isFloatWindow: " + localObject1 + ".isFloatWindow isLiveRoomOnDestory: " + CCw);
      if (!((f)localObject1).CCr)
      {
        localObject2 = a.CCh;
        if ((a.ejm()) && (CCw))
        {
          localObject2 = ((h)localObject1).CCB;
          if (localObject2 != null) {
            ((com.tencent.mm.live.core.core.c.b)localObject2).fD(true);
          }
          localObject1 = ((f)localObject1).surfaceTexture;
          if (localObject1 != null) {
            ((SurfaceTexture)localObject1).release();
          }
        }
      }
    }
    CCz.clear();
    AppMethodBeat.o(352188);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.fluent.g
 * JD-Core Version:    0.7.0.1
 */