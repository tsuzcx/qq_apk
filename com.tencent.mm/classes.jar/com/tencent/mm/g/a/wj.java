package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class wj
  extends IEvent
{
  public a ecv;
  
  public wj()
  {
    this((byte)0);
  }
  
  private wj(byte paramByte)
  {
    AppMethodBeat.i(94817);
    this.ecv = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(94817);
  }
  
  public static final class a
  {
    public String mediaId;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.a.wj
 * JD-Core Version:    0.7.0.1
 */