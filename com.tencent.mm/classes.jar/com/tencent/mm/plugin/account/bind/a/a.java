package com.tencent.mm.plugin.account.bind.a;

import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.hy;
import com.tencent.mm.protocal.c.hz;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.z;

public final class a
  extends m
  implements k
{
  private final b dmK;
  private f dmL;
  
  public a(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7)
  {
    Object localObject = new b.a();
    ((b.a)localObject).ecH = new hy();
    ((b.a)localObject).ecI = new hz();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/bindlinkedincontact";
    ((b.a)localObject).ecG = 549;
    ((b.a)localObject).ecJ = 0;
    ((b.a)localObject).ecK = 0;
    this.dmK = ((b.a)localObject).Kt();
    localObject = (hy)this.dmK.ecE.ecN;
    ((hy)localObject).syV = 1;
    ((hy)localObject).sBe = paramInt;
    ((hy)localObject).sBf = paramString1;
    ((hy)localObject).sBg = paramString2;
    ((hy)localObject).sBh = paramString3;
    ((hy)localObject).sBi = paramString4;
    ((hy)localObject).sBj = paramString5;
    ((hy)localObject).sBk = paramString6;
    ((hy)localObject).sBl = paramString7;
  }
  
  public final int a(com.tencent.mm.network.e parame, f paramf)
  {
    this.dmL = paramf;
    return a(parame, this.dmK, this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    y.d("MicroMsg.NetSceneBindLinkedinContact", "onGYNetEnd errType:" + paramInt2 + " errCode:" + paramInt3);
    paramq = (hy)this.dmK.ecE.ecN;
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      g.DP().Dz().o(286722, paramq.sBg);
      g.DP().Dz().o(286721, paramq.sBf);
      g.DP().Dz().o(286723, paramq.sBh);
    }
    this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
  }
  
  public final int getType()
  {
    return 549;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.account.bind.a.a
 * JD-Core Version:    0.7.0.1
 */