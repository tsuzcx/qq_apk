package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class gx
  extends IEvent
{
  public a dLa;
  
  public gx()
  {
    this((byte)0);
  }
  
  private gx(byte paramByte)
  {
    AppMethodBeat.i(19809);
    this.dLa = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(19809);
  }
  
  public static final class a
  {
    public Object dDg;
    public long dFW;
    public String dLb;
    public int dLc;
    public Object dLd;
    public String dLe;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.g.a.gx
 * JD-Core Version:    0.7.0.1
 */