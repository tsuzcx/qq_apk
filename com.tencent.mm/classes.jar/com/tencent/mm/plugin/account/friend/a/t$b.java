package com.tencent.mm.plugin.account.friend.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.l;
import com.tencent.mm.protocal.l.c;
import com.tencent.mm.protocal.l.e;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.aqi;

public final class t$b
  extends l.e
  implements l.c
{
  public aqi gxL;
  
  public t$b()
  {
    AppMethodBeat.i(108414);
    this.gxL = new aqi();
    AppMethodBeat.o(108414);
  }
  
  public final int fromProtoBuf(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(108415);
    this.gxL = ((aqi)new aqi().parseFrom(paramArrayOfByte));
    l.a(this, this.gxL.getBaseResponse());
    int i = this.gxL.getBaseResponse().Ret;
    AppMethodBeat.o(108415);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.a.t.b
 * JD-Core Version:    0.7.0.1
 */