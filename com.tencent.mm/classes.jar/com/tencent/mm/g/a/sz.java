package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class sz
  extends IEvent
{
  public a dZv;
  
  public sz()
  {
    this((byte)0);
  }
  
  private sz(byte paramByte)
  {
    AppMethodBeat.i(192279);
    this.dZv = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(192279);
  }
  
  public static final class a
  {
    public String info;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.g.a.sz
 * JD-Core Version:    0.7.0.1
 */