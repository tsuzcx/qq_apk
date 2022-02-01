package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class br
  extends IEvent
{
  public a dEV;
  
  public br()
  {
    this((byte)0);
  }
  
  private br(byte paramByte)
  {
    AppMethodBeat.i(149857);
    this.dEV = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(149857);
  }
  
  public static final class a
  {
    public int dDe = -1;
    public int dEO;
    public boolean dEU;
    public int subType;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.a.br
 * JD-Core Version:    0.7.0.1
 */