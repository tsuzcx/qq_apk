package com.tencent.mm.plugin.location.ui.impl;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelgeo.Addr;
import com.tencent.mm.protocal.protobuf.bjs;

public final class f
{
  public double bnl;
  public double bnm;
  public String mName;
  public String ogS;
  public String ogT;
  public String ogU;
  public String ogV;
  public String ogW;
  public String ogX;
  public String ogY;
  public String ogZ;
  public String oha;
  public String ohb;
  public Addr ohc;
  public String ohd;
  public String ohe;
  public int ohf;
  public int type;
  
  public f()
  {
    this.ohf = -1;
  }
  
  public f(bjs parambjs, String paramString)
  {
    AppMethodBeat.i(113667);
    this.ohf = -1;
    this.mName = parambjs.Name;
    this.ogS = parambjs.xyb;
    this.bnm = parambjs.wyO;
    this.bnl = parambjs.wyP;
    this.ogT = parambjs.xyc;
    this.ogU = parambjs.ped;
    this.ogV = parambjs.xyd;
    this.ogW = parambjs.gwQ;
    this.ogX = parambjs.gwR;
    this.ogY = parambjs.wOC;
    this.ogZ = parambjs.wOD;
    this.oha = parambjs.xye;
    this.ohd = paramString;
    this.ohc = new Addr();
    this.ohc.fBq = this.ogS;
    this.ohc.fBs = this.ogX;
    this.ohc.fBt = this.ogX;
    this.ohc.fBu = this.ogY;
    this.ohc.fBw = this.oha;
    this.ohc.fBz = this.mName;
    this.ohc.fBr = this.ogW;
    this.ohc.fBC = ((float)parambjs.wyO);
    this.ohc.fBB = ((float)parambjs.wyP);
    this.type = 0;
    AppMethodBeat.o(113667);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.location.ui.impl.f
 * JD-Core Version:    0.7.0.1
 */