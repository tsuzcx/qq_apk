package com.tencent.mm.autogen.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class gl
  extends IEvent
{
  public a hGB;
  public b hGC;
  
  public gl()
  {
    this((byte)0);
  }
  
  private gl(byte paramByte)
  {
    AppMethodBeat.i(19805);
    this.hGB = new a();
    this.hGC = new b();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(19805);
  }
  
  public static final class a
  {
    public String bssid;
    public int rssi;
    public String ssid;
    public int version = 1;
  }
  
  public static final class b
  {
    public String errmsg;
    public int hGD = 0;
    public int hGE = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.autogen.a.gl
 * JD-Core Version:    0.7.0.1
 */