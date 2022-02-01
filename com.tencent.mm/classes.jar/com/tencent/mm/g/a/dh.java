package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.b.b;

public final class dh
  extends b
{
  public a dcK;
  public b dcL;
  
  public dh()
  {
    this((byte)0);
  }
  
  private dh(byte paramByte)
  {
    AppMethodBeat.i(104415);
    this.dcK = new a();
    this.dcL = new b();
    this.Gqe = false;
    this.callback = null;
    AppMethodBeat.o(104415);
  }
  
  public static final class a
  {
    public int type;
  }
  
  public static final class b
  {
    public boolean dcM;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.g.a.dh
 * JD-Core Version:    0.7.0.1
 */