package com.tencent.mm.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.l;
import com.tencent.mm.protocal.l.c;
import com.tencent.mm.protocal.l.e;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.cqq;

public final class bc$b
  extends l.e
  implements l.c
{
  public cqq fmp;
  
  public bc$b()
  {
    AppMethodBeat.i(16325);
    this.fmp = new cqq();
    AppMethodBeat.o(16325);
  }
  
  public final int fromProtoBuf(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(16326);
    this.fmp = ((cqq)new cqq().parseFrom(paramArrayOfByte));
    l.a(this, this.fmp.getBaseResponse());
    int i = this.fmp.getBaseResponse().Ret;
    AppMethodBeat.o(16326);
    return i;
  }
  
  public final int getCmdId()
  {
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.model.bc.b
 * JD-Core Version:    0.7.0.1
 */