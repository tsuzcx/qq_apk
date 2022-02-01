package com.tencent.mm.autogen.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class lr
  extends IEvent
{
  public a hNB;
  
  public lr()
  {
    this((byte)0);
  }
  
  private lr(byte paramByte)
  {
    AppMethodBeat.i(155369);
    this.hNB = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(155369);
  }
  
  public static final class a
  {
    public int scene = 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.autogen.a.lr
 * JD-Core Version:    0.7.0.1
 */