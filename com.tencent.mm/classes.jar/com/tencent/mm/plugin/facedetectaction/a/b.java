package com.tencent.mm.plugin.facedetectaction.a;

import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.c.afr;
import com.tencent.mm.protocal.c.afs;
import com.tencent.mm.sdk.platformtools.y;

public final class b
  extends m
  implements k
{
  private com.tencent.mm.ah.b dmK;
  private f dmL;
  private afr jVJ;
  public afs jVK;
  
  public b(String paramString1, String paramString2, float paramFloat, String paramString3, String paramString4, int paramInt, String paramString5, String paramString6)
  {
    b.a locala = new b.a();
    locala.ecH = new afr();
    locala.ecI = new afs();
    locala.ecG = 2726;
    locala.uri = "/cgi-bin/mmpay-bin/getfacecheckresult";
    locala.ecJ = 0;
    locala.ecK = 0;
    this.dmK = locala.Kt();
    this.jVJ = ((afr)this.dmK.ecE.ecN);
    this.jVJ.person_id = paramString1;
    this.jVJ.tdA = paramString2;
    this.jVJ.tdD = ((int)paramFloat);
    this.jVJ.tdE = paramString3;
    this.jVJ.tdF = paramString4;
    this.jVJ.scene = paramInt;
    this.jVJ.sMC = paramString5;
    this.jVJ.iQe = paramString6;
    this.jVJ.tcE = ((com.tencent.mm.pluginsdk.wallet.b)g.r(com.tencent.mm.pluginsdk.wallet.b.class)).bkn();
    y.i("MicroMsg.NetSceneGetFaceCheckResult", "create GetFaceCheckResult, personId: %s, actionData: %s, reductionRatio: %s, videoFileid: %s, scene: %s, takeMessage: %s, packageName: %s", new Object[] { paramString1, paramString2, Float.valueOf(paramFloat), paramString3, Integer.valueOf(paramInt), paramString5, paramString6 });
  }
  
  public final int a(e parame, f paramf)
  {
    this.dmL = paramf;
    return a(parame, this.dmK, this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    y.i("MicroMsg.NetSceneGetFaceCheckResult", "onGYNetEnd, errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    paramArrayOfByte = h.nFQ;
    if (paramInt3 == 0) {}
    for (long l = 54L;; l = 55L)
    {
      paramArrayOfByte.a(917L, l, 1L, false);
      this.jVK = ((afs)((com.tencent.mm.ah.b)paramq).ecF.ecN);
      this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
      return;
    }
  }
  
  public final int getType()
  {
    return 2726;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetectaction.a.b
 * JD-Core Version:    0.7.0.1
 */