package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.b.b;

public final class wm
  extends b
{
  public a dLU;
  public b dLV;
  
  public wm()
  {
    this((byte)0);
  }
  
  private wm(byte paramByte)
  {
    AppMethodBeat.i(19840);
    this.dLU = new a();
    this.dLV = new b();
    this.IvZ = false;
    this.callback = null;
    AppMethodBeat.o(19840);
  }
  
  public static final class a
  {
    public String dED;
    public int dEE = 0;
    public int dEF = 0;
    public int opType = 0;
  }
  
  public static final class b {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.a.wm
 * JD-Core Version:    0.7.0.1
 */