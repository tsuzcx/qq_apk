package com.tencent.mm.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.l;
import com.tencent.mm.protocal.l.c;
import com.tencent.mm.protocal.l.e;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.bxr;

public final class bl$b
  extends l.e
  implements l.c
{
  public bxr iDV;
  
  public bl$b()
  {
    AppMethodBeat.i(20367);
    this.iDV = new bxr();
    AppMethodBeat.o(20367);
  }
  
  public final int fromProtoBuf(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(20368);
    this.iDV = ((bxr)new bxr().parseFrom(paramArrayOfByte));
    l.a(this, this.iDV.getBaseResponse());
    int i = this.iDV.getBaseResponse().Ret;
    AppMethodBeat.o(20368);
    return i;
  }
  
  public final int getCmdId()
  {
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.model.bl.b
 * JD-Core Version:    0.7.0.1
 */