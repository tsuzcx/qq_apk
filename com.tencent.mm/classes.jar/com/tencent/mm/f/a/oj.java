package com.tencent.mm.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class oj
  extends IEvent
{
  public a fNi;
  
  public oj()
  {
    this((byte)0);
  }
  
  private oj(byte paramByte)
  {
    AppMethodBeat.i(116035);
    this.fNi = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(116035);
  }
  
  public static final class a
  {
    public int type;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.f.a.oj
 * JD-Core Version:    0.7.0.1
 */