package com.tencent.mm.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class to
  extends IEvent
{
  public a fSW;
  
  public to()
  {
    this((byte)0);
  }
  
  private to(byte paramByte)
  {
    AppMethodBeat.i(116046);
    this.fSW = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(116046);
  }
  
  public static final class a
  {
    public int fSX = -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.f.a.to
 * JD-Core Version:    0.7.0.1
 */