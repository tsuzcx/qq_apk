package com.tencent.mm.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class ci
  extends IEvent
{
  public a fxW;
  public b fxX;
  
  public ci()
  {
    this((byte)0);
  }
  
  private ci(byte paramByte)
  {
    AppMethodBeat.i(140934);
    this.fxW = new a();
    this.fxX = new b();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(140934);
  }
  
  public static final class a
  {
    public int fxY = 0;
  }
  
  public static final class b
  {
    public int retCode = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.f.a.ci
 * JD-Core Version:    0.7.0.1
 */