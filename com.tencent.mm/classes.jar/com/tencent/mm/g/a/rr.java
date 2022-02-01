package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelsns.SnsAdClick;
import com.tencent.mm.sdk.event.IEvent;

public final class rr
  extends IEvent
{
  public a dYk;
  
  public rr()
  {
    this((byte)0);
  }
  
  private rr(byte paramByte)
  {
    AppMethodBeat.i(125626);
    this.dYk = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(125626);
  }
  
  public static final class a
  {
    public SnsAdClick dYl;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.a.rr
 * JD-Core Version:    0.7.0.1
 */