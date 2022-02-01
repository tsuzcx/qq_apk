package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class w
  extends IEvent
{
  public a dCO;
  
  public w()
  {
    this((byte)0);
  }
  
  private w(byte paramByte)
  {
    AppMethodBeat.i(149848);
    this.dCO = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(149848);
  }
  
  public static final class a
  {
    public boolean dCP = false;
    public int scene;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.a.w
 * JD-Core Version:    0.7.0.1
 */