package com.tencent.mm.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class km
  extends IEvent
{
  public a fIa;
  
  public km()
  {
    this((byte)0);
  }
  
  private km(byte paramByte)
  {
    AppMethodBeat.i(149864);
    this.fIa = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(149864);
  }
  
  public static final class a
  {
    public String url;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.f.a.km
 * JD-Core Version:    0.7.0.1
 */