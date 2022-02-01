package com.tencent.mm.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class yb
  extends IEvent
{
  public a fXp;
  
  public yb()
  {
    this((byte)0);
  }
  
  private yb(byte paramByte)
  {
    AppMethodBeat.i(116049);
    this.fXp = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(116049);
  }
  
  public static final class a
  {
    public int status;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.f.a.yb
 * JD-Core Version:    0.7.0.1
 */