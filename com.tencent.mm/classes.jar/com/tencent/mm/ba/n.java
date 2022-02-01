package com.tencent.mm.ba;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.messenger.foundation.a.a.k.b;
import com.tencent.mm.protocal.protobuf.dsj;

@Deprecated
public final class n
  extends k.b
{
  private dsj ils;
  
  public n(int paramInt)
  {
    super(30);
    AppMethodBeat.i(20568);
    this.ils = new dsj();
    this.ils.OpCode = paramInt;
    this.vWq = this.ils;
    AppMethodBeat.o(20568);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ba.n
 * JD-Core Version:    0.7.0.1
 */