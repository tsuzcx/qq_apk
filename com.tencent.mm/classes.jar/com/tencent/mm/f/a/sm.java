package com.tencent.mm.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class sm
  extends IEvent
{
  public a fRU;
  
  public sm()
  {
    this((byte)0);
  }
  
  private sm(byte paramByte)
  {
    AppMethodBeat.i(63291);
    this.fRU = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(63291);
  }
  
  public static final class a
  {
    public int fRV = 0;
    public boolean fzO = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.f.a.sm
 * JD-Core Version:    0.7.0.1
 */