package com.tencent.mm.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.l;
import com.tencent.mm.protocal.l.c;
import com.tencent.mm.protocal.l.e;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.bkq;

public final class bf$b
  extends l.e
  implements l.c
{
  public bkq hGt;
  
  public bf$b()
  {
    AppMethodBeat.i(20367);
    this.hGt = new bkq();
    AppMethodBeat.o(20367);
  }
  
  public final int fromProtoBuf(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(20368);
    this.hGt = ((bkq)new bkq().parseFrom(paramArrayOfByte));
    l.a(this, this.hGt.getBaseResponse());
    int i = this.hGt.getBaseResponse().Ret;
    AppMethodBeat.o(20368);
    return i;
  }
  
  public final int getCmdId()
  {
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.model.bf.b
 * JD-Core Version:    0.7.0.1
 */