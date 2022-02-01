package com.tencent.mm.autogen.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class fr
  extends IEvent
{
  public a hFV;
  public b hFW;
  
  public fr()
  {
    this((byte)0);
  }
  
  private fr(byte paramByte)
  {
    AppMethodBeat.i(116009);
    this.hFV = new a();
    this.hFW = new b();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(116009);
  }
  
  public static final class a
  {
    public String hEl;
    public String hFX;
    public int progress;
  }
  
  public static final class b {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.autogen.a.fr
 * JD-Core Version:    0.7.0.1
 */