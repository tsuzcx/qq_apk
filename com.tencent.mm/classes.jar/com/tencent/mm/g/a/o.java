package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class o
  extends IEvent
{
  public a dCr;
  
  public o()
  {
    this((byte)0);
  }
  
  private o(byte paramByte)
  {
    AppMethodBeat.i(201283);
    this.dCr = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(201283);
  }
  
  public static final class a
  {
    public String appId;
    public boolean dCs;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.a.o
 * JD-Core Version:    0.7.0.1
 */