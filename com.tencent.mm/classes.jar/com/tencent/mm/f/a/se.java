package com.tencent.mm.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class se
  extends IEvent
{
  public a fRL;
  
  public se()
  {
    this((byte)0);
  }
  
  private se(byte paramByte)
  {
    AppMethodBeat.i(184120);
    this.fRL = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(184120);
  }
  
  public static final class a
  {
    public int type = 0;
    public String username;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.f.a.se
 * JD-Core Version:    0.7.0.1
 */