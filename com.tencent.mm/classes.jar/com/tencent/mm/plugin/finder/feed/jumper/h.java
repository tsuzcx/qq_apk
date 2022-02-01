package com.tencent.mm.plugin.finder.feed.jumper;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.FinderJumpInfo;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/jumper/FinderFeedAllJumpInfo;", "", "commentScene", "", "feedId", "", "style", "list", "", "Lcom/tencent/mm/protocal/protobuf/FinderJumpInfo;", "(IJILjava/util/List;)V", "getCommentScene", "()I", "getFeedId", "()J", "getList", "()Ljava/util/List;", "getStyle", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class h
{
  private final int AJo;
  public final long feedId;
  public final List<FinderJumpInfo> list;
  public final int style;
  
  public h(int paramInt1, long paramLong, int paramInt2, List<? extends FinderJumpInfo> paramList)
  {
    AppMethodBeat.i(364188);
    this.AJo = paramInt1;
    this.feedId = paramLong;
    this.style = paramInt2;
    this.list = paramList;
    AppMethodBeat.o(364188);
  }
  
  public final boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if ((paramObject instanceof h))
    {
      bool1 = bool2;
      if (((h)paramObject).style == this.style) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public final int hashCode()
  {
    return this.style;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(364212);
    String str = "FinderFeedAllJumpInfo(commentScene=" + this.AJo + ", feedId=" + this.feedId + ", style=" + this.style + ", list=" + this.list + ')';
    AppMethodBeat.o(364212);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.jumper.h
 * JD-Core Version:    0.7.0.1
 */