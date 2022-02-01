package com.tencent.mm.autogen.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class jc
  extends IEvent
{
  public a hKK;
  
  public jc()
  {
    this((byte)0);
  }
  
  private jc(byte paramByte)
  {
    AppMethodBeat.i(369461);
    this.hKK = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(369461);
  }
  
  public static final class a
  {
    public double lat;
    public double lng;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.autogen.a.jc
 * JD-Core Version:    0.7.0.1
 */