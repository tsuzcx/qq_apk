package com.tencent.mm.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.l;
import com.tencent.mm.protocal.l.c;
import com.tencent.mm.protocal.l.e;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.bkm;

public final class be$b
  extends l.e
  implements l.c
{
  public bkm hGr;
  
  public be$b()
  {
    AppMethodBeat.i(20363);
    this.hGr = new bkm();
    AppMethodBeat.o(20363);
  }
  
  public final int fromProtoBuf(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(20364);
    this.hGr = ((bkm)new bkm().parseFrom(paramArrayOfByte));
    l.a(this, this.hGr.getBaseResponse());
    int i = this.hGr.getBaseResponse().Ret;
    AppMethodBeat.o(20364);
    return i;
  }
  
  public final int getCmdId()
  {
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.model.be.b
 * JD-Core Version:    0.7.0.1
 */