package com.tencent.mm.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class ys
  extends IEvent
{
  public a fXS;
  public b fXT;
  
  public ys()
  {
    this((byte)0);
  }
  
  private ys(byte paramByte)
  {
    AppMethodBeat.i(19840);
    this.fXS = new a();
    this.fXT = new b();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(19840);
  }
  
  public static final class a
  {
    public String fPV;
    public int fPW = 0;
    public int fPX = 0;
    public int opType = 0;
  }
  
  public static final class b {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.f.a.ys
 * JD-Core Version:    0.7.0.1
 */