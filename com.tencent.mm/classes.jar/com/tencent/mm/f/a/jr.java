package com.tencent.mm.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class jr
  extends IEvent
{
  public a fGU;
  
  public jr()
  {
    this((byte)0);
  }
  
  private jr(byte paramByte)
  {
    AppMethodBeat.i(89646);
    this.fGU = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(89646);
  }
  
  public static final class a
  {
    public String appid;
    public int fvK;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.f.a.jr
 * JD-Core Version:    0.7.0.1
 */