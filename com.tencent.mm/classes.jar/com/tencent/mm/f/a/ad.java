package com.tencent.mm.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class ad
  extends IEvent
{
  public a fvG;
  
  public ad()
  {
    this((byte)0);
  }
  
  private ad(byte paramByte)
  {
    AppMethodBeat.i(149850);
    this.fvG = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(149850);
  }
  
  public static final class a
  {
    public String url;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.f.a.ad
 * JD-Core Version:    0.7.0.1
 */