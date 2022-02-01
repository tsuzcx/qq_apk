package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class mz
  extends IEvent
{
  public a dSI;
  
  public mz()
  {
    this((byte)0);
  }
  
  private mz(byte paramByte)
  {
    AppMethodBeat.i(149874);
    this.dSI = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(149874);
  }
  
  public static final class a
  {
    public String businessType;
    public String dSJ;
    public int errCode;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.a.mz
 * JD-Core Version:    0.7.0.1
 */