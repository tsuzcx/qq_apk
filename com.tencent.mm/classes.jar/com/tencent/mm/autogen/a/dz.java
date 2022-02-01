package com.tencent.mm.autogen.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class dz
  extends IEvent
{
  public a hDP;
  
  public dz()
  {
    this((byte)0);
  }
  
  private dz(byte paramByte)
  {
    AppMethodBeat.i(104413);
    this.hDP = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(104413);
  }
  
  public static final class a
  {
    public boolean enable;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.autogen.a.dz
 * JD-Core Version:    0.7.0.1
 */