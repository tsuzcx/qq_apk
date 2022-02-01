package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class xu
  extends IEvent
{
  public a eee;
  
  public xu()
  {
    this((byte)0);
  }
  
  private xu(byte paramByte)
  {
    AppMethodBeat.i(241576);
    this.eee = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(241576);
  }
  
  public static final class a
  {
    public int dLS;
    public int eef;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.a.xu
 * JD-Core Version:    0.7.0.1
 */