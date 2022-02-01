package com.tencent.mm.plugin.finder.convert;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.q;
import com.tencent.mm.plugin.finder.cgi.bk;
import com.tencent.mm.plugin.finder.feed.model.FinderFeedRelTimelineLoader;
import com.tencent.mm.plugin.finder.feed.model.FinderFeedRelTimelineLoader.c;
import com.tencent.mm.plugin.finder.feed.model.internal.i;
import com.tencent.mm.plugin.finder.model.bu;
import com.tencent.mm.protocal.protobuf.avr;
import com.tencent.mm.protocal.protobuf.bid;
import com.tencent.mm.protocal.protobuf.emr;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/convert/FinderStreamCardAlbumConvert$fetchContent$loader$1", "Lcom/tencent/mm/plugin/finder/feed/model/FinderFeedRelTimelineLoader;", "createDataFetch", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataFetch;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "isObservePostEvent", "", "plugin-finder_release"})
public final class FinderStreamCardAlbumConvert$fetchContent$loader$1
  extends FinderFeedRelTimelineLoader
{
  FinderStreamCardAlbumConvert$fetchContent$loader$1(emr paramemr, bid parambid)
  {
    super(0L, null, 0, null, 10, false, null, null, null, 0, localbid, 0.0F, 0.0F, 28655);
  }
  
  public final i<bu> createDataFetch()
  {
    AppMethodBeat.i(290536);
    i locali = (i)new a(this);
    AppMethodBeat.o(290536);
    return locali;
  }
  
  public final boolean isObservePostEvent()
  {
    return false;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/convert/FinderStreamCardAlbumConvert$fetchContent$loader$1$createDataFetch$1", "Lcom/tencent/mm/plugin/finder/feed/model/FinderFeedRelTimelineLoader$FinderStreamCardDataFetcher;", "Lcom/tencent/mm/plugin/finder/feed/model/FinderFeedRelTimelineLoader;", "genRefreshNetScene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "plugin-finder_release"})
  public static final class a
    extends FinderFeedRelTimelineLoader.c
  {
    a()
    {
      super();
    }
    
    public final q genRefreshNetScene()
    {
      AppMethodBeat.i(282428);
      emr localemr = this.xpo.xpl;
      bid localbid = this.xpo.getContextObj();
      avr localavr = this.xpo.xGR;
      Object localObject = localavr;
      if (localavr == null) {
        localObject = new avr();
      }
      localObject = new bk(localemr, localbid, (avr)localObject);
      ((bk)localObject).pullType = 0;
      localObject = (q)localObject;
      AppMethodBeat.o(282428);
      return localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.convert.FinderStreamCardAlbumConvert.fetchContent.loader.1
 * JD-Core Version:    0.7.0.1
 */