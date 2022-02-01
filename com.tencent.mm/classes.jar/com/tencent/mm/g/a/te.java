package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class te
  extends IEvent
{
  public a dZD;
  public b dZE;
  
  public te()
  {
    this((byte)0);
  }
  
  private te(byte paramByte)
  {
    AppMethodBeat.i(19833);
    this.dZD = new a();
    this.dZE = new b();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(19833);
  }
  
  public static final class a
  {
    public String userName;
  }
  
  public static final class b {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.g.a.te
 * JD-Core Version:    0.7.0.1
 */