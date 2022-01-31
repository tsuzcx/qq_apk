package com.tencent.mm.plugin.account.security.a;

import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.te;
import com.tencent.mm.protocal.c.tf;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.z;

public final class a
  extends m
  implements k
{
  private String bwK;
  private b dmK;
  private f dmL;
  
  public a(String paramString)
  {
    this.bwK = paramString;
    b.a locala = new b.a();
    locala.ecH = new te();
    locala.ecI = new tf();
    locala.uri = "/cgi-bin/micromsg-bin/delsafedevice";
    locala.ecG = 362;
    locala.ecJ = 0;
    locala.ecK = 0;
    this.dmK = locala.Kt();
    ((te)this.dmK.ecE.ecN).sQz = paramString;
  }
  
  public final int a(com.tencent.mm.network.e parame, f paramf)
  {
    if (bk.bl(this.bwK))
    {
      y.e("MicroMsg.NetSceneDelSafeDevice", "null device id");
      return -1;
    }
    this.dmL = paramf;
    return a(parame, this.dmK, this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    y.d("MicroMsg.NetSceneDelSafeDevice", "NetSceneDelSafeDevice, errType= " + paramInt2 + " errCode = " + paramInt3);
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      paramq = (tf)this.dmK.ecF.ecN;
      g.DP().Dz().o(64, Integer.valueOf(paramq.stS));
      y.d("MicroMsg.NetSceneDelSafeDevice", "NetSceneDelSafeDevice, get safedevice state = " + paramq.stS);
    }
    this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
  }
  
  public final int getType()
  {
    return 362;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.account.security.a.a
 * JD-Core Version:    0.7.0.1
 */