package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class aba
  extends IEvent
{
  public a eim;
  
  public aba()
  {
    this((byte)0);
  }
  
  private aba(byte paramByte)
  {
    AppMethodBeat.i(117553);
    this.eim = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(117553);
  }
  
  public static final class a
  {
    public String dNk;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.a.aba
 * JD-Core Version:    0.7.0.1
 */