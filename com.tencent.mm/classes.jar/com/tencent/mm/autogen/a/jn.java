package com.tencent.mm.autogen.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class jn
  extends IEvent
{
  public a hLd;
  
  public jn()
  {
    this((byte)0);
  }
  
  private jn(byte paramByte)
  {
    AppMethodBeat.i(369438);
    this.hLd = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(369438);
  }
  
  public static final class a
  {
    public long feedId;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.autogen.a.jn
 * JD-Core Version:    0.7.0.1
 */