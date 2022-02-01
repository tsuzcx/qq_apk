package com.tencent.mm.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class ty
  extends IEvent
{
  public a fTm;
  
  public ty()
  {
    this((byte)0);
  }
  
  private ty(byte paramByte)
  {
    AppMethodBeat.i(94800);
    this.fTm = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(94800);
  }
  
  public static final class a
  {
    public long msgId = 0L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.f.a.ty
 * JD-Core Version:    0.7.0.1
 */