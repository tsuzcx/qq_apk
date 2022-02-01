package com.tencent.mm.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class zc
  extends IEvent
{
  public a fYv;
  
  public zc()
  {
    this((byte)0);
  }
  
  private zc(byte paramByte)
  {
    AppMethodBeat.i(94818);
    this.fYv = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(94818);
  }
  
  public static final class a
  {
    public long delay = 0L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.f.a.zc
 * JD-Core Version:    0.7.0.1
 */