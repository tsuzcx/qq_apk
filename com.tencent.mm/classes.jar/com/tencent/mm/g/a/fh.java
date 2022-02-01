package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class fh
  extends IEvent
{
  public a dIE;
  public b dIF;
  
  public fh()
  {
    this((byte)0);
  }
  
  private fh(byte paramByte)
  {
    AppMethodBeat.i(19800);
    this.dIE = new a();
    this.dIF = new b();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(19800);
  }
  
  public static final class a
  {
    public boolean dGW = false;
  }
  
  public static final class b
  {
    public boolean dGX;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.g.a.fh
 * JD-Core Version:    0.7.0.1
 */