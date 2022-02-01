package com.tencent.mm.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.l;
import com.tencent.mm.protocal.l.c;
import com.tencent.mm.protocal.l.e;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.dpr;

public final class bf$b
  extends l.e
  implements l.c
{
  public dpr hod;
  
  public bf$b()
  {
    AppMethodBeat.i(20371);
    this.hod = new dpr();
    AppMethodBeat.o(20371);
  }
  
  public final int fromProtoBuf(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(20372);
    this.hod = ((dpr)new dpr().parseFrom(paramArrayOfByte));
    l.a(this, this.hod.getBaseResponse());
    int i = this.hod.getBaseResponse().Ret;
    AppMethodBeat.o(20372);
    return i;
  }
  
  public final int getCmdId()
  {
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.model.bf.b
 * JD-Core Version:    0.7.0.1
 */