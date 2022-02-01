package com.tencent.mm.autogen.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class ep
  extends IEvent
{
  public a hEC;
  public b hED;
  
  public ep()
  {
    this((byte)0);
  }
  
  private ep(byte paramByte)
  {
    AppMethodBeat.i(115982);
    this.hEC = new a();
    this.hED = new b();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(115982);
  }
  
  public static final class a
  {
    public String hEE;
    public String hEl;
  }
  
  public static final class b
  {
    public boolean hEn;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.autogen.a.ep
 * JD-Core Version:    0.7.0.1
 */