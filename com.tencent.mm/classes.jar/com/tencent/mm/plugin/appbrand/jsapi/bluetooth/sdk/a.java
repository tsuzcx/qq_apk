package com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a
{
  public static boolean kjB;
  public static a kjo;
  public static boolean kjr;
  public static boolean kjs;
  public static boolean kju;
  public static boolean kjw;
  public static int kjx;
  public boolean aNj;
  public int gbd;
  public boolean kjA;
  public boolean kjp;
  public long kjq;
  public boolean kjt;
  public boolean kjv;
  public String kjy;
  public int kjz;
  
  static
  {
    AppMethodBeat.i(144530);
    kjo = new a().bfJ();
    kjr = false;
    kjs = true;
    kju = true;
    kjw = false;
    kjx = 5;
    kjB = true;
    AppMethodBeat.o(144530);
  }
  
  public a(a parama)
  {
    this.gbd = parama.gbd;
    this.kjp = parama.kjp;
    this.kjq = parama.kjq;
    this.aNj = parama.aNj;
    this.kjt = parama.kjt;
    this.kjv = parama.kjv;
    this.kjy = parama.kjy;
    this.kjz = parama.kjz;
    this.kjA = parama.kjA;
  }
  
  public static void a(a parama)
  {
    kjo = parama;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(144529);
    String str = "BleConfig{interval=" + this.gbd + ", allowDuplicatesKey=" + this.kjp + ", actionTimeOutTime=" + this.kjq + ", debug=" + this.aNj + ", mainThread=" + this.kjt + ", serial=" + this.kjv + ", mode='" + this.kjy + '\'' + ", actionDelayTime=" + this.kjz + '}';
    AppMethodBeat.o(144529);
    return str;
  }
  
  public static final class a
  {
    public boolean aNj = a.kjr;
    public int gbd = 0;
    public boolean kjA = true;
    public boolean kjp = false;
    long kjq = 20000L;
    public boolean kjt = a.kjs;
    public boolean kjv = a.kju;
    public String kjy = "medium";
    public int kjz = 10;
    
    public final a bfJ()
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