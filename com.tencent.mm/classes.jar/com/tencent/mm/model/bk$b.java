package com.tencent.mm.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.l;
import com.tencent.mm.protocal.l.c;
import com.tencent.mm.protocal.l.e;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.bxn;

public final class bk$b
  extends l.e
  implements l.c
{
  public bxn iDT;
  
  public bk$b()
  {
    AppMethodBeat.i(20363);
    this.iDT = new bxn();
    AppMethodBeat.o(20363);
  }
  
  public final int fromProtoBuf(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(20364);
    this.iDT = ((bxn)new bxn().parseFrom(paramArrayOfByte));
    l.a(this, this.iDT.getBaseResponse());
    int i = this.iDT.getBaseResponse().Ret;
    AppMethodBeat.o(20364);
    return i;
  }
  
  public final int getCmdId()
  {
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.model.bk.b
 * JD-Core Version:    0.7.0.1
 */