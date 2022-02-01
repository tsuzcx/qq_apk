package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class tu
  extends IEvent
{
  public a eao;
  
  public tu()
  {
    this((byte)0);
  }
  
  private tu(byte paramByte)
  {
    AppMethodBeat.i(110507);
    this.eao = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(110507);
  }
  
  public static final class a
  {
    public boolean dOs = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.g.a.tu
 * JD-Core Version:    0.7.0.1
 */