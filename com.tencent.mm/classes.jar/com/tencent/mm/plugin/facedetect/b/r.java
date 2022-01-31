package com.tencent.mm.plugin.facedetect.b;

import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.xn;
import com.tencent.mm.protocal.c.xo;
import com.tencent.mm.sdk.platformtools.y;

public final class r
  extends m
  implements k
{
  private b dmK;
  private f dmL;
  public String mFileName = "";
  
  public r(String paramString1, long paramLong, String paramString2, String paramString3, String paramString4)
  {
    b.a locala = new b.a();
    locala.ecH = new xn();
    locala.ecI = new xo();
    locala.uri = "/cgi-bin/mmbiz-bin/usrmsg/facevideobindbioid";
    locala.ecG = 1197;
    locala.ecJ = 0;
    locala.ecK = 0;
    this.dmK = locala.Kt();
    this.mFileName = paramString1;
    paramString1 = (xn)this.dmK.ecE.ecN;
    paramString1.bOL = paramString2;
    paramString1.sUf = paramLong;
    paramString1.sUg = paramString4;
    paramString1.sUl = paramString3;
  }
  
  public final int a(e parame, f paramf)
  {
    this.dmL = paramf;
    return a(parame, this.dmK, this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    y.d("MicroMsg.NetSceneFaceThirdBindVideo", "hy:  errType: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if (this.dmL != null) {
      this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
  }
  
  public final int getType()
  {
    return 1197;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.b.r
 * JD-Core Version:    0.7.0.1
 */