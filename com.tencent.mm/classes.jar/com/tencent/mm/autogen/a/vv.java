package com.tencent.mm.autogen.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class vv
  extends IEvent
{
  public a hZv;
  public b hZw;
  
  public vv()
  {
    this((byte)0);
  }
  
  private vv(byte paramByte)
  {
    AppMethodBeat.i(19833);
    this.hZv = new a();
    this.hZw = new b();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(19833);
  }
  
  public static final class a
  {
    public String userName;
  }
  
  public static final class b {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.autogen.a.vv
 * JD-Core Version:    0.7.0.1
 */