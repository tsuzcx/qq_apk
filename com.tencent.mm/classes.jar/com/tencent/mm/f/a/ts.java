package com.tencent.mm.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class ts
  extends IEvent
{
  public a fTa;
  public b fTb;
  
  public ts()
  {
    this((byte)0);
  }
  
  private ts(byte paramByte)
  {
    AppMethodBeat.i(93326);
    this.fTa = new a();
    this.fTb = new b();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(93326);
  }
  
  public static final class a {}
  
  public static final class b {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.f.a.ts
 * JD-Core Version:    0.7.0.1
 */