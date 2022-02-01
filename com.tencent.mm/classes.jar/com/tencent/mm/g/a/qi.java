package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class qi
  extends IEvent
{
  public a dWH;
  public b dWI;
  
  public qi()
  {
    this((byte)0);
  }
  
  private qi(byte paramByte)
  {
    AppMethodBeat.i(149881);
    this.dWH = new a();
    this.dWI = new b();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(149881);
  }
  
  public static final class a
  {
    public String dWJ;
  }
  
  public static final class b
  {
    public int ret = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.g.a.qi
 * JD-Core Version:    0.7.0.1
 */