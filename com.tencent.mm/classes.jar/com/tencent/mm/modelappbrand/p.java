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
import com.tencent.mm.protocal.c.ake;
import com.tencent.mm.protocal.c.akf;
import com.tencent.mm.sdk.platformtools.y;

public final class p
  extends m
  implements k
{
  private f dIJ;
  public final b dZP;
  
  public p(int paramInt)
  {
    b.a locala = new b.a();
    locala.ecH = new ake();
    locala.ecI = new akf();
    locala.uri = "/cgi-bin/mmbiz-bin/wxausrevent/getservicenotifyoptions";
    locala.ecG = 1145;
    locala.ecJ = 0;
    locala.ecK = 0;
    this.dZP = locala.Kt();
    ((ake)this.dZP.ecE.ecN).tgK = paramInt;
  }
  
  public final akf Ju()
  {
    return (akf)this.dZP.ecF.ecN;
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
    return 1145;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.modelappbrand.p
 * JD-Core Version:    0.7.0.1
 */