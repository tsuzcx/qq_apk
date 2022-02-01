package com.tencent.mm.autogen.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class vn
  extends IEvent
{
  public a hZk;
  
  public vn()
  {
    this((byte)0);
  }
  
  private vn(byte paramByte)
  {
    AppMethodBeat.i(94800);
    this.hZk = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(94800);
  }
  
  public static final class a
  {
    public long msgId = 0L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.autogen.a.vn
 * JD-Core Version:    0.7.0.1
 */