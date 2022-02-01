package com.tencent.mm.plugin.finder.service;

import com.tencent.e.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.ah;
import com.tencent.mm.plugin.finder.preload.worker.b;
import com.tencent.mm.plugin.finder.storage.FeedData;
import com.tencent.mm.plugin.finder.storage.FeedData.a;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.FinderItem.a;
import com.tencent.mm.plugin.findersdk.a.bk;
import com.tencent.mm.plugin.findersdk.a.bk.a;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.dji;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.List<+Lcom.tencent.mm.protocal.protobuf.FinderObject;>;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.g.a.a;
import kotlin.g.b.s;
import kotlin.j;
import kotlin.k;
import kotlin.r;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/service/FinderFeedDetailService$FinderPreloadVideoService;", "Lcom/tencent/mm/plugin/findersdk/api/IFinderPreloadVideoService;", "()V", "cache", "Ljava/util/concurrent/ConcurrentHashMap;", "", "", "getCache", "()Ljava/util/concurrent/ConcurrentHashMap;", "callback", "Lcom/tencent/mm/plugin/findersdk/api/IFinderPreloadVideoService$PreloadVideoCallback;", "preloadVideoWorker", "com/tencent/mm/plugin/finder/service/FinderFeedDetailService$FinderPreloadVideoService$preloadVideoWorker$2$1", "getPreloadVideoWorker", "()Lcom/tencent/mm/plugin/finder/service/FinderFeedDetailService$FinderPreloadVideoService$preloadVideoWorker$2$1;", "preloadVideoWorker$delegate", "Lkotlin/Lazy;", "cancelAll", "", "cancelFeed", "feedId", "preloadVideo", "commentScene", "", "feeds", "", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "setPreloadVideoCallback", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class e$b
  implements bk
{
  private final j AMt;
  private final ConcurrentHashMap<Long, String> BvD;
  bk.a FyY;
  
  public e$b()
  {
    AppMethodBeat.i(330059);
    this.AMt = k.cm((a)new e.b.a(this));
    this.BvD = new ConcurrentHashMap();
    AppMethodBeat.o(330059);
  }
  
  private final e.b.a.1 ePw()
  {
    AppMethodBeat.i(330066);
    e.b.a.1 local1 = (e.b.a.1)this.AMt.getValue();
    AppMethodBeat.o(330066);
    return local1;
  }
  
  public final void a(bk.a parama)
  {
    AppMethodBeat.i(330073);
    s.u(parama, "callback");
    this.FyY = parama;
    AppMethodBeat.o(330073);
  }
  
  public final void hv(List<? extends FinderObject> paramList)
  {
    AppMethodBeat.i(330083);
    s.u(paramList, "feeds");
    paramList = (Iterable)paramList;
    Object localObject2 = (Collection)new ArrayList(p.a(paramList, 10));
    Object localObject3 = paramList.iterator();
    if (((Iterator)localObject3).hasNext())
    {
      paramList = (FinderObject)((Iterator)localObject3).next();
      localObject1 = FinderItem.Companion;
      paramList = FinderItem.a.e(paramList, 0);
      paramList.setReplaceLongVideoToNormal(true);
      ah localah = new ah(paramList);
      Map localMap = (Map)this.BvD;
      long l = localah.bZA();
      paramList = (dji)p.oL((List)paramList.getMediaList());
      if (paramList == null) {
        paramList = "";
      }
      for (;;)
      {
        localMap.put(Long.valueOf(l), paramList);
        ((Collection)localObject2).add(new r(localah, localah.feedObject.getMediaList()));
        break;
        localObject1 = paramList.mediaId;
        paramList = (List<? extends FinderObject>)localObject1;
        if (localObject1 == null) {
          paramList = "";
        }
      }
    }
    paramList = (List)localObject2;
    Object localObject1 = (r)p.oL(paramList);
    if (localObject1 != null)
    {
      localObject2 = ePw();
      localObject3 = FeedData.Companion;
      ((e.b.a.1)localObject2).a(42, FeedData.a.l((BaseFinderFeed)((r)localObject1).bsC), p.J((Collection)paramList), 0);
    }
    AppMethodBeat.o(330083);
  }
  
  public final void pS(long paramLong)
  {
    AppMethodBeat.i(330091);
    s.X("[cancelFeed]... ", d.hF(paramLong));
    h.jXD();
    String str = (String)this.BvD.get(Long.valueOf(paramLong));
    if (str == null)
    {
      AppMethodBeat.o(330091);
      return;
    }
    e.b.a.1 local1 = ePw();
    s.u(str, "mediaId");
    local1.bK(str, true);
    local1.eHV();
    AppMethodBeat.o(330091);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.service.e.b
 * JD-Core Version:    0.7.0.1
 */