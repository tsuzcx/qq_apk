package com.tencent.mm.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class xl
  extends IEvent
{
  public a fWs;
  
  public xl()
  {
    this((byte)0);
  }
  
  private xl(byte paramByte)
  {
    AppMethodBeat.i(261589);
    this.fWs = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(261589);
  }
  
  public static final class a
  {
    public int state;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.f.a.xl
 * JD-Core Version:    0.7.0.1
 */