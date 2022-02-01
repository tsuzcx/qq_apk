package com.tencent.mm.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class ep
  extends IEvent
{
  public a fAx;
  
  public ep()
  {
    this((byte)0);
  }
  
  private ep(byte paramByte)
  {
    AppMethodBeat.i(115992);
    this.fAx = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(115992);
  }
  
  public static final class a
  {
    public double fAA = 0.0D;
    public double fAB = 0.0D;
    public String fAC;
    public int fAD = 0;
    public String fAv;
    public int fAy = 0;
    public int fAz = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.f.a.ep
 * JD-Core Version:    0.7.0.1
 */