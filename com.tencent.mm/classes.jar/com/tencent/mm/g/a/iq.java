package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class iq
  extends IEvent
{
  public a dNl;
  
  public iq()
  {
    this((byte)0);
  }
  
  private iq(byte paramByte)
  {
    AppMethodBeat.i(125616);
    this.dNl = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(125616);
  }
  
  public static final class a
  {
    public int scene;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.a.iq
 * JD-Core Version:    0.7.0.1
 */