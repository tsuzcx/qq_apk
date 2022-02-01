package com.tencent.mm.autogen.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class bg
  extends IEvent
{
  public a hBl;
  
  public bg()
  {
    this((byte)0);
  }
  
  private bg(byte paramByte)
  {
    AppMethodBeat.i(120830);
    this.hBl = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(120830);
  }
  
  public static final class a
  {
    public int hBm;
    public int scene = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.autogen.a.bg
 * JD-Core Version:    0.7.0.1
 */