package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class sn
  extends IEvent
{
  public a dZd;
  
  public sn()
  {
    this((byte)0);
  }
  
  private sn(byte paramByte)
  {
    AppMethodBeat.i(116046);
    this.dZd = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(116046);
  }
  
  public static final class a
  {
    public int dZe = -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.a.sn
 * JD-Core Version:    0.7.0.1
 */