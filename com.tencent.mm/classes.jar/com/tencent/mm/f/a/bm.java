package com.tencent.mm.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class bm
  extends IEvent
{
  public a fxk;
  
  public bm()
  {
    this((byte)0);
  }
  
  private bm(byte paramByte)
  {
    AppMethodBeat.i(155365);
    this.fxk = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(155365);
  }
  
  public static final class a
  {
    public boolean result = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.f.a.bm
 * JD-Core Version:    0.7.0.1
 */