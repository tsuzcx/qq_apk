package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class aas
  extends IEvent
{
  public a ehH;
  
  public aas()
  {
    this((byte)0);
  }
  
  private aas(byte paramByte)
  {
    AppMethodBeat.i(117616);
    this.ehH = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(117616);
  }
  
  public static final class a
  {
    public int result;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.g.a.aas
 * JD-Core Version:    0.7.0.1
 */