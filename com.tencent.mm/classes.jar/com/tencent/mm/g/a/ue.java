package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class ue
  extends IEvent
{
  public a eaA;
  
  public ue()
  {
    this((byte)0);
  }
  
  private ue(byte paramByte)
  {
    AppMethodBeat.i(194251);
    this.eaA = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(194251);
  }
  
  public static final class a
  {
    public String dNA;
    public long eaB;
    public Boolean eaz;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.a.ue
 * JD-Core Version:    0.7.0.1
 */