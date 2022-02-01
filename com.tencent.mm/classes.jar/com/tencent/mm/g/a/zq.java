package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class zq
  extends IEvent
{
  public a efK;
  
  public zq()
  {
    this((byte)0);
  }
  
  private zq(byte paramByte)
  {
    AppMethodBeat.i(91222);
    this.efK = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(91222);
  }
  
  public static final class a
  {
    public int result = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.g.a.zq
 * JD-Core Version:    0.7.0.1
 */