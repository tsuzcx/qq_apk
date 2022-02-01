package com.tencent.mm.autogen.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class aap
  extends IEvent
{
  public a iee;
  
  public aap()
  {
    this((byte)0);
  }
  
  private aap(byte paramByte)
  {
    AppMethodBeat.i(19841);
    this.iee = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(19841);
  }
  
  public static final class a
  {
    public boolean ief = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.autogen.a.aap
 * JD-Core Version:    0.7.0.1
 */