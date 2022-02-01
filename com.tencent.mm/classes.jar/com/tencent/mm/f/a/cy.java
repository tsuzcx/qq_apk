package com.tencent.mm.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class cy
  extends IEvent
{
  public a fyC;
  public b fyD;
  
  public cy()
  {
    this((byte)0);
  }
  
  private cy(byte paramByte)
  {
    AppMethodBeat.i(127401);
    this.fyC = new a();
    this.fyD = new b();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(127401);
  }
  
  public static final class a
  {
    public long fyE = 0L;
  }
  
  public static final class b
  {
    public boolean fyl = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.f.a.cy
 * JD-Core Version:    0.7.0.1
 */