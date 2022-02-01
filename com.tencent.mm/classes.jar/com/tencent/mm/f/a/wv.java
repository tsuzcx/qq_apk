package com.tencent.mm.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class wv
  extends IEvent
{
  public a fVP;
  public b fVQ;
  
  public wv()
  {
    this((byte)0);
  }
  
  private wv(byte paramByte)
  {
    AppMethodBeat.i(148771);
    this.fVP = new a();
    this.fVQ = new b();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(148771);
  }
  
  public static final class a
  {
    public String fVR;
  }
  
  public static final class b
  {
    public Object result;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.f.a.wv
 * JD-Core Version:    0.7.0.1
 */