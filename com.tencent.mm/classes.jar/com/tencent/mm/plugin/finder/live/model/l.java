package com.tencent.mm.plugin.finder.live.model;

import com.tencent.c.a.a.a.a.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.w;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.findersdk.d.a.a.b;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.bac;
import com.tencent.mm.protocal.protobuf.bid;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.g.b.p;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/model/FinderLiveFeedFlowReporter;", "", "()V", "TAG", "", "cacheMap", "Ljava/util/concurrent/ConcurrentHashMap;", "", "", "currentTask", "Ljava/lang/Runnable;", "timer", "Lcom/tencent/mm/sdk/platformtools/MTimerHandler;", "validWatchTime", "", "checkAlreadyInCache", "", "feed", "Lcom/tencent/mm/plugin/finder/model/FinderFeedLive;", "needCalculateWatchNumberOnFeedFlow", "tabType", "commentScene", "reportJoinLiveOnFeedFlow", "", "finderObject", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "startPlayLiveOnFeedFlow", "stopPlayLiveOnFeedFlow", "plugin-finder_release"})
public final class l
{
  private static final MTimerHandler timer;
  private static final ConcurrentHashMap<String, Set<Long>> xHs;
  private static Runnable yfn;
  private static final int yfo;
  public static final l yfp;
  
  static
  {
    AppMethodBeat.i(286268);
    yfp = new l();
    xHs = new ConcurrentHashMap();
    a locala = a.Zlt;
    yfo = ((Number)a.inj().aSr()).intValue();
    timer = new MTimerHandler("FinderLiveFeedFlowReporter::Timer", (MTimerHandler.CallBack)new l.c(), false);
    AppMethodBeat.o(286268);
  }
  
  public static void a(FinderObject paramFinderObject, final bid parambid)
  {
    AppMethodBeat.i(286265);
    p.k(paramFinderObject, "finderObject");
    Log.i("Finder.FinderLiveFeedFlowReporter", "startPlayLiveOnFeedFlow");
    yfn = (Runnable)new b(paramFinderObject, parambid);
    timer.startTimer(yfo * 1000L, 0L);
    AppMethodBeat.o(286265);
  }
  
  public static boolean a(int paramInt1, int paramInt2, w paramw)
  {
    AppMethodBeat.i(286264);
    p.k(paramw, "feed");
    Set localSet = (Set)xHs.get(z.bdh());
    boolean bool;
    if (localSet == null) {
      bool = false;
    }
    while (bool)
    {
      AppMethodBeat.o(286264);
      return false;
      p.j(localSet, "cacheMap[ConfigStorageLo…ername()] ?: return false");
      paramw = paramw.feedObject.getFeedObject().liveInfo;
      if (paramw != null) {
        bool = localSet.contains(Long.valueOf(paramw.liveId));
      } else {
        bool = false;
      }
    }
    if ((paramInt1 == 1) || (paramInt1 == 3) || (paramInt1 == 4) || (paramInt2 == 1))
    {
      AppMethodBeat.o(286264);
      return true;
    }
    AppMethodBeat.o(286264);
    return false;
  }
  
  public static void dyr()
  {
    AppMethodBeat.i(286267);
    Log.i("Finder.FinderLiveFeedFlowReporter", "stopPlayLiveOnFeedFlow");
    yfn = null;
    timer.stopTimer();
    AppMethodBeat.o(286267);
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(FinderObject paramFinderObject, bid parambid) {}
    
    public final void run()
    {
      AppMethodBeat.i(271824);
      l locall = l.yfp;
      l.b(this.xXG, parambid);
      AppMethodBeat.o(271824);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.model.l
 * JD-Core Version:    0.7.0.1
 */