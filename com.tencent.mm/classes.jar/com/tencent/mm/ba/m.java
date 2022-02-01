package com.tencent.mm.ba;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.messenger.foundation.a.a.j.b;
import com.tencent.mm.protocal.protobuf.cci;

@Deprecated
public final class m
  extends j.b
{
  private cci hPk;
  
  public m(int paramInt, String paramString)
  {
    super(26);
    AppMethodBeat.i(20567);
    this.hPk = new cci();
    this.hPk.FqQ = paramInt;
    this.hPk.FqR = paramString;
    this.uHj = this.hPk;
    AppMethodBeat.o(20567);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ba.m
 * JD-Core Version:    0.7.0.1
 */