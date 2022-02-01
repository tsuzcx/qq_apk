package com.tencent.mm.autogen.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class aac
  extends IEvent
{
  public a idI;
  
  public aac()
  {
    this((byte)0);
  }
  
  private aac(byte paramByte)
  {
    AppMethodBeat.i(118480);
    this.idI = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(118480);
  }
  
  public static final class a
  {
    public int state = -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.autogen.a.aac
 * JD-Core Version:    0.7.0.1
 */