package com.tencent.mm.openim.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.a;
import com.tencent.mm.protocal.protobuf.dxz;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/openim/oplog/OpenIMKefuMuteOp;", "Lcom/tencent/mm/openim/oplog/OpenIMKefuOpBase;", "kfUser", "", "switchFlg", "", "(Ljava/lang/String;I)V", "oplog", "Lcom/tencent/mm/protocal/protobuf/OpenIMModKefuContactMuteOplog;", "getOplog", "()Lcom/tencent/mm/protocal/protobuf/OpenIMModKefuContactMuteOplog;", "setOplog", "(Lcom/tencent/mm/protocal/protobuf/OpenIMModKefuContactMuteOplog;)V", "Companion", "plugin-comm_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  extends c
{
  public static final a ptv;
  private dxz ptw;
  
  static
  {
    AppMethodBeat.i(235781);
    ptv = new a((byte)0);
    AppMethodBeat.o(235781);
  }
  
  public b(String paramString, int paramInt)
  {
    AppMethodBeat.i(235778);
    this.ptw = new dxz();
    this.ptw.YFY = paramString;
    this.ptw.ZFI = paramInt;
    this.KRu = ((a)this.ptw);
    AppMethodBeat.o(235778);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/openim/oplog/OpenIMKefuMuteOp$Companion;", "", "()V", "TAG", "", "plugin-comm_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.openim.c.b
 * JD-Core Version:    0.7.0.1
 */