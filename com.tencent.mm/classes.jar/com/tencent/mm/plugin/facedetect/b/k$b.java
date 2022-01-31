package com.tencent.mm.plugin.facedetect.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.l;
import com.tencent.mm.protocal.l.c;
import com.tencent.mm.protocal.l.e;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.cpw;

public final class k$b
  extends l.e
  implements l.c
{
  public cpw mgR;
  
  public k$b()
  {
    AppMethodBeat.i(76);
    this.mgR = new cpw();
    AppMethodBeat.o(76);
  }
  
  public final int fromProtoBuf(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(77);
    this.mgR = ((cpw)new cpw().parseFrom(paramArrayOfByte));
    l.a(this, this.mgR.getBaseResponse());
    int i = this.mgR.getBaseResponse().Ret;
    AppMethodBeat.o(77);
    return i;
  }
  
  public final int getCmdId()
  {
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.b.k.b
 * JD-Core Version:    0.7.0.1
 */