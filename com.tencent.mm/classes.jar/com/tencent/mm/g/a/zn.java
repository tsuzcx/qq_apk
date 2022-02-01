package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class zn
  extends IEvent
{
  public a efE;
  
  public zn()
  {
    this((byte)0);
  }
  
  private zn(byte paramByte)
  {
    AppMethodBeat.i(256166);
    this.efE = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(256166);
  }
  
  public static final class a
  {
    public int mode = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.g.a.zn
 * JD-Core Version:    0.7.0.1
 */