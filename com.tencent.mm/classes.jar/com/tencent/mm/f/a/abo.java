package com.tencent.mm.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class abo
  extends IEvent
{
  public a gbv;
  
  public abo()
  {
    this((byte)0);
  }
  
  private abo(byte paramByte)
  {
    AppMethodBeat.i(91232);
    this.gbv = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(91232);
  }
  
  public static final class a
  {
    public int result;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.f.a.abo
 * JD-Core Version:    0.7.0.1
 */