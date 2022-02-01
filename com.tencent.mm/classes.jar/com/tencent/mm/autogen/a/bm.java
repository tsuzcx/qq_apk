package com.tencent.mm.autogen.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class bm
  extends IEvent
{
  public a hBz;
  
  public bm()
  {
    this((byte)0);
  }
  
  private bm(byte paramByte)
  {
    AppMethodBeat.i(369387);
    this.hBz = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(369387);
  }
  
  public static final class a
  {
    public int channelId = -1;
    public boolean hBA = false;
    public boolean highlight = false;
    public long seq = -1L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.autogen.a.bm
 * JD-Core Version:    0.7.0.1
 */