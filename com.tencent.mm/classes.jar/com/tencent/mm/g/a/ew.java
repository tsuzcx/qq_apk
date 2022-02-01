package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class ew
  extends IEvent
{
  public a dIh;
  public b dIi;
  
  public ew()
  {
    this((byte)0);
  }
  
  private ew(byte paramByte)
  {
    AppMethodBeat.i(116006);
    this.dIh = new a();
    this.dIi = new b();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(116006);
  }
  
  public static final class a
  {
    public String brandName;
    public String dGL;
    public byte[] data;
  }
  
  public static final class b
  {
    public boolean dGX;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.a.ew
 * JD-Core Version:    0.7.0.1
 */