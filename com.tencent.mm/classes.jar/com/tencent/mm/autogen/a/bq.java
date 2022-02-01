package com.tencent.mm.autogen.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class bq
  extends IEvent
{
  public a hBG;
  
  public bq()
  {
    this((byte)0);
  }
  
  private bq(byte paramByte)
  {
    AppMethodBeat.i(369391);
    this.hBG = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(369391);
  }
  
  public static final class a
  {
    public boolean hBF;
    public long msgId;
    public int type;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.autogen.a.bq
 * JD-Core Version:    0.7.0.1
 */