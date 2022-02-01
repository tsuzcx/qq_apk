package com.tencent.mm.plugin.finder.feed;

import com.tencent.mm.plugin.finder.feed.model.internal.IResponse;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/feed/FinderAtTimelineUIContract$FinderAtTimelineResponse;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "totalCount", "", "errType", "", "errCode", "errMsg", "", "(JIILjava/lang/String;)V", "getTotalCount", "()J", "plugin-finder_release"})
public final class g$f
  extends IResponse<BaseFinderFeed>
{
  private final long qxB;
  
  public g$f(long paramLong, int paramInt1, int paramInt2, String paramString)
  {
    super(paramInt1, paramInt2, paramString);
    this.qxB = paramLong;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.g.f
 * JD-Core Version:    0.7.0.1
 */