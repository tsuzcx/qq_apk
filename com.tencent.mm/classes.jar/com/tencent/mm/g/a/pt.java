package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class pt
  extends IEvent
{
  public a dVJ;
  
  public pt()
  {
    this((byte)0);
  }
  
  private pt(byte paramByte)
  {
    AppMethodBeat.i(104419);
    this.dVJ = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(104419);
  }
  
  public static final class a
  {
    public String dVK;
    public int dVL;
    public long dVM;
    public String query;
    public int type;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.a.pt
 * JD-Core Version:    0.7.0.1
 */