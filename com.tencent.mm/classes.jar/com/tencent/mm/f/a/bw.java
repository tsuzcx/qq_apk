package com.tencent.mm.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class bw
  extends IEvent
{
  public a fxJ;
  
  public bw()
  {
    this((byte)0);
  }
  
  private bw(byte paramByte)
  {
    AppMethodBeat.i(149857);
    this.fxJ = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(149857);
  }
  
  public static final class a
  {
    public int fvK = -1;
    public int fxC;
    public boolean fxI;
    public int subType;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.f.a.bw
 * JD-Core Version:    0.7.0.1
 */