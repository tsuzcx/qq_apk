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
import com.tencent.mm.protocal.c.ann;
import com.tencent.mm.protocal.c.ano;
import com.tencent.mm.sdk.platformtools.y;

public final class af
  extends m
  implements k
{
  public String bZd;
  private final b dmK;
  private f dmL;
  public int ino;
  public String inp;
  
  public af(String paramString1, String paramString2, int paramInt)
  {
    Object localObject = new b.a();
    ((b.a)localObject).ecH = new ann();
    ((b.a)localObject).ecI = new ano();
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/giftcarditem";
    ((b.a)localObject).ecG = 652;
    ((b.a)localObject).ecJ = 0;
    ((b.a)localObject).ecK = 0;
    this.dmK = ((b.a)localObject).Kt();
    localObject = (ann)this.dmK.ecE.ecN;
    ((ann)localObject).bZc = paramString1;
    ((ann)localObject).tjG = paramString2;
    ((ann)localObject).tjH = paramInt;
  }
  
  public final int a(e parame, f paramf)
  {
    this.dmL = paramf;
    return a(parame, this.dmK, this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    y.i("MicroMsg.NetSceneGiftCardItem", "onGYNetEnd, errType = " + paramInt2 + " errCode = " + paramInt3);
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      paramq = (ano)this.dmK.ecF.ecN;
      if (paramq != null)
      {
        this.bZd = paramq.bZd;
        this.inp = paramq.inp;
        this.ino = paramq.ino;
      }
    }
    for (;;)
    {
      this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
      return;
      paramq = (ano)this.dmK.ecF.ecN;
      if (paramq != null)
      {
        this.bZd = paramq.bZd;
        this.inp = paramq.inp;
        this.ino = paramq.ino;
      }
    }
  }
  
  public final int getType()
  {
    return 652;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.card.model.af
 * JD-Core Version:    0.7.0.1
 */