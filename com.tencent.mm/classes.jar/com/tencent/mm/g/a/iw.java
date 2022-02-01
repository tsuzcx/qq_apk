package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class iw
  extends IEvent
{
  public a dNy;
  public b dNz;
  
  public iw()
  {
    this((byte)0);
  }
  
  private iw(byte paramByte)
  {
    AppMethodBeat.i(89643);
    this.dNy = new a();
    this.dNz = new b();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(89643);
  }
  
  public static final class a
  {
    public int EX = 0;
    public String param;
  }
  
  public static final class b
  {
    public String dNA;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.a.iw
 * JD-Core Version:    0.7.0.1
 */