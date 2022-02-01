package com.tencent.mm.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class mm
  extends IEvent
{
  public a fKB;
  
  public mm()
  {
    this((byte)0);
  }
  
  private mm(byte paramByte)
  {
    AppMethodBeat.i(225685);
    this.fKB = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(225685);
  }
  
  public static final class a
  {
    public boolean fFE;
    public boolean fKC;
    public boolean fKD;
    public boolean isStart;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.f.a.mm
 * JD-Core Version:    0.7.0.1
 */