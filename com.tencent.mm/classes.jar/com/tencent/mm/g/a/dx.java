package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class dx
  extends IEvent
{
  public a dGY;
  public b dGZ;
  
  public dx()
  {
    this((byte)0);
  }
  
  private dx(byte paramByte)
  {
    AppMethodBeat.i(115981);
    this.dGY = new a();
    this.dGZ = new b();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(115981);
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
 * Qualified Name:     com.tencent.mm.g.a.dx
 * JD-Core Version:    0.7.0.1
 */