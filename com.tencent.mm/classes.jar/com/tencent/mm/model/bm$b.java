package com.tencent.mm.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.l;
import com.tencent.mm.protocal.l.c;
import com.tencent.mm.protocal.l.e;
import com.tencent.mm.protocal.protobuf.cfl;
import com.tencent.mm.protocal.protobuf.jh;

public final class bm$b
  extends l.e
  implements l.c
{
  public cfl ltW;
  
  public bm$b()
  {
    AppMethodBeat.i(20367);
    this.ltW = new cfl();
    AppMethodBeat.o(20367);
  }
  
  public final int fromProtoBuf(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(20368);
    this.ltW = ((cfl)new cfl().parseFrom(paramArrayOfByte));
    l.a(this, this.ltW.getBaseResponse());
    int i = this.ltW.getBaseResponse().CqV;
    AppMethodBeat.o(20368);
    return i;
  }
  
  public final int getCmdId()
  {
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.model.bm.b
 * JD-Core Version:    0.7.0.1
 */