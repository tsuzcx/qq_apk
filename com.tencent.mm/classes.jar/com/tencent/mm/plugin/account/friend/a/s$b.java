package com.tencent.mm.plugin.account.friend.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.l;
import com.tencent.mm.protocal.l.c;
import com.tencent.mm.protocal.l.e;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.ais;

public final class s$b
  extends l.e
  implements l.c
{
  public ais keS;
  
  public s$b()
  {
    AppMethodBeat.i(131069);
    this.keS = new ais();
    AppMethodBeat.o(131069);
  }
  
  public final int fromProtoBuf(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(131070);
    this.keS = ((ais)new ais().parseFrom(paramArrayOfByte));
    l.a(this, this.keS.getBaseResponse());
    int i = this.keS.getBaseResponse().Ret;
    AppMethodBeat.o(131070);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.a.s.b
 * JD-Core Version:    0.7.0.1
 */