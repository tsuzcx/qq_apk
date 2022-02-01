package com.tencent.mm.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class yv
  extends IEvent
{
  public a fYd;
  
  public yv()
  {
    this((byte)0);
  }
  
  private yv(byte paramByte)
  {
    AppMethodBeat.i(162263);
    this.fYd = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(162263);
  }
  
  public static final class a
  {
    public String viewId;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.f.a.yv
 * JD-Core Version:    0.7.0.1
 */