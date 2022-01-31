package com.tencent.mm.plugin.label.b;

import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.atc;
import com.tencent.mm.protocal.c.bzu;
import com.tencent.mm.protocal.c.bzv;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

public final class e
  extends m
  implements k
{
  private final b dmK;
  private f dmL;
  private atc lAP = null;
  
  public e(int paramInt, String paramString)
  {
    b.a locala = new b.a();
    locala.ecH = new bzu();
    locala.ecI = new bzv();
    locala.uri = "/cgi-bin/micromsg-bin/updatecontactlabel";
    locala.ecG = 637;
    locala.ecJ = 0;
    locala.ecK = 0;
    this.dmK = locala.Kt();
    if ((paramInt >= 0) && (!bk.bl(paramString)))
    {
      this.lAP = new atc();
      this.lAP.toI = paramInt;
      this.lAP.toH = paramString;
    }
  }
  
  public final int a(com.tencent.mm.network.e parame, f paramf)
  {
    this.dmL = paramf;
    bzu localbzu = (bzu)this.dmK.ecE.ecN;
    if (this.lAP != null)
    {
      localbzu.tPA = this.lAP;
      return a(parame, this.dmK, this);
    }
    y.e("MicroMsg.Label.NetSceneUpdateContactLabel", "cpan[doScene] label pair is null.");
    paramf.onSceneEnd(3, -1, "[doScene]empty label pair.", this);
    return 0;
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    y.d("MicroMsg.Label.NetSceneUpdateContactLabel", "cpan[onGYNetEnd] netId:%d errType:%d errCode:%d errMsg:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
  }
  
  public final int getType()
  {
    return 637;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.label.b.e
 * JD-Core Version:    0.7.0.1
 */