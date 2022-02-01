package com.tencent.mm.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class wl
  extends IEvent
{
  public a fVD;
  
  public wl()
  {
    this((byte)0);
  }
  
  private wl(byte paramByte)
  {
    AppMethodBeat.i(194186);
    this.fVD = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(194186);
  }
  
  public static final class a
  {
    public long fVE;
    public Object fVF;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.f.a.wl
 * JD-Core Version:    0.7.0.1
 */