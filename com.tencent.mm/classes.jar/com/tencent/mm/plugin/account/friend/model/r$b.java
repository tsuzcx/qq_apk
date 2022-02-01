package com.tencent.mm.plugin.account.friend.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.l;
import com.tencent.mm.protocal.l.c;
import com.tencent.mm.protocal.l.e;
import com.tencent.mm.protocal.protobuf.ctc;
import com.tencent.mm.protocal.protobuf.kd;

public final class r$b
  extends l.e
  implements l.c
{
  public ctc pTa;
  
  public r$b()
  {
    AppMethodBeat.i(131075);
    this.pTa = new ctc();
    AppMethodBeat.o(131075);
  }
  
  public final int fromProtoBuf(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(131076);
    this.pTa = ((ctc)new ctc().parseFrom(paramArrayOfByte));
    l.a(this, this.pTa.getBaseResponse());
    int i = this.pTa.getBaseResponse().Idd;
    AppMethodBeat.o(131076);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.model.r.b
 * JD-Core Version:    0.7.0.1
 */