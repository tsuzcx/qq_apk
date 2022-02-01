package com.tencent.mm.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class rh
  extends IEvent
{
  public a fQq;
  public b fQr;
  
  public rh()
  {
    this((byte)0);
  }
  
  private rh(byte paramByte)
  {
    AppMethodBeat.i(127289);
    this.fQq = new a();
    this.fQr = new b();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(127289);
  }
  
  public static final class a
  {
    public String fQs;
    public String talker;
  }
  
  public static final class b
  {
    public boolean fyl = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.f.a.rh
 * JD-Core Version:    0.7.0.1
 */