package com.tencent.mm.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class lh
  extends IEvent
{
  public a fJa;
  
  public lh()
  {
    this((byte)0);
  }
  
  private lh(byte paramByte)
  {
    AppMethodBeat.i(121033);
    this.fJa = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(121033);
  }
  
  public static final class a
  {
    public String fIY;
    public String sessionId;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.f.a.lh
 * JD-Core Version:    0.7.0.1
 */