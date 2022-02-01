package com.tencent.mm.plugin.finder.feed.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import com.tencent.mm.plugin.finder.feed.model.internal.j;
import com.tencent.mm.protocal.protobuf.dzp;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/feed/model/ProfileRequest;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IRequest;", "username", "", "maxid", "", "pullType", "", "lastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Ljava/lang/String;JILcom/tencent/mm/protobuf/ByteString;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "getContextObj", "()Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "getLastBuffer", "()Lcom/tencent/mm/protobuf/ByteString;", "getMaxid", "()J", "getPullType", "()I", "getUsername", "()Ljava/lang/String;", "plugin-finder_release"})
public final class p
  implements j
{
  final dzp contextObj;
  final b lastBuffer;
  final int pullType;
  final long qyO;
  final String username;
  
  public p(String paramString, long paramLong, int paramInt, b paramb, dzp paramdzp)
  {
    AppMethodBeat.i(198321);
    this.username = paramString;
    this.qyO = paramLong;
    this.pullType = paramInt;
    this.lastBuffer = paramb;
    this.contextObj = paramdzp;
    AppMethodBeat.o(198321);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.model.p
 * JD-Core Version:    0.7.0.1
 */