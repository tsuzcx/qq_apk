package com.tencent.mm.autogen.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class acf
  extends IEvent
{
  public a ifI;
  
  public acf()
  {
    this((byte)0);
  }
  
  private acf(byte paramByte)
  {
    AppMethodBeat.i(369425);
    this.ifI = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(369425);
  }
  
  public static final class a
  {
    public boolean ifJ;
    public long msgId;
    public boolean success;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.autogen.a.acf
 * JD-Core Version:    0.7.0.1
 */