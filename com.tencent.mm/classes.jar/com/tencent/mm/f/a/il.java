package com.tencent.mm.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class il
  extends IEvent
{
  public a fFF;
  
  public il()
  {
    this((byte)0);
  }
  
  private il(byte paramByte)
  {
    AppMethodBeat.i(281844);
    this.fFF = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(281844);
  }
  
  public static final class a
  {
    public double lat;
    public double lng;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.f.a.il
 * JD-Core Version:    0.7.0.1
 */