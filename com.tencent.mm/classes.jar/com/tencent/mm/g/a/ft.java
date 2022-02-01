package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class ft
  extends IEvent
{
  public a dIV;
  public b dIW;
  
  public ft()
  {
    this((byte)0);
  }
  
  private ft(byte paramByte)
  {
    AppMethodBeat.i(19805);
    this.dIV = new a();
    this.dIW = new b();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(19805);
  }
  
  public static final class a
  {
    public String bssid;
    public int dIX;
    public String ssid;
    public int version = 1;
  }
  
  public static final class b
  {
    public int dIY = 0;
    public int dIZ = 0;
    public String dJa;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.a.ft
 * JD-Core Version:    0.7.0.1
 */