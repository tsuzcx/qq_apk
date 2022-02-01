package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class pz
  extends IEvent
{
  public a dWg;
  public b dWh;
  
  public pz()
  {
    this((byte)0);
  }
  
  private pz(byte paramByte)
  {
    AppMethodBeat.i(149879);
    this.dWg = new a();
    this.dWh = new b();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(149879);
  }
  
  public static final class a
  {
    public int cSx = 0;
    public int dRt = 10;
    public String dWi;
    public String label;
    public double lat = -1.0D;
    public double lng = -1.0D;
  }
  
  public static final class b
  {
    public int ret = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.g.a.pz
 * JD-Core Version:    0.7.0.1
 */