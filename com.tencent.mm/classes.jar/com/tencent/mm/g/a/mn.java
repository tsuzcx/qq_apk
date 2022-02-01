package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class mn
  extends IEvent
{
  public a dSa;
  public b dSb;
  
  public mn()
  {
    this((byte)0);
  }
  
  private mn(byte paramByte)
  {
    AppMethodBeat.i(149871);
    this.dSa = new a();
    this.dSb = new b();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(149871);
  }
  
  public static final class a
  {
    public int action;
    public int dSc;
    public String filePath;
  }
  
  public static final class b {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.g.a.mn
 * JD-Core Version:    0.7.0.1
 */