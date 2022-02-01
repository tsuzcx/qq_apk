package com.tencent.mm.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class rp
  extends IEvent
{
  public a fQO;
  
  public rp()
  {
    this((byte)0);
  }
  
  private rp(byte paramByte)
  {
    AppMethodBeat.i(91212);
    this.fQO = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(91212);
  }
  
  public static final class a
  {
    public long fQP;
    public String fQs;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.f.a.rp
 * JD-Core Version:    0.7.0.1
 */