package com.tencent.mm.autogen.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class st
  extends IEvent
{
  public a hWb;
  public b hWc;
  
  public st()
  {
    this((byte)0);
  }
  
  private st(byte paramByte)
  {
    AppMethodBeat.i(9427);
    this.hWb = new a();
    this.hWc = new b();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(9427);
  }
  
  public static final class a
  {
    public long hCz;
    public String xml;
  }
  
  public static final class b
  {
    public String hWd;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.autogen.a.st
 * JD-Core Version:    0.7.0.1
 */