package com.tencent.mm.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.l;
import com.tencent.mm.protocal.l.c;
import com.tencent.mm.protocal.l.e;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.dkc;

public final class bf$b
  extends l.e
  implements l.c
{
  public dkc gND;
  
  public bf$b()
  {
    AppMethodBeat.i(20371);
    this.gND = new dkc();
    AppMethodBeat.o(20371);
  }
  
  public final int fromProtoBuf(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(20372);
    this.gND = ((dkc)new dkc().parseFrom(paramArrayOfByte));
    l.a(this, this.gND.getBaseResponse());
    int i = this.gND.getBaseResponse().Ret;
    AppMethodBeat.o(20372);
    return i;
  }
  
  public final int getCmdId()
  {
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.model.bf.b
 * JD-Core Version:    0.7.0.1
 */