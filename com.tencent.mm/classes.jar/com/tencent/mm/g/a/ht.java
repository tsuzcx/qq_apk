package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class ht
  extends IEvent
{
  public a dMp;
  
  public ht()
  {
    this((byte)0);
  }
  
  private ht(byte paramByte)
  {
    AppMethodBeat.i(168629);
    this.dMp = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(168629);
  }
  
  public static final class a
  {
    public int errCode;
    public String errMsg;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.a.ht
 * JD-Core Version:    0.7.0.1
 */