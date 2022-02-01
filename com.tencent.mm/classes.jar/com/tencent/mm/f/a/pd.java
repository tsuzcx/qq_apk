package com.tencent.mm.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class pd
  extends IEvent
{
  public a fNX;
  
  public pd()
  {
    this((byte)0);
  }
  
  private pd(byte paramByte)
  {
    AppMethodBeat.i(183832);
    this.fNX = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(183832);
  }
  
  public static final class a
  {
    public String fJD;
    public int scene;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.f.a.pd
 * JD-Core Version:    0.7.0.1
 */