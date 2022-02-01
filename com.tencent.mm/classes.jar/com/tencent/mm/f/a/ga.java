package com.tencent.mm.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class ga
  extends IEvent
{
  public a fBM;
  public b fBN;
  
  public ga()
  {
    this((byte)0);
  }
  
  private ga(byte paramByte)
  {
    AppMethodBeat.i(19805);
    this.fBM = new a();
    this.fBN = new b();
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
    public int fBO = 0;
    public int fBP = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.f.a.ga
 * JD-Core Version:    0.7.0.1
 */