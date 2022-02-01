package com.tencent.mm.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.l;
import com.tencent.mm.protocal.l.c;
import com.tencent.mm.protocal.l.e;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.eqj;

public final class bm$b
  extends l.e
  implements l.c
{
  public eqj iDX;
  
  public bm$b()
  {
    AppMethodBeat.i(20371);
    this.iDX = new eqj();
    AppMethodBeat.o(20371);
  }
  
  public final int fromProtoBuf(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(20372);
    this.iDX = ((eqj)new eqj().parseFrom(paramArrayOfByte));
    l.a(this, this.iDX.getBaseResponse());
    int i = this.iDX.getBaseResponse().Ret;
    AppMethodBeat.o(20372);
    return i;
  }
  
  public final int getCmdId()
  {
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.model.bm.b
 * JD-Core Version:    0.7.0.1
 */