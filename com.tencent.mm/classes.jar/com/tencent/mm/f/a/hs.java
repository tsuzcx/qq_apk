package com.tencent.mm.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class hs
  extends IEvent
{
  public a fEJ;
  
  public hs()
  {
    this((byte)0);
  }
  
  private hs(byte paramByte)
  {
    AppMethodBeat.i(273383);
    this.fEJ = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(273383);
  }
  
  public static final class a
  {
    public long feedId;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.f.a.hs
 * JD-Core Version:    0.7.0.1
 */