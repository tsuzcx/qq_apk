package com.tencent.mm.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.l;
import com.tencent.mm.protocal.l.c;
import com.tencent.mm.protocal.l.e;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.bgi;

public final class be$b
  extends l.e
  implements l.c
{
  public bgi hob;
  
  public be$b()
  {
    AppMethodBeat.i(20367);
    this.hob = new bgi();
    AppMethodBeat.o(20367);
  }
  
  public final int fromProtoBuf(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(20368);
    this.hob = ((bgi)new bgi().parseFrom(paramArrayOfByte));
    l.a(this, this.hob.getBaseResponse());
    int i = this.hob.getBaseResponse().Ret;
    AppMethodBeat.o(20368);
    return i;
  }
  
  public final int getCmdId()
  {
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.model.be.b
 * JD-Core Version:    0.7.0.1
 */