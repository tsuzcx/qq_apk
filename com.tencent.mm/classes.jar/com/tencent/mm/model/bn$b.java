package com.tencent.mm.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.l;
import com.tencent.mm.protocal.l.c;
import com.tencent.mm.protocal.l.e;
import com.tencent.mm.protocal.protobuf.fav;
import com.tencent.mm.protocal.protobuf.jh;

public final class bn$b
  extends l.e
  implements l.c
{
  public fav ltY;
  
  public bn$b()
  {
    AppMethodBeat.i(20371);
    this.ltY = new fav();
    AppMethodBeat.o(20371);
  }
  
  public final int fromProtoBuf(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(20372);
    this.ltY = ((fav)new fav().parseFrom(paramArrayOfByte));
    l.a(this, this.ltY.getBaseResponse());
    int i = this.ltY.getBaseResponse().CqV;
    AppMethodBeat.o(20372);
    return i;
  }
  
  public final int getCmdId()
  {
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.model.bn.b
 * JD-Core Version:    0.7.0.1
 */