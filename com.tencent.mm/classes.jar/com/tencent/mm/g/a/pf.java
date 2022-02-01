package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class pf
  extends IEvent
{
  public a dVk;
  
  public pf()
  {
    this((byte)0);
  }
  
  private pf(byte paramByte)
  {
    AppMethodBeat.i(206895);
    this.dVk = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(206895);
  }
  
  public static final class a
  {
    public String dVl;
    public String dVm;
    public int dVn;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.g.a.pf
 * JD-Core Version:    0.7.0.1
 */