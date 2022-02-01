package com.tencent.mm.autogen.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class bp
  extends IEvent
{
  public a hBE;
  
  public bp()
  {
    this((byte)0);
  }
  
  private bp(byte paramByte)
  {
    AppMethodBeat.i(369388);
    this.hBE = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(369388);
  }
  
  public static final class a
  {
    public boolean hBF;
    public long msgId;
    public int type;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.autogen.a.bp
 * JD-Core Version:    0.7.0.1
 */