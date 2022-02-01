package com.tencent.mm.live.core.core.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.live.core.view.LiveVideoView;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/live/core/core/visitor/FinderLiveVisitorPlayCore;", "Lcom/tencent/mm/live/core/core/visitor/LiveVisitorTRTCCore;", "()V", "liveId", "", "cdnStartPlay", "", "streamType", "", "playerView", "Lcom/tencent/mm/live/core/view/LiveVideoView;", "playCallback", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "success", "cdnStopPlay", "keepLastFrame", "getCoreKey", "toString", "", "Companion", "finder-sdk_release"})
public final class a
  extends c
{
  private static ConcurrentHashMap<Long, a> kqj;
  public static final a kqk;
  public long liveId;
  
  static
  {
    AppMethodBeat.i(208930);
    kqk = new a((byte)0);
    kqj = new ConcurrentHashMap(2);
    AppMethodBeat.o(208930);
  }
  
  public final void a(int paramInt, LiveVideoView paramLiveVideoView, kotlin.g.a.b<? super Boolean, x> paramb)
  {
    AppMethodBeat.i(208926);
    p.k(paramLiveVideoView, "playerView");
    Log.i("FinderLiveVisitorPlayCore", "cdnStartPlay liveId:" + this.liveId + '(' + this + ")!");
    super.a(paramInt, paramLiveVideoView, paramb);
    AppMethodBeat.o(208926);
  }
  
  public final void fi(boolean paramBoolean)
  {
    AppMethodBeat.i(208927);
    Log.i("FinderLiveVisitorPlayCore", "cdnStopPlay liveId:" + this.liveId + '(' + this + ")!");
    super.fi(paramBoolean);
    AppMethodBeat.o(208927);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(208928);
    String str = super.toString() + ",Core liveId:" + this.liveId;
    AppMethodBeat.o(208928);
    return str;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/live/core/core/visitor/FinderLiveVisitorPlayCore$Companion;", "", "()V", "TAG", "", "instanceArray", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lcom/tencent/mm/live/core/core/visitor/FinderLiveVisitorPlayCore;", "checkPlayerLeak", "", "clear", "", "create", "liveId", "getCoreSize", "", "getInstance", "hasInstance", "releaseInstance", "releaseWithoutLiveId", "finder-sdk_release"})
  public static final class a
  {
    public static a FB(long paramLong)
    {
      AppMethodBeat.i(208109);
      Object localObject1 = com.tencent.mm.plugin.findersdk.f.b.Bxg;
      Object localObject2 = new StringBuilder(" create ").append(paramLong).append(' ');
      localObject1 = (a)a.aMe().get(Long.valueOf(paramLong));
      if (localObject1 != null) {}
      for (localObject1 = Integer.valueOf(((a)localObject1).hashCode());; localObject1 = null)
      {
        com.tencent.mm.plugin.findersdk.f.b.hA("FinderLiveVisitorPlayCore", localObject1);
        localObject1 = (ConcurrentMap)a.aMe();
        localObject2 = Long.valueOf(paramLong);
        if (((ConcurrentMap)localObject1).get(localObject2) == null)
        {
          a locala = new a();
          ((Map)a.aMe()).put(Long.valueOf(paramLong), locala);
          a.a(locala, paramLong);
          Log.i("FinderLiveVisitorPlayCore", "FinderLiveVisitorPlayCore create instance:" + locala.hashCode() + ", liveId:" + paramLong + ", core size:" + a.aMe().size());
          ((ConcurrentMap)localObject1).putIfAbsent(localObject2, locala);
        }
        localObject1 = (a)a.aMe().get(Long.valueOf(paramLong));
        AppMethodBeat.o(208109);
        return localObject1;
      }
    }
    
    public static a FC(long paramLong)
    {
      AppMethodBeat.i(208110);
      a locala = (a)a.aMe().get(Long.valueOf(paramLong));
      if (locala == null) {
        Log.i("FinderLiveVisitorPlayCore", "FinderLiveVisitorPlayCore get liveId:" + paramLong + " instance is empty, core size:" + a.aMe().size());
      }
      AppMethodBeat.o(208110);
      return locala;
    }
    
    public static void clear()
    {
      AppMethodBeat.i(208111);
      Log.i("FinderLiveVisitorPlayCore", "FinderLiveVisitorPlayCore clear, core size:" + a.aMe().size());
      Object localObject = com.tencent.mm.plugin.findersdk.f.b.Bxg;
      com.tencent.mm.plugin.findersdk.f.b.hA("FinderLiveVisitorPlayCore", "FinderLiveVisitorPlayCore clear, core size:" + a.aMe().size());
      localObject = ((Map)a.aMe()).entrySet().iterator();
      while (((Iterator)localObject).hasNext())
      {
        Map.Entry localEntry = (Map.Entry)((Iterator)localObject).next();
        ((a)localEntry.getValue()).fi(false);
        ((a)localEntry.getValue()).release();
      }
      a.aMe().clear();
      AppMethodBeat.o(208111);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.live.core.core.c.a
 * JD-Core Version:    0.7.0.1
 */