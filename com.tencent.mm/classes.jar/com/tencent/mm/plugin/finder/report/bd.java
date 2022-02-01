package com.tencent.mm.plugin.finder.report;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.bra;
import kotlin.Metadata;
import kotlin.ah;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/report/SessionBufferEx;", "", "sessionBuffer", "", "(Ljava/lang/String;)V", "baseInfo", "Lcom/tencent/mm/protocal/protobuf/FinderObjectBaseInfo;", "getBaseInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderObjectBaseInfo;", "commentScene", "", "getCommentScene", "()I", "setCommentScene", "(I)V", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class bd
{
  public int AJo;
  public final bra FuM;
  
  public bd(String paramString)
  {
    AppMethodBeat.i(331057);
    bra localbra = new bra();
    localbra.ZJK = paramString;
    paramString = ah.aiuX;
    this.FuM = localbra;
    AppMethodBeat.o(331057);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.report.bd
 * JD-Core Version:    0.7.0.1
 */