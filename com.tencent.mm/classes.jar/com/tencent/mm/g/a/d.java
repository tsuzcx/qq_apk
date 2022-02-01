package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class d
  extends IEvent
{
  public a dBP;
  
  public d()
  {
    this((byte)0);
  }
  
  private d(byte paramByte)
  {
    AppMethodBeat.i(140983);
    this.dBP = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(140983);
  }
  
  public static final class a
  {
    public boolean dBQ;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.g.a.d
 * JD-Core Version:    0.7.0.1
 */