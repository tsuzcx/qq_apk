package com.tencent.mm.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class wh
  extends IEvent
{
  public a fVv;
  
  public wh()
  {
    this((byte)0);
  }
  
  private wh(byte paramByte)
  {
    AppMethodBeat.i(260270);
    this.fVv = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(260270);
  }
  
  public static final class a
  {
    public String fVw;
    public String fVx;
    public String fVy;
    public int fVz = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.f.a.wh
 * JD-Core Version:    0.7.0.1
 */