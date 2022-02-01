package com.tencent.mm.autogen.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class ld
  extends IEvent
{
  public a hMP;
  
  public ld()
  {
    this((byte)0);
  }
  
  private ld(byte paramByte)
  {
    AppMethodBeat.i(19812);
    this.hMP = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(19812);
  }
  
  public static final class a
  {
    public long hMQ;
    public long hMR;
    public long hMS;
    public long hMT;
    public String username;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.autogen.a.ld
 * JD-Core Version:    0.7.0.1
 */