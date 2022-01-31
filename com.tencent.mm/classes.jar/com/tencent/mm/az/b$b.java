package com.tencent.mm.az;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.l.b;
import com.tencent.mm.protocal.l.d;
import com.tencent.mm.protocal.protobuf.bjo;

final class b$b
  extends l.d
  implements l.b
{
  public bjo fLK;
  
  b$b()
  {
    AppMethodBeat.i(59987);
    this.fLK = new bjo();
    AppMethodBeat.o(59987);
  }
  
  public final int getFuncId()
  {
    return 681;
  }
  
  public final byte[] toProtoBuf()
  {
    AppMethodBeat.i(59988);
    byte[] arrayOfByte = this.fLK.toByteArray();
    AppMethodBeat.o(59988);
    return arrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.az.b.b
 * JD-Core Version:    0.7.0.1
 */