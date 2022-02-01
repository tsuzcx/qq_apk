package com.tencent.mm.autogen.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class aai
  extends IEvent
{
  public a idM;
  
  public aai()
  {
    this((byte)0);
  }
  
  private aai(byte paramByte)
  {
    AppMethodBeat.i(149890);
    this.idM = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(149890);
  }
  
  public static final class a
  {
    public String eventId;
    public int hHC = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.autogen.a.aai
 * JD-Core Version:    0.7.0.1
 */