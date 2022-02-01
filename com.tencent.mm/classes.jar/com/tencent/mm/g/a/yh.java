package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class yh
  extends IEvent
{
  public a eeC;
  
  public yh()
  {
    this((byte)0);
  }
  
  private yh(byte paramByte)
  {
    AppMethodBeat.i(140992);
    this.eeC = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(140992);
  }
  
  public static final class a
  {
    public int eeD = 0;
    public int eeE = 0;
    public int eeF = 0;
    public int type = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.a.yh
 * JD-Core Version:    0.7.0.1
 */