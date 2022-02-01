package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class gh
  extends IEvent
{
  public a dKc;
  public b dKd;
  
  public gh()
  {
    this((byte)0);
  }
  
  private gh(byte paramByte)
  {
    AppMethodBeat.i(116025);
    this.dKc = new a();
    this.dKd = new b();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(116025);
  }
  
  public static final class a
  {
    public long msgId;
  }
  
  public static final class b
  {
    public String fileName;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.g.a.gh
 * JD-Core Version:    0.7.0.1
 */