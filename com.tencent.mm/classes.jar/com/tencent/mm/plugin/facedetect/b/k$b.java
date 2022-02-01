package com.tencent.mm.plugin.facedetect.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.l;
import com.tencent.mm.protocal.l.c;
import com.tencent.mm.protocal.l.e;
import com.tencent.mm.protocal.protobuf.eow;
import com.tencent.mm.protocal.protobuf.kd;

public final class k$b
  extends l.e
  implements l.c
{
  public eow zRJ;
  
  public k$b()
  {
    AppMethodBeat.i(103597);
    this.zRJ = new eow();
    AppMethodBeat.o(103597);
  }
  
  public final int fromProtoBuf(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(103598);
    this.zRJ = ((eow)new eow().parseFrom(paramArrayOfByte));
    l.a(this, this.zRJ.getBaseResponse());
    int i = this.zRJ.getBaseResponse().Idd;
    AppMethodBeat.o(103598);
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