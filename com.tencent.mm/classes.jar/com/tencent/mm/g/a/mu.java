package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class mu
  extends IEvent
{
  public a dSs;
  public b dSt;
  
  public mu()
  {
    this((byte)0);
  }
  
  private mu(byte paramByte)
  {
    AppMethodBeat.i(149873);
    this.dSs = new a();
    this.dSt = new b();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.g.a.mu
 * JD-Core Version:    0.7.0.1
 */