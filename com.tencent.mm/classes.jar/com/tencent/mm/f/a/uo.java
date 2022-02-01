package com.tencent.mm.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class uo
  extends IEvent
{
  public a fTR;
  
  public uo()
  {
    this((byte)0);
  }
  
  private uo(byte paramByte)
  {
    AppMethodBeat.i(237359);
    this.fTR = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(237359);
  }
  
  public static final class a
  {
    public String deviceName;
    public String fTQ;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.f.a.uo
 * JD-Core Version:    0.7.0.1
 */