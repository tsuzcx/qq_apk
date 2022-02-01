package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class do
  extends IEvent
{
  public b dGA;
  public a dGz;
  
  public do()
  {
    this((byte)0);
  }
  
  private do(byte paramByte)
  {
    AppMethodBeat.i(104415);
    this.dGz = new a();
    this.dGA = new b();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(104415);
  }
  
  public static final class a
  {
    public int type;
  }
  
  public static final class b
  {
    public boolean dGB;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.g.a.do
 * JD-Core Version:    0.7.0.1
 */