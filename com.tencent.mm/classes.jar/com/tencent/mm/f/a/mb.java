package com.tencent.mm.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class mb
  extends IEvent
{
  public a fJY;
  
  public mb()
  {
    this((byte)0);
  }
  
  private mb(byte paramByte)
  {
    AppMethodBeat.i(128845);
    this.fJY = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(128845);
  }
  
  public static final class a
  {
    public String appid;
    public int fBP;
    public String returnKey;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.f.a.mb
 * JD-Core Version:    0.7.0.1
 */