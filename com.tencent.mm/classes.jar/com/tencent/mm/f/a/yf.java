package com.tencent.mm.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class yf
  extends IEvent
{
  public a fXy;
  
  public yf()
  {
    this((byte)0);
  }
  
  private yf(byte paramByte)
  {
    AppMethodBeat.i(116050);
    this.fXy = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(116050);
  }
  
  public static final class a
  {
    public int fCN;
    public long fXA;
    public String fXB;
    public String fXz;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.f.a.yf
 * JD-Core Version:    0.7.0.1
 */