package com.tencent.mm.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.l;
import com.tencent.mm.protocal.l.c;
import com.tencent.mm.protocal.l.e;
import com.tencent.mm.protocal.protobuf.cvo;
import com.tencent.mm.protocal.protobuf.kd;

public final class bn$b
  extends l.e
  implements l.c
{
  public cvo olv;
  
  public bn$b()
  {
    AppMethodBeat.i(20367);
    this.olv = new cvo();
    AppMethodBeat.o(20367);
  }
  
  public final int fromProtoBuf(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(20368);
    this.olv = ((cvo)new cvo().parseFrom(paramArrayOfByte));
    l.a(this, this.olv.getBaseResponse());
    int i = this.olv.getBaseResponse().Idd;
    AppMethodBeat.o(20368);
    return i;
  }
  
  public final int getCmdId()
  {
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.model.bn.b
 * JD-Core Version:    0.7.0.1
 */