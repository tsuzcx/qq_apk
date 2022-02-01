package com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a
{
  public static a kHB;
  public static boolean kHE;
  public static boolean kHF;
  public static boolean kHH;
  public static boolean kHJ;
  public static int kHK;
  public static boolean kHO;
  public boolean aXD;
  public int gxu;
  public boolean kHC;
  public long kHD;
  public boolean kHG;
  public boolean kHI;
  public String kHL;
  public int kHM;
  public boolean kHN;
  
  static
  {
    AppMethodBeat.i(144530);
    kHB = new a().bjW();
    kHE = false;
    kHF = true;
    kHH = true;
    kHJ = false;
    kHK = 5;
    kHO = true;
    AppMethodBeat.o(144530);
  }
  
  public a(a parama)
  {
    this.gxu = parama.gxu;
    this.kHC = parama.kHC;
    this.kHD = parama.kHD;
    this.aXD = parama.aXD;
    this.kHG = parama.kHG;
    this.kHI = parama.kHI;
    this.kHL = parama.kHL;
    this.kHM = parama.kHM;
    this.kHN = parama.kHN;
  }
  
  public static void a(a parama)
  {
    kHB = parama;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(144529);
    String str = "BleConfig{interval=" + this.gxu + ", allowDuplicatesKey=" + this.kHC + ", actionTimeOutTime=" + this.kHD + ", debug=" + this.aXD + ", mainThread=" + this.kHG + ", serial=" + this.kHI + ", mode='" + this.kHL + '\'' + ", actionDelayTime=" + this.kHM + '}';
    AppMethodBeat.o(144529);
    return str;
  }
  
  public static final class a
  {
    public boolean aXD = a.kHE;
    public int gxu = 0;
    public boolean kHC = false;
    long kHD = 20000L;
    public boolean kHG = a.kHF;
    public boolean kHI = a.kHH;
    public String kHL = "medium";
    public int kHM = 10;
    public boolean kHN = true;
    
    public final a bjW()
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