package com.tencent.mm.plugin.location.ui.impl;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelgeo.Addr;
import com.tencent.mm.protocal.protobuf.cgs;
import com.tencent.mm.sdk.platformtools.bt;

public final class f
{
  public double bXD;
  public double bXE;
  public String dwW;
  public String mName;
  public int type;
  public String vgT;
  public String vgU;
  public String vgV;
  public String vgW;
  public String vgX;
  public String vgY;
  public String vgZ;
  public String vha;
  public String vhb;
  public String vhc;
  public Addr vhd;
  public String vhe;
  public int vhf;
  
  public f()
  {
    this.vhf = -1;
  }
  
  public f(cgs paramcgs, String paramString)
  {
    AppMethodBeat.i(56098);
    this.vhf = -1;
    this.mName = paramcgs.Name;
    this.vgT = paramcgs.Hag;
    this.bXE = paramcgs.FIb;
    this.bXD = paramcgs.FIc;
    this.vgU = paramcgs.Hah;
    this.vgV = paramcgs.wpT;
    this.vgW = paramcgs.Hai;
    this.vgX = paramcgs.jdd;
    this.vgY = paramcgs.jde;
    this.vgZ = paramcgs.GbA;
    this.vha = paramcgs.GbB;
    this.vhb = paramcgs.Haj;
    this.vhe = paramString;
    this.vhd = new Addr();
    this.vhd.hWY = this.vgT;
    this.vhd.hXa = this.vgY;
    this.vhd.hXb = this.vgY;
    this.vhd.hXc = this.vgZ;
    this.vhd.hXe = this.vhb;
    this.vhd.hXh = this.mName;
    this.vhd.hWZ = this.vgX;
    this.vhd.hXk = ((float)paramcgs.FIb);
    this.vhd.hXj = ((float)paramcgs.FIc);
    this.type = 0;
    AppMethodBeat.o(56098);
  }
  
  public final boolean c(Addr paramAddr)
  {
    AppMethodBeat.i(56099);
    this.vhd = paramAddr;
    if (!bt.isNullOrNil(paramAddr.hWY)) {
      this.mName = paramAddr.hWY;
    }
    if (!bt.isNullOrNil(paramAddr.hXc)) {
      this.vgT = paramAddr.hXc;
    }
    if (!bt.isNullOrNil(paramAddr.hXd)) {
      this.vgT += paramAddr.hXd;
    }
    if (!bt.isNullOrNil(paramAddr.hXe)) {
      this.vgT += paramAddr.hXe;
    }
    if (!bt.isNullOrNil(paramAddr.hXf)) {
      this.vgT += paramAddr.hXf;
    }
    this.bXD = paramAddr.hXj;
    this.bXE = paramAddr.hXk;
    this.vgX = paramAddr.hWZ;
    this.vgY = paramAddr.hXa;
    this.vgZ = paramAddr.hXc;
    this.vha = paramAddr.hXe;
    this.vhc = paramAddr.hXg;
    this.vhb = paramAddr.hXf;
    this.dwW = paramAddr.hXi;
    if ((bt.isNullOrNil(this.mName)) && (bt.isNullOrNil(this.vgT)))
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