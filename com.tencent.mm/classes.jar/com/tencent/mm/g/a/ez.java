package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class ez
  extends IEvent
{
  public a dIp;
  public b dIq;
  
  public ez()
  {
    this((byte)0);
  }
  
  private ez(byte paramByte)
  {
    AppMethodBeat.i(116009);
    this.dIp = new a();
    this.dIq = new b();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(116009);
  }
  
  public static final class a
  {
    public String dGL;
    public String dIr;
    public int progress;
  }
  
  public static final class b {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.g.a.ez
 * JD-Core Version:    0.7.0.1
 */