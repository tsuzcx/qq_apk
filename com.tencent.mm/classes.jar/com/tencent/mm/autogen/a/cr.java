package com.tencent.mm.autogen.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class cr
  extends IEvent
{
  public a hCB;
  public b hCC;
  
  public cr()
  {
    this((byte)0);
  }
  
  private cr(byte paramByte)
  {
    AppMethodBeat.i(140934);
    this.hCB = new a();
    this.hCC = new b();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(140934);
  }
  
  public static final class a
  {
    public int hCD = 0;
  }
  
  public static final class b
  {
    public int retCode = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.autogen.a.cr
 * JD-Core Version:    0.7.0.1
 */