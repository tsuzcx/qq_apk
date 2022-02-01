package com.tencent.mm.autogen.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class jm
  extends IEvent
{
  public a hLc;
  
  public jm()
  {
    this((byte)0);
  }
  
  private jm(byte paramByte)
  {
    AppMethodBeat.i(369474);
    this.hLc = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(369474);
  }
  
  public static final class a
  {
    public int position;
    public int type;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.autogen.a.jm
 * JD-Core Version:    0.7.0.1
 */