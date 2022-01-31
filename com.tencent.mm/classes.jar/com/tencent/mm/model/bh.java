package com.tencent.mm.model;

import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.pf;
import com.tencent.mm.protocal.c.pg;
import com.tencent.mm.sdk.platformtools.y;

public final class bh
  extends m
  implements k
{
  private final b dWV;
  public int dWW = 0;
  public int dWX = 0;
  public int dWY = 0;
  private f dmL;
  public int type = 0;
  
  public bh(int paramInt, String paramString1, String paramString2, String paramString3)
  {
    pf localpf = new pf();
    localpf.pyo = paramInt;
    localpf.sMR = paramString1;
    localpf.ljr = paramString2;
    localpf.sMS = paramString3;
    paramString1 = new b.a();
    paramString1.ecH = localpf;
    paramString1.ecI = new pg();
    paramString1.uri = "/cgi-bin/micromsg-bin/checkmobilesimtype";
    paramString1.ecG = 813;
    paramString1.ecJ = 0;
    paramString1.ecK = 0;
    this.dWV = paramString1.Kt();
    this.dWV.ccs = 1;
    y.i("MicroMsg.NetSceneGetMobileSIMType", "Check scene[%d] IP[%s] IMEI[%s] IMSI[%s]", new Object[] { Integer.valueOf(paramInt), localpf.sMR, localpf.ljr, localpf.sMS });
  }
  
  public final int a(e parame, f paramf)
  {
    this.dmL = paramf;
    return a(parame, this.dWV, this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    y.i("MicroMsg.NetSceneGetMobileSIMType", "summerdiz NetSceneGetMobileSIMType onGYNetEnd netId[%d], errType[%d], errCode[%d], errMsg[%s]", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      paramq = (pg)this.dWV.ecF.ecN;
      this.dWW = paramq.sMX;
      this.dWX = paramq.sMW;
      this.type = paramq.hQR;
      this.dWY = paramq.sMV;
      y.i("MicroMsg.NetSceneGetMobileSIMType", "CheckMobileSIMTypeResp ProductType[%d] expiredTime[%d] flag[%d]", new Object[] { Integer.valueOf(paramq.sMW), Integer.valueOf(paramq.sMV), Integer.valueOf(paramq.sMX) });
    }
    this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
  }
  
  public final int getType()
  {
    return 813;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.model.bh
 * JD-Core Version:    0.7.0.1
 */