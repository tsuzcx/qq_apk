package com.tencent.mm.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class lj
  extends IEvent
{
  public a fJd;
  
  public lj()
  {
    this((byte)0);
  }
  
  private lj(byte paramByte)
  {
    AppMethodBeat.i(153184);
    this.fJd = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(153184);
  }
  
  public static final class a
  {
    public int fJe;
    public int type;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.f.a.lj
 * JD-Core Version:    0.7.0.1
 */