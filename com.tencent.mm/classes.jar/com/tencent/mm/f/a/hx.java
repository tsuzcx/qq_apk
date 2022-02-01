package com.tencent.mm.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class hx
  extends IEvent
{
  public a fEW;
  
  public hx()
  {
    this((byte)0);
  }
  
  private hx(byte paramByte)
  {
    AppMethodBeat.i(262472);
    this.fEW = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(262472);
  }
  
  public static final class a
  {
    public String fEX;
    public boolean fEY;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.f.a.hx
 * JD-Core Version:    0.7.0.1
 */