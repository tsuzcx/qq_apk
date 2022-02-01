package com.tencent.mm.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class aci
  extends IEvent
{
  public a gcD;
  
  public aci()
  {
    this((byte)0);
  }
  
  private aci(byte paramByte)
  {
    AppMethodBeat.i(117553);
    this.gcD = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(117553);
  }
  
  public static final class a
  {
    public String fGw;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.f.a.aci
 * JD-Core Version:    0.7.0.1
 */