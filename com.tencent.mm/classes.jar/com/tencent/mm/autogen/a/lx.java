package com.tencent.mm.autogen.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class lx
  extends IEvent
{
  public a hNO;
  
  public lx()
  {
    this((byte)0);
  }
  
  private lx(byte paramByte)
  {
    AppMethodBeat.i(125619);
    this.hNO = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(125619);
  }
  
  public static final class a
  {
    public boolean isResume = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.autogen.a.lx
 * JD-Core Version:    0.7.0.1
 */