package com.tencent.mm.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class ch
  extends IEvent
{
  public a fxV;
  
  public ch()
  {
    this((byte)0);
  }
  
  private ch(byte paramByte)
  {
    AppMethodBeat.i(91200);
    this.fxV = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(91200);
  }
  
  public static final class a
  {
    public String fxS;
    public String fxT;
    public long fxU;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.f.a.ch
 * JD-Core Version:    0.7.0.1
 */