package com.tencent.mm.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class ns
  extends IEvent
{
  public a fMi;
  
  public ns()
  {
    this((byte)0);
  }
  
  private ns(byte paramByte)
  {
    AppMethodBeat.i(43442);
    this.fMi = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(43442);
  }
  
  public static final class a
  {
    public String businessType;
    public int errCode;
    public String fMh;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.f.a.ns
 * JD-Core Version:    0.7.0.1
 */