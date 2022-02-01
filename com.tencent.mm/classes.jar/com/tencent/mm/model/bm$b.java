package com.tencent.mm.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.l;
import com.tencent.mm.protocal.l.c;
import com.tencent.mm.protocal.l.e;
import com.tencent.mm.protocal.protobuf.cvk;
import com.tencent.mm.protocal.protobuf.kd;

public final class bm$b
  extends l.e
  implements l.c
{
  public cvk olt;
  
  public bm$b()
  {
    AppMethodBeat.i(20363);
    this.olt = new cvk();
    AppMethodBeat.o(20363);
  }
  
  public final int fromProtoBuf(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(20364);
    this.olt = ((cvk)new cvk().parseFrom(paramArrayOfByte));
    l.a(this, this.olt.getBaseResponse());
    int i = this.olt.getBaseResponse().Idd;
    AppMethodBeat.o(20364);
    return i;
  }
  
  public final int getCmdId()
  {
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.model.bm.b
 * JD-Core Version:    0.7.0.1
 */