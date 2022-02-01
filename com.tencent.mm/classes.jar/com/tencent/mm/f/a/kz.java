package com.tencent.mm.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class kz
  extends IEvent
{
  public a fIG;
  
  public kz()
  {
    this((byte)0);
  }
  
  private kz(byte paramByte)
  {
    AppMethodBeat.i(104418);
    this.fIG = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(104418);
  }
  
  public static final class a
  {
    public int errorCode;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.f.a.kz
 * JD-Core Version:    0.7.0.1
 */