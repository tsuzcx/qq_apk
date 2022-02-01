package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class bo
  extends IEvent
{
  public a dEL;
  
  public bo()
  {
    this((byte)0);
  }
  
  private bo(byte paramByte)
  {
    AppMethodBeat.i(131788);
    this.dEL = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(131788);
  }
  
  public static final class a
  {
    public int dEM = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.g.a.bo
 * JD-Core Version:    0.7.0.1
 */