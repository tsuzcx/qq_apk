package com.tencent.mm.plugin.location.ui.impl;

import com.tencent.mm.modelgeo.Addr;
import com.tencent.mm.protocal.c.bco;

public final class f
{
  public double aWE;
  public double aWF;
  public String lJE;
  public String lJF;
  public String lJG;
  public String lJH;
  public String lJI;
  public String lJJ;
  public String lJK;
  public String lJL;
  public String lJM;
  public String lJN;
  public Addr lJO;
  public String lJP;
  public String lJQ;
  public int lJR = -1;
  public String mName;
  public int type;
  
  public f() {}
  
  public f(bco parambco, String paramString)
  {
    this.mName = parambco.kRZ;
    this.lJE = parambco.txR;
    this.aWF = parambco.sDm;
    this.aWE = parambco.sDn;
    this.lJF = parambco.txS;
    this.lJG = parambco.mEb;
    this.lJH = parambco.txT;
    this.lJI = parambco.ffi;
    this.lJJ = parambco.ffj;
    this.lJK = parambco.sQh;
    this.lJL = parambco.sQi;
    this.lJM = parambco.txU;
    this.lJP = paramString;
    this.lJO = new Addr();
    this.lJO.ekZ = this.lJE;
    this.lJO.elb = this.lJJ;
    this.lJO.elc = this.lJJ;
    this.lJO.eld = this.lJK;
    this.lJO.elf = this.lJM;
    this.lJO.eli = this.mName;
    this.lJO.ela = this.lJI;
    this.lJO.ell = ((float)parambco.sDm);
    this.lJO.elk = ((float)parambco.sDn);
    this.type = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.location.ui.impl.f
 * JD-Core Version:    0.7.0.1
 */