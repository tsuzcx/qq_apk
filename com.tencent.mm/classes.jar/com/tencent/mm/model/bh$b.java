package com.tencent.mm.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.l;
import com.tencent.mm.protocal.l.c;
import com.tencent.mm.protocal.l.e;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.bli;

public final class bh$b
  extends l.e
  implements l.c
{
  public bli hJl;
  
  public bh$b()
  {
    AppMethodBeat.i(20367);
    this.hJl = new bli();
    AppMethodBeat.o(20367);
  }
  
  public final int fromProtoBuf(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(20368);
    this.hJl = ((bli)new bli().parseFrom(paramArrayOfByte));
    l.a(this, this.hJl.getBaseResponse());
    int i = this.hJl.getBaseResponse().Ret;
    AppMethodBeat.o(20368);
    return i;
  }
  
  public final int getCmdId()
  {
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.model.bh.b
 * JD-Core Version:    0.7.0.1
 */