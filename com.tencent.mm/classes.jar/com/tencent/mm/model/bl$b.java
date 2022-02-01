package com.tencent.mm.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.l;
import com.tencent.mm.protocal.l.c;
import com.tencent.mm.protocal.l.e;
import com.tencent.mm.protocal.protobuf.cfh;
import com.tencent.mm.protocal.protobuf.jh;

public final class bl$b
  extends l.e
  implements l.c
{
  public cfh ltU;
  
  public bl$b()
  {
    AppMethodBeat.i(20363);
    this.ltU = new cfh();
    AppMethodBeat.o(20363);
  }
  
  public final int fromProtoBuf(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(20364);
    this.ltU = ((cfh)new cfh().parseFrom(paramArrayOfByte));
    l.a(this, this.ltU.getBaseResponse());
    int i = this.ltU.getBaseResponse().CqV;
    AppMethodBeat.o(20364);
    return i;
  }
  
  public final int getCmdId()
  {
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.model.bl.b
 * JD-Core Version:    0.7.0.1
 */