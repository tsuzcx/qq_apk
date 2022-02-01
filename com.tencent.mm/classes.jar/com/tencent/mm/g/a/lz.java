package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class lz
  extends IEvent
{
  public a dRz;
  
  public lz()
  {
    this((byte)0);
  }
  
  private lz(byte paramByte)
  {
    AppMethodBeat.i(155372);
    this.dRz = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(155372);
  }
  
  public static final class a
  {
    public String content;
    public String url;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.a.lz
 * JD-Core Version:    0.7.0.1
 */