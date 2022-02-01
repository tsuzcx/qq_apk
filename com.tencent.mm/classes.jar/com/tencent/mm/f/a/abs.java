package com.tencent.mm.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class abs
  extends IEvent
{
  public a gbB;
  
  public abs()
  {
    this((byte)0);
  }
  
  private abs(byte paramByte)
  {
    AppMethodBeat.i(262555);
    this.gbB = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(262555);
  }
  
  public static final class a
  {
    public String fca;
    public long gbC;
    public int type;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.f.a.abs
 * JD-Core Version:    0.7.0.1
 */