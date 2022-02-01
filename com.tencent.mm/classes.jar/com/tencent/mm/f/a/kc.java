package com.tencent.mm.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class kc
  extends IEvent
{
  public a fHy;
  
  public kc()
  {
    this((byte)0);
  }
  
  private kc(byte paramByte)
  {
    AppMethodBeat.i(131790);
    this.fHy = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(131790);
  }
  
  public static final class a
  {
    public boolean fHA = false;
    public int fHz = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.f.a.kc
 * JD-Core Version:    0.7.0.1
 */