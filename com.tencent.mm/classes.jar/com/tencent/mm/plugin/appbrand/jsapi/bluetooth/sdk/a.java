package com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a
{
  public static int oIA;
  public static boolean oIE;
  private static volatile a oIr;
  public static boolean oIu;
  public static boolean oIv;
  public static boolean oIx;
  public static boolean oIz;
  public boolean aGM;
  public int interval;
  public String oIB;
  public int oIC;
  public boolean oID;
  public boolean oIF;
  public boolean oIG;
  public boolean oIs;
  public long oIt;
  public boolean oIw;
  public boolean oIy;
  
  static
  {
    AppMethodBeat.i(144530);
    oIr = null;
    oIu = false;
    oIv = true;
    oIx = true;
    oIz = false;
    oIA = 5;
    oIE = true;
    AppMethodBeat.o(144530);
  }
  
  public a(a parama)
  {
    this.interval = parama.interval;
    this.oIs = parama.oIs;
    this.oIt = parama.oIt;
    this.aGM = parama.aGM;
    this.oIw = parama.oIw;
    this.oIy = parama.oIy;
    this.oIB = parama.oIB;
    this.oIC = parama.oIC;
    this.oID = parama.oID;
    this.oIF = parama.oIF;
    this.oIG = parama.oIG;
  }
  
  public static void a(a parama)
  {
    try
    {
      oIr = parama;
      return;
    }
    finally
    {
      parama = finally;
      throw parama;
    }
  }
  
  public static a bQQ()
  {
    try
    {
      AppMethodBeat.i(200043);
      if (oIr == null) {
        oIr = new a().bQR();
      }
      a locala = oIr;
      AppMethodBeat.o(200043);
      return locala;
    }
    finally {}
  }
  
  public final String toString()
  {
    AppMethodBeat.i(144529);
    String str = "BleConfig{interval=" + this.interval + ", allowDuplicatesKey=" + this.oIs + ", actionTimeOutTime=" + this.oIt + ", debug=" + this.aGM + ", mainThread=" + this.oIw + ", serial=" + this.oIy + ", mode='" + this.oIB + '\'' + ", actionDelayTime=" + this.oIC + ", parseScanRecordManual=" + this.oIF + ", scanWorkaround=" + this.oIG + '}';
    AppMethodBeat.o(144529);
    return str;
  }
  
  public static final class a
  {
    public boolean aGM = a.oIu;
    public int interval = 0;
    public String oIB = "medium";
    public int oIC = 10;
    public boolean oID = true;
    public boolean oIF = true;
    public boolean oIG = true;
    public boolean oIs = false;
    long oIt = 20000L;
    public boolean oIw = a.oIv;
    public boolean oIy = a.oIx;
    
    public final a bQR()
    {
      AppMethodBeat.i(144528);
      a locala = new a(this);
      AppMethodBeat.o(144528);
      return locala;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a
 * JD-Core Version:    0.7.0.1
 */