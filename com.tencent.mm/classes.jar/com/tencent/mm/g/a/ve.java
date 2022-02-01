package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class ve
  extends IEvent
{
  public a ebB;
  
  public ve()
  {
    this((byte)0);
  }
  
  private ve(byte paramByte)
  {
    AppMethodBeat.i(201822);
    this.ebB = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(201822);
  }
  
  public static final class a
  {
    public int ebC = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.a.ve
 * JD-Core Version:    0.7.0.1
 */