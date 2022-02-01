package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class aai
  extends IEvent
{
  public a ehf;
  
  public aai()
  {
    this((byte)0);
  }
  
  private aai(byte paramByte)
  {
    AppMethodBeat.i(91233);
    this.ehf = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(91233);
  }
  
  public static final class a
  {
    public int result;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.a.aai
 * JD-Core Version:    0.7.0.1
 */