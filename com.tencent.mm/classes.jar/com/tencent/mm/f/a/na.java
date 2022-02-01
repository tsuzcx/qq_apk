package com.tencent.mm.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class na
  extends IEvent
{
  public a fLg;
  
  public na()
  {
    this((byte)0);
  }
  
  private na(byte paramByte)
  {
    AppMethodBeat.i(19819);
    this.fLg = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(19819);
  }
  
  public static final class a
  {
    public boolean eYG;
    public long progress;
    public long total;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.f.a.na
 * JD-Core Version:    0.7.0.1
 */