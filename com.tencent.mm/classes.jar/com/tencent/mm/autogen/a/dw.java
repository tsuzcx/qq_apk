package com.tencent.mm.autogen.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class dw
  extends IEvent
{
  public a hDL;
  
  public dw()
  {
    this((byte)0);
  }
  
  private dw(byte paramByte)
  {
    AppMethodBeat.i(104410);
    this.hDL = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(104410);
  }
  
  public static final class a
  {
    public int subType = 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.autogen.a.dw
 * JD-Core Version:    0.7.0.1
 */