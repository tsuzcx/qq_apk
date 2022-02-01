package com.tencent.mm.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class gp
  extends IEvent
{
  public a fCT;
  
  public gp()
  {
    this((byte)0);
  }
  
  private gp(byte paramByte)
  {
    AppMethodBeat.i(116026);
    this.fCT = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(116026);
  }
  
  public static final class a
  {
    public int fCU;
    public String fileName;
    public int scene;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.f.a.gp
 * JD-Core Version:    0.7.0.1
 */