package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class on
  extends IEvent
{
  public a dUC;
  
  public on()
  {
    this((byte)0);
  }
  
  private on(byte paramByte)
  {
    AppMethodBeat.i(130780);
    this.dUC = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(130780);
  }
  
  public static final class a
  {
    public int errCode = 0;
    public String errMsg;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.g.a.on
 * JD-Core Version:    0.7.0.1
 */