package com.tencent.mm.plugin.finder.feed.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.utils.av;
import com.tencent.mm.protocal.protobuf.to;
import com.tencent.mm.view.recyclerview.a;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/model/FinderWordingItem;", "Lcom/tencent/mm/protocal/protobuf/Buzzword;", "Lcom/tencent/mm/view/recyclerview/ConvertData;", "feed", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "item", "selfFlag", "", "(Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;Lcom/tencent/mm/protocal/protobuf/Buzzword;Z)V", "feedId", "", "id", "wording", "", "likeCount", "isLike", "isSelf", "(JJLjava/lang/String;JZZ)V", "()V", "getFeedId", "()J", "setFeedId", "(J)V", "()Z", "setSelf", "(Z)V", "getItemId", "getItemType", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class n
  extends to
  implements a
{
  public long feedId;
  public boolean hHq;
  
  public n() {}
  
  public n(BaseFinderFeed paramBaseFinderFeed, to paramto, boolean paramBoolean)
  {
    this();
    AppMethodBeat.i(366371);
    this.feedId = paramBaseFinderFeed.bZA();
    if (paramBoolean)
    {
      av localav = av.GiL;
      if (!av.e(paramBaseFinderFeed)) {}
    }
    for (paramBoolean = true;; paramBoolean = false)
    {
      this.hHq = paramBoolean;
      this.YZe = paramto.YZe;
      this.wording = paramto.wording;
      this.YZf = paramto.YZf;
      this.hJr = paramto.hJr;
      AppMethodBeat.o(366371);
      return;
    }
  }
  
  public final long bZA()
  {
    return 0L;
  }
  
  public final int bZB()
  {
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.model.n
 * JD-Core Version:    0.7.0.1
 */