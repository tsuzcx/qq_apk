package com.tencent.mm.autogen.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class bz
  extends IEvent
{
  public a hBZ;
  
  public bz()
  {
    this((byte)0);
  }
  
  private bz(byte paramByte)
  {
    AppMethodBeat.i(114790);
    this.hBZ = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(114790);
  }
  
  public static final class a
  {
    public boolean isStarted = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.autogen.a.bz
 * JD-Core Version:    0.7.0.1
 */