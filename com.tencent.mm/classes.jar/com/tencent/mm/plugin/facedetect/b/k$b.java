package com.tencent.mm.plugin.facedetect.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.l;
import com.tencent.mm.protocal.l.c;
import com.tencent.mm.protocal.l.e;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.epm;

public final class k$b
  extends l.e
  implements l.c
{
  public epm sPM;
  
  public k$b()
  {
    AppMethodBeat.i(103601);
    this.sPM = new epm();
    AppMethodBeat.o(103601);
  }
  
  public final int fromProtoBuf(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(103602);
    this.sPM = ((epm)new epm().parseFrom(paramArrayOfByte));
    l.a(this, this.sPM.getBaseResponse());
    int i = this.sPM.getBaseResponse().Ret;
    AppMethodBeat.o(103602);
    return i;
  }
  
  public final int getCmdId()
  {
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.b.k.b
 * JD-Core Version:    0.7.0.1
 */