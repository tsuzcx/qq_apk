package com.tencent.mm.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class mf
  extends IEvent
{
  public a fKi;
  
  public mf()
  {
    this((byte)0);
  }
  
  private mf(byte paramByte)
  {
    AppMethodBeat.i(89746);
    this.fKi = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(89746);
  }
  
  public static final class a
  {
    public String event;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.f.a.mf
 * JD-Core Version:    0.7.0.1
 */