package com.tencent.mm.plugin.finder.feed;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import com.tencent.mm.plugin.finder.feed.model.internal.j;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/feed/FinderAtTimelineUIContract$FinderAtTimelineRequest;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IRequest;", "finderUsername", "", "lastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "pullType", "", "(Ljava/lang/String;Lcom/tencent/mm/protobuf/ByteString;I)V", "getFinderUsername", "()Ljava/lang/String;", "getLastBuffer", "()Lcom/tencent/mm/protobuf/ByteString;", "getPullType", "()I", "plugin-finder_release"})
public final class g$e
  implements j
{
  final String finderUsername;
  final b lastBuffer;
  final int pullType;
  
  public g$e(String paramString, b paramb, int paramInt)
  {
    AppMethodBeat.i(197602);
    this.finderUsername = paramString;
    this.lastBuffer = paramb;
    this.pullType = paramInt;
    AppMethodBeat.o(197602);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.g.e
 * JD-Core Version:    0.7.0.1
 */