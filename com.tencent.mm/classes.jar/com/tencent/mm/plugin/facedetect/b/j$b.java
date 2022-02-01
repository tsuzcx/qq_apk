package com.tencent.mm.plugin.facedetect.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.l;
import com.tencent.mm.protocal.l.c;
import com.tencent.mm.protocal.l.e;
import com.tencent.mm.protocal.protobuf.cfi;
import com.tencent.mm.protocal.protobuf.kd;

public final class j$b
  extends l.e
  implements l.c
{
  public cfi zRH;
  
  public j$b()
  {
    AppMethodBeat.i(103593);
    this.zRH = new cfi();
    AppMethodBeat.o(103593);
  }
  
  public final int fromProtoBuf(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(103594);
    this.zRH = ((cfi)new cfi().parseFrom(paramArrayOfByte));
    l.a(this, this.zRH.getBaseResponse());
    int i = this.zRH.getBaseResponse().Idd;
    AppMethodBeat.o(103594);
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