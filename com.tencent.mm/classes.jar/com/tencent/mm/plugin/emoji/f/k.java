package com.tencent.mm.plugin.emoji.f;

import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.aez;
import com.tencent.mm.protocal.c.afa;
import com.tencent.mm.sdk.platformtools.y;

public final class k
  extends m
  implements com.tencent.mm.network.k
{
  private f dIJ;
  public final b dmK;
  public String iZR;
  private String iZS;
  
  public k(String paramString1, String paramString2)
  {
    b.a locala = new b.a();
    locala.ecH = new aez();
    locala.ecI = new afa();
    locala.uri = "/cgi-bin/micromsg-bin/getemotionactivity";
    locala.ecG = 368;
    locala.ecJ = 0;
    locala.ecK = 0;
    this.dmK = locala.Kt();
    this.iZR = paramString1;
    this.iZS = paramString2;
  }
  
  public final int a(e parame, f paramf)
  {
    this.dIJ = paramf;
    paramf = (aez)this.dmK.ecE.ecN;
    paramf.jnV = this.iZR;
    paramf.jnU = this.iZS;
    return a(parame, this.dmK, this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    y.i("MicroMsg.emoji.NetSceneGetEmotionActivity", "onGYNetEnd ErrType:%d, errCode:%d, errMsg", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    this.dIJ.onSceneEnd(paramInt2, paramInt3, paramString, this);
  }
  
  public final int getType()
  {
    return 368;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.f.k
 * JD-Core Version:    0.7.0.1
 */