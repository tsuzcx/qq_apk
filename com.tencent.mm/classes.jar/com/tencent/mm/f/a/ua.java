package com.tencent.mm.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class ua
  extends IEvent
{
  public a fTo;
  
  public ua()
  {
    this((byte)0);
  }
  
  private ua(byte paramByte)
  {
    AppMethodBeat.i(240925);
    this.fTo = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(240925);
  }
  
  public static final class a
  {
    public String fTp;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.f.a.ua
 * JD-Core Version:    0.7.0.1
 */