package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.dnp;
import com.tencent.mm.sdk.b.b;

public final class ws
  extends b
{
  public a dLb;
  public b dLc;
  
  public ws()
  {
    this((byte)0);
  }
  
  private ws(byte paramByte)
  {
    AppMethodBeat.i(152988);
    this.dLb = new a();
    this.dLc = new b();
    this.IbR = false;
    this.callback = null;
    AppMethodBeat.o(152988);
  }
  
  public static final class a
  {
    public int actionType;
  }
  
  public static final class b
  {
    public boolean dLd;
    public dnp dLe;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.g.a.ws
 * JD-Core Version:    0.7.0.1
 */