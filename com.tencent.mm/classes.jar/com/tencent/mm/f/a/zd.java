package com.tencent.mm.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class zd
  extends IEvent
{
  public a fYw;
  
  public zd()
  {
    this((byte)0);
  }
  
  private zd(byte paramByte)
  {
    AppMethodBeat.i(94819);
    this.fYw = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(94819);
  }
  
  public static final class a
  {
    public long delay = 0L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.f.a.zd
 * JD-Core Version:    0.7.0.1
 */