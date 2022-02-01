package com.tencent.mm.autogen.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelsns.SnsAdClick;
import com.tencent.mm.sdk.event.IEvent;

public final class uq
  extends IEvent
{
  public a hYr;
  
  public uq()
  {
    this((byte)0);
  }
  
  private uq(byte paramByte)
  {
    AppMethodBeat.i(125628);
    this.hYr = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(125628);
  }
  
  public static final class a
  {
    public SnsAdClick hXZ;
    public int hYs;
    public String uxInfo;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.autogen.a.uq
 * JD-Core Version:    0.7.0.1
 */