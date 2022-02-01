package com.tencent.mm.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class jn
  extends IEvent
{
  public a fGN;
  
  public jn()
  {
    this((byte)0);
  }
  
  private jn(byte paramByte)
  {
    AppMethodBeat.i(215412);
    this.fGN = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(215412);
  }
  
  public static final class a
  {
    public String event;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.f.a.jn
 * JD-Core Version:    0.7.0.1
 */