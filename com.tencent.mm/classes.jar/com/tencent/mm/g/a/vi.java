package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class vi
  extends IEvent
{
  public a ebE;
  
  public vi()
  {
    this((byte)0);
  }
  
  private vi(byte paramByte)
  {
    AppMethodBeat.i(125633);
    this.ebE = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(125633);
  }
  
  public static final class a
  {
    public String dRS;
    public String ebF;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.a.vi
 * JD-Core Version:    0.7.0.1
 */