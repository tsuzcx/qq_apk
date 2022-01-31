package com.tencent.mm.modelappbrand;

import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.f;
import com.tencent.mm.h.a.id;
import com.tencent.mm.h.a.id.a;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.plugin.websearch.api.s;
import com.tencent.mm.protocal.c.atp;
import com.tencent.mm.protocal.c.cil;
import com.tencent.mm.protocal.c.cim;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.z;

public final class q
  extends com.tencent.mm.plugin.websearch.api.a
  implements k
{
  private f dIJ;
  private final com.tencent.mm.ah.b dZP;
  private cim dZQ;
  private s dZR;
  
  public q(s params)
  {
    this.dZR = params;
    this.qTt = params.bVm;
    this.qTu = params.bGm;
    this.El = params.offset;
    this.fzn = params.scene;
    this.qTv = params.qTN;
    Object localObject = new b.a();
    ((b.a)localObject).ecH = new cil();
    ((b.a)localObject).ecI = new cim();
    ((b.a)localObject).uri = "/cgi-bin/mmbiz-bin/wxaapp/weappsearch";
    ((b.a)localObject).ecG = 1162;
    ((b.a)localObject).ecJ = 0;
    ((b.a)localObject).ecK = 0;
    this.dZP = ((b.a)localObject).Kt();
    localObject = (cil)this.dZP.ecE.ecN;
    atp localatp = Jx();
    ((cil)localObject).hQR = params.businessType;
    ((cil)localObject).tcJ = params.bGm;
    ((cil)localObject).sDT = params.offset;
    ((cil)localObject).sFF = params.jfE;
    ((cil)localObject).tpJ = params.qTC;
    id localid = new id();
    com.tencent.mm.sdk.b.a.udP.m(localid);
    ((cil)localObject).tpI = localid.bQn.bQo;
    if (localatp != null)
    {
      ((cil)localObject).tpK = localatp.sGJ;
      ((cil)localObject).tpL = localatp.sGK;
    }
    ((cil)localObject).tpM = b.dZL;
    ((cil)localObject).tWU = params.qTy;
    ((cil)localObject).tWV = params.qTD;
    ((cil)localObject).tWW = params.qTE;
    ((cil)localObject).tWS = b.dZM;
    ((cil)localObject).tAu = params.kwf;
    y.i("MicroMsg.NetSceneWeAppSearch", "NetSceneWeAppSearch oreh SessionID : %s, KeywordID : %s, LocationX : %s, LocationY : %s", new Object[] { ((cil)localObject).tpM, ((cil)localObject).tWS, Double.valueOf(((cil)localObject).tpK), Double.valueOf(((cil)localObject).tpL) });
  }
  
  private static atp Jx()
  {
    try
    {
      au.Hx();
      Object localObject = (String)c.Dz().get(67591, null);
      if (localObject != null)
      {
        atp localatp = new atp();
        localObject = ((String)localObject).split(",");
        localatp.sUn = Integer.valueOf(localObject[0]).intValue();
        localatp.sUq = Integer.valueOf(localObject[1]).intValue();
        localatp.sGK = (Integer.valueOf(localObject[2]).intValue() / 1000000.0F);
        localatp.sGJ = (Integer.valueOf(localObject[3]).intValue() / 1000000.0F);
        y.i("MicroMsg.NetSceneWeAppSearch", "lbs location is not null, %f, %f", new Object[] { Float.valueOf(localatp.sGK), Float.valueOf(localatp.sGJ) });
        return localatp;
      }
      y.i("MicroMsg.NetSceneWeAppSearch", "lbs location is null, lbsContent is null!");
      return null;
    }
    catch (Exception localException)
    {
      y.i("MicroMsg.NetSceneWeAppSearch", "lbs location is null, reason %s", new Object[] { localException.getMessage() });
    }
    return null;
  }
  
  public final String Jv()
  {
    if (this.dZQ != null) {
      return this.dZQ.sEb;
    }
    return "";
  }
  
  public final int Jw()
  {
    if (this.dZQ != null) {
      return this.dZQ.tpP;
    }
    return 0;
  }
  
  public final int a(e parame, f paramf)
  {
    y.i("MicroMsg.NetSceneWeAppSearch", "doScene");
    this.dIJ = paramf;
    return a(parame, this.dZP, this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.q paramq, byte[] paramArrayOfByte)
  {
    y.i("MicroMsg.NetSceneWeAppSearch", "onGYNetEnd, errType = %d, errCode = %d, errMsg = %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.dZQ = ((cim)this.dZP.ecF.ecN);
    if (this.dZQ != null) {
      y.v("MicroMsg.NetSceneWeAppSearch", "return data\n%s", new Object[] { this.dZQ.sEb });
    }
    if (this.dIJ != null) {
      this.dIJ.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
  }
  
  public final int getType()
  {
    return 1162;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.modelappbrand.q
 * JD-Core Version:    0.7.0.1
 */