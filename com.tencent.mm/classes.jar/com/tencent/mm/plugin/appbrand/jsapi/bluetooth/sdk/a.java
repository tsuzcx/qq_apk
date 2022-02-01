package com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;

public final class a
{
  private static volatile a rMa;
  public static boolean rMd;
  public static boolean rMe;
  public static boolean rMg;
  public static boolean rMi;
  public static int rMj;
  public static boolean rMn;
  private static volatile boolean rMq;
  public boolean debug;
  public int interval;
  public boolean rMb;
  public long rMc;
  public boolean rMf;
  public boolean rMh;
  public String rMk;
  public int rMl;
  public boolean rMm;
  public boolean rMo;
  public boolean rMp;
  
  static
  {
    AppMethodBeat.i(144530);
    rMa = null;
    rMd = false;
    rMe = true;
    rMg = true;
    rMi = false;
    rMj = 5;
    rMn = true;
    rMq = true;
    AppMethodBeat.o(144530);
  }
  
  public a(a parama)
  {
    this.interval = parama.interval;
    this.rMb = parama.rMb;
    this.rMc = parama.rMc;
    this.debug = parama.debug;
    this.rMf = parama.rMf;
    this.rMh = parama.rMh;
    this.rMk = parama.rMk;
    this.rMl = parama.rMl;
    this.rMm = parama.rMm;
    this.rMo = parama.rMo;
    this.rMp = parama.rMp;
  }
  
  public static void a(a parama)
  {
    try
    {
      rMa = parama;
      return;
    }
    finally
    {
      parama = finally;
      throw parama;
    }
  }
  
  public static a cqY()
  {
    try
    {
      AppMethodBeat.i(329685);
      if (rMa == null) {
        rMa = new a().cra();
      }
      a locala = rMa;
      AppMethodBeat.o(329685);
      return locala;
    }
    finally {}
  }
  
  public static boolean cqZ()
  {
    AppMethodBeat.i(329690);
    Log.i("MicroMsg.Ble.BleConfig", "isDefaultRefreshCache, defaultRefreshCache: " + rMq);
    boolean bool = rMq;
    AppMethodBeat.o(329690);
    return bool;
  }
  
  public static void jg(boolean paramBoolean)
  {
    AppMethodBeat.i(329688);
    Log.i("MicroMsg.Ble.BleConfig", "setDefaultRefreshCache, defaultRefreshCache: ".concat(String.valueOf(paramBoolean)));
    rMq = paramBoolean;
    AppMethodBeat.o(329688);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(144529);
    String str = "BleConfig{interval=" + this.interval + ", allowDuplicatesKey=" + this.rMb + ", actionTimeOutTime=" + this.rMc + ", debug=" + this.debug + ", mainThread=" + this.rMf + ", serial=" + this.rMh + ", mode='" + this.rMk + '\'' + ", actionDelayTime=" + this.rMl + ", parseScanRecordManual=" + this.rMo + ", scanWorkaround=" + this.rMp + '}';
    AppMethodBeat.o(144529);
    return str;
  }
  
  public static final class a
  {
    public boolean debug;
    public int interval;
    public boolean rMb;
    long rMc;
    public boolean rMf;
    public boolean rMh;
    public String rMk;
    public int rMl;
    public boolean rMm;
    public boolean rMo;
    public boolean rMp;
    
    public a()
    {
      AppMethodBeat.i(329686);
      this.interval = 0;
      this.rMb = false;
      this.rMc = 20000L;
      this.debug = a.rMd;
      this.rMf = a.rMe;
      this.rMh = a.rMg;
      this.rMk = "medium";
      this.rMl = 10;
      this.rMm = a.cqZ();
      this.rMo = true;
      this.rMp = true;
      AppMethodBeat.o(329686);
    }
    
    public final a cra()
    {
      AppMethodBeat.i(144528);
      a locala = new a(this);
      AppMethodBeat.o(144528);
      return locala;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a
 * JD-Core Version:    0.7.0.1
 */