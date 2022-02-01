package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class xc
  extends IEvent
{
  public a edy;
  
  public xc()
  {
    this((byte)0);
  }
  
  private xc(byte paramByte)
  {
    AppMethodBeat.i(118480);
    this.edy = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(118480);
  }
  
  public static final class a
  {
    public int state = -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.a.xc
 * JD-Core Version:    0.7.0.1
 */