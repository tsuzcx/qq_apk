package com.tencent.mm.autogen.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class adj
  extends IEvent
{
  public a ihv;
  public b ihw;
  
  public adj()
  {
    this((byte)0);
  }
  
  private adj(byte paramByte)
  {
    AppMethodBeat.i(116058);
    this.ihv = new a();
    this.ihw = new b();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(116058);
  }
  
  public static final class a
  {
    public String ihx;
  }
  
  public static final class b
  {
    public int ihA = -1;
    public int ihy = -1;
    public int ihz = -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.autogen.a.adj
 * JD-Core Version:    0.7.0.1
 */