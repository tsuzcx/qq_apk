package com.tencent.mm.autogen.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class o
  extends IEvent
{
  public a hzg;
  public b hzh;
  
  public o()
  {
    this((byte)0);
  }
  
  private o(byte paramByte)
  {
    AppMethodBeat.i(121047);
    this.hzg = new a();
    this.hzh = new b();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(121047);
  }
  
  public static final class a
  {
    public String hzi;
  }
  
  public static final class b
  {
    public int hzj;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.autogen.a.o
 * JD-Core Version:    0.7.0.1
 */