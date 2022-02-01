package com.tencent.mm.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class ps
  extends IEvent
{
  public a fOr;
  
  public ps()
  {
    this((byte)0);
  }
  
  private ps(byte paramByte)
  {
    AppMethodBeat.i(130928);
    this.fOr = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(130928);
  }
  
  public static final class a
  {
    public int retCode;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.f.a.ps
 * JD-Core Version:    0.7.0.1
 */