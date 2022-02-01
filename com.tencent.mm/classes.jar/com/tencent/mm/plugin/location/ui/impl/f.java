package com.tencent.mm.plugin.location.ui.impl;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelgeo.Addr;
import com.tencent.mm.protocal.protobuf.chm;
import com.tencent.mm.sdk.platformtools.bu;

public final class f
{
  public double bXD;
  public double bXE;
  public String dyb;
  public String mName;
  public int type;
  public String vta;
  public String vtb;
  public String vtc;
  public String vtd;
  public String vte;
  public String vtf;
  public String vtg;
  public String vth;
  public String vti;
  public String vtj;
  public Addr vtk;
  public String vtl;
  public int vtm;
  
  public f()
  {
    this.vtm = -1;
  }
  
  public f(chm paramchm, String paramString)
  {
    AppMethodBeat.i(56098);
    this.vtm = -1;
    this.mName = paramchm.Name;
    this.vta = paramchm.HtG;
    this.bXE = paramchm.Gax;
    this.bXD = paramchm.Gay;
    this.vtb = paramchm.HtH;
    this.vtc = paramchm.wFC;
    this.vtd = paramchm.HtI;
    this.vte = paramchm.jfW;
    this.vtf = paramchm.jfX;
    this.vtg = paramchm.Guh;
    this.vth = paramchm.Gui;
    this.vti = paramchm.HtJ;
    this.vtl = paramString;
    this.vtk = new Addr();
    this.vtk.hZQ = this.vta;
    this.vtk.hZS = this.vtf;
    this.vtk.hZT = this.vtf;
    this.vtk.hZU = this.vtg;
    this.vtk.hZW = this.vti;
    this.vtk.hZZ = this.mName;
    this.vtk.hZR = this.vte;
    this.vtk.iac = ((float)paramchm.Gax);
    this.vtk.iab = ((float)paramchm.Gay);
    this.type = 0;
    AppMethodBeat.o(56098);
  }
  
  public final boolean c(Addr paramAddr)
  {
    AppMethodBeat.i(56099);
    this.vtk = paramAddr;
    if (!bu.isNullOrNil(paramAddr.hZQ)) {
      this.mName = paramAddr.hZQ;
    }
    if (!bu.isNullOrNil(paramAddr.hZU)) {
      this.vta = paramAddr.hZU;
    }
    if (!bu.isNullOrNil(paramAddr.hZV)) {
      this.vta += paramAddr.hZV;
    }
    if (!bu.isNullOrNil(paramAddr.hZW)) {
      this.vta += paramAddr.hZW;
    }
    if (!bu.isNullOrNil(paramAddr.hZX)) {
      this.vta += paramAddr.hZX;
    }
    this.bXD = paramAddr.iab;
    this.bXE = paramAddr.iac;
    this.vte = paramAddr.hZR;
    this.vtf = paramAddr.hZS;
    this.vtg = paramAddr.hZU;
    this.vth = paramAddr.hZW;
    this.vtj = paramAddr.hZY;
    this.vti = paramAddr.hZX;
    this.dyb = paramAddr.iaa;
    if ((bu.isNullOrNil(this.mName)) && (bu.isNullOrNil(this.vta)))
    {
      AppMethodBeat.o(56099);
      return false;
    }
    AppMethodBeat.o(56099);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.location.ui.impl.f
 * JD-Core Version:    0.7.0.1
 */