package com.tencent.mm.plugin.finder.convert;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.plugin.finder.cgi.ch;
import com.tencent.mm.plugin.finder.feed.model.FinderFeedRelTimelineLoader;
import com.tencent.mm.plugin.finder.feed.model.FinderFeedRelTimelineLoader.c;
import com.tencent.mm.plugin.finder.feed.model.internal.i;
import com.tencent.mm.plugin.finder.model.cc;
import com.tencent.mm.protocal.protobuf.bav;
import com.tencent.mm.protocal.protobuf.bui;
import com.tencent.mm.protocal.protobuf.fhp;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/convert/FinderStreamCardAlbumConvert$preloadContent$1$loader$1", "Lcom/tencent/mm/plugin/finder/feed/model/FinderFeedRelTimelineLoader;", "createDataFetch", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataFetch;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "isObservePostEvent", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class FinderStreamCardAlbumConvert$preloadContent$1$loader$1
  extends FinderFeedRelTimelineLoader
{
  FinderStreamCardAlbumConvert$preloadContent$1$loader$1(fhp paramfhp, bui parambui)
  {
    super(0L, null, 0, null, 10, false, null, null, null, 0, parambui, 0.0F, 0.0F, 28655);
  }
  
  public final i<cc> createDataFetch()
  {
    AppMethodBeat.i(350027);
    i locali = (i)new a(this.AMI, this);
    AppMethodBeat.o(350027);
    return locali;
  }
  
  public final boolean isObservePostEvent()
  {
    return false;
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/convert/FinderStreamCardAlbumConvert$preloadContent$1$loader$1$createDataFetch$1", "Lcom/tencent/mm/plugin/finder/feed/model/FinderFeedRelTimelineLoader$FinderStreamCardDataFetcher;", "Lcom/tencent/mm/plugin/finder/feed/model/FinderFeedRelTimelineLoader;", "genRefreshNetScene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    extends FinderFeedRelTimelineLoader.c
  {
    a(fhp paramfhp, FinderStreamCardAlbumConvert.preloadContent.1.loader.1 param1)
    {
      super();
      AppMethodBeat.i(349838);
      AppMethodBeat.o(349838);
    }
    
    public final p genRefreshNetScene()
    {
      AppMethodBeat.i(349846);
      fhp localfhp = this.AMI;
      bui localbui = jdField_this.getContextObj();
      bav localbav = jdField_this.BfW;
      Object localObject = localbav;
      if (localbav == null) {
        localObject = new bav();
      }
      localObject = new ch(localfhp, localbui, (bav)localObject);
      ((ch)localObject).pullType = 0;
      localObject = (p)localObject;
      AppMethodBeat.o(349846);
      return localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.convert.FinderStreamCardAlbumConvert.preloadContent.1.loader.1
 * JD-Core Version:    0.7.0.1
 */