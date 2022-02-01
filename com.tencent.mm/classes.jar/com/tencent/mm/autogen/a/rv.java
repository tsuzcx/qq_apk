package com.tencent.mm.autogen.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class rv
  extends IEvent
{
  public a hUT;
  public b hUU;
  
  public rv()
  {
    this((byte)0);
  }
  
  private rv(byte paramByte)
  {
    AppMethodBeat.i(130031);
    this.hUT = new a();
    this.hUU = new b();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(130031);
  }
  
  public static final class a
  {
    public boolean hUV = false;
    public boolean hUW = false;
    public int type;
  }
  
  public static final class b
  {
    public boolean hUX = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.autogen.a.rv
 * JD-Core Version:    0.7.0.1
 */