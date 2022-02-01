package com.tencent.mm.am.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/modelbase/observer/NetSceneEvent;", "", "action", "Lcom/tencent/mm/modelbase/observer/NetSceneAction;", "errType", "", "errCode", "errMsg", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "(Lcom/tencent/mm/modelbase/observer/NetSceneAction;IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "getAction", "()Lcom/tencent/mm/modelbase/observer/NetSceneAction;", "getErrCode", "()I", "getErrMsg", "()Ljava/lang/String;", "getErrType", "getScene", "()Lcom/tencent/mm/modelbase/NetSceneBase;", "mmkernel_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
{
  public final int errCode;
  public final String errMsg;
  public final int errType;
  public final p hEi;
  public final b ovD;
  
  public c(b paramb, int paramInt1, int paramInt2, String paramString, p paramp)
  {
    AppMethodBeat.i(236815);
    this.ovD = paramb;
    this.errType = paramInt1;
    this.errCode = paramInt2;
    this.errMsg = paramString;
    this.hEi = paramp;
    AppMethodBeat.o(236815);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.am.b.c
 * JD-Core Version:    0.7.0.1
 */