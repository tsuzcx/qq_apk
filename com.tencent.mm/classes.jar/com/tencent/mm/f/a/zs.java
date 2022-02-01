package com.tencent.mm.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class zs
  extends IEvent
{
  public a fYX;
  
  public zs()
  {
    this((byte)0);
  }
  
  private zs(byte paramByte)
  {
    AppMethodBeat.i(94801);
    this.fYX = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(94801);
  }
  
  public static final class a
  {
    public long fYY = -1L;
    public long fYZ = -1L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.f.a.zs
 * JD-Core Version:    0.7.0.1
 */