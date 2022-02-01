package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class gu
  extends IEvent
{
  public a dKP;
  
  public gu()
  {
    this((byte)0);
  }
  
  private gu(byte paramByte)
  {
    AppMethodBeat.i(19808);
    this.dKP = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(19808);
  }
  
  public static final class a
  {
    public boolean isActive;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.g.a.gu
 * JD-Core Version:    0.7.0.1
 */