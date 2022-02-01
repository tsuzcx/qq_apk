package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class up
  extends IEvent
{
  public a eaS;
  
  public up()
  {
    this((byte)0);
  }
  
  private up(byte paramByte)
  {
    AppMethodBeat.i(93328);
    this.eaS = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(93328);
  }
  
  public static final class a
  {
    public long dFm;
    public String dPu;
    public String dPv;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.g.a.up
 * JD-Core Version:    0.7.0.1
 */