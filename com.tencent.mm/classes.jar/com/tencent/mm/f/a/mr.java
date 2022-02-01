package com.tencent.mm.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class mr
  extends IEvent
{
  public a fKQ;
  
  public mr()
  {
    this((byte)0);
  }
  
  private mr(byte paramByte)
  {
    AppMethodBeat.i(116031);
    this.fKQ = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(116031);
  }
  
  public static final class a
  {
    public int bnA = 0;
    public int status = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.f.a.mr
 * JD-Core Version:    0.7.0.1
 */