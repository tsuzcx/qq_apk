package com.tencent.mm.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class gq
  extends IEvent
{
  public a fCV;
  
  public gq()
  {
    this((byte)0);
  }
  
  private gq(byte paramByte)
  {
    AppMethodBeat.i(116027);
    this.fCV = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(116027);
  }
  
  public static final class a
  {
    public int fCW;
    public int fCX;
    public int fCY;
    public int fCZ;
    public String fileName;
    public int result;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.f.a.gq
 * JD-Core Version:    0.7.0.1
 */