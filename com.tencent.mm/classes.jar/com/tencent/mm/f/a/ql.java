package com.tencent.mm.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class ql
  extends IEvent
{
  public a fPi;
  
  public ql()
  {
    this((byte)0);
  }
  
  private ql(byte paramByte)
  {
    AppMethodBeat.i(91037);
    this.fPi = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(91037);
  }
  
  public static final class a
  {
    public int action = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.f.a.ql
 * JD-Core Version:    0.7.0.1
 */