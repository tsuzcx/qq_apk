package com.tencent.mm.autogen.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class sm
  extends IEvent
{
  public a hVG;
  public b hVH;
  
  public sm()
  {
    this((byte)0);
  }
  
  private sm(byte paramByte)
  {
    AppMethodBeat.i(149879);
    this.hVG = new a();
    this.hVH = new b();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(149879);
  }
  
  public static final class a
  {
    public int eQp = 0;
    public int hQp = 10;
    public String hVI;
    public String label;
    public double lat = -1.0D;
    public double lng = -1.0D;
  }
  
  public static final class b
  {
    public int ret = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.autogen.a.sm
 * JD-Core Version:    0.7.0.1
 */