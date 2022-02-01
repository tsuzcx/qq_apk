package com.tencent.mm.plugin.account.friend.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.l;
import com.tencent.mm.protocal.l.c;
import com.tencent.mm.protocal.l.e;
import com.tencent.mm.protocal.protobuf.ajh;
import com.tencent.mm.protocal.protobuf.jh;

public final class s$b
  extends l.e
  implements l.c
{
  public ajh mWr;
  
  public s$b()
  {
    AppMethodBeat.i(131069);
    this.mWr = new ajh();
    AppMethodBeat.o(131069);
  }
  
  public final int fromProtoBuf(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(131070);
    this.mWr = ((ajh)new ajh().parseFrom(paramArrayOfByte));
    l.a(this, this.mWr.getBaseResponse());
    int i = this.mWr.getBaseResponse().CqV;
    AppMethodBeat.o(131070);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.a.s.b
 * JD-Core Version:    0.7.0.1
 */