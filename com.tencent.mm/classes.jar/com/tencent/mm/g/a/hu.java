package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class hu
  extends IEvent
{
  public a dMq;
  
  public hu()
  {
    this((byte)0);
  }
  
  private hu(byte paramByte)
  {
    AppMethodBeat.i(208803);
    this.dMq = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(208803);
  }
  
  public static final class a
  {
    public int dJY;
    public long localId;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.a.hu
 * JD-Core Version:    0.7.0.1
 */