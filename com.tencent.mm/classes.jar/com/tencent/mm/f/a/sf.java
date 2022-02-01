package com.tencent.mm.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class sf
  extends IEvent
{
  public a fRM;
  
  public sf()
  {
    this((byte)0);
  }
  
  private sf(byte paramByte)
  {
    AppMethodBeat.i(19826);
    this.fRM = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(19826);
  }
  
  public static final class a
  {
    public int action;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.f.a.sf
 * JD-Core Version:    0.7.0.1
 */