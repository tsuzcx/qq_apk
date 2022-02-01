package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class lv
  extends IEvent
{
  public a dRl;
  
  public lv()
  {
    this((byte)0);
  }
  
  private lv(byte paramByte)
  {
    AppMethodBeat.i(223486);
    this.dRl = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(223486);
  }
  
  public static final class a
  {
    public boolean dMz;
    public boolean dRm;
    public boolean dRn;
    public boolean isStart;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.a.lv
 * JD-Core Version:    0.7.0.1
 */