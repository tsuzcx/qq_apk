package com.tencent.mm.am.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.protocal.protobuf.esc;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/modelbase/observer/NetSceneFlowEvent;", "T", "Lcom/tencent/mm/protocal/protobuf/ResponseProtoBuf;", "N", "Lcom/tencent/mm/modelbase/NetSceneBase;", "", "action", "Lcom/tencent/mm/modelbase/observer/NetSceneAction;", "netId", "", "errType", "errCode", "errMsg", "", "scene", "resp", "(Lcom/tencent/mm/modelbase/observer/NetSceneAction;IIILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;Lcom/tencent/mm/protocal/protobuf/ResponseProtoBuf;)V", "getAction", "()Lcom/tencent/mm/modelbase/observer/NetSceneAction;", "getErrCode", "()I", "getErrMsg", "()Ljava/lang/String;", "getErrType", "getNetId", "getResp", "()Lcom/tencent/mm/protocal/protobuf/ResponseProtoBuf;", "Lcom/tencent/mm/protocal/protobuf/ResponseProtoBuf;", "getScene", "()Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "mmkernel_release"}, k=1, mv={1, 5, 1}, xi=48)
public class d<T extends esc, N extends p>
{
  public final int errCode;
  public final String errMsg;
  public final int errType;
  private final N hEi;
  private final int netId;
  public final T ott;
  public final b ovD;
  
  public d(b paramb, int paramInt1, int paramInt2, int paramInt3, String paramString, N paramN, T paramT)
  {
    AppMethodBeat.i(236817);
    this.ovD = paramb;
    this.netId = paramInt1;
    this.errType = paramInt2;
    this.errCode = paramInt3;
    this.errMsg = paramString;
    this.hEi = paramN;
    this.ott = paramT;
    AppMethodBeat.o(236817);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.am.b.d
 * JD-Core Version:    0.7.0.1
 */