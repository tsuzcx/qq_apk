package com.tencent.mm.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class hl
  extends IEvent
{
  public a fEv;
  
  public hl()
  {
    this((byte)0);
  }
  
  private hl(byte paramByte)
  {
    AppMethodBeat.i(292055);
    this.fEv = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(292055);
  }
  
  public static final class a
  {
    public boolean fEw;
    public long feedId;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.f.a.hl
 * JD-Core Version:    0.7.0.1
 */