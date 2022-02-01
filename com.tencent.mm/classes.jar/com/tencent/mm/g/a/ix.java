package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class ix
  extends IEvent
{
  public a dNB;
  
  public ix()
  {
    this((byte)0);
  }
  
  private ix(byte paramByte)
  {
    AppMethodBeat.i(201272);
    this.dNB = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(201272);
  }
  
  public static final class a
  {
    public String event;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.g.a.ix
 * JD-Core Version:    0.7.0.1
 */