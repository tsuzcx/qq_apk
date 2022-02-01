package com.tencent.mm.plugin.finder.report;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.bft;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/report/SessionBufferEx;", "", "sessionBuffer", "", "(Ljava/lang/String;)V", "baseInfo", "Lcom/tencent/mm/protocal/protobuf/FinderObjectBaseInfo;", "getBaseInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderObjectBaseInfo;", "commentScene", "", "getCommentScene", "()I", "setCommentScene", "(I)V", "plugin-finder-base_release"})
public final class ao
{
  public int xkX;
  public final bft zZQ;
  
  public ao(String paramString)
  {
    AppMethodBeat.i(258796);
    bft localbft = new bft();
    localbft.SHp = paramString;
    this.zZQ = localbft;
    AppMethodBeat.o(258796);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.report.ao
 * JD-Core Version:    0.7.0.1
 */