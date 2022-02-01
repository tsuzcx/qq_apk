package com.tencent.mm.plugin.location.ui.impl;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelgeo.Addr;
import com.tencent.mm.protocal.protobuf.bxg;
import com.tencent.mm.sdk.platformtools.bt;

public final class f
{
  public double bPI;
  public double bPJ;
  public String dnB;
  public String mName;
  public String sVX;
  public String sVY;
  public String sVZ;
  public String sWa;
  public String sWb;
  public String sWc;
  public String sWd;
  public String sWe;
  public String sWf;
  public String sWg;
  public Addr sWh;
  public String sWi;
  public int sWj;
  public int type;
  
  public f()
  {
    this.sWj = -1;
  }
  
  public f(bxg parambxg, String paramString)
  {
    AppMethodBeat.i(56098);
    this.sWj = -1;
    this.mName = parambxg.Name;
    this.sVX = parambxg.DTI;
    this.bPJ = parambxg.CJD;
    this.bPI = parambxg.CJE;
    this.sVY = parambxg.DTJ;
    this.sVZ = parambxg.ubD;
    this.sWa = parambxg.DTK;
    this.sWb = parambxg.ijN;
    this.sWc = parambxg.ijO;
    this.sWd = parambxg.Dbi;
    this.sWe = parambxg.Dbj;
    this.sWf = parambxg.DTL;
    this.sWi = paramString;
    this.sWh = new Addr();
    this.sWh.hdQ = this.sVX;
    this.sWh.hdS = this.sWc;
    this.sWh.hdT = this.sWc;
    this.sWh.hdU = this.sWd;
    this.sWh.hdW = this.sWf;
    this.sWh.hdZ = this.mName;
    this.sWh.hdR = this.sWb;
    this.sWh.hec = ((float)parambxg.CJD);
    this.sWh.heb = ((float)parambxg.CJE);
    this.type = 0;
    AppMethodBeat.o(56098);
  }
  
  public final boolean c(Addr paramAddr)
  {
    AppMethodBeat.i(56099);
    this.sWh = paramAddr;
    if (!bt.isNullOrNil(paramAddr.hdQ)) {
      this.mName = paramAddr.hdQ;
    }
    if (!bt.isNullOrNil(paramAddr.hdU)) {
      this.sVX = paramAddr.hdU;
    }
    if (!bt.isNullOrNil(paramAddr.hdV)) {
      this.sVX += paramAddr.hdV;
    }
    if (!bt.isNullOrNil(paramAddr.hdW)) {
      this.sVX += paramAddr.hdW;
    }
    if (!bt.isNullOrNil(paramAddr.hdX)) {
      this.sVX += paramAddr.hdX;
    }
    this.bPI = paramAddr.heb;
    this.bPJ = paramAddr.hec;
    this.sWb = paramAddr.hdR;
    this.sWc = paramAddr.hdS;
    this.sWd = paramAddr.hdU;
    this.sWe = paramAddr.hdW;
    this.sWg = paramAddr.hdY;
    this.sWf = paramAddr.hdX;
    this.dnB = paramAddr.hea;
    if ((bt.isNullOrNil(this.mName)) && (bt.isNullOrNil(this.sVX)))
    {
      AppMethodBeat.o(56099);
      return false;
    }
    AppMethodBeat.o(56099);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.location.ui.impl.f
 * JD-Core Version:    0.7.0.1
 */