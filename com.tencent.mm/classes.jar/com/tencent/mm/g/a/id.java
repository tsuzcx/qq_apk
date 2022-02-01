package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class id
  extends IEvent
{
  public a dMJ;
  
  public id()
  {
    this((byte)0);
  }
  
  private id(byte paramByte)
  {
    AppMethodBeat.i(196973);
    this.dMJ = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(196973);
  }
  
  public static final class a
  {
    public boolean dMK = false;
    public int dML = -1;
    public int scene = -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.a.id
 * JD-Core Version:    0.7.0.1
 */