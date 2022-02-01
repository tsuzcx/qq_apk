package com.tencent.mm.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.l;
import com.tencent.mm.protocal.l.c;
import com.tencent.mm.protocal.l.e;
import com.tencent.mm.protocal.protobuf.fxb;
import com.tencent.mm.protocal.protobuf.kd;

public final class bo$b
  extends l.e
  implements l.c
{
  public fxb olx;
  
  public bo$b()
  {
    AppMethodBeat.i(20371);
    this.olx = new fxb();
    AppMethodBeat.o(20371);
  }
  
  public final int fromProtoBuf(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(20372);
    this.olx = ((fxb)new fxb().parseFrom(paramArrayOfByte));
    l.a(this, this.olx.getBaseResponse());
    int i = this.olx.getBaseResponse().Idd;
    AppMethodBeat.o(20372);
    return i;
  }
  
  public final int getCmdId()
  {
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.model.bo.b
 * JD-Core Version:    0.7.0.1
 */