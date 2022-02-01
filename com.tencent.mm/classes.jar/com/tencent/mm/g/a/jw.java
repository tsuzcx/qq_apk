package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class jw
  extends IEvent
{
  public a dOP;
  
  public jw()
  {
    this((byte)0);
  }
  
  private jw(byte paramByte)
  {
    AppMethodBeat.i(149864);
    this.dOP = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(149864);
  }
  
  public static final class a
  {
    public String url;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.a.jw
 * JD-Core Version:    0.7.0.1
 */