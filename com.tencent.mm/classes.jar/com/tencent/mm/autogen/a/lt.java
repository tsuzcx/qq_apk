package com.tencent.mm.autogen.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class lt
  extends IEvent
{
  public a hNE;
  public b hNF;
  
  public lt()
  {
    this((byte)0);
  }
  
  private lt(byte paramByte)
  {
    AppMethodBeat.i(149865);
    this.hNE = new a();
    this.hNF = new b();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(149865);
  }
  
  public static final class a
  {
    public String userName;
  }
  
  public static final class b {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.autogen.a.lt
 * JD-Core Version:    0.7.0.1
 */