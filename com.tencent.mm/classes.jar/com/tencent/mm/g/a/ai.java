package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class ai
  extends IEvent
{
  public a dDh;
  
  public ai()
  {
    this((byte)0);
  }
  
  private ai(byte paramByte)
  {
    AppMethodBeat.i(19403);
    this.dDh = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(19403);
  }
  
  public static final class a
  {
    public String dDi;
    public String dDj;
    public String dDk;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.g.a.ai
 * JD-Core Version:    0.7.0.1
 */