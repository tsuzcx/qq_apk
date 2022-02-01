package com.tencent.mm.plugin.location.ui.impl;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelgeo.Addr;
import com.tencent.mm.protocal.protobuf.dhe;
import com.tencent.mm.sdk.platformtools.Util;

public class f
{
  public double BVp;
  public double BVq;
  public String EqK;
  public String EqL;
  public String EqM;
  public String EqN;
  public String EqO;
  public String EqP;
  public String EqQ;
  public String EqR;
  public String EqS;
  public String EqT;
  public String EqU;
  public Addr EqV;
  public String EqW;
  public int EqX;
  public String fIY;
  public String mName;
  public int type;
  
  public f()
  {
    this.EqX = -1;
  }
  
  public f(dhe paramdhe, String paramString)
  {
    AppMethodBeat.i(56098);
    this.EqX = -1;
    this.mName = paramdhe.CMP;
    this.EqK = paramdhe.TOk;
    this.BVp = paramdhe.RVy;
    this.BVq = paramdhe.RVz;
    this.EqL = paramdhe.TOl;
    this.EqM = paramdhe.GtP;
    this.EqN = paramdhe.TOm;
    this.EqO = paramdhe.mVz;
    this.EqP = paramdhe.mVA;
    this.EqQ = paramdhe.Srf;
    this.EqS = paramdhe.Srg;
    this.EqT = paramdhe.TOn;
    this.EqW = paramString;
    this.EqV = new Addr();
    this.EqV.lLg = this.EqK;
    this.EqV.lLi = this.EqP;
    this.EqV.lLj = this.EqP;
    this.EqV.lLk = this.EqQ;
    this.EqV.lLm = this.EqT;
    this.EqV.lLq = this.mName;
    this.EqV.lLh = this.EqO;
    this.EqV.lLs = ((float)paramdhe.RVy);
    this.EqV.lLr = ((float)paramdhe.RVz);
    this.type = 0;
    AppMethodBeat.o(56098);
  }
  
  public final boolean c(Addr paramAddr)
  {
    AppMethodBeat.i(56099);
    this.EqV = paramAddr;
    if (!Util.isNullOrNil(paramAddr.lLg)) {
      this.mName = paramAddr.lLg;
    }
    if (!Util.isNullOrNil(paramAddr.lLk)) {
      this.EqK = paramAddr.lLk;
    }
    if (!Util.isNullOrNil(paramAddr.lLl)) {
      this.EqK += paramAddr.lLl;
    }
    if (!Util.isNullOrNil(paramAddr.lLm)) {
      this.EqK += paramAddr.lLm;
    }
    if (!Util.isNullOrNil(paramAddr.lLn)) {
      this.EqK += paramAddr.lLn;
    }
    this.BVq = paramAddr.lLr;
    this.BVp = paramAddr.lLs;
    this.EqO = paramAddr.lLh;
    this.EqP = paramAddr.lLi;
    this.EqQ = paramAddr.lLk;
    this.EqR = paramAddr.lLo;
    this.EqS = paramAddr.lLm;
    this.EqU = paramAddr.lLp;
    this.EqT = paramAddr.lLn;
    this.fIY = paramAddr.request_id;
    if ((Util.isNullOrNil(this.mName)) && (Util.isNullOrNil(this.EqK)))
    {
      AppMethodBeat.o(56099);
      return false;
    }
    AppMethodBeat.o(56099);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.location.ui.impl.f
 * JD-Core Version:    0.7.0.1
 */