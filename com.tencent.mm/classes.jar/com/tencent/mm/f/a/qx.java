package com.tencent.mm.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class qx
  extends IEvent
{
  public a fPL;
  public b fPM;
  
  public qx()
  {
    this((byte)0);
  }
  
  private qx(byte paramByte)
  {
    AppMethodBeat.i(149879);
    this.fPL = new a();
    this.fPM = new b();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(149879);
  }
  
  public static final class a
  {
    public int cUP = 0;
    public int fKJ = 10;
    public String fPN;
    public String label;
    public double lat = -1.0D;
    public double lng = -1.0D;
  }
  
  public static final class b
  {
    public int ret = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.f.a.qx
 * JD-Core Version:    0.7.0.1
 */