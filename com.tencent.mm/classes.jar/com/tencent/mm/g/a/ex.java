package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class ex
  extends IEvent
{
  public a dIj;
  public b dIk;
  
  public ex()
  {
    this((byte)0);
  }
  
  private ex(byte paramByte)
  {
    AppMethodBeat.i(116007);
    this.dIj = new a();
    this.dIk = new b();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(116007);
  }
  
  public static final class a
  {
    public String brandName;
    public String dGL;
    public String data;
  }
  
  public static final class b
  {
    public boolean dGX;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.a.ex
 * JD-Core Version:    0.7.0.1
 */