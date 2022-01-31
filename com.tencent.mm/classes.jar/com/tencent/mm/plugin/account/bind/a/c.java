package com.tencent.mm.plugin.account.bind.a;

import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.bzg;
import com.tencent.mm.protocal.c.bzh;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.z;

public final class c
  extends m
  implements k
{
  private final b dmK;
  private f dmL;
  
  public c()
  {
    b.a locala = new b.a();
    locala.ecH = new bzg();
    locala.ecI = new bzh();
    locala.uri = "/cgi-bin/micromsg-bin/unbindlinkedincontact";
    locala.ecG = 550;
    locala.ecJ = 0;
    locala.ecK = 0;
    this.dmK = locala.Kt();
    ((bzg)this.dmK.ecE.ecN).syV = 1;
  }
  
  public final int a(com.tencent.mm.network.e parame, f paramf)
  {
    this.dmL = paramf;
    return a(parame, this.dmK, this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    y.d("MicroMsg.NetSceneUnBindLinkedinContact", "onGYNetEnd errType:" + paramInt2 + " errCode:" + paramInt3);
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      g.DP().Dz().o(286722, "");
      g.DP().Dz().o(286721, "");
      g.DP().Dz().o(286723, "");
    }
    this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
  }
  
  public final int getType()
  {
    return 550;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.account.bind.a.c
 * JD-Core Version:    0.7.0.1
 */