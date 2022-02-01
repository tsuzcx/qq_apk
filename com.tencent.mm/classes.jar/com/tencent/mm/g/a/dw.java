package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class dw
  extends IEvent
{
  public a dGU;
  public b dGV;
  
  public dw()
  {
    this((byte)0);
  }
  
  private dw(byte paramByte)
  {
    AppMethodBeat.i(115980);
    this.dGU = new a();
    this.dGV = new b();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(115980);
  }
  
  public static final class a
  {
    public String brandName;
    public String dGL;
    public boolean dGW = false;
  }
  
  public static final class b
  {
    public boolean dGX;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.a.dw
 * JD-Core Version:    0.7.0.1
 */