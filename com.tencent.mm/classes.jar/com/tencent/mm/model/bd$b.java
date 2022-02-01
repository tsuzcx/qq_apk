package com.tencent.mm.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.l;
import com.tencent.mm.protocal.l.c;
import com.tencent.mm.protocal.l.e;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.bge;

public final class bd$b
  extends l.e
  implements l.c
{
  public bge hnZ;
  
  public bd$b()
  {
    AppMethodBeat.i(20363);
    this.hnZ = new bge();
    AppMethodBeat.o(20363);
  }
  
  public final int fromProtoBuf(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(20364);
    this.hnZ = ((bge)new bge().parseFrom(paramArrayOfByte));
    l.a(this, this.hnZ.getBaseResponse());
    int i = this.hnZ.getBaseResponse().Ret;
    AppMethodBeat.o(20364);
    return i;
  }
  
  public final int getCmdId()
  {
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.model.bd.b
 * JD-Core Version:    0.7.0.1
 */