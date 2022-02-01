package com.tencent.mm.ba;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.l.c;
import com.tencent.mm.protocal.l.e;
import com.tencent.mm.protocal.protobuf.cxn;

public final class b$c
  extends l.e
  implements l.c
{
  public cxn jgg;
  
  public b$c()
  {
    AppMethodBeat.i(43047);
    this.jgg = new cxn();
    AppMethodBeat.o(43047);
  }
  
  public final int fromProtoBuf(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(43048);
    this.jgg = ((cxn)new cxn().parseFrom(paramArrayOfByte));
    int i = this.jgg.Ret;
    AppMethodBeat.o(43048);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ba.b.c
 * JD-Core Version:    0.7.0.1
 */