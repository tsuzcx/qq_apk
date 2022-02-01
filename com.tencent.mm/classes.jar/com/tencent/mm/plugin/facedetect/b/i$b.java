package com.tencent.mm.plugin.facedetect.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.l;
import com.tencent.mm.protocal.l.c;
import com.tencent.mm.protocal.l.e;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.axy;

public final class i$b
  extends l.e
  implements l.c
{
  public axy rod;
  
  public i$b()
  {
    AppMethodBeat.i(103593);
    this.rod = new axy();
    AppMethodBeat.o(103593);
  }
  
  public final int fromProtoBuf(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(103594);
    this.rod = ((axy)new axy().parseFrom(paramArrayOfByte));
    l.a(this, this.rod.getBaseResponse());
    int i = this.rod.getBaseResponse().Ret;
    AppMethodBeat.o(103594);
    return i;
  }
  
  public final int getCmdId()
  {
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.b.i.b
 * JD-Core Version:    0.7.0.1
 */