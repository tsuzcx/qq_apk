package com.tencent.mm.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class im
  extends IEvent
{
  public a fFG;
  
  public im()
  {
    this((byte)0);
  }
  
  private im(byte paramByte)
  {
    AppMethodBeat.i(245637);
    this.fFG = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(245637);
  }
  
  public static final class a
  {
    public long id;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.f.a.im
 * JD-Core Version:    0.7.0.1
 */