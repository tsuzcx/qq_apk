package com.tencent.mm.plugin.finder.feed.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.c;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.protocal.protobuf.ald;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/feed/model/TimelineInsertRequest;", "Lcom/tencent/mm/plugin/finder/feed/model/TimelineRequest;", "pullType", "", "(I)V", "centerFeed", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "getCenterFeed", "()Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "setCenterFeed", "(Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;)V", "feed", "getFeed", "setFeed", "isPrefetch", "", "()Z", "setPrefetch", "(Z)V", "maxUnreadCount", "getMaxUnreadCount", "()I", "setMaxUnreadCount", "relatedEntranceInfo", "Lcom/tencent/mm/protocal/protobuf/FinderGetRelatedEntranceInfo;", "getRelatedEntranceInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderGetRelatedEntranceInfo;", "setRelatedEntranceInfo", "(Lcom/tencent/mm/protocal/protobuf/FinderGetRelatedEntranceInfo;)V", "toString", "", "plugin-finder_release"})
public final class y
  extends z
{
  public ald qXD;
  public BaseFinderFeed rdD;
  public BaseFinderFeed rde;
  public int rnB = -1;
  public boolean rnC;
  
  public y()
  {
    super(-1);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(202238);
    Object localObject1 = new StringBuilder("feed=");
    Object localObject2 = this.rdD;
    if (localObject2 != null)
    {
      localObject2 = ((BaseFinderFeed)localObject2).feedObject;
      if (localObject2 == null) {}
    }
    for (long l = ((FinderItem)localObject2).getId();; l = 0L)
    {
      localObject1 = c.pb(l) + ", keepUnreadSize=" + this.rnB;
      AppMethodBeat.o(202238);
      return localObject1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.model.y
 * JD-Core Version:    0.7.0.1
 */