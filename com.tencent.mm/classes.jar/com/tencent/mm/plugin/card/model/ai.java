package com.tencent.mm.plugin.card.model;

import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.blb;
import com.tencent.mm.protocal.c.blc;
import com.tencent.mm.sdk.platformtools.y;

public final class ai
  extends m
  implements k
{
  private final com.tencent.mm.ah.b dmK;
  private f dmL;
  
  public ai(String paramString, byte[] paramArrayOfByte, float paramFloat1, float paramFloat2, float paramFloat3, boolean paramBoolean1, boolean paramBoolean2)
  {
    Object localObject = new b.a();
    ((b.a)localObject).ecH = new blb();
    ((b.a)localObject).ecI = new blc();
    ((b.a)localObject).uri = "/cgi-bin/card/reportlotionorbluetoothinfo";
    ((b.a)localObject).ecG = 2574;
    ((b.a)localObject).ecJ = 0;
    ((b.a)localObject).ecK = 0;
    this.dmK = ((b.a)localObject).Kt();
    localObject = (blb)this.dmK.ecE.ecN;
    ((blb)localObject).bZc = paramString;
    ((blb)localObject).tEC = com.tencent.mm.bv.b.bk(paramArrayOfByte);
    ((blb)localObject).bTc = paramFloat1;
    ((blb)localObject).bRt = paramFloat2;
    ((blb)localObject).tEB = paramFloat3;
    ((blb)localObject).tED = paramBoolean1;
    ((blb)localObject).tEE = paramBoolean2;
  }
  
  public final int a(e parame, f paramf)
  {
    this.dmL = paramf;
    return a(parame, this.dmK, this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    y.i("MicroMsg.NetSceneReportLotionOrBluetoothInfo", "onGYNetEnd, errType = " + paramInt2 + " errCode = " + paramInt3);
    this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
  }
  
  public final int getType()
  {
    return 2574;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.card.model.ai
 * JD-Core Version:    0.7.0.1
 */