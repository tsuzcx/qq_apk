package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class gj
  extends IEvent
{
  public a dKg;
  
  public gj()
  {
    this((byte)0);
  }
  
  private gj(byte paramByte)
  {
    AppMethodBeat.i(116027);
    this.dKg = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(116027);
  }
  
  public static final class a
  {
    public int dKh;
    public int dKi;
    public int dKj;
    public int dKk;
    public String fileName;
    public int result;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.g.a.gj
 * JD-Core Version:    0.7.0.1
 */