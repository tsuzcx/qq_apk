package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class wf
  extends IEvent
{
  public a ecp;
  
  public wf()
  {
    this((byte)0);
  }
  
  private wf(byte paramByte)
  {
    AppMethodBeat.i(131794);
    this.ecp = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(131794);
  }
  
  public static final class a
  {
    public int sourceType = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.a.wf
 * JD-Core Version:    0.7.0.1
 */