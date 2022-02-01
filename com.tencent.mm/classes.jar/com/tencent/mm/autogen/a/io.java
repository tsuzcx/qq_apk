package com.tencent.mm.autogen.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class io
  extends IEvent
{
  public a hKb;
  
  public io()
  {
    this((byte)0);
  }
  
  private io(byte paramByte)
  {
    AppMethodBeat.i(369412);
    this.hKb = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(369412);
  }
  
  public static final class a
  {
    public int action;
    public long commentId;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.autogen.a.io
 * JD-Core Version:    0.7.0.1
 */