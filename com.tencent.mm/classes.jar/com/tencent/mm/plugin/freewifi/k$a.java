package com.tencent.mm.plugin.freewifi;

public final class k$a
{
  public String bHI;
  public String bHJ;
  public int bUR;
  public String bssid;
  public String dmU;
  public String iGw;
  private int kmO;
  public String kmP;
  public String kmQ;
  public int kmR;
  public long kmS;
  public String kmT;
  public String kmU;
  private long kmV;
  public int result;
  public String ssid;
  
  public final k aTz()
  {
    k localk = new k((byte)0);
    k.a(localk, this.ssid);
    k.b(localk, this.bssid);
    k.c(localk, this.bHJ);
    k.d(localk, this.bHI);
    k.a(localk, this.kmO);
    k.e(localk, this.kmP);
    k.f(localk, this.kmQ);
    k.g(localk, this.iGw);
    k.b(localk, this.kmR);
    k.a(localk, Integer.valueOf("1" + String.format("%03d", new Object[] { Integer.valueOf(this.kmR) }) + String.format("%03d", new Object[] { Long.valueOf(this.kmS) })).intValue());
    k.h(localk, this.kmT);
    k.c(localk, this.result);
    k.d(localk, this.bUR);
    k.i(localk, this.kmU);
    k.b(localk, this.kmV);
    k.j(localk, this.dmU);
    return localk;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.k.a
 * JD-Core Version:    0.7.0.1
 */