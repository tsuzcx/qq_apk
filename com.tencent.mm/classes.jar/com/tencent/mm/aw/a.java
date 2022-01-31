package com.tencent.mm.aw;

import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.bgo;
import com.tencent.mm.protocal.c.bgp;
import com.tencent.mm.sdk.platformtools.y;

public final class a
  extends m
  implements k
{
  private b dmK;
  private f dmL;
  boolean evb = false;
  int evc = 0;
  
  public a(int paramInt, String paramString)
  {
    Object localObject = new b.a();
    ((b.a)localObject).ecH = new bgo();
    ((b.a)localObject).ecI = new bgp();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/pushnewtips";
    ((b.a)localObject).ecG = 597;
    this.dmK = ((b.a)localObject).Kt();
    localObject = (bgo)this.dmK.ecE.ecN;
    ((bgo)localObject).tBk = paramInt;
    ((bgo)localObject).tBl = 1;
    ((bgo)localObject).sCH = paramString;
    this.evc = paramInt;
  }
  
  public final int a(e parame, f paramf)
  {
    y.d("MicroMsg.NetScenePushNewTips", "doScene");
    this.dmL = paramf;
    return a(parame, this.dmK, this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      y.e("MicroMsg.NetScenePushNewTips", "errType:" + paramInt2 + " errCode:" + paramInt3);
      this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
      return;
    }
    this.evb = ((bgp)((b)paramq).ecF.ecN).tBm;
    this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
  }
  
  public final int getType()
  {
    return 597;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.aw.a
 * JD-Core Version:    0.7.0.1
 */