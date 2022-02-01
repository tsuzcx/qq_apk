package com.tencent.mm.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class zy
  extends IEvent
{
  public a fZl;
  
  public zy()
  {
    this((byte)0);
  }
  
  private zy(byte paramByte)
  {
    AppMethodBeat.i(131617);
    this.fZl = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(131617);
  }
  
  public static final class a
  {
    public long delay = 800L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.f.a.zy
 * JD-Core Version:    0.7.0.1
 */