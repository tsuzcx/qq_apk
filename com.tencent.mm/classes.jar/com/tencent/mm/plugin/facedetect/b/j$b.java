package com.tencent.mm.plugin.facedetect.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.l;
import com.tencent.mm.protocal.l.c;
import com.tencent.mm.protocal.l.e;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.cns;

public final class j$b
  extends l.e
  implements l.c
{
  public cns qwm;
  
  public j$b()
  {
    AppMethodBeat.i(103597);
    this.qwm = new cns();
    AppMethodBeat.o(103597);
  }
  
  public final int fromProtoBuf(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(103598);
    this.qwm = ((cns)new cns().parseFrom(paramArrayOfByte));
    l.a(this, this.qwm.getBaseResponse());
    int i = this.qwm.getBaseResponse().Ret;
    AppMethodBeat.o(103598);
    return i;
  }
  
  public final int getCmdId()
  {
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.b.j.b
 * JD-Core Version:    0.7.0.1
 */