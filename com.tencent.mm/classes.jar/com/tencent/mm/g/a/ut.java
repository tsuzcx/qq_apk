package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet_core.model.a;
import com.tencent.mm.sdk.event.IEvent;

public final class ut
  extends IEvent
{
  public a eba;
  
  public ut()
  {
    this((byte)0);
  }
  
  private ut(byte paramByte)
  {
    AppMethodBeat.i(63292);
    this.eba = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(63292);
  }
  
  public static final class a
  {
    public a ebb;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.g.a.ut
 * JD-Core Version:    0.7.0.1
 */