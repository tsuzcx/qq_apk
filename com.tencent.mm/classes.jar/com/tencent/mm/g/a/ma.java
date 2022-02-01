package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class ma
  extends IEvent
{
  public a dRA;
  
  public ma()
  {
    this((byte)0);
  }
  
  private ma(byte paramByte)
  {
    AppMethodBeat.i(116031);
    this.dRA = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(116031);
  }
  
  public static final class a
  {
    public int bDZ = 0;
    public int status = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.g.a.ma
 * JD-Core Version:    0.7.0.1
 */