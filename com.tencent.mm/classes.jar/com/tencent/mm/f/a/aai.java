package com.tencent.mm.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class aai
  extends IEvent
{
  public a fZA;
  
  public aai()
  {
    this((byte)0);
  }
  
  private aai(byte paramByte)
  {
    AppMethodBeat.i(229256);
    this.fZA = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(229256);
  }
  
  public static final class a
  {
    public boolean fZB;
    public long msgId;
    public boolean success;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.f.a.aai
 * JD-Core Version:    0.7.0.1
 */