package com.tencent.mm.autogen.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class sw
  extends IEvent
{
  public a hWl;
  public b hWm;
  
  public sw()
  {
    this((byte)0);
  }
  
  private sw(byte paramByte)
  {
    AppMethodBeat.i(127289);
    this.hWl = new a();
    this.hWm = new b();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(127289);
  }
  
  public static final class a
  {
    public String hWn;
    public String talker;
  }
  
  public static final class b
  {
    public boolean hCQ = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.autogen.a.sw
 * JD-Core Version:    0.7.0.1
 */