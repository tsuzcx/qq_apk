package com.tencent.mm.plugin.location.ui.impl;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelgeo.Addr;
import com.tencent.mm.protocal.protobuf.cxt;
import com.tencent.mm.sdk.platformtools.Util;

public final class f
{
  public double cik;
  public double cil;
  public String dPI;
  public String mName;
  public int type;
  public String yMN;
  public String yMO;
  public String yMP;
  public String yMQ;
  public String yMR;
  public String yMS;
  public String yMT;
  public String yMU;
  public String yMV;
  public String yMW;
  public Addr yMX;
  public String yMY;
  public int yMZ;
  
  public f()
  {
    this.yMZ = -1;
  }
  
  public f(cxt paramcxt, String paramString)
  {
    AppMethodBeat.i(56098);
    this.yMZ = -1;
    this.mName = paramcxt.Name;
    this.yMN = paramcxt.MCE;
    this.cil = paramcxt.KUt;
    this.cik = paramcxt.KUu;
    this.yMO = paramcxt.MCF;
    this.yMP = paramcxt.AAN;
    this.yMQ = paramcxt.MCG;
    this.yMR = paramcxt.kdZ;
    this.yMS = paramcxt.kea;
    this.yMT = paramcxt.LpJ;
    this.yMU = paramcxt.LpK;
    this.yMV = paramcxt.MCH;
    this.yMY = paramString;
    this.yMX = new Addr();
    this.yMX.iUO = this.yMN;
    this.yMX.iUQ = this.yMS;
    this.yMX.iUR = this.yMS;
    this.yMX.iUS = this.yMT;
    this.yMX.iUU = this.yMV;
    this.yMX.iUX = this.mName;
    this.yMX.iUP = this.yMR;
    this.yMX.iUZ = ((float)paramcxt.KUt);
    this.yMX.iUY = ((float)paramcxt.KUu);
    this.type = 0;
    AppMethodBeat.o(56098);
  }
  
  public final boolean c(Addr paramAddr)
  {
    AppMethodBeat.i(56099);
    this.yMX = paramAddr;
    if (!Util.isNullOrNil(paramAddr.iUO)) {
      this.mName = paramAddr.iUO;
    }
    if (!Util.isNullOrNil(paramAddr.iUS)) {
      this.yMN = paramAddr.iUS;
    }
    if (!Util.isNullOrNil(paramAddr.iUT)) {
      this.yMN += paramAddr.iUT;
    }
    if (!Util.isNullOrNil(paramAddr.iUU)) {
      this.yMN += paramAddr.iUU;
    }
    if (!Util.isNullOrNil(paramAddr.iUV)) {
      this.yMN += paramAddr.iUV;
    }
    this.cik = paramAddr.iUY;
    this.cil = paramAddr.iUZ;
    this.yMR = paramAddr.iUP;
    this.yMS = paramAddr.iUQ;
    this.yMT = paramAddr.iUS;
    this.yMU = paramAddr.iUU;
    this.yMW = paramAddr.iUW;
    this.yMV = paramAddr.iUV;
    this.dPI = paramAddr.request_id;
    if ((Util.isNullOrNil(this.mName)) && (Util.isNullOrNil(this.yMN)))
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