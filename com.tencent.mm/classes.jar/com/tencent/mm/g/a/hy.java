package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class hy
  extends IEvent
{
  public a dMA;
  
  public hy()
  {
    this((byte)0);
  }
  
  private hy(byte paramByte)
  {
    AppMethodBeat.i(208804);
    this.dMA = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(208804);
  }
  
  public static final class a
  {
    public double lat;
    public double lng;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.a.hy
 * JD-Core Version:    0.7.0.1
 */