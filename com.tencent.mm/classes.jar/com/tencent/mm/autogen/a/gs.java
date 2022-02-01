package com.tencent.mm.autogen.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class gs
  extends IEvent
{
  public a hHj;
  public b hHk;
  
  public gs()
  {
    this((byte)0);
  }
  
  private gs(byte paramByte)
  {
    AppMethodBeat.i(116020);
    this.hHj = new a();
    this.hHk = new b();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(116020);
  }
  
  public static final class a
  {
    public int op;
    public String username;
  }
  
  public static final class b
  {
    public String fileName;
    public boolean hCQ = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.autogen.a.gs
 * JD-Core Version:    0.7.0.1
 */