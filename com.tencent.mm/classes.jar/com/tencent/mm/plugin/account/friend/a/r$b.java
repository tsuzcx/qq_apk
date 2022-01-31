package com.tencent.mm.plugin.account.friend.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.l;
import com.tencent.mm.protocal.l.c;
import com.tencent.mm.protocal.l.e;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.zf;

public final class r$b
  extends l.e
  implements l.c
{
  public zf gxI;
  
  public r$b()
  {
    AppMethodBeat.i(108408);
    this.gxI = new zf();
    AppMethodBeat.o(108408);
  }
  
  public final int fromProtoBuf(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(108409);
    this.gxI = ((zf)new zf().parseFrom(paramArrayOfByte));
    l.a(this, this.gxI.getBaseResponse());
    int i = this.gxI.getBaseResponse().Ret;
    AppMethodBeat.o(108409);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.a.r.b
 * JD-Core Version:    0.7.0.1
 */