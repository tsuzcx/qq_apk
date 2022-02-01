package com.tencent.mm.an.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.q;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/modelbase/observer/NetSceneEvent;", "", "action", "Lcom/tencent/mm/modelbase/observer/NetSceneAction;", "errType", "", "errCode", "errMsg", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "(Lcom/tencent/mm/modelbase/observer/NetSceneAction;IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "getAction", "()Lcom/tencent/mm/modelbase/observer/NetSceneAction;", "getErrCode", "()I", "getErrMsg", "()Ljava/lang/String;", "getErrType", "getScene", "()Lcom/tencent/mm/modelbase/NetSceneBase;", "mmkernel_release"})
public final class c
{
  public final int errCode;
  public final String errMsg;
  public final int errType;
  public final q fzz;
  public final b lDS;
  
  public c(b paramb, int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(203171);
    this.lDS = paramb;
    this.errType = paramInt1;
    this.errCode = paramInt2;
    this.errMsg = paramString;
    this.fzz = paramq;
    AppMethodBeat.o(203171);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.an.b.c
 * JD-Core Version:    0.7.0.1
 */