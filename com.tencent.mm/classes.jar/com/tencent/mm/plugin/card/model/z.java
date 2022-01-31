package com.tencent.mm.plugin.card.model;

import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.adg;
import com.tencent.mm.protocal.c.adh;
import com.tencent.mm.sdk.platformtools.y;

public final class z
  extends m
  implements k
{
  private final b dmK;
  private f dmL;
  public CardGiftInfo inq;
  
  public z(int paramInt, String paramString)
  {
    Object localObject = new b.a();
    ((b.a)localObject).ecH = new adg();
    ((b.a)localObject).ecI = new adh();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/getcardgiftinfo";
    ((b.a)localObject).ecG = 1165;
    ((b.a)localObject).ecJ = 0;
    ((b.a)localObject).ecK = 0;
    this.dmK = ((b.a)localObject).Kt();
    localObject = (adg)this.dmK.ecE.ecN;
    ((adg)localObject).sth = paramInt;
    ((adg)localObject).sti = paramString;
  }
  
  public final int a(e parame, f paramf)
  {
    this.dmL = paramf;
    return a(parame, this.dmK, this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    y.i("MicroMsg.NetSceneGetCardGiftInfo", "onGYNetEnd, errType = %d, errCode = %d ,errMsg:%s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      this.inq = CardGiftInfo.a((adh)this.dmK.ecF.ecN);
      y.d("MicroMsg.NetSceneGetCardGiftInfo", "%s", new Object[] { this.inq.toString() });
    }
    this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
  }
  
  public final int getType()
  {
    return 1165;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.card.model.z
 * JD-Core Version:    0.7.0.1
 */