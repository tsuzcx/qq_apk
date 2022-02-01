package com.tencent.mm.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class dw
  extends IEvent
{
  public a fzq;
  
  public dw()
  {
    this((byte)0);
  }
  
  private dw(byte paramByte)
  {
    AppMethodBeat.i(240931);
    this.fzq = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(240931);
  }
  
  public static final class a
  {
    public String fzr;
    public long fzs;
    public long fzt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.f.a.dw
 * JD-Core Version:    0.7.0.1
 */