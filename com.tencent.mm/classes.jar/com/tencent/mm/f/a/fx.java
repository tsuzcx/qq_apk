package com.tencent.mm.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class fx
  extends IEvent
{
  public a fBF;
  
  public fx()
  {
    this((byte)0);
  }
  
  private fx(byte paramByte)
  {
    AppMethodBeat.i(116015);
    this.fBF = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(116015);
  }
  
  public static final class a
  {
    public int op;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.f.a.fx
 * JD-Core Version:    0.7.0.1
 */