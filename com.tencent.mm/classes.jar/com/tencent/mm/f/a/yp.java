package com.tencent.mm.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class yp
  extends IEvent
{
  public a fXL;
  
  public yp()
  {
    this((byte)0);
  }
  
  private yp(byte paramByte)
  {
    AppMethodBeat.i(149890);
    this.fXL = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(149890);
  }
  
  public static final class a
  {
    public int fCN = 0;
    public String fXM;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.f.a.yp
 * JD-Core Version:    0.7.0.1
 */