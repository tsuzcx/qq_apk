package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class xb
  extends IEvent
{
  public a edv;
  
  public xb()
  {
    this((byte)0);
  }
  
  private xb(byte paramByte)
  {
    AppMethodBeat.i(118479);
    this.edv = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(118479);
  }
  
  public static final class a
  {
    public boolean edw = false;
    public long edx = 0L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.g.a.xb
 * JD-Core Version:    0.7.0.1
 */