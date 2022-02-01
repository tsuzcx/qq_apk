package com.tencent.mm.plugin.finder.feed.model;

import com.tencent.mm.bw.b;
import com.tencent.mm.plugin.finder.feed.model.internal.i;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/feed/model/LikedTimeLineRequest;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IRequest;", "maxid", "", "lastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "pullType", "", "(JLcom/tencent/mm/protobuf/ByteString;I)V", "getLastBuffer", "()Lcom/tencent/mm/protobuf/ByteString;", "getMaxid", "()J", "getPullType", "()I", "plugin-finder_release"})
public final class q
  implements i
{
  final b lastBuffer;
  final int pullType;
  final long rnv;
  
  public q(long paramLong, b paramb, int paramInt)
  {
    this.rnv = paramLong;
    this.lastBuffer = paramb;
    this.pullType = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.model.q
 * JD-Core Version:    0.7.0.1
 */