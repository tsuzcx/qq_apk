package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class cs
  extends IEvent
{
  public a dFQ;
  public b dFR;
  
  public cs()
  {
    this((byte)0);
  }
  
  private cs(byte paramByte)
  {
    AppMethodBeat.i(192285);
    this.dFQ = new a();
    this.dFR = new b();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(192285);
  }
  
  public static final class a
  {
    public String path;
  }
  
  public static final class b
  {
    public String[] dFS;
    public boolean isTimeout = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.g.a.cs
 * JD-Core Version:    0.7.0.1
 */