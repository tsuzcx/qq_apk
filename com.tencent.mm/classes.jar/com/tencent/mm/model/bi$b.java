package com.tencent.mm.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.l;
import com.tencent.mm.protocal.l.c;
import com.tencent.mm.protocal.l.e;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.dwf;

public final class bi$b
  extends l.e
  implements l.c
{
  public dwf hJn;
  
  public bi$b()
  {
    AppMethodBeat.i(20371);
    this.hJn = new dwf();
    AppMethodBeat.o(20371);
  }
  
  public final int fromProtoBuf(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(20372);
    this.hJn = ((dwf)new dwf().parseFrom(paramArrayOfByte));
    l.a(this, this.hJn.getBaseResponse());
    int i = this.hJn.getBaseResponse().Ret;
    AppMethodBeat.o(20372);
    return i;
  }
  
  public final int getCmdId()
  {
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.model.bi.b
 * JD-Core Version:    0.7.0.1
 */