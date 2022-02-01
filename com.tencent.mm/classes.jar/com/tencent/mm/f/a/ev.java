package com.tencent.mm.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class ev
  extends IEvent
{
  public a fAM;
  
  public ev()
  {
    this((byte)0);
  }
  
  private ev(byte paramByte)
  {
    AppMethodBeat.i(115998);
    this.fAM = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(115998);
  }
  
  public static final class a
  {
    public int fAN = -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.f.a.ev
 * JD-Core Version:    0.7.0.1
 */