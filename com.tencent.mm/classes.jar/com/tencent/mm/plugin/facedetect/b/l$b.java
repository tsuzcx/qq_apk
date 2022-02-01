package com.tencent.mm.plugin.facedetect.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.l;
import com.tencent.mm.protocal.l.c;
import com.tencent.mm.protocal.l.e;
import com.tencent.mm.protocal.protobuf.fwb;
import com.tencent.mm.protocal.protobuf.kd;

public final class l$b
  extends l.e
  implements l.c
{
  public fwb zRL;
  
  public l$b()
  {
    AppMethodBeat.i(103601);
    this.zRL = new fwb();
    AppMethodBeat.o(103601);
  }
  
  public final int fromProtoBuf(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(103602);
    this.zRL = ((fwb)new fwb().parseFrom(paramArrayOfByte));
    l.a(this, this.zRL.getBaseResponse());
    int i = this.zRL.getBaseResponse().Idd;
    AppMethodBeat.o(103602);
    return i;
  }
  
  public final int getCmdId()
  {
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.b.l.b
 * JD-Core Version:    0.7.0.1
 */