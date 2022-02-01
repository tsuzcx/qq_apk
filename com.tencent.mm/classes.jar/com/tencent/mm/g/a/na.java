package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class na
  extends IEvent
{
  public a dSK;
  
  public na()
  {
    this((byte)0);
  }
  
  private na(byte paramByte)
  {
    AppMethodBeat.i(43442);
    this.dSK = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(43442);
  }
  
  public static final class a
  {
    public String businessType;
    public String dSJ;
    public int errCode;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.a.na
 * JD-Core Version:    0.7.0.1
 */