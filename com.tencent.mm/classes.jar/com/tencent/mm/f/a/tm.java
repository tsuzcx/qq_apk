package com.tencent.mm.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.storage.ca;

public final class tm
  extends IEvent
{
  public a fSS;
  
  public tm()
  {
    this((byte)0);
  }
  
  private tm(byte paramByte)
  {
    AppMethodBeat.i(116045);
    this.fSS = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(116045);
  }
  
  public static final class a
  {
    public ca fvt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.f.a.tm
 * JD-Core Version:    0.7.0.1
 */