package com.tencent.mm.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.l;
import com.tencent.mm.protocal.l.c;
import com.tencent.mm.protocal.l.e;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.bcm;

public final class bd$b
  extends l.e
  implements l.c
{
  public bcm gNz;
  
  public bd$b()
  {
    AppMethodBeat.i(20363);
    this.gNz = new bcm();
    AppMethodBeat.o(20363);
  }
  
  public final int fromProtoBuf(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(20364);
    this.gNz = ((bcm)new bcm().parseFrom(paramArrayOfByte));
    l.a(this, this.gNz.getBaseResponse());
    int i = this.gNz.getBaseResponse().Ret;
    AppMethodBeat.o(20364);
    return i;
  }
  
  public final int getCmdId()
  {
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.model.bd.b
 * JD-Core Version:    0.7.0.1
 */