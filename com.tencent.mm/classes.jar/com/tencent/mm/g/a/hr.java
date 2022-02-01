package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class hr
  extends IEvent
{
  public a dMk;
  
  public hr()
  {
    this((byte)0);
  }
  
  private hr(byte paramByte)
  {
    AppMethodBeat.i(194248);
    this.dMk = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(194248);
  }
  
  public static final class a
  {
    public int aHK;
    public String dMl;
    public int eventId;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.g.a.hr
 * JD-Core Version:    0.7.0.1
 */