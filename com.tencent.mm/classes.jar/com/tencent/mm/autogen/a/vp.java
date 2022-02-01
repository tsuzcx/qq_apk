package com.tencent.mm.autogen.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class vp
  extends IEvent
{
  public a hZl;
  
  public vp()
  {
    this((byte)0);
  }
  
  private vp(byte paramByte)
  {
    AppMethodBeat.i(102633);
    this.hZl = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(102633);
  }
  
  public static final class a
  {
    public long msgId;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.autogen.a.vp
 * JD-Core Version:    0.7.0.1
 */