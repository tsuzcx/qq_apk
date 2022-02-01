package com.tencent.mm.autogen.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class le
  extends IEvent
{
  public a hMU;
  public b hMV;
  
  public le()
  {
    this((byte)0);
  }
  
  private le(byte paramByte)
  {
    AppMethodBeat.i(155368);
    this.hMU = new a();
    this.hMV = new b();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(155368);
  }
  
  public static final class a
  {
    public String hMW;
  }
  
  public static final class b
  {
    public String userName;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.autogen.a.le
 * JD-Core Version:    0.7.0.1
 */