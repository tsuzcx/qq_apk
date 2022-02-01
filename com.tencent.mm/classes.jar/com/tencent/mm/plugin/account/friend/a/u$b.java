package com.tencent.mm.plugin.account.friend.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.l;
import com.tencent.mm.protocal.l.c;
import com.tencent.mm.protocal.l.e;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.bax;

public final class u$b
  extends l.e
  implements l.c
{
  public bax ikI;
  
  public u$b()
  {
    AppMethodBeat.i(131075);
    this.ikI = new bax();
    AppMethodBeat.o(131075);
  }
  
  public final int fromProtoBuf(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(131076);
    this.ikI = ((bax)new bax().parseFrom(paramArrayOfByte));
    l.a(this, this.ikI.getBaseResponse());
    int i = this.ikI.getBaseResponse().Ret;
    AppMethodBeat.o(131076);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.a.u.b
 * JD-Core Version:    0.7.0.1
 */