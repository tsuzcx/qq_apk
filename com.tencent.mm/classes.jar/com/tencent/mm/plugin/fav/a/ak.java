package com.tencent.mm.plugin.fav.a;

import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.afv;
import com.tencent.mm.protocal.c.afw;
import com.tencent.mm.sdk.platformtools.y;

public final class ak
  extends m
  implements k
{
  private final com.tencent.mm.ah.b dmK;
  private f dmL = null;
  
  public ak()
  {
    b.a locala = new b.a();
    locala.ecH = new afv();
    locala.ecI = new afw();
    locala.uri = "/cgi-bin/micromsg-bin/getfavinfo";
    locala.ecG = 438;
    locala.ecJ = 217;
    locala.ecK = 1000000217;
    this.dmK = locala.Kt();
  }
  
  public final int a(e parame, f paramf)
  {
    this.dmL = paramf;
    return a(parame, this.dmK, this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    y.d("MicroMsg.NetSceneGetFavInfo", "netId : " + paramInt1 + " errType :" + paramInt2 + " errCode: " + paramInt3 + " errMsg :" + paramString);
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      paramq = (afw)((com.tencent.mm.ah.b)paramq).ecF.ecN;
      y.v("MicroMsg.NetSceneGetFavInfo", "used:%d  total:%d  mxDown:%d  mxUp:%d  mxFile:%d", new Object[] { Long.valueOf(paramq.svD), Long.valueOf(paramq.hQp), Integer.valueOf(paramq.tdK), Integer.valueOf(paramq.tdJ), Integer.valueOf(paramq.tdI) });
      b.en(paramq.svD);
      b.eo(paramq.hQp);
      b.eq(paramq.tdK);
      b.er(paramq.tdJ);
      b.es(paramq.tdI);
    }
    this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
  }
  
  public final int getType()
  {
    return 438;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.a.ak
 * JD-Core Version:    0.7.0.1
 */