package com.tencent.mm.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class ik
  extends IEvent
{
  public a fFD;
  
  public ik()
  {
    this((byte)0);
  }
  
  private ik(byte paramByte)
  {
    AppMethodBeat.i(200564);
    this.fFD = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(200564);
  }
  
  public static final class a
  {
    public boolean fFE;
    public boolean isStart;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.f.a.ik
 * JD-Core Version:    0.7.0.1
 */