package com.tencent.mm.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class cx
  extends IEvent
{
  public a fyB;
  
  public cx()
  {
    this((byte)0);
  }
  
  private cx(byte paramByte)
  {
    AppMethodBeat.i(127400);
    this.fyB = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(127400);
  }
  
  public static final class a
  {
    public long localId = -1L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.f.a.cx
 * JD-Core Version:    0.7.0.1
 */