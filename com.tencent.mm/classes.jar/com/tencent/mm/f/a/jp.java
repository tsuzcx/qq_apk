package com.tencent.mm.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class jp
  extends IEvent
{
  public a fGP;
  public b fGQ;
  
  public jp()
  {
    this((byte)0);
  }
  
  private jp(byte paramByte)
  {
    AppMethodBeat.i(89645);
    this.fGP = new a();
    this.fGQ = new b();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(89645);
  }
  
  public static final class a
  {
    public int Vh = 0;
    public String url;
  }
  
  public static final class b
  {
    public String fGR;
    public boolean fGS = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.f.a.jp
 * JD-Core Version:    0.7.0.1
 */