package com.tencent.mm.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class gw
  extends IEvent
{
  public a fDo;
  public b fDp;
  
  public gw()
  {
    this((byte)0);
  }
  
  private gw(byte paramByte)
  {
    AppMethodBeat.i(155366);
    this.fDo = new a();
    this.fDp = new b();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(155366);
  }
  
  public static final class a
  {
    public String fDq;
    public String fDr;
  }
  
  public static final class b
  {
    public boolean fDs = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.f.a.gw
 * JD-Core Version:    0.7.0.1
 */