package com.tencent.mm.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class abx
  extends IEvent
{
  public a gbT;
  
  public abx()
  {
    this((byte)0);
  }
  
  private abx(byte paramByte)
  {
    AppMethodBeat.i(114793);
    this.gbT = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(114793);
  }
  
  public static final class a
  {
    public int fvK;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.f.a.abx
 * JD-Core Version:    0.7.0.1
 */