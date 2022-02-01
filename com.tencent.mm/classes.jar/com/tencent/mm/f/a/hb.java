package com.tencent.mm.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class hb
  extends IEvent
{
  public a fDE;
  
  public hb()
  {
    this((byte)0);
  }
  
  private hb(byte paramByte)
  {
    AppMethodBeat.i(19808);
    this.fDE = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(19808);
  }
  
  public static final class a
  {
    public boolean isActive;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.f.a.hb
 * JD-Core Version:    0.7.0.1
 */