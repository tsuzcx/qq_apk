package com.tencent.mm.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class cw
  extends IEvent
{
  public a fyy;
  public b fyz;
  
  public cw()
  {
    this((byte)0);
  }
  
  private cw(byte paramByte)
  {
    AppMethodBeat.i(222439);
    this.fyy = new a();
    this.fyz = new b();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(222439);
  }
  
  public static final class a
  {
    public String path;
  }
  
  public static final class b
  {
    public String[] fyA;
    public boolean isTimeout = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.f.a.cw
 * JD-Core Version:    0.7.0.1
 */