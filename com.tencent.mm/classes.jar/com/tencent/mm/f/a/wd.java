package com.tencent.mm.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class wd
  extends IEvent
{
  public a fVp;
  
  public wd()
  {
    this((byte)0);
  }
  
  private wd(byte paramByte)
  {
    AppMethodBeat.i(94813);
    this.fVp = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(94813);
  }
  
  public static final class a
  {
    public String fVq;
    public int state;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.f.a.wd
 * JD-Core Version:    0.7.0.1
 */