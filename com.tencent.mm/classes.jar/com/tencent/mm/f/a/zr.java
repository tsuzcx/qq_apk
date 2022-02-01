package com.tencent.mm.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class zr
  extends IEvent
{
  public a fYW;
  
  public zr()
  {
    this((byte)0);
  }
  
  private zr(byte paramByte)
  {
    AppMethodBeat.i(19843);
    this.fYW = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(19843);
  }
  
  public static final class a
  {
    public String countryCode;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.f.a.zr
 * JD-Core Version:    0.7.0.1
 */