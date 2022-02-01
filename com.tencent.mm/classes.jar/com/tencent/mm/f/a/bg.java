package com.tencent.mm.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class bg
  extends IEvent
{
  public a fwZ;
  
  public bg()
  {
    this((byte)0);
  }
  
  private bg(byte paramByte)
  {
    AppMethodBeat.i(116457);
    this.fwZ = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(116457);
  }
  
  public static final class a
  {
    public String username;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.f.a.bg
 * JD-Core Version:    0.7.0.1
 */