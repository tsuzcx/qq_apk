package com.tencent.mm.autogen.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class acr
  extends IEvent
{
  public a igb;
  
  public acr()
  {
    this((byte)0);
  }
  
  private acr(byte paramByte)
  {
    AppMethodBeat.i(369433);
    this.igb = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(369433);
  }
  
  public static final class a
  {
    public int mode = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.autogen.a.acr
 * JD-Core Version:    0.7.0.1
 */