package com.tencent.mm.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class yx
  extends IEvent
{
  public a fYg;
  public b fYh;
  
  public yx()
  {
    this((byte)0);
  }
  
  private yx(byte paramByte)
  {
    AppMethodBeat.i(149891);
    this.fYg = new a();
    this.fYh = new b();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(149891);
  }
  
  public static final class a
  {
    public boolean fYi = false;
    public boolean fYj = false;
  }
  
  public static final class b
  {
    public String fYk;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.f.a.yx
 * JD-Core Version:    0.7.0.1
 */