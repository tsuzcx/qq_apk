package com.tencent.mm.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class ap
  extends IEvent
{
  public a fvY;
  
  public ap()
  {
    this((byte)0);
  }
  
  private ap(byte paramByte)
  {
    AppMethodBeat.i(211030);
    this.fvY = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(211030);
  }
  
  public static final class a
  {
    public String fvZ;
    public String fwa;
    public int scene = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.f.a.ap
 * JD-Core Version:    0.7.0.1
 */