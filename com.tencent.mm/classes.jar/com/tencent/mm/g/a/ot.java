package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class ot
  extends IEvent
{
  public a dUN;
  
  public ot()
  {
    this((byte)0);
  }
  
  private ot(byte paramByte)
  {
    AppMethodBeat.i(19823);
    this.dUN = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(19823);
  }
  
  public static final class a
  {
    public String talker;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.a.ot
 * JD-Core Version:    0.7.0.1
 */