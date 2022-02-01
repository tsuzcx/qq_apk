package com.tencent.mm.autogen.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class os
  extends IEvent
{
  public a hRy;
  public b hRz;
  
  public os()
  {
    this((byte)0);
  }
  
  private os(byte paramByte)
  {
    AppMethodBeat.i(149873);
    this.hRy = new a();
    this.hRz = new b();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(149873);
  }
  
  public static final class a
  {
    public int action;
  }
  
  public static final class b
  {
    public boolean isStart;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.autogen.a.os
 * JD-Core Version:    0.7.0.1
 */