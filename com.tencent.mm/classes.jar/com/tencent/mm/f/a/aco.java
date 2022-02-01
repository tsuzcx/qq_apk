package com.tencent.mm.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class aco
  extends IEvent
{
  public a gcP;
  
  public aco()
  {
    this((byte)0);
  }
  
  private aco(byte paramByte)
  {
    AppMethodBeat.i(149896);
    this.gcP = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(149896);
  }
  
  public static final class a
  {
    public boolean success = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.f.a.aco
 * JD-Core Version:    0.7.0.1
 */