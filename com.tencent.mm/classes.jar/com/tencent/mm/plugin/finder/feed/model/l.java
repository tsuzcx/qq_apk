package com.tencent.mm.plugin.finder.feed.model;

import com.tencent.mm.bx.b;
import com.tencent.mm.plugin.finder.feed.model.internal.j;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/feed/model/LikedTimeLineRequest;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IRequest;", "maxid", "", "lastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "pullType", "", "(JLcom/tencent/mm/protobuf/ByteString;I)V", "getLastBuffer", "()Lcom/tencent/mm/protobuf/ByteString;", "getMaxid", "()J", "getPullType", "()I", "plugin-finder_release"})
public final class l
  implements j
{
  final b lastBuffer;
  final int pullType;
  final long qyO;
  
  public l(long paramLong, b paramb, int paramInt)
  {
    this.qyO = paramLong;
    this.lastBuffer = paramb;
    this.pullType = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.model.l
 * JD-Core Version:    0.7.0.1
 */