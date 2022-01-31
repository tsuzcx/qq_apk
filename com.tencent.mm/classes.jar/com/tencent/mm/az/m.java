package com.tencent.mm.az;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.messenger.foundation.a.a.j.b;
import com.tencent.mm.protocal.protobuf.cng;

@Deprecated
public final class m
  extends j.b
{
  private cng fLW;
  
  public m(int paramInt)
  {
    super(30);
    AppMethodBeat.i(16522);
    this.fLW = new cng();
    this.fLW.OpCode = paramInt;
    this.oDZ = this.fLW;
    AppMethodBeat.o(16522);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.az.m
 * JD-Core Version:    0.7.0.1
 */