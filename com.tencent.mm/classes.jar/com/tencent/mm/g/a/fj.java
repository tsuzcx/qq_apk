package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class fj
  extends IEvent
{
  public a dII;
  public b dIJ;
  
  public fj()
  {
    this((byte)0);
  }
  
  private fj(byte paramByte)
  {
    AppMethodBeat.i(19802);
    this.dII = new a();
    this.dIJ = new b();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(19802);
  }
  
  public static final class a
  {
    public String brandName;
    public byte[] data;
    public String mac;
  }
  
  public static final class b
  {
    public boolean dGX;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.g.a.fj
 * JD-Core Version:    0.7.0.1
 */