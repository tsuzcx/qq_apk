package com.tencent.mm.autogen.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class dg
  extends IEvent
{
  public a hDh;
  public b hDi;
  
  public dg()
  {
    this((byte)0);
  }
  
  private dg(byte paramByte)
  {
    AppMethodBeat.i(369402);
    this.hDh = new a();
    this.hDi = new b();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(369402);
  }
  
  public static final class a
  {
    public String path;
  }
  
  public static final class b
  {
    public String[] hDj;
    public boolean isTimeout = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.autogen.a.dg
 * JD-Core Version:    0.7.0.1
 */