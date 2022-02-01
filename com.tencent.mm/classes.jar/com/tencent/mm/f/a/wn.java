package com.tencent.mm.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class wn
  extends IEvent
{
  public a fVG;
  
  public wn()
  {
    this((byte)0);
  }
  
  private wn(byte paramByte)
  {
    AppMethodBeat.i(125633);
    this.fVG = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(125633);
  }
  
  public static final class a
  {
    public String fLp;
    public String fVH;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.f.a.wn
 * JD-Core Version:    0.7.0.1
 */