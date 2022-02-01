package com.tencent.mm.plugin.account.friend.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.l;
import com.tencent.mm.protocal.l.c;
import com.tencent.mm.protocal.l.e;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.bep;

public final class u$b
  extends l.e
  implements l.c
{
  public bep iKP;
  
  public u$b()
  {
    AppMethodBeat.i(131075);
    this.iKP = new bep();
    AppMethodBeat.o(131075);
  }
  
  public final int fromProtoBuf(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(131076);
    this.iKP = ((bep)new bep().parseFrom(paramArrayOfByte));
    l.a(this, this.iKP.getBaseResponse());
    int i = this.iKP.getBaseResponse().Ret;
    AppMethodBeat.o(131076);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.a.u.b
 * JD-Core Version:    0.7.0.1
 */