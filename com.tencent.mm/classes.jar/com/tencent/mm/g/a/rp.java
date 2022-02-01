package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class rp
  extends IEvent
{
  public a dYf;
  
  public rp()
  {
    this((byte)0);
  }
  
  private rp(byte paramByte)
  {
    AppMethodBeat.i(91216);
    this.dYf = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(91216);
  }
  
  public static final class a
  {
    public String dDM;
    public String dQp;
    public int dYg;
    public String dYh;
    public int dYi;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.g.a.rp
 * JD-Core Version:    0.7.0.1
 */