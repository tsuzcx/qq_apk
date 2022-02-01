package com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a
{
  private static volatile a lMc;
  public static boolean lMf;
  public static boolean lMg;
  public static boolean lMi;
  public static boolean lMk;
  public static int lMl;
  public static boolean lMp;
  public boolean aXs;
  public int gTn;
  public boolean lMd;
  public long lMe;
  public boolean lMh;
  public boolean lMj;
  public String lMm;
  public int lMn;
  public boolean lMo;
  public boolean lMq;
  
  static
  {
    AppMethodBeat.i(144530);
    lMc = null;
    lMf = false;
    lMg = true;
    lMi = true;
    lMk = false;
    lMl = 5;
    lMp = true;
    AppMethodBeat.o(144530);
  }
  
  public a(a parama)
  {
    this.gTn = parama.gTn;
    this.lMd = parama.lMd;
    this.lMe = parama.lMe;
    this.aXs = parama.aXs;
    this.lMh = parama.lMh;
    this.lMj = parama.lMj;
    this.lMm = parama.lMm;
    this.lMn = parama.lMn;
    this.lMo = parama.lMo;
    this.lMq = parama.lMq;
  }
  
  public static void a(a parama)
  {
    try
    {
      lMc = parama;
      return;
    }
    finally
    {
      parama = finally;
      throw parama;
    }
  }
  
  public static a bFm()
  {
    try
    {
      AppMethodBeat.i(215146);
      if (lMc == null) {
        lMc = new a().bFn();
      }
      a locala = lMc;
      AppMethodBeat.o(215146);
      return locala;
    }
    finally {}
  }
  
  public final String toString()
  {
    AppMethodBeat.i(144529);
    String str = "BleConfig{interval=" + this.gTn + ", allowDuplicatesKey=" + this.lMd + ", actionTimeOutTime=" + this.lMe + ", debug=" + this.aXs + ", mainThread=" + this.lMh + ", serial=" + this.lMj + ", mode='" + this.lMm + '\'' + ", actionDelayTime=" + this.lMn + ", parseScanRecordManual=" + this.lMq + '}';
    AppMethodBeat.o(144529);
    return str;
  }
  
  public static final class a
  {
    public boolean aXs = a.lMf;
    public int gTn = 0;
    public boolean lMd = false;
    long lMe = 20000L;
    public boolean lMh = a.lMg;
    public boolean lMj = a.lMi;
    public String lMm = "medium";
    public int lMn = 10;
    public boolean lMo = true;
    public boolean lMq = true;
    
    public final a bFn()
    {
      AppMethodBeat.i(144528);
      a locala = new a(this);
      AppMethodBeat.o(144528);
      return locala;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a
 * JD-Core Version:    0.7.0.1
 */