package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class xg
  extends IEvent
{
  public a edA;
  
  public xg()
  {
    this((byte)0);
  }
  
  private xg(byte paramByte)
  {
    AppMethodBeat.i(91220);
    this.edA = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(91220);
  }
  
  public static final class a
  {
    public boolean edB = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.g.a.xg
 * JD-Core Version:    0.7.0.1
 */