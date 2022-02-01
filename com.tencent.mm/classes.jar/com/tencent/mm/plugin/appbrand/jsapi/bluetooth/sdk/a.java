package com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a
{
  public static a jIN;
  public static boolean jIQ;
  public static boolean jIR;
  public static boolean jIT;
  public static boolean jIV;
  public static int jIW;
  public static boolean jJa;
  public boolean aMt;
  public int fWw;
  public boolean jIO;
  public long jIP;
  public boolean jIS;
  public boolean jIU;
  public String jIX;
  public int jIY;
  public boolean jIZ;
  
  static
  {
    AppMethodBeat.i(144530);
    jIN = new a().aYN();
    jIQ = false;
    jIR = true;
    jIT = true;
    jIV = false;
    jIW = 5;
    jJa = true;
    AppMethodBeat.o(144530);
  }
  
  public a(a parama)
  {
    this.fWw = parama.fWw;
    this.jIO = parama.jIO;
    this.jIP = parama.jIP;
    this.aMt = parama.aMt;
    this.jIS = parama.jIS;
    this.jIU = parama.jIU;
    this.jIX = parama.jIX;
    this.jIY = parama.jIY;
    this.jIZ = parama.jIZ;
  }
  
  public static void a(a parama)
  {
    jIN = parama;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(144529);
    String str = "BleConfig{interval=" + this.fWw + ", allowDuplicatesKey=" + this.jIO + ", actionTimeOutTime=" + this.jIP + ", debug=" + this.aMt + ", mainThread=" + this.jIS + ", serial=" + this.jIU + ", mode='" + this.jIX + '\'' + ", actionDelayTime=" + this.jIY + '}';
    AppMethodBeat.o(144529);
    return str;
  }
  
  public static final class a
  {
    public boolean aMt = a.jIQ;
    public int fWw = 0;
    public boolean jIO = false;
    long jIP = 20000L;
    public boolean jIS = a.jIR;
    public boolean jIU = a.jIT;
    public String jIX = "medium";
    public int jIY = 10;
    public boolean jIZ = true;
    
    public final a aYN()
    {
      AppMethodBeat.i(144528);
      a locala = new a(this);
      AppMethodBeat.o(144528);
      return locala;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.a
 * JD-Core Version:    0.7.0.1
 */