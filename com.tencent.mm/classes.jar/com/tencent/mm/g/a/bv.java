package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class bv
  extends IEvent
{
  public a dFa;
  
  public bv()
  {
    this((byte)0);
  }
  
  private bv(byte paramByte)
  {
    AppMethodBeat.i(19792);
    this.dFa = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(19792);
  }
  
  public static final class a
  {
    public String bssid;
    public String dFb;
    public String dFc;
    public String dFd;
    public String dFe;
    public String dFf;
    public String ssid;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.g.a.bv
 * JD-Core Version:    0.7.0.1
 */