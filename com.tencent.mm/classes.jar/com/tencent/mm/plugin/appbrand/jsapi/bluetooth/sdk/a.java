package com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a
{
  public static a hFM;
  public static boolean hFP;
  public static boolean hFQ;
  public static boolean hFS;
  public static boolean hFU;
  public static int hFV;
  public static boolean hFZ;
  public boolean arI;
  public int eAS;
  public boolean hFN;
  public long hFO;
  public boolean hFR;
  public boolean hFT;
  public String hFW;
  public int hFX;
  public boolean hFY;
  
  static
  {
    AppMethodBeat.i(94218);
    hFM = new a.a().aCm();
    hFP = false;
    hFQ = true;
    hFS = true;
    hFU = false;
    hFV = 5;
    hFZ = true;
    AppMethodBeat.o(94218);
  }
  
  public a(a.a parama)
  {
    this.eAS = parama.eAS;
    this.hFN = parama.hFN;
    this.hFO = parama.hFO;
    this.arI = parama.arI;
    this.hFR = parama.hFR;
    this.hFT = parama.hFT;
    this.hFW = parama.hFW;
    this.hFX = parama.hFX;
    this.hFY = parama.hFY;
  }
  
  public static void a(a parama)
  {
    hFM = parama;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(94217);
    String str = "BleConfig{interval=" + this.eAS + ", allowDuplicatesKey=" + this.hFN + ", actionTimeOutTime=" + this.hFO + ", debug=" + this.arI + ", mainThread=" + this.hFR + ", serial=" + this.hFT + ", mode='" + this.hFW + '\'' + ", actionDelayTime=" + this.hFX + '}';
    AppMethodBeat.o(94217);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a
 * JD-Core Version:    0.7.0.1
 */