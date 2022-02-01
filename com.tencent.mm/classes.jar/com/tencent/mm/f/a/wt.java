package com.tencent.mm.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class wt
  extends IEvent
{
  public a fVN;
  
  public wt()
  {
    this((byte)0);
  }
  
  private wt(byte paramByte)
  {
    AppMethodBeat.i(125638);
    this.fVN = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(125638);
  }
  
  public static final class a
  {
    public String fAg;
    public String fLp;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.f.a.wt
 * JD-Core Version:    0.7.0.1
 */