package com.tencent.mm.plugin.finder.feed.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import com.tencent.mm.plugin.finder.feed.model.internal.i;
import com.tencent.mm.protocal.protobuf.anm;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/feed/model/ProfileRequest;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IRequest;", "username", "", "maxid", "", "pullType", "", "lastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Ljava/lang/String;JILcom/tencent/mm/protobuf/ByteString;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "getContextObj", "()Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "getLastBuffer", "()Lcom/tencent/mm/protobuf/ByteString;", "getMaxid", "()J", "getPullType", "()I", "getUsername", "()Ljava/lang/String;", "plugin-finder_release"})
public final class u
  implements i
{
  final anm contextObj;
  final b lastBuffer;
  final int pullType;
  final long rnv;
  final String username;
  
  public u(String paramString, long paramLong, int paramInt, b paramb, anm paramanm)
  {
    AppMethodBeat.i(202232);
    this.username = paramString;
    this.rnv = paramLong;
    this.pullType = paramInt;
    this.lastBuffer = paramb;
    this.contextObj = paramanm;
    AppMethodBeat.o(202232);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.model.u
 * JD-Core Version:    0.7.0.1
 */