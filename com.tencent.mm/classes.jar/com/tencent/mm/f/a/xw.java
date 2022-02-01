package com.tencent.mm.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class xw
  extends IEvent
{
  public xw.a fWN;
  public b fWO;
  
  public xw()
  {
    this((byte)0);
  }
  
  private xw(byte paramByte)
  {
    AppMethodBeat.i(153187);
    this.fWN = new xw.a();
    this.fWO = new b();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(153187);
  }
  
  public static final class b
  {
    public boolean fXi;
    public String fXj;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.f.a.xw
 * JD-Core Version:    0.7.0.1
 */