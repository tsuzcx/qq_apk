package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class aal
  extends IEvent
{
  public a ehk;
  
  public aal()
  {
    this((byte)0);
  }
  
  private aal(byte paramByte)
  {
    AppMethodBeat.i(194256);
    this.ehk = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(194256);
  }
  
  public static final class a
  {
    public String activity;
    public long ehl;
    public int type;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.g.a.aal
 * JD-Core Version:    0.7.0.1
 */