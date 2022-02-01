package com.tencent.mm.plugin.finder.convert;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.plugin.finder.cgi.bh;
import com.tencent.mm.plugin.finder.feed.model.FinderFeedRelTimelineLoader;
import com.tencent.mm.plugin.finder.feed.model.FinderFeedRelTimelineLoader.c;
import com.tencent.mm.plugin.finder.feed.model.internal.g;
import com.tencent.mm.plugin.finder.model.bo;
import com.tencent.mm.protocal.protobuf.ato;
import com.tencent.mm.protocal.protobuf.bbn;
import com.tencent.mm.protocal.protobuf.ecq;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/convert/FinderStreamCardAlbumConvert$fetchContent$loader$1", "Lcom/tencent/mm/plugin/finder/feed/model/FinderFeedRelTimelineLoader;", "createDataFetch", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataFetch;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "isObservePostEvent", "", "plugin-finder_release"})
public final class FinderStreamCardAlbumConvert$fetchContent$loader$1
  extends FinderFeedRelTimelineLoader
{
  FinderStreamCardAlbumConvert$fetchContent$loader$1(ecq paramecq, int paramInt)
  {
    super(0L, null, 0, null, 10, false, null, null, null, 0, localbbn, 4079);
  }
  
  public final g<bo> createDataFetch()
  {
    AppMethodBeat.i(243289);
    g localg = (g)new a(this);
    AppMethodBeat.o(243289);
    return localg;
  }
  
  public final boolean isObservePostEvent()
  {
    return false;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/convert/FinderStreamCardAlbumConvert$fetchContent$loader$1$createDataFetch$1", "Lcom/tencent/mm/plugin/finder/feed/model/FinderFeedRelTimelineLoader$FinderStreamCardDataFetcher;", "Lcom/tencent/mm/plugin/finder/feed/model/FinderFeedRelTimelineLoader;", "genRefreshNetScene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "plugin-finder_release"})
  public static final class a
    extends FinderFeedRelTimelineLoader.c
  {
    a()
    {
      super();
    }
    
    public final q genRefreshNetScene()
    {
      AppMethodBeat.i(243288);
      ecq localecq = this.tGC.tGy;
      bbn localbbn = this.tGC.getContextObj();
      ato localato = this.tGC.tta;
      Object localObject = localato;
      if (localato == null) {
        localObject = new ato();
      }
      localObject = new bh(localecq, localbbn, (ato)localObject);
      ((bh)localObject).pullType = 0;
      localObject = (q)localObject;
      AppMethodBeat.o(243288);
      return localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.convert.FinderStreamCardAlbumConvert.fetchContent.loader.1
 * JD-Core Version:    0.7.0.1
 */