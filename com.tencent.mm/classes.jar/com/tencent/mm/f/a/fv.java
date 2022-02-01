package com.tencent.mm.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class fv
  extends IEvent
{
  public a fBE;
  
  public fv()
  {
    this((byte)0);
  }
  
  private fv(byte paramByte)
  {
    AppMethodBeat.i(55661);
    this.fBE = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(55661);
  }
  
  public static final class a
  {
    public String username;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.f.a.fv
 * JD-Core Version:    0.7.0.1
 */