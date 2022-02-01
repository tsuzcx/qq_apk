package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class abg
  extends IEvent
{
  public a eiA;
  
  public abg()
  {
    this((byte)0);
  }
  
  private abg(byte paramByte)
  {
    AppMethodBeat.i(149896);
    this.eiA = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(149896);
  }
  
  public static final class a
  {
    public boolean success = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.a.abg
 * JD-Core Version:    0.7.0.1
 */