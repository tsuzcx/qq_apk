package com.tencent.mm.plugin.account.model;

import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.bfp;
import com.tencent.mm.protocal.c.gd;
import com.tencent.mm.sdk.platformtools.y;

public final class e
  extends m
  implements k
{
  private f dmL;
  private b eWr;
  private bfp fjw;
  
  public e(int paramInt)
  {
    b.a locala = new b.a();
    locala.ecH = new bfp();
    locala.ecI = new gd();
    locala.ecG = 268;
    locala.ecJ = 0;
    locala.ecK = 0;
    locala.uri = "/cgi-bin/micromsg-bin/privacypolicychoise";
    this.eWr = locala.Kt();
    this.fjw = ((bfp)this.eWr.ecE.ecN);
    this.fjw.tAo = paramInt;
  }
  
  public final int a(com.tencent.mm.network.e parame, f paramf)
  {
    this.dmL = paramf;
    return a(parame, this.eWr, this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    y.i("MicroMsg.NetScenePrivacyPolicyChoice", "errType %d,errCode %d,errMsg %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if (this.dmL != null) {
      this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
  }
  
  public final int getType()
  {
    return 268;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.account.model.e
 * JD-Core Version:    0.7.0.1
 */