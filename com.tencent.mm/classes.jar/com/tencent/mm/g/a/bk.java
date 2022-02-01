package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class bk
  extends IEvent
{
  public a dED;
  public b dEE;
  
  public bk()
  {
    this((byte)0);
  }
  
  private bk(byte paramByte)
  {
    AppMethodBeat.i(117354);
    this.dED = new a();
    this.dEE = new b();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(117354);
  }
  
  public static final class a {}
  
  public static final class b
  {
    public boolean dEF;
    public String msg;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.g.a.bk
 * JD-Core Version:    0.7.0.1
 */