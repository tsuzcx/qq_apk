package com.tencent.mm.ba;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.messenger.foundation.a.a.j.b;
import com.tencent.mm.protocal.protobuf.dlv;

@Deprecated
public final class n
  extends j.b
{
  private dlv hPl;
  
  public n(int paramInt)
  {
    super(30);
    AppMethodBeat.i(20568);
    this.hPl = new dlv();
    this.hPl.OpCode = paramInt;
    this.uHj = this.hPl;
    AppMethodBeat.o(20568);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ba.n
 * JD-Core Version:    0.7.0.1
 */