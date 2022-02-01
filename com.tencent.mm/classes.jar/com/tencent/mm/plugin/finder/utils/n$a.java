package com.tencent.mm.plugin.finder.utils;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.view.recyclerview.e;
import d.g.b.k;
import d.l;
import java.util.LinkedList;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/utils/FinderUtil$CenterFeed;", "", "feedId", "", "mediaId", "", "feed", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "feedPosition", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "(JLjava/lang/String;Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;ILcom/tencent/mm/view/recyclerview/SimpleViewHolder;)V", "currentFeedList", "Ljava/util/LinkedList;", "getCurrentFeedList", "()Ljava/util/LinkedList;", "setCurrentFeedList", "(Ljava/util/LinkedList;)V", "getFeed", "()Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "getFeedId", "()J", "getFeedPosition", "()I", "getHolder", "()Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "getMediaId", "()Ljava/lang/String;", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "toString", "plugin-finder_release"})
public final class n$a
{
  public final long dig;
  public final String mediaId;
  public final int rPO;
  public final e raq;
  public final BaseFinderFeed rdD;
  public LinkedList<a> uGK;
  
  public n$a(long paramLong, String paramString, BaseFinderFeed paramBaseFinderFeed, int paramInt, e parame)
  {
    AppMethodBeat.i(210194);
    this.dig = paramLong;
    this.mediaId = paramString;
    this.rdD = paramBaseFinderFeed;
    this.rPO = paramInt;
    this.raq = parame;
    this.uGK = new LinkedList();
    AppMethodBeat.o(210194);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(203637);
    if (this != paramObject)
    {
      if ((paramObject instanceof a))
      {
        paramObject = (a)paramObject;
        if ((this.dig != paramObject.dig) || (!k.g(this.mediaId, paramObject.mediaId)) || (!k.g(this.rdD, paramObject.rdD)) || (this.rPO != paramObject.rPO) || (!k.g(this.raq, paramObject.raq))) {}
      }
    }
    else
    {
      AppMethodBeat.o(203637);
      return true;
    }
    AppMethodBeat.o(203637);
    return false;
  }
  
  public final int hashCode()
  {
    int k = 0;
    AppMethodBeat.i(203636);
    long l = this.dig;
    int m = (int)(l ^ l >>> 32);
    Object localObject = this.mediaId;
    int i;
    if (localObject != null)
    {
      i = localObject.hashCode();
      localObject = this.rdD;
      if (localObject == null) {
        break label115;
      }
    }
    label115:
    for (int j = localObject.hashCode();; j = 0)
    {
      int n = this.rPO;
      localObject = this.raq;
      if (localObject != null) {
        k = localObject.hashCode();
      }
      AppMethodBeat.o(203636);
      return ((j + (i + m * 31) * 31) * 31 + n) * 31 + k;
      i = 0;
      break;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(203635);
    String str = "CenterFeed(feedId=" + this.dig + ", mediaId=" + this.mediaId + ", feed=" + this.rdD + ", feedPosition=" + this.rPO + ", holder=" + this.raq + ")";
    AppMethodBeat.o(203635);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.utils.n.a
 * JD-Core Version:    0.7.0.1
 */