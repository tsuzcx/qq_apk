package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class wq
  extends IEvent
{
  public wq.a ecI;
  public b ecJ;
  
  public wq()
  {
    this((byte)0);
  }
  
  private wq(byte paramByte)
  {
    AppMethodBeat.i(153187);
    this.ecI = new wq.a();
    this.ecJ = new b();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(153187);
  }
  
  public static final class b
  {
    public boolean edc;
    public String edd;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.a.wq
 * JD-Core Version:    0.7.0.1
 */