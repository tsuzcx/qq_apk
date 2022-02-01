package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class ik
  extends IEvent
{
  public a dNb;
  
  public ik()
  {
    this((byte)0);
  }
  
  private ik(byte paramByte)
  {
    AppMethodBeat.i(208813);
    this.dNb = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(208813);
  }
  
  public static final class a
  {
    public String dNc;
    public int opType;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.a.ik
 * JD-Core Version:    0.7.0.1
 */