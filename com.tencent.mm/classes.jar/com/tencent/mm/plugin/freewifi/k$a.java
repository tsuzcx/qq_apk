package com.tencent.mm.plugin.freewifi;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class k$a
{
  public String bssid;
  public int cCy;
  public String coX;
  public String coY;
  public String eev;
  public String kMp;
  private int mIA;
  public String mIB;
  public String mIC;
  public int mIE;
  public long mIF;
  public String mIG;
  public String mIH;
  private long mII;
  public int result;
  public String ssid;
  
  public final k bAe()
  {
    AppMethodBeat.i(20607);
    k localk = new k((byte)0);
    k.a(localk, this.ssid);
    k.b(localk, this.bssid);
    k.c(localk, this.coY);
    k.d(localk, this.coX);
    k.a(localk, this.mIA);
    k.e(localk, this.mIB);
    k.f(localk, this.mIC);
    k.g(localk, this.kMp);
    k.b(localk, this.mIE);
    k.a(localk, Integer.valueOf("1" + String.format("%03d", new Object[] { Integer.valueOf(this.mIE) }) + String.format("%03d", new Object[] { Long.valueOf(this.mIF) })).intValue());
    k.h(localk, this.mIG);
    k.c(localk, this.result);
    k.d(localk, this.cCy);
    k.i(localk, this.mIH);
    k.b(localk, this.mII);
    k.j(localk, this.eev);
    AppMethodBeat.o(20607);
    return localk;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.k.a
 * JD-Core Version:    0.7.0.1
 */