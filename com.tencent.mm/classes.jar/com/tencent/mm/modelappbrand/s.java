package com.tencent.mm.modelappbrand;

import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.cni;
import com.tencent.mm.protocal.c.cnj;
import com.tencent.mm.sdk.platformtools.y;

public final class s
  extends m
  implements k
{
  private f dIJ;
  private final b dZP;
  
  public s(String paramString)
  {
    b.a locala = new b.a();
    locala.ecH = new cni();
    locala.ecI = new cnj();
    locala.uri = "/cgi-bin/mmbiz-bin/wxausrevent/wxatmplcomplaint";
    locala.ecG = 1198;
    locala.ecJ = 0;
    locala.ecK = 0;
    this.dZP = locala.Kt();
    ((cni)this.dZP.ecE.ecN).uac = paramString;
  }
  
  public final cnj Jy()
  {
    if (this.dZP != null) {
      return (cnj)this.dZP.ecF.ecN;
    }
    return null;
  }
  
  public final int a(e parame, f paramf)
  {
    y.i("MicroMsg.NetSceneGetServiceNotifyOptions", "doScene");
    this.dIJ = paramf;
    return a(parame, this.dZP, this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    y.i("MicroMsg.NetSceneGetServiceNotifyOptions", "onGYNetEnd, errType = %d, errCode = %d, errMsg = %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if (this.dIJ != null) {
      this.dIJ.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
  }
  
  public final int getType()
  {
    return 1198;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.modelappbrand.s
 * JD-Core Version:    0.7.0.1
 */