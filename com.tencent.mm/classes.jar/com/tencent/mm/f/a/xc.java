package com.tencent.mm.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class xc
  extends IEvent
{
  public a fVZ;
  
  public xc()
  {
    this((byte)0);
  }
  
  private xc(byte paramByte)
  {
    AppMethodBeat.i(125643);
    this.fVZ = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(125643);
  }
  
  public static final class a
  {
    public boolean fWa;
    public boolean fWb;
    public boolean fWc;
    public String username;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.f.a.xc
 * JD-Core Version:    0.7.0.1
 */