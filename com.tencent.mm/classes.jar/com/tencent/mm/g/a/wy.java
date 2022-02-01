package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class wy
  extends IEvent
{
  public a edp;
  
  public wy()
  {
    this((byte)0);
  }
  
  private wy(byte paramByte)
  {
    AppMethodBeat.i(116050);
    this.edp = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(116050);
  }
  
  public static final class a
  {
    public int dJY;
    public String edq;
    public long edr;
    public String eds;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.a.wy
 * JD-Core Version:    0.7.0.1
 */