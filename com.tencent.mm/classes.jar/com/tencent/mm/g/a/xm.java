package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class xm
  extends IEvent
{
  public a edJ;
  public b edK;
  
  public xm()
  {
    this((byte)0);
  }
  
  private xm(byte paramByte)
  {
    AppMethodBeat.i(19840);
    this.edJ = new a();
    this.edK = new b();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(19840);
  }
  
  public static final class a
  {
    public String dWq;
    public int dWr = 0;
    public int dWs = 0;
    public int opType = 0;
  }
  
  public static final class b {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.g.a.xm
 * JD-Core Version:    0.7.0.1
 */