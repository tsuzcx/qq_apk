package com.tencent.mm.plugin.facedetect.b;

import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.protocal.c.bwm;
import com.tencent.mm.protocal.c.bwn;
import com.tencent.mm.sdk.platformtools.y;

public final class q
  extends m
  implements k
{
  private b dmK;
  private f dmL;
  public boolean jNc = false;
  public boolean jNd = false;
  
  public q(int paramInt)
  {
    b.a locala = new b.a();
    locala.ecH = new bwm();
    locala.ecI = new bwn();
    locala.uri = "/cgi-bin/micromsg-bin/switchopface";
    locala.ecG = 938;
    locala.ecJ = 0;
    locala.ecK = 0;
    this.dmK = locala.Kt();
    ((bwm)this.dmK.ecE.ecN).ssq = paramInt;
  }
  
  public final int a(e parame, f paramf)
  {
    this.dmL = paramf;
    return a(parame, this.dmK, this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.q paramq, byte[] paramArrayOfByte)
  {
    paramq = (bwn)((b)paramq).ecF.ecN;
    this.jNc = paramq.tMT;
    this.jNd = paramq.tMU;
    y.i("MicroMsg.NetSceneFaceSwitchOpFace", "hy: NetSceneFaceSwitchOpFace errType: %d, errCode: %d, errMsg: %s, hasBio: %b, isOpen: %b", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString, Boolean.valueOf(this.jNc), Boolean.valueOf(this.jNd) });
    if (this.dmL != null) {
      this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
    }
  }
  
  public final int getType()
  {
    return 938;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.b.q
 * JD-Core Version:    0.7.0.1
 */