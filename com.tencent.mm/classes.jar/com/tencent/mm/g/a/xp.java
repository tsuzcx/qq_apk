package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class xp
  extends IEvent
{
  public a edP;
  
  public xp()
  {
    this((byte)0);
  }
  
  private xp(byte paramByte)
  {
    AppMethodBeat.i(19841);
    this.edP = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(19841);
  }
  
  public static final class a
  {
    public boolean edQ = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.g.a.xp
 * JD-Core Version:    0.7.0.1
 */