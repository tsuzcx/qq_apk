package com.tencent.mm.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class ao
  extends IEvent
{
  public a fvX;
  
  public ao()
  {
    this((byte)0);
  }
  
  private ao(byte paramByte)
  {
    AppMethodBeat.i(5530);
    this.fvX = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(5530);
  }
  
  public static final class a
  {
    public String userName;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.f.a.ao
 * JD-Core Version:    0.7.0.1
 */