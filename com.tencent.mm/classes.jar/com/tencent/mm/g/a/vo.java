package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.dcn;
import com.tencent.mm.sdk.b.b;

public final class vo
  extends b
{
  public a dBb;
  public b dBc;
  
  public vo()
  {
    this((byte)0);
  }
  
  private vo(byte paramByte)
  {
    AppMethodBeat.i(152988);
    this.dBb = new a();
    this.dBc = new b();
    this.ESR = false;
    this.callback = null;
    AppMethodBeat.o(152988);
  }
  
  public static final class a
  {
    public int actionType;
  }
  
  public static final class b
  {
    public boolean dBd;
    public dcn dBe;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.g.a.vo
 * JD-Core Version:    0.7.0.1
 */