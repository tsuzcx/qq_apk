package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.sdk.b.b;

public final class do
  extends b
{
  public a dps;
  public b dpt;
  
  public do()
  {
    this((byte)0);
  }
  
  private do(byte paramByte)
  {
    AppMethodBeat.i(115975);
    this.dps = new a();
    this.dpt = new b();
    this.IvZ = false;
    this.callback = null;
    AppMethodBeat.o(115975);
  }
  
  public static final class a
  {
    public String dpu;
    public int dpv = 0;
    public n dpw;
    public int opType = 0;
  }
  
  public static final class b
  {
    public n dpw;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.a.do
 * JD-Core Version:    0.7.0.1
 */