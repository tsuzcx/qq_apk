package com.tencent.mm.plugin.account.friend.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.l;
import com.tencent.mm.protocal.l.c;
import com.tencent.mm.protocal.l.e;
import com.tencent.mm.protocal.protobuf.amm;
import com.tencent.mm.protocal.protobuf.kd;

public final class p$b
  extends l.e
  implements l.c
{
  public amm pSX;
  
  public p$b()
  {
    AppMethodBeat.i(131069);
    this.pSX = new amm();
    AppMethodBeat.o(131069);
  }
  
  public final int fromProtoBuf(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(131070);
    this.pSX = ((amm)new amm().parseFrom(paramArrayOfByte));
    l.a(this, this.pSX.getBaseResponse());
    int i = this.pSX.getBaseResponse().Idd;
    AppMethodBeat.o(131070);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.model.p.b
 * JD-Core Version:    0.7.0.1
 */