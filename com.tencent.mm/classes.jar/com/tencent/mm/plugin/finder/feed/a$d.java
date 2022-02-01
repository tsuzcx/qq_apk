package com.tencent.mm.plugin.finder.feed;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import com.tencent.mm.plugin.finder.feed.model.internal.i;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/feed/FinderAtTimelineUIContract$FinderAtTimelineRequest;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IRequest;", "finderUsername", "", "lastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "pullType", "", "(Ljava/lang/String;Lcom/tencent/mm/protobuf/ByteString;I)V", "getFinderUsername", "()Ljava/lang/String;", "getLastBuffer", "()Lcom/tencent/mm/protobuf/ByteString;", "getPullType", "()I", "plugin-finder_release"})
public final class a$d
  implements i
{
  final b lastBuffer;
  final int pullType;
  final String rfC;
  
  public a$d(String paramString, b paramb, int paramInt)
  {
    AppMethodBeat.i(201499);
    this.rfC = paramString;
    this.lastBuffer = paramb;
    this.pullType = paramInt;
    AppMethodBeat.o(201499);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.a.d
 * JD-Core Version:    0.7.0.1
 */