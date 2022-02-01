package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class ea
  extends IEvent
{
  public a dHf;
  public b dHg;
  
  public ea()
  {
    this((byte)0);
  }
  
  private ea(byte paramByte)
  {
    AppMethodBeat.i(115984);
    this.dHf = new a();
    this.dHg = new b();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(115984);
  }
  
  public static final class a
  {
    public boolean dGW = false;
  }
  
  public static final class b
  {
    public boolean dGX;
    public String dHh;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.a.ea
 * JD-Core Version:    0.7.0.1
 */