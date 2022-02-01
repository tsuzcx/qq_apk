package com.tencent.mm.plugin.finder.feed;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import com.tencent.mm.plugin.finder.feed.model.internal.j;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/feed/FinderRetransmitSourceContract$RetransmitSourceRequest;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IRequest;", "username", "", "refObjectId", "", "refObjectNonceId", "lastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "pullType", "", "(Ljava/lang/String;JLjava/lang/String;Lcom/tencent/mm/protobuf/ByteString;I)V", "getLastBuffer", "()Lcom/tencent/mm/protobuf/ByteString;", "getPullType", "()I", "getRefObjectId", "()J", "getRefObjectNonceId", "()Ljava/lang/String;", "getUsername", "plugin-finder_release"})
public final class h$e
  implements j
{
  final b lastBuffer;
  final int pullType;
  final long refObjectId;
  final String refObjectNonceId;
  final String username;
  
  public h$e(String paramString1, long paramLong, String paramString2, b paramb, int paramInt)
  {
    AppMethodBeat.i(165856);
    this.username = paramString1;
    this.refObjectId = paramLong;
    this.refObjectNonceId = paramString2;
    this.lastBuffer = paramb;
    this.pullType = paramInt;
    AppMethodBeat.o(165856);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.h.e
 * JD-Core Version:    0.7.0.1
 */