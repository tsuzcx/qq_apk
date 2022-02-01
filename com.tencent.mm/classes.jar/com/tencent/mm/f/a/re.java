package com.tencent.mm.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class re
  extends IEvent
{
  public a fQg;
  public b fQh;
  
  public re()
  {
    this((byte)0);
  }
  
  private re(byte paramByte)
  {
    AppMethodBeat.i(9427);
    this.fQg = new a();
    this.fQh = new b();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(9427);
  }
  
  public static final class a
  {
    public long fxU;
    public String xml;
  }
  
  public static final class b
  {
    public String fQi;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.f.a.re
 * JD-Core Version:    0.7.0.1
 */