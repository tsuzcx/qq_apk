package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class vc
  extends IEvent
{
  public a ebu;
  
  public vc()
  {
    this((byte)0);
  }
  
  private vc(byte paramByte)
  {
    AppMethodBeat.i(201820);
    this.ebu = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(201820);
  }
  
  public static final class a
  {
    public int ebv = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.a.vc
 * JD-Core Version:    0.7.0.1
 */