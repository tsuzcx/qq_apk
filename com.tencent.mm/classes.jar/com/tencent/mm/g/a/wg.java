package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class wg
  extends IEvent
{
  public a ecq;
  
  public wg()
  {
    this((byte)0);
  }
  
  private wg(byte paramByte)
  {
    AppMethodBeat.i(192721);
    this.ecq = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(192721);
  }
  
  public static final class a
  {
    public int state;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.a.wg
 * JD-Core Version:    0.7.0.1
 */