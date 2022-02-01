package com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a
{
  public static a kEm;
  public static boolean kEp;
  public static boolean kEq;
  public static boolean kEs;
  public static boolean kEu;
  public static int kEv;
  public static boolean kEz;
  public boolean aXD;
  public int guN;
  public boolean kEn;
  public long kEo;
  public boolean kEr;
  public boolean kEt;
  public String kEw;
  public int kEx;
  public boolean kEy;
  
  static
  {
    AppMethodBeat.i(144530);
    kEm = new a().bjn();
    kEp = false;
    kEq = true;
    kEs = true;
    kEu = false;
    kEv = 5;
    kEz = true;
    AppMethodBeat.o(144530);
  }
  
  public a(a parama)
  {
    this.guN = parama.guN;
    this.kEn = parama.kEn;
    this.kEo = parama.kEo;
    this.aXD = parama.aXD;
    this.kEr = parama.kEr;
    this.kEt = parama.kEt;
    this.kEw = parama.kEw;
    this.kEx = parama.kEx;
    this.kEy = parama.kEy;
  }
  
  public static void a(a parama)
  {
    kEm = parama;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(144529);
    String str = "BleConfig{interval=" + this.guN + ", allowDuplicatesKey=" + this.kEn + ", actionTimeOutTime=" + this.kEo + ", debug=" + this.aXD + ", mainThread=" + this.kEr + ", serial=" + this.kEt + ", mode='" + this.kEw + '\'' + ", actionDelayTime=" + this.kEx + '}';
    AppMethodBeat.o(144529);
    return str;
  }
  
  public static final class a
  {
    public boolean aXD = a.kEp;
    public int guN = 0;
    public boolean kEn = false;
    long kEo = 20000L;
    public boolean kEr = a.kEq;
    public boolean kEt = a.kEs;
    public String kEw = "medium";
    public int kEx = 10;
    public boolean kEy = true;
    
    public final a bjn()
    {
      AppMethodBeat.i(144528);
      a locala = new a(this);
      AppMethodBeat.o(144528);
      return locala;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a
 * JD-Core Version:    0.7.0.1
 */