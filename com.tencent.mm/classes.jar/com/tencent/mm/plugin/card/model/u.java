package com.tencent.mm.plugin.card.model;

import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.bkz;
import com.tencent.mm.protocal.c.bla;
import com.tencent.mm.sdk.platformtools.y;

public final class u
  extends m
  implements k
{
  private final b dmK;
  private f dmL;
  
  public u(float paramFloat1, float paramFloat2, String paramString1, String paramString2, int paramInt)
  {
    Object localObject = new b.a();
    ((b.a)localObject).ecH = new bkz();
    ((b.a)localObject).ecI = new bla();
    ((b.a)localObject).uri = "/cgi-bin/mmbiz-bin/card/reportlocation";
    ((b.a)localObject).ecG = 1253;
    ((b.a)localObject).ecJ = 0;
    ((b.a)localObject).ecK = 0;
    this.dmK = ((b.a)localObject).Kt();
    localObject = (bkz)this.dmK.ecE.ecN;
    ((bkz)localObject).latitude = paramFloat1;
    ((bkz)localObject).longitude = paramFloat2;
    ((bkz)localObject).bZc = paramString1;
    ((bkz)localObject).iln = paramString2;
    ((bkz)localObject).tEA = paramInt;
  }
  
  public final int a(e parame, f paramf)
  {
    this.dmL = paramf;
    return a(parame, this.dmK, this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    y.i("MicroMsg.NetSceneCardReportLocation", "onGYNetEnd, errType = " + paramInt2 + " errCode = " + paramInt3);
    this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
  }
  
  public final int getType()
  {
    return 1253;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.card.model.u
 * JD-Core Version:    0.7.0.1
 */