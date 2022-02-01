package com.tencent.mm.autogen.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class aak
  extends IEvent
{
  public a idR;
  
  public aak()
  {
    this((byte)0);
  }
  
  private aak(byte paramByte)
  {
    AppMethodBeat.i(131795);
    this.idR = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(131795);
  }
  
  public static final class a
  {
    public int status = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.autogen.a.aak
 * JD-Core Version:    0.7.0.1
 */