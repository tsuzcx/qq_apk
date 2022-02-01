package com.tencent.mm.plugin.finder.report;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.event.base.b;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.protocal.protobuf.bqs;
import d.g.b.k;
import d.l;
import java.util.LinkedList;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/report/PageChangeSubscriber$PageChangeEvent;", "Lcom/tencent/mm/plugin/finder/event/base/Event;", "feedId", "", "media", "Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;", "objectNonceId", "", "index", "", "mediaList", "Ljava/util/LinkedList;", "feed", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "(JLcom/tencent/mm/protocal/protobuf/LocalFinderMedia;Ljava/lang/String;ILjava/util/LinkedList;Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;)V", "getFeed", "()Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "getFeedId", "()J", "getIndex", "()I", "getMedia", "()Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;", "getMediaList", "()Ljava/util/LinkedList;", "getObjectNonceId", "()Ljava/lang/String;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "", "hashCode", "toString", "plugin-finder_release"})
public final class p$b
  extends b
{
  final long dig;
  final int index;
  private final LinkedList<bqs> mediaList;
  private final String objectNonceId;
  final bqs rcY;
  private final BaseFinderFeed rdD;
  
  public p$b(long paramLong, bqs parambqs, String paramString, int paramInt, LinkedList<bqs> paramLinkedList, BaseFinderFeed paramBaseFinderFeed)
  {
    AppMethodBeat.i(166709);
    this.dig = paramLong;
    this.rcY = parambqs;
    this.objectNonceId = paramString;
    this.index = paramInt;
    this.mediaList = paramLinkedList;
    this.rdD = paramBaseFinderFeed;
    AppMethodBeat.o(166709);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(166712);
    if (this != paramObject)
    {
      if ((paramObject instanceof b))
      {
        paramObject = (b)paramObject;
        if ((this.dig != paramObject.dig) || (!k.g(this.rcY, paramObject.rcY)) || (!k.g(this.objectNonceId, paramObject.objectNonceId)) || (this.index != paramObject.index) || (!k.g(this.mediaList, paramObject.mediaList)) || (!k.g(this.rdD, paramObject.rdD))) {}
      }
    }
    else
    {
      AppMethodBeat.o(166712);
      return true;
    }
    AppMethodBeat.o(166712);
    return false;
  }
  
  public final int hashCode()
  {
    int m = 0;
    AppMethodBeat.i(166711);
    long l = this.dig;
    int n = (int)(l ^ l >>> 32);
    Object localObject = this.rcY;
    int i;
    int j;
    label59:
    int i1;
    if (localObject != null)
    {
      i = localObject.hashCode();
      localObject = this.objectNonceId;
      if (localObject == null) {
        break label140;
      }
      j = localObject.hashCode();
      i1 = this.index;
      localObject = this.mediaList;
      if (localObject == null) {
        break label145;
      }
    }
    label140:
    label145:
    for (int k = localObject.hashCode();; k = 0)
    {
      localObject = this.rdD;
      if (localObject != null) {
        m = localObject.hashCode();
      }
      AppMethodBeat.o(166711);
      return (k + ((j + (i + n * 31) * 31) * 31 + i1) * 31) * 31 + m;
      i = 0;
      break;
      j = 0;
      break label59;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(166710);
    String str = "PageChangeEvent(feedId=" + this.dig + ", media=" + this.rcY + ", objectNonceId=" + this.objectNonceId + ", index=" + this.index + ", mediaList=" + this.mediaList + ", feed=" + this.rdD + ")";
    AppMethodBeat.o(166710);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.report.p.b
 * JD-Core Version:    0.7.0.1
 */