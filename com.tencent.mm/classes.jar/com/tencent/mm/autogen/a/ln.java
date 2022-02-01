package com.tencent.mm.autogen.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class ln
  extends IEvent
{
  public a hNp;
  public b hNq;
  
  public ln()
  {
    this((byte)0);
  }
  
  private ln(byte paramByte)
  {
    AppMethodBeat.i(130778);
    this.hNp = new a();
    this.hNq = new b();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(130778);
  }
  
  public static final class a
  {
    public int hNr = -1;
  }
  
  public static final class b
  {
    public int hNs = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.autogen.a.ln
 * JD-Core Version:    0.7.0.1
 */