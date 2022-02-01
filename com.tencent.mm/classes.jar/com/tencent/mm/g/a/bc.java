package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class bc
  extends IEvent
{
  public a dEl;
  
  public bc()
  {
    this((byte)0);
  }
  
  private bc(byte paramByte)
  {
    AppMethodBeat.i(116457);
    this.dEl = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(116457);
  }
  
  public static final class a
  {
    public String username;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.g.a.bc
 * JD-Core Version:    0.7.0.1
 */