package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class aaw
  extends IEvent
{
  public a ehM;
  
  public aaw()
  {
    this((byte)0);
  }
  
  private aaw(byte paramByte)
  {
    AppMethodBeat.i(91237);
    this.ehM = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(91237);
  }
  
  public static final class a
  {
    public int result = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.a.aaw
 * JD-Core Version:    0.7.0.1
 */