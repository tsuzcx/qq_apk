package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class aay
  extends IEvent
{
  public a eid;
  
  public aay()
  {
    this((byte)0);
  }
  
  private aay(byte paramByte)
  {
    AppMethodBeat.i(116061);
    this.eid = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(116061);
  }
  
  public static final class a
  {
    public int eie;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.a.aay
 * JD-Core Version:    0.7.0.1
 */