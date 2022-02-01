package com.tencent.mm.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class fa
  extends IEvent
{
  public a fAS;
  
  public fa()
  {
    this((byte)0);
  }
  
  private fa(byte paramByte)
  {
    AppMethodBeat.i(116003);
    this.fAS = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(116003);
  }
  
  public static final class a
  {
    public boolean fzN = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.f.a.fa
 * JD-Core Version:    0.7.0.1
 */