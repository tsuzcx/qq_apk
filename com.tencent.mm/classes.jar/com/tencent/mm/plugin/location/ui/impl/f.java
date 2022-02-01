package com.tencent.mm.plugin.location.ui.impl;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelgeo.Addr;
import com.tencent.mm.protocal.protobuf.ccb;
import com.tencent.mm.sdk.platformtools.bs;

public final class f
{
  public double bNq;
  public double bNr;
  public String dlj;
  public String mName;
  public int type;
  public String uek;
  public String uel;
  public String uem;
  public String uen;
  public String ueo;
  public String uep;
  public String ueq;
  public String uer;
  public String ues;
  public String uet;
  public Addr ueu;
  public String uev;
  public int uew;
  
  public f()
  {
    this.uew = -1;
  }
  
  public f(ccb paramccb, String paramString)
  {
    AppMethodBeat.i(56098);
    this.uew = -1;
    this.mName = paramccb.Name;
    this.uek = paramccb.Fqw;
    this.bNr = paramccb.Ecf;
    this.bNq = paramccb.Ecg;
    this.uel = paramccb.Fqx;
    this.uem = paramccb.vkB;
    this.uen = paramccb.Fqy;
    this.ueo = paramccb.iJU;
    this.uep = paramccb.iJV;
    this.ueq = paramccb.Euh;
    this.uer = paramccb.Eui;
    this.ues = paramccb.Fqz;
    this.uev = paramString;
    this.ueu = new Addr();
    this.ueu.hEt = this.uek;
    this.ueu.hEv = this.uep;
    this.ueu.hEw = this.uep;
    this.ueu.hEx = this.ueq;
    this.ueu.hEz = this.ues;
    this.ueu.hEC = this.mName;
    this.ueu.hEu = this.ueo;
    this.ueu.hEF = ((float)paramccb.Ecf);
    this.ueu.hEE = ((float)paramccb.Ecg);
    this.type = 0;
    AppMethodBeat.o(56098);
  }
  
  public final boolean c(Addr paramAddr)
  {
    AppMethodBeat.i(56099);
    this.ueu = paramAddr;
    if (!bs.isNullOrNil(paramAddr.hEt)) {
      this.mName = paramAddr.hEt;
    }
    if (!bs.isNullOrNil(paramAddr.hEx)) {
      this.uek = paramAddr.hEx;
    }
    if (!bs.isNullOrNil(paramAddr.hEy)) {
      this.uek += paramAddr.hEy;
    }
    if (!bs.isNullOrNil(paramAddr.hEz)) {
      this.uek += paramAddr.hEz;
    }
    if (!bs.isNullOrNil(paramAddr.hEA)) {
      this.uek += paramAddr.hEA;
    }
    this.bNq = paramAddr.hEE;
    this.bNr = paramAddr.hEF;
    this.ueo = paramAddr.hEu;
    this.uep = paramAddr.hEv;
    this.ueq = paramAddr.hEx;
    this.uer = paramAddr.hEz;
    this.uet = paramAddr.hEB;
    this.ues = paramAddr.hEA;
    this.dlj = paramAddr.hED;
    if ((bs.isNullOrNil(this.mName)) && (bs.isNullOrNil(this.uek)))
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