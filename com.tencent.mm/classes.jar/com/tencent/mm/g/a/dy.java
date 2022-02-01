package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class dy
  extends IEvent
{
  public a dHa;
  public b dHb;
  
  public dy()
  {
    this((byte)0);
  }
  
  private dy(byte paramByte)
  {
    AppMethodBeat.i(115982);
    this.dHa = new a();
    this.dHb = new b();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(115982);
  }
  
  public static final class a
  {
    public String dGL;
    public String dHc;
  }
  
  public static final class b
  {
    public boolean dGX;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.a.dy
 * JD-Core Version:    0.7.0.1
 */