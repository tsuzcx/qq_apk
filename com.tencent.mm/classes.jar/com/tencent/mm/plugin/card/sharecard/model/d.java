package com.tencent.mm.plugin.card.sharecard.model;

import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.aki;
import com.tencent.mm.protocal.c.akj;
import com.tencent.mm.sdk.platformtools.y;

public final class d
  extends m
  implements k
{
  private final b dmK;
  private f dmL;
  public String inn;
  public int ino;
  public String inp;
  
  public d(String paramString1, String paramString2, String paramString3)
  {
    Object localObject = new b.a();
    ((b.a)localObject).ecH = new aki();
    ((b.a)localObject).ecI = new akj();
    ((b.a)localObject).uri = "/cgi-bin/mmbiz-bin/card/getsharecardconsumedinfo";
    ((b.a)localObject).ecG = 910;
    ((b.a)localObject).ecJ = 0;
    ((b.a)localObject).ecK = 0;
    this.dmK = ((b.a)localObject).Kt();
    localObject = (aki)this.dmK.ecE.ecN;
    ((aki)localObject).bZc = paramString1;
    ((aki)localObject).scene = 20;
    ((aki)localObject).iln = paramString2;
    ((aki)localObject).code = paramString3;
  }
  
  public final int a(e parame, f paramf)
  {
    this.dmL = paramf;
    return a(parame, this.dmK, this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    y.i("MicroMsg.NetSceneGetShareCardConsumedInfo", "onGYNetEnd, cmdType = %d, errType = %d, errCode = %d", new Object[] { Integer.valueOf(910), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      paramq = (akj)this.dmK.ecF.ecN;
      y.v("MicroMsg.NetSceneGetShareCardConsumedInfo", "json:" + paramq.inn);
      this.inn = paramq.inn;
      this.inp = paramq.inp;
    }
    this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
  }
  
  public final int getType()
  {
    return 910;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.card.sharecard.model.d
 * JD-Core Version:    0.7.0.1
 */