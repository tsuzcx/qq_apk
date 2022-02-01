package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.storage.bv;

public final class sa
  extends b
{
  public a dHE;
  
  public sa()
  {
    this((byte)0);
  }
  
  private sa(byte paramByte)
  {
    AppMethodBeat.i(94799);
    this.dHE = new a();
    this.IvZ = false;
    this.callback = null;
    AppMethodBeat.o(94799);
  }
  
  public static final class a
  {
    public bv dCi;
    public String dHF;
    public bv dHG;
    public long dHH = 0L;
    public long msgId = 0L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.a.sa
 * JD-Core Version:    0.7.0.1
 */