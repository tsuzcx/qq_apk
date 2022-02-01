package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class fi
  extends IEvent
{
  public a dIG;
  public b dIH;
  
  public fi()
  {
    this((byte)0);
  }
  
  private fi(byte paramByte)
  {
    AppMethodBeat.i(19801);
    this.dIG = new a();
    this.dIH = new b();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(19801);
  }
  
  public static final class a
  {
    public byte[] data;
    public String mac;
  }
  
  public static final class b
  {
    public boolean dGX;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.g.a.fi
 * JD-Core Version:    0.7.0.1
 */