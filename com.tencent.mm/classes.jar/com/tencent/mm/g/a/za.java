package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class za
  extends IEvent
{
  public a efk;
  
  public za()
  {
    this((byte)0);
  }
  
  private za(byte paramByte)
  {
    AppMethodBeat.i(231468);
    this.efk = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(231468);
  }
  
  public static final class a
  {
    public boolean isStart;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.g.a.za
 * JD-Core Version:    0.7.0.1
 */