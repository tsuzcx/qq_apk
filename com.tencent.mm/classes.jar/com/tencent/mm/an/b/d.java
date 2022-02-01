package com.tencent.mm.an.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.q;
import com.tencent.mm.protocal.protobuf.dyy;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/modelbase/observer/NetSceneFlowEvent;", "T", "Lcom/tencent/mm/protocal/protobuf/ResponseProtoBuf;", "N", "Lcom/tencent/mm/modelbase/NetSceneBase;", "", "action", "Lcom/tencent/mm/modelbase/observer/NetSceneAction;", "netId", "", "errType", "errCode", "errMsg", "", "scene", "resp", "(Lcom/tencent/mm/modelbase/observer/NetSceneAction;IIILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;Lcom/tencent/mm/protocal/protobuf/ResponseProtoBuf;)V", "getAction", "()Lcom/tencent/mm/modelbase/observer/NetSceneAction;", "getErrCode", "()I", "getErrMsg", "()Ljava/lang/String;", "getErrType", "getNetId", "getResp", "()Lcom/tencent/mm/protocal/protobuf/ResponseProtoBuf;", "Lcom/tencent/mm/protocal/protobuf/ResponseProtoBuf;", "getScene", "()Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "mmkernel_release"})
public class d<T extends dyy, N extends q>
{
  public final int errCode;
  public final String errMsg;
  public final int errType;
  private final N fzz;
  public final T lBJ;
  public final b lDS;
  private final int netId;
  
  public d(b paramb, int paramInt1, int paramInt2, int paramInt3, String paramString, N paramN, T paramT)
  {
    AppMethodBeat.i(206393);
    this.lDS = paramb;
    this.netId = paramInt1;
    this.errType = paramInt2;
    this.errCode = paramInt3;
    this.errMsg = paramString;
    this.fzz = paramN;
    this.lBJ = paramT;
    AppMethodBeat.o(206393);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.an.b.d
 * JD-Core Version:    0.7.0.1
 */