package com.tencent.mm.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class bz
  extends IEvent
{
  public a fxN;
  
  public bz()
  {
    this((byte)0);
  }
  
  private bz(byte paramByte)
  {
    AppMethodBeat.i(114791);
    this.fxN = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(114791);
  }
  
  public static final class a
  {
    public boolean isStarted = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.f.a.bz
 * JD-Core Version:    0.7.0.1
 */