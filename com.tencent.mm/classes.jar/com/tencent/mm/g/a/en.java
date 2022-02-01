package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class en
  extends IEvent
{
  public a dHU;
  
  public en()
  {
    this((byte)0);
  }
  
  private en(byte paramByte)
  {
    AppMethodBeat.i(115997);
    this.dHU = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(115997);
  }
  
  public static final class a
  {
    public int op = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.a.en
 * JD-Core Version:    0.7.0.1
 */