package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class nk
  extends IEvent
{
  public a dTy;
  
  public nk()
  {
    this((byte)0);
  }
  
  private nk(byte paramByte)
  {
    AppMethodBeat.i(131792);
    this.dTy = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(131792);
  }
  
  public static final class a
  {
    public boolean dTA = false;
    public String dTB;
    public int dTz = 0;
    public int status = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.a.nk
 * JD-Core Version:    0.7.0.1
 */