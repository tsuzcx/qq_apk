package com.tencent.mm.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class gx
  extends IEvent
{
  public a fDt;
  public b fDu;
  
  public gx()
  {
    this((byte)0);
  }
  
  private gx(byte paramByte)
  {
    AppMethodBeat.i(155367);
    this.fDt = new a();
    this.fDu = new b();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(155367);
  }
  
  public static final class a
  {
    public String fDq;
    public String fDr;
  }
  
  public static final class b
  {
    public String fDv;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.f.a.gx
 * JD-Core Version:    0.7.0.1
 */