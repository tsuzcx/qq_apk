package com.tencent.mm.plugin.emoji.f;

import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.protocal.c.aff;
import com.tencent.mm.protocal.c.afg;
import com.tencent.mm.protocal.c.bmk;
import com.tencent.mm.sdk.platformtools.y;

public final class n
  extends m
  implements k
{
  private final b dmK;
  private f dmL;
  public byte[] iZW = null;
  private String iZX;
  
  public n(String paramString, byte[] paramArrayOfByte)
  {
    b.a locala = new b.a();
    locala.ecH = new aff();
    locala.ecI = new afg();
    locala.uri = "/cgi-bin/micromsg-bin/mmgetemotiondonorlist";
    locala.ecG = 299;
    locala.ecJ = 0;
    locala.ecK = 0;
    this.dmK = locala.Kt();
    this.iZW = paramArrayOfByte;
    this.iZX = paramString;
  }
  
  public final int a(e parame, f paramf)
  {
    this.dmL = paramf;
    paramf = (aff)this.dmK.ecE.ecN;
    if (this.iZW != null) {}
    for (paramf.swr = aa.I(this.iZW);; paramf.swr = new bmk())
    {
      paramf.syc = this.iZX;
      return a(parame, this.dmK, this);
    }
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    y.d("MicroMsg.emoji.NetSceneGetEmotionDonorList", "ErrType:" + paramInt2 + "   errCode:" + paramInt3);
    paramq = (afg)((b)paramq).ecF.ecN;
    if (paramq.sws != null) {
      this.iZW = aa.a(paramq.sws);
    }
    this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
  }
  
  public final afg aIh()
  {
    return (afg)this.dmK.ecF.ecN;
  }
  
  public final int getType()
  {
    return 299;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.f.n
 * JD-Core Version:    0.7.0.1
 */