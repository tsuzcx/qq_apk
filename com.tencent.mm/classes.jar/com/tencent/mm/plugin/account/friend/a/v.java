package com.tencent.mm.plugin.account.friend.a;

import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.bly;
import com.tencent.mm.protocal.c.gd;
import com.tencent.mm.protocal.c.xh;
import com.tencent.mm.protocal.c.xi;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.z;

public final class v
  extends m
  implements k
{
  private com.tencent.mm.ah.b dmK;
  private f dmL;
  public int opType;
  
  public v(int paramInt, String paramString)
  {
    this.opType = paramInt;
    Object localObject = new b.a();
    ((b.a)localObject).ecH = new xh();
    ((b.a)localObject).ecI = new xi();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/facebookauth";
    ((b.a)localObject).ecG = 183;
    ((b.a)localObject).ecJ = 0;
    ((b.a)localObject).ecK = 0;
    this.dmK = ((b.a)localObject).Kt();
    xh localxh = (xh)this.dmK.ecE.ecN;
    localObject = paramString;
    if (bk.bl(paramString)) {
      localObject = "";
    }
    localxh.sTS = ((String)localObject);
    localxh.kTS = paramInt;
  }
  
  public final int a(com.tencent.mm.network.e parame, f paramf)
  {
    this.dmL = paramf;
    return a(parame, this.dmK, this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    y.d("MicroMsg.NetSceneFaceBookAuth", "onGYNetEnd errType:" + paramInt2 + " errCode:" + paramInt3);
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      paramq = (xi)this.dmK.ecF.ecN;
      paramInt1 = paramq.tFx.sze;
      if (paramInt1 != 0)
      {
        y.e("MicroMsg.NetSceneFaceBookAuth", "baseresponse.ret = " + paramInt1);
        this.dmL.onSceneEnd(4, paramInt1, paramString, this);
        return;
      }
      y.d("MicroMsg.NetSceneFaceBookAuth", "fbuserid = " + paramq.sTU + ", fbusername = " + paramq.sTV);
      if ((this.opType == 0) || (this.opType == 1))
      {
        g.DP().Dz().o(65825, paramq.sTU);
        com.tencent.mm.ag.b.jT(paramq.sTU);
        g.DP().Dz().o(65826, paramq.sTV);
        g.DP().Dz().mC(true);
      }
    }
    this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
  }
  
  public final int getType()
  {
    return 183;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.a.v
 * JD-Core Version:    0.7.0.1
 */