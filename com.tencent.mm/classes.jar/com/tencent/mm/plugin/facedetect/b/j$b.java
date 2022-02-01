package com.tencent.mm.plugin.facedetect.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.l;
import com.tencent.mm.protocal.l.c;
import com.tencent.mm.protocal.l.e;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.dmf;

public final class j$b
  extends l.e
  implements l.c
{
  public dmf sPK;
  
  public j$b()
  {
    AppMethodBeat.i(103597);
    this.sPK = new dmf();
    AppMethodBeat.o(103597);
  }
  
  public final int fromProtoBuf(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(103598);
    this.sPK = ((dmf)new dmf().parseFrom(paramArrayOfByte));
    l.a(this, this.sPK.getBaseResponse());
    int i = this.sPK.getBaseResponse().Ret;
    AppMethodBeat.o(103598);
    return i;
  }
  
  public final int getCmdId()
  {
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.b.j.b
 * JD-Core Version:    0.7.0.1
 */