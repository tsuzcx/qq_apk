package com.tencent.mm.bd;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.messenger.foundation.a.a.k.b;
import com.tencent.mm.protocal.protobuf.agq;

@Deprecated
public final class g
  extends k.b
{
  private agq lWN;
  
  public g(String paramString)
  {
    super(32);
    AppMethodBeat.i(20566);
    this.lWN = new agq();
    this.lWN.SrS = paramString;
    this.lWN.SrT = 0;
    this.EVU = this.lWN;
    AppMethodBeat.o(20566);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.bd.g
 * JD-Core Version:    0.7.0.1
 */