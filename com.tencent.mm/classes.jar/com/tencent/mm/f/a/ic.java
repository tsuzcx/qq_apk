package com.tencent.mm.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class ic
  extends IEvent
{
  public a fFi;
  
  public ic()
  {
    this((byte)0);
  }
  
  private ic(byte paramByte)
  {
    AppMethodBeat.i(168629);
    this.fFi = new a();
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
 * Qualified Name:     com.tencent.mm.f.a.ic
 * JD-Core Version:    0.7.0.1
 */