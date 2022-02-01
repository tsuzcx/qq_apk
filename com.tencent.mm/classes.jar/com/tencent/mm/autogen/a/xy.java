package com.tencent.mm.autogen.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class xy
  extends IEvent
{
  public a ibs;
  
  public xy()
  {
    this((byte)0);
  }
  
  private xy(byte paramByte)
  {
    AppMethodBeat.i(125632);
    this.ibs = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(125632);
  }
  
  public static final class a
  {
    public boolean isStart;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.autogen.a.xy
 * JD-Core Version:    0.7.0.1
 */