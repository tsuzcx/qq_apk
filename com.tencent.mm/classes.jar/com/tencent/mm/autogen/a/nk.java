package com.tencent.mm.autogen.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class nk
  extends IEvent
{
  public a hPM;
  
  public nk()
  {
    this((byte)0);
  }
  
  private nk(byte paramByte)
  {
    AppMethodBeat.i(369371);
    this.hPM = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(369371);
  }
  
  public static final class a
  {
    public String content;
    public long hPN;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.autogen.a.nk
 * JD-Core Version:    0.7.0.1
 */