package com.tencent.mm.autogen.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class sn
  extends IEvent
{
  public a hVJ;
  public b hVK;
  
  public sn()
  {
    this((byte)0);
  }
  
  private sn(byte paramByte)
  {
    AppMethodBeat.i(149880);
    this.hVJ = new a();
    this.hVK = new b();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(149880);
  }
  
  public static final class a
  {
    public int eQp = 0;
    public String hVL;
    public String scanResult;
  }
  
  public static final class b
  {
    public int ret = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.autogen.a.sn
 * JD-Core Version:    0.7.0.1
 */