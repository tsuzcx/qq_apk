package com.tencent.mm.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.l;
import com.tencent.mm.protocal.l.c;
import com.tencent.mm.protocal.l.e;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.arx;

public final class bb$b
  extends l.e
  implements l.c
{
  public arx fmn;
  
  public bb$b()
  {
    AppMethodBeat.i(16321);
    this.fmn = new arx();
    AppMethodBeat.o(16321);
  }
  
  public final int fromProtoBuf(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(16322);
    this.fmn = ((arx)new arx().parseFrom(paramArrayOfByte));
    l.a(this, this.fmn.getBaseResponse());
    int i = this.fmn.getBaseResponse().Ret;
    AppMethodBeat.o(16322);
    return i;
  }
  
  public final int getCmdId()
  {
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.model.bb.b
 * JD-Core Version:    0.7.0.1
 */