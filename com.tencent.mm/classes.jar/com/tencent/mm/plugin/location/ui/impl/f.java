package com.tencent.mm.plugin.location.ui.impl;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelgeo.Addr;
import com.tencent.mm.protocal.protobuf.dzn;
import com.tencent.mm.sdk.platformtools.Util;

public class f
{
  public double HHN;
  public double HHO;
  public String KjA;
  public Addr KjB;
  public String KjC;
  public int KjD;
  public String Kjq;
  public String Kjr;
  public String Kjs;
  public String Kjt;
  public String Kju;
  public String Kjv;
  public String Kjw;
  public String Kjx;
  public String Kjy;
  public String Kjz;
  public String hOG;
  public String mName;
  public int type;
  
  public f()
  {
    this.KjD = -1;
  }
  
  public f(dzn paramdzn, String paramString)
  {
    AppMethodBeat.i(56098);
    this.KjD = -1;
    this.mName = paramdzn.IGU;
    this.Kjq = paramdzn.abeG;
    this.HHN = paramdzn.YTc;
    this.HHO = paramdzn.YTd;
    this.Kjr = paramdzn.abeH;
    this.Kjs = paramdzn.MpP;
    this.Kjt = paramdzn.abeI;
    this.Kju = paramdzn.pSg;
    this.Kjv = paramdzn.pSh;
    this.Kjw = paramdzn.Zqh;
    this.Kjy = paramdzn.Zqi;
    this.Kjz = paramdzn.abeJ;
    this.KjC = paramString;
    this.KjB = new Addr();
    this.KjB.oDI = this.Kjq;
    this.KjB.oDK = this.Kjv;
    this.KjB.oDL = this.Kjv;
    this.KjB.oDM = this.Kjw;
    this.KjB.oDO = this.Kjz;
    this.KjB.oDS = this.mName;
    this.KjB.oDJ = this.Kju;
    this.KjB.oDU = ((float)paramdzn.YTc);
    this.KjB.oDT = ((float)paramdzn.YTd);
    this.type = 0;
    AppMethodBeat.o(56098);
  }
  
  public final boolean d(Addr paramAddr)
  {
    AppMethodBeat.i(56099);
    this.KjB = paramAddr;
    if (!Util.isNullOrNil(paramAddr.oDI)) {
      this.mName = paramAddr.oDI;
    }
    if (!Util.isNullOrNil(paramAddr.oDM)) {
      this.Kjq = paramAddr.oDM;
    }
    if (!Util.isNullOrNil(paramAddr.oDN)) {
      this.Kjq += paramAddr.oDN;
    }
    if (!Util.isNullOrNil(paramAddr.oDO)) {
      this.Kjq += paramAddr.oDO;
    }
    if (!Util.isNullOrNil(paramAddr.oDP)) {
      this.Kjq += paramAddr.oDP;
    }
    this.HHO = paramAddr.oDT;
    this.HHN = paramAddr.oDU;
    this.Kju = paramAddr.oDJ;
    this.Kjv = paramAddr.oDK;
    this.Kjw = paramAddr.oDM;
    this.Kjx = paramAddr.oDQ;
    this.Kjy = paramAddr.oDO;
    this.KjA = paramAddr.oDR;
    this.Kjz = paramAddr.oDP;
    this.hOG = paramAddr.request_id;
    if ((Util.isNullOrNil(this.mName)) && (Util.isNullOrNil(this.Kjq)))
    {
      AppMethodBeat.o(56099);
      return false;
    }
    AppMethodBeat.o(56099);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.location.ui.impl.f
 * JD-Core Version:    0.7.0.1
 */