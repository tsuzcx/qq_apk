package com.tencent.mm.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class dd
  extends IEvent
{
  public dd.a fyI;
  public b fyJ;
  
  public dd()
  {
    this((byte)0);
  }
  
  private dd(byte paramByte)
  {
    AppMethodBeat.i(127402);
    this.fyI = new dd.a();
    this.fyJ = new b();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(127402);
  }
  
  public static final class b
  {
    public int ret = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.f.a.dd
 * JD-Core Version:    0.7.0.1
 */