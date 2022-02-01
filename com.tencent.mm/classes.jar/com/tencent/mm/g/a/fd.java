package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class fd
  extends IEvent
{
  public b dIA;
  public a dIz;
  
  public fd()
  {
    this((byte)0);
  }
  
  private fd(byte paramByte)
  {
    AppMethodBeat.i(19796);
    this.dIz = new a();
    this.dIA = new b();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(19796);
  }
  
  public static final class a
  {
    public boolean dGW = false;
    public String mac;
  }
  
  public static final class b
  {
    public boolean dGX;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.g.a.fd
 * JD-Core Version:    0.7.0.1
 */