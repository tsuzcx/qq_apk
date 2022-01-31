package com.tencent.mm.plugin.label.b;

import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.ss;
import com.tencent.mm.protocal.c.st;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

public final class b
  extends m
  implements k
{
  private final com.tencent.mm.ah.b dmK;
  private f dmL;
  public String lAN = null;
  
  public b(String paramString)
  {
    b.a locala = new b.a();
    locala.ecH = new ss();
    locala.ecI = new st();
    locala.uri = "/cgi-bin/micromsg-bin/delcontactlabel";
    locala.ecG = 636;
    locala.ecJ = 0;
    locala.ecK = 0;
    this.dmK = locala.Kt();
    this.lAN = paramString;
  }
  
  public final int a(e parame, f paramf)
  {
    this.dmL = paramf;
    ss localss = (ss)this.dmK.ecE.ecN;
    localss.sQu = this.lAN;
    if ((this.lAN != null) && (!bk.bl(this.lAN)))
    {
      localss.sQu = this.lAN;
      localss.sQu = this.lAN;
      return a(parame, this.dmK, this);
    }
    y.e("MicroMsg.Label.NetSceneDelContactLabel", "cpan[doScene] label id list is null.");
    paramf.onSceneEnd(3, -1, "[doScene]empty label is list.", this);
    return 0;
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    y.d("MicroMsg.Label.NetSceneDelContactLabel", "cpan[onGYNetEnd] netId:%d errType:%d errCode:%d errMsg:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
  }
  
  public final int getType()
  {
    return 636;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.label.b.b
 * JD-Core Version:    0.7.0.1
 */