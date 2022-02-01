package com.tencent.mm.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class bh
  extends IEvent
{
  public a fxa;
  
  public bh()
  {
    this((byte)0);
  }
  
  private bh(byte paramByte)
  {
    AppMethodBeat.i(116458);
    this.fxa = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(116458);
  }
  
  public static final class a
  {
    public String fxb;
    public String username;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.f.a.bh
 * JD-Core Version:    0.7.0.1
 */