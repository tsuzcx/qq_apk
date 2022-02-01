package com.tencent.mm.plugin.finder.feed.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ad.c;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/feed/model/TimelineInsertRequest;", "Lcom/tencent/mm/plugin/finder/feed/model/TimelineRequest;", "pullType", "", "(I)V", "centerFeed", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "getCenterFeed", "()Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "setCenterFeed", "(Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;)V", "feed", "getFeed", "setFeed", "isPrefetch", "", "()Z", "setPrefetch", "(Z)V", "maxUnreadCount", "getMaxUnreadCount", "()I", "setMaxUnreadCount", "toString", "", "plugin-finder_release"})
public final class ab
  extends t
{
  public int KQu = -1;
  public boolean KQv;
  public BaseFinderFeed qHv;
  public BaseFinderFeed qsl;
  
  public ab()
  {
    super(-1);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(198326);
    Object localObject1 = new StringBuilder("feed=");
    Object localObject2 = this.qHv;
    if (localObject2 != null)
    {
      localObject2 = ((BaseFinderFeed)localObject2).feedObject;
      if (localObject2 == null) {}
    }
    for (long l = ((FinderItem)localObject2).getId();; l = 0L)
    {
      localObject1 = c.ly(l) + ", keepUnreadSize=" + this.KQu;
      AppMethodBeat.o(198326);
      return localObject1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.model.ab
 * JD-Core Version:    0.7.0.1
 */