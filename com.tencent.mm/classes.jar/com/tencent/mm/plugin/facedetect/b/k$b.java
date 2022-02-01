package com.tencent.mm.plugin.facedetect.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.l;
import com.tencent.mm.protocal.l.c;
import com.tencent.mm.protocal.l.e;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.dun;

public final class k$b
  extends l.e
  implements l.c
{
  public dun rge;
  
  public k$b()
  {
    AppMethodBeat.i(103601);
    this.rge = new dun();
    AppMethodBeat.o(103601);
  }
  
  public final int fromProtoBuf(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(103602);
    this.rge = ((dun)new dun().parseFrom(paramArrayOfByte));
    l.a(this, this.rge.getBaseResponse());
    int i = this.rge.getBaseResponse().Ret;
    AppMethodBeat.o(103602);
    return i;
  }
  
  public final int getCmdId()
  {
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.b.k.b
 * JD-Core Version:    0.7.0.1
 */