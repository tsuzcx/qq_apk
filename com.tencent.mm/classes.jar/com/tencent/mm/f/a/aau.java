package com.tencent.mm.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class aau
  extends IEvent
{
  public a fZT;
  
  public aau()
  {
    this((byte)0);
  }
  
  private aau(byte paramByte)
  {
    AppMethodBeat.i(209849);
    this.fZT = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(209849);
  }
  
  public static final class a
  {
    public int mode = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.f.a.aau
 * JD-Core Version:    0.7.0.1
 */