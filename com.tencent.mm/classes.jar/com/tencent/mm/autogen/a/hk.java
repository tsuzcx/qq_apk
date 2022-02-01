package com.tencent.mm.autogen.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class hk
  extends IEvent
{
  public a hIq;
  public b hIr;
  
  public hk()
  {
    this((byte)0);
  }
  
  private hk(byte paramByte)
  {
    AppMethodBeat.i(116028);
    this.hIq = new a();
    this.hIr = new b();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(116028);
  }
  
  public static final class a
  {
    public int state = -1;
  }
  
  public static final class b
  {
    public boolean hCQ = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.autogen.a.hk
 * JD-Core Version:    0.7.0.1
 */