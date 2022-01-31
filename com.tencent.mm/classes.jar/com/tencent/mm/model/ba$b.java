package com.tencent.mm.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.l;
import com.tencent.mm.protocal.l.c;
import com.tencent.mm.protocal.l.e;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.art;

public final class ba$b
  extends l.e
  implements l.c
{
  public art fml;
  
  public ba$b()
  {
    AppMethodBeat.i(16317);
    this.fml = new art();
    AppMethodBeat.o(16317);
  }
  
  public final int fromProtoBuf(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(16318);
    this.fml = ((art)new art().parseFrom(paramArrayOfByte));
    l.a(this, this.fml.getBaseResponse());
    int i = this.fml.getBaseResponse().Ret;
    AppMethodBeat.o(16318);
    return i;
  }
  
  public final int getCmdId()
  {
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.model.ba.b
 * JD-Core Version:    0.7.0.1
 */