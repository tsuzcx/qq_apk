package com.tencent.mm.autogen.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class by
  extends IEvent
{
  public a hBW;
  public b hBX;
  
  public by()
  {
    this((byte)0);
  }
  
  private by(byte paramByte)
  {
    AppMethodBeat.i(117354);
    this.hBW = new a();
    this.hBX = new b();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(117354);
  }
  
  public static final class a {}
  
  public static final class b
  {
    public boolean hBY;
    public String msg;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.autogen.a.by
 * JD-Core Version:    0.7.0.1
 */