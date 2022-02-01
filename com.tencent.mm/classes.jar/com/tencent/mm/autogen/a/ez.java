package com.tencent.mm.autogen.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class ez
  extends IEvent
{
  public a hFg;
  public b hFh;
  
  public ez()
  {
    this((byte)0);
  }
  
  private ez(byte paramByte)
  {
    AppMethodBeat.i(115991);
    this.hFg = new a();
    this.hFh = new b();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(115991);
  }
  
  public static final class a
  {
    public boolean hFf = false;
    public String hFi;
  }
  
  public static final class b
  {
    public boolean hFj = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.autogen.a.ez
 * JD-Core Version:    0.7.0.1
 */