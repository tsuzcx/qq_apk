package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class uo
  extends IEvent
{
  public a eaR;
  
  public uo()
  {
    this((byte)0);
  }
  
  private uo(byte paramByte)
  {
    AppMethodBeat.i(19835);
    this.eaR = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(19835);
  }
  
  public static final class a
  {
    public String event;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.g.a.uo
 * JD-Core Version:    0.7.0.1
 */